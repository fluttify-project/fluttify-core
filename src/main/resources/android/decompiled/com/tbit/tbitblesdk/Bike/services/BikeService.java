package com.tbit.tbitblesdk.Bike.services;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.BikeReceivedPacketDispatcher;
import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.CommandDispatcher;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.util.BikeUtil;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.bluetooth.IBleClient;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.listener.ConnectStateChangeListener;
import com.tbit.tbitblesdk.bluetooth.request.RssiRequest;
import com.tbit.tbitblesdk.bluetooth.request.RssiResponse;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import com.tbit.tbitblesdk.protocol.callback.RssiCallback;
import com.tbit.tbitblesdk.protocol.dispatcher.PacketResponseListener;
import com.tbit.tbitblesdk.protocol.dispatcher.ReceivedPacketDispatcher;
import java.util.Iterator;
import java.util.List;

public class BikeService implements PacketResponseListener, ConnectStateChangeListener {

   private static final String TAG = "BikeService";
   private static final int SEQUENCE_ID_START = 128;
   private int sequenceId;
   private BikeState bikeState;
   private IBleClient bleClient;
   private BikeConfig bikeConfig;
   private CommandDispatcher commandDispatcher;
   private RequestDispatcher requestDispatcher;
   private ReceivedPacketDispatcher receivedPacketDispatcher;


   public BikeService(IBleClient bleClient, RequestDispatcher requestDispatcher) {
      this.bleClient = bleClient;
      this.bikeState = new BikeState();
      this.commandDispatcher = new CommandDispatcher();
      this.sequenceId = 128;
      this.requestDispatcher = requestDispatcher;
      this.receivedPacketDispatcher = new BikeReceivedPacketDispatcher(bleClient, requestDispatcher, this.bikeState);
      this.receivedPacketDispatcher.addPacketResponseListener(this);
      this.bleClient.getListenerManager().addConnectStateChangeListener(this);
   }

   public void setBikeConfig(BikeConfig bikeConfig) {
      this.bikeConfig = bikeConfig;
      this.receivedPacketDispatcher.setServiceUuid(bikeConfig.getUuid().SPS_SERVICE_UUID);
      this.receivedPacketDispatcher.setTxUuid(bikeConfig.getUuid().SPS_TX_UUID);
      this.receivedPacketDispatcher.setRxUuid(bikeConfig.getUuid().SPS_RX_UUID);
   }

   public BikeConfig getBikeConfig() {
      return this.bikeConfig;
   }

   public void addCommand(Command command) {
      command.setBleClient(this.bleClient);
      command.setRequestDispatcher(this.requestDispatcher);
      command.setReceivedPacketDispatcher(this.receivedPacketDispatcher);
      command.setBikeConfig(this.bikeConfig);
      command.setSequenceId(this.getSequenceId());
      this.commandDispatcher.addCommand(command);
   }

   public void destroy() {
      this.receivedPacketDispatcher.removePacketResponseListener(this);
      this.bleClient.getListenerManager().addConnectStateChangeListener(this);
      this.receivedPacketDispatcher.destroy();
      this.commandDispatcher.destroy();
   }

   public BikeState getBikeState() {
      return this.bikeState;
   }

   private int getSequenceId() {
      return this.sequenceId = this.sequenceId >= 255?128:++this.sequenceId;
   }

   public boolean onPacketReceived(Packet receivedPacket) {
      if(receivedPacket.getHeader().isAck()) {
         return false;
      } else {
         byte commandId = receivedPacket.getPacketValue().getCommandId();
         if(4 == commandId && PacketUtil.checkPacketValueContainKey(receivedPacket, 133)) {
            List resolvedData = receivedPacket.getPacketValue().getData();
            Iterator var4 = resolvedData.iterator();

            while(var4.hasNext()) {
               PacketValue.DataBean b = (PacketValue.DataBean)var4.next();
               int key = b.key & 255;
               Byte[] value = b.value;
               if(key == 133) {
                  this.bikeConfig.getResolver().resolveAll(this.bikeState, receivedPacket.getHeader().getProtocolVersion(), value);
                  break;
               }
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public void cancelAllCommand() {
      this.commandDispatcher.cancelAll();
   }

   public void readRssi(final ResultCallback resultCallback, final RssiCallback rssiCallback) {
      this.requestDispatcher.addRequest(new RssiRequest(new RssiResponse() {
         public void onRssi(int rssi) {
            rssiCallback.onRssiReceived(rssi);
         }
         public void onResponse(int resultCode) {
            int parsedResult = BikeUtil.parseResultCode(resultCode);
            resultCallback.onResult(parsedResult);
         }
      }));
   }

   public void onConnectionStateChange(int status, int newState) {}
}

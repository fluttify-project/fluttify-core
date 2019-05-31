package com.tbit.tbitblesdk.Bike.services;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;
import com.tbit.tbitblesdk.bluetooth.IBleClient;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.dispatcher.PacketResponseListener;
import com.tbit.tbitblesdk.protocol.dispatcher.ReceivedPacketDispatcher;
import java.util.Iterator;
import java.util.List;

public class BikeReceivedPacketDispatcher extends ReceivedPacketDispatcher {

   private BikeState bikeState;


   public BikeReceivedPacketDispatcher(IBleClient bleClient, RequestDispatcher requestDispatcher, BikeState bikeState) {
      super(bleClient, requestDispatcher);
      this.bikeState = bikeState;
   }

   protected void publishData(byte[] data) {
      BleLog.log("ReceivedDispatcherPublish", ByteUtil.bytesToHexString(data));
      Packet packet = new Packet(data);
      StateUpdateHelper.updateSysState(this.bikeState, Byte.valueOf(packet.getHeader().getSystemState()));
      if(!packet.getHeader().isAck()) {
         if(packet.getPacketValue().getCommandId() == 9 && this.getFirstKey(packet) != -107) {
            BleLog.log("ReceivedDispatcherPublish", "drop broad command");
            return;
         }

         this.getAckSender().sendACK(packet.getHeader().getSequenceId(), false);
      }

      Iterator var3 = this.getPacketResponseList().iterator();

      while(var3.hasNext()) {
         PacketResponseListener listener = (PacketResponseListener)var3.next();
         if(listener.onPacketReceived(packet)) {
            break;
         }
      }

   }

   private byte getFirstKey(Packet packet) {
      byte firstKey = 0;
      List databeans = packet.getPacketValue().getData();
      if(databeans.size() != 0) {
         firstKey = ((PacketValue.DataBean)databeans.get(0)).key;
      }

      return firstKey;
   }
}

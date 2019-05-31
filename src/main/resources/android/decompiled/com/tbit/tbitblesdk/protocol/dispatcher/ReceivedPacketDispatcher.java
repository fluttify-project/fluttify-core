package com.tbit.tbitblesdk.protocol.dispatcher;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.tbit.tbitblesdk.bluetooth.IBleClient;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.listener.ChangeCharacterListener;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import com.tbit.tbitblesdk.protocol.AckSender;
import com.tbit.tbitblesdk.protocol.CrcUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.ProtocolInfo;
import com.tbit.tbitblesdk.protocol.dispatcher.PacketResponseListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ReceivedPacketDispatcher implements ChangeCharacterListener, Callback {

   private static final String TAG = "ReceivedPacketDispatche";
   private static final int HEAD_LENGTH = 8;
   private static final Byte HEAD_FLAG = new Byte((byte)-86);
   private static final int PACKET_LENGTH_INDEX = 5;
   private static final int CRC_START_FLAG = 6;
   private static final int CRC_END_FLAG = 8;
   private IBleClient bleClient;
   private List receivedData = Collections.synchronizedList(new LinkedList());
   private List packetResponseList = new LinkedList();
   private Handler handler;
   private UUID serviceUuid;
   private UUID txUuid;
   private AckSender ackSender;


   public ReceivedPacketDispatcher(IBleClient bleClient, RequestDispatcher requestDispatcher) {
      this.bleClient = bleClient;
      this.ackSender = new AckSender(requestDispatcher);
      this.handler = new Handler(Looper.myLooper(), this);
      bleClient.getListenerManager().addChangeCharacterListener(this);
   }

   protected final List getPacketResponseList() {
      return this.packetResponseList;
   }

   public void setRxUuid(UUID rxUuid) {
      this.ackSender.setRxUuid(rxUuid);
   }

   public void setServiceUuid(UUID serviceUuid) {
      this.serviceUuid = serviceUuid;
      this.ackSender.setServiceUuid(serviceUuid);
   }

   protected final AckSender getAckSender() {
      return this.ackSender;
   }

   public void setTxUuid(UUID txUuid) {
      this.txUuid = txUuid;
   }

   public void addPacketResponseListener(PacketResponseListener packetResponseListener) {
      this.packetResponseList.add(0, packetResponseListener);
   }

   public void removePacketResponseListener(PacketResponseListener packetResponseListener) {
      this.packetResponseList.remove(packetResponseListener);
   }

   public void destroy() {
      this.packetResponseList.clear();
      this.bleClient.getListenerManager().removeChangeCharacterListener(this);
   }

   private void tryResolve() {
      if(!((Byte)this.receivedData.get(0)).equals(HEAD_FLAG)) {
         Iterator dataPacketLen = this.receivedData.iterator();

         while(dataPacketLen.hasNext() && !((Byte)dataPacketLen.next()).equals(HEAD_FLAG)) {
            dataPacketLen.remove();
         }
      }

      if(this.receivedData.size() >= 8) {
         int var6 = ((Byte)this.receivedData.get(5)).byteValue() & 255;
         if(this.receivedData.size() - 8 >= var6) {
            int totalLength = 8 + var6;
            byte[] data = new byte[totalLength];

            for(int crc = 0; crc < totalLength; ++crc) {
               data[crc] = ((Byte)this.receivedData.remove(0)).byteValue();
            }

            byte[] var7 = Arrays.copyOfRange(data, 6, 8);
            byte[] value = Arrays.copyOfRange(data, 8, data.length);
            if(!this.checkCrc(var7, value)) {
               BleLog.log("ReceivedDispatcherCheckCrc", "CheckCrc Failed");
            } else {
               this.publishData(data);
            }
         }
      }
   }

   private boolean checkCrc(byte[] crc, byte[] value) {
      try {
         short e = CrcUtil.crcTable(ProtocolInfo.packetCrcTable, value);
         byte[] calculatedCrc = ByteUtil.shortToByte(e);
         return Arrays.equals(crc, calculatedCrc);
      } catch (Exception var5) {
         BleLog.log("ReceivedDispatcherCheckCrc", "CheckCrc Exception: " + var5.getMessage());
         return false;
      }
   }

   protected void publishData(byte[] data) {
      BleLog.log("ReceivedDispatcherPublish", ByteUtil.bytesToHexString(data));
      Packet packet = new Packet(data);
      if(!packet.getHeader().isAck()) {
         if(packet.getPacketValue().getCommandId() == 9) {
            BleLog.log("ReceivedDispatcherPublish", "drop broad command");
            return;
         }

         this.ackSender.sendACK(packet.getHeader().getSequenceId(), false);
      }

      Iterator var3 = this.packetResponseList.iterator();

      while(var3.hasNext()) {
         PacketResponseListener listener = (PacketResponseListener)var3.next();
         if(listener.onPacketReceived(packet)) {
            break;
         }
      }

   }

   public void onCharacterChange(BluetoothGattCharacteristic characteristic, final byte[] value) {
      if(this.serviceUuid.equals(characteristic.getService().getUuid())) {
         if(this.txUuid.equals(characteristic.getUuid())) {
            this.handler.post(new Runnable() {
               public void run() {
                  Byte[] data = ByteUtil.byteArrayToBoxed(value);
                  ReceivedPacketDispatcher.this.receivedData.addAll(Arrays.asList(data));
                  ReceivedPacketDispatcher.this.tryResolve();
               }
            });
         }
      }
   }

   public boolean handleMessage(Message msg) {
      return true;
   }

}

package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.Iterator;
import java.util.List;

public class LockCommand extends Command {

   public LockCommand(ResultCallback resultCallback) {
      super(resultCallback);
   }

   protected void onResult(Packet resultPacket) {
      PacketValue packetValue = resultPacket.getPacketValue();
      List resolvedData = packetValue.getData();
      Iterator var4 = resolvedData.iterator();

      while(var4.hasNext()) {
         PacketValue.DataBean b = (PacketValue.DataBean)var4.next();
         int key = b.key & 255;
         Byte[] value = b.value;
         if(key == 129) {
            if(value[0].byteValue() != 0 && this.canRetry()) {
               this.retryDelayed(500);
               break;
            }

            short resultCode = -1;
            switch(value[0].byteValue()) {
            case 0:
               resultCode = 0;
               break;
            case 1:
               resultCode = -3001;
               break;
            case 2:
               resultCode = -3002;
               break;
            case 3:
               resultCode = -3003;
            }

            this.response(resultCode);
            break;
         }
      }

   }

   protected int getRetryTimes() {
      return 3;
   }

   protected int getTimeout() {
      return 15000;
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)3, (byte)1, new Byte[]{Byte.valueOf((byte)1)});
   }

   public boolean compare(Packet receivedPacket) {
      return PacketUtil.compareCommandId(receivedPacket, this.getSendPacket()) && PacketUtil.checkPacketValueContainKey(receivedPacket, 129);
   }
}

package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.Iterator;
import java.util.List;

public class UnlockCommand extends Command {

   public UnlockCommand(ResultCallback resultCallback) {
      super(resultCallback);
   }

   protected void onResult(Packet resultPacket) {
      PacketValue packetValue = resultPacket.getPacketValue();
      List resolvedData = packetValue.getData();
      short resultCode = -1;
      Iterator var5 = resolvedData.iterator();

      label23:
      while(var5.hasNext()) {
         PacketValue.DataBean b = (PacketValue.DataBean)var5.next();
         int key = b.key & 255;
         Byte[] value = b.value;
         if(key == 130) {
            switch(value[0].byteValue()) {
            case 0:
               resultCode = 0;
               break label23;
            case 1:
               resultCode = -3001;
               break label23;
            case 2:
               resultCode = -3002;
               break label23;
            case 3:
               resultCode = -3003;
            default:
               break label23;
            }
         }
      }

      this.response(resultCode);
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)3, (byte)2, new Byte[]{Byte.valueOf((byte)0)});
   }

   public boolean compare(Packet receivedPacket) {
      return PacketUtil.compareCommandId(receivedPacket, this.getSendPacket()) && PacketUtil.checkPacketValueContainKey(receivedPacket, 130);
   }
}

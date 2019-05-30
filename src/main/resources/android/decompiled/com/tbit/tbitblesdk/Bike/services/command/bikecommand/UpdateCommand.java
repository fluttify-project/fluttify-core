package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.command.bikecommand.UpdatableCommand;
import com.tbit.tbitblesdk.Bike.services.command.callback.StateCallback;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.Iterator;
import java.util.List;

public class UpdateCommand extends UpdatableCommand {

   public UpdateCommand(ResultCallback resultCallback, StateCallback stateCallback, BikeState bikeState) {
      super(resultCallback, stateCallback, bikeState);
   }

   protected void onResult(Packet resultPacket) {
      PacketValue packetValue = resultPacket.getPacketValue();
      List resolvedData = packetValue.getData();
      Iterator var4 = resolvedData.iterator();

      while(var4.hasNext()) {
         PacketValue.DataBean b = (PacketValue.DataBean)var4.next();
         int key = b.key & 255;
         Byte[] value = b.value;
         if(key == 133) {
            this.parseAll(resultPacket.getHeader().getProtocolVersion(), value);
            this.updateState();
            this.response(0);
            break;
         }
      }

   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)4, (byte)5, (Byte[])null);
   }

   public boolean compare(Packet receivedPacket) {
      return PacketUtil.compareCommandId(receivedPacket, this.getSendPacket()) && PacketUtil.checkPacketValueContainKey(receivedPacket, 133);
   }
}

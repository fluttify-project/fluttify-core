package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketHeader;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.PacketCallback;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.List;

public class CommonCommand extends Command {

   protected PacketCallback packetCallback;
   private Packet packetUnready;


   public CommonCommand(ResultCallback resultCallback, PacketCallback packetCallback, Packet packet) {
      super(resultCallback);
      this.packetCallback = packetCallback;
      this.packetUnready = packet;
   }

   protected void onResult(Packet receivedPacket) {
      if(this.packetCallback != null) {
         this.packetCallback.onPacketReceived(receivedPacket);
      }

      this.response(0);
   }

   public boolean compare(Packet receivedPacket) {
      return PacketUtil.compareCommandId(receivedPacket, this.getSendPacket());
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      this.packetUnready.getHeader().setSequenceId((byte)sequenceId);
      return this.packetUnready;
   }

   protected void onFinish() {
      super.onFinish();
      this.packetCallback = null;
   }

   public boolean onPacketReceived(Packet packet) {
      return super.onPacketReceived(this.fixBug(packet));
   }

   private Packet fixBug(Packet packet) {
      PacketValue packetValue = packet.getPacketValue();
      PacketValue sendPacketValue = this.getSendPacket().getPacketValue();
      return !packet.getHeader().isAck() && packetValue.getCommandId() == 9 && this.getFirstKey(packet) == -107 && sendPacketValue.getCommandId() == 4 && this.getFirstKey(this.getSendPacket()) == 29?new Packet(this.getFixPacketHeader(packet), this.getFixPacketValue(packet)):packet;
   }

   private PacketHeader getFixPacketHeader(Packet packet) {
      PacketHeader fixPacketHeader = new PacketHeader(packet.getHeader().getData());
      fixPacketHeader.setSequenceId(this.getSendPacket().getHeader().getSequenceId());
      return fixPacketHeader;
   }

   private PacketValue getFixPacketValue(Packet packet) {
      byte[] values = packet.getPacketValue().toArray();
      values[0] = 4;
      values[2] = -99;
      return new PacketValue(values);
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

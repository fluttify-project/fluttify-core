package com.tbit.tbitblesdk.Bike.util;

import com.tbit.tbitblesdk.protocol.CrcUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketHeader;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.ProtocolInfo;
import java.util.Iterator;

public class PacketUtil {

   public static Packet createPacket(int sequenceId, byte commandId, byte key, Byte[] data) {
      return createPacket(sequenceId, commandId, new PacketValue.DataBean[]{new PacketValue.DataBean(key, data)});
   }

   public static Packet createPacket(int sequenceId, byte commandId, PacketValue.DataBean ... dataBeans) {
      PacketValue packetValue = new PacketValue();
      packetValue.setCommandId(commandId);
      if(dataBeans != null) {
         packetValue.addData(dataBeans);
      }

      short valueLength = (short)packetValue.getSize();
      short crc16 = CrcUtil.crcTable(ProtocolInfo.packetCrcTable, packetValue.toArray());
      PacketHeader header = (new PacketHeader.HeaderBuilder()).setLength(valueLength).setSystemState((byte)0).setSequenceId((byte)sequenceId).setAck(false).setError(false).setCRC16((short)crc16).build();
      Packet newPacket = new Packet(header, packetValue);
      return newPacket;
   }

   public static Packet createAck(int sequenceId, boolean error) {
      PacketHeader packetHeader = (new PacketHeader.HeaderBuilder()).setAck(true).setError(error).setSequenceId((byte)sequenceId).setSystemState((byte)0).setLength((short)0).setCRC16((short)0).build();
      return new Packet(packetHeader);
   }

   public static Packet createAck(int sequenceId) {
      return createAck(sequenceId, false);
   }

   public static boolean compareCommandId(Packet packet1, Packet packet2) {
      byte commandId1 = packet1.getPacketValue().getCommandId();
      byte commandId2 = packet2.getPacketValue().getCommandId();
      return commandId1 == commandId2;
   }

   public static boolean checkPacketValueContainKey(Packet packet, int key) {
      boolean result = false;
      Iterator var3 = packet.getPacketValue().getData().iterator();

      while(var3.hasNext()) {
         PacketValue.DataBean b = (PacketValue.DataBean)var3.next();
         int packetKey = b.key & 255;
         if(packetKey == key) {
            result = true;
         }
      }

      return result;
   }
}

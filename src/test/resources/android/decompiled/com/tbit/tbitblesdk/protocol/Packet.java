package com.tbit.tbitblesdk.protocol;

import com.tbit.tbitblesdk.protocol.PacketHeader;
import com.tbit.tbitblesdk.protocol.PacketValue;

import java.util.Arrays;

public class Packet {

   private PacketHeader header;
   private PacketValue packetValue;


   public Packet(PacketHeader header, PacketValue packetValue) {
      this.packetValue = packetValue;
      this.header = header;
   }

   public Packet(byte[] raw) {
      this.header = new PacketHeader(Arrays.copyOfRange(raw, 0, 8));
      this.packetValue = new PacketValue(Arrays.copyOfRange(raw, 8, raw.length));
   }

   public Packet(PacketHeader header) {
      this.header = header;
   }

   public PacketHeader getHeader() {
      return this.header;
   }

   public PacketValue getPacketValue() {
      return this.packetValue;
   }

   public byte[] toByteArray() {
      if(this.packetValue != null && this.packetValue.getSize() != 0) {
         byte[] headData = this.header.getData();
         byte[] valueData = this.packetValue.toArray();
         byte[] result = new byte[headData.length + valueData.length];
         System.arraycopy(headData, 0, result, 0, headData.length);
         System.arraycopy(valueData, 0, result, headData.length, valueData.length);
         return result;
      } else {
         return this.header.getData();
      }
   }

   public String toString() {
      return "Packet{header=" + this.header.toString() + ", value=" + this.packetValue.toString() + '}';
   }
}

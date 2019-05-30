package com.tbit.tbitblesdk.protocol;

import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;

public class PacketHeader {

   private byte[] header = new byte[]{(byte)-86, (byte)2, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};


   public PacketHeader() {}

   public PacketHeader(byte[] header) {
      this.header = header;
   }

   public byte getSystemState() {
      return this.header[2];
   }

   public void setSystemState(byte systemState) {
      this.header[2] = systemState;
   }

   public short getLength() {
      int value = this.header[4] & 255;
      value <<= 8;
      value |= this.header[5] & 255;
      return (short)value;
   }

   public void setLength(short length) {
      byte[] len = ByteUtil.shortToByte(length);
      this.header[4] = len[0];
      this.header[5] = len[1];
   }

   public short getCRC16() {
      int value = this.header[6] & 255;
      value <<= 8;
      value |= this.header[7] & 255;
      return (short)value;
   }

   public void setCRC16(short crc16) {
      byte[] crc = ByteUtil.shortToByte(crc16);
      this.header[6] = crc[0];
      this.header[7] = crc[1];
   }

   public byte getSequenceId() {
      return this.header[3];
   }

   public void setSequenceId(byte sequenceId) {
      this.header[3] = sequenceId;
   }

   public boolean isAck() {
      return (this.header[1] & 16) == 16;
   }

   public void setACK(boolean ack) {
      byte sta = this.header[1];
      if(ack) {
         sta = (byte)(sta | 16);
      } else {
         sta &= -17;
      }

      this.header[1] = sta;
   }

   public boolean isError() {
      return (this.header[1] & 32) == 32;
   }

   public void setError(boolean err) {
      byte sta = this.header[1];
      if(err) {
         sta = (byte)(sta | 32);
      } else {
         sta &= -33;
      }

      this.header[1] = sta;
   }

   public byte getProtocolVersion() {
      return (byte)(this.header[1] & 15);
   }

   public byte[] getData() {
      return this.header;
   }

   public String toString() {
      return ByteUtil.bytesToHexString(this.header);
   }

   public static class HeaderBuilder {

      private PacketHeader header = new PacketHeader();


      public PacketHeader.HeaderBuilder setSystemState(byte systemState) {
         this.header.setSystemState(systemState);
         return this;
      }

      public PacketHeader.HeaderBuilder setAck(boolean isAck) {
         this.header.setACK(isAck);
         return this;
      }

      public PacketHeader.HeaderBuilder setCRC16(short crc16) {
         this.header.setCRC16(crc16);
         return this;
      }

      public PacketHeader.HeaderBuilder setError(boolean err) {
         this.header.setError(err);
         return this;
      }

      public PacketHeader.HeaderBuilder setLength(short length) {
         this.header.setLength(length);
         return this;
      }

      public PacketHeader.HeaderBuilder setSequenceId(byte sequenceId) {
         this.header.setSequenceId(sequenceId);
         return this;
      }

      public PacketHeader build() {
         return this.header;
      }
   }
}

package com.tbit.tbitblesdk.protocol;

import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacketValue implements Cloneable {

   List aPacketValue = new LinkedList();
   List mData = new LinkedList();
   private final String TAG = "PacketValue";


   public PacketValue() {}

   public int getSize() {
      return this.aPacketValue.size();
   }

   public PacketValue(byte[] data) {
      this.aPacketValue.addAll(Arrays.asList(ByteUtil.byteArrayToBoxed(data)));
      this.initData();
   }

   private void initData() {
      if(this.aPacketValue.size() >= 5) {
         int cursor = 2;
         int size = this.aPacketValue.size();

         try {
            while(cursor < size) {
               byte e = ((Byte)this.aPacketValue.get(cursor)).byteValue();
               ++cursor;
               byte length = ((Byte)this.aPacketValue.get(cursor)).byteValue();
               ++cursor;
               Byte[] value = (Byte[])this.aPacketValue.subList(cursor, cursor + length).toArray(new Byte[length]);
               PacketValue.DataBean d = new PacketValue.DataBean(e, value);
               this.mData.add(d);
               cursor += length;
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }

      }
   }

   public byte getCommandId() {
      return this.aPacketValue.size() == 0?0:((Byte)this.aPacketValue.get(0)).byteValue();
   }

   public void setCommandId(byte commandId) {
      this.aPacketValue.add(Byte.valueOf(commandId));
      this.aPacketValue.add(Byte.valueOf((byte)0));
   }

   public void addData(PacketValue.DataBean d) {
      this.mData.add(d);
      this.aPacketValue.add(Byte.valueOf(d.key));
      if(d.value != null) {
         this.aPacketValue.add(Byte.valueOf((byte)d.value.length));
         Byte[] var2 = d.value;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4].byteValue();
            this.aPacketValue.add(Byte.valueOf(b));
         }
      } else {
         this.aPacketValue.add(Byte.valueOf((byte)0));
      }

   }

   public void addData(PacketValue.DataBean ... dataBeens) {
      PacketValue.DataBean[] var2 = dataBeens;
      int var3 = dataBeens.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         PacketValue.DataBean bean = var2[var4];
         this.addData(bean);
      }

   }

   public List getData() {
      return this.mData;
   }

   public List toList() {
      return this.aPacketValue;
   }

   public byte[] toArray() {
      Byte[] value = new Byte[this.aPacketValue.size()];
      this.aPacketValue.toArray(value);
      return ByteUtil.byteArrayToUnBoxed(value);
   }

   public String toString() {
      return ByteUtil.bytesToHexString(this.toArray());
   }

   public Object clone() throws CloneNotSupportedException {
      return super.clone();
   }

   public static class DataBean {

      public byte key;
      public Byte[] value;


      public DataBean(byte key, Byte[] value) {
         this.key = key;
         this.value = value;
      }
   }
}

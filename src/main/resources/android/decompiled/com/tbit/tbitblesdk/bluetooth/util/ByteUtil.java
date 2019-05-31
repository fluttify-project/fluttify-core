package com.tbit.tbitblesdk.bluetooth.util;

import java.util.ArrayList;
import java.util.Arrays;

public class ByteUtil {

   public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
      if(byte_1 == null) {
         return byte_2;
      } else {
         byte[] byte_3 = new byte[byte_1.length + byte_2.length];
         System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
         System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
         return byte_3;
      }
   }

   public static byte[] subBytes(byte[] src, int begin, int count) {
      byte[] bs = new byte[count];

      for(int i = begin; i < begin + count; ++i) {
         bs[i - begin] = src[i];
      }

      return bs;
   }

   public static byte[] byteArrayUnBox(Byte[] ByteArray) {
      byte[] byteArray = new byte[ByteArray.length];
      int i = 0;
      Byte[] var3 = ByteArray;
      int var4 = ByteArray.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Byte B = var3[var5];
         byteArray[i++] = B.byteValue();
      }

      return byteArray;
   }

   public static byte[] byteToByte(byte value) {
      byte[] abyte = new byte[]{(byte)((255 & value) >> 0)};
      return abyte;
   }

   public static byte[] shortToByte(short value) {
      byte[] abyte = new byte[]{(byte)(('\uff00' & value) >> 8), (byte)((255 & value) >> 0)};
      return abyte;
   }

   public static byte[] intToByte(int value) {
      byte[] abyte = new byte[]{(byte)((-16777216 & value) >> 24), (byte)((16711680 & value) >> 16), (byte)(('\uff00' & value) >> 8), (byte)((255 & value) >> 0)};
      return abyte;
   }

   public static int bytesToInt(byte[] src) {
      int value = (src[0] & 255) << 24 | (src[1] & 255) << 16 | (src[2] & 255) << 8 | src[3] & 255;
      return value;
   }

   public static byte[] longToByte(long value) {
      byte[] abyte = new byte[]{(byte)((int)((-72057594037927936L & value) >> 56)), (byte)((int)((71776119061217280L & value) >> 48)), (byte)((int)((280375465082880L & value) >> 40)), (byte)((int)((1095216660480L & value) >> 32)), (byte)((int)((4278190080L & value) >> 24)), (byte)((int)((16711680L & value) >> 16)), (byte)((int)((65280L & value) >> 8)), (byte)((int)((255L & value) >> 0))};
      return abyte;
   }

   public static Byte[] stringToBytes(String str) {
      String[] ss = str.split(" ");
      ArrayList list = new ArrayList();
      String[] byteArray = ss;
      int var4 = ss.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String s1 = byteArray[var5];
         list.add(Byte.valueOf((byte)Integer.parseInt(s1, 16)));
      }

      Byte[] var7 = (Byte[])list.toArray(new Byte[0]);
      return var7;
   }

   public static byte[] byteArrayToUnBoxed(Byte[] oBytes) {
      byte[] bytes = new byte[oBytes.length];

      for(int i = 0; i < oBytes.length; ++i) {
         bytes[i] = oBytes[i].byteValue();
      }

      return bytes;
   }

   public static Byte[] byteArrayToBoxed(byte[] bytesPrim) {
      Byte[] bytes = new Byte[bytesPrim.length];
      int i = 0;
      byte[] var3 = bytesPrim;
      int var4 = bytesPrim.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte b = var3[var5];
         bytes[i++] = Byte.valueOf(b);
      }

      return bytes;
   }

   public static final byte[] adv_report_parse(short type, byte[] adv_data) {
      int index = 0;
      boolean field_type = false;
      boolean field_length = false;
      int length = adv_data.length;

      while(index < length) {
         byte var9;
         byte var10;
         try {
            var10 = adv_data[index];
            var9 = adv_data[index + 1];
         } catch (Exception var8) {
            return null;
         }

         if(var9 == (byte)type) {
            byte[] data = new byte[var10 - 1];

            for(byte i = 0; i < var10 - 1; ++i) {
               data[i] = adv_data[index + 2 + i];
            }

            return data;
         }

         index += var10 + 1;
         if(index >= adv_data.length) {
            return null;
         }
      }

      return null;
   }

   public static String bytesToHexStringWithoutSpace(byte[] bytes) {
      if(bytes == null) {
         return "";
      } else {
         StringBuilder builder = new StringBuilder();
         byte[] var2 = bytes;
         int var3 = bytes.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            builder.append(String.format("%02X", new Object[]{Byte.valueOf(b)}));
         }

         return builder.toString();
      }
   }

   public static String bytesToHexString(byte[] bytes) {
      if(bytes == null) {
         return "";
      } else {
         StringBuilder builder = new StringBuilder();
         byte[] var2 = bytes;
         int var3 = bytes.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            byte b = var2[var4];
            builder.append(String.format("%02X ", new Object[]{Byte.valueOf(b)}));
         }

         return builder.toString();
      }
   }

   public static String bytesToHexString(Byte[] bytes) {
      byte[] array = new byte[bytes.length];

      for(int i = 0; i < bytes.length; ++i) {
         array[i] = bytes[i].byteValue();
      }

      return bytesToHexString(array);
   }

   public static double[] getPoint(Byte[] data) {
      double[] result = new double[]{0.0D, 0.0D};
      if(data == null) {
         return result;
      } else {
         byte[] converted = new byte[data.length];
         int length = data.length;

         for(int e = 0; e < length; ++e) {
            converted[e] = data[e].byteValue();
         }

         try {
            result[0] = (double)ParseUInt32(Arrays.copyOfRange(converted, 4, 8)) / 1800000.0D;
            result[1] = (double)ParseUInt32(Arrays.copyOfRange(converted, 0, 4)) / 1800000.0D;
         } catch (Exception var5) {
            var5.printStackTrace();
         }

         return result;
      }
   }

   public static long ParseUInt32(byte[] data) {
      byte i = 0;
      long l = 0L;
      int var4 = i + 1;
      l |= (long)((data[i] & 255) << 24);
      l |= (long)((data[var4++] & 255) << 16);
      l |= (long)((data[var4++] & 255) << 8);
      l |= (long)(data[var4++] & 255);
      return l;
   }
}

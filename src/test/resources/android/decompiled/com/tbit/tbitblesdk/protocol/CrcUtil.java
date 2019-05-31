package com.tbit.tbitblesdk.protocol;


public class CrcUtil {

   public static short crcTable(int[] table, byte[] bytes) {
      int mCrc = '\uffff';
      byte[] var3 = bytes;
      int var4 = bytes.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         byte b = var3[var5];
         mCrc = mCrc >>> 8 ^ table[(mCrc ^ b) & 255];
      }

      return (short)(~mCrc & '\uffff');
   }
}

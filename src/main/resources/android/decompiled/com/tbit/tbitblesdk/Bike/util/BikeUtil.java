package com.tbit.tbitblesdk.Bike.util;

import android.text.TextUtils;
import com.tbit.tbitblesdk.Bike.model.ManufacturerAd;
import com.tbit.tbitblesdk.Bike.model.ParsedAd;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import java.io.File;

public class BikeUtil {

   private static final int MAX_ENCRYPT_COUNT = 95;
   private static char[] szKey = new char[]{'5', 'A', '2', 'B', '3', 'C', '6', 'D', '9', 'E', '8', 'F', '7', '4', '1', '0'};


   public static String encryptStr(String in_str) {
      boolean count = false;
      StringBuilder builder = new StringBuilder();
      if(in_str != null && in_str.length() != 0) {
         int var4 = in_str.length();
         if(var4 > 95) {
            return null;
         } else {
            for(int i = 0; i < var4; ++i) {
               builder.append(szKey[in_str.charAt(i) - 42]);
            }

            return builder.toString();
         }
      } else {
         return null;
      }
   }

   public static String decryptStr(String in_str) {
      StringBuilder builder = new StringBuilder();
      boolean count = false;
      boolean j = false;
      if(in_str != null && in_str.length() != 0) {
         int var5 = in_str.length();
         if(var5 > 95) {
            return null;
         } else {
            for(int i = 0; i < var5; ++i) {
               int var6;
               for(var6 = 0; var6 < 95 && in_str.charAt(i) != szKey[var6]; ++var6) {
                  ;
               }

               builder.append((char)(42 + var6));
            }

            return builder.toString();
         }
      } else {
         return null;
      }
   }

   public static double calcDistByRSSI(int rssi) {
      int iRssi = Math.abs(rssi);
      double power = (double)(iRssi - 59) / 20.0D;
      return Math.pow(10.0D, power);
   }

   public static String resolveMachineIdByAdData(byte[] data) {
      try {
         ParsedAd e = ParsedAd.parseData(data);
         byte[] manufacturerData = e.getManufacturer();
         ManufacturerAd manufacturerAd = ManufacturerAd.resolveManufacturerAd(manufacturerData);
         String encryptedId = manufacturerAd.getMachineId();
         return decryptStr(encryptedId);
      } catch (Exception var5) {
         return "";
      }
   }

   public static Byte[] resolveKey(String keyStr, int length) {
      if(TextUtils.isEmpty(keyStr)) {
         return null;
      } else {
         length *= 2;
         Byte[] result = new Byte[0];
         keyStr = keyStr.replace(" ", "");
         if(keyStr.length() != length) {
            return result;
         } else {
            StringBuilder sb = new StringBuilder();

            for(int e = 0; e < length; e += 2) {
               sb.append(keyStr.substring(e, e + 2));
               if(e != length - 2) {
                  sb.append(" ");
               }
            }

            try {
               result = ByteUtil.stringToBytes(sb.toString());
            } catch (Exception var5) {
               var5.printStackTrace();
            }

            return result;
         }
      }
   }

   public static boolean isOtaFileLegal(File file) {
      if(file == null) {
         return false;
      } else if(!file.exists()) {
         return false;
      } else {
         String filename = file.getName();
         if(TextUtils.isEmpty(filename)) {
            return false;
         } else {
            int dot = filename.lastIndexOf(46);
            if(dot > -1 && dot < filename.length() - 1) {
               String extName = filename.substring(dot + 1);
               return TextUtils.equals(extName, "img");
            } else {
               return false;
            }
         }
      }
   }

   public static int parseResultCode(int bleCode) {
      short parsedResultCode;
      switch(bleCode) {
      case -6:
         parsedResultCode = -1004;
         break;
      case -5:
         parsedResultCode = -1001;
         break;
      case -4:
         parsedResultCode = -1002;
         break;
      case -3:
         parsedResultCode = -2;
         break;
      case -2:
      case -1:
      default:
         parsedResultCode = -1;
         break;
      case 0:
         parsedResultCode = 0;
      }

      return parsedResultCode;
   }

}

package com.tbit.tbitblesdk.bluetooth.debug;

import com.tbit.tbitblesdk.bluetooth.debug.LogCallback;

public class BleLog {

   private static LogCallback logCallback;


   public static void setLogCallback(LogCallback logCallback) {
      logCallback = logCallback;
   }

   public static void log(String key, String value) {
      if(logCallback != null) {
         logCallback.onLogReceived(key + "\n" + value);
      }

   }
}

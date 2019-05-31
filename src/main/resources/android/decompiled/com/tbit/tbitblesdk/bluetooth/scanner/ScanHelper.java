package com.tbit.tbitblesdk.bluetooth.scanner;

import android.os.Build.VERSION;
import com.tbit.tbitblesdk.bluetooth.scanner.AndroidLScanner;
import com.tbit.tbitblesdk.bluetooth.scanner.BelowAndroidLScanner;
import com.tbit.tbitblesdk.bluetooth.scanner.Scanner;

public class ScanHelper {

   public static Scanner getScanner() {
      Object scanner;
      if(VERSION.SDK_INT >= 21) {
         scanner = new AndroidLScanner();
      } else {
         scanner = new BelowAndroidLScanner();
      }

      return (Scanner)scanner;
   }
}

package com.tbit.tbitblesdk.bluetooth.scanner.decorator;

import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;

public abstract class BaseCallback implements ScannerCallback {

   protected ScannerCallback callback;


   public BaseCallback(ScannerCallback callback) {
      this.callback = callback;
   }
}

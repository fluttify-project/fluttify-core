package com.tbit.tbitblesdk.bluetooth.scanner;

import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.FilterNameCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.LogCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.NoneRepeatCallback;

public class ScanBuilder {

   private ScannerCallback callback;


   public ScanBuilder(ScannerCallback callback) {
      this.callback = callback;
   }

   public ScanBuilder setLogMode(boolean isLog) {
      if(isLog) {
         this.callback = new LogCallback(this.callback);
      }

      return this;
   }

   public ScanBuilder setRepeatable(boolean isRepeatable) {
      if(!isRepeatable) {
         this.callback = new NoneRepeatCallback(this.callback);
      }

      return this;
   }

   public ScanBuilder setFilter(String filterStr) {
      this.callback = new FilterNameCallback(filterStr, this.callback);
      return this;
   }

   public ScannerCallback build() {
      return this.callback;
   }
}

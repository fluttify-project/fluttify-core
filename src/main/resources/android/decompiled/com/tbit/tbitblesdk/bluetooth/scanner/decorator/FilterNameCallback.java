package com.tbit.tbitblesdk.bluetooth.scanner.decorator;

import android.bluetooth.BluetoothDevice;
import android.text.TextUtils;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.BaseCallback;

public class FilterNameCallback extends BaseCallback {

   private String deviceName;
   private boolean isTotalMatch;


   public FilterNameCallback(String deviceName, ScannerCallback callback) {
      this(deviceName, callback, true);
   }

   public FilterNameCallback(String deviceName, ScannerCallback callback, boolean isTotalMatch) {
      super(callback);
      this.deviceName = deviceName;
      this.isTotalMatch = isTotalMatch;
   }

   public void onScanStart() {
      this.callback.onScanStart();
   }

   public void onDeviceFounded(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
      String name = bluetoothDevice.getName();
      if(!TextUtils.isEmpty(name)) {
         if(this.isTotalMatch) {
            if(TextUtils.equals(this.deviceName, name)) {
               this.callback.onDeviceFounded(bluetoothDevice, i, bytes);
            }
         } else if(name.contains(this.deviceName)) {
            this.callback.onDeviceFounded(bluetoothDevice, i, bytes);
         }

      }
   }

   public void onScanStop() {
      this.callback.onScanStop();
   }

   public void onScanCanceled() {
      this.callback.onScanCanceled();
   }
}

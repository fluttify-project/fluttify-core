package com.tbit.tbitblesdk.bluetooth.scanner.decorator;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.BaseCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoneRepeatCallback extends BaseCallback {

   private List addressList = Collections.synchronizedList(new ArrayList());


   public NoneRepeatCallback(ScannerCallback callback) {
      super(callback);
   }

   public void onScanStart() {
      this.addressList.clear();
      this.callback.onScanStart();
   }

   public void onDeviceFounded(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
      String address = bluetoothDevice.getAddress();
      if(!this.addressList.contains(address)) {
         this.addressList.add(address);
         this.callback.onDeviceFounded(bluetoothDevice, i, bytes);
      }

   }

   public void onScanStop() {
      this.callback.onScanStop();
   }

   public void onScanCanceled() {
      this.callback.onScanCanceled();
   }
}

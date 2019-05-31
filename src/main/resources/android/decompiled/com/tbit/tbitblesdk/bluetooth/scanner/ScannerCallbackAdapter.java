package com.tbit.tbitblesdk.bluetooth.scanner;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;

public abstract class ScannerCallbackAdapter implements ScannerCallback {

   public void onScanStart() {}

   public void onScanStop() {}

   public void onScanCanceled() {}

   public void onDeviceFounded(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {}
}

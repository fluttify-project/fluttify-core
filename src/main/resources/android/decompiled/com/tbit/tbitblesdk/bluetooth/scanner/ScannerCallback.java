package com.tbit.tbitblesdk.bluetooth.scanner;

import android.bluetooth.BluetoothDevice;

public interface ScannerCallback {

   void onScanStart();

   void onScanStop();

   void onScanCanceled();

   void onDeviceFounded(BluetoothDevice var1, int var2, byte[] var3);
}

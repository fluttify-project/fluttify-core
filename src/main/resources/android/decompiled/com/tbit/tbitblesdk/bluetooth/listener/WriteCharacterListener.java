package com.tbit.tbitblesdk.bluetooth.listener;

import android.bluetooth.BluetoothGattCharacteristic;

public interface WriteCharacterListener {

   void onCharacteristicWrite(BluetoothGattCharacteristic var1, int var2, byte[] var3);
}

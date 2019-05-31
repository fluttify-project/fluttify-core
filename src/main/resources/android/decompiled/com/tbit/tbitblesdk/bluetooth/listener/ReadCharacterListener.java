package com.tbit.tbitblesdk.bluetooth.listener;

import android.bluetooth.BluetoothGattCharacteristic;

public interface ReadCharacterListener {

   void onCharacteristicRead(BluetoothGattCharacteristic var1, int var2, byte[] var3);
}

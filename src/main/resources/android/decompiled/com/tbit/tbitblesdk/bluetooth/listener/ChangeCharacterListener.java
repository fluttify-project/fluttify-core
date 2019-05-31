package com.tbit.tbitblesdk.bluetooth.listener;

import android.bluetooth.BluetoothGattCharacteristic;

public interface ChangeCharacterListener {

   void onCharacterChange(BluetoothGattCharacteristic var1, byte[] var2);
}

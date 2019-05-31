package com.tbit.tbitblesdk.bluetooth.listener;

import android.bluetooth.BluetoothGattDescriptor;

public interface WriteDescriptorListener {

   void onDescriptorWrite(BluetoothGattDescriptor var1, int var2);
}

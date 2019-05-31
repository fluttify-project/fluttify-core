package com.tbit.tbitblesdk.bluetooth;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.bluetooth.ListenerManager;
import java.util.UUID;

public interface IBleClient {

   void connect(BluetoothDevice var1, boolean var2);

   void disconnect();

   void close();

   int getConnectionState();

   ListenerManager getListenerManager();

   boolean setCharacteristicNotification(UUID var1, UUID var2, UUID var3, boolean var4);

   boolean write(UUID var1, UUID var2, byte[] var3, boolean var4);

   boolean readRssi();

   boolean requestConnectionPriority(int var1);
}

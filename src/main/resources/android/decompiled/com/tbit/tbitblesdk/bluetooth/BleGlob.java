package com.tbit.tbitblesdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;

public class BleGlob {

   private static Context mContext;
   private static BluetoothManager mBluetoothManager;
   private static BluetoothAdapter mBluetoothAdapter;


   public static void setContext(Context context) {
      mContext = context.getApplicationContext();
   }

   public static Context getContext() {
      return mContext;
   }

   public static BluetoothManager getBluetoothManager() {
      if(isBleSupported()) {
         if(mBluetoothManager == null) {
            mBluetoothManager = (BluetoothManager)getContext().getSystemService("bluetooth");
         }

         return mBluetoothManager;
      } else {
         return null;
      }
   }

   public static BluetoothAdapter getBluetoothAdapter() {
      if(mBluetoothAdapter == null) {
         mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      }

      return mBluetoothAdapter;
   }

   public static boolean isBleSupported() {
      return VERSION.SDK_INT >= 18 && getContext() != null && getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
   }

   public static boolean isBluetoothEnabled() {
      return getBluetoothAdapter() == null?false:getBluetoothAdapter().isEnabled();
   }

   public static int getBluetoothState() {
      BluetoothAdapter adapter = getBluetoothAdapter();
      return adapter != null?adapter.getState():0;
   }
}

package com.tbit.tbitblesdk.Bike;

import android.content.Context;
import com.tbit.tbitblesdk.Bike.TbitBleInstance;
import com.tbit.tbitblesdk.Bike.TbitDebugListener;
import com.tbit.tbitblesdk.Bike.TbitListener;
import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.command.callback.StateCallback;
import com.tbit.tbitblesdk.protocol.ProtocolAdapter;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;

public class TbitBle {

   private static TbitBleInstance instance;
   private static Context mContext;
   private static ProtocolAdapter mAdapter;


   public static void initialize(Context context, ProtocolAdapter adapter) {
      if(instance == null) {
         mContext = context.getApplicationContext();
         mAdapter = adapter;
      }

   }

   @Deprecated
   public static void setListener(TbitListener listener) {
      createInstanceIfNotExists();
      instance.setListener(listener);
   }

   @Deprecated
   public static void unSetListener() {
      if(instance != null) {
         instance.setListener((TbitListener)null);
      }

   }

   public static void setDebugListener(TbitDebugListener listener) {
      createInstanceIfNotExists();
      instance.setDebugListener(listener);
   }

   public static void testModel(BikeState listener) {
      createInstanceIfNotExists();
      instance.setDebugListener(listener);
   }

   public static BikeState testModel2(BikeState listener) {
      createInstanceIfNotExists();
      instance.setDebugListener(listener);
   }

   public static void testJsonable(int a) {
   }

   @Deprecated
   public static void connect(String macAddr, String key) {
      createInstanceIfNotExists();
      instance.connect(macAddr, key);
   }

   public static void connect(String machineId, String key, ResultCallback resultCallback, StateCallback stateCallback) {
      createInstanceIfNotExists();
      instance.connect(machineId, key, resultCallback, stateCallback);
   }

   public static void stopScan() {
      createInstanceIfNotExists();
      instance.stopScan();
   }
}

package com.tbit.tbitblesdk.Bike;

import android.content.Context;
import com.tbit.tbitblesdk.Bike.TbitBleInstance;
import com.tbit.tbitblesdk.Bike.TbitDebugListener;
import com.tbit.tbitblesdk.Bike.TbitListener;
import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.callback.SimpleCommonCallback;
import com.tbit.tbitblesdk.Bike.services.command.callback.StateCallback;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.bluetooth.BleGlob;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.ProtocolAdapter;
import com.tbit.tbitblesdk.protocol.ProtocolInfo;
import com.tbit.tbitblesdk.protocol.callback.PacketCallback;
import com.tbit.tbitblesdk.protocol.callback.ProgressCallback;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import com.tbit.tbitblesdk.protocol.callback.RssiCallback;
import java.io.File;

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

   @Deprecated
   public static void connect(String macAddr, String key) {
      createInstanceIfNotExists();
      instance.connect(macAddr, key);
   }

   public static void connect(String machineId, String key, ResultCallback resultCallback, StateCallback stateCallback) {
      createInstanceIfNotExists();
      instance.connect(machineId, key, resultCallback, stateCallback);
   }

   public static int startScan(ScannerCallback callback, long timeout) {
      createInstanceIfNotExists();
      return instance.startScan(callback, timeout);
   }

   public static void stopScan() {
      createInstanceIfNotExists();
      instance.stopScan();
   }

   public static void commonCommand(Command command) {
      createInstanceIfNotExists();
      instance.common(command);
   }

   public static void commonCommand(byte commandId, byte key, Byte[] value, ResultCallback resultCallback, PacketCallback packetCallback) {
      createInstanceIfNotExists();
      instance.common(commandId, key, value, resultCallback, packetCallback);
   }

   public static void commonCommand(Packet packet, ResultCallback resultCallback, PacketCallback packetCallback) {
      createInstanceIfNotExists();
      instance.common(packet, resultCallback, packetCallback);
   }

   public static void commonCommand(byte commandId, byte key, Byte[] value, SimpleCommonCallback simpleCommonCallback) {
      createInstanceIfNotExists();
      instance.common(commandId, key, value, simpleCommonCallback, simpleCommonCallback);
   }

   @Deprecated
   public static void commonCommand(byte commandId, byte key, Byte[] value) {
      createInstanceIfNotExists();
      instance.common(commandId, key, value);
   }

   @Deprecated
   public static void unlock() {
      createInstanceIfNotExists();
      instance.unlock();
   }

   public static void unlock(ResultCallback resultCallback) {
      createInstanceIfNotExists();
      instance.unlock(resultCallback);
   }

   @Deprecated
   public static void lock() {
      createInstanceIfNotExists();
      instance.lock();
   }

   public static void lock(ResultCallback resultCallback) {
      createInstanceIfNotExists();
      instance.lock(resultCallback);
   }

   @Deprecated
   public static void update() {
      createInstanceIfNotExists();
      instance.update();
   }

   public static void update(ResultCallback resultCallback, StateCallback stateCallback) {
      createInstanceIfNotExists();
      instance.update(resultCallback, stateCallback);
   }

   @Deprecated
   public static void reconnect(ResultCallback resultCallback, StateCallback stateCallback) {
      createInstanceIfNotExists();
      instance.reConnect(resultCallback, stateCallback);
   }

   @Deprecated
   public static void reconnect() {
      createInstanceIfNotExists();
      instance.reConnect();
   }

   public static int getBleConnectionState() {
      createInstanceIfNotExists();
      return instance.getBleConnectionState();
   }

   public static boolean isConnected() {
      createInstanceIfNotExists();
      return instance.isConnected();
   }

   public static BikeState getState() {
      createInstanceIfNotExists();
      return instance.getState();
   }

   public static void disConnect() {
      createInstanceIfNotExists();
      instance.disConnect();
   }

   public static void ota(File file, ResultCallback resultCallback, ProgressCallback progressCallback) {
      createInstanceIfNotExists();
      instance.ota(file, resultCallback, progressCallback);
   }

   public static void connectiveOta(String machineNo, String key, File file, ResultCallback resultCallback, ProgressCallback progressCallback) {
      createInstanceIfNotExists();
      instance.connectiveOta(machineNo, key, file, resultCallback, progressCallback);
   }

   public static void destroy() {
      createInstanceIfNotExists();
      instance.destroy();
      instance = null;
   }

   public static void cancelAllCommand() {
      createInstanceIfNotExists();
      instance.cancelAllCommand();
   }

   public static boolean atLeastConnectedOnce() {
      createInstanceIfNotExists();
      return instance.atLeastConnectedOnce();
   }

   public static void readRssi(ResultCallback resultCallback, RssiCallback rssiCallback) {
      createInstanceIfNotExists();
      instance.readRssi(resultCallback, rssiCallback);
   }

   public static BikeConfig getConfig() {
      createInstanceIfNotExists();
      return instance.getConfig();
   }

   public static boolean hasInitialized() {
      return instance != null;
   }

   private static void createInstanceIfNotExists() {
      if(mContext != null && mAdapter != null) {
         if(instance == null) {
            instance = new TbitBleInstance();
            BleGlob.setContext(mContext);
            ProtocolInfo.packetCrcTable = mAdapter.getPacketCrcTable();
            ProtocolInfo.adKey = mAdapter.getAdKey();
            ProtocolInfo.maxEncryptCount = mAdapter.getMaxAdEncryptedCount();
            ProtocolInfo.configDispatcher = mAdapter.getConfigDispatcher();
         }

      } else {
         throw new RuntimeException("have you \'initialize\' on TbitBle ? ");
      }
   }
}

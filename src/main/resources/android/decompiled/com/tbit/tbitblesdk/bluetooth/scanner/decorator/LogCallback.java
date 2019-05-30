package com.tbit.tbitblesdk.bluetooth.scanner.decorator;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.model.SearchResult;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.BaseCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LogCallback extends BaseCallback {

   private Map results = new ConcurrentHashMap();
   private StringBuilder sb;


   public LogCallback(ScannerCallback callback) {
      super(callback);
   }

   public void onScanStart() {
      this.results.clear();
      this.printLogStart();
      this.callback.onScanStart();
   }

   public void onScanStop() {
      this.printLogScannedLog();
      this.printLogTimeout();
      this.callback.onScanStop();
   }

   public void onScanCanceled() {
      this.printLogScannedLog();
      this.printLogCanceled();
      this.callback.onScanCanceled();
   }

   public void onDeviceFounded(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
      if(!this.results.containsKey(bluetoothDevice.getAddress())) {
         this.results.put(bluetoothDevice.getAddress(), new SearchResult(bluetoothDevice, i, bytes));
      }

      this.callback.onDeviceFounded(bluetoothDevice, i, bytes);
   }

   private void printLogScannedLog() {
      this.sb = new StringBuilder();
      this.sb.append("#####################################\n");
      Iterator var1 = this.results.entrySet().iterator();

      while(var1.hasNext()) {
         Entry entry = (Entry)var1.next();
         this.sb.append("mac: " + (String)entry.getKey()).append("|").append(" rssi : " + ((SearchResult)entry.getValue()).getRssi()).append("|").append(" name : " + ((SearchResult)entry.getValue()).getDevice().getName()).append("|").append("\n");
      }

      this.sb.append("#####################################");
      BleLog.log("ScanLog", this.sb.toString());
   }

   private void printLogStart() {
      BleLog.log("ScanLog", "Scan Started");
   }

   private void printLogTimeout() {
      BleLog.log("ScanLog", "Scan Timeout");
   }

   protected void printLogCanceled() {
      BleLog.log("ScanLog", "Scan Canceled");
   }
}

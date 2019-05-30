package com.tbit.tbitblesdk.Bike.tasks;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.Bike.tasks.exceptions.ResultCodeThrowable;
import com.tbit.tbitblesdk.Bike.util.BikeUtil;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.model.SearchResult;
import com.tbit.tbitblesdk.bluetooth.scanner.Scanner;
import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.LogCallback;
import com.tbit.tbitblesdk.bluetooth.scanner.decorator.NoneRepeatCallback;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class SearchObservable implements ObservableOnSubscribe, ScannerCallback {

   private String machineId;
   private String encryptedMachineId;
   private Scanner scanner;
   private ScannerCallback decoratedCallback;
   private ObservableEmitter emitter;


   public SearchObservable(String machineId, Scanner scanner) {
      this.scanner = scanner;
      this.machineId = machineId;
      this.encryptMachineId();
      this.decorateCallback();
   }

   private void encryptMachineId() {
      this.encryptedMachineId = BikeUtil.encryptStr(this.machineId);
   }

   private void decorateCallback() {
      LogCallback logCallback = new LogCallback(this);
      this.decoratedCallback = new NoneRepeatCallback(logCallback);
   }

   public void subscribe(@NonNull ObservableEmitter e) throws Exception {
      this.emitter = e;
      if(!this.scanner.isScanning()) {
         this.scanner.start(this.decoratedCallback, 10000L);
      } else {
         this.emitter.onError(new ResultCodeThrowable("SearchObservable: scanning", -1005));
      }

   }

   public void onScanStart() {}

   public void onScanStop() {
      this.emitter.onError(new ResultCodeThrowable("SearchObservable: timeout", -2002));
   }

   public void onScanCanceled() {}

   public void onDeviceFounded(BluetoothDevice bluetoothDevice, int i, byte[] bytes) {
      String dataStr = ByteUtil.bytesToHexStringWithoutSpace(bytes);
      boolean isFound = this.encryptedMachineId != null && dataStr.contains(this.encryptedMachineId);
      if(isFound) {
         this.scanner.stop();
         this.emitter.onNext(new SearchResult(bluetoothDevice, i, bytes));
         BleLog.log("BroadcastAD", dataStr);
      }

   }
}

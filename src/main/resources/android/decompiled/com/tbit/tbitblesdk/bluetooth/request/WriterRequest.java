package com.tbit.tbitblesdk.bluetooth.request;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tbit.tbitblesdk.bluetooth.listener.WriteCharacterListener;
import com.tbit.tbitblesdk.bluetooth.request.BleRequest;
import com.tbit.tbitblesdk.bluetooth.request.BleResponse;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class WriterRequest extends BleRequest implements WriteCharacterListener {

   private static final int MAX_LENGTH = 20;
   private UUID serviceUuid;
   private UUID characterUuid;
   private byte[] value;
   private boolean withResponse;
   private int timeout;
   private List valueList;


   public WriterRequest(UUID serviceUuid, UUID characterUuid, byte[] value, boolean withResponse, BleResponse bleResponse) {
      this(serviceUuid, characterUuid, value, withResponse, bleResponse, 5000);
   }

   public WriterRequest(UUID serviceUuid, UUID characterUuid, byte[] value, boolean withResponse, BleResponse bleResponse, int timeout) {
      super(bleResponse);
      this.serviceUuid = serviceUuid;
      this.characterUuid = characterUuid;
      this.value = value;
      this.withResponse = withResponse;
      this.timeout = timeout;
      this.valueList = new LinkedList();
      if(value == null || value.length == 0) {
         this.response(-1);
      }

      this.prepareList();
   }

   protected void onPrepare() {
      super.onPrepare();
      this.bleClient.getListenerManager().addWriteCharacterListener(this);
   }

   private void prepareList() {
      int start = 0;

      int end;
      byte[] bytes;
      for(end = this.value.length; end - start > 20; start += 20) {
         bytes = Arrays.copyOfRange(this.value, start, start + 20);
         this.valueList.add(bytes);
      }

      bytes = Arrays.copyOfRange(this.value, start, end);
      this.valueList.add(bytes);
   }

   public int getTimeout() {
      return this.timeout;
   }

   protected void onRequest() {
      this.doWrite();
      this.startTiming();
   }

   private void doWrite() {
      if(this.valueList.size() == 0) {
         this.stopTiming();
         this.response(0);
      } else {
         byte[] value = (byte[])this.valueList.remove(0);
         if(!this.bleClient.write(this.serviceUuid, this.characterUuid, value, this.withResponse)) {
            this.response(-1);
         }

      }
   }

   public void onCharacteristicWrite(BluetoothGattCharacteristic characteristic, int status, byte[] value) {
      if(status == 0) {
         this.doWrite();
      } else {
         this.response(-1);
      }

   }

   protected void onFinish() {
      this.bleClient.getListenerManager().removeWriteCharacterListener(this);
   }
}

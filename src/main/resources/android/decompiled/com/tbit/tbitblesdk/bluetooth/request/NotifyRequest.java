package com.tbit.tbitblesdk.bluetooth.request;

import android.bluetooth.BluetoothGattDescriptor;
import com.tbit.tbitblesdk.bluetooth.listener.WriteDescriptorListener;
import com.tbit.tbitblesdk.bluetooth.request.BleRequest;
import com.tbit.tbitblesdk.bluetooth.request.BleResponse;
import java.util.UUID;

public class NotifyRequest extends BleRequest implements WriteDescriptorListener {

   private UUID service;
   private UUID character;
   private UUID descriptor;
   private boolean isEnable;


   public NotifyRequest(BleResponse response, UUID service, UUID character, UUID descriptor, boolean isEnable) {
      super(response);
      this.service = service;
      this.character = character;
      this.descriptor = descriptor;
      this.isEnable = isEnable;
   }

   protected void onPrepare() {
      super.onPrepare();
      this.bleClient.getListenerManager().addWriteDescriptorListener(this);
   }

   protected void onRequest() {
      if(!this.bleClient.setCharacteristicNotification(this.service, this.character, this.descriptor, this.isEnable)) {
         this.response(-1);
      } else {
         this.startTiming();
      }
   }

   protected int getTimeout() {
      return 3000;
   }

   public void onDescriptorWrite(BluetoothGattDescriptor descriptor, int status) {
      this.stopTiming();
      if(0 == status) {
         this.response(0);
      } else {
         this.response(-1);
      }

   }

   protected void onFinish() {
      this.bleClient.getListenerManager().removeWriteDescriptorListener(this);
   }
}

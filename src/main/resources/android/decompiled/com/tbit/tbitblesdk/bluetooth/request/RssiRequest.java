package com.tbit.tbitblesdk.bluetooth.request;

import com.tbit.tbitblesdk.bluetooth.listener.ReadRssiListener;
import com.tbit.tbitblesdk.bluetooth.request.BleRequest;
import com.tbit.tbitblesdk.bluetooth.request.RssiResponse;

public class RssiRequest extends BleRequest implements ReadRssiListener {

   private RssiResponse rssiResponse;


   public RssiRequest(RssiResponse rssiResponse) {
      super(rssiResponse);
      this.rssiResponse = rssiResponse;
   }

   protected void onPrepare() {
      super.onPrepare();
      this.bleClient.getListenerManager().addReadRssiListener(this);
   }

   protected void onRequest() {
      if(!this.bleClient.readRssi()) {
         this.response(-1);
      } else {
         this.startTiming();
      }
   }

   protected int getTimeout() {
      return 3000;
   }

   public void onReadRemoteRssi(final int rssi, int status) {
      this.stopTiming();
      if(0 == status) {
         this.response(0);
         this.handler.post(new Runnable() {
            public void run() {
               RssiRequest.this.rssiResponse.onRssi(rssi);
            }
         });
      } else {
         this.response(-1);
      }

   }

   protected void onFinish() {
      this.bleClient.getListenerManager().removeReadRssiListener(this);
   }
}

package com.tbit.tbitblesdk.bluetooth.request;

import android.bluetooth.BluetoothDevice;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.listener.ConnectStateChangeListener;
import com.tbit.tbitblesdk.bluetooth.listener.ServiceDiscoverListener;
import com.tbit.tbitblesdk.bluetooth.request.BleRequest;
import com.tbit.tbitblesdk.bluetooth.request.BleResponse;

public class ConnectRequest extends BleRequest implements ConnectStateChangeListener, ServiceDiscoverListener {

   private static final int DEFAULT_RETRY_TIME = 0;
   private int retryCount;
   private int maxRetryTimes;
   private BluetoothDevice bluetoothDevice;


   public ConnectRequest(BluetoothDevice bluetoothDevice, BleResponse response) {
      this(bluetoothDevice, response, 0);
   }

   public ConnectRequest(BluetoothDevice bluetoothDevice, BleResponse response, int maxRetryTimes) {
      super(response);
      this.maxRetryTimes = maxRetryTimes;
      this.bluetoothDevice = bluetoothDevice;
   }

   protected int getTimeout() {
      return 7000;
   }

   protected void onPrepare() {
      super.onPrepare();
      this.bleClient.getListenerManager().addConnectStateChangeListener(this);
      this.bleClient.getListenerManager().addServiceDiscoverListener(this);
   }

   protected void onRequest() {
      this.doConnect();
      this.startTiming();
   }

   private void doConnect() {
      this.bleClient.connect(this.bluetoothDevice, false);
   }

   protected void onFinish() {
      this.bleClient.getListenerManager().removeConnectStateChangeListener(this);
      this.bleClient.getListenerManager().removeServiceDiscoverListener(this);
   }

   private void tryReconnect() {
      BleLog.log("ConnectRequest", "tryReconnect");
      if(this.retryCount < this.maxRetryTimes) {
         this.doConnect();
         ++this.retryCount;
      } else {
         this.response(-1);
      }

   }

   public void onConnectionStateChange(int status, int newState) {
      if(newState == 0) {
         this.tryReconnect();
      }

   }

   public void onServicesDiscovered(final int status) {
      this.handler.post(new Runnable() {
         public void run() {
            if(status != 0) {
               ConnectRequest.this.tryReconnect();
            } else {
               ConnectRequest.this.stopTiming();
               ConnectRequest.this.response(0);
            }

         }
      });
   }
}

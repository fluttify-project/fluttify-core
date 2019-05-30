package com.tbit.tbitblesdk.bluetooth.model;

import android.bluetooth.BluetoothDevice;

public class SearchResult {

   private BluetoothDevice device;
   private int rssi;
   private byte[] broadcastData;


   public SearchResult(BluetoothDevice device, int rssi, byte[] broadcastData) {
      this.device = device;
      this.rssi = rssi;
      this.broadcastData = broadcastData;
   }

   public BluetoothDevice getDevice() {
      return this.device;
   }

   public void setDevice(BluetoothDevice device) {
      this.device = device;
   }

   public int getRssi() {
      return this.rssi;
   }

   public void setRssi(int rssi) {
      this.rssi = rssi;
   }

   public byte[] getBroadcastData() {
      return this.broadcastData;
   }

   public void setBroadcastData(byte[] broadcastData) {
      this.broadcastData = broadcastData;
   }
}

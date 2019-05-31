package com.tbit.tbitblesdk.Bike.model;

import android.text.TextUtils;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;

import java.util.Arrays;

public class ManufacturerAd {

   private byte[] manuId = new byte[1];
   private byte[] maskId = new byte[1];
   private String machineId = "";
   private byte[] reverse = new byte[1];
   private int hardwareVersion;
   private int softwareVersion;
   private int type;


   public byte[] getManuId() {
      return this.manuId;
   }

   public void setManuId(byte[] manuId) {
      this.manuId = manuId;
   }

   public byte[] getMaskId() {
      return this.maskId;
   }

   public void setMaskId(byte[] maskId) {
      this.maskId = maskId;
   }

   public String getMachineId() {
      return this.machineId;
   }

   public void setMachineId(String machineId) {
      this.machineId = machineId;
   }

   public byte[] getReverse() {
      return this.reverse;
   }

   public void setReverse(byte[] reverse) {
      this.reverse = reverse;
   }

   public int getHardwareVersion() {
      return this.hardwareVersion;
   }

   public void setHardwareVersion(int hardwareVersion) {
      this.hardwareVersion = hardwareVersion;
   }

   public int getSoftwareVersion() {
      return this.softwareVersion;
   }

   public void setSoftwareVersion(int softwareVersion) {
      this.softwareVersion = softwareVersion;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int type) {
      this.type = type;
   }

   public String toString() {
      return "ManufacturerAd{manuId=" + Arrays.toString(this.manuId) + ", maskId=" + Arrays.toString(this.maskId) + ", machineId=\'" + this.machineId + '\'' + ", reverse=" + Arrays.toString(this.reverse) + ", hardwareVersion=" + this.hardwareVersion + ", softwareVersion=" + this.softwareVersion + ", type=" + this.type + '}';
   }

   public static ManufacturerAd resolveManufacturerAd(byte[] data) {
      ManufacturerAd manufacturerAd = new ManufacturerAd();
      if(data != null && data.length == 12) {
         manufacturerAd.setManuId(new byte[]{data[0]});
         manufacturerAd.setMaskId(new byte[]{data[1]});
         String machineId = ByteUtil.bytesToHexStringWithoutSpace(Arrays.copyOfRange(data, 2, 8));
         if(!TextUtils.isEmpty(machineId) && machineId.length() >= 9) {
            machineId = machineId.substring(0, 9);
         }

         manufacturerAd.setMachineId(machineId);
         manufacturerAd.setReverse(new byte[]{data[8]});
         manufacturerAd.setHardwareVersion(data[9]);
         manufacturerAd.setSoftwareVersion(data[10]);
         manufacturerAd.setType(data[11]);
         return manufacturerAd;
      } else {
         return manufacturerAd;
      }
   }
}

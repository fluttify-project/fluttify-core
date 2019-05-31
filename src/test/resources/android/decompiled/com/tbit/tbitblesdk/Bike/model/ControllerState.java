package com.tbit.tbitblesdk.Bike.model;

import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;

import java.util.Arrays;

public class ControllerState {

   private Byte[] rawData = new Byte[0];
   private int totalMillage;
   private int singleMillage;
   private int speed;
   private int voltage;
   private int electricCurrent;
   private int battery;
   private int[] errCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0};


   public Byte[] getRawData() {
      return this.rawData;
   }

   public void setRawData(Byte[] rawData) {
      this.rawData = rawData;
   }

   public int getTotalMillage() {
      return this.totalMillage;
   }

   public void setTotalMillage(int totalMillage) {
      this.totalMillage = totalMillage;
   }

   public int getSingleMillage() {
      return this.singleMillage;
   }

   public void setSingleMillage(int singleMillage) {
      this.singleMillage = singleMillage;
   }

   public int getSpeed() {
      return this.speed;
   }

   public void setSpeed(int speed) {
      this.speed = speed;
   }

   public int getVoltage() {
      return this.voltage;
   }

   public void setVoltage(int voltage) {
      this.voltage = voltage;
   }

   public int getElectricCurrent() {
      return this.electricCurrent;
   }

   public void setElectricCurrent(int electricCurrent) {
      this.electricCurrent = electricCurrent;
   }

   public int getBattery() {
      return this.battery;
   }

   public void setBattery(int battery) {
      this.battery = battery;
   }

   public int[] getErrCode() {
      return this.errCode;
   }

   public void setErrCode(int[] errCode) {
      this.errCode = errCode;
   }

   public String toString() {
      return "ControllerState{rawData=" + ByteUtil.bytesToHexString(this.rawData) + ", totalMillage=" + this.totalMillage + ", singleMillage=" + this.singleMillage + ", speed=" + this.speed + ", voltage=" + this.voltage + ", electricCurrent=" + this.electricCurrent + ", battery=" + this.battery + ", errCode=" + Arrays.toString(this.errCode) + '}';
   }
}

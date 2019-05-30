package com.tbit.tbitblesdk.user.entity;

import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import java.util.Arrays;

public class AControllerState {

   private int totalMillage;
   private int singleMillage;
   private int speed;
   private int voltage;
   private int electricCurrent;
   private int battery;
   private int[] errCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0};


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
      return "AControllerState{totalMillage=" + this.totalMillage + ", singleMillage=" + this.singleMillage + ", speed=" + this.speed + ", voltage=" + this.voltage + ", electricCurrent=" + this.electricCurrent + ", battery=" + this.battery + ", errCode=" + Arrays.toString(this.errCode) + '}';
   }

   public static AControllerState resolve(Byte[] data) {
      AControllerState controllerState = new AControllerState();
      if(data != null && data.length == 13) {
         byte[] originData = ByteUtil.byteArrayToUnBoxed(data);
         controllerState.setTotalMillage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 0, 2)));
         controllerState.setSingleMillage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 2, 4)));
         controllerState.setSpeed(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 4, 6)));
         Byte originError = data[6];
         int[] error = controllerState.getErrCode();
         error[0] = StateUpdateHelper.bitResolver(originError, 1);
         error[1] = StateUpdateHelper.bitResolver(originError, 2);
         error[2] = StateUpdateHelper.bitResolver(originError, 4);
         error[3] = StateUpdateHelper.bitResolver(originError, 8);
         error[4] = StateUpdateHelper.bitResolver(originError, 16);
         error[5] = StateUpdateHelper.bitResolver(originError, 32);
         error[6] = StateUpdateHelper.bitResolver(originError, 64);
         error[7] = StateUpdateHelper.bitResolver(originError, 128);
         controllerState.setVoltage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 7, 9)));
         controllerState.setElectricCurrent(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 9, 11)));
         controllerState.setBattery(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 11, 13)));
         return controllerState;
      } else {
         return controllerState;
      }
   }
}

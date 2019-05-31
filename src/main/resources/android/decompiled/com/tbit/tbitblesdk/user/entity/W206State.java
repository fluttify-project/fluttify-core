package com.tbit.tbitblesdk.user.entity;

import java.util.Arrays;

public class W206State {

   private int totalMileage;
   private int singleMileage;
   private int battery;
   private int extVoltage;
   private int chargeCount;
   private int[] errorCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   private int ctrlState;
   private int movingEi;
   private int controllerTemperature;


   public int getControllerTemperature() {
      return this.controllerTemperature;
   }

   public void setControllerTemperature(int controllerTemperature) {
      this.controllerTemperature = controllerTemperature;
   }

   public int getMovingEi() {
      return this.movingEi;
   }

   public void setMovingEi(int movingEi) {
      this.movingEi = movingEi;
   }

   public int getTotalMileage() {
      return this.totalMileage;
   }

   public void setTotalMileage(int totalMileage) {
      this.totalMileage = totalMileage;
   }

   public void setSingleMileage(int singleMileage) {
      this.singleMileage = singleMileage;
   }

   public int getBattery() {
      return this.battery;
   }

   public void setBattery(int battery) {
      this.battery = battery;
   }

   public void setExtVoltage(int extVoltage) {
      this.extVoltage = extVoltage;
   }

   public int getChargeCount() {
      return this.chargeCount;
   }

   public void setChargeCount(int chargeCount) {
      this.chargeCount = chargeCount;
   }

   public int[] getErrorCode() {
      return this.errorCode;
   }

   public void setErrorCode(int[] errorCode) {
      this.errorCode = errorCode;
   }

   public int getCtrlState() {
      return this.ctrlState;
   }

   public void setCtrlState(int ctrlState) {
      this.ctrlState = ctrlState;
   }

   public String toString() {
      return "W206State{totalMileage=" + this.totalMileage + ", singleMileage=" + this.singleMileage + ", battery=" + this.battery + ", extVoltage=" + this.extVoltage + ", chargeCount=" + this.chargeCount + ", errorCode=" + Arrays.toString(this.errorCode) + ", ctrlState=" + this.ctrlState + ", movingEi=" + this.movingEi + ", controllerTemperature=" + this.controllerTemperature + '}';
   }
}

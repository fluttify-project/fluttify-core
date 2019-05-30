package com.tbit.tbitblesdk.user.entity;

import java.util.Arrays;

public class BControllerState {

   private int[] status2 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   private int[] status3 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   private int[] status4 = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   private int totalMillage;
   private int singleMillage;
   private int humidity;
   private int voltage;
   private int extVoltage;
   private int chargeCount;
   private int movingEi;


   public int getChargeCount() {
      return this.chargeCount;
   }

   public void setChargeCount(int chargeCount) {
      this.chargeCount = chargeCount;
   }

   public int[] getStatus2() {
      return this.status2;
   }

   public void setStatus2(int[] status2) {
      this.status2 = status2;
   }

   public int[] getStatus3() {
      return this.status3;
   }

   public void setStatus3(int[] status3) {
      this.status3 = status3;
   }

   public int[] getStatus4() {
      return this.status4;
   }

   public void setStatus4(int[] status4) {
      this.status4 = status4;
   }

   public int getMovingEi() {
      return this.movingEi;
   }

   public void setMovingEi(int movingEi) {
      this.movingEi = movingEi;
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

   public int getHumidity() {
      return this.humidity;
   }

   public void setHumidity(int humidity) {
      this.humidity = humidity;
   }

   public int getVoltage() {
      return this.voltage;
   }

   public void setVoltage(int voltage) {
      this.voltage = voltage;
   }

   public int getExtVoltage() {
      return this.extVoltage;
   }

   public void setExtVoltage(int extVoltage) {
      this.extVoltage = extVoltage;
   }

   public String toString() {
      return "BControllerState{status2=" + Arrays.toString(this.status2) + ", status3=" + Arrays.toString(this.status3) + ", status4=" + Arrays.toString(this.status4) + ", totalMillage=" + this.totalMillage + ", singleMillage=" + this.singleMillage + ", humidity=" + this.humidity + ", voltage=" + this.voltage + ", extVoltage=" + this.extVoltage + ", chargeCount=" + this.chargeCount + ", movingEi=" + this.movingEi + '}';
   }
}

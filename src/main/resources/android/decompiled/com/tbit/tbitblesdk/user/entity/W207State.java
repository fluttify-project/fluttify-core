package com.tbit.tbitblesdk.user.entity;

import java.util.Arrays;

public class W207State {

   private double latitudeDegree;
   private double latitudeMinute;
   private double longitudeDegree;
   private double longitudeMinute;
   private int satellite;
   private int totalMileage;
   private int battery;
   private int chargeCount;
   private boolean charging;
   private int[] errorCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
   private int ctrlState;
   private boolean sustained;
   private int gpsState = 0;


   public int getGpsState() {
      return this.gpsState;
   }

   public void setGpsState(int gpsState) {
      this.gpsState = gpsState;
   }

   public boolean isSustained() {
      return this.sustained;
   }

   public void setSustained(boolean sustained) {
      this.sustained = sustained;
   }

   public double getLatitudeDegree() {
      return this.latitudeDegree;
   }

   public void setLatitudeDegree(double latitudeDegree) {
      this.latitudeDegree = latitudeDegree;
   }

   public double getLatitudeMinute() {
      return this.latitudeMinute;
   }

   public void setLatitudeMinute(double latitudeMinute) {
      this.latitudeMinute = latitudeMinute;
   }

   public double getLongitudeDegree() {
      return this.longitudeDegree;
   }

   public void setLongitudeDegree(double longitudeDegree) {
      this.longitudeDegree = longitudeDegree;
   }

   public double getLongitudeMinute() {
      return this.longitudeMinute;
   }

   public void setLongitudeMinute(double longitudeMinute) {
      this.longitudeMinute = longitudeMinute;
   }

   public int getSatellite() {
      return this.satellite;
   }

   public void setSatellite(int satellite) {
      this.satellite = satellite;
   }

   public int getTotalMileage() {
      return this.totalMileage;
   }

   public void setTotalMileage(int totalMileage) {
      this.totalMileage = totalMileage;
   }

   public int getBattery() {
      return this.battery;
   }

   public void setBattery(int battery) {
      this.battery = battery;
   }

   public int getChargeCount() {
      return this.chargeCount;
   }

   public void setChargeCount(int chargeCount) {
      this.chargeCount = chargeCount;
   }

   public boolean isCharging() {
      return this.charging;
   }

   public void setCharging(boolean charging) {
      this.charging = charging;
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
      return "W207State{latitudeDegree=" + this.latitudeDegree + ", latitudeMinute=" + this.latitudeMinute + ", longitudeDegree=" + this.longitudeDegree + ", longitudeMinute=" + this.longitudeMinute + ", satellite=" + this.satellite + ", totalMileage=" + this.totalMileage + ", battery=" + this.battery + ", chargeCount=" + this.chargeCount + ", charging=" + this.charging + ", errorCode=" + Arrays.toString(this.errorCode) + ", ctrlState=" + this.ctrlState + ", sustained=" + this.sustained + ", gpsState=" + this.gpsState + '}';
   }
}

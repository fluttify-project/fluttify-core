package com.tbit.tbitblesdk.Bike.model;

import com.tbit.tbitblesdk.Bike.model.ControllerState;
import java.util.Arrays;

public class BikeState {

   private float battery;
   private double[] location = new double[]{0.0D, 0.0D};
   private int[] signal = new int[]{0, 0, 0};
   private int verifyFailedCode;
   private int deviceFaultCode;
   private int[] systemState = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
   private int operateFaultCode;
   private int[] baseStation = new int[]{0, 0, 0, 0};
   private int[] version = new int[]{0, 0};
   private ControllerState controllerState = new ControllerState();
   private Byte[] rawData = new Byte[0];
   private int gpsState = 0;


   public int getGpsState() {
      return this.gpsState;
   }

   public void setGpsState(int gpsState) {
      this.gpsState = gpsState;
   }

   public Byte[] getRawData() {
      return this.rawData;
   }

   public void setRawData(Byte[] rawData) {
      this.rawData = rawData;
   }

   public ControllerState getControllerState() {
      return this.controllerState;
   }

   public void setControllerState(ControllerState controllerState) {
      this.controllerState = controllerState;
   }

   public int[] getBaseStation() {
      return this.baseStation;
   }

   public void setBaseStation(int[] baseStation) {
      this.baseStation = baseStation;
   }

   public int[] getVersion() {
      return this.version;
   }

   public void setVersion(int[] version) {
      this.version = version;
   }

   public int[] getSystemState() {
      return this.systemState;
   }

   public void setSystemState(int[] systemState) {
      this.systemState = systemState;
   }

   public int getOperateFaultCode() {
      return this.operateFaultCode;
   }

   public void setOperateFaultCode(int operateFaultCode) {
      this.operateFaultCode = operateFaultCode;
   }

   public float getBattery() {
      return this.battery;
   }

   public void setBattery(float battery) {
      this.battery = battery;
   }

   public double[] getLocation() {
      return this.location;
   }

   public void setLocation(double[] location) {
      this.location = location;
   }

   public int[] getSignal() {
      return this.signal;
   }

   public void setSignal(int[] signal) {
      this.signal = signal;
   }

   public int getVerifyFailedCode() {
      return this.verifyFailedCode;
   }

   public void setVerifyFailedCode(int verifyFailedCode) {
      this.verifyFailedCode = verifyFailedCode;
   }

   public int getDeviceFaultCode() {
      return this.deviceFaultCode;
   }

   public void setDeviceFaultCode(int deviceFaultCode) {
      this.deviceFaultCode = deviceFaultCode;
   }

   public String toString() {
      return "BikeState{battery=" + this.battery + ", location=" + Arrays.toString(this.location) + ", signal=" + Arrays.toString(this.signal) + ", verifyFailedCode=" + this.verifyFailedCode + ", deviceFaultCode=" + this.deviceFaultCode + ", systemState=" + Arrays.toString(this.systemState) + ", operateFaultCode=" + this.operateFaultCode + ", baseStation=" + Arrays.toString(this.baseStation) + ", version=" + Arrays.toString(this.version) + ", gpsState=" + this.gpsState + '}';
   }
}

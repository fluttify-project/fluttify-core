package com.tbit.tbitblesdk.Bike.services.resolver;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.model.ControllerState;
import com.tbit.tbitblesdk.Bike.services.resolver.Resolver;
import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import com.tbit.tbitblesdk.user.entity.W206State;
import java.util.Arrays;

public class W206Resolver implements Resolver {

   private final int mSoftVersion;
   private final int mRawControllerStateLength;


   public W206Resolver(int softVersion) {
      this.mSoftVersion = softVersion;
      if(this.mSoftVersion <= 3) {
         this.mRawControllerStateLength = 13;
      } else {
         this.mRawControllerStateLength = 19;
      }

   }

   public void resolveAll(BikeState bikeStates, byte protocolVersion, Byte[] data) {
      if(data != null && data.length != 0) {
         bikeStates.setRawData(data);
         Byte[] rawControllerState;
         if(data.length >= 10) {
            rawControllerState = (Byte[])Arrays.copyOfRange(data, 0, 10);
            this.resolveLocations(bikeStates, rawControllerState);
         }

         if(data.length >= 13) {
            rawControllerState = (Byte[])Arrays.copyOfRange(data, 10, 13);
            StateUpdateHelper.updateSignal(bikeStates, rawControllerState);
         }

         if(data.length >= 15) {
            rawControllerState = (Byte[])Arrays.copyOfRange(data, 13, 15);
            StateUpdateHelper.updateVoltage(bikeStates, protocolVersion, rawControllerState);
         }

         if(data.length >= 23) {
            rawControllerState = (Byte[])Arrays.copyOfRange(data, 15, 23);
            StateUpdateHelper.updateBaseStation(bikeStates, rawControllerState);
         }

         if(data.length >= 23 + this.mRawControllerStateLength) {
            rawControllerState = (Byte[])Arrays.copyOfRange(data, 23, 23 + this.mRawControllerStateLength);
            this.resolveControllerState(bikeStates, rawControllerState);
         }

      }
   }

   public void resolveControllerState(BikeState bikeState, Byte[] data) {
      if(data != null && data.length >= this.mRawControllerStateLength) {
         ControllerState controllerState = bikeState.getControllerState();
         controllerState.setRawData(data);
      }
   }

   public void resolveLocations(BikeState bikeState, Byte[] data) {
      StateUpdateHelper.updateLocation(bikeState, data);
   }

   public W206State resolveCustomState(BikeState bikeState) {
      return bikeState.getControllerState().getRawData().length < this.mRawControllerStateLength?new W206State():(this.mSoftVersion <= 3?this.resolveCustomStateV3(bikeState):this.resolveCustomStateV4(bikeState));
   }

   public W206State resolveCustomStateV3(BikeState bikeState) {
      W206State state = new W206State();
      byte[] originData = ByteUtil.byteArrayToUnBoxed(bikeState.getControllerState().getRawData());
      state.setMovingEi(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 4, 5)));
      state.setChargeCount(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 5, 7)));
      state.setBattery(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 7, 8)));
      state.setControllerTemperature(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 8, 9)));
      state.setSingleMileage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 9, 13)));
      int[] errCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
      StateUpdateHelper.byteToBitArray(Byte.valueOf(originData[1]), errCode);
      state.setErrorCode(errCode);
      int[] sysState = bikeState.getSystemState();
      int ctrlValue = (sysState[5] << 1) + sysState[4];
      state.setCtrlState(ctrlValue);
      return state;
   }

   public W206State resolveCustomStateV4(BikeState bikeState) {
      W206State state = this.resolveCustomStateV3(bikeState);
      byte[] originData = ByteUtil.byteArrayToUnBoxed(bikeState.getControllerState().getRawData());
      state.setTotalMileage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 9, 13)));
      state.setSingleMileage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 13, 17)));
      state.setExtVoltage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 17, 19)));
      return state;
   }
}

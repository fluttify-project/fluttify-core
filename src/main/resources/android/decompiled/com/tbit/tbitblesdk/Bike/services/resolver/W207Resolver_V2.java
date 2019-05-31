package com.tbit.tbitblesdk.Bike.services.resolver;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.model.ControllerState;
import com.tbit.tbitblesdk.Bike.services.resolver.Resolver;
import com.tbit.tbitblesdk.Bike.services.resolver.W207Resolver;
import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import com.tbit.tbitblesdk.user.entity.BControllerState;
import com.tbit.tbitblesdk.user.entity.W207State;
import java.util.Arrays;

public class W207Resolver_V2 implements Resolver {

   public void resolveAll(BikeState bikeStates, byte protocolVersion, Byte[] data) {
      if(data != null && data.length != 0) {
         bikeStates.setRawData(data);
         Byte[] controllerInfoData;
         if(data.length >= 11) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 0, 8);
            StateUpdateHelper.updateLocation(bikeStates, controllerInfoData);
            Byte[] heading = (Byte[])Arrays.copyOfRange(data, 8, 11);
            bikeStates.setGpsState(StateUpdateHelper.bitResolver(heading[0], 16));
         }

         if(data.length >= 14) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 11, 14);
            StateUpdateHelper.updateSignal(bikeStates, controllerInfoData);
         }

         if(data.length >= 16) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 14, 16);
            StateUpdateHelper.updateVoltage(bikeStates, protocolVersion, controllerInfoData);
         }

         if(data.length >= 24) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 16, 24);
            StateUpdateHelper.updateBaseStation(bikeStates, controllerInfoData);
         }

         if(data.length >= 44) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 24, 44);
            this.resolveControllerState(bikeStates, controllerInfoData);
         }

      }
   }

   public void resolveControllerState(BikeState bikeState, Byte[] data) {
      if(data != null && data.length >= 19) {
         ControllerState controllerState = bikeState.getControllerState();
         controllerState.setRawData(data);
      }
   }

   public void resolveLocations(BikeState bikeState, Byte[] data) {
      if(data.length >= 11) {
         double[] result = ByteUtil.getPoint(data);
         bikeState.setLocation(result);
         Byte[] heading = (Byte[])Arrays.copyOfRange(data, 8, 10);
         bikeState.setGpsState(StateUpdateHelper.bitResolver(heading[0], 16));
      }
   }

   public W207State resolveCustomState(BikeState bikeState) {
      W207State state = new W207State();
      if(bikeState.getControllerState().getRawData().length < 19) {
         return state;
      } else {
         double[] longitudes = W207Resolver.resolveLocations(bikeState.getLocation()[0]);
         double[] latitude = W207Resolver.resolveLocations(bikeState.getLocation()[1]);
         state.setLongitudeDegree(longitudes[0]);
         state.setLongitudeMinute(longitudes[1]);
         state.setLatitudeDegree(latitude[0]);
         state.setLatitudeMinute(latitude[1]);
         state.setSatellite(bikeState.getSignal()[1]);
         state.setGpsState(bikeState.getGpsState());
         BControllerState controllerState = this.resolveBControllerState(bikeState.getControllerState().getRawData());
         state.setTotalMileage(controllerState.getTotalMillage());
         state.setBattery(controllerState.getVoltage());
         int[] sysState = bikeState.getSystemState();
         state.setCharging(sysState[2] == 1);
         int[] status2 = controllerState.getStatus2();
         int[] errCode = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
         System.arraycopy(status2, 0, errCode, 0, status2.length);
         state.setErrorCode(errCode);
         state.setChargeCount(controllerState.getChargeCount());
         state.setSustained(sysState[7] == 1);
         String res = sysState[1] + String.valueOf(sysState[0]);
         int flag = Integer.valueOf(res, 2).intValue();
         byte ctrlValue = 1;
         switch(flag) {
         case 0:
            ctrlValue = 2;
            break;
         case 1:
            ctrlValue = 1;
            break;
         case 2:
            ctrlValue = 3;
         }

         state.setCtrlState(ctrlValue);
         return state;
      }
   }

   private BControllerState resolveBControllerState(Byte[] data) {
      BControllerState controllerState = new BControllerState();
      if(data != null && data.length >= 19) {
         byte[] originData = ByteUtil.byteArrayToUnBoxed(data);
         int[] status2 = controllerState.getStatus2();
         Byte b2 = data[1];
         StateUpdateHelper.byteToBitArray(b2, status2);
         int[] status3 = controllerState.getStatus3();
         Byte b3 = data[2];
         StateUpdateHelper.byteToBitArray(b3, status3);
         int[] status4 = controllerState.getStatus4();
         Byte b4 = data[3];
         StateUpdateHelper.byteToBitArray(b4, status4);
         controllerState.setMovingEi(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 4, 5)));
         controllerState.setChargeCount(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 5, 7)));
         controllerState.setVoltage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 7, 8)));
         controllerState.setHumidity(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 8, 9)));
         controllerState.setTotalMillage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 9, 13)));
         controllerState.setSingleMillage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 13, 17)));
         controllerState.setExtVoltage(StateUpdateHelper.byteArrayToInt(Arrays.copyOfRange(originData, 17, 19)));
         return controllerState;
      } else {
         return controllerState;
      }
   }
}

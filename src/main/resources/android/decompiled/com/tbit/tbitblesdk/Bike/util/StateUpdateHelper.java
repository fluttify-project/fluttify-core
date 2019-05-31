package com.tbit.tbitblesdk.Bike.util;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.model.ControllerState;
import com.tbit.tbitblesdk.bluetooth.util.ByteUtil;
import java.util.Arrays;

public class StateUpdateHelper {

   public static void updateControllerState(BikeState bikeStates, Byte[] data) {
      if(data != null && data.length == 13) {
         ControllerState controllerState = bikeStates.getControllerState();
         controllerState.setRawData(data);
         byte[] originData = ByteUtil.byteArrayToUnBoxed(data);
         controllerState.setTotalMillage(byteArrayToInt(Arrays.copyOfRange(originData, 0, 2)));
         controllerState.setSingleMillage(byteArrayToInt(Arrays.copyOfRange(originData, 2, 4)));
         controllerState.setSpeed(byteArrayToInt(Arrays.copyOfRange(originData, 4, 6)));
         Byte originError = data[6];
         int[] error = controllerState.getErrCode();
         error[0] = bitResolver(originError, 1);
         error[1] = bitResolver(originError, 2);
         error[2] = bitResolver(originError, 4);
         error[3] = bitResolver(originError, 8);
         error[4] = bitResolver(originError, 16);
         error[5] = bitResolver(originError, 32);
         error[6] = bitResolver(originError, 64);
         error[7] = bitResolver(originError, 128);
         controllerState.setVoltage(byteArrayToInt(Arrays.copyOfRange(originData, 7, 9)));
         controllerState.setElectricCurrent(byteArrayToInt(Arrays.copyOfRange(originData, 9, 11)));
         controllerState.setBattery(byteArrayToInt(Arrays.copyOfRange(originData, 11, 13)));
      }
   }

   public static void updateBaseStation(BikeState bikeStates, Byte[] data) {
      if(data != null && data.length == 8) {
         try {
            byte[] e = ByteUtil.byteArrayToUnBoxed(data);
            byte[] mcc = ByteUtil.subBytes(e, 0, 2);
            byte[] mnc = ByteUtil.subBytes(e, 2, 1);
            byte[] lac = ByteUtil.subBytes(e, 3, 2);
            byte[] cell = ByteUtil.subBytes(e, 5, 3);
            int[] result = new int[]{byteArrayToInt(mcc), byteArrayToInt(mnc), byteArrayToInt(lac), byteArrayToInt(cell)};
            bikeStates.setBaseStation(result);
         } catch (Exception var8) {
            var8.printStackTrace();
         }

      }
   }

   public static int bitResolver(Byte state, int flag) {
      boolean isFlagged = (state.byteValue() & flag) == flag;
      return isFlagged?1:0;
   }

   public static void byteToBitArray(Byte b, int[] array) {
      array[0] = bitResolver(b, 1);
      array[1] = bitResolver(b, 2);
      array[2] = bitResolver(b, 4);
      array[3] = bitResolver(b, 8);
      array[4] = bitResolver(b, 16);
      array[5] = bitResolver(b, 32);
      array[6] = bitResolver(b, 64);
      array[7] = bitResolver(b, 128);
   }

   public static int byteArrayToInt(byte[] data) {
      String s = ByteUtil.bytesToHexString(data);
      s = s.replace(" ", "");
      return Integer.parseInt(s, 16);
   }

   public static void updateAll(BikeState bikeStates, byte protocolVersion, Byte[] data) {
      if(data != null && data.length != 0) {
         bikeStates.setRawData(data);
         Byte[] controllerInfoData;
         if(data.length >= 10) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 0, 10);
            updateLocation(bikeStates, controllerInfoData);
         }

         if(data.length >= 13) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 10, 13);
            updateSignal(bikeStates, controllerInfoData);
         }

         if(data.length >= 15) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 13, 15);
            updateVoltage(bikeStates, protocolVersion, controllerInfoData);
         }

         if(data.length >= 23) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 15, 23);
            updateBaseStation(bikeStates, controllerInfoData);
         }

         if(data.length >= 36) {
            controllerInfoData = (Byte[])Arrays.copyOfRange(data, 23, 36);
            updateControllerState(bikeStates, controllerInfoData);
         }

      }
   }

   public static void updateVoltage(BikeState bikeStates, byte protocolVersion, Byte[] data) {
      int result = 0;

      try {
         result = byteArrayToInt(ByteUtil.byteArrayToUnBoxed(data));
         if(protocolVersion >= 2) {
            result *= 10;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      bikeStates.setBattery((float)result);
   }

   public static void updateDeviceFault(BikeState bikeStates, Byte[] data) {
      int result = 0;

      try {
         result = byteArrayToInt(ByteUtil.byteArrayToUnBoxed(data));
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      bikeStates.setDeviceFaultCode(result);
   }

   public static void updateLocation(BikeState bikeStates, Byte[] data) {
      double[] result = ByteUtil.getPoint(data);
      bikeStates.setLocation(result);
   }

   public static void updateSignal(BikeState bikeStates, Byte[] data) {
      if(data != null && data.length == 3) {
         int[] result = new int[3];

         try {
            for(int e = 0; e < data.length; ++e) {
               result[e] = Integer.valueOf(data[e].byteValue()).intValue();
            }
         } catch (ArrayIndexOutOfBoundsException var4) {
            var4.printStackTrace();
            return;
         }

         bikeStates.setSignal(result);
      }
   }

   public static void updateVerifyFailed(BikeState bikeStates, Byte[] data) {
      if(data != null && data.length != 0) {
         bikeStates.setVerifyFailedCode(data[data.length - 1].byteValue());
      }
   }

   public static void updateSysState(BikeState bikeState, Byte state) {
      int[] result = new int[]{bitResolver(state, 1), bitResolver(state, 2), bitResolver(state, 4), bitResolver(state, 8), bitResolver(state, 16), bitResolver(state, 32), bitResolver(state, 64), bitResolver(state, 128)};
      bikeState.setSystemState(result);
   }
}

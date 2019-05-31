package com.tbit.tbitblesdk.Bike.services.config;

import com.tbit.tbitblesdk.Bike.model.ManufacturerAd;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.services.config.ConfigDispatcher;
import com.tbit.tbitblesdk.Bike.services.config.Config_207;
import com.tbit.tbitblesdk.Bike.services.config.Config_207_2;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;

public class MMConfigDispatcher implements ConfigDispatcher {

   public BikeConfig dispatch(ManufacturerAd manufacturerAd) {
      int hardVersion = manufacturerAd.getHardwareVersion();
      int softVersion = manufacturerAd.getSoftwareVersion();
      int mainHardVersion = (hardVersion & 224) >> 5;
      int subHardVersion = hardVersion & 31;
      Object result;
      switch(softVersion) {
      case 0:
      case 1:
         result = new Config_207();
         break;
      case 2:
         result = new Config_207_2();
         break;
      default:
         result = new Config_207_2();
      }

      BleLog.log("BikeConfigDispatcher", result == null?"null":result.getClass().getSimpleName());
      return (BikeConfig)result;
   }
}

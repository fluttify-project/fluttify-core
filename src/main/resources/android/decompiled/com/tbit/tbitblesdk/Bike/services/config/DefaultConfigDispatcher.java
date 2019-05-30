package com.tbit.tbitblesdk.Bike.services.config;

import com.tbit.tbitblesdk.Bike.model.ManufacturerAd;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.services.config.ConfigDispatcher;
import com.tbit.tbitblesdk.Bike.services.config.Config_205B;
import com.tbit.tbitblesdk.Bike.services.config.Config_205D;
import com.tbit.tbitblesdk.Bike.services.config.Config_206;
import com.tbit.tbitblesdk.Bike.services.config.Config_207;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;

public class DefaultConfigDispatcher implements ConfigDispatcher {

   public BikeConfig dispatch(ManufacturerAd manufacturerAd) {
      Object result;
      int hardVersion = manufacturerAd.getHardwareVersion();
      int softVersion = manufacturerAd.getSoftwareVersion();
      int mainHardVersion = (hardVersion & 224) >> 5;
      int subHardVersion = hardVersion & 31;
      label24:
      switch(mainHardVersion) {
      case 0:
         switch(softVersion) {
         case 0:
         case 1:
         case 2:
            result = new Config_205B();
            break label24;
         case 3:
         case 4:
            result = new Config_205D();
            break label24;
         default:
            result = new Config_205D();
            break label24;
         }
      case 1:
         switch(subHardVersion) {
         case 1:
            result = new Config_206(softVersion);
            break label24;
         case 2:
            result = new Config_206(softVersion);
            break label24;
         case 3:
            result = new Config_207();
            break label24;
         case 4:
            result = new Config_205D();
            break label24;
         default:
            result = new Config_206(softVersion);
            break label24;
         }
      default:
         result = new Config_206(softVersion);
      }

      BleLog.log("BikeConfigDispatcher", result == null?"null":result.getClass().getSimpleName());
      return (BikeConfig)result;
   }
}

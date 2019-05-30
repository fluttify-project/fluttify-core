package com.tbit.tbitblesdk.Bike.services.resolver;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.resolver.Resolver;
import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;

public class BeforeW207Resolver implements Resolver {

   public void resolveAll(BikeState bikeState, byte protocolVersion, Byte[] data) {
      StateUpdateHelper.updateAll(bikeState, protocolVersion, data);
   }

   public void resolveControllerState(BikeState bikeState, Byte[] data) {
      StateUpdateHelper.updateControllerState(bikeState, data);
   }

   public void resolveLocations(BikeState bikeState, Byte[] data) {
      StateUpdateHelper.updateLocation(bikeState, data);
   }

   public BikeState resolveCustomState(BikeState bikeState) {
      return bikeState;
   }
}

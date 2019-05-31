package com.tbit.tbitblesdk.Bike.services.resolver;

import com.tbit.tbitblesdk.Bike.model.BikeState;

public interface Resolver {

   void resolveAll(BikeState var1, byte var2, Byte[] var3);

   void resolveControllerState(BikeState var1, Byte[] var2);

   void resolveLocations(BikeState var1, Byte[] var2);

   Object resolveCustomState(BikeState var1);
}

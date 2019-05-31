package com.tbit.tbitblesdk.Bike.services.command.callback;

import com.tbit.tbitblesdk.Bike.model.BikeState;

public interface StateCallback {

   void onStateUpdated(BikeState var1);
}

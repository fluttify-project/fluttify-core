package com.tbit.tbitblesdk.Bike;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.protocol.PacketValue;

public interface TbitListener {

   void onConnectResponse(int var1);

   void onUnlockResponse(int var1);

   void onLockResponse(int var1);

   void onUpdateResponse(int var1);

   void onStateUpdated(BikeState var1);

   void onDisconnected(int var1);

   void onCommonCommandResponse(int var1, PacketValue var2);
}

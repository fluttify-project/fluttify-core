package com.tbit.tbitblesdk.Bike;

import com.tbit.tbitblesdk.Bike.TbitDebugListener;
import com.tbit.tbitblesdk.Bike.TbitListener;
import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.protocol.PacketValue;

public class EmptyListener implements TbitListener {

   public void onConnectResponse(int resultCode) {}

   public void onUnlockResponse(int resultCode) {}

   public void onLockResponse(int resultCode) {}

   public void onUpdateResponse(int resultCode) {}

   public void onStateUpdated(BikeState state) {}

   public void onDisconnected(int resultCode) {}

   public void onCommonCommandResponse(int resultCode, PacketValue packetValue) {}

   public static class EmptyDebugListener implements TbitDebugListener {

      public void onLogStrReceived(String logStr) {}
   }
}

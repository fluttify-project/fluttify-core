package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.callback.StateCallback;
import com.tbit.tbitblesdk.Bike.util.StateUpdateHelper;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;

public abstract class UpdatableCommand extends Command {

   protected BikeState bikeState;
   protected StateCallback stateCallback;


   public UpdatableCommand(ResultCallback resultCallback, StateCallback stateCallback, BikeState bikeState) {
      super(resultCallback);
      this.bikeState = bikeState;
      this.stateCallback = stateCallback;
   }

   protected void parseVerifyFailed(Byte[] data) {
      StateUpdateHelper.updateVerifyFailed(this.bikeState, data);
   }

   protected void parseLocation(Byte[] data) {
      this.bikeConfig.getResolver().resolveLocations(this.bikeState, data);
   }

   protected void parseSignal(Byte[] data) {
      StateUpdateHelper.updateSignal(this.bikeState, data);
   }

   protected void parseControllerState(Byte[] data) {
      this.bikeConfig.getResolver().resolveControllerState(this.bikeState, data);
   }

   protected void parseBaseStation(Byte[] data) {
      StateUpdateHelper.updateBaseStation(this.bikeState, data);
   }

   protected void parseAll(byte protocolVersion, Byte[] data) {
      this.bikeConfig.getResolver().resolveAll(this.bikeState, protocolVersion, data);
   }

   protected void parseVoltage(byte protocolVersion, Byte[] data) {
      StateUpdateHelper.updateVoltage(this.bikeState, protocolVersion, data);
   }

   protected void parseDeviceFault(Byte[] data) {
      StateUpdateHelper.updateDeviceFault(this.bikeState, data);
   }

   protected void updateState() {
      if(this.stateCallback != null) {
         this.stateCallback.onStateUpdated(this.bikeState);
      }

   }

   protected void onFinish() {
      super.onFinish();
      this.stateCallback = null;
   }
}

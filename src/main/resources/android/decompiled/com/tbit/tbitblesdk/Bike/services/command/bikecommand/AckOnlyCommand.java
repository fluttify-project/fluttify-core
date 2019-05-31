package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;

public abstract class AckOnlyCommand extends Command {

   public AckOnlyCommand(ResultCallback resultCallback) {
      super(resultCallback);
   }

   protected void onAckSuccess() {
      this.response(0);
   }
}

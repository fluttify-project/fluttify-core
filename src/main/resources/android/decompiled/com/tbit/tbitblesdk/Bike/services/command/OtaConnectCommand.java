package com.tbit.tbitblesdk.Bike.services.command;

import com.tbit.tbitblesdk.Bike.services.OtaService;
import com.tbit.tbitblesdk.Bike.services.command.OtaCommand;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.callback.ProgressCallback;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;

public class OtaConnectCommand extends OtaCommand {

   private Byte[] key;


   public OtaConnectCommand(OtaService otaServices, Byte[] key, ResultCallback resultCallback, ProgressCallback progressCallback) {
      super(otaServices, resultCallback, progressCallback);
      this.key = key;
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)1, (byte)1, this.key);
   }
}

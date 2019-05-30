package com.tbit.tbitblesdk.Bike.services.command.comparator;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.comparator.CommandComparator;
import com.tbit.tbitblesdk.protocol.Packet;

public class SequenceIdComparator implements CommandComparator {

   public boolean compare(Command command, Packet receivedPacket) {
      byte sendSequenceId = command.getSendPacket().getHeader().getSequenceId();
      byte receivedSequenceId = receivedPacket.getHeader().getSequenceId();
      return sendSequenceId == receivedSequenceId;
   }
}

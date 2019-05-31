package com.tbit.tbitblesdk.Bike.services.command.comparator;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.comparator.CommandComparator;
import com.tbit.tbitblesdk.protocol.Packet;

public class CommandInsideComparator implements CommandComparator {

   public boolean compare(Command command, Packet receivedPacket) {
      return command.compare(receivedPacket);
   }
}

package com.tbit.tbitblesdk.Bike.services.command.comparator;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.protocol.Packet;

public interface CommandComparator {

   boolean compare(Command var1, Packet var2);
}

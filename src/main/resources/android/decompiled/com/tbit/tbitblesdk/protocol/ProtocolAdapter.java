package com.tbit.tbitblesdk.protocol;

import com.tbit.tbitblesdk.Bike.services.config.ConfigDispatcher;
import com.tbit.tbitblesdk.Bike.services.config.DefaultConfigDispatcher;

public abstract class ProtocolAdapter {

   public abstract int[] getPacketCrcTable();

   public abstract char[] getAdKey();

   public abstract int getMaxAdEncryptedCount();

   public ConfigDispatcher getConfigDispatcher() {
      return new DefaultConfigDispatcher();
   }
}

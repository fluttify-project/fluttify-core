package com.tbit.tbitblesdk.Bike.services.config;

import com.tbit.tbitblesdk.Bike.services.command.comparator.CommandComparator;
import com.tbit.tbitblesdk.Bike.services.command.comparator.CommandInsideComparator;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.services.config.Uuid;
import com.tbit.tbitblesdk.Bike.services.resolver.BeforeW207Resolver;
import com.tbit.tbitblesdk.Bike.services.resolver.Resolver;
import java.util.UUID;

public class Config_205B implements BikeConfig {

   private Uuid uuid = new Uuid();
   private CommandComparator commandComparator;
   private Resolver resolver;


   public Config_205B() {
      this.uuid.SPS_SERVICE_UUID = UUID.fromString("0783b03e-8535-b5a0-7140-a304d2495cb7");
      this.uuid.SPS_TX_UUID = UUID.fromString("0783b03e-8535-b5a0-7140-a304d2495cb8");
      this.uuid.SPS_RX_UUID = UUID.fromString("0783b03e-8535-b5a0-7140-a304d2495cba");
      this.uuid.SPS_NOTIFY_DESCRIPTOR = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
      this.uuid.SPS_CTRL_UUID = UUID.fromString("0783b03e-8535-b5a0-7140-a304d2495cb9");
      this.commandComparator = new CommandInsideComparator();
      this.resolver = new BeforeW207Resolver();
   }

   public Uuid getUuid() {
      return this.uuid;
   }

   public CommandComparator getComparator() {
      return this.commandComparator;
   }

   public Resolver getResolver() {
      return this.resolver;
   }
}

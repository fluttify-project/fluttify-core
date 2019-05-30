package com.tbit.tbitblesdk.Bike.services.config;

import com.tbit.tbitblesdk.Bike.services.command.comparator.CommandComparator;
import com.tbit.tbitblesdk.Bike.services.config.Uuid;
import com.tbit.tbitblesdk.Bike.services.resolver.Resolver;

public interface BikeConfig {

   Uuid getUuid();

   CommandComparator getComparator();

   Resolver getResolver();
}

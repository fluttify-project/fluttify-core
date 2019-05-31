package com.tbit.tbitblesdk.Bike.tasks;

import com.tbit.tbitblesdk.Bike.model.ManufacturerAd;
import com.tbit.tbitblesdk.Bike.model.ParsedAd;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.tasks.exceptions.ResultCodeThrowable;
import com.tbit.tbitblesdk.protocol.ProtocolInfo;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class ResolveAdObservable implements ObservableOnSubscribe {

   private byte[] originData;


   public ResolveAdObservable(byte[] originData) {
      this.originData = originData;
   }

   public void subscribe(@NonNull ObservableEmitter e) throws Exception {
      try {
         ParsedAd e1 = ParsedAd.parseData(this.originData);
         byte[] data = e1.getManufacturer();
         ManufacturerAd manufacturerAd = ManufacturerAd.resolveManufacturerAd(data);
         BikeConfig bikeConfig = ProtocolInfo.configDispatcher.dispatch(manufacturerAd);
         e.onNext(bikeConfig);
      } catch (Exception var6) {
         e.onError(new ResultCodeThrowable("ResolveAdObservable: " + var6.getMessage(), -2004));
      }

   }
}

package com.tbit.tbitblesdk.Bike.tasks;

import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.services.config.Uuid;
import com.tbit.tbitblesdk.Bike.tasks.exceptions.ResultCodeThrowable;
import com.tbit.tbitblesdk.Bike.util.BikeUtil;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.request.BleResponse;
import com.tbit.tbitblesdk.bluetooth.request.NotifyRequest;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class SetNotificationObservable implements ObservableOnSubscribe {

   private BikeConfig bikeConfig;
   private RequestDispatcher requestDispatcher;


   public SetNotificationObservable(RequestDispatcher requestDispatcher, BikeConfig bikeConfig) {
      this.bikeConfig = bikeConfig;
      this.requestDispatcher = requestDispatcher;
   }

   public void subscribe(@NonNull final ObservableEmitter e) throws Exception {
      Uuid uuid = this.bikeConfig.getUuid();
      this.requestDispatcher.addRequest(new NotifyRequest(new BleResponse() {
         public void onResponse(int resultCode) {
            if(resultCode == 0) {
               e.onNext(SetNotificationObservable.this.bikeConfig);
            } else {
               int parsedResult = BikeUtil.parseResultCode(resultCode);
               e.onError(new ResultCodeThrowable("SetNotificationObservable: " + resultCode, parsedResult));
            }

         }
      }, uuid.SPS_SERVICE_UUID, uuid.SPS_TX_UUID, uuid.SPS_NOTIFY_DESCRIPTOR, true));
   }
}

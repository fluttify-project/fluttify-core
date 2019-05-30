package com.tbit.tbitblesdk.Bike.tasks;

import com.tbit.tbitblesdk.Bike.tasks.exceptions.ResultCodeThrowable;
import com.tbit.tbitblesdk.Bike.util.BikeUtil;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.model.SearchResult;
import com.tbit.tbitblesdk.bluetooth.request.BleResponse;
import com.tbit.tbitblesdk.bluetooth.request.ConnectRequest;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;

public class ConnectObservable implements ObservableOnSubscribe {

   private RequestDispatcher requestDispatcher;
   private SearchResult searchResult;


   public ConnectObservable(RequestDispatcher requestDispatcher, SearchResult searchResult) {
      this.requestDispatcher = requestDispatcher;
      this.searchResult = searchResult;
   }

   public void subscribe(@NonNull final ObservableEmitter e) throws Exception {
      this.requestDispatcher.addRequest(new ConnectRequest(this.searchResult.getDevice(), new BleResponse() {
         public void onResponse(int resultCode) {
            if(resultCode == 0) {
               e.onNext(ConnectObservable.this.searchResult);
               e.onComplete();
            } else {
               int parsedResult = BikeUtil.parseResultCode(resultCode);
               e.onError(new ResultCodeThrowable("ConnectObservable：errCode: " + resultCode, parsedResult));
            }

         }
      }, 3));
   }
}

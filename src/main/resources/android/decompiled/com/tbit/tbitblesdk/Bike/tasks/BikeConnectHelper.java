package com.tbit.tbitblesdk.Bike.tasks;

import android.text.TextUtils;
import com.tbit.tbitblesdk.Bike.TbitBle;
import com.tbit.tbitblesdk.Bike.services.BikeService;
import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.config.BikeConfig;
import com.tbit.tbitblesdk.Bike.tasks.ConnectObservable;
import com.tbit.tbitblesdk.Bike.tasks.ResolveAdObservable;
import com.tbit.tbitblesdk.Bike.tasks.SearchObservable;
import com.tbit.tbitblesdk.Bike.tasks.SetNotificationObservable;
import com.tbit.tbitblesdk.Bike.tasks.exceptions.ResultCodeThrowable;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.bluetooth.model.SearchResult;
import com.tbit.tbitblesdk.bluetooth.scanner.Scanner;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class BikeConnectHelper {

   private static final String TAG = "BikeConnectHelper";
   private static final int STATE_CONNECT = 0;
   private static final int STATE_DISCONNECT = 1;
   private int state;
   private BikeService bikeService;
   private Scanner scanner;
   private RequestDispatcher requestDispatcher;
   private CompositeDisposable compositeDisposable;
   private String lastConnectedDeviceId;
   private int lastConnectedType;


   public BikeConnectHelper(BikeService bikeService, Scanner scanner, RequestDispatcher requestDispatcher) {
      this.bikeService = bikeService;
      this.scanner = scanner;
      this.requestDispatcher = requestDispatcher;
      this.compositeDisposable = new CompositeDisposable();
   }

   public void connect(final String deviceId, final int connectType, final ResultCallback resultCallback, final Command command) {
      if(TbitBle.isConnected() && TextUtils.equals(this.lastConnectedDeviceId, deviceId) && this.lastConnectedType == connectType) {
         resultCallback.onResult(0);
      } else {
         this.lastConnectedDeviceId = null;
         this.lastConnectedType = -1;
         command.addResultCallback(new ResultCallback() {
            public void onResult(int resultCode) {
               if(resultCode == 0) {
                  BikeConnectHelper.this.lastConnectedDeviceId = deviceId;
                  BikeConnectHelper.this.lastConnectedType = connectType;
               } else {
                  TbitBle.disConnect();
               }

            }
         });
         TbitBle.disConnect();
         this.state = 0;
         Observable.create(new SearchObservable(deviceId, this.scanner)).flatMap(new Function() {
            public ObservableSource apply(@NonNull SearchResult searchResult) throws Exception {
               return Observable.create(new ConnectObservable(BikeConnectHelper.this.requestDispatcher, searchResult));
            }
         }).flatMap(new Function() {
            public ObservableSource apply(@NonNull SearchResult searchResult) throws Exception {
               return Observable.create(new ResolveAdObservable(searchResult.getBroadcastData()));
            }
         }).flatMap(new Function() {
            public ObservableSource apply(@NonNull BikeConfig bikeConfig) throws Exception {
               return Observable.create(new SetNotificationObservable(BikeConnectHelper.this.requestDispatcher, bikeConfig));
            }
         }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            public void accept(@NonNull BikeConfig bikeConfig) throws Exception {
               if(BikeConnectHelper.this.state != 1) {
                  BikeConnectHelper.this.bikeService.setBikeConfig(bikeConfig);
                  BikeConnectHelper.this.bikeService.addCommand(command);
               }
            }
         }, new Consumer() {
            public void accept(@NonNull Throwable throwable) throws Exception {
               if(BikeConnectHelper.this.state != 1) {
                  if(throwable instanceof ResultCodeThrowable) {
                     resultCallback.onResult(((ResultCodeThrowable)throwable).getResultCode());
                  } else {
                     throwable.printStackTrace();
                     resultCallback.onResult(-1);
                  }

                  BleLog.log("BikeConnectHelper", throwable.getMessage());
               }
            }
         }, new Action() {
            public void run() throws Exception {}
         }, new Consumer() {
            public void accept(@NonNull Disposable disposable) throws Exception {
               BikeConnectHelper.this.compositeDisposable.add(disposable);
            }
         });
      }
   }

   public void disConnect() {
      if(this.scanner.isScanning()) {
         this.scanner.stop();
      }

      this.state = 1;
   }

   public void destroy() {
      if(this.scanner.isScanning()) {
         this.scanner.stop();
      }

      this.compositeDisposable.dispose();
   }
}

package com.tbit.tbitblesdk.bluetooth;

import com.tbit.tbitblesdk.bluetooth.IBleClient;
import com.tbit.tbitblesdk.bluetooth.IRequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.request.BleRequest;
import java.util.LinkedList;
import java.util.List;

public class RequestDispatcher implements IRequestDispatcher {

   private IBleClient bleClient;
   private List bleRequests;
   private BleRequest curRequest;


   public RequestDispatcher(IBleClient bleClient) {
      this.bleClient = bleClient;
      this.bleRequests = new LinkedList();
   }

   public void addRequest(BleRequest bleRequest) {
      bleRequest.setBleClient(this.bleClient);
      bleRequest.setRequestDispatcher(this);
      this.bleRequests.add(bleRequest);
      this.notifyNextRequest();
   }

   private void notifyNextRequest() {
      if(this.bleRequests.size() != 0) {
         if(this.curRequest == null || this.curRequest.isFinished()) {
            this.curRequest = (BleRequest)this.bleRequests.remove(0);
            this.curRequest.process();
         }
      }
   }

   public void onRequestFinished(BleRequest request) {
      this.notifyNextRequest();
   }
}

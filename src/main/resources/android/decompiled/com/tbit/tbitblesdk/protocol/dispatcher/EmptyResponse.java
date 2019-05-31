package com.tbit.tbitblesdk.protocol.dispatcher;

import com.tbit.tbitblesdk.bluetooth.request.BleResponse;

public class EmptyResponse implements BleResponse {

   public void onResponse(int resultCode) {}
}

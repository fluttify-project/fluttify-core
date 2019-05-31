package com.tbit.tbitblesdk.bluetooth.request;

import com.tbit.tbitblesdk.bluetooth.request.BleResponse;

public interface RssiResponse extends BleResponse {

   void onRssi(int var1);
}

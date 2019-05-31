package com.tbit.tbitblesdk.bluetooth.scanner;

import com.tbit.tbitblesdk.bluetooth.scanner.ScannerCallback;

public interface Scanner {

   void start(ScannerCallback var1, long var2);

   void stop();

   boolean isScanning();
}

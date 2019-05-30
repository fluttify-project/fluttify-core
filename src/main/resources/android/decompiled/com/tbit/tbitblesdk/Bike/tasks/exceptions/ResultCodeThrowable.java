package com.tbit.tbitblesdk.Bike.tasks.exceptions;


public class ResultCodeThrowable extends Throwable {

   private int resultCode;


   public ResultCodeThrowable(String message, int resultCode) {
      super(message);
      this.resultCode = resultCode;
   }

   public int getResultCode() {
      return this.resultCode;
   }
}

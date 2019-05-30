package com.tbit.tbitblesdk.Bike.util.proxy;

import java.lang.reflect.Method;

public class ProxyBulk {

   private Object object;
   private Method method;
   private Object[] args;


   public ProxyBulk(Object object, Method method, Object[] args) {
      this.object = object;
      this.method = method;
      this.args = args;
   }

   public Object safeInvoke() {
      Object result = null;

      try {
         result = this.method.invoke(this.object, this.args);
      } catch (Throwable var3) {
         var3.printStackTrace();
      }

      return result;
   }
}

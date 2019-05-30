package com.tbit.tbitblesdk.Bike.util.proxy;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Handler.Callback;
import com.tbit.tbitblesdk.Bike.util.proxy.ProxyBulk;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler, Callback {

   private Object subject;
   private Handler handler;


   public ProxyInvocationHandler(Object subject) {
      this.subject = subject;
      this.handler = new Handler(Looper.getMainLooper(), this);
   }

   public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      ProxyBulk proxyBulk = new ProxyBulk(this.subject, method, args);
      this.handler.obtainMessage(0, proxyBulk);
      return null;
   }

   public boolean handleMessage(Message msg) {
      ((ProxyBulk)msg.obj).safeInvoke();
      return true;
   }
}

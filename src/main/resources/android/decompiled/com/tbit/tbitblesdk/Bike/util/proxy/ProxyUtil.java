package com.tbit.tbitblesdk.Bike.util.proxy;

import com.tbit.tbitblesdk.Bike.util.proxy.ProxyInvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtil {

   public static Object getProxy(Object object) {
      return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new ProxyInvocationHandler(object));
   }
}

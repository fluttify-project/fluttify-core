package com.tbit.tbitblesdk.Bike.services.command.callback;

import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.PacketCallback;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.List;

public class SimpleCommonCallback implements ResultCallback, PacketCallback {

   private ResultCallback resultCallback;


   public SimpleCommonCallback(ResultCallback resultCallback) {
      this.resultCallback = resultCallback;
   }

   public void onPacketReceived(Packet packet) {
      try {
         PacketValue e = packet.getPacketValue();
         List resolvedData = e.getData();
         Byte[] value = ((PacketValue.DataBean)resolvedData.get(0)).value;
         switch(value[0].byteValue()) {
         case 0:
            this.response(0);
            break;
         case 1:
            this.response(-3001);
            break;
         case 2:
            this.response(-3002);
            break;
         case 3:
            this.response(-3003);
            break;
         default:
            this.response(-1);
         }
      } catch (Exception var5) {
         this.response(-1);
         var5.printStackTrace();
      }

   }

   public void onResult(int resultCode) {
      if(resultCode != 0) {
         this.response(resultCode);
      }

   }

   private void response(int resultCode) {
      if(this.resultCallback != null) {
         this.resultCallback.onResult(resultCode);
      }

      this.resultCallback = null;
   }
}

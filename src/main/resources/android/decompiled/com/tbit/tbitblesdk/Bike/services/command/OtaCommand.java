package com.tbit.tbitblesdk.Bike.services.command;

import com.tbit.tbitblesdk.Bike.services.OtaService;
import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.bluetooth.debug.BleLog;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ProgressCallback;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.List;

public class OtaCommand extends Command implements ResultCallback, ProgressCallback {

   private static final String TAG = "OtaCommand";
   private static final int STATE_COMMAND = 0;
   private static final int STATE_UPDATING = 1;
   protected int timeout;
   protected OtaService otaService;
   protected ProgressCallback progressCallback;
   protected int state;


   public OtaCommand(OtaService otaService, ResultCallback resultCallback, ProgressCallback progressCallback) {
      super(resultCallback);
      this.progressCallback = progressCallback;
      this.otaService = otaService;
      this.timeout = 10000;
      this.state = 0;
   }

   protected void onResult(Packet receivedPacket) {
      PacketValue packetValue = receivedPacket.getPacketValue();
      List resolvedData = packetValue.getData();
      PacketValue.DataBean bean = (PacketValue.DataBean)resolvedData.get(0);
      Byte[] data = bean.value;
      byte dataOne = data[0].byteValue();
      byte dataTwo = data[1].byteValue();
      if(dataOne == 0) {
         BleLog.log("OtaCommand", "--进入ota模式成功");
         this.state = 0;
         this.handler.removeCallbacksAndMessages((Object)null);
         this.timeout = 120000;
         this.startTiming();
         this.otaService.update(this, this);
      } else if(dataOne == 1) {
         if(dataTwo == 1) {
            this.response(-4002);
            BleLog.log("OtaCommand", "--进入ota模式失败，电池电量过低");
         } else if(dataTwo == 2) {
            BleLog.log("OtaCommand", "--进入ota模式失败，密钥错误");
            this.response(-4005);
         } else {
            BleLog.log("OtaCommand", "--进入ota模式失败，发生未知错误");
            this.response(-4003);
         }
      }

   }

   protected void onFinish() {
      if(this.state == 1) {
         this.otaService.destroy();
      }

      super.onFinish();
   }

   protected int getTimeout() {
      return this.timeout;
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)1, (byte)1, (Byte[])null);
   }

   public boolean compare(Packet receivedPacket) {
      return PacketUtil.compareCommandId(receivedPacket, this.getSendPacket()) && PacketUtil.checkPacketValueContainKey(receivedPacket, 2);
   }

   public void onProgress(final int progress) {
      if(this.progressCallback != null) {
         this.handler.post(new Runnable() {
            public void run() {
               OtaCommand.this.progressCallback.onProgress(progress);
            }
         });
      }

   }

   public void onResult(int resultCode) {
      this.response(resultCode);
   }
}

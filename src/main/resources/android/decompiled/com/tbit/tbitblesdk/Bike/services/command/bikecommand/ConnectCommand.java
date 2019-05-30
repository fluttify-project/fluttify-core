package com.tbit.tbitblesdk.Bike.services.command.bikecommand;

import android.util.Log;
import com.tbit.tbitblesdk.Bike.model.BikeState;
import com.tbit.tbitblesdk.Bike.services.command.bikecommand.UpdatableCommand;
import com.tbit.tbitblesdk.Bike.services.command.callback.StateCallback;
import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.PacketValue;
import com.tbit.tbitblesdk.protocol.callback.ResultCallback;
import java.util.Iterator;
import java.util.List;

public class ConnectCommand extends UpdatableCommand {

   private Byte[] key;


   public ConnectCommand(ResultCallback resultCallback, StateCallback stateCallback, Byte[] key, BikeState bikeState) {
      super(resultCallback, stateCallback, bikeState);
      this.key = key;
   }

   protected void onResult(Packet resultPacket) {
      Log.d("ConnectCommand", "onResult: " + resultPacket.toString());
      PacketValue packetValue = resultPacket.getPacketValue();
      List resolvedData = packetValue.getData();
      short resultCode = -1;
      Iterator var5 = resolvedData.iterator();

      while(var5.hasNext()) {
         PacketValue.DataBean b = (PacketValue.DataBean)var5.next();
         int key = b.key & 255;
         Byte[] value = b.value;
         switch(key) {
         case 2:
            if(value[0].byteValue() == 1) {
               resultCode = 0;
            }
            break;
         case 129:
            this.parseVoltage(resultPacket.getHeader().getProtocolVersion(), value);
            break;
         case 130:
            switch(value[0].byteValue()) {
            case 0:
               resultCode = -8000;
               continue;
            case 1:
               resultCode = -8001;
               continue;
            case 2:
               resultCode = -8002;
               continue;
            case 3:
               resultCode = -8003;
               continue;
            default:
               resultCode = -1;
               continue;
            }
         case 131:
            this.parseDeviceFault(value);
            break;
         case 132:
            this.parseLocation(value);
            break;
         case 133:
            this.parseBaseStation(value);
            break;
         case 134:
            this.parseSignal(value);
            break;
         case 136:
            this.parseControllerState(value);
         case 255:
         }
      }

      if(resultCode == 0) {
         this.updateState();
      }

      this.response(resultCode);
   }

   protected Packet onCreateSendPacket(int sequenceId) {
      return PacketUtil.createPacket(sequenceId, (byte)2, (byte)1, this.key);
   }

   public boolean compare(Packet receivedPacket) {
      return 5 == receivedPacket.getPacketValue().getCommandId() && PacketUtil.checkPacketValueContainKey(receivedPacket, 2);
   }
}

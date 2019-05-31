package com.tbit.tbitblesdk.protocol;

import com.tbit.tbitblesdk.Bike.util.PacketUtil;
import com.tbit.tbitblesdk.bluetooth.RequestDispatcher;
import com.tbit.tbitblesdk.bluetooth.request.WriterRequest;
import com.tbit.tbitblesdk.protocol.Packet;
import com.tbit.tbitblesdk.protocol.dispatcher.EmptyResponse;
import java.util.UUID;

public class AckSender {

   private UUID serviceUuid;
   private UUID rxUuid;
   private RequestDispatcher requestDispatcher;


   public AckSender(RequestDispatcher requestDispatcher) {
      this.requestDispatcher = requestDispatcher;
   }

   public void setServiceUuid(UUID serviceUuid) {
      this.serviceUuid = serviceUuid;
   }

   public void setRxUuid(UUID rxUuid) {
      this.rxUuid = rxUuid;
   }

   public void sendACK(int sequenceId, boolean error) {
      Packet packet = PacketUtil.createAck(sequenceId, error);
      byte[] data = packet.toByteArray();
      this.requestDispatcher.addRequest(new WriterRequest(this.serviceUuid, this.rxUuid, data, false, new EmptyResponse()));
   }
}

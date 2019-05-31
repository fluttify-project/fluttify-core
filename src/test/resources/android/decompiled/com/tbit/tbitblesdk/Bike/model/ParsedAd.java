package com.tbit.tbitblesdk.Bike.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.UUID;

public class ParsedAd {

   private byte flags;
   private ArrayList uuids = new ArrayList();
   private String localName;
   private byte[] manufacturer;


   public byte[] getManufacturer() {
      return this.manufacturer;
   }

   public void setManufacturer(byte[] manufacturer) {
      this.manufacturer = manufacturer;
   }

   public byte getFlags() {
      return this.flags;
   }

   public void setFlags(byte flags) {
      this.flags = flags;
   }

   public ArrayList getUuids() {
      return this.uuids;
   }

   public void setUuids(ArrayList uuids) {
      this.uuids = uuids;
   }

   public String getLocalName() {
      return this.localName;
   }

   public void setLocalName(String localName) {
      this.localName = localName;
   }

   public static ParsedAd parseData(byte[] adv_data) {
      ParsedAd parsedAd = new ParsedAd();
      ByteBuffer buffer = ByteBuffer.wrap(adv_data).order(ByteOrder.LITTLE_ENDIAN);

      while(buffer.remaining() > 2) {
         byte length = buffer.get();
         if(length == 0) {
            break;
         }

         byte type = buffer.get();
         --length;
         label39:
         switch(type) {
         case -1:
            byte[] data = new byte[length];
            buffer.get(data, 0, length);
            parsedAd.manufacturer = data;
            length = 0;
         case 0:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         default:
            break;
         case 1:
            parsedAd.flags = buffer.get();
            --length;
            break;
         case 2:
         case 3:
         case 20:
            while(true) {
               if(length < 2) {
                  break label39;
               }

               parsedAd.uuids.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Short.valueOf(buffer.getShort())})));
               length = (byte)(length - 2);
            }
         case 4:
         case 5:
            while(true) {
               if(length < 4) {
                  break label39;
               }

               parsedAd.uuids.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(buffer.getInt())})));
               length = (byte)(length - 4);
            }
         case 6:
         case 7:
         case 21:
            while(true) {
               if(length < 16) {
                  break label39;
               }

               long var9 = buffer.getLong();
               long msb = buffer.getLong();
               parsedAd.uuids.add(new UUID(msb, var9));
               length = (byte)(length - 16);
            }
         case 8:
         case 9:
            byte[] sb = new byte[length];
            buffer.get(sb, 0, length);
            length = 0;
            parsedAd.localName = (new String(sb)).trim();
         }

         if(length > 0) {
            buffer.position(buffer.position() + length);
         }
      }

      return parsedAd;
   }
}

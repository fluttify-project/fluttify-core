package com.tbit.tbitblesdk.Bike;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OtaFile {

   private static String filesDir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Suota";
   private static final int fileChunkSize = 20;
   private InputStream inputStream;
   private byte crc;
   private byte[] bytes;
   private byte[][][] blocks;
   private int fileBlockSize = 0;
   private int bytesAvailable;
   private int numberOfBlocks = -1;
   private int chunksPerBlockCount;
   private int totalChunkCount;


   private OtaFile(InputStream inputStream) throws IOException {
      this.inputStream = inputStream;
      this.bytesAvailable = this.inputStream.available();
      this.bytes = new byte[this.bytesAvailable + 1];
      this.inputStream.read(this.bytes);
      this.crc = this.getCrc();
      this.bytes[this.bytesAvailable] = this.crc;
   }

   public int getFileBlockSize() {
      return this.fileBlockSize;
   }

   public int getNumberOfBytes() {
      return this.bytes.length;
   }

   public void setFileBlockSize(int fileBlockSize) {
      this.fileBlockSize = fileBlockSize;
      this.chunksPerBlockCount = (int)Math.ceil((double)fileBlockSize / 20.0D);
      this.numberOfBlocks = (int)Math.ceil((double)this.bytes.length / (double)this.fileBlockSize);
      this.initBlocks();
   }

   private void initBlocksSuota() {
      int totalChunkCounter = 0;
      this.blocks = new byte[this.numberOfBlocks][][];
      int byteOffset = 0;

      for(int i = 0; i < this.numberOfBlocks; ++i) {
         int blockSize = this.fileBlockSize;
         if(i + 1 == this.numberOfBlocks) {
            blockSize = this.bytes.length % this.fileBlockSize;
         }

         int numberOfChunksInBlock = (int)Math.ceil((double)blockSize / 20.0D);
         int chunkNumber = 0;
         this.blocks[i] = new byte[numberOfChunksInBlock][];

         for(int j = 0; j < blockSize; j += 20) {
            int chunkSize = 20;
            if(byteOffset + 20 > this.bytes.length) {
               chunkSize = this.bytes.length - byteOffset;
            } else if(j + 20 > blockSize) {
               chunkSize = this.fileBlockSize % 20;
            }

            byte[] chunk = Arrays.copyOfRange(this.bytes, byteOffset, byteOffset + chunkSize);
            this.blocks[i][chunkNumber] = chunk;
            byteOffset += chunkSize;
            ++chunkNumber;
            ++totalChunkCounter;
         }
      }

      this.totalChunkCount = totalChunkCounter;
   }

   private void initBlocks() {
      this.initBlocksSuota();
   }

   public byte[][] getBlock(int index) {
      return this.blocks[index];
   }

   public void close() {
      if(this.inputStream != null) {
         try {
            this.inputStream.close();
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

   }

   public int getNumberOfBlocks() {
      return this.numberOfBlocks;
   }

   public int getChunksPerBlockCount() {
      return this.chunksPerBlockCount;
   }

   public int getTotalChunkCount() {
      return this.totalChunkCount;
   }

   private byte getCrc() throws IOException {
      byte crc_code = 0;

      for(int i = 0; i < this.bytesAvailable; ++i) {
         Byte byteValue = Byte.valueOf(this.bytes[i]);
         int intVal = byteValue.intValue();
         crc_code = (byte)(crc_code ^ intVal);
      }

      Log.d("crc", String.format("Fimware CRC: %#04x", new Object[]{Integer.valueOf(crc_code & 255)}));
      return crc_code;
   }

   public static OtaFile getByFileName(String filename) throws IOException {
      FileInputStream is = new FileInputStream(filesDir + "/" + filename);
      return new OtaFile(is);
   }

   public static OtaFile getByFile(File file) throws IOException {
      FileInputStream is = new FileInputStream(file);
      return new OtaFile(is);
   }

   public static Map list() {
      File f = new File(filesDir);
      File[] file = f.listFiles();
      Log.d("Files", "Size: " + file.length);
      HashMap map = new HashMap();

      for(int i = 0; i < file.length; ++i) {
         Log.d("Files", "FileName:" + file[i].getName());
         map.put(file[i].getName(), file[i].getName());
      }

      return map;
   }

   public static void createFileDirectories(Context c) {
      String directoryName = filesDir;
      File directory = new File(directoryName);
      directory.mkdirs();
   }

}

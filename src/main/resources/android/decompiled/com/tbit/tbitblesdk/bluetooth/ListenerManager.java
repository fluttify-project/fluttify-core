package com.tbit.tbitblesdk.bluetooth;

import com.tbit.tbitblesdk.bluetooth.listener.ChangeCharacterListener;
import com.tbit.tbitblesdk.bluetooth.listener.ConnectStateChangeListener;
import com.tbit.tbitblesdk.bluetooth.listener.ReadCharacterListener;
import com.tbit.tbitblesdk.bluetooth.listener.ReadDescriptorListener;
import com.tbit.tbitblesdk.bluetooth.listener.ReadRssiListener;
import com.tbit.tbitblesdk.bluetooth.listener.ServiceDiscoverListener;
import com.tbit.tbitblesdk.bluetooth.listener.WriteCharacterListener;
import com.tbit.tbitblesdk.bluetooth.listener.WriteDescriptorListener;
import java.util.LinkedList;
import java.util.List;

public class ListenerManager {

   public List connectStateChangeListeners = new LinkedList();
   public List changeCharacterListeners = new LinkedList();
   public List writeCharacterListeners = new LinkedList();
   public List writeDescriptorListeners = new LinkedList();
   public List readCharacterListeners = new LinkedList();
   public List readDescriptorListeners = new LinkedList();
   public List serviceDiscoverListeners = new LinkedList();
   public List readRssiListeners = new LinkedList();


   public void addReadRssiListener(ReadRssiListener readRssiListener) {
      this.readRssiListeners.add(readRssiListener);
   }

   public void removeReadRssiListener(ReadRssiListener readRssiListener) {
      this.readRssiListeners.remove(readRssiListener);
   }

   public void addServiceDiscoverListener(ServiceDiscoverListener serviceDiscoverListener) {
      this.serviceDiscoverListeners.add(serviceDiscoverListener);
   }

   public void removeServiceDiscoverListener(ServiceDiscoverListener serviceDiscoverListener) {
      this.serviceDiscoverListeners.remove(serviceDiscoverListener);
   }

   public void addChangeCharacterListener(ChangeCharacterListener changeCharacterListener) {
      this.changeCharacterListeners.add(changeCharacterListener);
   }

   public void addConnectStateChangeListener(ConnectStateChangeListener connectStateChangeListener) {
      this.connectStateChangeListeners.add(connectStateChangeListener);
   }

   public void removeChangeCharacterListener(ChangeCharacterListener changeCharacterListener) {
      this.changeCharacterListeners.remove(changeCharacterListener);
   }

   public void removeConnectStateChangeListener(ConnectStateChangeListener connectStateChangeListener) {
      this.connectStateChangeListeners.remove(connectStateChangeListener);
   }

   public void addWriteCharacterListener(WriteCharacterListener writeCharacterListener) {
      this.writeCharacterListeners.add(writeCharacterListener);
   }

   public void removeWriteCharacterListener(WriteCharacterListener writeCharacterListener) {
      this.writeCharacterListeners.remove(writeCharacterListener);
   }

   public void addReadCharacterListener(ReadCharacterListener readCharacterListener) {
      this.readCharacterListeners.add(readCharacterListener);
   }

   public void removeReadCharacterListener(ReadCharacterListener readCharacterListener) {
      this.readCharacterListeners.remove(readCharacterListener);
   }

   public void addReadDescriptorListener(ReadDescriptorListener readDescriptorListener) {
      this.readDescriptorListeners.add(readDescriptorListener);
   }

   public void removeReadDescriptorListener(ReadDescriptorListener readDescriptorListener) {
      this.readDescriptorListeners.remove(readDescriptorListener);
   }

   public void addWriteDescriptorListener(WriteDescriptorListener writeDescriptorListener) {
      this.writeDescriptorListeners.add(writeDescriptorListener);
   }

   public void removeWriteDescriptorListener(WriteDescriptorListener writeDescriptorListener) {
      this.writeDescriptorListeners.remove(writeDescriptorListener);
   }

   public void removeAll() {
      this.readRssiListeners.clear();
      this.serviceDiscoverListeners.clear();
      this.writeCharacterListeners.clear();
      this.writeDescriptorListeners.clear();
      this.readCharacterListeners.clear();
      this.readDescriptorListeners.clear();
      this.connectStateChangeListeners.clear();
      this.changeCharacterListeners.clear();
   }
}

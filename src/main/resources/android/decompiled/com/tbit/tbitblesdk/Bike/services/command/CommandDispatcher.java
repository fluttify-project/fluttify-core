package com.tbit.tbitblesdk.Bike.services.command;

import com.tbit.tbitblesdk.Bike.services.command.Command;
import com.tbit.tbitblesdk.Bike.services.command.CommandHolder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommandDispatcher implements CommandHolder {

   private Command currentCommand;
   private List commandList = new LinkedList();


   public void addCommand(Command command) {
      this.commandList.add(command);
      this.notifyCommandAdded();
   }

   private void notifyCommandAdded() {
      if(this.currentCommand == null || this.currentCommand.getState() == 2) {
         if(this.commandList.size() != 0) {
            Command nextCommand = (Command)this.commandList.remove(0);
            this.executeCommand(nextCommand);
         }
      }
   }

   private void executeCommand(Command command) {
      this.currentCommand = command;
      command.process(this);
   }

   public Command getCurrentCommand() {
      return this.currentCommand;
   }

   public void onCommandCompleted() {
      this.notifyCommandAdded();
   }

   public void destroy() {
      this.cancelAll();
   }

   public void cancelAll() {
      if(this.currentCommand != null) {
         this.currentCommand.cancel();
         this.currentCommand = null;
      }

      Iterator var1 = this.commandList.iterator();

      while(var1.hasNext()) {
         Command command = (Command)var1.next();
         command.cancel();
      }

      this.commandList.clear();
   }
}

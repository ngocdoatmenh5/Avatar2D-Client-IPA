package avt;

import java.io.IOException;

public class IService {
   private ISession sender = Session_ME.a();
   protected Message m;

   protected final void writeInt(int var1) {
      try {
         this.m.writer().writeInt(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   protected final void writeByte(int var1) {
      try {
         this.m.writer().writeByte(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   protected final void writeShort(int var1) {
      try {
         this.m.writer().writeShort(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void writeUTF(String var1) {
      try {
         this.m.writer().writeUTF(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void sendMessage() {
      this.sender.sendMessage(this.m);
      this.m.cleanup();
   }

   public final void createMessage(byte var1) {
      this.m = new Message(var1);
   }
}

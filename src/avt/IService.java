package avt;

import java.io.IOException;

public class IService {
   private ISession a = Session_ME.a();
   protected Message b;

   protected final void n(int var1) {
      try {
         this.b.c().writeInt(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   protected final void o(int var1) {
      try {
         this.b.c().writeByte(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   protected final void p(int var1) {
      try {
         this.b.c().writeShort(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void c(String var1) {
      try {
         this.b.c().writeUTF(var1);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void k() {
      this.a.sendMessage(this.b);
      this.b.d();
   }

   public final void e(byte var1) {
      this.b = new Message(var1);
   }
}

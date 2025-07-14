package avt;

import java.io.IOException;
import java.util.Vector;

final class Session_ME2 implements Runnable {
   private final Vector a;
   private Session_ME b;

   public Session_ME2(Session_ME var1) {
      this.b = var1;
      this.a = new Vector();
   }

   public final void a(Message var1) {
      this.a.addElement(var1);
   }

   public final void run() {
       while(this.b.c) {
          if (this.b.h) {
             while(this.a.size() > 0) {
                Message var1 = (Message)this.a.elementAt(0);
                this.a.removeElementAt(0);
                Session_ME.a(this.b, var1);
             }
          }

          try {
             Thread.sleep(10L);
          } catch (InterruptedException var2) {
          }
       }

   }

   static Vector a(Session_ME2 var0) {
      return var0.a;
   }
}

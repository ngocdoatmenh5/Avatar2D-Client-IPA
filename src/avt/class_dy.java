package avt;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class class_dy implements Runnable {
   private final String b;
   final Session_ME a;

   class_dy(Session_ME var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      Session_ME.l = false;
      (new Thread(new class_kh(this))).start();
      this.a.d = true;
      this.a.c = true;

      try {
         String var2 = this.b;
         Session_ME.a(this.a, (SocketConnection)Connector.open(var2));
         Session_ME.a(this.a, Session_ME.a(this.a).openDataOutputStream());
         this.a.a = Session_ME.a(this.a).openDataInputStream();
         (new Thread(Session_ME.b(this.a))).start();
         this.a.e = new Thread(new class_gv(this.a));
         this.a.e.start();
         this.a.j = System.currentTimeMillis();
         Session_ME.a(this.a, new Message((byte)-27));
         this.a.d = false;
      } catch (Exception var4) {
         var4.printStackTrace();

         try {
            Thread.sleep(500L);
         } catch (InterruptedException var3) {
         }

         if (!Session_ME.l) {
            if (this.a.b != null) {
               this.a.c();
               this.a.b.onConnectionFail();
            }

         }
      }
   }
}

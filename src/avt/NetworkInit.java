package avt;

import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;

final class NetworkInit implements Runnable {
   private final String b;
   final Session_ME a;

   NetworkInit(Session_ME var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void run() {
      Session_ME.l = false;
      (new Thread(new class_kh(this))).start();
      this.a.connecting = true;
      this.a.connected = true;

      try {
         String var2 = this.b;
         Session_ME.setSc(this.a, (SocketConnection)Connector.open(var2));
         Session_ME.setDos(this.a, Session_ME.setSc(this.a).openDataOutputStream());
         this.a.dis = Session_ME.setSc(this.a).openDataInputStream();
         (new Thread(Session_ME.getSender(this.a))).start();
         this.a.sendThread = new Thread(new class_gv(this.a));
         this.a.sendThread.start();
         this.a.j = System.currentTimeMillis();
         Session_ME.sendMes(this.a, new Message((byte)-27));
         this.a.connecting = false;
      } catch (Exception var4) {
         var4.printStackTrace();

         try {
            Thread.sleep(500L);
         } catch (InterruptedException var3) {
         }

         if (!Session_ME.l) {
            if (this.a.messageHandler != null) {
               this.a.close();
               this.a.messageHandler.onConnectionFail();
            }

         }
      }
   }
}

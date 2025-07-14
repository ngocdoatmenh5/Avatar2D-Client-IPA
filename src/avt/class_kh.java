package avt;

final class class_kh implements Runnable {
   private class_dy a;

   class_kh(class_dy var1) {
      this.a = var1;
   }

   public final void run() {
      try {
         Thread.sleep(20000L);
      } catch (InterruptedException var3) {
         System.out.println("ERROR 1111111111");
      }

      if (this.a.a.d) {
         try {
            Session_ME.a(this.a.a).close();
            Session_ME2.a(Session_ME.b(this.a.a)).removeAllElements();
         } catch (Exception var2) {
         }

         Session_ME.l = true;
         this.a.a.d = false;
         this.a.a.c = false;
         this.a.a.b.onConnectionFail();
      }

   }
}

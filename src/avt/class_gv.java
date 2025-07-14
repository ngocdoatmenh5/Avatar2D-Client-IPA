package avt;

import java.io.IOException;

final class class_gv implements Runnable {
   private Session_ME a;

   class_gv(Session_ME var1) {
      this.a = var1;
   }

   public final void run() {
      while(true) {
         try {
            if (this.a.b()) {
               class_gv var1 = this;
               byte var2 = this.a.a.readByte();
               if (this.a.h) {
                  var2 = Session_ME.a(this.a, var2);
               }

               int var3;
               int var5;
               if (this.a.h) {
                  byte var4 = this.a.a.readByte();
                  var5 = this.a.a.readByte();
                  var3 = (Session_ME.a(this.a, var4) & 255) << 8 | Session_ME.a(this.a, (byte)var5) & 255;
               } else {
                  var3 = this.a.a.readUnsignedShort();
               }

               byte[] var11 = new byte[var3];
               var5 = 0;
               int var6 = 0;

               int var7;
               while(var5 != -1 && var6 < var3) {
                  if ((var5 = var1.a.a.read(var11, var6, var3 - var6)) > 0) {
                     var6 += var5;
                     Session_ME var10000 = var1.a;
                     var10000.g += var6 + 5;
                     var7 = Session_ME.a().g + Session_ME.a().f;
                     var1.a.k = var7 / 1024 + "." + var7 % 1024 / 102 + "Kb";
                  }
               }

               if (var1.a.h) {
                  for(var7 = 0; var7 < var11.length; ++var7) {
                     var11[var7] = Session_ME.a(var1.a, var11[var7]);
                  }
               }

               Message var10;
               if ((var10 = new Message(var2, var11)) != null) {
                  try {
                     if (var10.a == -27) {
                        this.a(var10);
                        continue;
                     }

                     this.a.b.onMessage(var10);
                  } catch (Exception var8) {
                     var8.printStackTrace();
                  }
                  continue;
               }
            }
         } catch (Exception var9) {
         }

         if (this.a.c) {
            if (this.a.b != null) {
               if (System.currentTimeMillis() - this.a.j > 500L) {
                  this.a.b.c();
               } else {
                  this.a.b.b();
               }
            }

            if (Session_ME.a(this.a) != null) {
               Session_ME.c(this.a);
            }
         }

         return;
      }
   }

   private void a(Message var1) throws IOException {
      byte var2 = var1.reader().readByte();
      this.a.i = new byte[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.a.i[var3] = var1.reader().readByte();
      }

      for(var3 = 0; var3 < this.a.i.length - 1; ++var3) {
         byte[] var10000 = this.a.i;
         var10000[var3 + 1] ^= this.a.i[var3];
      }

      this.a.h = true;
   }
}

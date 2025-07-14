package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class class_jv extends MyScreen {
   public static class_jv a;
   private static int b = 20;
   private static Image c;

   static {
      try {
         c = Image.createImage(T1.a() + "/lg.png");
      } catch (IOException var1) {
         var1.printStackTrace();
      }
   }

   public static class_jv b() {
      return a == null ? (a = new class_jv()) : a;
   }

   public final void a() {
      OnScreen.b = false;
      b = 0;
      if (OnScreen.c != 0) {
         c = MyScreen.am;
      }

      super.a();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 50:
            b(0);
            return;
         case 51:
            b(1);
         default:
      }
   }

   public final void k() {
      if (b > 51) {
         if (OnScreen.c != 0) {
            if (OnScreen.c == 2) {
               MapScr.gI().a();
               c = null;
               OnScreen.c = 0;
               Canvas.S.g();
            }
         } else if (b == 52) {
            LoginScr.b().h();
            OptionScr.b().f();
            if (!LoginScr.u) {
               LoginScr.u = true;
               AvatarData.b("avatarSV");
               AvatarData.f();
               b(0);
            } else {
               AvatarData.f();
               LoginScr.b().e();
               if (class_ez.b() != Canvas.currentMyScreen) {
                  LoginScr.b().a();
               }

               c = null;
            }
         }
      } else if (OnScreen.c != 0 && b == 0) {
         MapScr.gI().a();
         c = null;
         OnScreen.c = 0;
         Canvas.S.g();
      }

      ++b;
   }

   private static void b(int var0) {
      Canvas.i();
      OptionScr.b().b[4] = var0;
      OptionScr.b().b(0);
      LoginScr.b().e();
      LoginScr.b().a();
      c = null;
   }

   public final void a(Graphics var1) {
      PaintPopup.a(0, 0, Canvas.m, Canvas.a.getHeight(), 0, var1);
      if (b > 1 && c != null) {
         var1.drawImage(c, Canvas.m >> 1, Canvas.n >> 1, 3);
      }

      Canvas.a(var1);
   }
}

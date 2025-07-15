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
         c = Image.createImage(T.getPath() + "/lg.png");
      } catch (IOException var1) {
         var1.printStackTrace();
      }
   }

   public static class_jv b() {
      return a == null ? (a = new class_jv()) : a;
   }

   public final void switchToMe() {
      OnScreen.isOngame = false;
      b = 0;
      if (OnScreen.c != 0) {
         c = MyScreen.am;
      }

      super.switchToMe();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 50:
            b(0);
            return;
         case 51:
            b(1);
         default:
      }
   }

   public final void update() {
      if (b > 51) {
         if (OnScreen.c != 0) {
            if (OnScreen.c == 2) {
               MapScr.gI().switchToMe();
               c = null;
               OnScreen.c = 0;
               Canvas.paint.g();
            }
         } else if (b == 52) {
            LoginScr.gI().loadLogin();
            OptionScr.gI().load();
            if (!LoginScr.isSelectedLanguage) {
               LoginScr.isSelectedLanguage = true;
               AvatarData.delErrorRms("avatarSV");
               AvatarData.f();
               b(0);
            } else {
               AvatarData.f();
               LoginScr.gI().e();
               if (ServerListScr.gI() != Canvas.currentMyScreen) {
                  LoginScr.gI().switchToMe();
               }

               c = null;
            }
         }
      } else if (OnScreen.c != 0 && b == 0) {
         MapScr.gI().switchToMe();
         c = null;
         OnScreen.c = 0;
         Canvas.paint.g();
      }

      ++b;
   }

   private static void b(int var0) {
      Canvas.startWaitDlg();
      OptionScr.gI().mapFocus[4] = var0;
      OptionScr.gI().save(0);
      LoginScr.gI().e();
      LoginScr.gI().switchToMe();
      c = null;
   }

   public final void paint(Graphics var1) {
      PaintPopup.fill(0, 0, Canvas.w, Canvas.instance.getHeight(), 0, var1);
      if (b > 1 && c != null) {
         var1.drawImage(c, Canvas.w >> 1, Canvas.h >> 1, 3);
      }

      Canvas.paintPlus(var1);
   }
}

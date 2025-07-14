package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public abstract class MyScreen extends AvMain {
   public static int al = 20;
   public static Image am;
   public static Image an;
   public static Image ao;
   public static Image ap;
   public static Image aq;
   public int ar = 0;
   public static int as = 0;
   public static int at = 20;
   public static int au;
   public static int av;
   public static final int[] aw = new int[]{4802889, 3092271};
   public static final int[] ax = new int[]{14400144, 12689526};

   public void a(int var1, boolean var2) {
      this.ar = var1;
   }

   public void a(boolean var1) {
      super.aj = var1;
   }

   public void a() {
      GameCanvas.e();
      GameCanvas.r = this;
      GameCanvas.a.setFullScreenMode(true);
   }

   public void a(Graphics var1) {
      if (GameCanvas.t == null && GameCanvas.v == null && GameCanvas.A == null && !class_im.c) {
         super.a(var1);
      } else {
         GameCanvas.c(var1);
      }

      if (!Session_ME.a().b()) {
         GameCanvas.M.a(var1, "2.5.8", GameCanvas.af.a, GameCanvas.af.b, GameCanvas.af.c);
      } else if (GameCanvas.r == class_ez.a || GameCanvas.r == MiniMap.a) {
         GameCanvas.M.a(var1, Session_ME.a().k, GameCanvas.af.a, GameCanvas.af.b, GameCanvas.af.c);
      }

      GameCanvas.S.a(var1);
   }

   public void b(Graphics var1) {
   }

   public abstract void k();

   public void d(int var1) {
   }

   public void d() {
   }

   public static void z() {
      int var0 = GameCanvas.n + GameCanvas.T;
      if (an == null) {
         an = Image.createImage(GameCanvas.m, var0);
      }

      Graphics var1 = an.getGraphics();
      if (GameCanvas.r == DiamondScr.a) {
         DiamondScr.a.c(var1);
      } else {
         if (GameCanvas.r == TLBoardScr.a || GameCanvas.r == PBoardScr.a) {
            int var2;
            if (GameCanvas.m < var0) {
               var2 = var0 / 10;
            } else {
               var2 = GameCanvas.m / 10;
            }

            for(int var3 = 0; var3 < var2; ++var3) {
               var1.setColor(6629892);
               var1.drawRect(GameCanvas.o - var3 * var2 - 1, var0 / 2 - var3 * var2, var3 * var2 << 1, var3 * var2 << 1);
               var1.setColor(13399567);
               var1.drawRect(GameCanvas.o - var3 * var2, var0 / 2 - var3 * var2 + 1, var3 * var2 << 1, var3 * var2 << 1);
            }
         }

      }
   }
}

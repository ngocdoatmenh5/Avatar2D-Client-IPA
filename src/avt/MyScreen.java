package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

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

   public void switchToMe() {
      Canvas.clearKeyPressed();
      Canvas.currentMyScreen = this;
      Canvas.instance.setFullScreenMode(true);
   }

   public void paint(Graphics var1) {
      if (Canvas.menuMain == null && Canvas.currentDialog == null && Canvas.currentFace == null && !ChatTextField.c) {
         super.paint(var1);
      } else {
         Canvas.resetTrans(var1);
      }

      if (!Session_ME.a().b()) {
         Canvas.M.a(var1, "2.5.8", Canvas.af.x, Canvas.af.y, Canvas.af.anchor);
      } else if (Canvas.currentMyScreen == class_ez.a || Canvas.currentMyScreen == MiniMap.a) {
         Canvas.M.a(var1, Session_ME.a().k, Canvas.af.x, Canvas.af.y, Canvas.af.anchor);
      }

      Canvas.paint.a(var1);
   }

   public void paintMain(Graphics var1) {
   }

   public abstract void update();

   public void keyPress(int var1) {
   }

   public void close() {
   }

   public static void repaint() {
      int var0 = Canvas.h + Canvas.hTab;
      if (an == null) {
         an = Image.createImage(Canvas.w, var0);
      }

      Graphics var1 = an.getGraphics();
      if (Canvas.currentMyScreen == DiamondScr.me_) {
         DiamondScr.me_.paintCaro(var1);
      } else {
         if (Canvas.currentMyScreen == TLBoardScr.a || Canvas.currentMyScreen == PBoardScr.a) {
            int var2;
            if (Canvas.w < var0) {
               var2 = var0 / 10;
            } else {
               var2 = Canvas.w / 10;
            }

            for(int var3 = 0; var3 < var2; ++var3) {
               var1.setColor(6629892);
               var1.drawRect(Canvas.hw - var3 * var2 - 1, var0 / 2 - var3 * var2, var3 * var2 << 1, var3 * var2 << 1);
               var1.setColor(13399567);
               var1.drawRect(Canvas.hw - var3 * var2, var0 / 2 - var3 * var2 + 1, var3 * var2 << 1, var3 * var2 << 1);
            }
         }

      }
   }
}

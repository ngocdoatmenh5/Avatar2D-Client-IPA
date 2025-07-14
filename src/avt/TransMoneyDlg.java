package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class TransMoneyDlg extends Dialog {
   private FrameImage b;
   public static TransMoneyDlg a;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int[] j;

   public static TransMoneyDlg a() {
      return a == null ? (a = new TransMoneyDlg()) : a;
   }

   public final void b() {
      TransMoneyDlg var1 = this;
      if (this.b == null) {
         try {
            var1.b = new FrameImage(Image.createImage(T.a() + "/button.png"), AvMain.hd == 2 ? 112 : 52, 16 * AvMain.hd);
         } catch (IOException var3) {
            var3.printStackTrace();
         }

         this.e = this.b.frameWidth * 3 + 30 * AvMain.hd;
         this.f = this.b.frameHeight * 3 + 60 * AvMain.hd;
         this.c = (Canvas.w - this.e) / 2;
         this.d = (Canvas.h - this.f) / 2;
         this.g = this.f / 3;
         this.h = this.e / 3;
         this.j = new int[]{100, 1000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000};
         super.center = new Command(T.O, 0, this);
         super.right = new Command(T.d, 1, this);
      }

      Canvas.currentDialog = this;
   }

   public final void commandTab(int var1) {
      switch (var1) {
         case 0:
            Canvas.startOKDlg("Bạn có chắc muốn chuyển tiền không ?", (IAction)(new class_jm(this)));
            return;
         case 1:
            Canvas.currentDialog = null;
         default:
      }
   }

   public final void update() {
   }

   public final void updateKey() {
      super.updateKey();
      if (Canvas.a(2)) {
         if (this.i / 3 > 0) {
            this.i -= 3;
         }
      } else if (Canvas.a(4)) {
         if (this.i % 3 > 0) {
            --this.i;
         }
      } else if (Canvas.a(6)) {
         if (this.i % 3 < 2) {
            ++this.i;
         }
      } else if (Canvas.a(8) && this.i / 3 < 2) {
         this.i += 3;
      }

      if (Canvas.isPointerClick) {
         for(int var1 = 0; var1 < this.j.length; ++var1) {
            if (Canvas.b(this.c + var1 % 3 * this.h, this.d + var1 / 3 * this.g, this.h, this.g)) {
               Canvas.isPointerClick = false;
               this.i = var1;
               return;
            }
         }
      }

   }

   public final void paint(Graphics var1) {
      Canvas.currentMyScreen.paintMain(var1);
      Canvas.resetTrans(var1);
      Canvas.paint.h(var1, this.c, this.d, this.e, this.f);
      var1.translate(this.c, this.d);

      for(int var2 = 0; var2 < this.j.length; ++var2) {
         this.b.drawFrame(this.i == var2 ? 1 : 0, this.h / 2 + var2 % 3 * this.h, this.g / 2 + var2 / 3 * this.g, 0, 3, var1);
         Canvas.smallFontYellow.drawString(var1, String.valueOf(this.j[var2]), this.h / 2 + var2 % 3 * this.h, this.g / 2 + var2 / 3 * this.g - AvMain.ai / 2, 2);
      }

      Canvas.resetTrans(var1);
      OnScreen.a(var1, super.left, super.center, super.right);
   }

   static int[] a(TransMoneyDlg var0) {
      return var0.j;
   }

   static int b(TransMoneyDlg var0) {
      return var0.i;
   }
}

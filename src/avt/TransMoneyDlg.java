package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

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
            var1.b = new FrameImage(Image.createImage(T1.a() + "/button.png"), AvMain.Y == 2 ? 112 : 52, 16 * AvMain.Y);
         } catch (IOException var3) {
            var3.printStackTrace();
         }

         this.e = this.b.a * 3 + 30 * AvMain.Y;
         this.f = this.b.b * 3 + 60 * AvMain.Y;
         this.c = (GameCanvas.m - this.e) / 2;
         this.d = (GameCanvas.n - this.f) / 2;
         this.g = this.f / 3;
         this.h = this.e / 3;
         this.j = new int[]{100, 1000, 10000, 50000, 100000, 500000, 1000000, 5000000, 10000000};
         super.ad = new Command(T1.O, 0, this);
         super.ae = new Command(T1.d, 1, this);
      }

      GameCanvas.v = this;
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            GameCanvas.a("Bạn có chắc muốn chuyển tiền không ?", (IAction)(new class_jm(this)));
            return;
         case 1:
            GameCanvas.v = null;
         default:
      }
   }

   public final void k() {
   }

   public final void l() {
      super.l();
      if (GameCanvas.a(2)) {
         if (this.i / 3 > 0) {
            this.i -= 3;
         }
      } else if (GameCanvas.a(4)) {
         if (this.i % 3 > 0) {
            --this.i;
         }
      } else if (GameCanvas.a(6)) {
         if (this.i % 3 < 2) {
            ++this.i;
         }
      } else if (GameCanvas.a(8) && this.i / 3 < 2) {
         this.i += 3;
      }

      if (GameCanvas.g) {
         for(int var1 = 0; var1 < this.j.length; ++var1) {
            if (GameCanvas.b(this.c + var1 % 3 * this.h, this.d + var1 / 3 * this.g, this.h, this.g)) {
               GameCanvas.g = false;
               this.i = var1;
               return;
            }
         }
      }

   }

   public final void a(Graphics var1) {
      GameCanvas.r.b(var1);
      GameCanvas.c(var1);
      GameCanvas.S.h(var1, this.c, this.d, this.e, this.f);
      var1.translate(this.c, this.d);

      for(int var2 = 0; var2 < this.j.length; ++var2) {
         this.b.a(this.i == var2 ? 1 : 0, this.h / 2 + var2 % 3 * this.h, this.g / 2 + var2 / 3 * this.g, 0, 3, var1);
         GameCanvas.Q.a(var1, String.valueOf(this.j[var2]), this.h / 2 + var2 % 3 * this.h, this.g / 2 + var2 / 3 * this.g - AvMain.ai / 2, 2);
      }

      GameCanvas.c(var1);
      OnScreen.a(var1, super.ac, super.ad, super.ae);
   }

   static int[] a(TransMoneyDlg var0) {
      return var0.j;
   }

   static int b(TransMoneyDlg var0) {
      return var0.i;
   }
}

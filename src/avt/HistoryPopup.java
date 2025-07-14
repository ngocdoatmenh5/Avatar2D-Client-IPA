package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class HistoryPopup extends Dialog {
   private short[] a;
   private String[] b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k = 0;
   private boolean l = false;
   private int m;
   private int n;
   private int o;
   private int p;

   public HistoryPopup(class_jz var1, short[] var2, String[] var3) {
      this.a = var2;
      this.b = var3;
      super.ad = new Command(T1.z, (IAction)null);
      this.d = 150 * AvMain.Y;
      this.c = 200 * AvMain.Y;
      this.c = 0;

      for(int var5 = 0; var5 < var3.length; ++var5) {
         int var4;
         if ((var4 = GameCanvas.K.a(var3[var5]) + 40 * AvMain.Y) > this.c) {
            this.c = var4;
         }
      }

      this.e = AvMain.ag + 5 * AvMain.Y;
      this.j = var2.length * this.e - (this.d - 10 * AvMain.Y);
      if (this.j < 0) {
         this.j = 0;
      }

   }

   public final void l() {
      ++this.n;
      boolean var1 = false;
      if (GameCanvas.g && GameCanvas.a((GameCanvas.m - this.c) / 2, (GameCanvas.n - this.d) / 2, this.c, this.d) && !this.l) {
         this.k = this.g;
         this.l = true;
         this.m = 0;
      }

      if (this.l) {
         int var2 = GameCanvas.l();
         if (GameCanvas.e) {
            if (GameCanvas.l % 3 == 0) {
               this.p = GameCanvas.i;
               this.o = this.n;
            }

            this.f = this.k + var2;
            this.m = 0;
            if (this.f < 0 || this.f > this.j) {
               this.f = this.k + var2 / 2;
            }

            this.g = this.f;
         }

         if (GameCanvas.f) {
            this.l = false;
            int var3 = this.n - this.o;
            int var4;
            if (CRes.f(var4 = this.p - GameCanvas.i) > 40 && var3 < 10 && this.f > 0 && this.f < this.j) {
               this.m = var4 / var3 * 10;
            }

            this.o = -1;
            if (Math.abs(var2) < 10) {
               this.f = this.k + var2;
            }
         }
      }

      if (GameCanvas.d[2]) {
         this.f -= AvMain.ag;
         var1 = true;
      } else if (GameCanvas.d[8]) {
         var1 = true;
         this.f += AvMain.ag;
      }

      if (var1) {
         if (this.f < 0) {
            this.f = 0;
         }

         if (this.f > this.j) {
            this.f = this.j;
         }
      }

      if (this.m != 0) {
         if (this.g < 0 || this.g > this.j) {
            this.m -= this.m / 4;
            this.g += this.m / 20;
            if (this.m / 10 <= 1) {
               this.m = 0;
            }
         }

         if (this.g < 0) {
            if (this.g < -this.d / 2) {
               this.g = -this.d / 2;
               this.f = 0;
               this.m = 0;
            }
         } else if (this.g > this.j) {
            if (this.g < this.j + this.d / 2) {
               this.g = this.j + this.d / 2;
               this.f = this.j;
               this.m = 0;
            }
         } else {
            this.g += this.m / 10;
         }

         this.f = this.g;
         this.m -= this.m / 10;
         if (this.m / 10 == 0) {
            this.m = 0;
         }
      } else if (this.g < 0) {
         this.f = 0;
      } else if (this.g > this.j) {
         this.f = this.j;
      }

      if (this.g != this.f) {
         this.i = this.f - this.g << 2;
         this.h += this.i;
         this.g += this.h >> 4;
         this.h &= 15;
      }

      super.l();
   }

   public final void a(Graphics var1) {
      GameCanvas.S.a(var1, (GameCanvas.m - this.c) / 2, (GameCanvas.q - this.d) / 2 - (PaintPopup.o + 3 * AvMain.Y), this.d + PaintPopup.o + 3 * AvMain.Y, this.c, 0, 0, PaintPopup.a().j, PaintPopup.a().i, PaintPopup.o, 1, 1, PaintPopup.a().n, PaintPopup.a().m, "Lịch sử");
      GameCanvas.c(var1);
      var1.translate((GameCanvas.m - this.c) / 2, (GameCanvas.q - this.d) / 2);
      var1.setClip(0, 5 * AvMain.Y, this.c, this.d - 10 * AvMain.Y);
      var1.translate(0, -this.g);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         AvatarData.a(var1, this.a[var2], 15 * AvMain.Y, 15 * AvMain.Y + var2 * this.e, 3);
         GameCanvas.K.a(var1, this.b[var2], 35 * AvMain.Y, 15 * AvMain.Y + var2 * this.e - AvMain.ag / 2, 0);
      }

      super.a(var1);
   }
}

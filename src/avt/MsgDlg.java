package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class MsgDlg extends Dialog {
   private Vector c;
   private String d = "";
   private Vector e = new Vector();
   private int f = 0;
   private int g;
   private int h;
   private int i;
   private int j;
   public boolean a = false;
   private int k = 0;
   private int l = 0;
   private int m;
   private int n;
   private int o = 0;
   private int p = 0;
   private int q;
   public static FrameImage b;
   private long r = -1L;
   private long s;
   private long t;
   private int u = 0;

   public MsgDlg() {
      this.m = AvMain.af;
   }

   public final void a(String var1, Command var2, Vector var3) {
      if (class_im.c) {
         class_im.d().a();
      }

      this.q = MyScreen.av;
      this.a = false;
      this.d = var1;
      super.ad = var2;
      this.f = 0;
      this.e = var3;
      if (var3 != null) {
         Command var4 = (Command)var3.elementAt(this.f);
         super.ad = var4;
         if (var4 != null) {
            super.ad.b = var4.b;
            super.ad.c = var4.c;
            super.ad.d = var4.d;
         }

         this.u = 0;

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            var2 = (Command)var3.elementAt(var5);
            if (GameCanvas.K.a(var2.a) > this.u) {
               this.u = GameCanvas.K.a(var2.a) + (GameCanvas.H ? this.g / 3 : 0);
            }
         }
      } else {
         this.t = System.currentTimeMillis() / 100L;
      }

      this.l = 0;
      if (this.e != null) {
         this.l = this.e.size();
      }

      this.k = 0;
      this.r = -1L;
      this.a();
      GameCanvas.v = GameCanvas.s;
   }

   public final void a() {
      this.g = GameCanvas.m - 80;
      if (GameCanvas.m < 200) {
         this.g = GameCanvas.m - 40;
         if (GameCanvas.m <= 128) {
            this.g = GameCanvas.m - 10;
         }
      }

      if (this.d.equals(T1.b)) {
         this.g = GameCanvas.o;
      }

      this.c = GameCanvas.M.b(this.d, this.g - 16);
      this.h = this.c.size() * this.m + 20;
      this.n = 0;
      if (super.ad != null) {
         this.h += this.q + 15 * AvMain.Y;
         this.n += this.q + 15 * AvMain.Y;
      }

      if (this.h < this.q * 3 + (AvMain.Y - 1) * 15) {
         this.h = this.q * 3 + (AvMain.Y - 1) * 15;
      }

      this.i = GameCanvas.o - this.g / 2;
      this.j = GameCanvas.q - GameCanvas.T - this.h - 10;
   }

   public final void a(boolean var1) {
      this.a = var1;
      this.h = this.c.size() * this.m + 20;
      if (this.a) {
         this.h += 25 * AvMain.Y + 4;
         this.n += 25 * AvMain.Y + 4;
      }

      int var2 = this.q * 3 + (AvMain.Y - 1) * 15;
      if (this.h < var2) {
         this.h = var2;
      }

      this.j = GameCanvas.q - GameCanvas.T - this.h - 10;
      this.s = (long)GameCanvas.j();
   }

   public final void a(Graphics var1) {
      GameCanvas.c(var1);
      if (System.currentTimeMillis() / 100L - this.t >= 5L) {
         GameCanvas.S.a(var1, this.i, this.j, this.g, this.h, PaintPopup.d[0], PaintPopup.d[1], 0);
         if (super.ad != null) {
            PaintPopup.a(this.i + 1, this.j + this.h - (this.q + 15 * AvMain.Y - 4), this.g - 2, this.q, 15530985, var1);
         }

         if (this.a) {
            b.a(this.k, this.i + this.g / 2, this.j + 4 + (this.h - this.n) / 2 + this.c.size() * AvMain.af / 2 + (this.h - (4 + (this.h - this.n) / 2 + this.c.size() * AvMain.af / 2)) / 2, 0, 3, var1);
         }

         if (this.l > 0) {
            Command var2 = (Command)this.e.elementAt(this.f);
            GameCanvas.K.a(var1, var2.a, GameCanvas.o, this.j + this.h - (this.q + 15 * AvMain.Y - 4) + this.q / 2 - AvMain.ah / 2, 2);
            if (this.l > 1) {
               GameCanvas.S.b(var1, GameCanvas.o - this.u / 2 - 11, (GameCanvas.Z != 2 ? AvMain.ah / 2 : 0) + this.j + this.h - (this.q + 15 * AvMain.Y - 4) + MyScreen.av / 2 + 1 + (GameCanvas.Z == 1 ? -7 : 0) + (GameCanvas.Z == 0 ? -3 : 0), 17 + this.u, this.o / 3, this.p / 3);
            }
         } else if (super.ad != null) {
            GameCanvas.K.a(var1, super.ad.a, GameCanvas.o, this.j + this.h - (this.q + 15 * AvMain.Y - 4) + this.q / 2 - AvMain.ah / 2, 2);
         }

         for(int var3 = 0; var3 < this.c.size(); ++var3) {
            GameCanvas.M.a(var1, (String)this.c.elementAt(var3), GameCanvas.o, this.j + 4 + (this.h - this.n) / 2 - this.c.size() * AvMain.af / 2 + var3 * AvMain.af, 2);
         }

      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case -2:
            MapScr.b().v();
            return;
         case -1:
            this.a = false;
            GameCanvas.v = null;
            return;
         default:
            GameCanvas.r.a(var1, var2);
      }
   }

   private void b(int var1) {
      if (this.l > 0) {
         this.f += var1;
         if (this.f < 0) {
            this.f = this.l - 1;
         }

         if (this.f >= this.l) {
            this.f = 0;
         }

         Command var2 = (Command)this.e.elementAt(this.f);
         super.ad = var2;
      }

   }

   public final void l() {
      int var2;
      if (this.a) {
         ++this.k;
         if (this.k >= 8) {
            this.k = 0;
         }

         if ((long)GameCanvas.j() - this.s > 30L) {
            String var1 = "";

            for(var2 = 0; var2 < this.c.size(); ++var2) {
               var1 = var1 + (String)this.c.elementAt(var2) + " ";
            }

            GameCanvas.b(var1, -2, (AvMain)null);
         }
      }

      if (this.r != -1L && System.currentTimeMillis() / 100L - this.r > 0L) {
         GameCanvas.b[5] = true;
      }

      if (this.o > 0) {
         --this.o;
      }

      if (this.p > 0) {
         --this.p;
      }

      if (GameCanvas.a(4)) {
         this.b(-1);
         this.o = 5;
      } else if (GameCanvas.a(6)) {
         this.b(1);
         this.p = 5;
      }

      if (GameCanvas.f) {
         label84: {
            int var3 = 0;
            if (this.e != null && this.e.size() > 0) {
               Command var4 = (Command)this.e.elementAt(this.f);
               var3 = GameCanvas.K.a(var4.a) + 20;
            } else if (super.ad != null) {
               var3 = GameCanvas.K.a(super.ad.a) + 20;
            }

            var3 *= AvMain.Y;
            if (super.ad != null && GameCanvas.a(GameCanvas.o - var3 / 2, this.j + this.h - (this.q + 18 * AvMain.Y - 4), var3, this.q)) {
               GameCanvas.h();
               this.a(super.ad);
            } else {
               if (!GameCanvas.a(this.i + 1, this.j + this.h - (this.q + 18 * AvMain.Y - 4), this.g - 2, this.q)) {
                  break label84;
               }

               if ((var2 = GameCanvas.o - GameCanvas.h) > var3 / 2) {
                  this.b(-1);
                  this.o = 5;
               } else if (var2 < -var3 / 2) {
                  this.b(1);
                  this.p = 5;
               }
            }

            GameCanvas.f = false;
         }
      }

      super.l();
   }
}

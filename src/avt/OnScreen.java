package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class OnScreen extends MyScreen {
   public static OnScreen a;
   private Command d;
   private int e = 0;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private static FrameImage l;
   private static int m;
   private static int n;
   private static int o;
   private static int p;
   private static int q;
   public static boolean b = true;
   private static boolean r;
   private static Image s;
   public static int c = 0;
   private int t = 0;
   private int u;
   private int v;
   private int w;
   private int x;
   private int y;
   private int z;
   private boolean A = false;
   private int B;
   private int C = 2;
   private int D = 0;
   private int E = -40;
   private int F = 1;

   public static void b() {
      l = null;
      s = null;
      OnSplashScr.c = null;
   }

   public static OnScreen e() {
      if (a == null) {
         a = new OnScreen();
      }

      return a;
   }

   public final void a() {
      super.ar = 2;
      GameCanvas.t = null;
      GameCanvas.h();
      if (l == null) {
         FilePack.b(T1.aw);
         FrameImage.a("up", 13 * AvMain.Y, 11 * AvMain.Y);
         FilePack.a();

         try {
            int var1 = 70 * AvMain.Y;
            if (GameCanvas.Z == 0) {
               var1 = 40;
            }

            l = new FrameImage(Image.createImage(T1.a() + "/on/iconGame0.on"), var1, var1);
            s = Image.createImage(T1.a() + "/on/select.on");
            if (OnSplashScr.c == null) {
               OnSplashScr.c = Image.createImage(T1.a() + "/on/logo.on");
            }
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

      super.a();
      this.g = GameCanvas.n / 2 - AvMain.ah;
      this.j = 4;
      this.k = 70 * AvMain.Y;
      if (GameCanvas.Z == 0) {
         this.k = 40;
      }

      this.h = GameCanvas.m / this.j;
      if (this.h > 100 * AvMain.Y) {
         this.h = 100 * AvMain.Y;
      }

      this.i = l.b + AvMain.ah + 5 * AvMain.Y;
      this.f = (GameCanvas.m - this.j * this.h) / 2 + this.h / 2;
      if ((q = this.j * this.h - GameCanvas.m) < 0) {
         q = 0;
      }

      g();
      if (GameCanvas.J == 0) {
         GameCanvas.J = 1;
      }

      r = true;
      b = true;
   }

   private static void g() {
      GameCanvas.T = MyScreen.av;
      if (GameCanvas.Z == 0) {
         GameCanvas.T = AvMain.ag + 5;
      }

      GameCanvas.n = GameCanvas.a.getHeight() - GameCanvas.T;

      for(int var0 = 0; var0 < 3; ++var0) {
         GameCanvas.ae[var0].b = GameCanvas.q - GameCanvas.T;
      }

   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            switch (this.e) {
               case 0:
               case 1:
               case 2:
               case 3:
                  var1 = this.e;
                  GameCanvas.i();
                  GlobalService.gI().d((int)3);
                  MapScr.i = (byte)var1;
                  return;
               case 4:
                  TransMoneyDlg.a().b();
               default:
                  return;
            }
         case 1:
            c = 1;
            GameCanvas.y.m = false;
            GlobalService var3;
            (var3 = GlobalService.gI()).e((byte)-96);
            var3.k();
            GameCanvas.i();
            return;
         case 2:
            GlobalService.gI().h(1);
            GameCanvas.i();
            return;
         case 3:
            this.h();
         default:
      }
   }

   public OnScreen() {
      this.d = new Command(T1.O, 0);
      super.ae = new Command(T1.x, 1);
      super.ac = new Command("Top", 2);
      if (GameCanvas.Z == 0) {
         super.ad = new Command(T1.O, 3);
      }

   }

   public final void d() {
      this.a(1, -1);
   }

   private void h() {
      r = true;
      this.d.b();
   }

   public final void k() {
      if (this.w > 0) {
         --this.w;
         if (this.w == 0 && GameCanvas.r != PopupShop.a) {
            this.h();
         }
      }

      if (this.u != 0) {
         if (n < 0 || n > q) {
            if (this.u > 500) {
               this.u = 500;
            } else if (this.u < -500) {
               this.u = -500;
            }

            this.u -= this.u / 5;
            if (CRes.f(this.u / 10) <= 10) {
               this.u = 0;
            }
         }

         m = n += this.u / 15;
         this.u -= this.u / 20;
      } else if (n < 0) {
         m = 0;
      } else if (n > q) {
         m = q;
      }

      if (n != m) {
         p = m - n << 2;
         o += p;
         n += o >> 4;
         o &= 15;
      }

      if (this.D >= 0) {
         this.E += this.F * this.D;
         this.D += this.F * this.C;
         if (this.D <= 0) {
            this.F = -this.F;
         }

         if (this.E > 0) {
            this.F = -this.F;
            this.D -= 2 * this.C;
         }
      }

   }

   public final void l() {
      ++this.x;
      if (GameCanvas.a(4)) {
         if (this.e % this.j > 0) {
            --this.e;
         }
      } else if (GameCanvas.a(6)) {
         if (this.e < l.c - 1 && this.e % this.j < this.j - 1) {
            ++this.e;
         }
      } else if (GameCanvas.a(2)) {
         if (this.e / this.j > 0) {
            this.e -= this.j;
         }
      } else if (GameCanvas.a(8) && this.e / this.j < l.c / this.j && this.e + this.j < l.c) {
         this.e += this.j;
      }

      int var1;
      if (GameCanvas.g) {
         for(var1 = 0; var1 < T1.eA.length; ++var1) {
            if (GameCanvas.b(this.f + var1 % this.j * this.h - this.k / 2, this.g + var1 / this.j * this.i - this.k / 2, this.k, this.k + AvMain.ah + 10)) {
               this.B = GameCanvas.j;
               this.y = this.x;
               this.t = n;
               this.u = 0;
               GameCanvas.g = false;
               this.A = true;
               break;
            }
         }
      }

      if (this.A) {
         var1 = this.x - this.y;
         int var2 = this.B - GameCanvas.h;
         this.B = GameCanvas.h;
         int var3;
         if (GameCanvas.e) {
            if (this.x % 2 == 0) {
               this.v = GameCanvas.h;
               this.z = this.x;
            }

            this.u = 0;
            if (m > 0 && m < q) {
               m = this.t + var2;
               this.t = m;
            } else {
               m = this.t + GameCanvas.k() / 2;
            }

            n = m;
            if (var1 < 20) {
               var2 = (m + GameCanvas.h - (this.f - this.h / 2)) / this.h;
               var3 = (GameCanvas.i - (this.g - this.h / 2)) / this.i;
               this.e = var3 * this.j + var2;
               if (this.e < 0) {
                  this.e = 0;
               }

               if (this.e >= T1.eA.length) {
                  this.e = T1.eA.length - 1;
               }
            }

            if (CRes.f(GameCanvas.l()) < 10 * AvMain.Y && CRes.f(GameCanvas.k()) < 10 * AvMain.Y) {
               if (var1 > 3 && var1 < 8) {
                  r = false;
               }
            } else {
               r = true;
            }
         }

         if (GameCanvas.f) {
            var2 = this.v - GameCanvas.h;
            var3 = this.x - this.z;
            if (CRes.f(var2) > 40 && var3 < 20 && m > 0 && m < q) {
               this.u = var2 / var3 * 10;
            }

            this.z = -1;
            if (CRes.f(GameCanvas.l()) < 10 * AvMain.Y && CRes.f(GameCanvas.k()) < 10 * AvMain.Y) {
               if (var1 <= 4) {
                  this.w = 5;
                  r = false;
               } else if (!r) {
                  this.h();
               }
            }

            this.A = false;
            GameCanvas.f = false;
         }
      }

      if (GameCanvas.Z != 0) {
         GameCanvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public final void b(Graphics var1) {
      GameCanvas.S.b(var1);
      if (GameCanvas.W != 2) {
         GameCanvas.S.a(var1, GameCanvas.o, (this.g - l.b / 2) / 2);
      }

      var1.translate(this.f, this.g);
      var1.translate(-n, 0);

      for(int var2 = 0; var2 < T1.eA.length; ++var2) {
         l.a(var2, var2 % this.j * this.h, var2 / this.j * this.i, 0, 3, var1);
         GameCanvas.M.a(var1, T1.eA[var2], var2 % this.j * this.h, var2 / this.j * this.i + l.b / 2 + 5, 2);
         if (this.e == var2 && (!GameCanvas.H || !r)) {
            var1.drawImage(s, var2 % this.j * this.h, var2 / this.j * this.i, 3);
         }
      }

   }

   public final void a(Graphics var1) {
      GameCanvas.c(var1);
      this.b(var1);
      a(var1, super.ac, super.ad, super.ae);
      GameCanvas.c(var1);
      GameCanvas.b(var1);
   }

   public static void a(Graphics var0, Command var1, Command var2, Command var3) {
      GameCanvas.c(var0);
      GameCanvas.S.c(var0);
      if (GameCanvas.t == null && (GameCanvas.v == null || GameCanvas.v == TransMoneyDlg.a)) {
         GameCanvas.S.b(var0, var1, var2, var3);
      }

   }

   public static void f() {
      if (b && OptionScr.d) {
         OptionScr.d = false;
         OptionScr.b().b[4] = 0;
         GameCanvas.a.b();
         g();
      }

   }
}

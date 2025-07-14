package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class MenuSub extends MenuMain {
   private static MenuSub i;
   private Vector j;
   private int k;
   private int l;
   public int a;
   public int b;
   public int c;
   public int d;
   private int m;
   public int e;
   public static FrameImage f;
   private boolean n = false;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u = 0;
   private static Command v;
   public static IAction g;
   public static short[] h;
   private int w;
   private int x;
   private int y = 0;
   private int z;
   private boolean A = false;
   private long B;
   private long C;
   private long D;

   public static MenuSub a() {
      return i == null ? (i = new MenuSub()) : i;
   }

   public MenuSub() {
      this.c();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.d();
            return;
         case 1:
            this.n = false;
            GameCanvas.t = null;
            if (g != null) {
               g.perform();
            }
         default:
      }
   }

   public final void c() {
      if (GameCanvas.Z == 0) {
         super.ac = new Command(T1.O, 0);
      }

      super.ae = new Command(T1.d, 1);
   }

   public final void a(Vector var1, int var2, int var3, int var4) {
      if (var1.size() != 0) {
         if (GameCanvas.Z > 0) {
            super.aj = true;
         }

         this.u = var1.size();
         this.t = GameCanvas.n;
         this.n = true;
         this.c = this.u * var3 + (AvMain.Z << 1) + 4;
         if (this.c > GameCanvas.m) {
            this.c = GameCanvas.m;
         }

         this.a = var2 - this.c / 2;
         this.d = var4 + (AvMain.Z << 1) + 4;
         if (this.a < 0) {
            this.a = 0;
         }

         this.b = GameCanvas.q - GameCanvas.T - this.d - (AvMain.Z << 1);
         this.m = this.b;
         this.e = var4;
         this.j = var1;
         this.b();
         this.s = this.u * this.e - (this.c - (AvMain.Z << 1) - 4);
         if (this.s < 0) {
            this.s = 0;
         }

         this.x = this.c;
         v = null;
         g = null;
         h = null;
         GameCanvas.t = this;
      }
   }

   private void b() {
      if (this.k < 0) {
         this.k = 0;
      }

      if (this.k >= this.u) {
         this.k = 0;
      }

   }

   public final void a(Vector var1, int var2) {
      if (var1.size() != 0) {
         if (GameCanvas.Z > 0) {
            super.aj = true;
         }

         this.e = MyScreen.av;
         h = null;
         this.t = GameCanvas.n;
         this.l = 0;
         this.j = var1;
         this.u = this.j.size();
         this.c = this.d = 0;

         for(int var4 = 0; var4 < this.u; ++var4) {
            Command var3 = (Command)this.j.elementAt(var4);
            int var5;
            if ((var5 = GameCanvas.K.a(var3.a) + 20) > this.c) {
               this.c = var5;
            }

            this.d += this.e;
         }

         if (this.c < GameCanvas.m / 3) {
            this.c = GameCanvas.m / 3;
         }

         if (this.c > GameCanvas.m - 4) {
            this.c = GameCanvas.m - 4;
         }

         this.d += 4;
         if (var2 == 0) {
            this.a = 2 * (GameCanvas.Z != 0 ? 2 : 1);
         } else if (var2 == 1) {
            this.a = GameCanvas.m - this.c - 2;
         } else {
            this.a = (GameCanvas.m >> 1) - (this.c >> 1);
         }

         if (this.u > 5) {
            this.d = MyScreen.av * 5 + 4;
         }

         this.b = GameCanvas.n - this.d - AvMain.Z - GameCanvas.T;
         if (OnScreen.b) {
            this.b = GameCanvas.q - GameCanvas.T - this.d - 5;
         }

         if (GameCanvas.n < 200) {
            this.b += 10;
         }

         this.m = GameCanvas.n - this.e;
         if (GameCanvas.Z > 0) {
            this.b = GameCanvas.q - this.d - AvMain.Z - 3;
            if (GameCanvas.Z == 1) {
               this.b -= 7;
            }

            super.ac = null;
         }

         this.n = false;
         this.k = 0;
         this.s = (this.u - 5) * this.e;
         if (this.s < 0) {
            this.s = 0;
         }

         this.o = 0;
         this.p = 0;
         v = null;
         if (GameCanvas.E) {
            GameCanvas.g();
         }

         g = null;
         this.x = this.d;
         GameCanvas.t = this;
      }
   }

   private void d() {
      this.n = false;
      GameCanvas.t = null;
      Command var1;
      if ((var1 = (Command)this.j.elementAt(this.k)).d != null) {
         var1.d.a(var1.c);
      } else if (var1.b != null) {
         var1.b.perform();
      } else {
         GameCanvas.r.d(var1.c, var1.e);
      }
   }

   public final void l() {
      super.l();
      ++this.C;
      boolean var2 = false;
      if (!GameCanvas.a(2) && !GameCanvas.a(4)) {
         if (GameCanvas.a(8) || GameCanvas.a(6)) {
            var2 = true;
            ++this.k;
            if (this.k > this.u - 1) {
               this.k = 0;
            }

            super.aj = false;
         }
      } else {
         var2 = true;
         --this.k;
         if (this.k < 0) {
            this.k = this.u - 1;
         }

         super.aj = false;
      }

      if (GameCanvas.g && GameCanvas.b(this.a - 2, this.m - 7, this.c + 4, this.d + 15)) {
         GameCanvas.g = false;
         this.y = this.p;
         this.B = System.currentTimeMillis() / 10L;
         this.A = true;
      }

      if (this.A) {
         int var3 = GameCanvas.l();
         if (this.n) {
            var3 = GameCanvas.k();
         }

         long var4 = System.currentTimeMillis() / 10L - this.B;
         int var6;
         int var7;
         if (GameCanvas.e) {
            if (GameCanvas.l % 3 == 0) {
               this.z = GameCanvas.i;
               this.D = this.C;
            }

            this.w = 0;
            if (Math.abs(var3) < 20 * AvMain.Y) {
               var6 = this.m;
               var7 = (this.o + GameCanvas.i - var6) / this.e;
               if (this.n) {
                  var6 = this.a;
                  var7 = (this.o + GameCanvas.h - var6) / this.e;
               }

               this.k = var7;
               this.b();
            }

            if (CRes.f(var3) >= 20 * AvMain.Y) {
               super.aj = true;
            } else if (var4 > 10L && var4 < 20L) {
               super.aj = false;
            }

            this.o = this.y + var3;
            if (this.o < 0 || this.o > this.s) {
               this.o = this.y + var3 / 3;
            }

            this.p = this.o;
         }

         if (GameCanvas.f && GameCanvas.b(this.a - 2, this.m - 7, this.c + 4, this.d + 15)) {
            var6 = (int)(this.C - this.D);
            if (CRes.f(var7 = this.z - GameCanvas.i) > 40 && var6 < 10 && this.o > 0 && this.o < this.s) {
               this.w = var7 / var6 * 10;
            }

            this.D = -1L;
            if (Math.abs(var3) < 20 * AvMain.Y) {
               if (var4 <= 10L) {
                  super.aj = false;
               }

               if (!super.aj) {
                  var3 = this.m;
                  var3 = (this.o + GameCanvas.i - var3) / this.e;
                  if (this.n) {
                     var3 = this.a;
                     var3 = (this.o + GameCanvas.h - var3) / this.e;
                  }

                  this.k = var3;
                  this.b();
                  this.d();
               }
            }

            GameCanvas.f = false;
         }
      }

      if (GameCanvas.f) {
         if (!this.A) {
            this.n = false;
            GameCanvas.t = null;
            if (g != null) {
               g.perform();
            }
         }

         this.A = false;
         GameCanvas.f = false;
      }

      if (var2) {
         this.o = this.k * this.e - this.c / 2 + this.e / 2;
         if (this.o > this.s) {
            this.o = this.s;
            return;
         }

         if (this.o < 0) {
            this.o = 0;
         }
      }

   }

   public final void a(Graphics var1) {
      var1.translate(0, this.t);
      int var6;
      int var8;
      if (this.n) {
         Graphics var3 = var1;
         MenuSub var2 = this;
         GameCanvas.c(var1);
         GameCanvas.S.a(var1, this.a, this.b, this.c, this.d);
         var1.translate(this.a + AvMain.Z + 2, this.b + AvMain.Z + 2);
         var1.setClip(0, 0, this.c - (AvMain.Z << 1) - 4, this.e);
         var1.translate(-this.p, 0);
         int var4;
         if ((var4 = this.p / this.e) < 0) {
            var4 = 0;
         }

         int var5;
         if ((var5 = var4 + this.c / this.e + 2) > this.u) {
            var5 = this.u;
         }

         if (!super.aj) {
            PaintPopup.a(var1, this.k * this.e, 0, this.e, this.e);
         }

         for(var6 = var4; var6 < var5; ++var6) {
            ((Command)var2.j.elementAt(var6)).a(var3, var6 * var2.e + var2.e / 2, var2.e / 2);
         }

         if (var2.k >= 0 && var2.k < var2.j.size()) {
            Command var11 = (Command)var2.j.elementAt(var2.k);
            var3.setClip(var2.p - 50, -100, var2.p + GameCanvas.m + 100, var2.d + 200);
            int var7 = var2.k * var2.e + var2.e / 2;
            if (var2.u * var2.e + (AvMain.Z << 1) + 10 > GameCanvas.m) {
               var8 = GameCanvas.L.a(var11.a) / 2;
               if (var7 - var8 < var2.p) {
                  var7 = var2.p + var8;
               } else if (var7 + var8 > GameCanvas.m + var2.p - 15) {
                  var7 = GameCanvas.m + var2.p - var8 - 15;
               }
            }

            GameCanvas.L.a(var3, var11.a, var7, -AvMain.ag - AvMain.Z - 6 - (AvMain.Y == 2 ? 15 : 0), 2);
         }

         GameCanvas.c(var3);
      } else if (this.u != 0) {
         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         Graphics var10 = var1;
         MenuSub var9 = this;
         GameCanvas.c(var1);
         if (OnScreen.b) {
            GameCanvas.S.e(var1, this.a - 2, this.m - 7, this.c + 4, this.d + 15);
         } else {
            GameCanvas.S.a(var1, this.a - 2, this.m - 7, this.c + 4, this.d + 15);
         }

         var1.setClip(this.a, this.m, this.c, this.d);
         var1.translate(this.a + 3, this.m + 1);
         var1.translate(0, -this.p);
         var6 = (this.e - AvMain.ah) / 2;

         for(var8 = 0; var8 < var9.u; ++var8) {
            var10.setColor(0);
            if (!var9.aj && var8 == var9.k) {
               if (OnScreen.b) {
                  var10.setColor(35217);
                  var10.fillRect(0, var8 * var9.e, var9.c - 6, var9.e);
               } else {
                  GameCanvas.S.b(var10, 0, var8 * var9.e, var9.c - 6, var9.e);
               }
            }

            short var12 = 0;
            if (h != null && var8 < h.length && h[var8] != -1 && AvatarData.c(h[var8]) != null) {
               var12 = AvatarData.c(h[var8]).b;
               AvatarData.a(var10, h[var8], 3, var8 * var9.e + var6 + 1, 0);
            }

            if (OnScreen.b) {
               GameCanvas.L.a(var10, ((Command)var9.j.elementAt(var8)).a, var12 + 5, var8 * var9.e + var6, 0);
            } else {
               GameCanvas.S.a(var10, ((Command)var9.j.elementAt(var8)).a, var12 + 5, var8 * var9.e + var6, 0);
            }
         }
      }

      super.a(var1);
   }

   public final void k() {
      if (this.t != 0) {
         this.t += -this.t >> 1;
      }

      if (this.t == -1) {
         this.t = 0;
      }

      if (this.w != 0) {
         if (this.p < 0 || this.p > this.s) {
            this.w -= this.w / 4;
            this.p += this.w / 20;
            if (this.w / 10 <= 1) {
               this.w = 0;
            }
         }

         if (this.p < 0) {
            if (this.p < -this.x / 2) {
               this.p = -this.x / 2;
               this.o = 0;
               this.w = 0;
            }
         } else if (this.p > this.s) {
            if (this.p < this.s + this.x / 2) {
               this.p = this.s + this.x / 2;
               this.o = this.s;
               this.w = 0;
            }
         } else {
            this.p += this.w / 10;
         }

         this.o = this.p;
         this.w -= this.w / 10;
         if (this.w / 10 == 0) {
            this.w = 0;
         }
      } else if (this.p < 0) {
         this.o = 0;
      } else if (this.p > this.s) {
         this.o = this.s;
      }

      if (this.p != this.o) {
         this.r = this.o - this.p << 2;
         this.q += this.r;
         this.p += this.q >> 4;
         this.q &= 15;
      }

      if (this.m > this.b) {
         int var2;
         if ((var2 = this.m - this.b >> 2) <= 0) {
            var2 = 1;
         }

         this.m -= var2;
      }

      this.m = this.b;
   }
}

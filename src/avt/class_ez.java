package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class class_ez extends MyScreen {
   public static class_ez a;
   public int b;
   private Image c;
   private boolean d = false;
   private static int e;
   private static int f;
   private static int g;
   private static int h;
   private static int i;
   private static int j;
   private static int k;
   private static int l;
   private int m = 0;
   private long n;
   private int o;
   private boolean p;
   private int q;
   private long r;
   private long s;
   private int t;

   public static class_ez b() {
      return a == null ? (a = new class_ez()) : a;
   }

   public final void a() {
      super.a();
      this.e();
      this.m = 0;
      if (super.ad == null) {
         this.c();
      }

      this.g();
   }

   public class_ez() {
      FilePack.b(T1.av);
      this.c = FilePack.a("tp");
      FilePack.a();
      this.c();
      CRes.b();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            if (this.d && super.ar > 0) {
               Canvas.d(T1.N);
               LoginScr.b().r = System.currentTimeMillis();
               LoginScr.b().i();
               return;
            } else {
               if (!this.d) {
                  this.d = true;
                  this.e();
                  super.ar = 1 + CRes.rnd(GameMidlet.a[OptionScr.b().b[4]][this.b].length - 1);
                  this.g();
                  return;
               }

               this.d = false;
               return;
            }
         case 1:
            this.f();
            return;
         case 2:
            this.d = false;
            this.b = 0;
            super.ar = 0;
            LoginScr.b().a();
         default:
      }
   }

   public final void c() {
      if (T1.O != null) {
         if (Canvas.Z == 0) {
            super.ad = new Command(T1.O, 0);
         }

         if (GameMidlet.f == 0) {
            super.ac = new Command(T1.f, 1);
         }

         super.ae = new Command(T1.dw, 2);
      }
   }

   private void f() {
      while(true) {
         Canvas.d(T1.b);
         if (this.m >= GameMidlet.d[OptionScr.b().b[4]].length) {
            Canvas.b(T1.ds);
            this.m = 0;
            return;
         }

         String var1;
         if ((var1 = GameMidlet.a(GameMidlet.d[OptionScr.b().b[4]][this.m])) != null) {
            String[] var6 = Canvas.K.a(var1, "*");
            GameMidlet.c[OptionScr.b().b[4]] = new int[var6.length - 1][];
            GameMidlet.b[OptionScr.b().b[4]] = new String[var6.length - 1][];
            GameMidlet.a[OptionScr.b().b[4]] = new String[var6.length - 1][];

            for(int var2 = 1; var2 < var6.length; ++var2) {
               String[] var3 = Canvas.K.a(var6[var2], "\n");
               GameMidlet.a[OptionScr.b().b[4]][var2 - 1] = new String[var3.length - 1];
               GameMidlet.b[OptionScr.b().b[4]][var2 - 1] = new String[var3.length - 2];
               GameMidlet.c[OptionScr.b().b[4]][var2 - 1] = new int[var3.length - 2];
               GameMidlet.a[OptionScr.b().b[4]][var2 - 1][0] = var3[0];

               for(int var4 = 1; var4 < var3.length - 1; ++var4) {
                  String[] var5 = Canvas.K.a(var3[var4], ":");
                  GameMidlet.a[OptionScr.b().b[4]][var2 - 1][var4] = var5[0];
                  GameMidlet.b[OptionScr.b().b[4]][var2 - 1][var4 - 1] = var5[1];
                  var5[2] = var5[2].substring(0, var5[2].length() - 1);
                  GameMidlet.c[OptionScr.b().b[4]][var2 - 1][var4 - 1] = Integer.parseInt(var5[2]);
               }
            }

            AvatarData.e();
            Canvas.h();
            this.e();
            return;
         }

         ++this.m;
      }
   }

   public final void e() {
      if (Canvas.Z > 0) {
         super.aj = true;
      }

      int var1 = 176;
      if (176 > Canvas.m) {
         var1 = Canvas.m;
      }

      PaintPopup.a().a(T1.bP, var1 * AvMain.hd, MyScreen.av * 6, 1);
      k = PaintPopup.a().g + 4;
      l = PaintPopup.a().h + PaintPopup.o + AvMain.Z;
      j = PaintPopup.a().e - (PaintPopup.o + (AvMain.Z << 1));
      i = GameMidlet.a[OptionScr.b().b[4]].length * MyScreen.av + (this.d ? GameMidlet.a[OptionScr.b().b[4]][this.b].length * MyScreen.av : 0) - j;
      e = 0;
      f = 0;
      if (i < 0) {
         i = 0;
      }

   }

   public final void k() {
      if (this.o != 0) {
         if (f < 0 || f > i) {
            this.o -= this.o / 4;
            f += this.o / 20;
            if (this.o / 10 <= 1) {
               this.o = 0;
            }
         }

         if (f < 0) {
            if (f < -j / 2) {
               f = -j / 2;
               e = 0;
               this.o = 0;
            }
         } else if (f > i) {
            if (f < i + j / 2) {
               f = i + j / 2;
               e = i;
               this.o = 0;
            }
         } else {
            f += this.o / 10;
         }

         e = f;
         this.o -= this.o / 10;
         if (this.o / 10 == 0) {
            this.o = 0;
         }
      } else if (f < 0) {
         e = 0;
      } else if (f > i) {
         e = i;
      }

      if (f != e) {
         h = e - f << 2;
         g += h;
         f += g >> 4;
         g &= 15;
      }

      Canvas.x.b();
   }

   private void b(int var1) {
      this.b = var1;
      if (this.b >= GameMidlet.a[OptionScr.b().b[4]].length) {
         this.b = 0;
      }

      if (this.b < 0) {
         this.b = GameMidlet.a[OptionScr.b().b[4]].length - 1;
      }

   }

   public final void a(int var1, boolean var2) {
      super.ar = var1;
      if (super.ar >= GameMidlet.a[OptionScr.b().b[4]][this.b].length || super.ar <= 0) {
         super.ar = 0;
         if (var2) {
            this.d = false;
            this.e();
         }
      }

   }

   public final void l() {
      ++this.r;
      boolean var1 = false;
      if (Canvas.a(8)) {
         var1 = true;
         if (!this.d) {
            this.b(this.b + 1);
         } else {
            this.a(super.ar + 1, true);
         }
      } else if (Canvas.a(2)) {
         var1 = true;
         if (!this.d) {
            this.b(this.b - 1);
         } else {
            this.a(super.ar - 1, true);
         }
      }

      if (Canvas.g && Canvas.b(k, l, PaintPopup.a().f, j)) {
         Canvas.g = false;
         this.q = f;
         this.p = true;
         this.n = System.currentTimeMillis() / 10L;
      }

      if (this.p) {
         long var2 = System.currentTimeMillis() / 10L - this.n;
         int var4 = Canvas.l();
         int var5;
         if (Canvas.e) {
            if (Canvas.gameTick % 3 == 0) {
               this.t = Canvas.i;
               this.s = this.r;
            }

            this.o = 0;
            var5 = (e + Canvas.i - l) / MyScreen.av;
            if (this.d) {
               super.ar = var5 - this.b;
            } else if (var5 >= 0 && var5 < GameMidlet.a[OptionScr.b().b[4]].length) {
               this.b = var5;
            }

            if (CRes.f(var4) >= 20 * AvMain.hd) {
               super.aj = true;
            } else if (var2 > 10L && var2 < 20L) {
               super.aj = false;
            }

            if ((e = this.q + var4) < 0 || e > i) {
               e = this.q + var4 / 2;
            }

            f = e;
         }

         if (Canvas.f && Canvas.b(k, l, PaintPopup.a().f, j)) {
            var5 = (int)(this.r - this.s);
            int var6;
            if (CRes.f(var6 = this.t - Canvas.i) > 40 && var5 < 10 && e > 0 && e < i) {
               this.o = var6 / var5 * 10;
            }

            this.s = -1L;
            if (Math.abs(var4) < 20 * AvMain.hd) {
               if (var2 <= 10L) {
                  super.aj = false;
               }

               if (!super.aj) {
                  int var7 = (e + Canvas.i - l) / MyScreen.av;
                  if (this.d) {
                     if (var7 - this.b > 0 && var7 - this.b < GameMidlet.a[OptionScr.b().b[4]][this.b].length) {
                        super.ar = var7 - this.b;
                        this.a(0, -1);
                     } else {
                        if (var7 - this.b <= 0) {
                           this.d = false;
                           super.ar = 0;
                           this.b = var7;
                           var1 = true;
                        }

                        if (var7 >= GameMidlet.a[OptionScr.b().b[4]][this.b].length - this.b && var7 < GameMidlet.a[OptionScr.b().b[4]][this.b].length - 1 + GameMidlet.a[OptionScr.b().b[4]].length) {
                           this.d = false;
                           super.ar = 0;
                           this.b = var7 - GameMidlet.a[OptionScr.b().b[4]][this.b].length + 1;
                           var1 = true;
                        }
                     }
                  } else if (var7 >= 0 && var7 < GameMidlet.a[OptionScr.b().b[4]].length) {
                     this.b = var7;
                     this.a(0, -1);
                  }
               }
            }
         }
      }

      if (Canvas.f) {
         this.p = false;
      }

      if (var1) {
         this.g();
      }

      super.l();
   }

   private void g() {
      if ((e = (this.b + (this.d ? super.ar : 0)) * MyScreen.av - j / 2 + MyScreen.av / 2) < 0) {
         e = 0;
      }

      if (e > i) {
         e = i;
      }

   }

   public final void a(Graphics var1) {
      Canvas.x.b(var1);
      Canvas.x.d(var1);
      Canvas.resetTrans(var1);
      PaintPopup.a().a(var1);
      if (GameMidlet.avatar != null && !GameMidlet.avatar.name.equals("")) {
         Canvas.L.a(var1, T1.dz + ", " + GameMidlet.avatar.name, PaintPopup.a().g + PaintPopup.a().f / 2, PaintPopup.a().h - AvMain.ag, 2);
      }

      var1.translate(k, l);
      var1.setClip(0, 0, PaintPopup.a().f - 9, PaintPopup.a().e - (PaintPopup.o + (AvMain.Z << 1)));
      var1.translate(0, -f);
      if (!super.aj) {
         Canvas.S.c(var1, 2 * AvMain.hd, this.b * MyScreen.av + (this.d ? super.ar * MyScreen.av : 0), PaintPopup.a().f - 8 - 4 * AvMain.hd, MyScreen.av);
      }

      int var2 = (MyScreen.av - AvMain.ah) / 2;

      for(int var3 = 0; var3 < GameMidlet.a[OptionScr.b().b[4]].length; ++var3) {
         Canvas.K.a(var1, GameMidlet.a[OptionScr.b().b[4]][var3][0], 24 * AvMain.hd, var2, 0);
         PaintPopup.a.drawFrame(0, 14 * AvMain.hd, var2 + AvMain.ah / 2, 5, 3, var1);
         var2 += MyScreen.av;
         if (this.d && this.b == var3) {
            for(int var4 = 1; var4 < GameMidlet.a[OptionScr.b().b[4]][var3].length; ++var4) {
               Canvas.K.a(var1, GameMidlet.a[OptionScr.b().b[4]][var3][var4], 36 * AvMain.hd, var2, 0);
               var1.drawImage(this.c, 24 * AvMain.hd, var2 + AvMain.ah / 2, 3);
               var2 += MyScreen.av;
            }
         }
      }

      super.a(var1);
      Canvas.a(var1);
   }
}

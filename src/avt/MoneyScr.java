package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class MoneyScr extends MyScreen {
   public static MoneyScr a;
   private Vector b;
   private int c = 0;
   private int d = 0;
   private MyScreen e;
   private Command f;
   private Command g;
   private Command h;
   private Image i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private int p;

   public static MoneyScr b() {
      if (a == null) {
         a = new MoneyScr();
      }

      return a;
   }

   public final void a(MyScreen var1) {
      this.e();
      this.d = 0;
      super.ar = 0;
      this.e = var1;
      this.c();
      super.a();
   }

   public final void e() {
      if (this.i == null) {
         FilePack.b(T1.au);
         this.i = FilePack.a("coin");
         FilePack.a();
      }

      String var1;
      if (LoadMap.a == 25) {
         this.c = 1;
         var1 = T1.ev[1];
         FarmService.a().e(0, 0);
         GameCanvas.i();
      } else {
         var1 = T1.ev[0];
         this.c = 0;
      }

      this.g();
      PaintPopup.a().a(var1, this.l, this.m, 2);
      if (OnScreen.b) {
         PaintPopup.a().h = 25 + MyScreen.al + 1;
      }

      this.k = PaintPopup.a().h;
      this.f();
   }

   public final void a(int var1, boolean var2) {
      if (var2 && super.ar == var1) {
         if (super.ad != null) {
            super.ad.b();
         } else if (super.ac != null) {
            super.ac.b();
         }
      }

      super.a(var1, var2);
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            GameCanvas.y.m = false;
            this.e.a();
            this.i = null;
            return;
         case 1:
         case 2:
            if (this.c != 0) {
               GameCanvas.u.a(T1.ay, 100, 1);
               return;
            }

            String var3;
            MoneyInfo var8;
            if ((var8 = (MoneyInfo)this.b.elementAt(super.ar)).c.indexOf(T1.aH) != -1) {
               var3 = GameCanvas.K.a(var8.c, T1.aI, GameMidlet.i.x);
               GameCanvas.a(T1.cL, (IAction)(new class_ci(this, var3)));
            } else {
               String var9;
               if (var8.c.indexOf("napthe:") != -1) {
                  var3 = var8.c.substring(0, var8.c.indexOf("napthe:") + "napthe:".length());
                  var3 = GameCanvas.K.a(var8.c, var3, "");
                  String var10001 = var3;
                  var3 = var8.a;
                  var9 = var10001;
                  TField[] var4;
                  (var4 = new TField[2])[0] = new TField();
                  var4[1] = new TField();
                  var4[0].d(0);
                  var4[1].d(1);
                  InputFace.b().a(var4, var3, T1.eH, new Command(T1.cy, new class_ch(this, var9, var4)));
                  GameCanvas.A = InputFace.b();
               } else {
                  if (var8.c.indexOf("ServerNap:") == -1) {
                     GameCanvas.i();
                     GlobalService var10000 = GlobalService.gI();
                     var9 = var8.b;
                     GlobalService var7 = var10000;
                     var10000.e((byte)-91);
                     var7.c(var9);
                     var7.k();
                     return;
                  }

                  var3 = var8.c.substring(0, var8.c.indexOf("ServerNap:") + "ServerNap:".length());
                  var3 = GameCanvas.K.a(var8.c, var3, "");
                  AvatarService var6;
                  (var6 = AvatarService.a()).e((byte)-76);
                  var6.c(var3);
                  var6.k();
                  GameCanvas.i();
               }
            }
            break;
         case 100:
            try {
               if (GameCanvas.u.a().equals("")) {
                  return;
               }

               var1 = Integer.parseInt(GameCanvas.u.a());
               FarmService.a().e(var1, super.ar == 0 ? 1 : 0);
               GameCanvas.i();
               return;
            } catch (Exception var5) {
            }
      }

   }

   public final void c() {
      this.f = new Command(T1.ev[0], 1);
      super.ac = this.f;
      this.g = new Command(T1.O, 2);
      super.ad = this.g;
      this.h = new Command(T1.d, 0);
      super.ae = this.h;
   }

   public MoneyScr() {
      new AvPosition(0, 1);
      this.o = 0;
      this.p = -1;
   }

   public final void a(Graphics var1) {
      GameCanvas.c(var1);
      if (OnScreen.b) {
         GameCanvas.S.b(var1);
         GameCanvas.S.a(var1, T1.cf.toUpperCase(), GameMidlet.i.a[0] + T1.C, GameMidlet.i.a[2] + T1.D);
      } else if (this.e != null) {
         this.e.b(var1);
      }

      if (InputFace.a == null || GameCanvas.A != InputFace.a) {
         if (!OnScreen.b) {
            PaintPopup.a().a(var1);
            var1.translate(0, this.k + PaintPopup.o + AvMain.Z);
            var1.setClip(this.j + 5, 0, this.l - 10, PaintPopup.a().e - PaintPopup.o - 2 * AvMain.Z);
         } else {
            var1.translate(0, this.k);
            var1.setClip(this.j + 5, 0, this.l - 10, this.m);
         }

         if (this.d == 1) {
            int var2 = (this.m - PaintPopup.o + (AvMain.Z << 1)) / 6;
            GameCanvas.N.a(var1, T1.aA + GameMidlet.i.x, this.j + this.l / 2, var2 / 2, 2);
            if (!FarmScr.z) {
               GameCanvas.N.a(var1, T1.aJ + ": " + GameMidlet.i.c, this.j + this.l / 2, var2 / 2 + var2, 2);
            }

            GameCanvas.N.a(var1, GameMidlet.i.a[2] + T1.D, this.j + this.l / 2, var2 / 2 + (var2 << 1), 2);
            if (FarmScr.z) {
               GameCanvas.N.a(var1, MapScr.r(), this.j + this.l / 2, var2 / 2 + var2 * 3, 2);
            }
         } else {
            var1.translate(0, -CameraList.i);
            if (this.c == 0) {
               this.d(var1);
            } else {
               this.c(var1);
            }
         }

         if (GameCanvas.D == null || !Welcome.d) {
            super.a(var1);
         }

         GameCanvas.a(var1);
      }
   }

   public final void a(Vector var1) {
      this.g();
      this.b = var1;
      this.f();
      this.o = 0;
   }

   private void f() {
      if (this.b != null) {
         this.b.size();
         int var1 = this.b.size() * this.n;
         int var2 = this.b.size();
         if (LoadMap.a == 25) {
            var1 = this.n << 1;
            var2 = 2;
         }

         GameCanvas.y.a(this.j, this.k + (!OnScreen.b ? PaintPopup.o + AvMain.Z : 0), this.l, this.n, this.l, var1, this.l, this.m - (PaintPopup.o + 2 * AvMain.Z) - AvMain.Z, var2);
      }
   }

   private void g() {
      if (OnScreen.b) {
         this.l = GameCanvas.m + 8;
         this.m = GameCanvas.n - 25 - MyScreen.al + (AvMain.Z << 1);
      } else {
         this.l = LoginScr.b().l;
         this.m = LoginScr.b().m;
      }

      this.n = MyScreen.av;
      this.j = GameCanvas.o - this.l / 2;
   }

   private void c(Graphics var1) {
      for(int var2 = 0; var2 < 2; ++var2) {
         if (!super.aj && var2 == super.ar) {
            GameCanvas.S.c(var1, this.j + 3 * AvMain.Y, var2 * this.n + 5, this.l - 6 * AvMain.Y, this.n);
         }

         GameCanvas.K.a(var1, T1.ew[var2], this.j + 10 + (super.ar == var2 ? this.o : 0), var2 * this.n + 5 + this.n / 2 - AvMain.ah / 2, 0);
      }

   }

   private void d(Graphics var1) {
      int var2 = this.i.getWidth() + 14;
      int var3 = this.b.size();

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         if (var4 == super.ar && !super.aj) {
            if (OnScreen.b) {
               var1.setColor(14328855);
               var1.fillRect(this.j, var4 * this.n, this.l - 3 * AvMain.Y, this.n);
            } else {
               GameCanvas.S.c(var1, this.j + 6, var4 * this.n, this.l - 6 * AvMain.Y, this.n);
            }
         }

         var1.drawImage(this.i, this.j + var2 / 2, var4 * this.n + this.n / 2, 3);
      }

      for(var4 = 0; var4 < var3; ++var4) {
         MoneyInfo var5 = (MoneyInfo)this.b.elementAt(var4);
         var1.setClip(this.j + var2 - 3, CameraList.i, this.l - var2 - 2, this.m - (!OnScreen.b ? PaintPopup.o + 2 * AvMain.Z : 0));
         GameCanvas.K.a(var1, var5.a, this.j + var2, var4 * this.n + this.n / 2 - AvMain.ah / 2, 0);
      }

   }

   public final void l() {
      super.l();
      if (!OnScreen.b) {
         if (GameCanvas.b[4] || GameCanvas.b[6]) {
            this.h();
         }

         if (GameCanvas.g && GameCanvas.a(0, PaintPopup.a().h, GameCanvas.m, PaintPopup.o)) {
            GameCanvas.g = false;
            this.h();
         }
      }

   }

   private void h() {
      String var1;
      if (this.d == 0) {
         this.d = 1;
         super.ac = null;
         var1 = T1.ev[2];
      } else {
         if (this.c == 1) {
            var1 = T1.ev[1];
         } else {
            var1 = T1.ev[0];
         }

         this.d = 0;
      }

      PaintPopup.a().a(var1, this.d);
   }

   public final void d(int var1) {
   }

   public final void k() {
      if (this.e != null) {
         this.e.k();
      }

      int var2;
      if (this.c == 0) {
         MoneyInfo var1 = (MoneyInfo)this.b.elementAt(super.ar);
         var2 = GameCanvas.K.a(var1.a);
      } else {
         var2 = GameCanvas.K.a(T1.ew[super.ar]);
      }

      if (var2 > this.l - 20) {
         this.o += this.p;
         if (this.o <= -(var2 - (this.l - 30))) {
            this.p = 1;
         }

         if (this.o > 0) {
            this.p = -1;
         }
      } else {
         this.o = 0;
      }

      if (this.d == 0) {
         if (LoadMap.a != 25) {
            super.ac = this.f;
            super.ad = null;
         } else {
            super.ac = null;
            super.ad = this.g;
         }
      } else {
         super.ac = null;
         super.ad = null;
      }
   }
}

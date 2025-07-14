package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

public final class MenuCenter extends MyScreen {
   public static MenuCenter a;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private boolean j = false;
   private Vector k;
   private short[] l;
   private MyScreen m;
   private Command n;
   public AvPosition b;
   private static class_hz o;
   public boolean c = false;
   private boolean p;
   private long q = 0L;
   private boolean r = false;
   private int s;

   public static MenuCenter b() {
      return a == null ? (a = new MenuCenter()) : a;
   }

   public final void a() {
      if (GameCanvas.r != this) {
         this.m = GameCanvas.r;
      }

      this.c();
      super.a();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.h();
            return;
         case 1:
            this.h();
            Command var3;
            if ((var3 = (Command)this.k.elementAt(this.d)).b != null) {
               var3.b.perform();
               return;
            } else {
               this.d(var3.c, var3.e);
            }
         default:
      }
   }

   public final void c() {
      if (GameCanvas.Z == 0) {
         super.ae = new Command(T1.d, 0);
      } else {
         this.j = true;
      }

      this.n = new Command(T1.O, 1);
   }

   public MenuCenter() {
      this.s = 50 * AvMain.Y;
   }

   private void h() {
      this.m.a();
      if (MapScr.h != null) {
         MapScr.h.L = false;
      }

      this.r = false;
      o = null;
      super.ad = null;
      this.p = false;
   }

   public final void d(int var1, int var2) {
      StringObj var8;
      switch (var1) {
         case 1:
            MapScr.b().j();
            return;
         case 2:
            MenuCenter var10 = this;
            byte[] var11 = new byte[]{4, 5, 6, 7, 8, 9, 10, 11, 12};
            Vector var12 = new Vector();

            for(int var13 = 0; var13 < var11.length; ++var13) {
               var12.addElement(new CommandFeel(var10, "", 19, var13, var11, var13));
            }

            var10.b = null;
            var10.a(var12);
            return;
         case 3:
            this.e();
            return;
         case 4:
            MapScr.x = true;
            ParkService.a().b(GameMidlet.i.w);
            return;
         case 5:
            ListScr.b().b(false);
            return;
         case 6:
            this.c = false;
            GlobalService.gI().c(GameMidlet.i.w);
            return;
         case 7:
            MapScr.b();
            MapScr.c(MapScr.h);
            return;
         case 8:
            GlobalService.gI().e(26);
            GameCanvas.i();
            return;
         case 9:
            MapScr.b().g();
            return;
         case 10:
            MapScr.b();
            MapScr.o();
            return;
         case 11:
            MapScr.x = true;
            MapScr.b();
            MapScr.p();
            return;
         case 12:
            MapScr.b().i();
            return;
         case 13:
            MapScr.b();
            MapScr.h();
            return;
         case 14:
         default:
            break;
         case 15:
            MapScr.b().a(GameMidlet.j);
            return;
         case 16:
            if ((var8 = (StringObj)MapScr.o.elementAt(var2)).f == 1) {
               GlobalService.gI().b(var8.e, MapScr.h != null ? MapScr.h.w : -1);
               return;
            }
            break;
         case 17:
            GlobalService.gI().h(var2);
            return;
         case 18:
            if ((var8 = (StringObj)MapScr.o.elementAt(var2)).f == 0) {
               GlobalService.gI().b(var8.e, MapScr.h != null ? MapScr.h.w : -1);
               return;
            }
            break;
         case 19:
            byte[] var7 = new byte[]{4, 5, 6, 7, 8, 9, 10, 11, 12};
            if (var2 == 0) {
               MapScr.b();
               MapScr.b((int)4);
               return;
            }

            MapScr.b();
            MapScr.b((int)var7[var2]);
            return;
         case 20:
            if (GameMidlet.i.Q != 0 && GameMidlet.i.Q != -5 || Bus.b) {
               return;
            }

            if (LoadMap.p == null || LoadMap.p.az != 5) {
               Vector var9 = new Vector();
               Command var3 = this.a(T1.cw, 4, 17);
               Command var4 = this.a(T1.dr, 6, 14);
               Command var5 = this.a(T1.l, 21, 14);
               Command var6 = this.a(T1.cd, 15, 17);
               var9.addElement(var3);
               var9.addElement(var6);
               var9.addElement(var5);
               var9.addElement(var4);
               if (GameCanvas.r != PopupShop.b()) {
                  b().a(var9);
               }

               return;
            }

            ParkService.a().c(((Drop_Part)LoadMap.p).d);
            break;
         case 21:
            GlobalService.gI().c(GameMidlet.i.w);
            this.c = true;
      }

   }

   public final void e() {
      if (MapScr.h != null) {
         this.r = false;
         Vector var1;
         (var1 = new Vector()).addElement(this.a(T1.bT, 9, 13));
         var1.addElement(this.a(T1.bW, 12, 2));
         var1.addElement(this.a(T1.y, 7, 11));
         var1.addElement(this.a(T1.bS, 8, 12));
         var1.addElement(this.a(T1.bU, 10, 21));
         var1.addElement(this.a(T1.bV, 11, 19));
         var1.addElement(this.a(T1.dj, 13, 22));
         if (MapScr.o.size() > 0) {
            for(int var2 = 0; var2 < MapScr.o.size(); ++var2) {
               StringObj var3;
               if ((var3 = (StringObj)MapScr.o.elementAt(var2)).f == 1) {
                  var1.addElement(new class_ji(this, var3.a, 16, var2, var3));
               }
            }
         }

         this.a(var1);
      }
   }

   public final void f() {
      if (GameMidlet.i.Q == 0 || GameMidlet.i.Q == -5) {
         if (!Bus.b) {
            if (LoadMap.p != null && LoadMap.p.az == 5) {
               ParkService.a().c(((Drop_Part)LoadMap.p).d);
            } else if (LoadMap.p != null && LoadMap.p.az == 0 && ((Avatar)LoadMap.p).w == -100) {
               GameCanvas.a(T1.eb, (IAction)(new class_jc(this)));
            } else {
               Vector var1 = new Vector();
               Command var2 = this.a(T1.bX, 1, 1);
               Command var3 = this.a(T1.bY, 2, 0);
               Command var4 = this.a(T1.bZ, 3, 20);
               Command var5 = this.a(T1.by, 20, 17);
               Command var6 = this.a(T1.aa, 5, 18);
               if (GameCanvas.Z == 0) {
                  var1.addElement(var4);
               }

               var1.addElement(var5);
               var1.addElement(var3);
               if (GameCanvas.Z == 0) {
                  var1.addElement(MapScr.b().f);
               }

               if (GameMidlet.i.H != 14) {
                  var1.addElement(var2);
               }

               var1.addElement(var6);
               int var7;
               StringObj var8;
               if (GameCanvas.Z > 0 && MapScr.n != null && MapScr.n.size() > 0) {
                  for(var7 = 0; var7 < MapScr.n.size(); ++var7) {
                     var8 = (StringObj)MapScr.n.elementAt(var7);
                     var1.addElement(new class_jg(this, var8.a, 17, var7, var8));
                  }
               }

               if (MapScr.o.size() > 0) {
                  for(var7 = 0; var7 < MapScr.o.size(); ++var7) {
                     if ((var8 = (StringObj)MapScr.o.elementAt(var7)).f == 0) {
                        var1.addElement(new class_ix(this, var8.a, 18, var7, var8));
                     }
                  }
               }

               if (GameCanvas.r != PopupShop.b()) {
                  this.b = null;
                  b().a(var1);
               }
            }
         }
      }
   }

   public static void g() {
      Avatar var0 = GameMidlet.i;
      if (GameCanvas.r != a) {
         PopupShop.b().m = true;
         PopupShop.b().a(new String[]{T1.l, T1.co}, new Vector[]{MapScr.b().a((Avatar)var0, 0), MapScr.b().a(GameMidlet.k, var0.w, 1)}, (Vector)null);
         PopupShop.b().a(MapScr.b().a(var0.e, 0, 0, false), 0);
         PopupShop.b().a(MapScr.b().a(GameMidlet.k, 1, 0, true), 1);
         if (GameCanvas.r != PopupShop.b()) {
            PopupShop.b().a();
         }

      }
   }

   private Command a(String var1, int var2, int var3) {
      return new class_iz(this, var1, var2, var3);
   }

   public final Command a(String var1, IAction var2, int var3) {
      return new class_iv(this, var1, new class_iu(this, var2), var3);
   }

   public final void a(Vector var1) {
      this.k = var1;
      if (GameCanvas.H) {
         this.g = 40 * AvMain.Y + (AvMain.Y - 1) * 20;
         if (GameCanvas.Z == 1 && GameCanvas.m > 300) {
            this.g += 20;
         }
      } else {
         this.g = 30;
      }

      this.h = this.g + 2 * AvMain.Y;
      this.f = AvMain.ag << 1;
      this.e = 0;
      this.i = GameCanvas.m / this.h;
      if (var1.size() * this.h < GameCanvas.m) {
         this.e = (GameCanvas.m - var1.size() * this.h) / 2;
      } else {
         this.e = (GameCanvas.m - this.i * this.h) / 2;
      }

      this.l = new short[var1.size()];

      for(int var2 = 0; var2 < this.l.length; ++var2) {
         this.l[var2] = -40;
      }

      if (this.d >= var1.size()) {
         this.d = 0;
      }

      this.r = false;
      if (MapScr.h != null && GameCanvas.Z > 0) {
         MapScr.h.L = true;
      }

      if (GameCanvas.Z > 0) {
         this.f = GameCanvas.p - (var1.size() / this.i + 1) * this.g / 2;
      }

      this.a();
      if (GameCanvas.Z == 0) {
         super.ad = this.n;
      }

   }

   public final void k() {
      this.m.k();

      for(int var1 = 0; var1 < this.l.length; ++var1) {
         if (this.l[var1] != var1 % this.i * this.h) {
            short[] var10000 = this.l;
            var10000[var1] = (short)(var10000[var1] + (var1 % this.i * this.h - this.l[var1]) / 3);
         }
      }

   }

   public final void l() {
      if (GameCanvas.g) {
         boolean var1 = false;

         for(int var2 = this.k.size() - 1; var2 >= 0; --var2) {
            if (GameCanvas.a(this.l[var2] + this.e, this.f + var2 / this.i * this.h, this.g, this.g)) {
               this.d = var2;
               this.p = true;
               this.j = false;
               var1 = true;
               this.q = System.currentTimeMillis() / 100L;
               break;
            }
         }

         if (!var1) {
            this.h();
         }
      }

      int var3;
      if (this.p) {
         if (System.currentTimeMillis() / 100L - this.q > 10L) {
            this.j = false;
         }

         if (GameCanvas.f) {
            this.p = false;
            this.j = true;

            for(var3 = this.k.size() - 1; var3 >= 0; --var3) {
               if (GameCanvas.a(this.l[var3] + this.e, this.f + var3 / this.i * this.h, this.g, this.g)) {
                  if (var3 == this.d) {
                     this.h();
                     this.a(1, -1);
                  }
                  break;
               }
            }

            GameCanvas.f = false;
         }
      }

      if (GameCanvas.a(4)) {
         --this.d;
         if (this.d < 0) {
            this.d = this.k.size() - 1;
         }
      } else if (GameCanvas.a(6)) {
         ++this.d;
         if (this.d >= this.k.size()) {
            this.d = 0;
         }
      } else if (GameCanvas.a(2)) {
         if ((var3 = this.d - this.i) < 0) {
            if ((var3 = this.k.size() / this.i * this.i + this.i + var3) < this.k.size()) {
               this.d = var3;
            }
         } else {
            this.d = var3;
         }
      } else if (GameCanvas.a(8)) {
         this.d += this.i;
         if (this.d >= this.k.size()) {
            this.d %= this.i;
         }
      }

      super.l();
   }

   public final void a(Graphics var1) {
      this.m.b(var1);
      GameCanvas.c(var1);
      Graphics var3 = var1;
      MenuCenter var2 = this;
      if (GameMidlet.i.H != 14) {
         GameMidlet.i.a(var1, GameMidlet.i.aw * AvMain.Y - AvCamera.a().a, GameMidlet.i.ax * AvMain.Y - AvCamera.a().b, false);
      }

      Command var4 = (Command)this.k.elementAt(this.d);
      GameCanvas.L.a(var1, var4.a, GameCanvas.o, this.f - 15, 2);
      var1.translate(this.e, this.f);

      for(int var5 = this.k.size() - 1; var5 >= 0; --var5) {
         byte var7 = 0;
         Command var6 = (Command)var2.k.elementAt(var5);
         if (var5 == var2.d && !var2.j) {
            var7 = 4;
         }

         GameCanvas.S.a(var3, var2.l[var5], var5 / var2.i * var2.h, var2.g, var2.g, var7);
         var6.a(var3, var2.h / 2 + var2.l[var5], var2.h / 2 + var5 / var2.i * var2.h);
      }

      super.a(var1);
   }
}

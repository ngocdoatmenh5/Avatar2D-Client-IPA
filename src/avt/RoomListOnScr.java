package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class RoomListOnScr extends MyScreen {
   public static RoomListOnScr a;
   public static FrameImage b;
   private Vector d;
   public static String c;
   private int e;
   private int f;
   private Command g;
   private Command h;
   private int i = 0;

   public static RoomListOnScr b() {
      if (a == null) {
         a = new RoomListOnScr();
      }

      return a;
   }

   public final void a() {
      Canvas.S.h();
      super.a();
      super.ae = this.h;
      if (Canvas.Z == 0) {
         super.ad = new Command(T1.O, 3);
      } else {
         super.ad = new Command(T1.i, 1);
      }

      super.aj = true;
      this.e();
      OnScreen.b();
      this.e = this.i;
      Canvas.y.a(this.e);
   }

   public RoomListOnScr() {
      this.e();
      this.c();
   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 1:
            Canvas.i();
            CasinoService.a().c();
            return;
         case 2:
            Canvas.i();
            CasinoService.a().b();
            return;
         case 3:
            Canvas.i();
            GlobalService.gI().a(GameMidlet.avatar.IDDB);
         default:
      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var3;
            (var3 = new Vector()).addElement(new Command(T1.i, 1));
            var3.addElement(new Command(T1.f, 2));
            if (Canvas.Z == 0) {
               var3.addElement(MapScr.gI().f);
            }

            var3.addElement(new Command(T1.am, 3));
            MenuSub.a().a(var3, 0);
            return;
         case 1:
            this.f();
            return;
         case 2:
            GlobalService.gI().d((int)9);
            Canvas.i();
            return;
         case 3:
            this.f();
         default:
      }
   }

   public final void c() {
      this.g = new Command(T1.c, 0);
      new Command(T1.O, 1);
      this.h = new Command(T1.d, 2);
      super.ac = this.g;
      super.ae = this.h;
   }

   public static void a(int var0, BoardScr var1) {
      if (!OnScreen.b) {
         c = T1.ek[var0];
      } else {
         c = T1.eA[var0];
      }

      CasinoMsgHandler.d = var1;
   }

   public final void e() {
      if (Canvas.Z == 0) {
         this.f = 50;
         this.i = 1;
      } else {
         if (Canvas.Z == 1) {
            this.f = 80;
         } else if (Canvas.Z == 2) {
            this.f = 150;
         }

         this.i = Canvas.m / this.f;
      }

      if (this.d != null) {
         if (this.f != 0) {
            if (Canvas.Z == 0) {
               Canvas.y.a(0, Canvas.m < 200 ? this.f / 2 : 50, Canvas.m, this.f, Canvas.m, this.d.size() * this.f, Canvas.m, Canvas.n - (Canvas.m < 200 ? this.f / 2 : 50) - 4, this.d.size());
            } else {
               Canvas.y.a((Canvas.m - this.f * this.i) / 2, 50 * AvMain.hd, this.f, this.f, Canvas.m, (this.d.size() / this.i + 2) * this.f, Canvas.m, Canvas.n - 50 * AvMain.hd - 4, this.d.size());
            }

            Canvas.y.a(this.e);
         }

      }
   }

   private void f() {
      byte var1;
      if ((var1 = ((RoomInfo)this.d.elementAt(this.e)).a) != -1) {
         CasinoService.a().a(var1);
         Canvas.i();
      }
   }

   public final void a(Graphics var1) {
      this.b(var1);
      OnScreen.a(var1, super.ac, super.ad, super.ae);
      Canvas.b(var1);
   }

   public final void b(Graphics var1) {
      Canvas.S.b(var1);
      a(var1, "Phòng " + c);
      Canvas.S.a(var1, this.d, this.f, this.e);
   }

   public static void a(Graphics var0, String var1) {
      Canvas.S.b(var0);
      if (Canvas.m > 200) {
         Canvas.S.e(var0, Canvas.o - 100 * AvMain.hd, 5 * AvMain.hd - CameraList.i, 200 * AvMain.hd, 44 * AvMain.hd);
         FontX var2 = Canvas.O;
         if (Canvas.Z == 0) {
            var2 = Canvas.L;
         }

         var2.a(var0, var1, Canvas.o, 5 * AvMain.hd - CameraList.i + 22 * AvMain.hd - var2.a() / 2, 2);
      }

   }

   public final void a(Vector var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         RoomInfo var3 = (RoomInfo)var1.elementAt(var2);

         for(int var4 = var2; var4 < var1.size(); ++var4) {
            RoomInfo var5;
            if ((var5 = (RoomInfo)var1.elementAt(var4)).c < var3.c) {
               var1.setElementAt(var3, var4);
               var1.setElementAt(var5, var2);
               var3 = var5;
            }
         }
      }

      this.d = new Vector();
      byte var6 = -1;

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         RoomInfo var8 = (RoomInfo)var1.elementAt(var7);
         if (var6 == -1 || var8.c != var6) {
            this.d.addElement(new RoomInfo((byte)-1, (byte)0, (byte)0, var8.c));
         }

         this.d.addElement(var8);
         var6 = var8.c;
      }

      if (Canvas.Z != 0) {
         this.g();
      }

      this.e = 1;
      this.e();
   }

   private boolean g() {
      for(int var1 = 0; var1 < this.d.size(); ++var1) {
         RoomInfo var2;
         if ((var2 = (RoomInfo)this.d.elementAt(var1)).a == -1) {
            int var3;
            int var4;
            if ((var3 = this.i - var1 % this.i) != this.i) {
               for(var4 = 0; var4 < var3; ++var4) {
                  this.d.insertElementAt(new RoomInfo((byte)-2, (byte)0, (byte)0, var2.c), var1);
               }

               var1 += var3;
            }

            for(var4 = 0; var4 < this.i - 1; ++var4) {
               this.d.insertElementAt(new RoomInfo((byte)-2, (byte)0, (byte)0, var2.c), var1 + 1);
            }

            var1 += this.i;
         }
      }

      return false;
   }

   public final void a(int var1, boolean var2) {
      if (var2 && this.e == var1) {
         this.f();
      }

      if (Canvas.Z == 0) {
         if (this.e > 0 && this.e < this.d.size()) {
            RoomInfo var3;
            if ((var3 = (RoomInfo)this.d.elementAt(var1)).a != -1 && var3.a != -1) {
               if (var1 >= 0 && var1 < this.d.size()) {
                  this.e = var1;
               }
            } else if (var1 > this.e) {
               this.e = var1 + this.i;
            } else {
               this.e = var1 - this.i;
            }

            Canvas.y.a(this.e);
            if (this.e <= 0) {
               this.e = this.d.size() - 1;
               Canvas.y.a(this.e);
               return;
            }
         }
      } else {
         this.e = var1;
      }

   }

   public final void l() {
      if (Canvas.Z != 0) {
         Canvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public final void k() {
   }
}

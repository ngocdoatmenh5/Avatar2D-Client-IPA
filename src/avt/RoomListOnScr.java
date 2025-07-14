package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
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
      GameCanvas.S.h();
      super.a();
      super.ae = this.h;
      if (GameCanvas.Z == 0) {
         super.ad = new Command(T1.O, 3);
      } else {
         super.ad = new Command(T1.i, 1);
      }

      super.aj = true;
      this.e();
      OnScreen.b();
      this.e = this.i;
      GameCanvas.y.a(this.e);
   }

   public RoomListOnScr() {
      this.e();
      this.c();
   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 1:
            GameCanvas.i();
            CasinoService.a().c();
            return;
         case 2:
            GameCanvas.i();
            CasinoService.a().b();
            return;
         case 3:
            GameCanvas.i();
            GlobalService.gI().a(GameMidlet.i.w);
         default:
      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var3;
            (var3 = new Vector()).addElement(new Command(T1.i, 1));
            var3.addElement(new Command(T1.f, 2));
            if (GameCanvas.Z == 0) {
               var3.addElement(MapScr.b().f);
            }

            var3.addElement(new Command(T1.am, 3));
            MenuSub.a().a(var3, 0);
            return;
         case 1:
            this.f();
            return;
         case 2:
            GlobalService.gI().d((int)9);
            GameCanvas.i();
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
      if (GameCanvas.Z == 0) {
         this.f = 50;
         this.i = 1;
      } else {
         if (GameCanvas.Z == 1) {
            this.f = 80;
         } else if (GameCanvas.Z == 2) {
            this.f = 150;
         }

         this.i = GameCanvas.m / this.f;
      }

      if (this.d != null) {
         if (this.f != 0) {
            if (GameCanvas.Z == 0) {
               GameCanvas.y.a(0, GameCanvas.m < 200 ? this.f / 2 : 50, GameCanvas.m, this.f, GameCanvas.m, this.d.size() * this.f, GameCanvas.m, GameCanvas.n - (GameCanvas.m < 200 ? this.f / 2 : 50) - 4, this.d.size());
            } else {
               GameCanvas.y.a((GameCanvas.m - this.f * this.i) / 2, 50 * AvMain.Y, this.f, this.f, GameCanvas.m, (this.d.size() / this.i + 2) * this.f, GameCanvas.m, GameCanvas.n - 50 * AvMain.Y - 4, this.d.size());
            }

            GameCanvas.y.a(this.e);
         }

      }
   }

   private void f() {
      byte var1;
      if ((var1 = ((RoomInfo)this.d.elementAt(this.e)).a) != -1) {
         CasinoService.a().a(var1);
         GameCanvas.i();
      }
   }

   public final void a(Graphics var1) {
      this.b(var1);
      OnScreen.a(var1, super.ac, super.ad, super.ae);
      GameCanvas.b(var1);
   }

   public final void b(Graphics var1) {
      GameCanvas.S.b(var1);
      a(var1, "Phòng " + c);
      GameCanvas.S.a(var1, this.d, this.f, this.e);
   }

   public static void a(Graphics var0, String var1) {
      GameCanvas.S.b(var0);
      if (GameCanvas.m > 200) {
         GameCanvas.S.e(var0, GameCanvas.o - 100 * AvMain.Y, 5 * AvMain.Y - CameraList.i, 200 * AvMain.Y, 44 * AvMain.Y);
         FontX var2 = GameCanvas.O;
         if (GameCanvas.Z == 0) {
            var2 = GameCanvas.L;
         }

         var2.a(var0, var1, GameCanvas.o, 5 * AvMain.Y - CameraList.i + 22 * AvMain.Y - var2.a() / 2, 2);
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

      if (GameCanvas.Z != 0) {
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

      if (GameCanvas.Z == 0) {
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

            GameCanvas.y.a(this.e);
            if (this.e <= 0) {
               this.e = this.d.size() - 1;
               GameCanvas.y.a(this.e);
               return;
            }
         }
      } else {
         this.e = var1;
      }

   }

   public final void l() {
      if (GameCanvas.Z != 0) {
         GameCanvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public final void k() {
   }
}

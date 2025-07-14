package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class BoardListOnScr extends MyScreen {
   public static BoardListOnScr a;
   public static byte b = 0;
   public static byte c = 1;
   public static byte d = 2;
   public static byte e;
   public static FrameImage f;
   private static Image k;
   private static Image l;
   private static Image m;
   private static Image n;
   private int o;
   Vector g;
   private int p;
   private int q;
   public byte h;
   private short r;
   private Command s;
   public static Image i;
   int j;

   static {
      e = c;
   }

   public static BoardListOnScr b() {
      return a == null ? (a = new BoardListOnScr()) : a;
   }

   public final void a() {
      OnScreen.f();
      MyScreen.z();
      super.ar = 0;
      Canvas.S.b(e);
      if (k == null) {
         try {
            k = Image.createImage(T1.a() + "/on/imgkhungsoban.on");
            l = Image.createImage(T1.a() + "/on/imgNumPlayer.on");
            m = Image.createImage(T1.a() + "/on/imgPlay.on");
            n = Image.createImage(T1.a() + "/on/imgLock.on");
         } catch (IOException var2) {
            var2.printStackTrace();
         }
      }

      Canvas.J = 1;
      super.aj = true;
      GameMidlet.avatar.ableShow = false;
      super.a();
   }

   public BoardListOnScr() {
      this.s = new Command(T1.O, 1);
      super.ae = new Command(T1.d, 2);
      if (Canvas.Z != 0) {
         super.ad = new Command(T1.i, 5);
      } else {
         super.ad = this.s;
      }

      super.ac = new Command(T1.c, 6);
      this.r = (short)(110 * AvMain.hd);
      if (Canvas.Z == 1) {
         this.r = 95;
      } else if (Canvas.Z == 0) {
         this.r = (short)(Canvas.m / 4);
         if (this.r < 70) {
            this.r = (short)(Canvas.m / 3);
         }

         if (Canvas.m < 180) {
            this.r = (short)(Canvas.m / 2);
         }
      }

      this.o = Canvas.m / this.r + 1;
      if (this.o * this.r > Canvas.m - this.r / 2) {
         --this.o;
      }

      this.p = this.r / 2;
      this.q = this.r / 2;
      this.q += 10;
      if (Canvas.m > this.o * this.r) {
         this.p = (Canvas.m - this.o * this.r) / 2 + this.r / 2;
      }

   }

   public final void d() {
      Canvas.i();
      i();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 1:
            class_dl var4 = (class_dl)this.g.elementAt(super.ar);
            if (MapScr.isNewVersion && var4.f > GameMidlet.avatar.money[3]) {
               b().f();
            } else {
               if (!var4.d) {
                  CasinoService.a().a(this.h, var4.a, "");
                  Canvas.i();
                  return;
               }

               Canvas.u.a(T1.X, new class_cn(this), 2);
            }
            break;
         case 2:
            i();
            return;
         case 3:
            this.d(1, -1);
            return;
         case 4:
            this.h();
            return;
         case 5:
            Canvas.i();
            CasinoService.a().c();
            return;
         case 6:
            Vector var3;
            (var3 = new Vector()).addElement(new Command(T1.i, 5));
            var3.addElement(new Command("Đến bàn", 6));
            var3.addElement(MapScr.gI().f);
            var3.addElement(new Command(T1.am, 7));
            MenuSub.a().a(var3, 0);
      }

   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 1:
            Canvas.c(T1.b);
            CasinoService.a().a(this.h);
            return;
         case 3:
            Canvas.i();
            GlobalService.gI().a(GameMidlet.avatar.IDDB);
            return;
         case 4:
            i();
            return;
         case 5:
            Canvas.i();
            CasinoService.a().c();
            return;
         case 6:
            this.h();
            return;
         case 7:
            Canvas.i();
            GlobalService.gI().a(GameMidlet.avatar.IDDB);
         case 2:
         default:
      }
   }

   private void h() {
      Canvas.u.a(T1.an, new IActionToGo(this), 3);
   }

   protected final void e() {
      Canvas.u.a(T1.ap, new class_cj(this), 0);
   }

   public final void f() {
      Canvas.a("Hiện tại bạn không đủ Xèng để tham gia màn chơi, bạn có muốn nạp thêm Xèng không?", (IAction)(new IActionXeng(this)));
   }

   private static void i() {
      Canvas.y.m = false;
      CasinoService.a().b();
      Canvas.i();
   }

   public final void a(Graphics var1) {
      Canvas.resetTrans(var1);
      RoomListOnScr.a(var1, "Phòng " + RoomListOnScr.c + " " + this.h);
      this.c(var1);
      OnScreen.a(var1, super.ac, super.ad, super.ae);
      Canvas.b(var1);
   }

   private void c(Graphics var1) {
      var1.translate(this.p, this.q);
      var1.translate(0, -CameraList.i);
      int var2;
      if ((var2 = CameraList.i / this.r * this.o - this.o) < 0) {
         var2 = 0;
      }

      int var3;
      if ((var3 = var2 + Canvas.n / this.r * this.o + (this.o << 1) + this.o) > this.g.size()) {
         var3 = this.g.size();
      }

      for(var2 = var2; var2 < var3; ++var2) {
         int var4 = var2 % this.o * this.r;
         int var5 = var2 / this.o * this.r;
         class_dl var6 = (class_dl)this.g.elementAt(var2);
         if ((!Canvas.H || !super.aj) && var2 == super.ar) {
            var1.drawImage(i, var4, var5, 3);
         }

         f.drawFrame(var6.b, var4, var5, 0, 3, var1);
         var1.drawImage(k, var4 - this.r / 4, var5 - 30 * AvMain.hd, 3);
         Canvas.smallFontYellow.a(var1, "" + var6.a, var4 - this.r / 4, var5 - 30 * AvMain.hd - AvMain.ai / 2, 2);
         if (var6.f > 0) {
            Canvas.smallFontYellow.a(var1, var6.g, var4, var5 - 30 * AvMain.hd - AvMain.ai / 2, 2);
         }

         if (e == c && var6.c < 4) {
            var1.drawImage(l, var4 + this.r / 4, var5 - 30 * AvMain.hd, 3);
            Canvas.smallFontRed.a(var1, "" + var6.c, var4 + this.r / 4, var5 - 30 * AvMain.hd - AvMain.ai / 2, 2);
         }

         if (var6.e) {
            var1.drawImage(l, var4 - this.r / 4, var5 + this.r / 3, 3);
            var1.drawImage(m, var4 - this.r / 4, var5 + this.r / 3, 3);
         }

         if (var6.d) {
            var1.drawImage(l, var4 + this.r / 4, var5 + this.r / 3, 3);
            var1.drawImage(n, var4 + this.r / 4, var5 + this.r / 3, 3);
         }
      }

   }

   public final void l() {
      if (OnScreen.b && Canvas.Z != 0) {
         Canvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public final void a(Vector var1) {
      this.g = var1;
   }

   public final void g() {
      int var1 = this.g.size() / this.o;
      if (this.g.size() % this.o != 0) {
         ++var1;
      }

      this.q = 100 * AvMain.hd;
      if (Canvas.m < 200) {
         this.q = 50;
      }

      Canvas.y.a(this.p - this.r / 2, this.q - this.r / 2, this.r, this.r, this.o * this.r, var1 * this.r + 10, this.o * this.r, Canvas.n - (this.q - this.r / 2) - 4, this.g.size());
   }

   public final void a(int var1, boolean var2) {
      if (var2 && super.ar == var1 && this.s != null) {
         this.s.b();
      }

      if (var1 >= 0 && var1 < this.g.size()) {
         super.a(var1, var2);
      }

   }

   public final void k() {
   }
}

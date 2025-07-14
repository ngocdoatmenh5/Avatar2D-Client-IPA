package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public abstract class BoardScr extends MyScreen implements IChatable {
   public static BoardScr i;
   public static boolean j;
   public static boolean k;
   public static boolean l;
   public static Vector m;
   public int n;
   public int o;
   public static byte p;
   public static byte q;
   public static int r;
   private static int a;
   public static byte s;
   public static long t;
   public static long u;
   public static int v;
   public static int w;
   public static int[] x = new int[4];
   public int y = 10;
   public static int z;
   public static int A;
   public int B = -1;
   private static Command b;
   private static Command c;
   public static Command C;
   public static Command D;
   private static Command d;
   public static Command E;
   private static Image[] e;
   public static AvPosition[] F;
   private static Vector f = new Vector();
   public static Image G;
   public static int H = 4;
   public static Vector I = new Vector();
   public static Vector J = new Vector();
   private static ChatPopup g;

   public final void d() {
      this.u();
   }

   public void a() {
      GameCanvas.e();
      super.a();
      i = this;
   }

   public BoardScr() {
      this.e();
      b = new Command(T1.c, 0);
      new Command(T1.z, 1);
      c = new Command(T1.n, 2);
      C = new Command(T1.w, 3);
      D = new Command(T1.A, 4);
      d = new Command(T1.j, 5);
      E = new Command(T1.b, 6);
   }

   public void e() {
      F = new AvPosition[]{new AvPosition(GameCanvas.o, 30 + 23 * AvMain.Y, 2), new AvPosition(13 * AvMain.Y, GameCanvas.p - 20, 0), new AvPosition(GameCanvas.o, GameCanvas.n - 28, 2), new AvPosition(GameCanvas.m - 13 * AvMain.Y, GameCanvas.p - 20, 1)};
      if (GameCanvas.m < 200) {
         z = 26;
         A = 32;
         F = new AvPosition[]{new AvPosition(GameCanvas.o, 30 + 23 * AvMain.Y, 2), new AvPosition(13 * AvMain.Y, GameCanvas.p - 20, 0), new AvPosition(GameCanvas.o, GameCanvas.q - GameCanvas.T - 5, 2), new AvPosition(GameCanvas.m - 13 * AvMain.Y, GameCanvas.p - 20, 1)};
      } else {
         z = 54;
         A = 72;
      }

      if (AvMain.Y == 2) {
         z = 144;
         A = 194;
      }

      if (j || k) {
         this.f();
      }

      MyScreen.an = null;
   }

   private void b() {
      f.removeAllElements();
      t();
      ReportDlg.a().b();
   }

   public final void c(String var1) {
      super.ac = null;
      super.ad = null;
      GameCanvas.b(var1, 50, (AvMain)null);
   }

   protected void h() {
      if (h(GameMidlet.i.w).H != 1) {
         if (MapScr.u && a > GameMidlet.i.a[3]) {
            BoardListOnScr.b().f();
         } else {
            boolean var1;
            if (var1 = !((Avatar)m.elementAt(s)).o) {
               w = 100;
            }

            o();
            GameCanvas.i();
            CasinoService.a().a(var1);
         }
      }
   }

   public static void o() {
      i.ad = E;
      i.ae = null;
   }

   protected void j() {
   }

   private static void m() {
      if (!j) {
         if (MapScr.u && a > GameMidlet.i.a[3]) {
            BoardListOnScr.b().f();
         } else {
            int var0 = 0;
            int var1 = 0;

            for(int var2 = 0; var2 < H; ++var2) {
               Avatar var3;
               if ((var3 = (Avatar)m.elementAt(var2)).w != GameMidlet.i.w && var3.w != -1) {
                  if (var3.o) {
                     ++var0;
                  } else {
                     ++var1;
                  }
               }
            }

            if (var0 != 0 && var1 <= 0) {
               if (i == PBoardScr.a) {
                  i.ad = E;
                  i.ae = null;
               } else {
                  GameCanvas.i();
               }

               MyScreen.z();
               CasinoService.a().h();
            } else {
               GameCanvas.b(T1.aT);
            }
         }
      }
   }

   public final void d(int var1, int var2) {
      Avatar var5;
      switch (var1) {
         case 1:
            Vector var6 = new Vector();
            Command var7 = new Command(T1.r, 10);
            Command var3 = new Command(T1.s, 11);
            Command var4 = new Command(T1.t, 12);
            var6.addElement(var7);
            if (LoadMap.a == 61) {
               var6.addElement(var3);
            }

            var6.addElement(var4);
            MenuSub.a().a(var6, 0);
            return;
         case 2:
            w();
            return;
         case 3:
            x();
            return;
         case 4:
            MessageScr.b().a((MyScreen)i);
            return;
         case 5:
            this.u();
            return;
         case 6:
         case 7:
         case 8:
         case 9:
         default:
            break;
         case 10:
            GameCanvas.u.a(T1.G, 100, 1);
            return;
         case 11:
            v();
            return;
         case 12:
            GameCanvas.u.a(T1.t, 101, 3);
            return;
         case 13:
            if (var2 < m.size()) {
               var5 = (Avatar)m.elementAt(var2);
               MapScr.b();
               MapScr.c(var5);
               return;
            }
            break;
         case 14:
            if (var2 >= 0 && var2 < m.size()) {
               var5 = (Avatar)m.elementAt(var2);
               CasinoService.a().c(var5.w);
               return;
            }
            break;
         case 15:
            CasinoService.a().a(var2 + 2);
      }

   }

   protected void a_() {
      u = 0L;
      t = 0L;
      j = false;
      k = false;
      l = false;
   }

   private static void t() {
      AvCamera.a().b = AvCamera.a().d = (LoadMap.f * LoadMap.i * AvMain.Y - GameCanvas.n) / 2;
      AvCamera.a().a = AvCamera.a().c = (LoadMap.e * LoadMap.i * AvMain.Y - GameCanvas.m) / 2;
   }

   public final void p() {
      this.f();
   }

   public final void a(int var1, Avatar var2) {
      m.setElementAt(var2, var1);
      this.n();
      this.f();
   }

   public void g() {
      t();
      MyScreen.z();
   }

   public void l() {
      if (GameCanvas.Z != 0) {
         GameCanvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public void k() {
      if (w > 0) {
         --w;
      }

      if (!j) {
         super.ac = b;
         AvCamera.a().c();
      }

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w != -1) {
            var2.d();
         }
      }

      if (g != null && g.a()) {
         g = null;
      }

   }

   public final void q() {
      if (r == GameMidlet.i.w) {
         if (super.ad != E) {
            super.ad = c;
            c.a = T1.n;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < H; ++var2) {
            Avatar var3;
            if ((var3 = (Avatar)m.elementAt(var2)).w == -1) {
               var1 = false;
            } else if (var3.w != GameMidlet.i.w && !var3.o) {
               var1 = false;
            }
         }

         if (var1 && GameCanvas.l % 10 > 7) {
            c.a = "";
            return;
         }
      } else if (!k) {
         super.ad = d;
         d.a = T1.j;

         for(int var4 = 0; var4 < H; ++var4) {
            Avatar var5;
            if ((var5 = (Avatar)m.elementAt(var4)).w == GameMidlet.i.w) {
               if (!var5.o) {
                  if (GameCanvas.l % 10 > 7) {
                     d.a = "";
                  }
               } else {
                  d.a = T1.k;
                  if (w == 0) {
                     super.ad = d;
                  } else {
                     super.ad = null;
                  }
               }
            }
         }
      }

   }

   public final void d(int var1) {
      class_im.d().a(var1, this);
      super.d(var1);
   }

   public void a(Graphics var1) {
      if (g != null) {
         g.a(var1);
      }

      if (OnScreen.b) {
         OnScreen.a(var1, super.ac, super.ad, super.ae);
      } else {
         super.a(var1);
      }

      LoadMap.a(var1);
      GameCanvas.b(var1);
   }

   public void a_(Graphics var1) {
      GameCanvas.c(var1);

      for(int var2 = 0; var2 < H; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar)m.elementAt(var2)).w != -1) {
            var3.a(var1, var3.aw, var3.ax);
            a(var1, var3.aw, var3.ax - 50 - (!j && LoadMap.y == -1 ? 10 * AvMain.Y : 0), 3, var3);
            var3.a(var1, var3.aw, var3.ax, false);
         }
      }

   }

   public static void d(Graphics var0) {
      for(int var1 = 0; var1 < m.size(); ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w != -1 && var2.O != null) {
            var2.O.a(var0);
         }
      }

   }

   public void b(Graphics var1) {
      GameCanvas.c(var1);
      var1.setClip(0, 0, GameCanvas.m, GameCanvas.n + GameCanvas.T);
      if (!j && !k) {
         GameCanvas.c(var1);
         if (OnScreen.b) {
            e(var1);
         } else {
            var1.setClip(0, 0, GameCanvas.m, GameCanvas.n + GameCanvas.T);
            var1.setColor(0);
            var1.fillRect(0, 0, GameCanvas.m, GameCanvas.n + GameCanvas.T);
            var1.translate(-AvCamera.a().a, -AvCamera.a().b);
            GameCanvas.x.c(var1);
            if (GameCanvas.m > 150) {
               GameCanvas.N.a(var1, RoomListOnScr.c, AvCamera.a().a + GameCanvas.o, AvCamera.a().b + GameCanvas.p - AvMain.af - AvMain.af / 2 - 5, 2);
               GameCanvas.N.a(var1, "P: " + p + " - B: " + q, AvCamera.a().a + GameCanvas.o, AvCamera.a().b + GameCanvas.p - AvMain.af / 2 - 5, 2);
               GameCanvas.Q.a(var1, a + T1.k(), AvCamera.a().a + GameCanvas.o, AvCamera.a().b + GameCanvas.p - 5 + AvMain.af / 2, 2);
               d(var1);
            }

         }
      } else {
         e(var1);
      }
   }

   private static void e(Graphics var0) {
      GameCanvas.S.b(var0);
      if (!j) {
         GameCanvas.K.a(var0, "P: " + p + " - B: " + q, GameCanvas.o, GameCanvas.n / 2 - 10 * AvMain.Y, 2);
         GameCanvas.Q.a(var0, a + T1.k(), GameCanvas.o, GameCanvas.n / 2 + 10 * AvMain.Y, 2);
      } else {
         if (GameCanvas.r == DiamondScr.a) {
            DiamondScr.a.c(var0);
         }

      }
   }

   public static void a(Graphics var0, int var1, int var2, int var3, Avatar var4) {
      if (!j) {
         if (var4.w == r) {
            var0.drawImage(e[1], var1, var2, 3);
            return;
         }

         if (var4.o) {
            var0.drawImage(e[0], var1, var2, 3);
         }
      }

   }

   private void u() {
      if (j && !k && !l) {
         GameCanvas.a(T1.cv, 0, this);
      } else {
         this.a(0);
      }
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            GameCanvas.J = 0;
            this.a_();
            CasinoService.a().g();
            CasinoService.a().a(p);
            if (H == 2) {
               this.c("");
            }

            t();
            GameCanvas.i();
         default:
      }
   }

   public void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Command var6 = new Command(T1.ab, 1);
            Command var7 = new Command(T1.v, 2);
            int var3 = 0;

            for(int var4 = 0; var4 < H; ++var4) {
               if (((Avatar)m.elementAt(var4)).w != -1) {
                  ++var3;
               }
            }

            Vector var8 = new Vector();
            if (r == GameMidlet.i.w && !j) {
               var8.addElement(var6);
               if (var3 > 1) {
                  var8.addElement(var7);
               }
            }

            if (var3 > 1) {
               var8.addElement(new Command(T1.y, 3));
            }

            var8.addElement(new Command(T1.q, 4));
            var8.addElement(new Command(T1.u, 5));
            MenuSub.a().a(var8, 0);
            return;
         case 1:
            i.b();
            return;
         case 2:
            m();
            return;
         case 3:
            i.g();
            return;
         case 4:
            i.j();
            return;
         case 5:
            i.h();
            return;
         case 6:
            return;
         case 50:
            this.g();
            this.b();
            j = false;
            this.B = -1;
            v = 0;
            return;
         case 100:
            try {
               if ((var1 = Integer.parseInt(GameCanvas.u.a())) < 0) {
                  return;
               } else {
                  GameCanvas.h();
                  if (MapScr.u && var1 > GameMidlet.i.a[3]) {
                     BoardListOnScr.b().f();
                     return;
                  }

                  CasinoService.a().b(var1);
                  return;
               }
            } catch (Exception var5) {
               return;
            }
         case 101:
            CasinoService.a().b(GameCanvas.u.a());
            GameCanvas.b(T1.I);
         default:
      }
   }

   private static void v() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < 3; ++var1) {
         var0.addElement(new Command(T1.ej[var1], 15, var1));
      }

      MenuSub.a().a(var0, 0);
   }

   private static void w() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w != GameMidlet.i.w && var2.w != -1) {
            var0.addElement(new Command(var2.l, 14, var1));
         }
      }

      MenuSub.a().a(var0, 0);
   }

   private static void x() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w != GameMidlet.i.w && var2.w != -1) {
            var0.addElement(new Command(var2.x, 13, var1));
         }
      }

      if (var0.size() == 1) {
         ((Command)var0.elementAt(0)).b();
      }

      MenuSub.a().a(var0, 0);
   }

   public final void e(int var1) {
      Avatar var2;
      if ((var2 = h(var1)) != null) {
         a(var2.x + T1.aU, 30, var2.w);
         var2.w = -1;
         var2.a("");
         var2.d(0);
         var2.o = false;
      }

      this.n();
      if (j || k) {
         this.f();
      }

   }

   public static void f(int var0) {
      r = var0;
      Avatar var1;
      if ((var1 = h(var0)) != null) {
         var1.o = true;
      }

   }

   public void a(byte var1, byte var2, int var3, int var4, Vector var5) {
      if (e == null) {
         e = new Image[2];

         try {
            e[0] = Image.createImage(T1.a() + "/on/ready.on");
            e[1] = Image.createImage(T1.a() + "/on/owner.on");
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

      p = (byte)var1;
      q = var2;
      a = var4;
      if (m != null) {
         m.removeAllElements();
      }

      m = var5;
      f(var3);

      for(var1 = 0; var1 < H; ++var1) {
         Avatar var8;
         (var8 = (Avatar)m.elementAt(var1)).K = 0;
         var8.b((byte)2);
         var8.f(var8.H);
         if (var8.w == GameMidlet.i.w) {
            s = (byte)var1;
            break;
         }
      }

      this.n();
      if (H > 2) {
         GameCanvas.S.b();
      }

   }

   public static void r() {
      for(int var0 = 0; var0 < H; ++var0) {
         ((Avatar)m.elementAt(var0)).o = false;
      }

   }

   public final void g(int var1) {
      a = var1;
      r();
   }

   public static void b(int var0, boolean var1) {
      Avatar var2;
      if ((var2 = h(var0)) != null) {
         var2.o = var1;
      }

   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         CasinoService.a().a(var1);
         a(GameMidlet.i.w, var1);
      }
   }

   public static void a(int var0, String var1) {
      Avatar var3 = h(var0);
      Avatar var2 = new Avatar();
      if (var3 != null) {
         var2.aw = var3.aw;
         var2.ax = var3.ax;
         var2.w = var3.w;
         if (var2.w != -1) {
            if (j && BoardListOnScr.e == 0) {
               var2.aw = GameCanvas.o;
               if (var2.w != GameMidlet.i.w) {
                  var2.ax = 30;
               } else {
                  var2.ax = GameCanvas.n - 40;
               }
            }

            a(var1, 50, var2.w);
         }

      }
   }

   public static void c(int var0, int var1) {
      if (var1 != 0) {
         if (!j) {
            var0 = i(var0);
            GameCanvas.a(var1, F[x[var0]].a, F[x[var0]].b, -1, -1);
         } else {
            Avatar var2 = h(var0);
            GameCanvas.a(var1, var2.aw, var2.ax, -1, -1);
         }
      }
   }

   public static boolean a(byte var0, byte var1) {
      return p == var0 && q == var1;
   }

   public final void s() {
      this.n();
   }

   public static void a(String var0, int var1, int var2) {
      if (var2 == -1) {
         if (g == null) {
            (g = new ChatPopup(var1, var0, (byte)0)).a(GameCanvas.o, GameCanvas.p - 20);
         } else {
            g.a(var1, var0);
         }
      } else {
         for(int var3 = 0; var3 < m.size(); ++var3) {
            Base var4;
            if ((var4 = (Base)m.elementAt(var3)).w == var2) {
               if (var4.O == null) {
                  var4.O = new ChatPopup(var1, var0, (byte)0);
                  var4.O.a(var4.aw, var4.ax - 45);
               } else {
                  var4.O.a(var1, var0);
               }
            }
         }

      }
   }

   public void n() {
      int var1 = 0;
      int var2 = 0;

      for(int var3 = 0; var3 < H; ++var3) {
         Avatar var4;
         (var4 = (Avatar)m.elementAt(var3)).b((byte)0);
         if (var4.w != -1) {
            ++var1;
            if (var4.w != GameMidlet.i.w) {
               var2 = var3;
            }
         }
      }

      int[] var5 = new int[H];
      int var6 = 2;
      if (var1 == 2) {
         var5[s] = 2;
         var5[var2] = 0;
      } else {
         for(var1 = s; var1 < s + H; ++var1) {
            var2 = var1;
            if (var1 > H - 1) {
               var2 = var1 - H;
            }

            var5[var2] = var6++;
            if (var6 >= H) {
               var6 = 0;
            }
         }
      }

      x = var5;
   }

   public static Avatar h(int var0) {
      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w == var0) {
            return var2;
         }
      }

      return null;
   }

   public static int i(int var0) {
      for(int var1 = 0; var1 < H; ++var1) {
         if (((Avatar)m.elementAt(var1)).w == var0) {
            return var1;
         }
      }

      return -1;
   }

   public void f() {
      AvCamera.a().b(0, 0);

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).w != -1) {
            var2.h = 0;
            var2.b((byte)0);
            var2.f(var2.H);
            var2.C = var2.aw = F[x[var1]].a;
            var2.D = var2.ax = F[x[var1]].b;
            if (x[var1] != 2 && x[var1] != 3) {
               var2.K = var2.t = 0;
            } else {
               var2.K = var2.t = Base.J;
            }
         }
      }

   }
}

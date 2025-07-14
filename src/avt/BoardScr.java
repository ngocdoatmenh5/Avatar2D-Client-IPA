package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
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
      Canvas.e();
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
      F = new AvPosition[]{new AvPosition(Canvas.o, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.o, Canvas.n - 28, 2), new AvPosition(Canvas.m - 13 * AvMain.hd, Canvas.hh - 20, 1)};
      if (Canvas.m < 200) {
         z = 26;
         A = 32;
         F = new AvPosition[]{new AvPosition(Canvas.o, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.o, Canvas.q - Canvas.T - 5, 2), new AvPosition(Canvas.m - 13 * AvMain.hd, Canvas.hh - 20, 1)};
      } else {
         z = 54;
         A = 72;
      }

      if (AvMain.hd == 2) {
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
      Canvas.b(var1, 50, (AvMain)null);
   }

   protected void h() {
      if (h(GameMidlet.avatar.IDDB).action != 1) {
         if (MapScr.isNewVersion && a > GameMidlet.avatar.money[3]) {
            BoardListOnScr.b().f();
         } else {
            boolean var1;
            if (var1 = !((Avatar)m.elementAt(s)).isReady) {
               w = 100;
            }

            o();
            Canvas.i();
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
         if (MapScr.isNewVersion && a > GameMidlet.avatar.money[3]) {
            BoardListOnScr.b().f();
         } else {
            int var0 = 0;
            int var1 = 0;

            for(int var2 = 0; var2 < H; ++var2) {
               Avatar var3;
               if ((var3 = (Avatar)m.elementAt(var2)).IDDB != GameMidlet.avatar.IDDB && var3.IDDB != -1) {
                  if (var3.isReady) {
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
                  Canvas.i();
               }

               MyScreen.z();
               CasinoService.a().h();
            } else {
               Canvas.b(T1.aT);
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
            Canvas.u.a(T1.G, 100, 1);
            return;
         case 11:
            v();
            return;
         case 12:
            Canvas.u.a(T1.t, 101, 3);
            return;
         case 13:
            if (var2 < m.size()) {
               var5 = (Avatar)m.elementAt(var2);
               MapScr.gI();
               MapScr.c(var5);
               return;
            }
            break;
         case 14:
            if (var2 >= 0 && var2 < m.size()) {
               var5 = (Avatar)m.elementAt(var2);
               CasinoService.a().c(var5.IDDB);
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
      AvCamera.gI().yCam = AvCamera.gI().d = (LoadMap.f * LoadMap.i * AvMain.hd - Canvas.n) / 2;
      AvCamera.gI().xCam = AvCamera.gI().c = (LoadMap.wMap * LoadMap.i * AvMain.hd - Canvas.m) / 2;
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
      if (Canvas.Z != 0) {
         Canvas.S.a(super.ac, super.ad, super.ae);
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
         AvCamera.gI().c();
      }

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != -1) {
            var2.updateFrame();
         }
      }

      if (g != null && g.a()) {
         g = null;
      }

   }

   public final void q() {
      if (r == GameMidlet.avatar.IDDB) {
         if (super.ad != E) {
            super.ad = c;
            c.a = T1.n;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < H; ++var2) {
            Avatar var3;
            if ((var3 = (Avatar)m.elementAt(var2)).IDDB == -1) {
               var1 = false;
            } else if (var3.IDDB != GameMidlet.avatar.IDDB && !var3.isReady) {
               var1 = false;
            }
         }

         if (var1 && Canvas.gameTick % 10 > 7) {
            c.a = "";
            return;
         }
      } else if (!k) {
         super.ad = d;
         d.a = T1.j;

         for(int var4 = 0; var4 < H; ++var4) {
            Avatar var5;
            if ((var5 = (Avatar)m.elementAt(var4)).IDDB == GameMidlet.avatar.IDDB) {
               if (!var5.isReady) {
                  if (Canvas.gameTick % 10 > 7) {
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
         g.paintAnimal(var1);
      }

      if (OnScreen.b) {
         OnScreen.a(var1, super.ac, super.ad, super.ae);
      } else {
         super.a(var1);
      }

      LoadMap.a(var1);
      Canvas.b(var1);
   }

   public void a_(Graphics var1) {
      Canvas.resetTrans(var1);

      for(int var2 = 0; var2 < H; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar)m.elementAt(var2)).IDDB != -1) {
            var3.paintName(var1, var3.x, var3.y);
            a(var1, var3.x, var3.y - 50 - (!j && LoadMap.y == -1 ? 10 * AvMain.hd : 0), 3, var3);
            var3.paintIcon(var1, var3.x, var3.y, false);
         }
      }

   }

   public static void d(Graphics var0) {
      for(int var1 = 0; var1 < m.size(); ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != -1 && var2.chat != null) {
            var2.chat.paintAnimal(var0);
         }
      }

   }

   public void b(Graphics var1) {
      Canvas.resetTrans(var1);
      var1.setClip(0, 0, Canvas.m, Canvas.n + Canvas.T);
      if (!j && !k) {
         Canvas.resetTrans(var1);
         if (OnScreen.b) {
            e(var1);
         } else {
            var1.setClip(0, 0, Canvas.m, Canvas.n + Canvas.T);
            var1.setColor(0);
            var1.fillRect(0, 0, Canvas.m, Canvas.n + Canvas.T);
            var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
            Canvas.x.c(var1);
            if (Canvas.m > 150) {
               Canvas.N.a(var1, RoomListOnScr.c, AvCamera.gI().xCam + Canvas.o, AvCamera.gI().yCam + Canvas.hh - AvMain.af - AvMain.af / 2 - 5, 2);
               Canvas.N.a(var1, "P: " + p + " - B: " + q, AvCamera.gI().xCam + Canvas.o, AvCamera.gI().yCam + Canvas.hh - AvMain.af / 2 - 5, 2);
               Canvas.smallFontYellow.a(var1, a + T1.k(), AvCamera.gI().xCam + Canvas.o, AvCamera.gI().yCam + Canvas.hh - 5 + AvMain.af / 2, 2);
               d(var1);
            }

         }
      } else {
         e(var1);
      }
   }

   private static void e(Graphics var0) {
      Canvas.S.b(var0);
      if (!j) {
         Canvas.K.a(var0, "P: " + p + " - B: " + q, Canvas.o, Canvas.n / 2 - 10 * AvMain.hd, 2);
         Canvas.smallFontYellow.a(var0, a + T1.k(), Canvas.o, Canvas.n / 2 + 10 * AvMain.hd, 2);
      } else {
         if (Canvas.currentMyScreen == DiamondScr.a) {
            DiamondScr.a.c(var0);
         }

      }
   }

   public static void a(Graphics var0, int var1, int var2, int var3, Avatar var4) {
      if (!j) {
         if (var4.IDDB == r) {
            var0.drawImage(e[1], var1, var2, 3);
            return;
         }

         if (var4.isReady) {
            var0.drawImage(e[0], var1, var2, 3);
         }
      }

   }

   private void u() {
      if (j && !k && !l) {
         Canvas.a(T1.cv, 0, this);
      } else {
         this.a(0);
      }
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            Canvas.J = 0;
            this.a_();
            CasinoService.a().g();
            CasinoService.a().a(p);
            if (H == 2) {
               this.c("");
            }

            t();
            Canvas.i();
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
               if (((Avatar)m.elementAt(var4)).IDDB != -1) {
                  ++var3;
               }
            }

            Vector var8 = new Vector();
            if (r == GameMidlet.avatar.IDDB && !j) {
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
               if ((var1 = Integer.parseInt(Canvas.u.a())) < 0) {
                  return;
               } else {
                  Canvas.h();
                  if (MapScr.isNewVersion && var1 > GameMidlet.avatar.money[3]) {
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
            CasinoService.a().b(Canvas.u.a());
            Canvas.b(T1.I);
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
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != GameMidlet.avatar.IDDB && var2.IDDB != -1) {
            var0.addElement(new Command(var2.showName, 14, var1));
         }
      }

      MenuSub.a().a(var0, 0);
   }

   private static void x() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != GameMidlet.avatar.IDDB && var2.IDDB != -1) {
            var0.addElement(new Command(var2.name, 13, var1));
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
         a(var2.name + T1.aU, 30, var2.IDDB);
         var2.IDDB = -1;
         var2.setName("");
         var2.setExp(0);
         var2.isReady = false;
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
         var1.isReady = true;
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
         (var8 = (Avatar)m.elementAt(var1)).direct = 0;
         var8.setAction((byte)2);
         var8.setFrame(var8.action);
         if (var8.IDDB == GameMidlet.avatar.IDDB) {
            s = (byte)var1;
            break;
         }
      }

      this.n();
      if (H > 2) {
         Canvas.S.b();
      }

   }

   public static void r() {
      for(int var0 = 0; var0 < H; ++var0) {
         ((Avatar)m.elementAt(var0)).isReady = false;
      }

   }

   public final void g(int var1) {
      a = var1;
      r();
   }

   public static void b(int var0, boolean var1) {
      Avatar var2;
      if ((var2 = h(var0)) != null) {
         var2.isReady = var1;
      }

   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         CasinoService.a().a(var1);
         a(GameMidlet.avatar.IDDB, var1);
      }
   }

   public static void a(int var0, String var1) {
      Avatar var3 = h(var0);
      Avatar var2 = new Avatar();
      if (var3 != null) {
         var2.x = var3.x;
         var2.y = var3.y;
         var2.IDDB = var3.IDDB;
         if (var2.IDDB != -1) {
            if (j && BoardListOnScr.e == 0) {
               var2.x = Canvas.o;
               if (var2.IDDB != GameMidlet.avatar.IDDB) {
                  var2.y = 30;
               } else {
                  var2.y = Canvas.n - 40;
               }
            }

            a(var1, 50, var2.IDDB);
         }

      }
   }

   public static void c(int var0, int var1) {
      if (var1 != 0) {
         if (!j) {
            var0 = i(var0);
            Canvas.a(var1, F[x[var0]].a, F[x[var0]].b, -1, -1);
         } else {
            Avatar var2 = h(var0);
            Canvas.a(var1, var2.x, var2.y, -1, -1);
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
            (g = new ChatPopup(var1, var0, (byte)0)).setPos(Canvas.o, Canvas.hh - 20);
         } else {
            g.a(var1, var0);
         }
      } else {
         for(int var3 = 0; var3 < m.size(); ++var3) {
            Base var4;
            if ((var4 = (Base)m.elementAt(var3)).IDDB == var2) {
               if (var4.chat == null) {
                  var4.chat = new ChatPopup(var1, var0, (byte)0);
                  var4.chat.setPos(var4.x, var4.y - 45);
               } else {
                  var4.chat.a(var1, var0);
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
         (var4 = (Avatar)m.elementAt(var3)).setAction((byte)0);
         if (var4.IDDB != -1) {
            ++var1;
            if (var4.IDDB != GameMidlet.avatar.IDDB) {
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
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB == var0) {
            return var2;
         }
      }

      return null;
   }

   public static int i(int var0) {
      for(int var1 = 0; var1 < H; ++var1) {
         if (((Avatar)m.elementAt(var1)).IDDB == var0) {
            return var1;
         }
      }

      return -1;
   }

   public void f() {
      AvCamera.gI().b(0, 0);

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != -1) {
            var2.ySat = 0;
            var2.setAction((byte)0);
            var2.setFrame(var2.action);
            var2.xCur = var2.x = F[x[var1]].a;
            var2.yCur = var2.y = F[x[var1]].b;
            if (x[var1] != 2 && x[var1] != 3) {
               var2.direct = var2.dirLast = 0;
            } else {
               var2.direct = var2.dirLast = Base.LEFT;
            }
         }
      }

   }
}

package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public abstract class BoardScr extends MyScreen implements IChatable {
   public static BoardScr me;
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
      me = this;
   }

   public BoardScr() {
      this.init();
      b = new Command(T.c, 0);
      new Command(T.z, 1);
      c = new Command(T.n, 2);
      C = new Command(T.w, 3);
      D = new Command(T.A, 4);
      d = new Command(T.j, 5);
      E = new Command(T.b, 6);
   }

   public void init() {
      F = new AvPosition[]{new AvPosition(Canvas.hw, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.hw, Canvas.h - 28, 2), new AvPosition(Canvas.w - 13 * AvMain.hd, Canvas.hh - 20, 1)};
      if (Canvas.w < 200) {
         z = 26;
         A = 32;
         F = new AvPosition[]{new AvPosition(Canvas.hw, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.hw, Canvas.q - Canvas.hTab - 5, 2), new AvPosition(Canvas.w - 13 * AvMain.hd, Canvas.hh - 20, 1)};
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
      super.left = null;
      super.center = null;
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
            Canvas.startWaitDlg();
            CasinoService.a().a(var1);
         }
      }
   }

   public static void o() {
      me.center = E;
      me.right = null;
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
               if (me == PBoardScr.a) {
                  me.center = E;
                  me.right = null;
               } else {
                  Canvas.startWaitDlg();
               }

               MyScreen.z();
               CasinoService.a().h();
            } else {
               Canvas.startOKDlg(T.aT);
            }
         }
      }
   }

   public final void d(int var1, int var2) {
      Avatar var5;
      switch (var1) {
         case 1:
            Vector var6 = new Vector();
            Command var7 = new Command(T.r, 10);
            Command var3 = new Command(T.s, 11);
            Command var4 = new Command(T.t, 12);
            var6.addElement(var7);
            if (LoadMap.TYPEMAP == 61) {
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
            MessageScr.b().a((MyScreen) me);
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
            Canvas.inputDlg.a(T.G, 100, 1);
            return;
         case 11:
            v();
            return;
         case 12:
            Canvas.inputDlg.a(T.t, 101, 3);
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
      AvCamera.gI().yCam = AvCamera.gI().yTo = (LoadMap.Hmap * LoadMap.i * AvMain.hd - Canvas.h) / 2;
      AvCamera.gI().xCam = AvCamera.gI().xTo = (LoadMap.wMap * LoadMap.i * AvMain.hd - Canvas.w) / 2;
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

   public void updateKey() {
      if (Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }

   public void k() {
      if (w > 0) {
         --w;
      }

      if (!j) {
         super.left = b;
         AvCamera.gI().updateTo();
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
         if (super.center != E) {
            super.center = c;
            c.a = T.n;
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
         super.center = d;
         d.a = T.j;

         for(int var4 = 0; var4 < H; ++var4) {
            Avatar var5;
            if ((var5 = (Avatar)m.elementAt(var4)).IDDB == GameMidlet.avatar.IDDB) {
               if (!var5.isReady) {
                  if (Canvas.gameTick % 10 > 7) {
                     d.a = "";
                  }
               } else {
                  d.a = T.k;
                  if (w == 0) {
                     super.center = d;
                  } else {
                     super.center = null;
                  }
               }
            }
         }
      }

   }

   public final void d(int var1) {
      ChatTextField.gI().a(var1, this);
      super.d(var1);
   }

   public void paint(Graphics var1) {
      if (g != null) {
         g.paintAnimal(var1);
      }

      if (OnScreen.b) {
         OnScreen.a(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
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
      var1.setClip(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
      if (!j && !k) {
         Canvas.resetTrans(var1);
         if (OnScreen.b) {
            e(var1);
         } else {
            var1.setClip(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
            var1.setColor(0);
            var1.fillRect(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
            var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
            Canvas.loadMap.c(var1);
            if (Canvas.w > 150) {
               Canvas.N.a(var1, RoomListOnScr.c, AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - AvMain.af - AvMain.af / 2 - 5, 2);
               Canvas.N.a(var1, "P: " + p + " - B: " + q, AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - AvMain.af / 2 - 5, 2);
               Canvas.smallFontYellow.a(var1, a + T.k(), AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - 5 + AvMain.af / 2, 2);
               d(var1);
            }

         }
      } else {
         e(var1);
      }
   }

   private static void e(Graphics var0) {
      Canvas.paint.b(var0);
      if (!j) {
         Canvas.K.a(var0, "P: " + p + " - B: " + q, Canvas.hw, Canvas.h / 2 - 10 * AvMain.hd, 2);
         Canvas.smallFontYellow.a(var0, a + T.k(), Canvas.hw, Canvas.h / 2 + 10 * AvMain.hd, 2);
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
         Canvas.a(T.cv, 0, this);
      } else {
         this.a(0);
      }
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            Canvas.load = 0;
            this.a_();
            CasinoService.a().g();
            CasinoService.a().a(p);
            if (H == 2) {
               this.c("");
            }

            t();
            Canvas.startWaitDlg();
         default:
      }
   }

   public void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Command var6 = new Command(T.ab, 1);
            Command var7 = new Command(T.v, 2);
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
               var8.addElement(new Command(T.y, 3));
            }

            var8.addElement(new Command(T.q, 4));
            var8.addElement(new Command(T.u, 5));
            MenuSub.a().a(var8, 0);
            return;
         case 1:
            me.b();
            return;
         case 2:
            m();
            return;
         case 3:
            me.g();
            return;
         case 4:
            me.j();
            return;
         case 5:
            me.h();
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
               if ((var1 = Integer.parseInt(Canvas.inputDlg.a())) < 0) {
                  return;
               } else {
                  Canvas.endDlg();
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
            CasinoService.a().b(Canvas.inputDlg.a());
            Canvas.startOKDlg(T.I);
         default:
      }
   }

   private static void v() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < 3; ++var1) {
         var0.addElement(new Command(T.ej[var1], 15, var1));
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
         a(var2.name + T.aU, 30, var2.IDDB);
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
            e[0] = Image.createImage(T.a() + "/on/ready.on");
            e[1] = Image.createImage(T.a() + "/on/owner.on");
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
         Canvas.paint.b();
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
               var2.x = Canvas.hw;
               if (var2.IDDB != GameMidlet.avatar.IDDB) {
                  var2.y = 30;
               } else {
                  var2.y = Canvas.h - 40;
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
            Canvas.a(var1, F[x[var0]].x, F[x[var0]].y, -1, -1);
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
            (g = new ChatPopup(var1, var0, (byte)0)).setPos(Canvas.hw, Canvas.hh - 20);
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
      AvCamera.gI().setPos(0, 0);

      for(int var1 = 0; var1 < H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)m.elementAt(var1)).IDDB != -1) {
            var2.ySat = 0;
            var2.setAction((byte)0);
            var2.setFrame(var2.action);
            var2.xCur = var2.x = F[x[var1]].x;
            var2.yCur = var2.y = F[x[var1]].y;
            if (x[var1] != 2 && x[var1] != 3) {
               var2.direct = var2.dirLast = 0;
            } else {
               var2.direct = var2.dirLast = Base.LEFT;
            }
         }
      }

   }
}

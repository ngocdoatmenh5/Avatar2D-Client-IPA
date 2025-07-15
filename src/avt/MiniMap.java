package avt;

import java.util.Vector;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;
import main.Canvas;
import main.GameMidlet;

public final class MiniMap extends MyScreen {
   public static MiniMap a;
   private FrameImage p;
   public FrameImage b;
   private byte[] q;
   private Vector r;
   private byte s;
   private byte t;
   private byte u = 16;
   public int c;
   public int d;
   private static Image v;
   private static Image w;
   public int e;
   private static int x;
   public static int f;
   private static int y;
   private static int z;
   private static int A;
   private static int B;
   public static int g;
   private static int C;
   private static int D;
   private static int E;
   public IAction h;
   public static String i;
   private boolean F;
   public static boolean j = false;
   public static Image[] k = new Image[2];
   private static Vector G = new Vector();
   private static FrameImage H;
   public Command l;
   private Command I;
   private int J;
   private int K;
   private int L;
   private int M;
   boolean m = false;
   private int N;
   private int O;
   private long P;
   private long Q;
   public static IAction n;
   public static byte o;

   public static MiniMap gI() {
      return a == null ? (a = new MiniMap()) : a;
   }

   public final void switchToMe() {
      super.switchToMe();
      if (!GlobalLogicHandler.isNewVersion) {
         Canvas.endDlg();
      }

      if (LoadMap.y != -1) {
         Canvas.endDlg();
      }

      super.left = this.l;
      if (Canvas.isInitChar) {
         (Canvas.welcome = new Welcome()).a();
         super.left = null;
      } else if (MyScreen.as > 0 && o == 1) {
         MessageScr.gI().a(Canvas.currentMyScreen);
      }

      if (Canvas.load == 0) {
         Canvas.load = 1;
      }

      Canvas.currentEffect.removeAllElements();
      this.g();
      MapScr.G = -1;
   }

   public MiniMap() {
      FilePack.b(T.aw);
      this.b = FrameImage.init("up", 13 * AvMain.hd, 11 * AvMain.hd);
      FilePack.reset();
      FilePack.b(T.av);
      v = FilePack.getImage("sIc");
      w = FilePack.getImage("b_p");
      FilePack.reset();
      this.l = new Command(T.c, 0);
      super.left = this.l;
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            if (Canvas.welcome == null || !Welcome.isPaintArrow) {
               Vector var3 = new Vector();
               if (n != null) {
                  var3.addElement(new Command("Đăng ký", n));
               }

               if (Canvas.stypeInt == 0) {
                  var3.addElement(MapScr.gI().f);
               }

               var3.addElement(new Command(T.ab, 1));
               var3.addElement(new Command(T.cw, 2));
               if (!LoginScr.w) {
                  var3.addElement(new Command(T.cx, 3));
               }

               var3.addElement(new Command(T.cF, 4));
               var3.addElement(new Command(T.cJ, 5));
               var3.addElement(new Command(T.x, 6));
               MenuSub.gI().startAt(var3, 0);
            }

            return;
         case 1:
            MapScr.gI().switchToMe();
            H = null;
         default:
      }
   }

   public final void commandActionPointer(int var1, int var2) {
      switch (var1) {
         case 1:
            OptionScr.gI().switchToMe();
            return;
         case 2:
            GlobalService.gI().requestService((byte)6, "");
            return;
         case 3:
            MapScr.gI().u();
            return;
         case 4:
            Form var5 = new Form(T.cG);
            TextField var6 = new TextField(T.cH, "", 50, 3);
            var5.append(var6);
            var5.append(T.cI);
            javax.microedition.lcdui.Command var3 = new javax.microedition.lcdui.Command(T.z, 4, 1);
            var5.addCommand(var3);
            javax.microedition.lcdui.Command var4 = new javax.microedition.lcdui.Command(T.d, 2, 1);
            var5.addCommand(var4);
            var5.setCommandListener(new class_fs(this, var3, var6));
            Display.getDisplay(GameMidlet.h).setCurrent(var5);
            return;
         case 5:
            GlobalService.gI().requestService((byte)3, (String)null);
            return;
         case 6:
            MapScr.gI().v();
            return;
         case 7:
            Welcome.h();
            (Canvas.welcome = new Welcome()).a();
            super.left = null;
         default:
      }
   }

   public final void close() {
      if (!j && Canvas.currentMyScreen != class_ez.a) {
         MapScr.gI().switchToMe();
         H = null;
      } else {
         MapScr.gI().v();
      }
   }

   public final void a(FrameImage var1, byte[] var2, Vector var3, byte var4, int var5, Command var6) {
      AvatarData.getImgIcon((short)839);
      GameMidlet.avatar.ableShow = false;
      this.u = (byte)var5;
      this.p = var1;
      this.q = var2;
      this.r = var3;
      this.s = 34;
      this.I = var6;
      if (Canvas.stypeInt == 0) {
         super.center = var6;
      }

      this.t = (byte)(var2.length / this.s);
      super.right = null;
      this.init();
      this.h = null;
      G.removeAllElements();

      for(int var7 = 0; var7 < 7; ++var7) {
         G.addElement(new AvPosition(var7 * this.s * this.u / 10 + 50, CRes.rnd(10) * (this.t * this.u / 10) + 20, CRes.rnd(2)));
      }

      B = g = f = x = this.e = 0;
      this.g();
      if (j) {
         FilePack.b(T.av);
         H = new FrameImage(FilePack.getImage("k"), 40 * AvMain.hd, 40 * AvMain.hd);
         FilePack.reset();
      }

   }

   public final void init() {
      this.c = (Canvas.w - this.s * this.u) / 2;
      this.d = (Canvas.hCan - Canvas.hTab - this.t * this.u) / 2;
      if (this.c < 0) {
         this.c = 0;
      }

      if (this.d < 0) {
         this.d = 0;
      }

      A = this.s * this.u - Canvas.w;
      E = this.t * this.u - Canvas.hCan;
      if (A < 0) {
         f = 0;
         A = 0;
      }

      if (E < 0) {
         g = 0;
         E = 0;
      }

   }

   public final void update() {
      if (this.J != 0) {
         if (g < 0 || g > E) {
            this.J -= this.J / 4;
            g += this.J / 20;
            if (this.J / 10 <= 1) {
               this.J = 0;
            }
         }

         B = g += this.J / 10;
         this.J -= this.J / 10;
         if (this.J / 10 == 0) {
            this.J = 0;
         }
      }

      if (g < 0) {
         B = 0;
         this.J = 0;
      } else if (g > E) {
         B = E;
         this.J = 0;
      }

      if (this.K != 0) {
         if (f < 0 || f > A) {
            this.K -= this.K / 4;
            f += this.K / 20;
            if (this.K / 10 <= 1) {
               this.K = 0;
            }
         }

         f += this.K / 10;
         this.K -= this.K / 10;
         x = f;
         if (this.K / 10 == 0) {
            this.K = 0;
         }
      }

      if (f < 0) {
         x = 0;
         this.K = 0;
      } else if (f > A) {
         x = A;
         this.K = 0;
      }

      if (g != B) {
         D = B - g << 2;
         C += D;
         g += C >> 4;
         C &= 15;
      }

      if (f != x) {
         z = x - f << 2;
         y += z;
         f += y >> 4;
         y &= 15;
      }

      if (B < 0 || g < 0) {
         g = 0;
         B = 0;
      }

      if (B > E || g > E) {
         B = g = E;
      }

      if (x < 0 || f < 0) {
         f = 0;
         x = 0;
      }

      if (x > A || f > A) {
         x = f = A;
      }

      for(int var1 = 0; var1 < G.size(); ++var1) {
         AvPosition var2;
         AvPosition var10000 = var2 = (AvPosition)G.elementAt(var1);
         var10000.x -= var2.anchor + (Canvas.gameTick % 5 == 1 ? 1 : 0);
         if (var2.x < -this.c - 50) {
            var2.x = this.c + CRes.rnd(4) * 50 + this.s * this.u;
            var2.y = CRes.rnd(10) * (this.t * this.u / 10) + 10;
            var2.anchor = CRes.rnd(2);
         }
      }

   }

   public static void f() {
      FarmScr.l = "e";
      PopupShop.i = "f";
      LoginScr.t = "a";
      MapScr.j = Canvas.a(i, -2);
   }

   public final void updateKey() {
      ++this.Q;
      if (Canvas.welcome == null || !Welcome.isPaintArrow) {
         super.updateKey();
      }

      this.m = false;
      if (Canvas.isPointer(0, 0, Canvas.w, Canvas.h)) {
         int var1 = Canvas.dx();
         int var2 = Canvas.dy();
         int var3;
         class_kb var4;
         if (Canvas.welcome == null && Canvas.isPointerClick) {
            Canvas.isPointerClick = false;

            for(var3 = 0; var3 < this.r.size(); ++var3) {
               var4 = (class_kb)this.r.elementAt(var3);
               if (Canvas.isPointer(this.c + var4.a * this.u + this.u / 2 - 24 * AvMain.hd - f, this.d + var4.b * this.u - 56 * AvMain.hd - g, 48 * AvMain.hd, 56 * AvMain.hd)) {
                  this.e = var3;
                  return;
               }
            }
         }

         if (Canvas.isPointerDown) {
            if (Canvas.gameTick % 3 == 0) {
               this.N = Canvas.py;
               this.O = Canvas.px;
               this.P = this.Q;
            }

            this.J = 0;
            this.K = 0;
            if (!this.F) {
               this.F = true;
               this.L = f;
               this.M = g;
            }

            B = this.M + var2;
            x = this.L + var1;
            h();
            g = B;
            f = x;
         }

         if (Canvas.isPointerRelease) {
            var3 = (int)(this.Q - this.P);
            int var5 = this.N - Canvas.py;
            if (var3 < 10) {
               if (B >= 0 && B < E) {
                  this.J = var5 / var3 * 10;
               }

               var5 = this.O - Canvas.px;
               if (x >= 0 && x < A) {
                  this.K = var5 / var3 * 10;
               }
            }

            this.P = -1L;
            this.F = false;
            if (CRes.abs(var1) < 10 && CRes.abs(var2) < 10) {
               var4 = (class_kb)this.r.elementAt(this.e);
               if (Canvas.isPointer(this.c + var4.a * this.u + this.u / 2 - 24 * AvMain.hd - f, this.d + var4.b * this.u - 56 * AvMain.hd - g, 48 * AvMain.hd, 56 * AvMain.hd)) {
                  this.I.perform();
                  return;
               }

               x = Canvas.px + f - Canvas.hw;
               B = Canvas.py + g - Canvas.hh;
               h();
            }
         }
      }

      if (this.h == null) {
         if (!Canvas.a(2) && !Canvas.a(4)) {
            if (Canvas.a(8) || Canvas.a(6)) {
               ++this.e;
               if (this.e >= this.r.size()) {
                  this.e = 0;
               }

               this.m = true;
            }
         } else {
            --this.e;
            if (this.e < 0) {
               this.e = this.r.size() - 1;
            }

            this.m = true;
         }
      } else if (Canvas.welcome == null) {
         this.h.perform();
      }

      if (this.m) {
         this.g();
      }

   }

   private void g() {
      class_kb var1;
      x = (var1 = (class_kb)this.r.elementAt(this.e)).a * this.u - Canvas.w / 2;
      B = var1.b * this.u - Canvas.hCan / 2;
      h();
   }

   private static void h() {
      if (B < 0) {
         B = 0;
      }

      if (B > E) {
         B = E;
      }

      if (x < 0) {
         x = 0;
      }

      if (x > A) {
         x = A;
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      if (Canvas.welcome == null || !Welcome.isPaintArrow) {
         super.paint(var1);
      }

      Canvas.paintPlus(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.resetTrans(var1);
      var1.setColor(0);
      var1.fillRect(0, 0, Canvas.w, Canvas.hCan);
      var1.translate(this.c, this.d);
      var1.translate(-f, -g);

      int var2;
      int var4;
      for(var2 = 0; var2 < this.q.length; ++var2) {
         byte var3;
         var4 = (var3 = this.q[var2]) / this.p.nFrame;
         this.p.drawFrameXY(var4, var3 % this.p.nFrame, var2 % this.s * this.u, var2 / this.s * this.u, var1);
      }

      for(var2 = 0; var2 < this.r.size(); ++var2) {
         class_kb var9 = (class_kb)this.r.elementAt(var2);
         if (var2 == this.e) {
            var1.drawImage(w, var9.a * this.u + this.u / 2, var9.b * this.u, 33);
            if (j) {
               H.drawFrame(var2, var9.a * this.u + this.u / 2, var9.b * this.u - 12 * AvMain.hd, 0, 33, var1);
            } else {
               AvatarData.paintImg(var1, var9.d, var9.a * this.u + this.u / 2, var9.b * this.u - 12 * AvMain.hd, 33);
            }
         } else {
            var1.drawImage(v, var9.a * this.u + this.u / 2, var9.b * this.u - var9.e / 3, 33);
            ++var9.e;
            if (var9.e >= 9) {
               var9.e = 0;
            }
         }
      }

      Graphics var10 = var1;
      MiniMap var8 = this;

      for(var4 = 0; var4 < var8.r.size(); ++var4) {
         class_kb var5;
         int var6 = (var5 = (class_kb)var8.r.elementAt(var4)).a * var8.u;
         int var7;
         if ((var7 = var5.b * var8.u) < g + 50) {
            var7 = g + 50;
         }

         if (var7 > g + Canvas.hCan - 20) {
            var7 = g + Canvas.hCan - 20;
         }

         if (var6 < f + 20) {
            var6 = f + 20;
         }

         if (var6 > f + Canvas.w - 47) {
            var6 = f + Canvas.w - 47;
         }

         Canvas.borderFont.drawString(var10, var5.c, var6 + 10, var7 - (var4 == var8.e ? 70 * AvMain.hd : 35 * AvMain.hd) - var5.e / 3, 2);
      }

      Graphics var11 = var1;

      for(var4 = 0; var4 < G.size(); ++var4) {
         AvPosition var12;
         if ((var12 = (AvPosition)G.elementAt(var4)).x > f - 30 && var12.x < f + 30 + Canvas.w && var12.y > g - 20 && var12.y < g + 20 + Canvas.h) {
            var11.drawImage(k[var12.anchor], var12.x, var12.y, 3);
         }
      }

      Canvas.resetTrans(var1);
   }

   public final void a(byte var1, String var2, String var3, String var4) {
      System.out.println("onRegisterByEmail: " + var3 + "   " + var4);
      if (var1 == 0) {
         n = new class_ct(this, var2);
      } else if (var1 == 1) {
         n = new class_ay(this, var2);
      } else {
         if (var1 == 2) {
            LoginScr.gI().b.a(var3);
            LoginScr.gI().c.a(var4);
            LoginScr.gI().g();
            Canvas.startOKDlg("Đăng ký thành công.");
            n = null;
         }

      }
   }
}

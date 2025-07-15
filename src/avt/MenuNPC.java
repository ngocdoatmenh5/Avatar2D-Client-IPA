package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class MenuNPC extends MenuMain {
   private static MenuNPC b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   public static FrameImage a;
   private Vector n = new Vector();
   private String o;
   private String[] p;
   private boolean[] q;
   private int r = 0;
   private int s;
   private int t;
   private int u;
   private boolean v = false;
   private boolean w = false;
   private long x;
   private long y;
   private long z;
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int F;

   static {
      try {
         a = new FrameImage(Image.createImage(T.a() + "/race/popup/tile0.png"), 20 * AvMain.hd, 20 * AvMain.hd);
      } catch (IOException var1) {
         var1.printStackTrace();
      }
   }

   public static MenuNPC gI() {
      return b == null ? (b = new MenuNPC()) : b;
   }

   public MenuNPC() {
      this.f = 200 * AvMain.hd;
      this.g = 190 * AvMain.hd;
      this.d = (Canvas.w - this.f) / 2;
      this.e = (Canvas.h - this.g) / 2;
      this.i = 70 * AvMain.hd;
      this.j = 120 * AvMain.hd;
      this.h = this.f - this.j - 12 * AvMain.hd;
      this.l = 30 * AvMain.hd;
      this.k = this.l * 3 + 20 * AvMain.hd;
      super.center = new Command(T.O, 0, this);
      super.right = new Command(T.d, 1, this);
   }

   public final void commandTab(int var1) {
      switch (var1) {
         case 0:
            this.b();
            return;
         case 1:
            Canvas.menuMain = null;
         default:
      }
   }

   public final void setInfo(Vector var1, int var2, String var3, String var4, boolean[] var5) {
      this.n = var1;
      this.q = var5;
      this.c = var2;
      this.F = var1.size() * this.l - (this.k - 20 * AvMain.hd);
      if (this.F < 0) {
         this.F = 0;
      }

      this.o = var3;
      this.p = Canvas.M.splitFontBStrInLine(var4, this.f - 50 * AvMain.hd);
      Canvas.menuMain = this;
   }

   public final void update() {
      if (this.t > 0) {
         --this.t;
         if (this.t == 0) {
            this.b();
         }
      }

      if (this.A != 0) {
         if (this.C < 0 || this.C > this.F) {
            this.A -= this.A / 4;
            this.C += this.A / 20;
            if (this.A / 10 <= 1) {
               this.A = 0;
            }
         }

         if (this.C < 0) {
            if (this.C < -this.k / 2) {
               this.C = -this.k / 2;
               this.B = 0;
               this.A = 0;
            }
         } else if (this.C > this.F) {
            if (this.C < this.F + this.k / 2) {
               this.C = this.F + this.k / 2;
               this.B = this.F;
               this.A = 0;
            }
         } else {
            this.C += this.A / 10;
         }

         this.B = this.C;
         this.A -= this.A / 10;
         if (this.A / 10 == 0) {
            this.A = 0;
         }
      } else if (this.C < 0) {
         this.B = 0;
      } else if (this.C > this.F) {
         this.B = this.F;
      }

      if (this.C != this.B) {
         this.E = this.B - this.C << 2;
         this.D += this.E;
         this.C += this.D >> 4;
         this.D &= 15;
      }

   }

   public final void updateKey() {
      super.updateKey();
      ++this.y;
      boolean var1 = false;
      if (Canvas.a(2)) {
         --this.m;
         if (this.m < 0) {
            this.m = this.n.size() - 1;
         }

         var1 = true;
      } else if (Canvas.a(8)) {
         ++this.m;
         if (this.m >= this.n.size()) {
            this.m = 0;
         }

         var1 = true;
      }

      if (Canvas.isPointerClick) {
         this.u = Canvas.pyLast;
         this.w = false;
         if (Canvas.b(this.d + this.h, this.e + this.i, this.j, this.k)) {
            if (this.A != 0) {
               this.w = true;
            }

            Canvas.isPointerClick = false;
            this.r = this.B;
            this.x = this.y;
            this.v = true;
         }
      }

      if (this.v) {
         int var2 = this.u - Canvas.py;
         this.u = Canvas.py;
         long var3 = this.y - this.x;
         int var5;
         int var6;
         if (Canvas.isPointerDown) {
            if (this.y % 2L == 0L) {
               this.s = Canvas.py;
               this.z = this.y;
            }

            this.A = 0;
            if (Math.abs(var2) < 10 * AvMain.hd) {
               var5 = this.e + this.i + 10 * AvMain.hd;
               var6 = this.l;
               if ((var5 = (this.B + Canvas.py - var5) / var6) >= 0 && var5 < this.n.size()) {
                  this.m = var5;
               }
            }

            if (CRes.abs(Canvas.dy()) >= 10 * AvMain.hd) {
               super.aj = true;
            } else if (var3 > 3L && var3 < 8L) {
               var5 = this.e + this.i + 10 * AvMain.hd;
               var6 = this.l;
               if ((var5 = (this.B + Canvas.py - var5) / var6) >= 0 && var5 < this.n.size() && !this.w) {
                  super.aj = false;
               }
            }

            if (this.B < 0 || this.B > this.F) {
               this.B = this.r + var2 / 2;
               this.r = this.B;
            }

            this.C = this.B;
         }

         if (Canvas.isPointerRelease && Canvas.b(this.d, this.e, this.f, this.g)) {
            this.w = false;
            var5 = (int)(this.y - this.z);
            if (CRes.abs(var6 = this.s - Canvas.py) > 40 && var5 < 10 && this.B > 0 && this.B < this.F) {
               this.A = var6 / var5 * 10;
            }

            this.z = -1L;
            if (Math.abs(var2) < 10 * AvMain.hd) {
               if (var3 <= 4L) {
                  super.aj = false;
                  this.t = 5;
               } else if (!super.aj) {
                  this.b();
               }
            }

            this.v = false;
            Canvas.isPointerRelease = false;
         }
      } else if (Canvas.isPointerRelease && !Canvas.b(this.d, this.e, this.f, this.g)) {
         Canvas.isPointerRelease = false;
         Canvas.menuMain = null;
      }

      if (var1) {
         this.B = this.m * this.l - this.k / 2 + this.l / 2;
         if (this.B > this.F) {
            this.B = this.F;
            return;
         }

         if (this.B < 0) {
            this.B = 0;
         }
      }

   }

   private void b() {
      if (!this.q[this.m]) {
         Canvas.menuMain = null;
      } else {
         Canvas.startWaitDlg();
      }

      ((Command)this.n.elementAt(this.m)).perform();
   }

   public final void paint(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.paint.paintPopupBack(var1, this.d, this.e, this.f, this.g, 0);
      var1.translate(this.d, this.e);
      var1.setColor(695195);
      var1.fillRect(12 * AvMain.hd, 12 * AvMain.hd, this.f - 24 * AvMain.hd, 50 * AvMain.hd);
      var1.setColor(12648440);
      var1.fillRect(15 * AvMain.hd, 15 * AvMain.hd, this.f - 30 * AvMain.hd, 44 * AvMain.hd);

      int var2;
      for(var2 = 0; var2 < this.p.length; ++var2) {
         Canvas.fontChatB.drawString(var1, this.p[var2], 20 * AvMain.hd, 12 * AvMain.hd + 25 * AvMain.hd - this.p.length * AvMain.hBlack / 2 + var2 * AvMain.hBlack, 0);
      }

      Avatar var9 = LoadMap.getAvatar(this.c);
      Canvas.normalFont.drawString(var1, this.o, this.h / 2, this.i + this.k / 2 - AvMain.ah - 20 * AvMain.hd, 2);
      var9.paintIcon(var1, this.h / 2, this.i + this.k / 2 + var9.height, true);
      var2 = 4441283;
      FrameImage var7 = a;
      int var6 = this.k;
      int var5 = this.j;
      int var4 = this.i;
      int var3 = this.h;
      Graphics var10 = var1;
      var7.drawFrame(0, var3, var4, 0, var1);
      var7.drawFrame(2, var3 + var5 - var7.frameWidth, var4, 0, var1);
      var7.drawFrame(5, var3, var4 + var6 - var7.frameHeight, 0, var1);
      var7.drawFrame(7, var3 + var5 - var7.frameWidth, var4 + var6 - var7.frameHeight, 0, var1);

      int var8;
      for(var8 = 0; var8 < (var5 - (var7.frameWidth << 1)) / var7.frameWidth; ++var8) {
         var7.drawFrame(1, var3 + (var8 + 1) * var7.frameWidth, var4, 0, var10);
         var7.drawFrame(6, var3 + (var8 + 1) * var7.frameWidth, var4 + var6 - var7.frameHeight, 0, var10);
      }

      var7.drawFrame(1, var3 + var5 - (var7.frameWidth << 1), var4, 0, var10);
      var7.drawFrame(6, var3 + var5 - (var7.frameWidth << 1), var4 + var6 - var7.frameHeight, 0, var10);

      for(var8 = 0; var8 < (var6 - (var7.frameHeight << 1)) / var7.frameHeight; ++var8) {
         var7.drawFrame(3, var3, var4 + (var8 + 1) * var7.frameHeight, 0, var10);
         var7.drawFrame(4, var3 + var5 - var7.frameWidth, var4 + (var8 + 1) * var7.frameHeight, 0, var10);
      }

      var7.drawFrame(3, var3, var4 + var6 - (var7.frameHeight << 1), 0, var10);
      var7.drawFrame(4, var3 + var5 - var7.frameWidth, var4 + var6 - (var7.frameHeight << 1), 0, var10);
      var10.setColor(4441283);
      var10.fillRect(var3 + var7.frameWidth, var4 + var7.frameHeight, var5 - (var7.frameWidth << 1), var6 - (var7.frameHeight << 1));
      var1.translate(this.h, this.i);
      var1.setClip(0, 0, this.j, this.k);
      var1.translate(0, -this.C);

      for(var2 = 0; var2 < this.n.size(); ++var2) {
         Command var11 = (Command)this.n.elementAt(var2);
         if (var2 == this.m && !super.aj) {
            var1.setColor(10543802);
            var1.fillRect(4 * AvMain.hd, 10 * AvMain.hd + var2 * this.l, this.j - 8 * AvMain.hd, this.l);
         }

         Canvas.normalFont.drawString(var1, var11.caption, 10 * AvMain.hd, 10 * AvMain.hd + var2 * this.l + this.l / 2 - AvMain.ah / 2, 0);
      }

      super.paint(var1);
   }
}

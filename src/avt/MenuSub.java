package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class MenuSub extends MenuMain {
   private static MenuSub i;
   private Vector j;
   private int k;
   private int l;
   public int a;
   public int b;
   public int c;
   public int d;
   private int m;
   public int e;
   public static FrameImage f;
   private boolean n = false;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private int t;
   private int u = 0;
   private static Command v;
   public static IAction iNo;
   public static short[] h;
   private int w;
   private int x;
   private int y = 0;
   private int z;
   private boolean A = false;
   private long B;
   private long C;
   private long D;

   public static MenuSub gI() {
      return i == null ? (i = new MenuSub()) : i;
   }

   public MenuSub() {
      this.doLeftMenu();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.d();
            return;
         case 1:
            this.n = false;
            Canvas.menuMain = null;
            if (iNo != null) {
               iNo.perform();
            }
         default:
      }
   }

   public final void doLeftMenu() {
      if (Canvas.stypeInt == 0) {
         super.left = new Command(T.O, 0);
      }

      super.right = new Command(T.d, 1);
   }

   public final void startMenuFarm(Vector var1, int var2, int var3, int var4) {
      if (var1.size() != 0) {
         if (Canvas.stypeInt > 0) {
            super.aj = true;
         }

         this.u = var1.size();
         this.t = Canvas.h;
         this.n = true;
         this.c = this.u * var3 + (AvMain.hDuBox << 1) + 4;
         if (this.c > Canvas.w) {
            this.c = Canvas.w;
         }

         this.a = var2 - this.c / 2;
         this.d = var4 + (AvMain.hDuBox << 1) + 4;
         if (this.a < 0) {
            this.a = 0;
         }

         this.b = Canvas.hCan - Canvas.hTab - this.d - (AvMain.hDuBox << 1);
         this.m = this.b;
         this.e = var4;
         this.j = var1;
         this.b();
         this.s = this.u * this.e - (this.c - (AvMain.hDuBox << 1) - 4);
         if (this.s < 0) {
            this.s = 0;
         }

         this.x = this.c;
         v = null;
         iNo = null;
         h = null;
         Canvas.menuMain = this;
      }
   }

   private void b() {
      if (this.k < 0) {
         this.k = 0;
      }

      if (this.k >= this.u) {
         this.k = 0;
      }

   }

   public final void startAt(Vector var1, int var2) {
      if (var1.size() != 0) {
         if (Canvas.stypeInt > 0) {
            super.aj = true;
         }

         this.e = MyScreen.av;
         h = null;
         this.t = Canvas.h;
         this.l = 0;
         this.j = var1;
         this.u = this.j.size();
         this.c = this.d = 0;

         for(int var4 = 0; var4 < this.u; ++var4) {
            Command var3 = (Command)this.j.elementAt(var4);
            int var5;
            if ((var5 = Canvas.normalFont.getWidth(var3.caption) + 20) > this.c) {
               this.c = var5;
            }

            this.d += this.e;
         }

         if (this.c < Canvas.w / 3) {
            this.c = Canvas.w / 3;
         }

         if (this.c > Canvas.w - 4) {
            this.c = Canvas.w - 4;
         }

         this.d += 4;
         if (var2 == 0) {
            this.a = 2 * (Canvas.stypeInt != 0 ? 2 : 1);
         } else if (var2 == 1) {
            this.a = Canvas.w - this.c - 2;
         } else {
            this.a = (Canvas.w >> 1) - (this.c >> 1);
         }

         if (this.u > 5) {
            this.d = MyScreen.av * 5 + 4;
         }

         this.b = Canvas.h - this.d - AvMain.hDuBox - Canvas.hTab;
         if (OnScreen.isOngame) {
            this.b = Canvas.hCan - Canvas.hTab - this.d - 5;
         }

         if (Canvas.h < 200) {
            this.b += 10;
         }

         this.m = Canvas.h - this.e;
         if (Canvas.stypeInt > 0) {
            this.b = Canvas.hCan - this.d - AvMain.hDuBox - 3;
            if (Canvas.stypeInt == 1) {
               this.b -= 7;
            }

            super.left = null;
         }

         this.n = false;
         this.k = 0;
         this.s = (this.u - 5) * this.e;
         if (this.s < 0) {
            this.s = 0;
         }

         this.o = 0;
         this.p = 0;
         v = null;
         if (Canvas.E) {
            Canvas.clearKeyReleased();
         }

         iNo = null;
         this.x = this.d;
         Canvas.menuMain = this;
      }
   }

   private void d() {
      this.n = false;
      Canvas.menuMain = null;
      Command var1;
      if ((var1 = (Command)this.j.elementAt(this.k)).pointer != null) {
         var1.pointer.commandTab(var1.indexMenu);
      } else if (var1.action != null) {
         var1.action.perform();
      } else {
         Canvas.currentMyScreen.commandActionPointer(var1.indexMenu, var1.subIndex);
      }
   }

   public final void updateKey() {
      super.updateKey();
      ++this.C;
      boolean var2 = false;
      if (!Canvas.a(2) && !Canvas.a(4)) {
         if (Canvas.a(8) || Canvas.a(6)) {
            var2 = true;
            ++this.k;
            if (this.k > this.u - 1) {
               this.k = 0;
            }

            super.aj = false;
         }
      } else {
         var2 = true;
         --this.k;
         if (this.k < 0) {
            this.k = this.u - 1;
         }

         super.aj = false;
      }

      if (Canvas.isPointerClick && Canvas.b(this.a - 2, this.m - 7, this.c + 4, this.d + 15)) {
         Canvas.isPointerClick = false;
         this.y = this.p;
         this.B = System.currentTimeMillis() / 10L;
         this.A = true;
      }

      if (this.A) {
         int var3 = Canvas.dy();
         if (this.n) {
            var3 = Canvas.dx();
         }

         long var4 = System.currentTimeMillis() / 10L - this.B;
         int var6;
         int var7;
         if (Canvas.isPointerDown) {
            if (Canvas.gameTick % 3 == 0) {
               this.z = Canvas.py;
               this.D = this.C;
            }

            this.w = 0;
            if (Math.abs(var3) < 20 * AvMain.hd) {
               var6 = this.m;
               var7 = (this.o + Canvas.py - var6) / this.e;
               if (this.n) {
                  var6 = this.a;
                  var7 = (this.o + Canvas.px - var6) / this.e;
               }

               this.k = var7;
               this.b();
            }

            if (CRes.abs(var3) >= 20 * AvMain.hd) {
               super.aj = true;
            } else if (var4 > 10L && var4 < 20L) {
               super.aj = false;
            }

            this.o = this.y + var3;
            if (this.o < 0 || this.o > this.s) {
               this.o = this.y + var3 / 3;
            }

            this.p = this.o;
         }

         if (Canvas.isPointerRelease && Canvas.b(this.a - 2, this.m - 7, this.c + 4, this.d + 15)) {
            var6 = (int)(this.C - this.D);
            if (CRes.abs(var7 = this.z - Canvas.py) > 40 && var6 < 10 && this.o > 0 && this.o < this.s) {
               this.w = var7 / var6 * 10;
            }

            this.D = -1L;
            if (Math.abs(var3) < 20 * AvMain.hd) {
               if (var4 <= 10L) {
                  super.aj = false;
               }

               if (!super.aj) {
                  var3 = this.m;
                  var3 = (this.o + Canvas.py - var3) / this.e;
                  if (this.n) {
                     var3 = this.a;
                     var3 = (this.o + Canvas.px - var3) / this.e;
                  }

                  this.k = var3;
                  this.b();
                  this.d();
               }
            }

            Canvas.isPointerRelease = false;
         }
      }

      if (Canvas.isPointerRelease) {
         if (!this.A) {
            this.n = false;
            Canvas.menuMain = null;
            if (iNo != null) {
               iNo.perform();
            }
         }

         this.A = false;
         Canvas.isPointerRelease = false;
      }

      if (var2) {
         this.o = this.k * this.e - this.c / 2 + this.e / 2;
         if (this.o > this.s) {
            this.o = this.s;
            return;
         }

         if (this.o < 0) {
            this.o = 0;
         }
      }

   }

   public final void paint(Graphics var1) {
      var1.translate(0, this.t);
      int var6;
      int var8;
      if (this.n) {
         Graphics var3 = var1;
         MenuSub var2 = this;
         Canvas.resetTrans(var1);
         Canvas.paint.a(var1, this.a, this.b, this.c, this.d);
         var1.translate(this.a + AvMain.hDuBox + 2, this.b + AvMain.hDuBox + 2);
         var1.setClip(0, 0, this.c - (AvMain.hDuBox << 1) - 4, this.e);
         var1.translate(-this.p, 0);
         int var4;
         if ((var4 = this.p / this.e) < 0) {
            var4 = 0;
         }

         int var5;
         if ((var5 = var4 + this.c / this.e + 2) > this.u) {
            var5 = this.u;
         }

         if (!super.aj) {
            PaintPopup.a(var1, this.k * this.e, 0, this.e, this.e);
         }

         for(var6 = var4; var6 < var5; ++var6) {
            ((Command)var2.j.elementAt(var6)).paint(var3, var6 * var2.e + var2.e / 2, var2.e / 2);
         }

         if (var2.k >= 0 && var2.k < var2.j.size()) {
            Command var11 = (Command)var2.j.elementAt(var2.k);
            var3.setClip(var2.p - 50, -100, var2.p + Canvas.w + 100, var2.d + 200);
            int var7 = var2.k * var2.e + var2.e / 2;
            if (var2.u * var2.e + (AvMain.hDuBox << 1) + 10 > Canvas.w) {
               var8 = Canvas.borderFont.getWidth(var11.caption) / 2;
               if (var7 - var8 < var2.p) {
                  var7 = var2.p + var8;
               } else if (var7 + var8 > Canvas.w + var2.p - 15) {
                  var7 = Canvas.w + var2.p - var8 - 15;
               }
            }

            Canvas.borderFont.drawString(var3, var11.caption, var7, -AvMain.ag - AvMain.hDuBox - 6 - (AvMain.hd == 2 ? 15 : 0), 2);
         }

         Canvas.resetTrans(var3);
      } else if (this.u != 0) {
         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         Graphics var10 = var1;
         MenuSub var9 = this;
         Canvas.resetTrans(var1);
         if (OnScreen.isOngame) {
            Canvas.paint.e(var1, this.a - 2, this.m - 7, this.c + 4, this.d + 15);
         } else {
            Canvas.paint.a(var1, this.a - 2, this.m - 7, this.c + 4, this.d + 15);
         }

         var1.setClip(this.a, this.m, this.c, this.d);
         var1.translate(this.a + 3, this.m + 1);
         var1.translate(0, -this.p);
         var6 = (this.e - AvMain.ah) / 2;

         for(var8 = 0; var8 < var9.u; ++var8) {
            var10.setColor(0);
            if (!var9.aj && var8 == var9.k) {
               if (OnScreen.isOngame) {
                  var10.setColor(35217);
                  var10.fillRect(0, var8 * var9.e, var9.c - 6, var9.e);
               } else {
                  Canvas.paint.b(var10, 0, var8 * var9.e, var9.c - 6, var9.e);
               }
            }

            short var12 = 0;
            if (h != null && var8 < h.length && h[var8] != -1 && AvatarData.getImgIcon(h[var8]) != null) {
               var12 = AvatarData.getImgIcon(h[var8]).w;
               AvatarData.paintImg(var10, h[var8], 3, var8 * var9.e + var6 + 1, 0);
            }

            if (OnScreen.isOngame) {
               Canvas.borderFont.drawString(var10, ((Command)var9.j.elementAt(var8)).caption, var12 + 5, var8 * var9.e + var6, 0);
            } else {
               Canvas.paint.drawString(var10, ((Command)var9.j.elementAt(var8)).caption, var12 + 5, var8 * var9.e + var6, 0);
            }
         }
      }

      super.paint(var1);
   }

   public final void update() {
      if (this.t != 0) {
         this.t += -this.t >> 1;
      }

      if (this.t == -1) {
         this.t = 0;
      }

      if (this.w != 0) {
         if (this.p < 0 || this.p > this.s) {
            this.w -= this.w / 4;
            this.p += this.w / 20;
            if (this.w / 10 <= 1) {
               this.w = 0;
            }
         }

         if (this.p < 0) {
            if (this.p < -this.x / 2) {
               this.p = -this.x / 2;
               this.o = 0;
               this.w = 0;
            }
         } else if (this.p > this.s) {
            if (this.p < this.s + this.x / 2) {
               this.p = this.s + this.x / 2;
               this.o = this.s;
               this.w = 0;
            }
         } else {
            this.p += this.w / 10;
         }

         this.o = this.p;
         this.w -= this.w / 10;
         if (this.w / 10 == 0) {
            this.w = 0;
         }
      } else if (this.p < 0) {
         this.o = 0;
      } else if (this.p > this.s) {
         this.o = this.s;
      }

      if (this.p != this.o) {
         this.r = this.o - this.p << 2;
         this.q += this.r;
         this.p += this.q >> 4;
         this.q &= 15;
      }

      if (this.m > this.b) {
         int var2;
         if ((var2 = this.m - this.b >> 2) <= 0) {
            var2 = 1;
         }

         this.m -= var2;
      }

      this.m = this.b;
   }
}

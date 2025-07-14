package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class DialLuckyScr extends MyScreen {
   private static DialLuckyScr a;
   private Image b;
   private Image c;
   private Image d;
   private Image e;
   private FrameImage f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   private AvPosition n;
   private boolean o;
   private boolean p;
   private boolean q = false;
   private MyScreen r;
   private short s;
   private Command t;
   private Command u;
   private Command v;
   private Vector w = new Vector();
   private long x = 0L;
   private boolean[] y;
   private Vector z;

   public static DialLuckyScr b() {
      return a == null ? (a = new DialLuckyScr()) : a;
   }

   public final void a(MyScreen var1, short var2) {
      this.r = var1;
      this.s = var2;
      Canvas.keyHold[5] = false;
      super.switchToMe();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.q = true;
            return;
         case 1:
            return;
         case 2:
            this.r.switchToMe();
            DialLuckyScr var3 = this;
            this.p = false;
            super.center = this.t;

            for(var2 = 0; var2 < 3; ++var2) {
               var3.y[var2] = false;
            }

            var3.z.removeAllElements();
            a(var3.w, GameMidlet.avatar, 0);
         default:
      }
   }

   public DialLuckyScr() {
      FilePack.b(T.ax);
      this.b = FilePack.a("c");
      this.d = FilePack.a("sq");
      this.e = FilePack.a("q");
      this.f = FrameImage.a("st", 11 * AvMain.hd, 11 * AvMain.hd);
      this.c = FilePack.a("cb");
      FilePack.a();
      if (Canvas.w < 200) {
         this.g = 80;
      } else {
         this.g = 90;
      }

      this.n = new AvPosition(Canvas.w, Canvas.hh);
      this.i = 30;
      this.l = 360 / this.i;
      this.t = new Command(T.dv, 0);
      this.u = new Command(T.b, 1);
      this.v = new Command(T.d, 2);
      super.center = this.t;
      this.k = 90;
      this.y = new boolean[3];
      this.z = new Vector();
   }

   private static void a(Vector var0, Avatar var1, int var2) {
      var2 = var2;

      for(int var3 = 0; var3 < var0.size(); ++var3) {
         Gift var4 = (Gift)var0.elementAt(var3);
         String var5 = "";
         switch (var4.b) {
            case 1:
               Part var6 = AvatarData.getPart(var4.a);
               ImageInfo var7 = AvatarData.listImgInfo[var6.h];
               Canvas.a(0, var1.x, var1.y - 50, -1, CRes.a(var7.x0 * AvMain.hd, var7.y0 * AvMain.hd, var7.w * AvMain.hd, var7.h * AvMain.hd, AvatarData.getBigImgInfo((int)var7.bigID).img), var2);
               break;
            case 2:
               var5 = "+" + var4.c + T.C;
               var1.setMoney(var1.money[0] + var4.c);
               var2 += 20;
               break;
            case 3:
               var5 = "+" + var4.f + " xp";
               var1.setExp(var1.exp + var4.f);
               var2 += 20;
               break;
            case 4:
               var5 = "+" + var4.g + T.D;
               int[] var10000 = var1.money;
               var10000[2] += var4.g;
               var2 += 20;
         }

         if (!var5.equals("")) {
            Canvas.a(var5, var1.x, var1.y - 50, -1, 1, var2);
         }
      }

   }

   public final void update() {
      this.r.update();
      int var1;
      int var2;
      if (this.j > 0) {
         this.h -= this.j;
         if (this.h < 0) {
            this.h += 7200;
         }

         if (this.j < 10) {
            if (this.h / 20 % 30 == 0) {
               this.j = 0;
            }
         } else {
            --this.j;
         }

         if (Canvas.gameTick % 8 == 4) {
            var1 = CRes.rnd(this.l);
            if ((var2 = this.h / 20 + var1 * this.i) > 360) {
               var2 -= 360;
            }

            var2 = CRes.fixangle(var2);
            var1 = this.g * CRes.cos(var2) >> 10;
            var2 = -(this.g * CRes.sin(var2)) >> 10;
            this.b(this.n.x + var1, this.n.y + var2);
         }
      } else if (this.o) {
         DialLuckyScr var6 = this;
         this.o = false;
         this.p = true;
         this.q = false;
         this.x = System.currentTimeMillis() / 100L;

         for(var2 = 0; var2 < var6.w.size(); ++var2) {
            Gift var3 = (Gift)var6.w.elementAt(var2);
            int var4;
            if (var2 == 0) {
               var4 = 150;
            } else if (var2 == 1) {
               var4 = 180;
            } else {
               var4 = 210;
            }

            var4 = CRes.fixangle(var4);
            int var5 = var6.g * CRes.cos(var4) >> 10;
            var4 = -(var6.g * CRes.sin(var4)) >> 10;
            var3.d = var6.n.x + var5;
            var3.e = var6.n.y + var4;
         }
      }

      if (super.center == this.u) {
         var1 = 0;

         for(var2 = 0; var2 < this.y.length; ++var2) {
            if (this.y[var2]) {
               ++var1;
            }
         }

         if (var1 == 3) {
            super.center = this.v;
         }
      }

      for(var1 = 0; var1 < this.z.size(); ++var1) {
         Point var7;
         Point var10000 = var7 = (Point)this.z.elementAt(var1);
         var10000.x += var7.b;
         if (var7.b > 1 || var7.b < -1) {
            var7.b -= var7.b / CRes.abs(var7.b);
         }

         var7.y += var7.e;
         ++var7.e;
         ++var7.color;
         if (var7.color > 20) {
            this.z.removeElement(var7);
         }
      }

      if (this.p) {
         for(var1 = 0; var1 < this.w.size(); ++var1) {
            if (!this.y[var1] && System.currentTimeMillis() / 100L - this.x > (long)((var1 + 1) * 5)) {
               this.y[var1] = true;
               Gift var8 = (Gift)this.w.elementAt(var1);
               this.b(var8.d, var8.e);
            }
         }
      }

   }

   private void b(int var1, int var2) {
      for(int var3 = 0; var3 < 10; ++var3) {
         byte var4 = 1;
         if (var3 % 2 == 0) {
            var4 = -1;
         }

         Point var5;
         (var5 = new Point(var1, var2)).color = 0;
         var5.b = var4 * (CRes.rnd(80) / 10);
         var5.e = -CRes.rnd(70) / 10;
         this.z.addElement(var5);
      }

   }

   public final void updateKey() {
      if (!this.p) {
         if (Canvas.paint.d() == 1) {
            if (Canvas.isPointerDown) {
               Canvas.keyHold[5] = true;
            }

            if (Canvas.isPointerRelease) {
               Canvas.keyReleased[5] = true;
            }
         }

         if (Canvas.keyHold[5] && !this.o && this.q) {
            if (this.k < 270) {
               this.k += 3;
            }
         } else if (this.k > 90) {
            this.k -= 3;
         }

         if (Canvas.keyReleased[5]) {
            if (this.k > 90 && !this.o && this.q) {
               this.m = this.k;
               GlobalService.gI().a(this.s, this.m - 90);
               Canvas.startWaitDlg();
            }

            Canvas.keyReleased[5] = false;
         }
      }

      super.updateKey();
   }

   public final void a(int var1, int var2, Vector var3) {
      if (var1 != GameMidlet.avatar.IDDB) {
         Avatar var4;
         if ((var4 = LoadMap.g(var1)) != null) {
            a(var3, var4, var2 + 100 + 20);
            return;
         }
      } else {
         super.center = this.u;
         this.w = var3;
         this.j = 100 + (this.m - 90);
         this.o = true;
         Canvas.endDlg();
      }

   }

   public final void paint(Graphics var1) {
      this.r.paintMain(var1);
      Canvas.resetTrans(var1);
      int var2 = this.h / 20;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      for(var3 = 0; var3 < this.l; ++var3) {
         if ((var4 = var2 + var3 * this.i) > 360) {
            var4 -= 360;
         }

         if (var4 >= 82 && var4 <= 278) {
            var5 = CRes.fixangle(var4);
            var6 = this.g * CRes.cos(var5) >> 10;
            var7 = -(this.g * CRes.sin(var5)) >> 10;
            var1.drawImage(this.c, this.n.x + var6, this.n.y + var7, 3);
         }
      }

      if (this.p) {
         Graphics var12 = var1;
         DialLuckyScr var11 = this;

         for(var5 = 0; var5 < var11.w.size(); ++var5) {
            if (System.currentTimeMillis() / 100L - var11.x > (long)((var5 + 1) * 5)) {
               Gift var13;
               switch ((var13 = (Gift)var11.w.elementAt(var5)).b) {
                  case 1:
                     AvatarData.getPart(var13.a).a(var12, var13.d, var13.e, 3);
                     Canvas.L.a(var12, var13.h, var13.d - 17, var13.e - 7, 1);
                     break;
                  case 2:
                     Canvas.L.a(var12, T.C, var13.d, var13.e - AvMain.ag / 2, 2);
                     Canvas.L.a(var12, String.valueOf(var13.c), var13.d - 17, var13.e - 8, 1);
                     break;
                  case 3:
                     Canvas.L.a(var12, "xp", var13.d, var13.e - AvMain.ag / 2, 2);
                     Canvas.L.a(var12, String.valueOf(var13.f), var13.d - 17, var13.e - 8, 1);
                     break;
                  case 4:
                     Canvas.L.a(var12, T.D, var13.d, var13.e - AvMain.ag / 2, 2);
                     Canvas.L.a(var12, String.valueOf(var13.g), var13.d - 17, var13.e - 8, 1);
               }
            }
         }
      }

      var3 = 0;

      for(var4 = 0; var4 < this.l; ++var4) {
         if ((var5 = var2 + var4 * this.i) > 360) {
            var5 -= 360;
         }

         if (var5 >= 82 && var5 <= 278) {
            var6 = CRes.fixangle(var5);
            var7 = this.g * CRes.cos(var6) >> 10;
            var6 = -(this.g * CRes.sin(var6)) >> 10;
            long var9 = System.currentTimeMillis() / 100L - this.x;
            if (this.p && var5 >= 150 && var5 <= 210 && (var9 > (long)((var3 + 1) * 5) || var9 <= (long)((var3 + 1) * 5 - 5))) {
               ++var3;
            } else {
               var1.drawImage(this.e, this.n.x + var7, this.n.y + var6, 3);
            }

            var1.drawImage(this.b, this.n.x + var7, this.n.y + var6, 3);
         }
      }

      var1.drawRegion(this.d, 0, 0, 64, 62, 0, this.n.x, this.n.y, 40);
      var1.drawRegion(this.d, 0, 0, 64, 62, 1, this.n.x, this.n.y, 24);
      var5 = CRes.fixangle(this.k);
      var6 = (this.g / 3 + 2) * CRes.cos(var5) >> 10;
      var7 = -((this.g / 3 + 2) * CRes.sin(var5)) >> 10;
      if ((var2 = this.k + 90) > 360) {
         var2 -= 360;
      }

      var2 = CRes.fixangle(var2);
      var5 = 6 * CRes.cos(var2) >> 10;
      var2 = -(6 * CRes.sin(var2)) >> 10;
      int var8;
      if ((var8 = this.k - 90) < 0) {
         var8 += 360;
      }

      var8 = CRes.fixangle(var8);
      int var14 = 6 * CRes.cos(var8) >> 10;
      var8 = -(6 * CRes.sin(var8)) >> 10;
      var1.setColor(14483456);
      var1.fillTriangle(this.n.x + var6, this.n.y + var7, this.n.x + var5, this.n.y + var2, this.n.x + var14, this.n.y + var8);
      var1.fillRoundRect(this.n.x - 6, this.n.y - 6, 12, 12, 12, 12);
      if (this.p || this.j > 0) {
         this.c(var1);
      }

      super.paint(var1);
   }

   private void c(Graphics var1) {
      for(int var2 = 0; var2 < this.z.size(); ++var2) {
         Point var3 = (Point)this.z.elementAt(var2);
         this.f.drawFrame(var3.color / 5, var3.x, var3.y, 0, 3, var1);
      }

   }
}

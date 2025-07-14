package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
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
      GameCanvas.d[5] = false;
      super.a();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.q = true;
            return;
         case 1:
            return;
         case 2:
            this.r.a();
            DialLuckyScr var3 = this;
            this.p = false;
            super.ad = this.t;

            for(var2 = 0; var2 < 3; ++var2) {
               var3.y[var2] = false;
            }

            var3.z.removeAllElements();
            a(var3.w, GameMidlet.i, 0);
         default:
      }
   }

   public DialLuckyScr() {
      FilePack.b(T1.ax);
      this.b = FilePack.a("c");
      this.d = FilePack.a("sq");
      this.e = FilePack.a("q");
      this.f = FrameImage.a("st", 11 * AvMain.Y, 11 * AvMain.Y);
      this.c = FilePack.a("cb");
      FilePack.a();
      if (GameCanvas.m < 200) {
         this.g = 80;
      } else {
         this.g = 90;
      }

      this.n = new AvPosition(GameCanvas.m, GameCanvas.p);
      this.i = 30;
      this.l = 360 / this.i;
      this.t = new Command(T1.dv, 0);
      this.u = new Command(T1.b, 1);
      this.v = new Command(T1.d, 2);
      super.ad = this.t;
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
               Part var6 = AvatarData.a(var4.a);
               ImageInfo var7 = AvatarData.a[var6.h];
               GameCanvas.a(0, var1.aw, var1.ax - 50, -1, CRes.a(var7.c * AvMain.Y, var7.d * AvMain.Y, var7.e * AvMain.Y, var7.f * AvMain.Y, AvatarData.a((int)var7.b).e), var2);
               break;
            case 2:
               var5 = "+" + var4.c + T1.C;
               var1.a(var1.a[0] + var4.c);
               var2 += 20;
               break;
            case 3:
               var5 = "+" + var4.f + " xp";
               var1.d(var1.n + var4.f);
               var2 += 20;
               break;
            case 4:
               var5 = "+" + var4.g + T1.D;
               int[] var10000 = var1.a;
               var10000[2] += var4.g;
               var2 += 20;
         }

         if (!var5.equals("")) {
            GameCanvas.a(var5, var1.aw, var1.ax - 50, -1, 1, var2);
         }
      }

   }

   public final void k() {
      this.r.k();
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

         if (GameCanvas.l % 8 == 4) {
            var1 = CRes.e(this.l);
            if ((var2 = this.h / 20 + var1 * this.i) > 360) {
               var2 -= 360;
            }

            var2 = CRes.c(var2);
            var1 = this.g * CRes.b(var2) >> 10;
            var2 = -(this.g * CRes.a(var2)) >> 10;
            this.b(this.n.a + var1, this.n.b + var2);
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

            var4 = CRes.c(var4);
            int var5 = var6.g * CRes.b(var4) >> 10;
            var4 = -(var6.g * CRes.a(var4)) >> 10;
            var3.d = var6.n.a + var5;
            var3.e = var6.n.b + var4;
         }
      }

      if (super.ad == this.u) {
         var1 = 0;

         for(var2 = 0; var2 < this.y.length; ++var2) {
            if (this.y[var2]) {
               ++var1;
            }
         }

         if (var1 == 3) {
            super.ad = this.v;
         }
      }

      for(var1 = 0; var1 < this.z.size(); ++var1) {
         Point var7;
         Point var10000 = var7 = (Point)this.z.elementAt(var1);
         var10000.aw += var7.b;
         if (var7.b > 1 || var7.b < -1) {
            var7.b -= var7.b / CRes.f(var7.b);
         }

         var7.ax += var7.e;
         ++var7.e;
         ++var7.f;
         if (var7.f > 20) {
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
         (var5 = new Point(var1, var2)).f = 0;
         var5.b = var4 * (CRes.e(80) / 10);
         var5.e = -CRes.e(70) / 10;
         this.z.addElement(var5);
      }

   }

   public final void l() {
      if (!this.p) {
         if (GameCanvas.S.d() == 1) {
            if (GameCanvas.e) {
               GameCanvas.d[5] = true;
            }

            if (GameCanvas.f) {
               GameCanvas.c[5] = true;
            }
         }

         if (GameCanvas.d[5] && !this.o && this.q) {
            if (this.k < 270) {
               this.k += 3;
            }
         } else if (this.k > 90) {
            this.k -= 3;
         }

         if (GameCanvas.c[5]) {
            if (this.k > 90 && !this.o && this.q) {
               this.m = this.k;
               GlobalService.gI().a(this.s, this.m - 90);
               GameCanvas.i();
            }

            GameCanvas.c[5] = false;
         }
      }

      super.l();
   }

   public final void a(int var1, int var2, Vector var3) {
      if (var1 != GameMidlet.i.w) {
         Avatar var4;
         if ((var4 = LoadMap.g(var1)) != null) {
            a(var3, var4, var2 + 100 + 20);
            return;
         }
      } else {
         super.ad = this.u;
         this.w = var3;
         this.j = 100 + (this.m - 90);
         this.o = true;
         GameCanvas.h();
      }

   }

   public final void a(Graphics var1) {
      this.r.b(var1);
      GameCanvas.c(var1);
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
            var5 = CRes.c(var4);
            var6 = this.g * CRes.b(var5) >> 10;
            var7 = -(this.g * CRes.a(var5)) >> 10;
            var1.drawImage(this.c, this.n.a + var6, this.n.b + var7, 3);
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
                     AvatarData.a(var13.a).a(var12, var13.d, var13.e, 3);
                     GameCanvas.L.a(var12, var13.h, var13.d - 17, var13.e - 7, 1);
                     break;
                  case 2:
                     GameCanvas.L.a(var12, T1.C, var13.d, var13.e - AvMain.ag / 2, 2);
                     GameCanvas.L.a(var12, String.valueOf(var13.c), var13.d - 17, var13.e - 8, 1);
                     break;
                  case 3:
                     GameCanvas.L.a(var12, "xp", var13.d, var13.e - AvMain.ag / 2, 2);
                     GameCanvas.L.a(var12, String.valueOf(var13.f), var13.d - 17, var13.e - 8, 1);
                     break;
                  case 4:
                     GameCanvas.L.a(var12, T1.D, var13.d, var13.e - AvMain.ag / 2, 2);
                     GameCanvas.L.a(var12, String.valueOf(var13.g), var13.d - 17, var13.e - 8, 1);
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
            var6 = CRes.c(var5);
            var7 = this.g * CRes.b(var6) >> 10;
            var6 = -(this.g * CRes.a(var6)) >> 10;
            long var9 = System.currentTimeMillis() / 100L - this.x;
            if (this.p && var5 >= 150 && var5 <= 210 && (var9 > (long)((var3 + 1) * 5) || var9 <= (long)((var3 + 1) * 5 - 5))) {
               ++var3;
            } else {
               var1.drawImage(this.e, this.n.a + var7, this.n.b + var6, 3);
            }

            var1.drawImage(this.b, this.n.a + var7, this.n.b + var6, 3);
         }
      }

      var1.drawRegion(this.d, 0, 0, 64, 62, 0, this.n.a, this.n.b, 40);
      var1.drawRegion(this.d, 0, 0, 64, 62, 1, this.n.a, this.n.b, 24);
      var5 = CRes.c(this.k);
      var6 = (this.g / 3 + 2) * CRes.b(var5) >> 10;
      var7 = -((this.g / 3 + 2) * CRes.a(var5)) >> 10;
      if ((var2 = this.k + 90) > 360) {
         var2 -= 360;
      }

      var2 = CRes.c(var2);
      var5 = 6 * CRes.b(var2) >> 10;
      var2 = -(6 * CRes.a(var2)) >> 10;
      int var8;
      if ((var8 = this.k - 90) < 0) {
         var8 += 360;
      }

      var8 = CRes.c(var8);
      int var14 = 6 * CRes.b(var8) >> 10;
      var8 = -(6 * CRes.a(var8)) >> 10;
      var1.setColor(14483456);
      var1.fillTriangle(this.n.a + var6, this.n.b + var7, this.n.a + var5, this.n.b + var2, this.n.a + var14, this.n.b + var8);
      var1.fillRoundRect(this.n.a - 6, this.n.b - 6, 12, 12, 12, 12);
      if (this.p || this.j > 0) {
         this.c(var1);
      }

      super.a(var1);
   }

   private void c(Graphics var1) {
      for(int var2 = 0; var2 < this.z.size(); ++var2) {
         Point var3 = (Point)this.z.elementAt(var2);
         this.f.a(var3.f / 5, var3.aw, var3.ax, 0, 3, var1);
      }

   }
}

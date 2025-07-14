package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class PopupShop extends MyScreen {
   public static PopupShop me;
   private static String[] p;
   private static int q;
   public static int b;
   public static int c;
   public static int d;
   public static int e;
   private static int r = 5;
   private static int s;
   public static int f = 5;
   private static int t;
   private static int u;
   public static int g;
   private int v;
   public Vector[] h;
   private Vector w;
   private Command[] x;
   private boolean[] y;
   private String[] z;
   public static String i;
   public static int j = 0;
   public static boolean k = false;
   private static int A = 0;
   public static int l = 0;
   private static Vector B = new Vector();
   private static MyScreen C;
   private int D;
   private int E = 0;
   public boolean m = false;
   public static boolean n = false;
   public static boolean o = false;
   private static boolean F = false;
   private static int G = 0;
   private static int H;
   private static String I = "";
   private int J;
   private int K;
   private boolean L = false;
   private int M = 0;
   private int N;

   public static PopupShop b() {
      if (me == null) {
         me = new PopupShop();
      }

      return me;
   }

   public final void a() {
      C = Canvas.currentMyScreen;
      this.D = Canvas.h + 50;
      this.E = Canvas.getSecond();
      n = true;
      G = 86;
      if (Canvas.stypeInt != 0) {
         G = 86 + 40 * Canvas.stypeInt;
      }

      o = false;
      super.a();
   }

   public final void a(int var1, int var2) {
      FarmItem var4;
      switch (var1) {
         case 0:
            this.d();
            return;
         case 1:
            if (j < this.h[g].size()) {
               ((Command)this.h[g].elementAt(j)).b.perform();
               this.m();
            }

            return;
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
         case 14:
         default:
            break;
         case 7:
            FarmScr.b().f(var2, 0);
            return;
         case 8:
            if (var2 < FarmData.d.size()) {
               AnimalInfo var6 = (AnimalInfo)FarmData.d.elementAt(var2);
               FarmScr.b().a(var6);
               return;
            }
            break;
         case 9:
            if (var2 < FarmData.e.size()) {
               var4 = (FarmItem)FarmData.e.elementAt(var2);
               FarmScr.b().f(var4.a, 4);
               return;
            }
            break;
         case 10:
            if (var2 < FarmScr.f.size()) {
               Item var5 = (Item)FarmScr.f.elementAt(var2);
               FarmScr.b().a((int)var5.ID, var5.name);
               return;
            }
            break;
         case 11:
            if (var2 < FarmScr.e.size()) {
               var4 = FarmScr.b(((Item)FarmScr.e.elementAt(var2)).ID);
               FarmScr.b().a((int)var4.a, var4.f);
               return;
            }
            break;
         case 12:
         case 13:
            return;
         case 15:
            byte[] var3 = new byte[]{0, 102};
            if (var2 != 0 || LoadMap.k == -1) {
               MapScr.gI();
               MapScr.f(var3[var2]);
            }

            b().d();
      }

   }

   public final void d(int var1, int var2) {
      C.d(var1, var2);
   }

   public final void d() {
      if (k) {
         k = false;
      } else {
         Canvas.cameraList.m = false;
         this.m = false;
         C.a();
         if (Canvas.isDoubleImage) {
            if (LoadMap.TYPEMAP == 25 && Welcome.f != 0) {
               Canvas.D = new Welcome();
               if (Welcome.f == 2) {
                  Welcome.f = 3;
               }

               Canvas.D.a((MyScreen)MapScr.a);
               GameMidlet.avatar.direct = Base.LEFT;
               return;
            }

            if (LoadMap.TYPEMAP == 57) {
               (Canvas.D = new Welcome()).b(MapScr.a);
            }
         }

      }
   }

   public final void c() {
      super.right = new Command(T.d, 0);
      super.center = new Command(T.O, 1);
   }

   public PopupShop() {
      this.N = 80 * AvMain.hd;
      t = AvMain.af;
      e = 30 * AvMain.hd;
      if (Canvas.w < 150) {
         e = 24;
      }

      if (Canvas.stypeInt == 1) {
         e = 35;
      }

      init();
      this.c();
      H = 25 * (2 - AvMain.hd) + 40 * (Canvas.stypeInt + 1) + 10 * (AvMain.hd - 1);
   }

   public static void init() {
      c = e * 5 + 11 + AvMain.Z + 2;
      d = e * 6 + 10 + AvMain.Z;
      q = Canvas.hw - e * 5 / 2;
      b = (Canvas.h - MyScreen.at) / 2 - d / 2;
   }

   public static int f() {
      return A;
   }

   public static void g() {
      k = true;
      o();
   }

   public static boolean h() {
      return k;
   }

   public static void a(String var0) {
      if (var0 != null) {
         B.addElement(new StringObj(var0, Canvas.K.getWidth(var0)));
      }

   }

   public final void a(String[] var1, Vector[] var2, Vector var3) {
      g = 0;
      this.h = var2;
      this.x = new Command[var2.length];
      this.y = new boolean[var2.length];
      this.z = new String[var2.length];
      this.w = var3;
      p = var1;
      System.out.println("addElement: " + this.h.length);
      this.v = this.h.length;
      k = false;
      PaintPopup.gI().a(p[g], c, d, this.v);
      this.i();
   }

   public final void i() {
      j = 0;
      u = 0;
      if (o || this.y[g]) {
         u = AvMain.af;
      }

      if (this.h[g] != null) {
         if ((s = this.h[g].size() / 5) >= 3 && !this.m && !o && !this.y[g]) {
            f = 5;
         } else {
            f = 2;
         }

         if (this.h[g].size() % 5 != 0) {
            ++s;
         }

         if (s < f) {
            s = f;
         }
      }

      int var1 = 1;
      if (this.h[g] == null) {
         r = 1;
      } else {
         var1 = this.h[g].size();
         r = 5;
      }

      l = -e / 2;
      if (f > 2 || o || this.y[g]) {
         l = 0;
      }

      Canvas.cameraList.a(q, PaintPopup.gI().h + PaintPopup.o + AvMain.Z + (!o && !this.y[g] ? 0 : u), e, e, e * r, e * s, e * 5, f * e - l, var1);
      this.m();
      PaintPopup.gI().a(p[g], g);
   }

   public final void k() {
      C.k();
      if (this.D != 0) {
         this.D += -this.D >> 1;
      }

      if (this.D == -1) {
         this.D = 0;
      }

      if (this.h[g] != null) {
         int var1 = this.h[g].size();

         for(int var2 = 0; var2 < var1; ++var2) {
            if (n) {
               ((Command)this.h[g].elementAt(var2)).a();
            }
         }
      }

      if (this.x[g] != null) {
         super.left = this.x[g];
      } else {
         super.left = null;
      }
   }

   public static void j() {
      GameMidlet.m = "frp1qr";
      CRes.b = "frp2qr";
      PaintPopup.k = Canvas.a(GameMidlet.m, -2);
   }

   public final void a(Command var1, int var2) {
      this.x[var2] = var1;
   }

   public final void updateKey() {
      int var2;
      if (k) {
         if (Canvas.a(4)) {
            this.c(-1);
            this.J = 5;
         } else if (Canvas.a(6)) {
            this.c(1);
            this.K = 5;
         }

         if (Canvas.a(0, 0, Canvas.w, Canvas.h - Canvas.hTab)) {
            Canvas.isPointerClick = false;
         }

         if (Canvas.isPointerRelease) {
            var2 = j % r * e;
            int var3 = (j / r + 1) * e;
            if (var2 + e / 2 - G / 2 + q + 5 < 0) {
               var2 = -e / 2 + G / 2 - q - 5;
            } else if (var2 + e / 2 - G / 2 + G > Canvas.w) {
               var2 = Canvas.w - G - e / 2 + G / 2;
            }

            var2 += q;
            var3 += b + PaintPopup.o + AvMain.Z;
            int var4 = (H - (AvMain.Z << 1)) / 4;
            var3 += AvMain.Z + 8;
            var2 = var2 + e / 2 - 35 * (Canvas.stypeInt + 1) / 2 - 2 - 10 - 10 * AvMain.hd;
            var3 = var3 + var4 / 2 + var4 + AvMain.ah / 2;
            if (Canvas.a(var2, var3 - 15 * AvMain.hd - 5, 20 + 20 * AvMain.hd, 30 * AvMain.hd)) {
               this.c(-1);
               this.J = 5;
            } else if (Canvas.a(var2 + 35 * (Canvas.stypeInt + 1), var3 - 15 * AvMain.hd - 5, 20 + 20 * AvMain.hd, 30 * AvMain.hd)) {
               this.c(1);
               this.K = 5;
            } else if (Canvas.a(var2 + 20 + 20 * AvMain.hd, var3 - 15 * AvMain.hd - 5, var2 + 35 * (Canvas.stypeInt + 1) - (var2 + 20 + 20 * AvMain.hd), 30 * AvMain.hd)) {
               super.center.b();
            }
         }

         if (this.J > 0) {
            --this.J;
         }

         if (this.K > 0) {
            --this.K;
         }
      } else {
         PopupShop var1 = this;
         if (Canvas.a(6)) {
            if (j % r != r - 1 && r != 1 && !F) {
               ++j;
            } else {
               this.b(1);
            }

            Canvas.cameraList.a(j);
            this.m();
         } else if (Canvas.a(4)) {
            if (j % r != 0 && r != 1 && !F) {
               --j;
            } else {
               this.b(-1);
            }

            Canvas.cameraList.a(j);
            this.m();
         } else if (Canvas.a(2)) {
            if (this.h[g] != null && this.h[g].size() > 0 && !F) {
               if (j / r > 0) {
                  j -= r;
               } else {
                  for(var2 = 0; var2 < var1.h.length; ++var2) {
                     if (var2 != g) {
                        PaintPopup.gI().a(4, var2);
                     }
                  }

                  F = true;
               }
            }

            Canvas.cameraList.a(j);
            var1.m();
         } else if (Canvas.a(8)) {
            if (F) {
               F = false;

               for(var2 = 0; var2 < var1.h.length; ++var2) {
                  if (var2 != g) {
                     PaintPopup.gI().a(0, var2);
                  }
               }
            } else if (r > 1 && j / r + 1 < s) {
               j += r;
            }

            Canvas.cameraList.a(j);
            var1.m();
         }

         if (Canvas.isPointerClick && (var2 = PaintPopup.gI().d()) != 0) {
            var1.b(var2);
            Canvas.isPointerClick = false;
         }
      }

      super.updateKey();
   }

   private void c(int var1) {
      if ((A += var1) < 0) {
         A = 99;
      }

      if (A > 99) {
         A = 0;
      }

      this.m();
      o();
   }

   public final void a(int var1, boolean var2) {
      if (!k) {
         if (j == var1 && super.center != null && !var2) {
            super.center.b();
         }

         j = var1;
         this.m();
      }
   }

   private static void o() {
      if (g == 1) {
         FarmItem var0;
         I = Canvas.getPriceMoney((var0 = (FarmItem)FarmData.e.elementAt(j)).g * A, var0.h * A, true);
      } else {
         I = Canvas.getPriceMoney(FarmData.b[j].g[0] * A, FarmData.b[j].g[1] * A, true);
      }

      if ((G = Canvas.K.getWidth(I) + 16 + 30 * Canvas.stypeInt) < 86 * AvMain.hd) {
         G = 86 * AvMain.hd;
      }

      if (Canvas.stypeInt != 0) {
         G = 86 + 40 * Canvas.stypeInt;
      }

   }

   public final void b(int var1) {
      if ((g += var1) == this.v) {
         g = 0;
      }

      if (g < 0) {
         g = this.v - 1;
      }

      this.i();
   }

   public final void m() {
      if (this.h[g] != null && j < this.h[g].size()) {
         super.center = (Command)this.h[g].elementAt(j);
      } else if (this.w != null && g < this.w.size()) {
         Command var1;
         if ((var1 = (Command)this.w.elementAt(g)) != null) {
            super.center = var1;
         }
      } else {
         super.center = null;
      }

      n = true;
      this.E = Canvas.getSecond();
   }

   public final void a(boolean var1) {
      this.L = var1;
   }

   public final void paint(Graphics var1) {
      C.b(var1);
      Canvas.resetTrans(var1);
      PaintPopup.gI().a(var1);
      var1.setColor(0);
      var1.translate(q, PaintPopup.gI().h + PaintPopup.o + AvMain.Z);
      int var3;
      int var4;
      if (o) {
         String var2 = Canvas.getPriceMoney(GameMidlet.avatar.money[0], GameMidlet.avatar.money[2], GameMidlet.avatar.luongKhoa, true);
         var3 = Canvas.N.getWidth(var2);
         if (CRes.f(var4 = this.M) > var3 + 20 - (c - 20)) {
            var4 = 0;
         }

         var1.setClip(0, 0, c - 20, 20);
         Canvas.N.a(var1, var2, var4, 0, 0);
         if (var3 > c - 20) {
            if (CRes.f(this.M) > var3 + 50 - (c - 20)) {
               this.M = 0;
            }

            --this.M;
         }

         var1.translate(0, u);
      }

      if (this.h[g] != null) {
         if (this.y[g]) {
            Canvas.N.a(var1, this.z[g], 0, 0, 0);
            var1.translate(0, u);
         }

         var1.setClip(0, 0, 5 * e, f * e - l);
         var1.translate(0, -CameraList.i);

         int var9;
         for(var9 = 0; var9 < s * r; ++var9) {
            PaintPopup.a(var1, e * (var9 % r), e * (var9 / r), e, e);
         }

         if (!this.L && !F) {
            PaintPopup.a(3 + j % r * e, j / r * e + 3, e - 5, e - 5, 2293623, var1);
         }

         var9 = this.h[g].size();
         if ((var3 = CameraList.i / e * r) < 0) {
            var3 = 0;
         }

         if ((var4 = CameraList.i / e * r + (f + 1) * r) > this.h[g].size()) {
            var4 = this.h[g].size();
         }

         for(var3 = var3; var3 < var4 && var3 < var9; ++var3) {
            ((Command)this.h[g].elementAt(var3)).a(var1, e * (var3 % r), e * (var3 / r));
         }

         var1.translate(0, CameraList.i - l);
         var1.setClip(0, 0, c - 9, d);
         int var5;
         int var7;
         Graphics var11;
         StringObj var12;
         if (f == 2) {
            if (o && MapScr.C != null) {
               var1.translate(0, u);
               var1.setColor(10674392);
               var1.fillTriangle(30 * AvMain.hd, f * e - (AvMain.hd == 2 ? 10 : 0), 8 * AvMain.hd, f * e + 40 * AvMain.hd, 30 * AvMain.hd + 22 * AvMain.hd, f * e + 40 * AvMain.hd);
               var1.setColor(13364969);
               var1.fillArc(8 * AvMain.hd, f * e + 40 * AvMain.hd - 10 * AvMain.hd, 44 * AvMain.hd, 20 * AvMain.hd, 0, 360);
               MapScr.C.paintIcon(var1, 30 * AvMain.hd, f * e + 45 * AvMain.hd, false);
               var1.translate(60 * AvMain.hd, 0);
            }

            var11 = var1;
            if (B != null && j < this.h[g].size()) {
               var4 = o ? 80 : 0;
               var1.setClip(0, f * e, c - var4 + 5, d);

               for(var5 = 0; var5 < B.size(); ++var5) {
                  var12 = (StringObj)B.elementAt(var5);
                  var7 = 0;
                  if (var12.c > c + 5 - var4) {
                     var12.a(c + 5 - var4);
                     if (var12.d >= 0) {
                        var7 = var12.d;
                     }
                  }

                  Canvas.N.a(var11, var12.a, 2 - var7, f * e + var5 * t, 0);
               }
            }
         } else {
            var11 = var1;
            PopupShop var10 = this;
            if (Canvas.getSecond() - this.E > 0 && !k && B != null && j < this.h[g].size()) {
               var4 = j % r * e - this.N / 2 + e / 2;
               var5 = (j / r + 1) * e - CameraList.i + 5;
               int var6 = B.size() * AvMain.af + (AvMain.Z << 1) + 8;
               if (var5 + var6 + b + 12 > Canvas.h) {
                  var5 -= var6 + e + 10;
               }

               if (var5 + b < 0) {
                  var5 = -b;
               }

               if (var4 + q + 5 + this.N > Canvas.w) {
                  var4 = Canvas.w - (q + 5 + this.N);
               } else if (var4 + q < 0) {
                  var4 = -q;
               }

               var1.setClip(var4, var5, this.N, var6 * AvMain.hd);
               Canvas.paint.a(var1, var4, var5, this.N, var6, PaintPopup.d[2], PaintPopup.d[3], 1);
               var4 += AvMain.Z;
               var5 += AvMain.Z - AvMain.af / 2;

               for(var7 = 0; var7 < B.size(); ++var7) {
                  var12 = (StringObj)B.elementAt(var7);
                  int var8 = 0;
                  if (var12.c > var10.N + 5) {
                     var12.a(var10.N);
                     if (var12.d >= 0) {
                        var8 = var12.d;
                     }
                  }

                  Canvas.N.a(var11, var12.a, var4 - var8, var5 + 5 + var7 * t, 0);
               }
            }
         }

         if (k) {
            Canvas.resetTrans(var1);
            var1.translate(q, Canvas.cameraList.e);
            Canvas.paint.a(var1, j, r, e, G, q, H, g, A, I, this.J, this.K);
         }
      } else {
         var1.setClip(-5, 0, c - 10, d);
         ((Command)this.w.elementAt(g)).a(var1, 0, 0);
      }

      if (Canvas.D == null || Welcome.g || !Welcome.d) {
         super.paint(var1);
      }

      Canvas.a(var1);
   }

   public static void n() {
      n = false;
      B.removeAllElements();
      if (k) {
         o();
      }

   }
}

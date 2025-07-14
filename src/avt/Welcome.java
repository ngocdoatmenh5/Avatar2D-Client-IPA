package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class Welcome extends AvMain {
   private int h;
   private int i;
   private int j;
   private int k;
   private String[][] l;
   public byte a = 0;
   public static MyScreen b;
   public static int c = 0;
   private String[][] m;
   private static int n = 0;
   private String[][] o;
   public static boolean d = false;
   private static int p = 0;
   private String[][] q;
   public static int e = 0;
   private static short[] r;
   private static short[] s;
   private String[][] t;
   private String[][] u;
   private static int v = 0;
   public static int f = 0;
   private static int w = 0;
   private String[][] x;
   private String[][] y;
   private static byte[] z;
   private static int A = 0;
   private String[][] B;
   public static boolean g = false;
   private static byte[] C = new byte[]{3, 7, 4, 1, 5};

   public Welcome() {
      g = false;
      d = true;
      this.h = 10;
      this.k = 0;
      super.center = new Command("", new class_dk(this));
      super.left = new Command(T.dA, new class_dj(this));
   }

   public final void k() {
   }

   public final void updateKey() {
      if (d) {
         super.updateKey();
      }

      if (d && b == Canvas.currentMyScreen && Canvas.menuMain == null && Canvas.currentDialog == null) {
         if (this.l != null) {
            Canvas.keyHold[2] = Canvas.keyHold[4] = Canvas.keyHold[6] = Canvas.keyHold[8] = false;
         }

         if (this.l != null && this.k < this.l.length - 1 && Canvas.currentMyScreen != PopupShop.b()) {
            Canvas.isPointerRelease = false;
            Canvas.isPointerDown = false;
            Canvas.isPointerClick = false;
         }
      }

   }

   private void i() {
      this.j = this.l[this.k].length * AvMain.af + (AvMain.Z << 1);
      if (this.j < (AvMain.af << 1) + (AvMain.Z << 1)) {
         this.j = (AvMain.af << 1) + (AvMain.Z << 1);
      }

      this.i = 5;
   }

   public final void paint(Graphics var1) {
      if (b == Canvas.currentMyScreen && Canvas.menuMain == null && Canvas.currentDialog == null) {
         Canvas.resetTrans(var1);
         var1.translate(0, Canvas.ab);
         if (d || Canvas.gameTick % 20 > 2) {
            ChatPopup.a(var1, this.h, this.i, Canvas.w - (this.h << 1), this.j, 16777215, 1, (byte)0);
            if (this.l != null && this.l[this.k] != null) {
               byte var2 = 0;
               if (this.l[this.k].length == 1) {
                  var2 = 2;
               }

               for(int var3 = 0; var3 < this.l[this.k].length; ++var3) {
                  Canvas.N.a(var1, this.l[this.k][var3], this.h + (Canvas.w - (this.h << 1)) / 2, this.i + this.j / 2 - this.l[this.k].length * AvMain.af / 2 + var3 * AvMain.af - var2, 2);
               }

               ++this.a;
               if (this.a >= 8) {
                  this.a = 0;
               }

               if (Canvas.currentMyScreen == MiniMap.a) {
                  var1.translate(-MiniMap.f + MiniMap.gI().c, -MiniMap.g + MiniMap.gI().d);
               } else {
                  var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
               }
            }
         }

         if (d) {
            super.paint(var1);
            if (Canvas.gameTick % 10 > 5 || Canvas.stypeInt > 0) {
               FontX var4 = Canvas.L;
               if (Canvas.stypeInt > 0) {
                  var4 = Canvas.M;
               }

               var4.a(var1, T.w, Canvas.ae[1].x + MyScreen.au / 2, Canvas.ae[1].y + Canvas.hTab / 2 - AvMain.ag / 2, 2);
            }
         }
      }

   }

   public final void a() {
      if (p == C.length + 1) {
         Canvas.D = null;
         Canvas.isDoubleImage = false;
      } else {
         if (this.q == null) {
            this.q = T.b();
         }

         b = MiniMap.a;
         d = true;
         if (p < C.length) {
            MiniMap.gI().e = C[p];
         }

         Canvas.D.a(this.q[p]);
         ++p;
      }
   }

   private void a(String[] var1) {
      this.l = new String[var1.length][];

      for(int var2 = 0; var2 < this.l.length; ++var2) {
         this.l[var2] = Canvas.N.a(var1[var2], Canvas.w - (this.h << 1) - 35 * AvMain.hd);
      }

      this.i();
      d = true;
   }

   public final void b() {
      if (this.t == null) {
         this.t = T.c();
      }

      b = MapScr.a;
      (r = new short[3])[0] = 180;
      r[1] = 312;
      r[2] = 720;
      z = new byte[]{108, 100, 107};
      if (e != 0) {
         if (e == r.length) {
            this.close(288, 150);
            return;
         }

         AvCamera.gI().setToPos(r[e] * AvMain.hd, 20 * AvMain.hd);
         AvCamera.isFollow = true;
      }

      if (e != 0) {
         SubObject var1 = new SubObject(-9, r[e], 50, 20);
         LoadMap.l.addElement(var1);
         LoadMap.a(LoadMap.l);
      }

      Canvas.D.a(this.t[e]);
      ++e;
   }

   public final void d() {
      if (this.u == null) {
         this.u = T.d();
      }

      b = MapScr.a;
      (r = new short[3])[0] = 865;
      r[1] = 445;
      r[2] = 95;
      z = new byte[]{57, 104, 58, 100, 107};
      if (v != 0) {
         if (v == r.length) {
            this.close(640, 150);
            return;
         }

         AvCamera.gI().setToPos(r[v] * AvMain.hd, 20 * AvMain.hd);
         AvCamera.isFollow = true;
         SubObject var1 = new SubObject(-9, r[v], 50, 20);
         LoadMap.l.addElement(var1);
         LoadMap.a(LoadMap.l);
      }

      Canvas.D.a(this.u[v]);
      ++v;
   }

   public static boolean b(int var0) {
      if (g) {
         return true;
      } else {
         switch (LoadMap.TYPEMAP) {
            case 9:
               if (e - 1 < z.length && var0 == z[e - 1]) {
                  return true;
               }
               break;
            case 23:
               if (v - 1 < z.length && var0 == z[v - 1]) {
                  return true;
               }
               break;
            case 25:
               if (f <= z.length && var0 == z[f - 1]) {
                  return true;
               }
               break;
            case 57:
               if (n <= z.length && var0 == z[n - 1]) {
                  return true;
               }
         }

         return false;
      }
   }

   public final void a(MyScreen var1) {
      if (this.x == null) {
         this.x = T.f();
      }

      b = var1;
      if (f == 0) {
         r = new short[]{372, -1, -1, 220};
         s = new short[]{25, -1, -1, 25};
         z = new byte[]{52, -1, -1, 24};
      } else if (f == this.x.length) {
         this.close(170, 150);
         return;
      }

      if (f == 1) {
         m();
      }

      SubObject var2 = new SubObject(-9, r[f], s[f], 20);
      LoadMap.l.addElement(var2);
      LoadMap.a(LoadMap.l);
      AvCamera.gI().setToPos(r[f] * AvMain.hd, 20 * AvMain.hd);
      AvCamera.isFollow = true;
      Canvas.D.a(this.x[f]);
      ++f;
   }

   public final void e() {
      if (this.y == null) {
         this.y = T.e();
      }

      Canvas.D.a(this.y[w]);
      ++w;
   }

   private void j() {
      if (this.B == null) {
         this.B = T.g();
      }

      b = FarmScr.a;
      if (A == 0) {
         r = new short[]{(short)(FarmScr.b().v[0].x * LoadMap.i + 12), (short)(FarmScr.C.x + 12), (short)FarmScr.W, (short)FarmScr.J.x, (short)(FarmScr.D.x + 12)};
         s = new short[]{36, 36, (short)(FarmScr.X + 15), 36, 36};
      }

      int var1;
      if ((var1 = A) < 3) {
         var1 = 0;
      } else if (var1 == 3) {
         var1 = 1;
      } else if (var1 == 4) {
         var1 = 2;
      } else if (var1 == 5) {
         var1 = 3;
      } else if (var1 == 6) {
         var1 = 4;
      }

      if (A < 3 || A == 4 || A == 5) {
         SubObject var2 = new SubObject(-9, r[var1], s[var1], 20);
         LoadMap.l.addElement(var2);
         LoadMap.a(LoadMap.l);
      }

      AvCamera.gI().setToPos(r[var1] * AvMain.hd, 36 * AvMain.hd);
      AvCamera.isFollow = true;
      Canvas.D.a(this.B[A]);
      ++A;
      FarmScr.b().left = null;
   }

   public final void b(MyScreen var1) {
      if (this.o == null) {
         this.o = T.h();
      }

      b = var1;
      if (n == 0) {
         r = new short[]{192};
         z = new byte[]{56};
         SubObject var2 = new SubObject(-9, r[n] + 12, 135, 20);
         LoadMap.l.addElement(var2);
         LoadMap.a(LoadMap.l);
         AvCamera.gI().setToPos(r[n] + 12, 130 * AvMain.hd);
      } else {
         if (n == this.o.length) {
            this.close(180, 240);
            return;
         }

         AvCamera.isFollow = true;
      }

      Canvas.D.a(this.o[n]);
      ++n;
   }

   public final void f() {
      if (this.m == null) {
         this.m = T.i();
      }

      b = MapScr.a;
      if (c == 0) {
         z = new byte[]{56};
      } else {
         if (c == this.m.length) {
            this.close(170, 170);
            return;
         }

         if (c < 4) {
            r = new short[]{12, 480, 230};
            s = new short[]{110, 110, 12};
            AvCamera.gI().setToPos(r[c - 1] * AvMain.hd, s[c - 1] * AvMain.hd);
            AvCamera.isFollow = true;
            SubObject var1 = new SubObject(-9, r[c - 1], s[c - 1], 20);
            LoadMap.l.addElement(var1);
            LoadMap.a(LoadMap.l);
         } else {
            AvCamera.isFollow = false;
         }
      }

      Canvas.D.a(this.m[c]);
      ++c;
   }

   private static void m() {
      for(int var0 = 0; var0 < LoadMap.l.size(); ++var0) {
         MyObject var1;
         if ((var1 = (MyObject)LoadMap.l.elementAt(var0)).catagory == 1 && ((SubObject)var1).type == -9) {
            LoadMap.l.removeElement(var1);
            --var0;
         }
      }

   }

   private void close(int var1, int var2) {
      this.k = 0;
      g = true;
      m();
      SubObject var3 = new SubObject(-9, var1, var2, 20);
      LoadMap.l.addElement(var3);
      LoadMap.a(LoadMap.l);
      AvCamera.gI().setToPos(var1 * AvMain.hd, var2 * AvMain.hd);
      AvCamera.isFollow = true;
      String[] var4 = T.j();
      Canvas.D.a(var4);
   }

   public static void g() {
      int var0;
      if ((var0 = A) < 3) {
         var0 = 0;
      } else if (var0 == 3) {
         var0 = 1;
      } else if (var0 == 4) {
         var0 = 2;
      }

      if (var0 < r.length) {
         (Canvas.D = new Welcome()).j();
      }

   }

   public static void h() {
      Canvas.isDoubleImage = true;
      A = 0;
      f = 0;
      c = 0;
      e = 0;
      p = 0;
      n = 0;
      g = false;
      d = false;
   }

   static void a(Welcome var0) {
      if (var0.k < var0.l.length - 1) {
         ++var0.k;
         d = true;
         var0.i();
         if (LoadMap.TYPEMAP == 23) {
            if (v == 1 && var0.k == var0.l.length - 1) {
               AvCamera.gI().setToPos(r[0], 20);
               AvCamera.isFollow = true;
               SubObject var1 = new SubObject(-9, r[v - 1], 50, 20);
               LoadMap.l.addElement(var1);
               LoadMap.a(LoadMap.l);
               return;
            }
         } else if (LoadMap.TYPEMAP == 9 && e == 1 && var0.k == var0.l.length - 1) {
            var0.b();
            return;
         }
      } else if (var0.k == var0.l.length - 1) {
         AvCamera.isFollow = false;
         if (100 == LoadMap.TYPEMAP) {
            Canvas.D = null;
            return;
         }

         if (Canvas.currentMyScreen == MiniMap.a && var0.q != null && p == var0.q.length) {
            var0.a();
            return;
         }

         if (LoadMap.TYPEMAP == 24) {
            if (A == 3 || A == 4 || A == 5 || A == 6) {
               m();
               (Canvas.D = new Welcome()).j();
               d = true;
               return;
            }

            if (A == 7 && d && !g) {
               var0.close(470, 168);
               return;
            }
         } else if (LoadMap.TYPEMAP == 25) {
            if (f == var0.x.length - 1) {
               Canvas.D = null;
            }
         } else if (LoadMap.TYPEMAP == 13) {
            var0.k = 0;
            if (!g) {
               var0.f();
               return;
            }
         }

         var0.i = 5;
         d = false;
      }

   }
}

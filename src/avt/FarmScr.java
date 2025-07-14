package avt;

import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class FarmScr extends MyScreen {
   public static FarmScr a;
   public static int b;
   private String ay;
   public static Vector c;
   private static Vector az = new Vector();
   public static Vector d = new Vector();
   public static Vector e = new Vector();
   public static Vector f;
   public static Vector g;
   public static Vector h;
   public static Vector i = new Vector();
   public static Vector[] j = new Vector[2];
   public static Image[] k;
   public static String l;
   public static Image m;
   public static Image n;
   public static Image o;
   public static FrameImage p;
   public static FrameImage q;
   public static FrameImage r;
   public static FrameImage s;
   public static FrameImage t;
   public static FrameImage u;
   public AvPosition[] v;
   private Vector aA;
   public static int w;
   public static int x;
   private byte[] aB = new byte[]{33, 34, 35, 36, 37};
   private byte[] aC = new byte[]{33, 120, 121, 122, 123};
   private Vector aD = new Vector();
   public static boolean y = false;
   public static boolean z = false;
   public static AvPosition A;
   public static AvPosition B;
   public static AvPosition C;
   public static AvPosition D;
   public static byte E = -1;
   public static byte F;
   private AvPosition aE;
   private int aF;
   private static int aG = 12;
   private static int aH = 4;
   public static int G = -1;
   public static int H = -1;
   private int aI;
   private long aJ;
   private long aK;
   private static int aL = 0;
   public static boolean I = false;
   private static boolean aM = false;
   private static final byte[][] aN = new byte[][]{{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, {4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, {8, 8, 8, 8, 8, 9, 9, 9, 9, 9}};
   private static Command aO;
   private static Command aP;
   private static Command aQ;
   private static Command aR;
   private static Command aS;
   private static Command aT;
   public static StarFruitObj J;
   private Command aU;
   private Command aV;
   public Vector K = new Vector();
   private boolean aW = false;
   private boolean aX = false;
   public static int L = -1;
   Animal M;
   private long aY = -1L;
   public static boolean N = false;
   private boolean aZ;
   private Vector ba = new Vector();
   private boolean bb = false;
   private int bc = 0;
   public static byte O;
   public static byte P;
   public static byte Q;
   public static boolean R = false;
   public static int S = -1;
   public static int T = -1;
   public static int U;
   public static short V = 0;
   private static int bd = -1;
   private static String be = "";
   private boolean bf = true;
   private int bg = 0;
   public static int W;
   public static int X;

   public static FarmScr b() {
      if (a == null) {
         a = new FarmScr();
      }

      return a;
   }

   public final void a() {
      super.a();
   }

   public static void e() {
      I = false;
      aM = false;
      if (t == null) {
         FilePack.b(T1.au);
         m = FilePack.a("buyLand");
         t = FrameImage.a("cut", 24 * AvMain.Y, 24 * AvMain.Y);
         p = FrameImage.a("vp", 16 * AvMain.Y, 16 * AvMain.Y);
         (k = new Image[2])[0] = FilePack.a("w");
         k[1] = FilePack.a("g");
         q = FrameImage.a("wg", 13 * AvMain.Y, 9 * AvMain.Y);
         r = FrameImage.a("m", 27 * AvMain.Y, 17 * AvMain.Y);
         s = FrameImage.a("tc", 13 * AvMain.Y, 13 * AvMain.Y);
         o = FilePack.a("focus");
         FilePack.a();
      }
   }

   public final void c() {
      aO = new Command(T1.O, 0);
      aP = new Command(T1.c, 7);
      aQ = new Command((String)null, 2);
      aR = new Command((String)null, 3);
      super.ac = aP;
   }

   public FarmScr() {
      j[0] = new Vector();
      j[1] = new Vector();
      this.c();
      FilePack.b(T1.au);
      n = FilePack.a("coin");
      u = FrameImage.a("iB", 9 * AvMain.Y, 13 * AvMain.Y);
      FilePack.a();
      this.r();
      e();
      aS = new Command(T1.cy, 8);
      aT = new Command(T1.bz, 9);
      this.aU = new Command(T1.bz, 16, this);
      this.aV = new Command(T1.d, 18, this);
   }

   private void q() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < d.size(); ++var2) {
         Item var3;
         FarmItem var4;
         if ((var4 = b((var3 = (Item)d.elementAt(var2)).a)).e == 5 && (var4.d == 4 || var4.d == 101)) {
            var1.addElement(new class_hg(this, var4.f, new class_bx(this, var3), var4));
         }
      }

      a(var1);
   }

   private void r() {
      this.K.addElement(MapScr.b().f);
      Command var1 = new Command(T1.x, 20);
      this.K.addElement(var1);
   }

   private void s() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < az.size(); ++var2) {
         Item var3;
         if (FarmData.b((int)(var3 = (Item)az.elementAt(var2)).a) != null) {
            var1.addElement(new class_bz(this, var3.f + "(" + var3.e + ")", 7, var2, var3));
         }
      }

      a(var1);
   }

   public final void d() {
      GameCanvas.i();
      GlobalService.gI().d((int)8);
   }

   private void t() {
      int var1;
      if ((var1 = this.j(A.a, A.b)) - c.size() == 0) {
         GameCanvas.i();
         FarmService.a().b(b);
      } else {
         if (var1 >= 0 && var1 < c.size()) {
            CellFarm var8;
            if ((var8 = (CellFarm)c.elementAt(var1)).q == 5) {
               this.u();
               return;
            }

            if (var8.c != -1 || (var8.p != 1 || var8.o != this.aB[1]) && (var8.p != 2 || var8.o != this.aC[1])) {
               this.a(var8);
            } else {
               FarmScr var9 = this;
               if (az.size() != 0) {
                  if (E == -1) {
                     Vector var2 = new Vector();
                     int var3 = this.j(A.a, A.b);
                     CellFarm var4 = (CellFarm)c.elementAt(var3);
                     CellFarm var5 = null;
                     if (var3 > 0) {
                        var5 = (CellFarm)c.elementAt(var3 - 1);
                     }

                     for(int var6 = 0; var6 < az.size(); ++var6) {
                        Item var7;
                        if (FarmData.b((int)(var7 = (Item)az.elementAt(var6)).a) != null) {
                           var2.addElement(new class_bn(var9, var7.f + "(" + var7.e + ")", 5, var6, var7));
                        }
                     }

                     if (b == GameMidlet.i.w && (var4.p == 1 && var3 == 0 || var3 > 0 && var4.p < var5.p)) {
                        var2.addElement(new class_bp(var9, T1.g, 11));
                     }

                     a(var2);
                  }

                  return;
               }

               GameCanvas.b(T1.dF);
            }
         }

      }
   }

   public static void a(String var0) {
      Vector var1;
      (var1 = new Vector()).addElement(new Command(T1.C, 51));
      var1.addElement(new Command(T1.D, 52));
      var1.addElement(GameCanvas.ad);
      GameCanvas.a(var0, var1);
   }

   private void a(IAction var1) {
      if (E != -1) {
         this.aD.addElement(var1);
      } else {
         var1.perform();
      }
   }

   private boolean h(int var1, int var2) {
      boolean var3 = false;

      for(int var4 = 0; var4 < d.size(); ++var4) {
         FarmItem var5;
         if ((var5 = b(((Item)d.elementAt(var4)).a)).d == 0 && var5.e == var2) {
            this.a((IAction)(new class_bs(this, var5, var1)));
            var3 = true;
            break;
         }
      }

      if (!var3) {
         GameCanvas.b(T1.dG);
      }

      return var3;
   }

   private void a(CellFarm var1) {
      int var2 = this.j(A.a, A.b);
      CellFarm var3 = (CellFarm)c.elementAt(var2);
      CellFarm var4 = null;
      if (var2 > 0) {
         var4 = (CellFarm)c.elementAt(var2 - 1);
      }

      class_bv var5 = null;
      if (b == GameMidlet.i.w && (var3.p == 1 && var2 == 0 || var2 > 0 && var3.p < var4.p)) {
         var5 = new class_bv(this, T1.g, 11);
      }

      if (var1.c != -1 && var1.q < 6 && var1.o == 36) {
         this.a((IAction)(new class_bg(this)));
      }

      if (var1.c == -1 || var1.q >= 6) {
         class_bi var7 = new class_bi(this, var1);
         if (var5 != null) {
            Vector var8;
            (var8 = new Vector()).addElement(new class_bk(this, T1.be, var7));
            var8.addElement(var5);
            a(var8);
            return;
         }

         this.a((IAction)var7);
      }

      if (var1.c != -1 && var1.q < 6 && var2 < c.size() && d.size() > 0) {
         if (var1.j) {
            this.h(var2, 7);
         } else if (var1.k) {
            this.h(var2, 3);
         } else if (var1.n < 80) {
            this.h(var2, 2);
         }
      }

      if (E == -1) {
         Vector var9 = new Vector();
         class_em var6 = new class_em(this, T1.bd, 1);
         var9.addElement(var6);
         if (b == GameMidlet.i.w) {
            var9.addElement(new class_et(this, T1.be, new class_en(this, var1)));
         }

         if (var5 != null) {
            var9.addElement(var5);
         }

         for(var2 = 0; var2 < d.size(); ++var2) {
            Item var10;
            FarmItem var12;
            if ((var12 = b((var10 = (Item)d.elementAt(var2)).a)).d == 0 && (var12.e == 3 && var1.k || var12.e == 7 && var1.j || var12.e != 3 && var12.e != 7)) {
               String var11 = var12.f + "(" + var10.e + ")";
               var9.addElement(new class_hg(this, var11, 6, var2, var12));
            }
         }

         a(var9);
      }

   }

   public static void a(Vector var0) {
      int var1 = LoadMap.i * AvMain.Y;
      if (GameCanvas.H) {
         var1 += var1 / 3;
      }

      MenuSub.a().a(var0, GameCanvas.o, var1, var1);
   }

   public final void a(int var1) {
      FarmService var2;
      switch (var1) {
         case 0:
            GameCanvas.a(T1.ei, 1, this);
            return;
         case 1:
            FarmService.a().d((short)-1);
            PopupShop.b().d();
            return;
         case 2:
            PopupShop.b().d();
            if (U == 0) {
               (var2 = FarmService.a()).e((byte)92);
               var2.k();
               return;
            }

            FarmService.a().e(0);
            return;
         case 3:
            FarmService.a().f(1, 0);
            return;
         case 4:
            FarmService.a().f(1, 1);
            return;
         case 5:
            FarmService.a().g(1, 0);
            return;
         case 6:
            FarmService.a().g(1, 1);
            return;
         case 7:
            FarmService.a().c((int)1);
            return;
         case 8:
            FarmService.a().d((int)1);
            return;
         case 9:
            FarmService.a().h(1, 1);
            return;
         case 10:
            FarmService.a().h(1, 2);
            return;
         case 11:
            FarmService.a().e(1);
            return;
         case 12:
            GameCanvas.a(T1.dH, (IAction)(new class_eu(this)));
            return;
         case 13:
            FarmService.a().i(1, 1);
            return;
         case 14:
            FarmService.a().i(1, 2);
            return;
         case 15:
            ListScr.b().b(true);
            return;
         case 16:
            FarmService.a().f(0);
            return;
         case 17:
            (var2 = FarmService.a()).e((byte)95);
            var2.k();
            return;
         case 18:
            b().j();
            return;
         case 19:
            (var2 = FarmService.a()).e((byte)98);
            var2.k();
            return;
         case 20:
            aM = true;
            super.ac = null;
         default:
      }
   }

   public final void d(int var1, int var2) {
      FarmService var3;
      FarmItem var4;
      Item var8;
      switch (var1) {
         case 1:
            this.a((byte)1, (int)G);
            return;
         case 2:
            if (LoadMap.p != null) {
               GameCanvas.h();
               FarmService.a().d(b, ((Base)LoadMap.p).w);
               return;
            }
            break;
         case 3:
            if (LoadMap.p != null) {
               AnimalInfo var12 = FarmData.c(e(((Base)LoadMap.p).w).k);

               for(int var11 = 0; var11 < d.size(); ++var11) {
                  if (var2 == var11) {
                     Item var9 = (Item)d.elementAt(var11);
                     this.a(var9, var12.c == 1 ? 0 : 1);
                  }
               }

               return;
            }
            break;
         case 4:
            if (LoadMap.p != null) {
               for(var1 = 0; var1 < d.size(); ++var1) {
                  if (var2 == var1) {
                     var4 = b((var8 = (Item)d.elementAt(var1)).a);
                     this.a(var4, var8.a, (Animal)LoadMap.p);
                  }
               }

               return;
            }
            break;
         case 5:
            for(var1 = 0; var1 < az.size(); ++var1) {
               if (var1 == var2) {
                  int var10;
                  if ((var10 = this.j(A.a, A.b)) >= c.size()) {
                     return;
                  }

                  i(var1, var10);
               }
            }

            return;
         case 6:
            for(var1 = 0; var1 < d.size(); ++var1) {
               if (var1 == var2) {
                  if ((var8 = (Item)d.elementAt(var1)).e > 0) {
                     int var5;
                     if ((var5 = this.j(A.a, A.b)) < c.size() && d.size() != 0) {
                        byte var6;
                        if ((var6 = (var4 = b(var8.a)).e) != 7) {
                           if (var6 == 1) {
                              this.a((byte)2, (int)var4.a);
                           } else {
                              this.a((byte)var6, (int)var4.a);
                           }
                        }

                        FarmService.a().b(b, var5, var4.a);
                     }
                  } else {
                     GameCanvas.b(T1.bf + var8.f);
                  }
               }
            }

            return;
         case 7:
            this.h(var2);
            return;
         case 8:
            this.a((int)5, (int)-1);
            this.s();
            return;
         case 9:
            this.aX = true;
            this.h(0);
            return;
         case 10:
            y = true;

            for(var1 = this.bg; var1 < i.size(); ++var1) {
               Animal var7 = (Animal)i.elementAt(var1);
               boolean var10000;
               if (var7.j[1]) {
                  LoadMap.p = var7;
                  AvCamera.a().a(var7.aw * AvMain.Y, var7.ax * AvMain.Y);
                  AvCamera.g = true;
                  super.ad = new Command(T1.dU, new IActionTriBenh1(this, var7));
                  super.ac = aS;
                  super.ae = aT;
                  var10000 = true;
               } else if (var7.j[0]) {
                  LoadMap.p = var7;
                  AvCamera.a().a(var7.aw * AvMain.Y, var7.ax * AvMain.Y);
                  AvCamera.g = true;
                  super.ad = new Command(T1.dU, new IActionTriBenh2(this, var7));
                  super.ac = aS;
                  super.ae = aT;
                  var10000 = true;
               } else if (var7.i && !(var7 instanceof Dog) && !(var7 instanceof Cattle)) {
                  LoadMap.p = var7;
                  AvCamera.a().a(var7.aw * AvMain.Y, var7.ax * AvMain.Y);
                  AvCamera.g = true;
                  super.ad = new Command(T1.dX, new class_ab(this, var7));
                  super.ac = aS;
                  super.ae = aT;
                  var10000 = true;
               } else if (var7.h < 50) {
                  LoadMap.p = var7;
                  AvCamera.a().a(var7.aw * AvMain.Y, var7.ax * AvMain.Y);
                  AvCamera.g = true;
                  super.ad = new Command(T1.dZ, new class_w(this, var7));
                  super.ac = aS;
                  super.ae = aT;
                  var10000 = true;
               } else {
                  var10000 = false;
               }

               if (var10000) {
                  return;
               }

               ++this.bg;
            }

            this.a((int)8, (int)-1);
            GameCanvas.b(T1.dI);
            return;
         case 11:
            FarmService.a().h(0, 0);
            return;
         case 12:
            (var3 = FarmService.a()).e((byte)85);
            var3.k();
            return;
         case 13:
            if (J.e > 0) {
               FarmService.a().d((int)0);
               return;
            }

            FarmService.a().c((int)0);
            return;
         case 14:
            (var3 = FarmService.a()).e((byte)87);
            var3.k();
            return;
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         default:
            break;
         case 20:
            this.d();
      }

   }

   private void h(int var1) {
      H = 0;
      super.ac = new Command(T1.cy, 5);
      super.ae = null;
      AvCamera.g = true;
      super.ad = null;
      this.aW = true;
      L = var1;
   }

   private void a(FarmItem var1, short var2, Animal var3) {
      this.a((IAction)(new class_ep(this, var1, var2, var3)));
   }

   protected final void a(Item var1, int var2) {
      int var3 = GameMidlet.i.K == 0 ? 1 : -1;
      int var4 = j[var2].size();
      if (var1.e - var4 <= 0) {
         GameCanvas.b(T1.bw);
      } else {
         for(int var5 = 0; var5 < 3 && var5 < var1.e - var4; ++var5) {
            Point var6 = new Point(GameMidlet.i.aw, GameMidlet.i.ax - 40);
            FarmItem var7 = b(var1.a);
            var6.j = var1.a;
            var6.d = var6.e = 2;
            var6.b = -(4 + CRes.e(3));
            var6.c = var3 * (2 + CRes.e(3));
            var6.g = GameMidlet.i.ax - 20 + CRes.e(4) * 5;
            if (var7.d == 4) {
               int var8 = LoadMap.d(GameMidlet.i.aw, GameMidlet.i.ax + 23);
               if (LoadMap.d[var8] == 14) {
                  var6.g = 50 + CRes.e(50);
                  var6.c = var3 * CRes.e(3);
               }
            }

            var6.a = new class_ft(this, var6);
            j[var2].addElement(var6);
            LoadMap.n.addElement(var6);
         }

      }
   }

   public static void a(int var0, int var1, CellFarm var2, Animal var3) {
      if (LoadMap.a != 25 && var0 != var1) {
         String var4 = "";
         if (var1 - var0 > 0) {
            var4 = var4 + "+";
         }

         int var5;
         int var6;
         if (var2 != null) {
            var5 = var2.a * LoadMap.i + LoadMap.i / 2;
            var6 = var2.b * LoadMap.i - LoadMap.i / 2;
         } else {
            var5 = var3.aw;
            var6 = var3.ax - 30;
         }

         GameCanvas.a(var4 + (var1 - var0), var5, var6, -1, 0, -1);
      }

   }

   private void u() {
      if (GameMidlet.i.w == b) {
         int var1 = this.j(A.a, A.b);
         GameMidlet.i.getClass();
         FarmService.a().a(b, var1);
      }
   }

   private static void i(int var0, int var1) {
      if (GameCanvas.I) {
         Welcome.g();
      }

      Item var2 = (Item)az.elementAt(var0);
      FarmService.a().a((int)b, (int)var1, var2.a);
   }

   private int j(int var1, int var2) {
      for(int var3 = 0; var3 < this.v.length; ++var3) {
         for(int var4 = 0; var4 < aG; ++var4) {
            int var5 = this.v[var3].a + var4 / aH;
            int var6 = this.v[var3].b + var4 % aH;
            if (var1 == var5 && var2 == var6) {
               return var3 * aG + var4;
            }
         }
      }

      return -1;
   }

   private void a(byte var1, int var2) {
      G = var2;
      E = var1;
      GameMidlet.i.Q = -1;
      GameMidlet.i.i = -1;
      GameMidlet.i.j = -1;
      if (E == 4) {
         this.aE = new AvPosition(LoadMap.p.aw / LoadMap.i, LoadMap.p.ax / LoadMap.i);
      } else {
         this.aE = new AvPosition(A.a, A.b);
      }

      GameMidlet.i.D = this.aE.b * LoadMap.i + LoadMap.i / 2;
      GameMidlet.i.C = this.aE.a * LoadMap.i;
      if (GameMidlet.i.K == Base.J) {
         Avatar var10000 = GameMidlet.i;
         var10000.C += LoadMap.i;
      }

   }

   private void v() {
      for(int var1 = 0; var1 < this.v.length; ++var1) {
         for(int var2 = 0; var2 < aG; ++var2) {
            int var3 = this.v[var1].a + var2 / aH;
            int var4 = this.v[var1].b + var2 % aH;
            if (var1 * aG + var2 < c.size()) {
               LoadMap.a(var3, (int)var4, (byte)51);
               CellFarm var5;
               (var5 = (CellFarm)c.elementAt(var1 * aG + var2)).e = (short)(var1 * aG + var2);
               var5.a = var3;
               var5.b = var4;
               var5.aw = var3 * LoadMap.i + LoadMap.i / 2;
               var5.ax = var4 * LoadMap.i + 18;
               this.c(var1 * aG + var2);
               LoadMap.l.addElement(var5);
            } else {
               if (var1 * aG + var2 == c.size()) {
                  LoadMap.l.addElement(new SubObject(-3, var3 * LoadMap.i + 20, var4 * LoadMap.i + 20, m.getWidth()));
                  LoadMap.a(var3, (int)var4, (byte)51);
                  LoadMap.a(LoadMap.l);
               }

               if (LoadMap.d[var4 * LoadMap.e + var3] == this.aB[0]) {
                  LoadMap.a(LoadMap.l);
                  return;
               }

               if (var3 == this.v[var1].a && var4 == this.v[var1].b) {
                  LoadMap.d[var4 * LoadMap.e + var3] = 4;
               }
            }
         }
      }

      LoadMap.a(LoadMap.l);
   }

   public final void k() {
      this.aF += 2;
      if (this.aF >= 10) {
         this.aF = 0;
      }

      if (E != -1) {
         F = aN[E][this.aF];
         ++this.aI;
         if (this.aI > 10) {
            this.aI = 0;
            this.w();
         }
      }

      if (LoadMap.a == 24 && LoadMap.a == 53 && (System.currentTimeMillis() - this.aJ) / 1000L > 300L) {
         this.aJ = System.currentTimeMillis();
         this.b(b, true);
      }

      GameCanvas.x.b();
      if (!y && !N && L == -1) {
         this.y();
      }

      int var2;
      label143: {
         if (E != -1 && this.aY == -1L && GameMidlet.i.H == 0) {
            this.aY = System.currentTimeMillis() / 100L;
            var2 = -1;
            if (this.aE != null) {
               var2 = this.j(this.aE.a, this.aE.b);
            }

            if (E == 4) {
               var2 = 0;
            }

            if (this.aE.a * LoadMap.i < GameMidlet.i.aw) {
               GameMidlet.i.K = Base.J;
            } else {
               GameMidlet.i.K = 0;
            }

            GameMidlet.i.t = GameMidlet.i.K;
            if (this.M != null) {
               this.M.p = false;
               this.M = null;
            }

            if (var2 == -1) {
               this.w();
               break label143;
            }

            SubObject var6 = new SubObject(-2, GameMidlet.i.aw, GameMidlet.i.ax - 5, t.a);
            LoadMap.l.addElement(var6);
            byte var3 = 0;
            if (E == 0) {
               var3 = 5;
               var6.ax = GameMidlet.i.ax - 8;
            }

            if (GameMidlet.i.K == 0) {
               var6.aw = GameMidlet.i.aw + 10 + var3;
            } else {
               var6.aw = GameMidlet.i.aw - 10 - var3;
            }
         }

         if (this.aY != -1L && (E == 1 || E == 0 || E == 2) && System.currentTimeMillis() / 100L - this.aY > 2L) {
            this.aY = System.currentTimeMillis() / 100L;
            if (GameMidlet.i.H == 6) {
               GameMidlet.i.b((byte)0);
            } else {
               GameMidlet.i.b((byte)6);
            }
         }
      }

      if ((LoadMap.a == 24 || LoadMap.a == 53) && i.size() > 0 && ++aL > 250) {
         aL = 0;
         var2 = CRes.e(i.size());
         Animal var7 = (Animal)i.elementAt(var2);
         String var8 = "";
         if (var7.j[0]) {
            var8 = var8 + T1.bi;
         }

         if (var7.j[1]) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + T1.bj;
         }

         if (var7.i) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + T1.bk;
         }

         if (var7.h < 20) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + T1.bl;
         }

         if (!var8.equals("")) {
            var7.O = new ChatPopup(25, var8, (byte)0);
            var7.O.a(var7.aw, var7.ax - 45);
         }
      }

      if (System.currentTimeMillis() / 1000L - this.aK / 1000L >= 1L) {
         if (U > 0) {
            --U;
         }

         this.aK = System.currentTimeMillis();

         for(int var1 = 0; var1 < c.size(); ++var1) {
            CellFarm var9;
            if ((var9 = (CellFarm)c.elementAt(var1)).c != -1 && var9.q < 5) {
               ++var9.h;
               if ((long)(FarmData.b(var9.c).e * 60 * 60) - var9.h <= 0L) {
                  var9.q = 5;
               }
            }
         }
      }

   }

   private void w() {
      int var1;
      for(var1 = 0; var1 < LoadMap.l.size(); ++var1) {
         if (((SubObject)LoadMap.l.elementAt(var1)).f == -2) {
            LoadMap.l.removeElementAt(var1);
            if (var1 > 0) {
               --var1;
            }
         }
      }

      this.aY = -1L;
      var1 = -1;
      if (this.aE != null) {
         int var2 = this.aE.b;
         var1 = this.aE.a;
         int var3 = c.size();
         int var4 = 0;

         int var10000;
         while(true) {
            if (var4 >= var3) {
               var10000 = -1;
               break;
            }

            CellFarm var5;
            if ((var5 = (CellFarm)c.elementAt(var4)).a == var1 && var5.b == var2) {
               var10000 = var4;
               break;
            }

            ++var4;
         }

         var1 = var10000;
      }

      if (var1 == -1) {
         E = -1;
         GameMidlet.i.H = 0;
         GameMidlet.i.Q = 0;
         this.x();
      } else {
         if (G == -1) {
            CellFarm var6 = (CellFarm)c.elementAt(var1);
            switch (E) {
               case 0:
                  this.a((CellFarm)var6, 1);
                  var6.q = 0;
                  LoadMap.d[var6.b * LoadMap.e + var6.a] = var6.o;
                  if (var6.c != -1) {
                     FarmService.a().a((int)b, (int)var1, -1);
                  }

                  var6.c = -1;
                  if (GameCanvas.I) {
                     Welcome.g();
                  }
                  break;
               case 1:
                  this.a((CellFarm)var6, 4);
                  var6.i = false;
                  LoadMap.d[var6.b * LoadMap.e + var6.a] = var6.o;
                  FarmService.a().b(b, var1, 100);
               case 2:
            }
         }

         G = -1;
         this.aE = null;
         E = -1;
         GameMidlet.i.Q = 0;
         GameMidlet.i.H = 0;
         this.x();
      }
   }

   private void x() {
      if (y) {
         this.d(10, -1);
      } else if (this.aD.size() > 0) {
         IAction var1;
         (var1 = (IAction)this.aD.elementAt(0)).perform();
         this.aD.removeElement(var1);
      } else {
         if (this.aX) {
            this.A();
         }

      }
   }

   private void y() {
      if (LoadMap.a != 25) {
         int var1;
         if (GameMidlet.i.K == Base.J) {
            var1 = GameMidlet.i.aw - 23;
         } else {
            var1 = GameMidlet.i.aw + 23;
         }

         var1 /= LoadMap.i;
         int var2 = GameMidlet.i.ax / LoadMap.i;
         int var3 = LoadMap.g[var2 * LoadMap.e + var1];
         int var4 = this.j(var1, var2);
         if (var3 == 51 && var4 <= c.size()) {
            A.a = var1;
            A.b = var2;
            if (E != 0 && E != 1) {
               super.ad = aO;
            } else {
               super.ad = null;
            }
         } else {
            if (super.ad == aO || super.ad == aR) {
               super.ad = null;
            }

            A.a = -1;
            A.b = -1;
            if (LoadMap.p == null) {
               var2 = LoadMap.d(GameMidlet.i.aw + 12, GameMidlet.i.ax);
               var3 = LoadMap.d(GameMidlet.i.aw, GameMidlet.i.ax + 12);
               boolean var10000;
               if ((LoadMap.d[var2] != 100 || GameMidlet.i.K != 0) && LoadMap.d[var3] != 14) {
                  super.ad = null;
                  var10000 = false;
               } else {
                  super.ad = aR;
                  var10000 = true;
               }

               if (var10000) {
                  return;
               }
            }

            if (LoadMap.p != null && super.ad == null) {
               if (super.ae == null) {
                  super.ae = LoadMap.q;
               }

               super.ad = aQ;
            }

            if (LoadMap.p == null) {
               super.ae = null;
            }

            if (LoadMap.p == null && super.ad == aQ) {
               super.ad = null;
            }

         }
      }
   }

   public final void l() {
      if (this.aZ && GameMidlet.i.H == 0 && GameMidlet.i.Q == 0 && GameMidlet.i.aw == GameMidlet.i.C && GameMidlet.i.ax == GameMidlet.i.D) {
         this.aZ = false;
         GameMidlet.i.K = 0;
         this.y();
         if (E == -1) {
            if (L != -1) {
               if (this.ba.size() > 0 && L != -1) {
                  label244: {
                     AvPosition var3 = (AvPosition)this.ba.elementAt(0);
                     CellFarm var4;
                     (var4 = (CellFarm)c.elementAt(var3.c)).l = false;
                     A.a = var4.aw / LoadMap.i;
                     A.b = var4.ax / LoadMap.i;
                     if (this.aX) {
                        if (var4.q == 5) {
                           this.u();
                           this.A();
                        } else {
                           boolean var5 = false;
                           if (var4.c != -1 && var4.q < 6 && var4.o == 36) {
                              this.a((IAction)(new class_fp(this, var4)));
                              var5 = true;
                           }

                           if (var4.c != -1 && var4.q < 6) {
                              if (var3.c >= c.size()) {
                                 break label244;
                              }

                              if (var4.j && this.h(var3.c, 7)) {
                                 var5 = true;
                              }

                              if (var4.k && this.h(var3.c, 3)) {
                                 var5 = true;
                              }

                              if (var4.n < 80) {
                                 boolean var10 = false;

                                 for(int var6 = 0; var6 < d.size(); ++var6) {
                                    FarmItem var7;
                                    if ((var7 = b(((Item)d.elementAt(var6)).a)).e == 2 && (var7.a == 111 || var7.a == 112)) {
                                       var10 = true;
                                       FarmService.a().b(b, var3.c, var7.a);
                                       break;
                                    }
                                 }

                                 if (!var10) {
                                    GameCanvas.b(T1.dM);
                                 }
                              }
                           }

                           if (!var5) {
                              this.A();
                           }
                        }
                     } else if (var4.q == 5) {
                        this.u();
                        this.A();
                     } else {
                        this.a((IAction)(new class_fq(this, var4)));
                        this.a((IAction)(new class_gc(this, var3)));
                     }

                     this.ba.removeElement(var3);
                  }
               }
            } else {
               L = -1;
               this.t();
            }
         }
      }

      int var2;
      if (H != -1) {
         if (GameCanvas.a(2)) {
            GameCanvas.d[2] = false;
            if ((var2 = H) % 12 % 4 != 0) {
               --var2;
            }

            if (var2 >= 0) {
               H = var2;
            }
         } else if (GameCanvas.a(4)) {
            GameCanvas.d[4] = false;
            var2 = H;
            var2 -= 4;
            if (var2 >= 0) {
               H = var2;
            }
         } else if (GameCanvas.a(6)) {
            GameCanvas.d[6] = false;
            var2 = H;
            var2 += 4;
            if (var2 < c.size()) {
               H = var2;
            }
         } else if (GameCanvas.a(8)) {
            GameCanvas.d[8] = false;
            if ((var2 = H) % 12 % 4 != 3) {
               ++var2;
            }

            if (var2 < c.size()) {
               H = var2;
            }
         } else if (GameCanvas.a(5)) {
            label276: {
               var2 = LoadMap.i;
               CellFarm var8;
               if ((var8 = (CellFarm)c.elementAt(H)).c != -1 && var8.q < 6) {
                  if (this.aX) {
                     if (!var8.l) {
                        this.ba.addElement(new AvPosition(var8.aw / var2, var8.ax / var2, H));
                     }

                     var8.l = true;
                     this.A();
                     break label276;
                  }
               } else if (!this.aX) {
                  if (!var8.l) {
                     this.ba.addElement(new AvPosition(var8.aw / var2, var8.ax / var2, H));
                  }

                  var8.l = true;
                  this.A();
                  break label276;
               }

               GameCanvas.b(T1.dJ);
            }
         }

         if (GameCanvas.Z == 0) {
            CellFarm var12 = (CellFarm)c.elementAt(H);
            AvCamera.a().a(var12.aw, var12.ax);
         }
      }

      int var9;
      int var11;
      CellFarm var13;
      if (GameCanvas.g) {
         var2 = GameCanvas.h + AvCamera.a().a;
         var9 = GameCanvas.i + AvCamera.a().b;
         var11 = LoadMap.i * AvMain.Y;
         if (var9 / var11 * LoadMap.e + var2 / var11 >= 0 && var9 / var11 * LoadMap.e + var2 / var11 <= LoadMap.g.length && LoadMap.g[var9 / var11 * LoadMap.e + var2 / var11] == 51) {
            this.bb = true;
            N = true;
            var11 = this.j(var2 / var11, var9 / var11);
            var13 = (CellFarm)c.elementAt(var11);
            A.a = var13.aw / LoadMap.i;
            A.b = var13.ax / LoadMap.i;
         }
      }

      if (this.bb && GameCanvas.f) {
         this.bb = false;
         N = false;
         var2 = GameCanvas.h + AvCamera.a().a;
         var9 = GameCanvas.i + AvCamera.a().b;
         var11 = LoadMap.i * AvMain.Y;
         if (!this.aW && super.ad != null && A != null && var2 / var11 == A.a && var9 / var11 == A.b) {
            super.ad.b();
         } else if (var9 / var11 * LoadMap.e + var2 / var11 >= 0 && var9 / var11 * LoadMap.e + var2 / var11 <= LoadMap.g.length && LoadMap.g[var9 / var11 * LoadMap.e + var2 / var11] == 51) {
            var11 = this.j(var2 / var11, var9 / var11);
            var13 = (CellFarm)c.elementAt(var11);
            A.a = var13.aw / LoadMap.i;
            A.b = var13.ax / LoadMap.i;
            if (this.aW && var11 >= 0 && var11 < c.size()) {
               H = var11;
               if (var13.c != -1 && var13.q != 5 && var13.q < 6) {
                  GameCanvas.f = false;
                  if (this.aX) {
                     if (!var13.l) {
                        this.ba.addElement(new AvPosition(var2 / LoadMap.i, var9 / LoadMap.i, var11));
                     }

                     var13.l = true;
                     this.A();
                  } else if (var13.q != 5) {
                     GameCanvas.b(T1.dL);
                  }
               } else {
                  GameCanvas.f = false;
                  if (this.aX && var13.q != 5) {
                     GameCanvas.b(T1.dK);
                  } else {
                     if (!var13.l) {
                        this.ba.addElement(new AvPosition(var2 / LoadMap.i, var9 / LoadMap.i, var11));
                     }

                     var13.l = true;
                     this.A();
                  }
               }
            } else {
               GameCanvas.j = GameCanvas.h -= LoadMap.i * AvMain.Y;
               this.aZ = true;
            }
         }
      }

      if (GameCanvas.b[5] && (LoadMap.a == 24 || LoadMap.a == 53) && super.ac != null && super.ad == null) {
         super.ac.b();
      }

      super.l();
      GameCanvas.x.a();
      if (E == -1) {
         GameMidlet.i.e();
      }

   }

   private void A() {
      if (this.ba.size() > 0 && L != -1) {
         this.aZ = true;
         AvPosition var1 = (AvPosition)this.ba.elementAt(0);
         if (GameMidlet.i.at == null) {
            LoadMap.u = new AvPosition();
            GameMidlet.i.n();
         }

         LoadMap.u.a = var1.a * 24 - 24;
         LoadMap.u.b = var1.b * 24 + 12;
         GameMidlet.i.Q = -5;
         GameMidlet.i.R = -1;
         GameMidlet.i.C = GameMidlet.i.aw;
         GameMidlet.i.D = GameMidlet.i.ax;
         GameMidlet.i.av = LoadMap.u;
         GameMidlet.i.m();
      }

   }

   public final void a(Graphics var1) {
      this.b(var1);
      if (GameCanvas.D == null || !Welcome.d) {
         super.a(var1);
      }

      GameCanvas.a(var1);
   }

   public final void b(Graphics var1) {
      GameCanvas.x.b(var1);
      GameCanvas.x.d(var1);
      if (H >= 0) {
         if (this.bc >= 8) {
            this.bc = 0;
         }

         CellFarm var4 = (CellFarm)c.elementAt(H);
         var1.drawImage(MapScr.d, var4.aw * AvMain.Y, (var4.ax - 24 + this.bc / 2) * AvMain.Y, 3);
         ++this.bc;
      } else if (GameCanvas.Z == 0 && A != null && A.a != -1 && LoadMap.a != 25) {
         if (this.bc >= 8) {
            this.bc = 0;
         }

         var1.drawImage(MapScr.d, (A.a * LoadMap.i + LoadMap.i / 2) * AvMain.Y, (A.b * LoadMap.i - 4 + this.bc / 2) * AvMain.Y, 3);
         ++this.bc;
      }

      if (LoadMap.a != 25) {
         GameCanvas.N.a(var1, this.ay, (B.a + 26) * AvMain.Y, (B.b - 14) * AvMain.Y + (AvMain.Y - 1) * 7, 2);
      }

      GameCanvas.c(var1);
      LoadMap.a(var1);
   }

   public static void a(Vector var0, Vector var1, Vector var2, Vector var3, byte var4, int var5, boolean var6) {
      az = var0;
      z = var6;
      O = (byte)var4;
      int var7 = az.size();

      for(var4 = 0; var4 < var7; ++var4) {
         Item var8;
         TreeInfo var9;
         if ((var9 = FarmData.b((int)(var8 = (Item)az.elementAt(var4)).a)) != null) {
            var8.f = var9.a;
         }
      }

      f = var1;

      for(var4 = 0; var4 < f.size(); ++var4) {
         a((Item)f.elementAt(var4));
      }

      d = var2;
      e = var3;
   }

   private static void a(Item var0) {
      if (var0.a < 50) {
         var0.d[0] = FarmData.b((int)var0.a).h;
         var0.f = FarmData.b((int)var0.a).a;
      } else {
         if (var0.a < 100) {
            var0.d[0] = FarmData.c(var0.a).f;
            if (FarmData.c(var0.a).c == 1) {
               var0.f = T1.bn + " " + FarmData.c(var0.a).l;
               return;
            }

            if (FarmData.c(var0.a).c == 2) {
               if (var0.a == 55) {
                  var0.f = T1.dN + " " + FarmData.c(var0.a).l;
                  return;
               }

               var0.f = T1.bm + " " + FarmData.c(var0.a).l;
            }
         }

      }
   }

   public static FarmItem b(int var0) {
      for(int var1 = 0; var1 < FarmData.e.size(); ++var1) {
         FarmItem var2;
         if ((var2 = (FarmItem)FarmData.e.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void a(Item var0, int var1, int var2, int var3) {
      GameMidlet.i.a(var1, var2, var3);
      PopupShop.n = true;
      if (var0.a >= 50 && var0.a <= 100) {
         c = null;
      }

      if (var0.e > 0) {
         Item var4;
         if (var0.a >= 111) {
            if ((var4 = Item.a(d, var0.a)) != null) {
               var4.e += var0.e;
            } else {
               FarmItem var5 = b(var0.a);
               var0.f = var5.f;
               d.addElement(var0);
            }
         } else {
            if (var0.a <= 100 && var0.a < 50) {
               if ((var4 = Item.a(az, var0.a)) != null) {
                  var4.e += var0.e;
               } else {
                  az.addElement(var0);
                  var0.f = FarmData.b((int)var0.a).a;
               }

               if (az.size() == 0) {
                  az.addElement(var0);
               }
            }

         }
      }
   }

   public final void a(int var1, Vector var2, Vector var3, byte var4, byte var5, short var6, int var7) {
      P = (byte)var4;
      Q = (byte)var5;
      V = (short)var6;
      U = var7;
      b = var1;
      if (var1 != GameMidlet.i.w) {
         Avatar var10;
         if ((var10 = ListScr.b(var1)) == null) {
            GameCanvas.b(T1.bo);
            return;
         }

         if (var10.l == null) {
            var10.a(var10.x);
         }

         this.ay = var10.l;
         j[0].removeAllElements();
         j[1].removeAllElements();
      } else {
         this.ay = GameMidlet.i.l;
      }

      c = var2;
      if (LoadMap.a != 24 && LoadMap.a != 53 && i.size() == 0) {
         i = var3;
      }

      f();
      if (this.bf) {
         if (R || LoadMap.a != 24 && LoadMap.a != 53) {
            R = false;
            A = new AvPosition();
            E = -1;
            this.aI = 0;
            Cattle.v = -1;
            Dog.u = -1;
            this.v = new AvPosition[4];
            GameCanvas.x.e(25);
            GameCanvas.J = 0;
            int var12 = var5;
            byte var11 = (byte)var4;

            try {
               x = FishFarm.r + var12;
               w = Cattle.u + var11;
               int var13 = D.a / 24;
               var4 = (byte) (C.a / 24 + 2);
               InputStream var16;
               LoadMap.d = new short[(var16 = LoadMap.d(25)).available()];

               for(var6 = 0; var6 < LoadMap.d.length; ++var6) {
                  LoadMap.d[var6] = (short)var16.read();
               }

               short[] var17 = new short[LoadMap.d.length + LoadMap.f * (var12 + var11)];
               var5 = 0;

               for(var7 = 0; var7 < LoadMap.d.length; ++var7) {
                  var17[var5] = LoadMap.d[var7];
                  ++var5;
                  int var8;
                  if (var7 % LoadMap.e == var13) {
                     for(var8 = 0; var8 < var12; ++var8) {
                        var17[var5] = LoadMap.d[var7];
                        ++var5;
                     }
                  }

                  if (var7 % LoadMap.e == var4) {
                     for(var8 = 0; var8 < var11; ++var8) {
                        var17[var5] = LoadMap.d[var7];
                        ++var5;
                     }
                  }
               }

               LoadMap.e = (short)(LoadMap.e + var12 + var11);
               LoadMap.d = var17;
               LoadMap.l.removeAllElements();
               GameCanvas.x.a((InputStream)null, LoadMap.a + 1, true);
               Avatar var10000 = GameMidlet.i;
               var10000.aw += var11 * 24;
               LoadMap.a(849, (int)(D.a + 12 + CRes.e(x - 2) * 24), (int)(D.b + 12 + CRes.e(3) * 24));
            } catch (Exception var9) {
               var9.printStackTrace();
            }

            g = new Vector();
            h = new Vector();
            a(1, class_ex.s, (byte)87, -8, g);
            a(2, Cattle.s, (byte)86, -7, h);
            var1 = i.size();

            for(var12 = 0; var12 < var1; ++var12) {
               Animal var15;
               if ((var15 = (Animal)i.elementAt(var12)) instanceof FishFarm) {
                  ((FishFarm)var15).a();
               } else if (var15 instanceof class_ex) {
                  ((class_ex)var15).a();
               } else if (var15 instanceof Dog) {
                  ((Dog)var15).a();
               } else if (var15 instanceof Cattle) {
                  ((Cattle)var15).a();
               } else {
                  var15.a();
               }

               LoadMap.m.addElement(var15);
            }

            GameCanvas.J = 1;
            GameCanvas.h();
         }

         for(var1 = 0; var1 < LoadMap.l.size(); ++var1) {
            SubObject var14;
            if ((var14 = (SubObject)LoadMap.l.elementAt(var1)).f < 800 && var14.f >= 100 || var14.f == -3 || var14 instanceof CellFarm) {
               LoadMap.l.removeElement(var14);
               --var1;
            }
         }

         this.v();
         this.aJ = System.currentTimeMillis();
         this.aK = System.currentTimeMillis();
         if (GameCanvas.r != this) {
            this.a();
         }

         if (GameCanvas.I) {
            Welcome.g();
         }

         GameMidlet.i.C = GameMidlet.i.aw;
         GameMidlet.i.D = GameMidlet.i.ax;
      }

      this.bf = true;
      if (S != -1) {
         GameMidlet.i.aw = GameMidlet.i.C = S;
         GameMidlet.i.ax = GameMidlet.i.D = T;
         S = -1;
         T = -1;
      }

      super.ac = aP;
      super.ae = null;
      super.ad = null;
   }

   private static void a(int var0, AvPosition var1, byte var2, int var3, Vector var4) {
      int var5 = 0;

      for(int var6 = 0; var6 < i.size(); ++var6) {
         Animal var7;
         AnimalInfo var8;
         if ((var8 = FarmData.c((var7 = (Animal)i.elementAt(var6)).k)).c == var0 && var8.h != -1) {
            boolean var11 = false;

            int var9;
            for(var9 = 0; var9 < var4.size(); ++var9) {
               if (((AvPosition)var4.elementAt(var9)).c == var7.k) {
                  var11 = true;
                  break;
               }
            }

            if (!var11) {
               var9 = var1.a + var5 * 24;
               var4.addElement(new AvPosition(var9, var1.b, var7.k));
               int var10 = LoadMap.d(var9, var1.b);
               LoadMap.g[var10] = var2;
               LoadMap.a(var3, var9, var1.b);
               ++var5;
            }
         }
      }

   }

   public static void f() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < i.size(); ++var1) {
         Animal var2;
         AnimalInfo var3 = FarmData.c((var2 = (Animal)i.elementAt(var1)).k);
         if (var2 instanceof AnimalDan) {
            boolean var4 = false;

            for(int var5 = 0; var5 < var0.size(); ++var5) {
               AvPosition var6;
               if ((var6 = (AvPosition)var0.elementAt(var5)).c == var2.k) {
                  ((AnimalDan)var2).t = var6.a;
                  var4 = true;
                  break;
               }
            }

            if (!var4) {
               ((AnimalDan)var2).t = var2.w;
               var0.addElement(new AvPosition(var2.w, 0, var2.k));
            }
         }

         int var7;
         if ((var7 = var3.d * 60 / 3) > 0) {
            var2.d = var2.g / var7;
         }

         if (var2.d > 2) {
            var2.d = 2;
         }

         if (var2.g == -1 || var3.c == 3) {
            var2.d = 0;
         }
      }

   }

   public final void b(int var1, int var2) {
      if (LoadMap.a == 24 || LoadMap.a == 53) {
         Item var3;
         if ((var3 = Item.a(az, var2)) != null) {
            CellFarm var4;
            (var4 = (CellFarm)c.elementAt(var1)).c = var2;
            this.a((CellFarm)var4, 4);
            LoadMap.d[var4.b * LoadMap.e + var4.a] = var4.o;
            var4.q = 0;
            var4.k = false;
            var4.j = false;
            var4.d = 0;
            var4.h = 0L;
            var4.n = 100;
            var4.m = 0;
            --var3.e;
            if (var3.e <= 0) {
               az.removeElement(var3);
            }
         }

      }
   }

   public final void c(int var1) {
      CellFarm var4;
      if ((var4 = (CellFarm)c.elementAt(var1)).c == -1) {
         this.a((CellFarm)var4, 2);
      } else {
         TreeInfo var2;
         int var3 = (var2 = FarmData.d(var4.c)).e * 60 / 5;
         var4.q = var4.d / var3;
         if (var4.q >= 5) {
            var4.q = 5;
         }

         if (var4.d < 0 || var2.f != -1 && var4.d - var2.e * 60 > var2.f * 60 || var4.m == 100 || var4.q < 0) {
            var4.q = 6;
         }

         if (var4.i) {
            this.a((CellFarm)var4, 3);
         } else {
            this.a((CellFarm)var4, 4);
         }
      }

      LoadMap.d[var4.b * LoadMap.e + var4.a] = var4.o;
   }

   private void a(CellFarm var1, int var2) {
      if (var1.p == 2) {
         var1.o = this.aC[var2];
      } else {
         var1.o = this.aB[var2];
      }
   }

   public static void c(int var0, int var1) {
      CellFarm var3 = (CellFarm)c.elementAt(var0);
      if (var1 > 0) {
         TreeInfo var2;
         if ((var2 = FarmData.b(var3.c)).l) {
            GameCanvas.a(var1, var3.a * LoadMap.i + 11, var3.b * LoadMap.i, -1, 0, var2.c[var3.q], -1);
         } else {
            ImageInfo var5 = FarmData.a[var2.c[var3.q]];
            GameCanvas.a(var1, var3.a * LoadMap.i + 11, var3.b * LoadMap.i, -1, CRes.a(var5.c * AvMain.Y, var5.d * AvMain.Y, var5.e * AvMain.Y, var5.f * AvMain.Y, FarmData.c[var5.b]), -1);
         }
      }

      if (b == GameMidlet.i.w) {
         var3.q = 6;
         var3.m = 100;
         var3.k = false;
         var3.j = false;
      }

      TreeInfo var4;
      Item var6;
      if ((var4 = FarmData.b(var3.c)).l) {
         if ((var6 = f(var4.j)) != null) {
            var6.e += var1;
         } else {
            (var6 = new Item()).a = var4.j;
            var6.e = var1;
            var6.d[0] = var4.h;
            var6.f = var4.a;
            e.addElement(var6);
         }
      } else if ((var6 = Item.a(f, var4.b)) != null) {
         var6.e += var1;
      } else {
         (var6 = new Item()).a = var4.b;
         var6.e = var1;
         var6.d[0] = FarmData.b((int)var4.b).h;
         var6.f = FarmData.b((int)var4.b).a;
         f.addElement(var6);
      }
   }

   public static void e(int var0, int var1) {
      Animal var6 = e(var0);
      if (var1 > 0 && var6 != null) {
         AnimalInfo var2;
         AnimalInfo var3 = var2 = FarmData.c(var6.k);
         Item var5;
         if ((var5 = Item.a(f, var3.a)) != null) {
            var5.e += var1;
         } else {
            (var5 = new Item()).a = (short)var3.a;
            var5.e = var1;
            var5.f = var3.l;
            var5.d[0] = var3.f;
            a(var5);
            f.addElement(var5);
         }

         if (AvatarData.c(var2.h) != null) {
            AvPosition var7 = null;
            if (var2.c == 1) {
               var7 = a((Vector)g, var6.k);
            } else if (var2.c == 2) {
               var7 = a((Vector)h, var6.k);
            }

            if (var7 != null) {
               GameCanvas.a(var1, var7.a, var7.b - 25, -1, AvatarData.c(var2.h).a, -1);
            }
         }

      }
   }

   private static AvPosition a(Vector var0, int var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         AvPosition var3;
         if ((var3 = (AvPosition)var0.elementAt(var2)).c == var1) {
            return var3;
         }
      }

      return null;
   }

   public static void a(int var0, int var1, byte var2, String var3, int var4, int var5, int var6) {
      if (var0 == b) {
         System.out.println("onOpenLand: " + var1 + "    " + var2);
         GameMidlet.i.a(var4, var5, var6);
         GameCanvas.b(var3);
      }
   }

   public final void b(int var1, boolean var2) {
      this.bf = var2;
      FarmService.a().a(var1);
   }

   public final void a(int var1, String var2) {
      GameCanvas.a(T1.bp + " " + var2 + "?", (IAction)(new class_ge(this, var1)));
   }

   public final void g() {
      Vector var1 = new Vector();

      int var2;
      for(var2 = 0; var2 < FarmData.b.length; ++var2) {
         class_fu var4 = new class_fu(this, T1.O, 7, FarmData.b[var2].b, var2);
         var1.addElement(var4);
      }

      var2 = FarmData.d.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         AnimalInfo var6 = (AnimalInfo)FarmData.d.elementAt(var3);
         class_fy var7 = new class_fy(this, T1.O, 8, var3, var6, var3);
         var1.addElement(var7);
      }

      PopupShop.b().a();
      PopupShop.b().a(new String[]{T1.br, T1.bs, T1.aN}, new Vector[]{var1, this.B(), this.C()}, (Vector)null);
      if (GameCanvas.I && !Welcome.g) {
         (GameCanvas.D = new Welcome()).a((MyScreen)PopupShop.a);
      }

   }

   private Vector B() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < FarmData.e.size(); ++var2) {
         FarmItem var3;
         if ((var3 = (FarmItem)FarmData.e.elementAt(var2)).c && (var3.h > 0 || var3.g > 0)) {
            var1.addElement(new CommandGoVatPham(this, T1.O, 9, var2, var3, var2));
         }
      }

      return var1;
   }

   private Vector C() {
      Vector var1 = new Vector();
      int var2 = f.size();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Item var4;
         if (FarmData.b((int)(var4 = (Item)f.elementAt(var3)).a) != null || var4.a >= 50) {
            class_ko var5 = new class_ko(this, T1.bg, new class_fr(this, var3), var3, var4);
            var1.addElement(var5);
         }
      }

      for(var3 = 0; var3 < e.size(); ++var3) {
         Item var7;
         FarmItem var6 = b((var7 = (Item)e.elementAt(var3)).a);
         System.out.println("aaaaaaaaaa: " + var6 + "    " + var7.a);
         var1.addElement(new CommandGoKhoHang2(this, "", 11, var3, var6, var3, var7));
      }

      return var1;
   }

   public final void h() {
      if (GameMidlet.i.w != b) {
         GameCanvas.b(T1.bt);
      } else {
         Vector var1 = new Vector();

         int var2;
         for(var2 = 0; var2 < az.size(); ++var2) {
            Item var4;
            if (FarmData.b((int)(var4 = (Item)az.elementAt(var2)).a) != null) {
               class_d var3 = new class_d(this, "", 12, var2, var4, var2);
               var1.addElement(var3);
            }
         }

         for(var2 = 0; var2 < d.size(); ++var2) {
            CommandOpenKhoHang2 var6 = new CommandOpenKhoHang2(this, "", 13, var2, var2);
            var1.addElement(var6);
         }

         PopupShop.b().a();
         PopupShop.b().a(new String[]{T1.aN, T1.bu}, new Vector[]{this.C(), var1}, (Vector)null);

         for(int var5 = 0; var5 < f.size(); ++var5) {
            f.elementAt(var5);
         }

      }
   }

   public final void f(int var1, int var2) {
      if (var2 != 3 && !PopupShop.h()) {
         PopupShop.g();
         if (GameCanvas.I) {
            GameCanvas.D = new Welcome();
            if (Welcome.f > 2) {
               --Welcome.f;
            }

            GameCanvas.D.a((MyScreen)PopupShop.a);
            return;
         }
      } else {
         int var3 = PopupShop.f();
         int var4 = 0;
         int var5 = 0;
         if (var2 == 0) {
            TreeInfo var7;
            var4 = (var7 = FarmData.d(var1)).g[0];
            var5 = var7.g[1];
         } else if (var2 == 2) {
            var4 = FarmData.a(var1).d[0];
            var5 = FarmData.a(var1).d[1];
         } else {
            FarmItem var8;
            if (var2 == 4 && (var8 = b(var1)) != null) {
               var4 = var8.g;
               var5 = var8.h;
            }
         }

         GameCanvas.a(var4 * var3, var5 * var3, new class_u(this, var1, var3, var4), new class_r(this, var1, var3, var5), (IAction)null);
      }

   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.t();
            return;
         case 1:
            if (GameCanvas.D == null || Welcome.d) {
               MenuSub.a().a(this.K, 0);
               return;
            }
            break;
         case 2:
            FarmScr var10 = this;
            Vector var11 = new Vector();
            Animal var3;
            AnimalInfo var4 = FarmData.c((var3 = e(((Base)LoadMap.p).w)).k);

            int var5;
            Item var6;
            FarmItem var7;
            for(var5 = 0; var5 < d.size(); ++var5) {
               if ((var7 = b((var6 = (Item)d.elementAt(var5)).a)).d == var4.c && var7.e == 5 && (var4.c == 4 || var4.c == 1)) {
                  int var8 = var6.e;
                  if (var4.c == 4) {
                     var8 -= j[1].size();
                  } else if (var4.c == 1) {
                     var8 -= j[0].size();
                  }

                  var11.addElement(new class_ff(var10, var7.f + "(" + var8 + ")", new class_er(var10, var6, var4), var7));
               }
            }

            for(var5 = 0; var5 < d.size(); ++var5) {
               if ((var7 = b((var6 = (Item)d.elementAt(var5)).a)).e != 5 && var7.d != 0 && (var7.d == var4.c || var7.d == 101 || var7.d == 100 && var4.c != 4) && (var7.e != 4 || var3.j[0] || var3.j[1]) && (var7.e != 6 || var3.h < 100)) {
                  var11.addElement(new class_fb(var10, var7.f + "(" + var6.e + ")", new class_fi(var10, var7, var6), var7));
               }
            }

            if (b == GameMidlet.i.w) {
               var11.addElement(new class_fd(var10, T1.bg, 2));
            }

            a(var11);
            return;
         case 3:
            this.q();
            return;
         case 4:
            this.r();
            return;
         case 5:
            super.ac = aP;
            super.ae = null;
            this.aW = false;
            AvCamera.g = false;
            this.aX = false;
            this.ba.removeAllElements();

            for(var1 = 0; var1 < c.size(); ++var1) {
               ((CellFarm)c.elementAt(var1)).l = false;
            }

            H = -1;
            L = -1;
            N = false;
            return;
         case 6:
            this.s();
            return;
         case 7:
            Vector var9;
            (var9 = new Vector()).addElement(new Command(T1.dR, 10));
            var9.addElement(new Command(T1.dS, 8));
            var9.addElement(new Command(T1.dT, 9));
            var9.addElement(new Command(T1.x, 20));
            MenuSub.a().a(var9, 0);
            return;
         case 8:
            y = false;
            super.ae = null;
            super.ad = null;
            super.ac = aP;
            this.bg = 0;
            AvCamera.g = false;
            return;
         case 9:
            ++this.bg;
            this.d(10, -1);
            return;
         case 51:
            FarmService.a().b(b, 1);
            this.aJ = System.currentTimeMillis();
            this.b(b, true);
            return;
         case 52:
            FarmService.a().b(b, 2);
            this.aJ = System.currentTimeMillis();
            this.b(b, true);
            return;
         case 53:
            this.a((byte)0, (int)-1);
            GameCanvas.h();
            return;
         case 54:
            this.j();
      }

   }

   public final void a(AnimalInfo var1) {
      GameCanvas.a(var1.e[0], var1.e[1], new class_x(this, var1), new class_aj(this, var1), (IAction)null);
   }

   public static void i() {
      if (LoadMap.a == 24 || LoadMap.a == 53) {
         GameCanvas.t = null;
         GameCanvas.b(T1.bv, 54, (AvMain)null);
      }

   }

   public static boolean a(short var0, int var1) {
      if (Item.a(d, var0) == null) {
         return false;
      } else {
         FarmService.a().b(b, var1, var0);
         return false;
      }
   }

   public final void a(byte var1, byte var2) {
      Vector var6 = new Vector();

      for(int var3 = 0; var3 < d.size(); ++var3) {
         Item var4;
         FarmItem var5;
         if (((var5 = b((var4 = (Item)d.elementAt(var3)).a)).d == var1 || var5.d == 101) && var5.e == 5) {
            var6.addElement(new class_hg(this, var5.f + "(" + var4.e + ")", new class_ak(this, var1, var4), var5));
         }
      }

      MenuSub.a().a(var6, GameCanvas.o, LoadMap.i * AvMain.Y, LoadMap.i * AvMain.Y);
   }

   private static void a(Animal var0) {
      FarmService.a().c(b, var0.w);
   }

   public final void a(int var1, int var2, Vector var3) {
      if (GameMidlet.i.w == b) {
         if (var2 >= 0 && var2 < var3.size()) {
            AvPosition var6 = (AvPosition)var3.elementAt(var2);

            for(int var7 = 0; var7 < i.size(); ++var7) {
               Animal var4;
               AnimalInfo var5 = FarmData.c((var4 = (Animal)i.elementAt(var7)).k);
               if (var4.o > 0 && var6.c == var4.k) {
                  var4.o = 0;
                  if (var1 == 1 && var5.c == var1) {
                     a(var4);
                     i(-50);
                  }

                  if (var1 == 2 && var5.c == var1) {
                     a(var4);
                     i(-51);
                  }
               }
            }

         }
      }
   }

   public final void a(int var1, int var2, short var3) {
      GameMidlet.i.a[0] = var2;
      PopupShop.n = true;
      GameCanvas.b(T1.bx + var1 + T1.T);
      Item var4;
      if ((var4 = Item.a(f, var3)) == null) {
         var4 = Item.a(e, var3);
         e.removeElement(var4);
      } else {
         f.removeElement(var4);
      }

      if (GameCanvas.r == PopupShop.b()) {
         PopupShop.b().d();
         if (LoadMap.a == 25) {
            this.g();
            PopupShop.b().b(2);
         } else {
            this.h();
         }
      }

      GameCanvas.h();
   }

   public static void g(int var0, int var1) {
      Animal var4;
      if ((var4 = e(var0)) != null) {
         int var2 = var1 - GameMidlet.i.a[0];
         LoadMap.p = null;
         Image var3 = AvatarData.c(FarmData.c(var4.k).j[var4.d]).a;
         GameCanvas.a(var2, var4.aw, var4.ax - 7, -1, CRes.a(0, var4.m * var4.aA, var3.getWidth(), var4.aA, var3), -1);
         i.removeElement(var4);
         LoadMap.m.removeElement(var4);
      }

      PopupShop.n = true;
      GameMidlet.i.a[0] = var1;
   }

   public final void a(byte var1, String var2) {
      GameCanvas.a(var2, (IAction)(new IActionPriceAnimal(this, var1)));
   }

   public final void j() {
      I = false;
      aM = false;
      Cattle.v = -1;
      Dog.u = -1;
      this.aA = null;
      super.ae = null;
      ParkService.a().a(25, 0);
   }

   public static Animal e(int var0) {
      for(int var1 = 0; var1 < i.size(); ++var1) {
         Animal var2;
         if ((var2 = (Animal)i.elementAt(var1)).w == var0) {
            return var2;
         }
      }

      return null;
   }

   public final void m() {
      if (GameMidlet.i.w == b) {
         Vector var1 = new Vector();
         if (J.d > 0) {
            var1.addElement(new class_ao(this, T1.eO + "(" + J.d + ")", 12));
         }

         var1.addElement(new class_ap(this, J.e > 0 ? T1.eN : T1.g, 13));
         var1.addElement(new class_am(this, T1.cw, 14));
         a(var1);
      }
   }

   private static void i(int var0) {
      for(int var1 = 0; var1 < LoadMap.l.size(); ++var1) {
         SubObject var2;
         if ((var2 = (SubObject)LoadMap.l.elementAt(var1)).az == 8 && var2.f == var0) {
            LoadMap.l.removeElement(var2);
            return;
         }
      }

   }

   public final void n() {
      if (b == GameMidlet.i.w) {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < FarmData.f.size(); ++var2) {
            Food var3 = (Food)FarmData.f.elementAt(var2);
            var1.addElement(new CommandCooking1(this, T1.m, new IActionCooking1(this, var3), var3, var2));
         }

         Vector var5 = new Vector();
         if (V > 0) {
            var5.addElement((Object)null);
            CommandCooking2 var6 = new CommandCooking2(this, U == 0 ? T1.eL : T1.h, 2, this);
            var5.addElement(var6);
         }

         PopupShop.b().a();
         PopupShop.b().m = true;
         if (V > 0) {
            PopupShop.b().a(new String[]{T1.m, T1.dD}, new Vector[]{var1, null}, var5);
            PopupShop.b().a(new Command(T1.cm, 0, this), 1);
            PopupShop.g = 1;
            PopupShop.b().i();
            PopupShop.b().m();
         } else {
            PopupShop.b().a(new String[]{T1.m}, new Vector[]{var1}, (Vector)null);
         }
      }
   }

   public static void a(short var0, short var1) {
      for(int var2 = 0; var2 < J.i.length; ++var2) {
         GameCanvas.a(0, J.aw + J.i[var2], J.ax - 45 + J.j[var2], -1, 0, J.c, -1);
      }

      GameCanvas.a(var1, GameMidlet.i.aw, GameMidlet.i.ax - GameMidlet.i.aA, -1, 10);
      J.d = 0;
      Item var3;
      if ((var3 = f(var0)) != null) {
         var3.e += var1;
      } else {
         (var3 = new Item()).a = var0;
         var3.e = var1;
         e.addElement(var3);
      }

      GameCanvas.h();
   }

   public static Item f(int var0) {
      for(int var1 = 0; var1 < e.size(); ++var1) {
         Item var2;
         if ((var2 = (Item)e.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Item g(int var0) {
      for(int var1 = 0; var1 < f.size(); ++var1) {
         Item var2;
         if ((var2 = (Item)f.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void o() {
      ListScr.b().b(true);
   }

   static void a(FarmScr var0, byte var1, int var2) {
      var0.a(var1, var2);
   }

   static void a(FarmScr var0, CellFarm var1) {
      if (var1.c != -1 && var1.q < 6) {
         GameCanvas.b(T1.bh, 53);
      } else {
         var0.a((byte)0, (int)-1);
         GameCanvas.h();
      }
   }

   static void a(FarmScr var0, int var1, int var2) {
      i(var1, var2);
   }

   static void a(FarmScr var0) {
      var0.A();
   }

   static Vector p() {
      return az;
   }

   static void a(FarmScr var0, FarmItem var1, short var2, Animal var3) {
      var0.a(var1, var2, var3);
   }
}

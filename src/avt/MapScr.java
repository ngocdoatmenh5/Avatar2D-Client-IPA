package avt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class MapScr extends MyScreen implements IChatable {
   public static MapScr a;
   public static byte b;
   public static byte c;
   public static Image d;
   private Command H;
   public Command e;
   public Command f;
   private Command I;
   private Command J;
   public static byte g = -1;
   public static Avatar h;
   public static byte i = -1;
   public static String j;
   public static Image k;
   public static Vector l = new Vector();
   public static int m = -1;
   public static Vector n;
   public static Vector o;
   public static Vector p;
   public static Vector q;
   public static boolean r = false;
   public static boolean s = false;
   public static boolean t = false;
   public static boolean u = false;
   public static int v = -1;
   static byte[] w = new byte[]{10, 4, 3, 5};
   private byte K = 0;
   private byte L = -1;
   public static boolean x = false;
   private Vector M = new Vector();
   private int N;
   private int O = 60;
   public boolean y = true;
   public static byte z;
   public static byte A;
   public static short[] B;
   public static Avatar C;
   public static int D = -1;
   public static int E;
   public static int F;
   public static int G = -1;

   public final void a() {
      this.c();
      super.a();
   }

   public static MapScr b() {
      if (a == null) {
         a = new MapScr();
      }

      return a;
   }

   public final void c() {
      this.H = new Command(T1.c, 0, this);
      super.ac = this.H;
      this.f = MenuCenter.b().a(T1.bR, new class_ig(this), 15);
      this.e = new Command(GameCanvas.H ? (GameCanvas.Z == 0 ? T1.O : T1.c) : "", 1, this);
      if (GameCanvas.Z > 0 && GameCanvas.D == null) {
         super.ac = this.e;
      }

      this.I = new Command(T1.x, 2, this);
      this.J = new Command(T1.bZ, 2);
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            this.A();
            return;
         case 1:
            if (!t) {
               MenuCenter.b().f();
               return;
            }
            break;
         case 2:
            this.e();
            return;
         case 3:
            w();
      }

   }

   public final void d() {
      this.I.b();
   }

   public MapScr() {
      this.c();
   }

   public final void e() {
      GameCanvas.i();
      g = -1;
      i = -1;
      if (GameMidlet.e == 8) {
         this.t();
      } else {
         GlobalService.gI().d((int)8);
      }
   }

   protected static void f() {
      MessageScr.b().a(GameCanvas.r);
   }

   protected final void g() {
      if (h != null) {
         f(100);
      }
   }

   protected static void h() {
      if (h != null) {
         ParkService.a().c(0, h.w);
      }

   }

   public final void a(byte var1, int var2) {
      GameCanvas.h();
      Avatar var3;
      if ((var3 = LoadMap.g(var2)) != null) {
         if (var1 == 0) {
            GameCanvas.a(T1.dp + var3.x + ". " + T1.dq, (IAction)(new class_ih(this, var2)));
         } else {
            if (var1 == 1) {
               v = var2;
               GlobalService.gI().d((int)11);
               GameCanvas.i();
            }

         }
      }
   }

   protected final void i() {
      MessageScr.b().a(h.w, h.x);
      MessageScr.b().a((MyScreen)this);
   }

   private void A() {
      Vector var1 = new Vector();
      short[] var2 = null;
      if (LoadMap.a != 25 && n != null && n.size() > 0) {
         var2 = new short[n.size()];

         for(int var3 = 0; var3 < n.size(); ++var3) {
            StringObj var4 = (StringObj)n.elementAt(var3);
            var2[var3] = (short)var4.d;
            var1.addElement(new Command(var4.a, 2, var3));
         }
      }

      var1.addElement(this.I);
      MenuSub var10000 = MenuSub.a();
      boolean var5 = false;
      MenuSub var6 = var10000;
      var10000.a(var1, 0);
      MenuSub.h = var2;
      if (var2 != null) {
         var6.c += var6.e;
      }

   }

   public static void a(byte var0) {
      GameMidlet.i.a(var0);
      AvatarService.a().a((int)var0);
   }

   public static void b(int var0) {
      GameMidlet.i.e(var0);
      GameMidlet.i.U = GameMidlet.i.S;
      GameMidlet.i.T = 0;
      AvatarService.a().a(var0 + 100);
   }

   public static void a(int var0, byte var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         if (var1 >= 100) {
            var2.e(var1 - 100);
            var2.U = var2.S;
            var2.T = 0;
            return;
         }

         var2.a(var1);
      }

   }

   protected final void j() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < 4; ++var2) {
         Command var3 = MenuCenter.b().a(T1.ey[var2], new class_io(this, var2), var2 + 7);
         var1.addElement(var3);
      }

      MenuCenter.b().b = null;
      MenuCenter.b().a(var1);
   }

   public final void k() {
      GameCanvas.x.b();
      if (GameCanvas.Z == 0 && LoadMap.p != null) {
         if (h != null && LoadMap.p.az != 5 && h.w > 2000000000) {
            super.ad = this.J;
         } else {
            super.ad = null;
         }

         super.ae = LoadMap.q;
         if (LoadMap.p.az == 0) {
            super.ae.a = ((Avatar)LoadMap.p).x;
            if (super.ae.a.length() > 8) {
               super.ae.a = super.ae.a.substring(0, 8) + "..";
            }
         }
      }

      if (LoadMap.p == null && super.ae == LoadMap.q) {
         super.ae = null;
         super.ad = null;
      }

      Avatar var2;
      Avatar var3;
      if (t) {
         Avatar var4;
         if (this.K == 1 && GameCanvas.J == -1) {
            System.out.println("updateWedding1111111111111: " + this.K);
            this.K = 2;
            var2 = LoadMap.g(-100);
            var3 = LoadMap.g(E);
            var4 = LoadMap.g(F);
            if (var3 != null && var4 != null) {
               AvCamera.a().h = var2;
               System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
               var2.a(150, T1.eB[0] + var3.x + T1.eB[1] + var4.x + T1.eB[2], (byte)1);
            } else {
               this.B();
            }
         }

         if (this.K == 2 && GameCanvas.l % 4 == 2 && LoadMap.g(-100).O == null) {
            this.K = 3;
            var3 = LoadMap.g(E);
            var4 = LoadMap.g(F);
            if (var3 != null && var4 != null) {
               var4.C = 26 * LoadMap.i - LoadMap.i;
               var4.Q = -5;
               var3.C = 26 * LoadMap.i - (LoadMap.i << 1);
               var3.Q = -5;
               AvCamera.a().h = var3;
            } else {
               this.B();
            }
         }

         if (this.K == 3) {
            var2 = LoadMap.g(E);
            var3 = LoadMap.g(F);
            if (var2 != null && var3 != null && var2.Q == 0 && var3.Q == 0) {
               this.K = 4;
               var4 = LoadMap.g(-100);
               AvCamera.a().h = var4;
               var4.a(200, T1.eC[0] + var2.x + T1.eB[1] + var3.x, (byte)1);
               var4.a(200, T1.eC[1], (byte)1);
               var4.a(150, T1.eC[2], (byte)1);
               var4.a(100, T1.eC[3], (byte)1);
            }
         }

         if (this.K == 4) {
            var2 = LoadMap.g(E);
            var3 = LoadMap.g(F);
            var2.G = 4;
            var3.G = 4;
            if ((var4 = LoadMap.g(-100)).O == null && var4.P.size() == 0) {
               if (E == GameMidlet.i.w) {
                  ParkService.a().b(F, 101);
               }

               this.L = 0;
               this.K = 5;
            }
         }
      }

      if (this.K == 5 && this.L >= 0) {
         ++this.L;
         if (this.L > 20) {
            if (this.L == 21) {
               AnimateEffect var5 = new AnimateEffect(2, 0);
               GameCanvas.B.addElement(var5);
               AvCamera.a().h = GameMidlet.i;
               GameMidlet.i.G = 4;
            }

            if (GameMidlet.i.w != E) {
               t = false;
               this.L = -1;
            }

            if (GameMidlet.i.Q == 0 && GameMidlet.i.w == E) {
               t = false;
               var2 = LoadMap.g(E);
               var3 = LoadMap.g(F);
               if (var2 != null && var3 != null) {
                  var2.G = 4;
                  var3.G = 4;
               }

               this.K = 6;
               this.L = -1;
               ParkService.a().b(F, 102);
            }
         }
      }

      if (super.ad == null && GameCanvas.Z == 0 && GameCanvas.D == null) {
         super.ad = this.e;
      } else if (GameCanvas.D != null) {
         super.ad = null;
      }

      if (l.size() > 0) {
         for(int var1 = 0; var1 < l.size(); ++var1) {
            ((Fish)l.elementAt(var1)).c();
         }
      }

      if (this.N > 0) {
         --this.N;
         if (this.N == 0) {
            if (this.M.size() > 0) {
               this.M.removeElementAt(0);
            }

            if (this.M.size() > 0) {
               this.N = this.O;
            }
         }
      }

   }

   private void B() {
      t = false;
      this.K = 0;

      for(int var1 = 0; var1 < LoadMap.m.size(); ++var1) {
         MyObject var2;
         if ((var2 = (MyObject)LoadMap.m.elementAt(var1)).az == 0) {
            Avatar var3;
            (var3 = (Avatar)var2).G = 4;
         }
      }

   }

   public final void l() {
      if (GameCanvas.g && GameCanvas.a(0, 0, GameCanvas.m, 0)) {
         GameCanvas.g = false;
         GlobalService.gI().c(GameMidlet.i.w);
      }

      if (GameCanvas.D == null || !Welcome.d) {
         super.l();
      }

      GameCanvas.x.a();
      GameMidlet.i.e();
   }

   public final void a(Graphics var1) {
      this.b(var1);
      if (GameCanvas.D == null || !Welcome.d) {
         super.a(var1);
      }

      GameCanvas.a(var1);
   }

   public final void b(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.x.b(var1);
      int var2;
      if (l.size() > 0) {
         for(var2 = 0; var2 < l.size(); ++var2) {
            ((Fish)l.elementAt(var2)).a(var1);
         }
      }

      GameCanvas.x.d(var1);
      GameCanvas.c(var1);
      if (this.M.size() != 0) {
         String var4 = (String)this.M.elementAt(0);
         if ((var2 = this.O - this.N) > 10) {
            var2 = 10;
         }

         int var5 = GameCanvas.m;

         for(int var6 = 0; var6 < var2; ++var6) {
            var5 >>= 1;
         }

         GameCanvas.L.a(var1, var4, var5 + 3, 2, 0);
      }

      GameCanvas.c(var1);
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.A();
            return;
         case 2:
            GlobalService.gI().h(h.w);
            return;
         case 52:
            if (GameCanvas.r == MiniMap.a && LoadMap.a == -1) {
               GameCanvas.i();
               GlobalService.gI().d((int)8);
            }
         default:
      }
   }

   public final void a(byte var1, byte var2, short var3, short var4, Vector var5, Vector var6, Vector var7) {
      if (var2 == -1) {
         GameCanvas.b(T1.aW, 52, (AvMain)null);
      } else {
         if (LoadMap.y == -1) {
            LoadMap.F = var6;
            LoadMap.G = var7;
         }

         GameCanvas.S.a(var1);
         GameCanvas.g();
         b = (byte)var1;
         c = var2;
         h = null;
         LoadMap.p = null;
         GameMidlet.i.Q = 0;
         if (GameCanvas.I || var1 != LoadMap.a || var1 == LoadMap.a && LoadMap.y == -1 || LoadMap.y == -1 && (LoadMap.a == 14 || LoadMap.a == 15 || LoadMap.a == 16)) {
            GameMidlet.i.L = false;
            if (var1 != LoadMap.a) {
               GameMidlet.i.aw = var3;
               GameMidlet.i.ax = var4;
            }

            LoadMap.l.removeAllElements();
            GameCanvas.x.e(var1 + 1);
         } else {
            l.removeAllElements();
            LoadMap.m.removeAllElements();
            LoadMap.n.removeAllElements();
            GameCanvas.B.removeAllElements();
            LoadMap.b(GameMidlet.i);
         }

         if (var6 != null) {
            LoadMap.d();
         }

         if (LoadMap.B != -1) {
            GameMidlet.i.a(LoadMap.B, LoadMap.C);
            LoadMap.C = -1;
            LoadMap.B = -1;
         }

         if (LoadMap.H != -1) {
            GameMidlet.i.aw = LoadMap.H;
            GameMidlet.i.ax = LoadMap.I;
            LoadMap.I = -1;
            LoadMap.H = -1;
            a(GameMidlet.i.aw, GameMidlet.i.ax, GameMidlet.i.K, 0);
         }

         GameCanvas.a.b();
         if (GameCanvas.r != this) {
            if (OnScreen.c == 0) {
               b().a();
            } else {
               OnScreen.c = 2;
               class_jv.b().a();
            }
         }

         for(var1 = 0; var1 < var5.size(); ++var1) {
            MyObject var8;
            if ((var8 = (MyObject)var5.elementAt(var1)).az == 0) {
               Avatar var9;
               (var9 = (Avatar)var8).C = var9.aw;
               var9.D = var9.ax;
               var9.t = var9.K;
               var9.h();
               if (var9.w != GameMidlet.i.w) {
                  e(var9);
                  LoadMap.b(var9);
               }
            } else if (var8.az == 5) {
               Drop_Part var10;
               (var10 = (Drop_Part)var8).b = var10.aw;
               var10.c = var10.ax;
               LoadMap.m.addElement(var10);
            }
         }

         if (Bus.b) {
            a(Bus.a.a, Bus.a.b, GameMidlet.i.K, GameMidlet.i.N);
         } else {
            ++GameMidlet.i.ax;
            this.n();
         }

         b((int)GameMidlet.i.S);
         if (GameCanvas.Z == 0 && GameCanvas.D == null) {
            super.ac = this.H;
         }

         h = null;
         if (LoadMap.a != 25) {
            GameCanvas.h();
         }

         GameCanvas.a.sizeChanged(0, 0);
         if (GameCanvas.I) {
            if (LoadMap.a == 9 && Welcome.e != 0) {
               (GameCanvas.D = new Welcome()).b();
            } else if (!Bus.b && LoadMap.a == 23) {
               (GameCanvas.D = new Welcome()).d();
            } else if (LoadMap.a == 25 && Welcome.f > 0) {
               (GameCanvas.D = new Welcome()).a((MyScreen)a);
            }

            super.ac = null;
            super.ad = null;
         }

         GameMidlet.i.M = false;
         GameMidlet.i.N = 0;
         GameMidlet.i.G = 4;
         r = false;
         t = false;
         GameCanvas.A = null;
         if (LoadMap.a == 108) {
            AvCamera.a().d();
            AvCamera.a().b();
         }

         if (GameCanvas.J == 0) {
            GameCanvas.J = 1;
         }

      }
   }

   public static void m() {
      byte var0 = 0;
      switch (i) {
         case 0:
            var0 = 3;
            break;
         case 1:
            var0 = 7;
            break;
         case 2:
            var0 = 21;
            break;
         case 3:
            var0 = 22;
            break;
         case 4:
            var0 = 21;
            break;
         case 5:
            var0 = 22;
      }

      GlobalService.gI().b((int)var0);
   }

   public final void b(byte var1) {
      if (g == -1) {
         this.n();
         System.out.println("doJoinShop: " + var1);
         GameCanvas.i();
         g = var1;
         GlobalService.gI().d((int)8);
      }
   }

   public static void a(int var0, int var1, int var2, int var3) {
      if ((GameMidlet.e == 9 || GameMidlet.e == 11) && !t) {
         GameMidlet.i.C = var0;
         GameMidlet.i.D = var1;
         ParkService.a().a(var0, var1, var2, var3);
      }
   }

   public final void n() {
      a(GameMidlet.i.aw, GameMidlet.i.ax, GameMidlet.i.K, GameMidlet.i.N);
   }

   public static void a(int var0, int var1, int var2, int var3, short var4) {
      Avatar var5 = LoadMap.g(var0);
      if (var0 != GameMidlet.i.w && !t) {
         if (var5 != null) {
            if (var5.L && var5.Q == 0) {
               var5.L = false;
               var5.a(var1, var2);
               var5.N = var4;
            }

            if (var5.H == -3) {
               var5.H = 0;
            }

            var5.R = -1;
            if (var5.Q == 0) {
               AvPosition var6;
               (var6 = new AvPosition(var1, var2, var3)).d = var4;
               var5.g.addElement(var6);
            }
         }

      }
   }

   public final void a(Avatar var1) {
      e(var1);
      var1.h();
      var1.L = true;
      Avatar var2;
      if ((var2 = LoadMap.g(var1.w)) != null) {
         LoadMap.m.removeElement(var2);
      }

      LoadMap.b(var1);
   }

   private static void e(Avatar var0) {
      APartInfo var1;
      if ((var1 = AvatarData.a(var0.e, 50)) != null) {
         var0.d = var1.b;
      }

   }

   public static void c(int var0) {
      Avatar var1;
      if ((var1 = LoadMap.g(var0)) != null) {
         var1.f();
         var1.p = true;
         Fish var2;
         if ((var2 = class_kv.c(var0)) != null) {
            l.removeElement(var2);
         }
      }

   }

   public final void d(int var1) {
      class_im.d().a(var1, this);
      super.d(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         if (var1.indexOf("dmw") != -1) {
            if (h != null) {
               GlobalService.gI().b(h.w, var1);
            }

         } else if (var1.indexOf("ptw") == 0 && h != null && h.O != null && h.O.d != null) {
            String var2 = var1 + " (";

            for(int var3 = 0; var3 < h.O.d.length; ++var3) {
               var2 = var2 + " " + h.O.d[var3];
            }

            var2 = var2 + ").";
            GlobalService.gI().b(h.w, var2);
         } else {
            ParkService.a().a(var1);
         }
      }
   }

   public static void a(int var0, String var1) {
      if (LoadMap.a != 24 && LoadMap.a != 53) {
         Avatar var2;
         if ((var2 = LoadMap.g(var0)) != null) {
            var2.O = null;
            var2.a(100, var1, (byte)(var0 >= 2000000000 ? 1 : 0));
            if (var0 < 2000000000) {
               MessageScr var10000 = MessageScr.b();
               var1 = var2.x + ": " + var1;
               var10000.a.a(var1);
            }

         }
      }
   }

   protected static void o() {
      if (h != null && h.Q == 0) {
         ParkService.a().b(h.w, 101);
      }
   }

   public final void e(int var1) {
      if (h != null) {
         APartInfo var2;
         GameCanvas.a((var2 = (APartInfo)AvatarData.a((short)var1)).i[0], var2.i[1], new class_ij(this, var2), new class_ik(this, var2), (IAction)null);
      }
   }

   public static void f(int var0) {
      ParkService.a().b(h.w, var0);
   }

   public final void a(int var1, int var2, int var3, String var4, int var5) {
      if (var3 == -1) {
         GameCanvas.b(var4);
      } else {
         this.a(1, var1, var2, var3, (int)var5);
      }
   }

   public final void a(int var1, int var2, int var3, String var4, int var5, int var6, int var7, int var8) {
      if (var3 == -1) {
         GameCanvas.b(var4);
      } else {
         if (var1 == GameMidlet.i.w) {
            System.out.println("onGiftGiving: " + var5);
            GameMidlet.i.a(var6, var7, var8);
         }

         this.a(0, var1, var2, var3, (int)0);
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      Avatar var6 = LoadMap.g(var2);
      Avatar var7 = LoadMap.g(var3);
      if (var6 != null && var7 != null) {
         if (var6.Q == 0 && var7.Q == 0) {
            var6.j = var7.w;
            var6.i = var6.w;
            var7.i = var6.w;
            var7.j = var7.w;
            if (var2 == GameMidlet.i.w) {
               GameMidlet.i.D = var7.ax;
               if (GameMidlet.i.aw < var7.aw) {
                  var2 = var7.aw - 15;
               } else {
                  var2 = var7.aw + 15;
               }

               GameMidlet.i.C = var2;
               a(var2, var7.ax, GameMidlet.i.K, GameMidlet.i.N);
            }

            if (var3 == GameMidlet.i.w) {
               a(GameMidlet.i.aw, GameMidlet.i.ax, var6.K == 0 ? Base.J : 0, GameMidlet.i.N);
            }

            if (var1 == 1) {
               var7.R = -1;
               switch (var4) {
                  case 0:
                     var7.Q = var6.Q = -3;
                     this.b(var6.x + " " + T1.ca + var7.x);
                     break;
                  case 100:
                     if (var7.Q == 0) {
                        var6.Q = -2;
                        var7.Q = -2;
                        var6.g.removeAllElements();
                        var7.g.removeAllElements();
                        var6.ao = var7;
                        var6.d(var7.aw, var7.ax + 5);
                     }
                     break;
                  case 101:
                     if (var7.Q == 0) {
                        var6.Q = 11;
                        var7.Q = 11;
                        var6.g.removeAllElements();
                        var7.g.removeAllElements();
                        var6.ao = var7;
                        if (var6.aw < var7.aw) {
                           var6.d(var7.aw - 20, var7.ax + 2);
                        } else {
                           var6.d(var7.aw + 20, var7.ax + 2);
                        }
                     }
                     break;
                  case 102:
                  case 103:
                     var7.Q = var6.Q = 12;
                     var7.Y = var6.Y = (short)var5;
                     this.b(var6.x + " " + T1.bS + " " + var7.x);
                     break;
                  default:
                     this.b(var6.x + " " + "tặng quà" + " " + var7.x);
               }
            } else {
               var6.Q = 9;
               var7.Q = 8;
               var7.R = -1;
               var7.k = var4;
               Part var8 = AvatarData.a((short)var4);
               this.b(var6.x + " " + T1.di + " " + var8.l + " " + T1.dh + " " + var7.x);
            }

            var7.U = var7.S;
            var7.T = 0;
            var6.U = var6.S;
            var6.T = 0;
         }
      }
   }

   public static void b(Avatar var0) {
      SeriPart var1;
      if ((var1 = AvatarData.a(((APartInfo)AvatarData.a((short)var0.k)).j, var0.e)) == null) {
         var0.a(new SeriPart((short)var0.k));
         var0.h();
      } else {
         var1.a = (short)var0.k;
      }
   }

   public static void c(Avatar var0) {
      if (var0 != null) {
         ParkService.a().a(var0.w);
         GameCanvas.b(T1.b + " " + var0.x + "  " + T1.e);
      }
   }

   public final void a(Avatar var1, String var2) {
      class_cw var3;
      (var3 = new class_cw(T1.y, -2, new Command(T1.e, new class_in(this, var1)), new Command(T1.cc, new class_ej(this, var1)), false)).a(var2);
      MessageScr var4 = MessageScr.b();
      var3.a = true;
      var4.b(var3);
      if (GameCanvas.r != MessageScr.b()) {
         ++MyScreen.as;
      }

   }

   public static void a(boolean var0, String var1) {
      if (var0) {
         ListScr.b();
         ListScr.h();
      }

      GameCanvas.b(var1);
   }

   protected static void p() {
      if (h != null) {
         GameCanvas.d(T1.b);
         ParkService.a().b(h.w);
      }

   }

   public static void b(int var0, int var1) {
      if (var0 != GameMidlet.i.w) {
         Avatar var2;
         SeriPart var3;
         if ((var2 = LoadMap.g(var0)) != null && (var3 = AvatarData.b(var2.e, var1)) != null) {
            var2.e.removeElement(var3);
         }

      }
   }

   public final void a(int[] var1) {
      class_hk.b().a(var1);
      class_hk.b().a((MyScreen)this);
   }

   public final void a(Vector var1) {
      GameMidlet.k = var1;
      if (MenuCenter.b().c) {
         MenuCenter.b();
         MenuCenter.g();
      } else {
         this.q();
      }
   }

   public static void a(int var0, short var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         if (AvatarData.a(var1).j == -1) {
            if (var2.V == var1) {
               Pet var3;
               if ((var3 = LoadMap.h(var2.w)) != null) {
                  LoadMap.m.removeElement(var3);
                  var2.V = -1;
               }
            } else {
               var2.a(var1);
               AvatarService.a().e(var2.w);
            }
         } else {
            SeriPart var4;
            if ((var4 = AvatarData.b(var2.e, var1)) != null) {
               var2.e.removeElement(var4);
            } else {
               var2.b(new SeriPart(var1));
               var2.h();
            }
         }

         if (var0 == GameMidlet.i.w) {
            if (GameCanvas.r == PopupShop.b()) {
               PopupShop.b().d();
            }

            GameMidlet.k = null;
            GameCanvas.h();
         }

         r = false;
      }
   }

   public final Command a(Vector var1, int var2, int var3, boolean var4) {
      Command var5 = new Command(T1.bJ, new class_eh(this, var1, var2, var3));
      return var4 ? new Command(T1.c, new class_ee(this, var5)) : var5;
   }

   protected final void q() {
      Avatar var1 = GameMidlet.i;
      if (GameCanvas.r != MenuCenter.a) {
         PopupShop.b().m = true;
         PopupShop.b().a(new String[]{T1.co, T1.l}, new Vector[]{this.a(GameMidlet.k, var1.w, 1), this.a((Avatar)var1, 0)}, (Vector)null);
         PopupShop.b().a(this.a(var1.e, 0, 0, false), 1);
         PopupShop.b().a(this.a(GameMidlet.k, 1, 0, true), 0);
         if (GameCanvas.r != PopupShop.b()) {
            PopupShop.b().a();
         }

      }
   }

   public final Vector a(Avatar var1, int var2) {
      Avatar var6;
      (var6 = new Avatar()).x = var1.x;
      var6.a(var1.a());
      var6.w = var1.w;
      var6.V = var1.V;
      var6.W = var1.W;

      for(int var3 = 0; var3 < var1.e.size(); ++var3) {
         SeriPart var4;
         Part var5;
         if ((var5 = AvatarData.a((var4 = (SeriPart)var1.e.elementAt(var3)).a)) != null && var5.j != 30 && var5.j != 40) {
            var6.a(var4);
         }
      }

      if (var6.V != -1) {
         SeriPart var7;
         (var7 = new SeriPart(var6.V)).b = (byte)(100 - var6.W);
         var6.e.addElement(var7);
      }

      new Vector();
      return this.a(var6.e, var6.w, 0);
   }

   public final Vector a(Vector var1, int var2, int var3) {
      Vector var4 = new Vector();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         SeriPart var7;
         Part var8 = AvatarData.a((var7 = (SeriPart)var1.elementAt(var5)).a);
         String var9 = null;
         if (var2 == GameMidlet.i.w && (!AvatarData.c((int)var8.j) || var3 != 0)) {
            if (var3 == 1) {
               var9 = T1.cs;
            } else {
               var9 = T1.cq;
            }
         }

         class_fz var6 = new class_fz(this, var9, new class_gf(this, var7, var2, var3, var5), var7, var5, var3);
         var4.addElement(var6);
      }

      return var4;
   }

   private Command b(class_kp var1) {
      return new class_fk(this, (String)null, (IAction)null, var1);
   }

   public final void a(class_kp var1) {
      Vector var2;
      (var2 = new Vector()).addElement(this.b(var1));
      PopupShop.b().m = true;
      PopupShop.b().a(new String[]{T1.by}, new Vector[1], var2);
      if (GameCanvas.r != PopupShop.b()) {
         PopupShop.b().a();
      }

   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4) {
      var0.drawImage(k, var2, var3 + 2, 17);
      int var5 = k.getWidth() - 4 * AvMain.Y;
      int var6;
      if ((var6 = var4 * var5 / 100) > var5) {
         var6 = var5;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      GameCanvas.N.a(var0, var1, var2 - 32 * AvMain.Y, var3 + 4 * AvMain.Y - AvMain.af / 2, 1);
      PaintPopup.a(var5 = var2 - 27 * AvMain.Y, var3 + 4 * AvMain.Y - 1, var6, 4 * AvMain.Y, 47084, var0);
      PaintPopup.a(var5, var3 + 5 * AvMain.Y - 1, var6, 1 * AvMain.Y, 8575990, var0);
      PaintPopup.a(var5 + var6, var3 + 4 * AvMain.Y - 1, 1, 4 * AvMain.Y, 13379, var0);
      if (!var1.equals("")) {
         GameCanvas.N.a(var0, String.valueOf(var4), var2 + 29 * AvMain.Y + GameCanvas.N.a("100"), var3 + 4 * AvMain.Y - AvMain.af / 2, 1);
      }

   }

   public static String r() {
      return T1.aJ + ": " + GameCanvas.b(GameMidlet.i.a[0]) + T1.T;
   }

   private static void f(int var0, int var1) {
      if (var0 != var1) {
         GameCanvas.a((var1 - var0 > 0 ? "+" : "") + (var1 - var0), GameMidlet.i.aw, GameMidlet.i.ax - 40, -1, 0, -1);
      }

   }

   public final void a(int var1, class_kp var2, Avatar var3, String var4, short var5, byte var6, byte var7, String var8, short var9, String var10) {
      if (var1 == GameMidlet.i.w) {
         f(GameMidlet.j.g, var2.g);
         f(GameMidlet.j.a, var2.a);
         f(GameMidlet.j.b, var2.b);
         f(GameMidlet.j.e, var2.e);
         f(GameMidlet.j.c, var2.c);
         f(GameMidlet.j.d, var2.d);
         GameMidlet.j = var2;
      }

      GameCanvas.h();
      Avatar var19;
      if ((var19 = LoadMap.g(var1)) != null && x) {
         x = false;
         String var11 = var10;
         short var26 = var9;
         String var25 = var8;
         byte var24 = var7;
         var7 = (byte)var6;
         var6 = (byte) var5;
         String var23 = var4;
         Avatar var22 = var3;
         class_kp var21 = var2;
         Object var20 = var19;
         Vector var12 = new Vector();
         if (var19.w != GameMidlet.i.w) {
            var12 = this.a((Avatar)var19, 0);
         }

         Vector var13 = new Vector();
         String var16 = T1.aJ + ": " + GameCanvas.a(GameMidlet.i.a[0], GameMidlet.i.a[2], GameMidlet.i.b, true);
         StringObj var17 = new StringObj(var16, GameCanvas.N.a(var16));
         Pet var18 = LoadMap.h(var19.w);
         class_fj var15 = new class_fj((String)null, (IAction)null, var19, var18, var17);
         var19.K = 0;
         var13.addElement(var15);
         if (var22 != null) {
            var22.aa = var19.aa;
            var20 = new class_fm(this, "", (IAction)null, var23, var19, var22, var6, var7, var24, var25);
            var13.addElement(var20);
         }

         if (GameMidlet.i.w != ((Base)var20).w) {
            var13.addElement(this.b(var21));
         }

         if (GameCanvas.r != MenuCenter.a) {
            PopupShop.b().m = true;
            if (GameMidlet.i.w == ((Base)var20).w) {
               if (var22 != null) {
                  PopupShop.b().a(new String[]{T1.by, T1.a}, new Vector[2], var13);
                  if (var26 != -1) {
                     PopupShop.b().a(new Command(var11, new class_fv(this, var26)), 1);
                  }
               } else {
                  PopupShop.b().a(new String[]{T1.by}, new Vector[1], var13);
               }
            } else if (var22 != null) {
               PopupShop.b().a(new String[]{T1.by, T1.a, T1.cd, T1.by}, new Vector[]{null, null, null, var12}, var13);
               if (var26 != -1) {
                  PopupShop.b().a(new Command(var11, new class_fo(this, var26)), 1);
               }
            } else {
               PopupShop.b().a(new String[]{T1.by, T1.cd, T1.by}, new Vector[]{null, null, var12}, var13);
            }

            if (GameCanvas.r != PopupShop.b()) {
               PopupShop.b().a();
            }
         }
      }

   }

   public final void a(String var1, int var2) {
      Vector var3 = new Vector();

      for(int var4 = 0; var4 < AvatarData.c.size(); ++var4) {
         Item var5;
         if ((var5 = (Item)AvatarData.c.elementAt(var4)).c == var2) {
            var3.addElement(var5);
         }
      }

      Vector var8 = new Vector();

      for(int var9 = 0; var9 < var3.size(); ++var9) {
         Item var6 = (Item)var3.elementAt(var9);
         CommandIceDream var7 = new CommandIceDream(this, T1.Z, new class_fg(this, var6), var6, var9);
         var8.addElement(var7);
      }

      PopupShop.b().a();
      PopupShop.b().a(new String[]{var1}, new Vector[]{var8}, (Vector)null);
   }

   protected final void a(Item var1) {
      GameCanvas.a(T1.aF, (IAction)(new class_fc(this, var1)));
   }

   public static void a(short var0, int var1) {
      GameCanvas.h();
      PopupShop.n = true;
      Item var2;
      if ((var2 = Item.a(AvatarData.c, var0)) != null) {
         if (var2.c == 5) {
            AvatarService.a().e(GameMidlet.i.w);
         }

         GameMidlet.i.a(var1);
      }

   }

   public final void a(byte var1, int var2, String var3, short[] var4, int var5, String[] var6) {
      if (GameCanvas.r != PopupShop.b()) {
         d(GameMidlet.i);
         if (var2 == 26) {
            if (h == null) {
               return;
            }

            d(h);
         } else {
            d(GameMidlet.i);
         }

         Vector var7 = new Vector();
         if (var1 == 0) {
            if (var4 != null && var4.length != 0) {
               for(var1 = 0; var1 < var4.length; ++var1) {
                  var7.addElement(AvatarData.a(var4[var1]));
               }
            } else {
               for(var1 = 0; var1 < AvatarData.b.length; ++var1) {
                  Part var8;
                  if ((var8 = AvatarData.b[var1]) != null && (var8.i[0] > 0 || var8.i[1] > 0) && var2 == var8.k) {
                     var7.addElement(var8);
                  }
               }
            }

            String var11;
            int var19;
            if (var2 == 26) {
               Vector[] var14 = new Vector[6];

               for(var19 = 0; var19 < 6; ++var19) {
                  var14[var19] = new Vector();
               }

               int[] var21 = new int[6];

               int var20;
               for(var20 = 0; var20 < var7.size(); ++var20) {
                  Part var23 = (Part)var7.elementAt(var20);
                  var11 = "";
                  if (var6 != null && var6.length > 0) {
                     var11 = var6[var20];
                  }

                  var3 = "Tặng";
                  int var10002;
                  if (var23.j == 20) {
                     var14[0].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[0]), var23, var4 != null ? var4[var20] : -1, var21[0], var5, var2));
                     var10002 = var21[0]++;
                  } else if (var23.j == 10) {
                     var14[1].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[1]), var23, var4 != null ? var4[var20] : -1, var21[1], var5, var2));
                     var10002 = var21[1]++;
                  } else if (var23.j != 52 && var23.j != 53 && var23.j != 5) {
                     if (var23.j == 60) {
                        var14[3].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[3]), var23, var4 != null ? var4[var20] : -1, var21[3], var5, var2));
                        var10002 = var21[3]++;
                     } else if (var23.j == 70) {
                        var14[4].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[4]), var23, var4 != null ? var4[var20] : -1, var21[4], var5, var2));
                        var10002 = var21[4]++;
                     } else {
                        var14[5].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[5]), var23, var4 != null ? var4[var20] : -1, var21[5], var5, var2));
                        var10002 = var21[5]++;
                     }
                  } else {
                     var14[2].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[2]), var23, var4 != null ? var4[var20] : -1, var21[2], var5, var2));
                     var10002 = var21[2]++;
                  }
               }

               var20 = 0;

               for(int var24 = 0; var24 < var14.length; ++var24) {
                  if (var14[var24].size() > 0) {
                     ++var20;
                  }
               }

               String[] var25 = new String[]{"Áo", "Quần", "Trang sức", "Nón", "Cầm tay", "Khác"};
               byte[] var26 = new byte[]{0, 1, 2, 3, 4, 5};
               Vector[] var15 = new Vector[var20];
               byte[] var12 = new byte[var20];
               String[] var16 = new String[var20];
               var5 = 0;
               int var17 = 0;

               while(true) {
                  if (var17 >= var14.length) {
                     PopupShop.b().a();
                     PopupShop.o = true;
                     PopupShop.b().a(var16, var15, (Vector)null);
                     break;
                  }

                  if (var14[var17].size() > 0 || var17 == 5) {
                     if (var17 == 5) {
                        int var18 = var14[5].size();

                        for(var19 = 0; var19 < q.size(); ++var19) {
                           class_km var22 = (class_km)q.elementAt(var19);
                           var14[5].addElement(new class_ey(this, T1.bS, new class_ku(this, var19, var22.a), var19, var22, var18));
                        }
                     }

                     var15[var5] = var14[var17];
                     var12[var5] = var26[var17];
                     var16[var5] = var25[var17];
                     ++var5;
                  }

                  ++var17;
               }
            } else {
               Vector var13 = new Vector();

               for(var19 = 0; var19 < var7.size(); ++var19) {
                  Part var9 = (Part)var7.elementAt(var19);
                  String var10 = "";
                  if (var6 != null && var6.length > 0) {
                     var10 = var6[var19];
                  }

                  if (var2 == 100) {
                     var11 = T1.cO;
                  } else if (var2 == 26) {
                     var11 = "Tặng";
                  } else {
                     var11 = T1.Z;
                  }

                  var13.addElement(new class_jx(this, var11, new class_gt(this, var9, var4 != null ? var4[var19] : -1, var2, var10, var5, var19), var9, var4 != null ? var4[var19] : -1, var19, var5, var2));
               }

               if (var13.size() > 0) {
                  PopupShop.b().a();
                  PopupShop.o = true;
                  PopupShop.b().a(new String[]{var3}, new Vector[]{var13}, (Vector)null);
               }
            }

            GameCanvas.h();
         }

      }
   }

   public static void b(int var0, byte var1) {
      if (var0 == GameMidlet.i.w) {
         GameMidlet.i.W = var1;
      } else {
         Avatar var2;
         if ((var2 = LoadMap.g(var0)) != null) {
            var2.W = var1;
         }

      }
   }

   public final void a(int var1, int var2, String var3, String[] var4) {
      Vector var5 = new Vector();

      for(int var6 = 0; var6 < var4.length; ++var6) {
         var5.addElement(new Command(var4[var6], new class_ac(this, var1, var2, var6)));
      }

      GameCanvas.a(var3, var5);
   }

   public static void b(int var0, short var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         var2.X = var1;
      }

   }

   private void b(String var1) {
      this.M.addElement(var1);
      if (this.N == 0) {
         this.N = this.O;
      }

   }

   public final void b(Vector var1) {
      if (var1.size() != 0) {
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            StringObj var4 = (StringObj)var1.elementAt(var3);
            var2.addElement(new class_y(this, var4.a, new IActionExchange(this, var4), var4));
         }

         MenuCenter.b().a(var2);
      }
   }

   public static void a(byte var0, int var1, short var2, int var3, short var4, short var5) {
      Drop_Part var6;
      (var6 = new Drop_Part(var0, var2, var3)).a(var1, var4, var5);
      LoadMap.m.addElement(var6);
      LoadMap.a(LoadMap.l);
   }

   public static void c(int var0, int var1) {
      var0 = var0;
      int var2 = 0;

      Drop_Part var10000;
      while(true) {
         if (var2 >= LoadMap.m.size()) {
            var10000 = null;
            break;
         }

         MyObject var3;
         Drop_Part var5;
         if ((var3 = (MyObject)LoadMap.m.elementAt(var2)).az == 5 && (var5 = (Drop_Part)var3).d == var0) {
            var10000 = var5;
            break;
         }

         ++var2;
      }

      Drop_Part var4 = var10000;
      if (var10000 != null) {
         var4.a(var1);
      }

   }

   public static void a(EffectManager var0) {
      if (LoadMap.x == null) {
         LoadMap.x = new Vector();
      }

      LoadMap.x.addElement(var0);
   }

   public static void a(int var0, Vector var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         var2.f = var1;
         var2.as = 0;
      }

   }

   public final void s() {
      if (this.y) {
         this.y = true;
         GameCanvas.i();
         if (MiniMap.gI().e == 2) {
            GlobalService.gI().c((byte)-1);
         } else {
            byte[] var1 = new byte[]{0, 13, 20, 9, 23, 11, 17};
            ParkService.a().a(var1[MiniMap.gI().e], -1);
         }
      }
   }

   public final void t() {
      if (GameMidlet.i.d == 0) {
         if (!GlobalLogicHandler.a) {
            RegisterScr.b().a();
            GameCanvas.h();
         }
      } else {
         if (GameCanvas.r != MessageScr.d && GameCanvas.r != OptionScr.a) {
            GameCanvas.J = 0;
         }

         if (!this.y) {
            GlobalService.gI().d((int)9);
            GlobalService.gI().c((byte)0);
         } else {
            int var1 = 16 * AvMain.Y;
            LoadMap.y = -1;
            FilePack.b(T1.aw);
            FrameImage var10 = FrameImage.a("ct", var1, var1);
            FilePack.a();
            Vector var2 = new Vector();
            byte[] var3 = new byte[884];
            int var4 = 0;
            InputStream var5 = CRes.c(T1.a() + "/citiMap");

            try {
               for(int var6 = 0; var6 < 26; ++var6) {
                  for(int var7 = 0; var7 < 34; ++var7) {
                     var3[var6 * 34 + var7] = (byte)var5.read();
                     if (var3[var6 * 34 + var7] == 69) {
                        class_kb var8;
                        (var8 = new class_kb()).a = (byte)var7;
                        var8.b = (byte)var6;
                        var8.d = (short)(var4 + 819);
                        var8.c = T1.nameRegion[var4];
                        var2.addElement(var8);
                        ++var4;
                     }
                  }
               }

               var5.close();
            } catch (IOException var9) {
               var9.printStackTrace();
            }

            LoadMap.a = -1;
            MiniMap.j = true;
            MiniMap.gI().a(var10, var3, var2, (byte)34, 16 * AvMain.Y, new Command(T1.O, new ISelectMiniMapAction(this)));
            MiniMap.gI().h = new IActionMiniMapKey(this);
            MiniMap.gI().e = 3;
            MiniMap.gI().a();
            GameCanvas.h();
            if (MiniMap.n != null && MiniMap.o == 0 && !GameCanvas.I) {
               MiniMap.n.perform();
               MiniMap.o = 1;
            }

         }
      }
   }

   protected final void u() {
      TField[] var1 = new TField[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         var1[var2] = new TField();
         var1[var2].d(2);
      }

      var1[0].a(true);
      Command var3 = new Command(T1.cy, new class_m(this, var1));
      InputFace.b().a(var1, T1.cx, T1.eF, var3);
      GameCanvas.A = InputFace.b();
   }

   public static boolean a(TField[] var0) {
      int var1 = -1;

      for(int var2 = 0; var2 < 3; ++var2) {
         if (var0[var2].f().equals("")) {
            var1 = var2;
         }
      }

      if (!var0[1].f().equals(var0[2].f())) {
         var1 = 3;
      }

      if (var0[0].f().equals(var0[1].f())) {
         var1 = 4;
      }

      if (var1 != -1) {
         GameCanvas.b(T1.er[var1]);
         return false;
      } else {
         return true;
      }
   }

   public static void a(byte[] var0, byte var1, byte var2, byte var3, Image var4, short[] var5, Vector var6, Vector var7) {
      B = var5;
      GameCanvas.J = 0;
      b = var1;
      LoadMap.F = var6;
      LoadMap.G = var7;
      ByteArrayInputStream var11 = new ByteArrayInputStream(var0);
      LoadMap.d = new short[var0.length];
      LoadMap.e = var3;
      LoadMap.f = (short)(var0.length / var3);
      LoadMap.b = var4;
      if (var4 != null) {
         int[] var9 = new int[4];
         var4.getRGB(var9, 0, 2, 0, 0, 2, 2);
         LoadMap.s = var9[0];
      }

      try {
         for(int var10 = 0; var10 < LoadMap.d.length; ++var10) {
            LoadMap.d[var10] = (short)var11.read();
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      if (var2 != LoadMap.y) {
         GlobalService.gI().d(var2);
      } else {
         GameCanvas.x.e();
      }
   }

   public final void v() {
      GameCanvas.a(T1.P, (IAction)(new class_l(this)));
   }

   public static void w() {
      if (GameMidlet.i.e != null) {
         GameMidlet.i.e.removeAllElements();
      }

      LoadMap.t = -1;
      LoadMap.c = null;
      LoadMap.i = 24;
      Session_ME.a().c();
      LoginScr.b().a();
      LoginScr.b().e();
      OnScreen.b = false;
      OnScreen.c = 0;
      ListScr.d = null;
      LoadMap.m.removeAllElements();
      GameMidlet.i = new Avatar();
      GameMidlet.j = new class_kp();
      GameCanvas.C.removeAllElements();
      GlobalMessageHandler.a().a = null;
   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 0:
            AvatarService.a().b(GameMidlet.i.w);
            GameCanvas.i();
            return;
         case 1:
            HouseScr.b().e();
            return;
         case 2:
            GlobalService.gI().h(var2);
            return;
         case 3:
            b().b(GameMidlet.i, 0);
            return;
         case 4:
            b().b(GameMidlet.i, 1);
         default:
      }
   }

   public static void g(int var0) {
      HouseScr.b().c = (byte)var0;
      if (GameMidlet.i.q != var0 && GameMidlet.i.q != -1) {
         HouseScr.b().e();
      } else {
         Vector var1;
         (var1 = new Vector()).addElement(new Command(T1.df, 0));
         var1.addElement(new Command(T1.dg, 1));
         MenuSub.a().a(var1, 2);
      }
   }

   public static void d(Avatar var0) {
      (C = new Avatar()).e = new Vector();
      C.K = 0;
      C.d = var0.d;
      C.v = var0.v;

      for(int var1 = 0; var1 < var0.e.size(); ++var1) {
         SeriPart var2;
         (var2 = new SeriPart()).a = ((SeriPart)var0.e.elementAt(var1)).a;
         C.a(var2);
      }

   }

   private void b(Avatar var1, int var2) {
      d(var1);
      byte[] var3 = null;
      byte[] var5 = new byte[2];
      if (g == 3) {
         var5[0] = 3;
         var5[1] = 8;
      }

      System.out.println("typeJoin: " + g);
      byte[] var4;
      Vector[] var6;
      String[] var7;
      switch (g) {
         case 1:
         case 6:
            var3 = new byte[]{10, 20};
            (var6 = new Vector[2])[0] = new Vector();
            var6[1] = new Vector();
            (var7 = new String[2])[0] = T1.aB;
            var7[1] = T1.aC;
            var5[0] = 1;
            var5[1] = 6;
            var4 = new byte[2];
            break;
         case 2:
         case 7:
            var3 = new byte[]{40, 50};
            (var6 = new Vector[2])[0] = new Vector();
            var6[1] = new Vector();
            (var7 = new String[2])[0] = T1.aE;
            var7[1] = T1.aD;
            var4 = new byte[2];
            var5[0] = 2;
            var5[1] = 7;
            break;
         case 3:
         case 4:
         case 5:
         default:
            (var6 = new Vector[1])[0] = new Vector();
            (var7 = new String[1])[0] = T1.dy;
            var4 = new byte[1];
      }

      for(int var8 = 0; var8 < AvatarData.b.length; ++var8) {
         if (AvatarData.b[var8].f != -2) {
            Part var9;
            int var10;
            if ((var9 = AvatarData.b[var8]).f >= 0) {
               var10 = ((APartInfo)AvatarData.b[var9.f]).b;
            } else {
               var10 = ((APartInfo)var9).b;
            }

            if (var9 != null && (var9.i[0] > 0 || var9.i[1] > 0) && (var1.d == var10 || var10 == 0) && (var5[0] == var9.k || var5[1] == var9.k) && var9.f > -2) {
               if (var3 == null) {
                  byte var12 = var4[0];
                  var6[0].addElement(new class_i(this, T1.O, new class_k(this, var9), var9, var12));
                  ++var4[0];
               } else {
                  for(var10 = 0; var10 < var6.length; ++var10) {
                     if (var3[var10] == var9.j) {
                        byte var11 = var4[var10];
                        var6[var10].addElement(new class_e(this, T1.O, new class_g(this, var9), var9, var11));
                        ++var4[var10];
                     }
                  }
               }
            }
         }
      }

      PopupShop.b().a();
      PopupShop.o = true;
      PopupShop.b().a(var7, var6, (Vector)null);
      PopupShop.g = var2;
      PopupShop.b().i();
      GameCanvas.h();
      if (LoadMap.a == 57 && GameCanvas.I) {
         (GameCanvas.D = new Welcome()).b(PopupShop.a);
      }

   }

   public static void a(Part var0) {
      (C = new Avatar()).K = 0;
      C.e = new Vector();
      boolean var1 = false;

      for(int var2 = 0; var2 < GameMidlet.i.e.size(); ++var2) {
         SeriPart var3;
         (var3 = new SeriPart()).a = ((SeriPart)GameMidlet.i.e.elementAt(var2)).a;
         if (AvatarData.a(var3.a).j == var0.j) {
            var3.a = var0.g;
            var1 = true;
         }

         C.a(var3);
      }

      if (!var1) {
         SeriPart var5;
         (var5 = new SeriPart()).a = var0.g;
         C.a(var5);
         C.h();
      }

   }

   public static void h(int var0) {
      b(AvatarData.a((short)var0));
   }

   public static void b(Part var0) {
      GameCanvas.a(var0.i[0], var0.i[1], new class_at(var0), new class_ar(var0), (IAction)null);
   }

   public static void a(short var0, String var1, int var2, int var3, int var4) {
      GameCanvas.b(var1);
      GameMidlet.i.a(var2);
      GameMidlet.i.c(var3);
      GameMidlet.i.b = var4;
      Part var5;
      if ((var5 = AvatarData.a(var0)).f != -2) {
         SeriPart var6;
         if ((var6 = AvatarData.a(var5.j, GameMidlet.i.e)) != null) {
            var6.a = var0;
         } else if (var5.j == -1 && GameMidlet.i.V != -1) {
            GameMidlet.i.a(var0);
            AvatarService.a().e(GameMidlet.i.w);
         } else {
            GameMidlet.i.a(new SeriPart(var0));
            GameMidlet.i.h();
         }

         GameMidlet.i.e(11);
         if (var5.j == -1 && GameMidlet.i.V == -1) {
            GameMidlet.i.j();
            AvatarService.a().e(GameMidlet.i.w);
         }
      }

      GameMidlet.k = null;
   }

   public static void x() {
      ParkService.a().a(b, -1);
      g = -1;
   }

   public final void y() {
      this.d(3, -1);
   }

   public final void a(byte var1, Vector var2, Vector var3, Vector var4) {
      byte[] var5 = new byte[]{59, 60, 58, 104, 105, 101, 102};
      LoadMap.F = var3;
      LoadMap.G = var4;
      GameCanvas.x.e(var5[var1]);
      if (var3 != null) {
         LoadMap.d();
      }

      for(int var6 = 0; var6 < var2.size(); ++var6) {
         MyObject var7;
         if ((var7 = (MyObject)var2.elementAt(var6)).az == 0) {
            Avatar var8;
            (var8 = (Avatar)var7).C = var8.aw;
            var8.D = var8.ax;
            var8.t = var8.K;
            var8.h();
            if (var8.w != GameMidlet.i.w) {
               e(var8);
               LoadMap.b(var8);
            }
         } else if (var7.az == 5) {
            Drop_Part var9;
            (var9 = (Drop_Part)var7).b = var9.aw;
            var9.c = var9.ax;
            LoadMap.m.addElement(var9);
         }
      }

      if (Bus.b) {
         a(Bus.a.a, Bus.a.b, GameMidlet.i.K, GameMidlet.i.N);
      } else {
         ++GameMidlet.i.ax;
         this.n();
      }

      b((int)GameMidlet.i.S);
      if (GameCanvas.I && var5[var1] == 101) {
         (GameCanvas.D = new Welcome()).e();
      }

   }

   public static void i(int var0) {
      D = var0;
      G = LoadMap.a;
      b().n();
      GlobalService.gI().d((int)8);
      GameCanvas.i();
   }

   public final void e(int var1, int var2) {
      if (GameCanvas.r == PopupShop.a) {
         PopupShop.b().d();
      }

      System.out.println("onWeddingStart 1111111111111");
      GameCanvas.J = 1;
      E = var1;
      F = var2;
      t = true;
      this.K = 0;

      int var3;
      int var5;
      for(var3 = 0; var3 < p.size() - 1; ++var3) {
         AvPosition var4 = (AvPosition)p.elementAt(var3);

         for(var5 = var3 + 1; var5 < p.size(); ++var5) {
            AvPosition var6 = (AvPosition)p.elementAt(var5);
            if (var4.e > var6.e) {
               p.setElementAt(var6, var3);
               p.setElementAt(var4, var5);
               var4 = var6;
            }
         }
      }

      MyObject var10;
      for(var3 = 0; var3 < LoadMap.m.size() - 1; ++var3) {
         if ((var10 = (MyObject)LoadMap.m.elementAt(var3)).az == 0) {
            for(var5 = var3 + 1; var5 < LoadMap.m.size(); ++var5) {
               MyObject var14;
               if ((var14 = (MyObject)LoadMap.m.elementAt(var5)).az == 0 && ((Avatar)var10).w > ((Avatar)var14).w) {
                  LoadMap.m.setElementAt(var14, var3);
                  LoadMap.m.setElementAt(var10, var5);
                  var10 = var14;
               }
            }
         }
      }

      for(var3 = 0; var3 < LoadMap.m.size(); ++var3) {
         if ((var10 = (MyObject)LoadMap.m.elementAt(var3)).az == 0) {
            Avatar var13;
            (var13 = (Avatar)var10).g.removeAllElements();
            if (var13.w == var2) {
               var13.aw = var13.C = 0;
               var13.ax = var13.D = 8 * LoadMap.i + LoadMap.i / 2 - LoadMap.i / 2;
               var13.G = 2;
               this.K = 1;
               var13.f(2475, 20);
               var13.f(2476, 10);
               var13.f(300, 60);
               var13.f(302, 70);
               var13.h();
            } else if (var13.w == var1) {
               var13.aw = var13.C = 0;
               var13.ax = var13.D = 8 * LoadMap.i + LoadMap.i / 2 + LoadMap.i / 2;
               var13.G = 2;
               this.K = 1;
               var13.f(2477, 20);
               var13.f(2478, 10);
               var13.h();
            }
         }
      }

      Avatar var11 = LoadMap.g(var1);
      Avatar var12 = LoadMap.g(var2);
      LoadMap.m.removeElement(var11);
      LoadMap.m.removeElement(var12);
      var5 = 0;

      for(int var15 = 0; var15 < LoadMap.m.size(); ++var15) {
         MyObject var7;
         Avatar var8;
         if ((var7 = (MyObject)LoadMap.m.elementAt(var15)).az == 0 && (var8 = (Avatar)var7).w != -100) {
            AvPosition var9;
            GameCanvas.h = GameCanvas.j = (var9 = (AvPosition)p.elementAt(var5 / 2)).a - AvCamera.a().a + LoadMap.i / 2;
            GameCanvas.i = GameCanvas.k = var9.b - AvCamera.a().b + LoadMap.i / 2 + var15 % 2 * (LoadMap.i - 5);
            ++var5;
            var8.a(GameCanvas.h + AvCamera.a().a, GameCanvas.i + AvCamera.a().b);
         }
      }

      LoadMap.m.addElement(var11);
      LoadMap.m.addElement(var12);
      LoadMap.a(LoadMap.m);
      GameCanvas.h();
      System.out.println("onWeddingStart 2222222222222222222: " + t + "     " + this.K);
   }
}

package avt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class LoadMap {
   public static int a = -1;
   public static Image b;
   public static FrameImage c;
   public static short[] d;
   public static short e;
   public static short f;
   public static short[] g;
   public static byte[] h = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 3, 3, 3, 3, 3, 2, -1, -1, -1, 0, 0, 0, 2, 2};
   public static int i = 24;
   public static byte j = 0;
   public static byte k = -1;
   public static Vector l = new Vector();
   public static Vector m = new Vector();
   public static Vector n = new Vector();
   public static Vector o;
   private static int J = 0;
   private AvPosition[] K;
   private static Vector L = new Vector();
   private static int[] M = new int[]{15853390, 15006199, 8183509, 12254198};
   public static MyObject p;
   public static Command q;
   public static Image r;
   private static FrameImage N;
   private static int[] O = new int[]{6143735, 21};
   public static int s;
   public static int t = -1;
   private static int P = -1;
   public static AvPosition u;
   public static Vector v;
   public static Vector w;
   public static Vector x;
   public static int y = -1;
   private static Bus Q = new Bus();
   private boolean R;
   public static boolean z;
   private static int S;
   private static int T;
   public static int A = -1;
   private static int U = 3;
   public static int B = -1;
   public static int C = -1;
   private MyObject V;
   private MyObject W;
   private MyObject X;
   private int Y;
   private int Z;
   private int aa;
   private static int ab = 0;
   private static byte ac;
   public static int D = 0;
   public static int E = -1;
   public static Vector F;
   public static Vector G;
   public static int H = -1;
   public static int I = -1;

   public LoadMap() {
      q = new Command(T1.bz, new class_hr(this));
      J = CRes.e(3);
      i = 24;
      FilePack.b(T1.av);
      FilePack.a("den");
      r = FilePack.a("s0");
      if (GameCanvas.H) {
         if (GameCanvas.Z == 0) {
            N = new FrameImage(FilePack.a("focus"), 21 * AvMain.Y, 15 * AvMain.Y);
         } else {
            N = new FrameImage(FilePack.a("focus"), 32 * AvMain.Y, 11 * AvMain.Y);
         }

         u = new AvPosition();
      }

      FilePack.a();
   }

   public final void a() {
      if (PopupShop.b() != GameCanvas.r && GameCanvas.H) {
         if (GameCanvas.v != null || GameCanvas.A != null || GameCanvas.t != null) {
            return;
         }

         if (GameCanvas.b(0, 0, GameCanvas.m, GameCanvas.n)) {
            int var2 = GameCanvas.k();
            int var3 = GameCanvas.l();
            if (GameCanvas.g) {
               GameCanvas.g = false;
               S = AvCamera.a().a;
               T = AvCamera.a().b;
               this.R = true;
            }

            if (this.R) {
               if (GameCanvas.e && (CRes.f(var2) > 20 || CRes.f(var3) > 20)) {
                  AvCamera.a().c = S + var2;
                  AvCamera.a().d = T + var3;
                  AvCamera.a().a(AvCamera.a().c + GameCanvas.o, AvCamera.a().d + GameCanvas.p);
                  AvCamera.a().e = System.currentTimeMillis() / 100L;
               }

               if (GameCanvas.f) {
                  GameCanvas.f = false;
                  this.R = false;
                  if (CRes.f(var2) < 10 && CRes.f(var3) < 10 && !MapScr.t) {
                     u.a = GameCanvas.h + AvCamera.a().a;
                     u.b = GameCanvas.i + AvCamera.a().b;
                     if (u.b < 0) {
                        u.b = 0;
                     }

                     GameMidlet.i.av = u;
                     GameMidlet.i.l();
                  }
               }
            }
         }
      }
   }

   public final void b() {
      try {
         AvCamera.a().d();
         if ((GameCanvas.Z == 0 || GameCanvas.r != MenuCenter.b()) && m.size() > 0) {
            for (int var1 = 0; var1 < m.size(); var1++) {
               ((MyObject)m.elementAt(var1)).b();
            }

            a(m);
         }

         if (n.size() > 0) {
            a(n);

            for (int var8 = 0; var8 < n.size(); var8++) {
               ((MyObject)n.elementAt(var8)).b();
            }
         }

         if (l.size() > 0) {
            for (int var9 = 0; var9 < l.size(); var9++) {
               ((MyObject)l.elementAt(var9)).b();
            }
         }

         LoadMap var2 = this;
         if (this.K != null) {
            for (int var3 = 0; var3 < var2.K.length; var3++) {
               var2.K[var3].a--;
               if (var2.K[var3].a < AvCamera.a().a - 100) {
                  var2.K[var3].a = AvCamera.a().a + GameCanvas.m + 30 + CRes.e(10) * 50;
                  var2.K[var3].b = -110 - CRes.e(6) * 10;
               }
            }
         }

         if (GameCanvas.l % 4 == 2
                 && !FarmScr.N
                 && (a != 24 || GameCanvas.Z == 0)
                 && FarmScr.E == -1
                 && !FarmScr.y
                 && RaceScr.a != GameCanvas.r
                 && a != -1
                 && GameCanvas.r != MenuCenter.a
                 && GameCanvas.t == null) {
            if (p == null) {
               int var13 = 0;

               while (var13 < m.size() && !i(var13)) {
                  var13++;
               }
            } else if (CRes.f(p.aw - GameMidlet.i.aw) / i >= (p.az == 7 ? U << 1 : U) || CRes.f(p.ax - GameMidlet.i.ax) / i >= (p.az == 7 ? U << 1 : U)) {
               p = null;
               MapScr.h = null;
            }
         }

         if (Bus.b) {
            Q.a();
         }

         if (x != null) {
            for (int var10 = 0; var10 < x.size(); var10++) {
               EffectManager var14;
               if (AvatarData.d((var14 = (EffectManager)x.elementAt(var10)).a) != null) {
                  if (var14.k == 0) {
                     Avatar var15;
                     if ((var15 = g(var14.j)) == null) {
                        x.removeElement(var14);
                        continue;
                     }

                     var14.e = (short)var15.aw;
                     var14.f = (short)var15.ax;
                  }

                  if (var14.g == var14.c) {
                     var14.g = 0;
                     EffectObj var16;
                     (var16 = new EffectObj()).a = var14.a;
                     var16.d = var14.j;
                     var16.e = var14.k;
                     switch (var14.l) {
                        case 0:
                           var16.aw = var14.e;
                           var16.ax = var14.f;
                           break;
                        case 1:
                           int var4 = CRes.e(var14.d);
                           int var5 = CRes.e(360);
                           int var6 = var4 * CRes.b(CRes.c(var5)) >> 10;
                           var4 = -(var4 * CRes.a(CRes.c(var5))) >> 10;
                           var16.aw = var14.e;
                           var16.ax = var14.f;
                           var16.b = (short)var6;
                           var16.c = (short)var4;
                           break;
                        case 2:
                           var16.aw = var14.e;
                           var16.ax = var14.f;
                           if (var14.k == 0) {
                              var16.b = var14.m[var14.i];
                              var16.c = var14.n[var14.i];
                           } else {
                              var16.aw = var16.aw + var14.m[var14.i];
                              var16.ax = var16.ax + var14.n[var14.i];
                           }
                     }

                     var14.h++;
                     var14.i++;
                     if (var14.m != null && var14.i >= var14.m.length) {
                        var14.i = 0;
                     }

                     if (var14.b != -1 && var14.h >= var14.b) {
                        x.removeElement(var14);
                     }

                     switch (var14.k) {
                        case 0:
                           m.addElement(var16);
                           m = a(m);
                           break;
                        case 1:
                           l.addElement(var16);
                           l = a(l);
                           break;
                        case 2:
                           if (v == null) {
                              v = new Vector();
                           }

                           v.addElement(var16);
                           break;
                        case 3:
                           if (w == null) {
                              w = new Vector();
                           }

                           w.addElement(var16);
                     }
                  }

                  var14.g++;
               }
            }
         }

         if (v != null) {
            for (int var11 = 0; var11 < v.size(); var11++) {
               ((EffectObj)v.elementAt(var11)).b();
            }
         }

         if (w != null) {
            for (int var12 = 0; var12 < w.size(); var12++) {
               ((EffectObj)w.elementAt(var12)).b();
            }
         }

         if (N != null && A != -1 && GameMidlet.i.au > 0) {
            u.c++;
            if (u.c >= 10) {
               u.c = 0;
            }
         }

         if (++ab >= 6) {
            ab = 0;
            return;
         }
      } catch (Exception var7) {
      }
   }

   public static void c() {
      if (p != null) {
         z = false;
         int var0 = 0;
         int var1 = m.size();

         for (int var2 = 0; var2 < var1; var2++) {
            MyObject var3;
            if ((var3 = (MyObject)m.elementAt(var2)).az != 4 && var3 == p) {
               var0 = var2;
               break;
            }
         }

         p = null;
         int var4 = var0 + 1;

         while (var4 < var1 && !i(var4)) {
            var4++;
         }

         if (p == null) {
            var4 = 0;

            while (var4 <= var0 && !i(var4)) {
               var4++;
            }
         }
      }
   }

   private static boolean i(int var0) {
      MyObject var1;
      if ((var1 = (MyObject)m.elementAt(var0)).az != 4
              && var1 != GameMidlet.i
              && var1.az != 6
              && Math.abs(var1.aw - GameMidlet.i.aw) / i < (var1.az == 7 ? U << 1 : U)
              && Math.abs(var1.ax - GameMidlet.i.ax) / i < (var1.az == 7 ? U << 1 : U)) {
         if (var1.az != 0 || !((Avatar)var1).L) {
            p = var1;
         }

         if (var1.az == 0 && !((Avatar)var1).L) {
            MapScr.h = (Avatar)m.elementAt(var0);
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean a(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == -1
              || var0 == 108
              || var0 == 109
              || var0 == 57
              || var0 == 62
              || var0 == 0
              || var0 == 1
              || var0 == 2
              || var0 == 3
              || var0 == 4
              || var0 == 5
              || var0 == 6
              || var0 == 7
              || var0 == 8
              || var0 == 12
              || var0 == 11
              || var0 == 14
              || var0 == 15
              || var0 == 16
              || var0 == 13
              || var0 == 25
              || var0 == 24
              || var0 == 52
              || var0 == 53
              || var0 == 9
              || var0 == 58
              || var0 == 63
              || var0 == 59
              || var0 == 64
              || var0 == 56
              || var0 == 21
              || var0 == 68
              || var0 == 69
              || var0 == 70
              || var0 == 17
              || var0 == 18
              || var0 == 51
              || var0 == 71
              || var0 == 95
              || var0 == 96
              || var0 == 107
              || var0 == 10
              || var0 == 19;
   }

   public static boolean b(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == 55
              || var0 == 93
              || var0 == 78
              || var0 == 89
              || var0 == 27
              || var0 == 28
              || var0 == 29
              || var0 == 84
              || var0 == 85
              || var0 == 86
              || var0 == 83
              || var0 == 87
              || var0 == 54
              || var0 == 67
              || var0 == 81
              || var0 == 71
              || var0 == 79
              || var0 == 92
              || var0 == 52
              || var0 == 94
              || var0 == 95
              || var0 == 96
              || var0 == 97
              || var0 == 98
              || var0 == 100
              || var0 == 103
              || var0 == 101
              || var0 == 104
              || var0 == 23;
   }

   public static boolean c(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == 55
              || var0 == 93
              || var0 == 78
              || var0 == 89
              || var0 == 27
              || var0 == 28
              || var0 == 29
              || var0 == 84
              || var0 == 85
              || var0 == 86
              || var0 == 83
              || var0 == 87
              || var0 == 54
              || var0 == 71
              || var0 == 52
              || var0 == 94
              || var0 == 95
              || var0 == 96
              || var0 == 97
              || var0 == 98
              || var0 == 100
              || var0 == 103
              || var0 == 101
              || var0 == 104
              || var0 == 23;
   }

   private void f() {
      GameCanvas.a(T1.P, new IActionExitToCity(this));
   }

   public final boolean a(int var1, int var2) {
      z = false;
      int var3 = c(var1, var2);
      if ((GameCanvas.D == null || Welcome.b(var3)) && var3 != -2) {
         switch (var3) {
            case -1:
               MapScr.b().n();
               if (a == 25) {
                  FarmScr.b();
               }

               if (b != null) {
                  Q.a((byte)-1);
               } else {
                  MapScr.b().e();
               }
               break;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
               MapScr.b().n();
               ParkService.a().a(var3, -1);
               break;
            case 9:
               this.f();
               break;
            case 10:
               GameCanvas.i();
               MapScr.b().n();
               t = -1;
               ParkService.a().a(10, -1);
               break;
            case 12:
               this.f();
               break;
            case 17:
               this.f();
               break;
            case 19:
               GameCanvas.i();
               MapScr.b().n();
               t = -1;
               ParkService.a().a(19, -1);
               break;
            case 20:
               GlobalService.gI().a((short)0);
               GameCanvas.i();
               break;
            case 21:
               HouseScr.b().f();
               break;
            case 22:
            case 26:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 60:
            case 61:
            case 65:
            case 66:
            case 67:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 90:
            case 91:
            case 92:
            case 99:
            case 102:
            case 105:
            case 106:
            default:
               if (var3 >= -125 && var3 < 0) {
                  GameCanvas.i();
                  E = var3;
                  GlobalService.gI().a((short)(var3 - -125));
                  break;
               }

               if (!GameMidlet.i.M && var2 / i == 0 && var3 == 88) {
                  if (MapScr.s) {
                     GameMidlet.i.M = true;
                  } else {
                     ParkService var15 = ParkService.a();
                     if (!MapScr.r) {
                        MapScr.r = true;
                        var15.e((byte)92);
                        var15.k();
                     }
                  }
               }

               return false;
            case 23:
               GlobalService.gI().d(9);
               GameCanvas.i();
               break;
            case 24:
               if (FarmScr.c != null && FarmScr.b == GameMidlet.i.w) {
                  FarmScr.b().a(FarmScr.b, FarmScr.c, FarmScr.i, FarmScr.P, FarmScr.Q, FarmScr.V, FarmScr.U);
               } else {
                  GameCanvas.i();
                  FarmScr.b().b(GameMidlet.i.w, true);
               }
               break;
            case 25:
               FarmScr.b().j();
               break;
            case 27:
            case 56:
               if (a != 18 && a != 109 && a != 108) {
                  MapScr.b().y();
               }
               break;
            case 28:
               FarmScr.b().h();
               break;
            case 29:
               GameCanvas.i();
               ParkService.a().a(MapScr.b);
               break;
            case 52:
               FarmScr.b().g();
               break;
            case 53:
               FarmScr.b();
               FarmScr.o();
               break;
            case 54:
               return class_kv.b().b(var1, var2);
            case 55:
               GameCanvas.i();
               GlobalService var14;
               (var14 = GlobalService.gI()).e((byte)-23);
               var14.k();
               break;
            case 57:
               MapScr.b().n();
               MapScr.b().b((byte)1);
               break;
            case 58:
               MapScr.b().b((byte)2);
               break;
            case 59:
               MapScr.b().b((byte)3);
               break;
            case 62:
               MapScr.b().n();
               MapScr.b().b((byte)6);
               break;
            case 63:
               MapScr.b().b((byte)7);
               break;
            case 64:
               MapScr.b().b((byte)8);
               break;
            case 68:
            case 69:
            case 70:
               MapScr.b();
               MapScr.g(var3 - 67);
               break;
            case 71:
               GameCanvas.i();
               GlobalService.gI().c((byte)-1);
               break;
            case 78:
               MapScr.b().a(T1.cN, 5);
               break;
            case 83:
               int var10001 = var1 / i;
               var3 = var2 / i;
               var2 = var10001;
               LoadMap var13 = GameCanvas.x;
               if (AvatarData.g != null) {
                  for (int var4 = 0; var4 < AvatarData.g.size(); var4++) {
                     ObjAd var5 = (ObjAd)AvatarData.g.elementAt(var4);

                     for (int var6 = 0; var6 < var5.g.size(); var6++) {
                        AvPosition var7;
                        if ((var7 = (AvPosition)var5.g.elementAt(var6)).a == var2 && var7.b == var3 && a + 1 == var7.c) {
                           Vector var19;
                           (var19 = new Vector()).addElement(new Command(T1.z, new class_hu(var13, var5)));
                           var19.addElement(new Command(T1.d, new class_hv(var13)));
                           GameCanvas.a(var5.c, var19);
                           return true;
                        }
                     }
                  }
               }
               break;
            case 84:
               FarmScr.b().a((byte)2, (byte)5);
               break;
            case 85:
               FarmScr.b().a((byte)3, (byte)5);
               break;
            case 86:
               var1 = d(var1, var2);
               var2 = d(Cattle.s.a, Cattle.s.b);
               FarmScr.b().a(2, var1 - var2, FarmScr.h);
               break;
            case 87:
               var1 = d(var1, var2);
               var2 = d(class_ex.s.a, class_ex.s.b);
               FarmScr.b().a(1, var1 - var2, FarmScr.g);
               break;
            case 89:
               byte var10;
               if (a == 108 || a == 109) {
                  var10 = 1;
               } else if (a == 13) {
                  var10 = 2;
               } else {
                  var10 = 3;
               }

               GlobalService.gI().h(var10);
               GameCanvas.i();
               break;
            case 93:
               MapScr.b().a(T1.cN, 4);
               break;
            case 94:
               GlobalService.gI().h(4);
               GameCanvas.i();
               break;
            case 95:
               GameCanvas.i();
               FarmScr.S = GameMidlet.i.aw;
               FarmScr.T = GameMidlet.i.ax;
               FarmService.a().f(0, 0);
               break;
            case 96:
               GameCanvas.i();
               FarmScr.S = GameMidlet.i.aw;
               FarmScr.T = GameMidlet.i.ax;
               FarmService.a().g(0, 0);
               break;
            case 97:
               FarmScr.b().m();
               break;
            case 98:
               FarmScr.b().n();
               break;
            case 100:
               MapScr.b();
               MapScr.i(5);
               break;
            case 101:
               MapScr.b();
               MapScr.i(6);
               break;
            case 103:
               MapScr.b();
               MapScr.i(3);
               break;
            case 104:
               MapScr.b();
               MapScr.i(4);
               break;
            case 107:
               GameCanvas.i();
               MapScr.m = a;
               GlobalService.gI().d(12);
               break;
            case 108:
            case 109:
               B = GameMidlet.i.aw;
               C = GameMidlet.i.ax;
               GameCanvas.i();
               MapScr.A = 1;
               MapScr.z = 0;
               GlobalService.gI().a((short)4);
               break;
            case 110:
               GameCanvas.i();
               AvatarService.a().f(GameMidlet.i.w);
               break;
            case 111:
               GameCanvas.i();
               GlobalService var9;
               (var9 = GlobalService.gI()).e((byte)-105);
               var9.k();
               break;
            case 112:
               if (GameMidlet.i.H != 14) {
                  HouseScr.b().g = GameMidlet.i.ax;
                  if ((var1 = var1 / i * i + i / 2 + 1) < GameMidlet.i.aw) {
                     HouseScr.b().f = var1 + i;
                  } else {
                     HouseScr.b().f = var1 - i;
                  }

                  GameMidlet.i.a(var1, var2 / i * i + 5);
                  MapScr.b();
                  MapScr.a(GameMidlet.i.aw, GameMidlet.i.ax, GameMidlet.i.K, GameMidlet.i.Z);
                  GameMidlet.i.a((byte)14);
                  AvatarService.a().a(14);
               }
         }

         return true;
      } else {
         return false;
      }
   }

   public static void a(Graphics var0) {
      if (w != null) {
         for (int var1 = 0; var1 < w.size(); var1++) {
            ((EffectObj)w.elementAt(var1)).a(var0);
         }
      }
   }

   public final void b(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.c(var1);
      var1.translate(-AvCamera.a().a, -AvCamera.a().b);
      this.c(var1);
   }

   public final void c(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      if (b == null) {
         var1.setColor(1);
         var1.fillRect(AvCamera.a().a, AvCamera.a().b, GameCanvas.m, GameCanvas.n);
      } else {
         var1.setColor(s);
         var1.fillRect(AvCamera.a().a, AvCamera.a().b, GameCanvas.m, GameCanvas.n);
         int var4 = AvCamera.a().a * 30 / 210;
         int var5 = (AvCamera.a().a - var4) / (96 * AvMain.Y);
         int var6 = -(94 - i + i / 2) * AvMain.Y;
         if (a == 107) {
            var6 += 41 * AvMain.Y;
         }

         for (int var7 = var5; var7 <= var5 + GameCanvas.m / (96 * AvMain.Y) + 1; var7++) {
            var3.drawImage(b, var4 + var7 * 96 * AvMain.Y, var6, 0);
         }

         if (o != null) {
            for (int var8 = 0; var8 < o.size(); var8++) {
               AvPosition var9 = (AvPosition)o.elementAt(var8);
               int var15 = AvCamera.a().a * (30 + var9.d * 3) / 210;
               AvatarData.a(var3, var9.c, var9.a + var15, var9.b, 33);
            }
         }

         int var16;
         if ((var16 = L.size()) > 0) {
            for (int var18 = 0; var18 < var16; var18++) {
               AvPosition var23 = (AvPosition)L.elementAt(var18);
               var3.setColor(M[var23.c]);
               var3.fillRect(var23.a + var4, var23.b, 1, 1);
            }
         }

         if (this.K != null) {
            for (int var19 = 0; var19 < var2.K.length; var19++) {
               var3.drawImage(MiniMap.k[0], var2.K[var19].a, var2.K[var19].b, 0);
            }
         }

         if (GameCanvas.B.size() > 0) {
            for (int var20 = 0; var20 < GameCanvas.B.size(); var20++) {
               GameCanvas.B.elementAt(var20);
            }
         }

         if (v != null) {
            for (int var21 = 0; var21 < v.size(); var21++) {
               ((EffectObj)v.elementAt(var21)).a(var3);
            }
         }

         if (GameCanvas.m > e * i) {
            var3.setColor(0);
            var3.fillRect(AvCamera.a().a, AvCamera.a().b, -AvCamera.a().a, GameCanvas.n);
            var3.fillRect(e * i * AvMain.Y, AvCamera.a().b, -AvCamera.a().a, GameCanvas.n);
         }
      }

      Graphics var10 = var1;
      int var12;
      if ((var12 = (AvCamera.a().a + GameCanvas.m) / i + 1) > e) {
         var12 = e;
      }

      int var13;
      if ((var13 = (AvCamera.a().b + GameCanvas.n) / i + 1) > f) {
         var13 = f;
      }

      int var14;
      if ((var14 = AvCamera.a().a / (i * AvMain.Y)) < 0) {
         var14 = 0;
      }

      for (int var24 = 0; var24 < var13; var24++) {
         for (int var11 = var14; var11 < var12; var11++) {
            short var17;
            if ((var17 = d[var24 * e + var11]) != -1) {
               int var22 = var17 / c.c;
               c.b(var22, var17 % c.c, var11 * i * AvMain.Y, var24 * i * AvMain.Y, var10);
            }
         }
      }

      if (N != null && A != -1 && GameMidlet.i.au > 0) {
         N.a(u.c / 2, u.a, u.b, A, 3, var1);
      }
   }

   public final void d(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      this.Y = 0;
      this.Z = 0;
      this.aa = 0;

      while (var2.Y < m.size() || var2.Z < l.size() || var2.aa < n.size()) {
         var2.V = var2.W = var2.X = null;
         if (var2.Y < m.size()) {
            var2.V = (MyObject)m.elementAt(var2.Y);
         }

         if (var2.Z < l.size()) {
            var2.W = (MyObject)l.elementAt(var2.Z);
         }

         if (var2.aa < n.size()) {
            var2.X = (Point)n.elementAt(var2.aa);
         }

         if (var2.V == null || var2.W != null && var2.V.ax >= var2.W.ax || var2.X != null && var2.V.ax >= var2.X.ax) {
            if (var2.W == null || var2.X != null && var2.W.ax >= var2.X.ax) {
               if (var2.X != null) {
                  var2.X.a(var3);
                  var2.aa++;
               }
            } else {
               var2.W.a(var3);
               var2.Z++;
            }
         } else {
            var2.V.a(var3);
            var2.Y++;
         }
      }

      if (GameCanvas.Z == 0 && p != null) {
         var1.drawImage(MapScr.d, p.aw * AvMain.Y, (p.ax - (p.az == 7 ? 10 : p.aA)) * AvMain.Y - ab / 2, 3);
      }

      if (Bus.b) {
         Q.a(var1);
      }
   }

   private static void g() {
      L.removeAllElements();
      if (j != 0 && J != 0 && k == -1) {
         if (a != 9 && a != 12) {
            int var2 = CRes.e(GameCanvas.m / 10);

            for (int var3 = 0; var3 < var2; var3++) {
               L.addElement(new AvPosition(CRes.e(e * i), -(38 + CRes.e(GameCanvas.p)), CRes.e(4)));
            }
         } else {
            int var0 = CRes.e(GameCanvas.m / 10);

            for (int var1 = 0; var1 < var0; var1++) {
               L.addElement(new AvPosition(CRes.e(e * i), -(98 + CRes.e(GameCanvas.p)), CRes.e(4)));
            }
         }
      }
   }

   public static InputStream d(int var0) {
      FilePack.a = new FilePack("/a.clazz");
      String var3 = "" + var0;
      byte[] var4 = FilePack.a.c(var3);
      ByteArrayInputStream var1 = null;
      if (var4 != null) {
         try {
            var1 = new ByteArrayInputStream(var4);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

      return var1;
   }

   public final void e(int var1) {
      if (Session_ME.a().b()) {
         GameCanvas.J = 0;
         GameCanvas.h();
      }

      if (GameCanvas.D != null) {
         GameCanvas.D = null;
      }

      GameCanvas.a.b();
      GameMidlet.i.au = 0;
      y = -1;
      q.a = T1.bz;
      GameCanvas.B.removeAllElements();
      GameMidlet.i.L = false;
      Bus.b = false;
      AvCamera.f = false;
      GameMidlet.i.b((byte)0);
      i();
      MapScr.l.removeAllElements();
      p = null;
      MapScr.h = null;
      int var2;
      if ((var2 = Calendar.getInstance().get(11)) < 18 && var2 >= 6) {
         j = 0;
      } else {
         j = 1;
      }

      s = O[j];
      if ((var2 = var1 - 1) == 107 || var2 >= 0 && var2 < h.length && h[var2] != -1) {
         if (var2 == 107 || P != h[var2] || t != j) {
            byte var3;
            if (var2 == 107) {
               var3 = 0;
            } else {
               var3 = h[var2];
            }

            P = var3;
            FilePack.b(T1.as);
            Image var4 = FilePack.a(String.valueOf(var3) + j);
            Image var10 = FilePack.a(String.valueOf(j));
            Graphics var14 = (b = Image.createImage(96 * AvMain.Y, 96 * AvMain.Y)).getGraphics();
            PaintPopup.a(0, 0, 96 * AvMain.Y, 10 * AvMain.Y, O[j], var14);
            var14.drawImage(var10, 0, 69 * AvMain.Y, 36);
            var14.drawImage(var4, 0, 96 * AvMain.Y, 36);
            FilePack.a();
         }
      } else {
         P = -1;
         b = null;
      }

      if (t != j || c == null) {
         if (var1 - 1 == 19) {
            try {
               t = -1;
               c = new FrameImage(Image.createImage(T1.a() + "/wedding.png"), i * AvMain.Y, i * AvMain.Y);
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         } else if (var1 - 1 != 107) {
            i = 24;
            t = j;
            InputStream var11 = CRes.c(T1.a() + "/data/h" + j);
            InputStream var15 = CRes.c(T1.a() + "/data/data");

            try {
               byte[] var16 = new byte[var11.available()];
               var11.read(var16);
               byte[] var12 = new byte[var15.available()];
               var15.read(var12);
               c = new FrameImage(CRes.a(var16, var12), i * AvMain.Y, i * AvMain.Y);
            } catch (IOException var6) {
               var6.printStackTrace();
            }
         } else {
            try {
               i = 12;
               t = -1;
               c = new FrameImage(Image.createImage(T1.a() + "/tileDuaXe.png"), i * AvMain.Y, i * AvMain.Y);
            } catch (IOException var5) {
               var5.printStackTrace();
            }
         }
      }

      InputStream var13;
      if ((var13 = d(var1)) != null) {
         f = 8;
         switch (var1 - 1) {
            case 9:
               f = 8;
               break;
            case 10:
               f = 9;
            case 11:
            case 13:
            case 24:
            default:
               break;
            case 17:
               f = 6;
               break;
            case 18:
               f = 10;
               break;
            case 19:
               f = 13;
               break;
            case 20:
            case 57:
            case 58:
            case 59:
            case 62:
            case 63:
            case 64:
            case 100:
            case 101:
            case 103:
            case 104:
            case 109:
               f = 11;
               break;
            case 21:
               f = 7;
               break;
            case 25:
               f = 7;
               break;
            case 60:
            case 61:
            case 65:
               f = 5;
               break;
            case 107:
               f = 16;
               break;
            case 108:
               f = 8;
         }
      }

      this.a(var13, var1, true);
      a = var1 - 1;
      System.out.println("index: " + a);
      if (k != -1 && a < h.length && h[a] != -1) {
         AnimateEffect var8 = new AnimateEffect(k, 0);
         GameCanvas.B.addElement(var8);
      }

      this.h();
      g();
      if (Session_ME.a().b() && GameMidlet.i.e != null) {
         b(GameMidlet.i);
      }

      if (GameCanvas.J == 0) {
         GameCanvas.J = 1;
      }

      System.gc();
   }

   public final void a(InputStream inputStream, int n, boolean bl) {
      int n2;
      short s;
      block170: {
         s = 0;
         byte by = 0;
         byte by2 = 0;
         byte by3 = 0;
         byte by4 = 0;
         byte by5 = 0;
         byte by6 = 0;
         byte by7 = 0;
         int n3 = 0;
         int n4 = 0;
         int n5 = 0;
         byte by8 = 0;
         byte by9 = 0;
         byte by10 = 0;
         int n6 = 0;
         int n7 = 0;
         int n8 = 0;
         int n9 = 0;
         int n10 = 0;
         int n11 = 0;
         int n12 = 0;
         byte by11 = 0;
         byte by12 = 0;
         byte by13 = 0;
         int n13 = 0;
         byte by14 = 0;
         int n14 = 0;
         int n15 = 0;
         int n16 = 0;
         int n17 = 0;
         byte by15 = 0;
         int n18 = 0;
         byte by16 = 0;
         byte by17 = 0;
         int n19 = 0;
         int n20 = 0;
         int n21 = 0;
         int n22 = 0;
         int n23 = 0;
         int avatar = 0;
         int n24 = 0;
         ac = 0;
         byte[] byArray = new byte[13];
         try {
            if (inputStream != null) {
               e = (short)(inputStream.available() / f);
               d = new short[f * e];
            }
            if (bl) {
               g = new short[f * e];
            }
            avatar = 0;
            while (avatar < f * e) {
               if (inputStream != null) {
                  LoadMap.d[avatar] = (short)inputStream.read();
                  if (d[avatar] == 255) {
                     LoadMap.d[avatar] = -1;
                  }
               }
               ++avatar;
            }
            if (n - 1 == 19) {
               MapScr.p = new Vector();
               avatar = 0;
               while (avatar < d.length) {
                  LoadMap.g[avatar] = (short) (d[avatar] < 32 ? 80 : 88);
                  if (d[avatar] == 65) {
                     LoadMap.g[avatar] = 10;
                     LoadMap.d[avatar] = 1;
                     if (avatar == 1) {
                        LoadMap.d[avatar] = 16;
                        GameMidlet.i.aw = GameMidlet.i.C = LoadMap.k(avatar) + i;
                        GameMidlet.i.ax = GameMidlet.i.D = LoadMap.l(avatar) + 12;
                        LoadMap.a(T1.aq, LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + 12);
                     }
                     avatar = (byte)(avatar + 1);
                  } else if (d[avatar] == 27) {
                     AvPosition myObject = new AvPosition();
                     new AvPosition().a = LoadMap.k(avatar);
                     myObject.b = LoadMap.l(avatar);
                     myObject.e = (short)((5 - MapScr.p.size() % 6 << 1) + MapScr.p.size() / 6);
                     MapScr.p.addElement(myObject);
                  }
                  ++avatar;
               }
               Avatar exception2 = new Avatar();
               new Avatar().aw = exception2.C = 26 * i;
               exception2.ax = exception2.D = 8 * i + i / 2;
               exception2.x = "chu hon";
               exception2.w = -100;
               exception2.a(new SeriPart((short) 2480));
               exception2.K = exception2.t = Base.J;
               m.addElement(exception2);
               break block170;
            }
            if (n - 1 == 107) {
               avatar = 0;
               while (avatar < f * e) {
                  MyObject n27;
                  if (d[avatar] == 61 && CRes.e(2) == 1) {
                     Avatar var62 = new Avatar();
                     Avatar var53 = (Avatar)RaceScr.b().p.elementAt(CRes.e(RaceScr.b().p.size()));
                     var62.e = var53.e;
                     var62.aw = var62.C = k(avatar) + 12;
                     var62.ax = var62.D = l(avatar) + 12;
                     var62.H = 2;
                     var62.az = 9;
                     m.addElement(var62);
                  }
                  if (d[avatar] == 59) {
                     n27 = new ImageObj(1084, LoadMap.k(avatar) + i, LoadMap.l(avatar), 0);
                     l.addElement(n27);
                  } else if (d[avatar] == 60) {
                     n27 = new ImageObj(1085, LoadMap.k(avatar) + i, LoadMap.l(avatar), 0);
                     l.addElement(n27);
                  }
                  ++avatar;
               }
               break block170;
            }
            avatar = 0;
            while (avatar < f * e) {
               block173: {
                  block171: {
                     block172: {
                        if (d[avatar] == -4) break block171;
                        if (d[avatar] != -5) break block172;
                        LoadMap.g[avatar] = 88;
                        break block173;
                     }
                     if (d[avatar] == -3 || d[avatar] == -6) break block173;
                     LoadMap.g[avatar] = d[avatar] >= 120 && d[avatar] <= 123 ? 80 : (short) (d[avatar] >= 114 && d[avatar] <= 119 ? 80 : (d[avatar] == 67 || d[avatar] == 85 ? 92 : (d[avatar] >= 20 && d[avatar] <= 23 ? 79 : (d[avatar] < 7 ? 80 : 88))));
                     if (d[avatar] >= 44 && d[avatar] <= 55) {
                        LoadMap.g[avatar] = 80;
                     }
                     if (d[avatar] == 62 && n - 1 != 62 && n - 1 != 101 && n - 1 != 104 && n - 1 != 103 && n - 1 != 100 && n - 1 != 101) {
                        LoadMap.g[avatar] = 56;
                     }
                     if (d[avatar] != 111 && d[avatar] != 112) break block173;
                  }
                  LoadMap.g[avatar] = 80;
               }
               if (inputStream != null || GameMidlet.e != 11) {
                  switch (d[avatar]) {
                     case -1: {
                        LoadMap.g[avatar] = 88;
                        break;
                     }
                     case 24:
                     case 25:
                     case 26: {
                        if (!bl) break;
                        LoadMap.a(845, LoadMap.k(avatar) + 11, LoadMap.l(avatar));
                        break;
                     }
                     case 27: {
                        if (!bl) break;
                        LoadMap.a(844, LoadMap.k(avatar) + 11, LoadMap.l(avatar) + 1);
                        break;
                     }
                     case 28: {
                        if (!bl) break;
                        if (!Session_ME.a().b()) {
                           LoadMap.d[avatar] = 4;
                           break;
                        }
                        LoadMap.a(0, LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i - 2);
                        break;
                     }
                     case 127: {
                        if (by15 == 0) {
                           LoadMap.a(830, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + i - 2);
                           byte by18 = by15;
                           by15 = (byte)(by18 + 1);
                           LoadMap.b(avatar, by18, 2);
                        }
                        LoadMap.a(avatar, (byte)108, 96);
                        break;
                     }
                     case 128: {
                        if (s == 0) {
                           LoadMap.e(828, avatar);
                           byte by19 = (byte) s;
                           s = (byte)(by19 + 1);
                           LoadMap.b(avatar, by19, 2);
                        }
                        LoadMap.a(avatar, (byte)55, 5);
                        LoadMap.d[avatar] = d[avatar + e];
                        break;
                     }
                     case 129:
                     case 160: {
                        if (by == 0) {
                           if (n - 1 == 17) {
                              LoadMap.e(836, avatar);
                           } else {
                              LoadMap.e(829, avatar);
                           }
                           byte by20 = by;
                           by = (byte)(by20 + 1);
                           LoadMap.b(avatar, by20, 2);
                        }
                        LoadMap.a(avatar, d[avatar] == 129 ? (byte)57 : 62, 96);
                        break;
                     }
                     case 130:
                     case 131:
                     case 132:
                     case 133:
                     case 134:
                     case 135:
                     case 136:
                     case 137:
                     case 138: {
                        int n30;
                        int n25 = n30 = d[avatar] - 130;
                        byte by21 = byArray[n25];
                        byArray[n25] = (byte)(by21 + 1);
                        LoadMap.b(avatar, by21, 0);
                        LoadMap.a(avatar, (byte)n30);
                        break;
                     }
                     case 153: {
                        if (by14 == 0) {
                           byte by22 = by14;
                           by14 = (byte)(by22 + 1);
                           LoadMap.b(avatar, by22, 0);
                        }
                        LoadMap.a(avatar, (byte)11);
                        break;
                     }
                     case 139: {
                        LoadMap.g[avatar] = -1;
                        byte by23 = by13;
                        by13 = (byte)(by23 + 1);
                        LoadMap.b(avatar, by23, 0);
                        if (a == -1 && n != 21 && b != null) {
                           Bus.a = new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) - i / 2);
                           Q.a((byte)1);
                        }
                        LoadMap.a(avatar, d);
                        break;
                     }
                     case 140: {
                        byte by24 = by12;
                        by12 = (byte)(by24 + 1);
                        LoadMap.b(avatar, by24, 0);
                        LoadMap.a(avatar, (byte)25, 55);
                        by12 = (byte)(by12 + 1);
                        break;
                     }
                     case 141: {
                        if (by3 == 0) {
                           LoadMap.e(840, avatar);
                           byte by25 = by3;
                           by3 = (byte)(by25 + 1);
                           LoadMap.b(avatar, by25, 0);
                        }
                        LoadMap.a(avatar, (byte)24, 5);
                        LoadMap.d[avatar] = d[avatar + e];
                        break;
                     }
                     case 142: {
                        LoadMap.a(avatar, (byte)80, 7);
                        FarmScr.b().v[n5] = new AvPosition(avatar % e, avatar / e, 0);
                        n5 = (byte)(n5 + 1);
                        break;
                     }
                     case 143: {
                        if (by2 == 0) {
                           LoadMap.e(831, avatar);
                           byte by26 = by2;
                           by2 = (byte)(by26 + 1);
                           LoadMap.b(avatar, by26, 2);
                        }
                        LoadMap.a(avatar, (byte)52, 51);
                        LoadMap.d[avatar] = d[avatar + e];
                        break;
                     }
                     case 144: {
                        if (by4 == 0) {
                           LoadMap.e(841, avatar);
                           byte by27 = by4;
                           by4 = (byte)(by27 + 1);
                           LoadMap.b(avatar, by27, 2);
                        }
                        LoadMap.a(avatar, (byte)53, 5);
                        break;
                     }
                     case 145: {
                        byte by28 = ac;
                        ac = (byte)(by28 + 1);
                        LoadMap.b(avatar, by28, 0);
                        if (n - 1 == 109 || n - 1 == 57 && a == 17) {
                           LoadMap.a(avatar, (byte)17, -1);
                           break;
                        }
                        if (a == 23) {
                           LoadMap.a(avatar, (byte)23, -1);
                           break;
                        }
                        LoadMap.a(avatar, (byte)9, -1);
                        if (n - 1 != 100) break;
                        LoadMap.d[avatar] = 47;
                        break;
                     }
                     case 147:
                     case 161: {
                        if (by5 == 0) {
                           LoadMap.e(832, avatar);
                           byte by29 = by5;
                           by5 = (byte)(by29 + 1);
                           LoadMap.b(avatar, by29, 2);
                        }
                        LoadMap.a(avatar, d[avatar] == 147 ? (byte)58 : 63, 96);
                        break;
                     }
                     case 148:
                     case 162: {
                        if (by6 == 0) {
                           if (n == 18) {
                              LoadMap.a(836, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + i - 2);
                           } else {
                              LoadMap.a(833, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + i - 2);
                           }
                           byte by30 = by6;
                           by6 = (byte)(by30 + 1);
                           LoadMap.b(avatar, by30, 2);
                        }
                        LoadMap.a(avatar, d[avatar] == 148 ? (byte)59 : 64, 96);
                        break;
                     }
                     case 149: {
                        if (by7 == 0) {
                           LoadMap.e(834, avatar);
                           if (GameMidlet.i.w == FarmScr.b) {
                              LoadMap.b(avatar, by7, 2);
                           }
                           by7 = (byte)(by7 + 1);
                        }
                        LoadMap.a(avatar, (byte)28, 4);
                        break;
                     }
                     case 150: {
                        if (n17 == 0) {
                           LoadMap.e(842, avatar);
                        }
                        LoadMap.a(avatar, (byte)93, 0);
                        if (n == 26) {
                           LoadMap.d[avatar] = 4;
                        }
                        n17 = (byte)(n17 + 1);
                        break;
                     }
                     case 151: {
                        if (n18 == 0) {
                           LoadMap.e(843, avatar);
                        }
                        LoadMap.a(avatar, (byte)78, 0);
                        n18 = (byte)(n18 + 1);
                        break;
                     }
                     case 152: {
                        if (n3 == 0) {
                           LoadMap.e(835, avatar);
                        }
                        LoadMap.a(avatar, (byte)81, n - 1 == 25 ? 55 : 0);
                        n3 = (byte)(n3 + 1);
                        break;
                     }
                     case 155: {
                        LoadMap.a(avatar, (byte)80, 55);
                        if (Cattle.t <= 0) break;
                        LoadMap.a(avatar, (byte)84, 112);
                        LoadMap.a(-5, LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        Cattle.r = new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        break;
                     }
                     case 156: {
                        LoadMap.a(avatar, (byte)80, 5);
                        if (Dog.t <= 0) break;
                        LoadMap.a(avatar, (byte)85, 5);
                        LoadMap.a(-6, LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        Dog.s = new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        break;
                     }
                     case 157: {
                        LoadMap.a(avatar, (byte)80, 111);
                        Cattle.s = new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        break;
                     }
                     case 158: {
                        LoadMap.a(avatar, (byte)80, 5);
                        if (class_ex.r <= 0) break;
                        class_ex.s = new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        break;
                     }
                     case 159: {
                        int avPosition = 4;
                        if (n - 1 == 25) {
                           avPosition = 5;
                        } else if (n - 1 == 108 || n - 1 == 109) {
                           avPosition = 47;
                        } else if (n - 1 == 13) {
                           avPosition = 0;
                        }
                        LoadMap.a(avatar, (byte)89, avPosition);
                        LoadMap.e(848, avatar);
                        break;
                     }
                     case 163: {
                        byte by31 = ac;
                        ac = (byte)(by31 + 1);
                        LoadMap.b(avatar, by31, 0);
                        LoadMap.a(avatar, (byte)12, -1);
                        break;
                     }
                     case 164: {
                        LoadMap.b(avatar, byArray[9], 0);
                        byArray[9] = (byte)(byArray[9] + 1);
                        LoadMap.a(avatar, (byte)13, 6);
                        break;
                     }
                     case 165: {
                        LoadMap.b(avatar, byArray[10], 0);
                        LoadMap.a(avatar, (byte)14, 0);
                        byArray[10] = (byte)(byArray[10] + 1);
                        break;
                     }
                     case 166: {
                        LoadMap.b(avatar, byArray[11], 0);
                        LoadMap.a(avatar, (byte)15, 0);
                        byArray[11] = (byte)(byArray[11] + 1);
                        break;
                     }
                     case 167: {
                        LoadMap.b(avatar, byArray[12], 0);
                        byArray[12] = (byte)(byArray[12] + 1);
                        LoadMap.a(avatar, (byte)16, 43);
                        break;
                     }
                     case 172: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n14 % 3 == 0) {
                           LoadMap.a(836, LoadMap.k(avatar) + 37, LoadMap.l(avatar) + i);
                        }
                        n14 = (byte)(n14 + 1);
                        break;
                     }
                     case 173: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n15 % 4 == 0) {
                           LoadMap.a(837, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + i);
                        }
                        n15 = (byte)(n15 + 1);
                        break;
                     }
                     case 174: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n16 % 4 == 0) {
                           LoadMap.a(838, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + i);
                        }
                        n16 = (byte)(n16 + 1);
                        break;
                     }
                     case 175: {
                        byte by32 = by8;
                        by8 = (byte)(by32 + 1);
                        LoadMap.b(avatar, by32, 0);
                        LoadMap.a(avatar, (byte)68, 96);
                        break;
                     }
                     case 176: {
                        byte by33 = by9;
                        by9 = (byte)(by33 + 1);
                        LoadMap.b(avatar, by33, 0);
                        LoadMap.a(avatar, (byte)69, 96);
                        break;
                     }
                     case 177: {
                        byte by34 = by10;
                        by10 = (byte)(by34 + 1);
                        LoadMap.b(avatar, by34, 0);
                        LoadMap.a(avatar, (byte)70, 96);
                        break;
                     }
                     case 178: {
                        if (by15 == 0) {
                           LoadMap.a(830, LoadMap.k(avatar) + i, LoadMap.l(avatar) + i - 2);
                           byte by35 = by15;
                           by15 = (byte)(by35 + 1);
                           LoadMap.b(avatar, by35, 2);
                        }
                        LoadMap.a(avatar, (byte)109, 96);
                        break;
                     }
                     case 179: {
                        if (by10 == 0) {
                           byte by36 = by10;
                           by10 = (byte)(by36 + 1);
                           LoadMap.b(avatar, by36, 2);
                           LoadMap.e(837, avatar);
                        }
                        LoadMap.a(avatar, (byte)18, 96);
                        break;
                     }
                     case 180: {
                        byte by37 = by10;
                        by10 = (byte)(by37 + 1);
                        LoadMap.b(avatar, by37, 0);
                        LoadMap.a(avatar, (byte)17, 77);
                        if (n - 1 != 101) break;
                        LoadMap.d[avatar] = 0;
                        break;
                     }
                     case 181: {
                        if (n - 1 == 101 || n - 1 == 104 || n - 1 == 103 || n - 1 == 100 || n - 1 == 101) break;
                        if (by16 == 0) {
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i / 2);
                        }
                        by16 = (byte)(by16 + 1);
                        LoadMap.a(avatar, (byte)56, 46);
                        break;
                     }
                     case 182: {
                        FarmScr.C = new AvPosition(LoadMap.k(avatar), LoadMap.l(avatar));
                        LoadMap.a(avatar, (byte)80, 39);
                        break;
                     }
                     case 183: {
                        FarmScr.D = new AvPosition(LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        LoadMap.a(avatar, (byte)88, 13);
                        break;
                     }
                     case 184: {
                        break;
                     }
                     case 185: {
                        if (by17 == 1 && n == 18) {
                           LoadMap.a(975, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        if (n == 18) {
                           LoadMap.a(avatar, (byte)71, 43);
                           if (by17 == 2) {
                              LoadMap.a(T1.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 25);
                           }
                        } else {
                           byte by38 = by17;
                           by17 = (byte)(by38 + 1);
                           LoadMap.b(avatar, by38, 0);
                           LoadMap.a(avatar, (byte)71, 47);
                        }
                        by17 = (byte)(by17 + 1);
                        break;
                     }
                     case 186: {
                        byte by39 = (byte)(n19 + 1);
                        n19 = by39;
                        if (by39 == 3) {
                           LoadMap.a(T1.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 24);
                        }
                        LoadMap.a(avatar, (byte)94, 17);
                        if (n19 != 2) break;
                        LoadMap.a(974, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        break;
                     }
                     case 187: {
                        if (n20 == 0 && FarmScr.b == GameMidlet.i.w) {
                           l.addElement(new SubObject(-10, LoadMap.k(avatar) + 20, LoadMap.l(avatar) + 20, FarmScr.m.getWidth()));
                        }
                        n20 = (byte)(n20 + 1);
                        LoadMap.a(avatar, FarmScr.b == GameMidlet.i.w ? (byte)95 : 80, 4);
                        break;
                     }
                     case 188: {
                        if (FarmScr.b == GameMidlet.i.w) {
                           l.addElement(new SubObject(-10, LoadMap.k(avatar) + 20, LoadMap.l(avatar) + 20, FarmScr.m.getWidth()));
                        }
                        LoadMap.a(avatar, FarmScr.b == GameMidlet.i.w ? (byte)96 : 80, 4);
                        break;
                     }
                     case 189: {
                        FarmScr.J.aw = LoadMap.k(avatar) + 12;
                        FarmScr.J.ax = LoadMap.l(avatar) + 12;
                        if (GameMidlet.i.w == FarmScr.b) {
                           LoadMap.g[avatar] = 97;
                        }
                        LoadMap.d[avatar] = 4;
                        l.addElement(FarmScr.J);
                        if (GameMidlet.i.w == FarmScr.b) break;
                        break;
                     }
                     case 190: {
                        LoadMap.g[avatar] = 98;
                        LoadMap.d[avatar] = 4;
                        if (n21 == 0) {
                           LoadMap.a(1029, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 20);
                           FarmScr.W = LoadMap.k(avatar) + 26;
                           FarmScr.X = LoadMap.l(avatar) + 10;
                           if (FarmScr.b == GameMidlet.i.w) {
                              LoadMap.a(T1.aq, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 24);
                           }
                        }
                        n21 = (byte)(n21 + 1);
                        break;
                     }
                     case 191: {
                        LoadMap.g[avatar] = 23;
                        if (n - 1 == 104) {
                           LoadMap.d[avatar] = 0;
                           if (n6 == 1) {
                              LoadMap.a(T1.aq, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 12);
                           }
                        } else {
                           LoadMap.d[avatar] = (short) (n6 % 2 == 0 ? 46 : 44);
                           if (n6 == 1) {
                              LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 12);
                           }
                        }
                        n6 = (byte)(n6 + 1);
                        break;
                     }
                     case 192: {
                        LoadMap.g[avatar] = 99;
                        LoadMap.d[avatar] = 4;
                        if (n11 == 0) {
                           LoadMap.a(1034, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 24);
                        }
                        n11 = (byte)(n11 + 1);
                        break;
                     }
                     case 193: {
                        LoadMap.g[avatar] = 100;
                        LoadMap.d[avatar] = 4;
                        if (n10 == 1) {
                           LoadMap.a(1032, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n10 = (byte)(n10 + 1);
                        break;
                     }
                     case 194: {
                        LoadMap.g[avatar] = 106;
                        LoadMap.d[avatar] = 4;
                        if (n12 == 0) {
                           LoadMap.a(1030, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        n12 = (byte)(n12 + 1);
                        break;
                     }
                     case 195: {
                        LoadMap.g[avatar] = 102;
                        LoadMap.d[avatar] = 4;
                        if (n8 == 1) {
                           LoadMap.a(1037, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        n8 = (byte)(n8 + 1);
                        break;
                     }
                     case 196: {
                        LoadMap.g[avatar] = 103;
                        LoadMap.d[avatar] = 4;
                        if (n7 == 1) {
                           LoadMap.a(1035, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n7 = (byte)(n7 + 1);
                        break;
                     }
                     case 197: {
                        LoadMap.g[avatar] = 104;
                        LoadMap.d[avatar] = 4;
                        if (n9 == 1) {
                           LoadMap.a(1033, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 24);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n9 = (byte)(n9 + 1);
                        break;
                     }
                     case 198: {
                        LoadMap.g[avatar] = 105;
                        LoadMap.d[avatar] = 4;
                        LoadMap.a(1036, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 20);
                        break;
                     }
                     case 199: {
                        LoadMap.g[avatar] = 101;
                        LoadMap.d[avatar] = 4;
                        if (n4 == 1) {
                           LoadMap.a(1031, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n4 = (byte)(n4 + 1);
                        break;
                     }
                     case 200: {
                        LoadMap.g[avatar] = 107;
                        if (n22 == 1) {
                           LoadMap.a(1075, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n22 = (byte)(n22 + 1);
                        LoadMap.d[avatar] = 5;
                        break;
                     }
                     case 201: {
                        LoadMap.g[avatar] = 19;
                        LoadMap.d[avatar] = 5;
                        if (n23 == 1) {
                           LoadMap.a(1094, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 20);
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n23 = (byte)(n23 + 1);
                        break;
                     }
                     case 202: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n24 % 4 == 0) {
                           LoadMap.a(4, LoadMap.k(avatar) + (i << 1), LoadMap.l(avatar) + i);
                        }
                        n24 = (byte)(n24 + 1);
                        break;
                     }
                     case 203: {
                        byte by40 = by16;
                        by16 = (byte)(by40 + 1);
                        LoadMap.b(avatar, by40, 0);
                        LoadMap.a(avatar, (byte)110, 96);
                        break;
                     }
                     case 204: {
                        LoadMap.d[avatar] = 43;
                        LoadMap.g[avatar] = 10;
                        if (n23 == 1) {
                           LoadMap.a(T1.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 30);
                        }
                        n23 = (byte)(n23 + 1);
                        break;
                     }
                     case 63:
                     case 65: {
                        if (n - 1 == 101 || n - 1 == 104 || n - 1 == 103 || n - 1 == 100 || n - 1 == 101) break;
                        LoadMap.g[avatar] = 56;
                        byte by41 = by11;
                        by11 = (byte)(by41 + 1);
                        LoadMap.b(avatar, by41, 0);
                        if (n - 1 == 57 || n - 1 == 62) {
                           LoadMap.a(T1.aq, LoadMap.k(avatar) - 12, LoadMap.l(avatar) + 12);
                           break;
                        }
                        if (n - 1 == 58 || n - 1 == 63) {
                           LoadMap.a(T1.aq, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 36);
                           break;
                        }
                        LoadMap.a(T1.aq, LoadMap.k(avatar) - 12, LoadMap.l(avatar) + 12);
                        break;
                     }
                     case 97: {
                        LoadMap.g[avatar] = 54;
                        break;
                     }
                     case 98: {
                        LoadMap.g[avatar] = 29;
                        LoadMap.e(846, avatar);
                        if (n - 1 != 108 && n - 1 != 109) break;
                        LoadMap.d[avatar] = 56;
                        break;
                     }
                     case 102: {
                        LoadMap.g[avatar] = 92;
                        BoardScr.I.addElement(new AvPosition(LoadMap.k(avatar) + i / 2, LoadMap.l(avatar) + i));
                        AvPosition avPosition = new AvPosition(-20, LoadMap.l(avatar) + i);
                        if (n13 % 2 == (n == 66 ? 0 : 1)) {
                           avPosition.a = (GameCanvas.m + 20) / AvMain.Y;
                        }
                        BoardScr.J.addElement(avPosition);
                        n13 = (byte)(n13 + 1);
                        break;
                     }
                     case 110: {
                        FarmScr.B = new AvPosition(LoadMap.k(avatar) - i + 8, LoadMap.l(avatar) - 2);
                        LoadMap.a(847, LoadMap.k(avatar) + 11, LoadMap.l(avatar));
                        break;
                     }
                     default: {
                        by17 = 0;
                        by13 = 0;
                     }
                  }
               }
               ++avatar;
            }
         }
         catch (Exception exception) {
            Exception n25 = exception;
            exception.printStackTrace();
         }
      }
      LoadMap.m(n);
      LoadMap.a(l);
      if (a == 24 && FarmScr.b != GameMidlet.i.w) {
         a = 53;
      }
      if ((n2 = a) != -1 && y != -1) {
         n2 = D;
      }
      if (n - 1 != 19) {
         int n26 = 0;
         while (n26 < g.length) {
            int n27 = n26 / e;
            int n31 = n26 % e;
            s = (short)n2;
            if (g[n27 * e + n31] == s) {
               AvPosition avPosition = LoadMap.j(n26);
               if (avPosition == null) break;
               GameMidlet.i.aw = avPosition.a;
               GameMidlet.i.ax = avPosition.b;
               break;
            }
            ++n26;
         }
      }
      if (n == 60) {
         GameMidlet.i.aw = 150;
         GameMidlet.i.ax = f * i - i;
      }
      if (E != -1) {
         D = E;
      }
      AvCamera.a().h = GameMidlet.i;
      AvCamera.a().b(n);
      if (GameCanvas.H) {
         GameMidlet.i.n();
      }
   }

   private static AvPosition j(int var0) {
      if (var0 + 1 < g.length && g[var0] == g[var0 + 1]) {
         for (int var3 = var0; var3 < g.length; var3++) {
            if (g[var3] != g[var3 + 1]) {
               int var4 = i;
               if (var0 / e == f - 1) {
                  var4 = -i;
               }

               return new AvPosition(k(var0) + (var3 - var0 + 1) * i / 2, l(var0) + i / 2 + var4);
            }
         }
      } else if (var0 + e < g.length && g[var0] == g[var0 + e]) {
         for (int var1 = var0; var1 < g.length; var1 += e) {
            if (g[var1] != g[var1 + e]) {
               int var2 = -i;
               if (var0 % e == 0) {
                  var2 = i;
               }

               return new AvPosition(k(var0) + i / 2 + var2, l(var0) + ((var1 - var0) / e + 1) * i / 2);
            }
         }
      }

      return null;
   }

   public static void a(int var0, int var1, int var2) {
      if (y == -1) {
         Object var3;
         if (var0 > 0) {
            var3 = new ImageObj(var0, var1, var2, 0);
         } else {
            var3 = new SubObject(var0, var1, var2, 0);
         }

         l.addElement(var3);
      }
   }

   private static void e(int var0, int var1) {
      if (y == -1) {
         ImageObj var2 = new ImageObj(var0, k(var1) + b(var1, d), l(var1) + i - 4, 0);
         l.addElement(var2);
      }
   }

   private static int k(int var0) {
      return var0 % e * i;
   }

   private static int l(int var0) {
      return var0 / e * i;
   }

   private static void a(int var0, byte var1, int var2) {
      g[var0] = var1;
      d[var0] = (short)var2;
   }

   private static void a(int var0, byte var1) {
      g[var0] = var1;
      if (var0 / e == 0) {
         d[var0] = 43;
      } else {
         d[var0] = 6;
      }
   }

   public static void a(int var0, int var1, byte var2) {
      g[var1 * e + var0] = 51;
   }

   private static void a(String var0, int var1, int var2) {
      if (Session_ME.a().c) {
         l.addElement(new class_hz(var0, var1, var2));
      }
   }

   public static MapItemType f(int var0) {
      int var1 = F.size();

      for (int var2 = 0; var2 < var1; var2++) {
         MapItemType var3;
         if ((var3 = (MapItemType)F.elementAt(var2)).a == var0) {
            return var3;
         }
      }

      return null;
   }

   public static void d() {
      if (G != null && F != null) {
         for (int var0 = 0; var0 < G.size(); var0++) {
            MapItem var1;
            MapItemType var2 = f((var1 = (MapItem)G.elementAt(var0)).b);
            a(var1, var2);
            MapItem var3;
            (var3 = new MapItem(var1.f, var1.aw * i, var1.ax * i, var1.a, var1.b)).d = var1.d;
            l.addElement(var3);
         }

         a(l);
      }
   }

   private static void m(int var0) {
      for (int var1 = 0; var1 < AvatarData.f.size(); var1++) {
         MapItem var2;
         if ((var2 = (MapItem)AvatarData.f.elementAt(var1)).f == var0) {
            MapItemType var3 = AvatarData.b((int) var2.b);
            a(var2, var3);
            l.addElement(new MapItem(var2.f, var2.aw * i, var2.ax * i, var2.a, var2.b));
         }
      }

      if (AvatarData.g != null) {
         for (int var5 = 0; var5 < AvatarData.g.size(); var5++) {
            ObjAd var6 = (ObjAd)AvatarData.g.elementAt(var5);

            for (int var7 = 0; var7 < var6.g.size(); var7++) {
               AvPosition var4;
               if ((var4 = (AvPosition)var6.g.elementAt(var7)).c == var0) {
                  if (var4.b * e + var4.a >= 0 && var4.b * e + var4.a < g.length) {
                     g[var4.b * e + var4.a] = 83;
                  }

                  a(var6.b, var4.a * i + i / 2, var4.b * i + i / 2);
               }
            }
         }
      }
   }

   private void h() {
      this.K = null;
      if (j != 1) {
         this.K = new AvPosition[4];

         for (int var1 = 0; var1 < this.K.length; var1++) {
            int var2 = AvCamera.a().a + CRes.e(GameCanvas.m / 20 + 5) * 20;
            int var3 = -110 - CRes.e(3) * 10;
            this.K[var1] = new AvPosition(var2, var3);
         }

         CRes.c();
      }
   }

   public static Vector a(Vector var0) {
      try {
         int var1 = var0.size();

         for (int var2 = 0; var2 < var1 - 1; var2++) {
            MyObject var3 = (MyObject)var0.elementAt(var2);

            for (int var4 = var2 + 1; var4 < var1; var4++) {
               MyObject var5 = (MyObject)var0.elementAt(var4);
               if (var3.ax > var5.ax) {
                  var0.setElementAt(var3, var4);
                  var0.setElementAt(var5, var2);
                  var3 = var5;
               }
            }
         }
      } catch (Exception var6) {
      }

      return var0;
   }

   private static void i() {
      GameCanvas.B.removeAllElements();
      l.removeAllElements();
      m.removeAllElements();
      n.removeAllElements();
      v = null;
      w = null;
      x = null;
      System.gc();
   }

   public static boolean b(int var0, int var1) {
      int var2;
      return (var2 = c(var0, var1)) != 80 && var2 != 51 ? GameMidlet.i.Q == -5 && (var2 == 79 || var2 == 81 || var2 == 92 || var2 == 67) : true;
   }

   public static int c(int var0, int var1) {
      short var2;
      return var0 >= 0 && var0 <= e * i && var1 / i * e + var0 / i >= 0 && var1 / i * e + var0 / i < g.length ? (var2 = g[var1 / i * e + var0 / i]) : -2;
   }

   public static int d(int var0, int var1) {
      return var0 >= 0 && var0 <= e * i && var1 / i * e + var0 / i < g.length ? var1 / i * e + var0 / i : -1;
   }

   public static Avatar g(int var0) {
      for (int var1 = 0; var1 < m.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject)m.elementAt(var1)).az == 0 && ((Base)var2).w == var0) {
            return (Avatar)var2;
         }
      }

      return null;
   }

   public static void a(byte var0) {
      for (int var1 = 0; var1 < GameCanvas.B.size(); var1++) {
         ((Effect)GameCanvas.B.elementAt(var1)).b = true;
      }

      if (var0 != -1) {
         AnimateEffect var3 = new AnimateEffect(var0, 0);
         GameCanvas.B.addElement(var3);
      }

      k = var0;
   }

   public static void a(Avatar var0) {
      if (var0.V != -1) {
         Pet var1 = new Pet(var0);
         m.addElement(var1);
      }
   }

   public static Pet h(int var0) {
      for (int var1 = 0; var1 < m.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject)m.elementAt(var1)).az == 4 && ((Pet)var2).r.w == var0) {
            return (Pet)var2;
         }
      }

      return null;
   }

   public static void b(Avatar var0) {
      m.addElement(var0);
      var0.j();
   }

   public static void c(Avatar var0) {
      m.removeElement(var0);
      Pet var1;
      if ((var1 = h(var0.w)) != null) {
         m.removeElement(var1);
      }
   }

   public static void a(MyObject var0) {
      if (p == var0) {
         p = null;
      }

      m.removeElement(var0);
   }

   public final void a(byte var1, byte[] var2) {
      y = var1;
      c = new FrameImage(CRes.a(var2), i * AvMain.Y, AvMain.Y * i);
      this.e();
      GameCanvas.J = 0;
   }

   private static void a(int var0, short[] var1) {
      if (var0 % e == 0) {
         var1[var0] = var1[var0 + 1];
      } else {
         var1[var0] = var1[var0 - 1];
      }
   }

   public final void e() {
      Bus.b = false;
      i();
      b(GameMidlet.i);
      short[] var1 = new short[d.length];
      g = new short[d.length];
      byte[] var2 = new byte[100];
      byte var3 = 0;

      for (int var4 = 0; var4 < d.length; var4++) {
         var1[var4] = d[var4];
      }

      for (int var7 = 0; var7 < d.length; var7++) {
         if (d[var7] < c.c) {
            d[var7] = -4;
         } else if (d[var7] < c.c << 1) {
            d[var7] = -5;
         } else {
            int var5;
            switch (var5 = d[var7] - (c.c << 1)) {
               case 0:
                  d[var7] = 98;
                  ImageObj var6 = new ImageObj(846, k(var7) + i / 2, l(var7) + i / 2, 0);
                  l.addElement(var6);
                  break;
               case 1:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               default:
                  b(var7, var2[var5], 0);
                  g[var7] = (byte)(var5 + -125);
                  d[var7] = -3;
                  break;
               case 2:
                  d[var7] = 139;
                  break;
               case 3:
                  d[var7] = 152;
                  break;
               case 12:
                  d[var7] = 150;
                  break;
               case 13:
                  d[var7] = 151;
                  break;
               case 14:
                  b(var7, var3, 0);
                  var3++;
                  d[var7] = 184;
                  var1[var7] = 33;
                  break;
               case 15:
                  var1[var7] = 0;
                  d[var7] = 185;
            }

            if (var5 > 0 && var2[var5] == 0 && var5 - 1 < MapScr.B.length && MapScr.B[var5 - 1] != -1) {
               ImageObj var8 = new ImageObj(MapScr.B[var5 - 1], k(var7) + b(var7, var1), l(var7) + i - 4, 0);
               l.addElement(var8);
            }

            if (var5 != 14) {
               a(var7, var1);
            }

            var2[var5]++;
         }
      }

      AvCamera.f = false;
      GameMidlet.i.H = 0;
      this.a(null, MapScr.b + 1, false);
      a = MapScr.b;
      d = var1;
      AvCamera.a().b(MapScr.b + 1);
      GameCanvas.h();
      P = -1;
      t = -1;
      d();
      ParkService.a().a(MapScr.b, -1);
   }

   private static int b(int var0, short[] var1) {
      for (int var2 = var0; var2 < var1.length; var2++) {
         if (var1[var2] != var1[var2 + 1]) {
            return (var2 - var0 + 1) * i / 2;
         }
      }

      return 0;
   }

   private static void b(int var0, byte var1, int var2) {
      if (var1 == 0) {
         if (var0 + 1 < d.length && d[var0] == d[var0 + 1]) {
            for (int var4 = var0; var4 < d.length; var4++) {
               if (d[var4] != d[var4 + 1]) {
                  a(var2 != 1 ? T1.aq : "thoat", k(var0) + (var4 - var0 + 1) * i / 2, l(var0) + (y == -1 ? i / 2 : i) + (var2 == 2 ? i / 2 : 0));
                  return;
               }
            }
         } else {
            if (var0 + e < d.length && d[var0] == d[var0 + e]) {
               for (int var3 = var0; var3 < d.length; var3 += e) {
                  if (d[var3] != d[var3 + e]) {
                     a(var2 != 1 ? T1.aq : "thoat", k(var0) + 3, l(var0) + ((var3 - var0) / e + 1) * i / 2);
                     return;
                  }
               }
            }
         }
      }
   }

   private static void a(MapItem var0, MapItemType var1) {
      byte var2 = 88;
      if (var1.c == 1) {
         var2 = 79;
      } else if (var1.c == 2) {
         var2 = 67;
      }

      for (int var3 = 0; var3 < var1.j.size(); var3++) {
         AvPosition var4 = (AvPosition)var1.j.elementAt(var3);
         g[(var0.ax + var4.b) * e + var0.aw + var4.a] = var2;
      }
   }

   public static void a(byte var0, byte var1, int var2, int var3) {
      H = var2;
      I = var3;
      y = -1;
      GameCanvas.i();
      if (GameMidlet.e != 9) {
         GlobalService.gI().d(9);
      }

      ParkService.a().a(var0, var1);
   }
}

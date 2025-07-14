package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class RaceScr extends MyScreen implements IChatable {
   public static RaceScr a;
   private Command q;
   private Command r;
   public Command b;
   private Command s;
   private Command t;
   private Command u;
   public PetRace[] c;
   private short v;
   private boolean w;
   public boolean d;
   private boolean x;
   private long y;
   public byte e = 0;
   public byte f = 1;
   public byte g;
   public static Image h;
   public static Image i;
   public static Image[] j;
   public static Image[] k;
   private ChatPopup z;
   public dialogWin l;
   public static byte[][] m;
   private int A;
   private int B;
   private int C;
   private int D;
   private int E;
   private int F;
   private int G;
   private int H;
   private int I;
   private int J;
   private int K;
   private int L;
   private int M;
   private int N;
   private int O;
   private int P;
   private FrameImage Q;
   private FrameImage R;
   private FrameImage S;
   private FrameImage T;
   private boolean U = false;
   private byte V = 0;
   private byte W;
   public short n = 0;
   public long o;
   public Vector p = new Vector();
   private int X;
   private int ay;
   private int az = -1;
   private int aA = 0;
   private int aB = 0;
   private byte aC;
   private boolean aD = false;
   private long aE;
   private long aF;
   private int[] aG = new int[]{100, 500, 1000, 2000, 5000, 10000, 20000, 30000, 50000};
   private boolean aH = false;
   private short aI;
   private short aJ;
   private String aK;
   private byte aL;
   private byte aM;
   private byte aN;

   public static RaceScr b() {
      return a == null ? (a = new RaceScr()) : a;
   }

   public RaceScr() {
      (m = new byte[3][])[0] = new byte[]{0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1};
      m[1] = new byte[]{2, 2, 2, 3, 3, 3, 2, 2, 2, 3, 3, 3};
      m[2] = new byte[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
      this.q = new Command(T1.bz, 3, this);
      this.s = new Command(T1.ec, 1, this);
      this.r = new Command(T1.c, 7, this);
      this.t = new Command(T1.z, 6, this);
      this.u = new Command(T1.d, 8, this);
      this.b = new Command(T1.x, 2, this);
      this.A = 220 * AvMain.hd;
      this.B = 240 * AvMain.hd;
      this.E = 8 * AvMain.hd;
      this.F = this.J = 23 * AvMain.hd;
      this.G = 105 * AvMain.hd;
      this.H = this.L = 211 * AvMain.hd;
      this.K = 95 * AvMain.hd;
      this.I = this.A - this.K - 8 * AvMain.hd;
      this.O = 180 * AvMain.hd + 10 * AvMain.hd + 10 * AvMain.hd;
      this.P = 110 * AvMain.hd;
      this.M = (Canvas.m - this.O) / 2;
      this.N = (Canvas.n - this.P) / 2;
   }

   public final void a() {
      super.a();
   }

   public final void a(PetRace[] var1, short var2, boolean var3, boolean var4) {
      this.x = false;
      this.f = 1;
      this.X = -1;
      Canvas.v = null;
      Canvas.A = null;
      this.U = false;
      int var5;
      if (h == null) {
         try {
            this.Q = new FrameImage(Image.createImage(T1.a() + "/race/popup/tile1.png"), 20 * AvMain.hd, 20 * AvMain.hd);
            this.R = new FrameImage(Image.createImage(T1.a() + "/race/popup/bt1.png"), 31 * AvMain.hd, 31 * AvMain.hd);
            this.T = new FrameImage(Image.createImage(T1.a() + "/race/popup/bt0.png"), 60 * AvMain.hd, 24 * AvMain.hd);
            this.S = new FrameImage(Image.createImage(T1.a() + "/race/popup/time.png"), 14 * AvMain.hd, 14 * AvMain.hd);
            h = Image.createImage(T1.a() + "/race/28.png");
            i = Image.createImage(T1.a() + "/race/29.png");
            j = new Image[5];

            for(var5 = 0; var5 < 5; ++var5) {
               j[var5] = Image.createImage(T1.a() + "/race/bui/d0" + var5 + ".png");
            }

            k = new Image[3];

            for(var5 = 0; var5 < 3; ++var5) {
               k[var5] = Image.createImage(T1.a() + "/race/bui/w" + var5 + ".png");
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      }

      if (!var3) {
         if (var4) {
            for(var5 = 0; var5 < LoadMap.m.size(); ++var5) {
               MyObject var6;
               if ((var6 = (MyObject)LoadMap.m.elementAt(var5)).catagory == 10) {
                  LoadMap.a(var6);
               }
            }
         }

         if (a != Canvas.currentMyScreen) {
            LoadMap.a(LoadMap.m);
            b().a();
            LoadMap.t = -1;
            this.b(1);
            this.b(2);
            Canvas.x.e(108);
            LoadMap.c(GameMidlet.avatar);
            RaceScr var10 = b();
            AvCamera.gI().b(LoadMap.a);
            var10.C = (Canvas.m - var10.A) / 2;
            var10.D = (Canvas.n - var10.B) / 2;
            var10.W = (byte)(35 * AvMain.hd);
            if (Canvas.a.getHeight() <= 240) {
               var10.W = 30;
               var10.B = 215;
               var10.H = var10.L = 185;
            }

            AvCamera.g = false;
         }

         this.c = null;
         this.c = var1;
         if (var1 != null) {
            for(var5 = 0; var5 < 6; ++var5) {
               this.c[var5].x = 20;
               this.c[var5].y = 80 + var5 * 12;
               LoadMap.m.addElement(this.c[var5]);
            }

            AvCamera.gI().h = this.c[2];
            this.g = 3;
         }

         GameMidlet.avatar.x = GameMidlet.avatar.xCur = 0;
      }

      GameMidlet.avatar.y = GameMidlet.avatar.yCur = 96 * AvMain.hd;
      this.d = var3;
      this.w = var4;
      this.v = var2;
      this.y = System.currentTimeMillis();
      if (var3) {
         this.e = 48;
         super.ad = null;
         super.ae = this.q;
         super.ac = this.r;
      } else {
         super.ac = this.r;
         super.ae = null;
         super.ad = null;
         if (!var4) {
            super.ae = this.q;

            for(var5 = 0; var5 < 6; ++var5) {
               int var9 = 0;

               for(int var8 = 0; var8 < this.c[var5].e.length; ++var8) {
                  var9 += this.c[var5].e[var8];
                  PetRace var10000 = this.c[var5];
                  var10000.x += this.c[var5].f[var8] * this.c[var5].e[var8];
                  ++this.c[var5].b;
                  if (var9 >= (var2 - 4) * 20) {
                     break;
                  }
               }
            }
         } else {
            GlobalService.gI().k(this.c[0].IDDB);
            super.ad = this.s;
         }
      }

      this.z = new ChatPopup();
   }

   private void b(int var1) {
      Vector var2 = new Vector();
      Vector var3 = new Vector();
      Vector var4 = new Vector();
      Vector var5 = new Vector();
      Vector var6 = new Vector();

      int var7;
      for(var7 = 0; var7 < AvatarData.b.length; ++var7) {
         Part var8;
         APartInfo var9;
         if ((var8 = AvatarData.b[var7]).f == -1 && var8.IDPart < 2000 && var8.k > 0 && ((var9 = (APartInfo)var8).gender == var1 || var9.gender == 0)) {
            if (var9.zOrder == 10) {
               var2.addElement(var9);
            } else if (var8.zOrder == 20) {
               var3.addElement(var9);
            } else if (var8.zOrder == 30) {
               var4.addElement(var9);
            } else if (var8.zOrder == 40) {
               var5.addElement(var9);
            } else if (var8.zOrder == 50) {
               var6.addElement(var9);
            }
         }
      }

      for(var7 = 0; var7 < 10; ++var7) {
         Avatar var10;
         (var10 = new Avatar()).gender = (byte)var1;
         SeriPart var11;
         (var11 = new SeriPart()).idPart = ((Part)var2.elementAt(CRes.rnd(var2.size()))).IDPart;
         var10.addSeri(var11);
         (var11 = new SeriPart()).idPart = ((Part)var3.elementAt(CRes.rnd(var3.size()))).IDPart;
         var10.addSeri(var11);
         (var11 = new SeriPart()).idPart = ((Part)var4.elementAt(CRes.rnd(var4.size()))).IDPart;
         var10.addSeri(var11);
         (var11 = new SeriPart()).idPart = ((Part)var5.elementAt(CRes.rnd(var5.size()))).IDPart;
         var10.addSeri(var11);
         (var11 = new SeriPart()).idPart = ((Part)var6.elementAt(CRes.rnd(var6.size()))).IDPart;
         var10.addSeri(var11);
         var10.orderSeriesPath();
         this.p.addElement(var10);
      }

   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            GlobalService var4;
            (var4 = GlobalService.gI()).e((byte)8);
            var4.k();
            Canvas.i();
            return;
         case 1:
            if (this.aA >= 0) {
               this.U = true;
               super.ad = this.t;
               super.ac = null;
               super.ae = this.u;
               return;
            }
            break;
         case 2:
            class_fl var3 = new class_fl(this);
            if (this.d) {
               Canvas.a(T1.eP, (IAction)var3);
               return;
            }

            Canvas.a(T1.ee, (IAction)var3);
            return;
         case 3:
            AvCamera var10000 = AvCamera.gI();
            PetRace[] var10001 = this.c;
            byte var10004 = this.g;
            this.g = (byte)(var10004 + 1);
            var10000.h = var10001[var10004];
            if (this.g >= 6) {
               this.g = 0;
               return;
            }
         case 4:
         default:
            break;
         case 5:
            if (this.d || !this.w) {
               super.ac = this.q;
            }

            super.ae = null;
            return;
         case 6:
            GlobalService.gI().c(this.c[this.aA].IDDB, this.aG[this.aB]);
            this.a(8);
            return;
         case 7:
            Vector var2;
            (var2 = new Vector()).addElement(new Command(T1.ed, 0, this));
            var2.addElement(new Command(T1.x, 2, this));
            MenuSub.a().a(var2, 0);
            return;
         case 8:
            super.ad = this.s;
            super.ac = this.r;
            super.ae = null;
            this.U = false;
      }

   }

   public final void k() {
      if (this.aC >= 0) {
         --this.aC;
         if (this.aC == 0) {
            this.e();
         }
      }

      if ((this.d || !this.w) && System.currentTimeMillis() - this.o >= 1000L) {
         this.o = System.currentTimeMillis();
         --this.n;
         if (this.n < 0) {
            this.n = 0;
         }
      }

      GameMidlet.avatar.setPos(AvCamera.gI().xCam + Canvas.o, AvCamera.gI().yCam + Canvas.n - 40 * AvMain.hd);
      if (System.currentTimeMillis() - this.y >= 1000L) {
         this.y = System.currentTimeMillis();
         --this.v;
         if (this.v < 0) {
            this.v = 0;
         } else {
            ++this.ay;
            if (this.w && !this.d && this.ay > 0) {
               this.ay = 0;
               if (this.aA >= 0 && this.c != null && this.aA < 6 && this.c[this.aA] != null && this.c[this.aA].IDDB != this.X) {
                  this.X = this.c[this.aA].IDDB;
                  GlobalService.gI().k(this.X);
               }
            }
         }
      }

      int var1;
      if (this.c != null) {
         var1 = 0;

         int var2;
         for(var2 = 0; var2 < 6; ++var2) {
            if ((this.d || !this.w) && this.c[var2].b >= this.c[var2].f.length) {
               ++var1;
            }
         }

         if (!this.x && var1 == 6) {
            this.x = true;

            for(var2 = 0; var2 < 6; ++var2) {
               LoadMap.a((MyObject)this.c[var2]);
            }
         }

         if (this.x && this.l != null) {
            this.x = false;
            Canvas.A = this.l;
            int[] var10000 = GameMidlet.avatar.money;
            var10000[0] += this.l.f;
            Canvas.a(this.l.f, Canvas.o, Canvas.n - 30 * AvMain.hd, -1, -1);
            this.l = null;
         }
      }

      Canvas.x.b();
      if (this.d && this.e > 0) {
         --this.e;
      }

      if (this.z != null && this.z.a()) {
         this.z.d = null;
      }

      if (this.d || !this.w) {
         for(var1 = 0; var1 < LoadMap.m.size(); ++var1) {
            Base var4;
            if ((var4 = (Base)LoadMap.m.elementAt(var1)).catagory == 9) {
               Avatar var5 = (Avatar)var4;
               if (System.currentTimeMillis() / 1000L - (long)var5.exp > (long)var5.an) {
                  var5.exp = (int)(System.currentTimeMillis() / 1000L);
                  var5.an = (short)(CRes.rnd(10) + 6);
                  int var3;
                  if ((var3 = CRes.rnd(6)) == 1) {
                     var5.setAction((byte)0);
                  } else if (var3 == 3) {
                     var5.setAction((byte)0);
                     var5.doJumps();
                  } else if (var3 == 2) {
                     var5.setAction((byte)7);
                  } else {
                     var5.setAction((byte)2);
                  }
               }
            }
         }
      }

   }

   public final void d(int var1) {
      class_im.d().a(var1, this);
      super.d(var1);
   }

   public final void l() {
      super.l();
      ++this.aE;
      if (Canvas.D == null || !Welcome.d) {
         super.l();
      }

      if (Canvas.a(2)) {
         if (this.U) {
            if (this.aB / 3 > 0) {
               this.aB -= 3;
            }
         } else {
            --this.aA;
            if (this.aA < 0) {
               this.aA = 0;
            }
         }
      } else if (Canvas.a(8)) {
         if (this.U) {
            if (this.aB / 3 < 2) {
               this.aB += 3;
            }
         } else {
            ++this.aA;
            if (this.aA > 5) {
               this.aA = 5;
            }
         }
      } else if (Canvas.a(4)) {
         if (this.U && this.aB % 3 > 0) {
            --this.aB;
         }
      } else if (Canvas.a(6) && this.U && this.aB % 3 < 2) {
         ++this.aB;
      }

      if (Canvas.g && this.c != null && !this.d && this.w) {
         int var1;
         if (this.U) {
            if (Canvas.b(this.M + this.O - 30 * AvMain.hd, this.N, 30 * AvMain.hd, 30 * AvMain.hd)) {
               Canvas.g = false;
               this.V = 5;
               this.aD = true;
               this.aF = this.aE;
            } else {
               for(var1 = 0; var1 < 9; ++var1) {
                  if (Canvas.b(this.M + 5 * AvMain.hd + var1 % 3 * (5 * AvMain.hd + this.T.a), this.N + (this.P - 29 * AvMain.hd * 3) + var1 / 3 * 29 * AvMain.hd - 1 * AvMain.hd, 60 * AvMain.hd, 26 * AvMain.hd)) {
                     this.aB = var1;
                     Canvas.g = false;
                     this.aD = true;
                     this.aF = this.aE;
                     break;
                  }
               }
            }
         } else {
            for(var1 = 0; var1 < 6; ++var1) {
               if (Canvas.b(this.C + this.I + 32 * AvMain.hd / 2 - 15 * AvMain.hd, this.D + this.J + 3 * AvMain.hd + 35 * AvMain.hd * var1 + 31 * AvMain.hd / 2 - 15 * AvMain.hd, 31 * AvMain.hd, 31 * AvMain.hd)) {
                  this.az = var1;
                  this.aD = true;
                  Canvas.g = false;
                  this.aF = this.aE;
                  break;
               }

               if (Canvas.b(this.C + this.I + this.K - 1 * AvMain.hd - this.T.a, this.D + this.J + 3 * AvMain.hd + 35 * AvMain.hd * var1 + 31 * AvMain.hd / 2 - 15 * AvMain.hd, 60 * AvMain.hd, 31 * AvMain.hd)) {
                  this.aA = var1;
                  this.aD = true;
                  Canvas.g = false;
                  this.aF = this.aE;
                  break;
               }
            }
         }
      }

      if (this.aD) {
         if (Canvas.e) {
            if (this.aB != -1) {
               if (!Canvas.b(this.M + 5 * AvMain.hd + this.aB % 3 * (5 * AvMain.hd + this.T.a), this.N + (this.P - 29 * AvMain.hd * 3) + this.aB / 3 * 29 * AvMain.hd - 1 * AvMain.hd, 60 * AvMain.hd, 26 * AvMain.hd)) {
                  this.aB = -1;
               }
            } else if (this.V != 0) {
               if (!Canvas.b(this.M + this.O - 30 * AvMain.hd, this.N, 30 * AvMain.hd, 30 * AvMain.hd)) {
                  this.V = 0;
               }
            } else if (this.az != -1) {
               if (!Canvas.b(this.C + this.I + 32 * AvMain.hd / 2 - 15 * AvMain.hd, this.D + this.J + 3 * AvMain.hd + 35 * AvMain.hd * this.az + 31 * AvMain.hd / 2 - 15 * AvMain.hd, 31 * AvMain.hd, 31 * AvMain.hd)) {
                  this.az = -1;
               }
            } else if (this.aA != -1 && !this.U && !Canvas.b(this.C + this.I + this.K - 1 * AvMain.hd - this.T.a, this.D + this.J + 3 * AvMain.hd + 35 * AvMain.hd * this.aA + 31 * AvMain.hd / 2 - 15 * AvMain.hd, 60 * AvMain.hd, 31 * AvMain.hd)) {
               this.aA = -1;
            }
         }

         if (Canvas.f) {
            if (this.aE - this.aF <= 4L) {
               this.aC = 5;
            } else {
               this.e();
            }

            this.aD = false;
            Canvas.f = false;
         }
      }

      if (this.d || !this.w) {
         Canvas.x.a();
      }

   }

   private void e() {
      if (this.aB != -1) {
         GlobalService.gI().c(this.c[this.aA].IDDB, this.aG[this.aB]);
         this.aB = -1;
         this.aA = -1;
         this.U = false;
         this.a(8);
      } else if (this.V > 0) {
         this.V = 0;
         this.U = false;
         this.aA = -1;
      } else if (this.az != -1) {
         GlobalService.gI().k(this.c[this.az].IDDB);
         this.az = -1;
      } else {
         if (this.aA != -1) {
            this.U = true;
            super.ad = this.t;
            super.ac = null;
            super.ae = this.u;
         }

      }
   }

   private static void a(Graphics var0, int var1, int var2, int var3, int var4, FrameImage var5, int var6) {
      var5.a(0, var1, var2, 0, var0);
      var5.a(2, var1 + var3 - var5.a, var2, 0, var0);
      var5.a(5, var1, var2 + var4 - var5.b, 0, var0);
      var5.a(7, var1 + var3 - var5.a, var2 + var4 - var5.b, 0, var0);

      int var7;
      for(var7 = 0; var7 < (var3 - (var5.a << 1)) / var5.a; ++var7) {
         var5.a(1, var1 + (var7 + 1) * var5.a, var2, 0, var0);
         var5.a(6, var1 + (var7 + 1) * var5.a, var2 + var4 - var5.b, 0, var0);
      }

      var5.a(1, var1 + var3 - (var5.a << 1), var2, 0, var0);
      var5.a(6, var1 + var3 - (var5.a << 1), var2 + var4 - var5.b, 0, var0);

      for(var7 = 0; var7 < (var4 - (var5.b << 1)) / var5.b; ++var7) {
         var5.a(3, var1, var2 + (var7 + 1) * var5.b, 0, var0);
         var5.a(4, var1 + var3 - var5.a, var2 + (var7 + 1) * var5.b, 0, var0);
      }

      var5.a(3, var1, var2 + var4 - (var5.b << 1), 0, var0);
      var5.a(4, var1 + var3 - var5.a, var2 + var4 - (var5.b << 1), 0, var0);
      if (var6 != -1) {
         var0.setColor(var6);
         var0.fillRect(var1 + var5.a, var2 + var5.b, var3 - (var5.a << 1), var4 - (var5.b << 1));
      }

   }

   public final void a(Graphics var1) {
      this.b(var1);
      Canvas.resetTrans(var1);
      if (this.w) {
         Canvas.S.a(var1, this.C, this.D, this.A, this.B, PaintPopup.d[2], PaintPopup.d[3], 1);
         var1.translate(this.C, this.D);
         Canvas.K.a(var1, T1.ec, this.A / 2, 6 * AvMain.hd, 2);
         a(var1, this.E, this.F, this.G, this.H, this.Q, -1);
         a(var1, this.I, this.J, this.K, this.L, MenuNPC.a, -12335933);

         for(int var2 = 0; var2 < 6; ++var2) {
            this.R.drawFrame(this.az == var2 ? 1 : 0, this.I + 32 * AvMain.hd / 2, this.J + 3 * AvMain.hd + this.W * var2 + 31 * AvMain.hd / 2, 0, 3, var1);
            AvatarData.a(var1, this.c[var2].d, this.I + 32 * AvMain.hd / 2, this.J + 3 * AvMain.hd + this.W * var2 + 31 * AvMain.hd / 2, 3);
            Canvas.M.a(var1, "x" + this.c[var2].a, this.I + 32 * AvMain.hd / 2 + this.R.a / 2 - 5 * AvMain.hd, this.J + 3 * AvMain.hd + this.W * var2 + 31 * AvMain.hd / 2 + this.R.b / 2 - AvMain.af, 2);
            this.T.a(this.aA == var2 ? 1 : 0, this.I + this.K - 1 * AvMain.hd - this.T.a, this.J + 7 * AvMain.hd + this.W * var2, 0, var1);
            if (this.c[var2].g > 0) {
               Canvas.K.a(var1, "" + this.c[var2].g, this.I + this.K - 1 * AvMain.hd - this.T.a / 2, this.J + 7 * AvMain.hd + this.W * var2 + this.T.b / 2 - AvMain.ah / 2 - AvMain.hd - 1, 2);
            } else {
               Canvas.K.a(var1, T1.ec, this.I + this.K - 1 * AvMain.hd - this.T.a / 2, this.J + 7 * AvMain.hd + this.W * var2 + this.T.b / 2 - AvMain.ah / 2 - AvMain.hd - 1, 2);
            }
         }

         if (this.aH && this.c != null) {
            Canvas.K.a(var1, this.aK, this.E + this.G / 2, this.F + 6 * AvMain.hd, 2);
            AvatarData.a(var1, this.aI, this.E + this.G / 2, this.F + 40 * AvMain.hd, 3);
            int var4 = this.F + 70 * AvMain.hd;
            Canvas.K.a(var1, T1.aP, this.E + 5 * AvMain.hd, var4, 0);
            Canvas.N.a(var1, this.aJ + "%", this.E + this.G - 8 * AvMain.hd, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            Canvas.K.a(var1, T1.eg, this.E + 5 * AvMain.hd, var4, 0);
            Canvas.N.a(var1, "X" + this.aL, this.E + this.G - 8 * AvMain.hd, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            Canvas.K.a(var1, T1.eh, this.E + 5 * AvMain.hd, var4, 0);
            Canvas.N.a(var1, T1.eD[this.aM], this.E + this.G - 8 * AvMain.hd, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            Canvas.K.a(var1, T1.eQ, this.E + 5 * AvMain.hd, var4, 0);
            Canvas.N.a(var1, T1.eD[this.aN], this.E + this.G - 8 * AvMain.hd, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            this.S.drawFrame(0, this.E + this.S.a / 2 + 8 * AvMain.hd, this.F + this.H - AvMain.ag - this.S.b - 8 * AvMain.hd, 0, 3, var1);
            Canvas.K.a(var1, String.valueOf(this.v), this.E + 8 * AvMain.hd + this.S.a + 2 * AvMain.hd, this.F + this.H - AvMain.ag - this.S.b - 8 * AvMain.hd - Canvas.K.a() / 2, 0);
            this.S.drawFrame(1, this.E + this.S.a / 2 + 8 * AvMain.hd, this.F + this.H - AvMain.ag - AvMain.hd, 0, 3, var1);
            Canvas.K.a(var1, String.valueOf(GameMidlet.avatar.money[0]), this.E + 8 * AvMain.hd + this.S.a + 2 * AvMain.hd, this.F + this.H - AvMain.ag - AvMain.hd - AvMain.ah / 2, 0);
         }

         if (this.U) {
            this.c(var1);
         }
      } else {
         ImageIcon var5;
         if (this.d && this.e > 0 && (var5 = AvatarData.c((short)1065)).count != -1) {
            int var3 = var5.c / 4;
            var1.drawRegion(var5.img, 0, (3 - this.e / 12) * var3, var5.b, var3, 0, Canvas.m / 2, Canvas.n / 2, 3);
         }
      }

      Canvas.resetTrans(var1);
      if (this.z != null && this.z.d != null) {
         this.z.paintAnimal(var1);
      }

      if (Canvas.D == null || !Welcome.d) {
         super.a(var1);
      }

      if ((this.d || !this.w) && Canvas.v == null && this.x) {
         Canvas.L.a(var1, String.valueOf(this.n), Canvas.o, 5, 2);
      }

      Canvas.a(var1);
   }

   private void c(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.S.a(var1, this.M, this.N, this.O, this.P, PaintPopup.d[2], PaintPopup.d[3], 1);
      var1.translate(this.M, this.N);
      Canvas.K.a(var1, T1.ef, this.O / 2, 10 * AvMain.hd, 2);

      for(int var2 = 0; var2 < 9; ++var2) {
         this.T.a(this.aB == var2 ? 1 : 0, 5 * AvMain.hd + var2 % 3 * (5 * AvMain.hd + this.T.a), this.P - 29 * AvMain.hd * 3 + var2 / 3 * 29 * AvMain.hd, 0, var1);
         Canvas.smallFontYellow.a(var1, String.valueOf(this.aG[var2]), 5 * AvMain.hd + var2 % 3 * (5 * AvMain.hd + this.T.a) + this.T.a / 2, this.P - 29 * AvMain.hd * 3 + var2 / 3 * 29 * AvMain.hd + this.T.b / 2 - AvMain.ai / 2, 2);
      }

   }

   public final void b(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.x.b(var1);

      for(int var2 = 0; var2 < 6; ++var2) {
         if (AvCamera.gI().xCam <= 4 * LoadMap.i * AvMain.hd) {
            LoadMap.c.b(0, var2 % 2 == 0 ? 2 : 3, 3 * LoadMap.i * AvMain.hd, (var2 + 6) * LoadMap.i * AvMain.hd, 0, var1);
         }

         if (AvCamera.gI().xCam + Canvas.m >= (LoadMap.wMap - 3) * LoadMap.i * AvMain.hd) {
            LoadMap.c.b(0, var2 % 2 == 0 ? 2 : 3, (LoadMap.wMap - 3) * LoadMap.i * AvMain.hd, (var2 + 6) * LoadMap.i * AvMain.hd, 0, var1);
         }
      }

      Canvas.x.d(var1);
      Canvas.resetTrans(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.equals("")) {
         this.z = new ChatPopup(50, var1, (byte)0);
         this.z.a = Canvas.o;
         this.z.b = Canvas.n - this.z.c - MyScreen.at - class_im.d().b.d;
         GlobalService var10000 = GlobalService.gI();
         String var2 = var1;
         GlobalService var3 = var10000;
         var10000.e((byte)9);
         var3.c(var2);
         var3.k();
      }
   }

   public final void a(short var1, String var2, short var3, byte var4, byte var5, byte var6) {
      this.aH = true;
      this.aI = var1;
      this.aK = var2;
      this.aJ = var3;
      this.aL = var4;
      this.aM = var5;
      this.aN = var6;
   }

   public final void b(String var1) {
      Vector var2 = new Vector();
      int var3 = AvCamera.gI().c;
      if (this.d || !this.w) {
         var3 += Canvas.m / 3;
      }

      int var4;
      for(var4 = 0; var4 < LoadMap.m.size(); ++var4) {
         Base var5;
         if ((var5 = (Base)LoadMap.m.elementAt(var4)).catagory == 9 && var5.x * AvMain.hd > var3 && var5.x * AvMain.hd < var3 + Canvas.m) {
            var2.addElement(var5);
         }
      }

      if (var2.size() > 0) {
         var4 = CRes.rnd(var2.size());
         ((Avatar)var2.elementAt(var4)).chat = new ChatPopup(50, var1, (byte)0);
      }

   }
}

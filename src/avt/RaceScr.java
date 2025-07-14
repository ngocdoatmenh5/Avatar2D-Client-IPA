package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
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
      this.A = 220 * AvMain.Y;
      this.B = 240 * AvMain.Y;
      this.E = 8 * AvMain.Y;
      this.F = this.J = 23 * AvMain.Y;
      this.G = 105 * AvMain.Y;
      this.H = this.L = 211 * AvMain.Y;
      this.K = 95 * AvMain.Y;
      this.I = this.A - this.K - 8 * AvMain.Y;
      this.O = 180 * AvMain.Y + 10 * AvMain.Y + 10 * AvMain.Y;
      this.P = 110 * AvMain.Y;
      this.M = (GameCanvas.m - this.O) / 2;
      this.N = (GameCanvas.n - this.P) / 2;
   }

   public final void a() {
      super.a();
   }

   public final void a(PetRace[] var1, short var2, boolean var3, boolean var4) {
      this.x = false;
      this.f = 1;
      this.X = -1;
      GameCanvas.v = null;
      GameCanvas.A = null;
      this.U = false;
      int var5;
      if (h == null) {
         try {
            this.Q = new FrameImage(Image.createImage(T1.a() + "/race/popup/tile1.png"), 20 * AvMain.Y, 20 * AvMain.Y);
            this.R = new FrameImage(Image.createImage(T1.a() + "/race/popup/bt1.png"), 31 * AvMain.Y, 31 * AvMain.Y);
            this.T = new FrameImage(Image.createImage(T1.a() + "/race/popup/bt0.png"), 60 * AvMain.Y, 24 * AvMain.Y);
            this.S = new FrameImage(Image.createImage(T1.a() + "/race/popup/time.png"), 14 * AvMain.Y, 14 * AvMain.Y);
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
               if ((var6 = (MyObject)LoadMap.m.elementAt(var5)).az == 10) {
                  LoadMap.a(var6);
               }
            }
         }

         if (a != GameCanvas.r) {
            LoadMap.a(LoadMap.m);
            b().a();
            LoadMap.t = -1;
            this.b(1);
            this.b(2);
            GameCanvas.x.e(108);
            LoadMap.c(GameMidlet.i);
            RaceScr var10 = b();
            AvCamera.a().b(LoadMap.a);
            var10.C = (GameCanvas.m - var10.A) / 2;
            var10.D = (GameCanvas.n - var10.B) / 2;
            var10.W = (byte)(35 * AvMain.Y);
            if (GameCanvas.a.getHeight() <= 240) {
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
               this.c[var5].aw = 20;
               this.c[var5].ax = 80 + var5 * 12;
               LoadMap.m.addElement(this.c[var5]);
            }

            AvCamera.a().h = this.c[2];
            this.g = 3;
         }

         GameMidlet.i.aw = GameMidlet.i.C = 0;
      }

      GameMidlet.i.ax = GameMidlet.i.D = 96 * AvMain.Y;
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
                  var10000.aw += this.c[var5].f[var8] * this.c[var5].e[var8];
                  ++this.c[var5].b;
                  if (var9 >= (var2 - 4) * 20) {
                     break;
                  }
               }
            }
         } else {
            GlobalService.gI().k(this.c[0].w);
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
         if ((var8 = AvatarData.b[var7]).f == -1 && var8.g < 2000 && var8.k > 0 && ((var9 = (APartInfo)var8).b == var1 || var9.b == 0)) {
            if (var9.j == 10) {
               var2.addElement(var9);
            } else if (var8.j == 20) {
               var3.addElement(var9);
            } else if (var8.j == 30) {
               var4.addElement(var9);
            } else if (var8.j == 40) {
               var5.addElement(var9);
            } else if (var8.j == 50) {
               var6.addElement(var9);
            }
         }
      }

      for(var7 = 0; var7 < 10; ++var7) {
         Avatar var10;
         (var10 = new Avatar()).d = (byte)var1;
         SeriPart var11;
         (var11 = new SeriPart()).a = ((Part)var2.elementAt(CRes.e(var2.size()))).g;
         var10.a(var11);
         (var11 = new SeriPart()).a = ((Part)var3.elementAt(CRes.e(var3.size()))).g;
         var10.a(var11);
         (var11 = new SeriPart()).a = ((Part)var4.elementAt(CRes.e(var4.size()))).g;
         var10.a(var11);
         (var11 = new SeriPart()).a = ((Part)var5.elementAt(CRes.e(var5.size()))).g;
         var10.a(var11);
         (var11 = new SeriPart()).a = ((Part)var6.elementAt(CRes.e(var6.size()))).g;
         var10.a(var11);
         var10.h();
         this.p.addElement(var10);
      }

   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            GlobalService var4;
            (var4 = GlobalService.gI()).e((byte)8);
            var4.k();
            GameCanvas.i();
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
               GameCanvas.a(T1.eP, (IAction)var3);
               return;
            }

            GameCanvas.a(T1.ee, (IAction)var3);
            return;
         case 3:
            AvCamera var10000 = AvCamera.a();
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
            GlobalService.gI().c(this.c[this.aA].w, this.aG[this.aB]);
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

      GameMidlet.i.a(AvCamera.a().a + GameCanvas.o, AvCamera.a().b + GameCanvas.n - 40 * AvMain.Y);
      if (System.currentTimeMillis() - this.y >= 1000L) {
         this.y = System.currentTimeMillis();
         --this.v;
         if (this.v < 0) {
            this.v = 0;
         } else {
            ++this.ay;
            if (this.w && !this.d && this.ay > 0) {
               this.ay = 0;
               if (this.aA >= 0 && this.c != null && this.aA < 6 && this.c[this.aA] != null && this.c[this.aA].w != this.X) {
                  this.X = this.c[this.aA].w;
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
            GameCanvas.A = this.l;
            int[] var10000 = GameMidlet.i.a;
            var10000[0] += this.l.f;
            GameCanvas.a(this.l.f, GameCanvas.o, GameCanvas.n - 30 * AvMain.Y, -1, -1);
            this.l = null;
         }
      }

      GameCanvas.x.b();
      if (this.d && this.e > 0) {
         --this.e;
      }

      if (this.z != null && this.z.a()) {
         this.z.d = null;
      }

      if (this.d || !this.w) {
         for(var1 = 0; var1 < LoadMap.m.size(); ++var1) {
            Base var4;
            if ((var4 = (Base)LoadMap.m.elementAt(var1)).az == 9) {
               Avatar var5 = (Avatar)var4;
               if (System.currentTimeMillis() / 1000L - (long)var5.n > (long)var5.an) {
                  var5.n = (int)(System.currentTimeMillis() / 1000L);
                  var5.an = (short)(CRes.e(10) + 6);
                  int var3;
                  if ((var3 = CRes.e(6)) == 1) {
                     var5.b((byte)0);
                  } else if (var3 == 3) {
                     var5.b((byte)0);
                     var5.g();
                  } else if (var3 == 2) {
                     var5.b((byte)7);
                  } else {
                     var5.b((byte)2);
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
      if (GameCanvas.D == null || !Welcome.d) {
         super.l();
      }

      if (GameCanvas.a(2)) {
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
      } else if (GameCanvas.a(8)) {
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
      } else if (GameCanvas.a(4)) {
         if (this.U && this.aB % 3 > 0) {
            --this.aB;
         }
      } else if (GameCanvas.a(6) && this.U && this.aB % 3 < 2) {
         ++this.aB;
      }

      if (GameCanvas.g && this.c != null && !this.d && this.w) {
         int var1;
         if (this.U) {
            if (GameCanvas.b(this.M + this.O - 30 * AvMain.Y, this.N, 30 * AvMain.Y, 30 * AvMain.Y)) {
               GameCanvas.g = false;
               this.V = 5;
               this.aD = true;
               this.aF = this.aE;
            } else {
               for(var1 = 0; var1 < 9; ++var1) {
                  if (GameCanvas.b(this.M + 5 * AvMain.Y + var1 % 3 * (5 * AvMain.Y + this.T.a), this.N + (this.P - 29 * AvMain.Y * 3) + var1 / 3 * 29 * AvMain.Y - 1 * AvMain.Y, 60 * AvMain.Y, 26 * AvMain.Y)) {
                     this.aB = var1;
                     GameCanvas.g = false;
                     this.aD = true;
                     this.aF = this.aE;
                     break;
                  }
               }
            }
         } else {
            for(var1 = 0; var1 < 6; ++var1) {
               if (GameCanvas.b(this.C + this.I + 32 * AvMain.Y / 2 - 15 * AvMain.Y, this.D + this.J + 3 * AvMain.Y + 35 * AvMain.Y * var1 + 31 * AvMain.Y / 2 - 15 * AvMain.Y, 31 * AvMain.Y, 31 * AvMain.Y)) {
                  this.az = var1;
                  this.aD = true;
                  GameCanvas.g = false;
                  this.aF = this.aE;
                  break;
               }

               if (GameCanvas.b(this.C + this.I + this.K - 1 * AvMain.Y - this.T.a, this.D + this.J + 3 * AvMain.Y + 35 * AvMain.Y * var1 + 31 * AvMain.Y / 2 - 15 * AvMain.Y, 60 * AvMain.Y, 31 * AvMain.Y)) {
                  this.aA = var1;
                  this.aD = true;
                  GameCanvas.g = false;
                  this.aF = this.aE;
                  break;
               }
            }
         }
      }

      if (this.aD) {
         if (GameCanvas.e) {
            if (this.aB != -1) {
               if (!GameCanvas.b(this.M + 5 * AvMain.Y + this.aB % 3 * (5 * AvMain.Y + this.T.a), this.N + (this.P - 29 * AvMain.Y * 3) + this.aB / 3 * 29 * AvMain.Y - 1 * AvMain.Y, 60 * AvMain.Y, 26 * AvMain.Y)) {
                  this.aB = -1;
               }
            } else if (this.V != 0) {
               if (!GameCanvas.b(this.M + this.O - 30 * AvMain.Y, this.N, 30 * AvMain.Y, 30 * AvMain.Y)) {
                  this.V = 0;
               }
            } else if (this.az != -1) {
               if (!GameCanvas.b(this.C + this.I + 32 * AvMain.Y / 2 - 15 * AvMain.Y, this.D + this.J + 3 * AvMain.Y + 35 * AvMain.Y * this.az + 31 * AvMain.Y / 2 - 15 * AvMain.Y, 31 * AvMain.Y, 31 * AvMain.Y)) {
                  this.az = -1;
               }
            } else if (this.aA != -1 && !this.U && !GameCanvas.b(this.C + this.I + this.K - 1 * AvMain.Y - this.T.a, this.D + this.J + 3 * AvMain.Y + 35 * AvMain.Y * this.aA + 31 * AvMain.Y / 2 - 15 * AvMain.Y, 60 * AvMain.Y, 31 * AvMain.Y)) {
               this.aA = -1;
            }
         }

         if (GameCanvas.f) {
            if (this.aE - this.aF <= 4L) {
               this.aC = 5;
            } else {
               this.e();
            }

            this.aD = false;
            GameCanvas.f = false;
         }
      }

      if (this.d || !this.w) {
         GameCanvas.x.a();
      }

   }

   private void e() {
      if (this.aB != -1) {
         GlobalService.gI().c(this.c[this.aA].w, this.aG[this.aB]);
         this.aB = -1;
         this.aA = -1;
         this.U = false;
         this.a(8);
      } else if (this.V > 0) {
         this.V = 0;
         this.U = false;
         this.aA = -1;
      } else if (this.az != -1) {
         GlobalService.gI().k(this.c[this.az].w);
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
      GameCanvas.c(var1);
      if (this.w) {
         GameCanvas.S.a(var1, this.C, this.D, this.A, this.B, PaintPopup.d[2], PaintPopup.d[3], 1);
         var1.translate(this.C, this.D);
         GameCanvas.K.a(var1, T1.ec, this.A / 2, 6 * AvMain.Y, 2);
         a(var1, this.E, this.F, this.G, this.H, this.Q, -1);
         a(var1, this.I, this.J, this.K, this.L, MenuNPC.a, -12335933);

         for(int var2 = 0; var2 < 6; ++var2) {
            this.R.a(this.az == var2 ? 1 : 0, this.I + 32 * AvMain.Y / 2, this.J + 3 * AvMain.Y + this.W * var2 + 31 * AvMain.Y / 2, 0, 3, var1);
            AvatarData.a(var1, this.c[var2].d, this.I + 32 * AvMain.Y / 2, this.J + 3 * AvMain.Y + this.W * var2 + 31 * AvMain.Y / 2, 3);
            GameCanvas.M.a(var1, "x" + this.c[var2].a, this.I + 32 * AvMain.Y / 2 + this.R.a / 2 - 5 * AvMain.Y, this.J + 3 * AvMain.Y + this.W * var2 + 31 * AvMain.Y / 2 + this.R.b / 2 - AvMain.af, 2);
            this.T.a(this.aA == var2 ? 1 : 0, this.I + this.K - 1 * AvMain.Y - this.T.a, this.J + 7 * AvMain.Y + this.W * var2, 0, var1);
            if (this.c[var2].g > 0) {
               GameCanvas.K.a(var1, "" + this.c[var2].g, this.I + this.K - 1 * AvMain.Y - this.T.a / 2, this.J + 7 * AvMain.Y + this.W * var2 + this.T.b / 2 - AvMain.ah / 2 - AvMain.Y - 1, 2);
            } else {
               GameCanvas.K.a(var1, T1.ec, this.I + this.K - 1 * AvMain.Y - this.T.a / 2, this.J + 7 * AvMain.Y + this.W * var2 + this.T.b / 2 - AvMain.ah / 2 - AvMain.Y - 1, 2);
            }
         }

         if (this.aH && this.c != null) {
            GameCanvas.K.a(var1, this.aK, this.E + this.G / 2, this.F + 6 * AvMain.Y, 2);
            AvatarData.a(var1, this.aI, this.E + this.G / 2, this.F + 40 * AvMain.Y, 3);
            int var4 = this.F + 70 * AvMain.Y;
            GameCanvas.K.a(var1, T1.aP, this.E + 5 * AvMain.Y, var4, 0);
            GameCanvas.N.a(var1, this.aJ + "%", this.E + this.G - 8 * AvMain.Y, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            GameCanvas.K.a(var1, T1.eg, this.E + 5 * AvMain.Y, var4, 0);
            GameCanvas.N.a(var1, "X" + this.aL, this.E + this.G - 8 * AvMain.Y, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            GameCanvas.K.a(var1, T1.eh, this.E + 5 * AvMain.Y, var4, 0);
            GameCanvas.N.a(var1, T1.eD[this.aM], this.E + this.G - 8 * AvMain.Y, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            var4 += AvMain.ah;
            GameCanvas.K.a(var1, T1.eQ, this.E + 5 * AvMain.Y, var4, 0);
            GameCanvas.N.a(var1, T1.eD[this.aN], this.E + this.G - 8 * AvMain.Y, var4 + AvMain.ah / 2 - AvMain.af / 2, 1);
            this.S.a(0, this.E + this.S.a / 2 + 8 * AvMain.Y, this.F + this.H - AvMain.ag - this.S.b - 8 * AvMain.Y, 0, 3, var1);
            GameCanvas.K.a(var1, String.valueOf(this.v), this.E + 8 * AvMain.Y + this.S.a + 2 * AvMain.Y, this.F + this.H - AvMain.ag - this.S.b - 8 * AvMain.Y - GameCanvas.K.a() / 2, 0);
            this.S.a(1, this.E + this.S.a / 2 + 8 * AvMain.Y, this.F + this.H - AvMain.ag - AvMain.Y, 0, 3, var1);
            GameCanvas.K.a(var1, String.valueOf(GameMidlet.i.a[0]), this.E + 8 * AvMain.Y + this.S.a + 2 * AvMain.Y, this.F + this.H - AvMain.ag - AvMain.Y - AvMain.ah / 2, 0);
         }

         if (this.U) {
            this.c(var1);
         }
      } else {
         ImageIcon var5;
         if (this.d && this.e > 0 && (var5 = AvatarData.c((short)1065)).d != -1) {
            int var3 = var5.c / 4;
            var1.drawRegion(var5.a, 0, (3 - this.e / 12) * var3, var5.b, var3, 0, GameCanvas.m / 2, GameCanvas.n / 2, 3);
         }
      }

      GameCanvas.c(var1);
      if (this.z != null && this.z.d != null) {
         this.z.a(var1);
      }

      if (GameCanvas.D == null || !Welcome.d) {
         super.a(var1);
      }

      if ((this.d || !this.w) && GameCanvas.v == null && this.x) {
         GameCanvas.L.a(var1, String.valueOf(this.n), GameCanvas.o, 5, 2);
      }

      GameCanvas.a(var1);
   }

   private void c(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.S.a(var1, this.M, this.N, this.O, this.P, PaintPopup.d[2], PaintPopup.d[3], 1);
      var1.translate(this.M, this.N);
      GameCanvas.K.a(var1, T1.ef, this.O / 2, 10 * AvMain.Y, 2);

      for(int var2 = 0; var2 < 9; ++var2) {
         this.T.a(this.aB == var2 ? 1 : 0, 5 * AvMain.Y + var2 % 3 * (5 * AvMain.Y + this.T.a), this.P - 29 * AvMain.Y * 3 + var2 / 3 * 29 * AvMain.Y, 0, var1);
         GameCanvas.Q.a(var1, String.valueOf(this.aG[var2]), 5 * AvMain.Y + var2 % 3 * (5 * AvMain.Y + this.T.a) + this.T.a / 2, this.P - 29 * AvMain.Y * 3 + var2 / 3 * 29 * AvMain.Y + this.T.b / 2 - AvMain.ai / 2, 2);
      }

   }

   public final void b(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.x.b(var1);

      for(int var2 = 0; var2 < 6; ++var2) {
         if (AvCamera.a().a <= 4 * LoadMap.i * AvMain.Y) {
            LoadMap.c.b(0, var2 % 2 == 0 ? 2 : 3, 3 * LoadMap.i * AvMain.Y, (var2 + 6) * LoadMap.i * AvMain.Y, 0, var1);
         }

         if (AvCamera.a().a + GameCanvas.m >= (LoadMap.e - 3) * LoadMap.i * AvMain.Y) {
            LoadMap.c.b(0, var2 % 2 == 0 ? 2 : 3, (LoadMap.e - 3) * LoadMap.i * AvMain.Y, (var2 + 6) * LoadMap.i * AvMain.Y, 0, var1);
         }
      }

      GameCanvas.x.d(var1);
      GameCanvas.c(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.equals("")) {
         this.z = new ChatPopup(50, var1, (byte)0);
         this.z.a = GameCanvas.o;
         this.z.b = GameCanvas.n - this.z.c - MyScreen.at - class_im.d().b.d;
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
      int var3 = AvCamera.a().c;
      if (this.d || !this.w) {
         var3 += GameCanvas.m / 3;
      }

      int var4;
      for(var4 = 0; var4 < LoadMap.m.size(); ++var4) {
         Base var5;
         if ((var5 = (Base)LoadMap.m.elementAt(var4)).az == 9 && var5.aw * AvMain.Y > var3 && var5.aw * AvMain.Y < var3 + GameCanvas.m) {
            var2.addElement(var5);
         }
      }

      if (var2.size() > 0) {
         var4 = CRes.e(var2.size());
         ((Avatar)var2.elementAt(var4)).O = new ChatPopup(50, var1, (byte)0);
      }

   }
}

package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class BCBoardScr extends BoardScr {
   public static BCBoardScr a;
   private Vector K = new Vector();
   private Vector L = new Vector();
   private Vector M = new Vector();
   private Vector N = new Vector();
   private Vector O = new Vector();
   private Command P;
   private Command Q;
   private int R;
   private int S;
   private byte T = -1;
   private byte U = -1;
   private byte V;
   private byte W;
   private byte X;
   private byte ay;
   private byte az;
   public static int b;
   public static int c;
   private boolean[] aA = new boolean[6];
   public byte[][] d = new byte[5][6];
   private byte[] aB = new byte[3];
   public byte e;
   private byte aC = 0;
   private byte aD;
   private boolean aE;
   private boolean aF;
   private boolean aG;
   private boolean aH;
   public boolean f;
   private int[] aI;
   private Image aJ;
   public static int g;
   public static int h;
   private static AvPosition[] aK;
   private Vector aL = new Vector();
   private Command aM;

   public static BoardScr b() {
      return a == null ? (a = new BCBoardScr()) : a;
   }

   public final void a() {
      this.init();
      super.a();
   }

   private void t() {
      int var1;
      for(var1 = 0; var1 < this.aB.length; ++var1) {
         this.aB[var1] = -1;
      }

      for(var1 = 0; var1 < this.aA.length; ++var1) {
         this.aA[var1] = false;
      }

      for(var1 = 0; var1 < this.d.length; ++var1) {
         for(int var2 = 0; var2 < this.d[var1].length; ++var2) {
            this.d[var1][var2] = 0;
         }
      }

   }

   public BCBoardScr() {
      try {
         this.aJ = Image.createImage(avt.T.a() + "/on/p.on");
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      this.t();
      this.aI = null;
      this.P = new Command(avt.T.B, 7);
      this.Q = new Command(avt.T.w, 8);
      this.aM = new Command(avt.T.B, 9);
      if (Canvas.w > 200) {
         c = 23;
         b = 23;
         h = 48;
         g = 48;
         if (AvMain.hd == 2) {
            h = 96;
            g = 96;
         }
      } else {
         c = 12;
         b = 12;
         h = 32;
         g = 32;
      }

      this.v();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 7:
            this.y();
            break;
         case 8:
            this.g();
            this.aL.removeAllElements();
            BoardScr.l = false;
            BoardScr.j = false;
            BoardScr.k = false;
            super.n = -1;
            this.aI = null;
            this.K.removeAllElements();
            this.L.removeAllElements();
            this.T = -1;
            this.U = -1;
            break;
         case 9:
            if (!this.aE) {
               if (!this.aA[BoardScr.i(GameMidlet.avatar.IDDB)]) {
                  this.aD = 1;
                  this.C();
               }
            } else if (this.T != -1) {
               this.T = -1;
               super.center.a = "Chọn";
               super.right = this.P;
            }
      }

      super.a(var1, var2);
   }

   public final void init() {
      super.init();
      if (Canvas.w > 150) {
         aK = new AvPosition[]{new AvPosition(20 * AvMain.hd, 50 + 30 * AvMain.hd, 6), new AvPosition(20 * AvMain.hd, Canvas.hh + 60, 6), new AvPosition(Canvas.hw, Canvas.q - Canvas.hTab - 10, 33), new AvPosition(Canvas.w - 14 * AvMain.hd, Canvas.hh + 60, 10), new AvPosition(Canvas.w - 14 * AvMain.hd, 50 + 30 * AvMain.hd, 10)};
      } else {
         aK = new AvPosition[]{new AvPosition(20, 13, 6), new AvPosition(20, Canvas.hh - 5, 6), new AvPosition(Canvas.hw, Canvas.q - Canvas.hTab - 10, 33), new AvPosition(Canvas.w - 14, Canvas.hh - 5, 10), new AvPosition(Canvas.w - 14, 13, 10)};
      }
   }

   public final void a(byte var1, byte var2, int var3) {
      int var4 = var3;
      byte var7 = (byte)var2;
      if (var4 != 0) {
         Avatar var6 = (Avatar)BoardScr.m.elementAt(var1);
         Avatar var8 = (Avatar)BoardScr.m.elementAt(var7);
         Point var5;
         (var5 = new Point(var6.x, var6.y)).o = (short)var4;
         var5.f = CRes.rnd(3);
         var2 = (byte) CRes.a(var8.x - var6.x, -(var8.x - var6.y));
         var5.b = var2;
         var5.catagory = (byte)CRes.rnd(-1, 1);
         var5.e = CRes.c(var5.b + var5.catagory * 90);
         var2 = (byte) (10 * CRes.b(var5.e) >> 10);
         var4 = -(10 * CRes.a(var5.e)) >> 10;
         var5.n = (short)var8.x;
         var5.m = (short)var8.y;
         var5.x += var2;
         var5.y += var4;
         var5.f = 0;
         var5.i = (byte)(CRes.rnd(4) + 2);
         var5.height = (short)(8 + CRes.rnd(5));
         this.aL.addElement(var5);
      }

   }

   private void u() {
      this.T = -1;
      this.U = -1;
      this.W = 0;
      this.X = 0;
      this.ay = 0;
      this.aE = false;
      this.aF = false;
      this.aG = false;
      this.aC = 0;
      this.f = false;
      this.K.removeAllElements();
      this.L.removeAllElements();
      this.N.removeAllElements();
      this.az = 0;
      this.aH = false;
      BoardScr.j = false;
      super.n = -1;
      this.aD = 0;
      BoardScr.k = false;
      this.t();

      for(int var1 = 0; var1 < this.O.size(); ++var1) {
         ((class_kl)this.O.elementAt(var1)).b = 0;
      }

   }

   private void v() {
      this.O.removeAllElements();
      this.R = Canvas.w / 2 - g - g / 2 - 10;
      this.S = Canvas.h / 2 - h - 12;

      for(int var1 = 0; var1 < 6; ++var1) {
         class_kl var2;
         (var2 = new class_kl()).a = var1;
         var2.c = this.R + var1 % 3 * (g + 10);
         var2.d = this.S + var1 / 3 * (h + 8);
         this.O.addElement(var2);
      }

   }

   private void w() {
      if (this.N.size() <= 0) {
         int var1;
         int var2;
         if (Canvas.w > 200) {
            var1 = Canvas.w / 2 - 64 * AvMain.hd;

            for(var2 = 0; var2 < 3; ++var2) {
               this.a(var1 + (var2 << 6) * AvMain.hd, 10, var2, var2, false);
            }

            return;
         }

         var1 = Canvas.w / 2 - 49;

         for(var2 = 0; var2 < 3; ++var2) {
            this.a(var1 + var2 * 49, 0, var2, var2, false);
         }
      }

   }

   private void x() {
      if (!this.aF) {
         BoardScr.o();
         this.f = true;
         CasinoService.a().a(this.T, this.U);
         BoardScr.k = true;
         super.n = -1;
      }

   }

   private void y() {
      BoardScr.o();
      BoardScr.k = true;
      CasinoService.a().j();
   }

   private void A() {
      ++((class_kl)this.O.elementAt(this.V)).b;
      BCBoardScr var1 = this;

      for(int var2 = 0; var2 < 6; ++var2) {
         class_kl var3 = (class_kl)var1.O.elementAt(var2);
         int var4 = a(var1.M, BoardScr.i(GameMidlet.avatar.IDDB));
         int var10001 = var3.c + g / 2;
         int var10002 = var3.d + h / 2;
         int var10003 = var3.b;
         int var7 = b(var4);
         int var6 = var10003;
         int var5 = var10002;
         var4 = var10001;
         MoneyPut var8 = new MoneyPut(var4, var5, var6, var7);
         var1.K.addElement(var8);
      }

   }

   private void B() {
      for(int var1 = 0; var1 < 6; ++var1) {
         class_kl var2 = (class_kl)this.O.elementAt(var1);
         int var3 = a(this.M, this.ay);
         this.a(var2.c, var2.d, var2.c, var2.d, this.d[this.ay][var1], b(var3), var1, var1, false);
      }

   }

   private void e(Graphics var1) {
      if (this.N.size() > 0) {
         for(int var2 = 0; var2 < this.N.size(); ++var2) {
            ((Xingau)this.N.elementAt(var2)).a(var1);
         }
      }

   }

   private static int b(int var0) {
      switch (var0) {
         case 0:
            return 3;
         case 1:
            return 0;
         case 2:
            return 1;
         case 3:
            return 2;
         default:
            return -1;
      }
   }

   private void a(int var1, int var2, int var3, int var4, boolean var5) {
      Xingau var6 = new Xingau(var1, var2, var3, var4, false);
      this.N.addElement(var6);
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      class_ky var10 = new class_ky(var1, var2, var3, var4, var5, var6, var7, var8, false);
      this.L.addElement(var10);
   }

   public final void a(byte var1) {
      int var2 = BoardScr.i(GameMidlet.avatar.IDDB);
      Avatar var3 = (Avatar)BoardScr.m.elementAt(var1);
      if (var2 == var1) {
         this.aA[var2] = false;
         this.aE = true;
         super.right = null;
         this.aD = 2;
         this.f = false;
      }

      super.n = var3.IDDB;
      BoardScr.v = this.e;
      BoardScr.u = (long) Canvas.getSecond();
      if (!this.aG) {
         this.aG = true;
      }

      if (GameMidlet.avatar.IDDB != BoardScr.r && var2 == var1) {
         super.center = BoardScr.D;
         super.center.a = "Chọn";
         super.right = this.P;
      }

   }

   public final void paint(Graphics var1) {
      this.b(var1);
      Canvas.resetTrans(var1);
      Graphics var3 = var1;
      BCBoardScr var2 = this;

      for(int var4 = 0; var4 < var2.aL.size(); ++var4) {
         Point var5;
         if ((var5 = (Point)var2.aL.elementAt(var4)).i >= 0) {
            Canvas.O.a(var3, "+" + var5.o, var5.x, var5.y, 2);
         }
      }

      super.paint(var1);
   }

   public final void b(Graphics var1) {
      super.b(var1);
      BCBoardScr var3;
      Graphics var4;
      int var5;
      int var10003;
      if (BoardScr.j || BoardScr.k) {
         Canvas.resetTrans(var1);
         var4 = var1;
         var3 = this;
         if (this.O.size() > 0) {
            if (this.T != -1) {
               var1.setColor(16777215);
               if (Canvas.gameTick % 20 > 10) {
                  var1.fillRect(this.R + this.T % 3 * (g + 10), this.S + this.T / 3 * (h + 8), g, h);
               }
            }

            if (this.U != -1) {
               var1.setColor(1112500);
               if (Canvas.gameTick % 20 > 10) {
                  var1.fillRect(this.R + this.U % 3 * (g + 10), this.S + this.U / 3 * (h + 8), g, h);
               }
            }

            for(var5 = 0; var5 < var3.O.size(); ++var5) {
               class_kl var6 = (class_kl)var3.O.elementAt(var5);
               if (AvatarData.getImgIcon((short)(Canvas.w > 200 ? 872 : 873)).count != -1) {
                  var10003 = var6.a * h;
                  int var10007 = var3.R + var5 % 3 * (g + 10);
                  int var10008 = var3.S + var5 / 3 * (h + 8);
                  var4.drawRegion(AvatarData.getImgIcon((short)(Canvas.w > 200 ? 872 : 873)).img, 0, var10003, g, h, 0, var10007, var10008, 0);
               }
            }
         }
      }

      this.a_(var1);
      if (BoardScr.j || BoardScr.k) {
         Canvas.resetTrans(var1);
         var4 = var1;
         var3 = this;

         int var7;
         for(var5 = 0; var5 < BoardScr.m.size(); ++var5) {
            Avatar var10;
            if ((var10 = (Avatar)BoardScr.m.elementAt(var5)).IDDB == BoardScr.r || var10.IDDB != -1) {
               if (var3.n != var10.IDDB || Canvas.gameTick % 10 >= 5) {
                  Canvas.smallFontYellow.a(var4, var10.getMoneyNew() + avt.T.k(), var10.x, var10.y + 5, 2);
               }

               if ((var7 = a(var3.M, BoardScr.i(var10.IDDB))) != -1 && AvatarData.getImgIcon((short)871).count != -1) {
                  var4.drawRegion(AvatarData.getImgIcon((short)871).img, 0, b(var7) * 12, 12, 12, 0, var10.x, var10.y + 5 + AvMain.ai, 17);
               }
            }
         }

         int var2;
         if (BoardScr.j || BoardScr.k) {
            if ((var2 = (int)((long)BoardScr.v - BoardScr.t)) > 0 && !BoardScr.l && this.N.size() <= 0) {
               Canvas.O.a(var1, String.valueOf(var2), Canvas.hw, 10, 2);
            }

            if (this.aG) {
               if (this.aC < 100) {
                  ++this.aC;
               } else {
                  this.aC = 100;
               }

               if (this.aC < 50) {
                  Canvas.L.a(var1, "Bắt đầu tả", Canvas.hw, this.S - 40, 2);
               }
            }
         }

         if (this.K.size() > 0) {
            for(var2 = 0; var2 < this.K.size(); ++var2) {
               MoneyPut var8;
               if ((var8 = (MoneyPut)this.K.elementAt(var2)).a > 0) {
                  var8.a(var1);
               }
            }
         }

         if (this.L.size() > 0) {
            for(var2 = 0; var2 < this.L.size(); ++var2) {
               class_ky var9;
               if ((var9 = (class_ky)this.L.elementAt(var2)).c > 0 && !(var9 = var9).h) {
                  FontX var11 = Canvas.O;
                  if (Canvas.w <= 200) {
                     var11 = Canvas.smallFontYellow;
                  }

                  if (Canvas.stypeInt > 0) {
                     var11 = Canvas.K;
                  }

                  int var12 = var9.a + g / 4 + var9.d % 2 * g / 2;
                  var7 = var9.b + h / 4 + var9.d / 2 * h / 2;
                  if (AvatarData.getImgIcon((short)(Canvas.w > 200 ? 870 : 871)).count != -1) {
                     var10003 = var9.d * c;
                     var1.drawRegion(AvatarData.getImgIcon((short)(Canvas.w > 200 ? 870 : 871)).img, 0, var10003, b, c, 0, var12, var7, 3);
                  }

                  var11.a(var1, String.valueOf(var9.c), var12, var7 - var11.a() / 2, 2);
               }
            }
         }

         if (GameMidlet.avatar.IDDB != BoardScr.r && BoardScr.j && this.N.size() == 0) {
            var1.drawImage(this.aJ, this.R + g / 2 + this.V % 3 * (g + 10), this.S + h / 2 + this.V / 3 * (h + 8) + Canvas.gameTick % 4 + 5, 3);
         }

         this.e(var1);
      }

   }

   private void C() {
      BoardScr.o();
      this.f = true;
      CasinoService.a().a(this.O);
      this.K.removeAllElements();
   }

   public final void updateKey() {
      super.updateKey();
      if (!this.aA[BoardScr.i(GameMidlet.avatar.IDDB)] && GameMidlet.avatar.IDDB != BoardScr.r) {
         BCBoardScr var2 = this;
         if (!this.f && BoardScr.j && !BoardScr.l && this.O.size() > 0 && Canvas.isPointerClick) {
            Canvas.isPointerClick = false;

            for(int var3 = 0; var3 < var2.O.size(); ++var3) {
               class_kl var4 = (class_kl)var2.O.elementAt(var3);
               if (Canvas.px >= var4.c && Canvas.px <= var4.c + g && Canvas.py >= var4.d && Canvas.py <= var4.d + h) {
                  var2.V = (byte)var3;
                  if (!var2.aE) {
                     if (!var2.aA[BoardScr.i(GameMidlet.avatar.IDDB)]) {
                        if (var2.az < 6) {
                           var2.A();
                        }

                        ++var2.az;
                     }
                  } else if (var2.U == -1) {
                     if (var2.T == -1) {
                        var2.T = var2.V;
                        var2.center.a = "Tả";
                        var2.D();
                     } else {
                        var2.U = var2.V;
                        var2.x();
                     }
                  }
                  break;
               }
            }
         }

         if (Canvas.a(6)) {
            ++this.V;
            if (this.V > 5) {
               this.V = 0;
            }

            return;
         }

         if (Canvas.a(4)) {
            --this.V;
            if (this.V < 0) {
               this.V = 5;
            }

            return;
         }

         if (Canvas.a(8)) {
            if (this.V / 3 <= 0) {
               this.V = (byte)(this.V + 3);
               return;
            }
         } else if (Canvas.a(2) && this.V > 2) {
            this.V = (byte)(this.V - 3);
         }
      }

   }

   protected final void h() {
      super.h();
      if (!BoardScr.j && !BoardScr.k) {
         this.u();
      }

   }

   public final void k() {
      super.k();
      if (!BoardScr.j && !BoardScr.k) {
         this.q();
      } else {
         BoardScr.t = (long)((int)(System.currentTimeMillis() / 1000L - BoardScr.u));
         if (BoardScr.j && !BoardScr.l && !BoardScr.k && (long)BoardScr.v - BoardScr.t < 0L) {
            this.f = true;
            if (GameMidlet.avatar.IDDB != BoardScr.r) {
               if (this.aD == 0) {
                  this.aD = 1;
                  this.C();
               }

               if (this.aD == 2) {
                  this.aD = 3;
                  this.y();
               }
            }
         }

         BCBoardScr var1 = this;
         int var11;
         if (this.L.size() > 0 && this.O.size() > 0) {
            class_ky var4;
            for(int var2 = 0; var2 < var1.L.size(); ++var2) {
               class_ky var3;
               if ((var4 = var3 = (class_ky)var1.L.elementAt(var2)).a != var4.f) {
                  if (var4.f - var4.a >> 1 == 0) {
                     var4.a = var4.f;
                  } else {
                     var4.a += var4.f - var4.a >> 1;
                  }
               }

               if (var4.b != var4.g) {
                  if (var4.g - var4.b >> 1 == 0) {
                     var4.b = var4.g;
                  } else {
                     var4.b += var4.g - var4.b >> 1;
                  }
               }

               if (var4.i && var4.a == var4.f && var4.b == var4.g) {
                  var4.h = true;
               }

               if (var3.h) {
                  var1.L.removeElement(var3);
                  if (var1.aF) {
                     class_kl var10 = (class_kl)var1.O.elementAt(var1.X);
                     int var5 = a(var1.M, var1.ay);
                     var1.a(var10.c, var10.d, var10.c, var10.d, var1.d[var1.ay][var1.X], b(var5), var1.X, var1.X, false);
                     var1.aF = false;
                  }
               }
            }

            class_kl var7 = (class_kl)var1.O.elementAt(var1.X);
            if (var1.aF) {
               for(var11 = 0; var11 < var1.L.size(); ++var11) {
                  if ((var4 = (class_ky)var1.L.elementAt(var11)).e == var1.W) {
                     var4.f = var7.c;
                     var4.g = var7.d;
                     var4.i = true;
                  }
               }
            }
         }

         int var6;
         if (this.N.size() > 0) {
            for(var6 = 0; var6 < this.N.size(); ++var6) {
               Xingau var8;
               (var8 = (Xingau)this.N.elementAt(var6)).a();
               if (this.aH) {
                  var8.a = this.aB[var6];
                  var8.b = true;
               }
            }
         }

         for(var6 = 0; var6 < this.aL.size(); ++var6) {
            Point var9;
            if (CRes.f((var11 = CRes.a((var9 = (Point)this.aL.elementAt(var6)).n - var9.x, -(var9.m - var9.y))) - var9.e) > 10) {
               var9.e -= var9.height * var9.catagory;
               var9.e = CRes.c(var9.e);
            } else {
               var9.e = var11;
               var9.i = (byte)(var9.i + 2);
            }

            if (var9.f >= 4) {
               var9.f = 0;
            }

            ++var9.f;
            var11 = var9.i * CRes.b(var9.e) >> 10;
            int var12 = -(var9.i * CRes.a(var9.e)) >> 10;
            if (CRes.a(var9.x, var9.y, var9.n, var9.m) >= var9.i) {
               var9.x += var11;
               var9.y += var12;
            } else {
               this.aL.removeElement(var9);
            }
         }

      }
   }

   public final void a(int[] var1) {
      this.aI = var1;
      this.aH = true;
      BoardScr.l = true;
      super.right = null;
      this.aG = false;
      this.aC = 0;
      super.center = this.Q;
      BCBoardScr var4 = this;

      for(byte var2 = 0; var2 < 5; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar)BoardScr.m.elementAt(var2)).IDDB != -1) {
            BoardScr.a(var3.IDDB, String.valueOf(var4.aI[var2]));
            var3.setMoneyNew(var3.getMoneyNew() + var4.aI[var2]);
         }
      }

   }

   public final void i() {
      BoardScr.j = false;
      BoardScr.k = true;
      this.M.removeAllElements();
      this.f();

      for(int var1 = 0; var1 < BoardScr.m.size(); ++var1) {
         if (((Avatar)BoardScr.m.elementAt(var1)).IDDB != BoardScr.r) {
            this.M.addElement(String.valueOf(var1));
         }
      }

      this.B();
      super.center = BoardScr.E;
   }

   public final void j() {
      if (!this.aE) {
         if (!this.aA[BoardScr.i(GameMidlet.avatar.IDDB)]) {
            if (this.az < 6) {
               this.A();
            }

            ++this.az;
            return;
         }
      } else if (this.U == -1) {
         if (this.T == -1) {
            this.T = this.V;
            super.center.a = "Tả";
            this.D();
            return;
         }

         this.U = this.V;
         this.x();
      }

   }

   public final void m() {
      super.center = BoardScr.D;
      super.right = this.aM;
      super.center.a = "Đặt";
      super.right.a = "Xong";
   }

   private void D() {
      super.right = this.aM;
      super.right.a = "Chọn lại";
   }

   private static int a(Vector var0, int var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         if (((String)var0.elementAt(var2)).equals(String.valueOf(var1))) {
            return var2;
         }
      }

      return -1;
   }

   public final void n() {
      super.n();
      this.M.removeAllElements();

      for(int var1 = 0; var1 < BoardScr.m.size(); ++var1) {
         if (((Avatar)BoardScr.m.elementAt(var1)).IDDB != BoardScr.r) {
            this.M.addElement(String.valueOf(var1));
         }
      }

   }

   public final void b(byte var1) {
      super.s();
      Canvas.endDlg();
      this.u();
      BoardScr.r();
      this.M.removeAllElements();
      this.f();

      for(int var2 = 0; var2 < BoardScr.m.size(); ++var2) {
         if (((Avatar)BoardScr.m.elementAt(var2)).IDDB != BoardScr.r) {
            this.M.addElement(String.valueOf(var2));
         }
      }

      if (GameMidlet.avatar.IDDB != BoardScr.r) {
         this.m();
      } else {
         super.center = null;
         super.right = null;
      }

      BoardScr.l = false;
      BoardScr.j = true;
      BoardScr.v = var1;
      BoardScr.u = (long) Canvas.getSecond();
   }

   public final void c(byte var1) {
      this.ay = var1;
      this.aA[this.ay] = true;
      this.B();
   }

   public final void a(byte var1, byte var2, byte var3) {
      if (var2 != var3) {
         this.ay = var1;
         this.W = var2;
         this.X = var3;
         this.aF = true;
         this.aD = 3;
      }

   }

   public final void a(byte[] var1) {
      this.aB = var1;
      Vector var4 = new Vector();

      for(int var2 = 0; var2 < 6; ++var2) {
         class_kl var3 = new class_kl();
         if (var2 == this.aB[0]) {
            var3.b = 6;
         }

         var4.addElement(var3);
      }

      CasinoService.a().a(var4);
      this.w();
   }

   public final void f() {
      for(int var1 = 0; var1 < BoardScr.H; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar)BoardScr.m.elementAt(var1)).IDDB != -1) {
            var2.ySat = 0;
            var2.setAction((byte)0);
            var2.setFrame(var2.action);
            var2.setPos(aK[BoardScr.x[var1]].x, aK[BoardScr.x[var1]].y);
            if (BoardScr.x[var1] != 2 && BoardScr.x[var1] != 3 && BoardScr.x[var1] != 4) {
               var2.direct = var2.dirLast = 0;
            } else {
               var2.direct = var2.dirLast = Base.LEFT;
            }
         }
      }

   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class class_ez extends MyScreen {
   public static class_ez a;
   public int b;
   private Image c;
   private boolean d = false;
   private static int e;
   private static int f;
   private static int g;
   private static int h;
   private static int i;
   private static int j;
   private static int k;
   private static int l;
   private int m = 0;
   private long n;
   private int o;
   private boolean p;
   private int q;
   private long r;
   private long s;
   private int t;

   public static class_ez b() {
      return a == null ? (a = new class_ez()) : a;
   }

   public final void switchToMe() {
      super.switchToMe();
      this.e();
      this.m = 0;
      if (super.center == null) {
         this.doLeftMenu();
      }

      this.g();
   }

   public class_ez() {
      FilePack.b(T.av);
      this.c = FilePack.getImage("tp");
      FilePack.reset();
      this.doLeftMenu();
      CRes.b();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            if (this.d && super.ar > 0) {
               Canvas.startWaitCancelDlg(T.N);
               LoginScr.gI().r = System.currentTimeMillis();
               LoginScr.gI().i();
               return;
            } else {
               if (!this.d) {
                  this.d = true;
                  this.e();
                  super.ar = 1 + CRes.rnd(GameMidlet.a[OptionScr.gI().b[4]][this.b].length - 1);
                  this.g();
                  return;
               }

               this.d = false;
               return;
            }
         case 1:
            this.f();
            return;
         case 2:
            this.d = false;
            this.b = 0;
            super.ar = 0;
            LoginScr.gI().switchToMe();
         default:
      }
   }

   public final void doLeftMenu() {
      if (T.O != null) {
         if (Canvas.stypeInt == 0) {
            super.center = new Command(T.O, 0);
         }

         if (GameMidlet.f == 0) {
            super.left = new Command(T.f, 1);
         }

         super.right = new Command(T.dw, 2);
      }
   }

   private void f() {
      while(true) {
         Canvas.startWaitCancelDlg(T.b);
         if (this.m >= GameMidlet.d[OptionScr.gI().b[4]].length) {
            Canvas.startOKDlg(T.ds);
            this.m = 0;
            return;
         }

         String var1;
         if ((var1 = GameMidlet.a(GameMidlet.d[OptionScr.gI().b[4]][this.m])) != null) {
            String[] var6 = Canvas.normalFont.a(var1, "*");
            GameMidlet.c[OptionScr.gI().b[4]] = new int[var6.length - 1][];
            GameMidlet.b[OptionScr.gI().b[4]] = new String[var6.length - 1][];
            GameMidlet.a[OptionScr.gI().b[4]] = new String[var6.length - 1][];

            for(int var2 = 1; var2 < var6.length; ++var2) {
               String[] var3 = Canvas.normalFont.a(var6[var2], "\n");
               GameMidlet.a[OptionScr.gI().b[4]][var2 - 1] = new String[var3.length - 1];
               GameMidlet.b[OptionScr.gI().b[4]][var2 - 1] = new String[var3.length - 2];
               GameMidlet.c[OptionScr.gI().b[4]][var2 - 1] = new int[var3.length - 2];
               GameMidlet.a[OptionScr.gI().b[4]][var2 - 1][0] = var3[0];

               for(int var4 = 1; var4 < var3.length - 1; ++var4) {
                  String[] var5 = Canvas.normalFont.a(var3[var4], ":");
                  GameMidlet.a[OptionScr.gI().b[4]][var2 - 1][var4] = var5[0];
                  GameMidlet.b[OptionScr.gI().b[4]][var2 - 1][var4 - 1] = var5[1];
                  var5[2] = var5[2].substring(0, var5[2].length() - 1);
                  GameMidlet.c[OptionScr.gI().b[4]][var2 - 1][var4 - 1] = Integer.parseInt(var5[2]);
               }
            }

            AvatarData.e();
            Canvas.endDlg();
            this.e();
            return;
         }

         ++this.m;
      }
   }

   public final void e() {
      if (Canvas.stypeInt > 0) {
         super.aj = true;
      }

      int var1 = 176;
      if (176 > Canvas.w) {
         var1 = Canvas.w;
      }

      PaintPopup.gI().a(T.bP, var1 * AvMain.hd, MyScreen.av * 6, 1);
      k = PaintPopup.gI().g + 4;
      l = PaintPopup.gI().h + PaintPopup.o + AvMain.Z;
      j = PaintPopup.gI().e - (PaintPopup.o + (AvMain.Z << 1));
      i = GameMidlet.a[OptionScr.gI().b[4]].length * MyScreen.av + (this.d ? GameMidlet.a[OptionScr.gI().b[4]][this.b].length * MyScreen.av : 0) - j;
      e = 0;
      f = 0;
      if (i < 0) {
         i = 0;
      }

   }

   public final void update() {
      if (this.o != 0) {
         if (f < 0 || f > i) {
            this.o -= this.o / 4;
            f += this.o / 20;
            if (this.o / 10 <= 1) {
               this.o = 0;
            }
         }

         if (f < 0) {
            if (f < -j / 2) {
               f = -j / 2;
               e = 0;
               this.o = 0;
            }
         } else if (f > i) {
            if (f < i + j / 2) {
               f = i + j / 2;
               e = i;
               this.o = 0;
            }
         } else {
            f += this.o / 10;
         }

         e = f;
         this.o -= this.o / 10;
         if (this.o / 10 == 0) {
            this.o = 0;
         }
      } else if (f < 0) {
         e = 0;
      } else if (f > i) {
         e = i;
      }

      if (f != e) {
         h = e - f << 2;
         g += h;
         f += g >> 4;
         g &= 15;
      }

      Canvas.loadMap.update();
   }

   private void b(int var1) {
      this.b = var1;
      if (this.b >= GameMidlet.a[OptionScr.gI().b[4]].length) {
         this.b = 0;
      }

      if (this.b < 0) {
         this.b = GameMidlet.a[OptionScr.gI().b[4]].length - 1;
      }

   }

   public final void a(int var1, boolean var2) {
      super.ar = var1;
      if (super.ar >= GameMidlet.a[OptionScr.gI().b[4]][this.b].length || super.ar <= 0) {
         super.ar = 0;
         if (var2) {
            this.d = false;
            this.e();
         }
      }

   }

   public final void updateKey() {
      ++this.r;
      boolean var1 = false;
      if (Canvas.a(8)) {
         var1 = true;
         if (!this.d) {
            this.b(this.b + 1);
         } else {
            this.a(super.ar + 1, true);
         }
      } else if (Canvas.a(2)) {
         var1 = true;
         if (!this.d) {
            this.b(this.b - 1);
         } else {
            this.a(super.ar - 1, true);
         }
      }

      if (Canvas.isPointerClick && Canvas.b(k, l, PaintPopup.gI().f, j)) {
         Canvas.isPointerClick = false;
         this.q = f;
         this.p = true;
         this.n = System.currentTimeMillis() / 10L;
      }

      if (this.p) {
         long var2 = System.currentTimeMillis() / 10L - this.n;
         int var4 = Canvas.dy();
         int var5;
         if (Canvas.isPointerDown) {
            if (Canvas.gameTick % 3 == 0) {
               this.t = Canvas.py;
               this.s = this.r;
            }

            this.o = 0;
            var5 = (e + Canvas.py - l) / MyScreen.av;
            if (this.d) {
               super.ar = var5 - this.b;
            } else if (var5 >= 0 && var5 < GameMidlet.a[OptionScr.gI().b[4]].length) {
               this.b = var5;
            }

            if (CRes.abs(var4) >= 20 * AvMain.hd) {
               super.aj = true;
            } else if (var2 > 10L && var2 < 20L) {
               super.aj = false;
            }

            if ((e = this.q + var4) < 0 || e > i) {
               e = this.q + var4 / 2;
            }

            f = e;
         }

         if (Canvas.isPointerRelease && Canvas.b(k, l, PaintPopup.gI().f, j)) {
            var5 = (int)(this.r - this.s);
            int var6;
            if (CRes.abs(var6 = this.t - Canvas.py) > 40 && var5 < 10 && e > 0 && e < i) {
               this.o = var6 / var5 * 10;
            }

            this.s = -1L;
            if (Math.abs(var4) < 20 * AvMain.hd) {
               if (var2 <= 10L) {
                  super.aj = false;
               }

               if (!super.aj) {
                  int var7 = (e + Canvas.py - l) / MyScreen.av;
                  if (this.d) {
                     if (var7 - this.b > 0 && var7 - this.b < GameMidlet.a[OptionScr.gI().b[4]][this.b].length) {
                        super.ar = var7 - this.b;
                        this.commandTab(0, -1);
                     } else {
                        if (var7 - this.b <= 0) {
                           this.d = false;
                           super.ar = 0;
                           this.b = var7;
                           var1 = true;
                        }

                        if (var7 >= GameMidlet.a[OptionScr.gI().b[4]][this.b].length - this.b && var7 < GameMidlet.a[OptionScr.gI().b[4]][this.b].length - 1 + GameMidlet.a[OptionScr.gI().b[4]].length) {
                           this.d = false;
                           super.ar = 0;
                           this.b = var7 - GameMidlet.a[OptionScr.gI().b[4]][this.b].length + 1;
                           var1 = true;
                        }
                     }
                  } else if (var7 >= 0 && var7 < GameMidlet.a[OptionScr.gI().b[4]].length) {
                     this.b = var7;
                     this.commandTab(0, -1);
                  }
               }
            }
         }
      }

      if (Canvas.isPointerRelease) {
         this.p = false;
      }

      if (var1) {
         this.g();
      }

      super.updateKey();
   }

   private void g() {
      if ((e = (this.b + (this.d ? super.ar : 0)) * MyScreen.av - j / 2 + MyScreen.av / 2) < 0) {
         e = 0;
      }

      if (e > i) {
         e = i;
      }

   }

   public final void paint(Graphics var1) {
      Canvas.loadMap.b(var1);
      Canvas.loadMap.d(var1);
      Canvas.resetTrans(var1);
      PaintPopup.gI().a(var1);
      if (GameMidlet.avatar != null && !GameMidlet.avatar.name.equals("")) {
         Canvas.borderFont.drawString(var1, T.dz + ", " + GameMidlet.avatar.name, PaintPopup.gI().g + PaintPopup.gI().f / 2, PaintPopup.gI().h - AvMain.ag, 2);
      }

      var1.translate(k, l);
      var1.setClip(0, 0, PaintPopup.gI().f - 9, PaintPopup.gI().e - (PaintPopup.o + (AvMain.Z << 1)));
      var1.translate(0, -f);
      if (!super.aj) {
         Canvas.paint.c(var1, 2 * AvMain.hd, this.b * MyScreen.av + (this.d ? super.ar * MyScreen.av : 0), PaintPopup.gI().f - 8 - 4 * AvMain.hd, MyScreen.av);
      }

      int var2 = (MyScreen.av - AvMain.ah) / 2;

      for(int var3 = 0; var3 < GameMidlet.a[OptionScr.gI().b[4]].length; ++var3) {
         Canvas.normalFont.drawString(var1, GameMidlet.a[OptionScr.gI().b[4]][var3][0], 24 * AvMain.hd, var2, 0);
         PaintPopup.a.drawFrame(0, 14 * AvMain.hd, var2 + AvMain.ah / 2, 5, 3, var1);
         var2 += MyScreen.av;
         if (this.d && this.b == var3) {
            for(int var4 = 1; var4 < GameMidlet.a[OptionScr.gI().b[4]][var3].length; ++var4) {
               Canvas.normalFont.drawString(var1, GameMidlet.a[OptionScr.gI().b[4]][var3][var4], 36 * AvMain.hd, var2, 0);
               var1.drawImage(this.c, 24 * AvMain.hd, var2 + AvMain.ah / 2, 3);
               var2 += MyScreen.av;
            }
         }
      }

      super.paint(var1);
      Canvas.paintPlus(var1);
   }
}

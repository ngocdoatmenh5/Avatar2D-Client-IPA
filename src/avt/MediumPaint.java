package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class MediumPaint implements IPaint {
   private static FrameImage a;
   private static Image b;
   private static Image c;
   private static Image d;
   private static Image e;
   private static Image[] f;
   private static FrameImage[] g;
   private static FrameImage h;
   private static FrameImage i;
   private static Image[] j;
   private static FrameImage k;
   private static FrameImage l;
   private static byte[][] m = new byte[][]{{4, 6, 17, 0, 27, 14, 0, 27, 36}, {4, 6, 17, 0, 17, 13, 0, 37, 13}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 27, 36}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 17, 36, 0, 37, 36}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 17, 36, 0, 37, 36, 0, 27, 30}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 17, 28, 0, 37, 28}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 17, 28, 0, 37, 28, 0, 27, 36}, {4, 6, 17, 0, 17, 13, 0, 37, 13, 0, 17, 28, 0, 37, 28, 0, 27, 20}, {4, 6, 17, 8, 27, 36}, {4, 6, 17, 9, 27, 36}, {4, 6, 17, 10, 27, 36}, {4, 6, 17, 0, 27, 36}, {4, 6, 17, 0, 27, 14}};
   private static int n;
   private byte o;
   private byte p;
   private byte q;
   private static int r;
   private static int s;
   private static int t;
   private static int u;

   static {
      TField.s = 0;
      PaintPopup.d = new int[]{6201499, 2378578, 8705740, 2716523, 16701696, 7042560};
      n = 0;
      r = 35217;
      s = 32382;
      t = 23135;
      u = 14414578;
   }

   public MediumPaint() {
      try {
         Canvas.Y = Image.createImage(T1.a() + "/12Plus.png");
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      FilePack.b(T1.av);
      Avatar.imgHit = FrameImage.a("5", 50, 48);
      Avatar.imgKiss = FrameImage.a("2", 11, 10);
      Canvas.aa = FilePack.a("transtab");
      Pet.s[0] = FilePack.a("s1");
      Pet.s[1] = FilePack.a("s2");
      PaintPopup.a = FrameImage.a("arrowup", 9, 6);
      MsgDlg.b = FrameImage.a("busy", 16, 16);
      MenuSub.f = FrameImage.a("cmd", 24, 24);
      MapScr.k = FilePack.a("bar");
      MapScr.d = FilePack.a("arF");
      FrameImage.a("icon", 17, 19);
      Avatar.imgBlog = new FrameImage(FilePack.a("dauhoathi"), 9, 9);
      h = FrameImage.a("check", 12, 12);
      TField.r = FrameImage.a("tb", 4, 19);
      a = FrameImage.a("round", 8, 8);
      PaintPopup.b = FrameImage.a("ar2", 4, 6);
      i = new FrameImage(FilePack.a("arW"), 6, 11);

      for(int var1 = 0; var1 < 2; ++var1) {
         MiniMap.k[var1] = FilePack.a("cl" + var1);
      }

      FilePack.a();

      try {
         MyScreen.ao = Image.createImage(T1.a() + "/on/msg0.on");
         RoomListOnScr.b = new FrameImage(Image.createImage(T1.a() + "/on/stat.on"), 11, 11);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, TField var6, boolean var7) {
      if (var7) {
         TField.r.a(2, var2 + 1, var3 + 1, 0, var1);
         TField.r.a(3, var2 + var4 - 5, var3 + 1, 0, var1);
         PaintPopup.a(var2 + 4, var3 + 1, var4 - 8, 2, 2716523, var1);
         var1.fillRect(var2 + 4, var3 + 18, var4 - 8, 2);
         PaintPopup.a(var2 + 4, var3 + 3, var4 - 8, 1, 2704964, var1);
         PaintPopup.a(var2 + 4, var3 + 4, var4 - 8, 1, 5014141, var1);
         PaintPopup.a(var2 + 4, var3 + 5, var4 - 8, 13, 6201499, var1);
      } else {
         TField.r.a(0, var2 + 1, var3 + 1, 0, var1);
         TField.r.a(1, var2 + var4 - 5, var3 + 1, 0, var1);
         PaintPopup.a(var2 + 4, var3 + 2, var4 - 9, 1, 11074288, var1);
         var1.fillRect(var2 + 4, var3 + 18, var4 - 9, 1);
         PaintPopup.a(var2 + 4, var3 + 3, var4 - 9, 1, 2704964, var1);
         PaintPopup.a(var2 + 4, var3 + 4, var4 - 9, 1, 5014141, var1);
         PaintPopup.a(var2 + 4, var3 + 5, var4 - 9, 13, 6201499, var1);
      }

      var1.setClip(var2 + 3, var3 + 1, var4 - 8, var5 - 2);
      var1.setColor(0);
      if (var6.g.equals("")) {
         Canvas.K.a(var1, var6.q, 5 + var6.j + var2, var3 + (var5 - AvMain.af) / 2, 0);
      } else {
         Canvas.M.a(var1, var6.g, 5 + var6.j + var2, var3 + (var5 - AvMain.af) / 2 + 1, 0);
      }

      if (var6.d() && var6.k == 0 && (var6.l > 0 || var6.i / 5 % 2 == 0)) {
         var1.setColor(16777215);
         var1.fillRect(5 + var6.j + var2 + Canvas.M.getWidth(var6.g.substring(0, var6.h)) - 1 + 1, var3 + (var5 - TField.f) / 2 + 2, 1, var5 - 5 * AvMain.hd);
      }

      if (var7 && Canvas.j() - TField.o < 2) {
         int var8 = Canvas.K.getWidth(TField.p[TField.n]);
         var1.setClip(0, 0, Canvas.m, Canvas.n);
         PaintPopup.a(var2 + var4 - var8 - 4, var3 + 4, var8 + 1, var5 - 6, 8969676, var1);
         PaintPopup.a(var2 + var4 - var8 - 4, var3 + 4, var8 + 1, 1, 5614233, var1);
         Canvas.K.a(var1, TField.p[TField.n], var2 + var4 - 3, var3 + 3, 1);
      }

   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      a.a(0 + (var8 << 2), var2, var3, 0, var1);
      a.a(1 + (var8 << 2), var2 + var4 - 8, var3, 0, var1);
      a.a(2 + (var8 << 2), var2, var3 + var5 - 8, 0, var1);
      a.a(3 + (var8 << 2), var2 + var4 - 8, var3 + var5 - 8, 0, var1);
      PaintPopup.a(var2 + 8, var3, var4 - 16, 8, var6, var1);
      var1.fillRect(var2 + 8, var3 + var5 - 8, var4 - 16, 7);
      var1.fillRect(var2, var3 + 8, var4, var5 - 16);
      PaintPopup.a(var2 + 8, var3, var4 - 16, 1, var7, var1);
      var1.fillRect(var2 + 8, var3 + var5 - 1, var4 - 16, 1);
      var1.fillRect(var2, var3 + 8, 1, var5 - 16);
      var1.fillRect(var2 + var4 - 1, var3 + 8, 1, var5 - 16);
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int[] var13, int[] var14, String var15) {
      Canvas.resetTrans(var1);
      this.a(var1, var2, var3, var5, var4, PaintPopup.d[0], PaintPopup.d[1], 0);

      int var16;
      int var17;
      int var10002;
      int var18;
      for(var17 = var7; var17 < var6; ++var17) {
         var10002 = var13[var17]++;
         if (var13[var17] > 20) {
            var13[var17] = 0;
         }

         var18 = var14[var17];
         if (PaintPopup.a().n[var17] > 5) {
            var18 = 0;
         }

         var16 = var17 - var7;
         a.a(var18 + 4, var2 + 3 + var16 * var8, var3 + 3, 0, var1);
         PaintPopup.a(var2 + 11 + var16 * var8, var3 + 3, var9 - 16, var10 - 2, PaintPopup.d[2 + var18 / 2], var1);
         var1.fillRect(var2 + 3 + var16 * var8, var3 + 11, var9 - 1, var10);
         PaintPopup.a(var2 + 11 + var16 * var8, var3 + 3, var9 - 16, 1, PaintPopup.d[3 + var18 / 2], var1);
         var1.fillRect(var2 + 3 + var16 * var8, var3 + 11, 1, var10 + 1);
         var1.fillRect(var2 + 2 + var9 + var16 * var8, var3 + 11, 1, var10 + 1);
      }

      var17 = var11;
      if (var11 >= var12) {
         var17 = var12 + var7;
      }

      for(var18 = var17 - 1; var18 >= var6; --var18) {
         var10002 = var13[var18]++;
         if (var13[var18] > 20) {
            var13[var18] = 0;
         }

         var11 = var14[var18];
         if (var13[var18] > 5) {
            var11 = 0;
         }

         var16 = var18 - var7;
         if (var18 == var6) {
            a.a(var11 + 4, var2 + 3 + var16 * var8, var3 + 3, 0, var1);
         }

         a.a(var11 + 5, var2 + 3 + var9 - 8 + var16 * var8, var3 + 3, 0, var1);
         PaintPopup.a(var2 + 11 + var16 * var8, var3 + 3, var9 - 16, 8, PaintPopup.d[2 + var11 / 2], var1);
         var1.fillRect(var2 + 3 + var16 * var8, var3 + 11, var9 - 1, 15);
         PaintPopup.a(var2 + 11 + var16 * var8, var3 + 3, var9 - 16, 1, PaintPopup.d[3 + var11 / 2], var1);
         var1.fillRect(var2 + 3 + var16 * var8, var3 + 11, 1, 20);
         var1.fillRect(var2 + 2 + var9 + var16 * var8, var3 + 11, 1, 15);
      }

      this.a(var1, var2 + 3, var3 + var10, var5 - 6, var4 - var10 - 3, PaintPopup.d[2], PaintPopup.d[3], 1);
      PaintPopup.a(var2 + 4 + (var6 - var7) * var8, var3 + var10 / 2, var9 - 2, var10, PaintPopup.d[2], var1);
      Canvas.K.a(var1, var15, var2 + 3 + var9 / 2 + (var6 - var7) * var8, var3 + var10 / 2 - AvMain.ah / 2, 2);
   }

   public final void a(Graphics var1, Command var2, Command var3, Command var4) {
      if (var2 != null && var2.a != null) {
         Canvas.L.a(var1, var2.a, Canvas.ae[0].a + 2, Canvas.ae[0].b + Canvas.T / 2 - AvMain.ag / 2, 0);
      }

      if (var3 != null && var3.a != null) {
         Canvas.L.a(var1, var3.a, Canvas.ae[1].a + MyScreen.au / 2, Canvas.ae[1].b + Canvas.T / 2 - AvMain.ag / 2, 2);
      }

      if (var4 != null && var4.a != null) {
         Canvas.L.a(var1, var4.a, Canvas.ae[2].a + MyScreen.au - 2, Canvas.ae[2].b + Canvas.T / 2 - AvMain.ag / 2, 1);
      }

   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      this.a(var1, var2, var3, var4, var5, 0);
   }

   public final void b() {
      if (b == null) {
         try {
            f = new Image[14];
            g = new FrameImage[2];

            int var1;
            for(var1 = 0; var1 < 14; ++var1) {
               f[var1] = Image.createImage(T1.a() + "/card/c" + var1 + ".png");
            }

            var1 = f[12].getWidth();
            int var2 = f[12].getHeight();
            Image var3;
            Graphics var4;
            (var4 = (var3 = Image.createImage(var1 << 1, var2 << 1)).getGraphics()).setColor(-523560);
            var4.fillRect(0, 0, var1 << 1, var2 << 1);
            var4.drawImage(f[12], 0, 0, 0);
            var4.drawRegion(f[12], 0, 0, var1, var2, 2, var1, 0, 0);
            var4.drawRegion(f[12], 0, 0, var1, var2, 1, 0, var2, 0);
            var4.drawRegion(f[12], 0, 0, var1, var2, 3, var1, var2, 0);
            var3 = CRes.a(var3, -65315);
            f[12] = var3;
            g[0] = new FrameImage(Image.createImage(T1.a() + "/card/f.png"), 8, 9);
            g[1] = new FrameImage(Image.createImage(T1.a() + "/card/g.png"), 8, 9);
            b = Image.createImage(T1.a() + "/card/cb.png");
            c = Image.createImage(T1.a() + "/card/cb1.png");
            d = Image.createImage(T1.a() + "/card/cb2.png");
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }
   }

   public final void a(Graphics var1, Card var2) {
      if (var2.b == -1) {
         var1.drawImage(f[12], var2.c - 27, var2.d - 36, 0);
      } else {
         var1.drawImage(c, var2.c - 27, var2.d - 36, 0);
         d(var1, var2);
      }
   }

   public final void b(Graphics var1, Card var2) {
      if (var2.b == -1) {
         var1.drawImage(f[12], var2.c - 27, var2.d - 36, 0);
      } else {
         var1.drawImage(b, var2.c - 27, var2.d - 36, 0);
         d(var1, var2);
      }
   }

   private static void d(Graphics var0, Card var1) {
      int var2 = 0;

      while(var2 < 2) {
         int var3;
         if ((var3 = m[var1.h[var1.j]][var2++]) == 0 || var3 == 4) {
            var3 += var1.i;
         }

         if (var1.i == 0 && var1.h[var1.j] == 11 && var3 == 0) {
            var3 = 11;
         }

         byte var4 = m[var1.h[var1.j]][var2++];
         byte var5 = m[var1.h[var1.j]][var2++];
         var0.drawImage(f[var3], var1.c - 27 + var4, var1.d - 36 + var5, 3);
      }

      g[var1.k].drawFrame(var1.h[var1.j], var1.c - 27 + 5, var1.d - 36 + 7, 0, 3, var0);
   }

   public final void c(Graphics var1, Card var2) {
      if (var2.b == -1) {
         var1.drawImage(f[12], var2.c - 27, var2.d - 36, 0);
      } else {
         var1.drawImage(b, var2.c - 27, var2.d - 36, 0);
         int var3 = 0;

         while(var3 < m[var2.h[var2.j]].length) {
            int var4;
            if ((var4 = m[var2.h[var2.j]][var3++]) == 0 || var4 == 4) {
               var4 += var2.i;
            }

            if (var2.i == 0 && var2.h[var2.j] == 11 && var4 == 0) {
               var4 = 11;
            }

            byte var5 = m[var2.h[var2.j]][var3++];
            byte var6 = m[var2.h[var2.j]][var3++];
            var1.drawImage(f[var4], var2.c - 27 + var5, var2.d - 36 + var6, 3);
            if (var6 < 30) {
               var1.drawRegion(f[var4], 0, 0, f[var4].getWidth(), f[var4].getHeight(), 1, var2.c + 27 - var5, var2.d + 36 - var6, 3);
            }
         }

         g[var2.k].drawFrame(var2.h[var2.j], var2.c - 27 + 5, var2.d - 36 + 7, 0, 3, var1);
         g[var2.k].drawFrame(var2.h[var2.j], var2.c + 27 - 5, var2.d + 36 - 7, 3, 3, var1);
      }
   }

   public final void a(Graphics var1, Card var2, boolean var3) {
      if (var2.b == -1) {
         var1.drawImage(f[12], var2.c - 13, var2.d - 16, 0);
      } else {
         var1.drawImage(d, var2.c - 13, var2.d - 16, 0);
         g[var2.k].drawFrame(var2.h[var2.j], var2.c - 13 + 6, var2.d - 16 + 7, 0, 3, var1);
         if (var3) {
            var1.drawImage(f[var2.i + 4], var2.c - 13 + 6 + 7, var2.d - 16 + 7, 3);
         } else {
            var1.drawImage(f[var2.i + 4], var2.c - 13 + 6, var2.d - 16 + 17, 3);
         }

         var1.drawImage(f[var2.i], var2.c - 13 + 17, var2.d - 16 + 17, 3);
      }
   }

   public final void a() {
      AvMain.Z = 5;
   }

   public final void a(Graphics var1) {
      byte var2 = 0;
      if (Canvas.currentMyScreen == LoginScr.a || Canvas.currentMyScreen == MiniMap.a) {
         var2 = 14;
      }

      if (MyScreen.as > 0 && Canvas.v == null) {
         var1.drawImage(MyScreen.ao, Canvas.m - 8 * AvMain.hd - 2, var2 + 2, 17);
         Canvas.L.a(var1, "" + MyScreen.as, Canvas.m - 16 * AvMain.hd - 4, 1 + 6 * AvMain.hd - AvMain.ag / 2 + var2, 1);
      }

      if (MyScreen.ap != null && Canvas.m()) {
         var1.drawImage(MyScreen.ap, 25, 25, 3);
         if (GameMidlet.e == 9) {
            var1.drawImage(MyScreen.aq, 75, 25, 3);
         }
      }

   }

   public final void c() {
      MyScreen.av = Canvas.n / 12;
      if ((MyScreen.at = Canvas.n / 18) < 18) {
         MyScreen.at = 18;
      }

      if (MyScreen.at > 45) {
         MyScreen.at = 45;
      }

      if (Canvas.H) {
         MyScreen.at = 35;
      }

      AvMain.ab = 0;
      int var1 = Canvas.T = MyScreen.at;
      if (MyScreen.av < 20 || Canvas.a == null || !Canvas.H) {
         MyScreen.av = 20;
      }

      if (MyScreen.av > 50) {
         MyScreen.av = 50;
      }

      MyScreen.au = Canvas.m / 4;
      Canvas.ae[0] = new AvPosition(2, Canvas.n - var1, 2);
      Canvas.ae[1] = new AvPosition(Canvas.o - MyScreen.au / 2, Canvas.n - var1, 2);
      Canvas.ae[2] = new AvPosition(Canvas.m - MyScreen.au - 2, Canvas.n - var1, 2);
      Canvas.af = new AvPosition(Canvas.m - 2, 1, 1);
   }

   public final int d() {
      for(int var1 = 0; var1 < 3; ++var1) {
         if (Canvas.a(Canvas.ae[var1].a, Canvas.ae[var1].b, MyScreen.au, Canvas.T)) {
            return var1;
         }
      }

      return -1;
   }

   public final void a(LoginScr var1) {
      var1.l = 176;
      if (var1.i) {
         var1.m = 170;
      } else {
         var1.m = 130;
      }

      if (var1.l > Canvas.m) {
         var1.l = Canvas.m;
         var1.m = 100;
      }

      var1.x = (var1.m - 20) / 3;
      var1.y = 10;
      var1.j = Canvas.o - var1.l / 2;
      var1.k = Canvas.hh - var1.m / 2 + 5;
      int var2 = var1.k + 15 + 4;
      var1.b.b = var2;
      var1.b.a = var1.c.a = var1.d.a = var1.e.a = var1.q;
      var1.b.c = var1.c.c = var1.d.c = var1.e.c = var1.p;
      var2 += var1.b.d + 15;
      var1.c.b = var2;
      var2 += var1.b.d + 15;
      var1.d.b = var2;
      var1.o = var2 - 10;
      var2 += var1.b.d + 15;
      var1.e.b = var2;
      var1.n = var1.c.a - 40;
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      this.a(var1, var2, var3, var4, var5, PaintPopup.d[var6], PaintPopup.d[var6 + 1], 0);
      this.a(var1, var2 + 3, var3 + 3, var4 - 6, var5 - 6, PaintPopup.d[2], PaintPopup.d[3], 1);
   }

   public final void a(Graphics var1, int var2, int var3, int var4, boolean var5) {
      byte var6 = 0;
      if (var4 == 2) {
         var6 = 1;
      }

      h.a(var6, var2, var3 + AvMain.ah / 2, 0, var1);
      if (var5) {
         h.a(2, var2, var3 + AvMain.ah / 2, 0, var1);
      }

      Canvas.K.a(var1, T1.bQ, var2 + 15, var3 + h.b / 2, 0);
   }

   public final void b(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(15530985);
      var1.fillRect(0, var3, var4, var5);
   }

   public final void b(Graphics var1, int var2, int var3, int var4, int var5, int var6) {
      PaintPopup.b.drawFrame(var5, var2 - n / 5, var3 - 3, 0, 3, var1);
      PaintPopup.b.drawFrame(var6, var2 + var4 + n / 5, var3 - 3, 3, 3, var1);
      if (++n >= 15) {
         n = 0;
      }

   }

   public final void a(Graphics var1, String var2, int var3, int var4, int var5) {
      Canvas.K.a(var1, var2, var3, var4, var5);
   }

   public final void c(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(14279153);
      var1.fillRect(var2, var3, var4, var5);
   }

   public final void a(int var1) {
      if (var1 == 14 || var1 == 15 || var1 == 16) {
         if (AvMain.ak) {
            TField.m = true;
         }

         OptionScr.d = true;
         Canvas.a.sizeChanged(0, 0);
      }

   }

   public final void e() {
      int var1 = Canvas.n;
      AvPosition[] var10000 = new AvPosition[]{new AvPosition(Canvas.o + 5, 5, 0), new AvPosition(5, var1 / 2, 0), new AvPosition(Canvas.o + 5, var1 - 50, 0), new AvPosition(Canvas.m - 5, var1 / 2, 1)};
      var10000 = new AvPosition[]{new AvPosition(Canvas.o, 2, 3), new AvPosition(10, var1 / 2, 20), new AvPosition(Canvas.o - 10, var1 - 75 - MyScreen.at, 3), new AvPosition(Canvas.m - 60, var1 / 2, 3)};
      int var2 = Canvas.n - 24;
      var1 = var1 - 15 - Canvas.T;
      if (Canvas.m < 200) {
         PBoardScr.c = new AvPosition[]{new AvPosition(Canvas.o, BoardScr.A / 2, 0), new AvPosition(BoardScr.z / 2, var2 / 2, 0), new AvPosition(Canvas.o, var1 - BoardScr.A + 20, 0), new AvPosition(Canvas.m - BoardScr.z / 2 - 3, var2 / 2, 0)};
         PBoardScr.d = new AvPosition[]{new AvPosition(Canvas.o, BoardScr.A, 0), new AvPosition(BoardScr.z + 3, var2 / 2, 0), new AvPosition(Canvas.o, var1 - BoardScr.A / 2 + 20, 0), new AvPosition(Canvas.m - 3, var2 / 2, 0)};
         PBoardScr.b = new AvPosition[]{new AvPosition(Canvas.o, BoardScr.A + BoardScr.A / 2 + 2, 2), new AvPosition(BoardScr.z / 4 * 3 + BoardScr.z / 2 + 5, var2 / 2, 0), new AvPosition(Canvas.o, var1 - BoardScr.A - AvMain.ai - 5, 2), new AvPosition(Canvas.m - BoardScr.z - 5, var2 / 2 - 5, 1)};
      } else {
         PBoardScr.c = new AvPosition[]{new AvPosition(Canvas.o, BoardScr.A / 2, 0), new AvPosition(BoardScr.z / 2, var2 / 2, 0), new AvPosition(Canvas.o, var1 - BoardScr.A / 2, 0), new AvPosition(Canvas.m - BoardScr.z / 2, var2 / 2, 0)};
         PBoardScr.d = new AvPosition[]{new AvPosition(Canvas.o, 0, 0), new AvPosition(BoardScr.z / 4 * 3, var2 / 2, 0), new AvPosition(Canvas.o, var1 - BoardScr.A / 2 + BoardScr.A / 4, 0), new AvPosition(Canvas.m - BoardScr.z / 4, var2 / 2, 0)};
         PBoardScr.b = new AvPosition[]{new AvPosition(Canvas.o, BoardScr.A + 2, 2), new AvPosition(BoardScr.z / 4 * 3 + BoardScr.z / 2 + 5, var2 / 2 - 10, 0), new AvPosition(Canvas.o, var1 - BoardScr.A - AvMain.ai - 1, 2), new AvPosition(Canvas.m - BoardScr.z - 5, var2 / 2 - 10, 1)};
      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, String var10, int var11, int var12) {
      var6 = var2 % var3 * var4;
      var3 = (var2 / var3 + 1) * var4;
      var4 = var6 + var4 / 2;
      var1.setClip(var4 - var5 / 2, var3, var5, var7);
      var6 = (var7 - (AvMain.Z << 1)) / 4;
      this.a(var1, var4 - var5 / 2, var3, var5, var7, 0);
      var3 += AvMain.Z + 8;
      if (var8 == 1) {
         ((FarmItem)FarmData.e.elementAt(var2)).a(var1, var4, var3 + var6 / 2, 0, 3);
      } else {
         FarmData.b[var2].a(var1, 7, var4, var3 + var6 / 2, 3);
      }

      Canvas.L.a(var1, String.valueOf(var9), var4, var3 + var6 / 2 + var6 - 2, 2);
      Canvas.K.a(var1, var10, var4, var3 + var6 / 2 + (var6 << 1), 2);
      var2 = var3 + var6 / 2 + var6 + AvMain.ah / 2;
      i.drawFrame(var11 / 3, var4 - 17, var2 + 1, 2, 3, var1);
      i.drawFrame(var12 / 3, var4 - 17 + 35, var2, 0, 3, var1);
   }

   public final void a(Graphics var1, int var2, int var3, int var4, boolean var5, int var6, int[] var7) {
      Canvas.N.a(var1, T1.aX + var6, Canvas.o, Canvas.hh + var2 * var4 / 2 - 20, 2);
      var1.translate(Canvas.o - (var2 * var3 + 10) / 2 + 4, Canvas.hh - var2 * var4 / 2 + 4);
      var1.setClip(0, 3, var2 * var3 + 2, var2 * var4 - 32);
      var1.translate(1, -CameraList.i);
      if (!var5) {
         Canvas.S.c(var1, var6 % var3 * var2, var6 / var3 * var2, var2, var2);
      }

      int var8;
      if ((var8 = (var4 = CameraList.i / var2 * var3) + var2 * 7 / var2 * var3 + var3) > var7.length) {
         var8 = var7.length;
      }

      for(var4 = var4; var4 < var8; ++var4) {
         RoomListOnScr.b.drawFrame(var7[var4], var4 % var3 * var2 + var2 / 2, var4 / var3 * var2 + var2 / 2, 0, 3, var1);
      }

   }

   public final void b(Graphics var1) {
      for(int var2 = 0; var2 < Canvas.m / 50 + 1; ++var2) {
         for(int var3 = 0; var3 < Canvas.q / 71 + 1; ++var3) {
            var1.drawImage(e, var2 * 50, var3 * 71, 0);
         }
      }

   }

   public final void a(Graphics var1, int var2, int var3) {
      var1.drawImage(OnSplashScr.c, var2, var3, 3);
   }

   public final void a(Graphics var1, String var2, String var3, String var4) {
      var1.setClip(0, 0, Canvas.m, Canvas.n);
      Canvas.S.b(var1);
      Canvas.R.a(var1, var2, Canvas.o, 2, 2);
      var1.setColor(6192786);
      var1.fillRect(0, 25, Canvas.m, MyScreen.al);
      Canvas.M.a(var1, var3, 10, 28, 0);
      Canvas.M.a(var1, var4, Canvas.m - 10, 28, 1);
   }

   public final void b(int var1) {
      try {
         if (var1 == 0) {
            BoardListOnScr.f = new FrameImage(Image.createImage(T1.a() + "/on/imgBan2.on"), 60, 46);
         } else if (var1 == 1) {
            BoardListOnScr.f = new FrameImage(Image.createImage(T1.a() + "/on/imgBan4.on"), 60, 46);
         } else {
            BoardListOnScr.f = new FrameImage(Image.createImage(T1.a() + "/on/imgBan5.on"), 60, 46);
         }
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void f() {
      try {
         PaintPopup.d = new int[]{21080, 12313816, 8703190, 2713971, 5107863, 4559225};
         a = new FrameImage(Image.createImage(T1.a() + "/on/round.on"), 8, 8);
         e = Image.createImage(T1.a() + "/on/bg.on");
         j = new Image[8];

         for(int var1 = 0; var1 < 8; ++var1) {
            j[var1] = Image.createImage(T1.a() + "/on/imgPopup" + var1 + ".on");
         }

         l = new FrameImage(Image.createImage(T1.a() + "/barMoney.png"), 10, 10);
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void g() {
      PaintPopup.d = new int[]{6201499, 2378578, 8705740, 2716523, 16701696, 7042560};
      FilePack.b(T1.av);
      a = FrameImage.a("round", 8, 8);
      FilePack.a();
      e = null;
      l = null;
      OnScreen.a = null;
      TLBoardScr.a = null;
      PBoardScr.a = null;
      OnSplashScr.a = null;
      BoardScr.i = null;
      CasinoMsgHandler.d = null;
   }

   public final void h() {
      try {
         k = new FrameImage(Image.createImage(T1.a() + "/on/imgDoor.on"), 45, 44);
         new FrameImage(Image.createImage(T1.a() + "/on/trangthai.on"), 11, 4);
         BoardListOnScr.i = Image.createImage(T1.a() + "/on/imgSelectban.on");
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public final void i() {
      RoomListOnScr.a = null;
      BoardListOnScr.a = null;
      BoardScr.i = null;
      DiamondScr.a = null;
      BCBoardScr.a = null;
   }

   public final void d(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(12442838);
      byte var6 = 0;
      byte var7 = 30;
      if (var2 > 0) {
         var7 = 50;
         var6 = 40;
      }

      var1.fillRect(4, PaintPopup.o + 20 + AvMain.af / 2 + var6 - var7 / 2, PaintPopup.a().f - 8, var7);
      Canvas.K.a(var1, var3 == 1 ? T1.et[0] : T1.et[1], PaintPopup.a().f / 2, PaintPopup.o + 20, 2);
      PaintPopup.a.drawFrame(0, PaintPopup.a().f / 2 - 35 - var4 / 2, PaintPopup.o + 20 + AvMain.af / 2 + var6, 4, 3, var1);
      PaintPopup.a.drawFrame(0, PaintPopup.a().f / 2 + 35 + var5 / 2, PaintPopup.o + 20 + AvMain.af / 2 + var6, 7, 3, var1);
      GameMidlet.avatar.paintIcon(var1, PaintPopup.a().f / 2 + 1, PaintPopup.o + 87, false);
      Canvas.K.a(var1, T1.aA + GameMidlet.avatar.name, PaintPopup.a().f / 2, PaintPopup.o + 100, 2);
      Canvas.K.a(var1, T1.ao + GameMidlet.avatar.strMoney, PaintPopup.a().f / 2, PaintPopup.o + 115, 2);
   }

   public final void j() {
      if (Canvas.g) {
         if (Canvas.b(PaintPopup.a().g + PaintPopup.a().f / 2 - 20, PaintPopup.a().h + PaintPopup.o + AvMain.af / 2, 40, 40)) {
            RegisterScr.b().b(0);
            Canvas.g = false;
         } else if (Canvas.b(PaintPopup.a().g + PaintPopup.a().f / 2 - 20, PaintPopup.a().h + PaintPopup.o + 95 - GameMidlet.avatar.height / 2 - 20, 40, 45)) {
            RegisterScr.b().b(1);
            Canvas.g = false;
         } else if (Canvas.b(PaintPopup.a().g + PaintPopup.a().f / 2 - 20 - 40, PaintPopup.a().h + PaintPopup.o + AvMain.af / 2 + 50 * RegisterScr.b().a, 40, 40)) {
            RegisterScr.b().c(-1);
            RegisterScr.b().b = 6;
            Canvas.g = false;
         } else if (Canvas.b(PaintPopup.a().g + PaintPopup.a().f / 2 - 20 + 40, PaintPopup.a().h + PaintPopup.o + AvMain.af / 2 + 50 * RegisterScr.b().a, 40, 40)) {
            RegisterScr.b().c(1);
            RegisterScr.b().c = 6;
            Canvas.g = false;
         }
      }

      if (Canvas.a(2)) {
         RegisterScr.b().b(RegisterScr.b().a - 1);
      } else if (Canvas.a(4)) {
         RegisterScr.b().c(-1);
         RegisterScr.b().b = 6;
      } else if (Canvas.a(6)) {
         RegisterScr.b().c(1);
         RegisterScr.b().c = 6;
      } else {
         if (Canvas.a(8)) {
            RegisterScr.b().b(RegisterScr.b().a + 1);
         }

      }
   }

   public final void b(Graphics var1, Command var2, Command var3, Command var4) {
      int var5 = Canvas.q - Canvas.T / 2 - AvMain.ag / 2;
      if (var2 != null && var2.a != "") {
         Canvas.L.a(var1, var2.a, 4, var5, 0);
      }

      if (var3 != null && var3.a != "") {
         Canvas.L.a(var1, var3.a, Canvas.o, var5, 2);
      }

      if (var4 != null && var4.a != "") {
         Canvas.L.a(var1, var4.a, Canvas.m - 4, var5, 1);
      }

   }

   public final void e(Graphics var1, int var2, int var3, int var4, int var5) {
      boolean var9 = true;
      var5 = var5;
      var4 = var4;
      var3 = var3;
      var2 = var2;
      var1 = var1;
      int var6 = j[0].getWidth();
      int var7 = j[0].getHeight();
      var1.drawImage(j[0], var2, var3, 0);

      int var8;
      for(var8 = 1; var8 < var4 / var6 - 1; ++var8) {
         var1.drawImage(j[1], var2 + var6 * var8, var3, 0);
      }

      var1.drawImage(j[1], var2 + var4 - (var6 << 1), var3, 0);
      var1.drawImage(j[2], var2 + var4 - var6, var3, 0);
      if (var5 / var7 > 2) {
         for(var8 = 1; var8 < var5 / var7; ++var8) {
            var1.drawImage(j[3], var2, var3 + var7 * var8, 0);
            var1.drawImage(j[4], var2 + var4 - var6, var3 + var7 * var8, 0);
         }

         var1.drawImage(j[3], var2, var3 + var5 - (var7 << 1), 0);
         var1.drawImage(j[4], var2 + var4 - var6, var3 + var5 - (var7 << 1), 0);
      }

      if (var5 > (var7 << 1) - 20 && var5 <= var7 * 3) {
         var1.drawImage(j[3], var2, var3 + var5 / 2 - var7 / 2, 0);
         var1.drawImage(j[4], var2 + var4 - var6, var3 + var5 / 2 - var7 / 2, 0);
      }

      var1.drawImage(j[5], var2, var3 + var5 - var7, 0);

      for(var8 = 1; var8 < var4 / var6 - 1; ++var8) {
         var1.drawImage(j[6], var2 + var6 * var8, var3 + var5 - var7, 0);
      }

      var1.drawImage(j[6], var2 + var4 - (var6 << 1), var3 + var5 - var7, 0);
      var1.drawImage(j[7], var2 + var4 - var6, var3 + var5 - var7, 0);
      var1.setColor(t);
      var1.fillRect(var2 + 10, var3 + 10, var4 - 20, var5 - 20);
   }

   public final void f(Graphics var1, int var2, int var3, int var4, int var5) {
      if (AvMain.hd == 1) {
         var1.setColor(s);
         var1.fillRect(0, var3 + 1, var4, var5 - var3 + 1);
      } else {
         var1.setColor(s);
         var1.fillRect(0, var3 + 1, var4, var5 - var3 + 2);
      }
   }

   public final void g(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(r);
      var1.fillRect(2, var3, var4, var5);
   }

   public final void c(Graphics var1) {
      var1.setColor(s);
      var1.fillRect(0, Canvas.q - Canvas.T + 1, Canvas.m, Canvas.T);
      var1.setColor(u);
      var1.fillRect(0, Canvas.q - Canvas.T, Canvas.m, 1);
   }

   public final void a(Command var1, Command var2, Command var3) {
      // $FF: Couldn't be decompiled
   }

   private static int b(Command var0, Command var1, Command var2) {
      if (var0 != null && !var0.a.equals("") && Canvas.a(0, Canvas.q - Canvas.T, 95, Canvas.T)) {
         return 1;
      } else if (var1 != null && !var1.a.equals("") && Canvas.a(Canvas.m / 2 - 43 - 8, Canvas.q - Canvas.T, 95, Canvas.T)) {
         return 2;
      } else {
         return var2 != null && !var2.a.equals("") && Canvas.a(Canvas.m - 87 - 8, Canvas.q - Canvas.T, 95, Canvas.T) ? 3 : 0;
      }
   }

   public final void a(Graphics var1, Vector var2, int var3, int var4) {
      Canvas.resetTrans(var1);
      var1.translate(0, Canvas.y.e);
      var1.translate(0, -CameraList.i);
      int var6 = (var3 - AvMain.ag) / 2;
      int var7;
      if ((var7 = CameraList.i / var3 - 2) < 0) {
         var7 = 0;
      }

      int var8;
      if ((var8 = var7 + (Canvas.n - 40) / var3 + 3) > var2.size()) {
         var8 = var2.size();
      }

      int var5 = 4 + var7 * var3;

      for(var7 = var7; var7 < var8; ++var7) {
         RoomInfo var9 = (RoomInfo)var2.elementAt(var7);
         if (var7 == var4 && var9.a != -1) {
            Canvas.S.g(var1, 2, var5, Canvas.m - 4, var3);
         }

         if (var9.a == -1) {
            Canvas.L.a(var1, T1.ex[var9.c], 15, var5 + 8 + (Canvas.Z == 0 ? -4 : 0), 0);
            Canvas.S.f(var1, 0, var5 + 25, Canvas.m, var5 + 25);
         } else {
            k.drawFrame(0, 22, var5 + var3 / 2 + 1, 0, 3, var1);
            Canvas.M.a(var1, T1.V + var9.a, 50, var5 + var6, 0);
            if (var9.b >= 0 && var9.b <= 2) {
               RoomListOnScr.b.drawFrame(var9.b, Canvas.m - 20, var5 + var3 / 2, 0, 3, var1);
            }
         }

         var5 += var3;
      }

   }

   public final void h(Graphics var1, int var2, int var3, int var4, int var5) {
      l.a(0, var2, var3, 0, var1);
      l.a(1, var2 + var4 - 10, var3, 0, var1);
      l.a(2, var2, var3 + var5 - 10, 0, var1);
      l.a(3, var2 + var4 - 10, var3 + var5 - 10, 0, var1);
      var1.setColor(29555);
      var1.fillRect(var2 + 10, var3 + 1, var4 - 20, var5 - 2);
      var1.fillRect(var2 + 1, var3 + 10, 9, var5 - 20);
      var1.fillRect(var2 + var4 - 10, var3 + 10, 9, var5 - 20);
      var1.setColor(16777215);
      var1.fillRect(var2 + 10, var3, var4 - 20, 1);
      var1.fillRect(var2 + 10, var3 + var5 - 1, var4 - 20, 1);
      var1.fillRect(var2, var3 + 10, 1, var5 - 20);
      var1.fillRect(var2 + var4 - 1, var3 + 10, 1, var5 - 20);
   }
}

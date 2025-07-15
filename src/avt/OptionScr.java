package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class OptionScr extends MyScreen {
   public static OptionScr a;
   private int f = 0;
   private int g = 0;
   private int h = 5;
   public int[] b;
   public int c = 0;
   private int i;
   private int j;
   private MyScreen k;
   public static boolean d = false;
   public static boolean e = false;
   private boolean[] l;

   public static OptionScr gI() {
      if (a == null) {
         a = new OptionScr();
      }

      return a;
   }

   public final void switchToMe() {
      this.e();
      this.k = Canvas.currentMyScreen;
      super.switchToMe();
      this.f();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.b(this.c);
            this.k.switchToMe();
         default:
      }
   }

   public OptionScr() {
      this.l = new boolean[this.h];
   }

   public final void e() {
      super.left = new Command(T.aV, 0);
      this.j = MyScreen.av;
      this.i = Canvas.h;
      int var1 = PaintPopup.o + (AvMain.hDuBox << 1);
      if (this.l != null) {
         int var2;
         for(var2 = 0; var2 < this.l.length; ++var2) {
            if (this.l[var2]) {
               var1 += this.j;
            }
         }

         var2 = 176;
         if (Canvas.w < 176) {
            var2 = Canvas.w;
         }

         PaintPopup.gI().a(T.ab, var2 * AvMain.hd, var1, 1);
         if (Canvas.currentMyScreen != this) {
            for(var1 = 0; var1 < 3; ++var1) {
               this.l[var1] = true;
            }

            if (Canvas.E) {
               this.l[3] = true;
            }

            this.b = new int[this.h];
         }
      }

   }

   public final void b(int var1) {
      this.c = var1;
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      DataOutputStream var3 = new DataOutputStream(var2);

      try {
         var3.writeByte(var1);

         for(int var4 = 0; var4 < this.h; ++var4) {
            var3.writeByte(this.b[var4]);
         }
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      try {
         CRes.saveRMS("avatarShowName", var2.toByteArray());
         var3.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      this.g();
      SoundManager.a.a(var1 / 10);
   }

   public final void f() {
      this.e();
      DataInputStream var1 = AvatarData.loadRMS("avatarShowName");
      d = false;
      if (var1 != null) {
         try {
            this.c = var1.readByte();
            this.b = new int[this.h];

            for(int var2 = 0; var2 < this.h; ++var2) {
               this.b[var2] = var1.readByte();
               if (this.b[var2] > 1) {
                  this.b[var2] = 0;
               }
            }

            var1.close();
         } catch (Exception var3) {
            AvatarData.delErrorRms("avatarShowName");
         }

         this.g();
         SoundManager.a.a(this.c / 10);
      }
   }

   private void g() {
      if (Canvas.E) {
         e = this.b[3] == 1;
      }

      Canvas.a();
   }

   public final void updateKey() {
      super.updateKey();
      if (Canvas.a(2)) {
         this.c(-1);
      } else if (Canvas.a(8)) {
         this.c(1);
      } else if (Canvas.a(4)) {
         this.e(-1);
      } else if (Canvas.a(6)) {
         this.e(1);
      }

      if (Canvas.isPointerClick && Canvas.isPointer(PaintPopup.gI().g, PaintPopup.gI().h, PaintPopup.gI().f, PaintPopup.gI().e)) {
         Canvas.isPointerClick = false;
         if (Canvas.isPointer(PaintPopup.gI().g, PaintPopup.gI().h, PaintPopup.gI().f, PaintPopup.gI().e)) {
            int var1;
            for(int var2 = var1 = (Canvas.py - (PaintPopup.gI().h + PaintPopup.o + AvMain.hDuBox)) / this.j; var2 >= 0; --var2) {
               if (!this.l[var2]) {
                  ++var1;
               }
            }

            if (var1 == this.g) {
               if (this.b[this.g] == 1) {
                  this.e(-1);
               } else {
                  this.e(1);
               }
            }

            if (var1 >= this.h) {
               var1 = this.h - 1;
            }

            this.g = var1;
         }
      }

   }

   private void c(int var1) {
      while(true) {
         this.g += var1;
         if (this.g < 0) {
            this.g = this.h - 1;
         }

         if (this.g >= this.h) {
            this.g = 0;
         }

         if (this.l[this.g]) {
            return;
         }

         var1 /= CRes.abs(var1);
      }
   }

   private void e(int var1) {
      if (this.g == 2) {
         this.c += var1 * 10;
         if (this.c < 0) {
            this.c = 100;
         }

         if (this.c > 100) {
            this.c = 0;
            return;
         }
      } else {
         if (this.b[this.g] == 0) {
            this.b[this.g] = 1;
            return;
         }

         this.b[this.g] = 0;
      }

   }

   public final void update() {
      this.k.update();
      if (this.i != 0) {
         this.i += -this.i >> 1;
         if (this.i < 0) {
            this.i = 0;
         }
      }

   }

   public final void paint(Graphics var1) {
      this.k.paintMain(var1);
      this.paintMain(var1);
      super.paint(var1);
   }

   public final void paintMain(Graphics var1) {
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      var1.translate(0, this.i);
      PaintPopup.gI().a(var1);
      var1.translate(Canvas.hw - 65, PaintPopup.gI().h + PaintPopup.o + AvMain.hDuBox);
      if (this.f >= 4) {
         this.f = 0;
      }

      int var3 = -AvMain.ah / 2 + this.j / 2;
      int var4 = 0;

      for(int var5 = 0; var5 < this.h; ++var5) {
         if (this.l[var5]) {
            Canvas.normalFont.drawString(var1, T.eG[var5][2], -50 * (AvMain.hd - 1), var4 + var3, 0);
            Canvas.normalFont.drawString(var1, T.eG[var5][this.b[var5]], 52 + 50 * AvMain.hd, var4 + var3 - 1, 2);
            byte var2 = 0;
            int var6;
            if ((var6 = Canvas.normalFont.getWidth(T.eG[var5][this.b[var5]]) + 10 + 15 * (Canvas.stypeInt + 1) + PaintPopup.b.frameWidth) < 25 * AvMain.hd) {
               var6 = 25 * AvMain.hd;
            }

            if (var5 == this.g) {
               var2 = 1;
            }

            int var7 = var4 + var3 + AvMain.ah / 2 - PaintPopup.b.frameHeight / 2;
            PaintPopup.b.drawFrame(var2, 52 + 50 * AvMain.hd - var6 / 2, var7, 0, var1);
            PaintPopup.b.drawFrame(var2, 52 + 50 * AvMain.hd + var6 / 2 - PaintPopup.b.frameWidth, var7, 2, var1);
            var4 += this.j;
         }
      }

      Canvas.normalFont.drawString(var1, String.valueOf(this.c), 52 + 50 * AvMain.hd, 2 * this.j + var3, 2);
      ++this.f;
   }
}

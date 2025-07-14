package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

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

   public static OptionScr b() {
      if (a == null) {
         a = new OptionScr();
      }

      return a;
   }

   public final void a() {
      this.e();
      this.k = GameCanvas.r;
      super.a();
      this.f();
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.b(this.c);
            this.k.a();
         default:
      }
   }

   public OptionScr() {
      this.l = new boolean[this.h];
   }

   public final void e() {
      super.ac = new Command(T1.aV, 0);
      this.j = MyScreen.av;
      this.i = GameCanvas.n;
      int var1 = PaintPopup.o + (AvMain.Z << 1);
      if (this.l != null) {
         int var2;
         for(var2 = 0; var2 < this.l.length; ++var2) {
            if (this.l[var2]) {
               var1 += this.j;
            }
         }

         var2 = 176;
         if (GameCanvas.m < 176) {
            var2 = GameCanvas.m;
         }

         PaintPopup.a().a(T1.ab, var2 * AvMain.Y, var1, 1);
         if (GameCanvas.r != this) {
            for(var1 = 0; var1 < 3; ++var1) {
               this.l[var1] = true;
            }

            if (GameCanvas.E) {
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
         CRes.a("avatarShowName", var2.toByteArray());
         var3.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      this.g();
      SoundManager.a.a(var1 / 10);
   }

   public final void f() {
      this.e();
      DataInputStream var1 = AvatarData.a("avatarShowName");
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
            AvatarData.b("avatarShowName");
         }

         this.g();
         SoundManager.a.a(this.c / 10);
      }
   }

   private void g() {
      if (GameCanvas.E) {
         e = this.b[3] == 1;
      }

      GameCanvas.a();
   }

   public final void l() {
      super.l();
      if (GameCanvas.a(2)) {
         this.c(-1);
      } else if (GameCanvas.a(8)) {
         this.c(1);
      } else if (GameCanvas.a(4)) {
         this.e(-1);
      } else if (GameCanvas.a(6)) {
         this.e(1);
      }

      if (GameCanvas.g && GameCanvas.a(PaintPopup.a().g, PaintPopup.a().h, PaintPopup.a().f, PaintPopup.a().e)) {
         GameCanvas.g = false;
         if (GameCanvas.a(PaintPopup.a().g, PaintPopup.a().h, PaintPopup.a().f, PaintPopup.a().e)) {
            int var1;
            for(int var2 = var1 = (GameCanvas.i - (PaintPopup.a().h + PaintPopup.o + AvMain.Z)) / this.j; var2 >= 0; --var2) {
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

         var1 /= CRes.f(var1);
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

   public final void k() {
      this.k.k();
      if (this.i != 0) {
         this.i += -this.i >> 1;
         if (this.i < 0) {
            this.i = 0;
         }
      }

   }

   public final void a(Graphics var1) {
      this.k.b(var1);
      this.b(var1);
      super.a(var1);
   }

   public final void b(Graphics var1) {
      var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
      var1.translate(0, this.i);
      PaintPopup.a().a(var1);
      var1.translate(GameCanvas.o - 65, PaintPopup.a().h + PaintPopup.o + AvMain.Z);
      if (this.f >= 4) {
         this.f = 0;
      }

      int var3 = -AvMain.ah / 2 + this.j / 2;
      int var4 = 0;

      for(int var5 = 0; var5 < this.h; ++var5) {
         if (this.l[var5]) {
            GameCanvas.K.a(var1, T1.eG[var5][2], -50 * (AvMain.Y - 1), var4 + var3, 0);
            GameCanvas.K.a(var1, T1.eG[var5][this.b[var5]], 52 + 50 * AvMain.Y, var4 + var3 - 1, 2);
            byte var2 = 0;
            int var6;
            if ((var6 = GameCanvas.K.a(T1.eG[var5][this.b[var5]]) + 10 + 15 * (GameCanvas.Z + 1) + PaintPopup.b.a) < 25 * AvMain.Y) {
               var6 = 25 * AvMain.Y;
            }

            if (var5 == this.g) {
               var2 = 1;
            }

            int var7 = var4 + var3 + AvMain.ah / 2 - PaintPopup.b.b / 2;
            PaintPopup.b.a(var2, 52 + 50 * AvMain.Y - var6 / 2, var7, 0, var1);
            PaintPopup.b.a(var2, 52 + 50 * AvMain.Y + var6 / 2 - PaintPopup.b.a, var7, 2, var1);
            var4 += this.j;
         }
      }

      GameCanvas.K.a(var1, String.valueOf(this.c), 52 + 50 * AvMain.Y, 2 * this.j + var3, 2);
      ++this.f;
   }
}

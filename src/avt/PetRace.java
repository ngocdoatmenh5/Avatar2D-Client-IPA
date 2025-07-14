package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class PetRace extends Base {
   public byte a;
   public byte b;
   private byte h = 10;
   private byte i = -1;
   private byte j = -1;
   private byte k;
   private byte l = 6;
   public short c;
   public short d;
   public short[] e;
   public short[] f;
   public int g;
   private int m = 0;

   public PetRace(class_jz var1) {
   }

   public final void b() {
      ++this.k;
      if (this.k >= 10) {
         this.k = 0;
      }

      if (this.l < 9) {
         ++this.l;
      }

      ++this.m;
      if (this.m >= 6) {
         this.m = 0;
      }

      ++super.y;
      if (super.y == 12) {
         super.y = 0;
      }

      if (super.aw < (LoadMap.e + 1) * LoadMap.i) {
         if (this.e != null && this.b < this.e.length && RaceScr.b().e <= 0) {
            super.aw += this.f[this.b];
            if (this.f[this.b] == 0) {
               super.H = 2;
            } else {
               super.H = 1;
            }

            --this.e[this.b];
            if (this.e[this.b] <= 0) {
               ++this.b;
               if (this.b < this.f.length) {
                  if (this.l == 9 && this.f[this.b] == 0) {
                     this.l = 0;
                  } else if (this.i == -1 && this.f[this.b] == 2) {
                     this.i = 20;
                  } else if (this.j == -1 && this.f[this.b] == 5) {
                     this.j = 20;
                  }
               }
            }
         } else {
            super.H = 0;
            if (this.f != null && RaceScr.b().e <= 0) {
               super.aw += this.f[this.f.length - 1];
            }

            if (this.h == 10 && this.e != null && this.b >= this.e.length) {
               RaceScr var10001 = RaceScr.b();
               byte var10003 = var10001.f;
               var10001.f = (byte)(var10003 + 1);
               this.h = var10003;
            }
         }

         if (this.i >= 0) {
            --this.i;
         }

         if (this.j >= 0) {
            --this.j;
         }
      }

   }

   public final void a(Graphics var1) {
      ImageIcon var2;
      if ((var2 = AvatarData.c(this.c)).d != -1) {
         int var3 = var2.c / 5;
         var1.drawRegion(var2.a, 0, RaceScr.m[super.H][super.y] * var3, var2.b, var3, 0, super.aw * MyObject.ay, super.ax * MyObject.ay, 33);
         if (RaceScr.b().d && this.g > 0) {
            GameCanvas.M.a(var1, "" + this.g, super.aw * MyObject.ay - var2.b / 2 - 8 * MyObject.ay, super.ax * MyObject.ay - AvMain.af / 2 - 3 * MyObject.ay, 1);
         }

         if (this.i >= 0) {
            var1.drawImage(RaceScr.h, super.aw * MyObject.ay + var2.b / 2, super.ax * MyObject.ay - var3, 33);
         }

         if (this.l < 9) {
            var1.drawImage(RaceScr.k[this.l / 3], super.aw * MyObject.ay, super.ax * MyObject.ay, 3);
         }

         if (this.j >= 0) {
            var1.drawImage(RaceScr.i, super.aw * MyObject.ay + var2.b / 2, super.ax * MyObject.ay - var3, 33);
            var1.drawImage(RaceScr.j[this.k / 2], super.aw * MyObject.ay - var2.b / 2, super.ax * MyObject.ay, 3);
         }

         if (super.w == AvCamera.a().h.w) {
            var1.drawImage(MapScr.d, super.aw * MyObject.ay, super.ax * MyObject.ay - var3 - this.m / 2 - 10 * MyObject.ay, 3);
         }
      }

   }
}

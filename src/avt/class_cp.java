package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class class_cp {
   private String a = "";
   private int b;
   private int c;
   private int d;
   private int e;
   private boolean f = false;
   private Image g;
   private byte h;
   private byte i = -1;
   private short j = -1;
   private short k = -1;

   public class_cp(int var1, int var2, int var3, int var4, Image var5, int var6, int var7, int var8) {
      this.e = var6;
      this.h = (byte)var4;
      this.b = var1;
      this.c = var2;
      if (var3 > 0) {
         this.a = "+";
      }

      this.a = this.a + var3;
      if (var3 == 0) {
         this.a = "";
      }

      this.g = var5;
      this.f = false;
      this.i = -1;
      this.j = (short)var7;
      this.k = (short)var8;
   }

   public class_cp(int var1, int var2, String var3, int var4, int var5, int var6) {
      this.e = var6;
      this.h = (byte)var4;
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.d = 0;
      this.f = true;
      this.i = (byte)var5;
      this.j = -1;
      this.k = -1;
   }

   public final void a() {
      if (this.e > 0) {
         --this.e;
      } else {
         ++this.d;
         if (this.d > 40) {
            this.g = null;
            Canvas.ac.removeElement(this);
         }

         if (this.d < 3) {
            this.c += -2 * this.h;
         } else {
            this.c += this.h;
         }
      }
   }

   public final void a(Graphics var1) {
      if (Canvas.currentMyScreen == RaceScr.a) {
         Canvas.resetTrans(var1);
      }

      if (this.e <= 0) {
         int var2 = AvMain.hd;
         if (Canvas.currentMyScreen == BoardScr.me && (BoardScr.j || BoardScr.k) || Canvas.currentMyScreen == RaceScr.a) {
            var2 = 1;
         }

         FontX var3 = Canvas.O;
         if (this.f) {
            if (this.i == 0) {
               var3 = Canvas.smallFontRed;
            } else {
               byte var10000 = this.i;
               boolean var10001 = true;
               var3 = Canvas.L;
            }
         }

         var3.a(var1, this.a, this.b * var2, this.c * var2, 2);
         if (this.g == null) {
            if (this.j != -1) {
               FarmData.a(var1, this.j, this.b * var2, (this.c - 5) * var2, 33);
               return;
            }

            if (this.k != -1) {
               AvatarData.a(var1, this.k, this.b * var2, (this.c - 5) * var2, 33);
               return;
            }
         } else if (!this.f) {
            var1.drawImage(this.g, this.b * var2, this.c * var2, 33);
         }

      }
   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class CellFarm extends SubObject {
   public int a;
   public int b;
   public int c;
   public short d;
   public short e = -1;
   public long h;
   public boolean i;
   public boolean j;
   public boolean k;
   public boolean l = false;
   public byte m;
   public byte n;
   public byte o;
   public byte p;
   public int q;

   public final void a(Graphics var1) {
      if (super.aw * MyObject.ay >= AvCamera.a().a - 10 && this.a * MyObject.ay <= AvCamera.a().a + GameCanvas.m + 10) {
         if (this.l) {
            var1.drawImage(FarmScr.o, (super.aw - 13) * MyObject.ay, (super.ax - 18) * MyObject.ay, 0);
         }

         int var2 = FarmScr.A.a;
         int var3 = FarmScr.A.b;
         if (this.a == var2 && this.b == var3) {
            GameCanvas.Q.a(var1, "lv" + this.p, super.aw * MyObject.ay, (super.ax - 44) * MyObject.ay, 2);
         }

         if (this.c != -1) {
            TreeInfo var4;
            (var4 = FarmData.b(this.c)).a(var1, this.q, super.aw * MyObject.ay, super.ax * MyObject.ay, 33);
            int var5 = var4.e * 60 + var4.f * 60;
            if ((this.d <= var5 || var4.f == -1) && this.m != 100 && this.d >= 0) {
               if (this.k) {
                  var1.drawImage(FarmScr.k[1], (super.aw + 5) * MyObject.ay, (super.ax - 12) * MyObject.ay, 3);
               }

               if (this.j) {
                  var1.drawImage(FarmScr.k[0], (super.aw - 7) * MyObject.ay, super.ax * MyObject.ay, 3);
               }

               if (this.a == var2 && this.b == var3 || this.e != -1 && this.e == FarmScr.H) {
                  var2 = var2 * 24 * MyObject.ay;
                  var3 = var3 * 24 * MyObject.ay;
                  if (this.e != -1 && this.e == FarmScr.H) {
                     var2 = this.a * 24 * MyObject.ay;
                     var3 = this.b * 24 * MyObject.ay;
                  }

                  var4.a(var1, 7, var2 - 3, var3 - 40 * MyObject.ay, 33);
                  var1.setColor(1);
                  var1.fillRect(var2 - 4 * MyObject.ay, var3 - 38 * MyObject.ay, 31 * MyObject.ay, 5 * MyObject.ay);
                  var1.setColor(65280);
                  var1.fillRect(var2 - 3 * MyObject.ay, var3 - 37 * MyObject.ay, this.n * 30 / 100 * MyObject.ay, 3 * MyObject.ay);
                  var1.setColor(2512938);
                  var1.drawRect(var2 - 4 * MyObject.ay, var3 - 38 * MyObject.ay, 31 * MyObject.ay, 4 * MyObject.ay);
                  long var8 = (long)(var4.e * 60 * 60) - this.h;
                  long var10 = (long)(var4.e * 60 - this.d);
                  String var20 = "";
                  if (var8 < 0L) {
                     var8 = 0L;
                  }

                  long var13 = var8 / 60L / 60L;
                  long var15 = var8 / 60L % 60L;
                  long var17 = var8 % 60L;
                  var20 = var20 + var13 + ":" + var15 + ":" + var17;
                  if (var10 <= 0L || var8 <= 0L) {
                     var20 = T1.cn;
                  }

                  GameCanvas.Q.a(var1, var20, var2 + 5 * MyObject.ay, var3 - 49 * MyObject.ay, 0);
                  if ((var5 = this.d * 100 / (var4.e * 60) * 30 / 100) == 0) {
                     var5 = 1;
                  }

                  if (var5 >= 30) {
                     var5 = 29;
                  }

                  if (var4.e * 60 - this.d < 0) {
                     var5 = 30;
                  }

                  var1.setColor(1);
                  var1.fillRect(var2 - 4 * MyObject.ay, var3 - 32 * MyObject.ay, 31 * MyObject.ay, 5 * MyObject.ay);
                  var1.setColor(255, 255, 0);
                  var1.fillRect(var2 - 3 * MyObject.ay, var3 - 31 * MyObject.ay, var5 * MyObject.ay, 3 * MyObject.ay);
                  var1.setColor(2512938);
                  var1.drawRect(var2 - 4 * MyObject.ay, var3 - 32 * MyObject.ay, 31 * MyObject.ay, 4 * MyObject.ay);
                  byte var19 = 0;
                  if (this.k) {
                     var19 = 1;
                     FarmScr.q.a(1, var2 + (5 + (this.j ? 6 : 0)) * MyObject.ay, var3 - 22 * MyObject.ay, 0, var1);
                  }

                  if (this.j) {
                     FarmScr.q.a(0, var2 + (4 - var19 * 6) * MyObject.ay, var3 - 22 * MyObject.ay, 0, var1);
                  }
               }

            }
         }
      }
   }
}

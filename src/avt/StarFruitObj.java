package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class StarFruitObj extends SubObject {
   public short a;
   public short b;
   public short c;
   public short d;
   public int e;
   private int k = 0;
   private int l = 0;
   public long h;
   public byte[] i;
   public byte[] j;

   public final void b() {
      if (System.currentTimeMillis() - this.h >= 1000L) {
         if (this.e > 0) {
            --this.e;
            if (this.e == 0) {
               FarmService var1;
               (var1 = FarmService.a()).e((byte)83);
               var1.k();
            }
         }

         this.h = System.currentTimeMillis();
         ImageIcon var4;
         if ((var4 = FarmData.a(this.b)).b > 0 && this.k == 0) {
            this.k = var4.b / 3 << 1;
            this.l = var4.c / 2;
            StarFruitObj var5 = this;
            if (this.d > 0) {
               int var2 = CRes.e(3) + 3;
               this.i = new byte[var2];
               this.j = new byte[var2];

               for(int var3 = 0; var3 < var2; ++var3) {
                  var5.i[var3] = (byte)(CRes.e(var5.k - 10) - (var5.k - 10) / 2);
                  var5.j[var3] = (byte)(CRes.e(var5.l - 10) - (var5.l - 10) / 2);
               }
            }
         }
      }

   }

   public final void a(Graphics var1) {
      if (super.f >= 0 || super.aw * MyObject.ay + this.k / 2 >= AvCamera.a().a && super.aw * MyObject.ay - this.k / 2 <= AvCamera.a().a + GameCanvas.m) {
         FarmData.a(var1, this.b, super.aw * MyObject.ay, super.ax * MyObject.ay, 33);
         int var2;
         if (this.d > 0 && this.i != null) {
            for(var2 = 0; var2 < this.i.length; ++var2) {
               FarmData.a(var1, this.c, super.aw * MyObject.ay + this.i[var2], super.ax * MyObject.ay - (FarmData.a(this.b).c / 2 + 5) + this.j[var2], 3);
            }
         }

         var2 = FarmData.a(this.b).c + AvMain.ag;
         if (this.e > 0) {
            var2 += AvMain.ai;
         }

         FarmData.a(var1, this.c, (super.aw - 8) * MyObject.ay, super.ax * MyObject.ay - var2, 3);
         GameCanvas.L.a(var1, "Lv" + this.a, super.aw * MyObject.ay, super.ax * MyObject.ay - var2 - AvMain.ag / 2, 0);
         if (this.e > 0) {
            int var3 = this.e / 3600;
            int var4 = (this.e - var3 * 3600) / 60;
            int var5 = this.e - var3 * 3600 - var4 * 60;
            GameCanvas.Q.a(var1, var3 + ":" + var4 + ":" + var5, (super.aw + 3) * MyObject.ay, super.ax * MyObject.ay - var2 + GameCanvas.L.a() / 2 + 2 * MyObject.ay, 2);
         }

      }
   }
}

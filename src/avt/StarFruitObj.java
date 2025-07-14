package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

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

   public final void update() {
      if (System.currentTimeMillis() - this.h >= 1000L) {
         if (this.e > 0) {
            --this.e;
            if (this.e == 0) {
               FarmService var1;
               (var1 = FarmService.a()).createMessage((byte)83);
               var1.sendMessage();
            }
         }

         this.h = System.currentTimeMillis();
         ImageIcon var4;
         if ((var4 = FarmData.a(this.b)).b > 0 && this.k == 0) {
            this.k = var4.b / 3 << 1;
            this.l = var4.c / 2;
            StarFruitObj var5 = this;
            if (this.d > 0) {
               int var2 = CRes.rnd(3) + 3;
               this.i = new byte[var2];
               this.j = new byte[var2];

               for(int var3 = 0; var3 < var2; ++var3) {
                  var5.i[var3] = (byte)(CRes.rnd(var5.k - 10) - (var5.k - 10) / 2);
                  var5.j[var3] = (byte)(CRes.rnd(var5.l - 10) - (var5.l - 10) / 2);
               }
            }
         }
      }

   }

   public final void paint(Graphics var1) {
      if (super.type >= 0 || super.x * MyObject.hd + this.k / 2 >= AvCamera.gI().xCam && super.x * MyObject.hd - this.k / 2 <= AvCamera.gI().xCam + Canvas.w) {
         FarmData.a(var1, this.b, super.x * MyObject.hd, super.y * MyObject.hd, 33);
         int var2;
         if (this.d > 0 && this.i != null) {
            for(var2 = 0; var2 < this.i.length; ++var2) {
               FarmData.a(var1, this.c, super.x * MyObject.hd + this.i[var2], super.y * MyObject.hd - (FarmData.a(this.b).c / 2 + 5) + this.j[var2], 3);
            }
         }

         var2 = FarmData.a(this.b).c + AvMain.ag;
         if (this.e > 0) {
            var2 += AvMain.ai;
         }

         FarmData.a(var1, this.c, (super.x - 8) * MyObject.hd, super.y * MyObject.hd - var2, 3);
         Canvas.L.a(var1, "Lv" + this.a, super.x * MyObject.hd, super.y * MyObject.hd - var2 - AvMain.ag / 2, 0);
         if (this.e > 0) {
            int var3 = this.e / 3600;
            int var4 = (this.e - var3 * 3600) / 60;
            int var5 = this.e - var3 * 3600 - var4 * 60;
            Canvas.smallFontYellow.a(var1, var3 + ":" + var4 + ":" + var5, (super.x + 3) * MyObject.hd, super.y * MyObject.hd - var2 + Canvas.L.a() / 2 + 2 * MyObject.hd, 2);
         }

      }
   }
}

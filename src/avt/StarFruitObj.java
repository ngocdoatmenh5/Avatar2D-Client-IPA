package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class StarFruitObj extends SubObject {
   public short lv;
   public short b;
   public short fruitID;
   public short numberFruit;
   public int timeFinish;
   private int k = 0;
   private int l = 0;
   public long h;
   public byte[] xFruit;
   public byte[] yFruit;

   public final void update() {
      if (System.currentTimeMillis() - this.h >= 1000L) {
         if (this.timeFinish > 0) {
            --this.timeFinish;
            if (this.timeFinish == 0) {
               FarmService var1;
               (var1 = FarmService.gI()).createMessage((byte)83);
               var1.sendMessage();
            }
         }

         this.h = System.currentTimeMillis();
         ImageIcon var4;
         if ((var4 = FarmData.getImgIcon(this.b)).b > 0 && this.k == 0) {
            this.k = var4.b / 3 << 1;
            this.l = var4.c / 2;
            StarFruitObj var5 = this;
            if (this.numberFruit > 0) {
               int var2 = CRes.rnd(3) + 3;
               this.xFruit = new byte[var2];
               this.yFruit = new byte[var2];

               for(int var3 = 0; var3 < var2; ++var3) {
                  var5.xFruit[var3] = (byte)(CRes.rnd(var5.k - 10) - (var5.k - 10) / 2);
                  var5.yFruit[var3] = (byte)(CRes.rnd(var5.l - 10) - (var5.l - 10) / 2);
               }
            }
         }
      }

   }

   public final void paint(Graphics var1) {
      if (super.type >= 0 || super.x * MyObject.hd + this.k / 2 >= AvCamera.gI().xCam && super.x * MyObject.hd - this.k / 2 <= AvCamera.gI().xCam + Canvas.w) {
         FarmData.paintImg(var1, this.b, super.x * MyObject.hd, super.y * MyObject.hd, 33);
         int var2;
         if (this.numberFruit > 0 && this.xFruit != null) {
            for(var2 = 0; var2 < this.xFruit.length; ++var2) {
               FarmData.paintImg(var1, this.fruitID, super.x * MyObject.hd + this.xFruit[var2], super.y * MyObject.hd - (FarmData.getImgIcon(this.b).c / 2 + 5) + this.yFruit[var2], 3);
            }
         }

         var2 = FarmData.getImgIcon(this.b).c + AvMain.ag;
         if (this.timeFinish > 0) {
            var2 += AvMain.ai;
         }

         FarmData.paintImg(var1, this.fruitID, (super.x - 8) * MyObject.hd, super.y * MyObject.hd - var2, 3);
         Canvas.borderFont.drawString(var1, "Lv" + this.lv, super.x * MyObject.hd, super.y * MyObject.hd - var2 - AvMain.ag / 2, 0);
         if (this.timeFinish > 0) {
            int var3 = this.timeFinish / 3600;
            int var4 = (this.timeFinish - var3 * 3600) / 60;
            int var5 = this.timeFinish - var3 * 3600 - var4 * 60;
            Canvas.smallFontYellow.drawString(var1, var3 + ":" + var4 + ":" + var5, (super.x + 3) * MyObject.hd, super.y * MyObject.hd - var2 + Canvas.borderFont.getHeight() / 2 + 2 * MyObject.hd, 2);
         }

      }
   }
}

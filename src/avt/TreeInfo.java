package avt;

import javax.microedition.lcdui.Graphics;

public final class TreeInfo {
   public String name;
   public short ID;
   public short[] idImg;
   public byte[] Phase;
   public short harvestTime;
   public short dieTime = -1;
   public short[] priceSeed = new short[2];
   public short priceProduct;
   public short numProduct;
   public short j;
   public String name1;
   public boolean l = false;
   public byte m = 1;

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      if (this.l) {
         FarmData.paintImg(var1, this.idImg[var2], var3, var4, var5);
      } else {
         ImageInfo var10000 = FarmData.listImgInfo[this.idImg[var2]];
         Graphics var7 = var1;
         ImageInfo var6 = var10000;
         var7.drawRegion(FarmData.imgBig[var6.bigID], var6.x0 * AvMain.hd, var6.y0 * AvMain.hd, var6.w * AvMain.hd, var6.h * AvMain.hd, 0, var3, var4, var5);
      }
   }
}

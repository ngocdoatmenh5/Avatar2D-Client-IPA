package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class EffectData {
   public byte[] arrFrame;
   public ImageInfo[] imgImfo;
   public Image img;
   public Frame[] frame;
   public short ID;

   public final void paint(Graphics var1, int var2, int var3, int var4) {
      Frame var9 = this.frame[this.arrFrame[var4]];

      for(int var5 = 0; var5 < var9.dx.length; ++var5) {
         byte var7 = var9.idImg[var5];
         EffectData var6 = this;

         ImageInfo var10000;
         label23: {
            for(int var8 = 0; var8 < var6.imgImfo.length; ++var8) {
               if (var6.imgImfo[var8].ID == var7) {
                  var10000 = var6.imgImfo[var8];
                  break label23;
               }
            }

            var10000 = null;
         }

         ImageInfo var10 = var10000;
         var1.drawRegion(this.img, var10.x0 * AvMain.hd, var10.y0 * AvMain.hd, var10.w * AvMain.hd, var10.h * AvMain.hd, 0, var2 * AvMain.hd + var9.dx[var5] * AvMain.hd, var3 * AvMain.hd + var9.dy[var5] * AvMain.hd, 0);
      }

   }
}

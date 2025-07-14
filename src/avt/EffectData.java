package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class EffectData {
   public byte[] a;
   public ImageInfo[] b;
   public Image c;
   public Frame[] d;
   public short e;

   public final void a(Graphics var1, int var2, int var3, int var4) {
      Frame var9 = this.d[this.a[var4]];

      for(int var5 = 0; var5 < var9.b.length; ++var5) {
         byte var7 = var9.a[var5];
         EffectData var6 = this;

         ImageInfo var10000;
         label23: {
            for(int var8 = 0; var8 < var6.b.length; ++var8) {
               if (var6.b[var8].a == var7) {
                  var10000 = var6.b[var8];
                  break label23;
               }
            }

            var10000 = null;
         }

         ImageInfo var10 = var10000;
         var1.drawRegion(this.c, var10.c * AvMain.hd, var10.d * AvMain.hd, var10.e * AvMain.hd, var10.f * AvMain.hd, 0, var2 * AvMain.hd + var9.b[var5] * AvMain.hd, var3 * AvMain.hd + var9.c[var5] * AvMain.hd, 0);
      }

   }
}

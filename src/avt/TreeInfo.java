package avt;

import javax.microedition.lcdui.Graphics;

public final class TreeInfo {
   public String a;
   public short b;
   public short[] c;
   public byte[] d;
   public short e;
   public short f = -1;
   public short[] g = new short[2];
   public short h;
   public short i;
   public short j;
   public String k;
   public boolean l = false;
   public byte m = 1;

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      if (this.l) {
         FarmData.a(var1, this.c[var2], var3, var4, var5);
      } else {
         ImageInfo var10000 = FarmData.a[this.c[var2]];
         Graphics var7 = var1;
         ImageInfo var6 = var10000;
         var7.drawRegion(FarmData.c[var6.bigID], var6.x0 * AvMain.hd, var6.y0 * AvMain.hd, var6.w * AvMain.hd, var6.h * AvMain.hd, 0, var3, var4, var5);
      }
   }
}

package avt;

import javax.microedition.lcdui.Graphics;

public final class class_lb extends Part {
   public short a;

   public final void paintIcon(Graphics var1, int var2, int var3, int var4, int var5) {
      APartInfo var6 = (APartInfo)AvatarData.a(super.f);
      if (super.h == var6.c[0]) {
         ImageInfo var7 = AvatarData.a[var6.c[0]];
         int var10002 = var7.c * AvMain.Y;
         int var10003 = var7.d * AvMain.Y;
         int var10004 = var7.e * AvMain.Y;
         int var10005 = var7.f * AvMain.Y;
         var1.drawRegion(AvatarData.a((int)this.a).e, var10002, var10003, var10004, var10005, 0, var2, var3, var5);
      } else {
         var6.a(var1, var2, var3, var5);
      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4, int var5) {
      APartInfo var6 = (APartInfo)AvatarData.a(super.f);
      ImageInfo var7 = AvatarData.a[var6.c[var2]];
      AvatarData.a(var1, this.a, var7.c, var7.d, var7.e, var7.f, var3 + var6.d[var2] * AvMain.Y - (var5 == Base.J ? (var6.d[var2] * AvMain.Y << 1) + var7.e * AvMain.Y : 0), var4 + var6.e[var2] * AvMain.Y, var5, 0);
   }
}

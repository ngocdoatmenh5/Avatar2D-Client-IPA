package avt;

import javax.microedition.lcdui.Graphics;

public final class class_lb extends Part {
   public short a;

   public final void paintIcon(Graphics var1, int var2, int var3, int var4, int var5) {
      APartInfo var6 = (APartInfo)AvatarData.a(super.f);
      if (super.h == var6.imgID[0]) {
         ImageInfo var7 = AvatarData.listImgInfo[var6.imgID[0]];
         int var10002 = var7.c * AvMain.hd;
         int var10003 = var7.d * AvMain.hd;
         int var10004 = var7.e * AvMain.hd;
         int var10005 = var7.f * AvMain.hd;
         var1.drawRegion(AvatarData.a((int)this.a).e, var10002, var10003, var10004, var10005, 0, var2, var3, var5);
      } else {
         var6.a(var1, var2, var3, var5);
      }
   }

   public final void paintAvatar(Graphics var1, int var2, int var3, int var4, int var5) {
      APartInfo var6 = (APartInfo)AvatarData.a(super.f);
      ImageInfo var7 = AvatarData.listImgInfo[var6.imgID[var2]];
      AvatarData.a(var1, this.a, var7.c, var7.d, var7.e, var7.f, var3 + var6.dx[var2] * AvMain.hd - (var5 == Base.LEFT ? (var6.dx[var2] * AvMain.hd << 1) + var7.e * AvMain.hd : 0), var4 + var6.dy[var2] * AvMain.hd, var5, 0);
   }
}

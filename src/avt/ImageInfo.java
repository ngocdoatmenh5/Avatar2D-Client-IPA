package avt;

import javax.microedition.lcdui.Graphics;

public final class ImageInfo {
   public short a;
   public short b;
   public short c;
   public short d;
   public short e;
   public short f;

   public final void a(Graphics var1, int var2, int var3, int var4) {
      int var10002 = this.c * AvMain.Y;
      int var10003 = this.d * AvMain.Y;
      int var10004 = this.e * AvMain.Y;
      int var10005 = this.f * AvMain.Y;
      var1.drawRegion(AvatarData.a((int)this.b).e, var10002, var10003, var10004, var10005, 0, var2, var3, var4);
   }
}

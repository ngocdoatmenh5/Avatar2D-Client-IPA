package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class MapItem extends SubObject {
   public short a;
   public short b;
   public byte c;
   public boolean d = false;

   public MapItem() {
   }

   public MapItem(int var1, int var2, int var3, int var4, short var5) {
      super.f = (byte)var1;
      super.aw = var2;
      super.ax = var3;
      this.a = (short)var4;
      this.b = var5;
   }

   public final void a(Graphics var1) {
      MapItemType var2;
      if (this.d) {
         var2 = LoadMap.f(this.b);
      } else {
         var2 = AvatarData.b((int)this.b);
      }

      int var3;
      int var4;
      boolean var6;
      Graphics var8;
      Graphics var10001;
      int var10003;
      int var10004;
      if (!this.d && LoadMap.a != 68 && LoadMap.a != 69 && LoadMap.a != 70 && LoadMap.a != 110) {
         ImageInfo var10 = AvatarData.a[var2.b];
         if ((super.aw + var2.e + var10.e) * MyObject.ay >= AvCamera.a().a && (super.aw + var2.e - var10.e) * MyObject.ay <= AvCamera.a().a + GameCanvas.m && (super.ax + var10.f) * MyObject.ay >= AvCamera.a().b && (super.ax + var2.f - var10.f) * MyObject.ay <= AvCamera.a().b + GameCanvas.n) {
            ImageInfo var10000 = var10;
            var10001 = var1;
            int var10002 = (super.aw + var2.e) * MyObject.ay;
            var10003 = (super.ax + var2.f) * MyObject.ay;
            var6 = false;
            byte var11 = this.c;
            var4 = var10003;
            var3 = var10002;
            var8 = var10001;
            ImageInfo var7 = var10000;
            var10002 = var7.c * AvMain.Y;
            var10003 = var7.d * AvMain.Y;
            var10004 = var7.e * AvMain.Y;
            int var10005 = var7.f * AvMain.Y;
            var8.drawRegion(AvatarData.a((int)var7.b).e, var10002, var10003, var10004, var10005, var11, var3, var4, 0);
         }
      } else {
         var10001 = var1;
         var10003 = (super.aw + var2.e) * MyObject.ay;
         var10004 = (super.ax + var2.f) * MyObject.ay;
         var6 = false;
         int var5 = var10004;
         var4 = var10003;
         var3 = var2.b;
         var8 = var10001;
         ImageIcon var9 = AvatarData.c((short)var3);
         if (var4 + var9.b >= AvCamera.a().a && var4 <= AvCamera.a().a + GameCanvas.m && var5 + var9.c >= AvCamera.a().b && var5 <= AvCamera.a().b + GameCanvas.n) {
            if (var9.d != -1) {
               var8.drawRegion(var9.a, 0, 0, var9.b, var9.c, this.c, var4, var5, 0);
            }

         }
      }
   }

   public final void b() {
   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class MapItem extends SubObject {
   public short a;
   public short b;
   public byte c;
   public boolean d = false;

   public MapItem() {
   }

   public MapItem(int var1, int var2, int var3, int var4, short var5) {
      super.f = (byte)var1;
      super.x = var2;
      super.y = var3;
      this.a = (short)var4;
      this.b = var5;
   }

   public final void paint(Graphics var1) {
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
         ImageInfo var10 = AvatarData.listImgInfo[var2.b];
         if ((super.x + var2.e + var10.e) * MyObject.hd >= AvCamera.gI().xCam && (super.x + var2.e - var10.e) * MyObject.hd <= AvCamera.gI().xCam + Canvas.m && (super.y + var10.f) * MyObject.hd >= AvCamera.gI().yCam && (super.y + var2.f - var10.f) * MyObject.hd <= AvCamera.gI().yCam + Canvas.n) {
            ImageInfo var10000 = var10;
            var10001 = var1;
            int var10002 = (super.x + var2.e) * MyObject.hd;
            var10003 = (super.y + var2.f) * MyObject.hd;
            var6 = false;
            byte var11 = this.c;
            var4 = var10003;
            var3 = var10002;
            var8 = var10001;
            ImageInfo var7 = var10000;
            var10002 = var7.c * AvMain.hd;
            var10003 = var7.d * AvMain.hd;
            var10004 = var7.e * AvMain.hd;
            int var10005 = var7.f * AvMain.hd;
            var8.drawRegion(AvatarData.a((int)var7.b).e, var10002, var10003, var10004, var10005, var11, var3, var4, 0);
         }
      } else {
         var10001 = var1;
         var10003 = (super.x + var2.e) * MyObject.hd;
         var10004 = (super.y + var2.f) * MyObject.hd;
         var6 = false;
         int var5 = var10004;
         var4 = var10003;
         var3 = var2.b;
         var8 = var10001;
         ImageIcon var9 = AvatarData.c((short)var3);
         if (var4 + var9.b >= AvCamera.gI().xCam && var4 <= AvCamera.gI().xCam + Canvas.m && var5 + var9.c >= AvCamera.gI().yCam && var5 <= AvCamera.gI().yCam + Canvas.n) {
            if (var9.count != -1) {
               var8.drawRegion(var9.img, 0, 0, var9.b, var9.c, this.c, var4, var5, 0);
            }

         }
      }
   }

   public final void update() {
   }
}

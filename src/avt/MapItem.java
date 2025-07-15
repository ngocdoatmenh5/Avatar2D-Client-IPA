package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class MapItem extends SubObject {
   public short ID;
   public short typeID;
   public byte dir;
   public boolean isGetImg = false;

   public MapItem() {
   }

   public MapItem(int var1, int var2, int var3, int var4, short var5) {
      super.type = (byte)var1;
      super.x = var2;
      super.y = var3;
      this.ID = (short)var4;
      this.typeID = var5;
   }

   public final void paint(Graphics var1) {
      MapItemType var2;
      if (this.isGetImg) {
         var2 = LoadMap.getMapItemTypeByID(this.typeID);
      } else {
         var2 = AvatarData.getMapItemTypeByID((int)this.typeID);
      }

      int var3;
      int var4;
      boolean var6;
      Graphics var8;
      Graphics var10001;
      int var10003;
      int var10004;
      if (!this.isGetImg && LoadMap.TYPEMAP != 68 && LoadMap.TYPEMAP != 69 && LoadMap.TYPEMAP != 70 && LoadMap.TYPEMAP != 110) {
         ImageInfo var10 = AvatarData.listImgInfo[var2.imgID];
         if ((super.x + var2.dx + var10.w) * MyObject.hd >= AvCamera.gI().xCam && (super.x + var2.dx - var10.w) * MyObject.hd <= AvCamera.gI().xCam + Canvas.w && (super.y + var10.h) * MyObject.hd >= AvCamera.gI().yCam && (super.y + var2.dy - var10.h) * MyObject.hd <= AvCamera.gI().yCam + Canvas.h) {
            ImageInfo var10000 = var10;
            var10001 = var1;
            int var10002 = (super.x + var2.dx) * MyObject.hd;
            var10003 = (super.y + var2.dy) * MyObject.hd;
            var6 = false;
            byte var11 = this.dir;
            var4 = var10003;
            var3 = var10002;
            var8 = var10001;
            ImageInfo var7 = var10000;
            var10002 = var7.x0 * AvMain.hd;
            var10003 = var7.y0 * AvMain.hd;
            var10004 = var7.w * AvMain.hd;
            int var10005 = var7.h * AvMain.hd;
            var8.drawRegion(AvatarData.getBigImgInfo((int)var7.bigID).img, var10002, var10003, var10004, var10005, var11, var3, var4, 0);
         }
      } else {
         var10001 = var1;
         var10003 = (super.x + var2.dx) * MyObject.hd;
         var10004 = (super.y + var2.dy) * MyObject.hd;
         var6 = false;
         int var5 = var10004;
         var4 = var10003;
         var3 = var2.imgID;
         var8 = var10001;
         ImageIcon var9 = AvatarData.getImgIcon((short)var3);
         if (var4 + var9.w >= AvCamera.gI().xCam && var4 <= AvCamera.gI().xCam + Canvas.w && var5 + var9.h >= AvCamera.gI().yCam && var5 <= AvCamera.gI().yCam + Canvas.h) {
            if (var9.count != -1) {
               var8.drawRegion(var9.img, 0, 0, var9.w, var9.h, this.dir, var4, var5, 0);
            }

         }
      }
   }

   public final void update() {
   }
}

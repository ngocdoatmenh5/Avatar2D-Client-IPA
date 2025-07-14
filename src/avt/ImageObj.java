package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class ImageObj extends SubObject {
   private Image a;

   public ImageObj(int var1, int var2, int var3, int var4) {
      super(var1, var2, var3, 0);
      FilePack.b(T.at);
      this.a = FilePack.a("" + var1);
      if (this.a != null) {
         this.a.getWidth();
      }

      FilePack.a();
   }

   public final void update() {
   }

   public final void paint(Graphics var1) {
      if (this.a == null) {
         super.g = AvatarData.getImgIcon((short)super.type).b;
         AvatarData.a(var1, super.type, super.x * MyObject.hd, super.y * MyObject.hd, 33);
      } else {
         var1.drawImage(this.a, super.x * MyObject.hd, super.y * MyObject.hd, 33);
      }

      if (super.type == 846) {
         Canvas.N.a(var1, String.valueOf(MapScr.c), super.x * MyObject.hd, super.y * MyObject.hd - 30 * MyObject.hd, 2);
      } else {
         if (super.type == 1029 && FarmScr.V != 0) {
            FarmItem var2 = FarmScr.b(FarmData.b(FarmScr.V).b);
            String var3 = "";
            int var4;
            if ((var4 = FarmScr.U / 3600) > 0) {
               var3 = var4 + ":";
            }

            int var5;
            if ((var5 = (FarmScr.U - var4 * 3600) / 60) > 0 || var4 > 0) {
               var3 = var3 + var5 + ":";
            }

            var4 = FarmScr.U - var4 * 3600 - var5 * 60;
            var3 = var3 + var4;
            if (FarmScr.U == 0) {
               var3 = "hoan thanh";
            }

            FarmScr.W = super.x - Canvas.smallFontYellow.getWidth(var3) / 2 / MyObject.hd;
            FarmScr.X = super.y - AvatarData.getImgIcon((short)super.type).c / MyObject.hd - 10;
            FarmData.a(var1, var2.b, super.x * MyObject.hd - Canvas.smallFontYellow.getWidth(var3) / 2, super.y * MyObject.hd - AvatarData.getImgIcon((short)super.type).c - 10 * MyObject.hd, 3);
            Canvas.smallFontYellow.a(var1, var3, super.x * MyObject.hd - Canvas.smallFontYellow.getWidth(var3) / 2 + 10 * MyObject.hd, super.y * MyObject.hd - AvatarData.getImgIcon((short)super.type).c - 10 * MyObject.hd - AvMain.ai / 2 + 2, 0);
         }

      }
   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class MoneyPut {
   private int b;
   private int c;
   int a;
   private int d;

   public MoneyPut(int var1, int var2, int var3, int var4) {
      this.b = var1;
      this.c = var2;
      this.a = var3;
      this.d = var4;
   }

   public final void a(Graphics var1) {
      ImageIcon var2;
      if ((var2 = AvatarData.getImgIcon((short)(Canvas.w > 200 ? 870 : 871))).count != -1) {
         var1.drawRegion(var2.img, 0, this.d * BCBoardScr.c, BCBoardScr.b, BCBoardScr.c, 0, this.b, this.c, 3);
         FontX var3 = Canvas.O;
         if (Canvas.w <= 200) {
            var3 = Canvas.smallFontYellow;
         }

         if (Canvas.stypeInt > 0) {
            var3 = Canvas.normalFont;
         }

         var3.drawString(var1, String.valueOf(this.a), this.b, this.c - AvMain.ah / 2, 2);
      }

   }
}

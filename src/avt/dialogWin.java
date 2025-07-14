package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class dialogWin extends Face {
   public String a;
   public byte b;
   private int g = 200;
   private int h;
   public int c;
   public int d;
   public int e;
   public int f;

   public dialogWin() {
      this.h = (short)(AvMain.ah * 11);
      super.ac = RaceScr.b().b;
   }

   public final void a(Graphics var1) {
      Canvas.S.a(var1, (Canvas.m - this.g) / 2, (Canvas.n - this.h) / 2, this.g, this.h, PaintPopup.d[2], PaintPopup.d[3], 1);
      var1.translate((Canvas.m - this.g) / 2, (Canvas.n - this.h) / 2);
      int var2;
      Canvas.K.a(var1, String.valueOf(RaceScr.b().n), this.g / 2, (var2 = 0 + AvMain.ah) - AvMain.ah / 2 - 2 * AvMain.hd, 2);
      Canvas.K.a(var1, "Thú đua chiến thắng", this.g / 2, var2 += AvMain.ah / 2 + 2 * AvMain.hd, 2);
      Canvas.L.a(var1, this.a, this.g / 2, var2 += AvMain.ah + 6 * AvMain.hd, 2);
      var2 += AvMain.ah << 1;

      for(int var3 = 0; var3 < 6; ++var3) {
         ImageIcon var4;
         if (this.b == RaceScr.b().c[var3].IDDB && (var4 = AvatarData.c(RaceScr.b().c[var3].c)).count != -1) {
            int var5 = var4.c / 5;
            var1.drawRegion(var4.img, 0, RaceScr.m[0][0] * var5, var4.b, var5, 0, this.g / 2, var2 + AvMain.ah / 2, 3);
         }
      }

      var2 += AvMain.ah / 2;
      Canvas.K.a(var1, "Tiền cược: ", 10, var2 += AvMain.ah, 0);
      Canvas.smallFontYellow.a(var1, "" + this.c, this.g - 20, var2 + AvMain.ah / 2 - AvMain.ai / 2, 1);
      Canvas.K.a(var1, "Tiền ăn: ", 10, var2 += AvMain.ah, 0);
      Canvas.smallFontYellow.a(var1, "" + this.d, this.g - 20, var2 + AvMain.ah / 2 - AvMain.ai / 2, 1);
      Canvas.K.a(var1, "Tiền thuế: ", 10, var2 += AvMain.ah, 0);
      Canvas.smallFontYellow.a(var1, "" + this.e, this.g - 20, var2 + AvMain.ah / 2 - AvMain.ai / 2, 1);
      Canvas.K.a(var1, "Tiền nhận được: ", 10, var2 += AvMain.ah, 0);
      Canvas.smallFontYellow.a(var1, "" + this.f, this.g - 20, var2 + AvMain.ah / 2 - AvMain.ai / 2, 1);
      super.a(var1);
   }
}

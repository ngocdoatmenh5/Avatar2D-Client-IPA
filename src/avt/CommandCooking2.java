package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class CommandCooking2 extends Command {
   CommandCooking2(FarmScr var1, String var2, int var3, AvMain var4) {
      super(var2, 2, var4);
   }

   public final void a(Graphics var1, int var2, int var3) {
      Food var7;
      FarmItem var9 = FarmScr.b((var7 = FarmData.b(FarmScr.V)).b);
      FarmData.a(var1, var9.b, Canvas.y.d / 2, PopupShop.d / 2 - 30, 3);
      Canvas.N.a(var1, var7.d, Canvas.y.d / 2, PopupShop.d / 2 - 30 + 5 + FarmData.a(var9.b).c / 2 + AvMain.ai + 2, 2);
      String var8 = "";
      int var4 = FarmScr.U / 3600;
      FontX var5 = Canvas.M;
      if (var4 > 0) {
         var8 = var4 + ":";
      }

      int var6;
      if ((var6 = (FarmScr.U - var4 * 3600) / 60) > 0 || var4 > 0) {
         var8 = var8 + var6 + ":";
      }

      var4 = FarmScr.U - var4 * 3600 - var6 * 60;
      var8 = var8 + var4;
      if (FarmScr.U == 0) {
         var8 = T1.eL;
         var5 = Canvas.N;
      }

      var5.a(var1, var8, Canvas.y.d / 2, PopupShop.d / 2 - 30 + 5 + FarmData.a(var9.b).c / 2, 2);
   }
}

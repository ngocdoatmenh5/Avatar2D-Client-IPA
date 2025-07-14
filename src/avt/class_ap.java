package avt;

import javax.microedition.lcdui.Graphics;

final class class_ap extends Command {
   class_ap(FarmScr var1, String var2, int var3) {
      super(var2, 13);
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmData.a(var1, FarmScr.J.e > 0 ? 64 : 63, var2, var3, 3);
   }
}

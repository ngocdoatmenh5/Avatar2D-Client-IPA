package avt;

import javax.microedition.lcdui.Graphics;

final class class_bv extends Command {
   class_bv(FarmScr var1, String var2, int var3) {
      super(var2, 11);
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmData.a(var1, 65, var2, var3, 3);
   }
}

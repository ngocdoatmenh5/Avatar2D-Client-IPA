package avt;

import javax.microedition.lcdui.Graphics;

final class class_ao extends Command {
   class_ao(FarmScr var1, String var2, int var3) {
      super(var2, 12);
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmData.a(var1, 62, var2, var3, 3);
   }
}

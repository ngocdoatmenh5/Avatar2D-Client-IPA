package avt;

import javax.microedition.lcdui.Graphics;

final class class_fd extends Command {
   class_fd(FarmScr var1, String var2, int var3) {
      super(var2, 2);
   }

   public final void a(Graphics var1, int var2, int var3) {
      var1.drawImage(FarmScr.n, var2, var3, 3);
   }
}

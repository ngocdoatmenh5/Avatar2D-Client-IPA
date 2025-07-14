package avt;

import javax.microedition.lcdui.Graphics;

final class class_fb extends Command {
   private final FarmItem f;

   class_fb(FarmScr var1, String var2, IAction var3, FarmItem var4) {
      super(var2, var3);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.f.a(var1, var2, var3, 0, 3);
   }
}

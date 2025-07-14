package avt;

import javax.microedition.lcdui.Graphics;

final class class_iv extends Command {
   private final int f;

   class_iv(MenuCenter var1, String var2, IAction var3, int var4) {
      super(var2, var3);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      MenuSub.f.a(this.f, var2, var3, 0, 3, var1);
   }
}

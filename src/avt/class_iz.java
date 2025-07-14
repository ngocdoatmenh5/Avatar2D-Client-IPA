package avt;

import javax.microedition.lcdui.Graphics;

final class class_iz extends Command {
   private final int f;

   class_iz(MenuCenter var1, String var2, int var3, int var4) {
      super(var2, var3);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      MenuSub.f.b(this.f / MenuSub.f.c, this.f % MenuSub.f.c, var2, var3, 3, var1);
   }
}

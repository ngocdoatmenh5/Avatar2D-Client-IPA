package avt;

import javax.microedition.lcdui.Graphics;

final class class_bz extends Command {
   private final Item f;

   class_bz(FarmScr var1, String var2, int var3, int var4, Item var5) {
      super(var2, 7, var4);
      this.f = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmData.b((int)this.f.ID).a(var1, 7, var2, var3, 3);
   }
}

package avt;

import javax.microedition.lcdui.Graphics;

final class class_hg extends Command {
   private FarmItem f;

   public class_hg(FarmScr var1, String var2, IAction var3, FarmItem var4) {
      super(var2, var3);
      this.f = var4;
   }

   public class_hg(FarmScr var1, String var2, int var3, int var4, FarmItem var5) {
      super(var2, 6, var4);
      this.f = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.f.a(var1, var2, var3, 0, 3);
   }
}

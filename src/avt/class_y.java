package avt;

import javax.microedition.lcdui.Graphics;

final class class_y extends Command {
   private final StringObj f;

   class_y(MapScr var1, String var2, IAction var3, StringObj var4) {
      super(var2, var3);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.f.d, var2, var3, 3);
   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class class_gk extends Command {
   private final MapItemType f;
   private final int g;
   private final String h;
   private final String i;

   class_gk(HouseScr var1, String var2, IAction var3, MapItemType var4, int var5, String var6, String var7) {
      super(var2, var3);
      this.f = var4;
      this.g = 90;
      this.h = var6;
      this.i = var7;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.f.b, var2, var3 + this.g / 2 - AvMain.af - AvMain.ah - 5, 33);
      GameCanvas.N.a(var1, this.h, var2, var3 + this.g / 2 - AvMain.af, 2);
      GameCanvas.K.a(var1, this.i, var2, var3 + this.g / 2 - AvMain.af - AvMain.ah, 2);
   }
}

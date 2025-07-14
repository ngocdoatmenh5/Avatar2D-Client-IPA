package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class CommandInfo extends Command {
   private final Avatar f;
   private final byte g;
   private final byte h;
   private final int i;
   private final short j;

   CommandInfo(class_kv var1, String var2, int var3, Avatar var4, byte var5, byte var6, int var7, short var8) {
      super((String)null, 0);
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
      this.j = var8;
   }

   public final void a(Graphics var1, int var2, int var3) {
      GameCanvas.c(var1);
      var2 = PaintPopup.o + (AvMain.Z << 1) + 10 * AvMain.Y + 30 * (AvMain.Y - 1) + PopupShop.b;
      byte var5 = AvMain.ah;
      this.f.a(var1, GameCanvas.m / 2, var2, false);
      GameCanvas.K.a(var1, T1.aA + this.f.x, GameCanvas.m / 2, var2 + var5, 2);
      GameCanvas.K.a(var1, T1.em[3] + this.g + " (" + this.h + "%)", GameCanvas.m / 2, var2 + (var5 << 1), 2);
      GameCanvas.K.a(var1, T1.cC + this.i, GameCanvas.m / 2, var2 + var5 * 3, 2);
      GameCanvas.K.a(var1, T1.cD + ": ", GameCanvas.m / 2, var2 + (var5 << 2), 2);
      if (this.j != -1) {
         ((PartSmall)AvatarData.a(this.j)).a(var1, GameCanvas.m / 2, var2 + var5 * 6, 3);
      }

   }
}

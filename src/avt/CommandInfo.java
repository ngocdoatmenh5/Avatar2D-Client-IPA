package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

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
      Canvas.resetTrans(var1);
      var2 = PaintPopup.o + (AvMain.Z << 1) + 10 * AvMain.hd + 30 * (AvMain.hd - 1) + PopupShop.b;
      byte var5 = AvMain.ah;
      this.f.paintIcon(var1, Canvas.w / 2, var2, false);
      Canvas.K.a(var1, T.aA + this.f.name, Canvas.w / 2, var2 + var5, 2);
      Canvas.K.a(var1, T.em[3] + this.g + " (" + this.h + "%)", Canvas.w / 2, var2 + (var5 << 1), 2);
      Canvas.K.a(var1, T.cC + this.i, Canvas.w / 2, var2 + var5 * 3, 2);
      Canvas.K.a(var1, T.cD + ": ", Canvas.w / 2, var2 + (var5 << 2), 2);
      if (this.j != -1) {
         ((PartSmall)AvatarData.getPart(this.j)).a(var1, Canvas.w / 2, var2 + var5 * 6, 3);
      }

   }
}

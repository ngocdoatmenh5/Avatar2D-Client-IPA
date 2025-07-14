package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class class_fm extends Command {
   private final String f;
   private final Avatar g;
   private final Avatar h;
   private final short i;
   private final byte j;
   private final byte k;
   private final String l;

   class_fm(MapScr var1, String var2, IAction var3, String var4, Avatar var5, Avatar var6, short var7, byte var8, byte var9, String var10) {
      super(var2, (IAction)null);
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
      this.j = var8;
      this.k = var9;
      this.l = var10;
   }

   public final void a(Graphics var1, int var2, int var3) {
      var2 = 15 * AvMain.Y;
      GameCanvas.K.a(var1, this.f, PopupShop.c / 2 - 7, var2, 2);
      var2 += this.g.aA + GameCanvas.K.a() + 15 * AvMain.Y;
      this.g.a(var1, PopupShop.c / 4 - 7, var2, true);
      this.h.a(var1, PopupShop.c / 4 * 3 - 7, var2, true);
      ImageIcon var4;
      if ((var4 = AvatarData.c(this.i)).d != -1) {
         var1.drawImage(var4.a, PopupShop.c / 2 - 7, var2 - this.g.aA / 2, 3);
         if (this.j > 0) {
            GameCanvas.N.a(var1, "lv" + this.j + "+" + this.k + "%", PopupShop.c / 2 - 7, var2, 2);
            var2 += GameCanvas.N.a();
            MapScr.a(var1, "", PopupShop.c / 2 - 8, var2, this.k);
         }
      }

      var2 += GameCanvas.N.a() << 1;
      GameCanvas.K.a(var1, this.l, PopupShop.c / 2 - 7, var2 - 5, 2);
   }

   public final void a() {
      this.h.b();
   }
}

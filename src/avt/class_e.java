package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class class_e extends Command {
   private MapScr f;
   private final Part g;
   private final byte h;

   class_e(MapScr var1, String var2, IAction var3, Part var4, byte var5) {
      super(var2, var3);
      this.f = var1;
      this.g = var4;
      this.h = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.g.paintIcon(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void a() {
      if (this.h == PopupShop.j) {
         PopupShop.n();
         MapScr.a(this.g);
         String var1 = "";
         if (this.g.zOrder == 20) {
            var1 = T.aC;
         } else if (this.g.zOrder == 10) {
            var1 = T.aB;
         } else if (this.g.zOrder == 40) {
            var1 = T.aE;
         } else if (this.g.zOrder == 50) {
            var1 = T.aD;
         }

         PopupShop.a(var1 + AvatarData.getName(this.g));
         PopupShop.a(Canvas.getPriceMoney(this.g.i[0], this.g.i[1], true));
         PopupShop.a(T.dx + AvatarData.getLevel(this.g));
         PopupShop.a(T.em[0] + MapScr.C.lvMain);
      }

   }
}

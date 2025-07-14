package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class class_i extends Command {
   private MapScr f;
   private final Part g;
   private final byte h;

   class_i(MapScr var1, String var2, IAction var3, Part var4, byte var5) {
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
         MapScr.a(this.g);
         PopupShop.n();
         String var1 = "";
         PopupShop.a(var1 + AvatarData.a(this.g));
         PopupShop.a(T1.az + GameCanvas.a(this.g.i[0], this.g.i[1], false));
         PopupShop.a(T1.dx + AvatarData.b(this.g));
         PopupShop.a(T1.em[0] + MapScr.C.v);
      }

   }
}

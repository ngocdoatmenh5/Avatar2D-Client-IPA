package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

final class CommandIceDream extends Command {
   private final Item f;
   private final int g;

   CommandIceDream(MapScr var1, String var2, IAction var3, Item var4, int var5) {
      super(var2, var3);
      this.f = var4;
      this.g = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a[this.f.b].a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }

   public final void a() {
      if (this.g == PopupShop.j || PopupShop.k) {
         PopupShop.n();
         PopupShop.a(this.f.f);
         PopupShop.a(T1.az + this.f.d[0] + T1.T);
         PopupShop.a(T1.ce + GameCanvas.b(GameMidlet.i.a[0]) + T1.T);
      }

   }
}

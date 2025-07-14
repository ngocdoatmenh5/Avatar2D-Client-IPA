package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class CommandGoVatPham extends Command {
   private final FarmItem f;
   private final int g;

   CommandGoVatPham(FarmScr var1, String var2, int var3, int var4, FarmItem var5, int var6) {
      super(var2, 9, var4);
      this.f = var5;
      this.g = var6;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.f.a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void a() {
      if (this.g == PopupShop.j) {
         PopupShop.n();
         PopupShop.a(this.f.f);
         PopupShop.a(T1.az + Canvas.a(this.f.g, this.f.h, false));
      }

   }
}

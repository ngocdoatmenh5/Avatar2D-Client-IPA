package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class CommandGoKhoHang2 extends Command {
   private final FarmItem f;
   private final int g;
   private final Item h;

   CommandGoKhoHang2(FarmScr var1, String var2, int var3, int var4, FarmItem var5, int var6, Item var7) {
      super(var2, 11, var4);
      this.f = var5;
      this.g = var6;
      this.h = var7;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.f.a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void a() {
      if (PopupShop.n && this.g == PopupShop.j - FarmScr.f.size()) {
         PopupShop.n();
         PopupShop.a(this.f.f);
         PopupShop.a(T1.ay + this.h.e);
         if (this.f.h > 0) {
            PopupShop.a(T1.aK + Canvas.getMoneys(this.h.e * this.f.h) + T1.T);
         } else if (this.f.g > 0) {
            PopupShop.a(T1.aK + Canvas.getMoneys(this.h.e * this.f.g) + T1.T);
         }

         PopupShop.a(MapScr.r());
      }

   }
}

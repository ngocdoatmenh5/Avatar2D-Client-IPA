package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class class_fy extends Command {
   private final AnimalInfo f;
   private final int g;

   class_fy(FarmScr var1, String var2, int var3, int var4, AnimalInfo var5, int var6) {
      super(var2, 8, var4);
      this.f = var5;
      this.g = var6;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.f.g, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }

   public final void a() {
      if (this.g == PopupShop.j - FarmData.b.length && PopupShop.n) {
         PopupShop.n();
         PopupShop.a(this.f.l + "(" + this.f.d + T1.bq + ")");
         PopupShop.a(T1.az + GameCanvas.a(this.f.e[0], this.f.e[1], false));
         PopupShop.a(this.f.m);
         PopupShop.a(MapScr.r());
      }

   }
}

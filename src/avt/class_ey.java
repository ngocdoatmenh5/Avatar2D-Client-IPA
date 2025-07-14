package avt;

import javax.microedition.lcdui.Graphics;

final class class_ey extends Command {
   private int f;
   private int g;
   private class_km h;

   public class_ey(MapScr var1, String var2, class_ku var3, int var4, class_km var5, int var6) {
      super(var2, var3);
      this.f = var4;
      this.h = var5;
      this.g = var6;
   }

   public final void a() {
      if (PopupShop.n && PopupShop.j - this.g == this.f) {
         PopupShop.n();
         PopupShop.a(T1.aA + this.h.c);
         PopupShop.a(T1.az + this.h.d + (this.h.e == 0 ? T1.C : T1.D));
      }

   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.h.b, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }
}

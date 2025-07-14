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

   public final void update() {
      if (PopupShop.isTransFocus && PopupShop.focus - this.g == this.f) {
         PopupShop.resetIsTrans();
         PopupShop.addStr(T.aA + this.h.c);
         PopupShop.addStr(T.az + this.h.d + (this.h.e == 0 ? T.C : T.D));
      }

   }

   public final void paint(Graphics var1, int var2, int var3) {
      AvatarData.paintImg(var1, this.h.b, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }
}

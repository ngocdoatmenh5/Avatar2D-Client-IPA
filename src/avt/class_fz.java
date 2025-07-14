package avt;

import javax.microedition.lcdui.Graphics;

final class class_fz extends Command {
   private final SeriPart f;
   private final int g;
   private final int h;

   class_fz(MapScr var1, String var2, IAction var3, SeriPart var4, int var5, int var6) {
      super(var2, var3);
      this.f = var4;
      this.g = var5;
      this.h = var6;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(this.f.a).a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
      PaintPopup.a(var2 + 3, var3 + PopupShop.e - 3 * AvMain.Y, PopupShop.e - 5, 2 * AvMain.Y, 1, var1);
      PaintPopup.a(var2 + 3, var3 + PopupShop.e - 3 * AvMain.Y, PopupShop.e - 5 - this.f.b * (PopupShop.e - 5) / 100, 2 * AvMain.Y, 11907085, var1);
   }

   public final void a() {
      if (PopupShop.n && this.g == PopupShop.j) {
         Part var1 = AvatarData.a(this.f.a);
         PopupShop.n();
         PopupShop.a(T1.cr + (100 - this.f.b) + "%");
         String var2 = "";
         if (var1.j == 20) {
            var2 = T1.aC;
         } else if (var1.j == 10) {
            var2 = T1.aB;
         }

         PopupShop.a(var2 + AvatarData.a(var1));
         if (this.f.c != null && !this.f.c.equals("")) {
            PopupShop.a(this.f.c);
         }

         if (this.h == 0) {
            PopupShop.a(T1.em[2] + ": " + AvatarData.b(var1));
            return;
         }

         if (var1.f != -2) {
            byte var3;
            if (var1.f >= 0) {
               var3 = ((APartInfo)AvatarData.a(var1.f)).a;
            } else {
               var3 = ((APartInfo)var1).a;
            }

            PopupShop.a(T1.em[2] + ": " + var3);
         }
      }

   }
}

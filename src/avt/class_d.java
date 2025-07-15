package avt;

import javax.microedition.lcdui.Graphics;

final class class_d extends Command {
   private final Item f;
   private final int g;

   class_d(FarmScr var1, String var2, int var3, int var4, Item var5, int var6) {
      super(var2, 12, var4);
      this.f = var5;
      this.g = var6;
   }

   public final void paint(Graphics var1, int var2, int var3) {
      FarmData.getTreeByID((int)this.f.ID).a(var1, 7, var2 + PopupShop.h / 2, var3 + PopupShop.h / 2, 3);
   }

   public final void update() {
      if (this.g == PopupShop.focus) {
         PopupShop.resetIsTrans();
         PopupShop.addStr(this.f.name);
         PopupShop.addStr(T.ay + this.f.number);
      }

   }
}

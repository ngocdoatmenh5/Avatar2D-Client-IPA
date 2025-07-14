package avt;

import javax.microedition.lcdui.Graphics;

final class CommandOpenKhoHang2 extends Command {
   private Item f;
   private final int g;

   CommandOpenKhoHang2(FarmScr var1, String var2, int var3, int var4, int var5) {
      super(var2, 13, var4);
      this.g = var5;
      this.f = (Item)FarmScr.d.elementAt(var5);
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmScr.b(this.f.ID).a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void a() {
      if (PopupShop.n && this.g == PopupShop.j - FarmScr.p().size()) {
         PopupShop.n();
         PopupShop.a(FarmScr.b(this.f.ID).f);
         FarmItem var1 = FarmScr.b(this.f.ID);
         int var2 = this.f.e;
         if (var1.d == 4) {
            var2 -= FarmScr.listFood[1].size();
         } else if (var1.d == 1) {
            var2 -= FarmScr.listFood[0].size();
         }

         PopupShop.a(T.ay + var2);
      }

   }
}

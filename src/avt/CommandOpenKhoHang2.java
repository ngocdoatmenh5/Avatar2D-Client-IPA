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
      FarmScr.b(this.f.a).a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void a() {
      if (PopupShop.n && this.g == PopupShop.j - FarmScr.p().size()) {
         PopupShop.n();
         PopupShop.a(FarmScr.b(this.f.a).f);
         FarmItem var1 = FarmScr.b(this.f.a);
         int var2 = this.f.e;
         if (var1.d == 4) {
            var2 -= FarmScr.j[1].size();
         } else if (var1.d == 1) {
            var2 -= FarmScr.j[0].size();
         }

         PopupShop.a(T1.ay + var2);
      }

   }
}

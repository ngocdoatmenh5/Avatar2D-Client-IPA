package avt;

import main.GameCanvas;

final class IActionCooking1 implements IAction {
   private final Food a;

   IActionCooking1(FarmScr var1, Food var2) {
      this.a = var2;
   }

   public final void perform() {
      for(int var1 = 0; var1 < this.a.e.length; ++var1) {
         String var3 = "";
         Item var2;
         if (this.a.e[var1] < 100) {
            var2 = FarmScr.g(this.a.e[var1]);
            if (this.a.e[var1] < 50) {
               var3 = FarmData.b((int)this.a.e[var1]).a;
            } else if (FarmData.c(this.a.e[var1]).c == 1) {
               var3 = T1.bn + " " + FarmData.c(this.a.e[var1]).l;
            } else if (FarmData.c(this.a.e[var1]).c == 2) {
               var3 = T1.bm + " " + FarmData.c(this.a.e[var1]).l;
            }
         } else {
            var2 = FarmScr.f(this.a.e[var1]);
            var3 = FarmScr.b(this.a.e[var1]).f;
         }

         if (var2 == null || var2.e < this.a.f[var1]) {
            GameCanvas.b(T1.eI + var3);
            return;
         }
      }

      FarmService.a().d(this.a.a);
      PopupShop.b().d();
   }
}

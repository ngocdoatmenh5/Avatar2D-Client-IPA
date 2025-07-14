package avt;

import main.Canvas;

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
            } else if (FarmData.getAnimalByID(this.a.e[var1]).area == 1) {
               var3 = T.bn + " " + FarmData.getAnimalByID(this.a.e[var1]).name;
            } else if (FarmData.getAnimalByID(this.a.e[var1]).area == 2) {
               var3 = T.bm + " " + FarmData.getAnimalByID(this.a.e[var1]).name;
            }
         } else {
            var2 = FarmScr.f(this.a.e[var1]);
            var3 = FarmScr.b(this.a.e[var1]).f;
         }

         if (var2 == null || var2.e < this.a.f[var1]) {
            Canvas.startOKDlg(T.eI + var3);
            return;
         }
      }

      FarmService.a().d(this.a.a);
      PopupShop.b().d();
   }
}

package avt;

import main.GameCanvas;

final class class_de implements IAction {
   private HouseScr a;

   class_de(HouseScr var1) {
      this.a = var1;
   }

   public final void perform() {
      HouseScr.i(this.a);
      HouseScr var10000 = this.a;
      HouseScr.e(this.a, -1);
      HouseScr.d(var10000, -1);
      GameCanvas.h();
   }
}

package avt;

import main.Canvas;

final class IActionTriBenh2 implements IAction {
   private FarmScr a;
   private final Animal b;

   IActionTriBenh2(FarmScr var1, Animal var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      boolean var1 = false;

      for(int var2 = 0; var2 < FarmScr.d.size(); ++var2) {
         Item var3;
         if ((var3 = (Item)FarmScr.d.elementAt(var2)).a == 121) {
            FarmItem var4 = FarmScr.b(var3.a);
            FarmScr.a(this.a, var4, var3.a, this.b);
            var1 = true;
            break;
         }
      }

      if (!var1) {
         Canvas.b(T1.dW);
         FarmScr.b().a((int)8, (int)-1);
      }

   }
}

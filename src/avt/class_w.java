package avt;

import main.Canvas;

final class class_w implements IAction {
   private FarmScr a;
   private final Animal b;

   class_w(FarmScr var1, Animal var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      boolean var1 = false;

      for(int var2 = 0; var2 < FarmScr.d.size(); ++var2) {
         Item var3;
         if (FarmScr.b((var3 = (Item)FarmScr.d.elementAt(var2)).a).e == 6) {
            FarmService.a().b(FarmScr.b, this.b.IDDB, var3.a);
            var1 = true;
            this.a.d(10, -1);
            break;
         }
      }

      if (!var1) {
         FarmScr.b().a((int)8, (int)-1);
         Canvas.b(T1.ea);
      }

   }
}

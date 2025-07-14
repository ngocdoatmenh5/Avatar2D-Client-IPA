package avt;

import main.Canvas;

final class class_ab implements IAction {
   private FarmScr a;
   private final Animal b;

   class_ab(FarmScr var1, Animal var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      boolean var1 = false;
      AnimalInfo var2 = FarmData.getAnimalByID(this.b.species);

      for(int var3 = 0; var3 < FarmScr.d.size(); ++var3) {
         Item var4;
         FarmItem var5;
         if ((var5 = FarmScr.b((var4 = (Item)FarmScr.d.elementAt(var3)).ID)).d == var2.area && var5.e == 5 && var4.e > 0) {
            var1 = true;
            this.b.hunger = false;
            FarmScr.b();
            FarmScr.a(var5.a, this.b.IDDB);
            this.a.d(10, -1);
         }
      }

      if (!var1) {
         Canvas.startOKDlg(T.dY);
         this.a.a((int)8, (int)-1);
      }

   }
}

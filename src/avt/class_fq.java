package avt;

import main.GameMidlet;

final class class_fq implements IAction {
   private FarmScr a;
   private final CellFarm b;

   class_fq(FarmScr var1, CellFarm var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      GameMidlet.i.H = 0;
      FarmScr.A.a = this.b.aw / LoadMap.i;
      FarmScr.A.b = this.b.ax / LoadMap.i;
      FarmScr.a(this.a, this.b);
   }
}

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
      GameMidlet.avatar.action = 0;
      FarmScr.A.x = this.b.x / LoadMap.i;
      FarmScr.A.y = this.b.y / LoadMap.i;
      FarmScr.a(this.a, this.b);
   }
}

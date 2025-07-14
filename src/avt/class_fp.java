package avt;

final class class_fp implements IAction {
   private FarmScr a;
   private final CellFarm b;

   class_fp(FarmScr var1, CellFarm var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      FarmScr.A.x = this.b.x / LoadMap.i;
      FarmScr.A.y = this.b.y / LoadMap.i;
      FarmScr.a(this.a, (byte)1, FarmScr.G);
   }
}

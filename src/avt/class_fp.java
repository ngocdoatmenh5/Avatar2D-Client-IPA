package avt;

final class class_fp implements IAction {
   private FarmScr a;
   private final CellFarm b;

   class_fp(FarmScr var1, CellFarm var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      FarmScr.focusCell.x = this.b.x / LoadMap.w;
      FarmScr.focusCell.y = this.b.y / LoadMap.w;
      FarmScr.a(this.a, (byte)1, FarmScr.idItemUsing);
   }
}

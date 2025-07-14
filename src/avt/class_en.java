package avt;

final class class_en implements IAction {
   private FarmScr a;
   private final CellFarm b;

   class_en(FarmScr var1, CellFarm var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      FarmScr.a(this.a, this.b);
   }
}

package avt;

final class class_bx implements IAction {
   private FarmScr a;
   private final Item b;

   class_bx(FarmScr var1, Item var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      this.a.a((Item)this.b, 1);
   }
}

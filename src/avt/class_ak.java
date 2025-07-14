package avt;

final class class_ak implements IAction {
   private final byte a;
   private final Item b;

   class_ak(FarmScr var1, byte var2, Item var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void perform() {
      if (this.a == 2) {
         Cattle.v = this.b.ID;
      } else {
         Dog.u = this.b.ID;
      }
   }
}

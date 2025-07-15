package avt;

final class class_er implements IAction {
   private FarmScr a;
   private final Item b;
   private final AnimalInfo c;

   class_er(FarmScr var1, Item var2, AnimalInfo var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      if (LoadMap.focusObj != null) {
         this.a.doUsingVatPhamAnimal(this.b, this.c.area == 1 ? 0 : 1);
      }

   }
}

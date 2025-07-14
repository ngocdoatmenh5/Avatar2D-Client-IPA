package avt;

final class class_x implements IAction {
   private final AnimalInfo a;

   class_x(FarmScr var1, AnimalInfo var2) {
      this.a = var2;
   }

   public final void perform() {
      FarmService.gI().doBuyAnimal(this.a, 1);
   }
}

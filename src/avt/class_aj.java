package avt;

final class class_aj implements IAction {
   private final AnimalInfo a;

   class_aj(FarmScr var1, AnimalInfo var2) {
      this.a = var2;
   }

   public final void perform() {
      FarmService.gI().doBuyAnimal(this.a, 2);
   }
}

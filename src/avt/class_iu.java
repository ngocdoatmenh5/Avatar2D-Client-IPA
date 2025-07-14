package avt;

final class class_iu implements IAction {
   private final IAction a;

   class_iu(MenuCenter var1, IAction var2) {
      this.a = var2;
   }

   public final void perform() {
      this.a.perform();
   }
}

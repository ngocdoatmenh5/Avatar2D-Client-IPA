package avt;

final class class_bh implements IAction {
   private final IAction a;

   class_bh(SoundManager var1, IAction var2) {
      this.a = var2;
   }

   public final void perform() {
      OptionScr.b().b(100);
      this.a.perform();
   }
}

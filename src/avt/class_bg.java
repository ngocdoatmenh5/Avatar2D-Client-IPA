package avt;

final class class_bg implements IAction {
   private FarmScr a;

   class_bg(FarmScr var1) {
      this.a = var1;
   }

   public final void perform() {
      FarmScr.a(this.a, (byte)1, FarmScr.idItemUsing);
   }
}

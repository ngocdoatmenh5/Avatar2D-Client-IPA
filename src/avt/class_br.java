package avt;

final class class_br implements IAction {
   private final int a;

   class_br(GlobalMessageHandler var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      GlobalService.gI().m(this.a);
   }
}

package avt;

final class class_gm implements IAction {
   private class_cg a;

   class_gm(class_cg var1) {
      this.a = var1;
   }

   public final void perform() {
      GlobalService.gI().a(this.a.b, this.a.a);
   }
}

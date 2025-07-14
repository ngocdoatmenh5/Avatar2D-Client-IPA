package avt;

final class class_dg implements IAction {
   private LoginScr a;

   class_dg(LoginScr var1) {
      this.a = var1;
   }

   public final void perform() {
      LoginScr.v = false;
      this.a.ac = new Command("Đóng", new class_bq(this.a));
      this.a.ad = this.a.f;
   }
}

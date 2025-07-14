package avt;

final class class_bq implements IAction {
   private LoginScr a;

   class_bq(LoginScr var1) {
      this.a = var1;
   }

   public final void perform() {
      LoginScr.v = true;
      this.a.ac = this.a.h;
      this.a.ad = this.a.g;
   }
}

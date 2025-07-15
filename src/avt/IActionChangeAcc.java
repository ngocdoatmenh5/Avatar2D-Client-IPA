package avt;

final class IActionChangeAcc implements IAction {
   private LoginScr a;

   IActionChangeAcc(LoginScr var1) {
      this.a = var1;
   }

   public final void perform() {
      LoginScr.isNewGame = false;
      this.a.left = new Command("Đóng", new class_bq(this.a));
      this.a.center = this.a.cmdLogin;
   }
}

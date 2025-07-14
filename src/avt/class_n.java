package avt;

import main.GameCanvas;

final class class_n implements IAction {
   private final String a;

   class_n(LoginScr var1, String var2) {
      this.a = var2;
   }

   public final void perform() {
      if (!Session_ME.a().c) {
         GameCanvas.c(T1.M);
         GameCanvas.c();
      } else {
         GameCanvas.i();
      }

      GlobalService.gI().a((byte)4, this.a);
   }
}

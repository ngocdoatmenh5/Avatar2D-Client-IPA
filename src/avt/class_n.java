package avt;

import main.Canvas;

final class class_n implements IAction {
   private final String a;

   class_n(LoginScr var1, String var2) {
      this.a = var2;
   }

   public final void perform() {
      if (!Session_ME.a().c) {
         Canvas.startWaitDlg(T.M);
         Canvas.mSocket();
      } else {
         Canvas.startWaitDlg();
      }

      GlobalService.gI().requestService((byte)4, this.a);
   }
}

package avt;

import main.GameCanvas;

final class IActionToGo implements IAction {
   private BoardListOnScr a;

   IActionToGo(BoardListOnScr var1) {
      this.a = var1;
   }

   public final void perform() {
      try {
         this.a.j = Integer.parseInt(GameCanvas.u.a());
      } catch (Exception var1) {
         return;
      }

      this.a.e();
   }
}

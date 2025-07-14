package avt;

import main.GameCanvas;

final class class_cn implements IAction {
   private BoardListOnScr a;

   class_cn(BoardListOnScr var1) {
      this.a = var1;
   }

   public final void perform() {
      class_dl var1 = (class_dl)this.a.g.elementAt(this.a.ar);
      CasinoService.a().a(this.a.h, var1.a, GameCanvas.u.a());
      GameCanvas.h();
   }
}

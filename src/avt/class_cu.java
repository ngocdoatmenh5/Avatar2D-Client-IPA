package avt;

import main.GameCanvas;

final class class_cu implements IAction {
   class_cu(CasinoMsgHandler var1) {
   }

   public final void perform() {
      GameCanvas.i();
      CasinoService.a().a(BoardScr.p);
   }
}

package avt;

import main.Canvas;

final class class_cu implements IAction {
   class_cu(CasinoMsgHandler var1) {
   }

   public final void perform() {
      Canvas.startWaitDlg();
      CasinoService.gI().a(BoardScr.roomID);
   }
}

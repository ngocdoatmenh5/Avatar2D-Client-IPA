package avt;

import main.Canvas;

final class class_cj implements IAction {
   private BoardListOnScr a;

   class_cj(BoardListOnScr var1) {
      this.a = var1;
   }

   public final void perform() {
      CasinoService.a().a(this.a.h, (byte)this.a.j, Canvas.inputDlg.a());
      Canvas.endDlg();
   }
}

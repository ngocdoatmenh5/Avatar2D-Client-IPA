package avt;

import main.Canvas;

final class class_cn implements IAction {
   private BoardListOnScr a;

   class_cn(BoardListOnScr var1) {
      this.a = var1;
   }

   public final void perform() {
      class_dl var1 = (class_dl)this.a.g.elementAt(this.a.ar);
      CasinoService.gI().a(this.a.h, var1.a, Canvas.inputDlg.a());
      Canvas.endDlg();
   }
}

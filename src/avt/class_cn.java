package avt;

import main.Canvas;

final class class_cn implements IAction {
   private BoardListOnScr a;

   class_cn(BoardListOnScr var1) {
      this.a = var1;
   }

   public final void perform() {
      BoardInfo var1 = (BoardInfo)this.a.g.elementAt(this.a.selected_);
      CasinoService.gI().joinBoard(this.a.h, var1.boardID, Canvas.inputDlg.getText());
      Canvas.endDlg();
   }
}

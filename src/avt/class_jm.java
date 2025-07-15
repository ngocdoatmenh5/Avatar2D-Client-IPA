package avt;

import main.Canvas;

final class class_jm implements IAction {
   private TransMoneyDlg a;

   class_jm(TransMoneyDlg var1) {
      this.a = var1;
   }

   public final void perform() {
      GlobalService.gI().transXeng(TransMoneyDlg.a(this.a)[TransMoneyDlg.b(this.a)]);
      Canvas.startWaitDlg();
   }
}

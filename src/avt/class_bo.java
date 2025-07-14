package avt;

import main.Canvas;

final class class_bo implements IAction {
   private final int a;
   private final byte b;

   class_bo(GlobalMessageHandler var1, int var2, byte var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void perform() {
      GlobalService.gI().a(this.a, this.b, Canvas.inputDlg.a());
      Canvas.endDlg();
   }
}

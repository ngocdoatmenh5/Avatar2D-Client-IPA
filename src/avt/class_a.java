package avt;

import main.Canvas;

final class class_a implements IAction {
   private final int a;

   class_a(HomeMsgHandler var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      AvatarService.gI().doSetPassMyHouse(Canvas.inputDlg.a(), this.a, 1);
      Canvas.endDlg();
   }
}

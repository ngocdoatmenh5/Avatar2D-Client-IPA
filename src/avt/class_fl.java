package avt;

import main.Canvas;

final class class_fl implements IAction {
   class_fl(RaceScr var1) {
   }

   public final void perform() {
      Canvas.startWaitDlg();
      GlobalService.gI().getHandler((int)9);
   }
}

package avt;

import main.Canvas;

final class IActionExitToCity implements IAction {
   IActionExitToCity(LoadMap var1) {
   }

   public final void perform() {
      Canvas.startWaitDlg();
      if (LoadMap.TYPEMAP == 108) {
         ParkService.a().a(9, -1);
      } else {
         Canvas.startWaitDlg();
         GlobalService.gI().d((int)9);
      }
   }
}

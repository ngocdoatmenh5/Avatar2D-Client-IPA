package avt;

import main.GameCanvas;

final class IActionExitToCity implements IAction {
   IActionExitToCity(LoadMap var1) {
   }

   public final void perform() {
      GameCanvas.i();
      if (LoadMap.a == 108) {
         ParkService.a().a(9, -1);
      } else {
         GameCanvas.i();
         GlobalService.gI().d((int)9);
      }
   }
}

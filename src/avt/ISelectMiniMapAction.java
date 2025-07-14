package avt;

import main.GameCanvas;

final class ISelectMiniMapAction implements IAction {
   ISelectMiniMapAction(MapScr var1) {
   }

   public final void perform() {
      String var1 = T1.bc;
      switch (MiniMap.gI().e) {
         case 0:
            GlobalService.gI().d((int)11);
            break;
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
            GlobalService.gI().d((int)9);
            break;
         case 7:
            GlobalService.gI().d((int)10);
      }

      GameCanvas.c(var1 + T1.nameRegion[MiniMap.gI().e] + "...");
   }
}

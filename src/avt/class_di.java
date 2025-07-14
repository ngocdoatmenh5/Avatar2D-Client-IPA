package avt;

import main.GameCanvas;

final class class_di implements IAction {
   class_di(class_dj var1) {
   }

   public final void perform() {
      System.out.println("aaaaaaaaaaaaaaaa");
      GameCanvas.I = false;
      GameCanvas.D = null;
      AvCamera.g = false;
      MiniMap.gI().ac = MiniMap.gI().l;
      MapScr.b().c();
      FarmScr.b().c();
   }
}

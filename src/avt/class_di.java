package avt;

import main.Canvas;

final class class_di implements IAction {
   class_di(class_dj var1) {
   }

   public final void perform() {
      System.out.println("aaaaaaaaaaaaaaaa");
      Canvas.I = false;
      Canvas.D = null;
      AvCamera.g = false;
      MiniMap.gI().ac = MiniMap.gI().l;
      MapScr.gI().c();
      FarmScr.b().c();
   }
}

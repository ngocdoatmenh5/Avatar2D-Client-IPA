package avt;

import main.Canvas;

final class class_ds implements IAction {
   private final byte a;

   class_ds(GlobalLogicHandler var1, byte var2) {
      this.a = var2;
   }

   public final void perform() {
      if (this.a == 0) {
         GlobalService.gI().g(1);
      } else {
         GlobalService.gI().i(1);
      }

      Canvas.i();
   }
}

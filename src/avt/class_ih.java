package avt;

import main.Canvas;

final class class_ih implements IAction {
   private final int a;

   class_ih(MapScr var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      ParkService.a().c(1, this.a);
      Canvas.i();
   }
}

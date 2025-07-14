package avt;

import main.GameCanvas;

final class class_fc implements IAction {
   private final Item a;

   class_fc(MapScr var1, Item var2) {
      this.a = var2;
   }

   public final void perform() {
      ParkService.a().a(this.a.a);
      GameCanvas.i();
   }
}

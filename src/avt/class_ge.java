package avt;

import main.GameCanvas;

final class class_ge implements IAction {
   private final int a;

   class_ge(FarmScr var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      FarmService.a().b((short)this.a);
      GameCanvas.i();
   }
}

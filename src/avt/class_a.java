package avt;

import main.GameCanvas;

final class class_a implements IAction {
   private final int a;

   class_a(HomeMsgHandler var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      AvatarService.a().a(GameCanvas.u.a(), this.a, 1);
      GameCanvas.h();
   }
}

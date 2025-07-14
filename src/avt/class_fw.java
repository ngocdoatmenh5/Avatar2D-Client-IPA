package avt;

import main.Canvas;

final class class_fw implements IAction {
   private final MapItem a;

   class_fw(HouseScr var1, MapItem var2) {
      this.a = var2;
   }

   public final void perform() {
      HomeMsgHandler.a();
      AvatarService.a().b(this.a);
      Canvas.i();
   }
}

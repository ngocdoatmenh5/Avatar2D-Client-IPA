package avt;

import main.GameCanvas;

final class class_in implements IAction {
   private final Avatar a;

   class_in(MapScr var1, Avatar var2) {
      this.a = var2;
   }

   public final void perform() {
      class_cw var1 = MessageScr.b().b(MessageScr.b().b);
      if (ListScr.d != null) {
         ListScr.b();
         ListScr.h();
      }

      ParkService.a().a(this.a.w, true);
      MessageScr.b().a(var1);
      GameCanvas.b(T1.y + T1.cb + this.a.x + ".");
   }
}

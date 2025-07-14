package avt;

import main.Canvas;

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

      ParkService.a().a(this.a.IDDB, true);
      MessageScr.b().a(var1);
      Canvas.startOKDlg(T.y + T.cb + this.a.name + ".");
   }
}

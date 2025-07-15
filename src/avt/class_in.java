package avt;

import main.Canvas;

final class class_in implements IAction {
   private final Avatar a;

   class_in(MapScr var1, Avatar var2) {
      this.a = var2;
   }

   public final void perform() {
      class_cw var1 = MessageScr.gI().b(MessageScr.gI().b);
      if (ListScr.d != null) {
         ListScr.gI();
         ListScr.h();
      }

      ParkService.gI().a(this.a.IDDB, true);
      MessageScr.gI().a(var1);
      Canvas.startOKDlg(T.y + T.cb + this.a.name + ".");
   }
}

package avt;

import main.Canvas;
import main.GameMidlet;

final class class_hu implements IAction {
   private final ObjAd a;

   class_hu(LoadMap var1, ObjAd var2) {
      this.a = var2;
   }

   public final void perform() {
      if (this.a.a != -1) {
         GlobalService.gI().e(this.a.a);
         Canvas.startWaitDlg();
      } else if (this.a.d != null && !this.a.d.equals("")) {
         GameMidlet.b(this.a.d);
      } else {
         GameMidlet.a(this.a.e, this.a.f);
      }
   }
}

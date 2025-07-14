package avt;

import main.Canvas;

final class class_gg implements IAction {
   private final TField[] a;

   class_gg(HouseScr var1, TField[] var2) {
      this.a = var2;
   }

   public final void perform() {
      MapScr.gI();
      if (MapScr.a(this.a)) {
         GlobalService.gI().b(this.a[0].f(), this.a[1].f());
         Canvas.startWaitDlg();
         InputFace.b();
         Canvas.currentFace = null;
      }

   }
}

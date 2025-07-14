package avt;

import main.GameCanvas;

final class class_gg implements IAction {
   private final TField[] a;

   class_gg(HouseScr var1, TField[] var2) {
      this.a = var2;
   }

   public final void perform() {
      MapScr.b();
      if (MapScr.a(this.a)) {
         GlobalService.gI().b(this.a[0].f(), this.a[1].f());
         GameCanvas.i();
         InputFace.b();
         GameCanvas.A = null;
      }

   }
}

package avt;

import main.Canvas;

final class class_m implements IAction {
   private MapScr a;
   private final TField[] b;

   class_m(MapScr var1, TField[] var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      if (MapScr.setEnterPass(this.b)) {
         GlobalService.gI().doChangePass(this.b[0].getText(), this.b[1].getText());
         Canvas.startWaitDlg();
         InputFace.gI();
         Canvas.currentFace = null;
      }

   }
}

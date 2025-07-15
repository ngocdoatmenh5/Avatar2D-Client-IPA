package avt;

import main.Canvas;

final class class_de implements IAction {
   private HouseScr a;

   class_de(HouseScr var1) {
      this.a = var1;
   }

   public final void perform() {
      HouseScr.reset(this.a);
      HouseScr var10000 = this.a;
      HouseScr.setYtemp(this.a, -1);
      HouseScr.setxTemp(var10000, -1);
      Canvas.endDlg();
   }
}

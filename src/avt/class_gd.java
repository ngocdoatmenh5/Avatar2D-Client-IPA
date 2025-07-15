package avt;

import main.Canvas;

final class class_gd implements IAction {
   private final int a;
   private final int b;
   private final SeriPart c;

   class_gd(class_gf var1, int var2, int var3, SeriPart var4) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public final void perform() {
      if (this.a == 2) {
         GlobalService.gI().doTransChestPart(1, (int)this.b, (short)this.c.idPart);
      } else if (this.a == 3) {
         GlobalService.gI().doTransChestPart(0, (int)this.b, (short)this.c.idPart);
      } else {
         GlobalService.gI().doUsingItem(this.c.idPart, (byte)this.a);
      }

      Canvas.startWaitDlg();
   }
}

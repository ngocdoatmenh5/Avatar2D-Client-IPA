package avt;

import main.Canvas;

final class IActionDial implements IAction {
   private short a;

   public IActionDial(MapScr var1, short var2) {
      this.a = var2;
   }

   public final void perform() {
      PopupShop.gI().close();
      DialLuckyScr.gI().switchToMe(Canvas.currentMyScreen, this.a);
   }
}

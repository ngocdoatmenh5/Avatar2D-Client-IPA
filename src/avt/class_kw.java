package avt;

import main.Canvas;

final class class_kw implements IAction {
   private short a;

   public class_kw(MapScr var1, short var2) {
      this.a = var2;
   }

   public final void perform() {
      PopupShop.b().d();
      DialLuckyScr.b().a(Canvas.currentMyScreen, this.a);
   }
}

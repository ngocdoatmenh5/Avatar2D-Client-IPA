package avt;

final class class_fv implements IAction {
   private final short a;

   class_fv(MapScr var1, short var2) {
      this.a = var2;
   }

   public final void perform() {
      GlobalService.gI().b(this.a, -1);
      PopupShop.b().right.perform();
   }
}

package avt;

final class class_k implements IAction {
   private MapScr a;
   private final Part b;

   class_k(MapScr var1, Part var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      MapScr.doBuyItem(this.b.IDPart);
   }
}

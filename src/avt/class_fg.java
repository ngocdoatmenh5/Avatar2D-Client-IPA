package avt;

final class class_fg implements IAction {
   private MapScr a;
   private final Item b;

   class_fg(MapScr var1, Item var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      this.a.a(this.b);
   }
}

package avt;

final class class_er implements IAction {
   private FarmScr a;
   private final Item b;
   private final AnimalInfo c;

   class_er(FarmScr var1, Item var2, AnimalInfo var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      if (LoadMap.p != null) {
         this.a.a(this.b, this.c.c == 1 ? 0 : 1);
      }

   }
}

package avt;

final class class_fr implements IAction {
   private int a;

   public class_fr(FarmScr var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      Item var1 = (Item)FarmScr.f.elementAt(this.a);
      FarmScr.b().a((int)var1.a, var1.f);
   }
}

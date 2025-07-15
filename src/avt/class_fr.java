package avt;

final class class_fr implements IAction {
   private int a;

   public class_fr(FarmScr var1, int var2) {
      this.a = var2;
   }

   public final void perform() {
      Item var1 = (Item)FarmScr.itemProduct.elementAt(this.a);
      FarmScr.gI().doSellProduct((int)var1.ID, var1.name);
   }
}

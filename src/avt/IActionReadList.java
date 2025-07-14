package avt;

final class IActionReadList implements IAction {
   private ListScr a;
   private final int b;
   private final byte c;

   IActionReadList(ListScr var1, int var2, byte var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      GlobalService.gI().a(this.b, this.c, this.a.g, (byte)-1);
   }
}

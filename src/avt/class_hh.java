package avt;

final class class_hh implements IAction {
   private int a;
   private byte b;
   private int c;

   public class_hh(GlobalLogicHandler var1, int var2, int var3, byte var4) {
      this.c = var2;
      this.a = var3;
      this.b = var4;
   }

   public final void perform() {
      if (!ListScr.gI().setList(this.a + "-" + this.b + "-" + this.c)) {
         GlobalService.gI().doMenuOption(this.a, this.b, this.c);
      }

   }
}

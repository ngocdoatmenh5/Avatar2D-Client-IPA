package avt;

final class class_eq implements IAction {
   private int a;
   private int b;
   private int c;

   public class_eq(MapScr var1, int var2, int var3, int var4) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public final void perform() {
      ParkService.a().c(this.a, this.b, this.c);
   }
}

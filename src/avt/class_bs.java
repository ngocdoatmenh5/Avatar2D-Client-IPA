package avt;

final class class_bs implements IAction {
   private FarmScr a;
   private final FarmItem b;
   private final int c;

   class_bs(FarmScr var1, FarmItem var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      FarmScr.a(this.a, (byte)3, this.b.a);
      FarmService.a().b(FarmScr.b, this.c, this.b.a);
   }
}

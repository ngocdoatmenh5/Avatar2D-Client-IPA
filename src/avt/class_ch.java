package avt;

import main.GameCanvas;

final class class_ch implements IAction {
   private MoneyScr a;
   private final String b;
   private final TField[] c;

   class_ch(MoneyScr var1, String var2, TField[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      MoneyScr var10000 = this.a;
      String var10001 = this.b;
      String var10002 = this.c[0].f();
      String var4 = this.c[1].f();
      String var3 = var10002;
      String var2 = var10001;
      MoneyScr var1 = var10000;
      if (var3.equals("")) {
         GameCanvas.b(T1.en[0]);
      } else if (var4.equals("")) {
         GameCanvas.b(T1.en[1]);
      } else {
         GlobalService.gI().b(var2, var3, var4);
         var1.a(var1.ac.c, var1.ac.e);
         GameCanvas.i();
      }
   }
}

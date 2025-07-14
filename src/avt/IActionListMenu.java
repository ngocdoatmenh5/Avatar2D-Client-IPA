package avt;

import java.util.Vector;

final class IActionListMenu implements IAction {
   final ListScr a;
   private final String b;
   private final String[] c;
   private final int d;
   private final byte e;
   private final byte[] f;

   IActionListMenu(ListScr var1, String var2, String[] var3, int var4, byte var5, byte[] var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public final void perform() {
      Vector var1 = new Vector();
      if (!ListScr.a(this.a) && this.b.equals(ListScr.h)) {
         var1.addElement(new Command(T.f, 50));
      }

      for(int var2 = 0; var2 < this.c.length; ++var2) {
         var1.addElement(new Command(this.c[var2], new class_ib(this, this.d, this.e, this.f, var2)));
      }

      MenuSub.a().a(var1, 0);
   }
}

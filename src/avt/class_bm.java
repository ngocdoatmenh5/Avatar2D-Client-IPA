package avt;

import main.GameMidlet;

final class class_bm implements IAction {
   private final String a;
   private final String b;

   class_bm(GlobalMessageHandler var1, String var2, String var3) {
      this.a = var2;
      this.b = var3;
   }

   public final void perform() {
      GameMidlet.a(this.a, this.b);
   }
}

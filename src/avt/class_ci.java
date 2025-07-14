package avt;

import main.GameMidlet;

final class class_ci implements IAction {
   private final String a;

   class_ci(MoneyScr var1, String var2) {
      this.a = var2;
   }

   public final void perform() {
      GameMidlet.b(this.a);
   }
}

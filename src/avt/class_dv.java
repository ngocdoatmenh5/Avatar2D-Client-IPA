package avt;

import main.GameMidlet;

final class class_dv implements IAction {
   private final String a;

   class_dv(GlobalLogicHandler var1, String var2) {
      this.a = var2;
   }

   public final void perform() {
      GameMidlet.b(this.a);
   }
}

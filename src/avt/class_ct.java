package avt;

import main.GameCanvas;

final class class_ct implements IAction {
   private String a;
   private MiniMap b;

   public class_ct(MiniMap var1, String var2) {
      this.b = var1;
      this.a = var2;
   }

   public final void perform() {
      GameCanvas.a(this.a, (IAction)(new IActionYesRef(this.b)));
   }
}

package avt;

import main.Canvas;

final class class_ay implements IAction {
   private String a;
   private MiniMap b;

   public class_ay(MiniMap var1, String var2) {
      this.b = var1;
      this.a = var2;
   }

   public final void perform() {
      Canvas.b(this.a, new IActionYesRef(this.b));
   }
}

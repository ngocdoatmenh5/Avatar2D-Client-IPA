package avt;

import main.GameCanvas;

final class class_cg implements IAction {
   short a;
   private String c;
   byte b;

   public class_cg(HouseScr var1, byte var2, short var3, String var4) {
      this.b = var2;
      this.a = var3;
      this.c = var4;
   }

   public final void perform() {
      GameCanvas.a(this.c, (IAction)(new class_gm(this)));
   }
}

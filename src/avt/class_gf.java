package avt;

import main.GameCanvas;
import main.GameMidlet;

final class class_gf implements IAction {
   private final SeriPart a;
   private final int b;
   private final int c;
   private final int d;

   class_gf(MapScr var1, SeriPart var2, int var3, int var4, int var5) {
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public final void perform() {
      Part var1 = AvatarData.a(this.a.a);
      if (this.b == GameMidlet.i.w && (!AvatarData.c((int)var1.j) || this.c != 0)) {
         GameCanvas.a(T1.es[this.c], (IAction)(new class_gd(this, this.c, this.d, this.a)));
      }

   }
}

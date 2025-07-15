package avt;

import main.GameMidlet;

final class class_io implements IAction {
   private MapScr a;
   private final int b;

   class_io(MapScr var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      if (GameMidlet.avatar.action != 2) {
         MapScr.doAction(MapScr.ac[this.b]);
      }

   }
}

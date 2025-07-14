package avt;

import java.util.Vector;

final class class_ee implements IAction {
   private final Command a;

   class_ee(MapScr var1, Command var2) {
      this.a = var2;
   }

   public final void perform() {
      Vector var1;
      (var1 = new Vector()).addElement(this.a);
      var1.addElement(new Command(T.dk, new class_ed(this)));
      MenuSub.gI().startAt(var1, 0);
   }
}

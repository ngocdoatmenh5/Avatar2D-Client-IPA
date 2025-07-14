package avt;

import java.util.Vector;

final class class_dd implements IAction {
   class_dd(HouseScr var1) {
   }

   public final void perform() {
      Vector var1;
      (var1 = new Vector()).addElement(new Command(T.dk, 14));
      var1.addElement(new Command(T.t, 15));
      MenuSub.a().a(var1, 0);
   }
}

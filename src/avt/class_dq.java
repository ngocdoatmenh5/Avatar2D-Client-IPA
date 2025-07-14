package avt;

import main.Canvas;
import main.GameMidlet;

final class class_dq implements IAction {
   class_dq(GlobalLogicHandler var1) {
   }

   public final void perform() {
      GameMidlet.e = 8;
      GlobalMessageHandler.a().a = null;
      Session_ME.a().c();
      LoginScr.b().a();
      Canvas.t = null;
      SoundManager.a.a();
      FarmData.a();
   }
}

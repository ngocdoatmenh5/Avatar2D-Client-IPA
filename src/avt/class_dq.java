package avt;

import main.Canvas;
import main.GameMidlet;

final class class_dq implements IAction {
   class_dq(GlobalLogicHandler var1) {
   }

   public final void perform() {
      GameMidlet.CLIENT_TYPE = 8;
      GlobalMessageHandler.gI().miniGameMessageHandler = null;
      Session_ME.a().c();
      LoginScr.gI().switchToMe();
      Canvas.menuMain = null;
      SoundManager.a.a();
      FarmData.a();
   }
}

package avt;

import main.Canvas;

final class class_dj implements IAction {
   class_dj(Welcome var1) {
   }

   public final void perform() {
      Canvas.startOKDlg(T.dB, (IAction)(new class_di(this)));
   }
}

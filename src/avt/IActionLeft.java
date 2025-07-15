package avt;

import main.Canvas;

final class IActionLeft implements IAction {
   IActionLeft(Welcome var1) {
   }

   public final void perform() {
      Canvas.startOKDlg(T.dB, (IAction)(new IActionLeft1(this)));
   }
}

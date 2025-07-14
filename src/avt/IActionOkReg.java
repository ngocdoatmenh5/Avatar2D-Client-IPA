package avt;

import main.Canvas;

final class IActionOkReg implements IAction {
   private final TField[] a;

   IActionOkReg(IActionYesRef var1, TField[] var2) {
      this.a = var2;
   }

   public final void perform() {
      if (this.a[0].f().equals("")) {
         Canvas.startOKDlg("Bạn chưa nhập tên");
      } else if (!this.a[1].f().equals("") && !this.a[2].f().equals("")) {
         if (!this.a[1].f().equals(this.a[2].f())) {
            Canvas.startOKDlg("Hai mật khẩu không giống nhau");
         } else {
            Canvas.currentFace = null;
            GlobalService.gI().c(this.a[0].f().toLowerCase(), this.a[1].f().toLowerCase(), this.a[3].f());
         }
      } else {
         Canvas.startOKDlg("Bạn chưa nhập mật khẩu");
      }
   }
}

package avt;

import main.Canvas;

final class class_gt implements IAction {
   private Part a;
   private short b;
   private int c;
   private String d;
   private int e;
   private int f;
   private MapScr g;

   public class_gt(MapScr var1, Part var2, short var3, int var4, String var5, int var6, int var7) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.e = var4;
      this.d = var5;
      this.c = var6;
      this.f = var7;
   }

   public final void perform() {
      if (this.e == 100) {
         Canvas.a(T.cP, (IAction)(new class_kw(this.g, this.b)));
      } else if (this.e == 26) {
         Canvas.endDlg();
         MapScr.gI().e(this.b);
         PopupShop.b().close();
      } else {
         Part var1 = this.a;
         if (this.a.IDPart == -1) {
            var1 = AvatarData.getPart(this.b);
         }

         if (this.c != -1 && this.e != 17 && this.e != 18) {
            Canvas.a(this.d, (IAction)(new class_eq(this.g, this.c, this.e, this.f)));
         } else {
            MapScr.b(var1);
         }
      }
   }
}

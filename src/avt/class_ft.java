package avt;

import javax.microedition.lcdui.Graphics;

final class class_ft extends class_jt {
   private final Point a;

   class_ft(FarmScr var1, Point var2) {
      this.a = var2;
   }

   public final void a(Graphics var1) {
      PaintPopup.a(this.a.aw * AvMain.Y, this.a.ax * AvMain.Y, this.a.d, this.a.e, 5921542, var1);
   }

   public final void a() {
      if (this.a.ax < this.a.g) {
         Point var10000 = this.a;
         var10000.aw += this.a.c;
         var10000 = this.a;
         var10000.ax += this.a.b;
         ++this.a.b;
      } else {
         this.a.c = 0;
         this.a.b = 0;
      }
   }
}

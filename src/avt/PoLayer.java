package avt;

import javax.microedition.lcdui.Graphics;

final class PoLayer extends class_jt {
   private final Point a;

   PoLayer(FarmScr var1, Point var2) {
      this.a = var2;
   }

   public final void a(Graphics var1) {
      PaintPopup.a(this.a.x * AvMain.hd, this.a.y * AvMain.hd, this.a.w, this.a.e, 5921542, var1);
   }

   public final void a() {
      if (this.a.y < this.a.limitY) {
         Point var10000 = this.a;
         var10000.x += this.a.c;
         var10000 = this.a;
         var10000.y += this.a.b;
         ++this.a.b;
      } else {
         this.a.c = 0;
         this.a.b = 0;
      }
   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class class_il {
   private static class_il a;
   private int b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private boolean h = false;

   public static class_il a() {
      return a == null ? (a = new class_il()) : a;
   }

   public final void a(int var1, int var2) {
      if (var1 < var2) {
         this.h = true;
      } else {
         this.h = false;
         this.c = var1;
         this.b = var2;
         this.d = var2 * var2 / var1;
         if (this.d <= 0) {
            this.d = 1;
         }

      }
   }

   public final void b(int var1, int var2) {
      this.f = var1;
      this.g = var2;
      if (!this.h && (CRes.f(var2 - var1) > 5 || Canvas.y.n != 0 || Canvas.y.p)) {
         var2 = this.c * 100 / 100;
         var1 = var1 * 100 / var2;
         var2 = this.b * 100 / 100;
         this.e = var1 * var2;
      }

   }

   public final void a(Graphics var1, int var2, int var3) {
      if (!this.h && (CRes.f(this.g - this.f) > 5 || Canvas.y.n != 0 || Canvas.y.p)) {
         var1.setColor(6201499);
         var1.setClip(var2 - 1, -1, 6, this.b + 2);
         var1.fillRect(var2, 0 + this.e / 100, 4, this.d);
      }

   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

final class class_fj extends Command {
   private final Avatar f;
   private final Pet g;
   private final StringObj h;

   class_fj(String var1, IAction var2, Avatar var3, Pet var4, StringObj var5) {
      super((String)null, (IAction)null);
      this.f = var3;
      this.g = var4;
      this.h = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      this.f.a(var1, PopupShop.c / 2, 37 * AvMain.Y, true);
      if (this.g != null) {
         this.g.a(var1, PopupShop.c / 2 + 15 * AvMain.Y, 37 * AvMain.Y, this.f.W);
      }

      label50: {
         var2 = 40 * AvMain.Y;
         var3 = 15 * AvMain.Y;
         GameCanvas.N.a(var1, T1.aA + this.f.x, 0, var2, 0);
         FontX var10000;
         Graphics var10001;
         StringBuffer var10002;
         String var10003;
         if (this.f.w == GameMidlet.i.w) {
            if (GameMidlet.j.g <= 0 && GameMidlet.j.f <= 0) {
               break label50;
            }

            var10000 = GameCanvas.N;
            var10001 = var1;
            var10002 = (new StringBuffer(String.valueOf(T1.em[0]))).append(GameMidlet.j.g).append(" + ").append(GameMidlet.j.f);
            var10003 = "%";
         } else {
            if (this.f.v <= 0 && this.f.r <= 0) {
               break label50;
            }

            var10000 = GameCanvas.N;
            var10001 = var1;
            var10002 = (new StringBuffer(String.valueOf(T1.em[0]))).append(this.f.v).append(" + ");
            var10003 = this.f.r > 0 ? this.f.r + "%" : "";
         }

         var10000.a(var10001, var10002.append(var10003).toString(), 0, var2 += var3, 0);
      }

      if (this.f.u > 0 || this.f.s > 0) {
         GameCanvas.N.a(var1, T1.em[1] + this.f.u + " + " + (this.f.s > 0 ? this.f.s + "%" : ""), 0, var2 += var3, 0);
      }

      int var4 = 0;
      if (this.h.c > 125 * AvMain.Y) {
         this.h.a(100 * AvMain.Y);
         if (this.h.d >= 0) {
            var4 = this.h.d;
         }
      }

      GameCanvas.N.a(var1, this.h.a, 0 - var4, var2 += var3, 0);
      if (MapScr.u) {
         GameCanvas.N.a(var1, T1.dE + this.f.a[3] + T1.l(), 0, var2 + var3, 0);
      }

   }
}

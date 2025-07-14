package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class class_fu extends Command {
   private final int f;

   class_fu(FarmScr var1, String var2, int var3, int var4, int var5) {
      super(var2, 7, var4);
      this.f = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmData.b[this.f].a(var1, 7, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }

   public final void a() {
      if (this.f == PopupShop.j && PopupShop.n) {
         PopupShop.n();
         PopupShop.a(FarmData.b[this.f].k + "(" + FarmData.b[this.f].e + T1.bq + ")");
         PopupShop.a(T1.az + Canvas.a(FarmData.b[this.f].g[0], FarmData.b[this.f].g[1], false));
         PopupShop.a(T1.em[2] + ": " + FarmData.b[this.f].m);
         if (FarmData.b[this.f].l) {
            FarmItem var1 = FarmScr.b(FarmData.b[this.f].j);
            PopupShop.a(T1.dP + ": " + var1.f);
         }

         PopupShop.a(T1.dQ + ": " + Canvas.getMoneys(FarmData.b[this.f].i));
         PopupShop.a(MapScr.r());
      }

   }
}

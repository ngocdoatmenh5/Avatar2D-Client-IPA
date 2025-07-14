package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class CommandCooking1 extends Command {
   private final Food f;
   private final int g;

   CommandCooking1(FarmScr var1, String var2, IAction var3, Food var4, int var5) {
      super(var2, var3);
      this.f = var4;
      this.g = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      FarmItem var4 = FarmScr.b(this.f.b);
      FarmData.a(var1, var4.b, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
      var1.translate(0, CameraList.i);
      var1.setClip(0, 0, 5 * PopupShop.e, PopupShop.d);
      if (this.g == PopupShop.j) {
         for(var2 = 0; var2 < this.f.e.length; ++var2) {
            Item var5;
            if (this.f.e[var2] < 50) {
               var5 = FarmScr.g(this.f.e[var2]);
               FarmData.b((int)this.f.e[var2]).a(var1, 7, PopupShop.c / 2 - this.f.e.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.af << 2) + 10 * (AvMain.hd - 1), 3);
            } else if (this.f.e[var2] < 100) {
               var5 = FarmScr.g(this.f.e[var2]);
               AnimalInfo var6 = FarmData.getAnimalByID(this.f.e[var2]);
               AvatarData.a(var1, var6.iconProduct, PopupShop.c / 2 - this.f.e.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.af << 2) + 10 * (AvMain.hd - 1), 3);
            } else {
               var5 = FarmScr.f(this.f.e[var2]);
               var4 = FarmScr.b(this.f.e[var2]);
               FarmData.a(var1, var4.b, PopupShop.c / 2 - this.f.e.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.af << 2) + 10 * (AvMain.hd - 1), 3);
            }

            FontX var7 = Canvas.N;
            if (var5 == null || var5.e < this.f.f[var2]) {
               var7 = Canvas.M;
            }

            var7.a(var1, String.valueOf(this.f.f[var2]), PopupShop.c / 2 - this.f.e.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd - 1 + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.af << 2) + 8 * AvMain.hd + 10 * (AvMain.hd - 1), 2);
            if (var2 != this.f.e.length - 1) {
               Canvas.N.a(var1, "+", PopupShop.c / 2 - this.f.e.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.af << 2) + 10 * (AvMain.hd - 1), 2);
            }
         }
      }

      var1.setClip(0, 0, 5 * PopupShop.e, PopupShop.f * PopupShop.e - PopupShop.l);
      var1.translate(0, -CameraList.i);
   }

   public final void a() {
      if (this.g == PopupShop.j) {
         PopupShop.n();
         PopupShop.a(this.f.d);
         PopupShop.a(T1.eM + this.f.c + "p");
         FarmItem var1;
         if ((var1 = FarmScr.b(this.f.b)).g > 0) {
            PopupShop.a(T1.eJ + Canvas.getMoneys(var1.g) + T1.T);
         } else if (var1.h > 0) {
            PopupShop.a(T1.eJ + Canvas.getMoneys(var1.h) + T1.T);
         }

         PopupShop.a(T1.eK);
      }

   }
}

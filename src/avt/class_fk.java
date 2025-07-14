package avt;

import javax.microedition.lcdui.Graphics;

final class class_fk extends Command {
   private final class_kp f;

   class_fk(MapScr var1, String var2, IAction var3, class_kp var4) {
      super((String)null, (IAction)null);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      var2 = PopupShop.c / 2 + 7;
      int var4 = (var3 = (PopupShop.d - MyScreen.at - (AvMain.Z << 1)) / 7) / 2 - MapScr.k.getHeight() / 2;
      MapScr.a(var1, T1.eu[0] + this.f.g, var2, var4, this.f.f);
      MapScr.a(var1, T1.eu[1], var2, var4 += var3, this.f.a);
      MapScr.a(var1, T1.eu[2], var2, var4 += var3, this.f.b);
      MapScr.a(var1, T1.eu[3], var2, var4 += var3, this.f.e);
      MapScr.a(var1, T1.eu[4], var2, var4 += var3, this.f.c);
      MapScr.a(var1, T1.eu[5], var2, var4 + var3, this.f.d);
   }
}

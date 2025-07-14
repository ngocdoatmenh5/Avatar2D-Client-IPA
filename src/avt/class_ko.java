package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

final class class_ko extends Command {
   private int f = 0;
   private Item g;

   public class_ko(FarmScr var1, String var2, IAction var3, int var4, Item var5) {
      super(var2, var3);
      this.f = var4;
      this.g = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      if (this.g.a < 50) {
         FarmData.b((int)this.g.a).a(var1, 7, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
      } else {
         int var10002 = var2 + PopupShop.e / 2;
         int var10003 = var3 + PopupShop.e / 2;
         AvatarData.a(var1, FarmData.c(this.g.a).h, var10002, var10003, 3);
      }
   }

   public final void a() {
      if (this.f == PopupShop.j) {
         PopupShop.n();
         short var10000 = this.g.a;
         boolean var10001 = true;
         PopupShop.a(this.g.f);
         PopupShop.a(T1.ay + this.g.e);
         PopupShop.a(T1.aK + GameCanvas.b(this.g.d[0] * this.g.e) + T1.T);
         PopupShop.a(MapScr.r());
      }

   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

final class class_jx extends Command {
   private Part f;
   private short g;
   private int h;
   private int i;
   private MapScr j;

   public class_jx(MapScr var1, String var2, class_gt var3, Part var4, short var5, int var6, int var7, int var8) {
      super(var2, var3);
      this.j = var1;
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
   }

   public final void a() {
      if (PopupShop.n && this.h == PopupShop.j) {
         Part var1 = this.f;
         if (this.f.IDPart == -1) {
            var1 = AvatarData.a(this.g);
         }

         if (var1.IDPart != -1) {
            MapScr.a(var1);
            PopupShop.n();
            PopupShop.a(var1.l);
            if (this.i == -1) {
               PopupShop.a(Canvas.a(var1.i[0], var1.i[1], false));
            }

            if (var1.f == -1) {
               PopupShop.a(T1.em[0] + ((APartInfo)var1).level);
            }

            PopupShop.a(T1.ao + GameMidlet.avatar.strMoney);
            if (MapScr.isNewVersion) {
               PopupShop.a(T1.dE + GameMidlet.avatar.money[3] + " " + T1.k());
            }
         }
      }

   }

   public final void a(Graphics var1, int var2, int var3) {
      Part var4 = this.f;
      if (this.f.IDPart == -1) {
         var4 = AvatarData.a(this.g);
      }

      if (var4.IDPart != -1) {
         var4.a(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
      }

   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

final class CommandShop1 extends Command {
   private int f = 0;
   private String g;
   private String h;
   private short i;
   private short j;
   private int k;

   public CommandShop1(HouseScr var1, String var2, IAction var3, int var4, String var5, short var6, short var7, String var8, int var9, String var10, short var11) {
      super(var2, var3);
      this.f = var4;
      this.g = var5;
      this.i = var6;
      this.h = var8;
      this.k = var9;
      this.j = var11;
   }

   public final void a() {
      if (PopupShop.n && this.f == PopupShop.j) {
         PopupShop.n();
         Part var1;
         if (GameMidlet.avatar.gender == 1) {
            var1 = AvatarData.getPart(this.i);
         } else {
            var1 = AvatarData.getPart(this.j);
         }

         if (var1.IDPart != -1) {
            if (GameMidlet.avatar.gender == 1) {
               MapScr.gI();
               MapScr.a(var1);
            } else {
               MapScr.gI();
               MapScr.a(var1);
            }
         }

         PopupShop.a(this.g);
         if (this.h != null) {
            PopupShop.a(this.h);
         }

         if (this.k >= 0) {
            PopupShop.a(T.az + Canvas.getMoneys(this.k) + " Tim");
         }
      }

   }

   public final void a(Graphics var1, int var2, int var3) {
      Part var4;
      if (GameMidlet.avatar.gender == 1) {
         var4 = AvatarData.getPart(this.i);
      } else {
         var4 = AvatarData.getPart(this.j);
      }

      var4.paintIcon(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }
}

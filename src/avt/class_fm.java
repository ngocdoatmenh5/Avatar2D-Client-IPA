package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class class_fm extends Command {
   private final String f;
   private final Avatar g;
   private final Avatar h;
   private final short i;
   private final byte j;
   private final byte k;
   private final String l;

   class_fm(MapScr var1, String var2, IAction var3, String var4, Avatar var5, Avatar var6, short var7, byte var8, byte var9, String var10) {
      super(var2, (IAction)null);
      this.f = var4;
      this.g = var5;
      this.h = var6;
      this.i = var7;
      this.j = var8;
      this.k = var9;
      this.l = var10;
   }

   public final void a(Graphics var1, int var2, int var3) {
      var2 = 15 * AvMain.hd;
      Canvas.K.a(var1, this.f, PopupShop.c / 2 - 7, var2, 2);
      var2 += this.g.height + Canvas.K.a() + 15 * AvMain.hd;
      this.g.paintIcon(var1, PopupShop.c / 4 - 7, var2, true);
      this.h.paintIcon(var1, PopupShop.c / 4 * 3 - 7, var2, true);
      ImageIcon var4;
      if ((var4 = AvatarData.getImgIcon(this.i)).count != -1) {
         var1.drawImage(var4.img, PopupShop.c / 2 - 7, var2 - this.g.height / 2, 3);
         if (this.j > 0) {
            Canvas.N.a(var1, "lv" + this.j + "+" + this.k + "%", PopupShop.c / 2 - 7, var2, 2);
            var2 += Canvas.N.a();
            MapScr.a(var1, "", PopupShop.c / 2 - 8, var2, this.k);
         }
      }

      var2 += Canvas.N.a() << 1;
      Canvas.K.a(var1, this.l, PopupShop.c / 2 - 7, var2 - 5, 2);
   }

   public final void a() {
      this.h.update();
   }
}

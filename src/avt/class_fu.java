package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class class_fu extends Command {
   private final int f;

   class_fu(FarmScr var1, String var2, int var3, int var4, int var5) {
      super(var2, 7, var4);
      this.f = var5;
   }

   public final void paint(Graphics var1, int var2, int var3) {
      FarmData.treeInfo[this.f].a(var1, 7, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
   }

   public final void update() {
      if (this.f == PopupShop.focus && PopupShop.isTransFocus) {
         PopupShop.resetIsTrans();
         PopupShop.addStr(FarmData.treeInfo[this.f].name1 + "(" + FarmData.treeInfo[this.f].harvestTime + T.bq + ")");
         PopupShop.addStr(T.az + Canvas.getPriceMoney(FarmData.treeInfo[this.f].priceSeed[0], FarmData.treeInfo[this.f].priceSeed[1], false));
         PopupShop.addStr(T.em[2] + ": " + FarmData.treeInfo[this.f].m);
         if (FarmData.treeInfo[this.f].l) {
            FarmItem var1 = FarmScr.b(FarmData.treeInfo[this.f].j);
            PopupShop.addStr(T.dP + ": " + var1.des);
         }

         PopupShop.addStr(T.dQ + ": " + Canvas.getMoneys(FarmData.treeInfo[this.f].numProduct));
         PopupShop.addStr(MapScr.r());
      }

   }
}

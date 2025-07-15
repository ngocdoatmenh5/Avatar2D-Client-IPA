package avt;

import javax.microedition.lcdui.Graphics;

final class CommandOpenKhoHang2 extends Command {
   private Item item;
   private final int ii;

   CommandOpenKhoHang2(FarmScr var1, String var2, int var3, int var4, int var5) {
      super(var2, 13, var4);
      this.ii = var5;
      this.item = (Item)FarmScr.listItemFarm.elementAt(var5);
   }

   public final void paint(Graphics var1, int var2, int var3) {
      FarmScr.getFarmItem(this.item.ID).paint(var1, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 0, 3);
   }

   public final void update() {
      if (PopupShop.isTransFocus && this.ii == PopupShop.focus - FarmScr.getItemSeed().size()) {
         PopupShop.resetIsTrans();
         PopupShop.addStr(FarmScr.getFarmItem(this.item.ID).des);
         FarmItem var1 = FarmScr.getFarmItem(this.item.ID);
         int var2 = this.item.number;
         if (var1.type == 4) {
            var2 -= FarmScr.listFood[1].size();
         } else if (var1.type == 1) {
            var2 -= FarmScr.listFood[0].size();
         }

         PopupShop.addStr(T.ay + var2);
      }

   }
}

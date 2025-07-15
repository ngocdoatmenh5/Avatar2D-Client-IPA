package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

final class CommandCooking1 extends Command {
   private final Food food;
   private final int g;

   CommandCooking1(FarmScr var1, String var2, IAction var3, Food var4, int var5) {
      super(var2, var3);
      this.food = var4;
      this.g = var5;
   }

   public final void paint(Graphics var1, int var2, int var3) {
      FarmItem var4 = FarmScr.getFarmItem(this.food.productID);
      FarmData.paintImg(var1, var4.IDImg, var2 + PopupShop.e / 2, var3 + PopupShop.e / 2, 3);
      var1.translate(0, CameraList.cmtoY);
      var1.setClip(0, 0, 5 * PopupShop.e, PopupShop.d);
      if (this.g == PopupShop.focus) {
         for(var2 = 0; var2 < this.food.material.length; ++var2) {
            Item var5;
            if (this.food.material[var2] < 50) {
               var5 = FarmScr.getProductByID(this.food.material[var2]);
               FarmData.getTreeByID((int)this.food.material[var2]).a(var1, 7, PopupShop.c / 2 - this.food.material.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.hBlack << 2) + 10 * (AvMain.hd - 1), 3);
            } else if (this.food.material[var2] < 100) {
               var5 = FarmScr.getProductByID(this.food.material[var2]);
               AnimalInfo var6 = FarmData.getAnimalByID(this.food.material[var2]);
               AvatarData.paintImg(var1, var6.iconProduct, PopupShop.c / 2 - this.food.material.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.hBlack << 2) + 10 * (AvMain.hd - 1), 3);
            } else {
               var5 = FarmScr.getItemProductByID(this.food.material[var2]);
               var4 = FarmScr.getFarmItem(this.food.material[var2]);
               FarmData.paintImg(var1, var4.IDImg, PopupShop.c / 2 - this.food.material.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.hBlack << 2) + 10 * (AvMain.hd - 1), 3);
            }

            FontX var7 = Canvas.fontChatB;
            if (var5 == null || var5.number < this.food.numberMaterial[var2]) {
               var7 = Canvas.M;
            }

            var7.drawString(var1, String.valueOf(this.food.numberMaterial[var2]), PopupShop.c / 2 - this.food.material.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd - 1 + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.hBlack << 2) + 8 * AvMain.hd + 10 * (AvMain.hd - 1), 2);
            if (var2 != this.food.material.length - 1) {
               Canvas.fontChatB.drawString(var1, "+", PopupShop.c / 2 - this.food.material.length * 30 * AvMain.hd / 2 + var2 * 30 * AvMain.hd + 15 * AvMain.hd + 15 * (AvMain.hd - 1), (PopupShop.e << 1) + 25 * AvMain.hd + (AvMain.hBlack << 2) + 10 * (AvMain.hd - 1), 2);
            }
         }
      }

      var1.setClip(0, 0, 5 * PopupShop.e, PopupShop.f * PopupShop.e - PopupShop.l);
      var1.translate(0, -CameraList.cmtoY);
   }

   public final void update() {
      if (this.g == PopupShop.focus) {
         PopupShop.resetIsTrans();
         PopupShop.addStr(this.food.text);
         PopupShop.addStr(T.eM + this.food.cookTime + "p");
         FarmItem var1;
         if ((var1 = FarmScr.getFarmItem(this.food.productID)).priceXu > 0) {
            PopupShop.addStr(T.eJ + Canvas.getMoneys(var1.priceXu) + T.T);
         } else if (var1.priceLuong > 0) {
            PopupShop.addStr(T.eJ + Canvas.getMoneys(var1.priceLuong) + T.T);
         }

         PopupShop.addStr(T.eK);
      }

   }
}

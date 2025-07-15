package avt;

import main.GameMidlet;

final class class_gi implements IAction {
   final HouseScr a;
   private final int b;
   private final String c;

   class_gi(HouseScr var1, int var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      HouseScr.setStatusBuyItem(this.a);
      if (HouseScr.getxTemp(this.a) != -1) {
         HouseScr.setX(this.a, HouseScr.getxTemp(this.a));
         HouseScr.setyTemp(this.a, HouseScr.getYtemp(this.a));
         GameMidlet.avatar.x = HouseScr.getxTemp(this.a) * 24;
         GameMidlet.avatar.y = HouseScr.getYtemp(this.a) * 24;
         AvCamera.gI().setToPos(GameMidlet.avatar.x * AvMain.hd, GameMidlet.avatar.y * AvMain.hd);
      }

      HouseScr.isSelectObj = true;
      HouseScr.isChange = true;
      HouseScr.setSelectedIndex(this.a, this.b);
      this.a.center = new Command(T.cS, new class_gh(this, this.b, this.c));
      this.a.left = null;
      this.a.right = null;
   }
}

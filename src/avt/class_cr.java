package avt;

final class class_cr implements IAction {
   private HouseScr a;
   private final MapItemType b;
   private final String c;

   class_cr(HouseScr var1, MapItemType var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      MapItem var1 = new MapItem(1, HouseScr.d(this.a) * 24, HouseScr.e(this.a) * 24, 1, this.b.idType);
      AvatarService.gI().doBuyItemHouse(var1);
      HouseScr.a(this.a, this.c);
   }
}

package avt;

final class class_ga implements IAction {
   private HouseScr a;
   private final MapItem b;

   class_ga(HouseScr var1, MapItem var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      if (!HouseScr.a(this.a, AvatarData.getMapItemTypeByID((int)this.b.typeID))) {
         AvatarService.gI().doSortItem(HouseScr.g(this.a).anchor, HouseScr.g(this.a).x, HouseScr.g(this.a).y, HouseScr.d(this.a), HouseScr.e(this.a), this.b.dir);
         HouseScr.b = false;
         this.a.d = -1;
         HouseScr.c(this.a, -1);
         HouseScr.e = false;
         this.a.c(this.b);
         if (HouseScr.a(this.a, this.b)) {
            ++this.b.y;
         }

         LoadMap.orderVector(LoadMap.treeLists);
         HouseScr.h(this.a);
      }
   }
}

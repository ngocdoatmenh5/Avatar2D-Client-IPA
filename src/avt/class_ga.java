package avt;

final class class_ga implements IAction {
   private HouseScr a;
   private final MapItem b;

   class_ga(HouseScr var1, MapItem var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void perform() {
      if (!HouseScr.a(this.a, AvatarData.b((int)this.b.b))) {
         AvatarService.a().a(HouseScr.g(this.a).c, HouseScr.g(this.a).a, HouseScr.g(this.a).b, HouseScr.d(this.a), HouseScr.e(this.a), this.b.c);
         HouseScr.b = false;
         this.a.d = -1;
         HouseScr.c(this.a, -1);
         HouseScr.e = false;
         this.a.c(this.b);
         if (HouseScr.a(this.a, this.b)) {
            ++this.b.ax;
         }

         LoadMap.a(LoadMap.l);
         HouseScr.h(this.a);
      }
   }
}

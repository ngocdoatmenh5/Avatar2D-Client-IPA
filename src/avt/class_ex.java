package avt;

public final class class_ex extends AnimalDan {
   public static int r = 0;
   public static AvPosition s;

   public class_ex(int var1, byte var2, byte var3) {
      super(0, 0, var1, var2);
      super.captainID = 0;
      super.indexFood = 0;
      ++r;
   }

   public final void setInit() {
      super.posNext = new AvPosition();
      if (super.captainID == super.IDDB) {
         super.x = super.xCur = super.posNext.a = (FarmScr.w + 3) * 24 + j();
         super.y = super.yCur = super.posNext.b = 72 + (CRes.rnd(24) << 2);
      } else {
         this.updatePos();
         if (!LoadMap.isTrans(super.x, super.y)) {
            AvPosition var2 = new AvPosition((FarmScr.w + 3) * 24 + j(), 72 + (CRes.rnd(24) << 2));
            super.posNext = var2;
         }

         super.x = super.xCur = super.posNext.a;
         super.y = super.yCur = super.posNext.b;
      }
   }

   private static int j() {
      return CRes.rnd((LoadMap.wMap - FarmScr.x - FarmScr.w - 5) * 6) << 2;
   }

   public final void setFollowPos(AvPosition var1) {
      AvPosition var2 = new AvPosition(var1.a - 48 + j(), var1.b - 48 + (CRes.rnd(24) << 2));
      super.posNext = var2;
   }

   public final void setPos() {
      super.setPos();
   }
}

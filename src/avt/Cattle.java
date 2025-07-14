package avt;

public final class Cattle extends Animal {
   public static AvPosition r;
   public static AvPosition s;
   public static byte t = 0;
   public static byte u = 5;
   public static short v = -1;

   public Cattle() {
   }

   public Cattle(int var1, byte var2) {
      super(0, 0, var1, var2);
      ++t;
   }

   public final void setInit() {
      this.setPos(FarmScr.C.a + 48 + (CRes.rnd((FarmScr.w - 2) * 6) << 2), FarmScr.C.b + 24 + (CRes.rnd(12) << 2));
   }

   public final void updatePos() {
      super.posNext = new AvPosition();
      AvPosition var2;
      if (!super.isEat) {
         var2 = new AvPosition(FarmScr.C.a + 12 + (CRes.rnd(FarmScr.w * 6) << 2), FarmScr.C.b + 12 + (CRes.rnd(18) << 2));
         super.posNext = var2;
      } else {
         var2 = r;
         super.posNext = var2;
      }
   }

   public final void updateEat() {
      if (super.hunger && !super.isEat) {
         if (v != -1) {
            super.isEat = true;
         }

      }
   }

   public final void reset() {
      super.reset();
      if (super.isEat && CRes.f(r.a - super.x) < 20 && CRes.f(r.b - super.y) < 15) {
         super.isEat = false;
         super.hunger = false;
         FarmScr.b();
         FarmScr.a(v, super.IDDB);
      }

      super.cycle = 100 + 50 * (super.species - 50);
   }
}

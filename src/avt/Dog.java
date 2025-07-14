package avt;

public final class Dog extends Animal {
   public static boolean r = false;
   public static AvPosition s;
   public static byte t = 0;
   public static short u = -1;

   public Dog() {
   }

   public Dog(int var1, byte var2) {
      super(0, 0, var1, var2);
      ++t;
   }

   public final void setInit() {
      this.setPos((FarmScr.w + 3) * 24 + (CRes.rnd((LoadMap.wMap - FarmScr.x - FarmScr.w - 5) * 6) << 2), 48 + (CRes.rnd(30) << 2));
   }

   public final void updateEat() {
      if (u == -1) {
         super.isEat = false;
      } else if (super.hunger && !super.isEat) {
         super.isEat = true;
      }
   }

   public final void updatePos() {
      super.posNext = new AvPosition();
      this.setPos();
   }

   public final void setPos() {
      AvPosition var2;
      if (super.isEat) {
         super.G = 2;
         var2 = s;
         super.posNext = var2;
      } else {
         var2 = new AvPosition(288 + (CRes.rnd(126) << 2), 24 + (CRes.rnd(36) << 2));
         super.posNext = var2;
      }
   }

   public final void reset() {
      if (!super.isEat && CRes.d(2) == 0) {
         super.cycle = 200;
      }

      if (super.isEat && CRes.a(s.x, s.y, super.x, super.y) < 18) {
         super.isEat = false;
         super.hunger = false;
         super.cycle = 200;
         FarmScr.b();
         FarmScr.a(u, super.IDDB);
      }

      super.reset();
   }
}

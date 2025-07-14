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

   public final void a() {
      this.a(FarmScr.C.a + 48 + (CRes.e((FarmScr.w - 2) * 6) << 2), FarmScr.C.b + 24 + (CRes.e(12) << 2));
   }

   public final void c() {
      super.n = new AvPosition();
      AvPosition var2;
      if (!super.f) {
         var2 = new AvPosition(FarmScr.C.a + 12 + (CRes.e(FarmScr.w * 6) << 2), FarmScr.C.b + 12 + (CRes.e(18) << 2));
         super.n = var2;
      } else {
         var2 = r;
         super.n = var2;
      }
   }

   public final void d() {
      if (super.i && !super.f) {
         if (v != -1) {
            super.f = true;
         }

      }
   }

   public final void h() {
      super.h();
      if (super.f && CRes.f(r.a - super.aw) < 20 && CRes.f(r.b - super.ax) < 15) {
         super.f = false;
         super.i = false;
         FarmScr.b();
         FarmScr.a(v, super.w);
      }

      super.e = 100 + 50 * (super.k - 50);
   }
}

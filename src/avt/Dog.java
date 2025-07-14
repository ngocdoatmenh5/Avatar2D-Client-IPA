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

   public final void a() {
      this.a((FarmScr.w + 3) * 24 + (CRes.e((LoadMap.e - FarmScr.x - FarmScr.w - 5) * 6) << 2), 48 + (CRes.e(30) << 2));
   }

   public final void d() {
      if (u == -1) {
         super.f = false;
      } else if (super.i && !super.f) {
         super.f = true;
      }
   }

   public final void c() {
      super.n = new AvPosition();
      this.g();
   }

   public final void g() {
      AvPosition var2;
      if (super.f) {
         super.G = 2;
         var2 = s;
         super.n = var2;
      } else {
         var2 = new AvPosition(288 + (CRes.e(126) << 2), 24 + (CRes.e(36) << 2));
         super.n = var2;
      }
   }

   public final void h() {
      if (!super.f && CRes.d(2) == 0) {
         super.e = 200;
      }

      if (super.f && CRes.a(s.a, s.b, super.aw, super.ax) < 18) {
         super.f = false;
         super.i = false;
         super.e = 200;
         FarmScr.b();
         FarmScr.a(u, super.w);
      }

      super.h();
   }
}

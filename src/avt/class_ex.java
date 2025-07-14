package avt;

public final class class_ex extends AnimalDan {
   public static int r = 0;
   public static AvPosition s;

   public class_ex(int var1, byte var2, byte var3) {
      super(0, 0, var1, var2);
      super.t = 0;
      super.u = 0;
      ++r;
   }

   public final void a() {
      super.n = new AvPosition();
      if (super.t == super.w) {
         super.aw = super.C = super.n.a = (FarmScr.w + 3) * 24 + j();
         super.ax = super.D = super.n.b = 72 + (CRes.e(24) << 2);
      } else {
         this.c();
         if (!LoadMap.b(super.aw, super.ax)) {
            AvPosition var2 = new AvPosition((FarmScr.w + 3) * 24 + j(), 72 + (CRes.e(24) << 2));
            super.n = var2;
         }

         super.aw = super.C = super.n.a;
         super.ax = super.D = super.n.b;
      }
   }

   private static int j() {
      return CRes.e((LoadMap.e - FarmScr.x - FarmScr.w - 5) * 6) << 2;
   }

   public final void a(AvPosition var1) {
      AvPosition var2 = new AvPosition(var1.a - 48 + j(), var1.b - 48 + (CRes.e(24) << 2));
      super.n = var2;
   }

   public final void g() {
      super.g();
   }
}

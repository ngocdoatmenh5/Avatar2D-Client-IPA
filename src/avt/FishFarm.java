package avt;

import javax.microedition.lcdui.Graphics;

public final class FishFarm extends AnimalDan {
   public static int r = 5;
   private AvPosition s;
   private byte v = 0;

   public FishFarm(int var1, byte var2, byte var3) {
      super(0, 0, var1, var2);
      super.t = 0;
      super.u = 1;
      super.az = 7;
      this.s = new AvPosition(-10, 0, CRes.e(8));
   }

   public final void b() {
      if (this.s.c == 6 || this.s.a == -10) {
         this.s.a = super.aw + (super.d == 2 && super.K == 0 ? 3 : -3);
         this.s.b = super.ax + 2;
      }

      ++this.s.c;
      if (this.s.c > 17 * (3 - super.d) || this.v > 0) {
         this.s.c = 0;
      }

      AnimalInfo var1 = FarmData.c(super.k);
      super.m = var1.k[super.H][super.y];
      if (CRes.e(100) == 2 && this.v <= 0 && super.H == 0) {
         this.v = 8;
      }

      if (this.v > 0) {
         super.m = (byte)(2 - this.v / 3 + 2);
         --this.v;
         super.l = this.v;
         if (super.l >= 4) {
            super.l = (byte)(4 - this.v % 4);
         }

         super.l = (byte)(super.l + 5);
         super.l = (byte)(-super.l);
      } else {
         super.l = 0;
      }

      super.b();
   }

   public final void a(Graphics var1) {
      super.a(var1);
      if (this.s.c < 16) {
         var1.setColor(Fish.l[LoadMap.j]);
         var1.drawRoundRect((this.s.a - this.s.c / 2) * MyObject.ay, (this.s.b - this.s.c / 4) * MyObject.ay, this.s.c * MyObject.ay, this.s.c / 2 * MyObject.ay, this.s.c * MyObject.ay, this.s.c * MyObject.ay);
      }

   }

   public final void a() {
      super.n = new AvPosition();
      super.aw = super.C = super.n.a = FarmScr.D.a + CRes.e(FarmScr.x - 1) * 24;
      super.ax = super.D = super.n.b = FarmScr.D.b + 12 + CRes.e(2) * 24;
      (new StringBuffer("777777777777777777777: ")).append(super.aw).append("   ").append(super.ax).toString();
   }

   public final void g() {
      AvPosition var2 = new AvPosition(FarmScr.D.a + 30 + CRes.e(FarmScr.x - 2) * 24, FarmScr.D.b + 12 + CRes.e(2) * 24);
      super.n = var2;
   }

   public final void a(AvPosition var1) {
      AvPosition var2 = new AvPosition(var1.a - 10 + CRes.e(20), var1.b - 10 + CRes.e(20));
      super.n = var2;
   }

   public final boolean b(int var1, int var2) {
      if (super.H == -1) {
         super.E = 0;
         super.F = 0;
         return true;
      } else if (super.H != 0 && super.H != 1) {
         super.E = 0;
         super.F = 0;
         return true;
      } else {
         super.H = 1;
         int var3 = super.C;
         int var4 = super.D;
         if (!LoadMap.b(var3 + var1, var4 + var2)) {
            if (var1 != 0) {
               if (var1 > 0) {
                  super.E = super.G;
               } else {
                  super.E = -super.G;
               }
            }

            if (var2 != 0) {
               if (var2 > 0) {
                  super.F = super.G;
               } else {
                  super.F = -super.G;
               }
            }

            return false;
         } else {
            super.E = 0;
            super.F = 0;
            return true;
         }
      }
   }

   public final Point i() {
      Point var1;
      return !LoadMap.b((var1 = (Point)FarmScr.j[super.u].elementAt(CRes.e(FarmScr.j[super.u].size()))).aw, var1.ax) && var1.b == 0 ? var1 : null;
   }
}

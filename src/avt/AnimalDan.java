package avt;

public class AnimalDan extends Animal {
   public int t = 0;
   public byte u;

   public AnimalDan(int var1, int var2, int var3, byte var4) {
      super(0, 0, var3, var4);
   }

   public void b() {
      super.b();
   }

   public final void f() {
      super.f();
      if (!super.f && super.w == this.t && super.c > 150) {
         super.c = 150;
      }

   }

   public void a() {
   }

   public Point i() {
      return (Point)FarmScr.j[this.u].elementAt(CRes.e(FarmScr.j[this.u].size()));
   }

   public final void c() {
      if (!super.f && this.t == super.w) {
         this.g();
      } else {
         AvPosition var1 = new AvPosition();
         if (super.f && FarmScr.j[this.u].size() > 0) {
            Point var5;
            if ((var5 = this.i()) != null) {
               var1.a = var5.aw;
               var1.b = var5.ax;
               super.G = 2;
               super.n = var1;
            } else {
               this.g();
            }
         } else {
            int var2 = LoadMap.m.size();

            for(int var3 = 0; var3 < var2; ++var3) {
               Base var4;
               if ((var4 = (Base)LoadMap.m.elementAt(var3)) instanceof AnimalDan && var4.w == this.t) {
                  var1 = new AvPosition(var4.aw, var4.ax);
                  break;
               }
            }

            if (this.u != 1 && !LoadMap.b(super.aw, super.ax)) {
               this.g();
            } else {
               this.a(var1);
            }
         }
      }
   }

   public void a(AvPosition var1) {
   }

   public final void h() {
      int var1 = FarmScr.j[this.u].size();
      if (super.i && super.f && var1 > 0) {
         for(int var2 = 0; var2 < var1; ++var2) {
            Point var3;
            if (CRes.f((var3 = (Point)FarmScr.j[this.u].elementAt(var2)).aw - super.aw) <= 2 && CRes.f(var3.ax - super.ax) <= 2) {
               FarmScr.j[this.u].removeElement(var3);
               LoadMap.n.removeElement(var3);
               super.i = false;
               super.f = false;
               super.G = 1;
               FarmScr.b();
               FarmScr.a(var3.j, super.w);
               break;
            }
         }
      }

      super.h();
      super.e = 100 - (this.t != super.w ? this.u * CRes.e(70) : 0);
   }

   public final void d() {
      if (FarmScr.j[this.u].size() == 0) {
         super.f = false;
      } else if (super.i && !super.f) {
         super.f = true;
      }
   }
}

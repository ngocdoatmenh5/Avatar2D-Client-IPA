package avt;

import main.GameMidlet;

final class class_gi implements IAction {
   final HouseScr a;
   private final int b;
   private final String c;

   class_gi(HouseScr var1, int var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      HouseScr.a(this.a);
      if (HouseScr.b(this.a) != -1) {
         HouseScr.a(this.a, HouseScr.b(this.a));
         HouseScr.b(this.a, HouseScr.c(this.a));
         GameMidlet.i.aw = HouseScr.b(this.a) * 24;
         GameMidlet.i.ax = HouseScr.c(this.a) * 24;
         AvCamera.a().a(GameMidlet.i.aw * AvMain.Y, GameMidlet.i.ax * AvMain.Y);
      }

      HouseScr.b = true;
      HouseScr.e = true;
      HouseScr.c(this.a, this.b);
      this.a.ad = new Command(T1.cS, new class_gh(this, this.b, this.c));
      this.a.ac = null;
      this.a.ae = null;
   }
}

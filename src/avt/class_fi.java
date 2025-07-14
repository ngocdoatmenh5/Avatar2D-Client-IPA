package avt;

import main.GameCanvas;

final class class_fi implements IAction {
   private FarmScr a;
   private final FarmItem b;
   private final Item c;

   class_fi(FarmScr var1, FarmItem var2, Item var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      if (LoadMap.p != null) {
         if (this.b.e == 4) {
            FarmScr.a(this.a, (byte)4, this.c.a);
            this.a.M = (Animal)LoadMap.p;
            this.a.M.p = true;
            this.a.M.q = GameCanvas.j();
         }

         FarmService.a().b(FarmScr.b, ((Base)LoadMap.p).w, this.c.a);
      }

   }
}

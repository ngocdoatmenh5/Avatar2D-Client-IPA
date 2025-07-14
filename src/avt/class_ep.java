package avt;

import main.GameCanvas;

final class class_ep implements IAction {
   private FarmScr a;
   private final FarmItem b;
   private final short c;
   private final Animal d;

   class_ep(FarmScr var1, FarmItem var2, short var3, Animal var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public final void perform() {
      if (this.b.e == 4) {
         FarmScr.a(this.a, (byte)4, this.c);
         LoadMap.p = this.d;
         this.a.M = (Animal)LoadMap.p;
         this.a.M.p = true;
         this.a.M.q = GameCanvas.j();
      }

      FarmService.a().b(FarmScr.b, this.d.w, this.c);
   }
}

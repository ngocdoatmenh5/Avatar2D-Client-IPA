package avt;

import main.Canvas;

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
      if (LoadMap.focusObj != null) {
         if (this.b.action == 4) {
            FarmScr.a(this.a, (byte)4, this.c.ID);
            this.a.aniDoing = (Animal)LoadMap.focusObj;
            this.a.aniDoing.isStand = true;
            this.a.aniDoing.timeStand = Canvas.getSecond();
         }

         FarmService.gI().doUsingItem(FarmScr.idFarm, ((Base)LoadMap.focusObj).IDDB, this.c.ID);
      }

   }
}

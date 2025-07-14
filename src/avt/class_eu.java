package avt;

final class class_eu implements IAction {
   class_eu(FarmScr var1) {
   }

   public final void perform() {
      FarmService.gI().doUpdateStore(0, -1);
   }
}

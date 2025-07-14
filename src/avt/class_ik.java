package avt;

final class class_ik implements IAction {
   private final APartInfo a;

   class_ik(MapScr var1, APartInfo var2) {
      this.a = var2;
   }

   public final void perform() {
      ParkService.a().a(MapScr.h.IDDB, this.a.IDPart, 2);
   }
}

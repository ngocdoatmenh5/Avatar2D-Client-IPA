package avt;

final class IActionExchange implements IAction {
   private final StringObj a;

   IActionExchange(MapScr var1, StringObj var2) {
      this.a = var2;
   }

   public final void perform() {
      if (MapScr.h != null) {
         GlobalService.gI().doRequestCmdRotate(this.a.e, MapScr.h.IDDB);
      } else {
         GlobalService.gI().doRequestCmdRotate(this.a.e, -1);
      }
   }
}

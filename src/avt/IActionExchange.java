package avt;

final class IActionExchange implements IAction {
   private final StringObj a;

   IActionExchange(MapScr var1, StringObj var2) {
      this.a = var2;
   }

   public final void perform() {
      if (MapScr.h != null) {
         GlobalService.gI().b(this.a.e, MapScr.h.w);
      } else {
         GlobalService.gI().b(this.a.e, -1);
      }
   }
}

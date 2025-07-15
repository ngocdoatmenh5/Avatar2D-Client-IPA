package avt;

final class class_ej implements IAction {
   private final Avatar a;

   class_ej(MapScr var1, Avatar var2) {
      this.a = var2;
   }

   public final void perform() {
      class_cw var1 = MessageScr.gI().b(MessageScr.gI().b);
      ParkService.gI().doAddFriend(this.a.IDDB, false);
      MessageScr.gI().a(var1);
   }
}

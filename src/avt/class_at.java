package avt;

final class class_at implements IAction {
   private final Part a;

   class_at(Part var1) {
      this.a = var1;
   }

   public final void perform() {
      AvatarService.gI().doBuyItem(this.a.IDPart, 1);
   }
}

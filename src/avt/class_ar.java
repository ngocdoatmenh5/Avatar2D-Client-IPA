package avt;

final class class_ar implements IAction {
   private final Part a;

   class_ar(Part var1) {
      this.a = var1;
   }

   public final void perform() {
      AvatarService.gI().doBuyItem(this.a.IDPart, 2);
   }
}

package avt;

final class class_at implements IAction {
   private final Part a;

   class_at(Part var1) {
      this.a = var1;
   }

   public final void perform() {
      AvatarService.a().a(this.a.IDPart, 1);
   }
}

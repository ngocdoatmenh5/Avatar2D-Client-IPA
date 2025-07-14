package avt;

final class class_dk implements IAction {
   private Welcome a;

   class_dk(Welcome var1) {
      this.a = var1;
   }

   public final void perform() {
      Welcome.a(this.a);
   }
}

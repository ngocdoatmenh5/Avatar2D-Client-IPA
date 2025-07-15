package avt;

final class class_gh implements IAction {
   private class_gi a;
   private final int b;
   private final String c;

   class_gh(class_gi var1, int var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final void perform() {
      HouseScr.setxTemp(this.a.a, HouseScr.getX(this.a.a));
      HouseScr.setYtemp(this.a.a, HouseScr.getY(this.a.a));
      HouseScr.a(this.a.a, this.b, this.c);
   }
}

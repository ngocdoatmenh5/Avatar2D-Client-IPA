package avt;

final class class_ku implements IAction {
   private int a;
   private short b;
   private MapScr c;

   public class_ku(MapScr var1, int var2, short var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public final void perform() {
      if (this.a != 0 || LoadMap.k == -1) {
         MapScr.f(this.b);
      }

      PopupShop.b().close();
   }
}

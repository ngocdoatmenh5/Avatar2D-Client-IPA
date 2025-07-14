package avt;

public final class AvPosition {
   public int a;
   public int b;
   public int c;
   public short d = 0;
   public short e = -1;

   public AvPosition() {
      this.a = 0;
      this.b = 0;
   }

   public AvPosition(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public AvPosition(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }
}

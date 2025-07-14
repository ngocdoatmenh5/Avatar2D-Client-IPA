package avt;

public final class StringObj extends SubObject {
   public String a;
   public String b;
   public int c;
   private int h = 1;
   public int d = 0;
   public int e = 0;

   public StringObj() {
   }

   public StringObj(String var1, int var2) {
      this.a = var1;
      this.c = var2;
   }

   public StringObj(int var1, int var2, String var3) {
      super.x = var1;
      super.y = var2;
      this.a = var3;
   }

   public final void a(int var1) {
      this.d += this.h;
      if (this.d > this.c - var1) {
         this.d = -20;
      }

   }
}

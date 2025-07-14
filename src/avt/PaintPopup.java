package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class PaintPopup {
   public static FrameImage a;
   public static FrameImage b;
   public static PaintPopup c;
   public static int[] d;
   public int e;
   public int f;
   public int g;
   public int h;
   private int p;
   public int i;
   public int j = 10;
   public static String k;
   public int l;
   private int q = 0;
   private int r;
   public int[] m;
   public int[] n;
   private String s;
   public static byte o;

   public static PaintPopup a() {
      if (c == null) {
         c = new PaintPopup();
      }

      return c;
   }

   public PaintPopup() {
      o = (byte)(AvMain.ah << 1);
      if (Canvas.a != null && Canvas.H) {
         this.j = 17;
      } else {
         this.j = 10;
      }

      if (Canvas.Z != 0) {
         this.j *= Canvas.Z + 1;
      }

   }

   public final void a(String var1, int var2, int var3, int var4) {
      this.f = var2;
      this.e = var3;
      this.p = var4;
      if (var1 != null) {
         this.s = var1;
         if (Canvas.K.getWidth(this.s) > this.f / 2 && this.s.length() > 10) {
            this.s = this.s.substring(0, 10);
         }

         this.i = Canvas.K.getWidth(this.s) + 10 + (Canvas.Z != 0 ? 35 * Canvas.Z : 0);
      }

      if (this.i < 40) {
         this.i = 40;
      }

      this.b();
      this.l = 0;
      this.m = new int[this.p];
      this.n = new int[this.p];
      this.r = (this.f - this.i) / this.j;
      this.q = 0;
   }

   public final void b() {
      this.g = Canvas.o - this.f / 2;
      this.h = (Canvas.q - Canvas.T) / 2 - this.e / 2;
   }

   public final void a(int var1, int var2) {
      if (var2 != this.l) {
         this.m[var2] = var1;
         this.n[var2] = CRes.rnd(20);
      }

   }

   public final void a(String var1, int var2) {
      if (this.m != null && var2 < this.m.length) {
         this.m[var2] = 0;
      }

      this.s = var1;
      int var3;
      if ((var3 = Canvas.K.getWidth(this.s) + 10) > this.i) {
         this.i = var3;
         this.r = (this.f - this.i) / this.j;
      }

      this.l = var2;
      if (this.l >= this.r && this.r > 0) {
         this.q = this.l - (this.r - 1);
      }

      if (this.l < this.q) {
         this.q = this.l;
      }

   }

   public static void c() {
      GameMidlet.n = "ig_,";
      k = "plg";
      MiniMap.i = Canvas.a(GameMidlet.n, 5);
   }

   public final void a(int var1) {
      this.m = new int[var1];
      this.n = new int[var1];
      this.p = var1;
   }

   public final int d() {
      if (Canvas.g) {
         int var1;
         int var2;
         for(var2 = this.l - 1; var2 >= this.q; --var2) {
            var1 = var2 - this.q;
            if (Canvas.a(this.g + 3 + var1 * this.j, this.h + 3, this.j, o)) {
               return var2 - this.l;
            }
         }

         if ((var2 = this.p) >= this.r) {
            var2 = this.r + this.q;
         }

         for(int var3 = this.l + 1; var3 < var2; ++var3) {
            var1 = var3 - this.q;
            if (Canvas.a(this.g + 3 + var1 * this.j + (this.i - this.j), this.h + 3, this.j, o)) {
               return var3 - this.l;
            }
         }
      }

      return 0;
   }

   public final void a(Graphics var1) {
      Canvas.S.a(var1, this.g, this.h, this.e, this.f, this.l, this.q, this.j, this.i, o, this.p, this.r, this.n, this.m, this.s);
      Canvas.resetTrans(var1);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4) {
      a(var1, var2, var3, var4, d[0], var0);
      var0.setColor(d[2]);
      var0.drawRect(var1, var2, var3, var4);
      var0.setColor(12450472);
      var0.drawRect(var1 + 1, var2 + 1, var3 - 2, var4 - 2);
      var0.setColor(5738823);
      var0.drawRect(var1 + 2, var2 + 2, var3 - 4, var4 - 4);
   }

   public static void a(int var0, int var1, int var2, int var3, int var4, Graphics var5) {
      var5.setColor(var4);
      var5.fillRect(var0, var1, var2, var3);
   }
}

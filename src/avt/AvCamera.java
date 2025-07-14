package avt;

import main.GameCanvas;

public final class AvCamera {
   private static AvCamera i;
   public int a;
   public int b;
   public int c;
   public int d;
   private int j;
   private int k;
   public long e;
   private int l;
   private int m;
   private int n;
   private int o;
   private static int p;
   private static int q;
   public static boolean f = false;
   public static boolean g;
   public Base h;

   public static AvCamera a() {
      if (i == null) {
         i = new AvCamera();
      }

      return i;
   }

   public static void a(int var0) {
      p = var0;
   }

   public final void b(int var1) {
      if (this.h != null) {
         label56: {
            g = false;
            q = LoadMap.i * AvMain.Y;
            p = GameCanvas.m / 10;
            if (this.h.aw * AvMain.Y > GameCanvas.o) {
               if (this.h.aw * AvMain.Y < LoadMap.e * q - GameCanvas.o - q) {
                  this.c = this.h.aw * AvMain.Y - GameCanvas.o;
                  break label56;
               }

               this.c = LoadMap.e * q - GameCanvas.m;
               if (this.c >= 0) {
                  break label56;
               }
            }

            this.c = 0;
         }

         if (GameCanvas.m > LoadMap.e * q) {
            this.c = -(GameCanvas.m - LoadMap.e * q) / 2;
         }

         if (GameCanvas.n > LoadMap.f * q && (var1 - 1 == 57 || var1 - 1 == 58 || var1 - 1 == 59 || var1 - 1 == 108)) {
            this.d = -(GameCanvas.n - LoadMap.f * q) / 2;
         } else {
            this.d = LoadMap.f * q - GameCanvas.n;
         }

         this.j = LoadMap.e * q - GameCanvas.m;
         this.k = LoadMap.f * q - GameCanvas.n;
         this.a = this.c;
         if (this.a < 0) {
            this.a = 0;
         }

         if (this.a > this.j) {
            this.a = this.j;
         }

         if (this.b > this.k) {
            this.b = this.k;
         }

         if (this.d > this.k) {
            this.d = this.k;
         }

      }
   }

   public final void b() {
      this.a = this.c;
      this.b = this.d;
   }

   public final void c() {
      if (!f) {
         if (this.a != this.c) {
            this.l = this.c - this.a << 1;
            this.m += this.l;
            this.a += this.m >> 4;
            this.m &= 15;
            if (this.a < 0) {
               this.a = 0;
            }

            if (this.a > this.j) {
               this.a = this.j;
            }
         }
      } else {
         if (this.a < 0) {
            this.a = 0;
         }

         if (this.a > LoadMap.e * LoadMap.i * AvMain.Y - GameCanvas.m) {
            this.a = LoadMap.e * LoadMap.i * AvMain.Y - GameCanvas.m;
         }
      }

      if (this.b != this.d) {
         this.n = this.d - this.b << 1;
         this.o += this.n;
         this.b += this.o >> 4;
         this.o &= 15;
         if (this.b > this.k) {
            this.b = this.k;
         }
      }

   }

   public final void a(int var1, int var2) {
      this.e = 0L;
      this.c = var1 - GameCanvas.o;
      this.d = var2 - GameCanvas.p;
      if (this.c < 0) {
         this.c = 0;
      }

      if (this.c > LoadMap.e * q - GameCanvas.m) {
         this.c = LoadMap.e * q - GameCanvas.m;
      }

      if (this.d > LoadMap.f * q - GameCanvas.n) {
         this.d = LoadMap.f * q - GameCanvas.n;
      }

      this.e();
   }

   public final void b(int var1, int var2) {
      this.a = this.c = 0;
      this.b = this.d = 0;
   }

   public final void d() {
      this.c();
      if (System.currentTimeMillis() / 100L - this.e >= 20L && !g) {
         int var1;
         if (this.h.K == 0) {
            var1 = this.h.aw * AvMain.Y + p;
         } else {
            var1 = this.h.aw * AvMain.Y - p;
         }

         this.c = var1 - GameCanvas.o;
         this.d = (this.h.ax + this.h.N) * AvMain.Y - (GameCanvas.n - (GameCanvas.p - q));
         if (this.h.K == Base.J) {
            if (this.h.aw * AvMain.Y < GameCanvas.o) {
               this.c = 0;
            }
         } else if (this.h.aw * AvMain.Y > LoadMap.e * q - GameCanvas.o) {
            this.c = LoadMap.e * q - GameCanvas.m;
         }

         this.e();
      }
   }

   private void e() {
      if (LoadMap.a >= 0 && LoadMap.a < LoadMap.h.length && LoadMap.h[LoadMap.a] == -1 && LoadMap.b == null && GameCanvas.n > LoadMap.f * q) {
         this.b = this.d = -(GameCanvas.n - LoadMap.f * q) / 2;
      }

      if (GameCanvas.m > LoadMap.e * q) {
         this.a = this.c = -(GameCanvas.m - LoadMap.e * q) / 2;
      }

   }
}

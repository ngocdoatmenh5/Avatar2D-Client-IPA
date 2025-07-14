package avt;

import main.Canvas;

public final class AvCamera {
   private static AvCamera i;
   public int xCam;
   public int yCam;
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

   public static AvCamera gI() {
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
            q = LoadMap.i * AvMain.hd;
            p = Canvas.m / 10;
            if (this.h.x * AvMain.hd > Canvas.o) {
               if (this.h.x * AvMain.hd < LoadMap.wMap * q - Canvas.o - q) {
                  this.c = this.h.x * AvMain.hd - Canvas.o;
                  break label56;
               }

               this.c = LoadMap.wMap * q - Canvas.m;
               if (this.c >= 0) {
                  break label56;
               }
            }

            this.c = 0;
         }

         if (Canvas.m > LoadMap.wMap * q) {
            this.c = -(Canvas.m - LoadMap.wMap * q) / 2;
         }

         if (Canvas.n > LoadMap.f * q && (var1 - 1 == 57 || var1 - 1 == 58 || var1 - 1 == 59 || var1 - 1 == 108)) {
            this.d = -(Canvas.n - LoadMap.f * q) / 2;
         } else {
            this.d = LoadMap.f * q - Canvas.n;
         }

         this.j = LoadMap.wMap * q - Canvas.m;
         this.k = LoadMap.f * q - Canvas.n;
         this.xCam = this.c;
         if (this.xCam < 0) {
            this.xCam = 0;
         }

         if (this.xCam > this.j) {
            this.xCam = this.j;
         }

         if (this.yCam > this.k) {
            this.yCam = this.k;
         }

         if (this.d > this.k) {
            this.d = this.k;
         }

      }
   }

   public final void b() {
      this.xCam = this.c;
      this.yCam = this.d;
   }

   public final void c() {
      if (!f) {
         if (this.xCam != this.c) {
            this.l = this.c - this.xCam << 1;
            this.m += this.l;
            this.xCam += this.m >> 4;
            this.m &= 15;
            if (this.xCam < 0) {
               this.xCam = 0;
            }

            if (this.xCam > this.j) {
               this.xCam = this.j;
            }
         }
      } else {
         if (this.xCam < 0) {
            this.xCam = 0;
         }

         if (this.xCam > LoadMap.wMap * LoadMap.i * AvMain.hd - Canvas.m) {
            this.xCam = LoadMap.wMap * LoadMap.i * AvMain.hd - Canvas.m;
         }
      }

      if (this.yCam != this.d) {
         this.n = this.d - this.yCam << 1;
         this.o += this.n;
         this.yCam += this.o >> 4;
         this.o &= 15;
         if (this.yCam > this.k) {
            this.yCam = this.k;
         }
      }

   }

   public final void a(int var1, int var2) {
      this.e = 0L;
      this.c = var1 - Canvas.o;
      this.d = var2 - Canvas.hh;
      if (this.c < 0) {
         this.c = 0;
      }

      if (this.c > LoadMap.wMap * q - Canvas.m) {
         this.c = LoadMap.wMap * q - Canvas.m;
      }

      if (this.d > LoadMap.f * q - Canvas.n) {
         this.d = LoadMap.f * q - Canvas.n;
      }

      this.e();
   }

   public final void b(int var1, int var2) {
      this.xCam = this.c = 0;
      this.yCam = this.d = 0;
   }

   public final void d() {
      this.c();
      if (System.currentTimeMillis() / 100L - this.e >= 20L && !g) {
         int var1;
         if (this.h.direct == 0) {
            var1 = this.h.x * AvMain.hd + p;
         } else {
            var1 = this.h.x * AvMain.hd - p;
         }

         this.c = var1 - Canvas.o;
         this.d = (this.h.y + this.h.N) * AvMain.hd - (Canvas.n - (Canvas.hh - q));
         if (this.h.direct == Base.LEFT) {
            if (this.h.x * AvMain.hd < Canvas.o) {
               this.c = 0;
            }
         } else if (this.h.x * AvMain.hd > LoadMap.wMap * q - Canvas.o) {
            this.c = LoadMap.wMap * q - Canvas.m;
         }

         this.e();
      }
   }

   private void e() {
      if (LoadMap.a >= 0 && LoadMap.a < LoadMap.h.length && LoadMap.h[LoadMap.a] == -1 && LoadMap.b == null && Canvas.n > LoadMap.f * q) {
         this.yCam = this.d = -(Canvas.n - LoadMap.f * q) / 2;
      }

      if (Canvas.m > LoadMap.wMap * q) {
         this.xCam = this.c = -(Canvas.m - LoadMap.wMap * q) / 2;
      }

   }
}

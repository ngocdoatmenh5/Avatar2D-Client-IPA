package avt;

import javax.microedition.lcdui.Graphics;

public final class Drop_Part extends Base {
   public short a;
   private short f;
   public int b;
   public int c;
   public int d;
   private byte g;
   private byte h;
   private byte i;
   private byte j = 1;
   public byte e;
   private byte k;

   public Drop_Part() {
      super.az = 5;
   }

   public Drop_Part(byte var1, short var2, int var3) {
      this.d = var3;
      super.az = 5;
      this.e = var1;
      this.a = var2;
      this.h = 0;
      Part var4;
      if ((var4 = AvatarData.a(this.a)).h < AvatarData.a.length) {
         super.aA = AvatarData.a[var4.h].f;
      }

      this.i = (byte)CRes.e(10);
   }

   public final void b() {
      switch (this.k) {
         case 0:
         case 1:
            super.aw += (short)(this.b - super.aw >> 2);
            super.ax += (short)(this.c - super.ax >> 2);
            if (this.g >= -6) {
               this.f = (short)(this.f + this.g);
               --this.g;
            }

            if ((CRes.f(super.aw - this.b) < 4 || CRes.f(super.ax - this.c) < 4) && this.f <= 1) {
               super.aw = this.b;
               super.ax = this.c;
               this.f = 0;
               this.g = 0;
               if (this.k == 1) {
                  LoadMap.a((MyObject)this);
               }

               this.k = 2;
               return;
            }
         case 2:
         default:
            break;
         case 3:
            this.f = (short)(this.f + 3);
            if (this.f > 50) {
               LoadMap.a((MyObject)this);
               return;
            }
            break;
         case 4:
            if (this.f > 0) {
               this.f = (short)(this.f - this.g);
               ++this.g;
               return;
            }

            this.f = 0;
            this.k = 2;
      }

   }

   public final void a(Graphics var1) {
      var1.drawImage(LoadMap.r, super.aw, super.ax + 1, 33);
      if (this.e == 0) {
         AvatarData.a(this.a).paintIcon(var1, super.aw, super.ax + this.i / 10 - this.f, 0, 33);
      } else {
         super.aA = (short)(AvatarData.c(this.a).c + 10);
         AvatarData.a(var1, this.a, super.aw, super.ax + this.i / 10 - this.f, 33);
      }

      this.i += this.j;
      if (CRes.f(this.i) >= 10) {
         this.h = (byte)(-this.h);
      }

   }

   public final void a(int var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var1)) != null) {
         this.b = var2.aw;
         this.c = var2.ax;
         this.k = 1;
         this.f = 0;
      } else {
         this.f = 0;
         this.k = 3;
      }

      this.g = 6;
   }

   public final void a(int var1, short var2, short var3) {
      if (var1 == -2) {
         super.aw = var2;
         super.ax = var3;
         this.k = 2;
      } else {
         Avatar var4;
         if ((var4 = LoadMap.g(var1)) != null) {
            super.aw = var4.aw;
            super.ax = var4.ax;
            this.k = 0;
            this.g = 6;
            this.f = 0;
         } else {
            this.k = 4;
            super.aw = var2;
            super.ax = var3;
            this.f = 100;
            this.g = 0;
         }
      }

      this.b = var2;
      this.c = var3;
   }
}

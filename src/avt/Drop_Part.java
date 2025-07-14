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
      super.catagory = 5;
   }

   public Drop_Part(byte var1, short var2, int var3) {
      this.d = var3;
      super.catagory = 5;
      this.e = var1;
      this.a = var2;
      this.h = 0;
      Part var4;
      if ((var4 = AvatarData.getPart(this.a)).h < AvatarData.listImgInfo.length) {
         super.height = AvatarData.listImgInfo[var4.h].h;
      }

      this.i = (byte)CRes.rnd(10);
   }

   public final void update() {
      switch (this.k) {
         case 0:
         case 1:
            super.x += (short)(this.b - super.x >> 2);
            super.y += (short)(this.c - super.y >> 2);
            if (this.g >= -6) {
               this.f = (short)(this.f + this.g);
               --this.g;
            }

            if ((CRes.f(super.x - this.b) < 4 || CRes.f(super.y - this.c) < 4) && this.f <= 1) {
               super.x = this.b;
               super.y = this.c;
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

   public final void paint(Graphics var1) {
      var1.drawImage(LoadMap.r, super.x, super.y + 1, 33);
      if (this.e == 0) {
         AvatarData.getPart(this.a).paintIcon(var1, super.x, super.y + this.i / 10 - this.f, 0, 33);
      } else {
         super.height = (short)(AvatarData.getImgIcon(this.a).c + 10);
         AvatarData.a(var1, this.a, super.x, super.y + this.i / 10 - this.f, 33);
      }

      this.i += this.j;
      if (CRes.f(this.i) >= 10) {
         this.h = (byte)(-this.h);
      }

   }

   public final void a(int var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var1)) != null) {
         this.b = var2.x;
         this.c = var2.y;
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
         super.x = var2;
         super.y = var3;
         this.k = 2;
      } else {
         Avatar var4;
         if ((var4 = LoadMap.g(var1)) != null) {
            super.x = var4.x;
            super.y = var4.y;
            this.k = 0;
            this.g = 6;
            this.f = 0;
         } else {
            this.k = 4;
            super.x = var2;
            super.y = var3;
            this.f = 100;
            this.g = 0;
         }
      }

      this.b = var2;
      this.c = var3;
   }
}

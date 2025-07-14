package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class Fish {
   private static int m = 10;
   private int n = 1;
   public byte a = 9;
   public Avatar b;
   AvPosition[] c;
   AvPosition[] d;
   private AvPosition[] o;
   private int p = 0;
   int e;
   private int q;
   int f;
   int g;
   private int r;
   int h;
   private int s;
   boolean i;
   boolean j;
   boolean k;
   private boolean t;
   private AvPosition[] u;
   private AvPosition v;
   private AvPosition w;
   private AvPosition x;
   public static int[] l = new int[]{12577266, 10341591};
   private int y;
   private int z;
   private int A;

   public Fish() {
      this.e = m;
      this.q = -8;
      this.f = 0;
      this.g = -1;
      this.r = 25;
      this.h = -1;
      this.i = false;
      this.j = false;
      this.k = false;
      this.t = false;
      this.y = 0;
      this.z = 0;
      this.A = 0;
      this.a = (byte)(7 + CRes.rnd(4));
      this.u = new AvPosition[2];

      int var1;
      for(var1 = 0; var1 < 2; ++var1) {
         this.u[var1] = new AvPosition(-10, 0, var1 * 15);
      }

      this.o = new AvPosition[2];
      this.o[0] = new AvPosition();
      this.o[1] = new AvPosition();
      this.c = new AvPosition[this.a];
      this.d = new AvPosition[this.a];

      for(var1 = 0; var1 < this.a; ++var1) {
         this.c[var1] = new AvPosition();
         this.d[var1] = new AvPosition();
      }

      this.v = new AvPosition(0, 0, -1);
      this.w = new AvPosition(0, 0, -1);
      this.x = new AvPosition();
   }

   public final void a() {
      this.p = 0;
      this.f = 0;
      this.q = -(10 + CRes.rnd(4));
      this.g = -1;
      this.i = false;
      this.j = false;
      this.t = false;
   }

   public final void a(Avatar var1) {
      this.b = var1;
      if (var1.direct == 0) {
         this.n = 1;
      } else {
         this.n = -1;
      }

      this.a();
      this.g = 0;
      this.h = 0;
      Object var4;
      if (((Part)(var4 = AvatarData.getPartByZ(var1.seriPart, 70))).follow >= 0) {
         var4 = AvatarData.getPart(((Part)var4).follow);
      }

      APartInfo var8 = (APartInfo)var4;
      ImageInfo var5 = AvatarData.listImgInfo[var8.imgID[3]];
      ImageInfo var6 = AvatarData.listImgInfo[var8.imgID[14]];
      int var7 = var1.x;
      int var3 = var1.y + var1.ySat;
      this.o[0].x = var7 + var8.dx[3] * AvMain.hd + var5.w * AvMain.hd;
      this.o[0].y = var3 + var8.dy[3] * AvMain.hd - 5 * (AvMain.hd - 1);
      this.o[1].x = var7 + var8.dx[14] * AvMain.hd + var6.w * AvMain.hd;
      this.o[1].y = var3 + var8.dy[14] * AvMain.hd - 5 * (AvMain.hd - 1);
      this.v.anchor = -1;
      if (var1.IDDB == GameMidlet.avatar.IDDB) {
         MapScr.gI();
         MapScr.doAction((byte)13);
      }

   }

   public final void b() {
      ++this.p;
      this.e = m;

      for(int var1 = 0; var1 < this.a; ++var1) {
         this.c[var1].x = this.o[1].x;
         this.c[var1].y = this.o[1].y;
      }

   }

   public final void a(int var1) {
      this.c[0].x = this.o[var1].x;
      this.c[0].y = this.o[var1].y;
      if (var1 == 1) {
         this.b.action = 13;
      } else {
         this.b.action = 2;
      }
   }

   public final void c() {
      if (this.b != null) {
         ++this.A;
         if (this.A >= 6) {
            this.A = 0;
         }

         Fish var1 = this;
         int var2;
         int var3;
         int var5;
         AvPosition var10000;
         if (this.p != 0) {
            if (this.f == 1) {
               for(var2 = 1; var2 < var1.a - 2; ++var2) {
                  var10000 = var1.c[var2];
                  var10000.y += 6;
               }

               label273: {
                  Fish var10 = var1;
                  if (var1.t && var1.h > 0) {
                     ++var1.y;
                     if (var1.y < 2) {
                        var3 = 1;

                        while(true) {
                           if (var3 >= var10.a) {
                              break label273;
                           }

                           var10000 = var10.c[var3];
                           var10000.x -= 6;
                           ++var3;
                        }
                     }

                     if (var1.y > 4 && var1.y < 8) {
                        var3 = 1;

                        while(true) {
                           if (var3 >= var10.a) {
                              break label273;
                           }

                           var10000 = var10.c[var3];
                           var10000.x += 6;
                           ++var3;
                        }
                     }

                     if (var1.y <= 14) {
                        break label273;
                     }

                     --var1.z;
                     if (var1.z >= 0) {
                        break label273;
                     }

                     var1.y = 0;
                  }

                  var1.z = CRes.rnd(20);
               }

               if (var1.e == m) {
                  var1.e = 7;
               }
            }

            boolean var11 = false;
            var3 = var1.a - 1;
            byte var4 = 1;
            if (var1.j) {
               var4 = 0;
            }

            int var6;
            int var7;
            int var8;
            for(var5 = 1; var5 < var1.a - var1.f * var4; ++var5) {
               if ((var6 = CRes.a(var1.c[var5].x, var1.c[var5].y, var1.c[var5 - 1].x, var1.c[var5 - 1].y)) > var1.e + 1) {
                  var11 = true;
                  var7 = var6 - var1.e;
                  var6 = CRes.a(var1.c[var5 - 1].x - var1.c[var5].x, -(var1.c[var5 - 1].y - var1.c[var5].y));
                  var8 = var7 * CRes.cos(CRes.fixangle(var6)) >> 10;
                  var6 = -(var7 * CRes.sin(CRes.fixangle(var6))) >> 10;
                  var10000 = var1.c[var5];
                  var10000.x += var8;
                  var10000 = var1.c[var5];
                  var10000.y += var6;
               }
            }

            if (var1.c[var3].y < var1.b.y + var1.b.ySat + 5) {
               var10000 = var1.c[var3];
               var10000.x += 10;
               var10000 = var1.c[var3];
               var10000.y += var1.q;
               ++var1.q;
            }

            if (!var1.j) {
               for(var5 = var3 - 1; var5 > 0; --var5) {
                  if ((var6 = CRes.a(var1.c[var5].x, var1.c[var5].y, var1.c[var5 + 1].x, var1.c[var5 + 1].y)) > var1.e + 1) {
                     var11 = true;
                     var7 = CRes.a(var1.c[var5 + 1].x - var1.c[var5].x, -(var1.c[var5 + 1].y - var1.c[var5].y));
                     var8 = (var6 -= var1.e) * CRes.cos(CRes.fixangle(var7)) >> 10;
                     var6 = -(var6 * CRes.sin(CRes.fixangle(var7))) >> 10;
                     var10000 = var1.c[var5];
                     var10000.x += var8;
                     var10000 = var1.c[var5];
                     var10000.y += var6;
                  }
               }
            }

            if (!var11) {
               var1.f = 1;
            }
         }

         if (this.g != -1) {
            ++this.g;
            if (Canvas.gameTick % 4 == 2) {
               if (this.b.action == 2) {
                  this.b.action = 13;
                  if (this.g > 16) {
                     this.b();
                     this.g = -1;
                  }
               } else {
                  this.b.action = 2;
               }
            }
         }

         var1 = this;
         if (this.i) {
            if (this.e > 4 && Canvas.gameTick % 6 == 3) {
               --this.e;
            }

            if (!this.j && Canvas.gameTick % 6 == 3 && this.b != GameMidlet.avatar) {
               if (this.b.action == 2) {
                  this.a(1);
               } else {
                  this.a(0);
               }
            }

            if (this.j && this.e <= 4) {
               this.e = 2;
               var2 = 0;
               if (!this.t) {
                  for(var3 = 0; var3 < var1.a - 1; ++var3) {
                     var10000 = var1.c[var3];
                     boolean var13 = true;
                     var5 = var1.c[var3 + 1].x;
                     AvPosition var12 = var10000;
                     if (CRes.abs(var5 - var12.x) > 1) {
                        ++var2;
                     }
                  }
               }

               if (var2 == 0 && !var1.t) {
                  var1.v.anchor = -2;
                  var1.t = true;
               }
            }
         }

         if (this.k && (this.b.action == 2 || this.b.action == 13)) {
            this.a(this.b);
            this.k = false;
         }

         if (this.f != 0) {
            var1 = this;

            for(var2 = 0; var2 < 2; ++var2) {
               if (var1.u[var2].anchor == 0 || var1.u[var2].x == -10) {
                  var1.u[var2].x = var1.d[var1.a - 2].x;
                  var1.u[var2].y = var1.d[var1.a - 2].y;
               }

               if (var1.i) {
                  var10000 = var1.u[var2];
                  var10000.anchor += 2;
               } else {
                  ++var1.u[var2].anchor;
               }

               if (var1.u[var2].anchor > var1.r + (var1.i ? 10 : 0)) {
                  var1.u[var2].anchor = 0;
               }
            }
         }

         if (!this.j && this.f == 1) {
            if (this.v.anchor == -1) {
               this.v.x = this.w.x = this.x.x = this.c[this.a - 1].x;
               this.v.y = this.w.y = this.x.y = this.c[this.a - 1].y;
               this.v.anchor = 0;
               this.s = -1;
            }

            var2 = this.x.x - this.w.x;
            var3 = this.x.y - this.w.y;
            if (this.s > 0) {
               --this.s;
            }

            if ((this.s <= 0 || this.i) && Canvas.gameTick % 2 == 1) {
               if (CRes.abs(var2) > 0) {
                  if (var2 > 0) {
                     --this.x.x;
                  } else {
                     ++this.x.x;
                  }

                  this.c[this.a - 1].x = this.x.x;
               }

               if (CRes.abs(var3) > 0) {
                  if (var3 > 0) {
                     --this.x.y;
                  } else {
                     ++this.x.y;
                  }

                  this.c[this.a - 1].y = this.x.y;
               }
            }

            if (CRes.abs(var2) <= 0 && CRes.abs(var3) <= 0) {
               this.s = 50 + CRes.rnd(100);
               this.w.x = this.v.x + 10 - CRes.rnd(20);
               this.w.y = this.v.y + CRes.rnd(6);
            }
         }

         if (this.b.direct == 0) {
            this.n = 1;
         } else {
            this.n = -1;
         }

         for(int var9 = 0; var9 < this.a; ++var9) {
            var2 = this.c[var9].x - this.b.x;
            if (var9 != this.a - 2 || CRes.abs(this.d[var9].x - (this.b.x + this.n * var2)) > 1) {
               this.d[var9].x = this.b.x * AvMain.hd + this.n * var2;
            }

            this.d[var9].y = this.c[var9].y;
         }

      }
   }

   public final void a(Graphics var1) {
      if (!this.k && this.g == -1) {
         if (AvMain.hd > 1) {
            var1.translate(0, this.b.y);
         }

         int var2;
         if (this.f != 0 && !this.j && this.u[0].x > 0 && this.u[0].x > AvCamera.gI().xCam && this.u[0].x < AvCamera.gI().xCam + Canvas.w) {
            var1.setColor(l[LoadMap.j]);

            for(var2 = 0; var2 < 2; ++var2) {
               var1.drawRoundRect(this.u[var2].x - this.u[var2].anchor / 2, this.u[var2].y - this.u[var2].anchor / 4, this.u[var2].anchor, this.u[var2].anchor / 2, this.u[var2].anchor, this.u[var2].anchor);
            }
         }

         var1.setColor(8685448);
         if (this.d[0].x > AvCamera.gI().xCam && this.d[0].x < AvCamera.gI().xCam + Canvas.w || this.d[this.a - 1].x > AvCamera.gI().xCam && this.d[this.a - 1].x < AvCamera.gI().xCam + Canvas.w) {
            for(var2 = 0; var2 < this.a - 1 - this.f; ++var2) {
               if (this.d[var2 + 1].y < this.b.y + this.b.ySat + 20) {
                  var1.drawLine(this.d[var2].x, this.d[var2].y, this.d[var2 + 1].x, this.d[var2 + 1].y);
               }
            }

            if (this.f == 0 && this.d[this.a - 1].y < this.b.y + this.b.ySat + 10) {
               PaintPopup.a(this.d[this.a - 1].x, this.d[this.a - 1].y, 2, 2, 0, var1);
            }

            int var10002 = this.d[this.a - 2].x;
            int var10003 = this.d[this.a - 2].y;
            var1.drawImage(class_kv.b().a, var10002, var10003, 3);
            if (this.j && this.h > 0) {
               int var10001 = 0 + this.A / 3;
               var10002 = this.d[this.a - 2].x + 2;
               var10003 = this.d[this.a - 2].y + 4;
               class_kv.b().b.drawFrame(var10001, var10002, var10003, 0, 24, var1);
               PartSmall var3;
               if (Canvas.gameTick % 10 > 5 && (var3 = (PartSmall)AvatarData.getPart((short)this.h)) != null) {
                  var3.a(var1, this.b.x * AvMain.hd, this.b.y - 55 * AvMain.hd, 3);
               }
            }
         }

         if (AvMain.hd > 1) {
            var1.translate(0, -this.b.y);
         }

      }
   }
}

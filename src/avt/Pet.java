package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class Pet extends Animal {
   public Avatar r;
   private Vector t = new Vector();
   private int u;
   private int v;
   private int Q;
   private int R;
   private int S;
   private boolean T;
   public static Image[] s = new Image[2];
   private static final byte[][] U = new byte[][]{{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1}, {2, 2, 2, 3, 3, 3, 2, 2, 2, 3, 3, 3}};

   public Pet(Avatar var1) {
      super.catagory = 4;
      this.r = var1;
      super.posNext = new AvPosition();
      super.posNext.x = this.r.x - 40 + CRes.rnd(80);
      super.posNext.y = this.r.y - 20 + CRes.rnd(40);
      super.xCur = super.x = super.posNext.x;
      super.yCur = super.y = super.posNext.y;
      APartInfo var2 = (APartInfo)AvatarData.getPart(this.r.idPet);
      this.Q = var2.level;
   }

   public final void setPos() {
      if (this.t.size() > 0) {
         AvPosition var1 = (AvPosition)this.t.elementAt(0);
         super.posNext.x = var1.x;
         super.posNext.y = var1.y;
         this.t.removeElementAt(0);
      } else {
         int var2 = CRes.rnd(20) - 10;
         if (CRes.abs(super.posNext.x + var2 - GameMidlet.avatar.x) >= 35) {
            var2 = 0;
         }

         AvPosition var10000 = super.posNext;
         var10000.x += var2;
         super.posNext.y = super.y;
      }

      if (super.posNext.x < 0) {
         super.posNext.x = 5;
      } else if (super.posNext.x > LoadMap.wMap * 24) {
         super.posNext.x = LoadMap.wMap * 24 - 5;
      } else if (super.posNext.y < 0) {
         super.posNext.y = 5;
      } else {
         if (super.posNext.y > LoadMap.Hmap * 24 - 24) {
            super.posNext.y = LoadMap.Hmap * 24 - 30;
         }

      }
   }

   public final void updatePos() {
      this.setPos();
   }

   public final void update() {
      if (Canvas.gameTick % (3 - this.Q) == 0) {
         ++super.frame;
      }

      int var10000 = Canvas.gameTick;
      if (true && super.action == 1 && super.y == super.yCur && this.T) {
         if (this.S == 1) {
            ++this.R;
            if (this.R > 3) {
               this.S = -1;
            }
         } else {
            --this.R;
            if (this.R < -3) {
               this.S = 1;
            }
         }
      }

      if (super.frame >= 12) {
         super.frame = 0;
      }

      if ((this.u != this.r.x || this.v != this.r.y) && CRes.a(this.u, this.v, this.r.x, this.r.y) > 40) {
         int var2 = 10 + CRes.rnd(20);
         if (this.r.direct == 0) {
            var2 = -(10 + CRes.rnd(20));
         }

         if (LoadMap.c(this.r.x + var2, this.r.y) != 80) {
            var2 = 0;
         }

         this.t.addElement(new AvPosition(this.r.x + var2, this.r.y));
         this.u = this.r.x + var2;
         this.v = this.r.y;
      }

      if (super.action != 1) {
         if (super.cycle > 0) {
            if (super.frame == 0) {
               super.action = (byte)CRes.rnd(3 + (this.Q << 1));
               if (super.action != 2) {
                  super.action = 0;
               } else {
                  super.direct = (byte)CRes.rnd(0, Base.LEFT);
               }

               if (this.T) {
                  super.action = 2;
               }
            }

            --super.cycle;
            if (CRes.a(super.x, super.y, this.r.x, this.r.y) > 35) {
               super.reset();
               super.cycle = 0;
               super.G = 4;
            }

         } else {
            this.setPos();
            if (super.posNext.x > super.x) {
               super.direct = 0;
            } else {
               super.direct = Base.LEFT;
            }

            this.setAngleAndDis();
            super.action = 1;
         }
      } else {
         this.move();
      }
   }

   public final void reset() {
      super.reset();
      super.cycle = 50 + CRes.rnd(100);
      if (this.t.size() > 0) {
         this.setPos();
         if (super.posNext.x > super.x) {
            super.direct = 0;
         } else {
            super.direct = Base.LEFT;
         }

         this.setAngleAndDis();
         super.action = 1;
         super.cycle = 0;
         super.disTrans = 1;
         super.G = 2 + this.Q;
      } else {
         super.G = 1 + CRes.rnd(this.Q);
      }
   }

   public final void paint(Graphics var1) {
      if ((super.x + 15) * MyObject.hd >= AvCamera.gI().xCam && (super.x - 15) * MyObject.hd <= AvCamera.gI().xCam + Canvas.w && !this.r.ableShow && (Canvas.stypeInt <= 0 || Canvas.currentMyScreen != MenuCenter.gI())) {
         APartInfo var2;
         if ((var2 = (APartInfo)AvatarData.getPart(this.r.idPet)).IDPart != -1) {
            if (var2.IDPart >= 2000) {
               ImageIcon var3;
               if ((var3 = AvatarData.getImagePart(var2.imgID[U[super.action][super.frame]])).count != -1) {
                  if (!this.T && var2.dy[0] + var3.c < -10 && var3.c > 0) {
                     this.T = true;
                     this.S = 1;
                  }

                  var1.drawImage(s[this.T ? 0 : 1], super.x * MyObject.hd, (super.y - 1) * MyObject.hd, 3);
                  var1.drawRegion(var3.img, 0, 0, var3.b, var3.c, super.direct, super.x * MyObject.hd + var2.dx[U[super.action][super.frame]] * MyObject.hd - (super.direct == Base.LEFT ? (var2.dx[U[super.action][super.frame]] * AvMain.hd << 1) + var3.b * AvMain.hd : 0), (super.y + this.R) * MyObject.hd + var2.dy[U[super.action][super.frame]] * MyObject.hd, 0);
                  return;
               }
            } else {
               ImageInfo var4 = AvatarData.listImgInfo[var2.imgID[U[super.action][super.frame]]];
               if (!this.T && var2.dy[0] + var4.h < -10 && var4.h > 0) {
                  this.T = true;
                  this.S = 1;
               }

               var1.drawImage(s[this.T ? 0 : 1], super.x * MyObject.hd, (super.y - 1) * MyObject.hd, 3);
               int var10002 = var4.x0 * MyObject.hd;
               int var10003 = var4.y0 * MyObject.hd;
               int var10004 = var4.w * MyObject.hd;
               int var10005 = var4.h * MyObject.hd;
               int var10007 = super.x * MyObject.hd + var2.dx[U[super.action][super.frame]] * MyObject.hd - (super.direct == Base.LEFT ? (var2.dx[U[super.action][super.frame]] * AvMain.hd << 1) + var4.w * AvMain.hd : 0);
               var1.drawRegion(AvatarData.getBigImgInfo((int)var4.bigID).img, var10002, var10003, var10004, var10005, super.direct, var10007, (super.y + this.R) * MyObject.hd + var2.dy[U[super.action][super.frame]] * MyObject.hd, 0);
            }
         }

      }
   }

   public final void a(Graphics var1, int var2, int var3, int var4) {
      APartInfo var5;
      if ((var5 = (APartInfo)AvatarData.getPart(this.r.idPet)).IDPart != -1) {
         int var6 = var3 + var5.dy[U[super.action][super.frame]];
         PaintPopup.a(var2 - 10, var6 - 10, 20, 3, 11381824, var1);
         var1.setColor(11072024);
         var1.drawRect(var2 - 10, var6 - 10, 20, 3);
         PaintPopup.a(var2 - 9, var6 - 9, var4 * 20 / 100, 2, 16644608, var1);
         if (var5.IDPart >= 2000) {
            ImageIcon var7;
            if ((var7 = AvatarData.getImagePart(var5.imgID[U[super.action][super.frame]])).count != -1) {
               var1.drawImage(s[this.T ? 0 : 1], var2, var3 - 1, 3);
               var1.drawRegion(var7.img, 0, 0, var7.b, var7.c, super.direct, var2 + var5.dx[U[super.action][super.frame]] * MyObject.hd - (super.direct == Base.LEFT ? (var5.dx[U[super.action][super.frame]] * AvMain.hd << 1) + var7.b * AvMain.hd : 0), var6 + this.R, 0);
               return;
            }
         } else {
            ImageInfo var8 = AvatarData.listImgInfo[var5.imgID[U[super.action][super.frame]]];
            var1.drawImage(s[this.T ? 0 : 1], var2, var3 - 1, 3);
            int var10002 = var8.x0 * MyObject.hd;
            int var10003 = var8.y0 * MyObject.hd;
            int var10004 = var8.w * MyObject.hd;
            int var10005 = var8.h * MyObject.hd;
            int var10007 = var2 + var5.dx[U[super.action][super.frame]] * MyObject.hd;
            var1.drawRegion(AvatarData.getBigImgInfo((int)var8.bigID).img, var10002, var10003, var10004, var10005, super.direct, var10007 - (super.direct == Base.LEFT ? (var5.dx[U[super.action][super.frame]] * AvMain.hd << 1) + var8.w * AvMain.hd : 0), var6 + this.R, 0);
         }
      }

   }

   public final void move() {
      int var1 = super.G * this.r.hungerPet / 100;
      if (this.r.hungerPet >= 70) {
         var1 = super.G;
      }

      if (var1 <= 0) {
         var1 = 1;
      }

      int var2 = var1 * (super.disTrans * CRes.cos(CRes.fixangle(super.angle)) >> 10);
      var1 = -var1 * super.disTrans * CRes.sin(CRes.fixangle(super.angle)) >> 10;
      super.x = super.xCur + var2;
      super.y = super.yCur + var1;
      var1 = CRes.a(super.xCur, super.yCur, super.x, super.y);
      ++super.disTrans;
      if (var1 > super.distant) {
         this.reset();
      }

   }
}

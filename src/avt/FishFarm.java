package avt;

import javax.microedition.lcdui.Graphics;

public final class FishFarm extends AnimalDan {
   public static int r = 5;
   private AvPosition s;
   private byte v = 0;

   public FishFarm(int var1, byte var2, byte var3) {
      super(0, 0, var1, var2);
      super.captainID = 0;
      super.indexFood = 1;
      super.catagory = 7;
      this.s = new AvPosition(-10, 0, CRes.rnd(8));
   }

   public final void update() {
      if (this.s.anchor == 6 || this.s.x == -10) {
         this.s.x = super.x + (super.period == 2 && super.direct == 0 ? 3 : -3);
         this.s.y = super.y + 2;
      }

      ++this.s.anchor;
      if (this.s.anchor > 17 * (3 - super.period) || this.v > 0) {
         this.s.anchor = 0;
      }

      AnimalInfo var1 = FarmData.getAnimalByID(super.species);
      super.indexFr = var1.arrFrame[super.action][super.frame];
      if (CRes.rnd(100) == 2 && this.v <= 0 && super.action == 0) {
         this.v = 8;
      }

      if (this.v > 0) {
         super.indexFr = (byte)(2 - this.v / 3 + 2);
         --this.v;
         super.l = this.v;
         if (super.l >= 4) {
            super.l = (byte)(4 - this.v % 4);
         }

         super.l = (byte)(super.l + 5);
         super.l = (byte)(-super.l);
      } else {
         super.l = 0;
      }

      super.update();
   }

   public final void paint(Graphics var1) {
      super.paint(var1);
      if (this.s.anchor < 16) {
         var1.setColor(Fish.l[LoadMap.j]);
         var1.drawRoundRect((this.s.x - this.s.anchor / 2) * MyObject.hd, (this.s.y - this.s.anchor / 4) * MyObject.hd, this.s.anchor * MyObject.hd, this.s.anchor / 2 * MyObject.hd, this.s.anchor * MyObject.hd, this.s.anchor * MyObject.hd);
      }

   }

   public final void setInit() {
      super.posNext = new AvPosition();
      super.x = super.xCur = super.posNext.x = FarmScr.D.x + CRes.rnd(FarmScr.x - 1) * 24;
      super.y = super.yCur = super.posNext.y = FarmScr.D.y + 12 + CRes.rnd(2) * 24;
      (new StringBuffer("777777777777777777777: ")).append(super.x).append("   ").append(super.y).toString();
   }

   public final void setPos() {
      AvPosition var2 = new AvPosition(FarmScr.D.x + 30 + CRes.rnd(FarmScr.x - 2) * 24, FarmScr.D.y + 12 + CRes.rnd(2) * 24);
      super.posNext = var2;
   }

   public final void setFollowPos(AvPosition var1) {
      AvPosition var2 = new AvPosition(var1.x - 10 + CRes.rnd(20), var1.y - 10 + CRes.rnd(20));
      super.posNext = var2;
   }

   public final boolean detectCollision(int var1, int var2) {
      if (super.action == -1) {
         super.vx = 0;
         super.vy = 0;
         return true;
      } else if (super.action != 0 && super.action != 1) {
         super.vx = 0;
         super.vy = 0;
         return true;
      } else {
         super.action = 1;
         int var3 = super.xCur;
         int var4 = super.yCur;
         if (!LoadMap.isTrans(var3 + var1, var4 + var2)) {
            if (var1 != 0) {
               if (var1 > 0) {
                  super.vx = super.G;
               } else {
                  super.vx = -super.G;
               }
            }

            if (var2 != 0) {
               if (var2 > 0) {
                  super.vy = super.G;
               } else {
                  super.vy = -super.G;
               }
            }

            return false;
         } else {
            super.vx = 0;
            super.vy = 0;
            return true;
         }
      }
   }

   public final Point getPosEat() {
      Point var1;
      return !LoadMap.isTrans((var1 = (Point)FarmScr.listFood[super.indexFood].elementAt(CRes.rnd(FarmScr.listFood[super.indexFood].size()))).x, var1.y) && var1.b == 0 ? var1 : null;
   }
}

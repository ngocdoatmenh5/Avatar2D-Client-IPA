package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class DialLuckyScr extends MyScreen {
   private static DialLuckyScr me;
   private Image b;
   private Image c;
   private Image d;
   private Image e;
   private FrameImage imgFireWork;
   private int radius;
   private int degree;
   private int part  ;
   private int g;
   private int degreeKim   ;
   private int num;
   private int selectedNumber;
   private AvPosition posCenter;
   private boolean isTurn;
   private boolean isPaint;
   private boolean isable = false;
   private MyScreen lastScr;
   private short idPart;
   private Command cmdDial;
   private Command cmdWait    ;
   private Command cmdClose;
   private Vector listGift = new Vector();
   private long timePaint = 0L;
   private boolean[] isFireWork;
   private Vector listFireWork;

   public static DialLuckyScr gI() {
      return me == null ? (me = new DialLuckyScr()) : me;
   }

   public final void switchToMe(MyScreen var1, short var2) {
      this.lastScr = var1;
      this.idPart = var2;
      Canvas.keyHold[5] = false;
      super.switchToMe();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.isable = true;
            return;
         case 1:
            return;
         case 2:
            this.lastScr.switchToMe();
            DialLuckyScr var3 = this;
            this.isPaint = false;
            super.center = this.cmdDial;

            for(var2 = 0; var2 < 3; ++var2) {
               var3.isFireWork[var2] = false;
            }

            var3.listFireWork.removeAllElements();
            setItemBay(var3.listGift, GameMidlet.avatar, 0);
         default:
      }
   }

   public DialLuckyScr() {
      FilePack.b(T.ax);
      this.b = FilePack.getImage("c");
      this.d = FilePack.getImage("sq");
      this.e = FilePack.getImage("q");
      this.imgFireWork = FrameImage.init("st", 11 * AvMain.hd, 11 * AvMain.hd);
      this.c = FilePack.getImage("cb");
      FilePack.reset();
      if (Canvas.w < 200) {
         this.radius = 80;
      } else {
         this.radius = 90;
      }

      this.posCenter = new AvPosition(Canvas.w, Canvas.hh);
      this.part = 30;
      this.num = 360 / this.part;
      this.cmdDial = new Command(T.dv, 0);
      this.cmdWait = new Command(T.b, 1);
      this.cmdClose = new Command(T.d, 2);
      super.center = this.cmdDial;
      this.degreeKim = 90;
      this.isFireWork = new boolean[3];
      this.listFireWork = new Vector();
   }

   private static void setItemBay(Vector var0, Avatar var1, int var2) {
      var2 = var2;

      for(int var3 = 0; var3 < var0.size(); ++var3) {
         Gift var4 = (Gift)var0.elementAt(var3);
         String var5 = "";
         switch (var4.type) {
            case 1:
               Part var6 = AvatarData.getPart(var4.idPart);
               ImageInfo var7 = AvatarData.listImgInfo[var6.h];
               Canvas.a(0, var1.x, var1.y - 50, -1, CRes.createRGBImage(var7.x0 * AvMain.hd, var7.y0 * AvMain.hd, var7.w * AvMain.hd, var7.h * AvMain.hd, AvatarData.getBigImgInfo((int)var7.bigID).img), var2);
               break;
            case 2:
               var5 = "+" + var4.xu + T.C;
               var1.setMoney(var1.money[0] + var4.xu);
               var2 += 20;
               break;
            case 3:
               var5 = "+" + var4.xp + " xp";
               var1.setExp(var1.exp + var4.xp);
               var2 += 20;
               break;
            case 4:
               var5 = "+" + var4.luong + T.D;
               int[] var10000 = var1.money;
               var10000[2] += var4.luong;
               var2 += 20;
         }

         if (!var5.equals("")) {
            Canvas.addFlyTextSmall(var5, var1.x, var1.y - 50, -1, 1, var2);
         }
      }

   }

   public final void update() {
      this.lastScr.update();
      int var1;
      int var2;
      if (this.g > 0) {
         this.degree -= this.g;
         if (this.degree < 0) {
            this.degree += 7200;
         }

         if (this.g < 10) {
            if (this.degree / 20 % 30 == 0) {
               this.g = 0;
            }
         } else {
            --this.g;
         }

         if (Canvas.gameTick % 8 == 4) {
            var1 = CRes.rnd(this.num);
            if ((var2 = this.degree / 20 + var1 * this.part) > 360) {
               var2 -= 360;
            }

            var2 = CRes.fixangle(var2);
            var1 = this.radius * CRes.cos(var2) >> 10;
            var2 = -(this.radius * CRes.sin(var2)) >> 10;
            this.addFire(this.posCenter.x + var1, this.posCenter.y + var2);
         }
      } else if (this.isTurn) {
         DialLuckyScr var6 = this;
         this.isTurn = false;
         this.isPaint = true;
         this.isable = false;
         this.timePaint = System.currentTimeMillis() / 100L;

         for(var2 = 0; var2 < var6.listGift.size(); ++var2) {
            Gift var3 = (Gift)var6.listGift.elementAt(var2);
            int var4;
            if (var2 == 0) {
               var4 = 150;
            } else if (var2 == 1) {
               var4 = 180;
            } else {
               var4 = 210;
            }

            var4 = CRes.fixangle(var4);
            int var5 = var6.radius * CRes.cos(var4) >> 10;
            var4 = -(var6.radius * CRes.sin(var4)) >> 10;
            var3.x = var6.posCenter.x + var5;
            var3.y = var6.posCenter.y + var4;
         }
      }

      if (super.center == this.cmdWait) {
         var1 = 0;

         for(var2 = 0; var2 < this.isFireWork.length; ++var2) {
            if (this.isFireWork[var2]) {
               ++var1;
            }
         }

         if (var1 == 3) {
            super.center = this.cmdClose;
         }
      }

      for(var1 = 0; var1 < this.listFireWork.size(); ++var1) {
         Point var7;
         Point var10000 = var7 = (Point)this.listFireWork.elementAt(var1);
         var10000.x += var7.b;
         if (var7.b > 1 || var7.b < -1) {
            var7.b -= var7.b / CRes.abs(var7.b);
         }

         var7.y += var7.e;
         ++var7.e;
         ++var7.color;
         if (var7.color > 20) {
            this.listFireWork.removeElement(var7);
         }
      }

      if (this.isPaint) {
         for(var1 = 0; var1 < this.listGift.size(); ++var1) {
            if (!this.isFireWork[var1] && System.currentTimeMillis() / 100L - this.timePaint > (long)((var1 + 1) * 5)) {
               this.isFireWork[var1] = true;
               Gift var8 = (Gift)this.listGift.elementAt(var1);
               this.addFire(var8.x, var8.y);
            }
         }
      }

   }

   private void addFire(int var1, int var2) {
      for(int var3 = 0; var3 < 10; ++var3) {
         byte var4 = 1;
         if (var3 % 2 == 0) {
            var4 = -1;
         }

         Point var5;
         (var5 = new Point(var1, var2)).color = 0;
         var5.b = var4 * (CRes.rnd(80) / 10);
         var5.e = -CRes.rnd(70) / 10;
         this.listFireWork.addElement(var5);
      }

   }

   public final void updateKey() {
      if (!this.isPaint) {
         if (Canvas.paint.d() == 1) {
            if (Canvas.isPointerDown) {
               Canvas.keyHold[5] = true;
            }

            if (Canvas.isPointerRelease) {
               Canvas.keyReleased[5] = true;
            }
         }

         if (Canvas.keyHold[5] && !this.isTurn && this.isable) {
            if (this.degreeKim < 270) {
               this.degreeKim += 3;
            }
         } else if (this.degreeKim > 90) {
            this.degreeKim -= 3;
         }

         if (Canvas.keyReleased[5]) {
            if (this.degreeKim > 90 && !this.isTurn && this.isable) {
               this.selectedNumber = this.degreeKim;
               GlobalService.gI().doDialLucky(this.idPart, this.selectedNumber - 90);
               Canvas.startWaitDlg();
            }

            Canvas.keyReleased[5] = false;
         }
      }

      super.updateKey();
   }

   public final void onStart(int var1, int var2, Vector var3) {
      if (var1 != GameMidlet.avatar.IDDB) {
         Avatar var4;
         if ((var4 = LoadMap.g(var1)) != null) {
            setItemBay(var3, var4, var2 + 100 + 20);
            return;
         }
      } else {
         super.center = this.cmdWait;
         this.listGift = var3;
         this.g = 100 + (this.selectedNumber - 90);
         this.isTurn = true;
         Canvas.endDlg();
      }

   }

   public final void paint(Graphics var1) {
      this.lastScr.paintMain(var1);
      Canvas.resetTrans(var1);
      int var2 = this.degree / 20;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      for(var3 = 0; var3 < this.num; ++var3) {
         if ((var4 = var2 + var3 * this.part) > 360) {
            var4 -= 360;
         }

         if (var4 >= 82 && var4 <= 278) {
            var5 = CRes.fixangle(var4);
            var6 = this.radius * CRes.cos(var5) >> 10;
            var7 = -(this.radius * CRes.sin(var5)) >> 10;
            var1.drawImage(this.c, this.posCenter.x + var6, this.posCenter.y + var7, 3);
         }
      }

      if (this.isPaint) {
         Graphics var12 = var1;
         DialLuckyScr var11 = this;

         for(var5 = 0; var5 < var11.listGift.size(); ++var5) {
            if (System.currentTimeMillis() / 100L - var11.timePaint > (long)((var5 + 1) * 5)) {
               Gift var13;
               switch ((var13 = (Gift)var11.listGift.elementAt(var5)).type) {
                  case 1:
                     AvatarData.getPart(var13.idPart).a(var12, var13.x, var13.y, 3);
                     Canvas.borderFont.drawString(var12, var13.expire, var13.x - 17, var13.y - 7, 1);
                     break;
                  case 2:
                     Canvas.borderFont.drawString(var12, T.C, var13.x, var13.y - AvMain.ag / 2, 2);
                     Canvas.borderFont.drawString(var12, String.valueOf(var13.xu), var13.x - 17, var13.y - 8, 1);
                     break;
                  case 3:
                     Canvas.borderFont.drawString(var12, "xp", var13.x, var13.y - AvMain.ag / 2, 2);
                     Canvas.borderFont.drawString(var12, String.valueOf(var13.xp), var13.x - 17, var13.y - 8, 1);
                     break;
                  case 4:
                     Canvas.borderFont.drawString(var12, T.D, var13.x, var13.y - AvMain.ag / 2, 2);
                     Canvas.borderFont.drawString(var12, String.valueOf(var13.luong), var13.x - 17, var13.y - 8, 1);
               }
            }
         }
      }

      var3 = 0;

      for(var4 = 0; var4 < this.num; ++var4) {
         if ((var5 = var2 + var4 * this.part) > 360) {
            var5 -= 360;
         }

         if (var5 >= 82 && var5 <= 278) {
            var6 = CRes.fixangle(var5);
            var7 = this.radius * CRes.cos(var6) >> 10;
            var6 = -(this.radius * CRes.sin(var6)) >> 10;
            long var9 = System.currentTimeMillis() / 100L - this.timePaint;
            if (this.isPaint && var5 >= 150 && var5 <= 210 && (var9 > (long)((var3 + 1) * 5) || var9 <= (long)((var3 + 1) * 5 - 5))) {
               ++var3;
            } else {
               var1.drawImage(this.e, this.posCenter.x + var7, this.posCenter.y + var6, 3);
            }

            var1.drawImage(this.b, this.posCenter.x + var7, this.posCenter.y + var6, 3);
         }
      }

      var1.drawRegion(this.d, 0, 0, 64, 62, 0, this.posCenter.x, this.posCenter.y, 40);
      var1.drawRegion(this.d, 0, 0, 64, 62, 1, this.posCenter.x, this.posCenter.y, 24);
      var5 = CRes.fixangle(this.degreeKim);
      var6 = (this.radius / 3 + 2) * CRes.cos(var5) >> 10;
      var7 = -((this.radius / 3 + 2) * CRes.sin(var5)) >> 10;
      if ((var2 = this.degreeKim + 90) > 360) {
         var2 -= 360;
      }

      var2 = CRes.fixangle(var2);
      var5 = 6 * CRes.cos(var2) >> 10;
      var2 = -(6 * CRes.sin(var2)) >> 10;
      int var8;
      if ((var8 = this.degreeKim - 90) < 0) {
         var8 += 360;
      }

      var8 = CRes.fixangle(var8);
      int var14 = 6 * CRes.cos(var8) >> 10;
      var8 = -(6 * CRes.sin(var8)) >> 10;
      var1.setColor(14483456);
      var1.fillTriangle(this.posCenter.x + var6, this.posCenter.y + var7, this.posCenter.x + var5, this.posCenter.y + var2, this.posCenter.x + var14, this.posCenter.y + var8);
      var1.fillRoundRect(this.posCenter.x - 6, this.posCenter.y - 6, 12, 12, 12, 12);
      if (this.isPaint || this.g > 0) {
         this.paintFireWork(var1);
      }

      super.paint(var1);
   }

   private void paintFireWork(Graphics var1) {
      for(int var2 = 0; var2 < this.listFireWork.size(); ++var2) {
         Point var3 = (Point)this.listFireWork.elementAt(var2);
         this.imgFireWork.drawFrame(var3.color / 5, var3.x, var3.y, 0, 3, var1);
      }

   }
}

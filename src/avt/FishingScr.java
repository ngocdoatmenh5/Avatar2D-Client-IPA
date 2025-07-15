package avt;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;
import javax.microedition.lcdui.Image;

public final class FishingScr extends MyScreen
{
   private static FishingScr me;
   private Command cmdQuanCau;
   private Command cmdClose;
   private Command cmdXong;
   public Image imgPhao;
   public FrameImage imgCa;
   private Fish fish;
   private int h;
   private int i;
   private int j;
   private Image[] imgArrow;
   private int index;
   private byte[] arrIndex;
   private long cTime;
   private short timeDelay;
   private int iCancau;
   private int xKeyArr;
   private int yKeyArr;

   public static FishingScr gI() {
      if (FishingScr.me == null) {
         return FishingScr.me = new FishingScr();
      }
      return FishingScr.me;
   }

   public final void commandTab(final int n, final int n2) {
      switch (n) {
         case 0: {
            if (GameMidlet.avatar.action != 2 && GameMidlet.avatar.action != 13) {
               MapScr.gI().switchToMe();
            }
            final ParkService a;
            (a = ParkService.gI()).createMessage((byte)82);
            a.sendMessage();
            Canvas.startWaitDlg();
            super.center = null;
            return;
         }
         case 1: {
            ParkService.gI().doCauCaXong();
            Canvas.startWaitDlg();
            return;
         }
         case 2: {
            this.doClose();
            ParkService.gI().doCauCaXong();
            break;
         }
      }
   }

   public FishingScr() {
      this.fish = new Fish();
      this.index = 0;
      this.cmdQuanCau = new Command(T.cz, 0);
      this.cmdXong = new Command(T.cy, 1);
      this.cmdClose = new Command(T.d, 2);
      super.center = this.cmdQuanCau;
      FilePack.b(T.av);
      this.imgPhao = FilePack.getImage("cucphao");
      this.imgCa = FrameImage.init("ca", 14 * AvMain.hd, 14 * AvMain.hd);
      FilePack.reset();
      this.j = 530;
   }

   private void doClose() {
      GameMidlet.avatar.resetTypeChair();
      if (GameMidlet.avatar.direct == 0) {
         final Avatar i = GameMidlet.avatar;
         i.x -= 18;
      }
      else {
         final Avatar j = GameMidlet.avatar;
         j.x += 18;
      }
      final Avatar k = GameMidlet.avatar;
      k.y -= 10;
      AvCamera.setDistance(Canvas.w / 10);
      MapScr.listFish.removeElement(this.fish);
      MapScr.gI().switchToMe();
   }

   public final boolean doSat(final int n, final int n2) {
      this.yKeyArr = Canvas.h - Canvas.h / 4;
      if (this.yKeyArr > Canvas.h - 70 * AvMain.hd) {
         this.yKeyArr = Canvas.h - 70 * AvMain.hd;
      }
      this.xKeyArr = 60;
      if (this.xKeyArr < (Canvas.w - LoadMap.wMap * 24) / 2 + 50 * AvMain.hd) {
         this.xKeyArr = (Canvas.w - LoadMap.wMap * 24) / 2 + 50 * AvMain.hd;
      }
      this.index = 0;
      final int d = LoadMap.getposMap(n, n2);
      if (LoadMap.map[d + 1] == 100 || LoadMap.map[d + 1] == 16 || LoadMap.map[d + 1] == 13) {
         GameMidlet.avatar.direct = 0;
         this.xKeyArr = Canvas.w - this.xKeyArr;
      }
      else {
         GameMidlet.avatar.direct = Base.LEFT;
      }
      GameMidlet.avatar.setLayPLayer(n, n2);
      final ParkService a;
      (a = ParkService.gI()).createMessage((byte)86);
      a.sendMessage();
      Canvas.startWaitDlg();
      super.right = this.cmdClose;
      Canvas.clearKeyHold();
      return true;
   }

   public final void update() {
      MapScr.gI().update();
      if (this.fish.isCanCau && !this.fish.isSuccess) {
         if (this.index < this.arrIndex.length && System.currentTimeMillis() - this.cTime > this.timeDelay) {
            this.setIndex(0);
         }
         if (GameMidlet.avatar.action == 2) {
            --this.iCancau;
            if (this.iCancau < 0) {
               this.iCancau = 0;
               this.fish.setPosDay(1);
            }
         }
      }
   }

   public final void keyPress(final int n) {
      if (this.fish.isCanCau && !this.fish.isSuccess) {
         switch (n) {
            case 50:
            case 52:
            case 54:
            case 56: {
               Canvas.keyPressed[n - 48] = true;
               break;
            }
         }
         return;
      }
      MapScr.gI().keyPress(n);
   }

   public final void updateKey() {
      if (this.fish.isCanCau && !this.fish.isSuccess) {
         if (Canvas.a(2)) {
            this.setIndex(2);
         }
         else if (Canvas.a(4)) {
            this.setIndex(1);
         }
         else if (Canvas.a(6)) {
            this.setIndex(3);
         }
         else if (Canvas.a(8)) {
            this.setIndex(4);
         }
      }
      super.updateKey();
   }

   private void setIndex(final int n) {
      this.cTime = System.currentTimeMillis();
      if (this.index < this.arrIndex.length) {
         this.arrIndex[this.index] = (byte)n;
      }
      ++this.index;
      if (GameMidlet.avatar.action != 2) {
         this.fish.setPosDay(0);
         this.iCancau = 2;
      }
      if (this.index >= this.arrIndex.length) {
         this.fish.setPosDay(0);
         this.fish.isSuccess = true;
         ParkService.gI().doFinishFishing(true, this.arrIndex);
         Canvas.startWaitDlg();
      }
   }

   public final void paint(final Graphics graphics) {
      MapScr.gI().paintMain(graphics);
      if (this.fish.isCanCau && !this.fish.isSuccess && this.timeDelay != -1) {
         Canvas.resetTrans(graphics);
         graphics.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
         graphics.setColor(8575990);
         if (this.imgArrow != null && this.index < this.imgArrow.length) {
            if (System.currentTimeMillis() - this.cTime > 50L) {
               graphics.setColor(1423411);
            }
            else {
               graphics.setColor(15612731);
            }
            graphics.fillRoundRect(this.h - 1, this.i * AvMain.hd - 1, this.imgArrow[this.index].getWidth() + 2, this.imgArrow[this.index].getHeight() + 2, 5, 5);
            graphics.drawImage(this.imgArrow[this.index], this.h, this.i * AvMain.hd, 0);
         }
      }
      super.paint(graphics);
   }

   public final void onQuanCau(final int n) {
      final Avatar g;
      if ((g = LoadMap.getAvatar(n)) != null) {
         final Avatar b = g;
         final Fish c;
         if ((c = getFish(b.IDDB)) != null) {
            MapScr.listFish.removeElement(c);
         }
         Fish fish = new Fish();
         if (b.IDDB == GameMidlet.avatar.IDDB) {
            Canvas.endDlg();
            this.fish = fish;
         }
         else {
            fish = new Fish();
         }
         MapScr.listFish.addElement(fish);
         if (b.action != 2) {
            if (b.IDDB != GameMidlet.avatar.IDDB) {
               fish.ava = b;
               fish.isWait = true;
            }
            return;
         }
         fish.doQuanCau(b);
      }
   }

   public final void onCaCanCau(int i, final int h, final short o, final byte[][] array) {
      final Fish c;
      if ((c = getFish(i)) != null && c.isQuan != 0) {
         if ((c.ava.action != 13 && c.ava.action != 2) || c.isCanCau) {
            return;
         }
         c.isCanCau = true;
         c.setPosDay(0);
         c.ava.action = 2;
         c.idFish = h;
         if (o != -1) {
            Canvas.addFlyTextSmall(T.cA, c.ava.x, c.ava.y - 60, -1, 1, -1);
         }
         if (i == GameMidlet.avatar.IDDB) {
            this.cTime = System.currentTimeMillis();
            this.index = 0;
            this.iCancau = 2;
            this.imgArrow = new Image[array.length];
            this.arrIndex = new byte[array.length];
            for (i = 0; i < this.imgArrow.length; ++i) {
               this.imgArrow[i] = CRes.createImage(array[i]);
            }
            this.timeDelay = o;
            this.h = this.fish.posTemp[this.fish.size - 2].x;
            this.i = this.fish.posTemp[this.fish.size - 2].y - 30;
            if (o == -1) {
               this.setIndex(0);
            }
         }
      }
   }

   public final void onFinish(final int n, final int h) {
      final Fish c;
      if ((c = getFish(n)) != null) {
         if (c.ava.action != 2 && c.ava.action != 13) {
            MapScr.listFish.removeElement(c);
            return;
         }
         if (h < 0) {
            Canvas.addFlyTextSmall(T.cB, c.ava.x, c.ava.y - 60, -1, 1, -1);
         }
         c.idFish = h;
         c.isSuccess = true;
         c.setPosDay(0);
         if (c.ava.IDDB == GameMidlet.avatar.IDDB) {
            super.right = this.cmdXong;
            Canvas.endDlg();
         }
      }
   }

   public static Fish getFish(final int n) {
      for (int i = 0; i < MapScr.listFish.size(); ++i) {
         final Fish fish;
         if ((fish = (Fish) MapScr.listFish.elementAt(i)).ava.IDDB == n) {
            return fish;
         }
      }
      return null;
   }

   public final void onCauCaXong(final int n) {
      final Fish c = getFish(n);
      if (n == GameMidlet.avatar.IDDB) {
         super.center = this.cmdQuanCau;
         super.right = this.cmdClose;
         Canvas.endDlg();
      }
      if (c != null) {
         final PartSmall partSmall;
         if (c.idFish > 0 && (partSmall = (PartSmall)AvatarData.getPart((short)c.idFish)) != null) {
            final ImageInfo imageInfo;
            Canvas.addFlyText(1, c.ava.x, c.ava.y + c.ava.ySat - 50, -1, Image.createImage(AvatarData.getBigImgInfo((int)(imageInfo = AvatarData.listImgInfo[partSmall.idIcon]).bigID).img, imageInfo.x0 * AvMain.hd, imageInfo.y0 * AvMain.hd, imageInfo.w * AvMain.hd, imageInfo.h * AvMain.hd, 0), -1);
         }
         MapScr.listFish.removeElement(c);
      }
   }

   public final void onStartFishing(final boolean b, final String s) {
      if (b) {
         this.fish.doSetDayCau();
         super.center = this.cmdQuanCau;
         this.switchToMe();
         AvCamera.setDistance(Canvas.w / 3);
         Canvas.endDlg();
         return;
      }
      Canvas.startOK(s, 0, this);
   }

   public final void commandActionPointer(final int n) {
      switch (n) {
         case 0: {
            this.doClose();
            break;
         }
      }
   }

   public static void onStatus(final int n, final int n2) {
      final Avatar g;
      if ((g = LoadMap.getAvatar(n)) != null && (g.action == 2 || g.action == 13)) {
         final Fish obj = new Fish();
         MapScr.listFish.addElement(obj);
         obj.doQuanCau(g);
         obj.doQuanDay();
         obj.posDay[obj.size - 1].x = g.x + 70 + (AvMain.hd - 1) * 35 + CRes.rnd(25);
         obj.posDay[obj.size - 1].y = g.y;
         obj.isQuan = 1;
         obj.countQuan = -1;
         obj.setPosDay(1);
         if (n2 == 2) {
            obj.isCanCau = true;
            return;
         }
         if (n2 == 3) {
            obj.isCanCau = true;
            obj.isSuccess = true;
            obj.distant = 2;
         }
      }
   }

   public final void commandActionPointer(final int n, final int n2) {
   }

   public final void onInfo(final int n, final byte b, final byte b2, final int n2, final short n3) {
      Avatar g;
      if ((g = LoadMap.getAvatar(n)) == null && ListScr.tempList != null) {
         for (int i = 0; i < ListScr.tempList.size(); ++i) {
            final Avatar avatar;
            if ((avatar = (Avatar) ListScr.tempList.elementAt(i)).IDDB == n) {
               g = avatar;
            }
         }
      }
      final Avatar avatar2;
      if ((avatar2 = g) != null) {
         final Vector vector;
         (vector = new Vector()).addElement(new CommandInfo(this, null, 0, avatar2, b, b2, n2, n3));
         PopupShop.gI().addElement(new String[] { T.cw }, new Vector[1], vector);
         PopupShop.gI().switchToMe();
      }
      Canvas.endDlg();
   }
}

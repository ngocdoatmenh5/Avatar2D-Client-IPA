package avt;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;
import javax.microedition.lcdui.Image;

public final class FishingScr extends MyScreen
{
   private static FishingScr c;
   private Command d;
   private Command e;
   private Command f;
   public Image a;
   public FrameImage b;
   private Fish g;
   private int h;
   private int i;
   private int j;
   private Image[] k;
   private int l;
   private byte[] m;
   private long n;
   private short o;
   private int p;
   private int q;
   private int r;

   public static FishingScr b() {
      if (FishingScr.c == null) {
         return FishingScr.c = new FishingScr();
      }
      return FishingScr.c;
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
            this.e();
            ParkService.gI().doCauCaXong();
            break;
         }
      }
   }

   public FishingScr() {
      this.g = new Fish();
      this.l = 0;
      this.d = new Command(T.cz, 0);
      this.f = new Command(T.cy, 1);
      this.e = new Command(T.d, 2);
      super.center = this.d;
      FilePack.b(T.av);
      this.a = FilePack.getImage("cucphao");
      this.b = FrameImage.init("ca", 14 * AvMain.hd, 14 * AvMain.hd);
      FilePack.reset();
      this.j = 530;
   }

   private void e() {
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
      MapScr.listFish.removeElement(this.g);
      MapScr.gI().switchToMe();
   }

   public final boolean b(final int n, final int n2) {
      this.r = Canvas.h - Canvas.h / 4;
      if (this.r > Canvas.h - 70 * AvMain.hd) {
         this.r = Canvas.h - 70 * AvMain.hd;
      }
      this.q = 60;
      if (this.q < (Canvas.w - LoadMap.wMap * 24) / 2 + 50 * AvMain.hd) {
         this.q = (Canvas.w - LoadMap.wMap * 24) / 2 + 50 * AvMain.hd;
      }
      this.l = 0;
      final int d = LoadMap.getposMap(n, n2);
      if (LoadMap.map[d + 1] == 100 || LoadMap.map[d + 1] == 16 || LoadMap.map[d + 1] == 13) {
         GameMidlet.avatar.direct = 0;
         this.q = Canvas.w - this.q;
      }
      else {
         GameMidlet.avatar.direct = Base.LEFT;
      }
      GameMidlet.avatar.setLayPLayer(n, n2);
      final ParkService a;
      (a = ParkService.gI()).createMessage((byte)86);
      a.sendMessage();
      Canvas.startWaitDlg();
      super.right = this.e;
      Canvas.f();
      return true;
   }

   public final void update() {
      MapScr.gI().update();
      if (this.g.isCanCau && !this.g.isSuccess) {
         if (this.l < this.m.length && System.currentTimeMillis() - this.n > this.o) {
            this.f(0);
         }
         if (GameMidlet.avatar.action == 2) {
            --this.p;
            if (this.p < 0) {
               this.p = 0;
               this.g.setPosDay(1);
            }
         }
      }
   }

   public final void keyPress(final int n) {
      if (this.g.isCanCau && !this.g.isSuccess) {
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
      if (this.g.isCanCau && !this.g.isSuccess) {
         if (Canvas.a(2)) {
            this.f(2);
         }
         else if (Canvas.a(4)) {
            this.f(1);
         }
         else if (Canvas.a(6)) {
            this.f(3);
         }
         else if (Canvas.a(8)) {
            this.f(4);
         }
      }
      super.updateKey();
   }

   private void f(final int n) {
      this.n = System.currentTimeMillis();
      if (this.l < this.m.length) {
         this.m[this.l] = (byte)n;
      }
      ++this.l;
      if (GameMidlet.avatar.action != 2) {
         this.g.setPosDay(0);
         this.p = 2;
      }
      if (this.l >= this.m.length) {
         this.g.setPosDay(0);
         this.g.isSuccess = true;
         ParkService.gI().doFinishFishing(true, this.m);
         Canvas.startWaitDlg();
      }
   }

   public final void paint(final Graphics graphics) {
      MapScr.gI().paintMain(graphics);
      if (this.g.isCanCau && !this.g.isSuccess && this.o != -1) {
         Canvas.resetTrans(graphics);
         graphics.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
         graphics.setColor(8575990);
         if (this.k != null && this.l < this.k.length) {
            if (System.currentTimeMillis() - this.n > 50L) {
               graphics.setColor(1423411);
            }
            else {
               graphics.setColor(15612731);
            }
            graphics.fillRoundRect(this.h - 1, this.i * AvMain.hd - 1, this.k[this.l].getWidth() + 2, this.k[this.l].getHeight() + 2, 5, 5);
            graphics.drawImage(this.k[this.l], this.h, this.i * AvMain.hd, 0);
         }
      }
      super.paint(graphics);
   }

   public final void b(final int n) {
      final Avatar g;
      if ((g = LoadMap.getAvatar(n)) != null) {
         final Avatar b = g;
         final Fish c;
         if ((c = c(b.IDDB)) != null) {
            MapScr.listFish.removeElement(c);
         }
         Fish fish = new Fish();
         if (b.IDDB == GameMidlet.avatar.IDDB) {
            Canvas.endDlg();
            this.g = fish;
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

   public final void a(int i, final int h, final short o, final byte[][] array) {
      final Fish c;
      if ((c = c(i)) != null && c.isQuan != 0) {
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
            this.n = System.currentTimeMillis();
            this.l = 0;
            this.p = 2;
            this.k = new Image[array.length];
            this.m = new byte[array.length];
            for (i = 0; i < this.k.length; ++i) {
               this.k[i] = CRes.createImage(array[i]);
            }
            this.o = o;
            this.h = this.g.posTemp[this.g.size - 2].x;
            this.i = this.g.posTemp[this.g.size - 2].y - 30;
            if (o == -1) {
               this.f(0);
            }
         }
      }
   }

   public final void c(final int n, final int h) {
      final Fish c;
      if ((c = c(n)) != null) {
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
            super.right = this.f;
            Canvas.endDlg();
         }
      }
   }

   public static Fish c(final int n) {
      for (int i = 0; i < MapScr.listFish.size(); ++i) {
         final Fish fish;
         if ((fish = (Fish) MapScr.listFish.elementAt(i)).ava.IDDB == n) {
            return fish;
         }
      }
      return null;
   }

   public final void e(final int n) {
      final Fish c = c(n);
      if (n == GameMidlet.avatar.IDDB) {
         super.center = this.d;
         super.right = this.e;
         Canvas.endDlg();
      }
      if (c != null) {
         final PartSmall partSmall;
         if (c.idFish > 0 && (partSmall = (PartSmall)AvatarData.getPart((short)c.idFish)) != null) {
            final ImageInfo imageInfo;
            Canvas.a(1, c.ava.x, c.ava.y + c.ava.ySat - 50, -1, Image.createImage(AvatarData.getBigImgInfo((int)(imageInfo = AvatarData.listImgInfo[partSmall.idIcon]).bigID).img, imageInfo.x0 * AvMain.hd, imageInfo.y0 * AvMain.hd, imageInfo.w * AvMain.hd, imageInfo.h * AvMain.hd, 0), -1);
         }
         MapScr.listFish.removeElement(c);
      }
   }

   public final void a(final boolean b, final String s) {
      if (b) {
         this.g.doSetDayCau();
         super.center = this.d;
         this.switchToMe();
         AvCamera.setDistance(Canvas.w / 3);
         Canvas.endDlg();
         return;
      }
      Canvas.startOK(s, 0, this);
   }

   public final void commandTab(final int n) {
      switch (n) {
         case 0: {
            this.e();
            break;
         }
      }
   }

   public static void e(final int n, final int n2) {
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

   public final void a(final int n, final byte b, final byte b2, final int n2, final short n3) {
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

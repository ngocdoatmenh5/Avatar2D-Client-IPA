package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class HouseScr extends MyScreen implements IChatable {
   public static HouseScr a;
   private int h;
   private int i;
   private int j = -1;
   private Command k;
   private Command l;
   private Command m;
   private static short n = 0;
   public static boolean b = false;
   private Vector o;
   public byte c = -1;
   private int p = -1;
   public int d = -1;
   private int q;
   public static boolean e = false;
   private class_he[] r;
   private AvPosition s;
   private AvPosition t;
   private BigImgInfo u;
   private Image v;
   private int w = -1;
   private int x = -1;
   private int[] y = new int[]{1688583, 14744065};
   public int f;
   public int g;
   private short z = 69;
   private short A = 68;
   private short[] B;
   private int C = 0;
   private Vector D;
   private Vector E;
   private int F;
   private byte G;

   public static HouseScr b() {
      if (a == null) {
         a = new HouseScr();
      }

      return a;
   }

   public final void switchToMe() {
      super.switchToMe();
      this.i();
   }

   public HouseScr() {
      this.k = new Command(T.cS, 0);
      this.l = new Command(T.cy, 1);
      this.m = new Command(T.c, 2);
      FilePack.b(T.av);
      this.v = FilePack.getImage("hand");
      FilePack.reset();
   }

   private void i() {
      if (this.q == GameMidlet.avatar.IDDB) {
         super.center = MapScr.gI().e;
         super.center.caption = T.O;
         super.left = this.m;
      } else {
         super.left = this.m;
         if (Canvas.stypeInt == 0) {
            super.center = MapScr.gI().e;
         }

      }
   }

   private void j() {
      LoadMap.b(GameMidlet.avatar);
      GameMidlet.avatar.x = this.t.x;
      GameMidlet.avatar.y = this.t.y;
      GameMidlet.avatar.action = 0;
      AvCamera.gI().setToPos(this.t.x * AvMain.hd, this.t.y * AvMain.hd);
   }

   public final void close() {
      MapScr.gI().e();
   }

   private void m() {
      super.center = new Command(T.O, 3);
      super.right = new Command(T.cy, 4);
      super.left = null;
      e = true;
      this.h = GameMidlet.avatar.x / 24;
      this.i = GameMidlet.avatar.y / 24;
      LoadMap.c(GameMidlet.avatar);
   }

   private void n() {
      HomeMsgHandler.a();
      this.h = GameMidlet.avatar.x / 24;
      this.i = GameMidlet.avatar.y / 24;
      LoadMap.c(GameMidlet.avatar);
   }

   private static void o() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < LoadMap.playerLists.size(); ++var1) {
         Base var2;
         if ((var2 = (Base)LoadMap.playerLists.elementAt(var1)).catagory == 0 && var2.IDDB != GameMidlet.avatar.IDDB) {
            var0.addElement(new Command(var2.name, 16, var1));
         }
      }

      MenuSub.gI().startAt(var0, 0);
   }

   private void p() {
      this.n();
      if (this.B == null) {
         this.B = new short[LoadMap.map.length];

         for(int var1 = 0; var1 < LoadMap.map.length; ++var1) {
            this.B[var1] = LoadMap.map[var1];
         }
      }

      b = false;
      super.center = this.k;
      super.right = this.l;
      super.left = new Command(T.O, 5);
      Vector var4 = new Vector();

      for(int var2 = 0; var2 < this.r.length; ++var2) {
         if (this.r[var2].b != -1 || this.r[var2].c != -1) {
            var4.addElement(new class_gl(this, this.r[var2].a + "(" + Canvas.getPriceMoney(this.r[var2].b, this.r[var2].c, true) + ")", 17, var2, var2));
         }
      }

      if (var4.size() > 0) {
         MenuSub.gI().a(var4, Canvas.hw, 27 * AvMain.hd, 27 * AvMain.hd);
      }

   }

   private void q() {
      this.d = -1;
      this.j = -1;
      e = false;
      b = false;
      this.i();
      super.right = null;
      if (LoadMap.g(GameMidlet.avatar.IDDB) == null) {
         this.j();
      }

   }

   private void r() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < AvatarData.listMapItemType.size(); ++var2) {
         MapItemType var3;
         int var4;
         if ((var3 = (MapItemType)AvatarData.listMapItemType.elementAt(var2)).buy != 0 && (this.c != 4 && (var3.buy == 1 || var3.buy == 2) || this.c == 4) && (var4 = var3.name.indexOf(":")) != -1) {
            boolean var5 = false;
            String var6 = var3.name.substring(0, var4);

            for(var4 = 0; var4 < var1.size(); ++var4) {
               if (((Command)var1.elementAt(var4)).caption.equals(var6)) {
                  var5 = true;
               }
            }

            if (!var5 || var1.size() == 0) {
               var1.addElement(new Command(var6, 18, var2));
            }
         }
      }

      MenuSub.gI().startAt(var1, 2);
   }

   private void b(String var1) {
      this.q();
      Vector var2 = new Vector();

      for(int var3 = 0; var3 < AvatarData.listMapItemType.size(); ++var3) {
         MapItemType var4;
         int var5 = (var4 = (MapItemType)AvatarData.listMapItemType.elementAt(var3)).name.indexOf(var1);
         if (var4.buy != 0 && var5 != -1 && (this.c != 4 && (var4.buy == 1 || var4.buy == 2) || this.c == 4)) {
            String var8 = var4.name.substring(var4.name.indexOf(":") + 1);
            String var6 = Canvas.getPriceMoney(var4.priceXu, var4.priceLuong, true);
            var2.addElement(new class_gk(this, "", new class_gi(this, var3, var1), var4, 90, var6, var8));
         }
      }

      if (var2.size() > 0) {
         MenuSub.gI().a(var2, Canvas.hw, 90, 90);
         MenuSub.g = new class_gj(this);
      }

   }

   private boolean a(MapItemType var1) {
      if (var1.buy != 2 && var1.buy != 4) {
         if (LoadMap.type[this.i * LoadMap.wMap + this.h] != 80) {
            Canvas.startOKDlg(T.db);
            return true;
         }

         for(int var5 = 0; var5 < var1.listNotTrans.size(); ++var5) {
            AvPosition var6 = (AvPosition)var1.listNotTrans.elementAt(var5);
            if (LoadMap.type[(this.i + var6.y) * LoadMap.wMap + this.h + var6.x] != 80) {
               Canvas.startOKDlg(T.db);
               return true;
            }
         }
      } else {
         String var2 = "";

         int var3;
         for(var3 = 0; var3 < this.o.size(); ++var3) {
            MapItem var4 = (MapItem)this.o.elementAt(var3);
            if (var3 != this.d && var4.typeID == var1.idType && this.h == var4.x / 24 && this.i == var4.y / 24) {
               var2 = T.dc;
               break;
            }
         }

         if (!var2.equals("")) {
            Canvas.startOKDlg(var2);
            return true;
         }

         if (var1.buy == 2 || var1.buy == 4) {
            var3 = (this.i - 1) * LoadMap.wMap + this.h;
            if (LoadMap.map[var3] < n || LoadMap.map[this.i * LoadMap.wMap + this.h] >= n) {
               Canvas.startOKDlg(T.dd);
               return true;
            }
         }
      }

      return false;
   }

   public final void a(MapItem var1) {
      if (d(var1)) {
         ++var1.y;
      }

      this.o.addElement(var1);
      LoadMap.treeLists.addElement(var1);
      this.c(var1);
      LoadMap.a(LoadMap.treeLists);
   }

   public final void updateKey() {
      super.updateKey();
      if (!e) {
         Canvas.loadMap.a();
         GameMidlet.avatar.updateKey();
      } else {
         boolean var1 = false;
         if (Canvas.a(2)) {
            if (!b(this.h, this.i - 1)) {
               --this.i;
            }

            if (this.i < 0) {
               this.i = 0;
            }

            var1 = true;
         } else if (Canvas.a(4)) {
            if (!b(this.h - 1, this.i)) {
               --this.h;
            }

            if (this.h < 0) {
               this.h = 0;
            }

            var1 = true;
            GameMidlet.avatar.direct = Base.LEFT;
         } else if (Canvas.a(6)) {
            if (!b(this.h + 1, this.i)) {
               ++this.h;
            }

            if (this.h >= LoadMap.wMap) {
               this.h = LoadMap.wMap - 1;
            }

            var1 = true;
            GameMidlet.avatar.direct = 0;
         } else if (Canvas.a(8)) {
            if (!b(this.h, this.i + 1)) {
               ++this.i;
            }

            if (this.i >= LoadMap.Hmap) {
               this.i = LoadMap.Hmap - 1;
            }

            var1 = true;
         }

         if (Canvas.isPointerRelease) {
            int var3 = (AvCamera.gI().xCam + Canvas.px) / (LoadMap.i * AvMain.hd);
            int var2 = (AvCamera.gI().yCam + Canvas.py) / (LoadMap.i * AvMain.hd);
            if (var3 == this.h && var2 == this.i && super.center != null) {
               super.center.perform();
            }

            this.h = var3;
            this.i = var2;
            var1 = true;
            Canvas.isPointerRelease = false;
         }

         if (var1) {
            GameMidlet.avatar.x = this.h * 24 + 12;
            GameMidlet.avatar.y = this.i * 24 + 12;
            if (this.d != -1 && this.o.size() > 0) {
               MapItem var4;
               (var4 = (MapItem)this.o.elementAt(this.d)).x = this.h * 24;
               var4.y = this.i * 24;
               LoadMap.a(LoadMap.treeLists);
            }
         }

      }
   }

   private static boolean b(int var0, int var1) {
      return LoadMap.map[var1 * LoadMap.wMap + var0] == LoadMap.c.nFrame - 2 || LoadMap.map[var1 * LoadMap.wMap + var0] == -1;
   }

   public final void update() {
      MapScr.gI().update();
      if (!e && !b && super.right == null && MapScr.gI().right != null) {
         super.right = LoadMap.q;
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      super.paint(var1);
      Canvas.a(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.loadMap.b(var1);
      if (e && Canvas.menuMain == null) {
         Graphics var3 = var1;
         HouseScr var2 = this;
         int var6;
         if (!b && this.d == -1) {
            if (this.j != -1) {
               var6 = 0;

               while(true) {
                  if (var6 >= LoadMap.type.length) {
                     LoadMap.c.drawFrame(var2.j, var2.h * 24 * AvMain.hd, var2.i * 24 * AvMain.hd, 0, 0, var3);
                     break;
                  }

                  if (var2.p == 0 && LoadMap.map[var6] >= n && LoadMap.map[var6] < var2.r.length && (var2.r[LoadMap.map[var6]].c != -1 || var2.r[LoadMap.map[var6]].b != -1) || var2.p == 1 && LoadMap.map[var6] < n) {
                     var2.a(var3, 2 + var6 % LoadMap.wMap * 24, 2 + var6 / LoadMap.wMap * 24, 0, 20);
                  }

                  ++var6;
               }
            }
         } else if (this.j != -1) {
            MapItemType var4;
            if ((var4 = (MapItemType)AvatarData.listMapItemType.elementAt(this.j)).buy != 2 && var4.buy != 4) {
               for(var6 = 0; var6 < LoadMap.type.length; ++var6) {
                  if (LoadMap.type[var6] == 80 && (var6 % LoadMap.wMap != var2.h || var6 / LoadMap.wMap != var2.i)) {
                     var2.a(var3, 2 + var6 % LoadMap.wMap * 24, 2 + var6 / LoadMap.wMap * 24, 0, 20);
                  }
               }
            } else {
               for(var6 = 0; var6 < LoadMap.map.length; ++var6) {
                  if (var6 > 0 && LoadMap.map[var6] < n && LoadMap.map[var6 - LoadMap.wMap] >= n) {
                     var2.a(var3, 2 + var6 % LoadMap.wMap * 24, 2 + var6 / LoadMap.wMap * 24, 0, 20);
                  }
               }
            }
         }

         var2.a(var3, var2.h * 24, var2.i * 24, 1, 24);
      }

      Canvas.loadMap.d(var1);
      if (e) {
         if (b && this.j != -1) {
            MapItemType var5 = (MapItemType)AvatarData.listMapItemType.elementAt(this.j);
            AvatarData.paintImg(var1, var5.imgID, (this.h * 24 + var5.dx) * AvMain.hd, (this.i * 24 + var5.dy) * AvMain.hd, 0);
         }

         if (Canvas.menuMain == null) {
            var1.drawImage(this.v, (this.h * 24 + 12) * AvMain.hd, (this.i * 24 + this.C) * AvMain.hd, 33);
         }

         if (this.p != -1) {
            Canvas.borderFont.drawString(var1, this.r[this.j].a + "(" + Canvas.getPriceMoney(this.r[this.j].b, this.r[this.j].c, true) + ")", (this.h * 24 + 12) * AvMain.hd, (this.i * 24 - 40) * AvMain.hd, 2);
         }

         ++this.C;
         if (this.C > 5) {
            this.C = 0;
         }
      }

      Canvas.resetTrans(var1);
      LoadMap.a(var1);
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(this.y[var4]);
      var1.drawRect(var2 * AvMain.hd, var3 * AvMain.hd, (var5 - 1) * AvMain.hd, (var5 - 1) * AvMain.hd);
   }

   public final void a(byte var1, int var2, short[] var3, byte var4, Vector var5, Vector var6) {
      this.c = (byte)var1;
      this.q = var2;
      this.o = var5;
      LoadMap.wMap = var4;
      LoadMap.Hmap = (short)(var3.length / var4);
      LoadMap.map = var3;
      if (this.c == 4) {
         Canvas.loadMap.e(111);
      } else {
         Canvas.loadMap.e(68 + this.c);
      }

      LoadMap.t = -1;
      var1 = -1;
      var2 = 0;

      int var8;
      int var14;
      for(var8 = 0; var8 < var4; ++var8) {
         for(var14 = 0; var14 < LoadMap.Hmap; ++var14) {
            if (LoadMap.map[var14 * var4 + var8] < n) {
               LoadMap.type[var14 * var4 + var8] = 80;
            } else {
               LoadMap.type[var14 * var4 + var8] = 88;
            }
         }

         if (LoadMap.map[(LoadMap.Hmap - 1) * var4 + var8] == this.u.img.getHeight() / (24 * AvMain.hd) - 1) {
            LoadMap.map[(LoadMap.Hmap - 1) * var4 + var8] = LoadMap.map[(LoadMap.Hmap - 2) * var4 + var8];
            LoadMap.type[(LoadMap.Hmap - 1) * var4 + var8] = 21;
            ++var2;
            if (var1 == -1) {
               var1 = (byte) (var8 * 24);
            }
         }
      }

      this.t = new AvPosition(var1 + var2 * 24 / 2, LoadMap.Hmap * 24 - 30);
      GameMidlet.avatar.x = this.t.x;
      GameMidlet.avatar.y = this.t.y;
      Pet var11;
      if ((var11 = LoadMap.h(GameMidlet.avatar.IDDB)) != null) {
         var11.setPos(GameMidlet.avatar.x, GameMidlet.avatar.y);
         var11.reset();
      }

      AvCamera.gI().init(70 + this.c);
      LoadMap.c = new FrameImage(this.u.img, 24 * AvMain.hd, 24 * AvMain.hd);

      for(var14 = 0; var14 < var6.size(); ++var14) {
         Avatar var7;
         (var7 = (Avatar)var6.elementAt(var14)).xCur = var7.x;
         var7.yCur = var7.y;
         if (var7.IDDB != GameMidlet.avatar.IDDB) {
            LoadMap.b(var7);
         }
      }

      var14 = 0;
      var1 = 0;

      for(var2 = 0; var2 < this.o.size(); ++var2) {
         MapItem var12;
         if ((var12 = (MapItem)this.o.elementAt(var2)).x == 0 && var12.y == 0) {
            boolean var13 = false;

            for(int var16 = 0; var16 < LoadMap.map.length; ++var16) {
               if (LoadMap.type[var16] == 80) {
                  var12.x = var16 % LoadMap.wMap * 24;
                  var12.y = var16 / LoadMap.wMap * 24;
                  var14 = var12.x;
                  var1 = (byte) var12.y;
                  var13 = true;
                  this.c(var12);
                  AvatarService.gI().doSortItem(var12.typeID, 0, 0, var12.x / 24, var12.y / 24, var12.dir);
                  break;
               }
            }

            if (!var13) {
               var12.x = var14;
               var12.y = var1;
               AvatarService.gI().doSortItem(var12.typeID, 0, 0, var12.x / 24, var12.y / 24, var12.dir);
            }
         }

         if (d(var12)) {
            ++var12.y;
         }
      }

      MapScr.gI().n();
      Vector var10 = this.o;
      HouseScr var9 = this;

      for(var8 = 0; var8 < var10.size(); ++var8) {
         MapItem var15 = (MapItem)var10.elementAt(var8);
         LoadMap.treeLists.addElement(var15);
         var9.c(var15);
      }

      LoadMap.a(LoadMap.treeLists);
      this.switchToMe();
      Canvas.endDlg();
   }

   private static boolean d(MapItem var0) {
      if (AvatarData.getMapItemTypeByID((int)var0.typeID).buy != 2 && AvatarData.getMapItemTypeByID((int)var0.typeID).buy != 4) {
         int var1 = (var0.y / 24 - 1) * LoadMap.wMap + var0.x / 24;
         if (LoadMap.map[var1] >= n && LoadMap.map[var0.y / 24 * LoadMap.wMap + var0.x / 24] < n) {
            return true;
         }
      }

      return false;
   }

   private BigImgInfo s() {
      DataInputStream var1;
      if ((var1 = AvatarData.loadRMS("avatarTileMap")) == null) {
         return null;
      } else {
         this.u = new BigImgInfo();

         try {
            this.u.ver = var1.readShort();
            n = var1.readShort();
            byte[] var2 = new byte[var1.available()];
            var1.read(var2);
            this.u.img = CRes.createImage(var2);
            var1.close();
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         return this.u;
      }
   }

   public final void a(byte[] var1, int var2) {
      n = (short)var2;
      this.u.img = CRes.createImage(var1);
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      DataOutputStream var4 = new DataOutputStream(var3);

      try {
         var4.writeShort(this.u.ver);
         var4.writeShort(var2);
         var4.write(var1);
         CRes.saveRMS("avatarTileMap", var3.toByteArray());
         var4.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      if (MapScr.v != -1) {
         AvatarService.gI().doJoinHouse(MapScr.v);
         MapScr.v = -1;
      } else {
         Canvas.endDlg();
      }
   }

   public final void commandTab(int var1, int var2) {
      int var3;
      Vector var7;
      switch (var1) {
         case 0:
            if (this.j == -1) {
               return;
            }

            var2 = this.i * LoadMap.wMap + this.h;
            if (this.r[LoadMap.map[var2]].c == -1 && this.r[LoadMap.map[var2]].b == -1) {
               Canvas.startOKDlg(T.db);
            } else {
               if ((this.j >= n || LoadMap.map[var2] < n) && (this.j < n || LoadMap.map[var2] >= n)) {
                  this.w = this.h;
                  this.x = this.i;
                  LoadMap.map[this.i * LoadMap.wMap + this.h] = (short)this.j;
                  return;
               }

               Canvas.startOKDlg(T.db);
            }
            break;
         case 1:
            this.j = -1;
            this.p = -1;
            this.w = -1;
            this.x = -1;
            boolean var6 = false;

            for(var2 = 0; var2 < this.B.length; ++var2) {
               if (this.B[var2] != LoadMap.map[var2]) {
                  var6 = true;
                  break;
               }
            }

            if (var6) {
               AvatarService.gI().doCreateHome(LoadMap.map, 0);
               Canvas.startWaitDlg();
            }

            this.j();
            e = false;
            this.i();
            super.right = null;
            return;
         case 2:
            var7 = new Vector();
            if (this.q == GameMidlet.avatar.IDDB) {
               var7.addElement(new Command(T.co, 1));
               var7.addElement(new Command(T.cT, 2));
               var1 = 0;

               for(var3 = 0; var3 < LoadMap.playerLists.size(); ++var3) {
                  if (((MyObject)LoadMap.playerLists.elementAt(var3)).catagory == 0) {
                     ++var1;
                  }
               }

               if (var1 > 1) {
                  var7.addElement(new Command(T.v, 3));
               }

               var7.addElement(new Command(T.t, 4));
            }

            var7.addElement(new Command(T.x, 5));
            MenuSub.gI().startAt(var7, 0);
            return;
         case 3:
            (var7 = new Vector()).addElement(new Command(T.cY, 11));
            var7.addElement(new Command(T.cZ, 12));
            var7.addElement(new Command(T.bg, 13));
            MenuSub.gI().startAt(var7, 2);
            MenuSub var10000 = MenuSub.gI();
            int var10001 = this.h * 24 * AvMain.hd - AvCamera.gI().xCam - MenuSub.gI().c / 2 + 12;
            int var4 = this.i * 24 * AvMain.hd - AvCamera.gI().yCam - MenuSub.gI().d - 12;
            var3 = var10001;
            MenuSub var5 = var10000;
            var10000.a = var3;
            var5.b = var4;
            if (var5.a < 0) {
               var5.a = 0;
            }

            if (var5.b < 0) {
               var5.b = 0;
            }

            return;
         case 4:
            this.q();
            return;
         case 5:
            this.p();
            return;
         case 8:
            InputFace.b();
            Canvas.currentFace = null;
            return;
         case 50:
            AvatarService.gI().doCreateHome(LoadMap.map, 1);
            Canvas.startWaitDlg();
            return;
         case 51:
            LoadMap.map = this.B;
            this.B = null;
            ParkMsgHandler.a();
            return;
         case 53:
            GlobalService.gI().i(0);
            Canvas.startWaitDlg();
            return;
         case 100:
            AvatarService.gI().doSetPassMyHouse(Canvas.inputDlg.a(), 0, 0);
            Canvas.endDlg();
            return;
         case 101:
            GlobalService.gI().a(Canvas.inputDlg.a(), (byte)0);
      }

   }

   public final void a(short var1, String var2) {
      Canvas.endDlg();
      if (var1 == 0) {
         Vector var3;
         (var3 = new Vector()).addElement(new Command(T.o, 50));
         var3.addElement(new Command(T.p, 51));
         Canvas.a(var2, var3);
      } else {
         Canvas.startOKDlg(var2);
         if (var1 == 2) {
            LoadMap.map = this.B;
         }

         this.B = null;
         ParkMsgHandler.a();
         GameMidlet.avatar.x = this.t.x;
         GameMidlet.avatar.y = this.t.y;
         super.center = MapScr.gI().e;
         AvCamera.gI().init(70 + this.c);
      }
   }

   public final void a(class_he[] var1) {
      this.r = var1;
      this.p();
      Canvas.endDlg();
   }

   private void e(MapItem var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.o.size(); ++var3) {
         MapItem var4;
         if ((var4 = (MapItem)this.o.elementAt(var3)).x / 24 == var1.x / 24 && var4.y / 24 == var1.y / 24) {
            ++var2;
         }
      }

      if (var2 == 1) {
         MapItemType var6 = AvatarData.getMapItemTypeByID((int)var1.typeID);

         for(int var7 = 0; var7 < var6.listNotTrans.size(); ++var7) {
            AvPosition var5 = (AvPosition)var6.listNotTrans.elementAt(var7);
            LoadMap.type[(var1.y / 24 + var5.y) * LoadMap.wMap + var1.x / 24 + var5.x] = 80;
         }
      }

   }

   public final void b(MapItem var1) {
      MapItem var2 = var1;
      HouseScr var5 = this;
      int var3 = 0;

      MapItem var10000;
      while(true) {
         if (var3 >= var5.o.size()) {
            var10000 = null;
            break;
         }

         MapItem var4;
         if ((var4 = (MapItem)var5.o.elementAt(var3)).x / 24 == var2.x && var4.y / 24 == var2.y && var4.typeID == var2.typeID) {
            var10000 = var4;
            break;
         }

         ++var3;
      }

      var1 = var10000;
      LoadMap.treeLists.removeElement(var1);
      this.o.removeElement(var1);
      this.e(var1);
      ParkMsgHandler.a();
      Canvas.endDlg();
   }

   public final void c(MapItem var1) {
      MapItemType var2 = AvatarData.getMapItemTypeByID((int)var1.typeID);
      byte var3 = 88;
      if (var2.idType == this.A) {
         var3 = 112;
      } else if (var2.idType == this.z) {
         var3 = 111;
      } else if (var2.iconID == 1) {
         var3 = 79;
      } else if (var2.iconID == 2) {
         var3 = 67;
      }

      for(int var4 = 0; var4 < var2.listNotTrans.size(); ++var4) {
         AvPosition var5 = (AvPosition)var2.listNotTrans.elementAt(var4);
         LoadMap.type[(var1.y / 24 + var5.y) * LoadMap.wMap + var1.x / 24 + var5.x] = var3;
      }

   }

   public final void a(int var1, int var2, short var3, Vector var4) {
      if (var1 != 0) {
         for(var1 = 0; var1 < var4.size(); ++var1) {
            Avatar var6;
            Avatar var7 = ListScr.b((var6 = (Avatar)var4.elementAt(var1)).IDDB);
            if (var6 != null && var7 != null) {
               var7.typeHome = var6.typeHome;
            }
         }

         Canvas.endDlg();
         this.e();
      } else {
         GameMidlet.avatar.typeHome = (byte)var2;
         MapScr.gI().switchToMe();
         boolean var10000;
         if (this.u == null) {
            this.s();
            if (this.u != null && var3 == this.u.ver) {
               var10000 = true;
            } else {
               if (this.u == null) {
                  this.u = new BigImgInfo();
                  this.u.ver = var3;
               }

               AvatarService var5;
               (var5 = AvatarService.gI()).createMessage((byte)-73);
               var5.sendMessage();
               var10000 = false;
            }
         } else {
            var10000 = true;
         }

         if (var10000) {
            if (MapScr.v != -1) {
               AvatarService.gI().doJoinHouse(MapScr.v);
               MapScr.v = -1;
            } else {
               Canvas.load = 1;
               Canvas.endDlg();
            }
         } else {
            Canvas.load = 1;
         }
      }
   }

   public final void keyPress(int var1) {
      ChatTextField.gI().startChat(var1, this);
      super.keyPress(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         ParkService.a().a(var1);
      }
   }

   public final void e() {
      if (ListScr.d == null) {
         Canvas.startWaitDlg();
         CasinoService.gI().requestFriendList();
         ListScr.e = 2;
      } else if (ListScr.f) {
         ListScr.f = false;
         Canvas.startWaitDlg();
         AvatarService.gI().getTypeHouse((int)1);
      } else {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < ListScr.d.size(); ++var2) {
            Avatar var3;
            if ((var3 = (Avatar)ListScr.d.elementAt(var2)).typeHome == this.c) {
               var1.addElement(var3);
            }
         }

         if (var1.size() == 0) {
            if (Canvas.currentMyScreen == ListScr.b()) {
               ListScr.b().b.switchToMe();
            }

            Canvas.startOKDlg(T.de);
         } else {
            ListScr.b().switchToMe();
            ListScr.c = var1;
            ListScr.b().e();
            ListScr.b().g();
         }
      }
   }

   public final void commandActionPointer(int var1, int var2) {
      int var3 = -1;

      int var4;
      MapItem var5;
      for(var4 = 0; var4 < this.o.size(); ++var4) {
         if ((var5 = (MapItem)this.o.elementAt(var4)).x / 24 == this.h && var5.y / 24 == this.i) {
            var3 = var4;
            break;
         }
      }

      var5 = null;
      if (var3 != -1) {
         var5 = (MapItem)this.o.elementAt(var3);
      }

      var5 = var5;
      switch (var1) {
         case 1:
            GlobalService var11;
            (var11 = GlobalService.gI()).createMessage((byte)-87);
            var11.sendMessage();
            return;
         case 2:
            Vector var10;
            (var10 = new Vector()).addElement(new Command(T.cU, 6));
            var10.addElement(new Command(T.cV, 7));
            if (this.o.size() > 0) {
               var10.addElement(new Command(T.cW, 8));
            }

            MenuSub.gI().startAt(var10, 2);
            return;
         case 3:
            o();
            return;
         case 4:
            Canvas.inputDlg.a(T.bO + ":", 100, 2);
            return;
         case 5:
            MapScr.gI().e();
            return;
         case 6:
            this.r();
            return;
         case 7:
            e = true;
            if (this.r == null) {
               if (this.r == null) {
                  HomeMsgHandler.a();
                  AvatarService var9;
                  (var9 = AvatarService.gI()).createMessage((byte)-43);
                  var9.sendMessage();
                  Canvas.startWaitDlg();
               }

               return;
            }

            this.p();
            return;
         case 8:
            this.m();
            return;
         case 9:
         case 10:
         default:
            break;
         case 11:
            if (var3 == -1) {
               Canvas.startOKDlg(T.cX);
               return;
            }

            this.d = var3;

            for(var1 = 0; var1 < AvatarData.listMapItemType.size(); ++var1) {
               if (((MapItemType)AvatarData.listMapItemType.elementAt(var1)).idType == var5.typeID) {
                  this.j = var1;
                  break;
               }
            }

            super.left = null;
            super.right = null;
            this.e(var5);
            this.s = new AvPosition(this.h, this.i, var5.typeID);
            super.center = new Command(T.z, new class_ga(this, var5));
            return;
         case 12:
            if (var3 == -1) {
               Canvas.startOKDlg(T.cX);
               return;
            }

            if (var5.dir == 0) {
               var5.dir = 2;
            } else {
               var5.dir = 0;
            }

            AvatarService.gI().doSortItem(var5.typeID, this.h, this.i, this.h, this.i, var5.dir);
            return;
         case 13:
            if (var3 != -1 && var5.typeID != this.z) {
               Canvas.startOKDlg(T.da, (IAction)(new class_fw(this, var5)));
               return;
            }

            Canvas.startOKDlg(T.cX);
            return;
         case 14:
            PopupShop.b().close();
            Canvas.b(T.cK, 53);
            return;
         case 15:
            TField[] var7 = new TField[3];

            for(var2 = 0; var2 < 3; ++var2) {
               var7[var2] = new TField();
               var7[var2].d(2);
            }

            var7[0].a(true);
            Command var8 = new Command(T.cy, new class_gg(this, var7));
            PopupShop.b().close();
            InputFace.b().a(var7, T.cx, T.eF, var8);
            Canvas.currentFace = InputFace.b();
            InputFace.b().left = new Command(T.d, 8);
            return;
         case 16:
            if (var2 < LoadMap.playerLists.size()) {
               Base var6 = (Base)LoadMap.playerLists.elementAt(var2);
               AvatarService.gI().doKickOutHome(var6.IDDB);
               return;
            }
            break;
         case 17:
            for(var1 = 0; var1 < this.r.length; ++var1) {
               if (var1 == var2) {
                  if (this.w != -1) {
                     this.h = this.w;
                     this.i = this.x;
                     GameMidlet.avatar.x = this.w * 24;
                     GameMidlet.avatar.y = this.x * 24;
                     AvCamera.gI().setToPos(GameMidlet.avatar.x * AvMain.hd, GameMidlet.avatar.y * AvMain.hd);
                  }

                  this.j = var1;
                  if (this.j < n) {
                     this.p = 1;
                  } else {
                     this.p = 0;
                  }
               }
            }

            return;
         case 18:
            for(var1 = 0; var1 < AvatarData.listMapItemType.size(); ++var1) {
               MapItemType var12;
               if (var1 == var2 && (var12 = (MapItemType)AvatarData.listMapItemType.elementAt(var1)).buy != 0 && (this.c != 4 && (var12.buy == 1 || var12.buy == 2) || this.c == 4) && (var4 = var12.name.indexOf(":")) != -1) {
                  String var13 = var12.name.substring(0, var4);
                  this.b(var13);
               }
            }
      }

   }

   public final void f() {
      this.D = null;
      this.E = null;
      ParkService.a().a(21, 0);
      LoadMap.t = -1;
   }

   public final void a(Vector var1, Vector var2, int var3, byte var4) {
      this.E = var1;
      this.D = var2;
      this.F = var3;
      this.G = var4;
      Vector var7 = MapScr.gI().a(var1, GameMidlet.avatar.IDDB, 3);
      var2 = MapScr.gI().a(var2, GameMidlet.avatar.IDDB, 2);
      if (Canvas.currentMyScreen != MenuCenter.a) {
         PopupShop.b().m = true;
         PopupShop.b().a(new String[]{T.by, T.co}, new Vector[]{var7, var2}, (Vector)null);
         Command var5 = MapScr.gI().a(var1, 1, 1, false);
         Command var6 = new Command(T.c, new class_dd(this));
         PopupShop.b().a(var5, 0);
         PopupShop.b().a(var6, 1);
         if (Canvas.currentMyScreen != PopupShop.b()) {
            PopupShop.b().switchToMe();
         }

      }
   }

   public static void g() {
      Canvas.inputDlg.a(T.bO, 101, 2);
   }

   public final void a(boolean var1, String var2) {
      if (!var1) {
         Canvas.startOKDlg(var2);
      } else {
         int var3 = PopupShop.g;
         int var5 = PopupShop.focus;
         SeriPart var4;
         if (var3 == 0) {
            var4 = (SeriPart)this.E.elementAt(var5);
            this.D.addElement(var4);
            this.E.removeElement(var4);
         } else {
            var4 = (SeriPart)this.D.elementAt(var5);
            this.E.addElement(var4);
            this.D.removeElement(var4);
         }

         this.h();
         Canvas.endDlg();
      }
   }

   public final void h() {
      int var1 = PopupShop.g;
      int var2 = PopupShop.focus;
      PopupShop.b().close();
      this.a(this.E, this.D, this.F, this.G);
      PopupShop.g = var1;
      PopupShop.b().i();
      if (var2 >= PopupShop.b().h[var1].size()) {
         var2 = 0;
      }

      PopupShop.focus = var2;
      PopupShop.b().m();
      Canvas.cameraList.setSelect(PopupShop.focus);
   }

   public final void a(byte var1, String var2, String[] var3, short[] var4, short[] var5, String[] var6, String[] var7, int[] var8, short[] var9) {
      MapScr.gI();
      MapScr.d(GameMidlet.avatar);
      Vector var10 = new Vector();

      for(int var11 = 0; var11 < var3.length; ++var11) {
         var10.addElement(new CommandShop1(this, T.O, new class_cg(this, var1, var5[var11], var7[var11]), var11, var3[var11], var4[var11], var5[var11], var6[var11], var8 == null ? -1 : var8[var11], var7[var11], var9[var11]));
      }

      if (var10.size() > 0) {
         PopupShop.b().switchToMe();
         PopupShop.o = true;
         PopupShop.b().a(new String[]{var2}, new Vector[]{var10}, (Vector)null);
      }

   }

   static void a(HouseScr var0) {
      var0.n();
   }

   static int b(HouseScr var0) {
      return var0.w;
   }

   static void a(HouseScr var0, int var1) {
      var0.h = var1;
   }

   static int c(HouseScr var0) {
      return var0.x;
   }

   static void b(HouseScr var0, int var1) {
      var0.i = var1;
   }

   static void c(HouseScr var0, int var1) {
      var0.j = var1;
   }

   static int d(HouseScr var0) {
      return var0.h;
   }

   static void d(HouseScr var0, int var1) {
      var0.w = var1;
   }

   static int e(HouseScr var0) {
      return var0.i;
   }

   static void e(HouseScr var0, int var1) {
      var0.x = var1;
   }

   static void a(HouseScr var0, int var1, String var2) {
      MapItemType var3 = (MapItemType)AvatarData.listMapItemType.elementAt(var1);
      if (!var0.a(var3)) {
         Canvas.a(var3.priceXu, var3.priceLuong, new class_cr(var0, var3, var2), new class_co(var0, var3, var2), new class_de(var0));
      }

   }

   static void f(HouseScr var0) {
      var0.r();
   }

   static boolean a(HouseScr var0, MapItemType var1) {
      return var0.a(var1);
   }

   static AvPosition g(HouseScr var0) {
      return var0.s;
   }

   static boolean a(HouseScr var0, MapItem var1) {
      return d(var1);
   }

   static void h(HouseScr var0) {
      var0.m();
   }

   static void a(HouseScr var0, String var1) {
      var0.b(var1);
   }

   static void i(HouseScr var0) {
      var0.q();
   }
}

package avt;

import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class FarmScr extends MyScreen {
   public static FarmScr instance;
   public static int idFarm;
   private String nameFarm;
   public static Vector cell;
   private static Vector itemSeed = new Vector();
   public static Vector listItemFarm = new Vector();
   public static Vector listFarmProduct = new Vector();
   public static Vector itemProduct;
   public static Vector listNest;
   public static Vector listBucket;
   public static Vector animalLists = new Vector();
   public static Vector[] listFood = new Vector[2];
   public static Image[] imgWorm_G;
   public static String l;
   public static Image imgBuyLant;
   public static Image imgFocusCel;
   public static Image imgSell;
   public static FrameImage p;
   public static FrameImage q;
   public static FrameImage r;
   public static FrameImage s;
   public static FrameImage t;
   public static FrameImage u;
   public AvPosition[] posTree;
   private Vector listHound;
   public static int numTileBarn;
   public static int numTilePond;
   private byte[] aB = new byte[]{33, 34, 35, 36, 37};
   private byte[] aC = new byte[]{33, 120, 121, 122, 123};
   private Vector aD = new Vector();
   public static boolean y = false;
   public static boolean z = false;
   public static AvPosition A;
   public static AvPosition B;
   public static AvPosition posBarn;
   public static AvPosition D;
   public static byte E = -1;
   public static byte F;
   private AvPosition aE;
   private int aF;
   private static int aG = 12;
   private static int aH = 4;
   public static int G = -1;
   public static int H = -1;
   private int aI;
   private long aJ;
   private long aK;
   private static int aL = 0;
   public static boolean I = false;
   private static boolean aM = false;
   private static final byte[][] FRAME = new byte[][]{{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, {2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, {4, 4, 4, 4, 4, 5, 5, 5, 5, 5}, {6, 6, 6, 6, 6, 7, 7, 7, 7, 7}, {8, 8, 8, 8, 8, 9, 9, 9, 9, 9}};
   private static Command aO;
   private static Command aP;
   private static Command aQ;
   private static Command aR;
   private static Command aS;
   private static Command aT;
   public static StarFruitObj starFruil;
   private Command aU;
   private Command aV;
   public Vector K = new Vector();
   private boolean aW = false;
   private boolean aX = false;
   public static int L = -1;
   Animal M;
   private long aY = -1L;
   public static boolean N = false;
   private boolean aZ;
   private Vector ba = new Vector();
   private boolean bb = false;
   private int bc = 0;
   public static byte O;
   public static byte P;
   public static byte Q;
   public static boolean R = false;
   public static int S = -1;
   public static int T = -1;
   public static int U;
   public static short V = 0;
   private static int bd = -1;
   private static String be = "";
   private boolean bf = true;
   private int bg = 0;
   public static int W;
   public static int X;

   public static FarmScr gI() {
      if (instance == null) {
         instance = new FarmScr();
      }

      return instance;
   }

   public final void switchToMe() {
      super.switchToMe();
   }

   public static void init() {
      I = false;
      aM = false;
      if (t == null) {
         FilePack.b(avt.T.au);
         imgBuyLant = FilePack.getImage("buyLand");
         t = FrameImage.init("cut", 24 * AvMain.hd, 24 * AvMain.hd);
         p = FrameImage.init("vp", 16 * AvMain.hd, 16 * AvMain.hd);
         (imgWorm_G = new Image[2])[0] = FilePack.getImage("w");
         imgWorm_G[1] = FilePack.getImage("g");
         q = FrameImage.init("wg", 13 * AvMain.hd, 9 * AvMain.hd);
         r = FrameImage.init("m", 27 * AvMain.hd, 17 * AvMain.hd);
         s = FrameImage.init("tc", 13 * AvMain.hd, 13 * AvMain.hd);
         imgSell = FilePack.getImage("focus");
         FilePack.reset();
      }
   }

   public final void c() {
      aO = new Command(avt.T.O, 0);
      aP = new Command(avt.T.c, 7);
      aQ = new Command((String)null, 2);
      aR = new Command((String)null, 3);
      super.left = aP;
   }

   public FarmScr() {
      listFood[0] = new Vector();
      listFood[1] = new Vector();
      this.c();
      FilePack.b(avt.T.au);
      imgFocusCel = FilePack.getImage("coin");
      u = FrameImage.init("iB", 9 * AvMain.hd, 13 * AvMain.hd);
      FilePack.reset();
      this.r();
      init();
      aS = new Command(avt.T.cy, 8);
      aT = new Command(avt.T.bz, 9);
      this.aU = new Command(avt.T.bz, 16, this);
      this.aV = new Command(avt.T.d, 18, this);
   }

   private void q() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < listItemFarm.size(); ++var2) {
         Item var3;
         FarmItem var4;
         if ((var4 = b((var3 = (Item) listItemFarm.elementAt(var2)).ID)).action == 5 && (var4.type == 4 || var4.type == 101)) {
            var1.addElement(new class_hg(this, var4.des, new class_bx(this, var3), var4));
         }
      }

      a(var1);
   }

   private void r() {
      this.K.addElement(MapScr.gI().f);
      Command var1 = new Command(avt.T.x, 20);
      this.K.addElement(var1);
   }

   private void s() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < itemSeed.size(); ++var2) {
         Item var3;
         if (FarmData.getTreeByID((int)(var3 = (Item) itemSeed.elementAt(var2)).ID) != null) {
            var1.addElement(new class_bz(this, var3.name + "(" + var3.e + ")", 7, var2, var3));
         }
      }

      a(var1);
   }

   public final void close() {
      Canvas.startWaitDlg();
      GlobalService.gI().getHandler((int)8);
   }

   private void t() {
      int var1;
      if ((var1 = this.j(A.x, A.y)) - cell.size() == 0) {
         Canvas.startWaitDlg();
         FarmService.gI().doRequestPricePlant(idFarm);
      } else {
         if (var1 >= 0 && var1 < cell.size()) {
            CellFarm var8;
            if ((var8 = (CellFarm) cell.elementAt(var1)).statusTree == 5) {
               this.u();
               return;
            }

            if (var8.idTree != -1 || (var8.level != 1 || var8.status != this.aB[1]) && (var8.level != 2 || var8.status != this.aC[1])) {
               this.a(var8);
            } else {
               FarmScr var9 = this;
               if (itemSeed.size() != 0) {
                  if (E == -1) {
                     Vector var2 = new Vector();
                     int var3 = this.j(A.x, A.y);
                     CellFarm var4 = (CellFarm) cell.elementAt(var3);
                     CellFarm var5 = null;
                     if (var3 > 0) {
                        var5 = (CellFarm) cell.elementAt(var3 - 1);
                     }

                     for(int var6 = 0; var6 < itemSeed.size(); ++var6) {
                        Item var7;
                        if (FarmData.getTreeByID((int)(var7 = (Item) itemSeed.elementAt(var6)).ID) != null) {
                           var2.addElement(new class_bn(var9, var7.name + "(" + var7.e + ")", 5, var6, var7));
                        }
                     }

                     if (idFarm == GameMidlet.avatar.IDDB && (var4.level == 1 && var3 == 0 || var3 > 0 && var4.level < var5.level)) {
                        var2.addElement(new class_bp(var9, avt.T.g, 11));
                     }

                     a(var2);
                  }

                  return;
               }

               Canvas.startOKDlg(avt.T.dF);
            }
         }

      }
   }

   public static void a(String var0) {
      Vector var1;
      (var1 = new Vector()).addElement(new Command(avt.T.C, 51));
      var1.addElement(new Command(avt.T.D, 52));
      var1.addElement(Canvas.ad);
      Canvas.a(var0, var1);
   }

   private void a(IAction var1) {
      if (E != -1) {
         this.aD.addElement(var1);
      } else {
         var1.perform();
      }
   }

   private boolean h(int var1, int var2) {
      boolean var3 = false;

      for(int var4 = 0; var4 < listItemFarm.size(); ++var4) {
         FarmItem var5;
         if ((var5 = b(((Item) listItemFarm.elementAt(var4)).ID)).type == 0 && var5.action == var2) {
            this.a((IAction)(new class_bs(this, var5, var1)));
            var3 = true;
            break;
         }
      }

      if (!var3) {
         Canvas.startOKDlg(avt.T.dG);
      }

      return var3;
   }

   private void a(CellFarm var1) {
      int var2 = this.j(A.x, A.y);
      CellFarm var3 = (CellFarm) cell.elementAt(var2);
      CellFarm var4 = null;
      if (var2 > 0) {
         var4 = (CellFarm) cell.elementAt(var2 - 1);
      }

      class_bv var5 = null;
      if (idFarm == GameMidlet.avatar.IDDB && (var3.level == 1 && var2 == 0 || var2 > 0 && var3.level < var4.level)) {
         var5 = new class_bv(this, avt.T.g, 11);
      }

      if (var1.idTree != -1 && var1.statusTree < 6 && var1.status == 36) {
         this.a((IAction)(new class_bg(this)));
      }

      if (var1.idTree == -1 || var1.statusTree >= 6) {
         class_bi var7 = new class_bi(this, var1);
         if (var5 != null) {
            Vector var8;
            (var8 = new Vector()).addElement(new class_bk(this, avt.T.be, var7));
            var8.addElement(var5);
            a(var8);
            return;
         }

         this.a((IAction)var7);
      }

      if (var1.idTree != -1 && var1.statusTree < 6 && var2 < cell.size() && listItemFarm.size() > 0) {
         if (var1.isWorm) {
            this.h(var2, 7);
         } else if (var1.isGrass) {
            this.h(var2, 3);
         } else if (var1.vitalityPer < 80) {
            this.h(var2, 2);
         }
      }

      if (E == -1) {
         Vector var9 = new Vector();
         class_em var6 = new class_em(this, avt.T.bd, 1);
         var9.addElement(var6);
         if (idFarm == GameMidlet.avatar.IDDB) {
            var9.addElement(new class_et(this, avt.T.be, new class_en(this, var1)));
         }

         if (var5 != null) {
            var9.addElement(var5);
         }

         for(var2 = 0; var2 < listItemFarm.size(); ++var2) {
            Item var10;
            FarmItem var12;
            if ((var12 = b((var10 = (Item) listItemFarm.elementAt(var2)).ID)).type == 0 && (var12.action == 3 && var1.isGrass || var12.action == 7 && var1.isWorm || var12.action != 3 && var12.action != 7)) {
               String var11 = var12.des + "(" + var10.e + ")";
               var9.addElement(new class_hg(this, var11, 6, var2, var12));
            }
         }

         a(var9);
      }

   }

   public static void a(Vector var0) {
      int var1 = LoadMap.i * AvMain.hd;
      if (Canvas.isKeyBoard) {
         var1 += var1 / 3;
      }

      MenuSub.gI().a(var0, Canvas.hw, var1, var1);
   }

   public final void commandTab(int var1) {
      FarmService var2;
      switch (var1) {
         case 0:
            Canvas.startOKDlg(avt.T.ei, 1, this);
            return;
         case 1:
            FarmService.gI().doCooking((short)-1);
            PopupShop.b().close();
            return;
         case 2:
            PopupShop.b().close();
            if (U == 0) {
               (var2 = FarmService.gI()).createMessage((byte)92);
               var2.sendMessage();
               return;
            }

            FarmService.gI().nauNhanh(0);
            return;
         case 3:
            FarmService.gI().doUpdateFarm(1, 0);
            return;
         case 4:
            FarmService.gI().doUpdateFarm(1, 1);
            return;
         case 5:
            FarmService.gI().doUpdateFish(1, 0);
            return;
         case 6:
            FarmService.gI().doUpdateFish(1, 1);
            return;
         case 7:
            FarmService.gI().doUpdateStarFruil((int)1);
            return;
         case 8:
            FarmService.gI().doUpdateStarFruitByMoney((int)1);
            return;
         case 9:
            FarmService.gI().doUpdateLand(1, 1);
            return;
         case 10:
            FarmService.gI().doUpdateLand(1, 2);
            return;
         case 11:
            FarmService.gI().nauNhanh(1);
            return;
         case 12:
            Canvas.startOKDlg(avt.T.dH, (IAction)(new class_eu(this)));
            return;
         case 13:
            FarmService.gI().doUpdateStore(1, 1);
            return;
         case 14:
            FarmService.gI().doUpdateStore(1, 2);
            return;
         case 15:
            ListScr.b().b(true);
            return;
         case 16:
            FarmService.gI().doSteal(0);
            return;
         case 17:
            (var2 = FarmService.gI()).createMessage((byte)95);
            var2.sendMessage();
            return;
         case 18:
            gI().j();
            return;
         case 19:
            (var2 = FarmService.gI()).createMessage((byte)98);
            var2.sendMessage();
            return;
         case 20:
            aM = true;
            super.left = null;
         default:
      }
   }

   public final void commandActionPointer(int var1, int var2) {
      FarmService var3;
      FarmItem var4;
      Item var8;
      switch (var1) {
         case 1:
            this.a((byte)1, (int)G);
            return;
         case 2:
            if (LoadMap.p != null) {
               Canvas.endDlg();
               FarmService.gI().doRequestPriceAnimal(idFarm, ((Base)LoadMap.p).IDDB);
               return;
            }
            break;
         case 3:
            if (LoadMap.p != null) {
               AnimalInfo var12 = FarmData.getAnimalByID(e(((Base)LoadMap.p).IDDB).species);

               for(int var11 = 0; var11 < listItemFarm.size(); ++var11) {
                  if (var2 == var11) {
                     Item var9 = (Item) listItemFarm.elementAt(var11);
                     this.a(var9, var12.area == 1 ? 0 : 1);
                  }
               }

               return;
            }
            break;
         case 4:
            if (LoadMap.p != null) {
               for(var1 = 0; var1 < listItemFarm.size(); ++var1) {
                  if (var2 == var1) {
                     var4 = b((var8 = (Item) listItemFarm.elementAt(var1)).ID);
                     this.a(var4, var8.ID, (Animal)LoadMap.p);
                  }
               }

               return;
            }
            break;
         case 5:
            for(var1 = 0; var1 < itemSeed.size(); ++var1) {
               if (var1 == var2) {
                  int var10;
                  if ((var10 = this.j(A.x, A.y)) >= cell.size()) {
                     return;
                  }

                  i(var1, var10);
               }
            }

            return;
         case 6:
            for(var1 = 0; var1 < listItemFarm.size(); ++var1) {
               if (var1 == var2) {
                  if ((var8 = (Item) listItemFarm.elementAt(var1)).e > 0) {
                     int var5;
                     if ((var5 = this.j(A.x, A.y)) < cell.size() && listItemFarm.size() != 0) {
                        byte var6;
                        if ((var6 = (var4 = b(var8.ID)).action) != 7) {
                           if (var6 == 1) {
                              this.a((byte)2, (int)var4.ID);
                           } else {
                              this.a((byte)var6, (int)var4.ID);
                           }
                        }

                        FarmService.gI().doUsingItem(idFarm, var5, var4.ID);
                     }
                  } else {
                     Canvas.startOKDlg(avt.T.bf + var8.name);
                  }
               }
            }

            return;
         case 7:
            this.h(var2);
            return;
         case 8:
            this.commandTab((int)5, (int)-1);
            this.s();
            return;
         case 9:
            this.aX = true;
            this.h(0);
            return;
         case 10:
            y = true;

            for(var1 = this.bg; var1 < animalLists.size(); ++var1) {
               Animal var7 = (Animal) animalLists.elementAt(var1);
               boolean var10000;
               if (var7.disease[1]) {
                  LoadMap.p = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dU, new IActionTriBenh1(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.disease[0]) {
                  LoadMap.p = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dU, new IActionTriBenh2(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.hunger && !(var7 instanceof Dog) && !(var7 instanceof Cattle)) {
                  LoadMap.p = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dX, new class_ab(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.health < 50) {
                  LoadMap.p = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dZ, new class_w(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else {
                  var10000 = false;
               }

               if (var10000) {
                  return;
               }

               ++this.bg;
            }

            this.commandTab((int)8, (int)-1);
            Canvas.startOKDlg(avt.T.dI);
            return;
         case 11:
            FarmService.gI().doUpdateLand(0, 0);
            return;
         case 12:
            (var3 = FarmService.gI()).createMessage((byte)85);
            var3.sendMessage();
            return;
         case 13:
            if (starFruil.e > 0) {
               FarmService.gI().doUpdateStarFruitByMoney((int)0);
               return;
            }

            FarmService.gI().doUpdateStarFruil((int)0);
            return;
         case 14:
            (var3 = FarmService.gI()).createMessage((byte)87);
            var3.sendMessage();
            return;
         case 15:
         case 16:
         case 17:
         case 18:
         case 19:
         default:
            break;
         case 20:
            this.close();
      }

   }

   private void h(int var1) {
      H = 0;
      super.left = new Command(avt.T.cy, 5);
      super.right = null;
      AvCamera.isFollow = true;
      super.center = null;
      this.aW = true;
      L = var1;
   }

   private void a(FarmItem var1, short var2, Animal var3) {
      this.a((IAction)(new class_ep(this, var1, var2, var3)));
   }

   protected final void a(Item var1, int var2) {
      int var3 = GameMidlet.avatar.direct == 0 ? 1 : -1;
      int var4 = listFood[var2].size();
      if (var1.e - var4 <= 0) {
         Canvas.startOKDlg(avt.T.bw);
      } else {
         for(int var5 = 0; var5 < 3 && var5 < var1.e - var4; ++var5) {
            Point var6 = new Point(GameMidlet.avatar.x, GameMidlet.avatar.y - 40);
            FarmItem var7 = b(var1.ID);
            var6.itemID = var1.ID;
            var6.d = var6.e = 2;
            var6.b = -(4 + CRes.rnd(3));
            var6.c = var3 * (2 + CRes.rnd(3));
            var6.g = GameMidlet.avatar.y - 20 + CRes.rnd(4) * 5;
            if (var7.type == 4) {
               int var8 = LoadMap.getposMap(GameMidlet.avatar.x, GameMidlet.avatar.y + 23);
               if (LoadMap.map[var8] == 14) {
                  var6.g = 50 + CRes.rnd(50);
                  var6.c = var3 * CRes.rnd(3);
               }
            }

            var6.a = new class_ft(this, var6);
            listFood[var2].addElement(var6);
            LoadMap.n.addElement(var6);
         }

      }
   }

   public static void a(int var0, int var1, CellFarm var2, Animal var3) {
      if (LoadMap.TYPEMAP != 25 && var0 != var1) {
         String var4 = "";
         if (var1 - var0 > 0) {
            var4 = var4 + "+";
         }

         int var5;
         int var6;
         if (var2 != null) {
            var5 = var2.xCell * LoadMap.i + LoadMap.i / 2;
            var6 = var2.yCell * LoadMap.i - LoadMap.i / 2;
         } else {
            var5 = var3.x;
            var6 = var3.y - 30;
         }

         Canvas.a(var4 + (var1 - var0), var5, var6, -1, 0, -1);
      }

   }

   private void u() {
      if (GameMidlet.avatar.IDDB == idFarm) {
         int var1 = this.j(A.x, A.y);
         GameMidlet.avatar.getClass();
         FarmService.gI().doHervest(idFarm, var1);
      }
   }

   private static void i(int var0, int var1) {
      if (Canvas.isDoubleImage) {
         Welcome.g();
      }

      Item var2 = (Item) itemSeed.elementAt(var0);
      FarmService.gI().doPlantSeed((int) idFarm, (int)var1, var2.ID);
   }

   private int j(int var1, int var2) {
      for(int var3 = 0; var3 < this.posTree.length; ++var3) {
         for(int var4 = 0; var4 < aG; ++var4) {
            int var5 = this.posTree[var3].x + var4 / aH;
            int var6 = this.posTree[var3].y + var4 % aH;
            if (var1 == var5 && var2 == var6) {
               return var3 * aG + var4;
            }
         }
      }

      return -1;
   }

   private void a(byte var1, int var2) {
      G = var2;
      E = var1;
      GameMidlet.avatar.task = -1;
      GameMidlet.avatar.idFrom = -1;
      GameMidlet.avatar.idTo = -1;
      if (E == 4) {
         this.aE = new AvPosition(LoadMap.p.x / LoadMap.i, LoadMap.p.y / LoadMap.i);
      } else {
         this.aE = new AvPosition(A.x, A.y);
      }

      GameMidlet.avatar.yCur = this.aE.y * LoadMap.i + LoadMap.i / 2;
      GameMidlet.avatar.xCur = this.aE.x * LoadMap.i;
      if (GameMidlet.avatar.direct == Base.LEFT) {
         Avatar var10000 = GameMidlet.avatar;
         var10000.xCur += LoadMap.i;
      }

   }

   private void v() {
      for(int var1 = 0; var1 < this.posTree.length; ++var1) {
         for(int var2 = 0; var2 < aG; ++var2) {
            int var3 = this.posTree[var1].x + var2 / aH;
            int var4 = this.posTree[var1].y + var2 % aH;
            if (var1 * aG + var2 < cell.size()) {
               LoadMap.a(var3, (int)var4, (byte)51);
               CellFarm var5;
               (var5 = (CellFarm) cell.elementAt(var1 * aG + var2)).time = (short)(var1 * aG + var2);
               var5.xCell = var3;
               var5.yCell = var4;
               var5.x = var3 * LoadMap.i + LoadMap.i / 2;
               var5.y = var4 * LoadMap.i + 18;
               this.c(var1 * aG + var2);
               LoadMap.treeLists.addElement(var5);
            } else {
               if (var1 * aG + var2 == cell.size()) {
                  LoadMap.treeLists.addElement(new SubObject(-3, var3 * LoadMap.i + 20, var4 * LoadMap.i + 20, imgBuyLant.getWidth()));
                  LoadMap.a(var3, (int)var4, (byte)51);
                  LoadMap.a(LoadMap.treeLists);
               }

               if (LoadMap.map[var4 * LoadMap.wMap + var3] == this.aB[0]) {
                  LoadMap.a(LoadMap.treeLists);
                  return;
               }

               if (var3 == this.posTree[var1].x && var4 == this.posTree[var1].y) {
                  LoadMap.map[var4 * LoadMap.wMap + var3] = 4;
               }
            }
         }
      }

      LoadMap.a(LoadMap.treeLists);
   }

   public final void update() {
      this.aF += 2;
      if (this.aF >= 10) {
         this.aF = 0;
      }

      if (E != -1) {
         F = FRAME[E][this.aF];
         ++this.aI;
         if (this.aI > 10) {
            this.aI = 0;
            this.w();
         }
      }

      if (LoadMap.TYPEMAP == 24 && LoadMap.TYPEMAP == 53 && (System.currentTimeMillis() - this.aJ) / 1000L > 300L) {
         this.aJ = System.currentTimeMillis();
         this.b(idFarm, true);
      }

      Canvas.loadMap.b();
      if (!y && !N && L == -1) {
         this.y();
      }

      int var2;
      label143: {
         if (E != -1 && this.aY == -1L && GameMidlet.avatar.action == 0) {
            this.aY = System.currentTimeMillis() / 100L;
            var2 = -1;
            if (this.aE != null) {
               var2 = this.j(this.aE.x, this.aE.y);
            }

            if (E == 4) {
               var2 = 0;
            }

            if (this.aE.x * LoadMap.i < GameMidlet.avatar.x) {
               GameMidlet.avatar.direct = Base.LEFT;
            } else {
               GameMidlet.avatar.direct = 0;
            }

            GameMidlet.avatar.dirLast = GameMidlet.avatar.direct;
            if (this.M != null) {
               this.M.isStand = false;
               this.M = null;
            }

            if (var2 == -1) {
               this.w();
               break label143;
            }

            SubObject var6 = new SubObject(-2, GameMidlet.avatar.x, GameMidlet.avatar.y - 5, t.frameWidth);
            LoadMap.treeLists.addElement(var6);
            byte var3 = 0;
            if (E == 0) {
               var3 = 5;
               var6.y = GameMidlet.avatar.y - 8;
            }

            if (GameMidlet.avatar.direct == 0) {
               var6.x = GameMidlet.avatar.x + 10 + var3;
            } else {
               var6.x = GameMidlet.avatar.x - 10 - var3;
            }
         }

         if (this.aY != -1L && (E == 1 || E == 0 || E == 2) && System.currentTimeMillis() / 100L - this.aY > 2L) {
            this.aY = System.currentTimeMillis() / 100L;
            if (GameMidlet.avatar.action == 6) {
               GameMidlet.avatar.setAction((byte)0);
            } else {
               GameMidlet.avatar.setAction((byte)6);
            }
         }
      }

      if ((LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) && animalLists.size() > 0 && ++aL > 250) {
         aL = 0;
         var2 = CRes.rnd(animalLists.size());
         Animal var7 = (Animal) animalLists.elementAt(var2);
         String var8 = "";
         if (var7.disease[0]) {
            var8 = var8 + avt.T.bi;
         }

         if (var7.disease[1]) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + avt.T.bj;
         }

         if (var7.hunger) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + avt.T.bk;
         }

         if (var7.health < 20) {
            if (!var8.equals("")) {
               var8 = var8 + ", ";
            }

            var8 = var8 + avt.T.bl;
         }

         if (!var8.equals("")) {
            var7.chat = new ChatPopup(25, var8, (byte)0);
            var7.chat.setPos(var7.x, var7.y - 45);
         }
      }

      if (System.currentTimeMillis() / 1000L - this.aK / 1000L >= 1L) {
         if (U > 0) {
            --U;
         }

         this.aK = System.currentTimeMillis();

         for(int var1 = 0; var1 < cell.size(); ++var1) {
            CellFarm var9;
            if ((var9 = (CellFarm) cell.elementAt(var1)).idTree != -1 && var9.statusTree < 5) {
               ++var9.tempTime;
               if ((long)(FarmData.getTreeByID(var9.idTree).harvestTime * 60 * 60) - var9.tempTime <= 0L) {
                  var9.statusTree = 5;
               }
            }
         }
      }

   }

   private void w() {
      int var1;
      for(var1 = 0; var1 < LoadMap.treeLists.size(); ++var1) {
         if (((SubObject)LoadMap.treeLists.elementAt(var1)).type == -2) {
            LoadMap.treeLists.removeElementAt(var1);
            if (var1 > 0) {
               --var1;
            }
         }
      }

      this.aY = -1L;
      var1 = -1;
      if (this.aE != null) {
         int var2 = this.aE.y;
         var1 = this.aE.x;
         int var3 = cell.size();
         int var4 = 0;

         int var10000;
         while(true) {
            if (var4 >= var3) {
               var10000 = -1;
               break;
            }

            CellFarm var5;
            if ((var5 = (CellFarm) cell.elementAt(var4)).xCell == var1 && var5.yCell == var2) {
               var10000 = var4;
               break;
            }

            ++var4;
         }

         var1 = var10000;
      }

      if (var1 == -1) {
         E = -1;
         GameMidlet.avatar.action = 0;
         GameMidlet.avatar.task = 0;
         this.x();
      } else {
         if (G == -1) {
            CellFarm var6 = (CellFarm) cell.elementAt(var1);
            switch (E) {
               case 0:
                  this.a((CellFarm)var6, 1);
                  var6.statusTree = 0;
                  LoadMap.map[var6.yCell * LoadMap.wMap + var6.xCell] = var6.status;
                  if (var6.idTree != -1) {
                     FarmService.gI().doPlantSeed((int) idFarm, (int)var1, -1);
                  }

                  var6.idTree = -1;
                  if (Canvas.isDoubleImage) {
                     Welcome.g();
                  }
                  break;
               case 1:
                  this.a((CellFarm)var6, 4);
                  var6.isArid = false;
                  LoadMap.map[var6.yCell * LoadMap.wMap + var6.xCell] = var6.status;
                  FarmService.gI().doUsingItem(idFarm, var1, 100);
               case 2:
            }
         }

         G = -1;
         this.aE = null;
         E = -1;
         GameMidlet.avatar.task = 0;
         GameMidlet.avatar.action = 0;
         this.x();
      }
   }

   private void x() {
      if (y) {
         this.commandActionPointer(10, -1);
      } else if (this.aD.size() > 0) {
         IAction var1;
         (var1 = (IAction)this.aD.elementAt(0)).perform();
         this.aD.removeElement(var1);
      } else {
         if (this.aX) {
            this.A();
         }

      }
   }

   private void y() {
      if (LoadMap.TYPEMAP != 25) {
         int var1;
         if (GameMidlet.avatar.direct == Base.LEFT) {
            var1 = GameMidlet.avatar.x - 23;
         } else {
            var1 = GameMidlet.avatar.x + 23;
         }

         var1 /= LoadMap.i;
         int var2 = GameMidlet.avatar.y / LoadMap.i;
         int var3 = LoadMap.type[var2 * LoadMap.wMap + var1];
         int var4 = this.j(var1, var2);
         if (var3 == 51 && var4 <= cell.size()) {
            A.x = var1;
            A.y = var2;
            if (E != 0 && E != 1) {
               super.center = aO;
            } else {
               super.center = null;
            }
         } else {
            if (super.center == aO || super.center == aR) {
               super.center = null;
            }

            A.x = -1;
            A.y = -1;
            if (LoadMap.p == null) {
               var2 = LoadMap.getposMap(GameMidlet.avatar.x + 12, GameMidlet.avatar.y);
               var3 = LoadMap.getposMap(GameMidlet.avatar.x, GameMidlet.avatar.y + 12);
               boolean var10000;
               if ((LoadMap.map[var2] != 100 || GameMidlet.avatar.direct != 0) && LoadMap.map[var3] != 14) {
                  super.center = null;
                  var10000 = false;
               } else {
                  super.center = aR;
                  var10000 = true;
               }

               if (var10000) {
                  return;
               }
            }

            if (LoadMap.p != null && super.center == null) {
               if (super.right == null) {
                  super.right = LoadMap.q;
               }

               super.center = aQ;
            }

            if (LoadMap.p == null) {
               super.right = null;
            }

            if (LoadMap.p == null && super.center == aQ) {
               super.center = null;
            }

         }
      }
   }

   public final void updateKey() {
      if (this.aZ && GameMidlet.avatar.action == 0 && GameMidlet.avatar.task == 0 && GameMidlet.avatar.x == GameMidlet.avatar.xCur && GameMidlet.avatar.y == GameMidlet.avatar.yCur) {
         this.aZ = false;
         GameMidlet.avatar.direct = 0;
         this.y();
         if (E == -1) {
            if (L != -1) {
               if (this.ba.size() > 0 && L != -1) {
                  label244: {
                     AvPosition var3 = (AvPosition)this.ba.elementAt(0);
                     CellFarm var4;
                     (var4 = (CellFarm) cell.elementAt(var3.anchor)).isSelected = false;
                     A.x = var4.x / LoadMap.i;
                     A.y = var4.y / LoadMap.i;
                     if (this.aX) {
                        if (var4.statusTree == 5) {
                           this.u();
                           this.A();
                        } else {
                           boolean var5 = false;
                           if (var4.idTree != -1 && var4.statusTree < 6 && var4.status == 36) {
                              this.a((IAction)(new class_fp(this, var4)));
                              var5 = true;
                           }

                           if (var4.idTree != -1 && var4.statusTree < 6) {
                              if (var3.anchor >= cell.size()) {
                                 break label244;
                              }

                              if (var4.isWorm && this.h(var3.anchor, 7)) {
                                 var5 = true;
                              }

                              if (var4.isGrass && this.h(var3.anchor, 3)) {
                                 var5 = true;
                              }

                              if (var4.vitalityPer < 80) {
                                 boolean var10 = false;

                                 for(int var6 = 0; var6 < listItemFarm.size(); ++var6) {
                                    FarmItem var7;
                                    if ((var7 = b(((Item) listItemFarm.elementAt(var6)).ID)).action == 2 && (var7.ID == 111 || var7.ID == 112)) {
                                       var10 = true;
                                       FarmService.gI().doUsingItem(idFarm, var3.anchor, var7.ID);
                                       break;
                                    }
                                 }

                                 if (!var10) {
                                    Canvas.startOKDlg(avt.T.dM);
                                 }
                              }
                           }

                           if (!var5) {
                              this.A();
                           }
                        }
                     } else if (var4.statusTree == 5) {
                        this.u();
                        this.A();
                     } else {
                        this.a((IAction)(new class_fq(this, var4)));
                        this.a((IAction)(new class_gc(this, var3)));
                     }

                     this.ba.removeElement(var3);
                  }
               }
            } else {
               L = -1;
               this.t();
            }
         }
      }

      int var2;
      if (H != -1) {
         if (Canvas.a(2)) {
            Canvas.keyHold[2] = false;
            if ((var2 = H) % 12 % 4 != 0) {
               --var2;
            }

            if (var2 >= 0) {
               H = var2;
            }
         } else if (Canvas.a(4)) {
            Canvas.keyHold[4] = false;
            var2 = H;
            var2 -= 4;
            if (var2 >= 0) {
               H = var2;
            }
         } else if (Canvas.a(6)) {
            Canvas.keyHold[6] = false;
            var2 = H;
            var2 += 4;
            if (var2 < cell.size()) {
               H = var2;
            }
         } else if (Canvas.a(8)) {
            Canvas.keyHold[8] = false;
            if ((var2 = H) % 12 % 4 != 3) {
               ++var2;
            }

            if (var2 < cell.size()) {
               H = var2;
            }
         } else if (Canvas.a(5)) {
            label276: {
               var2 = LoadMap.i;
               CellFarm var8;
               if ((var8 = (CellFarm) cell.elementAt(H)).idTree != -1 && var8.statusTree < 6) {
                  if (this.aX) {
                     if (!var8.isSelected) {
                        this.ba.addElement(new AvPosition(var8.x / var2, var8.y / var2, H));
                     }

                     var8.isSelected = true;
                     this.A();
                     break label276;
                  }
               } else if (!this.aX) {
                  if (!var8.isSelected) {
                     this.ba.addElement(new AvPosition(var8.x / var2, var8.y / var2, H));
                  }

                  var8.isSelected = true;
                  this.A();
                  break label276;
               }

               Canvas.startOKDlg(avt.T.dJ);
            }
         }

         if (Canvas.stypeInt == 0) {
            CellFarm var12 = (CellFarm) cell.elementAt(H);
            AvCamera.gI().setToPos(var12.x, var12.y);
         }
      }

      int var9;
      int var11;
      CellFarm var13;
      if (Canvas.isPointerClick) {
         var2 = Canvas.px + AvCamera.gI().xCam;
         var9 = Canvas.py + AvCamera.gI().yCam;
         var11 = LoadMap.i * AvMain.hd;
         if (var9 / var11 * LoadMap.wMap + var2 / var11 >= 0 && var9 / var11 * LoadMap.wMap + var2 / var11 <= LoadMap.type.length && LoadMap.type[var9 / var11 * LoadMap.wMap + var2 / var11] == 51) {
            this.bb = true;
            N = true;
            var11 = this.j(var2 / var11, var9 / var11);
            var13 = (CellFarm) cell.elementAt(var11);
            A.x = var13.x / LoadMap.i;
            A.y = var13.y / LoadMap.i;
         }
      }

      if (this.bb && Canvas.isPointerRelease) {
         this.bb = false;
         N = false;
         var2 = Canvas.px + AvCamera.gI().xCam;
         var9 = Canvas.py + AvCamera.gI().yCam;
         var11 = LoadMap.i * AvMain.hd;
         if (!this.aW && super.center != null && A != null && var2 / var11 == A.x && var9 / var11 == A.y) {
            super.center.perform();
         } else if (var9 / var11 * LoadMap.wMap + var2 / var11 >= 0 && var9 / var11 * LoadMap.wMap + var2 / var11 <= LoadMap.type.length && LoadMap.type[var9 / var11 * LoadMap.wMap + var2 / var11] == 51) {
            var11 = this.j(var2 / var11, var9 / var11);
            var13 = (CellFarm) cell.elementAt(var11);
            A.x = var13.x / LoadMap.i;
            A.y = var13.y / LoadMap.i;
            if (this.aW && var11 >= 0 && var11 < cell.size()) {
               H = var11;
               if (var13.idTree != -1 && var13.statusTree != 5 && var13.statusTree < 6) {
                  Canvas.isPointerRelease = false;
                  if (this.aX) {
                     if (!var13.isSelected) {
                        this.ba.addElement(new AvPosition(var2 / LoadMap.i, var9 / LoadMap.i, var11));
                     }

                     var13.isSelected = true;
                     this.A();
                  } else if (var13.statusTree != 5) {
                     Canvas.startOKDlg(avt.T.dL);
                  }
               } else {
                  Canvas.isPointerRelease = false;
                  if (this.aX && var13.statusTree != 5) {
                     Canvas.startOKDlg(avt.T.dK);
                  } else {
                     if (!var13.isSelected) {
                        this.ba.addElement(new AvPosition(var2 / LoadMap.i, var9 / LoadMap.i, var11));
                     }

                     var13.isSelected = true;
                     this.A();
                  }
               }
            } else {
               Canvas.pxLast = Canvas.px -= LoadMap.i * AvMain.hd;
               this.aZ = true;
            }
         }
      }

      if (Canvas.keyPressed[5] && (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) && super.left != null && super.center == null) {
         super.left.perform();
      }

      super.updateKey();
      Canvas.loadMap.a();
      if (E == -1) {
         GameMidlet.avatar.updateKey();
      }

   }

   private void A() {
      if (this.ba.size() > 0 && L != -1) {
         this.aZ = true;
         AvPosition var1 = (AvPosition)this.ba.elementAt(0);
         if (GameMidlet.avatar.at == null) {
            LoadMap.u = new AvPosition();
            GameMidlet.avatar.n();
         }

         LoadMap.u.x = var1.x * 24 - 24;
         LoadMap.u.y = var1.y * 24 + 12;
         GameMidlet.avatar.task = -5;
         GameMidlet.avatar.isJumps = -1;
         GameMidlet.avatar.xCur = GameMidlet.avatar.x;
         GameMidlet.avatar.yCur = GameMidlet.avatar.y;
         GameMidlet.avatar.av = LoadMap.u;
         GameMidlet.avatar.findPath();
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      if (Canvas.welcome == null || !Welcome.d) {
         super.paint(var1);
      }

      Canvas.a(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.loadMap.b(var1);
      Canvas.loadMap.d(var1);
      if (H >= 0) {
         if (this.bc >= 8) {
            this.bc = 0;
         }

         CellFarm var4 = (CellFarm) cell.elementAt(H);
         var1.drawImage(MapScr.d, var4.x * AvMain.hd, (var4.y - 24 + this.bc / 2) * AvMain.hd, 3);
         ++this.bc;
      } else if (Canvas.stypeInt == 0 && A != null && A.x != -1 && LoadMap.TYPEMAP != 25) {
         if (this.bc >= 8) {
            this.bc = 0;
         }

         var1.drawImage(MapScr.d, (A.x * LoadMap.i + LoadMap.i / 2) * AvMain.hd, (A.y * LoadMap.i - 4 + this.bc / 2) * AvMain.hd, 3);
         ++this.bc;
      }

      if (LoadMap.TYPEMAP != 25) {
         Canvas.fontChatB.drawString(var1, this.nameFarm, (B.x + 26) * AvMain.hd, (B.y - 14) * AvMain.hd + (AvMain.hd - 1) * 7, 2);
      }

      Canvas.resetTrans(var1);
      LoadMap.a(var1);
   }

   public static void a(Vector var0, Vector var1, Vector var2, Vector var3, byte var4, int var5, boolean var6) {
      itemSeed = var0;
      z = var6;
      O = (byte)var4;
      int var7 = itemSeed.size();

      for(var4 = 0; var4 < var7; ++var4) {
         Item var8;
         TreeInfo var9;
         if ((var9 = FarmData.getTreeByID((int)(var8 = (Item) itemSeed.elementAt(var4)).ID)) != null) {
            var8.name = var9.name;
         }
      }

      itemProduct = var1;

      for(var4 = 0; var4 < itemProduct.size(); ++var4) {
         a((Item) itemProduct.elementAt(var4));
      }

      listItemFarm = var2;
      listFarmProduct = var3;
   }

   private static void a(Item var0) {
      if (var0.ID < 50) {
         var0.price[0] = FarmData.getTreeByID((int)var0.ID).priceProduct;
         var0.name = FarmData.getTreeByID((int)var0.ID).name;
      } else {
         if (var0.ID < 100) {
            var0.price[0] = FarmData.getAnimalByID(var0.ID).priceProduct;
            if (FarmData.getAnimalByID(var0.ID).area == 1) {
               var0.name = avt.T.bn + " " + FarmData.getAnimalByID(var0.ID).name;
               return;
            }

            if (FarmData.getAnimalByID(var0.ID).area == 2) {
               if (var0.ID == 55) {
                  var0.name = avt.T.dN + " " + FarmData.getAnimalByID(var0.ID).name;
                  return;
               }

               var0.name = avt.T.bm + " " + FarmData.getAnimalByID(var0.ID).name;
            }
         }

      }
   }

   public static FarmItem b(int var0) {
      for(int var1 = 0; var1 < FarmData.listItemFarm.size(); ++var1) {
         FarmItem var2;
         if ((var2 = (FarmItem)FarmData.listItemFarm.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void a(Item var0, int var1, int var2, int var3) {
      GameMidlet.avatar.updateMoney(var1, var2, var3);
      PopupShop.isTransFocus = true;
      if (var0.ID >= 50 && var0.ID <= 100) {
         cell = null;
      }

      if (var0.e > 0) {
         Item var4;
         if (var0.ID >= 111) {
            if ((var4 = Item.a(listItemFarm, var0.ID)) != null) {
               var4.e += var0.e;
            } else {
               FarmItem var5 = b(var0.ID);
               var0.name = var5.des;
               listItemFarm.addElement(var0);
            }
         } else {
            if (var0.ID <= 100 && var0.ID < 50) {
               if ((var4 = Item.a(itemSeed, var0.ID)) != null) {
                  var4.e += var0.e;
               } else {
                  itemSeed.addElement(var0);
                  var0.name = FarmData.getTreeByID((int)var0.ID).name;
               }

               if (itemSeed.size() == 0) {
                  itemSeed.addElement(var0);
               }
            }

         }
      }
   }

   public final void onJoin(int var1, Vector var2, Vector var3, byte var4, byte var5, short var6, int var7) {
      P = (byte)var4;
      Q = (byte)var5;
      V = (short)var6;
      U = var7;
      idFarm = var1;
      if (var1 != GameMidlet.avatar.IDDB) {
         Avatar var10;
         if ((var10 = ListScr.b(var1)) == null) {
            Canvas.startOKDlg(avt.T.bo);
            return;
         }

         if (var10.showName == null) {
            var10.setName(var10.name);
         }

         this.nameFarm = var10.showName;
         listFood[0].removeAllElements();
         listFood[1].removeAllElements();
      } else {
         this.nameFarm = GameMidlet.avatar.showName;
      }

      cell = var2;
      if (LoadMap.TYPEMAP != 24 && LoadMap.TYPEMAP != 53 && animalLists.size() == 0) {
         animalLists = var3;
      }

      f();
      if (this.bf) {
         if (R || LoadMap.TYPEMAP != 24 && LoadMap.TYPEMAP != 53) {
            R = false;
            A = new AvPosition();
            E = -1;
            this.aI = 0;
            Cattle.itemID = -1;
            Dog.itemID = -1;
            this.posTree = new AvPosition[4];
            Canvas.loadMap.e(25);
            Canvas.load = 0;
            int var12 = var5;
            byte var11 = (byte)var4;

            try {
               numTilePond = FishFarm.WTile + var12;
               numTileBarn = Cattle.numTileW + var11;
               int var13 = D.x / 24;
               var4 = (byte) (posBarn.x / 24 + 2);
               InputStream var16;
               LoadMap.map = new short[(var16 = LoadMap.d(25)).available()];

               for(var6 = 0; var6 < LoadMap.map.length; ++var6) {
                  LoadMap.map[var6] = (short)var16.read();
               }

               short[] var17 = new short[LoadMap.map.length + LoadMap.Hmap * (var12 + var11)];
               var5 = 0;

               for(var7 = 0; var7 < LoadMap.map.length; ++var7) {
                  var17[var5] = LoadMap.map[var7];
                  ++var5;
                  int var8;
                  if (var7 % LoadMap.wMap == var13) {
                     for(var8 = 0; var8 < var12; ++var8) {
                        var17[var5] = LoadMap.map[var7];
                        ++var5;
                     }
                  }

                  if (var7 % LoadMap.wMap == var4) {
                     for(var8 = 0; var8 < var11; ++var8) {
                        var17[var5] = LoadMap.map[var7];
                        ++var5;
                     }
                  }
               }

               LoadMap.wMap = (short)(LoadMap.wMap + var12 + var11);
               LoadMap.map = var17;
               LoadMap.treeLists.removeAllElements();
               Canvas.loadMap.a((InputStream)null, LoadMap.TYPEMAP + 1, true);
               Avatar var10000 = GameMidlet.avatar;
               var10000.x += var11 * 24;
               LoadMap.a(849, (int)(D.x + 12 + CRes.rnd(numTilePond - 2) * 24), (int)(D.y + 12 + CRes.rnd(3) * 24));
            } catch (Exception var9) {
               var9.printStackTrace();
            }

            listNest = new Vector();
            listBucket = new Vector();
            a(1, Chicken.s, (byte)87, -8, listNest);
            a(2, Cattle.posBucket, (byte)86, -7, listBucket);
            var1 = animalLists.size();

            for(var12 = 0; var12 < var1; ++var12) {
               Animal var15;
               if ((var15 = (Animal) animalLists.elementAt(var12)) instanceof FishFarm) {
                  ((FishFarm)var15).setInit();
               } else if (var15 instanceof Chicken) {
                  ((Chicken)var15).setInit();
               } else if (var15 instanceof Dog) {
                  ((Dog)var15).setInit();
               } else if (var15 instanceof Cattle) {
                  ((Cattle)var15).setInit();
               } else {
                  var15.setInit();
               }

               LoadMap.playerLists.addElement(var15);
            }

            Canvas.load = 1;
            Canvas.endDlg();
         }

         for(var1 = 0; var1 < LoadMap.treeLists.size(); ++var1) {
            SubObject var14;
            if ((var14 = (SubObject)LoadMap.treeLists.elementAt(var1)).type < 800 && var14.type >= 100 || var14.type == -3 || var14 instanceof CellFarm) {
               LoadMap.treeLists.removeElement(var14);
               --var1;
            }
         }

         this.v();
         this.aJ = System.currentTimeMillis();
         this.aK = System.currentTimeMillis();
         if (Canvas.currentMyScreen != this) {
            this.switchToMe();
         }

         if (Canvas.isDoubleImage) {
            Welcome.g();
         }

         GameMidlet.avatar.xCur = GameMidlet.avatar.x;
         GameMidlet.avatar.yCur = GameMidlet.avatar.y;
      }

      this.bf = true;
      if (S != -1) {
         GameMidlet.avatar.x = GameMidlet.avatar.xCur = S;
         GameMidlet.avatar.y = GameMidlet.avatar.yCur = T;
         S = -1;
         T = -1;
      }

      super.left = aP;
      super.right = null;
      super.center = null;
   }

   private static void a(int var0, AvPosition var1, byte var2, int var3, Vector var4) {
      int var5 = 0;

      for(int var6 = 0; var6 < animalLists.size(); ++var6) {
         Animal var7;
         AnimalInfo var8;
         if ((var8 = FarmData.getAnimalByID((var7 = (Animal) animalLists.elementAt(var6)).species)).area == var0 && var8.iconProduct != -1) {
            boolean var11 = false;

            int var9;
            for(var9 = 0; var9 < var4.size(); ++var9) {
               if (((AvPosition)var4.elementAt(var9)).anchor == var7.species) {
                  var11 = true;
                  break;
               }
            }

            if (!var11) {
               var9 = var1.x + var5 * 24;
               var4.addElement(new AvPosition(var9, var1.y, var7.species));
               int var10 = LoadMap.getposMap(var9, var1.y);
               LoadMap.type[var10] = var2;
               LoadMap.a(var3, var9, var1.y);
               ++var5;
            }
         }
      }

   }

   public static void f() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < animalLists.size(); ++var1) {
         Animal var2;
         AnimalInfo var3 = FarmData.getAnimalByID((var2 = (Animal) animalLists.elementAt(var1)).species);
         if (var2 instanceof AnimalDan) {
            boolean var4 = false;

            for(int var5 = 0; var5 < var0.size(); ++var5) {
               AvPosition var6;
               if ((var6 = (AvPosition)var0.elementAt(var5)).anchor == var2.species) {
                  ((AnimalDan)var2).captainID = var6.x;
                  var4 = true;
                  break;
               }
            }

            if (!var4) {
               ((AnimalDan)var2).captainID = var2.IDDB;
               var0.addElement(new AvPosition(var2.IDDB, 0, var2.species));
            }
         }

         int var7;
         if ((var7 = var3.harvestTime * 60 / 3) > 0) {
            var2.period = var2.bornTime / var7;
         }

         if (var2.period > 2) {
            var2.period = 2;
         }

         if (var2.bornTime == -1 || var3.area == 3) {
            var2.period = 0;
         }
      }

   }

   public final void b(int var1, int var2) {
      if (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) {
         Item var3;
         if ((var3 = Item.a(itemSeed, var2)) != null) {
            CellFarm var4;
            (var4 = (CellFarm) cell.elementAt(var1)).idTree = var2;
            this.a((CellFarm)var4, 4);
            LoadMap.map[var4.yCell * LoadMap.wMap + var4.xCell] = var4.status;
            var4.statusTree = 0;
            var4.isGrass = false;
            var4.isWorm = false;
            var4.d = 0;
            var4.tempTime = 0L;
            var4.vitalityPer = 100;
            var4.hervestPer = 0;
            --var3.e;
            if (var3.e <= 0) {
               itemSeed.removeElement(var3);
            }
         }

      }
   }

   public final void c(int var1) {
      CellFarm var4;
      if ((var4 = (CellFarm) cell.elementAt(var1)).idTree == -1) {
         this.a((CellFarm)var4, 2);
      } else {
         TreeInfo var2;
         int var3 = (var2 = FarmData.getTreeInfoByID(var4.idTree)).harvestTime * 60 / 5;
         var4.statusTree = var4.d / var3;
         if (var4.statusTree >= 5) {
            var4.statusTree = 5;
         }

         if (var4.d < 0 || var2.dieTime != -1 && var4.d - var2.harvestTime * 60 > var2.dieTime * 60 || var4.hervestPer == 100 || var4.statusTree < 0) {
            var4.statusTree = 6;
         }

         if (var4.isArid) {
            this.a((CellFarm)var4, 3);
         } else {
            this.a((CellFarm)var4, 4);
         }
      }

      LoadMap.map[var4.yCell * LoadMap.wMap + var4.xCell] = var4.status;
   }

   private void a(CellFarm var1, int var2) {
      if (var1.level == 2) {
         var1.status = this.aC[var2];
      } else {
         var1.status = this.aB[var2];
      }
   }

   public static void c(int var0, int var1) {
      CellFarm var3 = (CellFarm) cell.elementAt(var0);
      if (var1 > 0) {
         TreeInfo var2;
         if ((var2 = FarmData.getTreeByID(var3.idTree)).l) {
            Canvas.a(var1, var3.xCell * LoadMap.i + 11, var3.yCell * LoadMap.i, -1, 0, var2.idImg[var3.statusTree], -1);
         } else {
            ImageInfo var5 = FarmData.listImgInfo[var2.idImg[var3.statusTree]];
            Canvas.a(var1, var3.xCell * LoadMap.i + 11, var3.yCell * LoadMap.i, -1, CRes.createRGBImage(var5.x0 * AvMain.hd, var5.y0 * AvMain.hd, var5.w * AvMain.hd, var5.h * AvMain.hd, FarmData.imgBig[var5.bigID]), -1);
         }
      }

      if (idFarm == GameMidlet.avatar.IDDB) {
         var3.statusTree = 6;
         var3.hervestPer = 100;
         var3.isGrass = false;
         var3.isWorm = false;
      }

      TreeInfo var4;
      Item var6;
      if ((var4 = FarmData.getTreeByID(var3.idTree)).l) {
         if ((var6 = f(var4.j)) != null) {
            var6.e += var1;
         } else {
            (var6 = new Item()).ID = var4.j;
            var6.e = var1;
            var6.price[0] = var4.priceProduct;
            var6.name = var4.name;
            listFarmProduct.addElement(var6);
         }
      } else if ((var6 = Item.a(itemProduct, var4.ID)) != null) {
         var6.e += var1;
      } else {
         (var6 = new Item()).ID = var4.ID;
         var6.e = var1;
         var6.price[0] = FarmData.getTreeByID((int)var4.ID).priceProduct;
         var6.name = FarmData.getTreeByID((int)var4.ID).name;
         itemProduct.addElement(var6);
      }
   }

   public static void e(int var0, int var1) {
      Animal var6 = e(var0);
      if (var1 > 0 && var6 != null) {
         AnimalInfo var2;
         AnimalInfo var3 = var2 = FarmData.getAnimalByID(var6.species);
         Item var5;
         if ((var5 = Item.a(itemProduct, var3.species)) != null) {
            var5.e += var1;
         } else {
            (var5 = new Item()).ID = (short)var3.species;
            var5.e = var1;
            var5.name = var3.name;
            var5.price[0] = var3.priceProduct;
            a(var5);
            itemProduct.addElement(var5);
         }

         if (AvatarData.getImgIcon(var2.iconProduct) != null) {
            AvPosition var7 = null;
            if (var2.area == 1) {
               var7 = a((Vector) listNest, var6.species);
            } else if (var2.area == 2) {
               var7 = a((Vector) listBucket, var6.species);
            }

            if (var7 != null) {
               Canvas.a(var1, var7.x, var7.y - 25, -1, AvatarData.getImgIcon(var2.iconProduct).img, -1);
            }
         }

      }
   }

   private static AvPosition a(Vector var0, int var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         AvPosition var3;
         if ((var3 = (AvPosition)var0.elementAt(var2)).anchor == var1) {
            return var3;
         }
      }

      return null;
   }

   public static void a(int var0, int var1, byte var2, String var3, int var4, int var5, int var6) {
      if (var0 == idFarm) {
         System.out.println("onOpenLand: " + var1 + "    " + var2);
         GameMidlet.avatar.updateMoney(var4, var5, var6);
         Canvas.startOKDlg(var3);
      }
   }

   public final void b(int var1, boolean var2) {
      this.bf = var2;
      FarmService.gI().doJoinFarm(var1);
   }

   public final void a(int var1, String var2) {
      Canvas.startOKDlg(avt.T.bp + " " + var2 + "?", (IAction)(new class_ge(this, var1)));
   }

   public final void g() {
      Vector var1 = new Vector();

      int var2;
      for(var2 = 0; var2 < FarmData.treeInfo.length; ++var2) {
         class_fu var4 = new class_fu(this, avt.T.O, 7, FarmData.treeInfo[var2].ID, var2);
         var1.addElement(var4);
      }

      var2 = FarmData.listAnimalInfo.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         AnimalInfo var6 = (AnimalInfo)FarmData.listAnimalInfo.elementAt(var3);
         class_fy var7 = new class_fy(this, avt.T.O, 8, var3, var6, var3);
         var1.addElement(var7);
      }

      PopupShop.b().switchToMe();
      PopupShop.b().a(new String[]{avt.T.br, avt.T.bs, avt.T.aN}, new Vector[]{var1, this.B(), this.C()}, (Vector)null);
      if (Canvas.isDoubleImage && !Welcome.g) {
         (Canvas.welcome = new Welcome()).a((MyScreen)PopupShop.me);
      }

   }

   private Vector B() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < FarmData.listItemFarm.size(); ++var2) {
         FarmItem var3;
         if ((var3 = (FarmItem)FarmData.listItemFarm.elementAt(var2)).isItem && (var3.priceLuong > 0 || var3.priceXu > 0)) {
            var1.addElement(new CommandGoVatPham(this, avt.T.O, 9, var2, var3, var2));
         }
      }

      return var1;
   }

   private Vector C() {
      Vector var1 = new Vector();
      int var2 = itemProduct.size();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Item var4;
         if (FarmData.getTreeByID((int)(var4 = (Item) itemProduct.elementAt(var3)).ID) != null || var4.ID >= 50) {
            class_ko var5 = new class_ko(this, avt.T.bg, new class_fr(this, var3), var3, var4);
            var1.addElement(var5);
         }
      }

      for(var3 = 0; var3 < listFarmProduct.size(); ++var3) {
         Item var7;
         FarmItem var6 = b((var7 = (Item) listFarmProduct.elementAt(var3)).ID);
         System.out.println("aaaaaaaaaa: " + var6 + "    " + var7.ID);
         var1.addElement(new CommandGoKhoHang2(this, "", 11, var3, var6, var3, var7));
      }

      return var1;
   }

   public final void h() {
      if (GameMidlet.avatar.IDDB != idFarm) {
         Canvas.startOKDlg(avt.T.bt);
      } else {
         Vector var1 = new Vector();

         int var2;
         for(var2 = 0; var2 < itemSeed.size(); ++var2) {
            Item var4;
            if (FarmData.getTreeByID((int)(var4 = (Item) itemSeed.elementAt(var2)).ID) != null) {
               class_d var3 = new class_d(this, "", 12, var2, var4, var2);
               var1.addElement(var3);
            }
         }

         for(var2 = 0; var2 < listItemFarm.size(); ++var2) {
            CommandOpenKhoHang2 var6 = new CommandOpenKhoHang2(this, "", 13, var2, var2);
            var1.addElement(var6);
         }

         PopupShop.b().switchToMe();
         PopupShop.b().a(new String[]{avt.T.aN, avt.T.bu}, new Vector[]{this.C(), var1}, (Vector)null);

         for(int var5 = 0; var5 < itemProduct.size(); ++var5) {
            itemProduct.elementAt(var5);
         }

      }
   }

   public final void f(int var1, int var2) {
      if (var2 != 3 && !PopupShop.h()) {
         PopupShop.g();
         if (Canvas.isDoubleImage) {
            Canvas.welcome = new Welcome();
            if (Welcome.f > 2) {
               --Welcome.f;
            }

            Canvas.welcome.a((MyScreen)PopupShop.me);
            return;
         }
      } else {
         int var3 = PopupShop.f();
         int var4 = 0;
         int var5 = 0;
         if (var2 == 0) {
            TreeInfo var7;
            var4 = (var7 = FarmData.getTreeInfoByID(var1)).priceSeed[0];
            var5 = var7.priceSeed[1];
         } else if (var2 == 2) {
            var4 = FarmData.getVPbyID(var1).price[0];
            var5 = FarmData.getVPbyID(var1).price[1];
         } else {
            FarmItem var8;
            if (var2 == 4 && (var8 = b(var1)) != null) {
               var4 = var8.priceXu;
               var5 = var8.priceLuong;
            }
         }

         Canvas.a(var4 * var3, var5 * var3, new class_u(this, var1, var3, var4), new class_r(this, var1, var3, var5), (IAction)null);
      }

   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.t();
            return;
         case 1:
            if (Canvas.welcome == null || Welcome.d) {
               MenuSub.gI().startAt(this.K, 0);
               return;
            }
            break;
         case 2:
            FarmScr var10 = this;
            Vector var11 = new Vector();
            Animal var3;
            AnimalInfo var4 = FarmData.getAnimalByID((var3 = e(((Base)LoadMap.p).IDDB)).species);

            int var5;
            Item var6;
            FarmItem var7;
            for(var5 = 0; var5 < listItemFarm.size(); ++var5) {
               if ((var7 = b((var6 = (Item) listItemFarm.elementAt(var5)).ID)).type == var4.area && var7.action == 5 && (var4.area == 4 || var4.area == 1)) {
                  int var8 = var6.e;
                  if (var4.area == 4) {
                     var8 -= listFood[1].size();
                  } else if (var4.area == 1) {
                     var8 -= listFood[0].size();
                  }

                  var11.addElement(new class_ff(var10, var7.des + "(" + var8 + ")", new class_er(var10, var6, var4), var7));
               }
            }

            for(var5 = 0; var5 < listItemFarm.size(); ++var5) {
               if ((var7 = b((var6 = (Item) listItemFarm.elementAt(var5)).ID)).action != 5 && var7.type != 0 && (var7.type == var4.area || var7.type == 101 || var7.type == 100 && var4.area != 4) && (var7.action != 4 || var3.disease[0] || var3.disease[1]) && (var7.action != 6 || var3.health < 100)) {
                  var11.addElement(new class_fb(var10, var7.des + "(" + var6.e + ")", new class_fi(var10, var7, var6), var7));
               }
            }

            if (idFarm == GameMidlet.avatar.IDDB) {
               var11.addElement(new class_fd(var10, avt.T.bg, 2));
            }

            a(var11);
            return;
         case 3:
            this.q();
            return;
         case 4:
            this.r();
            return;
         case 5:
            super.left = aP;
            super.right = null;
            this.aW = false;
            AvCamera.isFollow = false;
            this.aX = false;
            this.ba.removeAllElements();

            for(var1 = 0; var1 < cell.size(); ++var1) {
               ((CellFarm) cell.elementAt(var1)).isSelected = false;
            }

            H = -1;
            L = -1;
            N = false;
            return;
         case 6:
            this.s();
            return;
         case 7:
            Vector var9;
            (var9 = new Vector()).addElement(new Command(avt.T.dR, 10));
            var9.addElement(new Command(avt.T.dS, 8));
            var9.addElement(new Command(avt.T.dT, 9));
            var9.addElement(new Command(avt.T.x, 20));
            MenuSub.gI().startAt(var9, 0);
            return;
         case 8:
            y = false;
            super.right = null;
            super.center = null;
            super.left = aP;
            this.bg = 0;
            AvCamera.isFollow = false;
            return;
         case 9:
            ++this.bg;
            this.commandActionPointer(10, -1);
            return;
         case 51:
            FarmService.gI().doOpenLand(idFarm, 1);
            this.aJ = System.currentTimeMillis();
            this.b(idFarm, true);
            return;
         case 52:
            FarmService.gI().doOpenLand(idFarm, 2);
            this.aJ = System.currentTimeMillis();
            this.b(idFarm, true);
            return;
         case 53:
            this.a((byte)0, (int)-1);
            Canvas.endDlg();
            return;
         case 54:
            this.j();
      }

   }

   public final void a(AnimalInfo var1) {
      Canvas.a(var1.price[0], var1.price[1], new class_x(this, var1), new class_aj(this, var1), (IAction)null);
   }

   public static void i() {
      if (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) {
         Canvas.menuMain = null;
         Canvas.startOK(avt.T.bv, 54, (AvMain)null);
      }

   }

   public static boolean a(short var0, int var1) {
      if (Item.a(listItemFarm, var0) == null) {
         return false;
      } else {
         FarmService.gI().doUsingItem(idFarm, var1, var0);
         return false;
      }
   }

   public final void a(byte var1, byte var2) {
      Vector var6 = new Vector();

      for(int var3 = 0; var3 < listItemFarm.size(); ++var3) {
         Item var4;
         FarmItem var5;
         if (((var5 = b((var4 = (Item) listItemFarm.elementAt(var3)).ID)).type == var1 || var5.type == 101) && var5.action == 5) {
            var6.addElement(new class_hg(this, var5.des + "(" + var4.e + ")", new class_ak(this, var1, var4), var5));
         }
      }

      MenuSub.gI().a(var6, Canvas.hw, LoadMap.i * AvMain.hd, LoadMap.i * AvMain.hd);
   }

   private static void a(Animal var0) {
      FarmService.gI().doHarvestAnimal(idFarm, var0.IDDB);
   }

   public final void a(int var1, int var2, Vector var3) {
      if (GameMidlet.avatar.IDDB == idFarm) {
         if (var2 >= 0 && var2 < var3.size()) {
            AvPosition var6 = (AvPosition)var3.elementAt(var2);

            for(int var7 = 0; var7 < animalLists.size(); ++var7) {
               Animal var4;
               AnimalInfo var5 = FarmData.getAnimalByID((var4 = (Animal) animalLists.elementAt(var7)).species);
               if (var4.numEggOne > 0 && var6.anchor == var4.species) {
                  var4.numEggOne = 0;
                  if (var1 == 1 && var5.area == var1) {
                     a(var4);
                     i(-50);
                  }

                  if (var1 == 2 && var5.area == var1) {
                     a(var4);
                     i(-51);
                  }
               }
            }

         }
      }
   }

   public final void a(int var1, int var2, short var3) {
      GameMidlet.avatar.money[0] = var2;
      PopupShop.isTransFocus = true;
      Canvas.startOKDlg(avt.T.bx + var1 + avt.T.T);
      Item var4;
      if ((var4 = Item.a(itemProduct, var3)) == null) {
         var4 = Item.a(listFarmProduct, var3);
         listFarmProduct.removeElement(var4);
      } else {
         itemProduct.removeElement(var4);
      }

      if (Canvas.currentMyScreen == PopupShop.b()) {
         PopupShop.b().close();
         if (LoadMap.TYPEMAP == 25) {
            this.g();
            PopupShop.b().b(2);
         } else {
            this.h();
         }
      }

      Canvas.endDlg();
   }

   public static void g(int var0, int var1) {
      Animal var4;
      if ((var4 = e(var0)) != null) {
         int var2 = var1 - GameMidlet.avatar.money[0];
         LoadMap.p = null;
         Image var3 = AvatarData.getImgIcon(FarmData.getAnimalByID(var4.species).idImg[var4.period]).img;
         Canvas.a(var2, var4.x, var4.y - 7, -1, CRes.createRGBImage(0, var4.indexFr * var4.height, var3.getWidth(), var4.height, var3), -1);
         animalLists.removeElement(var4);
         LoadMap.playerLists.removeElement(var4);
      }

      PopupShop.isTransFocus = true;
      GameMidlet.avatar.money[0] = var1;
   }

   public final void a(byte var1, String var2) {
      Canvas.startOKDlg(var2, (IAction)(new IActionPriceAnimal(this, var1)));
   }

   public final void j() {
      I = false;
      aM = false;
      Cattle.itemID = -1;
      Dog.itemID = -1;
      this.listHound = null;
      super.right = null;
      ParkService.a().a(25, 0);
   }

   public static Animal e(int var0) {
      for(int var1 = 0; var1 < animalLists.size(); ++var1) {
         Animal var2;
         if ((var2 = (Animal) animalLists.elementAt(var1)).IDDB == var0) {
            return var2;
         }
      }

      return null;
   }

   public final void m() {
      if (GameMidlet.avatar.IDDB == idFarm) {
         Vector var1 = new Vector();
         if (starFruil.d > 0) {
            var1.addElement(new class_ao(this, avt.T.eO + "(" + starFruil.d + ")", 12));
         }

         var1.addElement(new class_ap(this, starFruil.e > 0 ? avt.T.eN : avt.T.g, 13));
         var1.addElement(new class_am(this, avt.T.cw, 14));
         a(var1);
      }
   }

   private static void i(int var0) {
      for(int var1 = 0; var1 < LoadMap.treeLists.size(); ++var1) {
         SubObject var2;
         if ((var2 = (SubObject)LoadMap.treeLists.elementAt(var1)).catagory == 8 && var2.type == var0) {
            LoadMap.treeLists.removeElement(var2);
            return;
         }
      }

   }

   public final void n() {
      if (idFarm == GameMidlet.avatar.IDDB) {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < FarmData.listFood.size(); ++var2) {
            Food var3 = (Food)FarmData.listFood.elementAt(var2);
            var1.addElement(new CommandCooking1(this, avt.T.m, new IActionCooking1(this, var3), var3, var2));
         }

         Vector var5 = new Vector();
         if (V > 0) {
            var5.addElement((Object)null);
            CommandCooking2 var6 = new CommandCooking2(this, U == 0 ? avt.T.eL : avt.T.h, 2, this);
            var5.addElement(var6);
         }

         PopupShop.b().switchToMe();
         PopupShop.b().m = true;
         if (V > 0) {
            PopupShop.b().a(new String[]{avt.T.m, avt.T.dD}, new Vector[]{var1, null}, var5);
            PopupShop.b().a(new Command(avt.T.cm, 0, this), 1);
            PopupShop.g = 1;
            PopupShop.b().i();
            PopupShop.b().m();
         } else {
            PopupShop.b().a(new String[]{avt.T.m}, new Vector[]{var1}, (Vector)null);
         }
      }
   }

   public static void a(short var0, short var1) {
      for(int var2 = 0; var2 < starFruil.i.length; ++var2) {
         Canvas.a(0, starFruil.x + starFruil.i[var2], starFruil.y - 45 + starFruil.j[var2], -1, 0, starFruil.c, -1);
      }

      Canvas.a(var1, GameMidlet.avatar.x, GameMidlet.avatar.y - GameMidlet.avatar.height, -1, 10);
      starFruil.d = 0;
      Item var3;
      if ((var3 = f(var0)) != null) {
         var3.e += var1;
      } else {
         (var3 = new Item()).ID = var0;
         var3.e = var1;
         listFarmProduct.addElement(var3);
      }

      Canvas.endDlg();
   }

   public static Item f(int var0) {
      for(int var1 = 0; var1 < listFarmProduct.size(); ++var1) {
         Item var2;
         if ((var2 = (Item) listFarmProduct.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Item g(int var0) {
      for(int var1 = 0; var1 < itemProduct.size(); ++var1) {
         Item var2;
         if ((var2 = (Item) itemProduct.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void o() {
      ListScr.b().b(true);
   }

   static void a(FarmScr var0, byte var1, int var2) {
      var0.a(var1, var2);
   }

   static void a(FarmScr var0, CellFarm var1) {
      if (var1.idTree != -1 && var1.statusTree < 6) {
         Canvas.b(avt.T.bh, 53);
      } else {
         var0.a((byte)0, (int)-1);
         Canvas.endDlg();
      }
   }

   static void a(FarmScr var0, int var1, int var2) {
      i(var1, var2);
   }

   static void a(FarmScr var0) {
      var0.A();
   }

   static Vector p() {
      return itemSeed;
   }

   static void a(FarmScr var0, FarmItem var1, short var2, Animal var3) {
      var0.a(var1, var2, var3);
   }
}

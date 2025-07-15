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
   public static FrameImage unk;
   public static FrameImage u;
   public AvPosition[] posTree;
   private Vector listHound;
   public static int numTileBarn;
   public static int numTilePond;
   private byte[] typeCell = new byte[]{33, 34, 35, 36, 37};
   private byte[] typeCell1 = new byte[]{33, 120, 121, 122, 123};
   private Vector listAction = new Vector();
   public static boolean isAutoVatNuoi = false;
   public static boolean isNew = false;
   public static AvPosition focusCell;
   public static AvPosition posName;
   public static AvPosition posBarn;
   public static AvPosition posPond;
   public static byte action = -1;
   public static byte frame;
   private AvPosition posDoing;
   private int t;
   private static int numO = 12;
   private static int numH = 4;
   public static int idItemUsing = -1;
   public static int idSelected = -1;
   private int timeLimit;
   private long curTime;
   private long curTimeCooking;
   private static int tempTime = 0;
   public static boolean isSteal = false;
   private static boolean isAbleSteal = false;
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
   private boolean isSelectedCell = false;
   private boolean isChamSoc = false;
   public static int indexItem = -1;
   Animal aniDoing;
   private long timeDoing = -1L;
   public static boolean isSelected = false;
   private boolean isTrans;
   private Vector listSelectedCell = new Vector();
   private boolean isTran = false;
   private int n = 0;
   public static byte levelStore;
   public static byte numBarn;
   public static byte numPond;
   public static boolean isReSize = false;
   public static int xRemember = -1;
   public static int yRemember = -1;
   public static int remainTime;
   public static short foodID = 0;
   private static int bd = -1;
   private static String be = "";
   private boolean isJoin = true;
   private int indexAuto = 0;
   public static int xPosCook;
   public static int yPosCook;

   public static FarmScr gI() {
      if (instance == null) {
         instance = new FarmScr();
      }

      return instance;
   }

   public final void switchToMe() {
      super.switchToMe();
   }

   public static void initImg() {
      isSteal = false;
      isAbleSteal = false;
      if (unk == null) {
         FilePack.b(avt.T.au);
         imgBuyLant = FilePack.getImage("buyLand");
         unk = FrameImage.init("cut", 24 * AvMain.hd, 24 * AvMain.hd);
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

   public final void doLeftMenu() {
      aO = new Command(avt.T.O, 0);
      aP = new Command(avt.T.c, 7);
      aQ = new Command((String)null, 2);
      aR = new Command((String)null, 3);
      super.left = aP;
   }

   public FarmScr() {
      listFood[0] = new Vector();
      listFood[1] = new Vector();
      this.doLeftMenu();
      FilePack.b(avt.T.au);
      imgFocusCel = FilePack.getImage("coin");
      u = FrameImage.init("iB", 9 * AvMain.hd, 13 * AvMain.hd);
      FilePack.reset();
      this.r();
      initImg();
      aS = new Command(avt.T.cy, 8);
      aT = new Command(avt.T.bz, 9);
      this.aU = new Command(avt.T.bz, 16, this);
      this.aV = new Command(avt.T.d, 18, this);
   }

   private void doFeeding() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < listItemFarm.size(); ++var2) {
         Item var3;
         FarmItem var4;
         if ((var4 = getFarmItem((var3 = (Item) listItemFarm.elementAt(var2)).ID)).action == 5 && (var4.type == 4 || var4.type == 101)) {
            var1.addElement(new CommandThuoc(this, var4.des, new IActionThuoc(this, var3), var4));
         }
      }

      startMenuFarm(var1);
   }

   private void r() {
      this.K.addElement(MapScr.gI().f);
      Command var1 = new Command(avt.T.x, 20);
      this.K.addElement(var1);
   }

   private void doKhoGiong() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < itemSeed.size(); ++var2) {
         Item var3;
         if (FarmData.getTreeByID((int)(var3 = (Item) itemSeed.elementAt(var2)).ID) != null) {
            var1.addElement(new CommandKhoGiong(this, var3.name + "(" + var3.number + ")", 7, var2, var3));
         }
      }

      startMenuFarm(var1);
   }

   public final void close() {
      Canvas.startWaitDlg();
      GlobalService.gI().getHandler((int)8);
   }

   private void doSellect() {
      int var1;
      if ((var1 = this.getPosTreeByFocus(focusCell.x, focusCell.y)) - cell.size() == 0) {
         Canvas.startWaitDlg();
         FarmService.gI().doRequestPricePlant(idFarm);
      } else {
         if (var1 >= 0 && var1 < cell.size()) {
            CellFarm var8;
            if ((var8 = (CellFarm) cell.elementAt(var1)).statusTree == 5) {
               this.doHarvest();
               return;
            }

            if (var8.idTree != -1 || (var8.level != 1 || var8.status != this.typeCell[1]) && (var8.level != 2 || var8.status != this.typeCell1[1])) {
               this.a(var8);
            } else {
               FarmScr var9 = this;
               if (itemSeed.size() != 0) {
                  if (action == -1) {
                     Vector var2 = new Vector();
                     int var3 = this.getPosTreeByFocus(focusCell.x, focusCell.y);
                     CellFarm var4 = (CellFarm) cell.elementAt(var3);
                     CellFarm var5 = null;
                     if (var3 > 0) {
                        var5 = (CellFarm) cell.elementAt(var3 - 1);
                     }

                     for(int var6 = 0; var6 < itemSeed.size(); ++var6) {
                        Item var7;
                        if (FarmData.getTreeByID((int)(var7 = (Item) itemSeed.elementAt(var6)).ID) != null) {
                           var2.addElement(new class_bn(var9, var7.name + "(" + var7.number + ")", 5, var6, var7));
                        }
                     }

                     if (idFarm == GameMidlet.avatar.IDDB && (var4.level == 1 && var3 == 0 || var3 > 0 && var4.level < var5.level)) {
                        var2.addElement(new class_bp(var9, avt.T.g, 11));
                     }

                     startMenuFarm(var2);
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

   private void setAction(IAction var1) {
      if (action != -1) {
         this.listAction.addElement(var1);
      } else {
         var1.perform();
      }
   }

   private boolean h(int var1, int var2) {
      boolean var3 = false;

      for(int var4 = 0; var4 < listItemFarm.size(); ++var4) {
         FarmItem var5;
         if ((var5 = getFarmItem(((Item) listItemFarm.elementAt(var4)).ID)).type == 0 && var5.action == var2) {
            this.setAction((IAction)(new class_bs(this, var5, var1)));
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
      int var2 = this.getPosTreeByFocus(focusCell.x, focusCell.y);
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
         this.setAction((IAction)(new class_bg(this)));
      }

      if (var1.idTree == -1 || var1.statusTree >= 6) {
         class_bi var7 = new class_bi(this, var1);
         if (var5 != null) {
            Vector var8;
            (var8 = new Vector()).addElement(new class_bk(this, avt.T.be, var7));
            var8.addElement(var5);
            startMenuFarm(var8);
            return;
         }

         this.setAction((IAction)var7);
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

      if (action == -1) {
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
            if ((var12 = getFarmItem((var10 = (Item) listItemFarm.elementAt(var2)).ID)).type == 0 && (var12.action == 3 && var1.isGrass || var12.action == 7 && var1.isWorm || var12.action != 3 && var12.action != 7)) {
               String var11 = var12.des + "(" + var10.number + ")";
               var9.addElement(new CommandThuoc(this, var11, 6, var2, var12));
            }
         }

         startMenuFarm(var9);
      }

   }

   public static void startMenuFarm(Vector var0) {
      int var1 = LoadMap.w * AvMain.hd;
      if (Canvas.isKeyBoard) {
         var1 += var1 / 3;
      }

      MenuSub.gI().startMenuFarm(var0, Canvas.hw, var1, var1);
   }

   public final void commandTab(int var1) {
      FarmService var2;
      switch (var1) {
         case 0:
            Canvas.startOKDlg(avt.T.ei, 1, this);
            return;
         case 1:
            FarmService.gI().doCooking((short)-1);
            PopupShop.gI().close();
            return;
         case 2:
            PopupShop.gI().close();
            if (remainTime == 0) {
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
            ListScr.gI().setFriendList(true);
            return;
         case 16:
            FarmService.gI().doSteal(0);
            return;
         case 17:
            (var2 = FarmService.gI()).createMessage((byte)95);
            var2.sendMessage();
            return;
         case 18:
            gI().doGoFarmWay();
            return;
         case 19:
            (var2 = FarmService.gI()).createMessage((byte)98);
            var2.sendMessage();
            return;
         case 20:
            isAbleSteal = true;
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
            this.setAction((byte)1, (int) idItemUsing);
            return;
         case 2:
            if (LoadMap.focusObj != null) {
               Canvas.endDlg();
               FarmService.gI().doRequestPriceAnimal(idFarm, ((Base)LoadMap.focusObj).IDDB);
               return;
            }
            break;
         case 3:
            if (LoadMap.focusObj != null) {
               AnimalInfo var12 = FarmData.getAnimalByID(getAnimalByIndex(((Base)LoadMap.focusObj).IDDB).species);

               for(int var11 = 0; var11 < listItemFarm.size(); ++var11) {
                  if (var2 == var11) {
                     Item var9 = (Item) listItemFarm.elementAt(var11);
                     this.doUsingVatPhamAnimal(var9, var12.area == 1 ? 0 : 1);
                  }
               }

               return;
            }
            break;
         case 4:
            if (LoadMap.focusObj != null) {
               for(var1 = 0; var1 < listItemFarm.size(); ++var1) {
                  if (var2 == var1) {
                     var4 = getFarmItem((var8 = (Item) listItemFarm.elementAt(var1)).ID);
                     this.setActionAnimal(var4, var8.ID, (Animal)LoadMap.focusObj);
                  }
               }

               return;
            }
            break;
         case 5:
            for(var1 = 0; var1 < itemSeed.size(); ++var1) {
               if (var1 == var2) {
                  int var10;
                  if ((var10 = this.getPosTreeByFocus(focusCell.x, focusCell.y)) >= cell.size()) {
                     return;
                  }

                  doPlantSeed(var1, var10);
               }
            }

            return;
         case 6:
            for(var1 = 0; var1 < listItemFarm.size(); ++var1) {
               if (var1 == var2) {
                  if ((var8 = (Item) listItemFarm.elementAt(var1)).number > 0) {
                     int var5;
                     if ((var5 = this.getPosTreeByFocus(focusCell.x, focusCell.y)) < cell.size() && listItemFarm.size() != 0) {
                        byte var6;
                        if ((var6 = (var4 = getFarmItem(var8.ID)).action) != 7) {
                           if (var6 == 1) {
                              this.setAction((byte)2, (int)var4.ID);
                           } else {
                              this.setAction((byte)var6, (int)var4.ID);
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
            this.setAuto(var2);
            return;
         case 8:
            this.commandTab((int)5, (int)-1);
            this.doKhoGiong();
            return;
         case 9:
            this.isChamSoc = true;
            this.setAuto(0);
            return;
         case 10:
            isAutoVatNuoi = true;

            for(var1 = this.indexAuto; var1 < animalLists.size(); ++var1) {
               Animal var7 = (Animal) animalLists.elementAt(var1);
               boolean var10000;
               if (var7.disease[1]) {
                  LoadMap.focusObj = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dU, new IActionTriBenh1(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.disease[0]) {
                  LoadMap.focusObj = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dU, new IActionTriBenh2(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.hunger && !(var7 instanceof Dog) && !(var7 instanceof Cattle)) {
                  LoadMap.focusObj = var7;
                  AvCamera.gI().setToPos(var7.x * AvMain.hd, var7.y * AvMain.hd);
                  AvCamera.isFollow = true;
                  super.center = new Command(avt.T.dX, new class_ab(this, var7));
                  super.left = aS;
                  super.right = aT;
                  var10000 = true;
               } else if (var7.health < 50) {
                  LoadMap.focusObj = var7;
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

               ++this.indexAuto;
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
            if (starFruil.timeFinish > 0) {
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

   private void setAuto(int var1) {
      idSelected = 0;
      super.left = new Command(avt.T.cy, 5);
      super.right = null;
      AvCamera.isFollow = true;
      super.center = null;
      this.isSelectedCell = true;
      indexItem = var1;
   }

   private void setActionAnimal(FarmItem var1, short var2, Animal var3) {
      this.setAction((IAction)(new IActionSetAnimal(this, var1, var2, var3)));
   }

   protected final void doUsingVatPhamAnimal(Item var1, int var2) {
      int var3 = GameMidlet.avatar.direct == 0 ? 1 : -1;
      int var4 = listFood[var2].size();
      if (var1.number - var4 <= 0) {
         Canvas.startOKDlg(avt.T.bw);
      } else {
         for(int var5 = 0; var5 < 3 && var5 < var1.number - var4; ++var5) {
            Point var6 = new Point(GameMidlet.avatar.x, GameMidlet.avatar.y - 40);
            FarmItem var7 = getFarmItem(var1.ID);
            var6.itemID = var1.ID;
            var6.w = var6.e = 2;
            var6.b = -(4 + CRes.rnd(3));
            var6.c = var3 * (2 + CRes.rnd(3));
            var6.limitY = GameMidlet.avatar.y - 20 + CRes.rnd(4) * 5;
            if (var7.type == 4) {
               int var8 = LoadMap.getposMap(GameMidlet.avatar.x, GameMidlet.avatar.y + 23);
               if (LoadMap.map[var8] == 14) {
                  var6.limitY = 50 + CRes.rnd(50);
                  var6.c = var3 * CRes.rnd(3);
               }
            }

            var6.layer = new PoLayer(this, var6);
            listFood[var2].addElement(var6);
            LoadMap.dynamicLists.addElement(var6);
         }

      }
   }

   public static void startTextSmall(int var0, int var1, CellFarm var2, Animal var3) {
      if (LoadMap.TYPEMAP != 25 && var0 != var1) {
         String var4 = "";
         if (var1 - var0 > 0) {
            var4 = var4 + "+";
         }

         int var5;
         int var6;
         if (var2 != null) {
            var5 = var2.xCell * LoadMap.w + LoadMap.w / 2;
            var6 = var2.yCell * LoadMap.w - LoadMap.w / 2;
         } else {
            var5 = var3.x;
            var6 = var3.y - 30;
         }

         Canvas.addFlyTextSmall(var4 + (var1 - var0), var5, var6, -1, 0, -1);
      }

   }

   private void doHarvest() {
      if (GameMidlet.avatar.IDDB == idFarm) {
         int var1 = this.getPosTreeByFocus(focusCell.x, focusCell.y);
         GameMidlet.avatar.getClass();
         FarmService.gI().doHervest(idFarm, var1);
      }
   }

   private static void doPlantSeed(int var0, int var1) {
      if (Canvas.isInitChar) {
         Welcome.goFarm();
      }

      Item var2 = (Item) itemSeed.elementAt(var0);
      FarmService.gI().doPlantSeed((int) idFarm, (int)var1, var2.ID);
   }

   private int getPosTreeByFocus(int var1, int var2) {
      for(int var3 = 0; var3 < this.posTree.length; ++var3) {
         for(int var4 = 0; var4 < numO; ++var4) {
            int var5 = this.posTree[var3].x + var4 / numH;
            int var6 = this.posTree[var3].y + var4 % numH;
            if (var1 == var5 && var2 == var6) {
               return var3 * numO + var4;
            }
         }
      }

      return -1;
   }

   private void setAction(byte var1, int var2) {
      idItemUsing = var2;
      action = var1;
      GameMidlet.avatar.task = -1;
      GameMidlet.avatar.idFrom = -1;
      GameMidlet.avatar.idTo = -1;
      if (action == 4) {
         this.posDoing = new AvPosition(LoadMap.focusObj.x / LoadMap.w, LoadMap.focusObj.y / LoadMap.w);
      } else {
         this.posDoing = new AvPosition(focusCell.x, focusCell.y);
      }

      GameMidlet.avatar.yCur = this.posDoing.y * LoadMap.w + LoadMap.w / 2;
      GameMidlet.avatar.xCur = this.posDoing.x * LoadMap.w;
      if (GameMidlet.avatar.direct == Base.LEFT) {
         Avatar var10000 = GameMidlet.avatar;
         var10000.xCur += LoadMap.w;
      }

   }

   private void setCellAll() {
      for(int var1 = 0; var1 < this.posTree.length; ++var1) {
         for(int var2 = 0; var2 < numO; ++var2) {
            int var3 = this.posTree[var1].x + var2 / numH;
            int var4 = this.posTree[var1].y + var2 % numH;
            if (var1 * numO + var2 < cell.size()) {
               LoadMap.setType(var3, (int)var4, (byte)51);
               CellFarm var5;
               (var5 = (CellFarm) cell.elementAt(var1 * numO + var2)).time1 = (short)(var1 * numO + var2);
               var5.xCell = var3;
               var5.yCell = var4;
               var5.x = var3 * LoadMap.w + LoadMap.w / 2;
               var5.y = var4 * LoadMap.w + 18;
               this.setInfoCell(var1 * numO + var2);
               LoadMap.treeLists.addElement(var5);
            } else {
               if (var1 * numO + var2 == cell.size()) {
                  LoadMap.treeLists.addElement(new SubObject(-3, var3 * LoadMap.w + 20, var4 * LoadMap.w + 20, imgBuyLant.getWidth()));
                  LoadMap.setType(var3, (int)var4, (byte)51);
                  LoadMap.orderVector(LoadMap.treeLists);
               }

               if (LoadMap.map[var4 * LoadMap.wMap + var3] == this.typeCell[0]) {
                  LoadMap.orderVector(LoadMap.treeLists);
                  return;
               }

               if (var3 == this.posTree[var1].x && var4 == this.posTree[var1].y) {
                  LoadMap.map[var4 * LoadMap.wMap + var3] = 4;
               }
            }
         }
      }

      LoadMap.orderVector(LoadMap.treeLists);
   }

   public final void update() {
      this.t += 2;
      if (this.t >= 10) {
         this.t = 0;
      }

      if (action != -1) {
         frame = FRAME[action][this.t];
         ++this.timeLimit;
         if (this.timeLimit > 10) {
            this.timeLimit = 0;
            this.resetAction();
         }
      }

      if (LoadMap.TYPEMAP == 24 && LoadMap.TYPEMAP == 53 && (System.currentTimeMillis() - this.curTime) / 1000L > 300L) {
         this.curTime = System.currentTimeMillis();
         this.doJoinFarm(idFarm, true);
      }

      Canvas.loadMap.update();
      if (!isAutoVatNuoi && !isSelected && indexItem == -1) {
         this.setFocus();
      }

      int var2;
      label143: {
         if (action != -1 && this.timeDoing == -1L && GameMidlet.avatar.action == 0) {
            this.timeDoing = System.currentTimeMillis() / 100L;
            var2 = -1;
            if (this.posDoing != null) {
               var2 = this.getPosTreeByFocus(this.posDoing.x, this.posDoing.y);
            }

            if (action == 4) {
               var2 = 0;
            }

            if (this.posDoing.x * LoadMap.w < GameMidlet.avatar.x) {
               GameMidlet.avatar.direct = Base.LEFT;
            } else {
               GameMidlet.avatar.direct = 0;
            }

            GameMidlet.avatar.dirLast = GameMidlet.avatar.direct;
            if (this.aniDoing != null) {
               this.aniDoing.isStand = false;
               this.aniDoing = null;
            }

            if (var2 == -1) {
               this.resetAction();
               break label143;
            }

            SubObject var6 = new SubObject(-2, GameMidlet.avatar.x, GameMidlet.avatar.y - 5, unk.frameWidth);
            LoadMap.treeLists.addElement(var6);
            byte var3 = 0;
            if (action == 0) {
               var3 = 5;
               var6.y = GameMidlet.avatar.y - 8;
            }

            if (GameMidlet.avatar.direct == 0) {
               var6.x = GameMidlet.avatar.x + 10 + var3;
            } else {
               var6.x = GameMidlet.avatar.x - 10 - var3;
            }
         }

         if (this.timeDoing != -1L && (action == 1 || action == 0 || action == 2) && System.currentTimeMillis() / 100L - this.timeDoing > 2L) {
            this.timeDoing = System.currentTimeMillis() / 100L;
            if (GameMidlet.avatar.action == 6) {
               GameMidlet.avatar.setAction((byte)0);
            } else {
               GameMidlet.avatar.setAction((byte)6);
            }
         }
      }

      if ((LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) && animalLists.size() > 0 && ++tempTime > 250) {
         tempTime = 0;
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

      if (System.currentTimeMillis() / 1000L - this.curTimeCooking / 1000L >= 1L) {
         if (remainTime > 0) {
            --remainTime;
         }

         this.curTimeCooking = System.currentTimeMillis();

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

   private void resetAction() {
      int var1;
      for(var1 = 0; var1 < LoadMap.treeLists.size(); ++var1) {
         if (((SubObject)LoadMap.treeLists.elementAt(var1)).type == -2) {
            LoadMap.treeLists.removeElementAt(var1);
            if (var1 > 0) {
               --var1;
            }
         }
      }

      this.timeDoing = -1L;
      var1 = -1;
      if (this.posDoing != null) {
         int var2 = this.posDoing.y;
         var1 = this.posDoing.x;
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
         action = -1;
         GameMidlet.avatar.action = 0;
         GameMidlet.avatar.task = 0;
         this.doAction();
      } else {
         if (idItemUsing == -1) {
            CellFarm var6 = (CellFarm) cell.elementAt(var1);
            switch (action) {
               case 0:
                  this.setStatusCell((CellFarm)var6, 1);
                  var6.statusTree = 0;
                  LoadMap.map[var6.yCell * LoadMap.wMap + var6.xCell] = var6.status;
                  if (var6.idTree != -1) {
                     FarmService.gI().doPlantSeed((int) idFarm, (int)var1, -1);
                  }

                  var6.idTree = -1;
                  if (Canvas.isInitChar) {
                     Welcome.goFarm();
                  }
                  break;
               case 1:
                  this.setStatusCell((CellFarm)var6, 4);
                  var6.isArid = false;
                  LoadMap.map[var6.yCell * LoadMap.wMap + var6.xCell] = var6.status;
                  FarmService.gI().doUsingItem(idFarm, var1, 100);
               case 2:
            }
         }

         idItemUsing = -1;
         this.posDoing = null;
         action = -1;
         GameMidlet.avatar.task = 0;
         GameMidlet.avatar.action = 0;
         this.doAction();
      }
   }

   private void doAction() {
      if (isAutoVatNuoi) {
         this.commandActionPointer(10, -1);
      } else if (this.listAction.size() > 0) {
         IAction var1;
         (var1 = (IAction)this.listAction.elementAt(0)).perform();
         this.listAction.removeElement(var1);
      } else {
         if (this.isChamSoc) {
            this.setGieoHat();
         }

      }
   }

   private void setFocus() {
      if (LoadMap.TYPEMAP != 25) {
         int var1;
         if (GameMidlet.avatar.direct == Base.LEFT) {
            var1 = GameMidlet.avatar.x - 23;
         } else {
            var1 = GameMidlet.avatar.x + 23;
         }

         var1 /= LoadMap.w;
         int var2 = GameMidlet.avatar.y / LoadMap.w;
         int var3 = LoadMap.type[var2 * LoadMap.wMap + var1];
         int var4 = this.getPosTreeByFocus(var1, var2);
         if (var3 == 51 && var4 <= cell.size()) {
            focusCell.x = var1;
            focusCell.y = var2;
            if (action != 0 && action != 1) {
               super.center = aO;
            } else {
               super.center = null;
            }
         } else {
            if (super.center == aO || super.center == aR) {
               super.center = null;
            }

            focusCell.x = -1;
            focusCell.y = -1;
            if (LoadMap.focusObj == null) {
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

            if (LoadMap.focusObj != null && super.center == null) {
               if (super.right == null) {
                  super.right = LoadMap.q;
               }

               super.center = aQ;
            }

            if (LoadMap.focusObj == null) {
               super.right = null;
            }

            if (LoadMap.focusObj == null && super.center == aQ) {
               super.center = null;
            }

         }
      }
   }

   public final void updateKey() {
      if (this.isTrans && GameMidlet.avatar.action == 0 && GameMidlet.avatar.task == 0 && GameMidlet.avatar.x == GameMidlet.avatar.xCur && GameMidlet.avatar.y == GameMidlet.avatar.yCur) {
         this.isTrans = false;
         GameMidlet.avatar.direct = 0;
         this.setFocus();
         if (action == -1) {
            if (indexItem != -1) {
               if (this.listSelectedCell.size() > 0 && indexItem != -1) {
                  label244: {
                     AvPosition var3 = (AvPosition)this.listSelectedCell.elementAt(0);
                     CellFarm var4;
                     (var4 = (CellFarm) cell.elementAt(var3.anchor)).isSelected = false;
                     focusCell.x = var4.x / LoadMap.w;
                     focusCell.y = var4.y / LoadMap.w;
                     if (this.isChamSoc) {
                        if (var4.statusTree == 5) {
                           this.doHarvest();
                           this.setGieoHat();
                        } else {
                           boolean var5 = false;
                           if (var4.idTree != -1 && var4.statusTree < 6 && var4.status == 36) {
                              this.setAction((IAction)(new class_fp(this, var4)));
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
                                    if ((var7 = getFarmItem(((Item) listItemFarm.elementAt(var6)).ID)).action == 2 && (var7.ID == 111 || var7.ID == 112)) {
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
                              this.setGieoHat();
                           }
                        }
                     } else if (var4.statusTree == 5) {
                        this.doHarvest();
                        this.setGieoHat();
                     } else {
                        this.setAction((IAction)(new class_fq(this, var4)));
                        this.setAction((IAction)(new class_gc(this, var3)));
                     }

                     this.listSelectedCell.removeElement(var3);
                  }
               }
            } else {
               indexItem = -1;
               this.doSellect();
            }
         }
      }

      int var2;
      if (idSelected != -1) {
         if (Canvas.a(2)) {
            Canvas.keyHold[2] = false;
            if ((var2 = idSelected) % 12 % 4 != 0) {
               --var2;
            }

            if (var2 >= 0) {
               idSelected = var2;
            }
         } else if (Canvas.a(4)) {
            Canvas.keyHold[4] = false;
            var2 = idSelected;
            var2 -= 4;
            if (var2 >= 0) {
               idSelected = var2;
            }
         } else if (Canvas.a(6)) {
            Canvas.keyHold[6] = false;
            var2 = idSelected;
            var2 += 4;
            if (var2 < cell.size()) {
               idSelected = var2;
            }
         } else if (Canvas.a(8)) {
            Canvas.keyHold[8] = false;
            if ((var2 = idSelected) % 12 % 4 != 3) {
               ++var2;
            }

            if (var2 < cell.size()) {
               idSelected = var2;
            }
         } else if (Canvas.a(5)) {
            label276: {
               var2 = LoadMap.w;
               CellFarm var8;
               if ((var8 = (CellFarm) cell.elementAt(idSelected)).idTree != -1 && var8.statusTree < 6) {
                  if (this.isChamSoc) {
                     if (!var8.isSelected) {
                        this.listSelectedCell.addElement(new AvPosition(var8.x / var2, var8.y / var2, idSelected));
                     }

                     var8.isSelected = true;
                     this.setGieoHat();
                     break label276;
                  }
               } else if (!this.isChamSoc) {
                  if (!var8.isSelected) {
                     this.listSelectedCell.addElement(new AvPosition(var8.x / var2, var8.y / var2, idSelected));
                  }

                  var8.isSelected = true;
                  this.setGieoHat();
                  break label276;
               }

               Canvas.startOKDlg(avt.T.dJ);
            }
         }

         if (Canvas.stypeInt == 0) {
            CellFarm var12 = (CellFarm) cell.elementAt(idSelected);
            AvCamera.gI().setToPos(var12.x, var12.y);
         }
      }

      int var9;
      int var11;
      CellFarm var13;
      if (Canvas.isPointerClick) {
         var2 = Canvas.px + AvCamera.gI().xCam;
         var9 = Canvas.py + AvCamera.gI().yCam;
         var11 = LoadMap.w * AvMain.hd;
         if (var9 / var11 * LoadMap.wMap + var2 / var11 >= 0 && var9 / var11 * LoadMap.wMap + var2 / var11 <= LoadMap.type.length && LoadMap.type[var9 / var11 * LoadMap.wMap + var2 / var11] == 51) {
            this.isTran = true;
            isSelected = true;
            var11 = this.getPosTreeByFocus(var2 / var11, var9 / var11);
            var13 = (CellFarm) cell.elementAt(var11);
            focusCell.x = var13.x / LoadMap.w;
            focusCell.y = var13.y / LoadMap.w;
         }
      }

      if (this.isTran && Canvas.isPointerRelease) {
         this.isTran = false;
         isSelected = false;
         var2 = Canvas.px + AvCamera.gI().xCam;
         var9 = Canvas.py + AvCamera.gI().yCam;
         var11 = LoadMap.w * AvMain.hd;
         if (!this.isSelectedCell && super.center != null && focusCell != null && var2 / var11 == focusCell.x && var9 / var11 == focusCell.y) {
            super.center.perform();
         } else if (var9 / var11 * LoadMap.wMap + var2 / var11 >= 0 && var9 / var11 * LoadMap.wMap + var2 / var11 <= LoadMap.type.length && LoadMap.type[var9 / var11 * LoadMap.wMap + var2 / var11] == 51) {
            var11 = this.getPosTreeByFocus(var2 / var11, var9 / var11);
            var13 = (CellFarm) cell.elementAt(var11);
            focusCell.x = var13.x / LoadMap.w;
            focusCell.y = var13.y / LoadMap.w;
            if (this.isSelectedCell && var11 >= 0 && var11 < cell.size()) {
               idSelected = var11;
               if (var13.idTree != -1 && var13.statusTree != 5 && var13.statusTree < 6) {
                  Canvas.isPointerRelease = false;
                  if (this.isChamSoc) {
                     if (!var13.isSelected) {
                        this.listSelectedCell.addElement(new AvPosition(var2 / LoadMap.w, var9 / LoadMap.w, var11));
                     }

                     var13.isSelected = true;
                     this.setGieoHat();
                  } else if (var13.statusTree != 5) {
                     Canvas.startOKDlg(avt.T.dL);
                  }
               } else {
                  Canvas.isPointerRelease = false;
                  if (this.isChamSoc && var13.statusTree != 5) {
                     Canvas.startOKDlg(avt.T.dK);
                  } else {
                     if (!var13.isSelected) {
                        this.listSelectedCell.addElement(new AvPosition(var2 / LoadMap.w, var9 / LoadMap.w, var11));
                     }

                     var13.isSelected = true;
                     this.setGieoHat();
                  }
               }
            } else {
               Canvas.pxLast = Canvas.px -= LoadMap.w * AvMain.hd;
               this.isTrans = true;
            }
         }
      }

      if (Canvas.keyPressed[5] && (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) && super.left != null && super.center == null) {
         super.left.perform();
      }

      super.updateKey();
      Canvas.loadMap.a();
      if (action == -1) {
         GameMidlet.avatar.updateKey();
      }

   }

   private void setGieoHat() {
      if (this.listSelectedCell.size() > 0 && indexItem != -1) {
         this.isTrans = true;
         AvPosition var1 = (AvPosition)this.listSelectedCell.elementAt(0);
         if (GameMidlet.avatar.at == null) {
            LoadMap.posFocus = new AvPosition();
            GameMidlet.avatar.createAvatarArrays();
         }

         LoadMap.posFocus.x = var1.x * 24 - 24;
         LoadMap.posFocus.y = var1.y * 24 + 12;
         GameMidlet.avatar.task = -5;
         GameMidlet.avatar.isJumps = -1;
         GameMidlet.avatar.xCur = GameMidlet.avatar.x;
         GameMidlet.avatar.yCur = GameMidlet.avatar.y;
         GameMidlet.avatar.posFocus = LoadMap.posFocus;
         GameMidlet.avatar.findPath();
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      if (Canvas.welcome == null || !Welcome.isPaintArrow) {
         super.paint(var1);
      }

      Canvas.paintPlus(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.loadMap.b(var1);
      Canvas.loadMap.d(var1);
      if (idSelected >= 0) {
         if (this.n >= 8) {
            this.n = 0;
         }

         CellFarm var4 = (CellFarm) cell.elementAt(idSelected);
         var1.drawImage(MapScr.d, var4.x * AvMain.hd, (var4.y - 24 + this.n / 2) * AvMain.hd, 3);
         ++this.n;
      } else if (Canvas.stypeInt == 0 && focusCell != null && focusCell.x != -1 && LoadMap.TYPEMAP != 25) {
         if (this.n >= 8) {
            this.n = 0;
         }

         var1.drawImage(MapScr.d, (focusCell.x * LoadMap.w + LoadMap.w / 2) * AvMain.hd, (focusCell.y * LoadMap.w - 4 + this.n / 2) * AvMain.hd, 3);
         ++this.n;
      }

      if (LoadMap.TYPEMAP != 25) {
         Canvas.fontChatB.drawString(var1, this.nameFarm, (posName.x + 26) * AvMain.hd, (posName.y - 14) * AvMain.hd + (AvMain.hd - 1) * 7, 2);
      }

      Canvas.resetTrans(var1);
      LoadMap.paintEffectCamera(var1);
   }

   public static void a(Vector var0, Vector var1, Vector var2, Vector var3, byte var4, int var5, boolean var6) {
      itemSeed = var0;
      isNew = var6;
      levelStore = (byte)var4;
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
         setNameItem((Item) itemProduct.elementAt(var4));
      }

      listItemFarm = var2;
      listFarmProduct = var3;
   }

   private static void setNameItem(Item var0) {
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

   public static FarmItem getFarmItem(int var0) {
      for(int var1 = 0; var1 < FarmData.listItemFarm.size(); ++var1) {
         FarmItem var2;
         if ((var2 = (FarmItem)FarmData.listItemFarm.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void onBuyItem(Item var0, int var1, int var2, int var3) {
      GameMidlet.avatar.updateMoney(var1, var2, var3);
      PopupShop.isTransFocus = true;
      if (var0.ID >= 50 && var0.ID <= 100) {
         cell = null;
      }

      if (var0.number > 0) {
         Item var4;
         if (var0.ID >= 111) {
            if ((var4 = Item.getItemByList(listItemFarm, var0.ID)) != null) {
               var4.number += var0.number;
            } else {
               FarmItem var5 = getFarmItem(var0.ID);
               var0.name = var5.des;
               listItemFarm.addElement(var0);
            }
         } else {
            if (var0.ID <= 100 && var0.ID < 50) {
               if ((var4 = Item.getItemByList(itemSeed, var0.ID)) != null) {
                  var4.number += var0.number;
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
      numBarn = (byte)var4;
      numPond = (byte)var5;
      foodID = (short)var6;
      remainTime = var7;
      idFarm = var1;
      if (var1 != GameMidlet.avatar.IDDB) {
         Avatar var10;
         if ((var10 = ListScr.getAvatar(var1)) == null) {
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

      setAnimal();
      if (this.isJoin) {
         if (isReSize || LoadMap.TYPEMAP != 24 && LoadMap.TYPEMAP != 53) {
            isReSize = false;
            focusCell = new AvPosition();
            action = -1;
            this.timeLimit = 0;
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
               int var13 = posPond.x / 24;
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
               LoadMap.a(849, (int)(posPond.x + 12 + CRes.rnd(numTilePond - 2) * 24), (int)(posPond.y + 12 + CRes.rnd(3) * 24));
            } catch (Exception var9) {
               var9.printStackTrace();
            }

            listNest = new Vector();
            listBucket = new Vector();
            setChickNest(1, Chicken.s, (byte)87, -8, listNest);
            setChickNest(2, Cattle.posBucket, (byte)86, -7, listBucket);
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

         this.setCellAll();
         this.curTime = System.currentTimeMillis();
         this.curTimeCooking = System.currentTimeMillis();
         if (Canvas.currentMyScreen != this) {
            this.switchToMe();
         }

         if (Canvas.isInitChar) {
            Welcome.goFarm();
         }

         GameMidlet.avatar.xCur = GameMidlet.avatar.x;
         GameMidlet.avatar.yCur = GameMidlet.avatar.y;
      }

      this.isJoin = true;
      if (xRemember != -1) {
         GameMidlet.avatar.x = GameMidlet.avatar.xCur = xRemember;
         GameMidlet.avatar.y = GameMidlet.avatar.yCur = yRemember;
         xRemember = -1;
         yRemember = -1;
      }

      super.left = aP;
      super.right = null;
      super.center = null;
   }

   private static void setChickNest(int var0, AvPosition var1, byte var2, int var3, Vector var4) {
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

   public static void setAnimal() {
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

   public final void onPlantSeed(int var1, int var2) {
      if (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) {
         Item var3;
         if ((var3 = Item.getItemByList(itemSeed, var2)) != null) {
            CellFarm var4;
            (var4 = (CellFarm) cell.elementAt(var1)).idTree = var2;
            this.setStatusCell((CellFarm)var4, 4);
            LoadMap.map[var4.yCell * LoadMap.wMap + var4.xCell] = var4.status;
            var4.statusTree = 0;
            var4.isGrass = false;
            var4.isWorm = false;
            var4.time = 0;
            var4.tempTime = 0L;
            var4.vitalityPer = 100;
            var4.hervestPer = 0;
            --var3.number;
            if (var3.number <= 0) {
               itemSeed.removeElement(var3);
            }
         }

      }
   }

   public final void setInfoCell(int var1) {
      CellFarm var4;
      if ((var4 = (CellFarm) cell.elementAt(var1)).idTree == -1) {
         this.setStatusCell((CellFarm)var4, 2);
      } else {
         TreeInfo var2;
         int var3 = (var2 = FarmData.getTreeInfoByID(var4.idTree)).harvestTime * 60 / 5;
         var4.statusTree = var4.time / var3;
         if (var4.statusTree >= 5) {
            var4.statusTree = 5;
         }

         if (var4.time < 0 || var2.dieTime != -1 && var4.time - var2.harvestTime * 60 > var2.dieTime * 60 || var4.hervestPer == 100 || var4.statusTree < 0) {
            var4.statusTree = 6;
         }

         if (var4.isArid) {
            this.setStatusCell((CellFarm)var4, 3);
         } else {
            this.setStatusCell((CellFarm)var4, 4);
         }
      }

      LoadMap.map[var4.yCell * LoadMap.wMap + var4.xCell] = var4.status;
   }

   private void setStatusCell(CellFarm var1, int var2) {
      if (var1.level == 2) {
         var1.status = this.typeCell1[var2];
      } else {
         var1.status = this.typeCell[var2];
      }
   }

   public static void onHarvestTree(int var0, int var1) {
      CellFarm var3 = (CellFarm) cell.elementAt(var0);
      if (var1 > 0) {
         TreeInfo var2;
         if ((var2 = FarmData.getTreeByID(var3.idTree)).l) {
            Canvas.addFlyText(var1, var3.xCell * LoadMap.w + 11, var3.yCell * LoadMap.w, -1, 0, var2.idImg[var3.statusTree], -1);
         } else {
            ImageInfo var5 = FarmData.listImgInfo[var2.idImg[var3.statusTree]];
            Canvas.a(var1, var3.xCell * LoadMap.w + 11, var3.yCell * LoadMap.w, -1, CRes.createRGBImage(var5.x0 * AvMain.hd, var5.y0 * AvMain.hd, var5.w * AvMain.hd, var5.h * AvMain.hd, FarmData.imgBig[var5.bigID]), -1);
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
         if ((var6 = getItemProductByID(var4.j)) != null) {
            var6.number += var1;
         } else {
            (var6 = new Item()).ID = var4.j;
            var6.number = var1;
            var6.price[0] = var4.priceProduct;
            var6.name = var4.name;
            listFarmProduct.addElement(var6);
         }
      } else if ((var6 = Item.getItemByList(itemProduct, var4.ID)) != null) {
         var6.number += var1;
      } else {
         (var6 = new Item()).ID = var4.ID;
         var6.number = var1;
         var6.price[0] = FarmData.getTreeByID((int)var4.ID).priceProduct;
         var6.name = FarmData.getTreeByID((int)var4.ID).name;
         itemProduct.addElement(var6);
      }
   }

   public static void onHarvestAnimal(int var0, int var1) {
      Animal var6 = getAnimalByIndex(var0);
      if (var1 > 0 && var6 != null) {
         AnimalInfo var2;
         AnimalInfo var3 = var2 = FarmData.getAnimalByID(var6.species);
         Item var5;
         if ((var5 = Item.getItemByList(itemProduct, var3.species)) != null) {
            var5.number += var1;
         } else {
            (var5 = new Item()).ID = (short)var3.species;
            var5.number = var1;
            var5.name = var3.name;
            var5.price[0] = var3.priceProduct;
            setNameItem(var5);
            itemProduct.addElement(var5);
         }

         if (AvatarData.getImgIcon(var2.iconProduct) != null) {
            AvPosition var7 = null;
            if (var2.area == 1) {
               var7 = getPosO((Vector) listNest, var6.species);
            } else if (var2.area == 2) {
               var7 = getPosO((Vector) listBucket, var6.species);
            }

            if (var7 != null) {
               Canvas.a(var1, var7.x, var7.y - 25, -1, AvatarData.getImgIcon(var2.iconProduct).img, -1);
            }
         }

      }
   }

   private static AvPosition getPosO(Vector var0, int var1) {
      for(int var2 = 0; var2 < var0.size(); ++var2) {
         AvPosition var3;
         if ((var3 = (AvPosition)var0.elementAt(var2)).anchor == var1) {
            return var3;
         }
      }

      return null;
   }

   public static void onOpenLand(int var0, int var1, byte var2, String var3, int var4, int var5, int var6) {
      if (var0 == idFarm) {
         System.out.println("onOpenLand: " + var1 + "    " + var2);
         GameMidlet.avatar.updateMoney(var4, var5, var6);
         Canvas.startOKDlg(var3);
      }
   }

   public final void doJoinFarm(int var1, boolean var2) {
      this.isJoin = var2;
      FarmService.gI().doJoinFarm(var1);
   }

   public final void doSellProduct(int var1, String var2) {
      Canvas.startOKDlg(avt.T.bp + " " + var2 + "?", (IAction)(new IActionSellProduct(this, var1)));
   }

   public final void doOpenCuaHang() {
      Vector var1 = new Vector();

      int var2;
      for(var2 = 0; var2 < FarmData.treeInfo.length; ++var2) {
         CommandBuyItemCuaHang var4 = new CommandBuyItemCuaHang(this, avt.T.O, 7, FarmData.treeInfo[var2].ID, var2);
         var1.addElement(var4);
      }

      var2 = FarmData.listAnimalInfo.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         AnimalInfo var6 = (AnimalInfo)FarmData.listAnimalInfo.elementAt(var3);
         CommandBuyAnimalCuaHang var7 = new CommandBuyAnimalCuaHang(this, avt.T.O, 8, var3, var6, var3);
         var1.addElement(var7);
      }

      PopupShop.gI().switchToMe();
      PopupShop.gI().a(new String[]{avt.T.br, avt.T.bs, avt.T.aN}, new Vector[]{var1, this.goVatPham(), this.goKhoHang()}, (Vector)null);
      if (Canvas.isInitChar && !Welcome.g) {
         (Canvas.welcome = new Welcome()).a((MyScreen)PopupShop.me);
      }

   }

   private Vector goVatPham() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < FarmData.listItemFarm.size(); ++var2) {
         FarmItem var3;
         if ((var3 = (FarmItem)FarmData.listItemFarm.elementAt(var2)).isItem && (var3.priceLuong > 0 || var3.priceXu > 0)) {
            var1.addElement(new CommandGoVatPham(this, avt.T.O, 9, var2, var3, var2));
         }
      }

      return var1;
   }

   private Vector goKhoHang() {
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
         FarmItem var6 = getFarmItem((var7 = (Item) listFarmProduct.elementAt(var3)).ID);
         System.out.println("aaaaaaaaaa: " + var6 + "    " + var7.ID);
         var1.addElement(new CommandGoKhoHang2(this, "", 11, var3, var6, var3, var7));
      }

      return var1;
   }

   public final void doOpenKhoHang() {
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

         PopupShop.gI().switchToMe();
         PopupShop.gI().a(new String[]{avt.T.aN, avt.T.bu}, new Vector[]{this.goKhoHang(), var1}, (Vector)null);

         for(int var5 = 0; var5 < itemProduct.size(); ++var5) {
            itemProduct.elementAt(var5);
         }

      }
   }

   public final void f(int var1, int var2) {
      if (var2 != 3 && !PopupShop.h()) {
         PopupShop.g();
         if (Canvas.isInitChar) {
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
            if (var2 == 4 && (var8 = getFarmItem(var1)) != null) {
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
            this.doSellect();
            return;
         case 1:
            if (Canvas.welcome == null || Welcome.isPaintArrow) {
               MenuSub.gI().startAt(this.K, 0);
               return;
            }
            break;
         case 2:
            FarmScr var10 = this;
            Vector var11 = new Vector();
            Animal var3;
            AnimalInfo var4 = FarmData.getAnimalByID((var3 = getAnimalByIndex(((Base)LoadMap.focusObj).IDDB)).species);

            int var5;
            Item var6;
            FarmItem var7;
            for(var5 = 0; var5 < listItemFarm.size(); ++var5) {
               if ((var7 = getFarmItem((var6 = (Item) listItemFarm.elementAt(var5)).ID)).type == var4.area && var7.action == 5 && (var4.area == 4 || var4.area == 1)) {
                  int var8 = var6.number;
                  if (var4.area == 4) {
                     var8 -= listFood[1].size();
                  } else if (var4.area == 1) {
                     var8 -= listFood[0].size();
                  }

                  var11.addElement(new class_ff(var10, var7.des + "(" + var8 + ")", new class_er(var10, var6, var4), var7));
               }
            }

            for(var5 = 0; var5 < listItemFarm.size(); ++var5) {
               if ((var7 = getFarmItem((var6 = (Item) listItemFarm.elementAt(var5)).ID)).action != 5 && var7.type != 0 && (var7.type == var4.area || var7.type == 101 || var7.type == 100 && var4.area != 4) && (var7.action != 4 || var3.disease[0] || var3.disease[1]) && (var7.action != 6 || var3.health < 100)) {
                  var11.addElement(new class_fb(var10, var7.des + "(" + var6.number + ")", new class_fi(var10, var7, var6), var7));
               }
            }

            if (idFarm == GameMidlet.avatar.IDDB) {
               var11.addElement(new class_fd(var10, avt.T.bg, 2));
            }

            startMenuFarm(var11);
            return;
         case 3:
            this.doFeeding();
            return;
         case 4:
            this.r();
            return;
         case 5:
            super.left = aP;
            super.right = null;
            this.isSelectedCell = false;
            AvCamera.isFollow = false;
            this.isChamSoc = false;
            this.listSelectedCell.removeAllElements();

            for(var1 = 0; var1 < cell.size(); ++var1) {
               ((CellFarm) cell.elementAt(var1)).isSelected = false;
            }

            idSelected = -1;
            indexItem = -1;
            isSelected = false;
            return;
         case 6:
            this.doKhoGiong();
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
            isAutoVatNuoi = false;
            super.right = null;
            super.center = null;
            super.left = aP;
            this.indexAuto = 0;
            AvCamera.isFollow = false;
            return;
         case 9:
            ++this.indexAuto;
            this.commandActionPointer(10, -1);
            return;
         case 51:
            FarmService.gI().doOpenLand(idFarm, 1);
            this.curTime = System.currentTimeMillis();
            this.doJoinFarm(idFarm, true);
            return;
         case 52:
            FarmService.gI().doOpenLand(idFarm, 2);
            this.curTime = System.currentTimeMillis();
            this.doJoinFarm(idFarm, true);
            return;
         case 53:
            this.setAction((byte)0, (int)-1);
            Canvas.endDlg();
            return;
         case 54:
            this.doGoFarmWay();
      }

   }

   public final void a(AnimalInfo var1) {
      Canvas.a(var1.price[0], var1.price[1], new class_x(this, var1), new class_aj(this, var1), (IAction)null);
   }

   public static void onKick() {
      if (LoadMap.TYPEMAP == 24 || LoadMap.TYPEMAP == 53) {
         Canvas.menuMain = null;
         Canvas.startOK(avt.T.bv, 54, (AvMain)null);
      }

   }

   public static boolean doEat(short var0, int var1) {
      if (Item.getItemByList(listItemFarm, var0) == null) {
         return false;
      } else {
         FarmService.gI().doUsingItem(idFarm, var1, var0);
         return false;
      }
   }

   public final void doCattleFeeding(byte var1, byte var2) {
      Vector var6 = new Vector();

      for(int var3 = 0; var3 < listItemFarm.size(); ++var3) {
         Item var4;
         FarmItem var5;
         if (((var5 = getFarmItem((var4 = (Item) listItemFarm.elementAt(var3)).ID)).type == var1 || var5.type == 101) && var5.action == 5) {
            var6.addElement(new CommandThuoc(this, var5.des + "(" + var4.number + ")", new class_ak(this, var1, var4), var5));
         }
      }

      MenuSub.gI().startMenuFarm(var6, Canvas.hw, LoadMap.w * AvMain.hd, LoadMap.w * AvMain.hd);
   }

   private static void sendHarvestAnimal(Animal var0) {
      FarmService.gI().doHarvestAnimal(idFarm, var0.IDDB);
   }

   public final void doHarvestAnimal(int var1, int var2, Vector var3) {
      if (GameMidlet.avatar.IDDB == idFarm) {
         if (var2 >= 0 && var2 < var3.size()) {
            AvPosition var6 = (AvPosition)var3.elementAt(var2);

            for(int var7 = 0; var7 < animalLists.size(); ++var7) {
               Animal var4;
               AnimalInfo var5 = FarmData.getAnimalByID((var4 = (Animal) animalLists.elementAt(var7)).species);
               if (var4.numEggOne > 0 && var6.anchor == var4.species) {
                  var4.numEggOne = 0;
                  if (var1 == 1 && var5.area == var1) {
                     sendHarvestAnimal(var4);
                     removePopup(-50);
                  }

                  if (var1 == 2 && var5.area == var1) {
                     sendHarvestAnimal(var4);
                     removePopup(-51);
                  }
               }
            }

         }
      }
   }

   public final void onSell(int var1, int var2, short var3) {
      GameMidlet.avatar.money[0] = var2;
      PopupShop.isTransFocus = true;
      Canvas.startOKDlg(avt.T.bx + var1 + avt.T.T);
      Item var4;
      if ((var4 = Item.getItemByList(itemProduct, var3)) == null) {
         var4 = Item.getItemByList(listFarmProduct, var3);
         listFarmProduct.removeElement(var4);
      } else {
         itemProduct.removeElement(var4);
      }

      if (Canvas.currentMyScreen == PopupShop.gI()) {
         PopupShop.gI().close();
         if (LoadMap.TYPEMAP == 25) {
            this.doOpenCuaHang();
            PopupShop.gI().setTap(2);
         } else {
            this.doOpenKhoHang();
         }
      }

      Canvas.endDlg();
   }

   public static void onSellAnimal(int var0, int var1) {
      Animal var4;
      if ((var4 = getAnimalByIndex(var0)) != null) {
         int var2 = var1 - GameMidlet.avatar.money[0];
         LoadMap.focusObj = null;
         Image var3 = AvatarData.getImgIcon(FarmData.getAnimalByID(var4.species).idImg[var4.period]).img;
         Canvas.a(var2, var4.x, var4.y - 7, -1, CRes.createRGBImage(0, var4.indexFr * var4.height, var3.getWidth(), var4.height, var3), -1);
         animalLists.removeElement(var4);
         LoadMap.playerLists.removeElement(var4);
      }

      PopupShop.isTransFocus = true;
      GameMidlet.avatar.money[0] = var1;
   }

   public final void onPriceAnimal(byte var1, String var2) {
      Canvas.startOKDlg(var2, (IAction)(new IActionPriceAnimal(this, var1)));
   }

   public final void doGoFarmWay() {
      isSteal = false;
      isAbleSteal = false;
      Cattle.itemID = -1;
      Dog.itemID = -1;
      this.listHound = null;
      super.right = null;
      ParkService.gI().doJoinPark(25, 0);
   }

   public static Animal getAnimalByIndex(int var0) {
      for(int var1 = 0; var1 < animalLists.size(); ++var1) {
         Animal var2;
         if ((var2 = (Animal) animalLists.elementAt(var1)).IDDB == var0) {
            return var2;
         }
      }

      return null;
   }

   public final void doMenuStarFruit() {
      if (GameMidlet.avatar.IDDB == idFarm) {
         Vector var1 = new Vector();
         if (starFruil.numberFruit > 0) {
            var1.addElement(new CommandMenuStarFruit1(this, avt.T.eO + "(" + starFruil.numberFruit + ")", 12));
         }

         var1.addElement(new class_ap(this, starFruil.timeFinish > 0 ? avt.T.eN : avt.T.g, 13));
         var1.addElement(new class_am(this, avt.T.cw, 14));
         startMenuFarm(var1);
      }
   }

   private static void removePopup(int var0) {
      for(int var1 = 0; var1 < LoadMap.treeLists.size(); ++var1) {
         SubObject var2;
         if ((var2 = (SubObject)LoadMap.treeLists.elementAt(var1)).catagory == 8 && var2.type == var0) {
            LoadMap.treeLists.removeElement(var2);
            return;
         }
      }

   }

   public final void doOpenCooking() {
      if (idFarm == GameMidlet.avatar.IDDB) {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < FarmData.listFood.size(); ++var2) {
            Food var3 = (Food)FarmData.listFood.elementAt(var2);
            var1.addElement(new CommandCooking1(this, avt.T.m, new IActionCooking1(this, var3), var3, var2));
         }

         Vector var5 = new Vector();
         if (foodID > 0) {
            var5.addElement((Object)null);
            CommandCooking2 var6 = new CommandCooking2(this, remainTime == 0 ? avt.T.eL : avt.T.h, 2, this);
            var5.addElement(var6);
         }

         PopupShop.gI().switchToMe();
         PopupShop.gI().isHorizontal = true;
         if (foodID > 0) {
            PopupShop.gI().a(new String[]{avt.T.m, avt.T.dD}, new Vector[]{var1, null}, var5);
            PopupShop.gI().setCmdLeft(new Command(avt.T.cm, 0, this), 1);
            PopupShop.focusTap = 1;
            PopupShop.gI().setCmyLim();
            PopupShop.gI().setCaption();
         } else {
            PopupShop.gI().a(new String[]{avt.T.m}, new Vector[]{var1}, (Vector)null);
         }
      }
   }

   public static void onHarvestStarFruit(short var0, short var1) {
      for(int var2 = 0; var2 < starFruil.xFruit.length; ++var2) {
         Canvas.addFlyText(0, starFruil.x + starFruil.xFruit[var2], starFruil.y - 45 + starFruil.yFruit[var2], -1, 0, starFruil.fruitID, -1);
      }

      Canvas.a(var1, GameMidlet.avatar.x, GameMidlet.avatar.y - GameMidlet.avatar.height, -1, 10);
      starFruil.numberFruit = 0;
      Item var3;
      if ((var3 = getItemProductByID(var0)) != null) {
         var3.number += var1;
      } else {
         (var3 = new Item()).ID = var0;
         var3.number = var1;
         listFarmProduct.addElement(var3);
      }

      Canvas.endDlg();
   }

   public static Item getItemProductByID(int var0) {
      for(int var1 = 0; var1 < listFarmProduct.size(); ++var1) {
         Item var2;
         if ((var2 = (Item) listFarmProduct.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static Item getProductByID(int var0) {
      for(int var1 = 0; var1 < itemProduct.size(); ++var1) {
         Item var2;
         if ((var2 = (Item) itemProduct.elementAt(var1)).ID == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void doMenuFarmFriend() {
      ListScr.gI().setFriendList(true);
   }

   static void a(FarmScr var0, byte var1, int var2) {
      var0.setAction(var1, var2);
   }

   static void a(FarmScr var0, CellFarm var1) {
      if (var1.idTree != -1 && var1.statusTree < 6) {
         Canvas.b(avt.T.bh, 53);
      } else {
         var0.setAction((byte)0, (int)-1);
         Canvas.endDlg();
      }
   }

   static void a(FarmScr var0, int var1, int var2) {
      doPlantSeed(var1, var2);
   }

   static void a(FarmScr var0) {
      var0.setGieoHat();
   }

   static Vector getItemSeed() {
      return itemSeed;
   }

   static void a(FarmScr var0, FarmItem var1, short var2, Animal var3) {
      var0.setActionAnimal(var1, var2, var3);
   }
}

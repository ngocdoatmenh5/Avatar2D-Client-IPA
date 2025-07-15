package avt;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class LoadMap {
   public static int TYPEMAP = -1;
   public static Image imgBG;
   public static FrameImage imgMap;
   public static short[] map;
   public static short wMap;
   public static short Hmap;
   public static short[] type;
   public static byte[] bg = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 3, 3, 3, 3, 3, 2, -1, -1, -1, 0, 0, 0, 2, 2};
   public static int w = 24;
   public static byte status = 0;
   public static byte weather = -1;
   public static Vector treeLists = new Vector();
   public static Vector playerLists = new Vector();
   public static Vector dynamicLists = new Vector();
   public static Vector listImgAD;
   private static int star = 0;
   private AvPosition[] clound;
   private static Vector listStar = new Vector();
   private static int[] colorStar = new int[]{15853390, 15006199, 8183509, 12254198};
   public static MyObject focusObj;
   public static Command cmdNext;
   public static Image imgShadow;
   private static FrameImage imgFocus;
   private static int[] colorBg = new int[]{6143735, 21};
   public static int s;
   public static int rememMap = -1;
   private static int rememBg = -1;
   public static AvPosition posFocus;
   public static Vector effBgList;
   public static Vector effCameraList;
   public static Vector effManager;
   public static int idTileImg = -1;
   private static Bus bus = new Bus();
   private boolean R;
   public static boolean isGo;
   private static int S;
   private static int T;
   public static int A = -1;
   private static int wFocus = 3;
   public static int xDichChuyen_ = -1;
   public static int C = -1;
   private MyObject player;
   private MyObject obj;
   private MyObject dynamic;
   private int Y;
   private int Z;
   private int aa;
   private static int ab = 0;
   private static byte ac;
   public static int typeAny = 0;
   public static int typeTemp = -1;
   public static Vector mapItemType;
   public static Vector mapItem;
   public static int xDichChuyen = -1;
   public static int yDichChuyen = -1;

   public LoadMap() {
      cmdNext = new Command(avt.T.bz, new IActionNextFocus(this));
      star = CRes.rnd(3);
      w = 24;
      FilePack.b(avt.T.av);
      FilePack.getImage("den");
      imgShadow = FilePack.getImage("s0");
      if (Canvas.isKeyBoard) {
         if (Canvas.stypeInt == 0) {
            imgFocus = new FrameImage(FilePack.getImage("focus"), 21 * AvMain.hd, 15 * AvMain.hd);
         } else {
            imgFocus = new FrameImage(FilePack.getImage("focus"), 32 * AvMain.hd, 11 * AvMain.hd);
         }

         posFocus = new AvPosition();
      }

      FilePack.reset();
   }

   public final void updateKey() {
      if (PopupShop.gI() != Canvas.currentMyScreen && Canvas.isKeyBoard) {
         if (Canvas.currentDialog != null || Canvas.currentFace != null || Canvas.menuMain != null) {
            return;
         }

         if (Canvas.b(0, 0, Canvas.w, Canvas.h)) {
            int var2 = Canvas.dx();
            int var3 = Canvas.dy();
            if (Canvas.isPointerClick) {
               Canvas.isPointerClick = false;
               S = AvCamera.gI().xCam;
               T = AvCamera.gI().yCam;
               this.R = true;
            }

            if (this.R) {
               if (Canvas.isPointerDown && (CRes.abs(var2) > 20 || CRes.abs(var3) > 20)) {
                  AvCamera.gI().xTo = S + var2;
                  AvCamera.gI().yTo = T + var3;
                  AvCamera.gI().setToPos(AvCamera.gI().xTo + Canvas.hw, AvCamera.gI().yTo + Canvas.hh);
                  AvCamera.gI().timeDelay = System.currentTimeMillis() / 100L;
               }

               if (Canvas.isPointerRelease) {
                  Canvas.isPointerRelease = false;
                  this.R = false;
                  if (CRes.abs(var2) < 10 && CRes.abs(var3) < 10 && !MapScr.isWedding) {
                     posFocus.x = Canvas.px + AvCamera.gI().xCam;
                     posFocus.y = Canvas.py + AvCamera.gI().yCam;
                     if (posFocus.y < 0) {
                        posFocus.y = 0;
                     }

                     GameMidlet.avatar.posFocus = posFocus;
                     GameMidlet.avatar.l();
                  }
               }
            }
         }
      }
   }

   public final void update() {
      try {
         AvCamera.gI().update();
         if ((Canvas.stypeInt == 0 || Canvas.currentMyScreen != MainMenu.gI()) && playerLists.size() > 0) {
            for (int var1 = 0; var1 < playerLists.size(); var1++) {
               ((MyObject) playerLists.elementAt(var1)).update();
            }

            orderVector(playerLists);
         }

         if (dynamicLists.size() > 0) {
            orderVector(dynamicLists);

            for (int var8 = 0; var8 < dynamicLists.size(); var8++) {
               ((MyObject) dynamicLists.elementAt(var8)).update();
            }
         }

         if (treeLists.size() > 0) {
            for (int var9 = 0; var9 < treeLists.size(); var9++) {
               ((MyObject) treeLists.elementAt(var9)).update();
            }
         }

         LoadMap var2 = this;
         if (this.clound != null) {
            for (int var3 = 0; var3 < var2.clound.length; var3++) {
               var2.clound[var3].x--;
               if (var2.clound[var3].x < AvCamera.gI().xCam - 100) {
                  var2.clound[var3].x = AvCamera.gI().xCam + Canvas.w + 30 + CRes.rnd(10) * 50;
                  var2.clound[var3].y = -110 - CRes.rnd(6) * 10;
               }
            }
         }

         if (Canvas.gameTick % 4 == 2
                 && !FarmScr.isSelected
                 && (TYPEMAP != 24 || Canvas.stypeInt == 0)
                 && FarmScr.action == -1
                 && !FarmScr.isAutoVatNuoi
                 && RaceScr.me != Canvas.currentMyScreen
                 && TYPEMAP != -1
                 && Canvas.currentMyScreen != MainMenu.me
                 && Canvas.menuMain == null) {
            if (focusObj == null) {
               int var13 = 0;

               while (var13 < playerLists.size() && !i(var13)) {
                  var13++;
               }
            } else if (CRes.abs(focusObj.x - GameMidlet.avatar.x) / w >= (focusObj.catagory == 7 ? wFocus << 1 : wFocus) || CRes.abs(focusObj.y - GameMidlet.avatar.y) / w >= (focusObj.catagory == 7 ? wFocus << 1 : wFocus)) {
               focusObj = null;
               MapScr.focusP = null;
            }
         }

         if (Bus.isRun) {
            bus.update();
         }

         if (effManager != null) {
            for (int var10 = 0; var10 < effManager.size(); var10++) {
               EffectManager var14;
               if (AvatarData.getEffect((var14 = (EffectManager) effManager.elementAt(var10)).ID) != null) {
                  if (var14.style == 0) {
                     Avatar var15;
                     if ((var15 = getAvatar(var14.idPlayer)) == null) {
                        effManager.removeElement(var14);
                        continue;
                     }

                     var14.x = (short)var15.x;
                     var14.y = (short)var15.y;
                  }

                  if (var14.count == var14.loopLimit) {
                     var14.count = 0;
                     EffectObj var16;
                     (var16 = new EffectObj()).ID = var14.ID;
                     var16.idPlayer = var14.idPlayer;
                     var16.style = var14.style;
                     switch (var14.loopType) {
                        case 0:
                           var16.x = var14.x;
                           var16.y = var14.y;
                           break;
                        case 1:
                           int var4 = CRes.rnd(var14.radius);
                           int var5 = CRes.rnd(360);
                           int var6 = var4 * CRes.cos(CRes.fixangle(var5)) >> 10;
                           var4 = -(var4 * CRes.sin(CRes.fixangle(var5))) >> 10;
                           var16.x = var14.x;
                           var16.y = var14.y;
                           var16.dx = (short)var6;
                           var16.dy = (short)var4;
                           break;
                        case 2:
                           var16.x = var14.x;
                           var16.y = var14.y;
                           if (var14.style == 0) {
                              var16.dx = var14.xLoop[var14.indexPos];
                              var16.dy = var14.yLoop[var14.indexPos];
                           } else {
                              var16.x = var16.x + var14.xLoop[var14.indexPos];
                              var16.y = var16.y + var14.yLoop[var14.indexPos];
                           }
                     }

                     var14.indexLoop++;
                     var14.indexPos++;
                     if (var14.xLoop != null && var14.indexPos >= var14.xLoop.length) {
                        var14.indexPos = 0;
                     }

                     if (var14.loop != -1 && var14.indexLoop >= var14.loop) {
                        effManager.removeElement(var14);
                     }

                     switch (var14.style) {
                        case 0:
                           playerLists.addElement(var16);
                           playerLists = orderVector(playerLists);
                           break;
                        case 1:
                           treeLists.addElement(var16);
                           treeLists = orderVector(treeLists);
                           break;
                        case 2:
                           if (effBgList == null) {
                              effBgList = new Vector();
                           }

                           effBgList.addElement(var16);
                           break;
                        case 3:
                           if (effCameraList == null) {
                              effCameraList = new Vector();
                           }

                           effCameraList.addElement(var16);
                     }
                  }

                  var14.count++;
               }
            }
         }

         if (effBgList != null) {
            for (int var11 = 0; var11 < effBgList.size(); var11++) {
               ((EffectObj) effBgList.elementAt(var11)).update();
            }
         }

         if (effCameraList != null) {
            for (int var12 = 0; var12 < effCameraList.size(); var12++) {
               ((EffectObj) effCameraList.elementAt(var12)).update();
            }
         }

         if (imgFocus != null && A != -1 && GameMidlet.avatar.au > 0) {
            posFocus.anchor++;
            if (posFocus.anchor >= 10) {
               posFocus.anchor = 0;
            }
         }

         if (++ab >= 6) {
            ab = 0;
            return;
         }
      } catch (Exception var7) {
      }
   }

   public static void c() {
      if (focusObj != null) {
         isGo = false;
         int var0 = 0;
         int var1 = playerLists.size();

         for (int var2 = 0; var2 < var1; var2++) {
            MyObject var3;
            if ((var3 = (MyObject) playerLists.elementAt(var2)).catagory != 4 && var3 == focusObj) {
               var0 = var2;
               break;
            }
         }

         focusObj = null;
         int var4 = var0 + 1;

         while (var4 < var1 && !i(var4)) {
            var4++;
         }

         if (focusObj == null) {
            var4 = 0;

            while (var4 <= var0 && !i(var4)) {
               var4++;
            }
         }
      }
   }

   private static boolean i(int var0) {
      MyObject var1;
      if ((var1 = (MyObject) playerLists.elementAt(var0)).catagory != 4
              && var1 != GameMidlet.avatar
              && var1.catagory != 6
              && Math.abs(var1.x - GameMidlet.avatar.x) / w < (var1.catagory == 7 ? wFocus << 1 : wFocus)
              && Math.abs(var1.y - GameMidlet.avatar.y) / w < (var1.catagory == 7 ? wFocus << 1 : wFocus)) {
         if (var1.catagory != 0 || !((Avatar)var1).ableShow) {
            focusObj = var1;
         }

         if (var1.catagory == 0 && !((Avatar)var1).ableShow) {
            MapScr.focusP = (Avatar) playerLists.elementAt(var0);
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean setTypeJoint(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == -1
              || var0 == 108
              || var0 == 109
              || var0 == 57
              || var0 == 62
              || var0 == 0
              || var0 == 1
              || var0 == 2
              || var0 == 3
              || var0 == 4
              || var0 == 5
              || var0 == 6
              || var0 == 7
              || var0 == 8
              || var0 == 12
              || var0 == 11
              || var0 == 14
              || var0 == 15
              || var0 == 16
              || var0 == 13
              || var0 == 25
              || var0 == 24
              || var0 == 52
              || var0 == 53
              || var0 == 9
              || var0 == 58
              || var0 == 63
              || var0 == 59
              || var0 == 64
              || var0 == 56
              || var0 == 21
              || var0 == 68
              || var0 == 69
              || var0 == 70
              || var0 == 17
              || var0 == 18
              || var0 == 51
              || var0 == 71
              || var0 == 95
              || var0 == 96
              || var0 == 107
              || var0 == 10
              || var0 == 19;
   }

   public static boolean setTypeFind(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == 55
              || var0 == 93
              || var0 == 78
              || var0 == 89
              || var0 == 27
              || var0 == 28
              || var0 == 29
              || var0 == 84
              || var0 == 85
              || var0 == 86
              || var0 == 83
              || var0 == 87
              || var0 == 54
              || var0 == 67
              || var0 == 81
              || var0 == 71
              || var0 == 79
              || var0 == 92
              || var0 == 52
              || var0 == 94
              || var0 == 95
              || var0 == 96
              || var0 == 97
              || var0 == 98
              || var0 == 100
              || var0 == 103
              || var0 == 101
              || var0 == 104
              || var0 == 23;
   }

   public static boolean setTypeFindEnd(int var0) {
      return var0 >= -125 && var0 < 0
              ? true
              : var0 == 55
              || var0 == 93
              || var0 == 78
              || var0 == 89
              || var0 == 27
              || var0 == 28
              || var0 == 29
              || var0 == 84
              || var0 == 85
              || var0 == 86
              || var0 == 83
              || var0 == 87
              || var0 == 54
              || var0 == 71
              || var0 == 52
              || var0 == 94
              || var0 == 95
              || var0 == 96
              || var0 == 97
              || var0 == 98
              || var0 == 100
              || var0 == 103
              || var0 == 101
              || var0 == 104
              || var0 == 23;
   }

   private void f() {
      Canvas.startOKDlg(avt.T.P, new IActionExitToCity(this));
   }

   public final boolean doJoin(int var1, int var2) {
      isGo = false;
      int var3 = getTypeMap(var1, var2);
      if ((Canvas.welcome == null || Welcome.isJoinMapScr(var3)) && var3 != -2) {
         switch (var3) {
            case -1:
               MapScr.gI().move();
               if (TYPEMAP == 25) {
                  FarmScr.gI();
               }

               if (imgBG != null) {
                  bus.setBus((byte)-1);
               } else {
                  MapScr.gI().doExit();
               }
               break;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 16:
            case 18:
               MapScr.gI().move();
               ParkService.gI().doJoinPark(var3, -1);
               break;
            case 9:
               this.f();
               break;
            case 10:
               Canvas.startWaitDlg();
               MapScr.gI().move();
               rememMap = -1;
               ParkService.gI().doJoinPark(10, -1);
               break;
            case 12:
               this.f();
               break;
            case 17:
               this.f();
               break;
            case 19:
               Canvas.startWaitDlg();
               MapScr.gI().move();
               rememMap = -1;
               ParkService.gI().doJoinPark(19, -1);
               break;
            case 20:
               GlobalService.gI().requestJoinAny((short)0);
               Canvas.startWaitDlg();
               break;
            case 21:
               HouseScr.gI().doOut();
               break;
            case 22:
            case 26:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 60:
            case 61:
            case 65:
            case 66:
            case 67:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 79:
            case 80:
            case 81:
            case 82:
            case 88:
            case 90:
            case 91:
            case 92:
            case 99:
            case 102:
            case 105:
            case 106:
            default:
               if (var3 >= -125 && var3 < 0) {
                  Canvas.startWaitDlg();
                  typeTemp = var3;
                  GlobalService.gI().requestJoinAny((short)(var3 - -125));
                  break;
               }

               if (!GameMidlet.avatar.M && var2 / w == 0 && var3 == 88) {
                  if (MapScr.s) {
                     GameMidlet.avatar.M = true;
                  } else {
                     ParkService var15 = ParkService.gI();
                     if (!MapScr.r) {
                        MapScr.r = true;
                        var15.createMessage((byte)92);
                        var15.sendMessage();
                     }
                  }
               }

               return false;
            case 23:
               GlobalService.gI().getHandler(9);
               Canvas.startWaitDlg();
               break;
            case 24:
               if (FarmScr.cell != null && FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                  FarmScr.gI().onJoin(FarmScr.idFarm, FarmScr.cell, FarmScr.animalLists, FarmScr.numBarn, FarmScr.numPond, FarmScr.foodID, FarmScr.remainTime);
               } else {
                  Canvas.startWaitDlg();
                  FarmScr.gI().doJoinFarm(GameMidlet.avatar.IDDB, true);
               }
               break;
            case 25:
               FarmScr.gI().doGoFarmWay();
               break;
            case 27:
            case 56:
               if (TYPEMAP != 18 && TYPEMAP != 109 && TYPEMAP != 108) {
                  MapScr.gI().commandAction();
               }
               break;
            case 28:
               FarmScr.gI().doOpenKhoHang();
               break;
            case 29:
               Canvas.startWaitDlg();
               ParkService.gI().doRequestBoardList(MapScr.roomID);
               break;
            case 52:
               FarmScr.gI().doOpenCuaHang();
               break;
            case 53:
               FarmScr.gI();
               FarmScr.doMenuFarmFriend();
               break;
            case 54:
               return FishingScr.gI().doSat(var1, var2);
            case 55:
               Canvas.startWaitDlg();
               GlobalService var14;
               (var14 = GlobalService.gI()).createMessage((byte)-23);
               var14.sendMessage();
               break;
            case 57:
               MapScr.gI().move();
               MapScr.gI().doJoinShop((byte)1);
               break;
            case 58:
               MapScr.gI().doJoinShop((byte)2);
               break;
            case 59:
               MapScr.gI().doJoinShop((byte)3);
               break;
            case 62:
               MapScr.gI().move();
               MapScr.gI().doJoinShop((byte)6);
               break;
            case 63:
               MapScr.gI().doJoinShop((byte)7);
               break;
            case 64:
               MapScr.gI().doJoinShop((byte)8);
               break;
            case 68:
            case 69:
            case 70:
               MapScr.gI();
               MapScr.g(var3 - 67);
               break;
            case 71:
               Canvas.startWaitDlg();
               GlobalService.gI().requestCityMap((byte)-1);
               break;
            case 78:
               MapScr.gI().doOpenIceDream(avt.T.cN, 5);
               break;
            case 83:
               int var10001 = var1 / w;
               var3 = var2 / w;
               var2 = var10001;
               LoadMap var13 = Canvas.loadMap;
               if (AvatarData.listAd != null) {
                  for (int var4 = 0; var4 < AvatarData.listAd.size(); var4++) {
                     ObjAd var5 = (ObjAd)AvatarData.listAd.elementAt(var4);

                     for (int var6 = 0; var6 < var5.listPoint.size(); var6++) {
                        AvPosition var7;
                        if ((var7 = (AvPosition)var5.listPoint.elementAt(var6)).x == var2 && var7.y == var3 && TYPEMAP + 1 == var7.anchor) {
                           Vector var19;
                           (var19 = new Vector()).addElement(new Command(avt.T.z, new IActionAd(var13, var5)));
                           var19.addElement(new Command(avt.T.d, new class_hv(var13)));
                           Canvas.setInfoC(var5.text, var19);
                           return true;
                        }
                     }
                  }
               }
               break;
            case 84:
               FarmScr.gI().doCattleFeeding((byte)2, (byte)5);
               break;
            case 85:
               FarmScr.gI().doCattleFeeding((byte)3, (byte)5);
               break;
            case 86:
               var1 = getposMap(var1, var2);
               var2 = getposMap(Cattle.posBucket.x, Cattle.posBucket.y);
               FarmScr.gI().doHarvestAnimal(2, var1 - var2, FarmScr.listBucket);
               break;
            case 87:
               var1 = getposMap(var1, var2);
               var2 = getposMap(Chicken.s.x, Chicken.s.y);
               FarmScr.gI().doHarvestAnimal(1, var1 - var2, FarmScr.listNest);
               break;
            case 89:
               byte var10;
               if (TYPEMAP == 108 || TYPEMAP == 109) {
                  var10 = 1;
               } else if (TYPEMAP == 13) {
                  var10 = 2;
               } else {
                  var10 = 3;
               }

               GlobalService.gI().doCommunicate(var10);
               Canvas.startWaitDlg();
               break;
            case 93:
               MapScr.gI().doOpenIceDream(avt.T.cN, 4);
               break;
            case 94:
               GlobalService.gI().doCommunicate(4);
               Canvas.startWaitDlg();
               break;
            case 95:
               Canvas.startWaitDlg();
               FarmScr.xRemember = GameMidlet.avatar.x;
               FarmScr.yRemember = GameMidlet.avatar.y;
               FarmService.gI().doUpdateFarm(0, 0);
               break;
            case 96:
               Canvas.startWaitDlg();
               FarmScr.xRemember = GameMidlet.avatar.x;
               FarmScr.yRemember = GameMidlet.avatar.y;
               FarmService.gI().doUpdateFish(0, 0);
               break;
            case 97:
               FarmScr.gI().doMenuStarFruit();
               break;
            case 98:
               FarmScr.gI().doOpenCooking();
               break;
            case 100:
               MapScr.gI();
               MapScr.doJoinMapOffline(5);
               break;
            case 101:
               MapScr.gI();
               MapScr.doJoinMapOffline(6);
               break;
            case 103:
               MapScr.gI();
               MapScr.doJoinMapOffline(3);
               break;
            case 104:
               MapScr.gI();
               MapScr.doJoinMapOffline(4);
               break;
            case 107:
               Canvas.startWaitDlg();
               MapScr.indexMap = TYPEMAP;
               GlobalService.gI().getHandler(12);
               break;
            case 108:
            case 109:
               xDichChuyen_ = GameMidlet.avatar.x;
               C = GameMidlet.avatar.y;
               Canvas.startWaitDlg();
               MapScr.A = 1;
               MapScr.z = 0;
               GlobalService.gI().requestJoinAny((short)4);
               break;
            case 110:
               Canvas.startWaitDlg();
               AvatarService.gI().doJoinHouse4(GameMidlet.avatar.IDDB);
               break;
            case 111:
               Canvas.startWaitDlg();
               GlobalService var9;
               (var9 = GlobalService.gI()).createMessage((byte)-105);
               var9.sendMessage();
               break;
            case 112:
               if (GameMidlet.avatar.action != 14) {
                  HouseScr.gI().g = GameMidlet.avatar.y;
                  if ((var1 = var1 / w * w + w / 2 + 1) < GameMidlet.avatar.x) {
                     HouseScr.gI().f = var1 + w;
                  } else {
                     HouseScr.gI().f = var1 - w;
                  }

                  GameMidlet.avatar.setPos(var1, var2 / w * w + 5);
                  MapScr.gI();
                  MapScr.doMove(GameMidlet.avatar.x, GameMidlet.avatar.y, GameMidlet.avatar.direct, GameMidlet.avatar.timeTask);
                  GameMidlet.avatar.doAction((byte)14);
                  AvatarService.gI().doFeel(14);
               }
         }

         return true;
      } else {
         return false;
      }
   }

   public static void paintEffectCamera(Graphics var0) {
      if (effCameraList != null) {
         for (int var1 = 0; var1 < effCameraList.size(); var1++) {
            ((EffectObj) effCameraList.elementAt(var1)).paint(var0);
         }
      }
   }

   public final void paint(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.resetTrans(var1);
      var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
      this.paintM(var1);
   }

   public final void paintM(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      if (imgBG == null) {
         var1.setColor(1);
         var1.fillRect(AvCamera.gI().xCam, AvCamera.gI().yCam, Canvas.w, Canvas.h);
      } else {
         var1.setColor(s);
         var1.fillRect(AvCamera.gI().xCam, AvCamera.gI().yCam, Canvas.w, Canvas.h);
         int var4 = AvCamera.gI().xCam * 30 / 210;
         int var5 = (AvCamera.gI().xCam - var4) / (96 * AvMain.hd);
         int var6 = -(94 - w + w / 2) * AvMain.hd;
         if (TYPEMAP == 107) {
            var6 += 41 * AvMain.hd;
         }

         for (int var7 = var5; var7 <= var5 + Canvas.w / (96 * AvMain.hd) + 1; var7++) {
            var3.drawImage(imgBG, var4 + var7 * 96 * AvMain.hd, var6, 0);
         }

         if (listImgAD != null) {
            for (int var8 = 0; var8 < listImgAD.size(); var8++) {
               AvPosition var9 = (AvPosition) listImgAD.elementAt(var8);
               int var15 = AvCamera.gI().xCam * (30 + var9.depth * 3) / 210;
               AvatarData.paintImg(var3, var9.anchor, var9.x + var15, var9.y, 33);
            }
         }

         int var16;
         if ((var16 = listStar.size()) > 0) {
            for (int var18 = 0; var18 < var16; var18++) {
               AvPosition var23 = (AvPosition) listStar.elementAt(var18);
               var3.setColor(colorStar[var23.anchor]);
               var3.fillRect(var23.x + var4, var23.y, 1, 1);
            }
         }

         if (this.clound != null) {
            for (int var19 = 0; var19 < var2.clound.length; var19++) {
               var3.drawImage(MiniMap.imgClound[0], var2.clound[var19].x, var2.clound[var19].y, 0);
            }
         }

         if (Canvas.currentEffect.size() > 0) {
            for (int var20 = 0; var20 < Canvas.currentEffect.size(); var20++) {
               Canvas.currentEffect.elementAt(var20);
            }
         }

         if (effBgList != null) {
            for (int var21 = 0; var21 < effBgList.size(); var21++) {
               ((EffectObj) effBgList.elementAt(var21)).paint(var3);
            }
         }

         if (Canvas.w > wMap * w) {
            var3.setColor(0);
            var3.fillRect(AvCamera.gI().xCam, AvCamera.gI().yCam, -AvCamera.gI().xCam, Canvas.h);
            var3.fillRect(wMap * w * AvMain.hd, AvCamera.gI().yCam, -AvCamera.gI().xCam, Canvas.h);
         }
      }

      Graphics var10 = var1;
      int var12;
      if ((var12 = (AvCamera.gI().xCam + Canvas.w) / w + 1) > wMap) {
         var12 = wMap;
      }

      int var13;
      if ((var13 = (AvCamera.gI().yCam + Canvas.h) / w + 1) > Hmap) {
         var13 = Hmap;
      }

      int var14;
      if ((var14 = AvCamera.gI().xCam / (w * AvMain.hd)) < 0) {
         var14 = 0;
      }

      for (int var24 = 0; var24 < var13; var24++) {
         for (int var11 = var14; var11 < var12; var11++) {
            short var17;
            if ((var17 = map[var24 * wMap + var11]) != -1) {
               int var22 = var17 / imgMap.nFrame;
               imgMap.drawFrameXY(var22, var17 % imgMap.nFrame, var11 * w * AvMain.hd, var24 * w * AvMain.hd, var10);
            }
         }
      }

      if (imgFocus != null && A != -1 && GameMidlet.avatar.au > 0) {
         imgFocus.drawFrame(posFocus.anchor / 2, posFocus.x, posFocus.y, A, 3, var1);
      }
   }

   public final void paintBackGround(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      this.Y = 0;
      this.Z = 0;
      this.aa = 0;

      while (var2.Y < playerLists.size() || var2.Z < treeLists.size() || var2.aa < dynamicLists.size()) {
         var2.player = var2.obj = var2.dynamic = null;
         if (var2.Y < playerLists.size()) {
            var2.player = (MyObject) playerLists.elementAt(var2.Y);
         }

         if (var2.Z < treeLists.size()) {
            var2.obj = (MyObject) treeLists.elementAt(var2.Z);
         }

         if (var2.aa < dynamicLists.size()) {
            var2.dynamic = (Point) dynamicLists.elementAt(var2.aa);
         }

         if (var2.player == null || var2.obj != null && var2.player.y >= var2.obj.y || var2.dynamic != null && var2.player.y >= var2.dynamic.y) {
            if (var2.obj == null || var2.dynamic != null && var2.obj.y >= var2.dynamic.y) {
               if (var2.dynamic != null) {
                  var2.dynamic.paint(var3);
                  var2.aa++;
               }
            } else {
               var2.obj.paint(var3);
               var2.Z++;
            }
         } else {
            var2.player.paint(var3);
            var2.Y++;
         }
      }

      if (Canvas.stypeInt == 0 && focusObj != null) {
         var1.drawImage(MapScr.imgFocusP, focusObj.x * AvMain.hd, (focusObj.y - (focusObj.catagory == 7 ? 10 : focusObj.height)) * AvMain.hd - ab / 2, 3);
      }

      if (Bus.isRun) {
         bus.paint(var1);
      }
   }

   private static void setStar() {
      listStar.removeAllElements();
      if (status != 0 && star != 0 && weather == -1) {
         if (TYPEMAP != 9 && TYPEMAP != 12) {
            int var2 = CRes.rnd(Canvas.w / 10);

            for (int var3 = 0; var3 < var2; var3++) {
               listStar.addElement(new AvPosition(CRes.rnd(wMap * w), -(38 + CRes.rnd(Canvas.hh)), CRes.rnd(4)));
            }
         } else {
            int var0 = CRes.rnd(Canvas.w / 10);

            for (int var1 = 0; var1 < var0; var1++) {
               listStar.addElement(new AvPosition(CRes.rnd(wMap * w), -(98 + CRes.rnd(Canvas.hh)), CRes.rnd(4)));
            }
         }
      }
   }

   public static InputStream loadDataMap(int var0) {
      FilePack.instance = new FilePack("/a.clazz");
      String var3 = "" + var0;
      byte[] var4 = FilePack.instance.loadData(var3);
      ByteArrayInputStream var1 = null;
      if (var4 != null) {
         try {
            var1 = new ByteArrayInputStream(var4);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

      return var1;
   }

   public final void load(int var1) {
      if (Session_ME.gI().isConnected()) {
         Canvas.load = 0;
         Canvas.endDlg();
      }

      if (Canvas.welcome != null) {
         Canvas.welcome = null;
      }

      Canvas.instance.setSize();
      GameMidlet.avatar.au = 0;
      idTileImg = -1;
      cmdNext.caption = avt.T.bz;
      Canvas.currentEffect.removeAllElements();
      GameMidlet.avatar.ableShow = false;
      Bus.isRun = false;
      AvCamera.disable = false;
      GameMidlet.avatar.setAction((byte)0);
      resetObject();
      MapScr.listFish.removeAllElements();
      focusObj = null;
      MapScr.focusP = null;
      int var2;
      if ((var2 = Calendar.getInstance().get(11)) < 18 && var2 >= 6) {
         status = 0;
      } else {
         status = 1;
      }

      s = colorBg[status];
      if ((var2 = var1 - 1) == 107 || var2 >= 0 && var2 < bg.length && bg[var2] != -1) {
         if (var2 == 107 || rememBg != bg[var2] || rememMap != status) {
            byte var3;
            if (var2 == 107) {
               var3 = 0;
            } else {
               var3 = bg[var2];
            }

            rememBg = var3;
            FilePack.b(avt.T.as);
            Image var4 = FilePack.getImage(String.valueOf(var3) + status);
            Image var10 = FilePack.getImage(String.valueOf(status));
            Graphics var14 = (imgBG = Image.createImage(96 * AvMain.hd, 96 * AvMain.hd)).getGraphics();
            PaintPopup.fill(0, 0, 96 * AvMain.hd, 10 * AvMain.hd, colorBg[status], var14);
            var14.drawImage(var10, 0, 69 * AvMain.hd, 36);
            var14.drawImage(var4, 0, 96 * AvMain.hd, 36);
            FilePack.reset();
         }
      } else {
         rememBg = -1;
         imgBG = null;
      }

      if (rememMap != status || imgMap == null) {
         if (var1 - 1 == 19) {
            try {
               rememMap = -1;
               imgMap = new FrameImage(Image.createImage(avt.T.getPath() + "/wedding.png"), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         } else if (var1 - 1 != 107) {
            w = 24;
            rememMap = status;
            InputStream var11 = CRes.getResourceAsStream(avt.T.getPath() + "/data/h" + status);
            InputStream var15 = CRes.getResourceAsStream(avt.T.getPath() + "/data/data");

            try {
               byte[] var16 = new byte[var11.available()];
               var11.read(var16);
               byte[] var12 = new byte[var15.available()];
               var15.read(var12);
               imgMap = new FrameImage(CRes.createImage(var16, var12), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var6) {
               var6.printStackTrace();
            }
         } else {
            try {
               w = 12;
               rememMap = -1;
               imgMap = new FrameImage(Image.createImage(avt.T.getPath() + "/tileDuaXe.png"), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var5) {
               var5.printStackTrace();
            }
         }
      }

      InputStream var13;
      if ((var13 = loadDataMap(var1)) != null) {
         Hmap = 8;
         switch (var1 - 1) {
            case 9:
               Hmap = 8;
               break;
            case 10:
               Hmap = 9;
            case 11:
            case 13:
            case 24:
            default:
               break;
            case 17:
               Hmap = 6;
               break;
            case 18:
               Hmap = 10;
               break;
            case 19:
               Hmap = 13;
               break;
            case 20:
            case 57:
            case 58:
            case 59:
            case 62:
            case 63:
            case 64:
            case 100:
            case 101:
            case 103:
            case 104:
            case 109:
               Hmap = 11;
               break;
            case 21:
               Hmap = 7;
               break;
            case 25:
               Hmap = 7;
               break;
            case 60:
            case 61:
            case 65:
               Hmap = 5;
               break;
            case 107:
               Hmap = 16;
               break;
            case 108:
               Hmap = 8;
         }
      }

      this.setMap(var13, var1, true);
      TYPEMAP = var1 - 1;
      System.out.println("index: " + TYPEMAP);
      if (weather != -1 && TYPEMAP < bg.length && bg[TYPEMAP] != -1) {
         AnimateEffect var8 = new AnimateEffect(weather, 0);
         Canvas.currentEffect.addElement(var8);
      }

      this.setClound();
      setStar();
      if (Session_ME.gI().isConnected() && GameMidlet.avatar.seriPart != null) {
         addPlayer(GameMidlet.avatar);
      }

      if (Canvas.load == 0) {
         Canvas.load = 1;
      }

      System.gc();
   }

   public final void setMap(InputStream inputStream, int n, boolean bl) {
      int n2;
      short s;
      block170: {
         s = 0;
         byte by = 0;
         byte by2 = 0;
         byte by3 = 0;
         byte by4 = 0;
         byte by5 = 0;
         byte by6 = 0;
         byte by7 = 0;
         int n3 = 0;
         int n4 = 0;
         int n5 = 0;
         byte by8 = 0;
         byte by9 = 0;
         byte by10 = 0;
         int n6 = 0;
         int n7 = 0;
         int n8 = 0;
         int n9 = 0;
         int n10 = 0;
         int n11 = 0;
         int n12 = 0;
         byte by11 = 0;
         byte by12 = 0;
         byte by13 = 0;
         int n13 = 0;
         byte by14 = 0;
         int n14 = 0;
         int n15 = 0;
         int n16 = 0;
         int n17 = 0;
         byte by15 = 0;
         int n18 = 0;
         byte by16 = 0;
         byte by17 = 0;
         int n19 = 0;
         int n20 = 0;
         int n21 = 0;
         int n22 = 0;
         int n23 = 0;
         int avatar = 0;
         int n24 = 0;
         ac = 0;
         byte[] byArray = new byte[13];
         try {
            if (inputStream != null) {
               wMap = (short)(inputStream.available() / Hmap);
               map = new short[Hmap * wMap];
            }
            if (bl) {
               type = new short[Hmap * wMap];
            }
            avatar = 0;
            while (avatar < Hmap * wMap) {
               if (inputStream != null) {
                  LoadMap.map[avatar] = (short)inputStream.read();
                  if (map[avatar] == 255) {
                     LoadMap.map[avatar] = -1;
                  }
               }
               ++avatar;
            }
            if (n - 1 == 19) {
               MapScr.listChair = new Vector();
               avatar = 0;
               while (avatar < map.length) {
                  LoadMap.type[avatar] = (short) (map[avatar] < 32 ? 80 : 88);
                  if (map[avatar] == 65) {
                     LoadMap.type[avatar] = 10;
                     LoadMap.map[avatar] = 1;
                     if (avatar == 1) {
                        LoadMap.map[avatar] = 16;
                        GameMidlet.avatar.x = GameMidlet.avatar.xCur = LoadMap.x(avatar) + w;
                        GameMidlet.avatar.y = GameMidlet.avatar.yCur = LoadMap.y(avatar) + 12;
                        LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + 12);
                     }
                     avatar = (byte)(avatar + 1);
                  } else if (map[avatar] == 27) {
                     AvPosition myObject = new AvPosition();
                     new AvPosition().x = LoadMap.x(avatar);
                     myObject.y = LoadMap.y(avatar);
                     myObject.index = (short)((5 - MapScr.listChair.size() % 6 << 1) + MapScr.listChair.size() / 6);
                     MapScr.listChair.addElement(myObject);
                  }
                  ++avatar;
               }
               Avatar exception2 = new Avatar();
               new Avatar().x = exception2.xCur = 26 * w;
               exception2.y = exception2.yCur = 8 * w + w / 2;
               exception2.name = "chu hon";
               exception2.IDDB = -100;
               exception2.addSeri(new SeriPart((short) 2480));
               exception2.direct = exception2.dirLast = Base.LEFT;
               playerLists.addElement(exception2);
               break block170;
            }
            if (n - 1 == 107) {
               avatar = 0;
               while (avatar < Hmap * wMap) {
                  MyObject n27;
                  if (map[avatar] == 61 && CRes.rnd(2) == 1) {
                     Avatar var62 = new Avatar();
                     Avatar var53 = (Avatar)RaceScr.gI().p.elementAt(CRes.rnd(RaceScr.gI().p.size()));
                     var62.seriPart = var53.seriPart;
                     var62.x = var62.xCur = x(avatar) + 12;
                     var62.y = var62.yCur = y(avatar) + 12;
                     var62.action = 2;
                     var62.catagory = 9;
                     playerLists.addElement(var62);
                  }
                  if (map[avatar] == 59) {
                     n27 = new ImageObj(1084, LoadMap.x(avatar) + w, LoadMap.y(avatar), 0);
                     treeLists.addElement(n27);
                  } else if (map[avatar] == 60) {
                     n27 = new ImageObj(1085, LoadMap.x(avatar) + w, LoadMap.y(avatar), 0);
                     treeLists.addElement(n27);
                  }
                  ++avatar;
               }
               break block170;
            }
            avatar = 0;
            while (avatar < Hmap * wMap) {
               block173: {
                  block171: {
                     block172: {
                        if (map[avatar] == -4) break block171;
                        if (map[avatar] != -5) break block172;
                        LoadMap.type[avatar] = 88;
                        break block173;
                     }
                     if (map[avatar] == -3 || map[avatar] == -6) break block173;
                     LoadMap.type[avatar] = map[avatar] >= 120 && map[avatar] <= 123 ? 80 : (short) (map[avatar] >= 114 && map[avatar] <= 119 ? 80 : (map[avatar] == 67 || map[avatar] == 85 ? 92 : (map[avatar] >= 20 && map[avatar] <= 23 ? 79 : (map[avatar] < 7 ? 80 : 88))));
                     if (map[avatar] >= 44 && map[avatar] <= 55) {
                        LoadMap.type[avatar] = 80;
                     }
                     if (map[avatar] == 62 && n - 1 != 62 && n - 1 != 101 && n - 1 != 104 && n - 1 != 103 && n - 1 != 100 && n - 1 != 101) {
                        LoadMap.type[avatar] = 56;
                     }
                     if (map[avatar] != 111 && map[avatar] != 112) break block173;
                  }
                  LoadMap.type[avatar] = 80;
               }
               if (inputStream != null || GameMidlet.CLIENT_TYPE != 11) {
                  switch (map[avatar]) {
                     case -1: {
                        LoadMap.type[avatar] = 88;
                        break;
                     }
                     case 24:
                     case 25:
                     case 26: {
                        if (!bl) break;
                        LoadMap.addObjTree(845, LoadMap.x(avatar) + 11, LoadMap.y(avatar));
                        break;
                     }
                     case 27: {
                        if (!bl) break;
                        LoadMap.addObjTree(844, LoadMap.x(avatar) + 11, LoadMap.y(avatar) + 1);
                        break;
                     }
                     case 28: {
                        if (!bl) break;
                        if (!Session_ME.gI().isConnected()) {
                           LoadMap.map[avatar] = 4;
                           break;
                        }
                        LoadMap.addObjTree(0, LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w - 2);
                        break;
                     }
                     case 127: {
                        if (by15 == 0) {
                           LoadMap.addObjTree(830, LoadMap.x(avatar) + 36, LoadMap.y(avatar) + w - 2);
                           byte by18 = by15;
                           by15 = (byte)(by18 + 1);
                           LoadMap.setPopup(avatar, by18, 2);
                        }
                        LoadMap.setTypeMap(avatar, (byte)108, 96);
                        break;
                     }
                     case 128: {
                        if (s == 0) {
                           LoadMap.addObjTree(828, avatar);
                           byte by19 = (byte) s;
                           s = (byte)(by19 + 1);
                           LoadMap.setPopup(avatar, by19, 2);
                        }
                        LoadMap.setTypeMap(avatar, (byte)55, 5);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 129:
                     case 160: {
                        if (by == 0) {
                           if (n - 1 == 17) {
                              LoadMap.addObjTree(836, avatar);
                           } else {
                              LoadMap.addObjTree(829, avatar);
                           }
                           byte by20 = by;
                           by = (byte)(by20 + 1);
                           LoadMap.setPopup(avatar, by20, 2);
                        }
                        LoadMap.setTypeMap(avatar, map[avatar] == 129 ? (byte)57 : 62, 96);
                        break;
                     }
                     case 130:
                     case 131:
                     case 132:
                     case 133:
                     case 134:
                     case 135:
                     case 136:
                     case 137:
                     case 138: {
                        int n30;
                        int n25 = n30 = map[avatar] - 130;
                        byte by21 = byArray[n25];
                        byArray[n25] = (byte)(by21 + 1);
                        LoadMap.setPopup(avatar, by21, 0);
                        LoadMap.setTypePark(avatar, (byte)n30);
                        break;
                     }
                     case 153: {
                        if (by14 == 0) {
                           byte by22 = by14;
                           by14 = (byte)(by22 + 1);
                           LoadMap.setPopup(avatar, by22, 0);
                        }
                        LoadMap.setTypePark(avatar, (byte)11);
                        break;
                     }
                     case 139: {
                        LoadMap.type[avatar] = -1;
                        byte by23 = by13;
                        by13 = (byte)(by23 + 1);
                        LoadMap.setPopup(avatar, by23, 0);
                        if (TYPEMAP == -1 && n != 21 && imgBG != null) {
                           Bus.posBusStop = new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) - w / 2);
                           bus.setBus((byte)1);
                        }
                        LoadMap.setMapPaint(avatar, map);
                        break;
                     }
                     case 140: {
                        byte by24 = by12;
                        by12 = (byte)(by24 + 1);
                        LoadMap.setPopup(avatar, by24, 0);
                        LoadMap.setTypeMap(avatar, (byte)25, 55);
                        by12 = (byte)(by12 + 1);
                        break;
                     }
                     case 141: {
                        if (by3 == 0) {
                           LoadMap.addObjTree(840, avatar);
                           byte by25 = by3;
                           by3 = (byte)(by25 + 1);
                           LoadMap.setPopup(avatar, by25, 0);
                        }
                        LoadMap.setTypeMap(avatar, (byte)24, 5);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 142: {
                        LoadMap.setTypeMap(avatar, (byte)80, 7);
                        FarmScr.gI().posTree[n5] = new AvPosition(avatar % wMap, avatar / wMap, 0);
                        n5 = (byte)(n5 + 1);
                        break;
                     }
                     case 143: {
                        if (by2 == 0) {
                           LoadMap.addObjTree(831, avatar);
                           byte by26 = by2;
                           by2 = (byte)(by26 + 1);
                           LoadMap.setPopup(avatar, by26, 2);
                        }
                        LoadMap.setTypeMap(avatar, (byte)52, 51);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 144: {
                        if (by4 == 0) {
                           LoadMap.addObjTree(841, avatar);
                           byte by27 = by4;
                           by4 = (byte)(by27 + 1);
                           LoadMap.setPopup(avatar, by27, 2);
                        }
                        LoadMap.setTypeMap(avatar, (byte)53, 5);
                        break;
                     }
                     case 145: {
                        byte by28 = ac;
                        ac = (byte)(by28 + 1);
                        LoadMap.setPopup(avatar, by28, 0);
                        if (n - 1 == 109 || n - 1 == 57 && TYPEMAP == 17) {
                           LoadMap.setTypeMap(avatar, (byte)17, -1);
                           break;
                        }
                        if (TYPEMAP == 23) {
                           LoadMap.setTypeMap(avatar, (byte)23, -1);
                           break;
                        }
                        LoadMap.setTypeMap(avatar, (byte)9, -1);
                        if (n - 1 != 100) break;
                        LoadMap.map[avatar] = 47;
                        break;
                     }
                     case 147:
                     case 161: {
                        if (by5 == 0) {
                           LoadMap.addObjTree(832, avatar);
                           byte by29 = by5;
                           by5 = (byte)(by29 + 1);
                           LoadMap.setPopup(avatar, by29, 2);
                        }
                        LoadMap.setTypeMap(avatar, map[avatar] == 147 ? (byte)58 : 63, 96);
                        break;
                     }
                     case 148:
                     case 162: {
                        if (by6 == 0) {
                           if (n == 18) {
                              LoadMap.addObjTree(836, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + w - 2);
                           } else {
                              LoadMap.addObjTree(833, LoadMap.x(avatar) + 48, LoadMap.y(avatar) + w - 2);
                           }
                           byte by30 = by6;
                           by6 = (byte)(by30 + 1);
                           LoadMap.setPopup(avatar, by30, 2);
                        }
                        LoadMap.setTypeMap(avatar, map[avatar] == 148 ? (byte)59 : 64, 96);
                        break;
                     }
                     case 149: {
                        if (by7 == 0) {
                           LoadMap.addObjTree(834, avatar);
                           if (GameMidlet.avatar.IDDB == FarmScr.idFarm) {
                              LoadMap.setPopup(avatar, by7, 2);
                           }
                           by7 = (byte)(by7 + 1);
                        }
                        LoadMap.setTypeMap(avatar, (byte)28, 4);
                        break;
                     }
                     case 150: {
                        if (n17 == 0) {
                           LoadMap.addObjTree(842, avatar);
                        }
                        LoadMap.setTypeMap(avatar, (byte)93, 0);
                        if (n == 26) {
                           LoadMap.map[avatar] = 4;
                        }
                        n17 = (byte)(n17 + 1);
                        break;
                     }
                     case 151: {
                        if (n18 == 0) {
                           LoadMap.addObjTree(843, avatar);
                        }
                        LoadMap.setTypeMap(avatar, (byte)78, 0);
                        n18 = (byte)(n18 + 1);
                        break;
                     }
                     case 152: {
                        if (n3 == 0) {
                           LoadMap.addObjTree(835, avatar);
                        }
                        LoadMap.setTypeMap(avatar, (byte)81, n - 1 == 25 ? 55 : 0);
                        n3 = (byte)(n3 + 1);
                        break;
                     }
                     case 155: {
                        LoadMap.setTypeMap(avatar, (byte)80, 55);
                        if (Cattle.numPig <= 0) break;
                        LoadMap.setTypeMap(avatar, (byte)84, 112);
                        LoadMap.addObjTree(-5, LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        Cattle.posPigTr = new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        break;
                     }
                     case 156: {
                        LoadMap.setTypeMap(avatar, (byte)80, 5);
                        if (Dog.numBer <= 0) break;
                        LoadMap.setTypeMap(avatar, (byte)85, 5);
                        LoadMap.addObjTree(-6, LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        Dog.posDosTr = new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        break;
                     }
                     case 157: {
                        LoadMap.setTypeMap(avatar, (byte)80, 111);
                        Cattle.posBucket = new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        break;
                     }
                     case 158: {
                        LoadMap.setTypeMap(avatar, (byte)80, 5);
                        if (Chicken.numChicken <= 0) break;
                        Chicken.s = new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        break;
                     }
                     case 159: {
                        int avPosition = 4;
                        if (n - 1 == 25) {
                           avPosition = 5;
                        } else if (n - 1 == 108 || n - 1 == 109) {
                           avPosition = 47;
                        } else if (n - 1 == 13) {
                           avPosition = 0;
                        }
                        LoadMap.setTypeMap(avatar, (byte)89, avPosition);
                        LoadMap.addObjTree(848, avatar);
                        break;
                     }
                     case 163: {
                        byte by31 = ac;
                        ac = (byte)(by31 + 1);
                        LoadMap.setPopup(avatar, by31, 0);
                        LoadMap.setTypeMap(avatar, (byte)12, -1);
                        break;
                     }
                     case 164: {
                        LoadMap.setPopup(avatar, byArray[9], 0);
                        byArray[9] = (byte)(byArray[9] + 1);
                        LoadMap.setTypeMap(avatar, (byte)13, 6);
                        break;
                     }
                     case 165: {
                        LoadMap.setPopup(avatar, byArray[10], 0);
                        LoadMap.setTypeMap(avatar, (byte)14, 0);
                        byArray[10] = (byte)(byArray[10] + 1);
                        break;
                     }
                     case 166: {
                        LoadMap.setPopup(avatar, byArray[11], 0);
                        LoadMap.setTypeMap(avatar, (byte)15, 0);
                        byArray[11] = (byte)(byArray[11] + 1);
                        break;
                     }
                     case 167: {
                        LoadMap.setPopup(avatar, byArray[12], 0);
                        byArray[12] = (byte)(byArray[12] + 1);
                        LoadMap.setTypeMap(avatar, (byte)16, 43);
                        break;
                     }
                     case 172: {
                        LoadMap.setTypeMap(avatar, (byte)88, 96);
                        if (n14 % 3 == 0) {
                           LoadMap.addObjTree(836, LoadMap.x(avatar) + 37, LoadMap.y(avatar) + w);
                        }
                        n14 = (byte)(n14 + 1);
                        break;
                     }
                     case 173: {
                        LoadMap.setTypeMap(avatar, (byte)88, 96);
                        if (n15 % 4 == 0) {
                           LoadMap.addObjTree(837, LoadMap.x(avatar) + 48, LoadMap.y(avatar) + w);
                        }
                        n15 = (byte)(n15 + 1);
                        break;
                     }
                     case 174: {
                        LoadMap.setTypeMap(avatar, (byte)88, 96);
                        if (n16 % 4 == 0) {
                           LoadMap.addObjTree(838, LoadMap.x(avatar) + 48, LoadMap.y(avatar) + w);
                        }
                        n16 = (byte)(n16 + 1);
                        break;
                     }
                     case 175: {
                        byte by32 = by8;
                        by8 = (byte)(by32 + 1);
                        LoadMap.setPopup(avatar, by32, 0);
                        LoadMap.setTypeMap(avatar, (byte)68, 96);
                        break;
                     }
                     case 176: {
                        byte by33 = by9;
                        by9 = (byte)(by33 + 1);
                        LoadMap.setPopup(avatar, by33, 0);
                        LoadMap.setTypeMap(avatar, (byte)69, 96);
                        break;
                     }
                     case 177: {
                        byte by34 = by10;
                        by10 = (byte)(by34 + 1);
                        LoadMap.setPopup(avatar, by34, 0);
                        LoadMap.setTypeMap(avatar, (byte)70, 96);
                        break;
                     }
                     case 178: {
                        if (by15 == 0) {
                           LoadMap.addObjTree(830, LoadMap.x(avatar) + w, LoadMap.y(avatar) + w - 2);
                           byte by35 = by15;
                           by15 = (byte)(by35 + 1);
                           LoadMap.setPopup(avatar, by35, 2);
                        }
                        LoadMap.setTypeMap(avatar, (byte)109, 96);
                        break;
                     }
                     case 179: {
                        if (by10 == 0) {
                           byte by36 = by10;
                           by10 = (byte)(by36 + 1);
                           LoadMap.setPopup(avatar, by36, 2);
                           LoadMap.addObjTree(837, avatar);
                        }
                        LoadMap.setTypeMap(avatar, (byte)18, 96);
                        break;
                     }
                     case 180: {
                        byte by37 = by10;
                        by10 = (byte)(by37 + 1);
                        LoadMap.setPopup(avatar, by37, 0);
                        LoadMap.setTypeMap(avatar, (byte)17, 77);
                        if (n - 1 != 101) break;
                        LoadMap.map[avatar] = 0;
                        break;
                     }
                     case 181: {
                        if (n - 1 == 101 || n - 1 == 104 || n - 1 == 103 || n - 1 == 100 || n - 1 == 101) break;
                        if (by16 == 0) {
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w / 2);
                        }
                        by16 = (byte)(by16 + 1);
                        LoadMap.setTypeMap(avatar, (byte)56, 46);
                        break;
                     }
                     case 182: {
                        FarmScr.posBarn = new AvPosition(LoadMap.x(avatar), LoadMap.y(avatar));
                        LoadMap.setTypeMap(avatar, (byte)80, 39);
                        break;
                     }
                     case 183: {
                        FarmScr.posPond = new AvPosition(LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                        LoadMap.setTypeMap(avatar, (byte)88, 13);
                        break;
                     }
                     case 184: {
                        break;
                     }
                     case 185: {
                        if (by17 == 1 && n == 18) {
                           LoadMap.addObjTree(975, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                        }
                        if (n == 18) {
                           LoadMap.setTypeMap(avatar, (byte)71, 43);
                           if (by17 == 2) {
                              LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar), LoadMap.y(avatar) + 25);
                           }
                        } else {
                           byte by38 = by17;
                           by17 = (byte)(by38 + 1);
                           LoadMap.setPopup(avatar, by38, 0);
                           LoadMap.setTypeMap(avatar, (byte)71, 47);
                        }
                        by17 = (byte)(by17 + 1);
                        break;
                     }
                     case 186: {
                        byte by39 = (byte)(n19 + 1);
                        n19 = by39;
                        if (by39 == 3) {
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar), LoadMap.y(avatar) + 24);
                        }
                        LoadMap.setTypeMap(avatar, (byte)94, 17);
                        if (n19 != 2) break;
                        LoadMap.addObjTree(974, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                        break;
                     }
                     case 187: {
                        if (n20 == 0 && FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                           treeLists.addElement(new SubObject(-10, LoadMap.x(avatar) + 20, LoadMap.y(avatar) + 20, FarmScr.imgBuyLant.getWidth()));
                        }
                        n20 = (byte)(n20 + 1);
                        LoadMap.setTypeMap(avatar, FarmScr.idFarm == GameMidlet.avatar.IDDB ? (byte)95 : 80, 4);
                        break;
                     }
                     case 188: {
                        if (FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                           treeLists.addElement(new SubObject(-10, LoadMap.x(avatar) + 20, LoadMap.y(avatar) + 20, FarmScr.imgBuyLant.getWidth()));
                        }
                        LoadMap.setTypeMap(avatar, FarmScr.idFarm == GameMidlet.avatar.IDDB ? (byte)96 : 80, 4);
                        break;
                     }
                     case 189: {
                        FarmScr.starFruil.x = LoadMap.x(avatar) + 12;
                        FarmScr.starFruil.y = LoadMap.y(avatar) + 12;
                        if (GameMidlet.avatar.IDDB == FarmScr.idFarm) {
                           LoadMap.type[avatar] = 97;
                        }
                        LoadMap.map[avatar] = 4;
                        treeLists.addElement(FarmScr.starFruil);
                        if (GameMidlet.avatar.IDDB == FarmScr.idFarm) break;
                        break;
                     }
                     case 190: {
                        LoadMap.type[avatar] = 98;
                        LoadMap.map[avatar] = 4;
                        if (n21 == 0) {
                           LoadMap.addObjTree(1029, LoadMap.x(avatar) + 36, LoadMap.y(avatar) + 20);
                           FarmScr.xPosCook = LoadMap.x(avatar) + 26;
                           FarmScr.yPosCook = LoadMap.y(avatar) + 10;
                           if (FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                              LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 36, LoadMap.y(avatar) + 24);
                           }
                        }
                        n21 = (byte)(n21 + 1);
                        break;
                     }
                     case 191: {
                        LoadMap.type[avatar] = 23;
                        if (n - 1 == 104) {
                           LoadMap.map[avatar] = 0;
                           if (n6 == 1) {
                              LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 12, LoadMap.y(avatar) + 12);
                           }
                        } else {
                           LoadMap.map[avatar] = (short) (n6 % 2 == 0 ? 46 : 44);
                           if (n6 == 1) {
                              LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 12);
                           }
                        }
                        n6 = (byte)(n6 + 1);
                        break;
                     }
                     case 192: {
                        LoadMap.type[avatar] = 99;
                        LoadMap.map[avatar] = 4;
                        if (n11 == 0) {
                           LoadMap.addObjTree(1034, LoadMap.x(avatar) + 36, LoadMap.y(avatar) + 24);
                        }
                        n11 = (byte)(n11 + 1);
                        break;
                     }
                     case 193: {
                        LoadMap.type[avatar] = 100;
                        LoadMap.map[avatar] = 4;
                        if (n10 == 1) {
                           LoadMap.addObjTree(1032, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n10 = (byte)(n10 + 1);
                        break;
                     }
                     case 194: {
                        LoadMap.type[avatar] = 106;
                        LoadMap.map[avatar] = 4;
                        if (n12 == 0) {
                           LoadMap.addObjTree(1030, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                        }
                        n12 = (byte)(n12 + 1);
                        break;
                     }
                     case 195: {
                        LoadMap.type[avatar] = 102;
                        LoadMap.map[avatar] = 4;
                        if (n8 == 1) {
                           LoadMap.addObjTree(1037, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                        }
                        n8 = (byte)(n8 + 1);
                        break;
                     }
                     case 196: {
                        LoadMap.type[avatar] = 103;
                        LoadMap.map[avatar] = 4;
                        if (n7 == 1) {
                           LoadMap.addObjTree(1035, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n7 = (byte)(n7 + 1);
                        break;
                     }
                     case 197: {
                        LoadMap.type[avatar] = 104;
                        LoadMap.map[avatar] = 4;
                        if (n9 == 1) {
                           LoadMap.addObjTree(1033, LoadMap.x(avatar) + 12, LoadMap.y(avatar) + 24);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n9 = (byte)(n9 + 1);
                        break;
                     }
                     case 198: {
                        LoadMap.type[avatar] = 105;
                        LoadMap.map[avatar] = 4;
                        LoadMap.addObjTree(1036, LoadMap.x(avatar) + 12, LoadMap.y(avatar) + 20);
                        break;
                     }
                     case 199: {
                        LoadMap.type[avatar] = 101;
                        LoadMap.map[avatar] = 4;
                        if (n4 == 1) {
                           LoadMap.addObjTree(1031, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n4 = (byte)(n4 + 1);
                        break;
                     }
                     case 200: {
                        LoadMap.type[avatar] = 107;
                        if (n22 == 1) {
                           LoadMap.addObjTree(1075, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 24);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n22 = (byte)(n22 + 1);
                        LoadMap.map[avatar] = 5;
                        break;
                     }
                     case 201: {
                        LoadMap.type[avatar] = 19;
                        LoadMap.map[avatar] = 5;
                        if (n23 == 1) {
                           LoadMap.addObjTree(1094, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 20);
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 24, LoadMap.y(avatar) + 30);
                        }
                        n23 = (byte)(n23 + 1);
                        break;
                     }
                     case 202: {
                        LoadMap.setTypeMap(avatar, (byte)88, 96);
                        if (n24 % 4 == 0) {
                           LoadMap.addObjTree(4, LoadMap.x(avatar) + (w << 1), LoadMap.y(avatar) + w);
                        }
                        n24 = (byte)(n24 + 1);
                        break;
                     }
                     case 203: {
                        byte by40 = by16;
                        by16 = (byte)(by40 + 1);
                        LoadMap.setPopup(avatar, by40, 0);
                        LoadMap.setTypeMap(avatar, (byte)110, 96);
                        break;
                     }
                     case 204: {
                        LoadMap.map[avatar] = 43;
                        LoadMap.type[avatar] = 10;
                        if (n23 == 1) {
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar), LoadMap.y(avatar) + 30);
                        }
                        n23 = (byte)(n23 + 1);
                        break;
                     }
                     case 63:
                     case 65: {
                        if (n - 1 == 101 || n - 1 == 104 || n - 1 == 103 || n - 1 == 100 || n - 1 == 101) break;
                        LoadMap.type[avatar] = 56;
                        byte by41 = by11;
                        by11 = (byte)(by41 + 1);
                        LoadMap.setPopup(avatar, by41, 0);
                        if (n - 1 == 57 || n - 1 == 62) {
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) - 12, LoadMap.y(avatar) + 12);
                           break;
                        }
                        if (n - 1 == 58 || n - 1 == 63) {
                           LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) + 12, LoadMap.y(avatar) + 36);
                           break;
                        }
                        LoadMap.addPopup(avt.T.aq, LoadMap.x(avatar) - 12, LoadMap.y(avatar) + 12);
                        break;
                     }
                     case 97: {
                        LoadMap.type[avatar] = 54;
                        break;
                     }
                     case 98: {
                        LoadMap.type[avatar] = 29;
                        LoadMap.addObjTree(846, avatar);
                        if (n - 1 != 108 && n - 1 != 109) break;
                        LoadMap.map[avatar] = 56;
                        break;
                     }
                     case 102: {
                        LoadMap.type[avatar] = 92;
                        BoardScr.listPosAvatar.addElement(new AvPosition(LoadMap.x(avatar) + w / 2, LoadMap.y(avatar) + w));
                        AvPosition avPosition = new AvPosition(-20, LoadMap.y(avatar) + w);
                        if (n13 % 2 == (n == 66 ? 0 : 1)) {
                           avPosition.x = (Canvas.w + 20) / AvMain.hd;
                        }
                        BoardScr.listPosCasino.addElement(avPosition);
                        n13 = (byte)(n13 + 1);
                        break;
                     }
                     case 110: {
                        FarmScr.posName = new AvPosition(LoadMap.x(avatar) - w + 8, LoadMap.y(avatar) - 2);
                        LoadMap.addObjTree(847, LoadMap.x(avatar) + 11, LoadMap.y(avatar));
                        break;
                     }
                     default: {
                        by17 = 0;
                        by13 = 0;
                     }
                  }
               }
               ++avatar;
            }
         }
         catch (Exception exception) {
            Exception n25 = exception;
            exception.printStackTrace();
         }
      }
      LoadMap.setMapItem(n);
      LoadMap.orderVector(treeLists);
      if (TYPEMAP == 24 && FarmScr.idFarm != GameMidlet.avatar.IDDB) {
         TYPEMAP = 53;
      }
      if ((n2 = TYPEMAP) != -1 && idTileImg != -1) {
         n2 = typeAny;
      }
      if (n - 1 != 19) {
         int n26 = 0;
         while (n26 < type.length) {
            int n27 = n26 / wMap;
            int n31 = n26 % wMap;
            s = (short)n2;
            if (type[n27 * wMap + n31] == s) {
               AvPosition avPosition = LoadMap.setPosPlayer(n26);
               if (avPosition == null) break;
               GameMidlet.avatar.x = avPosition.x;
               GameMidlet.avatar.y = avPosition.y;
               break;
            }
            ++n26;
         }
      }
      if (n == 60) {
         GameMidlet.avatar.x = 150;
         GameMidlet.avatar.y = Hmap * w - w;
      }
      if (typeTemp != -1) {
         typeAny = typeTemp;
      }
      AvCamera.gI().followPlayer = GameMidlet.avatar;
      AvCamera.gI().init(n);
      if (Canvas.isKeyBoard) {
         GameMidlet.avatar.createAvatarArrays();
      }
   }

   private static AvPosition setPosPlayer(int var0) {
      if (var0 + 1 < type.length && type[var0] == type[var0 + 1]) {
         for (int var3 = var0; var3 < type.length; var3++) {
            if (type[var3] != type[var3 + 1]) {
               int var4 = w;
               if (var0 / wMap == Hmap - 1) {
                  var4 = -w;
               }

               return new AvPosition(x(var0) + (var3 - var0 + 1) * w / 2, y(var0) + w / 2 + var4);
            }
         }
      } else if (var0 + wMap < type.length && type[var0] == type[var0 + wMap]) {
         for (int var1 = var0; var1 < type.length; var1 += wMap) {
            if (type[var1] != type[var1 + wMap]) {
               int var2 = -w;
               if (var0 % wMap == 0) {
                  var2 = w;
               }

               return new AvPosition(x(var0) + w / 2 + var2, y(var0) + ((var1 - var0) / wMap + 1) * w / 2);
            }
         }
      }

      return null;
   }

   public static void addObjTree(int var0, int var1, int var2) {
      if (idTileImg == -1) {
         Object var3;
         if (var0 > 0) {
            var3 = new ImageObj(var0, var1, var2, 0);
         } else {
            var3 = new SubObject(var0, var1, var2, 0);
         }

         treeLists.addElement(var3);
      }
   }

   private static void addObjTree(int var0, int var1) {
      if (idTileImg == -1) {
         ImageObj var2 = new ImageObj(var0, x(var1) + getWTileImg(var1, map), y(var1) + w - 4, 0);
         treeLists.addElement(var2);
      }
   }

   private static int x(int var0) {
      return var0 % wMap * w;
   }

   private static int y(int var0) {
      return var0 / wMap * w;
   }

   private static void setTypeMap(int var0, byte var1, int var2) {
      type[var0] = var1;
      map[var0] = (short)var2;
   }

   private static void setTypePark(int var0, byte var1) {
      type[var0] = var1;
      if (var0 / wMap == 0) {
         map[var0] = 43;
      } else {
         map[var0] = 6;
      }
   }

   public static void setType(int var0, int var1, byte var2) {
      type[var1 * wMap + var0] = 51;
   }

   private static void addPopup(String var0, int var1, int var2) {
      if (Session_ME.gI().connected) {
         treeLists.addElement(new PopupName(var0, var1, var2));
      }
   }

   public static MapItemType getMapItemTypeByID(int var0) {
      int var1 = mapItemType.size();

      for (int var2 = 0; var2 < var1; var2++) {
         MapItemType var3;
         if ((var3 = (MapItemType) mapItemType.elementAt(var2)).idType == var0) {
            return var3;
         }
      }

      return null;
   }

   public static void setMapItemType() {
      if (mapItem != null && mapItemType != null) {
         for (int var0 = 0; var0 < mapItem.size(); var0++) {
            MapItem var1;
            MapItemType var2 = getMapItemTypeByID((var1 = (MapItem) mapItem.elementAt(var0)).typeID);
            setTypeSeat(var1, var2);
            MapItem var3;
            (var3 = new MapItem(var1.type, var1.x * w, var1.y * w, var1.ID, var1.typeID)).isGetImg = var1.isGetImg;
            treeLists.addElement(var3);
         }

         orderVector(treeLists);
      }
   }

   private static void setMapItem(int var0) {
      for (int var1 = 0; var1 < AvatarData.listMapItem.size(); var1++) {
         MapItem var2;
         if ((var2 = (MapItem)AvatarData.listMapItem.elementAt(var1)).type == var0) {
            MapItemType var3 = AvatarData.getMapItemTypeByID((int) var2.typeID);
            setTypeSeat(var2, var3);
            treeLists.addElement(new MapItem(var2.type, var2.x * w, var2.y * w, var2.ID, var2.typeID));
         }
      }

      if (AvatarData.listAd != null) {
         for (int var5 = 0; var5 < AvatarData.listAd.size(); var5++) {
            ObjAd var6 = (ObjAd)AvatarData.listAd.elementAt(var5);

            for (int var7 = 0; var7 < var6.listPoint.size(); var7++) {
               AvPosition var4;
               if ((var4 = (AvPosition)var6.listPoint.elementAt(var7)).anchor == var0) {
                  if (var4.y * wMap + var4.x >= 0 && var4.y * wMap + var4.x < type.length) {
                     type[var4.y * wMap + var4.x] = 83;
                  }

                  addPopup(var6.title, var4.x * w + w / 2, var4.y * w + w / 2);
               }
            }
         }
      }
   }

   private void setClound() {
      this.clound = null;
      if (status != 1) {
         this.clound = new AvPosition[4];

         for (int var1 = 0; var1 < this.clound.length; var1++) {
            int var2 = AvCamera.gI().xCam + CRes.rnd(Canvas.w / 20 + 5) * 20;
            int var3 = -110 - CRes.rnd(3) * 10;
            this.clound[var1] = new AvPosition(var2, var3);
         }

         CRes.c();
      }
   }

   public static Vector orderVector(Vector var0) {
      try {
         int var1 = var0.size();

         for (int var2 = 0; var2 < var1 - 1; var2++) {
            MyObject var3 = (MyObject)var0.elementAt(var2);

            for (int var4 = var2 + 1; var4 < var1; var4++) {
               MyObject var5 = (MyObject)var0.elementAt(var4);
               if (var3.y > var5.y) {
                  var0.setElementAt(var3, var4);
                  var0.setElementAt(var5, var2);
                  var3 = var5;
               }
            }
         }
      } catch (Exception var6) {
      }

      return var0;
   }

   private static void resetObject() {
      Canvas.currentEffect.removeAllElements();
      treeLists.removeAllElements();
      playerLists.removeAllElements();
      dynamicLists.removeAllElements();
      effBgList = null;
      effCameraList = null;
      effManager = null;
      System.gc();
   }

   public static boolean isTrans(int var0, int var1) {
      int var2;
      return (var2 = getTypeMap(var0, var1)) != 80 && var2 != 51 ? GameMidlet.avatar.task == -5 && (var2 == 79 || var2 == 81 || var2 == 92 || var2 == 67) : true;
   }

   public static int getTypeMap(int var0, int var1) {
      short var2;
      return var0 >= 0 && var0 <= wMap * w && var1 / w * wMap + var0 / w >= 0 && var1 / w * wMap + var0 / w < type.length ? (var2 = type[var1 / w * wMap + var0 / w]) : -2;
   }

   public static int getposMap(int var0, int var1) {
      return var0 >= 0 && var0 <= wMap * w && var1 / w * wMap + var0 / w < type.length ? var1 / w * wMap + var0 / w : -1;
   }

   public static Avatar getAvatar(int var0) {
      for (int var1 = 0; var1 < playerLists.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject) playerLists.elementAt(var1)).catagory == 0 && ((Base)var2).IDDB == var0) {
            return (Avatar)var2;
         }
      }

      return null;
   }

   public static void onWeather(byte var0) {
      for (int var1 = 0; var1 < Canvas.currentEffect.size(); var1++) {
         ((Effect) Canvas.currentEffect.elementAt(var1)).isStop = true;
      }

      if (var0 != -1) {
         AnimateEffect var3 = new AnimateEffect(var0, 0);
         Canvas.currentEffect.addElement(var3);
      }

      weather = var0;
   }

   public static void setPet(Avatar var0) {
      if (var0.idPet != -1) {
         Pet var1 = new Pet(var0);
         playerLists.addElement(var1);
      }
   }

   public static Pet getPet(int var0) {
      for (int var1 = 0; var1 < playerLists.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject) playerLists.elementAt(var1)).catagory == 4 && ((Pet)var2).follow.IDDB == var0) {
            return (Pet)var2;
         }
      }

      return null;
   }

   public static void addPlayer(Avatar var0) {
      playerLists.addElement(var0);
      var0.setPet();
   }

   public static void removePlayer(Avatar var0) {
      playerLists.removeElement(var0);
      Pet var1;
      if ((var1 = getPet(var0.IDDB)) != null) {
         playerLists.removeElement(var1);
      }
   }

   public static void removePlayer(MyObject var0) {
      if (focusObj == var0) {
         focusObj = null;
      }

      playerLists.removeElement(var0);
   }

   public final void onTileImg(byte var1, byte[] var2) {
      idTileImg = var1;
      imgMap = new FrameImage(CRes.createImage(var2), w * AvMain.hd, AvMain.hd * w);
      this.setMapAny();
      Canvas.load = 0;
   }

   private static void setMapPaint(int var0, short[] var1) {
      if (var0 % wMap == 0) {
         var1[var0] = var1[var0 + 1];
      } else {
         var1[var0] = var1[var0 - 1];
      }
   }

   public final void setMapAny() {
      Bus.isRun = false;
      resetObject();
      addPlayer(GameMidlet.avatar);
      short[] var1 = new short[map.length];
      type = new short[map.length];
      byte[] var2 = new byte[100];
      byte var3 = 0;

      for (int var4 = 0; var4 < map.length; var4++) {
         var1[var4] = map[var4];
      }

      for (int var7 = 0; var7 < map.length; var7++) {
         if (map[var7] < imgMap.nFrame) {
            map[var7] = -4;
         } else if (map[var7] < imgMap.nFrame << 1) {
            map[var7] = -5;
         } else {
            int var5;
            switch (var5 = map[var7] - (imgMap.nFrame << 1)) {
               case 0:
                  map[var7] = 98;
                  ImageObj var6 = new ImageObj(846, x(var7) + w / 2, y(var7) + w / 2, 0);
                  treeLists.addElement(var6);
                  break;
               case 1:
               case 4:
               case 5:
               case 6:
               case 7:
               case 8:
               case 9:
               case 10:
               case 11:
               default:
                  setPopup(var7, var2[var5], 0);
                  type[var7] = (byte)(var5 + -125);
                  map[var7] = -3;
                  break;
               case 2:
                  map[var7] = 139;
                  break;
               case 3:
                  map[var7] = 152;
                  break;
               case 12:
                  map[var7] = 150;
                  break;
               case 13:
                  map[var7] = 151;
                  break;
               case 14:
                  setPopup(var7, var3, 0);
                  var3++;
                  map[var7] = 184;
                  var1[var7] = 33;
                  break;
               case 15:
                  var1[var7] = 0;
                  map[var7] = 185;
            }

            if (var5 > 0 && var2[var5] == 0 && var5 - 1 < MapScr.idImg.length && MapScr.idImg[var5 - 1] != -1) {
               ImageObj var8 = new ImageObj(MapScr.idImg[var5 - 1], x(var7) + getWTileImg(var7, var1), y(var7) + w - 4, 0);
               treeLists.addElement(var8);
            }

            if (var5 != 14) {
               setMapPaint(var7, var1);
            }

            var2[var5]++;
         }
      }

      AvCamera.disable = false;
      GameMidlet.avatar.action = 0;
      this.setMap(null, MapScr.roomID + 1, false);
      TYPEMAP = MapScr.roomID;
      map = var1;
      AvCamera.gI().init(MapScr.roomID + 1);
      Canvas.endDlg();
      rememBg = -1;
      rememMap = -1;
      setMapItemType();
      ParkService.gI().doJoinPark(MapScr.roomID, -1);
   }

   private static int getWTileImg(int var0, short[] var1) {
      for (int var2 = var0; var2 < var1.length; var2++) {
         if (var1[var2] != var1[var2 + 1]) {
            return (var2 - var0 + 1) * w / 2;
         }
      }

      return 0;
   }

   private static void setPopup(int var0, byte var1, int var2) {
      if (var1 == 0) {
         if (var0 + 1 < map.length && map[var0] == map[var0 + 1]) {
            for (int var4 = var0; var4 < map.length; var4++) {
               if (map[var4] != map[var4 + 1]) {
                  addPopup(var2 != 1 ? avt.T.aq : "thoat", x(var0) + (var4 - var0 + 1) * w / 2, y(var0) + (idTileImg == -1 ? w / 2 : w) + (var2 == 2 ? w / 2 : 0));
                  return;
               }
            }
         } else {
            if (var0 + wMap < map.length && map[var0] == map[var0 + wMap]) {
               for (int var3 = var0; var3 < map.length; var3 += wMap) {
                  if (map[var3] != map[var3 + wMap]) {
                     addPopup(var2 != 1 ? avt.T.aq : "thoat", x(var0) + 3, y(var0) + ((var3 - var0) / wMap + 1) * w / 2);
                     return;
                  }
               }
            }
         }
      }
   }

   private static void setTypeSeat(MapItem var0, MapItemType var1) {
      byte var2 = 88;
      if (var1.iconID == 1) {
         var2 = 79;
      } else if (var1.iconID == 2) {
         var2 = 67;
      }

      for (int var3 = 0; var3 < var1.listNotTrans.size(); var3++) {
         AvPosition var4 = (AvPosition)var1.listNotTrans.elementAt(var3);
         type[(var0.y + var4.y) * wMap + var0.x + var4.x] = var2;
      }
   }

   public static void onDichChuyen(byte var0, byte var1, int var2, int var3) {
      xDichChuyen = var2;
      yDichChuyen = var3;
      idTileImg = -1;
      Canvas.startWaitDlg();
      if (GameMidlet.CLIENT_TYPE != 9) {
         GlobalService.gI().getHandler(9);
      }

      ParkService.gI().doJoinPark(var0, var1);
   }
}

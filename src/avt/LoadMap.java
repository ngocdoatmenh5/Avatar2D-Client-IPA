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
   public static Image b;
   public static FrameImage c;
   public static short[] map;
   public static short wMap;
   public static short Hmap;
   public static short[] type;
   public static byte[] h = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 3, 3, 3, 3, 3, 2, -1, -1, -1, 0, 0, 0, 2, 2};
   public static int w = 24;
   public static byte j = 0;
   public static byte k = -1;
   public static Vector treeLists = new Vector();
   public static Vector playerLists = new Vector();
   public static Vector dynamicLists = new Vector();
   public static Vector o;
   private static int J = 0;
   private AvPosition[] K;
   private static Vector L = new Vector();
   private static int[] M = new int[]{15853390, 15006199, 8183509, 12254198};
   public static MyObject focusObj;
   public static Command q;
   public static Image r;
   private static FrameImage N;
   private static int[] O = new int[]{6143735, 21};
   public static int s;
   public static int t = -1;
   private static int P = -1;
   public static AvPosition posFocus;
   public static Vector effBgList;
   public static Vector effCameraList;
   public static Vector x;
   public static int y = -1;
   private static Bus Q = new Bus();
   private boolean R;
   public static boolean z;
   private static int S;
   private static int T;
   public static int A = -1;
   private static int U = 3;
   public static int B = -1;
   public static int C = -1;
   private MyObject V;
   private MyObject W;
   private MyObject X;
   private int Y;
   private int Z;
   private int aa;
   private static int ab = 0;
   private static byte ac;
   public static int D = 0;
   public static int E = -1;
   public static Vector F;
   public static Vector G;
   public static int H = -1;
   public static int I = -1;

   public LoadMap() {
      q = new Command(avt.T.bz, new class_hr(this));
      J = CRes.rnd(3);
      w = 24;
      FilePack.b(avt.T.av);
      FilePack.getImage("den");
      r = FilePack.getImage("s0");
      if (Canvas.isKeyBoard) {
         if (Canvas.stypeInt == 0) {
            N = new FrameImage(FilePack.getImage("focus"), 21 * AvMain.hd, 15 * AvMain.hd);
         } else {
            N = new FrameImage(FilePack.getImage("focus"), 32 * AvMain.hd, 11 * AvMain.hd);
         }

         posFocus = new AvPosition();
      }

      FilePack.reset();
   }

   public final void a() {
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
                  if (CRes.abs(var2) < 10 && CRes.abs(var3) < 10 && !MapScr.t) {
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
         if ((Canvas.stypeInt == 0 || Canvas.currentMyScreen != MenuCenter.gI()) && playerLists.size() > 0) {
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
         if (this.K != null) {
            for (int var3 = 0; var3 < var2.K.length; var3++) {
               var2.K[var3].x--;
               if (var2.K[var3].x < AvCamera.gI().xCam - 100) {
                  var2.K[var3].x = AvCamera.gI().xCam + Canvas.w + 30 + CRes.rnd(10) * 50;
                  var2.K[var3].y = -110 - CRes.rnd(6) * 10;
               }
            }
         }

         if (Canvas.gameTick % 4 == 2
                 && !FarmScr.isSelected
                 && (TYPEMAP != 24 || Canvas.stypeInt == 0)
                 && FarmScr.action == -1
                 && !FarmScr.isAutoVatNuoi
                 && RaceScr.a != Canvas.currentMyScreen
                 && TYPEMAP != -1
                 && Canvas.currentMyScreen != MenuCenter.a
                 && Canvas.menuMain == null) {
            if (focusObj == null) {
               int var13 = 0;

               while (var13 < playerLists.size() && !i(var13)) {
                  var13++;
               }
            } else if (CRes.abs(focusObj.x - GameMidlet.avatar.x) / w >= (focusObj.catagory == 7 ? U << 1 : U) || CRes.abs(focusObj.y - GameMidlet.avatar.y) / w >= (focusObj.catagory == 7 ? U << 1 : U)) {
               focusObj = null;
               MapScr.h = null;
            }
         }

         if (Bus.isRun) {
            Q.update();
         }

         if (x != null) {
            for (int var10 = 0; var10 < x.size(); var10++) {
               EffectManager var14;
               if (AvatarData.getEffect((var14 = (EffectManager)x.elementAt(var10)).ID) != null) {
                  if (var14.style == 0) {
                     Avatar var15;
                     if ((var15 = g(var14.idPlayer)) == null) {
                        x.removeElement(var14);
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
                        x.removeElement(var14);
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

         if (N != null && A != -1 && GameMidlet.avatar.au > 0) {
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
         z = false;
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
              && Math.abs(var1.x - GameMidlet.avatar.x) / w < (var1.catagory == 7 ? U << 1 : U)
              && Math.abs(var1.y - GameMidlet.avatar.y) / w < (var1.catagory == 7 ? U << 1 : U)) {
         if (var1.catagory != 0 || !((Avatar)var1).ableShow) {
            focusObj = var1;
         }

         if (var1.catagory == 0 && !((Avatar)var1).ableShow) {
            MapScr.h = (Avatar) playerLists.elementAt(var0);
         }

         return true;
      } else {
         return false;
      }
   }

   public static boolean a(int var0) {
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

   public static boolean b(int var0) {
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

   public static boolean c(int var0) {
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

   public final boolean a(int var1, int var2) {
      z = false;
      int var3 = c(var1, var2);
      if ((Canvas.welcome == null || Welcome.b(var3)) && var3 != -2) {
         switch (var3) {
            case -1:
               MapScr.gI().n();
               if (TYPEMAP == 25) {
                  FarmScr.gI();
               }

               if (b != null) {
                  Q.setBus((byte)-1);
               } else {
                  MapScr.gI().e();
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
               MapScr.gI().n();
               ParkService.gI().doJoinPark(var3, -1);
               break;
            case 9:
               this.f();
               break;
            case 10:
               Canvas.startWaitDlg();
               MapScr.gI().n();
               t = -1;
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
               MapScr.gI().n();
               t = -1;
               ParkService.gI().doJoinPark(19, -1);
               break;
            case 20:
               GlobalService.gI().requestJoinAny((short)0);
               Canvas.startWaitDlg();
               break;
            case 21:
               HouseScr.b().f();
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
                  E = var3;
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
                  MapScr.gI().y();
               }
               break;
            case 28:
               FarmScr.gI().doOpenKhoHang();
               break;
            case 29:
               Canvas.startWaitDlg();
               ParkService.gI().a(MapScr.b);
               break;
            case 52:
               FarmScr.gI().doOpenCuaHang();
               break;
            case 53:
               FarmScr.gI();
               FarmScr.doMenuFarmFriend();
               break;
            case 54:
               return class_kv.b().b(var1, var2);
            case 55:
               Canvas.startWaitDlg();
               GlobalService var14;
               (var14 = GlobalService.gI()).createMessage((byte)-23);
               var14.sendMessage();
               break;
            case 57:
               MapScr.gI().n();
               MapScr.gI().b((byte)1);
               break;
            case 58:
               MapScr.gI().b((byte)2);
               break;
            case 59:
               MapScr.gI().b((byte)3);
               break;
            case 62:
               MapScr.gI().n();
               MapScr.gI().b((byte)6);
               break;
            case 63:
               MapScr.gI().b((byte)7);
               break;
            case 64:
               MapScr.gI().b((byte)8);
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
               MapScr.gI().a(avt.T.cN, 5);
               break;
            case 83:
               int var10001 = var1 / w;
               var3 = var2 / w;
               var2 = var10001;
               LoadMap var13 = Canvas.loadMap;
               if (AvatarData.listAd != null) {
                  for (int var4 = 0; var4 < AvatarData.listAd.size(); var4++) {
                     ObjAd var5 = (ObjAd)AvatarData.listAd.elementAt(var4);

                     for (int var6 = 0; var6 < var5.g.size(); var6++) {
                        AvPosition var7;
                        if ((var7 = (AvPosition)var5.g.elementAt(var6)).x == var2 && var7.y == var3 && TYPEMAP + 1 == var7.anchor) {
                           Vector var19;
                           (var19 = new Vector()).addElement(new Command(avt.T.z, new class_hu(var13, var5)));
                           var19.addElement(new Command(avt.T.d, new class_hv(var13)));
                           Canvas.a(var5.c, var19);
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
               MapScr.gI().a(avt.T.cN, 4);
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
               MapScr.i(5);
               break;
            case 101:
               MapScr.gI();
               MapScr.i(6);
               break;
            case 103:
               MapScr.gI();
               MapScr.i(3);
               break;
            case 104:
               MapScr.gI();
               MapScr.i(4);
               break;
            case 107:
               Canvas.startWaitDlg();
               MapScr.m = TYPEMAP;
               GlobalService.gI().getHandler(12);
               break;
            case 108:
            case 109:
               B = GameMidlet.avatar.x;
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
                  HouseScr.b().g = GameMidlet.avatar.y;
                  if ((var1 = var1 / w * w + w / 2 + 1) < GameMidlet.avatar.x) {
                     HouseScr.b().f = var1 + w;
                  } else {
                     HouseScr.b().f = var1 - w;
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

   public final void b(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.resetTrans(var1);
      var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
      this.c(var1);
   }

   public final void c(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      if (b == null) {
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
            var3.drawImage(b, var4 + var7 * 96 * AvMain.hd, var6, 0);
         }

         if (o != null) {
            for (int var8 = 0; var8 < o.size(); var8++) {
               AvPosition var9 = (AvPosition)o.elementAt(var8);
               int var15 = AvCamera.gI().xCam * (30 + var9.d * 3) / 210;
               AvatarData.paintImg(var3, var9.anchor, var9.x + var15, var9.y, 33);
            }
         }

         int var16;
         if ((var16 = L.size()) > 0) {
            for (int var18 = 0; var18 < var16; var18++) {
               AvPosition var23 = (AvPosition)L.elementAt(var18);
               var3.setColor(M[var23.anchor]);
               var3.fillRect(var23.x + var4, var23.y, 1, 1);
            }
         }

         if (this.K != null) {
            for (int var19 = 0; var19 < var2.K.length; var19++) {
               var3.drawImage(MiniMap.k[0], var2.K[var19].x, var2.K[var19].y, 0);
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
               int var22 = var17 / c.nFrame;
               c.drawFrameXY(var22, var17 % c.nFrame, var11 * w * AvMain.hd, var24 * w * AvMain.hd, var10);
            }
         }
      }

      if (N != null && A != -1 && GameMidlet.avatar.au > 0) {
         N.drawFrame(posFocus.anchor / 2, posFocus.x, posFocus.y, A, 3, var1);
      }
   }

   public final void d(Graphics var1) {
      Graphics var3 = var1;
      LoadMap var2 = this;
      this.Y = 0;
      this.Z = 0;
      this.aa = 0;

      while (var2.Y < playerLists.size() || var2.Z < treeLists.size() || var2.aa < dynamicLists.size()) {
         var2.V = var2.W = var2.X = null;
         if (var2.Y < playerLists.size()) {
            var2.V = (MyObject) playerLists.elementAt(var2.Y);
         }

         if (var2.Z < treeLists.size()) {
            var2.W = (MyObject) treeLists.elementAt(var2.Z);
         }

         if (var2.aa < dynamicLists.size()) {
            var2.X = (Point) dynamicLists.elementAt(var2.aa);
         }

         if (var2.V == null || var2.W != null && var2.V.y >= var2.W.y || var2.X != null && var2.V.y >= var2.X.y) {
            if (var2.W == null || var2.X != null && var2.W.y >= var2.X.y) {
               if (var2.X != null) {
                  var2.X.paint(var3);
                  var2.aa++;
               }
            } else {
               var2.W.paint(var3);
               var2.Z++;
            }
         } else {
            var2.V.paint(var3);
            var2.Y++;
         }
      }

      if (Canvas.stypeInt == 0 && focusObj != null) {
         var1.drawImage(MapScr.d, focusObj.x * AvMain.hd, (focusObj.y - (focusObj.catagory == 7 ? 10 : focusObj.height)) * AvMain.hd - ab / 2, 3);
      }

      if (Bus.isRun) {
         Q.paint(var1);
      }
   }

   private static void g() {
      L.removeAllElements();
      if (j != 0 && J != 0 && k == -1) {
         if (TYPEMAP != 9 && TYPEMAP != 12) {
            int var2 = CRes.rnd(Canvas.w / 10);

            for (int var3 = 0; var3 < var2; var3++) {
               L.addElement(new AvPosition(CRes.rnd(wMap * w), -(38 + CRes.rnd(Canvas.hh)), CRes.rnd(4)));
            }
         } else {
            int var0 = CRes.rnd(Canvas.w / 10);

            for (int var1 = 0; var1 < var0; var1++) {
               L.addElement(new AvPosition(CRes.rnd(wMap * w), -(98 + CRes.rnd(Canvas.hh)), CRes.rnd(4)));
            }
         }
      }
   }

   public static InputStream d(int var0) {
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

   public final void e(int var1) {
      if (Session_ME.a().b()) {
         Canvas.load = 0;
         Canvas.endDlg();
      }

      if (Canvas.welcome != null) {
         Canvas.welcome = null;
      }

      Canvas.instance.b();
      GameMidlet.avatar.au = 0;
      y = -1;
      q.caption = avt.T.bz;
      Canvas.currentEffect.removeAllElements();
      GameMidlet.avatar.ableShow = false;
      Bus.isRun = false;
      AvCamera.disable = false;
      GameMidlet.avatar.setAction((byte)0);
      i();
      MapScr.l.removeAllElements();
      focusObj = null;
      MapScr.h = null;
      int var2;
      if ((var2 = Calendar.getInstance().get(11)) < 18 && var2 >= 6) {
         j = 0;
      } else {
         j = 1;
      }

      s = O[j];
      if ((var2 = var1 - 1) == 107 || var2 >= 0 && var2 < h.length && h[var2] != -1) {
         if (var2 == 107 || P != h[var2] || t != j) {
            byte var3;
            if (var2 == 107) {
               var3 = 0;
            } else {
               var3 = h[var2];
            }

            P = var3;
            FilePack.b(avt.T.as);
            Image var4 = FilePack.getImage(String.valueOf(var3) + j);
            Image var10 = FilePack.getImage(String.valueOf(j));
            Graphics var14 = (b = Image.createImage(96 * AvMain.hd, 96 * AvMain.hd)).getGraphics();
            PaintPopup.a(0, 0, 96 * AvMain.hd, 10 * AvMain.hd, O[j], var14);
            var14.drawImage(var10, 0, 69 * AvMain.hd, 36);
            var14.drawImage(var4, 0, 96 * AvMain.hd, 36);
            FilePack.reset();
         }
      } else {
         P = -1;
         b = null;
      }

      if (t != j || c == null) {
         if (var1 - 1 == 19) {
            try {
               t = -1;
               c = new FrameImage(Image.createImage(avt.T.a() + "/wedding.png"), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var7) {
               var7.printStackTrace();
            }
         } else if (var1 - 1 != 107) {
            w = 24;
            t = j;
            InputStream var11 = CRes.getResourceAsStream(avt.T.a() + "/data/h" + j);
            InputStream var15 = CRes.getResourceAsStream(avt.T.a() + "/data/data");

            try {
               byte[] var16 = new byte[var11.available()];
               var11.read(var16);
               byte[] var12 = new byte[var15.available()];
               var15.read(var12);
               c = new FrameImage(CRes.createImage(var16, var12), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var6) {
               var6.printStackTrace();
            }
         } else {
            try {
               w = 12;
               t = -1;
               c = new FrameImage(Image.createImage(avt.T.a() + "/tileDuaXe.png"), w * AvMain.hd, w * AvMain.hd);
            } catch (IOException var5) {
               var5.printStackTrace();
            }
         }
      }

      InputStream var13;
      if ((var13 = d(var1)) != null) {
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

      this.a(var13, var1, true);
      TYPEMAP = var1 - 1;
      System.out.println("index: " + TYPEMAP);
      if (k != -1 && TYPEMAP < h.length && h[TYPEMAP] != -1) {
         AnimateEffect var8 = new AnimateEffect(k, 0);
         Canvas.currentEffect.addElement(var8);
      }

      this.h();
      g();
      if (Session_ME.a().b() && GameMidlet.avatar.seriPart != null) {
         b(GameMidlet.avatar);
      }

      if (Canvas.load == 0) {
         Canvas.load = 1;
      }

      System.gc();
   }

   public final void a(InputStream inputStream, int n, boolean bl) {
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
               MapScr.p = new Vector();
               avatar = 0;
               while (avatar < map.length) {
                  LoadMap.type[avatar] = (short) (map[avatar] < 32 ? 80 : 88);
                  if (map[avatar] == 65) {
                     LoadMap.type[avatar] = 10;
                     LoadMap.map[avatar] = 1;
                     if (avatar == 1) {
                        LoadMap.map[avatar] = 16;
                        GameMidlet.avatar.x = GameMidlet.avatar.xCur = LoadMap.k(avatar) + w;
                        GameMidlet.avatar.y = GameMidlet.avatar.yCur = LoadMap.l(avatar) + 12;
                        LoadMap.a(avt.T.aq, LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + 12);
                     }
                     avatar = (byte)(avatar + 1);
                  } else if (map[avatar] == 27) {
                     AvPosition myObject = new AvPosition();
                     new AvPosition().x = LoadMap.k(avatar);
                     myObject.y = LoadMap.l(avatar);
                     myObject.index = (short)((5 - MapScr.p.size() % 6 << 1) + MapScr.p.size() / 6);
                     MapScr.p.addElement(myObject);
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
                     Avatar var53 = (Avatar)RaceScr.b().p.elementAt(CRes.rnd(RaceScr.b().p.size()));
                     var62.seriPart = var53.seriPart;
                     var62.x = var62.xCur = k(avatar) + 12;
                     var62.y = var62.yCur = l(avatar) + 12;
                     var62.action = 2;
                     var62.catagory = 9;
                     playerLists.addElement(var62);
                  }
                  if (map[avatar] == 59) {
                     n27 = new ImageObj(1084, LoadMap.k(avatar) + w, LoadMap.l(avatar), 0);
                     treeLists.addElement(n27);
                  } else if (map[avatar] == 60) {
                     n27 = new ImageObj(1085, LoadMap.k(avatar) + w, LoadMap.l(avatar), 0);
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
                        LoadMap.a(845, LoadMap.k(avatar) + 11, LoadMap.l(avatar));
                        break;
                     }
                     case 27: {
                        if (!bl) break;
                        LoadMap.a(844, LoadMap.k(avatar) + 11, LoadMap.l(avatar) + 1);
                        break;
                     }
                     case 28: {
                        if (!bl) break;
                        if (!Session_ME.a().b()) {
                           LoadMap.map[avatar] = 4;
                           break;
                        }
                        LoadMap.a(0, LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w - 2);
                        break;
                     }
                     case 127: {
                        if (by15 == 0) {
                           LoadMap.a(830, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + w - 2);
                           byte by18 = by15;
                           by15 = (byte)(by18 + 1);
                           LoadMap.b(avatar, by18, 2);
                        }
                        LoadMap.a(avatar, (byte)108, 96);
                        break;
                     }
                     case 128: {
                        if (s == 0) {
                           LoadMap.e(828, avatar);
                           byte by19 = (byte) s;
                           s = (byte)(by19 + 1);
                           LoadMap.b(avatar, by19, 2);
                        }
                        LoadMap.a(avatar, (byte)55, 5);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 129:
                     case 160: {
                        if (by == 0) {
                           if (n - 1 == 17) {
                              LoadMap.e(836, avatar);
                           } else {
                              LoadMap.e(829, avatar);
                           }
                           byte by20 = by;
                           by = (byte)(by20 + 1);
                           LoadMap.b(avatar, by20, 2);
                        }
                        LoadMap.a(avatar, map[avatar] == 129 ? (byte)57 : 62, 96);
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
                        LoadMap.b(avatar, by21, 0);
                        LoadMap.a(avatar, (byte)n30);
                        break;
                     }
                     case 153: {
                        if (by14 == 0) {
                           byte by22 = by14;
                           by14 = (byte)(by22 + 1);
                           LoadMap.b(avatar, by22, 0);
                        }
                        LoadMap.a(avatar, (byte)11);
                        break;
                     }
                     case 139: {
                        LoadMap.type[avatar] = -1;
                        byte by23 = by13;
                        by13 = (byte)(by23 + 1);
                        LoadMap.b(avatar, by23, 0);
                        if (TYPEMAP == -1 && n != 21 && b != null) {
                           Bus.posBusStop = new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) - w / 2);
                           Q.setBus((byte)1);
                        }
                        LoadMap.a(avatar, map);
                        break;
                     }
                     case 140: {
                        byte by24 = by12;
                        by12 = (byte)(by24 + 1);
                        LoadMap.b(avatar, by24, 0);
                        LoadMap.a(avatar, (byte)25, 55);
                        by12 = (byte)(by12 + 1);
                        break;
                     }
                     case 141: {
                        if (by3 == 0) {
                           LoadMap.e(840, avatar);
                           byte by25 = by3;
                           by3 = (byte)(by25 + 1);
                           LoadMap.b(avatar, by25, 0);
                        }
                        LoadMap.a(avatar, (byte)24, 5);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 142: {
                        LoadMap.a(avatar, (byte)80, 7);
                        FarmScr.gI().posTree[n5] = new AvPosition(avatar % wMap, avatar / wMap, 0);
                        n5 = (byte)(n5 + 1);
                        break;
                     }
                     case 143: {
                        if (by2 == 0) {
                           LoadMap.e(831, avatar);
                           byte by26 = by2;
                           by2 = (byte)(by26 + 1);
                           LoadMap.b(avatar, by26, 2);
                        }
                        LoadMap.a(avatar, (byte)52, 51);
                        LoadMap.map[avatar] = map[avatar + wMap];
                        break;
                     }
                     case 144: {
                        if (by4 == 0) {
                           LoadMap.e(841, avatar);
                           byte by27 = by4;
                           by4 = (byte)(by27 + 1);
                           LoadMap.b(avatar, by27, 2);
                        }
                        LoadMap.a(avatar, (byte)53, 5);
                        break;
                     }
                     case 145: {
                        byte by28 = ac;
                        ac = (byte)(by28 + 1);
                        LoadMap.b(avatar, by28, 0);
                        if (n - 1 == 109 || n - 1 == 57 && TYPEMAP == 17) {
                           LoadMap.a(avatar, (byte)17, -1);
                           break;
                        }
                        if (TYPEMAP == 23) {
                           LoadMap.a(avatar, (byte)23, -1);
                           break;
                        }
                        LoadMap.a(avatar, (byte)9, -1);
                        if (n - 1 != 100) break;
                        LoadMap.map[avatar] = 47;
                        break;
                     }
                     case 147:
                     case 161: {
                        if (by5 == 0) {
                           LoadMap.e(832, avatar);
                           byte by29 = by5;
                           by5 = (byte)(by29 + 1);
                           LoadMap.b(avatar, by29, 2);
                        }
                        LoadMap.a(avatar, map[avatar] == 147 ? (byte)58 : 63, 96);
                        break;
                     }
                     case 148:
                     case 162: {
                        if (by6 == 0) {
                           if (n == 18) {
                              LoadMap.a(836, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + w - 2);
                           } else {
                              LoadMap.a(833, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + w - 2);
                           }
                           byte by30 = by6;
                           by6 = (byte)(by30 + 1);
                           LoadMap.b(avatar, by30, 2);
                        }
                        LoadMap.a(avatar, map[avatar] == 148 ? (byte)59 : 64, 96);
                        break;
                     }
                     case 149: {
                        if (by7 == 0) {
                           LoadMap.e(834, avatar);
                           if (GameMidlet.avatar.IDDB == FarmScr.idFarm) {
                              LoadMap.b(avatar, by7, 2);
                           }
                           by7 = (byte)(by7 + 1);
                        }
                        LoadMap.a(avatar, (byte)28, 4);
                        break;
                     }
                     case 150: {
                        if (n17 == 0) {
                           LoadMap.e(842, avatar);
                        }
                        LoadMap.a(avatar, (byte)93, 0);
                        if (n == 26) {
                           LoadMap.map[avatar] = 4;
                        }
                        n17 = (byte)(n17 + 1);
                        break;
                     }
                     case 151: {
                        if (n18 == 0) {
                           LoadMap.e(843, avatar);
                        }
                        LoadMap.a(avatar, (byte)78, 0);
                        n18 = (byte)(n18 + 1);
                        break;
                     }
                     case 152: {
                        if (n3 == 0) {
                           LoadMap.e(835, avatar);
                        }
                        LoadMap.a(avatar, (byte)81, n - 1 == 25 ? 55 : 0);
                        n3 = (byte)(n3 + 1);
                        break;
                     }
                     case 155: {
                        LoadMap.a(avatar, (byte)80, 55);
                        if (Cattle.numPig <= 0) break;
                        LoadMap.a(avatar, (byte)84, 112);
                        LoadMap.a(-5, LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        Cattle.posPigTr = new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        break;
                     }
                     case 156: {
                        LoadMap.a(avatar, (byte)80, 5);
                        if (Dog.numBer <= 0) break;
                        LoadMap.a(avatar, (byte)85, 5);
                        LoadMap.a(-6, LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        Dog.posDosTr = new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        break;
                     }
                     case 157: {
                        LoadMap.a(avatar, (byte)80, 111);
                        Cattle.posBucket = new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        break;
                     }
                     case 158: {
                        LoadMap.a(avatar, (byte)80, 5);
                        if (Chicken.numChicken <= 0) break;
                        Chicken.s = new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
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
                        LoadMap.a(avatar, (byte)89, avPosition);
                        LoadMap.e(848, avatar);
                        break;
                     }
                     case 163: {
                        byte by31 = ac;
                        ac = (byte)(by31 + 1);
                        LoadMap.b(avatar, by31, 0);
                        LoadMap.a(avatar, (byte)12, -1);
                        break;
                     }
                     case 164: {
                        LoadMap.b(avatar, byArray[9], 0);
                        byArray[9] = (byte)(byArray[9] + 1);
                        LoadMap.a(avatar, (byte)13, 6);
                        break;
                     }
                     case 165: {
                        LoadMap.b(avatar, byArray[10], 0);
                        LoadMap.a(avatar, (byte)14, 0);
                        byArray[10] = (byte)(byArray[10] + 1);
                        break;
                     }
                     case 166: {
                        LoadMap.b(avatar, byArray[11], 0);
                        LoadMap.a(avatar, (byte)15, 0);
                        byArray[11] = (byte)(byArray[11] + 1);
                        break;
                     }
                     case 167: {
                        LoadMap.b(avatar, byArray[12], 0);
                        byArray[12] = (byte)(byArray[12] + 1);
                        LoadMap.a(avatar, (byte)16, 43);
                        break;
                     }
                     case 172: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n14 % 3 == 0) {
                           LoadMap.a(836, LoadMap.k(avatar) + 37, LoadMap.l(avatar) + w);
                        }
                        n14 = (byte)(n14 + 1);
                        break;
                     }
                     case 173: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n15 % 4 == 0) {
                           LoadMap.a(837, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + w);
                        }
                        n15 = (byte)(n15 + 1);
                        break;
                     }
                     case 174: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n16 % 4 == 0) {
                           LoadMap.a(838, LoadMap.k(avatar) + 48, LoadMap.l(avatar) + w);
                        }
                        n16 = (byte)(n16 + 1);
                        break;
                     }
                     case 175: {
                        byte by32 = by8;
                        by8 = (byte)(by32 + 1);
                        LoadMap.b(avatar, by32, 0);
                        LoadMap.a(avatar, (byte)68, 96);
                        break;
                     }
                     case 176: {
                        byte by33 = by9;
                        by9 = (byte)(by33 + 1);
                        LoadMap.b(avatar, by33, 0);
                        LoadMap.a(avatar, (byte)69, 96);
                        break;
                     }
                     case 177: {
                        byte by34 = by10;
                        by10 = (byte)(by34 + 1);
                        LoadMap.b(avatar, by34, 0);
                        LoadMap.a(avatar, (byte)70, 96);
                        break;
                     }
                     case 178: {
                        if (by15 == 0) {
                           LoadMap.a(830, LoadMap.k(avatar) + w, LoadMap.l(avatar) + w - 2);
                           byte by35 = by15;
                           by15 = (byte)(by35 + 1);
                           LoadMap.b(avatar, by35, 2);
                        }
                        LoadMap.a(avatar, (byte)109, 96);
                        break;
                     }
                     case 179: {
                        if (by10 == 0) {
                           byte by36 = by10;
                           by10 = (byte)(by36 + 1);
                           LoadMap.b(avatar, by36, 2);
                           LoadMap.e(837, avatar);
                        }
                        LoadMap.a(avatar, (byte)18, 96);
                        break;
                     }
                     case 180: {
                        byte by37 = by10;
                        by10 = (byte)(by37 + 1);
                        LoadMap.b(avatar, by37, 0);
                        LoadMap.a(avatar, (byte)17, 77);
                        if (n - 1 != 101) break;
                        LoadMap.map[avatar] = 0;
                        break;
                     }
                     case 181: {
                        if (n - 1 == 101 || n - 1 == 104 || n - 1 == 103 || n - 1 == 100 || n - 1 == 101) break;
                        if (by16 == 0) {
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w / 2);
                        }
                        by16 = (byte)(by16 + 1);
                        LoadMap.a(avatar, (byte)56, 46);
                        break;
                     }
                     case 182: {
                        FarmScr.posBarn = new AvPosition(LoadMap.k(avatar), LoadMap.l(avatar));
                        LoadMap.a(avatar, (byte)80, 39);
                        break;
                     }
                     case 183: {
                        FarmScr.posPond = new AvPosition(LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        LoadMap.a(avatar, (byte)88, 13);
                        break;
                     }
                     case 184: {
                        break;
                     }
                     case 185: {
                        if (by17 == 1 && n == 18) {
                           LoadMap.a(975, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        if (n == 18) {
                           LoadMap.a(avatar, (byte)71, 43);
                           if (by17 == 2) {
                              LoadMap.a(avt.T.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 25);
                           }
                        } else {
                           byte by38 = by17;
                           by17 = (byte)(by38 + 1);
                           LoadMap.b(avatar, by38, 0);
                           LoadMap.a(avatar, (byte)71, 47);
                        }
                        by17 = (byte)(by17 + 1);
                        break;
                     }
                     case 186: {
                        byte by39 = (byte)(n19 + 1);
                        n19 = by39;
                        if (by39 == 3) {
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 24);
                        }
                        LoadMap.a(avatar, (byte)94, 17);
                        if (n19 != 2) break;
                        LoadMap.a(974, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        break;
                     }
                     case 187: {
                        if (n20 == 0 && FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                           treeLists.addElement(new SubObject(-10, LoadMap.k(avatar) + 20, LoadMap.l(avatar) + 20, FarmScr.imgBuyLant.getWidth()));
                        }
                        n20 = (byte)(n20 + 1);
                        LoadMap.a(avatar, FarmScr.idFarm == GameMidlet.avatar.IDDB ? (byte)95 : 80, 4);
                        break;
                     }
                     case 188: {
                        if (FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                           treeLists.addElement(new SubObject(-10, LoadMap.k(avatar) + 20, LoadMap.l(avatar) + 20, FarmScr.imgBuyLant.getWidth()));
                        }
                        LoadMap.a(avatar, FarmScr.idFarm == GameMidlet.avatar.IDDB ? (byte)96 : 80, 4);
                        break;
                     }
                     case 189: {
                        FarmScr.starFruil.x = LoadMap.k(avatar) + 12;
                        FarmScr.starFruil.y = LoadMap.l(avatar) + 12;
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
                           LoadMap.a(1029, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 20);
                           FarmScr.xPosCook = LoadMap.k(avatar) + 26;
                           FarmScr.yPosCook = LoadMap.l(avatar) + 10;
                           if (FarmScr.idFarm == GameMidlet.avatar.IDDB) {
                              LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 24);
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
                              LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 12);
                           }
                        } else {
                           LoadMap.map[avatar] = (short) (n6 % 2 == 0 ? 46 : 44);
                           if (n6 == 1) {
                              LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 12);
                           }
                        }
                        n6 = (byte)(n6 + 1);
                        break;
                     }
                     case 192: {
                        LoadMap.type[avatar] = 99;
                        LoadMap.map[avatar] = 4;
                        if (n11 == 0) {
                           LoadMap.a(1034, LoadMap.k(avatar) + 36, LoadMap.l(avatar) + 24);
                        }
                        n11 = (byte)(n11 + 1);
                        break;
                     }
                     case 193: {
                        LoadMap.type[avatar] = 100;
                        LoadMap.map[avatar] = 4;
                        if (n10 == 1) {
                           LoadMap.a(1032, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n10 = (byte)(n10 + 1);
                        break;
                     }
                     case 194: {
                        LoadMap.type[avatar] = 106;
                        LoadMap.map[avatar] = 4;
                        if (n12 == 0) {
                           LoadMap.a(1030, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        n12 = (byte)(n12 + 1);
                        break;
                     }
                     case 195: {
                        LoadMap.type[avatar] = 102;
                        LoadMap.map[avatar] = 4;
                        if (n8 == 1) {
                           LoadMap.a(1037, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                        }
                        n8 = (byte)(n8 + 1);
                        break;
                     }
                     case 196: {
                        LoadMap.type[avatar] = 103;
                        LoadMap.map[avatar] = 4;
                        if (n7 == 1) {
                           LoadMap.a(1035, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n7 = (byte)(n7 + 1);
                        break;
                     }
                     case 197: {
                        LoadMap.type[avatar] = 104;
                        LoadMap.map[avatar] = 4;
                        if (n9 == 1) {
                           LoadMap.a(1033, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 24);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n9 = (byte)(n9 + 1);
                        break;
                     }
                     case 198: {
                        LoadMap.type[avatar] = 105;
                        LoadMap.map[avatar] = 4;
                        LoadMap.a(1036, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 20);
                        break;
                     }
                     case 199: {
                        LoadMap.type[avatar] = 101;
                        LoadMap.map[avatar] = 4;
                        if (n4 == 1) {
                           LoadMap.a(1031, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n4 = (byte)(n4 + 1);
                        break;
                     }
                     case 200: {
                        LoadMap.type[avatar] = 107;
                        if (n22 == 1) {
                           LoadMap.a(1075, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 24);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n22 = (byte)(n22 + 1);
                        LoadMap.map[avatar] = 5;
                        break;
                     }
                     case 201: {
                        LoadMap.type[avatar] = 19;
                        LoadMap.map[avatar] = 5;
                        if (n23 == 1) {
                           LoadMap.a(1094, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 20);
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 24, LoadMap.l(avatar) + 30);
                        }
                        n23 = (byte)(n23 + 1);
                        break;
                     }
                     case 202: {
                        LoadMap.a(avatar, (byte)88, 96);
                        if (n24 % 4 == 0) {
                           LoadMap.a(4, LoadMap.k(avatar) + (w << 1), LoadMap.l(avatar) + w);
                        }
                        n24 = (byte)(n24 + 1);
                        break;
                     }
                     case 203: {
                        byte by40 = by16;
                        by16 = (byte)(by40 + 1);
                        LoadMap.b(avatar, by40, 0);
                        LoadMap.a(avatar, (byte)110, 96);
                        break;
                     }
                     case 204: {
                        LoadMap.map[avatar] = 43;
                        LoadMap.type[avatar] = 10;
                        if (n23 == 1) {
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar), LoadMap.l(avatar) + 30);
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
                        LoadMap.b(avatar, by41, 0);
                        if (n - 1 == 57 || n - 1 == 62) {
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) - 12, LoadMap.l(avatar) + 12);
                           break;
                        }
                        if (n - 1 == 58 || n - 1 == 63) {
                           LoadMap.a(avt.T.aq, LoadMap.k(avatar) + 12, LoadMap.l(avatar) + 36);
                           break;
                        }
                        LoadMap.a(avt.T.aq, LoadMap.k(avatar) - 12, LoadMap.l(avatar) + 12);
                        break;
                     }
                     case 97: {
                        LoadMap.type[avatar] = 54;
                        break;
                     }
                     case 98: {
                        LoadMap.type[avatar] = 29;
                        LoadMap.e(846, avatar);
                        if (n - 1 != 108 && n - 1 != 109) break;
                        LoadMap.map[avatar] = 56;
                        break;
                     }
                     case 102: {
                        LoadMap.type[avatar] = 92;
                        BoardScr.listPosAvatar.addElement(new AvPosition(LoadMap.k(avatar) + w / 2, LoadMap.l(avatar) + w));
                        AvPosition avPosition = new AvPosition(-20, LoadMap.l(avatar) + w);
                        if (n13 % 2 == (n == 66 ? 0 : 1)) {
                           avPosition.x = (Canvas.w + 20) / AvMain.hd;
                        }
                        BoardScr.listPosCasino.addElement(avPosition);
                        n13 = (byte)(n13 + 1);
                        break;
                     }
                     case 110: {
                        FarmScr.posName = new AvPosition(LoadMap.k(avatar) - w + 8, LoadMap.l(avatar) - 2);
                        LoadMap.a(847, LoadMap.k(avatar) + 11, LoadMap.l(avatar));
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
      LoadMap.m(n);
      LoadMap.orderVector(treeLists);
      if (TYPEMAP == 24 && FarmScr.idFarm != GameMidlet.avatar.IDDB) {
         TYPEMAP = 53;
      }
      if ((n2 = TYPEMAP) != -1 && y != -1) {
         n2 = D;
      }
      if (n - 1 != 19) {
         int n26 = 0;
         while (n26 < type.length) {
            int n27 = n26 / wMap;
            int n31 = n26 % wMap;
            s = (short)n2;
            if (type[n27 * wMap + n31] == s) {
               AvPosition avPosition = LoadMap.j(n26);
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
      if (E != -1) {
         D = E;
      }
      AvCamera.gI().followPlayer = GameMidlet.avatar;
      AvCamera.gI().init(n);
      if (Canvas.isKeyBoard) {
         GameMidlet.avatar.createAvatarArrays();
      }
   }

   private static AvPosition j(int var0) {
      if (var0 + 1 < type.length && type[var0] == type[var0 + 1]) {
         for (int var3 = var0; var3 < type.length; var3++) {
            if (type[var3] != type[var3 + 1]) {
               int var4 = w;
               if (var0 / wMap == Hmap - 1) {
                  var4 = -w;
               }

               return new AvPosition(k(var0) + (var3 - var0 + 1) * w / 2, l(var0) + w / 2 + var4);
            }
         }
      } else if (var0 + wMap < type.length && type[var0] == type[var0 + wMap]) {
         for (int var1 = var0; var1 < type.length; var1 += wMap) {
            if (type[var1] != type[var1 + wMap]) {
               int var2 = -w;
               if (var0 % wMap == 0) {
                  var2 = w;
               }

               return new AvPosition(k(var0) + w / 2 + var2, l(var0) + ((var1 - var0) / wMap + 1) * w / 2);
            }
         }
      }

      return null;
   }

   public static void a(int var0, int var1, int var2) {
      if (y == -1) {
         Object var3;
         if (var0 > 0) {
            var3 = new ImageObj(var0, var1, var2, 0);
         } else {
            var3 = new SubObject(var0, var1, var2, 0);
         }

         treeLists.addElement(var3);
      }
   }

   private static void e(int var0, int var1) {
      if (y == -1) {
         ImageObj var2 = new ImageObj(var0, k(var1) + b(var1, map), l(var1) + w - 4, 0);
         treeLists.addElement(var2);
      }
   }

   private static int k(int var0) {
      return var0 % wMap * w;
   }

   private static int l(int var0) {
      return var0 / wMap * w;
   }

   private static void a(int var0, byte var1, int var2) {
      type[var0] = var1;
      map[var0] = (short)var2;
   }

   private static void a(int var0, byte var1) {
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

   private static void a(String var0, int var1, int var2) {
      if (Session_ME.a().c) {
         treeLists.addElement(new class_hz(var0, var1, var2));
      }
   }

   public static MapItemType f(int var0) {
      int var1 = F.size();

      for (int var2 = 0; var2 < var1; var2++) {
         MapItemType var3;
         if ((var3 = (MapItemType)F.elementAt(var2)).idType == var0) {
            return var3;
         }
      }

      return null;
   }

   public static void d() {
      if (G != null && F != null) {
         for (int var0 = 0; var0 < G.size(); var0++) {
            MapItem var1;
            MapItemType var2 = f((var1 = (MapItem)G.elementAt(var0)).typeID);
            a(var1, var2);
            MapItem var3;
            (var3 = new MapItem(var1.type, var1.x * w, var1.y * w, var1.ID, var1.typeID)).d = var1.d;
            treeLists.addElement(var3);
         }

         orderVector(treeLists);
      }
   }

   private static void m(int var0) {
      for (int var1 = 0; var1 < AvatarData.listMapItem.size(); var1++) {
         MapItem var2;
         if ((var2 = (MapItem)AvatarData.listMapItem.elementAt(var1)).type == var0) {
            MapItemType var3 = AvatarData.getMapItemTypeByID((int) var2.typeID);
            a(var2, var3);
            treeLists.addElement(new MapItem(var2.type, var2.x * w, var2.y * w, var2.ID, var2.typeID));
         }
      }

      if (AvatarData.listAd != null) {
         for (int var5 = 0; var5 < AvatarData.listAd.size(); var5++) {
            ObjAd var6 = (ObjAd)AvatarData.listAd.elementAt(var5);

            for (int var7 = 0; var7 < var6.g.size(); var7++) {
               AvPosition var4;
               if ((var4 = (AvPosition)var6.g.elementAt(var7)).anchor == var0) {
                  if (var4.y * wMap + var4.x >= 0 && var4.y * wMap + var4.x < type.length) {
                     type[var4.y * wMap + var4.x] = 83;
                  }

                  a(var6.b, var4.x * w + w / 2, var4.y * w + w / 2);
               }
            }
         }
      }
   }

   private void h() {
      this.K = null;
      if (j != 1) {
         this.K = new AvPosition[4];

         for (int var1 = 0; var1 < this.K.length; var1++) {
            int var2 = AvCamera.gI().xCam + CRes.rnd(Canvas.w / 20 + 5) * 20;
            int var3 = -110 - CRes.rnd(3) * 10;
            this.K[var1] = new AvPosition(var2, var3);
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

   private static void i() {
      Canvas.currentEffect.removeAllElements();
      treeLists.removeAllElements();
      playerLists.removeAllElements();
      dynamicLists.removeAllElements();
      effBgList = null;
      effCameraList = null;
      x = null;
      System.gc();
   }

   public static boolean isTrans(int var0, int var1) {
      int var2;
      return (var2 = c(var0, var1)) != 80 && var2 != 51 ? GameMidlet.avatar.task == -5 && (var2 == 79 || var2 == 81 || var2 == 92 || var2 == 67) : true;
   }

   public static int c(int var0, int var1) {
      short var2;
      return var0 >= 0 && var0 <= wMap * w && var1 / w * wMap + var0 / w >= 0 && var1 / w * wMap + var0 / w < type.length ? (var2 = type[var1 / w * wMap + var0 / w]) : -2;
   }

   public static int getposMap(int var0, int var1) {
      return var0 >= 0 && var0 <= wMap * w && var1 / w * wMap + var0 / w < type.length ? var1 / w * wMap + var0 / w : -1;
   }

   public static Avatar g(int var0) {
      for (int var1 = 0; var1 < playerLists.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject) playerLists.elementAt(var1)).catagory == 0 && ((Base)var2).IDDB == var0) {
            return (Avatar)var2;
         }
      }

      return null;
   }

   public static void a(byte var0) {
      for (int var1 = 0; var1 < Canvas.currentEffect.size(); var1++) {
         ((Effect) Canvas.currentEffect.elementAt(var1)).isStop = true;
      }

      if (var0 != -1) {
         AnimateEffect var3 = new AnimateEffect(var0, 0);
         Canvas.currentEffect.addElement(var3);
      }

      k = var0;
   }

   public static void setPet(Avatar var0) {
      if (var0.idPet != -1) {
         Pet var1 = new Pet(var0);
         playerLists.addElement(var1);
      }
   }

   public static Pet h(int var0) {
      for (int var1 = 0; var1 < playerLists.size(); var1++) {
         MyObject var2;
         if ((var2 = (MyObject) playerLists.elementAt(var1)).catagory == 4 && ((Pet)var2).r.IDDB == var0) {
            return (Pet)var2;
         }
      }

      return null;
   }

   public static void b(Avatar var0) {
      playerLists.addElement(var0);
      var0.setPet();
   }

   public static void c(Avatar var0) {
      playerLists.removeElement(var0);
      Pet var1;
      if ((var1 = h(var0.IDDB)) != null) {
         playerLists.removeElement(var1);
      }
   }

   public static void a(MyObject var0) {
      if (focusObj == var0) {
         focusObj = null;
      }

      playerLists.removeElement(var0);
   }

   public final void a(byte var1, byte[] var2) {
      y = var1;
      c = new FrameImage(CRes.createImage(var2), w * AvMain.hd, AvMain.hd * w);
      this.e();
      Canvas.load = 0;
   }

   private static void a(int var0, short[] var1) {
      if (var0 % wMap == 0) {
         var1[var0] = var1[var0 + 1];
      } else {
         var1[var0] = var1[var0 - 1];
      }
   }

   public final void e() {
      Bus.isRun = false;
      i();
      b(GameMidlet.avatar);
      short[] var1 = new short[map.length];
      type = new short[map.length];
      byte[] var2 = new byte[100];
      byte var3 = 0;

      for (int var4 = 0; var4 < map.length; var4++) {
         var1[var4] = map[var4];
      }

      for (int var7 = 0; var7 < map.length; var7++) {
         if (map[var7] < c.nFrame) {
            map[var7] = -4;
         } else if (map[var7] < c.nFrame << 1) {
            map[var7] = -5;
         } else {
            int var5;
            switch (var5 = map[var7] - (c.nFrame << 1)) {
               case 0:
                  map[var7] = 98;
                  ImageObj var6 = new ImageObj(846, k(var7) + w / 2, l(var7) + w / 2, 0);
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
                  b(var7, var2[var5], 0);
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
                  b(var7, var3, 0);
                  var3++;
                  map[var7] = 184;
                  var1[var7] = 33;
                  break;
               case 15:
                  var1[var7] = 0;
                  map[var7] = 185;
            }

            if (var5 > 0 && var2[var5] == 0 && var5 - 1 < MapScr.B.length && MapScr.B[var5 - 1] != -1) {
               ImageObj var8 = new ImageObj(MapScr.B[var5 - 1], k(var7) + b(var7, var1), l(var7) + w - 4, 0);
               treeLists.addElement(var8);
            }

            if (var5 != 14) {
               a(var7, var1);
            }

            var2[var5]++;
         }
      }

      AvCamera.disable = false;
      GameMidlet.avatar.action = 0;
      this.a(null, MapScr.b + 1, false);
      TYPEMAP = MapScr.b;
      map = var1;
      AvCamera.gI().init(MapScr.b + 1);
      Canvas.endDlg();
      P = -1;
      t = -1;
      d();
      ParkService.gI().doJoinPark(MapScr.b, -1);
   }

   private static int b(int var0, short[] var1) {
      for (int var2 = var0; var2 < var1.length; var2++) {
         if (var1[var2] != var1[var2 + 1]) {
            return (var2 - var0 + 1) * w / 2;
         }
      }

      return 0;
   }

   private static void b(int var0, byte var1, int var2) {
      if (var1 == 0) {
         if (var0 + 1 < map.length && map[var0] == map[var0 + 1]) {
            for (int var4 = var0; var4 < map.length; var4++) {
               if (map[var4] != map[var4 + 1]) {
                  a(var2 != 1 ? avt.T.aq : "thoat", k(var0) + (var4 - var0 + 1) * w / 2, l(var0) + (y == -1 ? w / 2 : w) + (var2 == 2 ? w / 2 : 0));
                  return;
               }
            }
         } else {
            if (var0 + wMap < map.length && map[var0] == map[var0 + wMap]) {
               for (int var3 = var0; var3 < map.length; var3 += wMap) {
                  if (map[var3] != map[var3 + wMap]) {
                     a(var2 != 1 ? avt.T.aq : "thoat", k(var0) + 3, l(var0) + ((var3 - var0) / wMap + 1) * w / 2);
                     return;
                  }
               }
            }
         }
      }
   }

   private static void a(MapItem var0, MapItemType var1) {
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

   public static void a(byte var0, byte var1, int var2, int var3) {
      H = var2;
      I = var3;
      y = -1;
      Canvas.startWaitDlg();
      if (GameMidlet.CLIENT_TYPE != 9) {
         GlobalService.gI().getHandler(9);
      }

      ParkService.gI().doJoinPark(var0, var1);
   }
}

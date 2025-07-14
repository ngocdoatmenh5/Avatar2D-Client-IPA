package avt;

import java.util.Hashtable;
import java.util.Vector;
import main.Canvas;
import main.GameMidlet;

public final class GlobalLogicHandler {
   public static boolean a;

   public static void a(String var0) {
      Canvas.startOKDlg(var0);
   }

   public static void a() {
      AvatarMsgHandler.onHandler();
      if (AvatarData.playing == -1) {
         AvatarService.gI().getBigData();
      } else {
         MapScr.gI().joinCitymap();
      }

      AvatarService.gI().doRequestExpicePet(GameMidlet.avatar.IDDB);
      AvatarData.listImgIcon = new Hashtable();
      AvatarData.listImgPart = new Hashtable();
   }

   public final void a(String var1, String var2) {
      class_dv var4 = new class_dv(this, var2);
      Vector var3;
      (var3 = new Vector()).addElement(new Command(T.z, var4));
      var3.addElement(new Command(T.d, new class_dw(this)));
      Canvas.msgdlg.setIsWaiting(false);
      Canvas.a(var1, var3);
      a = true;
   }

   public final void a(String var1, boolean var2) {
      if (var2) {
         Canvas.b(var1, new class_dq(this));
      } else {
         Canvas.startOKDlg(var1);
      }
   }

   public static void a(byte var0) {
      if (GameMidlet.CLIENT_TYPE == 9) {
         a = false;
      }

      System.out.println("doGetHandler: " + var0 + "    " + MapScr.g);
      if (GlobalMessageHandler.gI().miniGameMessageHandler != null) {
         switch (var0) {
            case 3:
               CasinoMsgHandler.a();
               MapScr.gI();
               MapScr.m();
            case 4:
            case 5:
            case 6:
            case 7:
            default:
               break;
            case 8:
               MapScr.gI().y = true;
               AvatarMsgHandler.onHandler();
               if (MapScr.D != -1) {
                  GlobalService.gI().j(MapScr.D);
                  MapScr.D = -1;
               } else if (MapScr.g != -1) {
                  Canvas.loadMap.e(57 + MapScr.g);
                  if (Canvas.isDoubleImage && LoadMap.TYPEMAP == 57) {
                     (Canvas.D = new Welcome()).b(MapScr.a);
                  }

                  GameMidlet.avatar.setFeel(4);
                  Canvas.endDlg();
               } else {
                  MapScr.gI().joinCitymap();
                  Canvas.endDlg();
               }
               break;
            case 9:
               ParkMsgHandler.a();
               if (LoadMap.H == -1) {
                  if (!OnScreen.b) {
                     if (GameMidlet.CLIENT_TYPE == 12) {
                        LoadMap.i = 24;
                        LoadMap.t = -1;
                        ParkService.a().a(MapScr.m, -1);
                     } else if (GameMidlet.CLIENT_TYPE == 3) {
                        Canvas.paint.i();
                        ParkService.a().a(MapScr.m, -1);
                     } else if (MapScr.g != -1) {
                        MapScr.gI();
                        MapScr.x();
                     } else if (MapScr.G != -1) {
                        Canvas.startWaitDlg();
                        ParkService.a().a(MapScr.G, -1);
                        MapScr.G = -1;
                     } else {
                        MapScr.gI().s();
                     }
                  } else {
                     Canvas.paint.i();
                     OnScreen.e().a();
                     Canvas.endDlg();
                  }
               } else {
                  LoadMap.y = -1;
               }
               break;
            case 10:
               if (FarmMsgHandler.a == null) {
                  FarmMsgHandler.a = new FarmMsgHandler();
               }

               GlobalMessageHandler.gI().miniGameMessageHandler = FarmMsgHandler.a;
               if (FarmData.h == -1) {
                  FarmService var2;
                  (var2 = FarmService.a()).createMessage((byte)51);
                  var2.writeUTF(AvatarData.l);
                  var2.sendMessage();
               } else if (FarmScr.f == null) {
                  FarmService.a().d();
               } else {
                  ParkService.a().a(25, 0);
                  FarmScr.e();
                  FarmScr.b().b(GameMidlet.avatar.IDDB, false);
               }
               break;
            case 11:
               HomeMsgHandler.a();
               LoadMap.TYPEMAP = -1;
               ParkService.a().a(21, 0);
               if (MapScr.v != -1) {
                  Canvas.startWaitDlg();
                  AvatarService.gI().getTypeHouse((int)0);
               }
               break;
            case 12:
               if (class_jz.a == null) {
                  class_jz.a = new class_jz();
               }

               GlobalMessageHandler.gI().miniGameMessageHandler = class_jz.a;
               GlobalService var1 = GlobalService.gI();
               Canvas.startWaitDlg();
               var1.createMessage((byte)1);
               var1.sendMessage();
         }
      }

      GameMidlet.CLIENT_TYPE = var0;
   }

   public final void a(int var1, byte var2, String[] var3, String var4, String var5, boolean[] var6) {
      if (Canvas.menuMain != null) {
         Canvas.menuMain = null;
      }

      Canvas.endDlg();
      Vector var7 = new Vector();

      for(int var8 = 0; var8 < var3.length; ++var8) {
         var7.addElement(new Command(var3[var8], new class_hh(this, var8, var1, var2)));
      }

      if (var4 != null) {
         MenuNPC.a().a(var7, var1, var4, var5, var6);
      } else {
         MenuSub.a().a(var7, 0);
      }
   }

   public final void a(byte var1, byte var2, String var3) {
      if (var2 == 0) {
         Canvas.a(var3, (IAction)(new class_ds(this, var1)));
      } else {
         Canvas.startOKDlg(var3);
      }
   }
}

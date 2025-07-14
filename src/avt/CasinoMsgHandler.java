package avt;

import java.util.Vector;
import main.Canvas;
import main.GameMidlet;

public final class CasinoMsgHandler extends IService implements IMiniGameMsgHandler {
   public static CasinoMsgHandler a = new CasinoMsgHandler();
   public IMiniGameMsgHandler c;
   public static BoardScr d;

   public static void a() {
      GlobalMessageHandler.gI().miniGameMessageHandler = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2;
         int var5;
         int var9;
         String var12;
         int var13;
         byte var15;
         byte var16;
         int var17;
         switch (var1.a) {
            case 6:
               Vector var21 = new Vector();

               while(var1.reader().available() > 0) {
                  RoomInfo var19;
                  (var19 = new RoomInfo()).a = var1.reader().readByte();
                  var19.b = var1.reader().readByte();
                  var1.reader().readByte();
                  var19.c = var1.reader().readByte();
                  var21.addElement(var19);
               }

               RoomListOnScr.b().a(var21);
               RoomListOnScr.b().switchToMe();
               Canvas.endDlg();
               return;
            case 7:
               Vector var18 = new Vector();
               var15 = var1.reader().readByte();

               while(var1.reader().available() > 0) {
                  class_dl var20;
                  (var20 = new class_dl()).a = var1.reader().readByte();
                  var5 = var1.reader().readUnsignedByte();
                  var20.b = (byte)(var5 % 16);
                  var20.c = (byte)(var5 / 16);
                  int var22 = var1.reader().readUnsignedByte();
                  var20.d = (var22 & 1) != 0;
                  var20.e = (var22 & 2) != 0;
                  var20.f = var1.reader().readInt();
                  var20.g = Canvas.getMoneys(var20.f) + T.k();
                  var18.addElement(var20);
               }

               BoardListOnScr.gI().h = var15;
               BoardListOnScr.gI().a(var18);
               BoardListOnScr.gI().switchToMe();
               BoardListOnScr.gI().init();
               Canvas.endDlg();
               return;
            case 8:
               Canvas.load = 0;
               var15 = var1.reader().readByte();
               var16 = var1.reader().readByte();
               var17 = var1.reader().readInt();
               var5 = var1.reader().readInt();

               Vector var6;
               Avatar var7;
               int var24;
               for(var6 = new Vector(); var1.reader().available() > 0; var6.addElement(var7)) {
                  (var7 = new Avatar()).IDDB = var1.reader().readInt();
                  if (var7.IDDB == -1) {
                     var7.setName("");
                  } else {
                     if (var7.IDDB == GameMidlet.avatar.IDDB) {
                        var7 = GameMidlet.avatar;
                     }

                     var7.setName(var1.reader().readUTF());
                     var7.setMoneyNew(var1.reader().readInt());
                     var24 = var1.reader().readByte();

                     for(var9 = 0; var9 < var24; ++var9) {
                        SeriPart var26 = new SeriPart(var1.reader().readShort());
                        if (var7.IDDB != GameMidlet.avatar.IDDB) {
                           var7.addSeri(var26);
                        }
                     }

                     var9 = var1.reader().readInt();
                     var7.setExp(var9);
                     var7.isReady = var1.reader().readBoolean();
                     var7.setExp(var9);
                     var7.setMoneyNew(var7.getMoneyNew());
                     var7.idImg = var1.reader().readShort();
                  }
               }

               d.setPlayers(var15, var16, var17, var5, var6);
               TLBoardScr.b().b = true;
               BoardScr.disableReady = false;
               int var23 = var6.size();

               for(var24 = 0; var24 < var23; ++var24) {
                  Avatar var25;
                  if ((var25 = (Avatar)var6.elementAt(var24)).IDDB == var17) {
                     var25.isReady = true;
                  }

                  if (var25.IDDB == GameMidlet.avatar.IDDB) {
                     GameMidlet.avatar.setMoneyNew(var25.getMoneyNew());
                  }
               }

               if (BoardListOnScr.e != 0) {
                  byte var10000 = BoardListOnScr.e;
                  byte var10001 = BoardListOnScr.c;
               }

               d.loadMap();
               d.switchToMe();
               TLBoardScr.b();
               TLBoardScr.b(false);
               Canvas.endDlg();
               Canvas.load = 1;
               return;
            case 9:
               var15 = var1.reader().readByte();
               var16 = var1.reader().readByte();
               var17 = var1.reader().readInt();
               var12 = var1.reader().readUTF();
               if (BoardScr.setR_B(var15, var16)) {
                  BoardScr.showChat(var17, var12);
                  return;
               }
               break;
            case 11:
               var15 = var1.reader().readByte();
               var16 = var1.reader().readByte();
               var13 = var1.reader().readInt();
               Canvas.currentDialog = null;
               if (BoardScr.setR_B(var15, var16)) {
                  if (var13 == GameMidlet.avatar.IDDB) {
                     Canvas.b(T.H, new class_cu(this));
                     return;
                  }

                  BoardScr.me.playerLeave(var13);
                  return;
               }
               break;
            case 12:
               Avatar var8 = new Avatar();
               var9 = var1.reader().readByte();
               var8.IDDB = var1.reader().readInt();
               var8.setName(var1.reader().readUTF());
               var8.setMoneyNew(var1.reader().readInt());
               byte var10 = var1.reader().readByte();

               for(var2 = 0; var2 < var10; ++var2) {
                  var8.addSeri(new SeriPart(var1.reader().readShort()));
               }

               var8.direct = 0;
               var8.setExp(var1.reader().readInt());
               var8.idImg = var1.reader().readShort();
               var8.isReady = false;
               TLBoardScr.b().b = true;
               var8.isReady = false;
               d.setAt(var9, var8);
               return;
            case 14:
               var2 = var1.reader().readInt();
               var13 = var1.reader().readInt();
               if (BoardScr.isStartGame && BoardScr.numPlayer == 2) {
                  d.closeBoard(T.J);
               }

               TLBoardScr.b().b = true;
               BoardScr.me.playerLeave(var2);
               BoardScr.setOwner(var13);
               return;
            case 16:
               var2 = var1.reader().readInt();
               boolean var14 = var1.reader().readBoolean();
               if (var2 == GameMidlet.avatar.IDDB) {
                  Canvas.endDlg();
               }

               BoardScr.setReady(var2, var14);
               return;
            case 19:
               var15 = var1.reader().readByte();
               var16 = var1.reader().readByte();
               var13 = var1.reader().readInt();
               if (BoardScr.setR_B(var15, var16)) {
                  d.setMoney(var13);
                  return;
               }
               break;
            case 52:
               var1.reader().readByte();
               var1.reader().readByte();
               var2 = var1.reader().readInt();
               int var3 = var1.reader().readInt();
               var12 = var1.reader().readUTF();
               Avatar var4 = BoardScr.getAvatarByID(var2);
               if (var3 != 0 && var4 != null) {
                  var4.setMoneyNew(var4.getMoneyNew() + var3);
                  if (GameMidlet.avatar.IDDB == var2) {
                     GameMidlet.avatar.setMoneyNew(var4.getMoneyNew());
                  }

                  BoardScr.showChat(var2, var12);
                  BoardScr.showFlyText(var2, var3);
                  return;
               }

               return;
            case 61:
               switch (var1.reader().readByte()) {
                  case 3:
                     TienLenMsgHandler.a();
                     break;
                  case 7:
                     PhomMsgHandler.a();
                     break;
                  case 21:
                     DiamondMessageHandler.a();
                     break;
                  case 22:
                     BoardScr.numPlayer = 5;
                     BoardListOnScr.e = BoardListOnScr.d;
                     RoomListOnScr.a(3, BCBoardScr.gI());
                     if (class_da.a == null) {
                        class_da.a = new class_da();
                     }

                     a.c = class_da.a;
                     break;
                  default:
                     return;
               }

               Canvas.startWaitDlg(T.b);
               CasinoService.gI().b();
               return;
            default:
               this.c.onMessage(var1);
               return;
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }

   }
}

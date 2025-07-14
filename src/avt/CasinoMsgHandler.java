package avt;

import java.util.Vector;
import main.GameCanvas;
import main.GameMidlet;

public final class CasinoMsgHandler extends IService implements IMiniGameMsgHandler {
   public static CasinoMsgHandler a = new CasinoMsgHandler();
   public IMiniGameMsgHandler c;
   public static BoardScr d;

   public static void a() {
      GlobalMessageHandler.a().a = a;
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

               while(var1.b().available() > 0) {
                  RoomInfo var19;
                  (var19 = new RoomInfo()).a = var1.b().readByte();
                  var19.b = var1.b().readByte();
                  var1.b().readByte();
                  var19.c = var1.b().readByte();
                  var21.addElement(var19);
               }

               RoomListOnScr.b().a(var21);
               RoomListOnScr.b().a();
               GameCanvas.h();
               return;
            case 7:
               Vector var18 = new Vector();
               var15 = var1.b().readByte();

               while(var1.b().available() > 0) {
                  class_dl var20;
                  (var20 = new class_dl()).a = var1.b().readByte();
                  var5 = var1.b().readUnsignedByte();
                  var20.b = (byte)(var5 % 16);
                  var20.c = (byte)(var5 / 16);
                  int var22 = var1.b().readUnsignedByte();
                  var20.d = (var22 & 1) != 0;
                  var20.e = (var22 & 2) != 0;
                  var20.f = var1.b().readInt();
                  var20.g = GameCanvas.b(var20.f) + T1.k();
                  var18.addElement(var20);
               }

               BoardListOnScr.b().h = var15;
               BoardListOnScr.b().a(var18);
               BoardListOnScr.b().a();
               BoardListOnScr.b().g();
               GameCanvas.h();
               return;
            case 8:
               GameCanvas.J = 0;
               var15 = var1.b().readByte();
               var16 = var1.b().readByte();
               var17 = var1.b().readInt();
               var5 = var1.b().readInt();

               Vector var6;
               Avatar var7;
               int var24;
               for(var6 = new Vector(); var1.b().available() > 0; var6.addElement(var7)) {
                  (var7 = new Avatar()).w = var1.b().readInt();
                  if (var7.w == -1) {
                     var7.a("");
                  } else {
                     if (var7.w == GameMidlet.i.w) {
                        var7 = GameMidlet.i;
                     }

                     var7.a(var1.b().readUTF());
                     var7.b(var1.b().readInt());
                     var24 = var1.b().readByte();

                     for(var9 = 0; var9 < var24; ++var9) {
                        SeriPart var26 = new SeriPart(var1.b().readShort());
                        if (var7.w != GameMidlet.i.w) {
                           var7.a(var26);
                        }
                     }

                     var9 = var1.b().readInt();
                     var7.d(var9);
                     var7.o = var1.b().readBoolean();
                     var7.d(var9);
                     var7.b(var7.c());
                     var7.X = var1.b().readShort();
                  }
               }

               d.a(var15, var16, var17, var5, var6);
               TLBoardScr.b().b = true;
               BoardScr.k = false;
               int var23 = var6.size();

               for(var24 = 0; var24 < var23; ++var24) {
                  Avatar var25;
                  if ((var25 = (Avatar)var6.elementAt(var24)).w == var17) {
                     var25.o = true;
                  }

                  if (var25.w == GameMidlet.i.w) {
                     GameMidlet.i.b(var25.c());
                  }
               }

               if (BoardListOnScr.e != 0) {
                  byte var10000 = BoardListOnScr.e;
                  byte var10001 = BoardListOnScr.c;
               }

               d.p();
               d.a();
               TLBoardScr.b();
               TLBoardScr.b(false);
               GameCanvas.h();
               GameCanvas.J = 1;
               return;
            case 9:
               var15 = var1.b().readByte();
               var16 = var1.b().readByte();
               var17 = var1.b().readInt();
               var12 = var1.b().readUTF();
               if (BoardScr.a(var15, var16)) {
                  BoardScr.a(var17, var12);
                  return;
               }
               break;
            case 11:
               var15 = var1.b().readByte();
               var16 = var1.b().readByte();
               var13 = var1.b().readInt();
               GameCanvas.v = null;
               if (BoardScr.a(var15, var16)) {
                  if (var13 == GameMidlet.i.w) {
                     GameCanvas.b(T1.H, new class_cu(this));
                     return;
                  }

                  BoardScr.i.e(var13);
                  return;
               }
               break;
            case 12:
               Avatar var8 = new Avatar();
               var9 = var1.b().readByte();
               var8.w = var1.b().readInt();
               var8.a(var1.b().readUTF());
               var8.b(var1.b().readInt());
               byte var10 = var1.b().readByte();

               for(var2 = 0; var2 < var10; ++var2) {
                  var8.a(new SeriPart(var1.b().readShort()));
               }

               var8.K = 0;
               var8.d(var1.b().readInt());
               var8.X = var1.b().readShort();
               var8.o = false;
               TLBoardScr.b().b = true;
               var8.o = false;
               d.a(var9, var8);
               return;
            case 14:
               var2 = var1.b().readInt();
               var13 = var1.b().readInt();
               if (BoardScr.j && BoardScr.H == 2) {
                  d.c(T1.J);
               }

               TLBoardScr.b().b = true;
               BoardScr.i.e(var2);
               BoardScr.f(var13);
               return;
            case 16:
               var2 = var1.b().readInt();
               boolean var14 = var1.b().readBoolean();
               if (var2 == GameMidlet.i.w) {
                  GameCanvas.h();
               }

               BoardScr.b(var2, var14);
               return;
            case 19:
               var15 = var1.b().readByte();
               var16 = var1.b().readByte();
               var13 = var1.b().readInt();
               if (BoardScr.a(var15, var16)) {
                  d.g(var13);
                  return;
               }
               break;
            case 52:
               var1.b().readByte();
               var1.b().readByte();
               var2 = var1.b().readInt();
               int var3 = var1.b().readInt();
               var12 = var1.b().readUTF();
               Avatar var4 = BoardScr.h(var2);
               if (var3 != 0 && var4 != null) {
                  var4.b(var4.c() + var3);
                  if (GameMidlet.i.w == var2) {
                     GameMidlet.i.b(var4.c());
                  }

                  BoardScr.a(var2, var12);
                  BoardScr.c(var2, var3);
                  return;
               }

               return;
            case 61:
               switch (var1.b().readByte()) {
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
                     BoardScr.H = 5;
                     BoardListOnScr.e = BoardListOnScr.d;
                     RoomListOnScr.a(3, BCBoardScr.b());
                     if (class_da.a == null) {
                        class_da.a = new class_da();
                     }

                     a.c = class_da.a;
                     break;
                  default:
                     return;
               }

               GameCanvas.c(T1.b);
               CasinoService.a().b();
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

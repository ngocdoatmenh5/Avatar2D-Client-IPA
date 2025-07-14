package avt;

import java.util.Vector;
import main.Canvas;

public final class TienLenMsgHandler extends IService implements IMiniGameMsgHandler {
   private static TienLenMsgHandler a = new TienLenMsgHandler();

   public static void a() {
      BoardScr.numPlayer = 4;
      BoardListOnScr.type = BoardListOnScr.c;
      RoomListOnScr.setName(0, TLBoardScr.b());
      CasinoMsgHandler.me.miniGameMessageHandler = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2 = var1.reader().readByte();
         int var3 = var1.reader().readByte();
         if (!BoardScr.setR_B((byte)var2, (byte)var3)) {
            return;
         }

         System.out.println("tienlen: " + var1.a);
         int var5;
         byte var13;
         byte var14;
         int var15;
         switch (var1.a) {
            case 20:
               var14 = var1.reader().readByte();
               Vector var17 = new Vector();

               for(var15 = 0; var15 < 13; ++var15) {
                  var17.addElement(new Card(var1.reader().readByte()));
               }

               var15 = var1.reader().readInt();
               Canvas.endDlg();
               BoardScr.resetReady();
               TLBoardScr.b().a(var15, var14, var17);
               CasinoService var11 = CasinoService.gI();

               try {
                  var11.createMessageWithBoard((byte)53);
               } catch (Exception var6) {
               }

               var11.sendMessage();
               return;
            case 21:
               var5 = var1.reader().readInt();
               byte[] var16 = new byte[var14 = var1.reader().readByte()];

               for(var15 = 0; var15 < var14; ++var15) {
                  var16[var15] = var1.reader().readByte();
               }

               var15 = var1.reader().readInt();
               BoardScr.disableReady = true;
               TLBoardScr.b().a(var5, var16, var15);
               TLBoardScr.b().setPosPlaying();
               return;
            case 49:
               var2 = var1.reader().readInt();
               var3 = var1.reader().readInt();
               boolean var10 = var1.reader().readBoolean();
               TLBoardScr.b().a(var2, var3, var10);
               return;
            case 50:
               TLBoardScr.b().b = false;
               TLBoardScr.b();
               TLBoardScr.m();
               if (var1.reader().available() > 0) {
                  var2 = var1.reader().readInt();
                  byte[] var18 = new byte[var13 = var1.reader().readByte()];

                  for(var5 = 0; var5 < var13; ++var5) {
                     var18[var5] = var1.reader().readByte();
                  }

                  TLBoardScr.b().a(var2, var18);
                  return;
               }
               break;
            case 51:
               var2 = var1.reader().readInt();
               var13 = var1.reader().readByte();
               var15 = var1.reader().readInt();
               int var9 = var1.reader().readInt();
               TLBoardScr.b();
               TLBoardScr.a(var2, var13, var15, var9);
               return;
            case 53:
               var3 = var1.reader().readInt();
               byte[] var12 = new byte[13];

               try {
                  for(var15 = 0; var15 < 13; ++var15) {
                     var12[var15] = var1.reader().readByte();
                  }
               } catch (Exception var7) {
                  var12 = null;
               }

               Canvas.endDlg();
               TLBoardScr.b();
               TLBoardScr.m();
               if (var12 != null) {
                  TLBoardScr.b().a(var3, var12);
               }

               BoardScr.showChat(var3, T.K);
               return;
            case 54:
               String var4 = var1.reader().readUTF();
               TLBoardScr.b().b(var4);
            default:
               return;
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }
}

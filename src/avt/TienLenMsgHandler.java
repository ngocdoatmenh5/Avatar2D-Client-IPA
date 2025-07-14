package avt;

import java.util.Vector;
import main.Canvas;

public final class TienLenMsgHandler extends IService implements IMiniGameMsgHandler {
   private static TienLenMsgHandler a = new TienLenMsgHandler();

   public static void a() {
      BoardScr.H = 4;
      BoardListOnScr.e = BoardListOnScr.c;
      RoomListOnScr.a(0, TLBoardScr.b());
      CasinoMsgHandler.a.c = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2 = var1.b().readByte();
         int var3 = var1.b().readByte();
         if (!BoardScr.a((byte)var2, (byte)var3)) {
            return;
         }

         System.out.println("tienlen: " + var1.a);
         int var5;
         byte var13;
         byte var14;
         int var15;
         switch (var1.a) {
            case 20:
               var14 = var1.b().readByte();
               Vector var17 = new Vector();

               for(var15 = 0; var15 < 13; ++var15) {
                  var17.addElement(new Card(var1.b().readByte()));
               }

               var15 = var1.b().readInt();
               Canvas.h();
               BoardScr.r();
               TLBoardScr.b().a(var15, var14, var17);
               CasinoService var11 = CasinoService.a();

               try {
                  var11.b((byte)53);
               } catch (Exception var6) {
               }

               var11.k();
               return;
            case 21:
               var5 = var1.b().readInt();
               byte[] var16 = new byte[var14 = var1.b().readByte()];

               for(var15 = 0; var15 < var14; ++var15) {
                  var16[var15] = var1.b().readByte();
               }

               var15 = var1.b().readInt();
               BoardScr.k = true;
               TLBoardScr.b().a(var5, var16, var15);
               TLBoardScr.b().f();
               return;
            case 49:
               var2 = var1.b().readInt();
               var3 = var1.b().readInt();
               boolean var10 = var1.b().readBoolean();
               TLBoardScr.b().a(var2, var3, var10);
               return;
            case 50:
               TLBoardScr.b().b = false;
               TLBoardScr.b();
               TLBoardScr.m();
               if (var1.b().available() > 0) {
                  var2 = var1.b().readInt();
                  byte[] var18 = new byte[var13 = var1.b().readByte()];

                  for(var5 = 0; var5 < var13; ++var5) {
                     var18[var5] = var1.b().readByte();
                  }

                  TLBoardScr.b().a(var2, var18);
                  return;
               }
               break;
            case 51:
               var2 = var1.b().readInt();
               var13 = var1.b().readByte();
               var15 = var1.b().readInt();
               int var9 = var1.b().readInt();
               TLBoardScr.b();
               TLBoardScr.a(var2, var13, var15, var9);
               return;
            case 53:
               var3 = var1.b().readInt();
               byte[] var12 = new byte[13];

               try {
                  for(var15 = 0; var15 < 13; ++var15) {
                     var12[var15] = var1.b().readByte();
                  }
               } catch (Exception var7) {
                  var12 = null;
               }

               Canvas.h();
               TLBoardScr.b();
               TLBoardScr.m();
               if (var12 != null) {
                  TLBoardScr.b().a(var3, var12);
               }

               BoardScr.a(var3, T1.K);
               return;
            case 54:
               String var4 = var1.b().readUTF();
               TLBoardScr.b().b(var4);
            default:
               return;
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }
}

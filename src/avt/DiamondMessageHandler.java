package avt;

import java.util.Vector;
import main.GameCanvas;

public final class DiamondMessageHandler extends IService implements IMiniGameMsgHandler {
   private static DiamondMessageHandler a = new DiamondMessageHandler();

   public static void a() {
      BoardScr.H = 2;
      BoardListOnScr.e = 0;
      RoomListOnScr.a(2, DiamondScr.b());
      CasinoMsgHandler.a.c = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2 = var1.b().readByte();
         int var3 = var1.b().readByte();
         if (BoardScr.a((byte)var2, (byte)var3)) {
            Vector var4;
            byte var11;
            byte var12;
            int var18;
            switch (var1.a) {
               case 20:
                  var12 = var1.b().readByte();
                  var3 = var1.b().readInt();
                  byte[][] var17 = new byte[8][8];

                  for(var18 = 0; var18 < 8; ++var18) {
                     for(int var21 = 0; var21 < 8; ++var21) {
                        var17[var18][var21] = var1.b().readByte();
                     }
                  }

                  for(var18 = 0; var18 < 2; ++var18) {
                     Avatar var20;
                     (var20 = BoardScr.h(var1.b().readInt())).an = var1.b().readShort();
                     var20.aj = var20.ak = 0;
                     var20.ah = var20.al = var1.b().readShort();
                     var20.ai = var1.b().readShort();
                     var20.am = var1.b().readShort();
                     var20.G <<= 1;
                     var20.e(4);
                  }

                  DiamondScr.b().a(var3, var12, var17);
                  return;
               case 21:
                  var18 = var1.b().readInt();
                  byte var22 = var1.b().readByte();
                  var11 = var1.b().readByte();
                  DiamondScr.b().a(var18, var22, var11);
                  return;
               case 24:
                  var2 = var1.b().readInt();
                  byte[][] var15 = new byte[8][8];

                  for(int var14 = 0; var14 < 8; ++var14) {
                     for(var18 = 0; var18 < 8; ++var18) {
                        var15[var14][var18] = var1.b().readByte();
                     }
                  }

                  DiamondScr.b().a(var2, var15);
                  return;
               case 49:
                  int var10 = var1.b().readInt();
                  DiamondScr.b().b(var10);
                  return;
               case 51:
                  var4 = new Vector();

                  for(var18 = 0; var18 < 2; ++var18) {
                     var2 = var1.b().readInt();
                     var3 = var1.b().readInt();
                     Avatar var16;
                     Avatar var10000 = var16 = BoardScr.h(var2);
                     var10000.G /= 2;
                     var16.H = 0;
                     var16.b(var16.c() + var3);
                     if (var3 != 0) {
                        GameCanvas.a(var3, var16.aw, var16.ax, -1, 30);
                        String var19 = var16.x + ": ";
                        if (var3 > 0) {
                           DiamondScr.b().b = var16.w;
                           var19 = var19 + T1.aP + "   +" + var3 + T1.C;
                        } else {
                           var19 = var19 + T1.aQ + "  " + var3 + T1.C;
                        }

                        var4.addElement("  ");
                        var4.addElement(var19);
                     }
                  }

                  DiamondScr.b().a(var4);
                  return;
               case 64:
                  byte[] var6 = new byte[var18 = var1.b().readByte()];
                  AvPosition[] var7 = new AvPosition[var18];

                  for(var2 = 0; var2 < var18; ++var2) {
                     var7[var2] = new AvPosition();
                     var6[var2] = var1.b().readByte();
                     var7[var2].c = var1.b().readByte();
                     var7[var2].d = var1.b().readByte();
                  }

                  var12 = var1.b().readByte();
                  var11 = var1.b().readByte();
                  var4 = new Vector();

                  for(var18 = 0; var18 < var11; ++var18) {
                     String var8 = var1.b().readUTF();
                     var4.addElement(var8);
                  }

                  for(var18 = 0; var18 < 2; ++var18) {
                     Avatar var13;
                     (var13 = BoardScr.h(var1.b().readInt())).af = var1.b().readByte();
                     var13.an = var1.b().readShort();
                     var13.aj = (short)(var1.b().readShort() - var13.ah);
                     var13.ak = (short)(var1.b().readShort() - var13.ai);
                     var13.ad = var1.b().readBoolean();
                     if (var13.ad) {
                        DiamondScr.b().c = true;
                     }
                  }

                  DiamondScr.b().a(var6, var7, var12, var4);
                  return;
               case 71:
                  byte[][] var5 = new byte[8][];

                  for(var2 = 0; var2 < 8; ++var2) {
                     var5[var2] = new byte[8];
                  }

                  for(var2 = 0; var2 < 8; ++var2) {
                     for(var3 = 0; var3 < 8; ++var3) {
                        var5[var2][var3] = var1.b().readByte();
                     }
                  }

                  DiamondScr.b().a(var5);
                  return;
               default:
            }
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }
   }
}

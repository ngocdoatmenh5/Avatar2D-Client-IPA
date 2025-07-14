package avt;

import java.util.Vector;
import main.Canvas;

public final class HomeMsgHandler extends IService implements IMiniGameMsgHandler {
   public static HomeMsgHandler a = new HomeMsgHandler();

   public static void a() {
      GlobalMessageHandler.a().a = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2;
         int var7;
         short var17;
         Vector var18;
         short var19;
         switch (var1.a) {
            case -75:
               int var12 = var1.b().readInt();
               Canvas.u.a(T1.t, new class_a(this, var12), 0);
            default:
               return;
            case -73:
               var19 = var1.b().readShort();
               byte[] var22 = new byte[var1.b().readInt()];
               var1.b().read(var22);
               HouseScr.b().a((byte[])var22, var19);
               return;
            case -67:
               byte var14 = var1.b().readByte();
               byte var16 = -1;
               var17 = 0;
               var18 = null;
               if (var14 == 0) {
                  var17 = var1.b().readShort();
                  var16 = var1.b().readByte();
               } else {
                  var18 = new Vector();
                  var19 = var1.b().readShort();

                  for(var7 = 0; var7 < var19; ++var7) {
                     Avatar var21;
                     (var21 = new Avatar()).IDDB = var1.b().readInt();
                     var21.typeHome = var1.b().readByte();
                     var18.addElement(var21);
                  }
               }

               HouseScr.b().a(var14, var16, var17, var18);
               return;
            case -66:
               MapItem var13;
               (var13 = new MapItem()).b = var1.b().readShort();
               var13.x = var1.b().readByte();
               var13.y = var1.b().readByte();
               HouseScr.b().b(var13);
               return;
            case -65:
               var17 = var1.b().readByte();
               var2 = var1.b().readInt();
               short var5;
               short[] var15 = new short[var5 = var1.b().readShort()];

               for(int var6 = 0; var6 < var5; ++var6) {
                  var15[var6] = var1.b().readByte();
               }

               var19 = var1.b().readByte();
               var18 = new Vector();
               var7 = var1.b().readShort();

               for(int var8 = 0; var8 < var7; ++var8) {
                  MapItem var23;
                  (var23 = new MapItem()).b = var1.b().readShort();
                  var23.x = var1.b().readByte() * 24;
                  var23.y = var1.b().readByte() * 24;
                  var23.c = var1.b().readByte();
                  var18.addElement(var23);
               }

               Vector var20 = GlobalMessageHandler.b(var1);
               ParkMsgHandler.a();
               HouseScr.b().a((byte)var17, var2, var15, (byte)var19, var18, var20);
               return;
            case -46:
               short var9 = var1.b().readShort();
               String var11 = var1.b().readUTF();
               HouseScr.b().a(var9, var11);
               return;
            case -43:
               class_he[] var3 = new class_he[var2 = var1.b().readShort()];

               for(int var4 = 0; var4 < var2; ++var4) {
                  var3[var4] = new class_he();
                  var3[var4].a = var1.b().readUTF();
                  var3[var4].b = var1.b().readInt();
                  var3[var4].c = var1.b().readInt();
               }

               HouseScr.b().a(var3);
               return;
            case 51:
               MapScr.gI().a(ParkMsgHandler.b(var1));
               return;
            case 76:
               GlobalMessageHandler.c(var1);
               return;
            case 77:
               GlobalMessageHandler.d(var1);
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }
   }
}

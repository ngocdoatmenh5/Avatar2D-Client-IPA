package avt;

import main.GameCanvas;
import main.GameMidlet;

import java.io.IOException;

public final class ParkMsgHandler extends IService implements IMiniGameMsgHandler {
   public static ParkMsgHandler a;

   public static void a() {
      if (a == null) {
         a = new ParkMsgHandler();
      }

      GlobalMessageHandler.a().a = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var2;
         int var3;
         int var4;
         int var5;
         int var7;
         int var8;
         int var10;
         short var11;
         byte var12;
         byte var14;
         short var16;
         String var17;
         int var18;
         switch (var1.a) {
            case -69:
               GameCanvas.b(T1.dl, new class_ka(this));
               return;
            case -68:
               var14 = var1.b().readByte();
               var10 = var1.b().readInt();
               MapScr.b().a(var14, var10);
               return;
            case 51:
               MapScr.b().a(b(var1));
               return;
            case 53:
               var10 = var1.b().readInt();
               MapScr.b();
               MapScr.c(var10);
               return;
            case 54:
               GlobalMessageHandler.c(var1);
               return;
            case 55:
               GlobalMessageHandler.d(var1);
               return;
            case 57:
               var2 = var1.b().readInt();
               var12 = var1.b().readByte();
               MapScr.b();
               MapScr.a(var2, var12);
               return;
            case 58:
               var2 = var1.b().readInt();
               var3 = var1.b().readInt();
               var16 = var1.b().readShort();
               var17 = "";
               if (var16 == -1) {
                  var17 = var1.b().readUTF();
               }

               var18 = var1.b().readInt();
               var1.b().readByte();
               System.out.println("AVATAR_GIFT_GIVING: " + var1.b().available());
               var7 = var1.b().readInt();
               var8 = var1.b().readInt();
               var10 = var1.b().readInt();
               MapScr.b().a(var2, var3, var16, var17, var18, var7, var8, var10);
               return;
            case 59:
               var2 = var1.b().readInt();
               var3 = var1.b().readInt();
               var16 = var1.b().readShort();
               var17 = "";
               var18 = 0;
               if (var16 == -1) {
                  var17 = var1.b().readUTF();
               } else {
                  var18 = var1.b().readShort();
               }

               MapScr.b().a(var2, var3, var16, var17, var18);
               return;
            case 60:
               int[] var15 = new int[var14 = var1.b().readByte()];

               for(var4 = 0; var4 < var14; ++var4) {
                  var15[var4] = var1.b().readByte();
               }

               MapScr.b().a(var15);
               GameCanvas.h();
               return;
            case 78:
               return;
            case 82:
               var4 = var1.b().readInt();
               class_kv.b().b(var4);
               return;
            case 84:
               var2 = var1.b().readInt();
               var11 = var1.b().readShort();
               class_kv.b().c(var2, var11);
               return;
            case 85:
               var10 = var1.b().readInt();
               class_kv.b().e(var10);
               return;
            case 86:
               boolean var19 = var1.b().readBoolean();
               String var20 = "";
               if (!var19) {
                  var20 = var1.b().readUTF();
               }

               class_kv.b().a(var19, var20);
               return;
            case 87:
               var2 = var1.b().readInt();
               var12 = var1.b().readByte();
               class_kv.b();
               class_kv.e(var2, var12);
               return;
            case 88:
               var2 = var1.b().readInt();
               byte var13 = var1.b().readByte();
               var16 = var1.b().readByte();
               var5 = var1.b().readInt();
               var11 = var1.b().readShort();
               class_kv.b().a(var2, var13, (byte)var16, var5, var11);
               return;
            case 91:
               var2 = var1.b().readInt();
               var3 = var1.b().readShort();
               var4 = var1.b().readShort();
               byte[][] var6 = new byte[var5 = var1.b().readByte()][];

               for(var7 = 0; var7 < var5; ++var7) {
                  var8 = var1.b().readShort();
                  var6[var7] = new byte[var8];
                  var1.b().read(var6[var7]);
               }

               class_kv.b().a(var2, var3, (short)var4, var6);
               return;
            case 92:
               if (MapScr.s = var1.b().readBoolean()) {
                  GameMidlet.i.Z = var1.b().readShort();
                  return;
               }
               break;
            case 93:
               var2 = var1.b().readInt();
               var10 = var1.b().readInt();
               MapScr.b().e(var2, var10);
               return;
            default:
               return;
         }
      } catch (Exception var9) {
         var9.printStackTrace();
      }

   }

   public static Avatar b(Message var0) throws IOException {
      Avatar var1;
      (var1 = new Avatar()).w = var0.b().readInt();
      var1.a(var0.b().readUTF());
      byte var2 = var0.b().readByte();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.a(new SeriPart(var0.b().readShort()));
      }

      var1.aw = var1.C = var0.b().readShort();
      var1.ax = var1.D = var0.b().readShort();
      var1.ac = var0.b().readByte();
      var1.W = (byte)(100 - var0.b().readByte());
      var1.X = var0.b().readShort();
      var1.aa = var0.b().readShort();
      return var1;
   }
}

package avt;

import java.util.Vector;

public final class AvatarMsgHandler extends IService implements IMiniGameMsgHandler {
   private static AvatarMsgHandler a = new AvatarMsgHandler();

   public static void a() {
      GlobalMessageHandler.a().a = a;
   }

   public final void onMessage(Message var1) {
      try {
         int var3;
         BigImgInfo var10;
         byte[] var13;
         switch (var1.a) {
            case -41:
               var13 = new byte[var1.b().available()];
               var1.b().read(var13);
               AvatarData.e(var13);
               return;
            case -40:
               var13 = new byte[var1.b().available()];
               var1.b().read(var13);
               AvatarData.d(var13);
               return;
            case -37:
               var13 = new byte[var1.b().available()];
               var1.b().read(var13);
               AvatarData.b(var13);
               return;
            case -16:
               var13 = new byte[var1.b().available()];
               var1.b().read(var13);
               AvatarData.a(var13);
               return;
            case -15:
               byte[] var14 = new byte[var1.b().available()];
               var1.b().read(var14);
               AvatarData.c(var14);
               return;
            case -14:
               (var10 = new BigImgInfo()).a = var1.b().readShort();
               var10.b = var1.b().readShort();
               int var12 = var1.b().readUnsignedShort();
               var10.d = new byte[var12];

               for(var3 = 0; var3 < var12; ++var3) {
                  var10.d[var3] = var1.b().readByte();
               }

               var10.c = -1;
               if (var1.b().available() >= 2) {
                  var10.c = var1.b().readShort();
               }

               AvatarData.a(var10);
               return;
            case -11:
               Vector var2 = new Vector();
               var3 = var1.b().readByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  BigImgInfo var5;
                  (var5 = new BigImgInfo()).a = var1.b().readShort();
                  var5.b = var1.b().readShort();
                  var2.addElement(var5);
               }

               short var15 = var1.b().readShort();
               short var16 = var1.b().readShort();
               var3 = var1.b().readShort();
               short var6 = var1.b().readShort();
               short var7 = var1.b().readShort();
               byte var8 = var1.b().readByte();

               for(int var9 = 0; var9 < var8; ++var9) {
                  (var10 = new BigImgInfo()).a = var1.b().readShort();
                  var10.b = var1.b().readShort();
                  var2.addElement(var10);
               }

               var1.b().readInt();
               AvatarData.a(var2, var15, var16, var3, var6, var7);
               return;
            default:
         }
      } catch (Exception var11) {
         var11.printStackTrace();
      }
   }
}

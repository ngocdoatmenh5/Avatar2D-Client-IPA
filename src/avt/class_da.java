package avt;

public final class class_da implements IMiniGameMsgHandler {
   public static class_da a;

   public final void onMessage(Message var1) {
      try {
         int var2 = var1.reader().readByte();
         int var3 = var1.reader().readByte();
         if (!BoardScr.a((byte)var2, (byte)var3)) {
            return;
         }

         int var6;
         byte var7;
         switch (var1.a) {
            case 20:
               var7 = var1.reader().readByte();
               BCBoardScr.a.e = var7;
               BCBoardScr.a.b(var7);
               return;
            case 21:
               if ((var7 = var1.reader().readByte()) == -1) {
                  BCBoardScr.a.m();
                  BCBoardScr.a.f = false;
                  return;
               }

               if (var7 != -1) {
                  for(var3 = 0; var3 < 6; ++var3) {
                     BCBoardScr.a.d[var7][var3] = var1.reader().readByte();
                  }

                  BCBoardScr.a.c(var7);
                  return;
               }
               break;
            case 37:
               byte[] var10 = new byte[3];

               for(var2 = 0; var2 < 3; ++var2) {
                  var10[var2] = var1.reader().readByte();
               }

               BCBoardScr.a.a(var10);
               BoardScr.o();
               return;
            case 49:
               return;
            case 51:
               int[] var8 = new int[BoardScr.m.size()];

               for(var3 = 0; var3 < var8.length; ++var3) {
                  var8[var3] = var1.reader().readInt();
               }

               BCBoardScr.a.a(var8);
               return;
            case 60:
               var7 = var1.reader().readByte();
               byte var9 = var1.reader().readByte();
               var6 = var1.reader().readInt();
               BCBoardScr.a.a(var7, var9, var6);
               return;
            case 62:
               var2 = var1.reader().readByte();
               BCBoardScr.a.e = (byte)var2;

               for(var3 = 0; var3 < BoardScr.m.size(); ++var3) {
                  for(var2 = 0; var2 < 6; ++var2) {
                     BCBoardScr.a.d[var3][var2] = var1.reader().readByte();
                  }
               }

               BCBoardScr.a.i();
            default:
               return;
            case 65:
               var2 = var1.reader().readByte();
               var3 = var1.reader().readByte();
               byte var4 = var1.reader().readByte();
               var6 = var1.reader().readByte();
               if (var3 != var4 && var6 > 0) {
                  BCBoardScr.a.d[var2][var4] = (byte)var6;
                  BCBoardScr.a.a((byte)var2, (byte)var3, (byte)var4);
                  return;
               }
               break;
            case 100:
               var2 = var1.reader().readByte();
               BCBoardScr.a.a((byte)var2);
               return;
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }
}

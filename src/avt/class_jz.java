package avt;

import main.Canvas;

public final class class_jz implements IMiniGameMsgHandler {
   public static class_jz a;

   public final void onMessage(Message var1) {
      try {
         int var2;
         int var6;
         int var12;
         short var14;
         int var15;
         switch (var1.a) {
            case 1:
               if (var1.b().readByte() == 0) {
                  PetRace[] var13 = new PetRace[6];

                  for(var12 = 0; var12 < 6; ++var12) {
                     var13[var12] = new PetRace(this);
                     var13[var12].g = 0;
                     var13[var12].IDDB = var1.b().readByte();
                     var13[var12].a = var1.b().readByte();
                     var13[var12].c = var1.b().readShort();
                     var13[var12].d = var1.b().readShort();
                  }

                  var14 = var1.b().readShort();
                  RaceScr.b().a(var13, var14, false, true);
                  return;
               } else if (!var1.b().readBoolean()) {
                  PetRace[] var17 = new PetRace[6];

                  for(var15 = 0; var15 < 6; ++var15) {
                     var17[var15] = new PetRace(this);
                     var17[var15].g = 0;
                     var17[var15].IDDB = var1.b().readByte();
                     var17[var15].c = var1.b().readShort();
                     byte var19 = var1.b().readByte();
                     var17[var15].e = new short[var19];
                     var17[var15].f = new short[var19];

                     for(var6 = 0; var6 < var19; ++var6) {
                        var17[var15].e[var6] = var1.b().readShort();
                        var17[var15].f[var6] = var1.b().readShort();
                     }
                  }

                  short var18 = var1.b().readShort();
                  RaceScr.b().n = var1.b().readShort();
                  RaceScr.b().o = System.currentTimeMillis();
                  RaceScr.b().a(var17, var18, false, false);
                  return;
               } else {
                  for(var12 = 0; var12 < 6; ++var12) {
                     var15 = var1.b().readByte();
                     RaceScr.b().c[var12].e = new short[var15];
                     RaceScr.b().c[var12].f = new short[var15];

                     for(var2 = 0; var2 < var15; ++var2) {
                        RaceScr.b().c[var12].e[var2] = var1.b().readShort();
                        RaceScr.b().c[var12].f[var2] = var1.b().readShort();
                        RaceScr.b();
                     }
                  }

                  var14 = var1.b().readShort();
                  RaceScr.b().n = var1.b().readShort();
                  RaceScr.b().o = System.currentTimeMillis();
                  RaceScr.b().a((PetRace[])null, var14, true, false);
                  return;
               }
            case 2:
               short var16 = var1.b().readShort();
               String var10 = var1.b().readUTF();
               var6 = var1.b().readShort();
               var14 = var1.b().readByte();
               var15 = var1.b().readByte();
               byte var9 = var1.b().readByte();
               RaceScr.b().a(var16, var10, (short)var6, (byte)var14, (byte)var15, var9);
               return;
            case 5:
               var2 = var1.b().readByte();
               int var8 = var1.b().readInt();

               for(var12 = 0; var12 < RaceScr.b().c.length; ++var12) {
                  if (var2 == RaceScr.b().c[var12].IDDB) {
                     RaceScr.b().c[var12].g = var8;
                     RaceScr.b().g = (byte)var12;
                     break;
                  }
               }

               Canvas.h();
               return;
            case 8:
               short[] var11 = new short[var2 = var1.b().readByte()];
               String[] var4 = new String[var2];

               for(int var5 = 0; var5 < var2; ++var5) {
                  var11[var5] = var1.b().readShort();
                  var4[var5] = var1.b().readUTF();
               }

               if (var2 > 0) {
                  Canvas.v = new HistoryPopup(this, var11, var4);
                  return;
               }

               Canvas.h();
               return;
            case 9:
               String var3 = var1.b().readUTF();
               RaceScr.b().b(var3);
               return;
            case 10:
               RaceScr.b().l = new dialogWin();
               RaceScr.b().l.b = var1.b().readByte();
               RaceScr.b().l.a = var1.b().readUTF();
               RaceScr.b();
               var1.b().readByte();
               RaceScr.b().l.c = var1.b().readInt();
               RaceScr.b().l.d = var1.b().readInt();
               RaceScr.b().l.e = var1.b().readInt();
               RaceScr.b().l.f = var1.b().readInt();
            case 3:
            case 4:
            case 6:
            case 7:
            default:
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }
   }
}

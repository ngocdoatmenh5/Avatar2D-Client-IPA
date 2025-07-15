package avt;

import main.Canvas;

public final class RaceMsgHandler implements IMiniGameMsgHandler {
   public static RaceMsgHandler instance;

   public final void onMessage(Message var1) {
      try {
         int var2;
         int var6;
         int var12;
         short var14;
         int var15;
         switch (var1.command) {
            case 1:
               if (var1.reader().readByte() == 0) {
                  PetRace[] var13 = new PetRace[6];

                  for(var12 = 0; var12 < 6; ++var12) {
                     var13[var12] = new PetRace(this);
                     var13[var12].money = 0;
                     var13[var12].IDDB = var1.reader().readByte();
                     var13[var12].rate = var1.reader().readByte();
                     var13[var12].idImg = var1.reader().readShort();
                     var13[var12].idIcon = var1.reader().readShort();
                  }

                  var14 = var1.reader().readShort();
                  RaceScr.gI().doOpenRace(var13, var14, false, true);
                  return;
               } else if (!var1.reader().readBoolean()) {
                  PetRace[] var17 = new PetRace[6];

                  for(var15 = 0; var15 < 6; ++var15) {
                     var17[var15] = new PetRace(this);
                     var17[var15].money = 0;
                     var17[var15].IDDB = var1.reader().readByte();
                     var17[var15].idImg = var1.reader().readShort();
                     byte var19 = var1.reader().readByte();
                     var17[var15].numTick = new short[var19];
                     var17[var15].vTick = new short[var19];

                     for(var6 = 0; var6 < var19; ++var6) {
                        var17[var15].numTick[var6] = var1.reader().readShort();
                        var17[var15].vTick[var6] = var1.reader().readShort();
                     }
                  }

                  short var18 = var1.reader().readShort();
                  RaceScr.gI().timeStart = var1.reader().readShort();
                  RaceScr.gI().curTimeStart = System.currentTimeMillis();
                  RaceScr.gI().doOpenRace(var17, var18, false, false);
                  return;
               } else {
                  for(var12 = 0; var12 < 6; ++var12) {
                     var15 = var1.reader().readByte();
                     RaceScr.gI().listPet[var12].numTick = new short[var15];
                     RaceScr.gI().listPet[var12].vTick = new short[var15];

                     for(var2 = 0; var2 < var15; ++var2) {
                        RaceScr.gI().listPet[var12].numTick[var2] = var1.reader().readShort();
                        RaceScr.gI().listPet[var12].vTick[var2] = var1.reader().readShort();
                        RaceScr.gI();
                     }
                  }

                  var14 = var1.reader().readShort();
                  RaceScr.gI().timeStart = var1.reader().readShort();
                  RaceScr.gI().curTimeStart = System.currentTimeMillis();
                  RaceScr.gI().doOpenRace((PetRace[])null, var14, true, false);
                  return;
               }
            case 2:
               short var16 = var1.reader().readShort();
               String var10 = var1.reader().readUTF();
               var6 = var1.reader().readShort();
               var14 = var1.reader().readByte();
               var15 = var1.reader().readByte();
               byte var9 = var1.reader().readByte();
               RaceScr.gI().onPetInfo(var16, var10, (short)var6, (byte)var14, (byte)var15, var9);
               return;
            case 5:
               var2 = var1.reader().readByte();
               int var8 = var1.reader().readInt();

               for(var12 = 0; var12 < RaceScr.gI().listPet.length; ++var12) {
                  if (var2 == RaceScr.gI().listPet[var12].IDDB) {
                     RaceScr.gI().listPet[var12].money = var8;
                     RaceScr.gI().indexFocus = (byte)var12;
                     break;
                  }
               }

               Canvas.endDlg();
               return;
            case 8:
               short[] var11 = new short[var2 = var1.reader().readByte()];
               String[] var4 = new String[var2];

               for(int var5 = 0; var5 < var2; ++var5) {
                  var11[var5] = var1.reader().readShort();
                  var4[var5] = var1.reader().readUTF();
               }

               if (var2 > 0) {
                  Canvas.currentDialog = new HistoryPopup(this, var11, var4);
                  return;
               }

               Canvas.endDlg();
               return;
            case 9:
               String var3 = var1.reader().readUTF();
               RaceScr.gI().onChat(var3);
               return;
            case 10:
               RaceScr.gI().diaWin = new dialogWin();
               RaceScr.gI().diaWin.b = var1.reader().readByte();
               RaceScr.gI().diaWin.name = var1.reader().readUTF();
               RaceScr.gI();
               var1.reader().readByte();
               RaceScr.gI().diaWin.tienCuoc = var1.reader().readInt();
               RaceScr.gI().diaWin.tienAn = var1.reader().readInt();
               RaceScr.gI().diaWin.tienThue = var1.reader().readInt();
               RaceScr.gI().diaWin.tienNhanDuoc = var1.reader().readInt();
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

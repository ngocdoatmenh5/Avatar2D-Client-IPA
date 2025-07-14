package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public class SubObject extends MyObject {
   public int f;
   public short g;

   public SubObject() {
      super.catagory = 1;
   }

   public SubObject(int var1, int var2, int var3, int var4) {
      super.catagory = 1;
      this.f = var1;
      super.x = var2;
      super.y = var3;
      this.g = (short)var4;
   }

   public void paint(Graphics var1) {
      if (this.f >= 0 || super.x * MyObject.hd + this.g / 2 >= AvCamera.gI().xCam && super.x * MyObject.hd - this.g / 2 <= AvCamera.gI().xCam + Canvas.m) {
         int var2 = super.x * MyObject.hd;
         int var3 = super.y * MyObject.hd;
         switch (this.f) {
            case -10:
            case -3:
               var1.drawImage(FarmScr.m, var2, var3, 40);
               return;
            case -9:
               if (Canvas.D != null) {
                  var1.drawImage(LoadMap.r, var2, var3, 3);
                  AvatarData.a(var1, 900, var2, var3 + Canvas.D.a - 10, 33);
               }
            case -4:
            case -1:
            default:
               return;
            case -8:
               a(var1, var2, var3, FarmScr.g);
               return;
            case -7:
               a(var1, var2, var3, FarmScr.h);
               return;
            case -6:
               FarmScr.s.drawFrame(0, var2, var3, 0, 3, var1);
               if (Dog.u != -1) {
                  FarmScr.s.drawFrame(1, var2, var3, 0, 3, var1);
               }

               return;
            case -5:
               FarmScr.r.drawFrame(0, var2, var3, 0, 3, var1);
               if (Cattle.v != -1) {
                  FarmScr.r.drawFrame(2, var2, var3, 0, 3, var1);
               }

               return;
            case -2:
               if (FarmScr.E != -1) {
                  FarmScr.t.drawFrame(FarmScr.F, var2, var3, GameMidlet.avatar.direct == Base.LEFT ? 2 : 0, 3, var1);
               }

               return;
            case 0:
               AvatarData.a(var1, 243, var2, var3, 33);
         }
      }
   }

   private static void a(Graphics var0, int var1, int var2, Vector var3) {
      for(int var4 = 0; var4 < var3.size(); ++var4) {
         AvPosition var5;
         if ((var5 = (AvPosition)var3.elementAt(var4)).a * MyObject.hd == var1 && var5.b * MyObject.hd == var2) {
            AnimalInfo var6;
            if ((var6 = FarmData.getAnimalByID(var5.c)).iconO != -1) {
               AvatarData.a(var0, var6.iconO, var1, var2, 3);
            }

            for(int var7 = 0; var7 < FarmScr.i.size(); ++var7) {
               Animal var8;
               if ((var8 = (Animal)FarmScr.i.elementAt(var7)).species == var5.c && var8.numEggOne > 0) {
                  AvatarData.a(var0, var6.iconProduct, var1, var2, 3);
                  return;
               }
            }
         }
      }

   }
}

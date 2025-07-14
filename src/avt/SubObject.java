package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

public class SubObject extends MyObject {
   public int f;
   public short g;

   public SubObject() {
      super.az = 1;
   }

   public SubObject(int var1, int var2, int var3, int var4) {
      super.az = 1;
      this.f = var1;
      super.aw = var2;
      super.ax = var3;
      this.g = (short)var4;
   }

   public void a(Graphics var1) {
      if (this.f >= 0 || super.aw * MyObject.ay + this.g / 2 >= AvCamera.a().a && super.aw * MyObject.ay - this.g / 2 <= AvCamera.a().a + GameCanvas.m) {
         int var2 = super.aw * MyObject.ay;
         int var3 = super.ax * MyObject.ay;
         switch (this.f) {
            case -10:
            case -3:
               var1.drawImage(FarmScr.m, var2, var3, 40);
               return;
            case -9:
               if (GameCanvas.D != null) {
                  var1.drawImage(LoadMap.r, var2, var3, 3);
                  AvatarData.a(var1, 900, var2, var3 + GameCanvas.D.a - 10, 33);
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
               FarmScr.s.a(0, var2, var3, 0, 3, var1);
               if (Dog.u != -1) {
                  FarmScr.s.a(1, var2, var3, 0, 3, var1);
               }

               return;
            case -5:
               FarmScr.r.a(0, var2, var3, 0, 3, var1);
               if (Cattle.v != -1) {
                  FarmScr.r.a(2, var2, var3, 0, 3, var1);
               }

               return;
            case -2:
               if (FarmScr.E != -1) {
                  FarmScr.t.a(FarmScr.F, var2, var3, GameMidlet.i.K == Base.J ? 2 : 0, 3, var1);
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
         if ((var5 = (AvPosition)var3.elementAt(var4)).a * MyObject.ay == var1 && var5.b * MyObject.ay == var2) {
            AnimalInfo var6;
            if ((var6 = FarmData.c(var5.c)).i != -1) {
               AvatarData.a(var0, var6.i, var1, var2, 3);
            }

            for(int var7 = 0; var7 < FarmScr.i.size(); ++var7) {
               Animal var8;
               if ((var8 = (Animal)FarmScr.i.elementAt(var7)).k == var5.c && var8.o > 0) {
                  AvatarData.a(var0, var6.h, var1, var2, 3);
                  return;
               }
            }
         }
      }

   }
}

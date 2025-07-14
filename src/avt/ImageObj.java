package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class ImageObj extends SubObject {
   private Image a;

   public ImageObj(int var1, int var2, int var3, int var4) {
      super(var1, var2, var3, 0);
      FilePack.b(T1.at);
      this.a = FilePack.a("" + var1);
      if (this.a != null) {
         this.a.getWidth();
      }

      FilePack.a();
   }

   public final void b() {
   }

   public final void a(Graphics var1) {
      if (this.a == null) {
         super.g = AvatarData.c((short)super.f).b;
         AvatarData.a(var1, super.f, super.aw * MyObject.ay, super.ax * MyObject.ay, 33);
      } else {
         var1.drawImage(this.a, super.aw * MyObject.ay, super.ax * MyObject.ay, 33);
      }

      if (super.f == 846) {
         GameCanvas.N.a(var1, String.valueOf(MapScr.c), super.aw * MyObject.ay, super.ax * MyObject.ay - 30 * MyObject.ay, 2);
      } else {
         if (super.f == 1029 && FarmScr.V != 0) {
            FarmItem var2 = FarmScr.b(FarmData.b(FarmScr.V).b);
            String var3 = "";
            int var4;
            if ((var4 = FarmScr.U / 3600) > 0) {
               var3 = var4 + ":";
            }

            int var5;
            if ((var5 = (FarmScr.U - var4 * 3600) / 60) > 0 || var4 > 0) {
               var3 = var3 + var5 + ":";
            }

            var4 = FarmScr.U - var4 * 3600 - var5 * 60;
            var3 = var3 + var4;
            if (FarmScr.U == 0) {
               var3 = "hoan thanh";
            }

            FarmScr.W = super.aw - GameCanvas.Q.a(var3) / 2 / MyObject.ay;
            FarmScr.X = super.ax - AvatarData.c((short)super.f).c / MyObject.ay - 10;
            FarmData.a(var1, var2.b, super.aw * MyObject.ay - GameCanvas.Q.a(var3) / 2, super.ax * MyObject.ay - AvatarData.c((short)super.f).c - 10 * MyObject.ay, 3);
            GameCanvas.Q.a(var1, var3, super.aw * MyObject.ay - GameCanvas.Q.a(var3) / 2 + 10 * MyObject.ay, super.ax * MyObject.ay - AvatarData.c((short)super.f).c - 10 * MyObject.ay - AvMain.ai / 2 + 2, 0);
         }

      }
   }
}

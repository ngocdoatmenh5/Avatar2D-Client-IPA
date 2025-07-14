package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class class_hz extends SubObject {
   private String a;
   private byte b;
   private byte c = 0;

   public class_hz(String var1, int var2, int var3) {
      super.az = 8;
      super.aw = var2;
      super.ax = var3;
      this.a = var1;
      this.b = (byte)CRes.e(8);
   }

   public final void b() {
      ++this.b;
      if (this.b >= 8) {
         this.b = 0;
      }

   }

   public final void a(Graphics var1) {
      if (OptionScr.b().b[1] != 1 && GameCanvas.D == null) {
         if (super.aw * MyObject.ay >= AvCamera.a().a && super.aw * MyObject.ay <= AvCamera.a().a + GameCanvas.m && super.ax * MyObject.ay >= AvCamera.a().b && super.ax * MyObject.ay <= AvCamera.a().b + GameCanvas.n + 10 && GameCanvas.r != MenuCenter.b()) {
            var1.drawImage(LoadMap.r, super.aw * MyObject.ay, super.ax * MyObject.ay, 3);
            if (MiniMap.gI().b != null) {
               int var10002 = super.aw * MyObject.ay;
               int var10003 = (super.ax - 10 + this.b / 2) * MyObject.ay;
               MiniMap.gI().b.a(0, var10002, var10003, 0, 33, var1);
            }

            GameCanvas.Q.a(var1, this.a, super.aw * MyObject.ay, (super.ax - 32 + this.b / 2) * MyObject.ay, 2);
         }
      }
   }
}

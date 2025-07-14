package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class class_hz extends SubObject {
   private String a;
   private byte b;
   private byte c = 0;

   public class_hz(String var1, int var2, int var3) {
      super.catagory = 8;
      super.x = var2;
      super.y = var3;
      this.a = var1;
      this.b = (byte)CRes.rnd(8);
   }

   public final void update() {
      ++this.b;
      if (this.b >= 8) {
         this.b = 0;
      }

   }

   public final void paint(Graphics var1) {
      if (OptionScr.gI().b[1] != 1 && Canvas.welcome == null) {
         if (super.x * MyObject.hd >= AvCamera.gI().xCam && super.x * MyObject.hd <= AvCamera.gI().xCam + Canvas.w && super.y * MyObject.hd >= AvCamera.gI().yCam && super.y * MyObject.hd <= AvCamera.gI().yCam + Canvas.h + 10 && Canvas.currentMyScreen != MenuCenter.gI()) {
            var1.drawImage(LoadMap.r, super.x * MyObject.hd, super.y * MyObject.hd, 3);
            if (MiniMap.gI().b != null) {
               int var10002 = super.x * MyObject.hd;
               int var10003 = (super.y - 10 + this.b / 2) * MyObject.hd;
               MiniMap.gI().b.drawFrame(0, var10002, var10003, 0, 33, var1);
            }

            Canvas.smallFontYellow.a(var1, this.a, super.x * MyObject.hd, (super.y - 32 + this.b / 2) * MyObject.hd, 2);
         }
      }
   }
}

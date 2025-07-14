package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class OnSplashScr extends MyScreen {
   public static OnSplashScr a;
   public int b = 0;
   public static Image c;
   public static boolean d = false;

   public static OnSplashScr b() {
      return a == null ? (a = new OnSplashScr()) : a;
   }

   public final void a() {
      GameCanvas.C.removeAllElements();
      GameCanvas.U = 0;
      GameCanvas.a.b();
      OnScreen.b = true;

      try {
         c = Image.createImage(T1.a() + "/on/logo.on");
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      super.a();
   }

   public final void k() {
      if (this.b > 21) {
         LoadMap.B = GameMidlet.i.aw;
         LoadMap.C = GameMidlet.i.ax;
         OnScreen.e().a();
      } else if (this.b == 0) {
         GameCanvas.S.f();
      }

      ++this.b;
   }

   public final void a(Graphics var1) {
      GameCanvas.S.b(var1);
      if (this.b > 1) {
         var1.drawImage(c, GameCanvas.o, GameCanvas.q / 2, 3);
      }

      GameCanvas.a(var1);
   }
}

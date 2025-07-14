package avt;

import java.io.IOException;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
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
      Canvas.listInfoSV.removeAllElements();
      Canvas.transTab = 0;
      Canvas.instance.b();
      OnScreen.b = true;

      try {
         c = Image.createImage(T.a() + "/on/logo.on");
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      super.a();
   }

   public final void k() {
      if (this.b > 21) {
         LoadMap.B = GameMidlet.avatar.x;
         LoadMap.C = GameMidlet.avatar.y;
         OnScreen.e().a();
      } else if (this.b == 0) {
         Canvas.paint.f();
      }

      ++this.b;
   }

   public final void paint(Graphics var1) {
      Canvas.paint.b(var1);
      if (this.b > 1) {
         var1.drawImage(c, Canvas.hw, Canvas.q / 2, 3);
      }

      Canvas.a(var1);
   }
}

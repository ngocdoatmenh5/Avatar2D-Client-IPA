package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class ChatPopup {
   private int e;
   public int a;
   public int b;
   public int c;
   private int f;
   private static short g;
   public String[] d;
   private static FrameImage[] h = new FrameImage[2];
   private static Image[] i = new Image[2];
   private byte j = 0;

   static {
      FilePack.b(T1.aw);
      g = 8;
      h[0] = FrameImage.a("c", g, g);
      h[1] = FrameImage.a("cB", g, g);
      i[0] = FilePack.a("ar");
      i[1] = FilePack.a("ara");
      FilePack.a();
   }

   public ChatPopup() {
   }

   public ChatPopup(int var1, String var2, byte var3) {
      this.j = var3;
      this.a(var1, var2);
   }

   public final void a(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final boolean a() {
      if (this.e > 0) {
         --this.e;
      }

      if (this.e == 0) {
         return true;
      } else {
         if (GameCanvas.r == BoardScr.i) {
            if (this.b - this.c < 0) {
               this.b = this.c + 10;
            }

            if (this.a - 30 < 0) {
               this.a = 32;
            }

            if (this.a + 30 > GameCanvas.m) {
               this.a = GameCanvas.m - 40;
            }
         }

         return false;
      }
   }

   public final void a(int var1, String var2) {
      this.f = 80 * AvMain.Y;
      this.d = GameCanvas.N.a(var2, this.f - 25);
      this.c = AvMain.af * this.d.length + 4 + 4;
      if (this.c < g << 1) {
         this.c = g << 1;
      }

      if (this.d.length == 1) {
         this.f = GameCanvas.N.a(this.d[0]) + 20;
      }

      if (this.f < 30 * AvMain.Y) {
         this.f = 30 * AvMain.Y;
      }

      this.e = var1;
   }

   public final void a(Graphics var1) {
      int var2 = AvMain.Y;
      if (GameCanvas.r == BoardScr.i) {
         var2 = 1;
      }

      a(var1, this.a * var2 - this.f / 2, this.b * var2 - this.c, this.f, this.c, this.j == 1 ? 16773580 : 16777215, this.j == 1 ? 14957056 : 1, this.j);
      var1.drawImage(i[this.j], this.a * var2, this.b * var2 - 1, 17);
      byte var3 = AvMain.af;

      for(int var4 = 0; var4 < this.d.length; ++var4) {
         GameCanvas.N.a(var1, this.d[var4], this.a * var2 - this.f / 2 + this.f / 2, this.b * var2 - this.c / 2 + var4 * var3 - this.d.length * var3 / 2, 2);
      }

   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, byte var7) {
      h[var7].a(0, var1, var2, 0, var0);
      h[var7].a(1, var1 + var3 - g, var2, 0, var0);
      h[var7].a(3, var1, var2 + var4 - g, 0, var0);
      h[var7].a(2, var1 + var3 - g, var2 + var4 - g, 0, var0);
      var0.setColor(var5);
      var0.fillRect(var1 + g, var2, var3 - (g << 1), g);
      var0.fillRect(var1 + g, var2 + var4 - g, var3 - (g << 1), g - 1);
      var0.fillRect(var1, var2 + g, var3, var4 - (g << 1));
      var0.setColor(var6);
      var0.fillRect(var1 + g, var2, var3 - (g << 1), 1);
      var0.fillRect(var1 + g, var2 + var4 - 1, var3 - (g << 1), 1);
      var0.fillRect(var1, var2 + g, 1, var4 - (g << 1));
      var0.fillRect(var1 + var3 - 1, var2 + g, 1, var4 - (g << 1));
   }
}

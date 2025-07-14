package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class Bus {
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private static byte h;
   private static byte i;
   public static AvPosition a;
   public static boolean b = false;
   private static boolean j = false;
   private Image k;

   public final void a(byte var1) {
      if (!b && GameMidlet.i.H != -1) {
         FilePack.b(T1.at);
         this.k = FilePack.a("839");
         FilePack.a();
         i = var1;
         if (var1 == 1) {
            AvCamera.a().a = AvCamera.a().c = a.a * AvMain.Y - GameCanvas.o - 300;
         }

         this.d = LoadMap.f * LoadMap.i + (GameCanvas.Z != 0 ? GameCanvas.T : 0) / AvMain.Y + 20 * AvMain.Y;
         this.c = a.a + 300;
         this.e = this.f = 15;
         this.g = 0;
         h = 1;
         b = true;
         GameMidlet.i.b((byte)-1);
         AvCamera.f = true;
         j = false;
         if (i == 1) {
            GameMidlet.i.L = true;
         }

      }
   }

   public final void a() {
      if ((h == 1 && i == 1 || h == -1 && i == -1) && i == -1 && !j) {
         GlobalService.gI().d((int)8);
         GameMidlet.i.L = true;
         j = true;
      }

      this.c -= this.e;
      this.g += CRes.f(this.f - this.e / 2);
      if (this.g >= 20) {
         this.g = 0;
         this.e -= h;
         if (this.e == 0) {
            h = -1;
            this.f = 8;
            GameMidlet.i.a(this.c, a.b);
            GameMidlet.i.b((byte)0);
            AvCamera.f = false;
            GameMidlet.i.L = false;
            if (GameCanvas.I && Session_ME.a().b()) {
               if (LoadMap.a == 9) {
                  (GameCanvas.D = new Welcome()).b();
               } else if (i == 1 && LoadMap.a == 25) {
                  (GameCanvas.D = new Welcome()).a((MyScreen)MapScr.a);
               } else if (LoadMap.a == 13 && Welcome.c < 8) {
                  (GameCanvas.D = new Welcome()).f();
               } else if (i == 1 && LoadMap.a == 23) {
                  (GameCanvas.D = new Welcome()).d();
               }
            }
         }
      }

      if ((this.c + 58) * AvMain.Y < AvCamera.a().a) {
         b = false;
         if (i == -1) {
            GameCanvas.i();
         }
      }

   }

   public final void a(Graphics var1) {
      int var2 = 0;
      if (this.e > 1) {
         var2 = GameCanvas.l % 6 < 3 ? 1 : 0;
      }

      var1.drawImage(this.k, this.c * AvMain.Y, (this.d + var2) * AvMain.Y - this.k.getHeight(), 17);
   }
}

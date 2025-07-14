package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
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
      if (!b && GameMidlet.avatar.action != -1) {
         FilePack.b(T.at);
         this.k = FilePack.a("839");
         FilePack.a();
         i = var1;
         if (var1 == 1) {
            AvCamera.gI().xCam = AvCamera.gI().xTo = a.x * AvMain.hd - Canvas.hw - 300;
         }

         this.d = LoadMap.Hmap * LoadMap.i + (Canvas.stypeInt != 0 ? Canvas.hTab : 0) / AvMain.hd + 20 * AvMain.hd;
         this.c = a.x + 300;
         this.e = this.f = 15;
         this.g = 0;
         h = 1;
         b = true;
         GameMidlet.avatar.setAction((byte)-1);
         AvCamera.disable = true;
         j = false;
         if (i == 1) {
            GameMidlet.avatar.ableShow = true;
         }

      }
   }

   public final void a() {
      if ((h == 1 && i == 1 || h == -1 && i == -1) && i == -1 && !j) {
         GlobalService.gI().d((int)8);
         GameMidlet.avatar.ableShow = true;
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
            GameMidlet.avatar.setPos(this.c, a.y);
            GameMidlet.avatar.setAction((byte)0);
            AvCamera.disable = false;
            GameMidlet.avatar.ableShow = false;
            if (Canvas.isDoubleImage && Session_ME.a().b()) {
               if (LoadMap.TYPEMAP == 9) {
                  (Canvas.D = new Welcome()).b();
               } else if (i == 1 && LoadMap.TYPEMAP == 25) {
                  (Canvas.D = new Welcome()).a((MyScreen)MapScr.a);
               } else if (LoadMap.TYPEMAP == 13 && Welcome.c < 8) {
                  (Canvas.D = new Welcome()).f();
               } else if (i == 1 && LoadMap.TYPEMAP == 23) {
                  (Canvas.D = new Welcome()).d();
               }
            }
         }
      }

      if ((this.c + 58) * AvMain.hd < AvCamera.gI().xCam) {
         b = false;
         if (i == -1) {
            Canvas.startWaitDlg();
         }
      }

   }

   public final void a(Graphics var1) {
      int var2 = 0;
      if (this.e > 1) {
         var2 = Canvas.gameTick % 6 < 3 ? 1 : 0;
      }

      var1.drawImage(this.k, this.c * AvMain.hd, (this.d + var2) * AvMain.hd - this.k.getHeight(), 17);
   }
}

package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class AnimateEffect extends Effect {
   private static FrameImage d;
   private static FrameImage e;
   private byte f = 0;
   private int g = 0;
   public int a;
   private int h;
   private static int i = 5;
   private static int j;
   private static int k = CRes.b(1, -1);
   private Vector l = new Vector();

   public final void a() {
      super.a();
   }

   public AnimateEffect(int var1, int var2) {
      this.f = (byte)var1;
      this.g = var2 * 10;
      if (AvMain.Y == 1) {
         this.g = var2 * 5;
      }

      this.h = (int)(System.currentTimeMillis() / 1000L);
      switch (var1) {
         case 0:
            this.g = GameCanvas.m * GameCanvas.n / 1000 + 50;
            break;
         case 1:
            this.g = 30;
            if (d == null) {
               FilePack.b(T1.av);
               d = FrameImage.a("cobay", 16 * AvMain.Y, 10 * AvMain.Y);
               FilePack.a();
            }
         case 2:
         default:
            break;
         case 3:
            this.g = GameCanvas.m * GameCanvas.n / 1000;
            FilePack.b(T1.av);
            FrameImage.a("tuyet", 5 * AvMain.Y, 5 * AvMain.Y);
            FilePack.a();
            e = d;
      }

      Point var3;
      for(var2 = 0; var2 < this.g; ++var2) {
         (var3 = new Point(0, (AvCamera.a().b - (GameCanvas.n << 1) + CRes.e(GameCanvas.n << 1)) * 10)).aw = (-GameCanvas.m / 2 + CRes.e(LoadMap.e * LoadMap.i + GameCanvas.m)) * 10;
         if (var1 != 3 && this.f != 2) {
            var3.e = CRes.e(4);
         } else {
            var3.e = CRes.e(3);
         }

         var3.g = 16 + (CRes.e(3) << 2);
         var3.c = CRes.b(-1, 1);
         var3.f = CRes.e(var3.g);
         var3.i = (byte)CRes.e(20);
         this.l.addElement(var3);
      }

      if (var1 == 2) {
         for(var2 = 0; var2 < this.l.size() - 1; ++var2) {
            var3 = (Point)this.l.elementAt(var2);

            for(var1 = var2 + 1; var1 < this.l.size(); ++var1) {
               Point var4 = (Point)this.l.elementAt(var1);
               if (var3.e > var4.e) {
                  this.l.setElementAt(var3, var1);
                  this.l.setElementAt(var4, var2);
                  var3 = var4;
               }
            }
         }
      }

   }

   public final void a(Graphics var1) {
      GameCanvas.c(var1);
      var1.translate(-AvCamera.a().a, -AvCamera.a().b);
      int var3;
      Point var4;
      AnimateEffect var6;
      Graphics var7;
      switch (this.f) {
         case 0:
            var7 = var1;
            var6 = this;
            var1.setColor(14540253);

            for(var3 = 0; var3 < var6.g; ++var3) {
               var4 = (Point)var6.l.elementAt(var3);
               int var10001 = 2 - var4.e;
               int var5 = AvCamera.a().a * var10001 * 20 / 120;
               var7.fillRect(var5 + var4.aw / 10, var4.ax / 10, 1, var4.e + 1);
            }

            return;
         case 1:
            var7 = var1;
            var6 = this;

            for(var3 = 0; var3 < var6.g; ++var3) {
               if ((var4 = (Point)var6.l.elementAt(var3)).aw * AvMain.Y / 10 > AvCamera.a().a && var4.aw * AvMain.Y / 10 < AvCamera.a().a + GameCanvas.m && var4.ax * AvMain.Y / 10 > AvCamera.a().b) {
                  d.a(var4.f / (var4.g / 4), var4.aw * AvMain.Y / 10, var4.ax * AvMain.Y / 10, 0, 3, var7);
               }
            }

            return;
         case 2:
            if (super.c == -1) {
               return;
            } else {
               EffectData var2 = AvatarData.d(super.c);

               for(var3 = 0; var3 < this.g; ++var3) {
                  ++(var4 = (Point)this.l.elementAt(var3)).h;
                  if (var4.aw * AvMain.Y / 10 > AvCamera.a().a && var4.aw * AvMain.Y / 10 < AvCamera.a().a + GameCanvas.m && var4.ax * AvMain.Y / 10 > AvCamera.a().b && var4.ax * AvMain.Y / 10 < AvCamera.a().b + GameCanvas.q) {
                     if (var2 != null) {
                        if (var4.h >= var2.a.length) {
                           var4.h = 0;
                        }

                        var2.a(var1, var4.aw / 10, var4.ax / 10, var4.h);
                     }

                     ++var4.i;
                     if (var4.i >= 20) {
                        var4.i = 0;
                     }
                  }
               }

               return;
            }
         case 3:
            for(var3 = 0; var3 < this.g; ++var3) {
               if ((var4 = (Point)this.l.elementAt(var3)).aw * AvMain.Y / 10 > AvCamera.a().a && var4.aw * AvMain.Y / 10 < AvCamera.a().a + GameCanvas.m && var4.ax * AvMain.Y / 10 > AvCamera.a().b) {
                  e.a(2 - var4.e, var4.aw * AvMain.Y / 10, var4.ax * AvMain.Y / 10, 0, var1);
               }
            }
         default:
      }
   }

   public final void b() {
      int var1 = 1;
      if (GameCanvas.l % 6 == 3) {
         var1 = CRes.e(15);
      }

      if (var1 == 0 && i == 5) {
         i = 5 + CRes.e(20);
         j = 50 + CRes.e(100);
      }

      if (j > 0) {
         --j;
      }

      if (j == 0 && i > 5 && GameCanvas.l % 4 == 2) {
         --i;
      }

      Point var10000;
      int var2;
      Point var3;
      AnimateEffect var5;
      switch (this.f) {
         case 0:
            var5 = this;

            for(var2 = 0; var2 < var5.g; ++var2) {
               var10000 = var3 = (Point)var5.l.elementAt(var2);
               var10000.ax += (var3.e + 1) * 15 + (3 - var3.e) * 3;
               ++var3.b;
               var3.aw += var3.e + 1 << 2;
               if (var3.ax / 10 > AvCamera.a().b + GameCanvas.n - (4 - var3.e) * 50) {
                  var5.a(var3);
               }

               int var10001 = 2 - var3.e;
               int var4 = AvCamera.a().a * var10001 * 20 / 120;
               if (var3.aw / 10 + var4 < AvCamera.a().a - 10) {
                  var3.aw += (GameCanvas.m + 20) * 10;
               }

               if (var3.aw / 10 + var4 > AvCamera.a().a + GameCanvas.m + 10) {
                  var3.aw -= (GameCanvas.m + 20) * 10;
               }
            }

            return;
         case 1:
            var5 = this;

            for(var2 = 0; var2 < var5.g; ++var2) {
               var10000 = var3 = (Point)var5.l.elementAt(var2);
               var10000.ax += 10;
               var3.aw += var3.c * 10 + i * k;
               ++var3.f;
               if (var3.f >= var3.g) {
                  var3.f = 0;
               }

               if (var3.ax / 10 > LoadMap.f * LoadMap.i - (4 - var3.e) * 20) {
                  var5.a(var3);
               }
            }

            return;
         case 2:
            var5 = this;
            if (System.currentTimeMillis() / 1000L - (long)this.h > (long)this.a) {
               ++this.a;

               for(var2 = 0; var2 < 5; ++var2) {
                  var5.l.removeElementAt(0);
                  var5.g = var5.l.size();
                  if (var5.g == 0) {
                     var5.a();
                     return;
                  }
               }
            }

            for(var2 = 0; var2 < var5.g; ++var2) {
               var10000 = var3 = (Point)var5.l.elementAt(var2);
               var10000.ax += (var3.e + 2) * 5;
               var3.aw += (var3.e + 1 << 1) + i * k;
               if (var3.ax / 10 > LoadMap.f * LoadMap.i - (4 - var3.e) * 20) {
                  var5.a(var3);
               }
            }

            return;
         case 3:
            var5 = this;

            for(var2 = 0; var2 < var5.g; ++var2) {
               var10000 = var3 = (Point)var5.l.elementAt(var2);
               var10000.ax += (var3.e + 4) * 3;
               var3.aw += (var3.e + 1 << 1) + i * k;
               if (var3.ax / 10 > LoadMap.f * LoadMap.i - (4 - var3.e) * 20) {
                  var5.a(var3);
               }
            }
      }

   }

   private void a(Point var1) {
      if (super.b) {
         this.l.removeElement(var1);
         this.g = this.l.size();
         if (this.l.size() == 0) {
            super.a();
            return;
         }
      } else {
         var1.ax = (AvCamera.a().b - GameCanvas.p + CRes.e(GameCanvas.n << 1)) * 10;
         var1.aw = (-GameCanvas.m / 2 + CRes.e(LoadMap.e * LoadMap.i + GameCanvas.m)) * 10;
      }

   }
}

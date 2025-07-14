package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

public class AvMain {
   public static int Y = 1;
   public static int Z;
   public static int aa;
   public static int ab;
   public Command ac;
   public Command ad;
   public Command ae;
   public static byte af;
   public static byte ag;
   public static byte ah;
   public static byte ai;
   public boolean aj;
   public static boolean ak = false;
   private static byte a = 0;
   private static byte b = 0;
   private static byte c = 0;

   public void c() {
   }

   public void d(int var1) {
   }

   public void a(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.S.a(var1, this.ac, this.ad, this.ae);
   }

   public void d(int var1, int var2) {
   }

   public void a(int var1) {
   }

   public void a(int var1, int var2) {
   }

   private void b(Command var1) {
      if (var1 != null) {
         GameCanvas.g = false;
         GameCanvas.f = false;
         GameCanvas.h();
         this.a(var1);
      }

   }

   public void k() {
   }

   public void l() {
      if (GameCanvas.f) {
         if (GameCanvas.b(0, GameCanvas.ae[0].b, GameCanvas.m - 1, GameCanvas.T)) {
            switch (GameCanvas.S.d()) {
               case 0:
                  if (GameCanvas.Z == 0) {
                     this.b(this.ac);
                  }
                  break;
               case 1:
                  if (GameCanvas.Z == 0) {
                     this.b(this.ad);
                  }
                  break;
               case 2:
                  if (GameCanvas.Z == 0) {
                     this.b(this.ae);
                  }
            }
         }

         a = 0;
         b = 0;
         c = 0;
         if (GameCanvas.m()) {
            if (GameCanvas.a(0, 0, 50 * Y, 50 * Y)) {
               if (!OptionScr.d) {
                  if (TField.m) {
                     ak = true;
                     TField.m = false;
                  }
               } else if (ak) {
                  TField.m = true;
               }

               OptionScr.d = !OptionScr.d;
               GameCanvas.a.sizeChanged(0, 0);
               GameCanvas.f = false;
            }

            if (GameMidlet.e == 9 && GameCanvas.a(50, 0, 50 * Y, 50 * Y)) {
               if (!OptionScr.d) {
                  OptionScr.d = true;
                  OptionScr.b().b[4] = 1;
                  GameCanvas.a.b();
                  GameCanvas.z.a = true;
                  if (GameCanvas.r == MapScr.b()) {
                     class_im.d().d = MapScr.b();
                     class_im.c = true;
                  }
               } else {
                  OptionScr.d = false;
                  OptionScr.b().b[4] = 0;
                  GameCanvas.a.b();
                  if (GameCanvas.r == MapScr.b()) {
                     class_im.c = false;
                  }
               }

               GameCanvas.f = false;
            }
         }
      }

      if (GameCanvas.a(5)) {
         if (this.ad != null) {
            GameCanvas.h();
            this.a(this.ad);
            return;
         }

         if (GameCanvas.t == this) {
            this.a(this.ac);
            return;
         }
      } else {
         if (GameCanvas.a(12)) {
            this.a(this.ac);
            return;
         }

         if (GameCanvas.E) {
            if (GameCanvas.a(13) || GameCanvas.c[13]) {
               GameCanvas.c[13] = false;
               this.a(this.ae);
               return;
            }
         } else if (GameCanvas.a(13)) {
            this.a(this.ae);
         }
      }

   }

   public final void a(Command var1) {
      if (var1 != null) {
         if (var1.b != null) {
            var1.b.perform();
            return;
         }

         if (var1.d != null) {
            var1.d.a(var1.c);
            return;
         }

         if (class_im.c) {
            class_im.d().a(var1.c, var1.e);
            return;
         }

         this.a(var1.c, var1.e);
      }

   }
}

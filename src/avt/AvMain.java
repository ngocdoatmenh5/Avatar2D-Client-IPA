package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public class AvMain {
   public static int hd = 1;
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
      Canvas.resetTrans(var1);
      Canvas.S.a(var1, this.ac, this.ad, this.ae);
   }

   public void d(int var1, int var2) {
   }

   public void a(int var1) {
   }

   public void a(int var1, int var2) {
   }

   private void b(Command var1) {
      if (var1 != null) {
         Canvas.g = false;
         Canvas.f = false;
         Canvas.h();
         this.a(var1);
      }

   }

   public void k() {
   }

   public void l() {
      if (Canvas.f) {
         if (Canvas.b(0, Canvas.ae[0].b, Canvas.m - 1, Canvas.T)) {
            switch (Canvas.S.d()) {
               case 0:
                  if (Canvas.Z == 0) {
                     this.b(this.ac);
                  }
                  break;
               case 1:
                  if (Canvas.Z == 0) {
                     this.b(this.ad);
                  }
                  break;
               case 2:
                  if (Canvas.Z == 0) {
                     this.b(this.ae);
                  }
            }
         }

         a = 0;
         b = 0;
         c = 0;
         if (Canvas.m()) {
            if (Canvas.a(0, 0, 50 * hd, 50 * hd)) {
               if (!OptionScr.d) {
                  if (TField.m) {
                     ak = true;
                     TField.m = false;
                  }
               } else if (ak) {
                  TField.m = true;
               }

               OptionScr.d = !OptionScr.d;
               Canvas.a.sizeChanged(0, 0);
               Canvas.f = false;
            }

            if (GameMidlet.e == 9 && Canvas.a(50, 0, 50 * hd, 50 * hd)) {
               if (!OptionScr.d) {
                  OptionScr.d = true;
                  OptionScr.b().b[4] = 1;
                  Canvas.a.b();
                  Canvas.z.a = true;
                  if (Canvas.currentMyScreen == MapScr.gI()) {
                     class_im.d().d = MapScr.gI();
                     class_im.c = true;
                  }
               } else {
                  OptionScr.d = false;
                  OptionScr.b().b[4] = 0;
                  Canvas.a.b();
                  if (Canvas.currentMyScreen == MapScr.gI()) {
                     class_im.c = false;
                  }
               }

               Canvas.f = false;
            }
         }
      }

      if (Canvas.a(5)) {
         if (this.ad != null) {
            Canvas.h();
            this.a(this.ad);
            return;
         }

         if (Canvas.t == this) {
            this.a(this.ac);
            return;
         }
      } else {
         if (Canvas.a(12)) {
            this.a(this.ac);
            return;
         }

         if (Canvas.E) {
            if (Canvas.a(13) || Canvas.c[13]) {
               Canvas.c[13] = false;
               this.a(this.ae);
               return;
            }
         } else if (Canvas.a(13)) {
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

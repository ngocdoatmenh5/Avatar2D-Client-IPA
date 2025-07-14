package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class class_im extends AvMain {
   public static class_im a;
   public TField b;
   public static boolean c = false;
   public IChatable d;
   private long e;

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.b.a("");
            c = false;
            this.b.a(true);
            return;
         case 1:
            long var3;
            if ((var3 = System.currentTimeMillis()) - this.e < 2000L) {
               return;
            } else if (this.d != null) {
               this.d.onChatFromMe(this.b.f());
               this.b.a("");
               c = false;
               this.b.a(true);
               this.e = var3;
            }
         default:
      }
   }

   public final void a() {
      this.b.a("");
      c = false;
      this.b.a(true);
      if (OnScreen.b && OptionScr.d) {
         OptionScr.d = false;
         OptionScr.b().b[4] = 0;
         GameCanvas.a.b();
      }

   }

   protected class_im() {
      super.ac = new Command(T1.d, 0);
      super.ad = new Command(T1.ba, 1);
      this.b = new TField();
      this.b.e = false;
      this.b.a(true);
      this.b();
      this.b.a = (GameCanvas.m - this.b.c) / 2;
      this.b.c(40);
      super.ae = this.b.a();
   }

   public final void b() {
      this.b.b = GameCanvas.q - GameCanvas.T - this.b.d - 5;
      if (OnScreen.b) {
         TField var10000 = this.b;
         var10000.b -= 2 * AvMain.Y;
      }

      this.b.c = GameCanvas.m - 10;
   }

   public final void b(int var1) {
      if (c) {
         this.b.b(var1);
      }

   }

   public static class_im d() {
      return a == null ? (a = new class_im()) : a;
   }

   public final void a(int var1, IChatable var2) {
      if (GameCanvas.A == null) {
         this.b.b(var1);
         if (!this.b.f().equals("")) {
            this.d = var2;
            c = true;
         }

         this.b();
      }
   }

   public final void l() {
      this.b.e();
      if (OnScreen.b && GameCanvas.Z != 0) {
         GameCanvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }

   public final void a(Graphics var1) {
      if (OnScreen.b) {
         OnScreen.a(var1, super.ac, super.ad, super.ae);
      } else {
         super.a(var1);
      }

      this.b.a(var1);
   }
}

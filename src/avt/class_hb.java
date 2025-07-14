package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;

public final class class_hb extends Dialog {
   private String[] a;
   private TField b = new TField();
   private IAction c;
   private Image d;
   private int e;
   private int f;

   public class_hb() {
      this.b.e = false;
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 120:
            GameCanvas.v = null;
            return;
         default:
            GameCanvas.r.a(var1, var2);
      }
   }

   public final void a(Image var1) {
      this.d = var1;
      this.f += var1.getHeight();
      this.b();
   }

   public final String a() {
      return this.b.f();
   }

   public final void b() {
      this.b.a = GameCanvas.o - this.b.c / 2;
      this.b.b = GameCanvas.n - (GameCanvas.n - GameCanvas.ae[0].b + 5) - this.b.d - 8;
   }

   public final void a(String var1, int var2, int var3) {
      this.a(var1, var3);
      super.ad = new Command(T1.z, var2);
      GameCanvas.v = this;
      this.b.a(true);
   }

   private void a(String var1, int var2) {
      this.d = null;
      this.e = GameCanvas.m - 40;
      this.f = 70 * AvMain.Y;
      if (GameCanvas.K.a(var1) + 20 < this.e) {
         this.e = GameCanvas.K.a(var1) + 20;
      }

      if (this.e < GameCanvas.m / 2) {
         this.e = GameCanvas.m / 2;
      }

      this.a = GameCanvas.K.a(var1, this.e - 20);
      this.b = new TField();
      this.b.e = false;
      this.b.c = this.e - 10;
      this.b();
      this.b.a("");
      this.b.d(var2);
      super.ac = new Command(T1.d, 120);
      GameCanvas.v = this;
   }

   public final void a(String var1, IAction var2, int var3) {
      this.a(var1, var3);
      this.c = var2;
      super.ad = new Command(T1.z, this.c);
      GameCanvas.v = this;
   }

   public final void a(Graphics var1) {
      GameCanvas.c(var1);
      GameCanvas.S.a(var1, GameCanvas.o - this.e / 2, GameCanvas.n - this.f - (GameCanvas.n - GameCanvas.ae[0].b + 5), this.e, this.f, 0);
      int var2 = GameCanvas.n - this.f - (GameCanvas.n - GameCanvas.ae[0].b + 5) + (this.f - this.b.d - 8) / 2 - (this.a.length >> 1) * AvMain.ah - AvMain.ah / 2;
      if (this.d != null) {
         var1.drawImage(this.d, GameCanvas.o, this.b.b - this.d.getHeight() / 2 - 5 * AvMain.Y, 3);
         var2 -= this.d.getHeight() / 2;
      }

      int var3 = 0;

      for(var2 = var2; var3 < this.a.length; var2 += AvMain.ah) {
         GameCanvas.K.a(var1, this.a[var3], GameCanvas.o, var2, 2);
         ++var3;
      }

      this.b.a(var1);
      if (OnScreen.b) {
         GameCanvas.c(var1);
         GameCanvas.S.c(var1);
         GameCanvas.S.b(var1, super.ac, super.ad, super.ae);
      } else {
         super.a(var1);
      }
   }

   public final void d(int var1) {
      this.b.b(var1);
   }

   public final void l() {
      this.b.e();
      if (this.b.d()) {
         super.ae = this.b.a();
      }

      if (OnScreen.b && GameCanvas.Z != 0) {
         GameCanvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }
}

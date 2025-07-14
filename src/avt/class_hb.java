package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

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
            Canvas.v = null;
            return;
         default:
            Canvas.currentMyScreen.a(var1, var2);
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
      this.b.a = Canvas.o - this.b.c / 2;
      this.b.b = Canvas.n - (Canvas.n - Canvas.ae[0].b + 5) - this.b.d - 8;
   }

   public final void a(String var1, int var2, int var3) {
      this.a(var1, var3);
      super.ad = new Command(T1.z, var2);
      Canvas.v = this;
      this.b.a(true);
   }

   private void a(String var1, int var2) {
      this.d = null;
      this.e = Canvas.m - 40;
      this.f = 70 * AvMain.hd;
      if (Canvas.K.getWidth(var1) + 20 < this.e) {
         this.e = Canvas.K.getWidth(var1) + 20;
      }

      if (this.e < Canvas.m / 2) {
         this.e = Canvas.m / 2;
      }

      this.a = Canvas.K.a(var1, this.e - 20);
      this.b = new TField();
      this.b.e = false;
      this.b.c = this.e - 10;
      this.b();
      this.b.a("");
      this.b.d(var2);
      super.ac = new Command(T1.d, 120);
      Canvas.v = this;
   }

   public final void a(String var1, IAction var2, int var3) {
      this.a(var1, var3);
      this.c = var2;
      super.ad = new Command(T1.z, this.c);
      Canvas.v = this;
   }

   public final void a(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.S.a(var1, Canvas.o - this.e / 2, Canvas.n - this.f - (Canvas.n - Canvas.ae[0].b + 5), this.e, this.f, 0);
      int var2 = Canvas.n - this.f - (Canvas.n - Canvas.ae[0].b + 5) + (this.f - this.b.d - 8) / 2 - (this.a.length >> 1) * AvMain.ah - AvMain.ah / 2;
      if (this.d != null) {
         var1.drawImage(this.d, Canvas.o, this.b.b - this.d.getHeight() / 2 - 5 * AvMain.hd, 3);
         var2 -= this.d.getHeight() / 2;
      }

      int var3 = 0;

      for(var2 = var2; var3 < this.a.length; var2 += AvMain.ah) {
         Canvas.K.a(var1, this.a[var3], Canvas.o, var2, 2);
         ++var3;
      }

      this.b.a(var1);
      if (OnScreen.b) {
         Canvas.resetTrans(var1);
         Canvas.S.c(var1);
         Canvas.S.b(var1, super.ac, super.ad, super.ae);
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

      if (OnScreen.b && Canvas.Z != 0) {
         Canvas.S.a(super.ac, super.ad, super.ae);
      } else {
         super.l();
      }
   }
}

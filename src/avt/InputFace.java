package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class InputFace extends Face {
   public static InputFace a;
   private TField[] b;
   private String c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private String[][] j;

   public static InputFace b() {
      return a == null ? (a = new InputFace()) : a;
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Canvas.A = null;
            return;
         default:
            Canvas.currentMyScreen.a(var1, var2);
      }
   }

   public InputFace() {
      this.f = 200 + Canvas.Z * 88;
      this.d = (Canvas.m - this.f) / 2;
   }

   public final void a(TField[] var1, String var2, String[][] var3, Command var4) {
      super.ac = new Command(T1.d, 0);
      super.ad = var4;
      this.c = var2;
      this.b = var1;
      this.j = var3;
      this.g = MyScreen.at + AvMain.Z + AvMain.ah + (var1[0].d << 1) * var1.length + Canvas.Z * 12;
      this.e = (Canvas.n - Canvas.T - this.g) / 2;

      for(int var5 = 0; var5 < var1.length; ++var5) {
         var1[var5].c = this.f - 50 * (Canvas.Z + 1) - Canvas.K.getWidth(var3[0][0]);
         var1[var5].a = this.d + this.f - var1[var5].c - 10 * (Canvas.Z + 1);
         var1[var5].b = this.e + PaintPopup.o + AvMain.Z + AvMain.ah + (var1[0].d * var5 << 1);
      }

      this.i = Canvas.K.getWidth(var2) + 20 * AvMain.hd;
      if (this.i < 50 + 20 * AvMain.hd) {
         this.i = 50 + 20 * AvMain.hd;
      }

      this.d();
   }

   public final void l() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1].e();
      }

      boolean var2 = false;
      if (Canvas.a(2)) {
         --this.h;
         if (this.h < 0) {
            this.h = this.b.length - 1;
         }

         var2 = true;
      } else if (Canvas.a(8)) {
         ++this.h;
         if (this.h > this.b.length - 1) {
            this.h = 0;
         }

         var2 = true;
      }

      if (var2) {
         this.d();
      }

      super.l();
   }

   private void d() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1].a(false);
      }

      this.b[this.h].a(true);
      super.ae = this.b[this.h].a();
   }

   public final void d(int var1) {
      for(int var2 = 0; var2 < this.b.length; ++var2) {
         if (this.b[var2].d()) {
            this.b[var2].b(var1);
         }
      }

      super.d(var1);
   }

   public final void a(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.S.a(var1, this.d, this.e, this.g, this.f, 0, 0, PaintPopup.a().j, this.i, PaintPopup.o, 1, 1, PaintPopup.a().n, PaintPopup.a().m, this.c);

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         var1.setClip(this.d + 4 * AvMain.hd, this.e, this.f - 8 * AvMain.hd, this.g);
         int var3;
         if ((var3 = this.b[var2].a - Canvas.K.getWidth(this.j[var2][0]) - 5) > this.d + 4 * AvMain.hd + 5) {
            var3 = this.d + 4 * AvMain.hd + 5;
         }

         byte var4 = 2;
         if (this.j[var2][1].equals("")) {
            var4 = 1;
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            Canvas.K.a(var1, this.j[var2][var5], var3, this.b[var2].b + this.b[var2].d / 2 - AvMain.ah * var4 / 2 + AvMain.ah * var5, 0);
         }

         this.b[var2].a(var1);
      }

      super.a(var1);
   }
}

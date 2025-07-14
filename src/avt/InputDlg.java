package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;

public final class InputDlg extends Dialog {
   private String[] a;
   private TField b = new TField();
   private IAction c;
   private Image d;
   private int e;
   private int f;

   public InputDlg() {
      this.b.e = false;
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 120:
            Canvas.currentDialog = null;
            return;
         default:
            Canvas.currentMyScreen.a(var1, var2);
      }
   }

   public final void a(Image var1) {
      this.d = var1;
      this.f += var1.getHeight();
      this.init();
   }

   public final String a() {
      return this.b.f();
   }

   public final void init() {
      this.b.a = Canvas.hw - this.b.c / 2;
      this.b.b = Canvas.h - (Canvas.h - Canvas.ae[0].y + 5) - this.b.d - 8;
   }

   public final void a(String var1, int var2, int var3) {
      this.a(var1, var3);
      super.center = new Command(T.z, var2);
      Canvas.currentDialog = this;
      this.b.a(true);
   }

   private void a(String var1, int var2) {
      this.d = null;
      this.e = Canvas.w - 40;
      this.f = 70 * AvMain.hd;
      if (Canvas.K.getWidth(var1) + 20 < this.e) {
         this.e = Canvas.K.getWidth(var1) + 20;
      }

      if (this.e < Canvas.w / 2) {
         this.e = Canvas.w / 2;
      }

      this.a = Canvas.K.a(var1, this.e - 20);
      this.b = new TField();
      this.b.e = false;
      this.b.c = this.e - 10;
      this.init();
      this.b.a("");
      this.b.d(var2);
      super.left = new Command(T.d, 120);
      Canvas.currentDialog = this;
   }

   public final void a(String var1, IAction var2, int var3) {
      this.a(var1, var3);
      this.c = var2;
      super.center = new Command(T.z, this.c);
      Canvas.currentDialog = this;
   }

   public final void paint(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.paint.a(var1, Canvas.hw - this.e / 2, Canvas.h - this.f - (Canvas.h - Canvas.ae[0].y + 5), this.e, this.f, 0);
      int var2 = Canvas.h - this.f - (Canvas.h - Canvas.ae[0].y + 5) + (this.f - this.b.d - 8) / 2 - (this.a.length >> 1) * AvMain.ah - AvMain.ah / 2;
      if (this.d != null) {
         var1.drawImage(this.d, Canvas.hw, this.b.b - this.d.getHeight() / 2 - 5 * AvMain.hd, 3);
         var2 -= this.d.getHeight() / 2;
      }

      int var3 = 0;

      for(var2 = var2; var3 < this.a.length; var2 += AvMain.ah) {
         Canvas.K.a(var1, this.a[var3], Canvas.hw, var2, 2);
         ++var3;
      }

      this.b.a(var1);
      if (OnScreen.b) {
         Canvas.resetTrans(var1);
         Canvas.paint.c(var1);
         Canvas.paint.b(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
      }
   }

   public final void d(int var1) {
      this.b.b(var1);
   }

   public final void updateKey() {
      this.b.e();
      if (this.b.d()) {
         super.right = this.b.a();
      }

      if (OnScreen.b && Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }
}

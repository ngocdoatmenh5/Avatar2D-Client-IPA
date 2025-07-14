package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class class_hk extends MyScreen {
   public static class_hk a;
   private int[] b;
   private MyScreen c;
   private int d = 5;
   private int e;
   private int f = 7;

   public static class_hk b() {
      if (a == null) {
         a = new class_hk();
      }

      return a;
   }

   public final void a(MyScreen var1) {
      super.a();
      this.c = var1;
      super.ar = 0;
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Canvas.cameraList.m = false;
            this.c.a();
            return;
         case 1:
            Canvas.cameraList.m = false;
            this.c.a();
            ParkService.a().a(MapScr.b, super.ar);
         default:
      }
   }

   public class_hk() {
      super.right = new Command(T.d, 0);
      super.center = new Command(T.O, 1);
      this.e = 20;
      if (Canvas.stypeInt > 0) {
         this.e = Canvas.stypeInt * 30;
      }

      if (Canvas.w < 176) {
         this.e = 15;
      }

      if (this.f * this.e > Canvas.h - Canvas.hTab) {
         this.f = (Canvas.h - Canvas.hTab) / this.e;
      }

   }

   public final void a(int var1, boolean var2) {
      if (var2 && super.ar == var1 && super.center != null) {
         super.center.b();
      }

      super.a(var1, var2);
   }

   public final void a(int[] var1) {
      this.b = var1;
      Canvas.cameraList.a(Canvas.hw - (this.e * this.d + 10) / 2 + 4, Canvas.hh - this.e * this.f / 2, this.e, this.e, this.d * this.e, this.b.length / this.d * this.e, this.e * this.d, this.e * this.f - (Canvas.stypeInt == 0 ? 30 : 0), var1.length);
   }

   public final void updateKey() {
      super.updateKey();
   }

   public final void k() {
      this.c.k();
   }

   public final void paint(Graphics var1) {
      var1.translate(0, 0);
      var1.setClip(0, 0, Canvas.w, Canvas.h);
      this.c.b(var1);
      Canvas.paint.a(var1, Canvas.hw - (this.e * this.d + 10) / 2, Canvas.hh - this.e * this.f / 2, this.e * this.d + 10, this.e * this.f);
      Canvas.paint.a(var1, this.e, this.d, this.f, super.aj, super.ar, this.b);
      super.paint(var1);
   }
}

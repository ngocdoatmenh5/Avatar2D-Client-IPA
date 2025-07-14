package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

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
            GameCanvas.y.m = false;
            this.c.a();
            return;
         case 1:
            GameCanvas.y.m = false;
            this.c.a();
            ParkService.a().a(MapScr.b, super.ar);
         default:
      }
   }

   public class_hk() {
      super.ae = new Command(T1.d, 0);
      super.ad = new Command(T1.O, 1);
      this.e = 20;
      if (GameCanvas.Z > 0) {
         this.e = GameCanvas.Z * 30;
      }

      if (GameCanvas.m < 176) {
         this.e = 15;
      }

      if (this.f * this.e > GameCanvas.n - GameCanvas.T) {
         this.f = (GameCanvas.n - GameCanvas.T) / this.e;
      }

   }

   public final void a(int var1, boolean var2) {
      if (var2 && super.ar == var1 && super.ad != null) {
         super.ad.b();
      }

      super.a(var1, var2);
   }

   public final void a(int[] var1) {
      this.b = var1;
      GameCanvas.y.a(GameCanvas.o - (this.e * this.d + 10) / 2 + 4, GameCanvas.p - this.e * this.f / 2, this.e, this.e, this.d * this.e, this.b.length / this.d * this.e, this.e * this.d, this.e * this.f - (GameCanvas.Z == 0 ? 30 : 0), var1.length);
   }

   public final void l() {
      super.l();
   }

   public final void k() {
      this.c.k();
   }

   public final void a(Graphics var1) {
      var1.translate(0, 0);
      var1.setClip(0, 0, GameCanvas.m, GameCanvas.n);
      this.c.b(var1);
      GameCanvas.S.a(var1, GameCanvas.o - (this.e * this.d + 10) / 2, GameCanvas.p - this.e * this.f / 2, this.e * this.d + 10, this.e * this.f);
      GameCanvas.S.a(var1, this.e, this.d, this.f, super.aj, super.ar, this.b);
      super.a(var1);
   }
}

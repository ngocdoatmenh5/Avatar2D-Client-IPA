package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;

public final class RegisterScr extends MyScreen {
   private static RegisterScr d;
   private byte e = 1;
   public int a = 0;
   private int f;
   public int b;
   public int c;
   private Vector g;
   private Vector h;
   private Vector i;
   private int j = 0;

   public static RegisterScr b() {
      if (d == null) {
         d = new RegisterScr();
      }

      return d;
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var3;
            (var3 = new Vector()).addElement(new Command(T1.o, 0, this));
            var3.addElement(new Command(T1.p, 1, this));
            GameCanvas.a(T1.dC, var3);
         default:
      }
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            f();
            return;
         case 1:
            f();
         default:
      }
   }

   public final void a() {
      GameMidlet.i.K = 0;
      GameMidlet.i.e = new Vector();
      this.e();
      super.ad = new Command(T1.cj, 0);
      SeriPart var1 = new SeriPart();
      int var2 = CRes.a.nextInt(this.i.size());
      var1.a = ((APartInfo)this.i.elementAt(var2)).g;
      GameMidlet.i.a(var1);
      var1 = new SeriPart();
      var2 = CRes.a.nextInt(this.h.size());
      var1.a = ((APartInfo)this.h.elementAt(var2)).g;
      GameMidlet.i.a(var1);
      (var1 = new SeriPart()).a = 4;
      GameMidlet.i.a(var1);
      var1 = new SeriPart();
      var2 = CRes.a.nextInt(this.g.size());
      var1.a = ((APartInfo)this.g.elementAt(var2)).g;
      GameMidlet.i.a(var1);
      GameMidlet.i.a(new SeriPart((short)0));
      GameMidlet.i.h();
      PaintPopup.a().a(T1.ck, 150 * AvMain.Y, 170 + (AvMain.Y == 2 ? 120 : 0), 1);
      super.a();
   }

   private void e() {
      GameMidlet.i.d = this.e;
      if (this.g != null) {
         this.g.removeAllElements();
         this.h.removeAllElements();
         this.i.removeAllElements();
      }

      this.g = new Vector();
      this.h = new Vector();
      this.i = new Vector();

      for(int var1 = 0; var1 < AvatarData.b.length; ++var1) {
         APartInfo var2;
         if (AvatarData.b[var1] instanceof APartInfo && (var2 = (APartInfo)AvatarData.b[var1]) != null && (var2.b == this.e || var2.b == 0) && var2.a == 0) {
            if (var2.j == 50) {
               this.g.addElement(var2);
            } else if (var2.j == 20) {
               this.h.addElement(var2);
            } else if (var2.j == 10) {
               this.i.addElement(var2);
            }
         }
      }

      this.f = 0;
      this.g();
      if (GameMidlet.i.H != 10) {
         GameMidlet.i.b((byte)1);
      }

      GameMidlet.i.h();
   }

   private static void f() {
      GameCanvas.I = true;
      GameCanvas.c(T1.ck + "...");
      GlobalService.gI().c();
   }

   public final void k() {
      if (this.b > 0) {
         --this.b;
      }

      if (this.c > 0) {
         --this.c;
      }

      ++this.j;
      if (this.j > 50) {
         this.j = 0;
         int var1 = CRes.a.nextInt(3);
         if (GameMidlet.i.H != 10) {
            if (var1 == 0) {
               GameMidlet.i.b((byte)1);
            } else {
               GameMidlet.i.b((byte)0);
            }
         }
      }

      GameMidlet.i.d();
   }

   public final void b(int var1) {
      this.a = var1;
      if (this.a < 0) {
         this.a = 1;
      }

      if (this.a > 1) {
         this.a = 0;
      }

   }

   public final void c(int var1) {
      this.f += var1;
      if (this.f < 0) {
         this.f = 1;
      }

      if (this.f > 1) {
         this.f = 0;
      }

      if (this.a == 0) {
         if (this.e == 1) {
            this.e = 2;
         } else {
            this.e = 1;
         }

         this.e();
      } else {
         this.g();
      }
   }

   public final void l() {
      GameCanvas.S.j();
      super.l();
   }

   private void g() {
      for(int var1 = 0; var1 < GameMidlet.i.e.size(); ++var1) {
         SeriPart var2;
         APartInfo var3;
         if ((var3 = (APartInfo)AvatarData.a((var2 = (SeriPart)GameMidlet.i.e.elementAt(var1)).a)).j == 50 && this.g.size() != 0 && this.f < this.g.size()) {
            var2.a = ((APartInfo)this.g.elementAt(this.f)).g;
         }

         if (var3.j == 20 && this.h.size() != 0 && this.f < this.h.size()) {
            var2.a = ((APartInfo)this.h.elementAt(this.f)).g;
         }

         if (var3.j == 10 && this.i.size() != 0 && this.f < this.i.size()) {
            var2.a = ((APartInfo)this.i.elementAt(this.f)).g;
         }
      }

      GameMidlet.i.h();
   }

   public final void a(Graphics var1) {
      GameCanvas.x.b(var1);
      GameCanvas.x.d(var1);
      GameCanvas.c(var1);
      PaintPopup.a().a(var1);
      var1.translate(PaintPopup.a().g, PaintPopup.a().h);
      GameCanvas.S.d(var1, this.a, this.e, this.b, this.c);
      super.a(var1);
   }

   public static void b(boolean var0) {
      GameCanvas.h();
      if (var0) {
         MapScr.b().t();
      } else {
         GameCanvas.b(T1.cl);
      }
   }
}

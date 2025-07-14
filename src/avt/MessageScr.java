package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class MessageScr extends MyScreen {
   private Vector g = new Vector();
   private MyScreen h;
   public class_cw a;
   public int b;
   public static TField c;
   public static MessageScr me;
   public static int e;
   private static int i;
   public Command f;
   private boolean j = true;

   public static MessageScr b() {
      if (me == null) {
         me = new MessageScr();
      }

      return me;
   }

   public final void a(MyScreen var1) {
      this.h = var1;
      MyScreen.as = 0;
      b().b = b().g.size() - 1;
      this.f();
      PaintPopup.gI().l = this.b;
      b().g();
      this.j = this.b(this.b).h;
      this.init();
      PaintPopup.gI().a(this.b(this.b).b, this.b);
      super.a();
   }

   private void f() {
      PaintPopup var10000;
      int var10002;
      if (OnScreen.b && Canvas.stypeInt == 0) {
         var10000 = PaintPopup.gI();
         var10002 = Canvas.w - (e << 1);
         var10000.a(this.b(this.b).b, var10002, Canvas.q - Canvas.hTab - (e << 1), this.g.size());
      } else {
         var10000 = PaintPopup.gI();
         var10002 = Canvas.w - (e << 1);
         int var10003 = Canvas.h - Canvas.ab - Canvas.hTab - 10;
         var10000.a(this.b(this.b).b, var10002, var10003 + (OnScreen.b && this.h != BoardScr.me ? -20 : 0), this.g.size());
         i = PaintPopup.gI().h = 10 + Canvas.ab;
      }
   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 2:
            this.h.a();
            this.h = null;
         default:
            return;
         case 10:
            this.a(this.b(this.b));
      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 1:
            ParkService.a().a(c.f());
            c.a("");
            return;
         case 2:
            this.h.a();
            this.h = null;
            return;
         case 3:
            if (!c.f().equals("")) {
               class_cw var6 = this.b(this.b);
               String var7;
               if ((var7 = c.f()).indexOf("hack") != -1) {
                  var6.a(GameMidlet.avatar.name + ": " + var7);
                  var7 = var7 + " ";

                  for(int var3 = 0; var3 < var6.e.size(); ++var3) {
                     String var4 = (String)var6.e.elementAt(var3);
                     var7 = var7 + var4;
                  }

                  GlobalService.gI().b(var6.g, var7);
                  c.a("");
                  break;
               }

               GlobalService.gI().a(var6.g, var7);
               c.a("");
               var6.a(GameMidlet.avatar.name + ": " + var7);
            }

            return;
         case 4:
            this.h.a();
            this.h = null;
            return;
         case 5:
            Vector var5 = new Vector();
            if (this.b(this.b) != this.a) {
               var5.addElement(new Command(T.ch, 10));
            }

            var5.addElement(new Command(T.d, 2));
            MenuSub.a().a(var5, 0);
            return;
         case 6:
         case 7:
         case 8:
         case 9:
         default:
            break;
         case 10:
            this.a(this.b(this.b));
      }

   }

   public final void c() {
      if (Canvas.stypeInt == 0) {
         if (OnScreen.b) {
            super.left = new Command(T.d, 4);
         } else {
            super.left = new Command(T.c, 5);
         }
      } else if (this.b(this.b) == this.a) {
         super.left = new Command(T.d, 4);
      } else {
         super.left = new Command(T.ch, 10);
      }

      this.a = new class_cw(T.cg, -1, (Command)null, (Command)null, false);
   }

   public MessageScr() {
      this.f = new Command(T.ch, 10);
      if (Canvas.stypeInt == 0) {
         i = 10;
         e = 10;
      } else {
         e = i = AvMain.aa;
      }

      (c = new TField()).a = e + 5;
      this.init();
      c.a(true);
      c.c(40);
      this.c();
      class_cw var10000 = this.a;
      var10000.i += 20;
      this.g.addElement(this.a);
      this.b = 0;
      this.g();
   }

   public final void init() {
      if (Canvas.currentMyScreen == this) {
         this.f();
         this.b(this.b).c();
      }

      c.b = PaintPopup.gI().h + PaintPopup.gI().e - c.d - 6;
      c.c = Canvas.w - (PaintPopup.gI().g << 1) - 10;
   }

   private void g() {
      this.b(this.b).a = false;
      super.center = this.b(this.b).c;
      super.right = this.b(this.b).d;
      if (super.center != null) {
         c.a(this.b(this.b).f);
      }

      this.j = this.b(this.b).h;
      this.b(this.b).c();
      if (Canvas.currentMyScreen == this) {
         PaintPopup.gI().a(this.b(this.b).b, this.b);
      }

   }

   public final void a(int var1, String var2, String var3) {
      class_cw var4;
      if ((var4 = this.c(var1)) == null) {
         var4 = new class_cw(var2, var1, !var2.equals("admin") ? new Command(T.ba, 3) : null, !var2.equals("admin") ? c.a() : null, !var2.equals("admin"));
         this.b(var4);
      } else {
         var4.a = true;
         if (Canvas.currentMyScreen == this) {
            this.h();
         }
      }

      var4.a(var2, var3);
   }

   private class_cw c(int var1) {
      for(int var2 = 0; var2 < this.g.size(); ++var2) {
         if (((class_cw)this.g.elementAt(var2)).g == var1) {
            return (class_cw)this.g.elementAt(var2);
         }
      }

      return null;
   }

   public final class_cw b(int var1) {
      return var1 < this.g.size() ? (class_cw)this.g.elementAt(var1) : null;
   }

   public final void paint(Graphics var1) {
      this.h.b(var1);
      Canvas.resetTrans(var1);
      PaintPopup.gI().a(var1);
      var1.translate(e, i + PaintPopup.o + AvMain.Z);
      this.b(this.b).a(var1);
      if (this.j) {
         var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
         c.a(var1);
      }

      if (OnScreen.b) {
         OnScreen.a(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
      }
   }

   private void e(int var1) {
      this.b(this.b).f = c.f();
      this.b += var1;
      if (this.b < 0) {
         this.b = this.g.size() - 1;
      }

      if (this.b >= this.g.size()) {
         this.b = 0;
      }

      this.g();
      this.b(this.b).a();
      class_cw.j = class_cw.k;
   }

   public final void d(int var1) {
      if (var1 == -3) {
         this.e(-1);
      }

      if (var1 == -4) {
         this.e(1);
      }

      if (this.j) {
         c.b(var1);
      }

      super.d(var1);
   }

   public final void updateKey() {
      if (OnScreen.b && Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }

      int var1;
      if (Canvas.isPointerClick && (var1 = PaintPopup.gI().d()) != 0) {
         this.e(var1);
         Canvas.isPointerClick = false;
      }

      this.b(this.b).b();
   }

   public final void k() {
      if (this.j) {
         c.e();
      }

      if (this.h != null) {
         this.h.k();
      }

   }

   public final void a(class_cw var1) {
      this.g.removeElement(var1);
      if (this.b >= this.g.size()) {
         this.b = this.g.size() - 1;
      }

      PaintPopup.gI().l = this.b;
      PaintPopup.gI().a(this.g.size());
      this.h();
      this.g();
   }

   public final void a(int var1, String var2) {
      class_cw var3;
      if ((var3 = this.c(var1)) == null) {
         var3 = new class_cw(var2, var1, new Command(T.ba, 3), c.a(), true);
         this.b(var3);
         var3.a(T.ci + var2);
      }

      for(var1 = 0; var1 < this.g.size(); ++var1) {
         if (this.g.elementAt(var1) == var3) {
            this.b = var1;
         }
      }

      this.g();
   }

   public final void b(class_cw var1) {
      this.g.addElement(var1);
      if (Canvas.currentMyScreen == this) {
         PaintPopup.gI().a(this.g.size());
         this.h();
      }

   }

   private void h() {
      for(int var1 = 0; var1 < this.g.size(); ++var1) {
         if (this.b(var1).a) {
            PaintPopup.gI().a(4, var1);
         } else {
            PaintPopup.gI().a(0, var1);
         }
      }

   }
}

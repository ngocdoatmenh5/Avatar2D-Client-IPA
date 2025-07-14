package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
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
            (var3 = new Vector()).addElement(new Command(T.o, 0, this));
            var3.addElement(new Command(T.p, 1, this));
            Canvas.a(T.dC, var3);
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
      GameMidlet.avatar.direct = 0;
      GameMidlet.avatar.seriPart = new Vector();
      this.e();
      super.center = new Command(T.cj, 0);
      SeriPart var1 = new SeriPart();
      int var2 = CRes.a.nextInt(this.i.size());
      var1.idPart = ((APartInfo)this.i.elementAt(var2)).IDPart;
      GameMidlet.avatar.addSeri(var1);
      var1 = new SeriPart();
      var2 = CRes.a.nextInt(this.h.size());
      var1.idPart = ((APartInfo)this.h.elementAt(var2)).IDPart;
      GameMidlet.avatar.addSeri(var1);
      (var1 = new SeriPart()).idPart = 4;
      GameMidlet.avatar.addSeri(var1);
      var1 = new SeriPart();
      var2 = CRes.a.nextInt(this.g.size());
      var1.idPart = ((APartInfo)this.g.elementAt(var2)).IDPart;
      GameMidlet.avatar.addSeri(var1);
      GameMidlet.avatar.addSeri(new SeriPart((short)0));
      GameMidlet.avatar.orderSeriesPath();
      PaintPopup.gI().a(T.ck, 150 * AvMain.hd, 170 + (AvMain.hd == 2 ? 120 : 0), 1);
      super.a();
   }

   private void e() {
      GameMidlet.avatar.gender = this.e;
      if (this.g != null) {
         this.g.removeAllElements();
         this.h.removeAllElements();
         this.i.removeAllElements();
      }

      this.g = new Vector();
      this.h = new Vector();
      this.i = new Vector();

      for(int var1 = 0; var1 < AvatarData.listPart.length; ++var1) {
         APartInfo var2;
         if (AvatarData.listPart[var1] instanceof APartInfo && (var2 = (APartInfo)AvatarData.listPart[var1]) != null && (var2.gender == this.e || var2.gender == 0) && var2.level == 0) {
            if (var2.zOrder == 50) {
               this.g.addElement(var2);
            } else if (var2.zOrder == 20) {
               this.h.addElement(var2);
            } else if (var2.zOrder == 10) {
               this.i.addElement(var2);
            }
         }
      }

      this.f = 0;
      this.g();
      if (GameMidlet.avatar.action != 10) {
         GameMidlet.avatar.setAction((byte)1);
      }

      GameMidlet.avatar.orderSeriesPath();
   }

   private static void f() {
      Canvas.isDoubleImage = true;
      Canvas.startWaitDlg(T.ck + "...");
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
         if (GameMidlet.avatar.action != 10) {
            if (var1 == 0) {
               GameMidlet.avatar.setAction((byte)1);
            } else {
               GameMidlet.avatar.setAction((byte)0);
            }
         }
      }

      GameMidlet.avatar.updateFrame();
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

   public final void updateKey() {
      Canvas.paint.j();
      super.updateKey();
   }

   private void g() {
      for(int var1 = 0; var1 < GameMidlet.avatar.seriPart.size(); ++var1) {
         SeriPart var2;
         APartInfo var3;
         if ((var3 = (APartInfo)AvatarData.getPart((var2 = (SeriPart)GameMidlet.avatar.seriPart.elementAt(var1)).idPart)).zOrder == 50 && this.g.size() != 0 && this.f < this.g.size()) {
            var2.idPart = ((APartInfo)this.g.elementAt(this.f)).IDPart;
         }

         if (var3.zOrder == 20 && this.h.size() != 0 && this.f < this.h.size()) {
            var2.idPart = ((APartInfo)this.h.elementAt(this.f)).IDPart;
         }

         if (var3.zOrder == 10 && this.i.size() != 0 && this.f < this.i.size()) {
            var2.idPart = ((APartInfo)this.i.elementAt(this.f)).IDPart;
         }
      }

      GameMidlet.avatar.orderSeriesPath();
   }

   public final void paint(Graphics var1) {
      Canvas.loadMap.b(var1);
      Canvas.loadMap.d(var1);
      Canvas.resetTrans(var1);
      PaintPopup.gI().a(var1);
      var1.translate(PaintPopup.gI().g, PaintPopup.gI().h);
      Canvas.paint.d(var1, this.a, this.e, this.b, this.c);
      super.paint(var1);
   }

   public static void b(boolean var0) {
      Canvas.endDlg();
      if (var0) {
         MapScr.gI().joinCitymap();
      } else {
         Canvas.startOKDlg(T.cl);
      }
   }
}

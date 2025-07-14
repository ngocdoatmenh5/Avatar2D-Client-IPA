package avt;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.GameCanvas;
import main.GameMidlet;
import javax.microedition.lcdui.Image;

public final class class_kv extends MyScreen
{
   private static class_kv c;
   private Command d;
   private Command e;
   private Command f;
   public Image a;
   public FrameImage b;
   private Fish g;
   private int h;
   private int i;
   private int j;
   private Image[] k;
   private int l;
   private byte[] m;
   private long n;
   private short o;
   private int p;
   private int q;
   private int r;

   public static class_kv b() {
      if (class_kv.c == null) {
         return class_kv.c = new class_kv();
      }
      return class_kv.c;
   }

   public final void a(final int n, final int n2) {
      switch (n) {
         case 0: {
            if (GameMidlet.i.H != 2 && GameMidlet.i.H != 13) {
               MapScr.b().a();
            }
            final ParkService a;
            (a = ParkService.a()).e((byte)82);
            a.k();
            GameCanvas.i();
            super.ad = null;
            return;
         }
         case 1: {
            ParkService.a().b();
            GameCanvas.i();
            return;
         }
         case 2: {
            this.e();
            ParkService.a().b();
            break;
         }
      }
   }

   public class_kv() {
      this.g = new Fish();
      this.l = 0;
      this.d = new Command(T1.cz, 0);
      this.f = new Command(T1.cy, 1);
      this.e = new Command(T1.d, 2);
      super.ad = this.d;
      FilePack.b(T1.av);
      this.a = FilePack.a("cucphao");
      this.b = FrameImage.a("ca", 14 * AvMain.Y, 14 * AvMain.Y);
      FilePack.a();
      this.j = 530;
   }

   private void e() {
      GameMidlet.i.f();
      if (GameMidlet.i.K == 0) {
         final Avatar i = GameMidlet.i;
         i.aw -= 18;
      }
      else {
         final Avatar j = GameMidlet.i;
         j.aw += 18;
      }
      final Avatar k = GameMidlet.i;
      k.ax -= 10;
      AvCamera.a(GameCanvas.m / 10);
      MapScr.l.removeElement(this.g);
      MapScr.b().a();
   }

   public final boolean b(final int n, final int n2) {
      this.r = GameCanvas.n - GameCanvas.n / 4;
      if (this.r > GameCanvas.n - 70 * AvMain.Y) {
         this.r = GameCanvas.n - 70 * AvMain.Y;
      }
      this.q = 60;
      if (this.q < (GameCanvas.m - LoadMap.e * 24) / 2 + 50 * AvMain.Y) {
         this.q = (GameCanvas.m - LoadMap.e * 24) / 2 + 50 * AvMain.Y;
      }
      this.l = 0;
      final int d = LoadMap.d(n, n2);
      if (LoadMap.d[d + 1] == 100 || LoadMap.d[d + 1] == 16 || LoadMap.d[d + 1] == 13) {
         GameMidlet.i.K = 0;
         this.q = GameCanvas.m - this.q;
      }
      else {
         GameMidlet.i.K = Base.J;
      }
      GameMidlet.i.e(n, n2);
      final ParkService a;
      (a = ParkService.a()).e((byte)86);
      a.k();
      GameCanvas.i();
      super.ae = this.e;
      GameCanvas.f();
      return true;
   }

   public final void k() {
      MapScr.b().k();
      if (this.g.i && !this.g.j) {
         if (this.l < this.m.length && System.currentTimeMillis() - this.n > this.o) {
            this.f(0);
         }
         if (GameMidlet.i.H == 2) {
            --this.p;
            if (this.p < 0) {
               this.p = 0;
               this.g.a(1);
            }
         }
      }
   }

   public final void d(final int n) {
      if (this.g.i && !this.g.j) {
         switch (n) {
            case 50:
            case 52:
            case 54:
            case 56: {
               GameCanvas.b[n - 48] = true;
               break;
            }
         }
         return;
      }
      MapScr.b().d(n);
   }

   public final void l() {
      if (this.g.i && !this.g.j) {
         if (GameCanvas.a(2)) {
            this.f(2);
         }
         else if (GameCanvas.a(4)) {
            this.f(1);
         }
         else if (GameCanvas.a(6)) {
            this.f(3);
         }
         else if (GameCanvas.a(8)) {
            this.f(4);
         }
      }
      super.l();
   }

   private void f(final int n) {
      this.n = System.currentTimeMillis();
      if (this.l < this.m.length) {
         this.m[this.l] = (byte)n;
      }
      ++this.l;
      if (GameMidlet.i.H != 2) {
         this.g.a(0);
         this.p = 2;
      }
      if (this.l >= this.m.length) {
         this.g.a(0);
         this.g.j = true;
         ParkService.a().a(true, this.m);
         GameCanvas.i();
      }
   }

   public final void a(final Graphics graphics) {
      MapScr.b().b(graphics);
      if (this.g.i && !this.g.j && this.o != -1) {
         GameCanvas.c(graphics);
         graphics.translate(-AvCamera.a().a, -AvCamera.a().b);
         graphics.setColor(8575990);
         if (this.k != null && this.l < this.k.length) {
            if (System.currentTimeMillis() - this.n > 50L) {
               graphics.setColor(1423411);
            }
            else {
               graphics.setColor(15612731);
            }
            graphics.fillRoundRect(this.h - 1, this.i * AvMain.Y - 1, this.k[this.l].getWidth() + 2, this.k[this.l].getHeight() + 2, 5, 5);
            graphics.drawImage(this.k[this.l], this.h, this.i * AvMain.Y, 0);
         }
      }
      super.a(graphics);
   }

   public final void b(final int n) {
      final Avatar g;
      if ((g = LoadMap.g(n)) != null) {
         final Avatar b = g;
         final Fish c;
         if ((c = c(b.w)) != null) {
            MapScr.l.removeElement(c);
         }
         Fish fish = new Fish();
         if (b.w == GameMidlet.i.w) {
            GameCanvas.h();
            this.g = fish;
         }
         else {
            fish = new Fish();
         }
         MapScr.l.addElement(fish);
         if (b.H != 2) {
            if (b.w != GameMidlet.i.w) {
               fish.b = b;
               fish.k = true;
            }
            return;
         }
         fish.a(b);
      }
   }

   public final void a(int i, final int h, final short o, final byte[][] array) {
      final Fish c;
      if ((c = c(i)) != null && c.f != 0) {
         if ((c.b.H != 13 && c.b.H != 2) || c.i) {
            return;
         }
         c.i = true;
         c.a(0);
         c.b.H = 2;
         c.h = h;
         if (o != -1) {
            GameCanvas.a(T1.cA, c.b.aw, c.b.ax - 60, -1, 1, -1);
         }
         if (i == GameMidlet.i.w) {
            this.n = System.currentTimeMillis();
            this.l = 0;
            this.p = 2;
            this.k = new Image[array.length];
            this.m = new byte[array.length];
            for (i = 0; i < this.k.length; ++i) {
               this.k[i] = CRes.a(array[i]);
            }
            this.o = o;
            this.h = this.g.d[this.g.a - 2].a;
            this.i = this.g.d[this.g.a - 2].b - 30;
            if (o == -1) {
               this.f(0);
            }
         }
      }
   }

   public final void c(final int n, final int h) {
      final Fish c;
      if ((c = c(n)) != null) {
         if (c.b.H != 2 && c.b.H != 13) {
            MapScr.l.removeElement(c);
            return;
         }
         if (h < 0) {
            GameCanvas.a(T1.cB, c.b.aw, c.b.ax - 60, -1, 1, -1);
         }
         c.h = h;
         c.j = true;
         c.a(0);
         if (c.b.w == GameMidlet.i.w) {
            super.ae = this.f;
            GameCanvas.h();
         }
      }
   }

   public static Fish c(final int n) {
      for (int i = 0; i < MapScr.l.size(); ++i) {
         final Fish fish;
         if ((fish = (Fish) MapScr.l.elementAt(i)).b.w == n) {
            return fish;
         }
      }
      return null;
   }

   public final void e(final int n) {
      final Fish c = c(n);
      if (n == GameMidlet.i.w) {
         super.ad = this.d;
         super.ae = this.e;
         GameCanvas.h();
      }
      if (c != null) {
         final PartSmall partSmall;
         if (c.h > 0 && (partSmall = (PartSmall)AvatarData.a((short)c.h)) != null) {
            final ImageInfo imageInfo;
            GameCanvas.a(1, c.b.aw, c.b.ax + c.b.h - 50, -1, Image.createImage(AvatarData.a((int)(imageInfo = AvatarData.a[partSmall.h]).b).e, imageInfo.c * AvMain.Y, imageInfo.d * AvMain.Y, imageInfo.e * AvMain.Y, imageInfo.f * AvMain.Y, 0), -1);
         }
         MapScr.l.removeElement(c);
      }
   }

   public final void a(final boolean b, final String s) {
      if (b) {
         this.g.a();
         super.ad = this.d;
         this.a();
         AvCamera.a(GameCanvas.m / 3);
         GameCanvas.h();
         return;
      }
      GameCanvas.b(s, 0, this);
   }

   public final void a(final int n) {
      switch (n) {
         case 0: {
            this.e();
            break;
         }
      }
   }

   public static void e(final int n, final int n2) {
      final Avatar g;
      if ((g = LoadMap.g(n)) != null && (g.H == 2 || g.H == 13)) {
         final Fish obj = new Fish();
         MapScr.l.addElement(obj);
         obj.a(g);
         obj.b();
         obj.c[obj.a - 1].a = g.aw + 70 + (AvMain.Y - 1) * 35 + CRes.e(25);
         obj.c[obj.a - 1].b = g.ax;
         obj.f = 1;
         obj.g = -1;
         obj.a(1);
         if (n2 == 2) {
            obj.i = true;
            return;
         }
         if (n2 == 3) {
            obj.i = true;
            obj.j = true;
            obj.e = 2;
         }
      }
   }

   public final void d(final int n, final int n2) {
   }

   public final void a(final int n, final byte b, final byte b2, final int n2, final short n3) {
      Avatar g;
      if ((g = LoadMap.g(n)) == null && ListScr.c != null) {
         for (int i = 0; i < ListScr.c.size(); ++i) {
            final Avatar avatar;
            if ((avatar = (Avatar) ListScr.c.elementAt(i)).w == n) {
               g = avatar;
            }
         }
      }
      final Avatar avatar2;
      if ((avatar2 = g) != null) {
         final Vector vector;
         (vector = new Vector()).addElement(new CommandInfo(this, null, 0, avatar2, b, b2, n2, n3));
         PopupShop.b().a(new String[] { T1.cw }, new Vector[1], vector);
         PopupShop.b().a();
      }
      GameCanvas.h();
   }
}

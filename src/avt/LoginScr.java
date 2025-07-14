package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class LoginScr extends MyScreen {
   public static LoginScr a;
   public TField b = new TField();
   public TField c = new TField();
   public TField d = new TField();
   public TField e = new TField();
   private int z;
   private int A;
   private int B;
   private Command C;
   Command f;
   private Command D;
   Command g;
   private boolean E = true;
   Command h;
   public boolean i = false;
   private String F = "19006610";
   public int j;
   public int k;
   public int l;
   public int m;
   public int n;
   public int o;
   public int p;
   public int q;
   public long r = 0L;
   public static int s = 0;
   public static String t;
   public static boolean u = false;
   public static boolean v;
   public static boolean w;
   private String[] G = new String[]{"Chơi mới", "Chơi tiếp", "Đổi tài khoản"};
   public int x;
   public int y;
   private byte H;
   private String I = "";
   private String J = "";
   private boolean K;

   public static LoginScr b() {
      if (a == null) {
         a = new LoginScr();
      }

      return a;
   }

   public final void d() {
      GameCanvas.b(T1.P, 54);
   }

   public final void a() {
      this.c();
      super.a();
      GameCanvas.h();
      if (GameCanvas.H) {
         this.H = -1;
      }

      v = true;
      super.ad = this.g;
      if (this.I.equals("") && this.b.f().equals("")) {
         this.G = new String[]{"Chơi mới", "Đổi tài khoản"};
      } else {
         this.G = new String[]{"Chơi tiếp" + (!this.b.f().equals("") ? ", " + this.b.f() : ""), "Chơi mới", "Đổi tài khoản"};
      }
   }

   public final void e() {
      this.r = System.currentTimeMillis();
      FilePack.b(T1.aw);

      try {
         if (GameMidlet.f == 6) {
            MyScreen.am = Image.createImage("/lgyeah.png");
         } else {
            MyScreen.am = Image.createImage(T1.a() + "/l.png");
         }
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      FilePack.a();
      this.A = -50;
      GameCanvas.x.e(26);
      GameMidlet.i.aw = GameMidlet.i.C = LoadMap.e * 24 / 2 + 30;
      AvCamera.a().a = AvCamera.a().c = 200;
      this.b.a(true);
      this.c.a(false);
      this.z = 0;
      this.b.a(true);
   }

   public final void c() {
      this.h = new Command(T1.c, 0);
      this.D = new Command(T1.dt, 3);
      this.f = new Command(T1.O, 1);
      this.C = new Command(T1.bA, 2);
      this.g = new Command(T1.O, 104);
      super.ac = this.h;
   }

   public LoginScr() {
      this.f();
      this.b.a(true);
      this.b.d(0);
      this.c.d(2);
      this.d.d(2);
      this.e.d(0);
      this.e.q = "Tùy chọn";
      this.z = 0;
      if (CRes.b(CRes.b) == null) {
         AvatarData.b();
      }

   }

   public final void f() {
      if (GameCanvas.n > 200) {
         this.B = GameCanvas.p - 80;
      } else {
         this.B = GameCanvas.p - 65;
      }

      this.A = -50;
      this.p = GameCanvas.m - 30;
      if (this.p < 70) {
         this.p = 70;
      }

      if (this.p > 99) {
         this.p = 99;
      }

      this.q = (GameCanvas.m - this.p >> 1) + 29;
      if (GameCanvas.m <= 128) {
         this.p = 80;
         this.q = (GameCanvas.m - this.p >> 1) + 20;
      }

      this.q -= (AvMain.Y - 1) * 40;
      GameCanvas.S.a(this);
      this.B = this.k / 2;
      this.A = this.B;
      AvCamera.a().h = GameMidlet.i;
      AvCamera.a().d();
   }

   public final void d(int var1, int var2) {
      switch (var1) {
         case 0:
            this.i = true;
            GameCanvas.S.a(this);
            return;
         case 1:
            this.i = false;
            GameCanvas.S.a(this);
            return;
         case 2:
            GameCanvas.b(T1.P, 54);
            return;
         case 3:
            GameCanvas.b(T1.du, 55, (AvMain)null);
            return;
         case 4:
            GameCanvas.u.a(T1.bC, 100, 3);
            return;
         case 5:
            OptionScr.b().a();
            return;
         case 6:
            GameMidlet.b("http://wap.teamobi.com/faqs.php?provider=" + GameMidlet.f);
            return;
         case 7:
            GameMidlet.b("http://wap.teamobi.com?info=checkupdate&game=8&version=2.5.8&provider=" + GameMidlet.f + "&agent=" + GameMidlet.g);
            return;
         case 8:
            if (!this.F.equals("")) {
               GameMidlet.b("tel:" + this.F);
               return;
            }

            if (!Session_ME.a().c) {
               GameCanvas.c(T1.M);
               GameCanvas.c();
            } else {
               GameCanvas.i();
            }

            GlobalService.gI().a((byte)5, (String)null);
            return;
         case 9:
            GameCanvas.b(T1.bH + T1.bG);
            AvatarData.a();
         case 50:
         default:
      }
   }

   private void j() {
      if (!this.E) {
         this.E = true;
         this.C.a = T1.bJ;
      } else {
         this.E = false;
         this.C.a = T1.bA;
      }
   }

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var5 = new Vector();
            Command var4 = new Command(T1.x, 2);
            var5.addElement(new Command(T1.bB, 4));
            var5.addElement(new Command(T1.ab, 5));
            if (OptionScr.b().b[4] == 0) {
               var5.addElement(new Command(T1.bD, 6));
            }

            var5.addElement(new Command(T1.bE, 7));
            if (OptionScr.b().b[4] == 0) {
               var5.addElement(new Command(T1.bF, 8));
            }

            var5.addElement(new Command(T1.bG, 9));
            var5.addElement(var4);
            MenuSub.a().a(var5, 0);
            return;
         case 1:
            v = true;
            super.ac = this.h;
            super.ad = this.g;
            this.H = 0;
            this.G = new String[]{"Chơi tiếp" + (!this.b.f().equals("") ? ", " + this.b.f() : ""), "Chơi mới", "Đổi tài khoản"};
            return;
         case 2:
            this.j();
            return;
         case 3:
            if (this.b.f().equals("")) {
               GameCanvas.b(T1.eo[0]);
            } else if (this.c.f().equals("")) {
               GameCanvas.b(T1.eo[1]);
            } else if (this.d.f().equals("")) {
               GameCanvas.b(T1.eo[2]);
            } else if (!this.c.f().equals(this.d.f())) {
               GameCanvas.b(T1.eo[3]);
            } else {
               GameCanvas.h();
               this.r = System.currentTimeMillis();
               if (this.e.f().equals("")) {
                  n();
                  return;
               }

               GameCanvas.b("Bạn nên điền chính xác số di động hoặc email. Khi quên mật khẩu, bạn sẽ dùng nó để lấy lại. Bạn có chắc chắn đã điền số di động / email đúng chưa?", 102);
            }
            break;
         case 50:
            GameCanvas.b(T1.bI);
            return;
         case 51:
            this.m();
            return;
         case 52:
            return;
         case 53:
            GameMidlet.b("http://teamobi.com/dieukhoan.htm");
            return;
         case 54:
            GameMidlet.a();
            return;
         case 55:
            u = false;
            this.g();
            AvatarData.b("avatarSV");
            GameMidlet.a();
            return;
         case 100:
            String var3;
            if ((var3 = GameCanvas.u.a()).equals("")) {
               return;
            }

            (new class_n(this, var3)).perform();
            return;
         case 101:
            this.m();
            return;
         case 102:
            n();
            return;
         case 103:
            return;
         case 104:
            this.o();
      }

   }

   private void m() {
      GameCanvas.i();
      GameCanvas.c();
      GlobalService.gI().c(this.b.f().toLowerCase(), this.c.f().toLowerCase(), this.e.f());
      this.i = false;
      super.ad = this.f;
      GameCanvas.S.a(this);
   }

   private static void n() {
      Vector var0;
      (var0 = new Vector()).addElement(new Command(T1.e, 51));
      var0.addElement(new Command(T1.bK, 52));
      var0.addElement(new Command(T1.bL, 53));
      GameCanvas.a(T1.bM, var0);
   }

   public final void k() {
      if ((System.currentTimeMillis() - this.r) / 1000L > 300L) {
         GameMidlet.h.notifyDestroyed();
      }

      if (!v && this == GameCanvas.r && GameCanvas.t == null && !v) {
         this.b.e();
         this.c.e();
         if (this.i) {
            this.d.e();
            this.e.e();
         }

         if (this.b.d()) {
            super.ae = this.b.a();
         } else if (this.c.d()) {
            super.ae = this.c.a();
         } else if (this.d.d()) {
            super.ae = this.d.a();
         }
      } else {
         super.ae = null;
      }

      if (this.B != this.A) {
         this.A += this.B - this.A >> 1;
      }

      if (this.i) {
         super.ad = this.D;
      } else if (this.z == 2) {
         super.ae = this.C;
      }

      GameCanvas.x.b();
   }

   public final void d(int var1) {
      if (this.b.d()) {
         this.b.b(var1);
      } else if (this.c.d()) {
         this.c.b(var1);
      } else if (this.d.d()) {
         this.d.b(var1);
      } else if (this.e.d()) {
         this.e.b(var1);
      }

      super.d(var1);
   }

   public final void a(Graphics var1) {
      this.b(var1);
      super.a(var1);
      GameCanvas.a(var1);
   }

   public final void b(Graphics var1) {
      GameCanvas.x.b(var1);
      GameCanvas.x.d(var1);
      GameCanvas.c(var1);
      int var4;
      if (v) {
         Graphics var3 = var1;
         LoginScr var2 = this;
         GameCanvas.S.a(var1, this.j, this.k, this.l, this.m, 0);
         var1.translate(this.j, this.k + this.y);
         if (this.H != -1) {
            GameCanvas.S.c(var1, 5 * AvMain.Y, this.H * this.x, this.l - 10 * AvMain.Y, this.x);
         }

         for(var4 = 0; var4 < var2.G.length; ++var4) {
            GameCanvas.K.a(var3, var2.G[var4], var2.l / 2, var4 * var2.x + var2.x / 2 - GameCanvas.K.a() / 2, 2);
         }
      } else if (GameCanvas.v == null && this == GameCanvas.r) {
         GameCanvas.S.a(var1, this.j, this.k, this.l, this.m, 0);
         var1.setClip(this.j + 4, this.k + 4, this.l - 8, this.m - 8);
         if (!this.F.equals("") && OptionScr.b().b[4] == 0) {
            GameCanvas.S.a(var1, "Hotline: " + this.F, this.j + this.l - 8, this.k + this.m - AvMain.ah - 4, 1);
         }

         this.b.a(var1);
         var1.setClip(this.j + 4, this.k + 4, this.l - 8, this.m - 8);
         if ((var4 = GameCanvas.K.a(T1.bN + ":")) < this.b.a - this.j) {
            var4 = (this.b.a - this.j - var4) / 2 + AvMain.Z;
         } else {
            var4 = this.b.a - var4 - 5;
         }

         GameCanvas.S.a(var1, T1.bN, this.j + var4, this.b.b + this.b.d / 2 - AvMain.ah / 2, 0);
         GameCanvas.S.a(var1, T1.bO + ":", this.j + var4, this.c.b + this.b.d / 2 - AvMain.ah / 2, 0);
         if (!this.i) {
            GameCanvas.S.a(var1, this.n, this.o, this.z, this.E);
         } else {
            GameCanvas.S.a(var1, T1.cE, this.j + var4, this.d.b + this.b.d / 2 - AvMain.ah, 0);
            GameCanvas.S.a(var1, T1.bO + ":", this.j + var4, this.d.b + this.b.d / 2, 0);
            GameCanvas.S.a(var1, "Số di động", this.j + var4, this.e.b + this.b.d / 2 - AvMain.ah, 0);
            GameCanvas.S.a(var1, "hoặc email:", this.j + var4, this.e.b + this.b.d / 2, 0);
            this.d.a(var1);
            this.e.a(var1);
         }

         this.c.a(var1);
      }

      GameCanvas.c(var1);
      var1.drawImage(MyScreen.am, GameCanvas.o, this.A, 3);
   }

   public final void l() {
      if (v) {
         LoginScr loginScr = this;
         if (GameCanvas.a(2)) {
            loginScr.H = (byte)(loginScr.H - 1);
            if (loginScr.H < 0) {
               loginScr.H = (byte)(loginScr.G.length - 1);
            }
         } else if (GameCanvas.a(8)) {
            loginScr.H = (byte)(loginScr.H + 1);
            if (loginScr.H >= loginScr.G.length) {
               loginScr.H = 0;
            }
         }
         if (GameCanvas.g) {
            int n = 0;
            while (n < loginScr.G.length) {
               if (GameCanvas.b(loginScr.j, loginScr.k + loginScr.y + n * loginScr.x, loginScr.l, loginScr.x)) {
                  loginScr.H = (byte)n;
                  GameCanvas.g = false;
                  loginScr.K = true;
                  break;
               }
               ++n;
            }
         }
         if (loginScr.K) {
            if (GameCanvas.e && !GameCanvas.b(loginScr.j, loginScr.k + loginScr.y + loginScr.H * loginScr.x, loginScr.l, loginScr.x)) {
               loginScr.H = (byte)-1;
            }
            if (GameCanvas.f) {
               GameCanvas.f = false;
               loginScr.K = false;
               if (loginScr.H != -1) {
                  loginScr.o();
               }
            }
         }
         super.l();
         return;
      }
      if (GameCanvas.f && GameCanvas.a(0, 0, GameCanvas.m, GameCanvas.n) && GameCanvas.a(this.n - 10, this.o, 70, MyScreen.al * AvMain.Y + 10)) {
         this.j();
      }
      if (GameCanvas.b[2]) {
         this.z = this.z > 0 ? --this.z : (this.i ? 3 : 2);
      }
      if (GameCanvas.b[8]) {
         this.z = this.z < (this.i ? 3 : 2) ? ++this.z : 0;
      }
      if (GameCanvas.b[2] || GameCanvas.b[8]) {
         GameCanvas.e();
         if (this.z == 0) {
            this.b.a(true);
            this.c.a(false);
            this.d.a(false);
            this.e.a(false);
         } else if (this.z == 1) {
            this.b.a(false);
            this.c.a(true);
            this.d.a(false);
            this.e.a(false);
         } else if (this.z == 2) {
            this.b.a(false);
            this.c.a(false);
            this.ae = null;
            if (this.i) {
               this.d.a(true);
               this.e.a(false);
            }
         } else {
            this.b.a(false);
            this.c.a(false);
            this.d.a(false);
            this.e.a(true);
         }
      }
      super.l();
   }

   private void o() {
      System.out.println("clickNewGame: " + w + "    " + this.H);
      switch (this.H) {
         case 0:
            if (this.G.length == 2) {
               (new class_jk(this)).perform();
               return;
            }

            if (w) {
               class_ez.b().a();
               return;
            }

            String var2 = this.b.f().toLowerCase().trim();
            String var3 = this.c.f();
            if (!var2.equals("")) {
               if (var3.equals("")) {
                  this.z = 1;
                  this.b.a(false);
                  this.c.a(true);
                  break;
               }

               class_ez.b().a();
            }

            return;
         case 1:
            if (this.G.length != 2) {
               class_jk var1 = new class_jk(this);
               if (!this.I.equals("") && this.b.f().equals("")) {
                  GameCanvas.a("Tài khoản của bạn chưa được đăng kí liên kết với một tài khoản Team. Bạn sẽ mất tài khoản đang chơi nếu tiếp tục. Bạn có muốn tiếp tục ?", (IAction)var1);
                  return;
               }

               var1.perform();
               return;
            }
         case 2:
            this.p();
      }

   }

   private void p() {
      class_dg var1 = new class_dg(this);
      if (!this.I.equals("") && this.b.f().equals("")) {
         GameCanvas.a("Tài khoản của bạn chưa được đăng kí liên kết với một tài khoản Team. Bạn sẽ mất tài khoản đang chơi nếu tiếp tục. Bạn có muốn tiếp tục ?", (IAction)var1);
      } else {
         var1.perform();
      }
   }

   public final void g() {
      System.out.println("saveLogin");
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(var1);

      try {
         var2.writeUTF("2.5.8");
         var2.writeByte(super.ar);
         var2.writeUTF(this.F);
         var2.writeUTF(this.I);
         var2.writeUTF(this.J);
         if (this.E) {
            var2.writeUTF(b().b.f());
            var2.writeUTF(b().c.f());
         }

         var2.writeInt(s);
         var2.writeBoolean(u);
         var2.writeBoolean(w);
         CRes.a("avlogin", var1.toByteArray());
         var2.close();
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public final void h() {
      DataInputStream var1;
      if ((var1 = AvatarData.a("avlogin")) != null) {
         String var2 = "";

         try {
            var2 = var1.readUTF();
            super.ar = var1.readByte();
            this.F = var1.readUTF();
            this.I = var1.readUTF();
            this.J = var1.readUTF();
            if (this.E) {
               this.b.a(var1.readUTF());
               this.c.a(var1.readUTF());
            }

            s = var1.readInt();
            u = var1.readBoolean();
            w = var1.readBoolean();
            var1.close();
         } catch (Exception var3) {
            AvatarData.b("avlogin");
         }

         if (!u) {
            AvatarData.b("avatarSV");
         }

         if (!"2.5.8".equals(var2)) {
            AvatarData.a();
         }

      }
   }

   public final void a(String var1) {
      this.F = var1;
   }

   public final void i() {
      GameCanvas.c();
      GlobalService.gI().f(b().F.hashCode());
      System.out.println("login: " + v + "    " + this.H);
      if (!v || (this.H != 0 || this.G.length != 2) && (this.H != 1 || this.G.length != 3)) {
         if (this.b.f().equals("")) {
            GlobalService.gI().a(this.I, this.J, "2.5.8");
            w = true;
         } else {
            w = false;
            this.I = "";
            this.J = "";
            GlobalService.gI().a(this.b.f().toLowerCase(), this.c.f(), "2.5.8");
         }
      } else {
         GlobalService var1 = GlobalService.gI();
         System.out.println("doLoginNewGame");
         var1.e((byte)-12);
         var1.k();
      }
   }

   public final void a(String var1, String var2) {
      System.out.println("onLoginNewGame: " + var1 + "   " + var2);
      this.I = var1;
      this.J = var2;
      this.b.a("");
      this.c.a("");
      w = true;
      v = false;
      this.i();
   }
}

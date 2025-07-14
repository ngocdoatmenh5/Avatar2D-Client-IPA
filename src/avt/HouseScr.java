package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class HouseScr extends MyScreen implements IChatable {
   public static HouseScr a;
   private int h;
   private int i;
   private int j = -1;
   private Command k;
   private Command l;
   private Command m;
   private static short n = 0;
   public static boolean b = false;
   private Vector o;
   public byte c = -1;
   private int p = -1;
   public int d = -1;
   private int q;
   public static boolean e = false;
   private class_he[] r;
   private AvPosition s;
   private AvPosition t;
   private BigImgInfo u;
   private Image v;
   private int w = -1;
   private int x = -1;
   private int[] y = new int[]{1688583, 14744065};
   public int f;
   public int g;
   private short z = 69;
   private short A = 68;
   private short[] B;
   private int C = 0;
   private Vector D;
   private Vector E;
   private int F;
   private byte G;

   public static HouseScr b() {
      if (a == null) {
         a = new HouseScr();
      }

      return a;
   }

   public final void a() {
      super.a();
      this.i();
   }

   public HouseScr() {
      this.k = new Command(T1.cS, 0);
      this.l = new Command(T1.cy, 1);
      this.m = new Command(T1.c, 2);
      FilePack.b(T1.av);
      this.v = FilePack.a("hand");
      FilePack.a();
   }

   private void i() {
      if (this.q == GameMidlet.i.w) {
         super.ad = MapScr.b().e;
         super.ad.a = T1.O;
         super.ac = this.m;
      } else {
         super.ac = this.m;
         if (GameCanvas.Z == 0) {
            super.ad = MapScr.b().e;
         }

      }
   }

   private void j() {
      LoadMap.b(GameMidlet.i);
      GameMidlet.i.aw = this.t.a;
      GameMidlet.i.ax = this.t.b;
      GameMidlet.i.H = 0;
      AvCamera.a().a(this.t.a * AvMain.Y, this.t.b * AvMain.Y);
   }

   public final void d() {
      MapScr.b().e();
   }

   private void m() {
      super.ad = new Command(T1.O, 3);
      super.ae = new Command(T1.cy, 4);
      super.ac = null;
      e = true;
      this.h = GameMidlet.i.aw / 24;
      this.i = GameMidlet.i.ax / 24;
      LoadMap.c(GameMidlet.i);
   }

   private void n() {
      HomeMsgHandler.a();
      this.h = GameMidlet.i.aw / 24;
      this.i = GameMidlet.i.ax / 24;
      LoadMap.c(GameMidlet.i);
   }

   private static void o() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < LoadMap.m.size(); ++var1) {
         Base var2;
         if ((var2 = (Base)LoadMap.m.elementAt(var1)).az == 0 && var2.w != GameMidlet.i.w) {
            var0.addElement(new Command(var2.x, 16, var1));
         }
      }

      MenuSub.a().a(var0, 0);
   }

   private void p() {
      this.n();
      if (this.B == null) {
         this.B = new short[LoadMap.d.length];

         for(int var1 = 0; var1 < LoadMap.d.length; ++var1) {
            this.B[var1] = LoadMap.d[var1];
         }
      }

      b = false;
      super.ad = this.k;
      super.ae = this.l;
      super.ac = new Command(T1.O, 5);
      Vector var4 = new Vector();

      for(int var2 = 0; var2 < this.r.length; ++var2) {
         if (this.r[var2].b != -1 || this.r[var2].c != -1) {
            var4.addElement(new class_gl(this, this.r[var2].a + "(" + GameCanvas.a(this.r[var2].b, this.r[var2].c, true) + ")", 17, var2, var2));
         }
      }

      if (var4.size() > 0) {
         MenuSub.a().a(var4, GameCanvas.o, 27 * AvMain.Y, 27 * AvMain.Y);
      }

   }

   private void q() {
      this.d = -1;
      this.j = -1;
      e = false;
      b = false;
      this.i();
      super.ae = null;
      if (LoadMap.g(GameMidlet.i.w) == null) {
         this.j();
      }

   }

   private void r() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < AvatarData.e.size(); ++var2) {
         MapItemType var3;
         int var4;
         if ((var3 = (MapItemType)AvatarData.e.elementAt(var2)).i != 0 && (this.c != 4 && (var3.i == 1 || var3.i == 2) || this.c == 4) && (var4 = var3.g.indexOf(":")) != -1) {
            boolean var5 = false;
            String var6 = var3.g.substring(0, var4);

            for(var4 = 0; var4 < var1.size(); ++var4) {
               if (((Command)var1.elementAt(var4)).a.equals(var6)) {
                  var5 = true;
               }
            }

            if (!var5 || var1.size() == 0) {
               var1.addElement(new Command(var6, 18, var2));
            }
         }
      }

      MenuSub.a().a(var1, 2);
   }

   private void b(String var1) {
      this.q();
      Vector var2 = new Vector();

      for(int var3 = 0; var3 < AvatarData.e.size(); ++var3) {
         MapItemType var4;
         int var5 = (var4 = (MapItemType)AvatarData.e.elementAt(var3)).g.indexOf(var1);
         if (var4.i != 0 && var5 != -1 && (this.c != 4 && (var4.i == 1 || var4.i == 2) || this.c == 4)) {
            String var8 = var4.g.substring(var4.g.indexOf(":") + 1);
            String var6 = GameCanvas.a(var4.h, var4.d, true);
            var2.addElement(new class_gk(this, "", new class_gi(this, var3, var1), var4, 90, var6, var8));
         }
      }

      if (var2.size() > 0) {
         MenuSub.a().a(var2, GameCanvas.o, 90, 90);
         MenuSub.g = new class_gj(this);
      }

   }

   private boolean a(MapItemType var1) {
      if (var1.i != 2 && var1.i != 4) {
         if (LoadMap.g[this.i * LoadMap.e + this.h] != 80) {
            GameCanvas.b(T1.db);
            return true;
         }

         for(int var5 = 0; var5 < var1.j.size(); ++var5) {
            AvPosition var6 = (AvPosition)var1.j.elementAt(var5);
            if (LoadMap.g[(this.i + var6.b) * LoadMap.e + this.h + var6.a] != 80) {
               GameCanvas.b(T1.db);
               return true;
            }
         }
      } else {
         String var2 = "";

         int var3;
         for(var3 = 0; var3 < this.o.size(); ++var3) {
            MapItem var4 = (MapItem)this.o.elementAt(var3);
            if (var3 != this.d && var4.b == var1.a && this.h == var4.aw / 24 && this.i == var4.ax / 24) {
               var2 = T1.dc;
               break;
            }
         }

         if (!var2.equals("")) {
            GameCanvas.b(var2);
            return true;
         }

         if (var1.i == 2 || var1.i == 4) {
            var3 = (this.i - 1) * LoadMap.e + this.h;
            if (LoadMap.d[var3] < n || LoadMap.d[this.i * LoadMap.e + this.h] >= n) {
               GameCanvas.b(T1.dd);
               return true;
            }
         }
      }

      return false;
   }

   public final void a(MapItem var1) {
      if (d(var1)) {
         ++var1.ax;
      }

      this.o.addElement(var1);
      LoadMap.l.addElement(var1);
      this.c(var1);
      LoadMap.a(LoadMap.l);
   }

   public final void l() {
      super.l();
      if (!e) {
         GameCanvas.x.a();
         GameMidlet.i.e();
      } else {
         boolean var1 = false;
         if (GameCanvas.a(2)) {
            if (!b(this.h, this.i - 1)) {
               --this.i;
            }

            if (this.i < 0) {
               this.i = 0;
            }

            var1 = true;
         } else if (GameCanvas.a(4)) {
            if (!b(this.h - 1, this.i)) {
               --this.h;
            }

            if (this.h < 0) {
               this.h = 0;
            }

            var1 = true;
            GameMidlet.i.K = Base.J;
         } else if (GameCanvas.a(6)) {
            if (!b(this.h + 1, this.i)) {
               ++this.h;
            }

            if (this.h >= LoadMap.e) {
               this.h = LoadMap.e - 1;
            }

            var1 = true;
            GameMidlet.i.K = 0;
         } else if (GameCanvas.a(8)) {
            if (!b(this.h, this.i + 1)) {
               ++this.i;
            }

            if (this.i >= LoadMap.f) {
               this.i = LoadMap.f - 1;
            }

            var1 = true;
         }

         if (GameCanvas.f) {
            int var3 = (AvCamera.a().a + GameCanvas.h) / (LoadMap.i * AvMain.Y);
            int var2 = (AvCamera.a().b + GameCanvas.i) / (LoadMap.i * AvMain.Y);
            if (var3 == this.h && var2 == this.i && super.ad != null) {
               super.ad.b();
            }

            this.h = var3;
            this.i = var2;
            var1 = true;
            GameCanvas.f = false;
         }

         if (var1) {
            GameMidlet.i.aw = this.h * 24 + 12;
            GameMidlet.i.ax = this.i * 24 + 12;
            if (this.d != -1 && this.o.size() > 0) {
               MapItem var4;
               (var4 = (MapItem)this.o.elementAt(this.d)).aw = this.h * 24;
               var4.ax = this.i * 24;
               LoadMap.a(LoadMap.l);
            }
         }

      }
   }

   private static boolean b(int var0, int var1) {
      return LoadMap.d[var1 * LoadMap.e + var0] == LoadMap.c.c - 2 || LoadMap.d[var1 * LoadMap.e + var0] == -1;
   }

   public final void k() {
      MapScr.b().k();
      if (!e && !b && super.ae == null && MapScr.b().ae != null) {
         super.ae = LoadMap.q;
      }

   }

   public final void a(Graphics var1) {
      this.b(var1);
      super.a(var1);
      GameCanvas.a(var1);
   }

   public final void b(Graphics var1) {
      GameCanvas.x.b(var1);
      if (e && GameCanvas.t == null) {
         Graphics var3 = var1;
         HouseScr var2 = this;
         int var6;
         if (!b && this.d == -1) {
            if (this.j != -1) {
               var6 = 0;

               while(true) {
                  if (var6 >= LoadMap.g.length) {
                     LoadMap.c.a(var2.j, var2.h * 24 * AvMain.Y, var2.i * 24 * AvMain.Y, 0, 0, var3);
                     break;
                  }

                  if (var2.p == 0 && LoadMap.d[var6] >= n && LoadMap.d[var6] < var2.r.length && (var2.r[LoadMap.d[var6]].c != -1 || var2.r[LoadMap.d[var6]].b != -1) || var2.p == 1 && LoadMap.d[var6] < n) {
                     var2.a(var3, 2 + var6 % LoadMap.e * 24, 2 + var6 / LoadMap.e * 24, 0, 20);
                  }

                  ++var6;
               }
            }
         } else if (this.j != -1) {
            MapItemType var4;
            if ((var4 = (MapItemType)AvatarData.e.elementAt(this.j)).i != 2 && var4.i != 4) {
               for(var6 = 0; var6 < LoadMap.g.length; ++var6) {
                  if (LoadMap.g[var6] == 80 && (var6 % LoadMap.e != var2.h || var6 / LoadMap.e != var2.i)) {
                     var2.a(var3, 2 + var6 % LoadMap.e * 24, 2 + var6 / LoadMap.e * 24, 0, 20);
                  }
               }
            } else {
               for(var6 = 0; var6 < LoadMap.d.length; ++var6) {
                  if (var6 > 0 && LoadMap.d[var6] < n && LoadMap.d[var6 - LoadMap.e] >= n) {
                     var2.a(var3, 2 + var6 % LoadMap.e * 24, 2 + var6 / LoadMap.e * 24, 0, 20);
                  }
               }
            }
         }

         var2.a(var3, var2.h * 24, var2.i * 24, 1, 24);
      }

      GameCanvas.x.d(var1);
      if (e) {
         if (b && this.j != -1) {
            MapItemType var5 = (MapItemType)AvatarData.e.elementAt(this.j);
            AvatarData.a(var1, var5.b, (this.h * 24 + var5.e) * AvMain.Y, (this.i * 24 + var5.f) * AvMain.Y, 0);
         }

         if (GameCanvas.t == null) {
            var1.drawImage(this.v, (this.h * 24 + 12) * AvMain.Y, (this.i * 24 + this.C) * AvMain.Y, 33);
         }

         if (this.p != -1) {
            GameCanvas.L.a(var1, this.r[this.j].a + "(" + GameCanvas.a(this.r[this.j].b, this.r[this.j].c, true) + ")", (this.h * 24 + 12) * AvMain.Y, (this.i * 24 - 40) * AvMain.Y, 2);
         }

         ++this.C;
         if (this.C > 5) {
            this.C = 0;
         }
      }

      GameCanvas.c(var1);
      LoadMap.a(var1);
   }

   private void a(Graphics var1, int var2, int var3, int var4, int var5) {
      var1.setColor(this.y[var4]);
      var1.drawRect(var2 * AvMain.Y, var3 * AvMain.Y, (var5 - 1) * AvMain.Y, (var5 - 1) * AvMain.Y);
   }

   public final void a(byte var1, int var2, short[] var3, byte var4, Vector var5, Vector var6) {
      this.c = (byte)var1;
      this.q = var2;
      this.o = var5;
      LoadMap.e = var4;
      LoadMap.f = (short)(var3.length / var4);
      LoadMap.d = var3;
      if (this.c == 4) {
         GameCanvas.x.e(111);
      } else {
         GameCanvas.x.e(68 + this.c);
      }

      LoadMap.t = -1;
      var1 = -1;
      var2 = 0;

      int var8;
      int var14;
      for(var8 = 0; var8 < var4; ++var8) {
         for(var14 = 0; var14 < LoadMap.f; ++var14) {
            if (LoadMap.d[var14 * var4 + var8] < n) {
               LoadMap.g[var14 * var4 + var8] = 80;
            } else {
               LoadMap.g[var14 * var4 + var8] = 88;
            }
         }

         if (LoadMap.d[(LoadMap.f - 1) * var4 + var8] == this.u.e.getHeight() / (24 * AvMain.Y) - 1) {
            LoadMap.d[(LoadMap.f - 1) * var4 + var8] = LoadMap.d[(LoadMap.f - 2) * var4 + var8];
            LoadMap.g[(LoadMap.f - 1) * var4 + var8] = 21;
            ++var2;
            if (var1 == -1) {
               var1 = (byte) (var8 * 24);
            }
         }
      }

      this.t = new AvPosition(var1 + var2 * 24 / 2, LoadMap.f * 24 - 30);
      GameMidlet.i.aw = this.t.a;
      GameMidlet.i.ax = this.t.b;
      Pet var11;
      if ((var11 = LoadMap.h(GameMidlet.i.w)) != null) {
         var11.a(GameMidlet.i.aw, GameMidlet.i.ax);
         var11.h();
      }

      AvCamera.a().b(70 + this.c);
      LoadMap.c = new FrameImage(this.u.e, 24 * AvMain.Y, 24 * AvMain.Y);

      for(var14 = 0; var14 < var6.size(); ++var14) {
         Avatar var7;
         (var7 = (Avatar)var6.elementAt(var14)).C = var7.aw;
         var7.D = var7.ax;
         if (var7.w != GameMidlet.i.w) {
            LoadMap.b(var7);
         }
      }

      var14 = 0;
      var1 = 0;

      for(var2 = 0; var2 < this.o.size(); ++var2) {
         MapItem var12;
         if ((var12 = (MapItem)this.o.elementAt(var2)).aw == 0 && var12.ax == 0) {
            boolean var13 = false;

            for(int var16 = 0; var16 < LoadMap.d.length; ++var16) {
               if (LoadMap.g[var16] == 80) {
                  var12.aw = var16 % LoadMap.e * 24;
                  var12.ax = var16 / LoadMap.e * 24;
                  var14 = var12.aw;
                  var1 = (byte) var12.ax;
                  var13 = true;
                  this.c(var12);
                  AvatarService.a().a(var12.b, 0, 0, var12.aw / 24, var12.ax / 24, var12.c);
                  break;
               }
            }

            if (!var13) {
               var12.aw = var14;
               var12.ax = var1;
               AvatarService.a().a(var12.b, 0, 0, var12.aw / 24, var12.ax / 24, var12.c);
            }
         }

         if (d(var12)) {
            ++var12.ax;
         }
      }

      MapScr.b().n();
      Vector var10 = this.o;
      HouseScr var9 = this;

      for(var8 = 0; var8 < var10.size(); ++var8) {
         MapItem var15 = (MapItem)var10.elementAt(var8);
         LoadMap.l.addElement(var15);
         var9.c(var15);
      }

      LoadMap.a(LoadMap.l);
      this.a();
      GameCanvas.h();
   }

   private static boolean d(MapItem var0) {
      if (AvatarData.b((int)var0.b).i != 2 && AvatarData.b((int)var0.b).i != 4) {
         int var1 = (var0.ax / 24 - 1) * LoadMap.e + var0.aw / 24;
         if (LoadMap.d[var1] >= n && LoadMap.d[var0.ax / 24 * LoadMap.e + var0.aw / 24] < n) {
            return true;
         }
      }

      return false;
   }

   private BigImgInfo s() {
      DataInputStream var1;
      if ((var1 = AvatarData.a("avatarTileMap")) == null) {
         return null;
      } else {
         this.u = new BigImgInfo();

         try {
            this.u.b = var1.readShort();
            n = var1.readShort();
            byte[] var2 = new byte[var1.available()];
            var1.read(var2);
            this.u.e = CRes.a(var2);
            var1.close();
         } catch (Exception var3) {
            var3.printStackTrace();
         }

         return this.u;
      }
   }

   public final void a(byte[] var1, int var2) {
      n = (short)var2;
      this.u.e = CRes.a(var1);
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      DataOutputStream var4 = new DataOutputStream(var3);

      try {
         var4.writeShort(this.u.b);
         var4.writeShort(var2);
         var4.write(var1);
         CRes.a("avatarTileMap", var3.toByteArray());
         var4.close();
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      if (MapScr.v != -1) {
         AvatarService.a().b(MapScr.v);
         MapScr.v = -1;
      } else {
         GameCanvas.h();
      }
   }

   public final void a(int var1, int var2) {
      int var3;
      Vector var7;
      switch (var1) {
         case 0:
            if (this.j == -1) {
               return;
            }

            var2 = this.i * LoadMap.e + this.h;
            if (this.r[LoadMap.d[var2]].c == -1 && this.r[LoadMap.d[var2]].b == -1) {
               GameCanvas.b(T1.db);
            } else {
               if ((this.j >= n || LoadMap.d[var2] < n) && (this.j < n || LoadMap.d[var2] >= n)) {
                  this.w = this.h;
                  this.x = this.i;
                  LoadMap.d[this.i * LoadMap.e + this.h] = (short)this.j;
                  return;
               }

               GameCanvas.b(T1.db);
            }
            break;
         case 1:
            this.j = -1;
            this.p = -1;
            this.w = -1;
            this.x = -1;
            boolean var6 = false;

            for(var2 = 0; var2 < this.B.length; ++var2) {
               if (this.B[var2] != LoadMap.d[var2]) {
                  var6 = true;
                  break;
               }
            }

            if (var6) {
               AvatarService.a().a(LoadMap.d, 0);
               GameCanvas.i();
            }

            this.j();
            e = false;
            this.i();
            super.ae = null;
            return;
         case 2:
            var7 = new Vector();
            if (this.q == GameMidlet.i.w) {
               var7.addElement(new Command(T1.co, 1));
               var7.addElement(new Command(T1.cT, 2));
               var1 = 0;

               for(var3 = 0; var3 < LoadMap.m.size(); ++var3) {
                  if (((MyObject)LoadMap.m.elementAt(var3)).az == 0) {
                     ++var1;
                  }
               }

               if (var1 > 1) {
                  var7.addElement(new Command(T1.v, 3));
               }

               var7.addElement(new Command(T1.t, 4));
            }

            var7.addElement(new Command(T1.x, 5));
            MenuSub.a().a(var7, 0);
            return;
         case 3:
            (var7 = new Vector()).addElement(new Command(T1.cY, 11));
            var7.addElement(new Command(T1.cZ, 12));
            var7.addElement(new Command(T1.bg, 13));
            MenuSub.a().a(var7, 2);
            MenuSub var10000 = MenuSub.a();
            int var10001 = this.h * 24 * AvMain.Y - AvCamera.a().a - MenuSub.a().c / 2 + 12;
            int var4 = this.i * 24 * AvMain.Y - AvCamera.a().b - MenuSub.a().d - 12;
            var3 = var10001;
            MenuSub var5 = var10000;
            var10000.a = var3;
            var5.b = var4;
            if (var5.a < 0) {
               var5.a = 0;
            }

            if (var5.b < 0) {
               var5.b = 0;
            }

            return;
         case 4:
            this.q();
            return;
         case 5:
            this.p();
            return;
         case 8:
            InputFace.b();
            GameCanvas.A = null;
            return;
         case 50:
            AvatarService.a().a(LoadMap.d, 1);
            GameCanvas.i();
            return;
         case 51:
            LoadMap.d = this.B;
            this.B = null;
            ParkMsgHandler.a();
            return;
         case 53:
            GlobalService.gI().i(0);
            GameCanvas.i();
            return;
         case 100:
            AvatarService.a().a(GameCanvas.u.a(), 0, 0);
            GameCanvas.h();
            return;
         case 101:
            GlobalService.gI().a(GameCanvas.u.a(), (byte)0);
      }

   }

   public final void a(short var1, String var2) {
      GameCanvas.h();
      if (var1 == 0) {
         Vector var3;
         (var3 = new Vector()).addElement(new Command(T1.o, 50));
         var3.addElement(new Command(T1.p, 51));
         GameCanvas.a(var2, var3);
      } else {
         GameCanvas.b(var2);
         if (var1 == 2) {
            LoadMap.d = this.B;
         }

         this.B = null;
         ParkMsgHandler.a();
         GameMidlet.i.aw = this.t.a;
         GameMidlet.i.ax = this.t.b;
         super.ad = MapScr.b().e;
         AvCamera.a().b(70 + this.c);
      }
   }

   public final void a(class_he[] var1) {
      this.r = var1;
      this.p();
      GameCanvas.h();
   }

   private void e(MapItem var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.o.size(); ++var3) {
         MapItem var4;
         if ((var4 = (MapItem)this.o.elementAt(var3)).aw / 24 == var1.aw / 24 && var4.ax / 24 == var1.ax / 24) {
            ++var2;
         }
      }

      if (var2 == 1) {
         MapItemType var6 = AvatarData.b((int)var1.b);

         for(int var7 = 0; var7 < var6.j.size(); ++var7) {
            AvPosition var5 = (AvPosition)var6.j.elementAt(var7);
            LoadMap.g[(var1.ax / 24 + var5.b) * LoadMap.e + var1.aw / 24 + var5.a] = 80;
         }
      }

   }

   public final void b(MapItem var1) {
      MapItem var2 = var1;
      HouseScr var5 = this;
      int var3 = 0;

      MapItem var10000;
      while(true) {
         if (var3 >= var5.o.size()) {
            var10000 = null;
            break;
         }

         MapItem var4;
         if ((var4 = (MapItem)var5.o.elementAt(var3)).aw / 24 == var2.aw && var4.ax / 24 == var2.ax && var4.b == var2.b) {
            var10000 = var4;
            break;
         }

         ++var3;
      }

      var1 = var10000;
      LoadMap.l.removeElement(var1);
      this.o.removeElement(var1);
      this.e(var1);
      ParkMsgHandler.a();
      GameCanvas.h();
   }

   public final void c(MapItem var1) {
      MapItemType var2 = AvatarData.b((int)var1.b);
      byte var3 = 88;
      if (var2.a == this.A) {
         var3 = 112;
      } else if (var2.a == this.z) {
         var3 = 111;
      } else if (var2.c == 1) {
         var3 = 79;
      } else if (var2.c == 2) {
         var3 = 67;
      }

      for(int var4 = 0; var4 < var2.j.size(); ++var4) {
         AvPosition var5 = (AvPosition)var2.j.elementAt(var4);
         LoadMap.g[(var1.ax / 24 + var5.b) * LoadMap.e + var1.aw / 24 + var5.a] = var3;
      }

   }

   public final void a(int var1, int var2, short var3, Vector var4) {
      if (var1 != 0) {
         for(var1 = 0; var1 < var4.size(); ++var1) {
            Avatar var6;
            Avatar var7 = ListScr.b((var6 = (Avatar)var4.elementAt(var1)).w);
            if (var6 != null && var7 != null) {
               var7.q = var6.q;
            }
         }

         GameCanvas.h();
         this.e();
      } else {
         GameMidlet.i.q = (byte)var2;
         MapScr.b().a();
         boolean var10000;
         if (this.u == null) {
            this.s();
            if (this.u != null && var3 == this.u.b) {
               var10000 = true;
            } else {
               if (this.u == null) {
                  this.u = new BigImgInfo();
                  this.u.b = var3;
               }

               AvatarService var5;
               (var5 = AvatarService.a()).e((byte)-73);
               var5.k();
               var10000 = false;
            }
         } else {
            var10000 = true;
         }

         if (var10000) {
            if (MapScr.v != -1) {
               AvatarService.a().b(MapScr.v);
               MapScr.v = -1;
            } else {
               GameCanvas.J = 1;
               GameCanvas.h();
            }
         } else {
            GameCanvas.J = 1;
         }
      }
   }

   public final void d(int var1) {
      class_im.d().a(var1, this);
      super.d(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         ParkService.a().a(var1);
      }
   }

   public final void e() {
      if (ListScr.d == null) {
         GameCanvas.i();
         CasinoService.a().d();
         ListScr.e = 2;
      } else if (ListScr.f) {
         ListScr.f = false;
         GameCanvas.i();
         AvatarService.a().c((int)1);
      } else {
         Vector var1 = new Vector();

         for(int var2 = 0; var2 < ListScr.d.size(); ++var2) {
            Avatar var3;
            if ((var3 = (Avatar)ListScr.d.elementAt(var2)).q == this.c) {
               var1.addElement(var3);
            }
         }

         if (var1.size() == 0) {
            if (GameCanvas.r == ListScr.b()) {
               ListScr.b().b.a();
            }

            GameCanvas.b(T1.de);
         } else {
            ListScr.b().a();
            ListScr.c = var1;
            ListScr.b().e();
            ListScr.b().g();
         }
      }
   }

   public final void d(int var1, int var2) {
      int var3 = -1;

      int var4;
      MapItem var5;
      for(var4 = 0; var4 < this.o.size(); ++var4) {
         if ((var5 = (MapItem)this.o.elementAt(var4)).aw / 24 == this.h && var5.ax / 24 == this.i) {
            var3 = var4;
            break;
         }
      }

      var5 = null;
      if (var3 != -1) {
         var5 = (MapItem)this.o.elementAt(var3);
      }

      var5 = var5;
      switch (var1) {
         case 1:
            GlobalService var11;
            (var11 = GlobalService.gI()).e((byte)-87);
            var11.k();
            return;
         case 2:
            Vector var10;
            (var10 = new Vector()).addElement(new Command(T1.cU, 6));
            var10.addElement(new Command(T1.cV, 7));
            if (this.o.size() > 0) {
               var10.addElement(new Command(T1.cW, 8));
            }

            MenuSub.a().a(var10, 2);
            return;
         case 3:
            o();
            return;
         case 4:
            GameCanvas.u.a(T1.bO + ":", 100, 2);
            return;
         case 5:
            MapScr.b().e();
            return;
         case 6:
            this.r();
            return;
         case 7:
            e = true;
            if (this.r == null) {
               if (this.r == null) {
                  HomeMsgHandler.a();
                  AvatarService var9;
                  (var9 = AvatarService.a()).e((byte)-43);
                  var9.k();
                  GameCanvas.i();
               }

               return;
            }

            this.p();
            return;
         case 8:
            this.m();
            return;
         case 9:
         case 10:
         default:
            break;
         case 11:
            if (var3 == -1) {
               GameCanvas.b(T1.cX);
               return;
            }

            this.d = var3;

            for(var1 = 0; var1 < AvatarData.e.size(); ++var1) {
               if (((MapItemType)AvatarData.e.elementAt(var1)).a == var5.b) {
                  this.j = var1;
                  break;
               }
            }

            super.ac = null;
            super.ae = null;
            this.e(var5);
            this.s = new AvPosition(this.h, this.i, var5.b);
            super.ad = new Command(T1.z, new class_ga(this, var5));
            return;
         case 12:
            if (var3 == -1) {
               GameCanvas.b(T1.cX);
               return;
            }

            if (var5.c == 0) {
               var5.c = 2;
            } else {
               var5.c = 0;
            }

            AvatarService.a().a(var5.b, this.h, this.i, this.h, this.i, var5.c);
            return;
         case 13:
            if (var3 != -1 && var5.b != this.z) {
               GameCanvas.a(T1.da, (IAction)(new class_fw(this, var5)));
               return;
            }

            GameCanvas.b(T1.cX);
            return;
         case 14:
            PopupShop.b().d();
            GameCanvas.b(T1.cK, 53);
            return;
         case 15:
            TField[] var7 = new TField[3];

            for(var2 = 0; var2 < 3; ++var2) {
               var7[var2] = new TField();
               var7[var2].d(2);
            }

            var7[0].a(true);
            Command var8 = new Command(T1.cy, new class_gg(this, var7));
            PopupShop.b().d();
            InputFace.b().a(var7, T1.cx, T1.eF, var8);
            GameCanvas.A = InputFace.b();
            InputFace.b().ac = new Command(T1.d, 8);
            return;
         case 16:
            if (var2 < LoadMap.m.size()) {
               Base var6 = (Base)LoadMap.m.elementAt(var2);
               AvatarService.a().d(var6.w);
               return;
            }
            break;
         case 17:
            for(var1 = 0; var1 < this.r.length; ++var1) {
               if (var1 == var2) {
                  if (this.w != -1) {
                     this.h = this.w;
                     this.i = this.x;
                     GameMidlet.i.aw = this.w * 24;
                     GameMidlet.i.ax = this.x * 24;
                     AvCamera.a().a(GameMidlet.i.aw * AvMain.Y, GameMidlet.i.ax * AvMain.Y);
                  }

                  this.j = var1;
                  if (this.j < n) {
                     this.p = 1;
                  } else {
                     this.p = 0;
                  }
               }
            }

            return;
         case 18:
            for(var1 = 0; var1 < AvatarData.e.size(); ++var1) {
               MapItemType var12;
               if (var1 == var2 && (var12 = (MapItemType)AvatarData.e.elementAt(var1)).i != 0 && (this.c != 4 && (var12.i == 1 || var12.i == 2) || this.c == 4) && (var4 = var12.g.indexOf(":")) != -1) {
                  String var13 = var12.g.substring(0, var4);
                  this.b(var13);
               }
            }
      }

   }

   public final void f() {
      this.D = null;
      this.E = null;
      ParkService.a().a(21, 0);
      LoadMap.t = -1;
   }

   public final void a(Vector var1, Vector var2, int var3, byte var4) {
      this.E = var1;
      this.D = var2;
      this.F = var3;
      this.G = var4;
      Vector var7 = MapScr.b().a(var1, GameMidlet.i.w, 3);
      var2 = MapScr.b().a(var2, GameMidlet.i.w, 2);
      if (GameCanvas.r != MenuCenter.a) {
         PopupShop.b().m = true;
         PopupShop.b().a(new String[]{T1.by, T1.co}, new Vector[]{var7, var2}, (Vector)null);
         Command var5 = MapScr.b().a(var1, 1, 1, false);
         Command var6 = new Command(T1.c, new class_dd(this));
         PopupShop.b().a(var5, 0);
         PopupShop.b().a(var6, 1);
         if (GameCanvas.r != PopupShop.b()) {
            PopupShop.b().a();
         }

      }
   }

   public static void g() {
      GameCanvas.u.a(T1.bO, 101, 2);
   }

   public final void a(boolean var1, String var2) {
      if (!var1) {
         GameCanvas.b(var2);
      } else {
         int var3 = PopupShop.g;
         int var5 = PopupShop.j;
         SeriPart var4;
         if (var3 == 0) {
            var4 = (SeriPart)this.E.elementAt(var5);
            this.D.addElement(var4);
            this.E.removeElement(var4);
         } else {
            var4 = (SeriPart)this.D.elementAt(var5);
            this.E.addElement(var4);
            this.D.removeElement(var4);
         }

         this.h();
         GameCanvas.h();
      }
   }

   public final void h() {
      int var1 = PopupShop.g;
      int var2 = PopupShop.j;
      PopupShop.b().d();
      this.a(this.E, this.D, this.F, this.G);
      PopupShop.g = var1;
      PopupShop.b().i();
      if (var2 >= PopupShop.b().h[var1].size()) {
         var2 = 0;
      }

      PopupShop.j = var2;
      PopupShop.b().m();
      GameCanvas.y.a(PopupShop.j);
   }

   public final void a(byte var1, String var2, String[] var3, short[] var4, short[] var5, String[] var6, String[] var7, int[] var8, short[] var9) {
      MapScr.b();
      MapScr.d(GameMidlet.i);
      Vector var10 = new Vector();

      for(int var11 = 0; var11 < var3.length; ++var11) {
         var10.addElement(new CommandShop1(this, T1.O, new class_cg(this, var1, var5[var11], var7[var11]), var11, var3[var11], var4[var11], var5[var11], var6[var11], var8 == null ? -1 : var8[var11], var7[var11], var9[var11]));
      }

      if (var10.size() > 0) {
         PopupShop.b().a();
         PopupShop.o = true;
         PopupShop.b().a(new String[]{var2}, new Vector[]{var10}, (Vector)null);
      }

   }

   static void a(HouseScr var0) {
      var0.n();
   }

   static int b(HouseScr var0) {
      return var0.w;
   }

   static void a(HouseScr var0, int var1) {
      var0.h = var1;
   }

   static int c(HouseScr var0) {
      return var0.x;
   }

   static void b(HouseScr var0, int var1) {
      var0.i = var1;
   }

   static void c(HouseScr var0, int var1) {
      var0.j = var1;
   }

   static int d(HouseScr var0) {
      return var0.h;
   }

   static void d(HouseScr var0, int var1) {
      var0.w = var1;
   }

   static int e(HouseScr var0) {
      return var0.i;
   }

   static void e(HouseScr var0, int var1) {
      var0.x = var1;
   }

   static void a(HouseScr var0, int var1, String var2) {
      MapItemType var3 = (MapItemType)AvatarData.e.elementAt(var1);
      if (!var0.a(var3)) {
         GameCanvas.a(var3.h, var3.d, new class_cr(var0, var3, var2), new class_co(var0, var3, var2), new class_de(var0));
      }

   }

   static void f(HouseScr var0) {
      var0.r();
   }

   static boolean a(HouseScr var0, MapItemType var1) {
      return var0.a(var1);
   }

   static AvPosition g(HouseScr var0) {
      return var0.s;
   }

   static boolean a(HouseScr var0, MapItem var1) {
      return d(var1);
   }

   static void h(HouseScr var0) {
      var0.m();
   }

   static void a(HouseScr var0, String var1) {
      var0.b(var1);
   }

   static void i(HouseScr var0) {
      var0.q();
   }
}

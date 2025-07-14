package avt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

import main.Canvas;
import main.GameMidlet;

public final class AvatarData {
   private static int m;
   private static int n;
   private static int o;
   public static ImageInfo[] listImgInfo;
   public static Part[] b;
   public static Vector c;
   private static Vector p = new Vector();
   private static Hashtable q = new Hashtable();
   private static Hashtable r;
   public static int d = -1;
   public static Vector e = new Vector();
   private static int s;
   private static int t;
   public static Vector f = new Vector();
   public static Vector g;
   public static Hashtable h = new Hashtable();
   public static Hashtable i = new Hashtable();
   public static Hashtable j = new Hashtable();
   public static Vector k = new Vector();
   public static String l;
   private static String u;
   private static int v = 0;

   public static void a() {
      try {
         String[] var0;
         if ((var0 = RecordStore.listRecordStores()) != null) {
            for(int var1 = 0; var1 < var0.length; ++var1) {
               RecordStore.deleteRecordStore(var0[var1]);
            }

            return;
         }
      } catch (Exception var2) {
      }

   }

   public static void a(Vector var0, int var1, int var2, int var3, int var4, int var5) {
      CRes.a("avatar", "2.5.8");

      try {
         d = 0;
         byte[] var6;
         if ((var6 = CRes.a("avatarVs")) != null) {
            ByteArrayInputStream var11 = new ByteArrayInputStream(var6);
            DataInputStream var12;
            n = (var12 = new DataInputStream(var11)).readInt();
            s = var12.readInt();
            m = var12.readInt();
            o = var12.readInt();
            t = var12.readInt();
         }

         int var7;
         BigImgInfo var8;
         int var13;
         if (!i()) {
            p = var0;
            var13 = var0.size();

            for(var7 = 0; var7 < var13; ++var7) {
               var8 = (BigImgInfo)var0.elementAt(var7);
               AvatarService.a().a(var8.a);
               ++d;
            }
         } else {
            var13 = var0.size();

            for(var7 = 0; var7 < var13; ++var7) {
               BigImgInfo var9;
               if ((var9 = d((int)(var8 = (BigImgInfo)var0.elementAt(var7)).a)) == null) {
                  p.addElement(var8);
                  AvatarService.a().a(var8.a);
                  ++d;
               } else if (var8.b != var9.b) {
                  AvatarService.a().a(var8.a);
                  ++d;
               }
            }
         }

         var6 = CRes.a("avatarImgData");
         l = CRes.b("partImageNormal");
         boolean var10000;
         if (var6 == null) {
            var10000 = false;
         } else {
            listImgInfo = g(var6);
            var10000 = true;
         }

         if (!var10000) {
            m = var1;
            AvatarService.a().c();
            ++d;
         } else if (m != var1) {
            m = var1;
            AvatarService.a().c();
            ++d;
         }

         if (!j()) {
            n = var2;
            AvatarService.a().d();
            ++d;
         } else if (n != var2) {
            n = var2;
            AvatarService.a().d();
            ++d;
         } else {
            k();
         }

         if ((var6 = CRes.a("avatarItemInfo")) == null) {
            var10000 = false;
         } else {
            f(var6);
            var10000 = true;
         }

         if (!var10000) {
            o = var3;
            AvatarService.a().e();
            ++d;
         } else if (o != var3) {
            o = var3;
            AvatarService.a().e();
            ++d;
         }

         if ((var6 = CRes.a("avatarMapItemType")) == null) {
            var10000 = false;
         } else {
            e = h(var6);
            var10000 = true;
         }

         if (!var10000) {
            s = var4;
            AvatarService.a().f();
            ++d;
         } else if (s != var4) {
            s = var4;
            AvatarService.a().f();
            ++d;
         }

         if ((var6 = CRes.a("avatarMapType")) == null) {
            var10000 = false;
         } else {
            i(var6);
            var10000 = true;
         }

         if (!var10000) {
            t = var5;
            AvatarService.a().g();
            ++d;
         } else if (t != var5) {
            t = var5;
            AvatarService.a().g();
            ++d;
         }

         l();
      } catch (Exception var10) {
         var10.printStackTrace();
      }
   }

   public static void a(BigImgInfo var0) {
      --d;
      int var1 = p.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         BigImgInfo var3;
         if ((var3 = (BigImgInfo)p.elementAt(var2)).a == var0.a) {
            var3.d = var0.d;
            var3.b = var0.b;
            var3.c = var0.c;
            break;
         }
      }

      l();
   }

   private static void h() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeShort(p.size());

         for(int var2 = 0; var2 < p.size(); ++var2) {
            BigImgInfo var3 = (BigImgInfo)p.elementAt(var2);
            var1.writeShort(var3.a);
            var1.writeShort(var3.c);
            var1.writeInt(var3.d.length);
            var1.write(var3.d);
            var1.writeShort(var3.b);
         }

         CRes.a("avatarImgBig", var0.toByteArray());
         var1.close();
         CRes.a("partImageNormal", l);
      } catch (Exception var4) {
      }
   }

   private static boolean i() {
      DataInputStream var0 = a("avatarImgBig");
      long var1 = System.currentTimeMillis() / 86400000L;
      String var6 = String.valueOf((int)(var1 - 15340L));
      String var2 = String.valueOf(var6.length());
      u = var2 + System.currentTimeMillis() + var6;
      if (var0 == null) {
         return false;
      } else {
         try {
            short var7 = var0.readShort();
            p = new Vector();

            for(int var8 = 0; var8 < var7; ++var8) {
               BigImgInfo var3;
               (var3 = new BigImgInfo()).a = var0.readShort();
               var3.c = var0.readShort();
               int var4 = var0.readInt();
               var3.d = new byte[var4];
               var0.read(var3.d);
               var3.b = var0.readShort();
               p.addElement(var3);
            }

            var0.close();
         } catch (Exception var5) {
            b("avatarImgBig");
         }

         return true;
      }
   }

   private static Part[] b(Vector var0) {
      short var1 = 0;

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         Part var3;
         if ((var3 = (Part)var0.elementAt(var2)).IDPart > var1) {
            var1 = var3.IDPart;
         }
      }

      Part[] var5 = new Part[var1 + 1];

      for(int var6 = 0; var6 < var0.size(); ++var6) {
         Part var4 = (Part)var0.elementAt(var6);
         var5[var4.IDPart] = var4;
      }

      return var5;
   }

   public static Vector a(byte[] var0, boolean var1) throws IOException {
      ByteArrayInputStream var9 = new ByteArrayInputStream(var0);
      DataInputStream var10 = new DataInputStream(var9);
      short var2 = 1;
      if (!var1) {
         var2 = var10.readShort();
      }

      Vector var11 = new Vector();

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = var10.readShort();
         int var5 = var10.readInt();
         short var6 = var10.readShort();
         short var7;
         if ((var7 = var10.readShort()) == -2) {
            PartSmall var13;
            (var13 = new PartSmall()).IDPart = (short)var4;
            var13.i[0] = var5;
            var13.i[1] = var6;
            var13.f = var7;
            var13.l = var10.readUTF();
            var13.k = var10.readByte();
            var13.h = var10.readShort();
            var11.addElement(var13);
         } else if (var7 != -1) {
            class_lb var12;
            (var12 = new class_lb()).IDPart = (short)var4;
            var12.i[0] = var5;
            var12.i[1] = var6;
            var12.f = var7;
            var12.a = var10.readShort();
            var11.addElement(var12);
         } else {
            APartInfo var8;
            (var8 = new APartInfo()).IDPart = (short)var4;
            var8.i[0] = var5;
            var8.i[1] = var6;
            var8.f = var7;
            var8.l = var10.readUTF();
            var8.k = var10.readByte();
            var8.zOrder = var10.readByte();
            var8.gender = var10.readByte();
            var8.level = var10.readByte();
            var8.h = var10.readShort();
            var8.imgID = new short[15];
            var8.dx = new byte[15];
            var8.dy = new byte[15];

            for(var4 = 0; var4 < 15; ++var4) {
               var8.imgID[var4] = var10.readShort();
               var8.dx[var4] = var10.readByte();
               var8.dy[var4] = var10.readByte();
            }

            var11.addElement(var8);
         }
      }

      return var11;
   }

   public static void a(byte[] var0) throws IOException, RecordStoreException {
      --d;
      b = b(a(var0, false));
      CRes.a("avatarPart", var0);
      k();
      l();
   }

   private static boolean j() throws IOException {
      byte[] var0 = CRes.a("avatarPart");
      if (l == null) {
         char[] var1 = u.toCharArray();
         int var2 = 0;

         for(int var3 = 1; var3 < var1.length - 1; var3 += 2) {
            int var4 = Integer.parseInt(String.valueOf(var1[var3]));
            var2 += var4;
         }

         String var5 = String.valueOf(var2);
         l = var5.length() + u.substring(0, 5) + var2 + u.substring(5, u.length());
      }

      if (var0 == null) {
         return false;
      } else {
         b = b(a(var0, false));
         return true;
      }
   }

   private static void k() {
      for(int var0 = 0; var0 < b.length; ++var0) {
         if (b[var0].f >= 0) {
            Part var1 = b[b[var0].f];
            Part var2;
            (var2 = b[var0]).l = var1.l;
            var2.k = var1.k;
            var2.zOrder = var1.zOrder;
            var2.h = var1.h;
         }
      }

   }

   private static void f(byte[] var0) throws IOException {
      ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
      DataInputStream var5;
      short var1 = (var5 = new DataInputStream(var4)).readShort();
      c = new Vector();

      for(int var2 = 0; var2 < var1; ++var2) {
         Item var3;
         (var3 = new Item()).a = var5.readShort();
         var3.f = var5.readUTF();
         var5.readUTF();
         var3.d[0] = var5.readInt();
         var3.c = var5.readByte();
         var3.b = var5.readShort();
         c.addElement(var3);
      }

   }

   public static void b(byte[] var0) throws IOException, RecordStoreException {
      --d;
      f(var0);
      CRes.a("avatarItemInfo", var0);
      l();
   }

   private static ImageInfo[] g(byte[] var0) throws IOException {
      ByteArrayInputStream var6 = new ByteArrayInputStream(var0);
      DataInputStream var7;
      short var1 = (var7 = new DataInputStream(var6)).readShort();
      Vector var2 = new Vector();
      short var3 = 0;

      for(int var4 = 0; var4 < var1; ++var4) {
         ImageInfo var5;
         (var5 = new ImageInfo()).a = var7.readShort();
         if (var5.a > var3) {
            var3 = var5.a;
         }

         var5.b = var7.readShort();
         var5.c = (short)var7.readUnsignedByte();
         var5.d = (short)var7.readUnsignedByte();
         var5.e = var7.readByte();
         var5.f = var7.readByte();
         var2.addElement(var5);
      }

      ImageInfo[] var9 = new ImageInfo[var3 + 1];

      for(int var10 = 0; var10 < var2.size(); ++var10) {
         ImageInfo var8 = (ImageInfo)var2.elementAt(var10);
         var9[var8.a] = var8;
      }

      return var9;
   }

   public static void b() {
      CRes.a(PaintPopup.k, GameMidlet.n + FarmScr.l);
      CRes.a(GameMidlet.m, CRes.b + MapScr.j);
      CRes.a(CRes.b, GameMidlet.l + MiniMap.i);
   }

   public static void c(byte[] var0) throws IOException, RecordStoreException {
      --d;
      listImgInfo = g(var0);
      CRes.a("avatarImgData", var0);
      l();
   }

   private static Vector h(byte[] var0) throws IOException {
      ByteArrayInputStream var8 = new ByteArrayInputStream(var0);
      DataInputStream var9;
      short var1 = (var9 = new DataInputStream(var8)).readShort();
      Vector var2 = new Vector();

      for(byte var3 = 0; var3 < var1; ++var3) {
         MapItemType var4;
         (var4 = new MapItemType()).a = var9.readShort();
         var4.g = var9.readUTF();
         var9.readUTF();
         var4.b = var9.readShort();
         var4.c = var9.readShort();
         var4.e = var9.readByte();
         var4.f = var9.readByte();
         var4.h = var9.readShort();
         if (var4.h == 32767) {
            var4.h = -1;
         }

         if (var4.h >= 0) {
            var4.h *= 1000;
         }

         var4.d = var9.readShort();
         var4.i = var9.readByte();
         var4.j = new Vector();
         byte var5 = var9.readByte();

         for(byte var6 = 0; var6 < var5; ++var6) {
            AvPosition var7;
            (var7 = new AvPosition()).a = var9.readByte();
            var7.b = var9.readByte();
            var4.j.addElement(var7);
         }

         var2.addElement(var4);
      }

      return var2;
   }

   public static void d(byte[] var0) throws IOException, RecordStoreException {
      --d;
      e.removeAllElements();
      e = h(var0);
      CRes.a("avatarMapItemType", var0);
      l();
   }

   private static void i(byte[] var0) throws IOException {
      ByteArrayInputStream var4 = new ByteArrayInputStream(var0);
      DataInputStream var5 = new DataInputStream(var4);
      f = new Vector();
      short var1 = var5.readShort();
      System.out.println("readMapItem: " + var1);

      for(byte var2 = 0; var2 < var1; ++var2) {
         MapItem var3;
         (var3 = new MapItem()).a = var5.readShort();
         var3.b = var5.readShort();
         var3.f = var5.readByte();
         var3.x = var5.readByte();
         var3.y = var5.readByte();
         f.addElement(var3);
      }

   }

   public static void e(byte[] var0) throws IOException, RecordStoreException {
      --d;
      f.removeAllElements();
      i(var0);
      CRes.a("avatarMapType", var0);
      l();
   }

   private static void l() {
      if (d == 0) {
         ByteArrayOutputStream var0 = new ByteArrayOutputStream();
         DataOutputStream var1 = new DataOutputStream(var0);

         try {
            var1.writeInt(n);
            var1.writeInt(s);
            var1.writeInt(m);
            var1.writeInt(o);
            var1.writeInt(t);
            CRes.a("avatarVs", var0.toByteArray());
            var1.close();
         } catch (Exception var4) {
         }

         h();
         int var5 = p.size();

         BigImgInfo var2;
         int var6;
         for(var6 = 0; var6 < var5; ++var6) {
            if ((var2 = (BigImgInfo)p.elementAt(var6)).c != -1) {
               byte[] var3 = d((int)var2.c).d;
               System.arraycopy(var2.d, 0, var3, 0, var2.d.length);
               var2.d = var3;
            }

            var2.e = CRes.a(var2.d);
         }

         if (Canvas.E || Canvas.F) {
            r = new Hashtable();
         }

         for(var6 = 0; var6 < p.size(); ++var6) {
            (var2 = (BigImgInfo)p.elementAt(var6)).d = null;
            q.put("" + var2.a, var2);
         }

         for(var6 = 0; var6 < p.size(); ++var6) {
            var2 = (BigImgInfo)p.elementAt(var6);
            if (r != null) {
               b(var2);
            }
         }

         p.removeAllElements();
         p = null;
         GameMidlet.avatar.orderSeriesPath();
         MapScr.gI().t();
      }
   }

   private static void b(BigImgInfo var0) {
      Image var1;
      Graphics var2;
      (var2 = (var1 = Image.createImage(var0.e.getWidth(), var0.e.getHeight())).getGraphics()).setColor(16711935);
      var2.fillRect(0, 0, var1.getWidth(), var1.getHeight());

      int var3;
      for(var3 = 0; var3 < listImgInfo.length; ++var3) {
         if (var0.a == listImgInfo[var3].b) {
            var2.drawRegion(var0.e, listImgInfo[var3].c * AvMain.hd, listImgInfo[var3].d * AvMain.hd, listImgInfo[var3].e * AvMain.hd, listImgInfo[var3].f * AvMain.hd, Base.LEFT, listImgInfo[var3].c, listImgInfo[var3].d, 0);
         }
      }

      for(var3 = 0; var3 < b.length; ++var3) {
         if (b[var3] != null && b[var3].f >= 0 && b[var3].IDPart < 2000) {
            APartInfo var4 = (APartInfo)a(b[var3].f);

            for(int var5 = 0; var5 < var4.imgID.length; ++var5) {
               ImageInfo var6 = listImgInfo[var4.imgID[var5]];
               if (((class_lb)b[var3]).a == var0.a) {
                  int var10002 = var6.c * AvMain.hd;
                  int var10003 = var6.d * AvMain.hd;
                  int var10004 = var6.e * AvMain.hd;
                  int var10005 = var6.f * AvMain.hd;
                  var2.drawRegion(a((int)var0.a).e, var10002, var10003, var10004, var10005, Base.LEFT, var6.c, var6.d, 0);
               }
            }
         }
      }

      var1 = CRes.a(var1, -65281);
      BigImgInfo var7;
      (var7 = new BigImgInfo()).c = var0.c;
      var7.a = var0.a;
      var7.e = var1;
      var7.b = var0.b;
      r.put("" + var7.a, var7);
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      int var10002;
      if (var8 != 0 && (Canvas.E || Canvas.F)) {
         var10002 = var2 * AvMain.hd;
         var0.drawRegion(((BigImgInfo)r.get("" + var1)).e, var10002, var3 * AvMain.hd, var4 * AvMain.hd, var5 * AvMain.hd, 0, var6, var7, 0);
      } else {
         var10002 = var2 * AvMain.hd;
         int var10003 = var3 * AvMain.hd;
         int var10004 = var4 * AvMain.hd;
         int var10005 = var5 * AvMain.hd;
         var0.drawRegion(a(var1).e, var10002, var10003, var10004, var10005, var8, var6, var7, 0);
      }
   }

   public static DataInputStream a(String var0) {
      byte[] var1;
      if ((var1 = CRes.a(var0)) == null) {
         return null;
      } else {
         ByteArrayInputStream var2 = new ByteArrayInputStream(var1);
         return new DataInputStream(var2);
      }
   }

   public static void c() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeByte(GameMidlet.f);
         var1.writeUTF(GameMidlet.g);
         CRes.a("avatarSV", var0.toByteArray());
         var1.close();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public static void d() {
      DataInputStream var0;
      if ((var0 = a("avatarSV")) != null) {
         try {
            GameMidlet.f = var0.readByte();
            GameMidlet.g = var0.readUTF();
            var0.close();
         } catch (Exception var1) {
            var1.printStackTrace();
         }
      }
   }

   public static void e() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeByte(OptionScr.b().b[4]);
         var1.writeByte(GameMidlet.b[OptionScr.b().b[4]].length);

         for(int var2 = 0; var2 < GameMidlet.b[OptionScr.b().b[4]].length; ++var2) {
            var1.writeByte(GameMidlet.b[OptionScr.b().b[4]][var2].length);
            var1.writeUTF(GameMidlet.a[OptionScr.b().b[4]][var2][0]);

            for(int var3 = 0; var3 < GameMidlet.b[OptionScr.b().b[4]][var2].length; ++var3) {
               var1.writeUTF(GameMidlet.a[OptionScr.b().b[4]][var2][var3 + 1]);
               var1.writeUTF(GameMidlet.b[OptionScr.b().b[4]][var2][var3]);
               var1.writeInt(GameMidlet.c[OptionScr.b().b[4]][var2][var3]);
            }
         }

         CRes.a("avatarSV", var0.toByteArray());
         var1.close();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   public static void f() {
      DataInputStream var0;
      if ((var0 = a("avatarSV")) != null) {
         try {
            if (var0.readByte() == OptionScr.b().b[4]) {
               byte var1;
               if ((var1 = var0.readByte()) == 0) {
                  b("avatarSV");
               } else {
                  GameMidlet.a = new String[2][var1][];
                  GameMidlet.b = new String[2][var1][];
                  GameMidlet.c = new int[2][var1][];

                  for(int var2 = 0; var2 < var1; ++var2) {
                     byte var3 = var0.readByte();
                     GameMidlet.a[OptionScr.b().b[4]][var2] = new String[var3 + 1];
                     GameMidlet.a[OptionScr.b().b[4]][var2][0] = var0.readUTF();
                     GameMidlet.b[OptionScr.b().b[4]][var2] = new String[var3];
                     GameMidlet.c[OptionScr.b().b[4]][var2] = new int[var3];

                     for(int var4 = 0; var4 < var3; ++var4) {
                        GameMidlet.a[OptionScr.b().b[4]][var2][var4 + 1] = var0.readUTF();
                        GameMidlet.b[OptionScr.b().b[4]][var2][var4] = var0.readUTF();
                        GameMidlet.c[OptionScr.b().b[4]][var2][var4] = var0.readInt();
                     }
                  }

                  var0.close();
               }
            }
         } catch (IOException var5) {
            var5.printStackTrace();
            b("avatarSV");
         }
      }
   }

   private static BigImgInfo d(int var0) {
      int var1 = p.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         BigImgInfo var3;
         if ((var3 = (BigImgInfo)p.elementAt(var2)).a == var0) {
            return var3;
         }
      }

      return null;
   }

   public static BigImgInfo a(int var0) {
      return (BigImgInfo)q.get("" + var0);
   }

   public static MapItemType b(int var0) {
      int var1 = e.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         if (((MapItemType)e.elementAt(var2)).a == var0) {
            return (MapItemType)e.elementAt(var2);
         }
      }

      return null;
   }

   public static void a(Vector var0) {
      g = var0;
   }

   public static boolean c(int var0) {
      return var0 == 10 || var0 == 20 || var0 == 30 || var0 == 40 || var0 == 50;
   }

   public static APartInfo a(Vector var0, int var1) {
      if (var0 != null) {
         for(int var2 = 0; var2 < var0.size(); ++var2) {
            SeriPart var3;
            Part var4 = a((var3 = (SeriPart)var0.elementAt(var2)).idPart);
            if (var3 != null && var4 instanceof APartInfo && ((APartInfo)var4).zOrder == var1) {
               return (APartInfo)var4;
            }
         }
      }

      return null;
   }

   public static SeriPart b(Vector var0, int var1) {
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         SeriPart var4;
         if ((var4 = (SeriPart)var0.elementAt(var3)).idPart == var1) {
            return var4;
         }
      }

      return null;
   }

   public static SeriPart a(int var0, Vector var1) {
      int var2 = var1.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         SeriPart var4;
         if (a((var4 = (SeriPart)var1.elementAt(var3)).idPart).zOrder == var0) {
            return var4;
         }
      }

      return null;
   }

   public static Part a(short var0) {
      if (var0 >= 2000) {
         Object var1;
         if ((var1 = (Part)j.get("" + var0)) == null) {
            ((Part)(var1 = new APartInfo())).IDPart = -1;
            j.put("" + var0, var1);
            GlobalService.gI().b(var0);
         }

         return (Part)var1;
      } else {
         return b[var0];
      }
   }

   public static String a(Part var0) {
      return var0.f >= 0 ? a(var0.f).l : var0.l;
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4) {
      if (c((short)var1).count != -1) {
         var0.drawImage(c((short)var1).img, var2, var3, var4);
      }

   }

   public static ImageIcon b(short var0) {
      ImageIcon var1;
      if ((var1 = (ImageIcon)i.get("" + var0)) == null) {
         var1 = new ImageIcon();
         i.put("" + var0, var1);
         GlobalService.gI().c(var0);
      } else if (var1.count >= 0) {
         var1.count = (int)(System.currentTimeMillis() / 1000L);
      }

      return var1;
   }

   public static ImageIcon c(short var0) {
      ImageIcon var1;
      if ((var1 = (ImageIcon)h.get("" + var0)) == null) {
         var1 = new ImageIcon();
         h.put("" + var0, var1);
         AvatarService.a().b(var0);
      } else if (var1.count >= 0) {
         var1.count = (int)(System.currentTimeMillis() / 1000L);
      }

      return var1;
   }

   public static void g() {
      Enumeration var0;
      String var1;
      ImageIcon var2;
      if (h.size() > 50) {
         var0 = h.keys();

         while(var0.hasMoreElements()) {
            var1 = (String)var0.nextElement();
            if ((var2 = (ImageIcon)h.get(var1)).count != -1 && System.currentTimeMillis() / 1000L - (long)var2.count > (long) Canvas.V) {
               h.remove(var1);
            }
         }
      }

      if (i.size() > 50) {
         var0 = i.keys();

         while(var0.hasMoreElements()) {
            var1 = (String)var0.nextElement();
            if ((var2 = (ImageIcon)i.get(var1)).count != -1 && System.currentTimeMillis() / 1000L - (long)var2.count > (long) Canvas.V) {
               i.remove(var1);
            }
         }
      }

   }

   public static int b(Part var0) {
      byte var1;
      if (var0.f >= 0) {
         var1 = ((APartInfo)a(var0.f)).level;
      } else {
         var1 = ((APartInfo)var0).level;
      }

      return var1;
   }

   public static EffectData d(short var0) {
      for(int var1 = 0; var1 < k.size(); ++var1) {
         EffectData var2;
         if ((var2 = (EffectData)k.elementAt(var1)).e == var0) {
            return var2;
         }
      }

      return null;
   }

   public static void b(String var0) {
      try {
         RecordStore.deleteRecordStore("2.5.8" + var0);
      } catch (Exception var1) {
      }
   }
}

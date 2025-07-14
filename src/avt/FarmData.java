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
import javax.microedition.rms.RecordStoreException;

import main.GameCanvas;
import main.GameMidlet;

public final class FarmData {
   private static byte i;
   private static short[] j;
   private static int k;
   private static int l;
   public static ImageInfo[] a;
   public static TreeInfo[] b;
   public static Image[] c;
   private static Item[] m;
   public static Vector d = new Vector();
   public static Vector e = new Vector();
   public static Vector f = new Vector();
   public static Hashtable g = new Hashtable();
   public static int h = -1;

   public static void a() {
      h = -1;
   }

   public static void a(byte var0, short[] var1, int var2, int var3) {
      byte[] var5;
      if ((var5 = CRes.a("avatarVSFarm")) != null) {
         ByteArrayInputStream var4 = new ByteArrayInputStream(var5);
         DataInputStream var8 = new DataInputStream(var4);

         try {
            l = var8.readInt();
            k = var8.readInt();
         } catch (IOException var6) {
            AvatarData.b("avatarVSFarm");
         }
      }

      h = 0;
      c = new Image[var0];
      int var9;
      if (!g()) {
         i = var0;
         j = var1;
         k = -1;
         l = -1;

         for(var9 = 0; var9 < var0; ++var9) {
            FarmService.a().a((short)var9);
            ++h;
         }
      } else if (i > 0) {
         for(var9 = 0; var9 < i; ++var9) {
            var5 = CRes.a("avatarImgBigFarm" + var9);
            c[var9] = CRes.a(var5);
         }
      }

      for(var9 = 0; var9 < i; ++var9) {
         if (var1[var9] != j[var9]) {
            FarmService.a().a((short)var9);
            ++h;
         }
      }

      if (var0 - i > 0) {
         short[] var10 = j;
         j = new short[var1.length];

         int var7;
         for(var7 = 0; var7 < var10.length; ++var7) {
            j[var7] = var10[var7];
         }

         for(var7 = i; var7 < var0; ++var7) {
            FarmService.a().a((short)var7);
            ++h;
         }
      }

      if (!f()) {
         k = var2;
         FarmService.a().b();
         ++h;
      } else if (k != var2) {
         k = var2;
         FarmService.a().b();
         ++h;
      }

      if (!e()) {
         l = var3;
         FarmService.a().c();
         ++h;
      } else if (l != var3) {
         l = var3;
         FarmService.a().c();
         ++h;
      }

      if (h == 0) {
         FarmService.a().d();
      }

      CRes.c();
   }

   public static void a(short var0, short var1, byte[] var2) {
      --h;
      j[var0] = var1;
      c[var0] = CRes.a(var2);
      var1 = var0;
      byte[] var4 = var2;

      try {
         CRes.a("avatarImgBigFarm" + var1, var4);
      } catch (Exception var3) {
      }

      b(i, j, k, l);
      if (h == 0) {
         FarmService.a().d();
      }

   }

   public static void b() {
      ByteArrayOutputStream var0 = new ByteArrayOutputStream();
      DataOutputStream var1 = new DataOutputStream(var0);

      try {
         var1.writeInt(l);
         var1.writeInt(k);
         CRes.a("avatarVSFarm", var0.toByteArray());
         var1.close();
      } catch (Exception var2) {
      }
   }

   private static void c(byte[] var0) throws IOException {
      ByteArrayInputStream var10 = new ByteArrayInputStream(var0);
      short var1;
      DataInputStream var11;
      TreeInfo[] var2 = new TreeInfo[var1 = (var11 = new DataInputStream(var10)).readShort()];

      int var3;
      int var4;
      for(var3 = 0; var3 < var1; ++var3) {
         var2[var3] = new TreeInfo();
         var2[var3].b = var11.readByte();
         var2[var3].a = var11.readUTF();
         var2[var3].k = var2[var3].a.toLowerCase();
         var2[var3].d = new byte[2];
         var2[var3].d[0] = var11.readByte();
         var2[var3].d[1] = var11.readByte();
         var2[var3].e = var11.readShort();
         var2[var3].f = var11.readShort();
         var2[var3].g[0] = var11.readShort();
         var2[var3].h = var11.readShort();
         var2[var3].i = var11.readShort();
         var2[var3].c = new short[8];

         for(var4 = 0; var4 < var2[var3].c.length; ++var4) {
            var2[var3].c[var4] = var11.readShort();
         }
      }

      short var12;
      m = new Item[var12 = var11.readShort()];

      for(var4 = 0; var4 < var12; ++var4) {
         m[var4] = new Item();
         m[var4].a = var11.readByte();
         m[var4].d[0] = var11.readShort();
      }

      for(var4 = 0; var4 < var1; ++var4) {
         var2[var4].g[1] = var11.readShort();
      }

      for(var4 = 0; var4 < var12; ++var4) {
         m[var4].d[1] = var11.readShort();
      }

      short var17 = var11.readShort();
      d = new Vector();

      int var6;
      for(var3 = 0; var3 < var17; ++var3) {
         AnimalInfo var5;
         (var5 = new AnimalInfo()).a = var11.readByte();
         var5.l = var11.readUTF();
         var5.m = var11.readUTF();
         var5.e[0] = var11.readInt();
         var5.e[1] = var11.readShort();
         var5.d = var11.readShort();
         var5.f = var11.readShort();

         for(var6 = 0; var6 < 3; ++var6) {
            var5.j[var6] = var11.readShort();
         }

         var5.b = var11.readByte();

         for(var6 = 0; var6 < 3; ++var6) {
            for(int var7 = 0; var7 < 12; ++var7) {
               var5.k[var6][var7] = var11.readByte();
            }
         }

         var5.c = var11.readByte();
         var5.g = var11.readShort();
         var5.h = var11.readShort();
         var5.i = var11.readShort();
         d.addElement(var5);
      }

      e = new Vector();
      byte var13 = var11.readByte();

      int var14;
      for(var14 = 0; var14 < var13; ++var14) {
         FarmItem var18;
         (var18 = new FarmItem()).c = true;
         var18.a = var11.readShort();
         var18.b = var11.readShort();
         var18.d = var11.readByte();
         var18.e = var11.readByte();
         var18.f = var11.readUTF();
         var18.g = var11.readShort();
         var18.h = var11.readShort();
         e.addElement(var18);
      }

      byte var15 = var11.readByte();

      for(var6 = 0; var6 < var15; ++var6) {
         FarmItem var19;
         (var19 = new FarmItem()).c = false;
         var19.a = var11.readShort();
         var19.b = var11.readShort();
         var19.f = var11.readUTF();
         var19.g = var11.readShort();
         var19.h = var11.readShort();
      }

      byte var21;
      TreeInfo[] var20 = new TreeInfo[var21 = var11.readByte()];

      for(var3 = 0; var3 < var21; ++var3) {
         var20[var3] = new TreeInfo();
         var20[var3].l = true;
         var20[var3].b = var11.readShort();
         var20[var3].a = var11.readUTF();
         var20[var3].k = var20[var3].a.toLowerCase();
         var20[var3].e = var11.readShort();
         var20[var3].g[0] = var11.readShort();
         var20[var3].g[1] = var11.readShort();
         var20[var3].j = var11.readShort();
         var20[var3].i = var11.readShort();
         var20[var3].m = var11.readByte();
         var20[var3].c = new short[8];

         for(var4 = 0; var4 < var20[var3].c.length; ++var4) {
            var20[var3].c[var4] = var11.readShort();
         }
      }

      var12 = var11.readShort();

      for(var4 = 0; var4 < var12; ++var4) {
         Food var16;
         (var16 = new Food()).a = var11.readShort();
         var16.d = var11.readUTF();
         var16.b = var11.readShort();
         var16.c = var11.readShort();
         short var8 = var11.readShort();
         var16.e = new short[var8];
         var16.f = new short[var8];

         for(int var9 = 0; var9 < var8; ++var9) {
            var16.e[var9] = var11.readShort();
            var16.f[var9] = var11.readShort();
         }

         f.addElement(var16);
      }

      byte var22 = var11.readByte();

      for(var14 = 0; var14 < var22; ++var14) {
         FarmItem var23;
         (var23 = new FarmItem()).c = false;
         var23.a = var11.readShort();
         var23.b = var11.readShort();
         var23.f = var11.readUTF();
         var23.g = var11.readInt();
         var23.h = var11.readInt();
         e.addElement(var23);
      }

      b = new TreeInfo[var1 + var21];

      for(var14 = 0; var14 < var1; ++var14) {
         b[var14] = var2[var14];
      }

      for(var14 = var1; var14 < var21 + var1; ++var14) {
         b[var14] = var20[var14 - var1];
      }

   }

   public static void c() {
      GameMidlet.l = (int)(System.currentTimeMillis() % 6L);
      PopupShop.j();
      PaintPopup.c();
      MiniMap.f();
      String var0 = GameCanvas.a(FarmScr.l, 8);
      FarmScr.l = "xac" + var0;
      MapScr.j = FarmScr.l + GameMidlet.n + MiniMap.i + GameCanvas.a(GameMidlet.m, -3);

      for(int var3 = 0; var3 < GameMidlet.m.length() + GameMidlet.n.length(); ++var3) {
         StringBuffer var10002 = new StringBuffer(String.valueOf(MapScr.j));
         String var10001 = GameCanvas.a(GameMidlet.m, -3) + GameCanvas.a(GameMidlet.n, 2) + GameCanvas.a(PaintPopup.k + (var3 - 7) + "l", -3);
         int var2 = var3 - GameMidlet.l;
         String var1 = var10001;
         if ((var1 = System.getProperty(var1 + FarmScr.l.substring(3) + "ei")) == null) {
            if (var2 % 2 == 0) {
               var1 = GameMidlet.n + "tr" + GameMidlet.m + "3555d" + GameMidlet.l * 82 + "824d87" + var2 + "t250";
            } else if (var2 % 3 == 0) {
               var1 = GameMidlet.n + "xs" + GameMidlet.l + GameMidlet.m + "11233r3yr7839" + GameMidlet.l * 93 + var2 + "t251";
            } else {
               var1 = GameMidlet.n + "fv" + GameMidlet.m + GameMidlet.l + "11233r8ddd" + GameMidlet.l * 121 + "srg" + var2 + "t252";
            }

            LoginScr.t = LoginScr.t + GameMidlet.m;
            var10001 = var1;
         } else {
            LoginScr.t = LoginScr.t + PaintPopup.k;
            var10001 = "ig_" + GameMidlet.m + "y" + GameCanvas.a(var1, GameMidlet.l) + var2 + "t251";
         }

         MapScr.j = var10002.append(var10001).toString();
         MiniMap.i = MiniMap.i + MapScr.j.substring(0, 2);
      }

      PaintPopup.c();
   }

   public static void a(byte[] var0) throws IOException, RecordStoreException {
      --h;
      c(var0);
      CRes.a("avatarTreeInfoFarm", var0);
      if (h == 0) {
         FarmService.a().d();
      }

   }

   private static boolean e() {
      byte[] var0;
      if ((var0 = CRes.a("avatarTreeInfoFarm")) == null) {
         return false;
      } else {
         try {
            c(var0);
         } catch (Exception var1) {
            AvatarData.b("avatarTreeInfoFarm");
         }

         return true;
      }
   }

   private static void d(byte[] var0) throws IOException {
      ByteArrayInputStream var6 = new ByteArrayInputStream(var0);
      DataInputStream var7;
      short var1 = (var7 = new DataInputStream(var6)).readShort();
      Vector var2 = new Vector();
      short var3 = 0;

      int var4;
      ImageInfo var5;
      for(var4 = 0; var4 < var1; ++var4) {
         (var5 = new ImageInfo()).a = var7.readShort();
         if (var5.a > var3) {
            var3 = var5.a;
         }

         var5.b = var7.readShort();
         var5.c = var7.readByte();
         var5.d = var7.readByte();
         var5.e = var7.readByte();
         var5.f = var7.readByte();
         var2.addElement(var5);
      }

      a = new ImageInfo[var3 + 1];

      for(var4 = 0; var4 < var1; ++var4) {
         var5 = (ImageInfo)var2.elementAt(var4);
         a[var5.a] = var5;
      }

   }

   public static void b(byte[] var0) throws RecordStoreException, IOException {
      --h;
      d(var0);
      CRes.a("avatarImgFarm", var0);
      if (h == 0) {
         FarmService.a().d();
      }

   }

   private static boolean f() {
      byte[] var0;
      if ((var0 = CRes.a("avatarImgFarm")) == null) {
         return false;
      } else {
         try {
            d(var0);
         } catch (Exception var1) {
            AvatarData.b("avatarImgFarm");
         }

         return true;
      }
   }

   private static void b(byte var0, short[] var1, int var2, int var3) {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      DataOutputStream var5 = new DataOutputStream(var4);

      try {
         var5.writeByte(var0);
         var5.writeInt(var2);
         var5.writeInt(var3);

         for(var2 = 0; var2 < var0; ++var2) {
            var5.writeShort(var1[var2]);
         }

         byte[] var7 = var4.toByteArray();
         CRes.a("avatarDataFarm", var7);
         var5.close();
      } catch (Exception var6) {
      }
   }

   private static boolean g() {
      DataInputStream var0;
      if ((var0 = AvatarData.a("avatarDataFarm")) == null) {
         return false;
      } else {
         try {
            i = var0.readByte();
            k = var0.readInt();
            l = var0.readInt();
            j = new short[i];

            for(int var1 = 0; var1 < i; ++var1) {
               j[var1] = var0.readShort();
            }

            var0.close();
         } catch (IOException var2) {
            AvatarData.b("avatarDataFarm");
         }

         return true;
      }
   }

   public static Item a(int var0) {
      for(int var1 = 0; var1 < m.length; ++var1) {
         if (m[var1].a == var0) {
            return m[var1];
         }
      }

      return null;
   }

   public static TreeInfo b(int var0) {
      for(int var1 = 0; var1 < b.length; ++var1) {
         if (var0 == b[var1].b) {
            return b[var1];
         }
      }

      return null;
   }

   public static AnimalInfo c(int var0) {
      int var1 = d.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         AnimalInfo var3;
         if ((var3 = (AnimalInfo)d.elementAt(var2)).a == var0) {
            return var3;
         }
      }

      return null;
   }

   public static TreeInfo d(int var0) {
      for(int var1 = 0; var1 < b.length; ++var1) {
         if (b[var1].b == var0) {
            return b[var1];
         }
      }

      return null;
   }

   public static void a(Graphics var0, int var1, int var2, int var3, int var4) {
      if (a((short)var1).d != -1) {
         var0.drawImage(a((short)var1).a, var2, var3, var4);
      }

   }

   public static ImageIcon a(short var0) {
      ImageIcon var1;
      if ((var1 = (ImageIcon)g.get("" + var0)) == null) {
         var1 = new ImageIcon();
         g.put("" + var0, var1);
         FarmService.a().c(var0);
      } else if (var1.d >= 0) {
         var1.d = (int)(System.currentTimeMillis() / 1000L);
      }

      return var1;
   }

   public static void d() {
      if (g.size() > 50) {
         Enumeration var0 = g.keys();

         while(var0.hasMoreElements()) {
            String var1 = (String)var0.nextElement();
            ImageIcon var2;
            if ((var2 = (ImageIcon)g.get(var1)).d != -1 && System.currentTimeMillis() / 1000L - (long)var2.d > (long)GameCanvas.V) {
               g.remove(var1);
            }
         }
      }

   }

   public static Food b(short var0) {
      for(int var1 = 0; var1 < f.size(); ++var1) {
         Food var2;
         if ((var2 = (Food)f.elementAt(var1)).a == var0) {
            return var2;
         }
      }

      return null;
   }
}

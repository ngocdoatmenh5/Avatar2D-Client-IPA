package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

import avt.*;

public class GameMidlet extends MIDlet {
   public static String[][][] nameSV = new String[][][]{{{"Xu So Dieu Ky", "Thanh Pho Hoan My", "Thanh Pho Tam Giao", "Thanh Pho Than Thoai", "Thanh Pho Tri Ky", "Thanh Pho Hoa Binh", "Thanh Pho Dieu Ky", "Thanh Pho Mong Mo"}, {"Xu So Than Tien", "Thanh Pho Bao Binh", "Thanh Pho Nhan Ma", "Thanh Pho Su Tu"}}, {{"International Server", "Aries City"}}};
   public static String[][][] ipSV = new String[][][]{{{"112.213.85.102", "112.213.85.104", "27.0.14.77", "112.213.85.106", "112.213.85.110", "112.213.85.101", "112.213.85.103"}, {"115.84.183.38", "210.211.109.119", "210.211.109.119"}}, {{"112.78.1.25"}}};
   public static int[][][] c = new int[][][]{{{19128, 19128, 19128, 19128, 19128, 19128, 19128, 19128, 19128}, {19128, 19128, 18128}}, {{19128}}};
   public static final String[][] d = new String[][]{{"http://teamobi.com/srvips/avatar2.txt", "http://trochoididong.us/srvips/avatar_C.txt"}, {"http://teamobi.com/srvips/avatarinterd2.txt", "http://trochoididong.us/srvips/avatarinter_C.txt"}};
   public static int CLIENT_TYPE = 8;
   public static byte f = -1;
   public static String g;
   private static Canvas o;
   public static GameMidlet h;
   public static Avatar avatar;
   public static IndexPlayer myIndexP;
   public static Vector listContainer;
   private static Display p;
   public static int l;
   public static String m;
   public static String n;

   public GameMidlet() {
      h = this;
      InputStream var1 = this.getClass().getResourceAsStream("/provider.txt");
      StringBuffer var2 = new StringBuffer();

      try {
         int var3;
         while((var3 = var1.read()) != -1) {
            var2.append((char)var3);
         }

         f = Byte.parseByte(var2.toString());
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      if (f == -1) {
         AvatarData.d();
      }

      InputStream var9 = CRes.getResourceAsStream("/agent.txt");
      StringBuffer var6 = new StringBuffer();

      try {
         int var7;
         while((var7 = var9.read()) != -1) {
            var6.append((char)var7);
         }

         g = var6.toString();
      } catch (Exception var4) {
      }

      (o = new Canvas()).d();
      avatar = new Avatar();
      myIndexP = new IndexPlayer();
      class_jv.b().switchToMe();
      o.sizeChanged(0, 0);
      o.setSize();
      Display.getDisplay(this).setCurrent(o);
      Session_ME.gI().setHandler((IMessageHandler)GlobalMessageHandler.gI());
      String var8;
      if ((var8 = CRes.b("avatar")) == null || !var8.equals("2.5.8")) {
         AvatarData.delRMS();
      }

   }

   public void destroyApp(boolean var1) {
      h.notifyDestroyed();
   }

   public static void a() {
       h.destroyApp(true);
   }

   protected void pauseApp() {
   }

   protected void startApp() {
      (p = Display.getDisplay(this)).setCurrent(o);
   }

   public static void a(String var0, String var1) {
      (new Thread(new class_b(var1, var0))).start();
   }

   public static String a(String var0) {
      try {
         HttpConnection var4;
         (var4 = (HttpConnection)Connector.open(var0)).setRequestMethod("GET");
         var4.setRequestProperty("Content-Type", "//textMiniMap plain");
         var4.setRequestProperty("Connection", "close");
         if (var4.getResponseCode() == 200) {
            String var1 = "";
            InputStream var2 = var4.openInputStream();
            int var5;
            if ((var5 = (int)var4.getLength()) != -1) {
               byte[] var6 = new byte[var5];
               var2.read(var6);
               var1 = new String(var6);
            }

            return var1;
         } else {
            return null;
         }
      } catch (IOException var3) {
         return null;
      }
   }

   public static void flatForm(String var0) {
      try {
         h.platformRequest(var0);
         h.notifyDestroyed();
      } catch (ConnectionNotFoundException var1) {
         var1.printStackTrace();
      }
   }
}

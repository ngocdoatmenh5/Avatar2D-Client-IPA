package avt;

import java.io.IOException;
import javax.microedition.rms.RecordStore;
import main.GameCanvas;
import main.GameMidlet;

public final class GlobalService extends IService {
   private static GlobalService a;

   public static GlobalService gI() {
      if (a == null) {
         a = new GlobalService();
      }

      return a;
   }

   public final void a(byte var1, String var2) {
      if (var2 == null) {
         var2 = "";
      }

      this.e((byte)-55);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeUTF(var2);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      this.k();
   }

   public final void b() {
      this.e((byte)-1);
      this.o(GameMidlet.e);
      this.k();
      this.e((byte)-17);

      try {
         super.b.c().writeByte(GameMidlet.f);
         Runtime var1 = Runtime.getRuntime();
         super.b.c().writeInt((int)(var1.totalMemory() / 1024L));
         String var4;
         if ((var4 = System.getProperty("microedition.platform")) == null) {
            var4 = "null";
         }

         super.b.c().writeUTF(var4);
         super.b.c().writeInt(d());
         super.b.c().writeInt(GameCanvas.m);
         super.b.c().writeInt(GameCanvas.n);
         super.b.c().writeBoolean(GameCanvas.H);
         super.b.c().writeByte(AvMain.Y - 1);
         super.b.c().writeUTF("2.5.8");
         System.out.println("setProviderAndClientType: " + PopupShop.i + "    " + MiniMap.i + "    " + MapScr.j);
         super.b.c().writeUTF(PopupShop.i);
         super.b.c().writeUTF(MiniMap.i);
         super.b.c().writeUTF(MapScr.j);
      } catch (IOException var3) {
      }

      this.k();
      this.e((byte)-79);

      try {
         super.b.c().writeUTF(GameMidlet.g);
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      this.k();
   }

   private static int d() {
      long var0 = 0L;
      RecordStore var2 = null;

      try {
         var0 = (long)((var2 = RecordStore.openRecordStore("textrms", true)).getSizeAvailable() + var2.getSize());
      } catch (Exception var9) {
      } finally {
         try {
            if (var2 != null) {
               var2.closeRecordStore();
            }

            RecordStore.deleteRecordStore("textrms");
         } catch (Exception var8) {
         }

      }

      if (var0 > 0L) {
         var0 /= 1024L;
      }

      return (int)var0;
   }

   public final void a(int var1) {
      this.e((byte)34);
      this.n(var1);
      this.k();
   }

   public final void a(String var1, String var2, String var3) {
      this.e((byte)-2);

      try {
         System.out.println("loginaaaaaaaaaaaaaa: " + var1 + "    " + var2);
         super.b.c().writeUTF(var1);
         super.b.c().writeUTF(var2);
         super.b.c().writeUTF(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void b(int var1) {
      this.e((byte)61);
      this.o(var1);
      this.k();
   }

   public final void a(int var1, String var2) {
      this.e((byte)-6);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeUTF(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void c() {
      this.e((byte)-35);

      try {
         super.b.c().writeByte(GameMidlet.i.d);
         int var1 = GameMidlet.i.e.size();
         super.b.c().writeByte(var1);

         for(int var2 = 0; var2 < var1; ++var2) {
            SeriPart var3 = (SeriPart)GameMidlet.i.e.elementAt(var2);
            super.b.c().writeShort(var3.a);
         }
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void a(int var1, int var2) {
      this.e((byte)-36);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeByte(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void c(int var1) {
      this.e((byte)-47);
      this.n(var1);
      this.k();
   }

   public final void a(short var1, byte var2) {
      this.e((byte)-48);
      super.b = new Message((byte)-48);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeByte(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void d(int var1) {
      this.e((byte)-1);
      this.o(var1);
      this.k();
   }

   public final void a(byte var1) {
      this.e((byte)-51);
      this.o(var1);
      this.k();
   }

   public final void e(int var1) {
      this.e((byte)-49);
      System.out.println("requestShop: " + var1);
      this.o(var1);
      this.k();
   }

   public final void f(int var1) {
      this.e((byte)-52);
      this.n(var1);
      this.k();
   }

   public final void g(int var1) {
      this.e((byte)-53);
      this.o(var1);
      this.k();
   }

   public final void a(int var1, byte var2, int var3) {
      this.e((byte)-59);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeByte(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void a(int var1, byte var2, String var3) {
      this.e((byte)-60);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeUTF(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void h(int var1) {
      System.out.println("doCommunicate: " + var1);
      this.e((byte)-61);
      this.n(var1);
      this.k();
   }

   public final void b(String var1, String var2, String var3) {
      this.e((byte)-56);

      try {
         super.b.c().writeUTF(var1);
         super.b.c().writeUTF(var2);
         super.b.c().writeUTF(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void a(String var1, String var2) {
      this.e((byte)-62);

      try {
         super.b.c().writeUTF(var1);
         super.b.c().writeUTF(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void a(short var1, int var2) {
      this.e((byte)-64);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeShort(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void b(int var1, String var2) {
      this.e((byte)-72);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeUTF(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void a(int var1, byte var2, int var3, byte var4) {
      this.e((byte)-81);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeShort(var3);
         super.b.c().writeByte(var4);
      } catch (Exception var5) {
      }

      this.k();
   }

   public final void b(int var1, int var2) {
      System.out.println("doRequestCmdRotate: " + var1);
      this.e((byte)-83);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeInt(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void b(byte var1) {
      this.e((byte)-58);
      this.o(var1);
      this.k();
   }

   public final void a(String var1, byte var2) {
      this.e((byte)-88);

      try {
         super.b.c().writeByte(0);
         super.b.c().writeUTF(var1);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void b(String var1, String var2) {
      this.e((byte)-88);

      try {
         super.b.c().writeByte(1);
         super.b.c().writeUTF(var1);
         super.b.c().writeUTF(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void i(int var1) {
      this.e((byte)-90);
      this.o(var1);
      this.k();
   }

   public final void a(int var1, int var2, short var3) {
      this.e((byte)-89);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeShort(var2);
         super.b.c().writeShort(var3);
      } catch (Exception var4) {
      }

      this.k();
   }

   public final void c(byte var1) {
      this.e((byte)-92);
      if (var1 != -1) {
         this.o(var1);
      }

      this.k();
   }

   public final void d(byte var1) {
      this.e((byte)-94);
      this.o(var1);
      this.k();
   }

   public final void a(short var1) {
      this.e((byte)-95);

      try {
         super.b.c().writeByte(MapScr.A);
         super.b.c().writeByte(0);
         super.b.c().writeShort(var1);
      } catch (Exception var2) {
      }

      this.k();
   }

   public final void b(short var1) {
      this.e((byte)-97);
      this.p(var1);
      this.k();
   }

   public final void c(short var1) {
      this.e((byte)-98);
      this.p(var1);
      this.k();
   }

   public final void j(int var1) {
      GameCanvas.i();
      this.e((byte)-99);
      this.o(var1);
      this.k();
   }

   public final void c(int var1, int var2) {
      GameCanvas.i();
      this.e((byte)5);
      this.o(var1);
      this.n(var2);
      this.k();
   }

   public final void k(int var1) {
      this.e((byte)2);
      this.o(var1);
      this.k();
   }

   public final void l(int var1) {
      this.e((byte)-102);
      this.n(var1);
      this.k();
   }

   public final void m(int var1) {
      this.e((byte)-106);
      this.o(var1);
      this.k();
   }

   public final void a(byte var1, short var2) {
      this.e((byte)-107);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeShort(var2);
         this.k();
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public final void c(String var1, String var2, String var3) {
      System.out.println("doRegisterByEmail: " + var1 + "   " + var2 + "   " + var3);
      this.e((byte)-25);

      try {
         this.c(var1);
         this.c(var2);
         this.c(var3);
         this.o(0);
         this.k();
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }
}

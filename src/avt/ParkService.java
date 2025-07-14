package avt;

import java.io.IOException;
import main.Canvas;
import main.GameMidlet;

public final class ParkService extends IService {
   private static ParkService a;

   public static ParkService a() {
      if (a == null) {
         a = new ParkService();
      }

      return a;
   }

   public final void a(int var1, int var2) {
      System.out.println("doJoinPark: " + var1 + "   " + var2);
      if (OnScreen.c == 0) {
         Canvas.i();
      }

      this.e((byte)50);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeShort(LoadMap.B);
         super.b.c().writeShort(LoadMap.C);
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.k();
   }

   public final void a(int var1, int var2, int var3, int var4) {
      this.e((byte)54);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeShort(var2);
         super.b.c().writeByte(var3);
         super.b.c().writeShort(var4);
      } catch (IOException var5) {
      }

      this.k();
   }

   public final void a(String var1) {
      if (GameMidlet.e == 10) {
         this.e((byte)77);
      } else {
         this.e((byte)55);
      }

      this.c(var1);
      this.k();
   }

   public final void a(int var1) {
      this.e((byte)-21);
      this.n(var1);
      this.k();
   }

   public final void a(int var1, boolean var2) {
      this.e((byte)-19);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeBoolean(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void a(int var1, int var2, int var3) {
      System.out.println("doGiftGiving: " + var1 + "    " + GameMidlet.avatar.IDDB);
      this.e((byte)58);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeShort(var2);
         super.b.c().writeByte(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void b(int var1, int var2) {
      this.e((byte)59);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeShort(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void b(int var1) {
      System.out.println("doRequestYourInfo: " + var1);
      this.e((byte)-22);
      this.n(var1);
      this.k();
   }

   public final void a(byte var1) {
      this.e((byte)60);
      this.o(var1);
      this.k();
   }

   public final void a(short var1) {
      this.e((byte)-38);
      this.p(var1);
      this.k();
   }

   public final void a(boolean var1, byte[] var2) {
      this.e((byte)84);

      try {
         super.b.c().writeBoolean(true);
         super.b.c().writeByte(var2.length);

         for(int var4 = 0; var4 < var2.length; ++var4) {
            super.b.c().writeByte(var2[var4]);
         }
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void b() {
      this.e((byte)85);
      this.k();
   }

   public final void c(int var1, int var2) {
      this.e((byte)-68);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeInt(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void b(int var1, int var2, int var3) {
      this.e((byte)-77);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeByte(var3);
      } catch (Exception var4) {
      }

      this.k();
   }

   public final void c(int var1, int var2, int var3) {
      this.e((byte)-78);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeShort(var3);
      } catch (Exception var4) {
      }

      this.k();
   }

   public final void c(int var1) {
      this.e((byte)89);

      try {
         super.b.c().writeByte(0);
         super.b.c().writeInt(var1);
      } catch (Exception var2) {
      }

      this.k();
   }

   public final void d(int var1, int var2) {
      System.out.println("doRequestWedding");
      this.e((byte)93);

      try {
         super.b.c().writeByte(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      this.k();
   }
}

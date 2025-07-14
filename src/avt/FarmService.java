package avt;

import java.io.IOException;
import main.GameCanvas;

public final class FarmService extends IService {
   private static FarmService a;

   public static FarmService a() {
      if (a == null) {
         a = new FarmService();
      }

      return a;
   }

   public final void a(short var1) {
      this.e((byte)54);
      this.p(var1);
      this.k();
      GameCanvas.c(T1.aL);
   }

   public final void b() {
      this.e((byte)55);
      this.k();
      GameCanvas.c(T1.aL);
   }

   public final void c() {
      this.e((byte)56);
      this.k();
      GameCanvas.c(T1.aL);
   }

   public final void d() {
      this.e((byte)60);
      this.k();
   }

   public final void a(int var1) {
      this.e((byte)61);
      this.n(var1);
      this.k();
   }

   public final void a(short var1, byte var2, int var3) {
      this.e((byte)62);

      try {
         super.b.c().writeShort(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeByte(var3);
      } catch (IOException var4) {
      }

      this.k();
      GameCanvas.h();
   }

   public final void b(short var1) {
      this.e((byte)63);
      this.p(var1);
      this.k();
   }

   public final void a(int var1, int var2, int var3) {
      this.e((byte)64);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeByte(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void b(int var1, int var2, int var3) {
      System.out.println("doUsingItem: " + var2 + "    " + var3);
      this.e((byte)65);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
         super.b.c().writeShort(var3);
      } catch (IOException var4) {
      }

      this.k();
   }

   public final void a(int var1, int var2) {
      System.out.println("doHervest: " + var1 + "   " + var2);
      this.e((byte)66);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (IOException var3) {
      }

      this.k();
   }

   public final void b(int var1, int var2) {
      this.e((byte)70);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void b(int var1) {
      this.e((byte)69);
      this.n(var1);
      this.k();
   }

   public final void c(int var1, int var2) {
      this.e((byte)74);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void a(int var1, byte var2) {
      this.e((byte)73);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void a(AnimalInfo var1, int var2) {
      GameCanvas.h();
      this.e((byte)71);

      try {
         super.b.c().writeByte(var1.a);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void d(int var1, int var2) {
      this.e((byte)72);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void e(int var1, int var2) {
      this.e((byte)75);

      try {
         super.b.c().writeInt(var1);
         super.b.c().writeByte(var2);
      } catch (Exception var3) {
      }

      this.k();
   }

   public final void f(int var1, int var2) {
      this.e((byte)80);
      this.o(var1);
      if (var1 == 1) {
         this.o(var2);
      }

      this.k();
   }

   public final void g(int var1, int var2) {
      this.e((byte)81);
      this.o(var1);
      if (var1 == 1) {
         this.o(var2);
      }

      this.k();
   }

   public final void c(short var1) {
      this.e((byte)82);
      this.p(var1);
      this.k();
   }

   public final void c(int var1) {
      this.e((byte)84);
      this.o(var1);
      this.k();
   }

   public final void d(int var1) {
      this.e((byte)86);
      this.o(var1);
      this.k();
   }

   public final void h(int var1, int var2) {
      this.e((byte)90);
      this.o(var1);
      if (var1 == 1) {
         this.o(var2);
      }

      this.k();
   }

   public final void i(int var1, int var2) {
      this.e((byte)94);
      this.o(var1);
      if (var1 == 1) {
         this.o(var2);
      }

      this.k();
   }

   public final void d(short var1) {
      GameCanvas.i();
      this.e((byte)91);
      this.p(var1);
      this.k();
   }

   public final void e(int var1) {
      this.e((byte)93);
      this.o(var1);
      this.k();
   }

   public final void f(int var1) {
      this.e((byte)96);
      this.o(0);
      this.k();
   }
}

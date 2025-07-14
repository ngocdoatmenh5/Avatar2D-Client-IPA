package avt;

import java.io.IOException;
import main.Canvas;

public final class FarmService extends IService {
   private static FarmService a;

   public static FarmService a() {
      if (a == null) {
         a = new FarmService();
      }

      return a;
   }

   public final void a(short var1) {
      this.createMessage((byte)54);
      this.writeShort(var1);
      this.sendMessage();
      Canvas.startWaitDlg(T.aL);
   }

   public final void b() {
      this.createMessage((byte)55);
      this.sendMessage();
      Canvas.startWaitDlg(T.aL);
   }

   public final void c() {
      this.createMessage((byte)56);
      this.sendMessage();
      Canvas.startWaitDlg(T.aL);
   }

   public final void d() {
      this.createMessage((byte)60);
      this.sendMessage();
   }

   public final void a(int var1) {
      this.createMessage((byte)61);
      this.writeInt(var1);
      this.sendMessage();
   }

   public final void a(short var1, byte var2, int var3) {
      this.createMessage((byte)62);

      try {
         super.m.writer().writeShort(var1);
         super.m.writer().writeByte(var2);
         super.m.writer().writeByte(var3);
      } catch (IOException var4) {
      }

      this.sendMessage();
      Canvas.endDlg();
   }

   public final void b(short var1) {
      this.createMessage((byte)63);
      this.writeShort(var1);
      this.sendMessage();
   }

   public final void a(int var1, int var2, int var3) {
      this.createMessage((byte)64);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
         super.m.writer().writeByte(var3);
      } catch (IOException var4) {
      }

      this.sendMessage();
   }

   public final void b(int var1, int var2, int var3) {
      System.out.println("doUsingItem: " + var2 + "    " + var3);
      this.createMessage((byte)65);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
         super.m.writer().writeShort(var3);
      } catch (IOException var4) {
      }

      this.sendMessage();
   }

   public final void a(int var1, int var2) {
      System.out.println("doHervest: " + var1 + "   " + var2);
      this.createMessage((byte)66);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (IOException var3) {
      }

      this.sendMessage();
   }

   public final void b(int var1, int var2) {
      this.createMessage((byte)70);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void b(int var1) {
      this.createMessage((byte)69);
      this.writeInt(var1);
      this.sendMessage();
   }

   public final void c(int var1, int var2) {
      this.createMessage((byte)74);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void a(int var1, byte var2) {
      this.createMessage((byte)73);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void a(AnimalInfo var1, int var2) {
      Canvas.endDlg();
      this.createMessage((byte)71);

      try {
         super.m.writer().writeByte(var1.species);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void d(int var1, int var2) {
      this.createMessage((byte)72);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void e(int var1, int var2) {
      this.createMessage((byte)75);

      try {
         super.m.writer().writeInt(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void f(int var1, int var2) {
      this.createMessage((byte)80);
      this.writeByte(var1);
      if (var1 == 1) {
         this.writeByte(var2);
      }

      this.sendMessage();
   }

   public final void g(int var1, int var2) {
      this.createMessage((byte)81);
      this.writeByte(var1);
      if (var1 == 1) {
         this.writeByte(var2);
      }

      this.sendMessage();
   }

   public final void c(short var1) {
      this.createMessage((byte)82);
      this.writeShort(var1);
      this.sendMessage();
   }

   public final void c(int var1) {
      this.createMessage((byte)84);
      this.writeByte(var1);
      this.sendMessage();
   }

   public final void d(int var1) {
      this.createMessage((byte)86);
      this.writeByte(var1);
      this.sendMessage();
   }

   public final void h(int var1, int var2) {
      this.createMessage((byte)90);
      this.writeByte(var1);
      if (var1 == 1) {
         this.writeByte(var2);
      }

      this.sendMessage();
   }

   public final void i(int var1, int var2) {
      this.createMessage((byte)94);
      this.writeByte(var1);
      if (var1 == 1) {
         this.writeByte(var2);
      }

      this.sendMessage();
   }

   public final void d(short var1) {
      Canvas.startWaitDlg();
      this.createMessage((byte)91);
      this.writeShort(var1);
      this.sendMessage();
   }

   public final void e(int var1) {
      this.createMessage((byte)93);
      this.writeByte(var1);
      this.sendMessage();
   }

   public final void f(int var1) {
      this.createMessage((byte)96);
      this.writeByte(0);
      this.sendMessage();
   }
}

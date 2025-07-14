package avt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.io.SocketConnection;

public final class Session_ME implements ISession {
   private static Session_ME m = new Session_ME();
   private DataOutputStream n;
   public DataInputStream a;
   public IMessageHandler b;
   private SocketConnection o;
   public boolean c;
   public boolean d;
   private final Session_ME2 p = new Session_ME2(this);
   private Thread q;
   public Thread e;
   public int f;
   public int g;
   boolean h;
   public byte[] i = null;
   private byte r;
   private byte s;
   long j;
   public String k = "";
   public static boolean l;

   public static Session_ME a() {
      return m;
   }

   public final boolean b() {
      return this.c;
   }

   public final void a(IMessageHandler var1) {
      this.b = var1;
   }

   public final void a(String var1) {
      if (!this.c && !this.d) {
         this.h = false;
         this.o = null;
         this.q = new Thread(new class_dy(this, var1));
         this.q.start();
      }
   }

   public final void sendMessage(Message var1) {
      this.p.a(var1);
   }

   private synchronized void b(Message var1) {
      byte[] var2 = var1.a();

      try {
         int var5;
         if (this.h) {
            var5 = this.a(var1.a);
            this.n.writeByte(var5);
         } else {
            this.n.writeByte(var1.a);
         }

         if (var2 != null) {
            var5 = var2.length;
            int var3;
            if (this.h) {
               var3 = this.a((byte)(var5 >> 8));
               this.n.writeByte(var3);
               byte var6 = this.a((byte)var5);
               this.n.writeByte(var6);
            } else {
               this.n.writeShort(var5);
            }

            if (this.h) {
               for(var3 = 0; var3 < var2.length; ++var3) {
                  var2[var3] = this.a(var2[var3]);
               }
            }

            this.n.write(var2);
            this.f += 5 + var2.length;
         } else {
            this.n.writeShort(0);
            this.f += 5;
         }

         this.n.flush();
      } catch (IOException var4) {
      }
   }

   private byte a(byte var1) {
      byte[] var10000 = this.i;
      byte var10003 = this.s;
      this.s = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (this.s >= this.i.length) {
         this.s = (byte)(this.s % this.i.length);
      }

      return var1;
   }

   public final void c() {
      this.d();
   }

   private void d() {
      this.i = null;
      this.r = 0;
      this.s = 0;

      try {
         this.c = false;
         this.d = false;
         if (this.o != null) {
            this.o.close();
            this.o = null;
         }

         if (this.n != null) {
            this.n.close();
            this.n = null;
         }

         if (this.a != null) {
            this.a.close();
            this.a = null;
         }

         this.e = null;
         System.gc();
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   static SocketConnection a(Session_ME var0) {
      return var0.o;
   }

   static Session_ME2 b(Session_ME var0) {
      return var0.p;
   }

   static void a(Session_ME var0, SocketConnection var1) {
      var0.o = var1;
   }

   static void a(Session_ME var0, DataOutputStream var1) {
      var0.n = var1;
   }

   static void a(Session_ME var0, Message var1) {
      var0.b(var1);
   }

   static void c(Session_ME var0) {
      var0.d();
   }

   static byte a(Session_ME var0, byte var1) {
      byte[] var10000 = (var0 = var0).i;
      byte var10003 = var0.r;
      var0.r = (byte)(var10003 + 1);
      var1 = (byte)(var10000[var10003] & 255 ^ var1 & 255);
      if (var0.r >= var0.i.length) {
         var0.r = (byte)(var0.r % var0.i.length);
      }

      return var1;
   }
}

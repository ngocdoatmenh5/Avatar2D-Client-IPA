package avt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class Message {
   public byte a;
   private ByteArrayOutputStream b = null;
   private DataOutputStream c = null;
   private ByteArrayInputStream d = null;
   private DataInputStream e = null;

   public Message() {
   }

   public Message(byte var1) {
      this.a = var1;
      this.b = new ByteArrayOutputStream();
      this.c = new DataOutputStream(this.b);
   }

   public Message(byte var1, byte[] var2) {
      this.a = var1;
      this.d = new ByteArrayInputStream(var2);
      this.e = new DataInputStream(this.d);
   }

   public final byte[] a() {
      return this.b.toByteArray();
   }

   public final DataInputStream b() {
      return this.e;
   }

   public final DataOutputStream c() {
      return this.c;
   }

   public final void d() {
      try {
         if (this.e != null) {
            this.e.close();
         }

         if (this.c != null) {
            this.c.close();
            return;
         }
      } catch (IOException var1) {
      }

   }
}

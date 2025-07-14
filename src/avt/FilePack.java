package avt;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.lcdui.Image;

public final class FilePack {
   static FilePack a;
   private String[] b;
   private int[] c;
   private int[] d;
   private byte[] e;
   private int f;
   private int g;
   private String h;
   private byte[] i = new byte[]{78, 103, 117, 121, 101, 110, 86, 97, 110, 77, 105, 110, 104};
   private int j;
   private DataInputStream k;

   public FilePack() {
      this.j = this.i.length;
   }

   public static void a() {
      a.b();
      a = null;
      System.gc();
   }

   public FilePack(String var1) {
      this.j = this.i.length;
      int var3 = 0;
      int var4 = 0;
      this.h = var1;
      this.g = 0;
      this.k = new DataInputStream(this.getClass().getResourceAsStream(this.h));

      try {
         this.f = this.k.readUnsignedByte();
         ++this.g;
         this.b = new String[this.f];
         this.c = new int[this.f];
         this.d = new int[this.f];

         for(int var5 = 0; var5 < this.f; ++var5) {
            byte var7;
            byte[] var2 = new byte[var7 = this.k.readByte()];
            this.k.read(var2);
            this.a(var2);
            this.b[var5] = new String(var2);
            this.c[var5] = var3;
            this.d[var5] = this.k.readUnsignedShort();
            var3 += this.d[var5];
            var4 += this.d[var5];
            this.g += var7 + 3;
         }

         this.e = new byte[var4];
         this.k.readFully(this.e);
         this.a(this.e);
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      this.b();
   }

   public static Image a(String var0) {
      return a.d(var0 + ".png");
   }

   public static void b(String var0) {
      a = new FilePack(T.a() + var0);
   }

   private void a(byte[] var1) {
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         var1[var3] ^= this.i[var3 % this.j];
      }

   }

   private void b() {
      try {
         if (this.k != null) {
            this.k.close();
            return;
         }
      } catch (IOException var1) {
      }

   }

   private Image d(String var1) {
      for(int var2 = 0; var2 < this.f; ++var2) {
         if (this.b[var2].compareTo(var1) == 0) {
            return Image.createImage(this.e, this.c[var2], this.d[var2]);
         }
      }

      return null;
   }

   public final byte[] c(String var1) {
      for(int var2 = 0; var2 < this.f; ++var2) {
         if (this.b[var2].compareTo(var1) == 0) {
            byte[] var3 = new byte[this.d[var2]];
            System.arraycopy(this.e, this.c[var2], var3, 0, this.d[var2]);
            return var3;
         }
      }

      return null;
   }
}

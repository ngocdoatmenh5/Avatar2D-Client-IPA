package avt;

import java.io.IOException;
import java.util.Vector;

public final class CasinoService extends IService {
   private static CasinoService a;

   public static CasinoService gI() {
      if (a == null) {
         a = new CasinoService();
      }

      return a;
   }

   public final void b() {
      this.createMessage((byte)6);
      this.sendMessage();
   }

   public final void a(byte var1) {
      this.createMessage((byte)7);
      this.writeByte(var1);
      this.sendMessage();
   }

   public final void a(int var1) {
      try {
         this.b((byte)56);
         super.m.writer().writeByte(var1);
      } catch (Exception var2) {
      }

      this.sendMessage();
   }

   public final void a(byte var1, byte var2, String var3) {
      this.createMessage((byte)8);

      try {
         super.m.writer().writeByte(var1);
         super.m.writer().writeByte(var2);
         super.m.writer().writeUTF(var3);
      } catch (IOException var4) {
      }

      this.sendMessage();
   }

   public final void c() {
      this.createMessage((byte)28);
      this.sendMessage();
   }

   public final void d() {
      this.createMessage((byte)-18);
      this.sendMessage();
   }

   public final void a(byte[] var1) {
      try {
         this.b((byte)21);
         super.m.writer().writeByte(var1.length);

         for(int var2 = 0; var2 < var1.length; ++var2) {
            super.m.writer().write(var1[var2]);
         }
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void e() {
      try {
         this.b((byte)49);
      } catch (Exception var1) {
      }

      this.sendMessage();
   }

   public final void b(byte var1) throws IOException {
      super.createMessage(var1);
      super.m.writer().writeByte(BoardScr.roomID);
      super.m.writer().writeByte(BoardScr.boardID);
   }

   public final void c(byte var1) {
      try {
         this.b((byte)21);
         super.m.writer().writeByte(var1);
      } catch (Exception var2) {
      }

      this.sendMessage();
   }

   public final void f() {
      try {
         this.b((byte)63);
      } catch (Exception var1) {
      }

      this.sendMessage();
   }

   public final void a(int[] var1, byte var2) {
      try {
         this.b((byte)64);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            super.m.writer().writeByte(var1[var3]);
         }

         super.m.writer().writeByte(var2);
      } catch (Exception var4) {
      }

      this.sendMessage();
   }

   public final void a(Card[] var1) {
      try {
         this.b((byte)65);
         byte var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if (var1[var3].a != 0) {
               if (var1[var3].a != var2 && var2 != -1) {
                  super.m.writer().writeByte(-1);
               }

               var2 = var1[var3].a;
               super.m.writer().writeByte(var1[var3].b);
            } else if (var2 != -1) {
               super.m.writer().writeByte(-1);
               var2 = -1;
            }
         }
      } catch (Exception var4) {
      }

      this.sendMessage();
   }

   public final void a(int[] var1) {
      try {
         this.b((byte)67);

         for(int var2 = 0; var2 < var1.length; ++var2) {
            if (var1[var2] != -1) {
               super.m.writer().writeByte(var1[var2]);
            }
         }
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void a(int[] var1, int var2) {
      try {
         this.b((byte)68);
         super.m.writer().writeByte(var2);

         for(var2 = 0; var2 < 5 && var1[var2] != -1; ++var2) {
            super.m.writer().writeByte(var1[var2]);
         }
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void a(String var1) {
      try {
         this.b((byte)9);
         super.m.writer().writeUTF(var1);
      } catch (IOException var2) {
      }

      this.sendMessage();
   }

   public final void g() {
      try {
         this.b((byte)15);
      } catch (IOException var1) {
      }

      this.sendMessage();
   }

   public final void ready(boolean var1) {
      try {
         this.b((byte)16);
         super.m.writer().writeBoolean(var1);
      } catch (IOException var2) {
      }

      this.sendMessage();
   }

   public final void b(int var1) {
      try {
         this.b((byte)19);
         super.m.writer().writeInt(var1);
      } catch (IOException var2) {
      }

      this.sendMessage();
   }

   public final void b(String var1) {
      try {
         this.b((byte)18);
         super.m.writer().writeUTF(var1);
      } catch (IOException var2) {
      }

      this.sendMessage();
   }

   public final void c(int var1) {
      try {
         this.b((byte)11);
         super.m.writer().writeInt(var1);
      } catch (IOException var2) {
      }

      this.sendMessage();
   }

   public final void h() {
      try {
         this.b((byte)20);
      } catch (IOException var1) {
      }

      this.sendMessage();
   }

   public final void a(Point[][] var1) {
      try {
         this.b((byte)64);

         for(int var2 = 0; var2 < 8; ++var2) {
            for(int var3 = 0; var3 < 8; ++var3) {
               if (var1[var2][var3].l) {
                  var1[var2][var3].l = false;
                  super.m.writer().writeByte((var2 << 3) + var3);
               }
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
      }

      this.sendMessage();
   }

   public final void a(int var1, int var2) {
      try {
         this.b((byte)21);
         super.m.writer().writeByte(var1);
         super.m.writer().writeByte(var2);
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      this.sendMessage();
   }

   public final void i() {
      try {
         this.b((byte)24);
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      this.sendMessage();
   }

   public final void a(Vector var1) {
      try {
         this.b((byte)21);
         if (var1.size() > 0) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
               PimgBC var3 = (PimgBC)var1.elementAt(var2);
               super.m.writer().writeByte(var3.moneyPut);
               var3.moneyPut = 0;
            }
         }
      } catch (Exception var4) {
      }

      this.sendMessage();
   }

   public final void a(byte var1, byte var2) {
      try {
         this.b((byte)65);
         super.m.writer().writeByte(var1);
         super.m.writer().writeByte(var2);
      } catch (Exception var3) {
      }

      this.sendMessage();
   }

   public final void skip() {
      try {
         this.b((byte)49);
      } catch (Exception var1) {
      }

      this.sendMessage();
   }
}

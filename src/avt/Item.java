package avt;

import java.util.Vector;

public final class Item {
   public short a;
   public short b;
   public byte c;
   public int[] d = new int[2];
   public int e;
   public String f = "";

   public static Item a(Vector var0, int var1) {
      int var2 = var0.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         Item var4;
         if ((var4 = (Item)var0.elementAt(var3)).a == var1) {
            return var4;
         }
      }

      return null;
   }
}

package avt;

import javax.microedition.lcdui.Graphics;

public final class Point extends MyObject {
   public class_jt a;
   public int b;
   public int c;
   public int d;
   public int e;
   public int color = 0;
   public int g;
   public int h;
   public byte dis = 0;
   public short j;
   public boolean k;
   public boolean l;
   public short yTo;
   public short xTo;
   public short o;

   public Point() {
   }

   public Point(int var1, int var2) {
      super.x = var1;
      super.y = var2;
   }

   public Point(int var1, int var2, int var3) {
      super.x = var1;
      super.y = var2;
      this.xTo = (short)var1;
      this.yTo = (short)var2;
      this.j = (short)var3;
   }

   public final void update() {
      this.a.a();
   }

   public final void paint(Graphics var1) {
      this.a.a(var1);
   }
}

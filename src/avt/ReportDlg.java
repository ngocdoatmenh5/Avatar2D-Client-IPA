package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class ReportDlg extends Dialog {
   public Vector a;
   private static ReportDlg h;
   public int b = 0;
   public int c;
   public int d;
   public int e;
   public int f;
   private boolean i = false;
   public String g = "";

   public static ReportDlg a() {
      if (h == null) {
         h = new ReportDlg();
      }

      return h;
   }

   public final void a(int var1) {
      switch (var1) {
         case 0:
            Canvas.h();
            h = null;
         default:
      }
   }

   public ReportDlg() {
      super.ad = new Command(T1.z, 0);
   }

   public final void k() {
   }

   public final void b() {
      if (this.a != null && this.a.size() > 0) {
         Canvas.v = this;
      }

   }

   public final void a(Graphics var1) {
      Canvas.S.a(var1, this.d, this.b, this.e, this.c, 0);
      int var2 = this.b + PaintPopup.o + (5 + AvMain.Z - AvMain.ah / 2);

      for(int var3 = 0; var3 < this.a.size(); ++var3) {
         String var4;
         if ((var4 = (String)this.a.elementAt(var3)).substring(0, 1).equals("0")) {
            Canvas.smallFontYellow.a(var1, var4.substring(1), this.d + this.e / 2, var2 + 3 + AvMain.ah / 2 - AvMain.ai / 2, 2);
         } else {
            Canvas.K.a(var1, var4, this.d + 15, var2 + 3, 0);
         }

         var2 += AvMain.ah;
      }

      super.a(var1);
   }
}

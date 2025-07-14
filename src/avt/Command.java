package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public class Command {
   public String a;
   public IAction b;
   public byte c;
   public AvMain d;
   public short e = -1;

   public Command(String var1, IAction var2) {
      this.a = var1;
      this.b = var2;
   }

   public Command(String var1, int var2) {
      this.a = var1;
      this.c = (byte)var2;
   }

   public Command(String var1, int var2, AvMain var3) {
      this.a = var1;
      this.c = (byte)var2;
      this.d = var3;
   }

   public Command(String var1, int var2, int var3) {
      this.a = var1;
      this.c = (byte)var2;
      this.e = (byte)var3;
   }

   public final void b() {
      if (this.b != null) {
         this.b.perform();
      } else if (this.d != null) {
         this.d.a(this.c);
      } else if (ChatTextField.c) {
         ChatTextField.gI().a(this.c, this.e);
      } else {
         Canvas.currentMyScreen.a(this.c, this.e);
      }
   }

   public void a() {
   }

   public void a(Graphics var1, int var2, int var3) {
      Canvas.L.a(var1, this.a, var2, var3, 2);
   }
}

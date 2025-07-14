package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public abstract class Effect {
   public boolean b = false;
   public short c = -1;

   public abstract void b();

   public abstract void a(Graphics var1);

   public final void c() {
      GameCanvas.B.addElement(this);
   }

   public void a() {
      GameCanvas.B.removeElement(this);
   }
}

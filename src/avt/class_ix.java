package avt;

import javax.microedition.lcdui.Graphics;

final class class_ix extends Command {
   private final StringObj f;

   class_ix(MenuCenter var1, String var2, int var3, int var4, StringObj var5) {
      super(var2, 18, var4);
      this.f = var5;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.f.d, var2, var3, 3);
   }
}

package avt;

import javax.microedition.lcdui.Graphics;

final class CommandFlower extends Command {
   private final short f;

   CommandFlower(GlobalMessageHandler var1, String var2, IAction var3, short var4) {
      super(var2, var3);
      this.f = var4;
   }

   public final void a(Graphics var1, int var2, int var3) {
      AvatarData.a(var1, this.f, var2, var3, 3);
   }
}

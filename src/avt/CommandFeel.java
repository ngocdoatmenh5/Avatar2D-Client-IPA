package avt;

import javax.microedition.lcdui.Graphics;

final class CommandFeel extends Command {
   private final byte[] f;
   private final int g;

   CommandFeel(MenuCenter var1, String var2, int var3, int var4, byte[] var5, int var6) {
      super(var2, 19, var4);
      this.f = var5;
      this.g = var6;
   }

   public final void a(Graphics var1, int var2, int var3) {
      APartInfo var4;
      (var4 = (APartInfo)AvatarData.a((short)0)).a(var1, var2 + 2 + var4.d[0] * AvMain.Y, var3 + 21 + 20 * (AvMain.Y - 1) + var4.e[0] * AvMain.Y, 0);
      (var4 = (APartInfo)AvatarData.a((short)this.f[this.g])).a(var1, var2 + 2 + var4.d[0] * AvMain.Y, var3 + 21 + 20 * (AvMain.Y - 1) + var4.e[0] * AvMain.Y, 0);
   }
}

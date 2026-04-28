package avt;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class FrameImage {
   public int frameWidth;
   public int frameHeight;
   public int nFrame;
   public Image imgFrame;

   public FrameImage(Image var1, int var2, int var3) {
      this.imgFrame = var1;
      this.frameWidth = var2;
      this.frameHeight = var3;
      this.nFrame = var1.getHeight() / var3;
   }

   public static FrameImage init(String var0, int var1, int var2) {
      return new FrameImage(FilePack.getImage(var0), var1, var2);
   }

   public final void drawFrame(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      if (var1 >= 0 && var1 < this.nFrame) {
         var6.drawRegion(this.imgFrame, 0, var1 * this.frameHeight, this.frameWidth, this.frameHeight, var4, var2, var3, var5);
      }

   }

   public final void drawFrame(int var1, int var2, int var3, int var4, Graphics var5) {
      var5.drawRegion(this.imgFrame, 0, var1 * this.frameHeight, this.frameWidth, this.frameHeight, var4, var2, var3, 0);
   }

   public final void drawFrameXY(int var1, int var2, int var3, int var4, Graphics var5) {
      if (var1 >= 0 && var1 < this.nFrame && var2 >= 0 && var2 * this.frameHeight < this.imgFrame.getHeight() && var1 * this.frameWidth + this.frameWidth <= this.imgFrame.getWidth()) {
         var5.drawRegion(this.imgFrame, var1 * this.frameWidth, var2 * this.frameHeight, this.frameWidth, this.frameHeight, 0, var3, var4, 0);
      }

   }

   public final void drawFrameXY(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      if (var1 >= 0 && var1 < this.nFrame) {
         var6.drawRegion(this.imgFrame, var1 * this.frameWidth, var2 * this.frameHeight, this.frameWidth, this.frameHeight, 0, var3, var4, var5);
      }

   }
}

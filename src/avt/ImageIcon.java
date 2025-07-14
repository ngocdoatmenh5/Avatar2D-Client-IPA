package avt;

import javax.microedition.lcdui.Image;

public final class ImageIcon {
   public Image img;
   public short b;
   public short c;
   public int count = -1;

   public ImageIcon() {
   }

   public ImageIcon(Image var1) {
      this.img = var1;
      this.count = 0;
      this.b = (short)var1.getWidth();
      this.c = (short)var1.getHeight();
   }
}

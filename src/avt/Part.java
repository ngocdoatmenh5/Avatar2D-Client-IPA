package avt;

import javax.microedition.lcdui.Graphics;

public abstract class Part {
   public short f;
   public short IDPart;
   public short h;
   public int[] i = new int[2];
   public byte zOrder;
   public byte k;
   public String l;

   public final void a(Graphics var1, int var2, int var3, int var4) {
      if (this.IDPart != -1) {
         if (this.IDPart >= 2000) {
            Graphics var10001 = var1;
            int var6 = var4;
            boolean var7 = false;
            int var5 = var3;
            var4 = var2;
            short var9 = this.h;
            Graphics var8 = var10001;
            ImageIcon var10;
            if ((var10 = AvatarData.b(var9)).count != -1 || this.IDPart == -1) {
               var8.drawRegion(var10.img, 0, 0, var10.b, var10.c, 0, var4, var5, var6);
            }

            return;
         }

         AvatarData.listImgInfo[this.h].a(var1, var2, var3, var4);
      }

   }

   public void paintIcon(Graphics var1, int var2, int var3, int var4, int var5) {
      this.a(var1, var2, var3, var5);
   }

   public void paintAvatar(Graphics var1, int var2, int var3, int var4, int var5) {
   }
}

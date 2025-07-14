package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class EffectObj extends Base {
   public short a;
   public short b;
   public short c;
   public int d;
   public byte e;
   private byte f;

   public EffectObj() {
      this.b = this.c = 0;
      super.catagory = 6;
      this.f = 0;
   }

   public final void update() {
      EffectData var1;
      if ((var1 = AvatarData.getEffect(this.a)) != null) {
         ++this.f;
         if (this.f < var1.a.length) {
            return;
         }
      }

      this.a();
   }

   public final void paint(Graphics var1) {
      if (Canvas.stypeInt <= 0 || Canvas.currentMyScreen != MenuCenter.gI()) {
         EffectData var2;
         if ((var2 = AvatarData.getEffect(this.a)) != null) {
            if (this.e == 0) {
               Avatar var3;
               if ((var3 = LoadMap.g(this.d)) == null) {
                  this.a();
                  return;
               }

               super.x = var3.x + this.b;
               super.y = var3.y + this.c;
            }

            var2.a(var1, super.x, super.y, this.f);
         }

      }
   }

   private void a() {
      switch (this.e) {
         case 0:
            LoadMap.m.removeElement(this);
            return;
         case 1:
            LoadMap.l.removeElement(this);
            return;
         case 2:
            LoadMap.v.removeElement(this);
            return;
         case 3:
            LoadMap.w.removeElement(this);
         default:
      }
   }
}

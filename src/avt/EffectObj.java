package avt;

import javax.microedition.lcdui.Graphics;
import main.GameCanvas;

public final class EffectObj extends Base {
   public short a;
   public short b;
   public short c;
   public int d;
   public byte e;
   private byte f;

   public EffectObj() {
      this.b = this.c = 0;
      super.az = 6;
      this.f = 0;
   }

   public final void b() {
      EffectData var1;
      if ((var1 = AvatarData.d(this.a)) != null) {
         ++this.f;
         if (this.f < var1.a.length) {
            return;
         }
      }

      this.a();
   }

   public final void a(Graphics var1) {
      if (GameCanvas.Z <= 0 || GameCanvas.r != MenuCenter.b()) {
         EffectData var2;
         if ((var2 = AvatarData.d(this.a)) != null) {
            if (this.e == 0) {
               Avatar var3;
               if ((var3 = LoadMap.g(this.d)) == null) {
                  this.a();
                  return;
               }

               super.aw = var3.aw + this.b;
               super.ax = var3.ax + this.c;
            }

            var2.a(var1, super.aw, super.ax, this.f);
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

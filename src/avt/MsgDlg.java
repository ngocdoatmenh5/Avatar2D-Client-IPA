package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class MsgDlg extends Dialog {
   private Vector c;
   private String d = "";
   private Vector e = new Vector();
   private int f = 0;
   private int g;
   private int h;
   private int i;
   private int j;
   public boolean a = false;
   private int k = 0;
   private int l = 0;
   private int m;
   private int n;
   private int o = 0;
   private int p = 0;
   private int q;
   public static FrameImage b;
   private long r = -1L;
   private long s;
   private long t;
   private int u = 0;

   public MsgDlg() {
      this.m = AvMain.af;
   }

   public final void setInfoC(String var1, Command var2, Vector var3) {
      if (ChatTextField.c) {
         ChatTextField.gI().a();
      }

      this.q = MyScreen.av;
      this.a = false;
      this.d = var1;
      super.center = var2;
      this.f = 0;
      this.e = var3;
      if (var3 != null) {
         Command var4 = (Command)var3.elementAt(this.f);
         super.center = var4;
         if (var4 != null) {
            super.center.b = var4.b;
            super.center.c = var4.c;
            super.center.d = var4.d;
         }

         this.u = 0;

         for(int var5 = 0; var5 < var3.size(); ++var5) {
            var2 = (Command)var3.elementAt(var5);
            if (Canvas.K.getWidth(var2.caption) > this.u) {
               this.u = Canvas.K.getWidth(var2.caption) + (Canvas.isKeyBoard ? this.g / 3 : 0);
            }
         }
      } else {
         this.t = System.currentTimeMillis() / 100L;
      }

      this.l = 0;
      if (this.e != null) {
         this.l = this.e.size();
      }

      this.k = 0;
      this.r = -1L;
      this.init();
      Canvas.currentDialog = Canvas.msgdlg;
   }

   public final void init() {
      this.g = Canvas.w - 80;
      if (Canvas.w < 200) {
         this.g = Canvas.w - 40;
         if (Canvas.w <= 128) {
            this.g = Canvas.w - 10;
         }
      }

      if (this.d.equals(T.b)) {
         this.g = Canvas.hw;
      }

      this.c = Canvas.M.b(this.d, this.g - 16);
      this.h = this.c.size() * this.m + 20;
      this.n = 0;
      if (super.center != null) {
         this.h += this.q + 15 * AvMain.hd;
         this.n += this.q + 15 * AvMain.hd;
      }

      if (this.h < this.q * 3 + (AvMain.hd - 1) * 15) {
         this.h = this.q * 3 + (AvMain.hd - 1) * 15;
      }

      this.i = Canvas.hw - this.g / 2;
      this.j = Canvas.q - Canvas.hTab - this.h - 10;
   }

   public final void setIsWaiting(boolean var1) {
      this.a = var1;
      this.h = this.c.size() * this.m + 20;
      if (this.a) {
         this.h += 25 * AvMain.hd + 4;
         this.n += 25 * AvMain.hd + 4;
      }

      int var2 = this.q * 3 + (AvMain.hd - 1) * 15;
      if (this.h < var2) {
         this.h = var2;
      }

      this.j = Canvas.q - Canvas.hTab - this.h - 10;
      this.s = (long) Canvas.getSecond();
   }

   public final void paint(Graphics var1) {
      Canvas.resetTrans(var1);
      if (System.currentTimeMillis() / 100L - this.t >= 5L) {
         Canvas.paint.a(var1, this.i, this.j, this.g, this.h, PaintPopup.d[0], PaintPopup.d[1], 0);
         if (super.center != null) {
            PaintPopup.a(this.i + 1, this.j + this.h - (this.q + 15 * AvMain.hd - 4), this.g - 2, this.q, 15530985, var1);
         }

         if (this.a) {
            b.drawFrame(this.k, this.i + this.g / 2, this.j + 4 + (this.h - this.n) / 2 + this.c.size() * AvMain.af / 2 + (this.h - (4 + (this.h - this.n) / 2 + this.c.size() * AvMain.af / 2)) / 2, 0, 3, var1);
         }

         if (this.l > 0) {
            Command var2 = (Command)this.e.elementAt(this.f);
            Canvas.K.a(var1, var2.caption, Canvas.hw, this.j + this.h - (this.q + 15 * AvMain.hd - 4) + this.q / 2 - AvMain.ah / 2, 2);
            if (this.l > 1) {
               Canvas.paint.b(var1, Canvas.hw - this.u / 2 - 11, (Canvas.stypeInt != 2 ? AvMain.ah / 2 : 0) + this.j + this.h - (this.q + 15 * AvMain.hd - 4) + MyScreen.av / 2 + 1 + (Canvas.stypeInt == 1 ? -7 : 0) + (Canvas.stypeInt == 0 ? -3 : 0), 17 + this.u, this.o / 3, this.p / 3);
            }
         } else if (super.center != null) {
            Canvas.K.a(var1, super.center.caption, Canvas.hw, this.j + this.h - (this.q + 15 * AvMain.hd - 4) + this.q / 2 - AvMain.ah / 2, 2);
         }

         for(int var3 = 0; var3 < this.c.size(); ++var3) {
            Canvas.M.a(var1, (String)this.c.elementAt(var3), Canvas.hw, this.j + 4 + (this.h - this.n) / 2 - this.c.size() * AvMain.af / 2 + var3 * AvMain.af, 2);
         }

      }
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case -2:
            MapScr.gI().v();
            return;
         case -1:
            this.a = false;
            Canvas.currentDialog = null;
            return;
         default:
            Canvas.currentMyScreen.commandTab(var1, var2);
      }
   }

   private void b(int var1) {
      if (this.l > 0) {
         this.f += var1;
         if (this.f < 0) {
            this.f = this.l - 1;
         }

         if (this.f >= this.l) {
            this.f = 0;
         }

         Command var2 = (Command)this.e.elementAt(this.f);
         super.center = var2;
      }

   }

   public final void updateKey() {
      int var2;
      if (this.a) {
         ++this.k;
         if (this.k >= 8) {
            this.k = 0;
         }

         if ((long) Canvas.getSecond() - this.s > 30L) {
            String var1 = "";

            for(var2 = 0; var2 < this.c.size(); ++var2) {
               var1 = var1 + (String)this.c.elementAt(var2) + " ";
            }

            Canvas.startOK(var1, -2, (AvMain)null);
         }
      }

      if (this.r != -1L && System.currentTimeMillis() / 100L - this.r > 0L) {
         Canvas.keyPressed[5] = true;
      }

      if (this.o > 0) {
         --this.o;
      }

      if (this.p > 0) {
         --this.p;
      }

      if (Canvas.a(4)) {
         this.b(-1);
         this.o = 5;
      } else if (Canvas.a(6)) {
         this.b(1);
         this.p = 5;
      }

      if (Canvas.isPointerRelease) {
         label84: {
            int var3 = 0;
            if (this.e != null && this.e.size() > 0) {
               Command var4 = (Command)this.e.elementAt(this.f);
               var3 = Canvas.K.getWidth(var4.caption) + 20;
            } else if (super.center != null) {
               var3 = Canvas.K.getWidth(super.center.caption) + 20;
            }

            var3 *= AvMain.hd;
            if (super.center != null && Canvas.a(Canvas.hw - var3 / 2, this.j + this.h - (this.q + 18 * AvMain.hd - 4), var3, this.q)) {
               Canvas.endDlg();
               this.perform(super.center);
            } else {
               if (!Canvas.a(this.i + 1, this.j + this.h - (this.q + 18 * AvMain.hd - 4), this.g - 2, this.q)) {
                  break label84;
               }

               if ((var2 = Canvas.hw - Canvas.px) > var3 / 2) {
                  this.b(-1);
                  this.o = 5;
               } else if (var2 < -var3 / 2) {
                  this.b(1);
                  this.p = 5;
               }
            }

            Canvas.isPointerRelease = false;
         }
      }

      super.updateKey();
   }
}

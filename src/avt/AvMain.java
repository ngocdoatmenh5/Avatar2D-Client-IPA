package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public class AvMain {
   public static int hd = 1;
   public static int Z;
   public static int aa;
   public static int ab;
   public Command left;
   public Command center;
   public Command right;
   public static byte af;
   public static byte ag;
   public static byte ah;
   public static byte ai;
   public boolean aj;
   public static boolean ak = false;
   private static byte a = 0;
   private static byte b = 0;
   private static byte c = 0;

   public void c() {
   }

   public void keyPress(int var1) {
   }

   public void paint(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.paint.paintCmd(var1, this.left, this.center, this.right);
   }

   public void commandActionPointer(int var1, int var2) {
   }

   public void commandTab(int var1) {
   }

   public void commandTab(int var1, int var2) {
   }

   private void click(Command var1) {
      if (var1 != null) {
         Canvas.isPointerClick = false;
         Canvas.isPointerRelease = false;
         Canvas.endDlg();
         this.perform(var1);
      }

   }

   public void update() {
   }

   public void updateKey() {
      if (Canvas.isPointerRelease) {
         if (Canvas.b(0, Canvas.ae[0].y, Canvas.w - 1, Canvas.hTab)) {
            switch (Canvas.paint.d()) {
               case 0:
                  if (Canvas.stypeInt == 0) {
                     this.click(this.left);
                  }
                  break;
               case 1:
                  if (Canvas.stypeInt == 0) {
                     this.click(this.center);
                  }
                  break;
               case 2:
                  if (Canvas.stypeInt == 0) {
                     this.click(this.right);
                  }
            }
         }

         a = 0;
         b = 0;
         c = 0;
         if (Canvas.isPaintIconVir()) {
            if (Canvas.a(0, 0, 50 * hd, 50 * hd)) {
               if (!OptionScr.d) {
                  if (TField.m) {
                     ak = true;
                     TField.m = false;
                  }
               } else if (ak) {
                  TField.m = true;
               }

               OptionScr.d = !OptionScr.d;
               Canvas.instance.sizeChanged(0, 0);
               Canvas.isPointerRelease = false;
            }

            if (GameMidlet.CLIENT_TYPE == 9 && Canvas.a(50, 0, 50 * hd, 50 * hd)) {
               if (!OptionScr.d) {
                  OptionScr.d = true;
                  OptionScr.gI().b[4] = 1;
                  Canvas.instance.b();
                  Canvas.z.a = true;
                  if (Canvas.currentMyScreen == MapScr.gI()) {
                     ChatTextField.gI().d = MapScr.gI();
                     ChatTextField.c = true;
                  }
               } else {
                  OptionScr.d = false;
                  OptionScr.gI().b[4] = 0;
                  Canvas.instance.b();
                  if (Canvas.currentMyScreen == MapScr.gI()) {
                     ChatTextField.c = false;
                  }
               }

               Canvas.isPointerRelease = false;
            }
         }
      }

      if (Canvas.a(5)) {
         if (this.center != null) {
            Canvas.endDlg();
            this.perform(this.center);
            return;
         }

         if (Canvas.menuMain == this) {
            this.perform(this.left);
            return;
         }
      } else {
         if (Canvas.a(12)) {
            this.perform(this.left);
            return;
         }

         if (Canvas.E) {
            if (Canvas.a(13) || Canvas.keyReleased[13]) {
               Canvas.keyReleased[13] = false;
               this.perform(this.right);
               return;
            }
         } else if (Canvas.a(13)) {
            this.perform(this.right);
         }
      }

   }

   public final void perform(Command var1) {
      if (var1 != null) {
         if (var1.b != null) {
            var1.b.perform();
            return;
         }

         if (var1.d != null) {
            var1.d.commandTab(var1.c);
            return;
         }

         if (ChatTextField.c) {
            ChatTextField.gI().commandTab(var1.c, var1.e);
            return;
         }

         this.commandTab(var1.c, var1.e);
      }

   }
}

package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class ChatTextField extends AvMain {
   public static ChatTextField instance;
   public TField b;
   public static boolean c = false;
   public IChatable d;
   private long e;

   public final void a(int var1, int var2) {
      switch (var1) {
         case 0:
            this.b.a("");
            c = false;
            this.b.a(true);
            return;
         case 1:
            long var3;
            if ((var3 = System.currentTimeMillis()) - this.e < 2000L) {
               return;
            } else if (this.d != null) {
               this.d.onChatFromMe(this.b.f());
               this.b.a("");
               c = false;
               this.b.a(true);
               this.e = var3;
            }
         default:
      }
   }

   public final void a() {
      this.b.a("");
      c = false;
      this.b.a(true);
      if (OnScreen.b && OptionScr.d) {
         OptionScr.d = false;
         OptionScr.gI().b[4] = 0;
         Canvas.instance.b();
      }

   }

   protected ChatTextField() {
      super.left = new Command(T.d, 0);
      super.center = new Command(T.ba, 1);
      this.b = new TField();
      this.b.e = false;
      this.b.a(true);
      this.init();
      this.b.a = (Canvas.w - this.b.c) / 2;
      this.b.c(40);
      super.right = this.b.a();
   }

   public final void init() {
      this.b.b = Canvas.q - Canvas.hTab - this.b.d - 5;
      if (OnScreen.b) {
         TField var10000 = this.b;
         var10000.b -= 2 * AvMain.hd;
      }

      this.b.c = Canvas.w - 10;
   }

   public final void b(int var1) {
      if (c) {
         this.b.b(var1);
      }

   }

   public static ChatTextField gI() {
      return instance == null ? (instance = new ChatTextField()) : instance;
   }

   public final void a(int var1, IChatable var2) {
      if (Canvas.currentFace == null) {
         this.b.b(var1);
         if (!this.b.f().equals("")) {
            this.d = var2;
            c = true;
         }

         this.init();
      }
   }

   public final void updateKey() {
      this.b.e();
      if (OnScreen.b && Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }

   public final void paint(Graphics var1) {
      if (OnScreen.b) {
         OnScreen.a(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
      }

      this.b.a(var1);
   }
}

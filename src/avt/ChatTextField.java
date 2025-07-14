package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class ChatTextField extends AvMain {
   public static ChatTextField instance;
   public TField tfChat;
   public static boolean isShow = false;
   public IChatable parentMyScreen;
   private long lastTimeChat;

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.tfChat.a("");
            isShow = false;
            this.tfChat.a(true);
            return;
         case 1:
            long var3;
            if ((var3 = System.currentTimeMillis()) - this.lastTimeChat < 2000L) {
               return;
            } else if (this.parentMyScreen != null) {
               this.parentMyScreen.onChatFromMe(this.tfChat.f());
               this.tfChat.a("");
               isShow = false;
               this.tfChat.a(true);
               this.lastTimeChat = var3;
            }
         default:
      }
   }

   public final void a() {
      this.tfChat.a("");
      isShow = false;
      this.tfChat.a(true);
      if (OnScreen.b && OptionScr.d) {
         OptionScr.d = false;
         OptionScr.gI().b[4] = 0;
         Canvas.instance.b();
      }

   }

   protected ChatTextField() {
      super.left = new Command(T.d, 0);
      super.center = new Command(T.ba, 1);
      this.tfChat = new TField();
      this.tfChat.e = false;
      this.tfChat.a(true);
      this.init();
      this.tfChat.a = (Canvas.w - this.tfChat.c) / 2;
      this.tfChat.c(40);
      super.right = this.tfChat.a();
   }

   public final void init() {
      this.tfChat.b = Canvas.hCan - Canvas.hTab - this.tfChat.d - 5;
      if (OnScreen.b) {
         TField var10000 = this.tfChat;
         var10000.b -= 2 * AvMain.hd;
      }

      this.tfChat.c = Canvas.w - 10;
   }

   public final void b(int var1) {
      if (isShow) {
         this.tfChat.b(var1);
      }

   }

   public static ChatTextField gI() {
      return instance == null ? (instance = new ChatTextField()) : instance;
   }

   public final void startChat(int var1, IChatable var2) {
      if (Canvas.currentFace == null) {
         this.tfChat.b(var1);
         if (!this.tfChat.f().equals("")) {
            this.parentMyScreen = var2;
            isShow = true;
         }

         this.init();
      }
   }

   public final void updateKey() {
      this.tfChat.e();
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

      this.tfChat.paint(var1);
   }
}

package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class RoomListOnScr extends MyScreen {
   public static RoomListOnScr me;
   public static FrameImage b;
   private Vector d;
   public static String c;
   private int e;
   private int f;
   private Command g;
   private Command h;
   private int i = 0;

   public static RoomListOnScr b() {
      if (me == null) {
         me = new RoomListOnScr();
      }

      return me;
   }

   public final void switchToMe() {
      Canvas.paint.h();
      super.switchToMe();
      super.right = this.h;
      if (Canvas.stypeInt == 0) {
         super.center = new Command(T.O, 3);
      } else {
         super.center = new Command(T.i, 1);
      }

      super.aj = true;
      this.init();
      OnScreen.b();
      this.e = this.i;
      Canvas.cameraList.setSelect(this.e);
   }

   public RoomListOnScr() {
      this.init();
      this.doLeftMenu();
   }

   public final void commandActionPointer(int var1, int var2) {
      switch (var1) {
         case 1:
            Canvas.startWaitDlg();
            CasinoService.gI().joinAnyBoard();
            return;
         case 2:
            Canvas.startWaitDlg();
            CasinoService.gI().requestRoomList();
            return;
         case 3:
            Canvas.startWaitDlg();
            GlobalService.gI().requestInfoOf(GameMidlet.avatar.IDDB);
         default:
      }
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var3;
            (var3 = new Vector()).addElement(new Command(T.i, 1));
            var3.addElement(new Command(T.f, 2));
            if (Canvas.stypeInt == 0) {
               var3.addElement(MapScr.gI().f);
            }

            var3.addElement(new Command(T.am, 3));
            MenuSub.gI().startAt(var3, 0);
            return;
         case 1:
            this.f();
            return;
         case 2:
            GlobalService.gI().getHandler((int)9);
            Canvas.startWaitDlg();
            return;
         case 3:
            this.f();
         default:
      }
   }

   public final void doLeftMenu() {
      this.g = new Command(T.c, 0);
      new Command(T.O, 1);
      this.h = new Command(T.d, 2);
      super.left = this.g;
      super.right = this.h;
   }

   public static void setName(int var0, BoardScr var1) {
      if (!OnScreen.b) {
         c = T.ek[var0];
      } else {
         c = T.eA[var0];
      }

      CasinoMsgHandler.d = var1;
   }

   public final void init() {
      if (Canvas.stypeInt == 0) {
         this.f = 50;
         this.i = 1;
      } else {
         if (Canvas.stypeInt == 1) {
            this.f = 80;
         } else if (Canvas.stypeInt == 2) {
            this.f = 150;
         }

         this.i = Canvas.w / this.f;
      }

      if (this.d != null) {
         if (this.f != 0) {
            if (Canvas.stypeInt == 0) {
               Canvas.cameraList.a(0, Canvas.w < 200 ? this.f / 2 : 50, Canvas.w, this.f, Canvas.w, this.d.size() * this.f, Canvas.w, Canvas.h - (Canvas.w < 200 ? this.f / 2 : 50) - 4, this.d.size());
            } else {
               Canvas.cameraList.a((Canvas.w - this.f * this.i) / 2, 50 * AvMain.hd, this.f, this.f, Canvas.w, (this.d.size() / this.i + 2) * this.f, Canvas.w, Canvas.h - 50 * AvMain.hd - 4, this.d.size());
            }

            Canvas.cameraList.setSelect(this.e);
         }

      }
   }

   private void f() {
      byte var1;
      if ((var1 = ((RoomInfo)this.d.elementAt(this.e)).a) != -1) {
         CasinoService.gI().requestBoardList(var1);
         Canvas.startWaitDlg();
      }
   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      OnScreen.a(var1, super.left, super.center, super.right);
      Canvas.paintPlus2(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.paint.paintDefaultBg(var1);
      a(var1, "Phòng " + c);
      Canvas.paint.a(var1, this.d, this.f, this.e);
   }

   public static void a(Graphics var0, String var1) {
      Canvas.paint.paintDefaultBg(var0);
      if (Canvas.w > 200) {
         Canvas.paint.e(var0, Canvas.hw - 100 * AvMain.hd, 5 * AvMain.hd - CameraList.cmtoY, 200 * AvMain.hd, 44 * AvMain.hd);
         FontX var2 = Canvas.O;
         if (Canvas.stypeInt == 0) {
            var2 = Canvas.borderFont;
         }

         var2.drawString(var0, var1, Canvas.hw, 5 * AvMain.hd - CameraList.cmtoY + 22 * AvMain.hd - var2.getHeight() / 2, 2);
      }

   }

   public final void a(Vector var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         RoomInfo var3 = (RoomInfo)var1.elementAt(var2);

         for(int var4 = var2; var4 < var1.size(); ++var4) {
            RoomInfo var5;
            if ((var5 = (RoomInfo)var1.elementAt(var4)).c < var3.c) {
               var1.setElementAt(var3, var4);
               var1.setElementAt(var5, var2);
               var3 = var5;
            }
         }
      }

      this.d = new Vector();
      byte var6 = -1;

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         RoomInfo var8 = (RoomInfo)var1.elementAt(var7);
         if (var6 == -1 || var8.c != var6) {
            this.d.addElement(new RoomInfo((byte)-1, (byte)0, (byte)0, var8.c));
         }

         this.d.addElement(var8);
         var6 = var8.c;
      }

      if (Canvas.stypeInt != 0) {
         this.g();
      }

      this.e = 1;
      this.init();
   }

   private boolean g() {
      for(int var1 = 0; var1 < this.d.size(); ++var1) {
         RoomInfo var2;
         if ((var2 = (RoomInfo)this.d.elementAt(var1)).a == -1) {
            int var3;
            int var4;
            if ((var3 = this.i - var1 % this.i) != this.i) {
               for(var4 = 0; var4 < var3; ++var4) {
                  this.d.insertElementAt(new RoomInfo((byte)-2, (byte)0, (byte)0, var2.c), var1);
               }

               var1 += var3;
            }

            for(var4 = 0; var4 < this.i - 1; ++var4) {
               this.d.insertElementAt(new RoomInfo((byte)-2, (byte)0, (byte)0, var2.c), var1 + 1);
            }

            var1 += this.i;
         }
      }

      return false;
   }

   public final void a(int var1, boolean var2) {
      if (var2 && this.e == var1) {
         this.f();
      }

      if (Canvas.stypeInt == 0) {
         if (this.e > 0 && this.e < this.d.size()) {
            RoomInfo var3;
            if ((var3 = (RoomInfo)this.d.elementAt(var1)).a != -1 && var3.a != -1) {
               if (var1 >= 0 && var1 < this.d.size()) {
                  this.e = var1;
               }
            } else if (var1 > this.e) {
               this.e = var1 + this.i;
            } else {
               this.e = var1 - this.i;
            }

            Canvas.cameraList.setSelect(this.e);
            if (this.e <= 0) {
               this.e = this.d.size() - 1;
               Canvas.cameraList.setSelect(this.e);
               return;
            }
         }
      } else {
         this.e = var1;
      }

   }

   public final void updateKey() {
      if (Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }

   public final void update() {
   }
}

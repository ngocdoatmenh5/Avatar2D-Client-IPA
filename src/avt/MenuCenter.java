package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class MenuCenter extends MyScreen {
   public static MenuCenter me;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private boolean j = false;
   private Vector k;
   private short[] l;
   private MyScreen m;
   private Command n;
   public AvPosition b;
   private static class_hz o;
   public boolean c = false;
   private boolean p;
   private long q = 0L;
   private boolean r = false;
   private int s;

   public static MenuCenter gI() {
      return me == null ? (me = new MenuCenter()) : me;
   }

   public final void switchToMe() {
      if (Canvas.currentMyScreen != this) {
         this.m = Canvas.currentMyScreen;
      }

      this.initCmd();
      super.switchToMe();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.h();
            return;
         case 1:
            this.h();
            Command var3;
            if ((var3 = (Command)this.k.elementAt(this.d)).action != null) {
               var3.action.perform();
               return;
            } else {
               this.commandActionPointer(var3.indexMenu, var3.subIndex);
            }
         default:
      }
   }

   public final void initCmd() {
      if (Canvas.stypeInt == 0) {
         super.right = new Command(T.d, 0);
      } else {
         this.j = true;
      }

      this.n = new Command(T.O, 1);
   }

   public MenuCenter() {
      this.s = 50 * AvMain.hd;
   }

   private void h() {
      this.m.switchToMe();
      if (MapScr.focusP != null) {
         MapScr.focusP.ableShow = false;
      }

      this.r = false;
      o = null;
      super.center = null;
      this.p = false;
   }

   public final void commandActionPointer(int var1, int var2) {
      StringObj var8;
      switch (var1) {
         case 1:
            MapScr.gI().doSellectAction();
            return;
         case 2:
            MenuCenter var10 = this;
            byte[] var11 = new byte[]{4, 5, 6, 7, 8, 9, 10, 11, 12};
            Vector var12 = new Vector();

            for(int var13 = 0; var13 < var11.length; ++var13) {
               var12.addElement(new CommandFeel(var10, "", 19, var13, var11, var13));
            }

            var10.b = null;
            var10.setInfo(var12);
            return;
         case 3:
            this.e();
            return;
         case 4:
            MapScr.isOpenInfo = true;
            ParkService.gI().doRequestYourInfo(GameMidlet.avatar.IDDB);
            return;
         case 5:
            ListScr.gI().setFriendList(false);
            return;
         case 6:
            this.c = false;
            GlobalService.gI().doRequestContainer(GameMidlet.avatar.IDDB);
            return;
         case 7:
            MapScr.gI();
            MapScr.doRequestAddFriend(MapScr.focusP);
            return;
         case 8:
            GlobalService.gI().requestShop(26);
            Canvas.startWaitDlg();
            return;
         case 9:
            MapScr.gI().doHit();
            return;
         case 10:
            MapScr.gI();
            MapScr.doKiss();
            return;
         case 11:
            MapScr.isOpenInfo = true;
            MapScr.gI();
            MapScr.doRequestYourInfo();
            return;
         case 12:
            MapScr.gI().doAction();
            return;
         case 13:
            MapScr.gI();
            MapScr.doInviteToMyHome();
            return;
         case 14:
         default:
            break;
         case 15:
            MapScr.gI().a(GameMidlet.myIndexP);
            return;
         case 16:
            if ((var8 = (StringObj)MapScr.listCmdRotate.elementAt(var2)).type == 1) {
               GlobalService.gI().doRequestCmdRotate(var8.anthor, MapScr.focusP != null ? MapScr.focusP.IDDB : -1);
               return;
            }
            break;
         case 17:
            GlobalService.gI().doCommunicate(var2);
            return;
         case 18:
            if ((var8 = (StringObj)MapScr.listCmdRotate.elementAt(var2)).type == 0) {
               GlobalService.gI().doRequestCmdRotate(var8.anthor, MapScr.focusP != null ? MapScr.focusP.IDDB : -1);
               return;
            }
            break;
         case 19:
            byte[] var7 = new byte[]{4, 5, 6, 7, 8, 9, 10, 11, 12};
            if (var2 == 0) {
               MapScr.gI();
               MapScr.doSellectFeel((int)4);
               return;
            }

            MapScr.gI();
            MapScr.doSellectFeel((int)var7[var2]);
            return;
         case 20:
            if (GameMidlet.avatar.task != 0 && GameMidlet.avatar.task != -5 || Bus.isRun) {
               return;
            }

            if (LoadMap.focusObj == null || LoadMap.focusObj.catagory != 5) {
               Vector var9 = new Vector();
               Command var3 = this.a(T.cw, 4, 17);
               Command var4 = this.a(T.dr, 6, 14);
               Command var5 = this.a(T.l, 21, 14);
               Command var6 = this.a(T.cd, 15, 17);
               var9.addElement(var3);
               var9.addElement(var6);
               var9.addElement(var5);
               var9.addElement(var4);
               if (Canvas.currentMyScreen != PopupShop.gI()) {
                  gI().setInfo(var9);
               }

               return;
            }

            ParkService.gI().doGetDropPart(((Drop_Part)LoadMap.focusObj).ID);
            break;
         case 21:
            GlobalService.gI().doRequestContainer(GameMidlet.avatar.IDDB);
            this.c = true;
      }

   }

   public final void e() {
      if (MapScr.focusP != null) {
         this.r = false;
         Vector var1;
         (var1 = new Vector()).addElement(this.a(T.bT, 9, 13));
         var1.addElement(this.a(T.bW, 12, 2));
         var1.addElement(this.a(T.y, 7, 11));
         var1.addElement(this.a(T.bS, 8, 12));
         var1.addElement(this.a(T.bU, 10, 21));
         var1.addElement(this.a(T.bV, 11, 19));
         var1.addElement(this.a(T.dj, 13, 22));
         if (MapScr.listCmdRotate.size() > 0) {
            for(int var2 = 0; var2 < MapScr.listCmdRotate.size(); ++var2) {
               StringObj var3;
               if ((var3 = (StringObj)MapScr.listCmdRotate.elementAt(var2)).type == 1) {
                  var1.addElement(new class_ji(this, var3.str, 16, var2, var3));
               }
            }
         }

         this.setInfo(var1);
      }
   }

   public final void f() {
      if (GameMidlet.avatar.task == 0 || GameMidlet.avatar.task == -5) {
         if (!Bus.isRun) {
            if (LoadMap.focusObj != null && LoadMap.focusObj.catagory == 5) {
               ParkService.gI().doGetDropPart(((Drop_Part)LoadMap.focusObj).ID);
            } else if (LoadMap.focusObj != null && LoadMap.focusObj.catagory == 0 && ((Avatar)LoadMap.focusObj).IDDB == -100) {
               Canvas.startOKDlg(T.eb, (IAction)(new class_jc(this)));
            } else {
               Vector var1 = new Vector();
               Command var2 = this.a(T.bX, 1, 1);
               Command var3 = this.a(T.bY, 2, 0);
               Command var4 = this.a(T.bZ, 3, 20);
               Command var5 = this.a(T.by, 20, 17);
               Command var6 = this.a(T.aa, 5, 18);
               if (Canvas.stypeInt == 0) {
                  var1.addElement(var4);
               }

               var1.addElement(var5);
               var1.addElement(var3);
               if (Canvas.stypeInt == 0) {
                  var1.addElement(MapScr.gI().f);
               }

               if (GameMidlet.avatar.action != 14) {
                  var1.addElement(var2);
               }

               var1.addElement(var6);
               int var7;
               StringObj var8;
               if (Canvas.stypeInt > 0 && MapScr.listCmd != null && MapScr.listCmd.size() > 0) {
                  for(var7 = 0; var7 < MapScr.listCmd.size(); ++var7) {
                     var8 = (StringObj)MapScr.listCmd.elementAt(var7);
                     var1.addElement(new class_jg(this, var8.str, 17, var7, var8));
                  }
               }

               if (MapScr.listCmdRotate.size() > 0) {
                  for(var7 = 0; var7 < MapScr.listCmdRotate.size(); ++var7) {
                     if ((var8 = (StringObj)MapScr.listCmdRotate.elementAt(var7)).type == 0) {
                        var1.addElement(new class_ix(this, var8.str, 18, var7, var8));
                     }
                  }
               }

               if (Canvas.currentMyScreen != PopupShop.gI()) {
                  this.b = null;
                  gI().setInfo(var1);
               }
            }
         }
      }
   }

   public static void g() {
      Avatar var0 = GameMidlet.avatar;
      if (Canvas.currentMyScreen != me) {
         PopupShop.gI().isFull = true;
         PopupShop.gI().addElement(new String[]{T.l, T.co}, new Vector[]{MapScr.gI().getListYourPart((Avatar)var0, 0), MapScr.gI().getListCmdDoUsing(GameMidlet.listContainer, var0.IDDB, 1)}, (Vector)null);
         PopupShop.gI().setCmdLeft(MapScr.gI().cmdDellPart(var0.seriPart, 0, 0, false), 0);
         PopupShop.gI().setCmdLeft(MapScr.gI().cmdDellPart(GameMidlet.listContainer, 1, 0, true), 1);
         if (Canvas.currentMyScreen != PopupShop.gI()) {
            PopupShop.gI().switchToMe();
         }

      }
   }

   private Command a(String var1, int var2, int var3) {
      return new class_iz(this, var1, var2, var3);
   }

   public final Command a(String var1, IAction var2, int var3) {
      return new class_iv(this, var1, new class_iu(this, var2), var3);
   }

   public final void setInfo(Vector var1) {
      this.k = var1;
      if (Canvas.isKeyBoard) {
         this.g = 40 * AvMain.hd + (AvMain.hd - 1) * 20;
         if (Canvas.stypeInt == 1 && Canvas.w > 300) {
            this.g += 20;
         }
      } else {
         this.g = 30;
      }

      this.h = this.g + 2 * AvMain.hd;
      this.f = AvMain.ag << 1;
      this.e = 0;
      this.i = Canvas.w / this.h;
      if (var1.size() * this.h < Canvas.w) {
         this.e = (Canvas.w - var1.size() * this.h) / 2;
      } else {
         this.e = (Canvas.w - this.i * this.h) / 2;
      }

      this.l = new short[var1.size()];

      for(int var2 = 0; var2 < this.l.length; ++var2) {
         this.l[var2] = -40;
      }

      if (this.d >= var1.size()) {
         this.d = 0;
      }

      this.r = false;
      if (MapScr.focusP != null && Canvas.stypeInt > 0) {
         MapScr.focusP.ableShow = true;
      }

      if (Canvas.stypeInt > 0) {
         this.f = Canvas.hh - (var1.size() / this.i + 1) * this.g / 2;
      }

      this.switchToMe();
      if (Canvas.stypeInt == 0) {
         super.center = this.n;
      }

   }

   public final void update() {
      this.m.update();

      for(int var1 = 0; var1 < this.l.length; ++var1) {
         if (this.l[var1] != var1 % this.i * this.h) {
            short[] var10000 = this.l;
            var10000[var1] = (short)(var10000[var1] + (var1 % this.i * this.h - this.l[var1]) / 3);
         }
      }

   }

   public final void updateKey() {
      if (Canvas.isPointerClick) {
         boolean var1 = false;

         for(int var2 = this.k.size() - 1; var2 >= 0; --var2) {
            if (Canvas.isPointer(this.l[var2] + this.e, this.f + var2 / this.i * this.h, this.g, this.g)) {
               this.d = var2;
               this.p = true;
               this.j = false;
               var1 = true;
               this.q = System.currentTimeMillis() / 100L;
               break;
            }
         }

         if (!var1) {
            this.h();
         }
      }

      int var3;
      if (this.p) {
         if (System.currentTimeMillis() / 100L - this.q > 10L) {
            this.j = false;
         }

         if (Canvas.isPointerRelease) {
            this.p = false;
            this.j = true;

            for(var3 = this.k.size() - 1; var3 >= 0; --var3) {
               if (Canvas.isPointer(this.l[var3] + this.e, this.f + var3 / this.i * this.h, this.g, this.g)) {
                  if (var3 == this.d) {
                     this.h();
                     this.commandTab(1, -1);
                  }
                  break;
               }
            }

            Canvas.isPointerRelease = false;
         }
      }

      if (Canvas.a(4)) {
         --this.d;
         if (this.d < 0) {
            this.d = this.k.size() - 1;
         }
      } else if (Canvas.a(6)) {
         ++this.d;
         if (this.d >= this.k.size()) {
            this.d = 0;
         }
      } else if (Canvas.a(2)) {
         if ((var3 = this.d - this.i) < 0) {
            if ((var3 = this.k.size() / this.i * this.i + this.i + var3) < this.k.size()) {
               this.d = var3;
            }
         } else {
            this.d = var3;
         }
      } else if (Canvas.a(8)) {
         this.d += this.i;
         if (this.d >= this.k.size()) {
            this.d %= this.i;
         }
      }

      super.updateKey();
   }

   public final void paint(Graphics var1) {
      this.m.paintMain(var1);
      Canvas.resetTrans(var1);
      Graphics var3 = var1;
      MenuCenter var2 = this;
      if (GameMidlet.avatar.action != 14) {
         GameMidlet.avatar.paintIcon(var1, GameMidlet.avatar.x * AvMain.hd - AvCamera.gI().xCam, GameMidlet.avatar.y * AvMain.hd - AvCamera.gI().yCam, false);
      }

      Command var4 = (Command)this.k.elementAt(this.d);
      Canvas.borderFont.drawString(var1, var4.caption, Canvas.hw, this.f - 15, 2);
      var1.translate(this.e, this.f);

      for(int var5 = this.k.size() - 1; var5 >= 0; --var5) {
         byte var7 = 0;
         Command var6 = (Command)var2.k.elementAt(var5);
         if (var5 == var2.d && !var2.j) {
            var7 = 4;
         }

         Canvas.paint.paintPopupBack(var3, var2.l[var5], var5 / var2.i * var2.h, var2.g, var2.g, var7);
         var6.paint(var3, var2.h / 2 + var2.l[var5], var2.h / 2 + var5 / var2.i * var2.h);
      }

      super.paint(var1);
   }
}

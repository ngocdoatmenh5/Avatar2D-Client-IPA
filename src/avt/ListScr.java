package avt;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class ListScr extends MyScreen {
   public static ListScr a;
   public MyScreen b;
   private int j = 0;
   public static Vector c = new Vector();
   private Command k;
   public static Vector d;
   private int l;
   public static byte e = 0;
   public static boolean f = false;
   public int g;
   public static String h = "friendlist";
   public static Hashtable i = new Hashtable();
   private boolean m = false;
   private String n;
   private boolean o = false;
   private int p = -20;
   private Command q;

   public static ListScr b() {
      if (a == null) {
         a = new ListScr();
      }

      return a;
   }

   public final void switchToMe() {
      this.g = 0;
      this.k = new Command(T.d, 1);
      super.right = this.k;
      this.b = null;
      if (Canvas.currentMyScreen != MenuCenter.gI() && Canvas.currentMyScreen != PopupShop.b() && Canvas.currentMyScreen != b()) {
         this.b = Canvas.currentMyScreen;
      }

      this.f();
      super.switchToMe();
      if (Canvas.stypeInt > 0) {
         this.o = true;
      }

   }

   public final void e() {
      Canvas.cameraList.a(20, PaintPopup.gI().h + PaintPopup.o + AvMain.Z, Canvas.w - 40, this.l, Canvas.w - 40, c.size() * this.l, Canvas.w - 40, PaintPopup.gI().e - 5 - (PaintPopup.o + 2 * AvMain.Z), c.size());
      if (c.size() > 0) {
         class_il.a().a(c.size() * this.l, PaintPopup.gI().e - 5 - (PaintPopup.o + 2 * AvMain.Z));
      }

   }

   public final void f() {
      if (Canvas.stypeInt == 0) {
         PaintPopup.gI().a(this.n, Canvas.w - 20, Canvas.hCan - Canvas.hTab - 20, 1);
      } else {
         PaintPopup.gI().a(this.n, Canvas.w - 20 * AvMain.hd, Canvas.h - Canvas.ab - Canvas.hTab - 10 + (OnScreen.b ? 7 * AvMain.hd : 0), 1);
      }

      PaintPopup.gI().h = 10 + Canvas.ab;
      if (c != null) {
         this.e();
      }

   }

   public ListScr() {
      this.l = 40 * AvMain.hd;
   }

   public final void a(int var1, boolean var2) {
      if (var2 && var1 == this.g) {
         this.perform(this.q);
      }

      this.p = -20;
      if (var1 >= 0 && var1 < c.size()) {
         this.g = var1;
      }

   }

   public final void a(boolean var1) {
      this.o = var1;
   }

   public final void paint(Graphics var1) {
      var1.setClip(0, 0, Canvas.w, Canvas.h);
      if (this.b != null) {
         this.b.paintMain(var1);
      } else {
         MapScr.gI().paintMain(var1);
      }

      PaintPopup.gI().a(var1);
      var1.translate(0, PaintPopup.gI().h + PaintPopup.o + AvMain.Z);
      var1.setClip(0, 0, Canvas.w, Canvas.h);
      int var2;
      if ((var2 = CameraList.cmtoY / this.l) < 0) {
         var2 = 0;
      }

      int var3;
      if ((var3 = var2 + (Canvas.h - 40) / this.l + 1) > c.size()) {
         var3 = c.size();
      }

      int var5;
      int var6;
      int var7;
      int var9;
      ListScr var11;
      Graphics var12;
      if (this.j == 5) {
         var5 = var3;
         var12 = var1;
         var11 = this;
         var6 = 0 + this.l * var2;

         for(var7 = var2; var7 < var5; ++var7) {
            var12.setClip(10 * AvMain.hd + 4 + AvMain.hd, 0, PaintPopup.gI().f - 8 - (AvMain.hd << 1), PaintPopup.gI().e - 5 - (PaintPopup.o + 2 * AvMain.Z));
            var12.translate(0, -CameraList.cmtoY);
            StringObj var13 = (StringObj)c.elementAt(var7);
            int var8 = 0;
            if (!var11.o && var7 == var11.g) {
               Canvas.paint.c(var12, 10 * AvMain.hd + 3 + 2 * AvMain.hd, var6 + 2, Canvas.w - 20 * AvMain.hd - 6 - 4 * AvMain.hd, var11.l - 4);
               if (var13.c > PaintPopup.gI().f - 40) {
                  var11.p += 2;
                  if (var11.p > var13.c - (PaintPopup.gI().f - 40)) {
                     var11.p = -20;
                  }
               }

               var8 = var11.p;
               if (var11.p < 0) {
                  var8 = 0;
               }
            }

            var9 = AvatarData.getImgIcon((short)var13.d).c + 4;
            AvatarData.paintImg(var12, var13.d, 10 * AvMain.hd + 10 + var9 / 2, var6 + var11.l / 2 - 12 * AvMain.hd + AvMain.ah / 2, 3);
            Canvas.normalFont.drawString(var12, var13.a, 10 * AvMain.hd + 10 + var9, var6 + var11.l / 2 - 12 * AvMain.hd, 0);
            Canvas.fontChatB.drawString(var12, var13.b, 10 * AvMain.hd + 10 - var8, var6 + var11.l / 2 + 3 * AvMain.hd, 0);
            var6 += var11.l;
            var12.translate(0, CameraList.cmtoY);
         }
      } else if (this.j == 6 || this.j == 0) {
         var5 = var3;
         var12 = var1;
         var11 = this;
         var7 = 0;
         var6 = 0 + this.l * var2;

         for(int var4 = var2; var4 < var5; ++var4) {
            var12.setClip(10 * AvMain.hd + 4, 0, PaintPopup.gI().f - 8, PaintPopup.gI().e - 5 - (PaintPopup.o + 2 * AvMain.Z));
            var12.translate(0, -CameraList.cmtoY);
            Avatar var14 = (Avatar)c.elementAt(var4);
            var9 = 0;
            int var10;
            if (!var11.o && var4 == var11.g) {
               Canvas.paint.c(var12, 10 * AvMain.hd + 3 + 2 * AvMain.hd, var6 + 2, Canvas.w - 20 * AvMain.hd - 6 - 4 * AvMain.hd, var11.l - 4);
               int var10000 = var10 = Canvas.fontChatB.getWidth(var14.text2);
               int var10003 = AvMain.hd - 1;
               if (var10000 > PaintPopup.gI().f - (57 + var10003 * 30)) {
                  var11.p += 2;
                  int var10004 = AvMain.hd - 1;
                  if (var11.p > var10 - (PaintPopup.gI().f - (57 + var10004 * 30))) {
                     var11.p = -20;
                  }
               }

               var9 = var11.p;
               if (var11.p < 0) {
                  var9 = 0;
               }
            }

            var14.paintIcon(var12, 10 * AvMain.hd + 25 + (AvMain.hd - 1) * 20, var6 + var11.l - 5 * AvMain.hd, false);
            var10 = 0;
            if (var14.idImg != -1) {
               var10 = 6 * AvMain.hd;
               AvatarData.paintImg(var12, var14.idImg, 60 + (AvMain.hd - 1) * 30 + var10, var6 + var11.l / 2 - 12 * AvMain.hd + AvMain.ah / 2, 3);
            }

            int var10001 = 60 + (AvMain.hd - 1) * 30;
            int var10005 = AvMain.hd - 1;
            var12.setClip(var10001, CameraList.cmtoY, PaintPopup.gI().f - (47 + var10005 * 30), PaintPopup.gI().e - 5 - (PaintPopup.o + 2 * AvMain.Z));
            Canvas.normalFont.drawString(var12, var14.name, 60 + (var10 << 1) + (AvMain.hd - 1) * 30, var6 + var11.l / 2 - 12 * AvMain.hd, 0);
            if (var14.idWedding != -1) {
               AvatarData.paintImg(var12, var14.idWedding, 60 + 6 * AvMain.hd + (var10 << 1) + (AvMain.hd - 1) * 30 + Canvas.normalFont.getWidth(var14.name), var6 + var11.l / 2 - 12 * AvMain.hd + AvMain.ah / 2, 3);
            }

            if (var14.idStatus != -1) {
               var7 = 12 * AvMain.hd;
               AvatarData.paintImg(var12, var14.idStatus, 60 - var9 + (AvMain.hd - 1) * 30 + 6 * AvMain.hd, var6 + var11.l / 2 + 3 * AvMain.hd + AvMain.af / 2, 3);
            }

            Canvas.fontChatB.drawString(var12, var14.text2, 60 - var9 + (AvMain.hd - 1) * 30 + var7, var6 + var11.l / 2 + 3 * AvMain.hd, 0);
            var6 += var11.l;
            var12.translate(0, CameraList.cmtoY);
         }
      }

      class_il.a().a(var1, Canvas.w - 10 * AvMain.hd - 9 - AvMain.hd, 0);
      Canvas.resetTrans(var1);
      if (OnScreen.b) {
         OnScreen.a(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
      }
   }

   public final void updateKey() {
      if (OnScreen.b && Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }

   public final void update() {
      if (this.b != null) {
         this.b.update();
      }

      class_il.a().b(CameraList.cmtoY, CameraList.cmy);
   }

   private void a(int var1, Vector var2, MyScreen var3) {
      if (Canvas.currentMyScreen != b()) {
         this.b = var3;
      }

      switch (this.j) {
         case 0:
            f = true;
            d = var2;
            if (e == 1) {
               MapScr.gI();
               MapScr.c(MapScr.h);
            } else if (e == 2) {
               f = false;
               Canvas.startWaitDlg();
               AvatarService.gI().getTypeHouse((int)1);
            } else if (Canvas.currentMyScreen != this) {
               this.switchToMe();
            }

            e = 0;
         case 1:
         case 2:
         case 3:
         case 4:
      }

      c = null;
      c = var2;
      if (this.j != 5) {
         for(var1 = 0; var1 < c.size(); ++var1) {
            Avatar var4;
            (var4 = (Avatar)c.elementAt(var1)).initPet();
            var4.orderSeriesPath();
         }
      }

      this.g = 0;
      super.right = this.k;
      this.e();
   }

   public final void b(boolean var1) {
      this.j = 0;
      if (d == null) {
         Canvas.startWaitDlg();
         CasinoService.gI().requestFriendList();
      } else {
         this.b = Canvas.currentMyScreen;
         this.a(h);
         if (Canvas.currentMyScreen != this) {
            this.switchToMe();
         }
      }

      if (var1) {
         this.m = true;
         this.q = new Command(T.O, 4);
         if (Canvas.stypeInt == 0) {
            super.center = this.q;
         }
      }

   }

   public static Avatar b(int var0) {
      int var1 = d.size();

      for(int var2 = 0; var2 < var1; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar)d.elementAt(var2)).IDDB == var0) {
            return var3;
         }
      }

      return null;
   }

   public final boolean a(String var1) {
      byte[] var2 = (byte[])i.get(var1);
      Canvas.endDlg();
      if (var2 == null) {
         return false;
      } else {
         this.a(var2, var1);
         return true;
      }
   }

   public final void a(byte[] var1, String var2) {
      String[] var3 = null;
      byte[] var4 = null;
      ByteArrayInputStream var15 = new ByteArrayInputStream(var1);
      DataInputStream var16 = new DataInputStream(var15);

      try {
         String var5 = var16.readUTF();
         int var6 = var16.readInt();
         int var7 = var16.readByte();
         byte var8 = var16.readByte();
         short var9 = var16.readShort();
         Vector var10 = new Vector();
         if (var7 == 0) {
            this.j = 5;

            for(var7 = 0; var7 < var9; ++var7) {
               StringObj var11;
               (var11 = new StringObj()).d = var16.readShort();
               var11.a = var16.readUTF();
               var11.b = var16.readUTF();
               var11.c = Canvas.fontChatB.getWidth(var11.b);
               var10.addElement(var11);
            }
         } else {
            this.j = 6;

            for(var7 = 0; var7 < var9; ++var7) {
               Avatar var18;
               (var18 = new Avatar()).direct = 0;
               byte var12 = var16.readByte();
               var18.seriPart = new Vector();

               for(int var13 = 0; var13 < var12; ++var13) {
                  var18.addSeri(new SeriPart(var16.readShort()));
               }

               var18.IDDB = var16.readInt();
               var18.idImg = var16.readShort();
               if (var2.equals(h)) {
                  var18.idWedding = var16.readShort();
                  var18.idStatus = var16.readShort();
               }

               var18.name = var16.readUTF();
               var18.text2 = var16.readUTF();
               var10.addElement(var18);
            }
         }

         byte var17;
         if ((var17 = var16.readByte()) > 0) {
            var3 = new String[var17];
            var4 = new byte[var17];

            for(int var19 = 0; var19 < var17; ++var19) {
               var4[var19] = var16.readByte();
               var3[var19] = var16.readUTF();
            }
         }

         if (var2.equals(h)) {
            this.j = 0;
         }

         b().a(this.j, var10, Canvas.currentMyScreen);
         this.n = var5;
         this.f();
         if (Canvas.currentMyScreen != this) {
            this.switchToMe();
         }

         super.left = null;
         if (var17 > 0) {
            super.left = new Command(T.c, new IActionListMenu(this, var2, var3, var6, var8, var4));
         }

         if (!this.m) {
            if (var2.equals(h)) {
               this.q = new Command(T.L, 0);
               if (Canvas.stypeInt == 0) {
                  super.center = this.q;
               }
            } else if (!this.m) {
               this.q = new Command(T.O, new IActionReadList(this, var6, var8));
               if (Canvas.stypeInt == 0) {
                  super.center = this.q;
               }
            }
         }

         this.m = false;
      } catch (IOException var14) {
         var14.printStackTrace();
      }
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            if (this.g >= 0 && this.g < c.size()) {
               Avatar var4 = (Avatar)c.elementAt(this.g);
               MessageScr.gI().a(var4.IDDB, var4.name);
               MessageScr.gI().a(this.b);
               return;
            }
            break;
         case 1:
            super.center = null;
            super.right = null;
            super.left = null;
            c = null;
            Canvas.cameraList.isShow = false;
            if (this.b != null) {
               this.b.switchToMe();
               return;
            }

            MapScr.gI().switchToMe();
            break;
         case 2:
            return;
         case 3:
            Avatar var3 = (Avatar)c.elementAt(b().g);
            AvatarService.gI().doJoinHouse(var3.IDDB);
            Canvas.startWaitDlg();
            return;
         case 4:
            Canvas.startWaitDlg();
            FarmScr.gI().b(((Avatar)d.elementAt(this.g)).IDDB, true);
      }

   }

   public final void g() {
      this.q = new Command(T.O, 3);
      if (Canvas.stypeInt == 0) {
         super.center = this.q;
      }

   }

   public final void commandActionPointer(int var1, int var2) {
      switch (var1) {
         case 50:
            CasinoService.gI().requestFriendList();
         default:
      }
   }

   public static void h() {
      i.remove(h);
      d = null;
   }

   static boolean a(ListScr var0) {
      return var0.m;
   }
}

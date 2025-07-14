package avt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class MapScr extends MyScreen implements IChatable {
   public static MapScr a;
   public static byte b;
   public static byte c;
   public static Image d;
   private Command H;
   public Command e;
   public Command f;
   private Command I;
   private Command J;
   public static byte g = -1;
   public static Avatar h;
   public static byte i = -1;
   public static String j;
   public static Image k;
   public static Vector l = new Vector();
   public static int m = -1;
   public static Vector n;
   public static Vector o;
   public static Vector p;
   public static Vector q;
   public static boolean r = false;
   public static boolean s = false;
   public static boolean t = false;
   public static boolean isNewVersion = false;
   public static int v = -1;
   static byte[] w = new byte[]{10, 4, 3, 5};
   private byte K = 0;
   private byte L = -1;
   public static boolean x = false;
   private Vector M = new Vector();
   private int N;
   private int O = 60;
   public boolean y = true;
   public static byte z;
   public static byte A;
   public static short[] B;
   public static Avatar C;
   public static int D = -1;
   public static int E;
   public static int F;
   public static int G = -1;

   public final void switchToMe() {
      this.c();
      super.switchToMe();
   }

   public static MapScr gI() {
      if (a == null) {
         a = new MapScr();
      }

      return a;
   }

   public final void c() {
      this.H = new Command(T.c, 0, this);
      super.left = this.H;
      this.f = MenuCenter.gI().a(T.bR, new class_ig(this), 15);
      this.e = new Command(Canvas.isKeyBoard ? (Canvas.stypeInt == 0 ? T.O : T.c) : "", 1, this);
      if (Canvas.stypeInt > 0 && Canvas.welcome == null) {
         super.left = this.e;
      }

      this.I = new Command(T.x, 2, this);
      this.J = new Command(T.bZ, 2);
   }

   public final void commandTab(int var1) {
      switch (var1) {
         case 0:
            this.A();
            return;
         case 1:
            if (!t) {
               MenuCenter.gI().f();
               return;
            }
            break;
         case 2:
            this.e();
            return;
         case 3:
            w();
      }

   }

   public final void close() {
      this.I.perform();
   }

   public MapScr() {
      this.c();
   }

   public final void e() {
      Canvas.startWaitDlg();
      g = -1;
      i = -1;
      if (GameMidlet.CLIENT_TYPE == 8) {
         this.joinCitymap();
      } else {
         GlobalService.gI().getHandler((int)8);
      }
   }

   protected static void f() {
      MessageScr.gI().a(Canvas.currentMyScreen);
   }

   protected final void g() {
      if (h != null) {
         f(100);
      }
   }

   protected static void h() {
      if (h != null) {
         ParkService.a().c(0, h.IDDB);
      }

   }

   public final void a(byte var1, int var2) {
      Canvas.endDlg();
      Avatar var3;
      if ((var3 = LoadMap.g(var2)) != null) {
         if (var1 == 0) {
            Canvas.startOKDlg(T.dp + var3.name + ". " + T.dq, (IAction)(new class_ih(this, var2)));
         } else {
            if (var1 == 1) {
               v = var2;
               GlobalService.gI().getHandler((int)11);
               Canvas.startWaitDlg();
            }

         }
      }
   }

   protected final void i() {
      MessageScr.gI().a(h.IDDB, h.name);
      MessageScr.gI().a((MyScreen)this);
   }

   private void A() {
      Vector var1 = new Vector();
      short[] var2 = null;
      if (LoadMap.TYPEMAP != 25 && n != null && n.size() > 0) {
         var2 = new short[n.size()];

         for(int var3 = 0; var3 < n.size(); ++var3) {
            StringObj var4 = (StringObj)n.elementAt(var3);
            var2[var3] = (short)var4.d;
            var1.addElement(new Command(var4.a, 2, var3));
         }
      }

      var1.addElement(this.I);
      MenuSub var10000 = MenuSub.gI();
      boolean var5 = false;
      MenuSub var6 = var10000;
      var10000.startAt(var1, 0);
      MenuSub.h = var2;
      if (var2 != null) {
         var6.c += var6.e;
      }

   }

   public static void doAction(byte var0) {
      GameMidlet.avatar.doAction(var0);
      AvatarService.gI().doFeel((int)var0);
   }

   public static void b(int var0) {
      GameMidlet.avatar.setFeel(var0);
      GameMidlet.avatar.firFeel = GameMidlet.avatar.feel;
      GameMidlet.avatar.numFeel = 0;
      AvatarService.gI().doFeel(var0 + 100);
   }

   public static void a(int var0, byte var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         if (var1 >= 100) {
            var2.setFeel(var1 - 100);
            var2.firFeel = var2.feel;
            var2.numFeel = 0;
            return;
         }

         var2.doAction(var1);
      }

   }

   protected final void j() {
      Vector var1 = new Vector();

      for(int var2 = 0; var2 < 4; ++var2) {
         Command var3 = MenuCenter.gI().a(T.ey[var2], new class_io(this, var2), var2 + 7);
         var1.addElement(var3);
      }

      MenuCenter.gI().b = null;
      MenuCenter.gI().a(var1);
   }

   public final void update() {
      Canvas.loadMap.b();
      if (Canvas.stypeInt == 0 && LoadMap.p != null) {
         if (h != null && LoadMap.p.catagory != 5 && h.IDDB > 2000000000) {
            super.center = this.J;
         } else {
            super.center = null;
         }

         super.right = LoadMap.q;
         if (LoadMap.p.catagory == 0) {
            super.right.caption = ((Avatar)LoadMap.p).name;
            if (super.right.caption.length() > 8) {
               super.right.caption = super.right.caption.substring(0, 8) + "..";
            }
         }
      }

      if (LoadMap.p == null && super.right == LoadMap.q) {
         super.right = null;
         super.center = null;
      }

      Avatar var2;
      Avatar var3;
      if (t) {
         Avatar var4;
         if (this.K == 1 && Canvas.load == -1) {
            System.out.println("updateWedding1111111111111: " + this.K);
            this.K = 2;
            var2 = LoadMap.g(-100);
            var3 = LoadMap.g(E);
            var4 = LoadMap.g(F);
            if (var3 != null && var4 != null) {
               AvCamera.gI().followPlayer = var2;
               System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
               var2.a(150, T.eB[0] + var3.name + T.eB[1] + var4.name + T.eB[2], (byte)1);
            } else {
               this.B();
            }
         }

         if (this.K == 2 && Canvas.gameTick % 4 == 2 && LoadMap.g(-100).chat == null) {
            this.K = 3;
            var3 = LoadMap.g(E);
            var4 = LoadMap.g(F);
            if (var3 != null && var4 != null) {
               var4.xCur = 26 * LoadMap.i - LoadMap.i;
               var4.task = -5;
               var3.xCur = 26 * LoadMap.i - (LoadMap.i << 1);
               var3.task = -5;
               AvCamera.gI().followPlayer = var3;
            } else {
               this.B();
            }
         }

         if (this.K == 3) {
            var2 = LoadMap.g(E);
            var3 = LoadMap.g(F);
            if (var2 != null && var3 != null && var2.task == 0 && var3.task == 0) {
               this.K = 4;
               var4 = LoadMap.g(-100);
               AvCamera.gI().followPlayer = var4;
               var4.a(200, T.eC[0] + var2.name + T.eB[1] + var3.name, (byte)1);
               var4.a(200, T.eC[1], (byte)1);
               var4.a(150, T.eC[2], (byte)1);
               var4.a(100, T.eC[3], (byte)1);
            }
         }

         if (this.K == 4) {
            var2 = LoadMap.g(E);
            var3 = LoadMap.g(F);
            var2.G = 4;
            var3.G = 4;
            if ((var4 = LoadMap.g(-100)).chat == null && var4.listChat.size() == 0) {
               if (E == GameMidlet.avatar.IDDB) {
                  ParkService.a().b(F, 101);
               }

               this.L = 0;
               this.K = 5;
            }
         }
      }

      if (this.K == 5 && this.L >= 0) {
         ++this.L;
         if (this.L > 20) {
            if (this.L == 21) {
               AnimateEffect var5 = new AnimateEffect(2, 0);
               Canvas.currentEffect.addElement(var5);
               AvCamera.gI().followPlayer = GameMidlet.avatar;
               GameMidlet.avatar.G = 4;
            }

            if (GameMidlet.avatar.IDDB != E) {
               t = false;
               this.L = -1;
            }

            if (GameMidlet.avatar.task == 0 && GameMidlet.avatar.IDDB == E) {
               t = false;
               var2 = LoadMap.g(E);
               var3 = LoadMap.g(F);
               if (var2 != null && var3 != null) {
                  var2.G = 4;
                  var3.G = 4;
               }

               this.K = 6;
               this.L = -1;
               ParkService.a().b(F, 102);
            }
         }
      }

      if (super.center == null && Canvas.stypeInt == 0 && Canvas.welcome == null) {
         super.center = this.e;
      } else if (Canvas.welcome != null) {
         super.center = null;
      }

      if (l.size() > 0) {
         for(int var1 = 0; var1 < l.size(); ++var1) {
            ((Fish)l.elementAt(var1)).update();
         }
      }

      if (this.N > 0) {
         --this.N;
         if (this.N == 0) {
            if (this.M.size() > 0) {
               this.M.removeElementAt(0);
            }

            if (this.M.size() > 0) {
               this.N = this.O;
            }
         }
      }

   }

   private void B() {
      t = false;
      this.K = 0;

      for(int var1 = 0; var1 < LoadMap.playerLists.size(); ++var1) {
         MyObject var2;
         if ((var2 = (MyObject)LoadMap.playerLists.elementAt(var1)).catagory == 0) {
            Avatar var3;
            (var3 = (Avatar)var2).G = 4;
         }
      }

   }

   public final void updateKey() {
      if (Canvas.isPointerClick && Canvas.isPointer(0, 0, Canvas.w, 0)) {
         Canvas.isPointerClick = false;
         GlobalService.gI().c(GameMidlet.avatar.IDDB);
      }

      if (Canvas.welcome == null || !Welcome.d) {
         super.updateKey();
      }

      Canvas.loadMap.a();
      GameMidlet.avatar.updateKey();
   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      if (Canvas.welcome == null || !Welcome.d) {
         super.paint(var1);
      }

      Canvas.a(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.resetTrans(var1);
      Canvas.loadMap.b(var1);
      int var2;
      if (l.size() > 0) {
         for(var2 = 0; var2 < l.size(); ++var2) {
            ((Fish)l.elementAt(var2)).paint(var1);
         }
      }

      Canvas.loadMap.d(var1);
      Canvas.resetTrans(var1);
      if (this.M.size() != 0) {
         String var4 = (String)this.M.elementAt(0);
         if ((var2 = this.O - this.N) > 10) {
            var2 = 10;
         }

         int var5 = Canvas.w;

         for(int var6 = 0; var6 < var2; ++var6) {
            var5 >>= 1;
         }

         Canvas.borderFont.drawString(var1, var4, var5 + 3, 2, 0);
      }

      Canvas.resetTrans(var1);
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            this.A();
            return;
         case 2:
            GlobalService.gI().h(h.IDDB);
            return;
         case 52:
            if (Canvas.currentMyScreen == MiniMap.a && LoadMap.TYPEMAP == -1) {
               Canvas.startWaitDlg();
               GlobalService.gI().getHandler((int)8);
            }
         default:
      }
   }

   public final void a(byte var1, byte var2, short var3, short var4, Vector var5, Vector var6, Vector var7) {
      if (var2 == -1) {
         Canvas.startOK(T.aW, 52, (AvMain)null);
      } else {
         if (LoadMap.y == -1) {
            LoadMap.F = var6;
            LoadMap.G = var7;
         }

         Canvas.paint.a(var1);
         Canvas.g();
         b = (byte)var1;
         c = var2;
         h = null;
         LoadMap.p = null;
         GameMidlet.avatar.task = 0;
         if (Canvas.isDoubleImage || var1 != LoadMap.TYPEMAP || var1 == LoadMap.TYPEMAP && LoadMap.y == -1 || LoadMap.y == -1 && (LoadMap.TYPEMAP == 14 || LoadMap.TYPEMAP == 15 || LoadMap.TYPEMAP == 16)) {
            GameMidlet.avatar.ableShow = false;
            if (var1 != LoadMap.TYPEMAP) {
               GameMidlet.avatar.x = var3;
               GameMidlet.avatar.y = var4;
            }

            LoadMap.treeLists.removeAllElements();
            Canvas.loadMap.e(var1 + 1);
         } else {
            l.removeAllElements();
            LoadMap.playerLists.removeAllElements();
            LoadMap.n.removeAllElements();
            Canvas.currentEffect.removeAllElements();
            LoadMap.b(GameMidlet.avatar);
         }

         if (var6 != null) {
            LoadMap.d();
         }

         if (LoadMap.B != -1) {
            GameMidlet.avatar.setPos(LoadMap.B, LoadMap.C);
            LoadMap.C = -1;
            LoadMap.B = -1;
         }

         if (LoadMap.H != -1) {
            GameMidlet.avatar.x = LoadMap.H;
            GameMidlet.avatar.y = LoadMap.I;
            LoadMap.I = -1;
            LoadMap.H = -1;
            doMove(GameMidlet.avatar.x, GameMidlet.avatar.y, GameMidlet.avatar.direct, 0);
         }

         Canvas.instance.b();
         if (Canvas.currentMyScreen != this) {
            if (OnScreen.c == 0) {
               gI().switchToMe();
            } else {
               OnScreen.c = 2;
               class_jv.b().switchToMe();
            }
         }

         for(var1 = 0; var1 < var5.size(); ++var1) {
            MyObject var8;
            if ((var8 = (MyObject)var5.elementAt(var1)).catagory == 0) {
               Avatar var9;
               (var9 = (Avatar)var8).xCur = var9.x;
               var9.yCur = var9.y;
               var9.dirLast = var9.direct;
               var9.orderSeriesPath();
               if (var9.IDDB != GameMidlet.avatar.IDDB) {
                  e(var9);
                  LoadMap.b(var9);
               }
            } else if (var8.catagory == 5) {
               Drop_Part var10;
               (var10 = (Drop_Part)var8).x0 = var10.x;
               var10.y0 = var10.y;
               LoadMap.playerLists.addElement(var10);
            }
         }

         if (Bus.isRun) {
            doMove(Bus.posBusStop.x, Bus.posBusStop.y, GameMidlet.avatar.direct, GameMidlet.avatar.N);
         } else {
            ++GameMidlet.avatar.y;
            this.n();
         }

         b((int)GameMidlet.avatar.feel);
         if (Canvas.stypeInt == 0 && Canvas.welcome == null) {
            super.left = this.H;
         }

         h = null;
         if (LoadMap.TYPEMAP != 25) {
            Canvas.endDlg();
         }

         Canvas.instance.sizeChanged(0, 0);
         if (Canvas.isDoubleImage) {
            if (LoadMap.TYPEMAP == 9 && Welcome.e != 0) {
               (Canvas.welcome = new Welcome()).b();
            } else if (!Bus.isRun && LoadMap.TYPEMAP == 23) {
               (Canvas.welcome = new Welcome()).d();
            } else if (LoadMap.TYPEMAP == 25 && Welcome.f > 0) {
               (Canvas.welcome = new Welcome()).a((MyScreen)a);
            }

            super.left = null;
            super.center = null;
         }

         GameMidlet.avatar.M = false;
         GameMidlet.avatar.N = 0;
         GameMidlet.avatar.G = 4;
         r = false;
         t = false;
         Canvas.currentFace = null;
         if (LoadMap.TYPEMAP == 108) {
            AvCamera.gI().update();
            AvCamera.gI().notTrans();
         }

         if (Canvas.load == 0) {
            Canvas.load = 1;
         }

      }
   }

   public static void m() {
      byte var0 = 0;
      switch (i) {
         case 0:
            var0 = 3;
            break;
         case 1:
            var0 = 7;
            break;
         case 2:
            var0 = 21;
            break;
         case 3:
            var0 = 22;
            break;
         case 4:
            var0 = 21;
            break;
         case 5:
            var0 = 22;
      }

      GlobalService.gI().b((int)var0);
   }

   public final void b(byte var1) {
      if (g == -1) {
         this.n();
         System.out.println("doJoinShop: " + var1);
         Canvas.startWaitDlg();
         g = var1;
         GlobalService.gI().getHandler((int)8);
      }
   }

   public static void doMove(int var0, int var1, int var2, int var3) {
      if ((GameMidlet.CLIENT_TYPE == 9 || GameMidlet.CLIENT_TYPE == 11) && !t) {
         GameMidlet.avatar.xCur = var0;
         GameMidlet.avatar.yCur = var1;
         ParkService.a().a(var0, var1, var2, var3);
      }
   }

   public final void n() {
      doMove(GameMidlet.avatar.x, GameMidlet.avatar.y, GameMidlet.avatar.direct, GameMidlet.avatar.N);
   }

   public static void a(int var0, int var1, int var2, int var3, short var4) {
      Avatar var5 = LoadMap.g(var0);
      if (var0 != GameMidlet.avatar.IDDB && !t) {
         if (var5 != null) {
            if (var5.ableShow && var5.task == 0) {
               var5.ableShow = false;
               var5.setPos(var1, var2);
               var5.N = var4;
            }

            if (var5.action == -3) {
               var5.action = 0;
            }

            var5.isJumps = -1;
            if (var5.task == 0) {
               AvPosition var6;
               (var6 = new AvPosition(var1, var2, var3)).d = var4;
               var5.moveList.addElement(var6);
            }
         }

      }
   }

   public final void a(Avatar var1) {
      e(var1);
      var1.orderSeriesPath();
      var1.ableShow = true;
      Avatar var2;
      if ((var2 = LoadMap.g(var1.IDDB)) != null) {
         LoadMap.playerLists.removeElement(var2);
      }

      LoadMap.b(var1);
   }

   private static void e(Avatar var0) {
      APartInfo var1;
      if ((var1 = AvatarData.getPartByZ(var0.seriPart, 50)) != null) {
         var0.gender = var1.gender;
      }

   }

   public static void c(int var0) {
      Avatar var1;
      if ((var1 = LoadMap.g(var0)) != null) {
         var1.resetTypeChair();
         var1.isLeave = true;
         Fish var2;
         if ((var2 = class_kv.c(var0)) != null) {
            l.removeElement(var2);
         }
      }

   }

   public final void keyPress(int var1) {
      ChatTextField.gI().startChat(var1, this);
      super.keyPress(var1);
   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         if (var1.indexOf("dmw") != -1) {
            if (h != null) {
               GlobalService.gI().b(h.IDDB, var1);
            }

         } else if (var1.indexOf("ptw") == 0 && h != null && h.chat != null && h.chat.chats != null) {
            String var2 = var1 + " (";

            for(int var3 = 0; var3 < h.chat.chats.length; ++var3) {
               var2 = var2 + " " + h.chat.chats[var3];
            }

            var2 = var2 + ").";
            GlobalService.gI().b(h.IDDB, var2);
         } else {
            ParkService.a().a(var1);
         }
      }
   }

   public static void onChatFrom(int var0, String var1) {
      if (LoadMap.TYPEMAP != 24 && LoadMap.TYPEMAP != 53) {
         Avatar var2;
         if ((var2 = LoadMap.g(var0)) != null) {
            var2.chat = null;
            var2.a(100, var1, (byte)(var0 >= 2000000000 ? 1 : 0));
            if (var0 < 2000000000) {
               MessageScr var10000 = MessageScr.gI();
               var1 = var2.name + ": " + var1;
               var10000.a.a(var1);
            }

         }
      }
   }

   protected static void o() {
      if (h != null && h.task == 0) {
         ParkService.a().b(h.IDDB, 101);
      }
   }

   public final void e(int var1) {
      if (h != null) {
         APartInfo var2;
         Canvas.a((var2 = (APartInfo)AvatarData.getPart((short)var1)).i[0], var2.i[1], new class_ij(this, var2), new class_ik(this, var2), (IAction)null);
      }
   }

   public static void f(int var0) {
      ParkService.a().b(h.IDDB, var0);
   }

   public final void a(int var1, int var2, int var3, String var4, int var5) {
      if (var3 == -1) {
         Canvas.startOKDlg(var4);
      } else {
         this.a(1, var1, var2, var3, (int)var5);
      }
   }

   public final void a(int var1, int var2, int var3, String var4, int var5, int var6, int var7, int var8) {
      if (var3 == -1) {
         Canvas.startOKDlg(var4);
      } else {
         if (var1 == GameMidlet.avatar.IDDB) {
            System.out.println("onGiftGiving: " + var5);
            GameMidlet.avatar.updateMoney(var6, var7, var8);
         }

         this.a(0, var1, var2, var3, (int)0);
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      Avatar var6 = LoadMap.g(var2);
      Avatar var7 = LoadMap.g(var3);
      if (var6 != null && var7 != null) {
         if (var6.task == 0 && var7.task == 0) {
            var6.idTo = var7.IDDB;
            var6.idFrom = var6.IDDB;
            var7.idFrom = var6.IDDB;
            var7.idTo = var7.IDDB;
            if (var2 == GameMidlet.avatar.IDDB) {
               GameMidlet.avatar.yCur = var7.y;
               if (GameMidlet.avatar.x < var7.x) {
                  var2 = var7.x - 15;
               } else {
                  var2 = var7.x + 15;
               }

               GameMidlet.avatar.xCur = var2;
               doMove(var2, var7.y, GameMidlet.avatar.direct, GameMidlet.avatar.N);
            }

            if (var3 == GameMidlet.avatar.IDDB) {
               doMove(GameMidlet.avatar.x, GameMidlet.avatar.y, var6.direct == 0 ? Base.LEFT : 0, GameMidlet.avatar.N);
            }

            if (var1 == 1) {
               var7.isJumps = -1;
               switch (var4) {
                  case 0:
                     var7.task = var6.task = -3;
                     this.b(var6.name + " " + T.ca + var7.name);
                     break;
                  case 100:
                     if (var7.task == 0) {
                        var6.task = -2;
                        var7.task = -2;
                        var6.moveList.removeAllElements();
                        var7.moveList.removeAllElements();
                        var6.focus = var7;
                        var6.doAction(var7.x, var7.y + 5);
                     }
                     break;
                  case 101:
                     if (var7.task == 0) {
                        var6.task = 11;
                        var7.task = 11;
                        var6.moveList.removeAllElements();
                        var7.moveList.removeAllElements();
                        var6.focus = var7;
                        if (var6.x < var7.x) {
                           var6.doAction(var7.x - 20, var7.y + 2);
                        } else {
                           var6.doAction(var7.x + 20, var7.y + 2);
                        }
                     }
                     break;
                  case 102:
                  case 103:
                     var7.task = var6.task = 12;
                     var7.Y = var6.Y = (short)var5;
                     this.b(var6.name + " " + T.bS + " " + var7.name);
                     break;
                  default:
                     this.b(var6.name + " " + "tặng quà" + " " + var7.name);
               }
            } else {
               var6.task = 9;
               var7.task = 8;
               var7.isJumps = -1;
               var7.idGift = var4;
               Part var8 = AvatarData.getPart((short)var4);
               this.b(var6.name + " " + T.di + " " + var8.name + " " + T.dh + " " + var7.name);
            }

            var7.firFeel = var7.feel;
            var7.numFeel = 0;
            var6.firFeel = var6.feel;
            var6.numFeel = 0;
         }
      }
   }

   public static void b(Avatar var0) {
      SeriPart var1;
      if ((var1 = AvatarData.getSeriByZ(((APartInfo)AvatarData.getPart((short)var0.idGift)).zOrder, var0.seriPart)) == null) {
         var0.addSeri(new SeriPart((short)var0.idGift));
         var0.orderSeriesPath();
      } else {
         var1.idPart = (short)var0.idGift;
      }
   }

   public static void c(Avatar var0) {
      if (var0 != null) {
         ParkService.a().a(var0.IDDB);
         Canvas.startOKDlg(T.b + " " + var0.name + "  " + T.e);
      }
   }

   public final void a(Avatar var1, String var2) {
      class_cw var3;
      (var3 = new class_cw(T.y, -2, new Command(T.e, new class_in(this, var1)), new Command(T.cc, new class_ej(this, var1)), false)).a(var2);
      MessageScr var4 = MessageScr.gI();
      var3.a = true;
      var4.b(var3);
      if (Canvas.currentMyScreen != MessageScr.gI()) {
         ++MyScreen.as;
      }

   }

   public static void a(boolean var0, String var1) {
      if (var0) {
         ListScr.b();
         ListScr.h();
      }

      Canvas.startOKDlg(var1);
   }

   protected static void p() {
      if (h != null) {
         Canvas.startWaitCancelDlg(T.b);
         ParkService.a().b(h.IDDB);
      }

   }

   public static void b(int var0, int var1) {
      if (var0 != GameMidlet.avatar.IDDB) {
         Avatar var2;
         SeriPart var3;
         if ((var2 = LoadMap.g(var0)) != null && (var3 = AvatarData.getSeriByIdPart(var2.seriPart, var1)) != null) {
            var2.seriPart.removeElement(var3);
         }

      }
   }

   public final void a(int[] var1) {
      class_hk.b().a(var1);
      class_hk.b().a((MyScreen)this);
   }

   public final void a(Vector var1) {
      GameMidlet.k = var1;
      if (MenuCenter.gI().c) {
         MenuCenter.gI();
         MenuCenter.g();
      } else {
         this.q();
      }
   }

   public static void a(int var0, short var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         if (AvatarData.getPart(var1).zOrder == -1) {
            if (var2.idPet == var1) {
               Pet var3;
               if ((var3 = LoadMap.h(var2.IDDB)) != null) {
                  LoadMap.playerLists.removeElement(var3);
                  var2.idPet = -1;
               }
            } else {
               var2.changePet(var1);
               AvatarService.gI().doRequestExpicePet(var2.IDDB);
            }
         } else {
            SeriPart var4;
            if ((var4 = AvatarData.getSeriByIdPart(var2.seriPart, var1)) != null) {
               var2.seriPart.removeElement(var4);
            } else {
               var2.addSeriPart(new SeriPart(var1));
               var2.orderSeriesPath();
            }
         }

         if (var0 == GameMidlet.avatar.IDDB) {
            if (Canvas.currentMyScreen == PopupShop.b()) {
               PopupShop.b().close();
            }

            GameMidlet.k = null;
            Canvas.endDlg();
         }

         r = false;
      }
   }

   public final Command a(Vector var1, int var2, int var3, boolean var4) {
      Command var5 = new Command(T.bJ, new class_eh(this, var1, var2, var3));
      return var4 ? new Command(T.c, new class_ee(this, var5)) : var5;
   }

   protected final void q() {
      Avatar var1 = GameMidlet.avatar;
      if (Canvas.currentMyScreen != MenuCenter.a) {
         PopupShop.b().m = true;
         PopupShop.b().a(new String[]{T.co, T.l}, new Vector[]{this.a(GameMidlet.k, var1.IDDB, 1), this.a((Avatar)var1, 0)}, (Vector)null);
         PopupShop.b().a(this.a(var1.seriPart, 0, 0, false), 1);
         PopupShop.b().a(this.a(GameMidlet.k, 1, 0, true), 0);
         if (Canvas.currentMyScreen != PopupShop.b()) {
            PopupShop.b().switchToMe();
         }

      }
   }

   public final Vector a(Avatar var1, int var2) {
      Avatar var6;
      (var6 = new Avatar()).name = var1.name;
      var6.setMoney(var1.getMoney());
      var6.IDDB = var1.IDDB;
      var6.idPet = var1.idPet;
      var6.hungerPet = var1.hungerPet;

      for(int var3 = 0; var3 < var1.seriPart.size(); ++var3) {
         SeriPart var4;
         Part var5;
         if ((var5 = AvatarData.getPart((var4 = (SeriPart)var1.seriPart.elementAt(var3)).idPart)) != null && var5.zOrder != 30 && var5.zOrder != 40) {
            var6.addSeri(var4);
         }
      }

      if (var6.idPet != -1) {
         SeriPart var7;
         (var7 = new SeriPart(var6.idPet)).b = (byte)(100 - var6.hungerPet);
         var6.seriPart.addElement(var7);
      }

      new Vector();
      return this.a(var6.seriPart, var6.IDDB, 0);
   }

   public final Vector a(Vector var1, int var2, int var3) {
      Vector var4 = new Vector();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         SeriPart var7;
         Part var8 = AvatarData.getPart((var7 = (SeriPart)var1.elementAt(var5)).idPart);
         String var9 = null;
         if (var2 == GameMidlet.avatar.IDDB && (!AvatarData.isZOrderMain((int)var8.zOrder) || var3 != 0)) {
            if (var3 == 1) {
               var9 = T.cs;
            } else {
               var9 = T.cq;
            }
         }

         class_fz var6 = new class_fz(this, var9, new class_gf(this, var7, var2, var3, var5), var7, var5, var3);
         var4.addElement(var6);
      }

      return var4;
   }

   private Command b(class_kp var1) {
      return new class_fk(this, (String)null, (IAction)null, var1);
   }

   public final void a(class_kp var1) {
      Vector var2;
      (var2 = new Vector()).addElement(this.b(var1));
      PopupShop.b().m = true;
      PopupShop.b().a(new String[]{T.by}, new Vector[1], var2);
      if (Canvas.currentMyScreen != PopupShop.b()) {
         PopupShop.b().switchToMe();
      }

   }

   public static void a(Graphics var0, String var1, int var2, int var3, int var4) {
      var0.drawImage(k, var2, var3 + 2, 17);
      int var5 = k.getWidth() - 4 * AvMain.hd;
      int var6;
      if ((var6 = var4 * var5 / 100) > var5) {
         var6 = var5;
      }

      if (var6 < 0) {
         var6 = 0;
      }

      Canvas.fontChatB.drawString(var0, var1, var2 - 32 * AvMain.hd, var3 + 4 * AvMain.hd - AvMain.af / 2, 1);
      PaintPopup.a(var5 = var2 - 27 * AvMain.hd, var3 + 4 * AvMain.hd - 1, var6, 4 * AvMain.hd, 47084, var0);
      PaintPopup.a(var5, var3 + 5 * AvMain.hd - 1, var6, 1 * AvMain.hd, 8575990, var0);
      PaintPopup.a(var5 + var6, var3 + 4 * AvMain.hd - 1, 1, 4 * AvMain.hd, 13379, var0);
      if (!var1.equals("")) {
         Canvas.fontChatB.drawString(var0, String.valueOf(var4), var2 + 29 * AvMain.hd + Canvas.fontChatB.getWidth("100"), var3 + 4 * AvMain.hd - AvMain.af / 2, 1);
      }

   }

   public static String r() {
      return T.aJ + ": " + Canvas.getMoneys(GameMidlet.avatar.money[0]) + T.T;
   }

   private static void f(int var0, int var1) {
      if (var0 != var1) {
         Canvas.a((var1 - var0 > 0 ? "+" : "") + (var1 - var0), GameMidlet.avatar.x, GameMidlet.avatar.y - 40, -1, 0, -1);
      }

   }

   public final void a(int var1, class_kp var2, Avatar var3, String var4, short var5, byte var6, byte var7, String var8, short var9, String var10) {
      if (var1 == GameMidlet.avatar.IDDB) {
         f(GameMidlet.j.g, var2.g);
         f(GameMidlet.j.a, var2.a);
         f(GameMidlet.j.b, var2.b);
         f(GameMidlet.j.e, var2.e);
         f(GameMidlet.j.c, var2.c);
         f(GameMidlet.j.d, var2.d);
         GameMidlet.j = var2;
      }

      Canvas.endDlg();
      Avatar var19;
      if ((var19 = LoadMap.g(var1)) != null && x) {
         x = false;
         String var11 = var10;
         short var26 = var9;
         String var25 = var8;
         byte var24 = var7;
         var7 = (byte)var6;
         var6 = (byte) var5;
         String var23 = var4;
         Avatar var22 = var3;
         class_kp var21 = var2;
         Object var20 = var19;
         Vector var12 = new Vector();
         if (var19.IDDB != GameMidlet.avatar.IDDB) {
            var12 = this.a((Avatar)var19, 0);
         }

         Vector var13 = new Vector();
         String var16 = T.aJ + ": " + Canvas.getPriceMoney(GameMidlet.avatar.money[0], GameMidlet.avatar.money[2], GameMidlet.avatar.luongKhoa, true);
         StringObj var17 = new StringObj(var16, Canvas.fontChatB.getWidth(var16));
         Pet var18 = LoadMap.h(var19.IDDB);
         class_fj var15 = new class_fj((String)null, (IAction)null, var19, var18, var17);
         var19.direct = 0;
         var13.addElement(var15);
         if (var22 != null) {
            var22.idWedding = var19.idWedding;
            var20 = new class_fm(this, "", (IAction)null, var23, var19, var22, var6, var7, var24, var25);
            var13.addElement(var20);
         }

         if (GameMidlet.avatar.IDDB != ((Base)var20).IDDB) {
            var13.addElement(this.b(var21));
         }

         if (Canvas.currentMyScreen != MenuCenter.a) {
            PopupShop.b().m = true;
            if (GameMidlet.avatar.IDDB == ((Base)var20).IDDB) {
               if (var22 != null) {
                  PopupShop.b().a(new String[]{T.by, T.a}, new Vector[2], var13);
                  if (var26 != -1) {
                     PopupShop.b().a(new Command(var11, new class_fv(this, var26)), 1);
                  }
               } else {
                  PopupShop.b().a(new String[]{T.by}, new Vector[1], var13);
               }
            } else if (var22 != null) {
               PopupShop.b().a(new String[]{T.by, T.a, T.cd, T.by}, new Vector[]{null, null, null, var12}, var13);
               if (var26 != -1) {
                  PopupShop.b().a(new Command(var11, new class_fo(this, var26)), 1);
               }
            } else {
               PopupShop.b().a(new String[]{T.by, T.cd, T.by}, new Vector[]{null, null, var12}, var13);
            }

            if (Canvas.currentMyScreen != PopupShop.b()) {
               PopupShop.b().switchToMe();
            }
         }
      }

   }

   public final void a(String var1, int var2) {
      Vector var3 = new Vector();

      for(int var4 = 0; var4 < AvatarData.listItemInfo.size(); ++var4) {
         Item var5;
         if ((var5 = (Item)AvatarData.listItemInfo.elementAt(var4)).shopType == var2) {
            var3.addElement(var5);
         }
      }

      Vector var8 = new Vector();

      for(int var9 = 0; var9 < var3.size(); ++var9) {
         Item var6 = (Item)var3.elementAt(var9);
         CommandIceDream var7 = new CommandIceDream(this, T.Z, new class_fg(this, var6), var6, var9);
         var8.addElement(var7);
      }

      PopupShop.b().switchToMe();
      PopupShop.b().a(new String[]{var1}, new Vector[]{var8}, (Vector)null);
   }

   protected final void a(Item var1) {
      Canvas.startOKDlg(T.aF, (IAction)(new class_fc(this, var1)));
   }

   public static void a(short var0, int var1) {
      Canvas.endDlg();
      PopupShop.isTransFocus = true;
      Item var2;
      if ((var2 = Item.a(AvatarData.listItemInfo, var0)) != null) {
         if (var2.shopType == 5) {
            AvatarService.gI().doRequestExpicePet(GameMidlet.avatar.IDDB);
         }

         GameMidlet.avatar.setMoney(var1);
      }

   }

   public final void a(byte var1, int var2, String var3, short[] var4, int var5, String[] var6) {
      if (Canvas.currentMyScreen != PopupShop.b()) {
         d(GameMidlet.avatar);
         if (var2 == 26) {
            if (h == null) {
               return;
            }

            d(h);
         } else {
            d(GameMidlet.avatar);
         }

         Vector var7 = new Vector();
         if (var1 == 0) {
            if (var4 != null && var4.length != 0) {
               for(var1 = 0; var1 < var4.length; ++var1) {
                  var7.addElement(AvatarData.getPart(var4[var1]));
               }
            } else {
               for(var1 = 0; var1 < AvatarData.listPart.length; ++var1) {
                  Part var8;
                  if ((var8 = AvatarData.listPart[var1]) != null && (var8.i[0] > 0 || var8.i[1] > 0) && var2 == var8.k) {
                     var7.addElement(var8);
                  }
               }
            }

            String var11;
            int var19;
            if (var2 == 26) {
               Vector[] var14 = new Vector[6];

               for(var19 = 0; var19 < 6; ++var19) {
                  var14[var19] = new Vector();
               }

               int[] var21 = new int[6];

               int var20;
               for(var20 = 0; var20 < var7.size(); ++var20) {
                  Part var23 = (Part)var7.elementAt(var20);
                  var11 = "";
                  if (var6 != null && var6.length > 0) {
                     var11 = var6[var20];
                  }

                  var3 = "Tặng";
                  int var10002;
                  if (var23.zOrder == 20) {
                     var14[0].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[0]), var23, var4 != null ? var4[var20] : -1, var21[0], var5, var2));
                     var10002 = var21[0]++;
                  } else if (var23.zOrder == 10) {
                     var14[1].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[1]), var23, var4 != null ? var4[var20] : -1, var21[1], var5, var2));
                     var10002 = var21[1]++;
                  } else if (var23.zOrder != 52 && var23.zOrder != 53 && var23.zOrder != 5) {
                     if (var23.zOrder == 60) {
                        var14[3].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[3]), var23, var4 != null ? var4[var20] : -1, var21[3], var5, var2));
                        var10002 = var21[3]++;
                     } else if (var23.zOrder == 70) {
                        var14[4].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[4]), var23, var4 != null ? var4[var20] : -1, var21[4], var5, var2));
                        var10002 = var21[4]++;
                     } else {
                        var14[5].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[5]), var23, var4 != null ? var4[var20] : -1, var21[5], var5, var2));
                        var10002 = var21[5]++;
                     }
                  } else {
                     var14[2].addElement(new class_jx(this, var3, new class_gt(this, var23, var4 != null ? var4[var20] : -1, var2, var11, var5, var21[2]), var23, var4 != null ? var4[var20] : -1, var21[2], var5, var2));
                     var10002 = var21[2]++;
                  }
               }

               var20 = 0;

               for(int var24 = 0; var24 < var14.length; ++var24) {
                  if (var14[var24].size() > 0) {
                     ++var20;
                  }
               }

               String[] var25 = new String[]{"Áo", "Quần", "Trang sức", "Nón", "Cầm tay", "Khác"};
               byte[] var26 = new byte[]{0, 1, 2, 3, 4, 5};
               Vector[] var15 = new Vector[var20];
               byte[] var12 = new byte[var20];
               String[] var16 = new String[var20];
               var5 = 0;
               int var17 = 0;

               while(true) {
                  if (var17 >= var14.length) {
                     PopupShop.b().switchToMe();
                     PopupShop.o = true;
                     PopupShop.b().a(var16, var15, (Vector)null);
                     break;
                  }

                  if (var14[var17].size() > 0 || var17 == 5) {
                     if (var17 == 5) {
                        int var18 = var14[5].size();

                        for(var19 = 0; var19 < q.size(); ++var19) {
                           class_km var22 = (class_km)q.elementAt(var19);
                           var14[5].addElement(new class_ey(this, T.bS, new class_ku(this, var19, var22.a), var19, var22, var18));
                        }
                     }

                     var15[var5] = var14[var17];
                     var12[var5] = var26[var17];
                     var16[var5] = var25[var17];
                     ++var5;
                  }

                  ++var17;
               }
            } else {
               Vector var13 = new Vector();

               for(var19 = 0; var19 < var7.size(); ++var19) {
                  Part var9 = (Part)var7.elementAt(var19);
                  String var10 = "";
                  if (var6 != null && var6.length > 0) {
                     var10 = var6[var19];
                  }

                  if (var2 == 100) {
                     var11 = T.cO;
                  } else if (var2 == 26) {
                     var11 = "Tặng";
                  } else {
                     var11 = T.Z;
                  }

                  var13.addElement(new class_jx(this, var11, new class_gt(this, var9, var4 != null ? var4[var19] : -1, var2, var10, var5, var19), var9, var4 != null ? var4[var19] : -1, var19, var5, var2));
               }

               if (var13.size() > 0) {
                  PopupShop.b().switchToMe();
                  PopupShop.o = true;
                  PopupShop.b().a(new String[]{var3}, new Vector[]{var13}, (Vector)null);
               }
            }

            Canvas.endDlg();
         }

      }
   }

   public static void b(int var0, byte var1) {
      if (var0 == GameMidlet.avatar.IDDB) {
         GameMidlet.avatar.hungerPet = var1;
      } else {
         Avatar var2;
         if ((var2 = LoadMap.g(var0)) != null) {
            var2.hungerPet = var1;
         }

      }
   }

   public final void a(int var1, int var2, String var3, String[] var4) {
      Vector var5 = new Vector();

      for(int var6 = 0; var6 < var4.length; ++var6) {
         var5.addElement(new Command(var4[var6], new class_ac(this, var1, var2, var6)));
      }

      Canvas.a(var3, var5);
   }

   public static void b(int var0, short var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         var2.idImg = var1;
      }

   }

   private void b(String var1) {
      this.M.addElement(var1);
      if (this.N == 0) {
         this.N = this.O;
      }

   }

   public final void b(Vector var1) {
      if (var1.size() != 0) {
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < var1.size(); ++var3) {
            StringObj var4 = (StringObj)var1.elementAt(var3);
            var2.addElement(new class_y(this, var4.a, new IActionExchange(this, var4), var4));
         }

         MenuCenter.gI().a(var2);
      }
   }

   public static void a(byte var0, int var1, short var2, int var3, short var4, short var5) {
      Drop_Part var6;
      (var6 = new Drop_Part(var0, var2, var3)).startDropFrom(var1, var4, var5);
      LoadMap.playerLists.addElement(var6);
      LoadMap.a(LoadMap.treeLists);
   }

   public static void c(int var0, int var1) {
      var0 = var0;
      int var2 = 0;

      Drop_Part var10000;
      while(true) {
         if (var2 >= LoadMap.playerLists.size()) {
            var10000 = null;
            break;
         }

         MyObject var3;
         Drop_Part var5;
         if ((var3 = (MyObject)LoadMap.playerLists.elementAt(var2)).catagory == 5 && (var5 = (Drop_Part)var3).ID == var0) {
            var10000 = var5;
            break;
         }

         ++var2;
      }

      Drop_Part var4 = var10000;
      if (var10000 != null) {
         var4.startFlyTo(var1);
      }

   }

   public static void a(EffectManager var0) {
      if (LoadMap.x == null) {
         LoadMap.x = new Vector();
      }

      LoadMap.x.addElement(var0);
   }

   public static void a(int var0, Vector var1) {
      Avatar var2;
      if ((var2 = LoadMap.g(var0)) != null) {
         var2.emotionList = var1;
         var2.as = 0;
      }

   }

   public final void s() {
      if (this.y) {
         this.y = true;
         Canvas.startWaitDlg();
         if (MiniMap.gI().e == 2) {
            GlobalService.gI().c((byte)-1);
         } else {
            byte[] var1 = new byte[]{0, 13, 20, 9, 23, 11, 17};
            ParkService.a().a(var1[MiniMap.gI().e], -1);
         }
      }
   }

   public final void joinCitymap() {
      if (GameMidlet.avatar.gender == 0) {
         if (!GlobalLogicHandler.isNewVersion) {
            RegisterScr.b().switchToMe();
            Canvas.endDlg();
         }
      } else {
         if (Canvas.currentMyScreen != MessageScr.me && Canvas.currentMyScreen != OptionScr.a) {
            Canvas.load = 0;
         }

         if (!this.y) {
            GlobalService.gI().getHandler((int)9);
            GlobalService.gI().c((byte)0);
         } else {
            int var1 = 16 * AvMain.hd;
            LoadMap.y = -1;
            FilePack.b(T.aw);
            FrameImage var10 = FrameImage.init("ct", var1, var1);
            FilePack.reset();
            Vector var2 = new Vector();
            byte[] var3 = new byte[884];
            int var4 = 0;
            InputStream var5 = CRes.getResourceAsStream(T.a() + "/citiMap");

            try {
               for(int var6 = 0; var6 < 26; ++var6) {
                  for(int var7 = 0; var7 < 34; ++var7) {
                     var3[var6 * 34 + var7] = (byte)var5.read();
                     if (var3[var6 * 34 + var7] == 69) {
                        class_kb var8;
                        (var8 = new class_kb()).a = (byte)var7;
                        var8.b = (byte)var6;
                        var8.d = (short)(var4 + 819);
                        var8.c = T.nameRegion[var4];
                        var2.addElement(var8);
                        ++var4;
                     }
                  }
               }

               var5.close();
            } catch (IOException var9) {
               var9.printStackTrace();
            }

            LoadMap.TYPEMAP = -1;
            MiniMap.j = true;
            MiniMap.gI().a(var10, var3, var2, (byte)34, 16 * AvMain.hd, new Command(T.O, new ISelectMiniMapAction(this)));
            MiniMap.gI().h = new IActionMiniMapKey(this);
            MiniMap.gI().e = 3;
            MiniMap.gI().switchToMe();
            Canvas.endDlg();
            if (MiniMap.n != null && MiniMap.o == 0 && !Canvas.isDoubleImage) {
               MiniMap.n.perform();
               MiniMap.o = 1;
            }

         }
      }
   }

   protected final void u() {
      TField[] var1 = new TField[3];

      for(int var2 = 0; var2 < 3; ++var2) {
         var1[var2] = new TField();
         var1[var2].d(2);
      }

      var1[0].a(true);
      Command var3 = new Command(T.cy, new class_m(this, var1));
      InputFace.b().a(var1, T.cx, T.eF, var3);
      Canvas.currentFace = InputFace.b();
   }

   public static boolean a(TField[] var0) {
      int var1 = -1;

      for(int var2 = 0; var2 < 3; ++var2) {
         if (var0[var2].f().equals("")) {
            var1 = var2;
         }
      }

      if (!var0[1].f().equals(var0[2].f())) {
         var1 = 3;
      }

      if (var0[0].f().equals(var0[1].f())) {
         var1 = 4;
      }

      if (var1 != -1) {
         Canvas.startOKDlg(T.er[var1]);
         return false;
      } else {
         return true;
      }
   }

   public static void a(byte[] var0, byte var1, byte var2, byte var3, Image var4, short[] var5, Vector var6, Vector var7) {
      B = var5;
      Canvas.load = 0;
      b = var1;
      LoadMap.F = var6;
      LoadMap.G = var7;
      ByteArrayInputStream var11 = new ByteArrayInputStream(var0);
      LoadMap.map = new short[var0.length];
      LoadMap.wMap = var3;
      LoadMap.Hmap = (short)(var0.length / var3);
      LoadMap.b = var4;
      if (var4 != null) {
         int[] var9 = new int[4];
         var4.getRGB(var9, 0, 2, 0, 0, 2, 2);
         LoadMap.s = var9[0];
      }

      try {
         for(int var10 = 0; var10 < LoadMap.map.length; ++var10) {
            LoadMap.map[var10] = (short)var11.read();
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      if (var2 != LoadMap.y) {
         GlobalService.gI().d(var2);
      } else {
         Canvas.loadMap.e();
      }
   }

   public final void v() {
      Canvas.startOKDlg(T.P, (IAction)(new class_l(this)));
   }

   public static void w() {
      if (GameMidlet.avatar.seriPart != null) {
         GameMidlet.avatar.seriPart.removeAllElements();
      }

      LoadMap.t = -1;
      LoadMap.c = null;
      LoadMap.i = 24;
      Session_ME.a().c();
      LoginScr.gI().switchToMe();
      LoginScr.gI().e();
      OnScreen.b = false;
      OnScreen.c = 0;
      ListScr.d = null;
      LoadMap.playerLists.removeAllElements();
      GameMidlet.avatar = new Avatar();
      GameMidlet.j = new class_kp();
      Canvas.listInfoSV.removeAllElements();
      GlobalMessageHandler.gI().miniGameMessageHandler = null;
   }

   public final void commandActionPointer(int var1, int var2) {
      switch (var1) {
         case 0:
            AvatarService.gI().doJoinHouse(GameMidlet.avatar.IDDB);
            Canvas.startWaitDlg();
            return;
         case 1:
            HouseScr.b().e();
            return;
         case 2:
            GlobalService.gI().h(var2);
            return;
         case 3:
            gI().b(GameMidlet.avatar, 0);
            return;
         case 4:
            gI().b(GameMidlet.avatar, 1);
         default:
      }
   }

   public static void g(int var0) {
      HouseScr.b().c = (byte)var0;
      if (GameMidlet.avatar.typeHome != var0 && GameMidlet.avatar.typeHome != -1) {
         HouseScr.b().e();
      } else {
         Vector var1;
         (var1 = new Vector()).addElement(new Command(T.df, 0));
         var1.addElement(new Command(T.dg, 1));
         MenuSub.gI().startAt(var1, 2);
      }
   }

   public static void d(Avatar var0) {
      (C = new Avatar()).seriPart = new Vector();
      C.direct = 0;
      C.gender = var0.gender;
      C.lvMain = var0.lvMain;

      for(int var1 = 0; var1 < var0.seriPart.size(); ++var1) {
         SeriPart var2;
         (var2 = new SeriPart()).idPart = ((SeriPart)var0.seriPart.elementAt(var1)).idPart;
         C.addSeri(var2);
      }

   }

   private void b(Avatar var1, int var2) {
      d(var1);
      byte[] var3 = null;
      byte[] var5 = new byte[2];
      if (g == 3) {
         var5[0] = 3;
         var5[1] = 8;
      }

      System.out.println("typeJoin: " + g);
      byte[] var4;
      Vector[] var6;
      String[] var7;
      switch (g) {
         case 1:
         case 6:
            var3 = new byte[]{10, 20};
            (var6 = new Vector[2])[0] = new Vector();
            var6[1] = new Vector();
            (var7 = new String[2])[0] = T.aB;
            var7[1] = T.aC;
            var5[0] = 1;
            var5[1] = 6;
            var4 = new byte[2];
            break;
         case 2:
         case 7:
            var3 = new byte[]{40, 50};
            (var6 = new Vector[2])[0] = new Vector();
            var6[1] = new Vector();
            (var7 = new String[2])[0] = T.aE;
            var7[1] = T.aD;
            var4 = new byte[2];
            var5[0] = 2;
            var5[1] = 7;
            break;
         case 3:
         case 4:
         case 5:
         default:
            (var6 = new Vector[1])[0] = new Vector();
            (var7 = new String[1])[0] = T.dy;
            var4 = new byte[1];
      }

      for(int var8 = 0; var8 < AvatarData.listPart.length; ++var8) {
         if (AvatarData.listPart[var8].follow != -2) {
            Part var9;
            int var10;
            if ((var9 = AvatarData.listPart[var8]).follow >= 0) {
               var10 = ((APartInfo)AvatarData.listPart[var9.follow]).gender;
            } else {
               var10 = ((APartInfo)var9).gender;
            }

            if (var9 != null && (var9.i[0] > 0 || var9.i[1] > 0) && (var1.gender == var10 || var10 == 0) && (var5[0] == var9.k || var5[1] == var9.k) && var9.follow > -2) {
               if (var3 == null) {
                  byte var12 = var4[0];
                  var6[0].addElement(new class_i(this, T.O, new class_k(this, var9), var9, var12));
                  ++var4[0];
               } else {
                  for(var10 = 0; var10 < var6.length; ++var10) {
                     if (var3[var10] == var9.zOrder) {
                        byte var11 = var4[var10];
                        var6[var10].addElement(new class_e(this, T.O, new class_g(this, var9), var9, var11));
                        ++var4[var10];
                     }
                  }
               }
            }
         }
      }

      PopupShop.b().switchToMe();
      PopupShop.o = true;
      PopupShop.b().a(var7, var6, (Vector)null);
      PopupShop.g = var2;
      PopupShop.b().i();
      Canvas.endDlg();
      if (LoadMap.TYPEMAP == 57 && Canvas.isDoubleImage) {
         (Canvas.welcome = new Welcome()).b(PopupShop.me);
      }

   }

   public static void a(Part var0) {
      (C = new Avatar()).direct = 0;
      C.seriPart = new Vector();
      boolean var1 = false;

      for(int var2 = 0; var2 < GameMidlet.avatar.seriPart.size(); ++var2) {
         SeriPart var3;
         (var3 = new SeriPart()).idPart = ((SeriPart)GameMidlet.avatar.seriPart.elementAt(var2)).idPart;
         if (AvatarData.getPart(var3.idPart).zOrder == var0.zOrder) {
            var3.idPart = var0.IDPart;
            var1 = true;
         }

         C.addSeri(var3);
      }

      if (!var1) {
         SeriPart var5;
         (var5 = new SeriPart()).idPart = var0.IDPart;
         C.addSeri(var5);
         C.orderSeriesPath();
      }

   }

   public static void h(int var0) {
      b(AvatarData.getPart((short)var0));
   }

   public static void b(Part var0) {
      Canvas.a(var0.i[0], var0.i[1], new class_at(var0), new class_ar(var0), (IAction)null);
   }

   public static void a(short var0, String var1, int var2, int var3, int var4) {
      Canvas.startOKDlg(var1);
      GameMidlet.avatar.setMoney(var2);
      GameMidlet.avatar.setGold(var3);
      GameMidlet.avatar.luongKhoa = var4;
      Part var5;
      if ((var5 = AvatarData.getPart(var0)).follow != -2) {
         SeriPart var6;
         if ((var6 = AvatarData.getSeriByZ(var5.zOrder, GameMidlet.avatar.seriPart)) != null) {
            var6.idPart = var0;
         } else if (var5.zOrder == -1 && GameMidlet.avatar.idPet != -1) {
            GameMidlet.avatar.changePet(var0);
            AvatarService.gI().doRequestExpicePet(GameMidlet.avatar.IDDB);
         } else {
            GameMidlet.avatar.addSeri(new SeriPart(var0));
            GameMidlet.avatar.orderSeriesPath();
         }

         GameMidlet.avatar.setFeel(11);
         if (var5.zOrder == -1 && GameMidlet.avatar.idPet == -1) {
            GameMidlet.avatar.setPet();
            AvatarService.gI().doRequestExpicePet(GameMidlet.avatar.IDDB);
         }
      }

      GameMidlet.k = null;
   }

   public static void x() {
      ParkService.a().a(b, -1);
      g = -1;
   }

   public final void y() {
      this.commandActionPointer(3, -1);
   }

   public final void a(byte var1, Vector var2, Vector var3, Vector var4) {
      byte[] var5 = new byte[]{59, 60, 58, 104, 105, 101, 102};
      LoadMap.F = var3;
      LoadMap.G = var4;
      Canvas.loadMap.e(var5[var1]);
      if (var3 != null) {
         LoadMap.d();
      }

      for(int var6 = 0; var6 < var2.size(); ++var6) {
         MyObject var7;
         if ((var7 = (MyObject)var2.elementAt(var6)).catagory == 0) {
            Avatar var8;
            (var8 = (Avatar)var7).xCur = var8.x;
            var8.yCur = var8.y;
            var8.dirLast = var8.direct;
            var8.orderSeriesPath();
            if (var8.IDDB != GameMidlet.avatar.IDDB) {
               e(var8);
               LoadMap.b(var8);
            }
         } else if (var7.catagory == 5) {
            Drop_Part var9;
            (var9 = (Drop_Part)var7).x0 = var9.x;
            var9.y0 = var9.y;
            LoadMap.playerLists.addElement(var9);
         }
      }

      if (Bus.isRun) {
         doMove(Bus.posBusStop.x, Bus.posBusStop.y, GameMidlet.avatar.direct, GameMidlet.avatar.N);
      } else {
         ++GameMidlet.avatar.y;
         this.n();
      }

      b((int)GameMidlet.avatar.feel);
      if (Canvas.isDoubleImage && var5[var1] == 101) {
         (Canvas.welcome = new Welcome()).e();
      }

   }

   public static void i(int var0) {
      D = var0;
      G = LoadMap.TYPEMAP;
      gI().n();
      GlobalService.gI().getHandler((int)8);
      Canvas.startWaitDlg();
   }

   public final void e(int var1, int var2) {
      if (Canvas.currentMyScreen == PopupShop.me) {
         PopupShop.b().close();
      }

      System.out.println("onWeddingStart 1111111111111");
      Canvas.load = 1;
      E = var1;
      F = var2;
      t = true;
      this.K = 0;

      int var3;
      int var5;
      for(var3 = 0; var3 < p.size() - 1; ++var3) {
         AvPosition var4 = (AvPosition)p.elementAt(var3);

         for(var5 = var3 + 1; var5 < p.size(); ++var5) {
            AvPosition var6 = (AvPosition)p.elementAt(var5);
            if (var4.index > var6.index) {
               p.setElementAt(var6, var3);
               p.setElementAt(var4, var5);
               var4 = var6;
            }
         }
      }

      MyObject var10;
      for(var3 = 0; var3 < LoadMap.playerLists.size() - 1; ++var3) {
         if ((var10 = (MyObject)LoadMap.playerLists.elementAt(var3)).catagory == 0) {
            for(var5 = var3 + 1; var5 < LoadMap.playerLists.size(); ++var5) {
               MyObject var14;
               if ((var14 = (MyObject)LoadMap.playerLists.elementAt(var5)).catagory == 0 && ((Avatar)var10).IDDB > ((Avatar)var14).IDDB) {
                  LoadMap.playerLists.setElementAt(var14, var3);
                  LoadMap.playerLists.setElementAt(var10, var5);
                  var10 = var14;
               }
            }
         }
      }

      for(var3 = 0; var3 < LoadMap.playerLists.size(); ++var3) {
         if ((var10 = (MyObject)LoadMap.playerLists.elementAt(var3)).catagory == 0) {
            Avatar var13;
            (var13 = (Avatar)var10).moveList.removeAllElements();
            if (var13.IDDB == var2) {
               var13.x = var13.xCur = 0;
               var13.y = var13.yCur = 8 * LoadMap.i + LoadMap.i / 2 - LoadMap.i / 2;
               var13.G = 2;
               this.K = 1;
               var13.addPart(2475, 20);
               var13.addPart(2476, 10);
               var13.addPart(300, 60);
               var13.addPart(302, 70);
               var13.orderSeriesPath();
            } else if (var13.IDDB == var1) {
               var13.x = var13.xCur = 0;
               var13.y = var13.yCur = 8 * LoadMap.i + LoadMap.i / 2 + LoadMap.i / 2;
               var13.G = 2;
               this.K = 1;
               var13.addPart(2477, 20);
               var13.addPart(2478, 10);
               var13.orderSeriesPath();
            }
         }
      }

      Avatar var11 = LoadMap.g(var1);
      Avatar var12 = LoadMap.g(var2);
      LoadMap.playerLists.removeElement(var11);
      LoadMap.playerLists.removeElement(var12);
      var5 = 0;

      for(int var15 = 0; var15 < LoadMap.playerLists.size(); ++var15) {
         MyObject var7;
         Avatar var8;
         if ((var7 = (MyObject)LoadMap.playerLists.elementAt(var15)).catagory == 0 && (var8 = (Avatar)var7).IDDB != -100) {
            AvPosition var9;
            Canvas.px = Canvas.pxLast = (var9 = (AvPosition)p.elementAt(var5 / 2)).x - AvCamera.gI().xCam + LoadMap.i / 2;
            Canvas.py = Canvas.pyLast = var9.y - AvCamera.gI().yCam + LoadMap.i / 2 + var15 % 2 * (LoadMap.i - 5);
            ++var5;
            var8.setPos(Canvas.px + AvCamera.gI().xCam, Canvas.py + AvCamera.gI().yCam);
         }
      }

      LoadMap.playerLists.addElement(var11);
      LoadMap.playerLists.addElement(var12);
      LoadMap.a(LoadMap.playerLists);
      Canvas.endDlg();
      System.out.println("onWeddingStart 2222222222222222222: " + t + "     " + this.K);
   }
}

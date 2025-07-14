package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public abstract class BoardScr extends MyScreen implements IChatable {
   public static BoardScr me;
   public static boolean isStartGame;
   public static boolean disableReady;
   public static boolean isGameEnd;
   public static Vector avatarInfos;
   public int currentPlayer;
   public int selectedCard;
   public static byte roomID;
   public static byte boardID;
   public static int ownerID;
   private static int money;
   public static byte indexOfMe;
   public static long dieTime;
   public static long currentTime;
   public static int interval;
   public static int notReadyDelay;
   public static int[] indexPlayer = new int[4];
   public int disCard = 10;
   public static int wCard;
   public static int hcard;
   public int B = -1;
   private static Command cmdMenu;
   private static Command cmdStart;
   public static Command cmdBack;
   public static Command cmdFire;
   private static Command cmdReady;
   public static Command cmdWaiting;
   private static Image[] imgReady;
   public static AvPosition[] posAvatar;
   private static Vector chatHistory = new Vector();
   public static Image imgBan;
   public static int numPlayer = 4;
   public static Vector listPosAvatar = new Vector();
   public static Vector listPosCasino = new Vector();
   private static ChatPopup chatPublic;

   public final void close() {
      this.doExit();
   }

   public void switchToMe() {
      Canvas.clearKeyPressed();
      super.switchToMe();
      me = this;
   }

   public BoardScr() {
      this.init();
      cmdMenu = new Command(T.c, 0);
      new Command(T.z, 1);
      cmdStart = new Command(T.n, 2);
      cmdBack = new Command(T.w, 3);
      cmdFire = new Command(T.A, 4);
      cmdReady = new Command(T.j, 5);
      cmdWaiting = new Command(T.b, 6);
   }

   public void init() {
      posAvatar = new AvPosition[]{new AvPosition(Canvas.hw, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.hw, Canvas.h - 28, 2), new AvPosition(Canvas.w - 13 * AvMain.hd, Canvas.hh - 20, 1)};
      if (Canvas.w < 200) {
         wCard = 26;
         hcard = 32;
         posAvatar = new AvPosition[]{new AvPosition(Canvas.hw, 30 + 23 * AvMain.hd, 2), new AvPosition(13 * AvMain.hd, Canvas.hh - 20, 0), new AvPosition(Canvas.hw, Canvas.q - Canvas.hTab - 5, 2), new AvPosition(Canvas.w - 13 * AvMain.hd, Canvas.hh - 20, 1)};
      } else {
         wCard = 54;
         hcard = 72;
      }

      if (AvMain.hd == 2) {
         wCard = 144;
         hcard = 194;
      }

      if (isStartGame || disableReady) {
         this.setPosPlaying();
      }

      MyScreen.an = null;
   }

   private void doCloseBoard() {
      chatHistory.removeAllElements();
      setPosCam();
      ReportDlg.a().b();
   }

   public final void closeBoard(String var1) {
      super.left = null;
      super.center = null;
      Canvas.startOK(var1, 50, (AvMain)null);
   }

   protected void doReady() {
      if (getAvatarByID(GameMidlet.avatar.IDDB).action != 1) {
         if (MapScr.isNewVersion && money > GameMidlet.avatar.money[3]) {
            BoardListOnScr.gI().setXeng();
         } else {
            boolean var1;
            if (var1 = !((Avatar) avatarInfos.elementAt(indexOfMe)).isReady) {
               notReadyDelay = 100;
            }

            setCmdWaiting();
            Canvas.startWaitDlg();
            CasinoService.gI().ready(var1);
         }
      }
   }

   public static void setCmdWaiting() {
      me.center = cmdWaiting;
      me.right = null;
   }

   protected void doFire() {
   }

   private static void doStartGame() {
      if (!isStartGame) {
         if (MapScr.isNewVersion && money > GameMidlet.avatar.money[3]) {
            BoardListOnScr.gI().setXeng();
         } else {
            int var0 = 0;
            int var1 = 0;

            for(int var2 = 0; var2 < numPlayer; ++var2) {
               Avatar var3;
               if ((var3 = (Avatar) avatarInfos.elementAt(var2)).IDDB != GameMidlet.avatar.IDDB && var3.IDDB != -1) {
                  if (var3.isReady) {
                     ++var0;
                  } else {
                     ++var1;
                  }
               }
            }

            if (var0 != 0 && var1 <= 0) {
               if (me == PBoardScr.a) {
                  me.center = cmdWaiting;
                  me.right = null;
               } else {
                  Canvas.startWaitDlg();
               }

               MyScreen.repaint();
               CasinoService.gI().h();
            } else {
               Canvas.startOKDlg(T.aT);
            }
         }
      }
   }

   public final void commandActionPointer(int var1, int var2) {
      Avatar var5;
      switch (var1) {
         case 1:
            Vector var6 = new Vector();
            Command var7 = new Command(T.r, 10);
            Command var3 = new Command(T.s, 11);
            Command var4 = new Command(T.t, 12);
            var6.addElement(var7);
            if (LoadMap.TYPEMAP == 61) {
               var6.addElement(var3);
            }

            var6.addElement(var4);
            MenuSub.a().a(var6, 0);
            return;
         case 2:
            doKick();
            return;
         case 3:
            doAddFriend();
            return;
         case 4:
            MessageScr.gI().a((MyScreen) me);
            return;
         case 5:
            this.doExit();
            return;
         case 6:
         case 7:
         case 8:
         case 9:
         default:
            break;
         case 10:
            Canvas.inputDlg.a(T.G, 100, 1);
            return;
         case 11:
            doSetMaxPlayer();
            return;
         case 12:
            Canvas.inputDlg.a(T.t, 101, 3);
            return;
         case 13:
            if (var2 < avatarInfos.size()) {
               var5 = (Avatar) avatarInfos.elementAt(var2);
               MapScr.gI();
               MapScr.c(var5);
               return;
            }
            break;
         case 14:
            if (var2 >= 0 && var2 < avatarInfos.size()) {
               var5 = (Avatar) avatarInfos.elementAt(var2);
               CasinoService.gI().c(var5.IDDB);
               return;
            }
            break;
         case 15:
            CasinoService.gI().a(var2 + 2);
      }

   }

   protected void resetCard() {
      currentTime = 0L;
      dieTime = 0L;
      isStartGame = false;
      disableReady = false;
      isGameEnd = false;
   }

   private static void setPosCam() {
      AvCamera.gI().yCam = AvCamera.gI().yTo = (LoadMap.Hmap * LoadMap.i * AvMain.hd - Canvas.h) / 2;
      AvCamera.gI().xCam = AvCamera.gI().xTo = (LoadMap.wMap * LoadMap.i * AvMain.hd - Canvas.w) / 2;
   }

   public final void loadMap() {
      this.setPosPlaying();
   }

   public final void setAt(int var1, Avatar var2) {
      avatarInfos.setElementAt(var2, var1);
      this.onStartGame();
      this.setPosPlaying();
   }

   public void doContinue() {
      setPosCam();
      MyScreen.repaint();
   }

   public void updateKey() {
      if (Canvas.stypeInt != 0) {
         Canvas.paint.a(super.left, super.center, super.right);
      } else {
         super.updateKey();
      }
   }

   public void update() {
      if (notReadyDelay > 0) {
         --notReadyDelay;
      }

      if (!isStartGame) {
         super.left = cmdMenu;
         AvCamera.gI().updateTo();
      }

      for(int var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB != -1) {
            var2.updateFrame();
         }
      }

      if (chatPublic != null && chatPublic.a()) {
         chatPublic = null;
      }

   }

   public final void updateReady() {
      if (ownerID == GameMidlet.avatar.IDDB) {
         if (super.center != cmdWaiting) {
            super.center = cmdStart;
            cmdStart.caption = T.n;
         }

         boolean var1 = true;

         for(int var2 = 0; var2 < numPlayer; ++var2) {
            Avatar var3;
            if ((var3 = (Avatar) avatarInfos.elementAt(var2)).IDDB == -1) {
               var1 = false;
            } else if (var3.IDDB != GameMidlet.avatar.IDDB && !var3.isReady) {
               var1 = false;
            }
         }

         if (var1 && Canvas.gameTick % 10 > 7) {
            cmdStart.caption = "";
            return;
         }
      } else if (!disableReady) {
         super.center = cmdReady;
         cmdReady.caption = T.j;

         for(int var4 = 0; var4 < numPlayer; ++var4) {
            Avatar var5;
            if ((var5 = (Avatar) avatarInfos.elementAt(var4)).IDDB == GameMidlet.avatar.IDDB) {
               if (!var5.isReady) {
                  if (Canvas.gameTick % 10 > 7) {
                     cmdReady.caption = "";
                  }
               } else {
                  cmdReady.caption = T.k;
                  if (notReadyDelay == 0) {
                     super.center = cmdReady;
                  } else {
                     super.center = null;
                  }
               }
            }
         }
      }

   }

   public final void keyPress(int var1) {
      ChatTextField.gI().startChat(var1, this);
      super.keyPress(var1);
   }

   public void paint(Graphics var1) {
      if (chatPublic != null) {
         chatPublic.paintAnimal(var1);
      }

      if (OnScreen.b) {
         OnScreen.a(var1, super.left, super.center, super.right);
      } else {
         super.paint(var1);
      }

      LoadMap.a(var1);
      Canvas.paintPlus2(var1);
   }

   public void paintNamePlayers(Graphics var1) {
      Canvas.resetTrans(var1);

      for(int var2 = 0; var2 < numPlayer; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar) avatarInfos.elementAt(var2)).IDDB != -1) {
            var3.paintName(var1, var3.x, var3.y);
            paintReady(var1, var3.x, var3.y - 50 - (!isStartGame && LoadMap.y == -1 ? 10 * AvMain.hd : 0), 3, var3);
            var3.paintIcon(var1, var3.x, var3.y, false);
         }
      }

   }

   public static void paintChat(Graphics var0) {
      for(int var1 = 0; var1 < avatarInfos.size(); ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB != -1 && var2.chat != null) {
            var2.chat.paintAnimal(var0);
         }
      }

   }

   public void paintMain(Graphics var1) {
      Canvas.resetTrans(var1);
      var1.setClip(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
      if (!isStartGame && !disableReady) {
         Canvas.resetTrans(var1);
         if (OnScreen.b) {
            paintBgOngame(var1);
         } else {
            var1.setClip(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
            var1.setColor(0);
            var1.fillRect(0, 0, Canvas.w, Canvas.h + Canvas.hTab);
            var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);
            Canvas.loadMap.c(var1);
            if (Canvas.w > 150) {
               Canvas.N.a(var1, RoomListOnScr.c, AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - AvMain.af - AvMain.af / 2 - 5, 2);
               Canvas.N.a(var1, "P: " + roomID + " - B: " + boardID, AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - AvMain.af / 2 - 5, 2);
               Canvas.smallFontYellow.a(var1, money + T.k(), AvCamera.gI().xCam + Canvas.hw, AvCamera.gI().yCam + Canvas.hh - 5 + AvMain.af / 2, 2);
               paintChat(var1);
            }

         }
      } else {
         paintBgOngame(var1);
      }
   }

   private static void paintBgOngame(Graphics var0) {
      Canvas.paint.paintDefaultBg(var0);
      if (!isStartGame) {
         Canvas.K.a(var0, "P: " + roomID + " - B: " + boardID, Canvas.hw, Canvas.h / 2 - 10 * AvMain.hd, 2);
         Canvas.smallFontYellow.a(var0, money + T.k(), Canvas.hw, Canvas.h / 2 + 10 * AvMain.hd, 2);
      } else {
         if (Canvas.currentMyScreen == DiamondScr.me_) {
            DiamondScr.me_.paintCaro(var0);
         }

      }
   }

   public static void paintReady(Graphics var0, int var1, int var2, int var3, Avatar var4) {
      if (!isStartGame) {
         if (var4.IDDB == ownerID) {
            var0.drawImage(imgReady[1], var1, var2, 3);
            return;
         }

         if (var4.isReady) {
            var0.drawImage(imgReady[0], var1, var2, 3);
         }
      }

   }

   private void doExit() {
      if (isStartGame && !disableReady && !isGameEnd) {
         Canvas.startOKDlg(T.cv, 0, this);
      } else {
         this.commandTab(0);
      }
   }

   public final void commandTab(int var1) {
      switch (var1) {
         case 0:
            Canvas.load = 0;
            this.resetCard();
            CasinoService.gI().g();
            CasinoService.gI().a(roomID);
            if (numPlayer == 2) {
               this.closeBoard("");
            }

            setPosCam();
            Canvas.startWaitDlg();
         default:
      }
   }

   public void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            Command var6 = new Command(T.ab, 1);
            Command var7 = new Command(T.v, 2);
            int var3 = 0;

            for(int var4 = 0; var4 < numPlayer; ++var4) {
               if (((Avatar) avatarInfos.elementAt(var4)).IDDB != -1) {
                  ++var3;
               }
            }

            Vector var8 = new Vector();
            if (ownerID == GameMidlet.avatar.IDDB && !isStartGame) {
               var8.addElement(var6);
               if (var3 > 1) {
                  var8.addElement(var7);
               }
            }

            if (var3 > 1) {
               var8.addElement(new Command(T.y, 3));
            }

            var8.addElement(new Command(T.q, 4));
            var8.addElement(new Command(T.u, 5));
            MenuSub.a().a(var8, 0);
            return;
         case 1:
            me.doCloseBoard();
            return;
         case 2:
            doStartGame();
            return;
         case 3:
            me.doContinue();
            return;
         case 4:
            me.doFire();
            return;
         case 5:
            me.doReady();
            return;
         case 6:
            return;
         case 50:
            this.doContinue();
            this.doCloseBoard();
            isStartGame = false;
            this.B = -1;
            interval = 0;
            return;
         case 100:
            try {
               if ((var1 = Integer.parseInt(Canvas.inputDlg.a())) < 0) {
                  return;
               } else {
                  Canvas.endDlg();
                  if (MapScr.isNewVersion && var1 > GameMidlet.avatar.money[3]) {
                     BoardListOnScr.gI().setXeng();
                     return;
                  }

                  CasinoService.gI().b(var1);
                  return;
               }
            } catch (Exception var5) {
               return;
            }
         case 101:
            CasinoService.gI().b(Canvas.inputDlg.a());
            Canvas.startOKDlg(T.I);
         default:
      }
   }

   private static void doSetMaxPlayer() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < 3; ++var1) {
         var0.addElement(new Command(T.ej[var1], 15, var1));
      }

      MenuSub.a().a(var0, 0);
   }

   private static void doKick() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB != GameMidlet.avatar.IDDB && var2.IDDB != -1) {
            var0.addElement(new Command(var2.showName, 14, var1));
         }
      }

      MenuSub.a().a(var0, 0);
   }

   private static void doAddFriend() {
      Vector var0 = new Vector();

      for(int var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB != GameMidlet.avatar.IDDB && var2.IDDB != -1) {
            var0.addElement(new Command(var2.name, 13, var1));
         }
      }

      if (var0.size() == 1) {
         ((Command)var0.elementAt(0)).b();
      }

      MenuSub.a().a(var0, 0);
   }

   public final void playerLeave(int var1) {
      Avatar var2;
      if ((var2 = getAvatarByID(var1)) != null) {
         addInfo(var2.name + T.aU, 30, var2.IDDB);
         var2.IDDB = -1;
         var2.setName("");
         var2.setExp(0);
         var2.isReady = false;
      }

      this.onStartGame();
      if (isStartGame || disableReady) {
         this.setPosPlaying();
      }

   }

   public static void setOwner(int var0) {
      ownerID = var0;
      Avatar var1;
      if ((var1 = getAvatarByID(var0)) != null) {
         var1.isReady = true;
      }

   }

   public void setPlayers(byte var1, byte var2, int var3, int var4, Vector var5) {
      if (imgReady == null) {
         imgReady = new Image[2];

         try {
            imgReady[0] = Image.createImage(T.a() + "/on/ready.on");
            imgReady[1] = Image.createImage(T.a() + "/on/owner.on");
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

      roomID = (byte)var1;
      boardID = var2;
      money = var4;
      if (avatarInfos != null) {
         avatarInfos.removeAllElements();
      }

      avatarInfos = var5;
      setOwner(var3);

      for(var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var8;
         (var8 = (Avatar) avatarInfos.elementAt(var1)).direct = 0;
         var8.setAction((byte)2);
         var8.setFrame(var8.action);
         if (var8.IDDB == GameMidlet.avatar.IDDB) {
            indexOfMe = (byte)var1;
            break;
         }
      }

      this.onStartGame();
      if (numPlayer > 2) {
         Canvas.paint.b();
      }

   }

   public static void resetReady() {
      for(int var0 = 0; var0 < numPlayer; ++var0) {
         ((Avatar) avatarInfos.elementAt(var0)).isReady = false;
      }

   }

   public final void setMoney(int var1) {
      money = var1;
      resetReady();
   }

   public static void setReady(int var0, boolean var1) {
      Avatar var2;
      if ((var2 = getAvatarByID(var0)) != null) {
         var2.isReady = var1;
      }

   }

   public final void onChatFromMe(String var1) {
      if (!var1.trim().equals("")) {
         CasinoService.gI().a(var1);
         showChat(GameMidlet.avatar.IDDB, var1);
      }
   }

   public static void showChat(int var0, String var1) {
      Avatar var3 = getAvatarByID(var0);
      Avatar var2 = new Avatar();
      if (var3 != null) {
         var2.x = var3.x;
         var2.y = var3.y;
         var2.IDDB = var3.IDDB;
         if (var2.IDDB != -1) {
            if (isStartGame && BoardListOnScr.e == 0) {
               var2.x = Canvas.hw;
               if (var2.IDDB != GameMidlet.avatar.IDDB) {
                  var2.y = 30;
               } else {
                  var2.y = Canvas.h - 40;
               }
            }

            addInfo(var1, 50, var2.IDDB);
         }

      }
   }

   public static void showFlyText(int var0, int var1) {
      if (var1 != 0) {
         if (!isStartGame) {
            var0 = getIndexByID(var0);
            Canvas.a(var1, posAvatar[indexPlayer[var0]].x, posAvatar[indexPlayer[var0]].y, -1, -1);
         } else {
            Avatar var2 = getAvatarByID(var0);
            Canvas.a(var1, var2.x, var2.y, -1, -1);
         }
      }
   }

   public static boolean setR_B(byte var0, byte var1) {
      return roomID == var0 && boardID == var1;
   }

   public final void start() {
      this.onStartGame();
   }

   public static void addInfo(String var0, int var1, int var2) {
      if (var2 == -1) {
         if (chatPublic == null) {
            (chatPublic = new ChatPopup(var1, var0, (byte)0)).setPos(Canvas.hw, Canvas.hh - 20);
         } else {
            chatPublic.a(var1, var0);
         }
      } else {
         for(int var3 = 0; var3 < avatarInfos.size(); ++var3) {
            Base var4;
            if ((var4 = (Base) avatarInfos.elementAt(var3)).IDDB == var2) {
               if (var4.chat == null) {
                  var4.chat = new ChatPopup(var1, var0, (byte)0);
                  var4.chat.setPos(var4.x, var4.y - 45);
               } else {
                  var4.chat.a(var1, var0);
               }
            }
         }

      }
   }

   public void onStartGame() {
      int var1 = 0;
      int var2 = 0;

      for(int var3 = 0; var3 < numPlayer; ++var3) {
         Avatar var4;
         (var4 = (Avatar) avatarInfos.elementAt(var3)).setAction((byte)0);
         if (var4.IDDB != -1) {
            ++var1;
            if (var4.IDDB != GameMidlet.avatar.IDDB) {
               var2 = var3;
            }
         }
      }

      int[] var5 = new int[numPlayer];
      int var6 = 2;
      if (var1 == 2) {
         var5[indexOfMe] = 2;
         var5[var2] = 0;
      } else {
         for(var1 = indexOfMe; var1 < indexOfMe + numPlayer; ++var1) {
            var2 = var1;
            if (var1 > numPlayer - 1) {
               var2 = var1 - numPlayer;
            }

            var5[var2] = var6++;
            if (var6 >= numPlayer) {
               var6 = 0;
            }
         }
      }

      indexPlayer = var5;
   }

   public static Avatar getAvatarByID(int var0) {
      for(int var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB == var0) {
            return var2;
         }
      }

      return null;
   }

   public static int getIndexByID(int var0) {
      for(int var1 = 0; var1 < numPlayer; ++var1) {
         if (((Avatar) avatarInfos.elementAt(var1)).IDDB == var0) {
            return var1;
         }
      }

      return -1;
   }

   public void setPosPlaying() {
      AvCamera.gI().setPos(0, 0);

      for(int var1 = 0; var1 < numPlayer; ++var1) {
         Avatar var2;
         if ((var2 = (Avatar) avatarInfos.elementAt(var1)).IDDB != -1) {
            var2.ySat = 0;
            var2.setAction((byte)0);
            var2.setFrame(var2.action);
            var2.xCur = var2.x = posAvatar[indexPlayer[var1]].x;
            var2.yCur = var2.y = posAvatar[indexPlayer[var1]].y;
            if (indexPlayer[var1] != 2 && indexPlayer[var1] != 3) {
               var2.direct = var2.dirLast = 0;
            } else {
               var2.direct = var2.dirLast = Base.LEFT;
            }
         }
      }

   }
}

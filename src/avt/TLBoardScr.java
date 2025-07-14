package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class TLBoardScr extends BoardScr {
   public static TLBoardScr a;
   private Vector c;
   private byte[] d;
   private byte e;
   private Vector f;
   private byte[] g;
   private byte h;
   private Vector K;
   private Command L;
   private Command M;
   private boolean N = false;
   private static int O;
   private static int P;
   private int Q = -1;
   private int R;
   private int S;
   private boolean T = false;
   private boolean U = false;
   private int V = 0;
   private boolean W = false;
   public boolean b = true;

   static {
      CRes.random.setSeed(System.currentTimeMillis());
   }

   public static TLBoardScr b() {
      return a == null ? (a = new TLBoardScr()) : a;
   }

   public final void resetCard() {
      System.out.println("resetCard");
      this.c = new Vector();
      this.e = -1;
      this.d = new byte[0];
      super.selectedCard = -1;
      this.g = new byte[0];
      this.h = -1;
      super.currentPlayer = -1;
      this.f = new Vector();
      super.resetCard();
   }

   private static void a(Vector var0) {
      int var1 = var0.size();

      for(int var2 = 0; var2 < var1 - 1; ++var2) {
         for(int var3 = var2 + 1; var3 < var1; ++var3) {
            Card var4 = (Card)var0.elementAt(var2);
            Card var5 = (Card)var0.elementAt(var3);
            if (var4.cardID > var5.cardID) {
               Object var7 = var0.elementAt(var3);
               var0.setElementAt(var0.elementAt(var2), var3);
               var0.setElementAt(var7, var2);
            }
         }
      }

   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 20:
            this.Q = -1;
            break;
         case 21:
            Canvas.b(avt.T.Q, 70);
            break;
         case 70:
            super.currentPlayer = -1;
            this.W = false;
            CasinoService.gI().e();
            Canvas.endDlg();
      }

      super.commandTab(var1, var2);
   }

   public TLBoardScr() {
      this.M = new Command(avt.T.F, 20);
      this.L = new Command(avt.T.B, 21);
      this.t();
   }

   private void t() {
      this.S = Canvas.h - Canvas.hTab;
      if (Canvas.w < 150) {
         O = 26;
         P = 32;
         this.S = Canvas.hCan - Canvas.hTab - 10;
      } else {
         O = 54;
         P = 72;
      }

      if (AvMain.hd == 2) {
         O = 144;
         P = 194;
      }

      String[] var10000 = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "Heo"};
   }

   public final void init() {
      super.init();
      this.t();
      if (BoardScr.isStartGame) {
         this.d(false);
      }

      this.c = null;
   }

   public final void doContinue() {
      this.resetCard();
      super.doContinue();
   }

   private void u() {
      ((Card)this.K.elementAt(super.selectedCard)).f = !((Card)this.K.elementAt(super.selectedCard)).f;
      this.g = this.v();
      this.h = CardUtils.getType(this.g);
      if (this.h != -1) {
         BoardScr.addInfo(avt.T.eE[this.h], 10, -1);
      }

      this.d(false);
   }

   protected final void doFire() {
      super.doFire();
      if (this.W) {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.g.length; ++var2) {
            if (this.g[var2] == 0) {
               var1 = true;
            }
         }

         if (!var1) {
            BoardScr.showChat(GameMidlet.avatar.IDDB, avt.T.R);
            return;
         }

         this.W = false;
      }

      if (this.c != null && this.c.size() != 0) {
         boolean var10000;
         label129: {
            byte var4 = this.e;
            byte[] var3 = this.d;
            byte var6 = this.h;
            byte[] var5 = this.g;
            switch (var4) {
               case -1:
                  if (var6 != -1) {
                     var10000 = true;
                     break label129;
                  }
               case 0:
                  if (var6 == 0 && var5[0] > var3[0]) {
                     var10000 = true;
                     break label129;
                  }

                  if (var3[0] / 4 != 12 || var6 != 4 && var6 != 5 && var6 != 6) {
                     break;
                  }

                  var10000 = true;
                  break label129;
               case 1:
                  if (var6 == 1 && var5.length == var3.length && var5[var5.length - 1] > var3[var3.length - 1]) {
                     var10000 = true;
                     break label129;
                  }
                  break;
               case 2:
                  if (var6 == 2 && var5[1] > var3[1]) {
                     var10000 = true;
                     break label129;
                  }

                  if (var3[0] / 4 != 12 || var6 != 6 && var6 != 5) {
                     break;
                  }

                  var10000 = true;
                  break label129;
               case 3:
                  if (var6 == 3 && var5[2] > var3[2]) {
                     var10000 = true;
                     break label129;
                  }
                  break;
               case 4:
                  if (var6 == 4 && var5[5] > var3[5] || var6 == 6 || var6 == 5) {
                     var10000 = true;
                     break label129;
                  }
                  break;
               case 5:
                  if (var6 == 5 && var5[7] > var3[7]) {
                     var10000 = true;
                     break label129;
                  }
                  break;
               case 6:
                  if (var6 == 6 && var5[3] > var3[3] || var6 == 5) {
                     var10000 = true;
                     break label129;
                  }
            }

            var10000 = false;
         }

         if (!var10000) {
            BoardScr.showChat(GameMidlet.avatar.IDDB, avt.T.S);
            return;
         }
      }

      CasinoService.gI().move(this.g);
      super.currentPlayer = -1;
      super.right = null;
   }

   private void c(boolean var1) {
      ((Card)this.K.elementAt(super.selectedCard)).f = var1;
      this.g = this.v();
      this.h = CardUtils.getType(this.g);
      this.d(false);
   }

   private void b(int var1) {
      if (this.Q == -1) {
         super.selectedCard += var1;
         if (super.selectedCard >= this.K.size()) {
            super.selectedCard = 0;
         }

         if (super.selectedCard < 0) {
            super.selectedCard = this.K.size() - 1;
            return;
         }
      } else {
         if (this.Q > 0 || this.Q < this.K.size() - 1) {
            Card var2 = (Card)this.K.elementAt(this.Q + var1);
            this.K.setElementAt(this.K.elementAt(this.Q), this.Q + var1);
            this.K.setElementAt(var2, this.Q);
            this.Q += var1;
            super.selectedCard = this.Q;
         }

         this.d(true);
      }

   }

   public final void updateKey() {
      super.updateKey();
      if (BoardScr.isStartGame) {
         int var1 = this.K.size();
         if (this.K != null && var1 > 0) {
            if (Canvas.isPointerClick && Canvas.isPointer(this.R - O / 2, this.S - P / 2 - 30, super.disCard * (var1 - 1) + O, P + 15)) {
               this.U = true;
               Canvas.isPointerClick = false;
               this.V = (Canvas.pxLast - (this.R - O / 2)) / super.disCard;
               this.T = true;
               super.selectedCard = this.V;
            }

            if (this.U) {
               var1 = Canvas.dx();
               int var2 = Canvas.dy();
               if (Canvas.isPointerDown) {
                  if (var2 > 10) {
                     this.c(true);
                  } else if (var2 < -10) {
                     this.c(false);
                  } else if (CRes.abs(var1) > 10) {
                     if (this.T) {
                        this.Q = super.selectedCard;
                     }

                     this.T = false;
                     int var3 = (Canvas.px - (this.R - O / 2)) / super.disCard;
                     if (super.selectedCard != var3) {
                        if (this.Q != -1) {
                           if (var3 < this.Q) {
                              this.b(-1);
                           } else if (var3 > this.Q) {
                              this.b(1);
                           }

                           super.selectedCard = this.Q;
                           this.T = true;
                           return;
                        }

                        this.T = false;
                     }

                     super.selectedCard = var3;
                     if (super.selectedCard < 0) {
                        super.selectedCard = 0;
                     }

                     if (super.selectedCard >= this.K.size()) {
                        super.selectedCard = this.K.size() - 1;
                     }

                     this.d(true);
                  }
               }

               if (Canvas.isPointerRelease) {
                  this.U = false;
                  this.Q = -1;
                  if (CRes.abs(var1) <= 10 && CRes.abs(var2) <= 10) {
                     this.c(!((Card)this.K.elementAt(super.selectedCard)).f);
                  }
               }
            }
         }

         if (Canvas.a(6)) {
            this.b(1);
         } else if (Canvas.a(4)) {
            this.b(-1);
         }

         if (Canvas.a(2)) {
            if (this.Q != -1) {
               this.Q = -1;
               this.d(true);
               return;
            }

            this.u();
            this.d(true);
         }

         if (Canvas.a(8)) {
            if (((Card)this.K.elementAt(super.selectedCard)).f) {
               this.u();
               this.d(true);
               return;
            }

            this.Q = super.selectedCard;
            this.d(true);
         }
      }

   }

   public final void update() {
      super.update();
      Card var2;
      int var3;
      if (BoardScr.isStartGame && this.K != null && this.K.size() > 0) {
         for(int var1 = this.K.size() - 1; var1 >= 0 && (var3 = (var2 = (Card)this.K.elementAt(var1)).translate()) != 1; --var1) {
            if (var3 == -1) {
               var2.g = false;
            }
         }
      }

      if (BoardScr.dieTime != 0L && (BoardScr.currentTime = System.currentTimeMillis()) > BoardScr.dieTime) {
         if (super.currentPlayer == GameMidlet.avatar.IDDB) {
            CasinoService.gI().e();
            super.currentPlayer = -1;
         }

         BoardScr.dieTime = 0L;
      }

      if (!BoardScr.isStartGame && !BoardScr.disableReady) {
         this.updateReady();
         super.right = null;
      } else if (this.Q != -1) {
         super.left = null;
         super.right = null;
         if (Canvas.stypeInt == 0) {
            super.center = this.M;
         }

      } else {
         if (BoardScr.isGameEnd) {
            super.left = null;
            super.center = BoardScr.cmdBack;
            super.right = null;
         } else if (super.currentPlayer == GameMidlet.avatar.IDDB) {
            super.right = this.L;
            if (this.v().length > 0) {
               if (this.h != -1) {
                  super.center = BoardScr.cmdFire;
               } else {
                  super.center = null;
               }
            } else {
               super.center = null;
            }
         } else {
            super.right = null;
            super.center = null;
         }

         TLBoardScr var4 = this;
         if (this.c != null && this.N) {
            for(int var5 = 0; var5 < var4.c.size(); ++var5) {
               Card var6;
               if ((var6 = (Card)var4.c.elementAt(var5)) != null) {
                  var3 = var6.translate();
                  if (var5 == var4.c.size() - 1 && var3 == 0) {
                     var4.N = false;
                  }
               }
            }
         }

      }
   }

   private void d(boolean var1) {
      int var2;
      if (this.K.size() > 0 && !var1) {
         var2 = 12;
         if (Canvas.isKeyBoard && (var2 = (Canvas.w - O / 2) / this.K.size()) > O / 3 << 1) {
            var2 = O / 3 << 1;
         }

         super.disCard = (Canvas.w - 60) / this.K.size() + 1;
         if (super.disCard > var2) {
            super.disCard = var2;
         }

         if (super.disCard < 9) {
            super.disCard = 9;
         }

         if (Canvas.isKeyBoard) {
            super.disCard = var2;
         }

         this.R = (Canvas.w - (super.disCard * this.K.size() + (O - super.disCard)) >> 1) + O / 2;
         if (this.R < O / 2) {
            this.R = O / 2;
         }
      }

      var2 = this.K.size();
      int var3 = this.R;

      for(int var4 = 0; var4 < var2; ++var4) {
         Card var5 = (Card)this.K.elementAt(var4);
         int var6 = 0;
         if (var5.f) {
            var6 = -8 * (Canvas.stypeInt + 1);
         }

         int var8 = this.S + var6;
         var5.xTo = var3;
         var5.yTo = var8;
         var5.distant = CRes.distance(var5.x, var5.y, var5.xTo, var5.yTo);
         if (var4 == this.Q && !Canvas.isKeyBoard) {
            var5.yTo += 8 * (Canvas.stypeInt + 1);
         }

         var3 += super.disCard;
         if (var1) {
            var5.x = var5.xTo;
            var5.y = var5.yTo;
         }
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      super.paint(var1);
   }

   public final void paintNamePlayers(Graphics var1) {
      for(int var2 = 0; var2 < BoardScr.numPlayer; ++var2) {
         Avatar var3;
         if ((var3 = (Avatar)BoardScr.avatarInfos.elementAt(var2)).IDDB != -1) {
            if (var3.IDDB != GameMidlet.avatar.IDDB || !BoardScr.isStartGame) {
               var3.paintIcon(var1, var3.x, var3.y, false);
            }

            var3.paintName(var1, var3.x, var3.y);
            BoardScr.paintReady(var1, var3.x, var3.y - 50, 3, var3);
         }
      }

   }

   public final void paintMain(Graphics var1) {
      super.paintMain(var1);
      this.paintNamePlayers(var1);
      if ((BoardScr.isStartGame || BoardScr.disableReady) && this.c != null && this.c.size() != 0) {
         Graphics var5 = var1;
         TLBoardScr var4 = this;
         int var6 = this.c.size();

         for(int var7 = 0; var7 < var6; ++var7) {
            Card var8 = (Card)var4.c.elementAt(var7);
            if (Canvas.w < 150) {
               var8.paintSmall(var5, false);
            } else if (var7 == var6 - 1) {
               var8.paintFull(var5);
            } else {
               var8.paintHalf(var5);
            }
         }

         if (!this.N) {
            this.N = true;
         }
      }

      if (BoardScr.isStartGame || BoardScr.disableReady) {
         Graphics var3 = var1;
         TLBoardScr var2 = this;

         for(int var11 = 0; var11 < 4; ++var11) {
            Avatar var12;
            if ((var12 = (Avatar)BoardScr.avatarInfos.elementAt(var11)).IDDB != -1) {
               byte var13 = 0;
               byte var14 = 0;
               if (BoardScr.indexPlayer[var11] == 2) {
                  var13 = -80;
               }

               if (BoardScr.indexPlayer[var11] == 1) {
                  var14 = -10;
               } else if (BoardScr.indexPlayer[var11] == 3) {
                  var14 = 10;
               }

               if (Canvas.w > 160) {
                  Canvas.smallFontYellow.drawString(var3, var12.getMoneyNew() + " " + avt.T.k(), BoardScr.posAvatar[BoardScr.indexPlayer[var11]].x + var14, BoardScr.posAvatar[BoardScr.indexPlayer[var11]].y + 5 + var13, BoardScr.posAvatar[BoardScr.indexPlayer[var11]].anchor);
               }

               if (var12.IDDB == var2.currentPlayer && var2.center != BoardScr.cmdBack) {
                  String var15 = "";
                  if (BoardScr.dieTime != 0L) {
                     long var9 = (BoardScr.currentTime - BoardScr.dieTime) / 1000L;
                     var15 = var15 + -var9;
                  }

                  int var16 = BoardScr.posAvatar[BoardScr.indexPlayer[var11]].x;
                  int var10 = BoardScr.posAvatar[BoardScr.indexPlayer[var11]].y + 13 * AvMain.hd;
                  if (BoardScr.indexPlayer[var11] == 2) {
                     var10 = var2.S - P / 2 - 20 * AvMain.hd;
                  }

                  PaintPopup.a(var16 - 10 * AvMain.hd, var10, 20 * AvMain.hd, AvMain.af, 16776365, var3);
                  var3.setColor(332544);
                  var3.drawRect(var16 - 10 * AvMain.hd, var10, 20 * AvMain.hd, AvMain.af);
                  Canvas.fontChatB.drawString(var3, var15, var16, var10 + 1, 2);
               }
            }
         }
      }

      if (BoardScr.isStartGame) {
         this.e(var1);
      }

      if (BoardScr.isStartGame || BoardScr.disableReady) {
         this.f(var1);
      }

      BoardScr.paintChat(var1);
      Canvas.resetTrans(var1);
   }

   private void e(Graphics var1) {
      if (BoardScr.isStartGame && this.K != null && this.K.size() > 0) {
         int var2 = this.K.size();
         int var3 = 0;
         int var4 = 0;

         for(int var5 = 0; var5 < var2; ++var5) {
            Card var6 = (Card)this.K.elementAt(var5);
            Card var7;
            (var7 = new Card((byte)-1, false)).x = var6.x;
            var7.y = var6.y;
            if (!var6.g) {
               var7 = (Card)this.K.elementAt(var5);
            }

            if (Canvas.w < 150) {
               var7.paintSmall(var1, false);
            } else if (var5 == var2 - 1 || var5 == this.Q || var6.f || var5 == this.Q - 1 || var7 != null && var7.f) {
               var7.paintFull(var1);
            } else if (super.disCard <= 14 && var7.x == var7.xTo && var7.y == var7.yTo) {
               var7.paintHalf(var1);
            } else {
               var7.paintHalfBackFull(var1);
            }

            if (var5 == super.selectedCard) {
               var4 = var7.y - P / 2 - 2 + (Canvas.gameTick % 10 > 4 ? 2 : 0);
               var3 = var7.x - O / 2 + 5 * AvMain.hd;
            }

            if (Canvas.stypeInt == 0 && var5 == this.Q && Canvas.gameTick % 10 > 6 && AvMain.hd == 1) {
               PaintPopup.b.drawFrame(0, var6.x - 40, var6.y - 30, 0, var1);
               PaintPopup.b.drawFrame(0, var6.x - 10, var6.y - 30, 3, var1);
            }
         }

         if (Canvas.stypeInt == 0) {
            MiniMap.gI().b.drawFrame(0, var3, var4, 0, 33, var1);
         }
      }

   }

   private void f(Graphics var1) {
      if (this.f != null && this.f.size() != 0) {
         int var2 = this.f.size();
         int var3;
         if ((var3 = (Canvas.w - 60) / var2 + 1) > 12) {
            var3 = 12;
         }

         int var4 = Canvas.hw - (var3 * var2 >> 1) + 6;
         int var5 = (Canvas.h + Canvas.hTab) / 2;

         for(int var6 = 0; var6 < var2; ++var6) {
            Card var7;
            (var7 = (Card)this.f.elementAt(var6)).x = var4;
            var7.y = var5;
            var4 += var3 * AvMain.hd;
            if (Canvas.w < 150) {
               var7.paintSmall(var1, false);
            } else if (var6 == var2 - 1) {
               var7.paintFull(var1);
            } else {
               var7.paintHalf(var1);
            }
         }

      }
   }

   public final void a(int var1, byte var2, Vector var3) {
      MyScreen.repaint();
      this.t();
      super.start();
      BoardScr.isStartGame = true;
      this.W = false;
      int var4;
      if (this.b && var1 == GameMidlet.avatar.IDDB) {
         for(var4 = 0; var4 < var3.size(); ++var4) {
            if (((Card)var3.elementAt(var4)).cardID == 0) {
               this.W = true;
               break;
            }
         }
      }

      this.f = null;
      this.c = new Vector();
      this.e = -1;
      this.d = new byte[0];
      BoardScr.isGameEnd = false;
      this.K = var3;
      a(var3);

      for(var4 = 0; var4 < this.K.size(); ++var4) {
         Card var5;
         (var5 = (Card)this.K.elementAt(var4)).x = Canvas.hw;
         var5.y = (Canvas.h + Canvas.hTab) / 2;
         var5.g = true;
      }

      for(int var6 = 0; var6 < BoardScr.numPlayer; ++var6) {
         BoardScr.avatarInfos.elementAt(var6);
      }

      BoardScr.interval = var2;
      BoardScr.dieTime = System.currentTimeMillis() + (long)(var2 * 1000);
      if (var1 == GameMidlet.avatar.IDDB) {
         super.right = this.L;
      }

      Avatar var7 = BoardScr.getAvatarByID(var1);
      BoardScr.addInfo(var7.name + avt.T.U, 20, var7.IDDB);
      this.e = -1;
      this.d = new byte[0];
      super.selectedCard = 2;
      super.currentPlayer = var1;
      this.setPosPlaying();
      this.d(false);
   }

   public final void a(int var1, byte[] var2, int var3) {
      this.W = false;
      if (var1 != -1) {
         int var4 = BoardScr.getIndexByID(var1);
         int var6 = BoardScr.indexPlayer[var4];
         byte[] var5 = var2;
         TLBoardScr var15 = this;
         int var7 = 0;
         int var8 = 0;
         int var10;
         switch (var6) {
            case 0:
               var7 = Canvas.hw;
               var8 = -27;
               break;
            case 1:
               var7 = -10;
               var8 = (Canvas.h + Canvas.hTab) / 2 - 20;
               break;
            case 2:
               var7 = Canvas.hw;
               var8 = Canvas.h + Canvas.hTab - 20;
               var6 = this.K.size() - 1;

               for(; var6 >= 0; --var6) {
                  Card var9 = (Card)var15.K.elementAt(var6);

                  for(var10 = 0; var10 < var5.length; ++var10) {
                     if (var9.cardID == var5[var10]) {
                        var7 = var9.x;
                        var8 = var9.y;
                        break;
                     }
                  }
               }
               break;
            case 3:
               var7 = Canvas.w + 10;
               var8 = (Canvas.h + Canvas.hTab) / 2 - 20;
         }

         var6 = Canvas.hw + CRes.random.nextInt(20);
         int var16 = Canvas.h / 2 - 20 * AvMain.hd + CRes.random.nextInt(25);
         var10 = var5.length;
         int var11;
         if ((var11 = (Canvas.w - 60) / var10 + 1) > 12) {
            var11 = 12;
         }

         int var12 = (var11 * var10 >> 1) + 6;
         var15.N = true;
         var15.c = new Vector();
         var15.d = var5;

         for(int var13 = 0; var13 < var10; ++var13) {
            Card var14;
            (var14 = new Card(var5[var13])).x = var7 + var13 * var15.disCard;
            var14.y = var8;
            var14.xTo = var6 - var12;
            var14.yTo = var16;
            var12 -= var11 * AvMain.hd;
            var15.c.addElement(var14);
         }

         var15.e = CardUtils.getType(var15.d);
      }

      if (var1 == GameMidlet.avatar.IDDB) {
         this.a(var2);
         super.selectedCard = 0;
         this.d(false);
      }

      super.currentPlayer = var3;
      if (super.currentPlayer == GameMidlet.avatar.IDDB) {
         if (this.v().length == 0) {
            super.right = this.L;
         } else {
            super.right = BoardScr.cmdFire;
         }
      } else {
         super.right = null;
      }

      if (BoardScr.interval == 0) {
         BoardScr.interval = 30;
      }

      BoardScr.dieTime = System.currentTimeMillis() + (long)(BoardScr.interval * 1000);
   }

   public final void a(int var1, int var2, boolean var3) {
      if (var3) {
         MyScreen.repaint();
      }

      String var4;
      Avatar var5;
      if ((var5 = BoardScr.getAvatarByID(var1)).name.equals("")) {
         var4 = avt.T.u;
      } else {
         var4 = avt.T.B;
      }

      BoardScr.addInfo(var4, 60, var5.IDDB);
      super.currentPlayer = var2;
      if (var3) {
         this.c = new Vector();
         this.e = -1;
         this.d = new byte[0];
      }

      if (super.currentPlayer == GameMidlet.avatar.IDDB) {
         if (this.v().length == 0) {
            super.right = this.L;
         } else {
            super.right = BoardScr.cmdFire;
         }
      } else {
         super.right = null;
      }

      BoardScr.dieTime = System.currentTimeMillis() + (long)(BoardScr.interval * 1000);
   }

   public final void a(int var1, byte[] var2) {
      Avatar var3 = BoardScr.getAvatarByID(var1);
      CardUtils.sort(var2);
      this.f = new Vector();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         this.f.addElement(new Card(var2[var4]));
      }

      if (var3 != null && var3.IDDB == var1 && this.K != null) {
         this.K.removeAllElements();
      }

   }

   public static void a(int var0, byte var1, int var2, int var3) {
      Avatar var4;
      if ((var4 = BoardScr.getAvatarByID(var0)) != null) {
         var4.isReady = false;
         if ((var3 += var4.exp) < 0) {
            var3 = 0;
         }

         var4.setExp(var3);
         var4.setMoneyNew(var4.getMoneyNew() + var2);
         if (var4.IDDB == GameMidlet.avatar.IDDB) {
            GameMidlet.avatar.setMoneyNew(var4.getMoneyNew());
         }
      }

      BoardScr.showChat(var0, avt.T.W + (var1 + 1));
   }

   public static void m() {
      BoardScr.isGameEnd = true;
   }

   public final void b(String var1) {
      BoardScr.addInfo(var1, 100, GameMidlet.avatar.IDDB);
      super.currentPlayer = GameMidlet.avatar.IDDB;
   }

   public static void b(boolean var0) {
      MyScreen.repaint();
      BoardScr.isStartGame = false;
   }

   private void a(byte[] var1) {
      for(int var2 = this.K.size() - 1; var2 >= 0; --var2) {
         Card var3 = (Card)this.K.elementAt(var2);

         for(int var4 = 0; var4 < var1.length; ++var4) {
            if (var3.cardID == var1[var4]) {
               this.K.removeElementAt(var2);
            }
         }
      }

   }

   private byte[] v() {
      Vector var1 = new Vector();
      int var2 = this.K.size();

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         Card var4;
         if ((var4 = (Card)this.K.elementAt(var3)).f) {
            var1.addElement(var4);
         }
      }

      byte[] var5 = new byte[var3 = var1.size()];

      for(var2 = 0; var2 < var3; ++var2) {
         var5[var2] = ((Card)var1.elementAt(var2)).cardID;
      }

      CardUtils.sort(var5);
      return var5;
   }
}

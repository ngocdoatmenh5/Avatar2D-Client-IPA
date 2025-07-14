package avt;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import main.Canvas;
import main.GameMidlet;

public final class DiamondScr extends BoardScr {
   public static DiamondScr me_;
   private Point[][] d = new Point[8][8];
   private int e;
   private int f;
   private int g;
   private int h;
   private int K = -1;
   private int L;
   private int M;
   private byte N = -1;
   private Vector O = new Vector();
   private boolean P = false;
   private boolean Q = false;
   private Command R;
   private Command S;
   private FrameImage T;
   private byte U;
   private int V = 0;
   public int b = -1;
   private boolean W = false;
   public boolean c = false;
   private boolean X = false;
   private int[][] ay = new int[][]{{1, -2}, {1, -1}, {1, -1}, {1, 3}, {1, 2}, {1, 2}, new int[2], {0, -1}, {0, 1}, new int[2], {0, -1}, {0, 1}, {-1, 1}, {-1, 1}, {-1, -1}, {1, 1}};
   private int[][] az = new int[][]{new int[2], {0, -1}, {0, 1}, new int[2], {0, -1}, {0, 1}, {1, 3}, {1, 2}, {1, 2}, {1, -2}, {1, -1}, {1, -1}, {-1, -1}, {1, 1}, {-1, 1}, {-1, 1}};
   private int[][] aA = new int[][]{{-1, -2}, new int[2], {1, 2}, new int[2], {-1, 1}, new int[2]};
   private int[][] aB = new int[][]{new int[2], {-1, -2}, new int[2], {1, 2}, new int[2], {-1, 1}};
   private boolean aC = false;
   private int aD;
   private Vector aE = new Vector();
   private boolean aF = false;
   private boolean aG = false;

   public static DiamondScr b() {
      return me_ == null ? (me_ = new DiamondScr()) : me_;
   }

   public DiamondScr() {
      this.R = new Command(avt.T.O, 20);
      this.S = new Command(avt.T.B, 21);
      FilePack.b(avt.T.ax);
      this.T = FrameImage.a("st", 11 * AvMain.hd, 11 * AvMain.hd);
      FilePack.a();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 20:
            if (!this.P) {
               if (this.h == -1 && super.center == this.R && super.B == GameMidlet.avatar.IDDB && !this.Q) {
                  this.h = this.V;
               } else {
                  this.h = -1;
               }
            }
            break;
         case 21:
            this.m();
      }

      super.commandTab(var1, var2);
   }

   private void m() {
      CasinoService var1 = CasinoService.gI();

      try {
         var1.b((byte)49);
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      var1.sendMessage();
      super.B = -1;
      super.center = BoardScr.cmdWaiting;
      super.right = null;
   }

   public final void init() {
      super.init();
      if (Canvas.q > 250) {
         this.g = 24 * AvMain.hd;
         this.U = (byte)(24 * AvMain.hd);
      } else {
         this.g = 16;
         this.U = 16;
      }

      this.aD = 40 * AvMain.hd;
      if (this.N == -1 || !BoardScr.isStartGame) {
         this.e = (Canvas.w - (this.g << 3)) / 2;
      }

      this.f = this.g / 2 + 2;
      if (Canvas.w < 160) {
         this.f = 0;
      }

   }

   public final void a(int var1, int var2, byte[][] var3) {
      MyScreen.repaint();
      super.start();
      this.W = false;
      super.B = var1;
      BoardScr.interval = var2;
      super.center = null;
      super.right = null;
      this.b = -1;
      BoardScr.dieTime = System.currentTimeMillis() + (long)(BoardScr.interval * 1000);
      if (GameMidlet.avatar.IDDB == super.B) {
         this.X = true;
      }

      this.init();
      this.setPosPlaying();
      BoardScr.isStartGame = true;
      this.h = -1;
      this.b(var3);
      Canvas.endDlg();
   }

   public final void setPosPlaying() {
      AvCamera.gI().setPos(0, 0);
      int var1 = this.e;
      int var2 = this.g << 3;
      if (Canvas.q < 250) {
         var2 = Canvas.w - 50;
         var1 = 25;
      }

      for(int var3 = 0; var3 < BoardScr.numPlayer; ++var3) {
         Avatar var4;
         if ((var4 = (Avatar)BoardScr.avatarInfos.elementAt(var3)).IDDB != -1) {
            if (var4.IDDB != GameMidlet.avatar.IDDB) {
               LoadMap.b(var4);
            }

            var4.yCur = var4.y = Canvas.q - Canvas.hTab - AvMain.ai / 2;
            if (var4.y < this.g << 3 && (var1 = this.e - this.aD - 15 * AvMain.hd) < 0) {
               var1 = 0;
            }

            if (Canvas.w < 160) {
               var4.yCur = var4.y = Canvas.q - 10;
            }

            if (Canvas.stypeInt == 0 && Canvas.w > 200) {
               var4.yCur = var4.y -= 10;
            }

            if (var4.IDDB == GameMidlet.avatar.IDDB) {
               this.L = var1 + 15 * AvMain.hd + this.aD;
               var4.xCur = var4.x = this.L;
               var4.direct = var4.dirLast = 0;
            } else {
               this.M = var1 + var2 - 15 * AvMain.hd - this.aD;
               var4.xCur = var4.x = this.M;
               var4.direct = var4.dirLast = Base.LEFT;
            }

            var4.ySat = 0;
            var4.setAction((byte)0);
            var4.setFrame(var4.action);
         }
      }

   }

   private void b(byte[][] var1) {
      boolean var2 = false;
      this.Q = true;

      for(int var3 = 7; var3 >= 0; --var3) {
         int var5 = 20;

         for(int var4 = 7; var4 >= 0; --var4) {
            this.d[var3][var4] = new Point(var4 * this.g, var3 * this.g, var1[var3][var4]);
            this.d[var3][var4].color = this.d[var3][var4].y;
            this.d[var3][var4].e = -var5;
            --var5;
            this.d[var3][var4].k = true;
            this.d[var3][var4].y = -(var4 * this.g + 24);
         }
      }

   }

   public final void update() {
      super.update();
      if (!BoardScr.isStartGame && !BoardScr.disableReady) {
         this.updateReady();
      } else {
         if (BoardScr.dieTime != 0L && (BoardScr.currentTime = System.currentTimeMillis()) > BoardScr.dieTime) {
            BoardScr.dieTime = 0L;
            if (super.B == GameMidlet.avatar.IDDB && super.center == this.R) {
               this.m();
            }
         }

         boolean var1 = false;
         boolean var2 = false;

         int var3;
         for(var3 = 63; var3 >= 0; --var3) {
            if (this.d[var3 / 8][var3 % 8] != null && this.d[var3 / 8][var3 % 8].catagory == 1) {
               Point var4;
               int var10000;
               if ((var4 = this.d[var3 / 8][var3 % 8]).x == var4.xTo && var4.y == var4.yTo) {
                  var10000 = -1;
               } else if (Math.abs((var4.xTo - var4.x) / 2) <= 1 && Math.abs((var4.yTo - var4.y) / 2) <= 1) {
                  var4.x = var4.xTo;
                  var4.y = var4.yTo;
                  var10000 = 0;
               } else {
                  if (var4.x != var4.xTo) {
                     var4.x += (var4.xTo - var4.x) / 2;
                  }

                  if (var4.y != var4.yTo) {
                     var4.y += (var4.yTo - var4.y) / 2;
                  }

                  var10000 = CRes.a(var4.x, var4.y, var4.xTo, var4.yTo) <= var4.o / 5 ? 2 : 1;
               }

               if (var10000 == -1) {
                  this.d[var3 / 8][var3 % 8].catagory = 0;
                  var2 = true;
               } else {
                  var1 = true;
               }
            }
         }

         if (var2 && this.P) {
            if (!this.c(this.V) && !this.c(this.h)) {
               var3 = this.V;
               this.V = this.h;
               this.h = var3;
               this.u();
               super.center = this.R;
               super.right = this.S;
            } else if (super.B == GameMidlet.avatar.IDDB) {
               CasinoService.gI().a(this.h, this.V);
            }

            this.P = false;
            this.h = -1;
         }

         int var5;
         if (!var1) {
            boolean var9 = false;

            for(var5 = 63; var5 >= 0; --var5) {
               if (this.d[var5 / 8][var5 % 8] != null && this.d[var5 / 8][var5 % 8].k) {
                  Point var13 = this.d[var5 / 8][var5 % 8];
                  var13.x += this.d[var5 / 8][var5 % 8].b;
                  if (this.d[var5 / 8][var5 % 8].b > 1 || this.d[var5 / 8][var5 % 8].b < -1) {
                     var13 = this.d[var5 / 8][var5 % 8];
                     var13.b -= this.d[var5 / 8][var5 % 8].b / CRes.abs(this.d[var5 / 8][var5 % 8].b);
                  }

                  var13 = this.d[var5 / 8][var5 % 8];
                  var13.y += this.d[var5 / 8][var5 % 8].e;
                  var13 = this.d[var5 / 8][var5 % 8];
                  var13.e += 2;
                  if (this.d[var5 / 8][var5 % 8].y >= this.d[var5 / 8][var5 % 8].color) {
                     this.d[var5 / 8][var5 % 8].y = this.d[var5 / 8][var5 % 8].color;
                     this.d[var5 / 8][var5 % 8].k = false;
                  } else {
                     var9 = true;
                  }
               }
            }

            if (!var9 && this.Q) {
               if (super.B == GameMidlet.avatar.IDDB) {
                  if (!this.X) {
                     if (this.aG) {
                        this.v();
                     }
                  } else if (this.t()) {
                     super.center = this.R;
                     super.right = this.S;
                  } else {
                     CasinoService.gI().i();
                  }

                  this.X = false;
               }

               this.Q = false;
            }
         }

         int var6;
         if (this.K != -1) {
            if (this.K % 10 == 0) {
               DiamondScr var10 = this;

               for(var5 = 4 - this.K / 10; var5 < 4 + var10.K / 10; ++var5) {
                  for(var6 = 4 - var10.K / 10; var6 < 4 + var10.K / 10; ++var6) {
                     var10.b(var10.d[var5][var6].x + 12, var10.d[var5][var6].y + 12, var10.d[var5][var6].j);
                     var10.d[var5][var6].j = -1;
                  }
               }
            }

            this.K += 2;
            if (this.K >= 50) {
               this.w();
               this.K = -1;
            }
         }

         Point var7;
         for(var3 = 0; var3 < this.O.size(); ++var3) {
            if ((var7 = (Point)this.O.elementAt(var3)).g > 0) {
               ++var7.g;
               if (var7.g == 3) {
                  this.O.removeElement(var7);
                  continue;
               }
            }

            if (!var7.k) {
               if (CRes.abs((var6 = CRes.a(var7.xTo - var7.x, -(var7.yTo - var7.y))) - var7.e) > 10) {
                  var7.e -= var7.height * var7.catagory;
                  var7.e = CRes.fixangle(var7.e);
               } else {
                  var7.e = var6;
                  var7.dis = (byte)(var7.dis + 2);
               }

               if (var7.color >= 4) {
                  var7.color = 0;
               }

               ++var7.color;
               int var11 = var7.dis * CRes.cos(var7.e) >> 10;
               var6 = -(var7.dis * CRes.sin(var7.e)) >> 10;
               if (CRes.a(var7.x, var7.y, var7.xTo, var7.yTo) >= var7.dis) {
                  var7.x += var11;
                  var7.y += var6;
               } else {
                  this.O.removeElement(var7);
               }
            } else {
               var7.x += var7.b;
               if (var7.b > 1 || var7.b < -1) {
                  var7.b -= var7.b / CRes.abs(var7.b);
               }

               var7.y += var7.e;
               ++var7.e;
               if (var7.catagory == 1 && var7.color < 19) {
                  ++var7.color;
               }

               if (var7.y + this.f > Canvas.h) {
                  this.O.removeElement(var7);
               }
            }
         }

         for(var3 = 0; var3 < 2; ++var3) {
            Avatar var8;
            if ((var8 = (Avatar)BoardScr.avatarInfos.elementAt(var3)).task == -1 && CRes.abs(var8.xCur - var8.x) < 10) {
               if (this.N == -2) {
                  this.N = -1;
                  var8.task = 0;
                  if (var8.IDDB == this.b) {
                     var8.doAction((byte)10);
                     var8.setFeel(10);
                  } else {
                     var8.action = 0;
                     if (this.b != -1) {
                        var8.setFeel(9);
                     }
                  }

                  this.c = false;
                  if (var8.IDDB == GameMidlet.avatar.IDDB) {
                     var8.direct = 0;
                  }
               } else if (var8.task == -1) {
                  if (var8.isNo && Canvas.gameTick % 6 == 3) {
                     this.c(var8.x, var8.y - var8.height, 0);
                  }

                  if (this.N != -1) {
                     if (this.N >= 0) {
                        --this.N;
                        if (this.N == -1) {
                           this.N = -2;
                           if (var8.IDDB == GameMidlet.avatar.IDDB) {
                              var8.xCur = this.L;
                           } else {
                              var8.xCur = this.M;
                           }
                        }
                     }
                  } else {
                     for(var6 = 0; var6 < 2; ++var6) {
                        Avatar var12;
                        if ((var12 = (Avatar)BoardScr.avatarInfos.elementAt(var6)).IDDB != var8.IDDB) {
                           var12.setFeel(20);
                           var12.action = 4;
                           var12.ableShow = true;
                           var8.ableShow = true;
                        }
                     }

                     this.N = 20;
                     if (this.c) {
                        this.N = 30;
                     }
                  }
               }
            }

            if (var8.plusHP > 0) {
               var6 = var8.maxHP / 100 + 1;
               if (var8.plusHP - var6 < 0) {
                  var6 = var8.plusHP;
               }

               var8.plusHP = (short)(var8.plusHP - var6);
               var8.hp = (short)(var8.hp + var6);
            } else if (var8.plusHP < 0) {
               var6 = var8.maxHP / 100 + 1;
               if (var8.plusHP + var6 > 0) {
                  var6 = -var8.plusHP;
               }

               var8.hp = (short)(var8.hp - var6);
               var8.plusHP = (short)(var8.plusHP + var6);
            }

            if (var8.plusMP > 0) {
               var6 = var8.maxHP / 100 + 1;
               if (var8.plusMP - var6 < 0) {
                  var6 = var8.plusMP;
               }

               var8.plusMP = (short)(var8.plusMP - var6);
               var8.mp = (short)(var8.mp + var6);
            } else if (var8.plusMP < 0) {
               var6 = var8.maxHP / 100 + 1;
               if (var8.plusMP + var6 > 0) {
                  var6 = -var8.plusMP;
               }

               var8.mp = (short)(var8.mp - var6);
               var8.plusMP = (short)(var8.plusMP + var6);
            }
         }

         for(var3 = 0; var3 < this.aE.size(); ++var3) {
            --(var7 = (Point)this.aE.elementAt(var3)).g;
            if (var7.g <= 0) {
               this.aE.removeElement(var7);
            }
         }

      }
   }

   private boolean t() {
      for(int var1 = 0; var1 < 8; ++var1) {
         for(int var2 = 0; var2 < 8; ++var2) {
            for(int var3 = 0; var3 < this.ay.length; ++var3) {
               if (var1 + this.az[var3][0] >= 0 && var1 + this.az[var3][0] < 8 && var1 + this.az[var3][1] >= 0 && var1 + this.az[var3][1] < 8 && var2 + this.ay[var3][0] >= 0 && var2 + this.ay[var3][0] < 8 && var2 + this.ay[var3][1] >= 0 && var2 + this.ay[var3][1] < 8 && this.d[var1][var2].j == this.d[var1 + this.az[var3][0]][var2 + this.ay[var3][0]].j && this.d[var1][var2].j == this.d[var1 + this.az[var3][1]][var2 + this.ay[var3][1]].j) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private void b(int var1, int var2, int var3) {
      if (var3 != -1) {
         Avatar var4;
         if ((var4 = BoardScr.getAvatarByID(super.B)) != null) {
            int var5 = 0;
            int var6 = 0;
            switch (var3) {
               case 0:
                  this.c(var1 + this.e, var2 + this.f, 0);
                  return;
               case 1:
                  var5 = var4.x;
                  var6 = var4.y - var4.height / 2;
                  if (var4.an > 0) {
                     if (var4.IDDB == GameMidlet.avatar.IDDB) {
                        var5 = this.L - 20 - 7;
                     } else {
                        var5 = this.M + 7 + 20;
                     }

                     var6 = var4.y - 22;
                  }
                  break;
               case 2:
                  if (var4.IDDB == GameMidlet.avatar.IDDB) {
                     var5 = this.L - 20 - this.aD + var4.hp * this.aD / var4.maxHP;
                  } else {
                     var5 = this.M + (this.aD - var4.hp * this.aD / var4.maxHP) + 20 - var4.hp * this.aD / var4.maxHP;
                  }

                  var6 = var4.y - 2 - 10 * AvMain.hd;
                  break;
               case 3:
                  if (var4.IDDB == GameMidlet.avatar.IDDB) {
                     var5 = this.L - 20 - this.aD + var4.mp * this.aD / var4.maxMP;
                  } else {
                     var5 = this.M + (this.aD - var4.mp * this.aD / var4.maxMP) + 20 - var4.hp * this.aD / var4.maxHP;
                  }

                  var6 = var4.y - 5 * AvMain.hd;
                  break;
               case 4:
                  this.c(var1 + this.e, var2 + this.f, 4);
                  return;
               case 5:
                  return;
            }

            Point var10;
            (var10 = new Point(var1 + this.e, var2 + this.f)).g = 1;
            this.O.addElement(var10);

            for(int var11 = 0; var11 < (var3 != 1 ? 3 : 1); ++var11) {
               Point var7;
               (var7 = new Point(var1 + this.e, var2 + this.f)).o = (short)var3;
               var7.color = CRes.rnd(3);
               int var8 = CRes.a(var5 - var1, -(var6 - var2));
               var7.b = var8;
               var7.catagory = (byte)CRes.rnd(-1, 1);
               var7.e = CRes.fixangle(var7.b + var7.catagory * 90);
               var8 = 10 * CRes.cos(var7.e) >> 10;
               int var9 = -(10 * CRes.sin(var7.e)) >> 10;
               var7.xTo = (short)var5;
               var7.yTo = (short)var6;
               var7.x += var8;
               var7.y += var9;
               var7.color = 0;
               var7.dis = (byte)(CRes.rnd(4) + 4);
               var7.height = (short)(10 + CRes.rnd(5));
               this.O.addElement(var7);
            }

         }
      }
   }

   private void c(int var1, int var2, int var3) {
      if (var3 != -1) {
         Point var4;
         (var4 = new Point(var1, var2)).g = 1;
         this.O.addElement(var4);

         for(int var7 = 0; var7 < 3; ++var7) {
            int var5 = CRes.rnd(-1, 1);
            Point var6;
            (var6 = new Point(var1, var2)).k = true;
            var6.color = CRes.rnd(3);
            var6.b = var5 * (CRes.rnd(100) / 10);
            var6.e = -CRes.rnd(100) / 10;
            var6.dis = (byte)var3;
            var6.catagory = 1;
            var6.g = 0;
            this.O.addElement(var6);
         }

      }
   }

   private boolean c(int var1) {
      if (this.h != -1 && !this.Q) {
         for(int var2 = 0; var2 < this.aA.length; ++var2) {
            if (var1 / 8 + this.aB[var2][0] >= 0 && var1 / 8 + this.aB[var2][0] < 8 && var1 / 8 + this.aB[var2][1] >= 0 && var1 / 8 + this.aB[var2][1] < 8 && var1 % 8 + this.aA[var2][0] >= 0 && var1 % 8 + this.aA[var2][0] < 8 && var1 % 8 + this.aA[var2][1] >= 0 && var1 % 8 + this.aA[var2][1] < 8 && this.d[var1 / 8][var1 % 8].j == this.d[var1 / 8 + this.aB[var2][0]][var1 % 8 + this.aA[var2][0]].j && this.d[var1 / 8][var1 % 8].j == this.d[var1 / 8 + this.aB[var2][1]][var1 % 8 + this.aA[var2][1]].j) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public final void updateKey() {
      super.updateKey();
      int var1;
      int var2;
      if (Canvas.isPointerClick && Canvas.a(this.e, this.f, this.g << 3, this.g << 3) && this.h == -1) {
         Canvas.isPointerClick = false;
         this.aC = true;
         var1 = (Canvas.px - this.e) / this.g;
         var2 = (Canvas.py - this.f) / this.g;
         this.V = (var2 << 3) + var1;
      }

      if (!this.P && !this.Q && super.center == this.R && super.center != BoardScr.cmdWaiting && this.aC) {
         if (Canvas.isPointerDown) {
            var1 = Canvas.dx();
            var2 = Canvas.dy();
            if (var1 < -this.g / 2) {
               if (this.V % 8 < 7) {
                  this.h = this.V++;
                  this.aC = false;
                  this.u();
               }
            } else if (var1 > this.g / 2) {
               if (this.V % 8 > 0) {
                  this.h = this.V--;
                  this.aC = false;
                  this.u();
               }
            } else if (var2 < -this.g / 2) {
               if (this.V / 8 < 7) {
                  this.h = this.V;
                  this.V += 8;
                  this.aC = false;
                  this.u();
               }
            } else if (var2 > this.g / 2 && this.V >= 8) {
               this.h = this.V;
               this.V -= 8;
               this.aC = false;
               this.u();
            }
         }

         if (Canvas.isPointerRelease) {
            Canvas.isPointerRelease = false;
            this.aC = false;
         }
      }

      if (BoardScr.isStartGame && super.center != BoardScr.cmdWaiting) {
         if (Canvas.a(2)) {
            if (!this.P && !this.Q) {
               if (this.V >= 8) {
                  this.V -= 8;
               }

               this.u();
               return;
            }
         } else if (Canvas.a(4)) {
            if (!this.P && !this.Q) {
               if (this.V % 8 > 0) {
                  --this.V;
               }

               this.u();
               return;
            }
         } else if (Canvas.a(6)) {
            if (!this.P && !this.Q) {
               if (this.V % 8 < 7) {
                  ++this.V;
               }

               this.u();
               return;
            }
         } else if (Canvas.a(8) && !this.P && !this.Q) {
            if (this.V / 8 < 7) {
               this.V += 8;
            }

            this.u();
         }
      }

   }

   private void u() {
      if (this.h != -1 && !this.Q) {
         super.center = BoardScr.cmdWaiting;
         super.right = null;
         this.P = true;
         this.aC = false;
         Point var1 = this.d[this.V / 8][this.V % 8];
         Point var2 = this.d[this.h / 8][this.h % 8];
         int var3 = var1.x;
         int var4 = var1.y;
         short var5 = var1.j;
         var1.x = var2.x;
         var1.y = var2.y;
         var1.j = var2.j;
         var2.x = var3;
         var2.y = var4;
         var2.j = var5;
         var2.catagory = 1;
         var1.catagory = 1;
      }
   }

   private void v() {
      boolean var1 = false;

      for(int var3 = 0; var3 < 64; ++var3) {
         if (this.d[var3 / 8][var3 % 8].j != -2) {
            int var2 = 0;

            int var4;
            for(var4 = var3 + 1; var4 % 8 < 8 && var4 < 64 && var4 / 8 == var3 / 8 && this.d[var3 / 8][var3 % 8].j == this.d[var4 / 8][var4 % 8].j; ++var4) {
               ++var2;
            }

            if (var2 > 1) {
               for(var4 = var3; var4 < var3 + var2 + 1; ++var4) {
                  this.d[var4 / 8][var4 % 8].l = true;
                  var1 = true;
               }
            }

            var2 = 0;

            for(var4 = var3 + 8; var4 < 64 && var4 % 8 == var3 % 8 && this.d[var3 / 8][var3 % 8].j == this.d[var4 / 8][var4 % 8].j; var4 += 8) {
               ++var2;
            }

            if (var2 > 1) {
               for(var4 = var3; var4 < var3 + (var2 + 1 << 3); var4 += 8) {
                  this.d[var4 / 8][var4 % 8].l = true;
                  var1 = true;
               }
            }
         }
      }

      if (var1) {
         CasinoService.gI().a(this.d);
      } else {
         if (this.aF) {
            this.aF = false;
            this.m();
         }

      }
   }

   private void w() {
      for(int var1 = 0; var1 < 8; ++var1) {
         for(int var2 = 7; var2 >= 0; --var2) {
            if (this.d[((var2 << 3) + var1) / 8][((var2 << 3) + var1) % 8].j == -1) {
               int var10001 = (var2 << 3) + var1;
               boolean var3 = true;
               int var5 = 4;
               int var4 = var10001;
               DiamondScr var7 = this;
               this.Q = true;

               for(int var6 = var4; var6 / 8 > 0; var6 -= 8) {
                  var7.d[var6 / 8][var6 % 8].j = var7.d[(var6 - 8) / 8][(var6 - 8) % 8].j;
                  var7.d[var6 / 8][var6 % 8].color = var6 / 8 * var7.g;
                  if (!var7.d[var6 / 8][var6 % 8].k) {
                     var7.d[var6 / 8][var6 % 8].e = -var5;
                     ++var5;
                     var7.d[var6 / 8][var6 % 8].k = true;
                  }

                  var7.d[var6 / 8][var6 % 8].y = var7.d[(var6 - 8) / 8][(var6 - 8) % 8].y;
               }

               var7.d[0][var4 % 8].j = -2;
               var7.d[0][var4 % 8].color = 0;
               if (!var7.d[0][var4 % 8].k) {
                  var7.d[0][var4 % 8].e = -var5;
                  ++var5;
                  var7.d[0][var4 % 8].k = true;
                  var7.d[0][var4 % 8].y = 0;
               }

               Point var10000 = var7.d[0][var4 % 8];
               var10000.y -= 24;
               ++var2;
            }
         }
      }

   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      super.paint(var1);
   }

   public final void paintMain(Graphics var1) {
      super.paintMain(var1);
      if (!BoardScr.isStartGame) {
         this.paintNamePlayers(var1);
      } else {
         Canvas.resetTrans(var1);
         Graphics var3 = var1;
         DiamondScr var2 = this;
         var1.translate(this.e, this.f);
         int var5;
         if (AvatarData.getImgIcon((short)876).count != -1) {
            for(var5 = 0; var5 < var2.aE.size(); ++var5) {
               Point var6 = (Point)var2.aE.elementAt(var5);
               int var4 = var5 * 17 - var2.g / 2 + 8;
               if (var6.color != GameMidlet.avatar.IDDB) {
                  var4 = (var2.g << 3) - var5 * 17 + var2.g / 2 - 8;
               }

               int var10003 = var6.j << 4;
               int var10008 = (var2.g << 3) + var2.g;
               var3.drawRegion(AvatarData.getImgIcon((short)876).img, 0, var10003, 16, 16, 0, var4, var10008, 3);
               Canvas.smallFontYellow.a(var3, String.valueOf(var6.dis), var4, (var2.g << 3) + var2.g - AvMain.ai / 2, 2);
            }
         }

         var3.setClip(-var2.g / 2, -var2.g / 2, (var2.g << 3) + var2.g, (var2.g << 3) + var2.g);
         ImageIcon var9;
         if (var2.V >= 0 && var2.d[var2.V / 8][var2.V % 8] != null && (var2.B != GameMidlet.avatar.IDDB || Canvas.gameTick % 10 != 5) && (var9 = AvatarData.getImgIcon((short)(Canvas.q > 250 ? 878 : 879))).count != -1) {
            var3.drawRegion(var9.img, 0, (var2.h != -1 && Canvas.gameTick % 6 < 3 ? 1 : 0) * var2.g, var2.g, var2.g, 0, var2.d[var2.V / 8][var2.V % 8].x, var2.d[var2.V / 8][var2.V % 8].y, 0);
         }

         if ((var9 = AvatarData.getImgIcon((short)(Canvas.q > 250 ? 875 : 876))).count != -1) {
            for(var5 = 0; var5 < 8; ++var5) {
               for(int var10 = 0; var10 < 8; ++var10) {
                  if (var2.d[var5][var10] != null && var2.d[var5][var10].j >= 0) {
                     var3.drawRegion(var9.img, 0, var2.d[var5][var10].j * var2.U, var2.U, var2.U, 0, var2.d[var5][var10].x, var2.d[var5][var10].y, 0);
                  }
               }
            }
         }

         Canvas.resetTrans(var1);
         if (Canvas.w > 160) {
            this.paintNamePlayers(var1);
         }

         this.e(var1);
         Canvas.resetTrans(var1);
         String var7 = "";
         if (BoardScr.dieTime != 0L) {
            long var8 = (BoardScr.currentTime - BoardScr.dieTime) / 1000L;
            var7 = var7 + -var8;
         }

         Canvas.O.a(var1, var7, this.e + (this.g << 3) / 2, this.f + (this.g << 3) + Canvas.O.a() + 2, 2);
         this.f(var1);
      }
   }

   public final void paintCaro(Graphics var1) {
      var1.setClip(this.e - this.g / 2, this.f - this.g / 2, (this.g << 3) + this.g + 1, (this.g << 3) + this.g + 1);

      for(int var2 = 0; var2 < 10; ++var2) {
         for(int var3 = 0; var3 < 10; ++var3) {
            if (var3 % 2 == var2 % 2) {
               var1.setColor(5197647);
            } else {
               var1.setColor(2697513);
            }

            var1.fillRect(this.e - this.g + var2 * this.g, this.f + var3 * this.g - this.g, this.g, this.g);
         }
      }

      var1.setColor(0);
      var1.drawRect(this.e - this.g / 2, this.f - this.g / 2, (this.g << 3) + this.g, (this.g << 3) + this.g);
      var1.drawRect(this.e - this.g / 2 + 1, this.f - this.g / 2 + 1, (this.g << 3) + this.g - 2, (this.g << 3) + this.g - 2);
   }

   private void e(Graphics var1) {
      int var3 = 0;
      int var4 = 0;

      for(int var11 = 0; var11 < 2; ++var11) {
         Avatar var12 = (Avatar)BoardScr.avatarInfos.elementAt(var11);
         ImageIcon var2;
         if (this.N != -1 && var12.task == -1 && var12.action == 0 && (var2 = AvatarData.getImgIcon((short)(this.c ? 882 : 881))).count != -1) {
            var1.drawRegion(var2.img, 0, 48 * AvMain.hd * (Canvas.gameTick % 6 < 3 ? 0 : 1), 48 * AvMain.hd, 48 * AvMain.hd, 0, var12.x, var12.y - var12.height / 2, 3);
         }

         byte var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var13;
         if (var12.IDDB == GameMidlet.avatar.IDDB) {
            var13 = this.L - (10 + 10 * AvMain.hd + this.aD);
            var3 = 0;
            var9 = 0;
            var10 = 0;
            var4 = 0;
            var6 = -2;
            var5 = 1;
            var7 = this.aD - 7;
            var8 = this.aD - 16 * AvMain.hd;
            if (Canvas.w > 160) {
               Canvas.smallFontYellow.a(var1, var12.getMoneyNew() + " " + avt.T.k(), var13 + this.aD, var12.y, 1);
            }
         } else {
            var13 = this.M + 10 + 10 * AvMain.hd;
            var3 += this.aD - var12.hp * this.aD / var12.maxHP;
            var4 += this.aD - var12.mp * this.aD / var12.maxMP;
            var10 = this.aD - (var12.hp + var12.plusHP) * this.aD / var12.maxHP;
            var9 = this.aD - (var12.mp + var12.plusMP) * this.aD / var12.maxMP;
            var6 = this.aD + 2;
            var7 = 8;
            var5 = 0;
            var8 = 16 * AvMain.hd;
            if (Canvas.w > 160) {
               Canvas.smallFontYellow.a(var1, var12.getMoneyNew() + " " + avt.T.k(), var13, var12.y, 0);
            }
         }

         Canvas.smallFontYellow.a(var1, String.valueOf(var12.hp), var13 + var6, var12.y - (AvMain.ai << 1) + 3 * AvMain.hd - AvMain.ai / 2, var5);
         Canvas.smallFontYellow.a(var1, String.valueOf(var12.mp), var13 + var6, var12.y - AvMain.ai + 3 * AvMain.hd - AvMain.ai / 2, var5);
         if (var12.an > 0 && var12.countDefent <= 0 || var12.countDefent > 0 && Canvas.gameTick % 6 < 3) {
            AvatarData.a(var1, 880, var13 + var7, var12.y - AvMain.ai * 3, 3);
            Canvas.smallFontYellow.a(var1, String.valueOf(var12.an), var13 + var8, var12.y - AvMain.ai * 3 - AvMain.ai / 2, var5);
            if (var12.countDefent > 0) {
               --var12.countDefent;
            }
         }

         if (var12.plusHP != 0 && Canvas.gameTick % 6 >= 3) {
            var1.setColor(1908254);
         } else {
            var1.setColor(0);
         }

         var1.fillRect(var13, var12.y - (AvMain.ai << 1), this.aD, 6 * AvMain.hd);
         var1.fillRect(var13, var12.y - AvMain.ai, this.aD, 6 * AvMain.hd);
         if (var12.plusHP > 0) {
            var1.setColor(16583178);
            var1.fillRect(var13 + var10, var12.y - 4 - 10 * AvMain.hd, (var12.hp + var12.plusHP) * this.aD / var12.maxHP, 6 * AvMain.hd);
         }

         if (var12.plusHP != 0 && Canvas.gameTick % 6 >= 3) {
            var1.setColor(16734553);
         } else {
            var1.setColor(16711680);
         }

         var1.fillRect(var13 + var3, var12.y - (AvMain.ai << 1), var12.hp * this.aD / var12.maxHP, 6 * AvMain.hd);
         var1.setColor(14137273);
         var1.drawRect(var13, var12.y - (AvMain.ai << 1), this.aD, 6 * AvMain.hd);
         var1.drawRect(var13, var12.y - AvMain.ai, this.aD, 6 * AvMain.hd);
         if (var12.plusMP > 0) {
            var1.setColor(3771903);
            var1.fillRect(var13 + var9, var12.y - AvMain.ai + 1, (var12.mp + var12.plusMP) * this.aD / var12.maxMP, 6 * AvMain.hd - 1);
         }

         if ((var12.plusMP != 0 || var12.isNo) && Canvas.gameTick % 6 >= 3) {
            var1.setColor(6799871);
         } else {
            var1.setColor(299247);
         }

         var1.fillRect(var13 + var4, var12.y - AvMain.ai + 1, var12.mp * this.aD / var12.maxMP, 6 * AvMain.hd - 1);
      }

   }

   private void f(Graphics var1) {
      for(int var2 = 0; var2 < this.O.size(); ++var2) {
         Point var3;
         if ((var3 = (Point)this.O.elementAt(var2)).g > 0) {
            AvatarData.a(var1, 877, var3.x, var3.y, 3);
         } else if (var3.k) {
            this.T.drawFrame(var3.color / 5, var3.x, var3.y, 0, 3, var1);
         } else if (var3.dis >= 0) {
            this.T.drawFrame(var3.color / 2 + 1, var3.x, var3.y, 0, 3, var1);
         }
      }

   }

   public final void a(byte[] var1, AvPosition[] var2, byte var3, Vector var4) {
      int var6;
      int var7;
      for(var6 = 0; var6 < var1.length; ++var6) {
         this.d[var1[var6] / 8][var1[var6] % 8].l = true;
         if (Canvas.h > 300) {
            boolean var5 = false;

            for(var7 = 0; var7 < this.aE.size(); ++var7) {
               Point var8;
               if ((var8 = (Point)this.aE.elementAt(var7)).j == this.d[var1[var6] / 8][var1[var6] % 8].j) {
                  var8.g += 20;
                  var5 = true;
                  ++var8.dis;
                  break;
               }
            }

            if (!var5) {
               Point var11;
               (var11 = new Point()).j = this.d[var1[var6] / 8][var1[var6] % 8].j;
               var11.g = 40;
               var11.dis = 1;
               var11.color = super.B;
               this.aE.addElement(var11);
            }
         }
      }

      DiamondScr var9 = this;

      for(int var10 = 0; var10 < 8; ++var10) {
         for(var6 = 0; var6 < 8; ++var6) {
            if (var9.d[var10][var6].l) {
               var9.d[var10][var6].l = false;
               var9.b(var9.d[var10][var6].x + 12, var9.d[var10][var6].y + 12, var9.d[var10][var6].j);
               var9.d[var10][var6].j = -1;
            }
         }
      }

      var9.w();

      for(var6 = 0; var6 < var2.length; ++var6) {
         var7 = var2[var6].anchor;
         this.d[var7 / 8][var7 % 8].j = var2[var6].d;
      }

      if (var3 > 1) {
         Canvas.a("Combo x" + var3, Canvas.hw, Canvas.hh, -1, 1, 20);
      }

      if (var4.size() > 0) {
         for(var6 = 0; var6 < var4.size(); ++var6) {
            Canvas.a((String)var4.elementAt(var6), Canvas.hw, Canvas.hh + 40, -1, 1, var6 * 30);
         }
      }

      for(var6 = 0; var6 < 2; ++var6) {
         Avatar var12;
         (var12 = (Avatar)BoardScr.avatarInfos.elementAt(var6)).setFeel(4);
         if (var12.IDDB != super.B && var12.fight > 0) {
            Avatar var13;
            if ((var13 = BoardScr.getAvatarByID(super.B)).task != -1) {
               var13.doAction(var12.x, var12.y);
            }

            var13.task = -1;
            if (var12.an > 0) {
               var12.countDefent = 20;
            }
         }
      }

      Canvas.endDlg();
   }

   public final void a(int var1, int var2, int var3) {
      if (!this.W) {
         Avatar var4;
         if ((var4 = BoardScr.getAvatarByID(var1)) != null && var4.action == 4) {
            var4.action = 0;
         }

         if (var1 == GameMidlet.avatar.IDDB) {
            this.aF = true;
            this.v();
            this.aG = true;
         } else {
            super.center = BoardScr.cmdWaiting;
            super.right = null;
            this.h = var2;
            this.V = var3;
            this.u();
            if (var1 == -1) {
               this.P = false;
               this.h = -1;
            }

         }
      }
   }

   public final void b(int var1) {
      if (!this.W) {
         this.h = -1;
         BoardScr.dieTime = System.currentTimeMillis() + (long)(BoardScr.interval * 1000);
         super.B = var1;
         this.aG = false;
         if (var1 == GameMidlet.avatar.IDDB) {
            if (this.t()) {
               super.right = this.S;
               super.center = this.R;
            } else {
               CasinoService.gI().i();
            }
         } else {
            this.aF = false;
            super.center = null;
            super.right = null;
         }
      }
   }

   public final void a(int var1, byte[][] var2) {
      super.B = var1;
      if (var1 == GameMidlet.avatar.IDDB) {
         this.X = true;
      }

      this.b(var2);
   }

   public final void doContinue() {
      super.doContinue();
      BoardScr.isStartGame = false;
      this.W = false;
      ReportDlg.a().b();
      this.b = -1;

      for(int var1 = 0; var1 < BoardScr.avatarInfos.size(); ++var1) {
         Avatar var2;
         (var2 = (Avatar)BoardScr.avatarInfos.elementAt(var1)).resetAction();
         var2.setFeel(4);
      }

   }

   public final void a(Vector var1) {
      ReportDlg var10000 = ReportDlg.a();
      String var3 = "";
      ReportDlg var4 = var10000;
      var10000.g = var3;
      var4.f = Canvas.K.getWidth(var4.g) + 20 * AvMain.hd;
      if (var4.f < 50 + 20 * AvMain.hd) {
         var4.f = 50 + 20 * AvMain.hd;
      }

      var4.a = var1;
      var4.c = var4.a.size() * AvMain.af + (AvMain.Z << 1) + 10 + PaintPopup.o;
      var4.e = 0;

      for(int var5 = 0; var5 < var4.a.size(); ++var5) {
         var3 = (String)var4.a.elementAt(var5);
         if (Canvas.K.getWidth(var3) + 20 > var4.e) {
            var4.e = Canvas.K.getWidth(var3) + 20;
         }
      }

      if (var4.e < 176) {
         var4.e = 176;
      }

      if (Canvas.w >= 240 && var4.e < 240 * AvMain.hd) {
         var4.e = 240 * AvMain.hd;
      }

      var4.d = (Canvas.w - var4.e) / 2;
      var4.b = Canvas.h - Canvas.hTab - var4.c - 10;
      ReportDlg.a().center = new Command(avt.T.z, -1, this);
      super.center = BoardScr.cmdBack;
      super.right = null;
      super.B = -1;
      BoardScr.resetReady();
      super.left = null;
      this.W = true;
   }

   public final void a(byte[][] var1) {
      for(int var2 = 7; var2 >= 0; --var2) {
         for(int var3 = 7; var3 >= 0; --var3) {
            this.d[var2][var3].j = var1[var2][var3];
         }
      }

   }
}

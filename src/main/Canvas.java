package main;

import java.util.Vector;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

import avt.*;

public final class Canvas extends javax.microedition.lcdui.Canvas implements Runnable, CommandListener {
   public static Canvas instance;
   private static boolean bRun;
   public static boolean[] keyPressed = new boolean[14];
   public static boolean[] keyReleased = new boolean[14];
   public static boolean[] keyHold = new boolean[14];
   public static boolean isPointerDown;
   public static boolean isPointerRelease;
   public static boolean isPointerClick;
   public static int px;
   public static int py;
   public static int pxLast;
   public static int pyLast;
   public static int gameTick;
   public static int w = 0;
   public static int h;
   public static int hw;
   public static int hh;
   public static int hCan;
   private static boolean ah;
   public static MyScreen currentMyScreen;
   public static MsgDlg msgdlg;
   public static MenuMain menuMain;
   public static InputDlg inputDlg;
   public static Dialog currentDialog;
   private static int count0;
   public static AvatarData avataData;
   public static LoadMap loadMap;
   public static CameraList cameraList;
   public static GamePad z;
   public static Face currentFace;
   public static Vector currentEffect = new Vector();
   private static long[] timeBB;
   public static Vector listInfoSV = new Vector();
   public static Welcome welcome;
   public static boolean E;
   private static boolean ak;
   public static boolean F;
   public static boolean G;
   public static boolean isKeyBoard = false;
   public static boolean isInitChar = false;
   public static int load = -1;
   private static javax.microedition.lcdui.Command al;
   private static javax.microedition.lcdui.Command am;
   private static Object an = new Object();
   public static FontX normalFont;
   public static FontX borderFont;
   public static FontX M;
   public static FontX fontChatB;
   public static FontX O;
   public static FontX smallFontRed;
   public static FontX smallFontYellow;
   public static FontX R;
   public static IPaint paint;
   public static int hTab = 0;
   public static int transTab = 0;
   private static int ao;
   public static int V;
   public static int W;
   public static T t;
   public static Image imagePlug;
   public static int stypeInt = 1;
   private int ap;
   private static boolean aq = false;
   public static Image aa;
   public static byte ab = 0;
   private long ar = 0L;
   public static Vector ac = new Vector();
   private int as;
   private int at;
   private static Vector au;
   public static Command ad;
   public static AvPosition[] ae = new AvPosition[3];
   public static AvPosition af;

   public Canvas() {
      this.setFullScreenMode(true);
      w = this.getWidth();
      hCan = h = this.getHeight();
      t = new T();
      AvMain.hd = 1;
      if (CRes.b(GameMidlet.m) == null) {
         FarmData.c();
      }

      stypeInt = 0;
      normalFont = new mFont(0);
      borderFont = new mFont(1);
      M = new mFont(2);
      fontChatB = new mFont(3);
      O = new mFont(4);
      smallFontRed = new mFont(5);
      smallFontYellow = new mFont(6);
      R = new mFont(7);
      paint = new MediumPaint();
      MyScreen.al = normalFont.getHeight() + 6;
      AvMain.hBlack = (byte) fontChatB.getHeight();
      AvMain.ag = (byte) borderFont.getHeight();
      AvMain.ah = (byte) normalFont.getHeight();
      AvMain.hSmall = (byte) smallFontRed.getHeight();
      this.setSize();
      hw = w / 2;
      hh = h / 2;
      instance = this;
      System.gc();
      TField.initKey(0);
      if (ah = this.getKeyCode(8) == -20) {
         TField.initKey(1);
      }

      String var1;
      E = (var1 = System.getProperty("microedition.platform")).indexOf("RIM") == 0 || var1.indexOf("BlackBerry") == 0;
      ak = var1.indexOf("NX") == 0;
      F = var1.indexOf("NokiaN7") == 0;
      isKeyBoard = this.hasPointerEvents();
      if (E) {
         count0 = 5;
         if (var1.indexOf("BlackBerry") == 0) {
            count0 = 1;
         }

         TField.initKey(3);
         this.setCommandListener(this);
         am = new javax.microedition.lcdui.Command(T.d, 2, 1);
         al = new javax.microedition.lcdui.Command(T.c, 1, 1);
         this.addCommand(al);
         this.addCommand(am);
      }

      if (ak) {
         count0 = 2;
      }

      if (E || ak) {
         timeBB = new long[4];
      }

      TField.b(instance.getGameAction(48) == 0 && instance.getGameAction(49) == 0 && instance.getGameAction(50) == 0 && instance.getGameAction(51) == 0 && instance.getGameAction(52) == 0 && instance.getGameAction(53) == 0 && instance.getGameAction(54) == 0 && instance.getGameAction(55) == 0 && instance.getGameAction(56) == 0 && instance.getGameAction(57) == 0);
      CRes.init();
      menuMain = new MenuSub();
      msgdlg = new MsgDlg();
      avataData = new AvatarData();
      inputDlg = new InputDlg();
      loadMap = new LoadMap();
      cameraList = new CameraList();
      OptionScr.gI().e();
      paint.c();
      if (this.hasPointerEvents()) {
         au = new Vector();
      }

      a();
      if ((V = (ao = (int)(Runtime.getRuntime().totalMemory() / 1024L)) / 17) < 60) {
         V = 60;
      }

   }

   public static void a() {
      ad = new Command(T.p, -1);
      MenuSub.gI().doLeftMenu();
      if (currentMyScreen != null) {
         currentMyScreen.doLeftMenu();
      }

   }

   public final void sizeChanged(int var1, int var2) {
      this.setFullScreenMode(true);
      this.setSize();
   }

   public final void setSize() {
      w = this.getWidth();
      h = this.getHeight();
      AvMain.aa = 20;
      if (w < 176) {
         AvMain.aa = 4;
      }

      if (OptionScr.d && isKeyBoard) {
         z = new GamePad();
      } else {
         G = false;
         z = null;
      }

      hCan = h;
      hw = w / 2;
      paint.c();
      hh = h / 2;
      paint.init();
      if (menuMain != null) {
         menuMain = null;
      }

      if (LoginScr.me != null) {
         LoginScr.gI().init();
      }

      AvCamera.gI().init(LoadMap.TYPEMAP);
      if (PopupShop.me != null) {
         PopupShop.init();
      }

      if (PaintPopup.me != null) {
         PaintPopup.gI().init();
      }

      if (msgdlg != null) {
         msgdlg.init();
         msgdlg.setIsWaiting(msgdlg.a);
      }

      if (currentMyScreen != null) {
         if (currentMyScreen == RaceScr.a) {
            RaceScr.b();
         }

         if (BoardScr.me == currentMyScreen) {
            BoardScr.me.init();
         }

         if (MessageScr.me != null) {
            MessageScr.me.init();
         }

         if (MiniMap.me != null) {
            MiniMap.gI().init();
         }

         if (RoomListOnScr.me == currentMyScreen) {
            RoomListOnScr.me.init();
         }

         if (BoardListOnScr.me == currentMyScreen) {
            BoardListOnScr.me.init();
         }
      }

      if (inputDlg != null) {
         inputDlg.init();
      }

      if (ChatTextField.instance != null) {
         ChatTextField.gI().init();
      }

      if (CustomTab.me != null) {
         CustomTab.gI().d();
      }

      if (isKeyBoard && MyScreen.ap == null) {
         FilePack.b(T.aw);
         MyScreen.ap = FilePack.getImage("bpa");
         MyScreen.aq = FilePack.getImage("icon_chat");
         FilePack.reset();
      }

      if (currentMyScreen != null) {
         if (currentMyScreen == ServerListScr.a) {
            ServerListScr.gI().e();
         }

         if (currentMyScreen == OptionScr.a) {
            OptionScr.gI().e();
         }

         if (currentMyScreen == ListScr.gI()) {
            ListScr.gI().f();
         }

         if (currentMyScreen == MoneyScr.b()) {
            MoneyScr.b().e();
         }

         if (currentFace != null) {
            currentFace = null;
         }
      }

   }

   public static void a(String var0) {
      if (!OnScreen.isOngame && !var0.equals("")) {
         StringObj var1;
         (var1 = new StringObj(var0, -normalFont.getWidth(var0))).x = w + 10;
         listInfoSV.addElement(var1);
         if (ab == 0) {
            ab = 1;
         }

         transTab = 0;
      }
   }

   public static void connect() {
      if (!Session_ME.gI().isConnected()) {
         int var0;
         if ((var0 = ServerListScr.gI().selected_ - 1) < 0) {
            var0 = 0;
         }

         String var1 = "socket://" + GameMidlet.b[OptionScr.gI().b[4]][ServerListScr.gI().b][var0] + ":" + GameMidlet.c[OptionScr.gI().b[4]][ServerListScr.gI().b][var0];
         if (E) {
            if (OptionScr.e) {
               var1 = var1 + ";interface=wifi";
            } else {
               var1 = var1 + ";deviceside=true";
            }
         }

         Session_ME.gI().connect(var1);
         GlobalService.gI().setProviderAndClientType();
      }

   }

   public final void d() {
      if (!aq) {
         (new Thread(this)).start();
      }

      aq = true;
      Session_ME.gI().close();
   }

   public final void run() {
      bRun = true;

      while(bRun) {
         try {
            if (this.ap > 0) {
               --this.ap;
               if (this.ap == 0) {
                  Display.getDisplay(GameMidlet.h).vibrate(0);
               }
            }

            long var1 = System.currentTimeMillis();
            if (++gameTick > 10000) {
               if (System.currentTimeMillis() - this.ar > 20000L && currentMyScreen == LoginScr.me) {
                  GameMidlet.h.notifyDestroyed();
               }

               gameTick = 0;
            }

            if (load != -1) {
               if (load == 1) {
                  this.as += 15;
               } else {
                  ++this.at;
                  if (this.at >= 8) {
                     this.at = 0;
                  }
               }

               if (this.as >= hh) {
                  this.as = 0;
                  load = -1;
               }
            }

            if (load != 0) {
               if (z != null) {
                  z.a();
               }

               if (welcome != null && currentDialog == null) {
                  welcome.updateKey();
               }

               int var3;
               if (currentEffect.size() > 0) {
                  for(var3 = 0; var3 < currentEffect.size(); ++var3) {
                     ((Effect) currentEffect.elementAt(var3)).updateWind();
                  }
               }

               if (currentMyScreen != null) {
                  if (ChatTextField.isShow) {
                     ChatTextField.gI().updateKey();
                  }

                  if (listInfoSV.size() <= 0) {
                     if (ab > 0) {
                        --ab;
                     }
                  } else {
                     if (ab < AvMain.ag) {
                        ++ab;
                     }

                     StringObj var9;
                     StringObj var10000 = var9 = (StringObj) listInfoSV.elementAt(0);
                     var10000.x -= 2;
                     if (var9.x < var9.w2) {
                        listInfoSV.removeElementAt(0);
                     }
                  }

                  currentMyScreen.update();
                  if (cameraList.isShow) {
                     CameraList var10 = cameraList;
                     if (menuMain == null && currentDialog == null) {
                        if (var10.n == 0) {
                           if (CameraList.cmtoY < 0) {
                              CameraList.cmy = 0;
                           } else if (CameraList.cmtoY > var10.cmyLim) {
                              CameraList.cmy = var10.cmyLim;
                           }
                        } else {
                           if (CameraList.cmtoY < 0 || CameraList.cmtoY > var10.cmyLim) {
                              if (var10.n > 500) {
                                 var10.n = 500;
                              } else if (var10.n < -500) {
                                 var10.n = -500;
                              }

                              var10.n -= var10.n / 5;
                              if (CRes.abs(var10.n / 10) <= 10) {
                                 var10.n = 0;
                              }
                           }

                           CameraList.cmy = CameraList.cmtoY += var10.n / 15;
                           var10.n -= var10.n / 20;
                        }

                        if (var10.o == 0) {
                           if (CameraList.cmtoX < 0) {
                              CameraList.cmx = 0;
                           } else if (CameraList.cmtoX > var10.cmxLim) {
                              CameraList.cmx = var10.cmxLim;
                           }
                        } else {
                           if (CameraList.cmtoX < 0 || CameraList.cmtoX > var10.cmxLim) {
                              if (var10.o > 500) {
                                 var10.o = 500;
                              } else if (var10.o < -500) {
                                 var10.o = -500;
                              }

                              var10.o -= var10.o / 5;
                              if (CRes.abs(var10.o / 10) <= 10) {
                                 var10.o = 0;
                              }
                           }

                           CameraList.cmx = CameraList.cmtoX += var10.o / 15;
                           var10.o -= var10.o / 20;
                        }

                        if (CameraList.cmtoY != CameraList.cmy) {
                           var10.cmvy = CameraList.cmy - CameraList.cmtoY << 2;
                           var10.cmdy += var10.cmvy;
                           CameraList.cmtoY += var10.cmdy >> 4;
                           var10.cmdy &= 15;
                        }

                        if (CameraList.cmtoX != CameraList.cmx) {
                           var10.cmvx = CameraList.cmx - CameraList.cmtoX << 2;
                           var10.cmdx += var10.cmvx;
                           CameraList.cmtoX += var10.cmdx >> 4;
                           var10.cmdx &= 15;
                        }
                     }
                  }

                  if (currentDialog != null) {
                     currentDialog.updateKey();
                  } else if (currentFace != null) {
                     if (welcome == null) {
                        currentFace.updateKey();
                     }
                  } else if (menuMain != null) {
                     menuMain.updateKey();
                     if (menuMain != null) {
                        menuMain.update();
                     }
                  } else {
                     if (currentFace == null && !ChatTextField.isShow) {
                        currentMyScreen.updateKey();
                     }

                     if (cameraList.isShow && currentFace == null) {
                        cameraList.updateKey();
                     }
                  }

                  if (gameTick % 20 == 10) {
                     AvatarData.setLimitImage();
                     FarmData.setLimitImage();
                     if ((byte)((int)(Runtime.getRuntime().freeMemory() / 1024L)) < 100) {
                        System.gc();
                     }
                  }
               }

               if (welcome != null) {
                  welcome.update();
               }

               isPointerClick = false;
               isPointerRelease = false;

               for(var3 = 0; var3 < ac.size(); ++var3) {
                  ((class_cp)ac.elementAt(var3)).a();
               }

               if (E || ak) {
                  for(var3 = 0; var3 < 4; ++var3) {
                     if (keyHold[(var3 << 1) + 2] && System.currentTimeMillis() / 100L - timeBB[var3] > (long) count0) {
                        keyHold[(var3 << 1) + 2] = false;
                     }
                  }
               }
            }

            this.repaint();
            if (E) {
               synchronized(an) {
                  try {
                     an.wait(1000L);
                  } catch (InterruptedException var6) {
                     var6.printStackTrace();
                  }
               }
            } else {
               this.serviceRepaints();
            }

            long var11 = System.currentTimeMillis() - var1;

            try {
               if (var11 < 50L) {
                  Thread.sleep(50L - var11);
               } else {
                  Thread.sleep(1L);
               }
            } catch (InterruptedException var5) {
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }
      }

   }

   public final void keyPressed(int var1) {
      if (load == -1) {
         this.ar = System.currentTimeMillis();
         if (ah) {
            switch (this.getGameAction(var1)) {
               case 1:
                  keyHold[2] = true;
                  keyPressed[2] = true;
                  return;
               case 2:
                  keyHold[4] = true;
                  keyPressed[4] = true;
                  return;
               case 3:
               case 4:
               case 7:
               default:
                  if (var1 == -21) {
                     var1 = -6;
                  } else if (var1 == -22) {
                     var1 = -7;
                  }
                  break;
               case 5:
                  keyHold[6] = true;
                  keyPressed[6] = true;
                  return;
               case 6:
                  keyHold[8] = true;
                  keyPressed[8] = true;
                  return;
               case 8:
                  keyHold[5] = true;
                  keyPressed[5] = true;
                  return;
            }
         } else if (E) {
            long var2 = System.currentTimeMillis() / 100L;
            switch (var1) {
               case -8:
                  keyHold[5] = true;
                  keyPressed[5] = true;
                  return;
               case 1:
                  timeBB[0] = var2;
                  keyHold[2] = true;
                  keyPressed[2] = true;
                  return;
               case 2:
                  timeBB[1] = var2;
                  keyHold[4] = true;
                  keyPressed[4] = true;
                  return;
               case 5:
                  timeBB[2] = var2;
                  keyHold[6] = true;
                  keyPressed[6] = true;
                  return;
               case 6:
                  timeBB[3] = var2;
                  keyHold[8] = true;
                  keyPressed[8] = true;
                  return;
            }
         }

         if (currentDialog != null) {
            currentDialog.keyPress(var1);
         } else if (currentFace != null) {
            currentFace.keyPress(var1);
         } else if (menuMain == null) {
            if (ChatTextField.isShow) {
               ChatTextField.gI().b(var1);
            } else {
               currentMyScreen.keyPress(var1);
            }
         }

         if (ak) {
            long var5 = System.currentTimeMillis() / 100L;
            switch (var1) {
               case -39:
               case -2:
                  timeBB[3] = var5;
                  break;
               case -38:
               case -1:
                  timeBB[0] = var5;
                  break;
               case -4:
                  timeBB[2] = var5;
                  break;
               case -3:
                  timeBB[1] = var5;
            }
         }

         switch (var1) {
            case -39:
            case -2:
               keyHold[8] = true;
               keyPressed[8] = true;
               return;
            case -38:
            case -1:
               keyHold[2] = true;
               keyPressed[2] = true;
               return;
            case -22:
            case -7:
               keyHold[13] = true;
               keyPressed[13] = true;
               return;
            case -21:
            case -6:
               keyHold[12] = true;
               keyPressed[12] = true;
               return;
            case -5:
            case 10:
               keyHold[5] = true;
               keyPressed[5] = true;
               return;
            case -4:
               keyHold[6] = true;
               keyPressed[6] = true;
            default:
               return;
            case -3:
               keyHold[4] = true;
               keyPressed[4] = true;
               return;
            case 35:
               keyHold[11] = true;
               keyPressed[11] = true;
               return;
            case 42:
               keyHold[10] = true;
               keyPressed[10] = true;
         }
      }
   }

   public static boolean a(int var0) {
      if (keyPressed[var0]) {
         keyPressed[var0] = false;
         return true;
      } else {
         return false;
      }
   }

   public final void keyReleased(int var1) {
      if (ah) {
         switch (this.getGameAction(var1)) {
            case 1:
               keyHold[2] = false;
               return;
            case 2:
               keyHold[4] = false;
               return;
            case 3:
            case 4:
            case 7:
            default:
               if (var1 == -21) {
                  var1 = -6;
               } else if (var1 == -22) {
                  var1 = -7;
               }
               break;
            case 5:
               keyHold[6] = false;
               return;
            case 6:
               keyHold[8] = false;
               return;
            case 8:
               keyHold[5] = false;
               return;
         }
      } else if (E && var1 == 27) {
         var1 = -7;
      }

      switch (var1) {
         case -39:
         case -2:
            if (!ak && !E) {
               keyHold[8] = false;
            }

            keyReleased[8] = true;
            return;
         case -38:
         case -1:
            if (!ak && !E) {
               keyHold[2] = false;
            }

            keyReleased[2] = true;
            return;
         case -22:
         case -7:
            keyHold[13] = false;
            keyReleased[13] = true;
            return;
         case -21:
         case -6:
            keyHold[12] = false;
            keyReleased[12] = true;
            return;
         case -5:
         case 10:
            keyHold[5] = false;
            keyReleased[5] = true;
            return;
         case -4:
            if (!ak && !E) {
               keyHold[6] = false;
            }

            keyReleased[6] = true;
         default:
            return;
         case -3:
            if (!ak && !E) {
               keyHold[4] = false;
            }

            keyReleased[4] = true;
            return;
         case 35:
            keyHold[11] = false;
            keyReleased[11] = true;
            return;
         case 42:
            keyHold[10] = false;
            keyReleased[10] = true;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      au.addElement(new AvPosition(var1, var2));
      px = var1;
      py = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      isPointerClick = true;
      isPointerDown = true;
      pxLast = var1;
      pyLast = var2;
      px = var1;
      py = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      isPointerDown = false;
      isPointerRelease = true;
      px = var1;
      py = var2;
   }

   public static void clearKeyPressed() {
      isPointerRelease = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         keyPressed[var0] = false;
      }

   }

   public static void f() {
      isPointerRelease = false;
      isPointerDown = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         keyHold[var0] = false;
      }

   }

   public static void clearKeyReleased() {
      isPointerDown = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         keyReleased[var0] = false;
      }

   }

   public static String a(String var0, int var1) {
      String var2 = "";

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         var2 = var2 + (char)(var0.charAt(var3) + var1);
      }

      return var2;
   }

   public static void a(int var0, int var1, int var2, int var3, int var4) {
      ac.addElement(new class_cp(var1, var2, var0, -1, (Image)null, var4, -1, -1));
   }

   public static void addFlyText(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      ac.addElement(new class_cp(var1, var2, var0, -1, (Image)null, 0, var5, -1));
   }

   public static void a(int var0, int var1, int var2, int var3, Image var4, int var5) {
      ac.addElement(new class_cp(var1, var2, var0, -1, var4, var5, -1, -1));
   }

   public static void addFlyTextSmall(String var0, int var1, int var2, int var3, int var4, int var5) {
      ac.addElement(new class_cp(var1, var2, var0, -1, var4, var5));
   }

   public static void paintPlus(Graphics var0) {
      var0.drawImage(imagePlug, 0, 1, 0);
   }

   public static void paintPlus2(Graphics var0) {
      var0.drawImage(imagePlug, 0, 1, 0);
   }

   protected final void paint(Graphics var1) {
      var1.translate(0, 0);
      if (load != 0) {
         if (currentMyScreen != null) {
            currentMyScreen.paint(var1);
         }

         if (currentEffect.size() > 0 && currentMyScreen != RoomListOnScr.me && currentMyScreen != BoardListOnScr.me) {
            for(int var2 = 0; var2 < currentEffect.size(); ++var2) {
               ((Effect) currentEffect.elementAt(var2)).paint(var1);
            }
         }

         if (ChatTextField.isShow) {
            ChatTextField.gI().paint(var1);
         }

         if (currentFace != null) {
            currentFace.paint(var1);
         }

         if (currentDialog != null) {
            currentDialog.paint(var1);
         } else if (menuMain != null) {
            menuMain.paint(var1);
         }

         if (welcome != null) {
            welcome.paint(var1);
         }

         Graphics var6 = var1;
         resetTrans(var1);
         var1.translate(-AvCamera.gI().xCam, -AvCamera.gI().yCam);

         int var3;
         for(var3 = 0; var3 < ac.size(); ++var3) {
            ((class_cp)ac.elementAt(var3)).a(var6);
         }

         if (ab > 0) {
            var6 = var1;
            var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
            var1.setClip(0, 0, w, h);
            var1.setColor(0);

            for(var3 = 0; var3 < w / 30 + 1; ++var3) {
               var6.drawImage(aa, var3 * 30, ab - 30, 0);
            }

            var6.fillRect(0, ab, w, 1);
            if (listInfoSV.size() > 0) {
               resetTrans(var6);
               var3 = ab / 2 - AvMain.ag / 2;
               var6.setClip(0, var3, w, AvMain.ag + 2);
               StringObj var4 = (StringObj) listInfoSV.elementAt(0);
               borderFont.drawString(var6, var4.str, var4.x, var3, 0);
               resetTrans(var6);
            }
         }
      }

      if (load != -1) {
         resetTrans(var1);
         var1.setColor(1);
         var1.fillRect(0, 0, w, hh - this.as);
         var1.fillRect(0, hh + this.as, w, hh - this.as + 2 + hTab);
         if (load != 1) {
            MsgDlg.b.drawFrame(this.at, hw, hh, 0, 3, var1);
         }
      }

      if (z != null) {
         z.a(var1);
      }

      resetTrans(var1);
      if (E) {
         synchronized(an) {
            an.notify();
         }
      }
   }

   public static void resetTrans(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.translate(0, 0);
      var0.setClip(0, 0, w, hCan);
   }

   public static void endDlg() {
      msgdlg.setIsWaiting(false);
      currentDialog = null;
   }

   public static void startOKDlg(String var0) {
      msgdlg.setInfoC(var0, new Command(T.z, -1), (Vector)null);
   }

   public static void a(String var0, Vector var1) {
      if (OnScreen.isOngame) {
         msgdlg.setInfoC(var0, (Command)null, var1);
      } else {
         msgdlg.setInfoC(var0, new Command("", -1), var1);
      }
   }

   public static void startOKDlg(String var0, IAction var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T.o, var1));
      var2.addElement(ad);
      a(var0, var2);
   }

   public static void startOKDlg(String var0, int var1, AvMain var2) {
      Vector var3;
      (var3 = new Vector()).addElement(new Command(T.o, var1, var2));
      var3.addElement(ad);
      a(var0, var3);
   }

   public static void startOK(String var0, IAction var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T.z, var1));
      a(var0, var2);
   }

   public static void startOKDlg(String var0, int var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T.o, var1));
      var2.addElement(ad);
      a(var0, var2);
   }

   public static void startOK(String var0, int var1, AvMain var2) {
      Vector var3;
      (var3 = new Vector()).addElement(new Command(T.z, var1, var2));
      a(var0, var3);
   }

   public static void startWaitDlg(String var0) {
      msgdlg.setInfoC(var0, (Command)null, (Vector)null);
      msgdlg.setIsWaiting(true);
   }

   public static void startWaitCancelDlg(String var0) {
      msgdlg.setInfoC(var0, new Command(T.cm, -1), (Vector)null);
   }

   public static void startWaitDlg() {
      startWaitDlg(T.b);
   }

   public static String getPriceMoney(int var0, int var1, int var2, boolean var3) {
      String var4 = "";
      if (var0 > 0) {
         var4 = var4 + getMoneys(var0) + T.C;
      }

      if (var1 > 0) {
         if (var0 > 0) {
            var4 = var4 + " - ";
         }

         var4 = var4 + getMoneys(var1) + T.D;
      }

      if (var2 >= 0) {
         if (!var4.equals("")) {
            var4 = var4 + " - ";
         }

         var4 = var4 + getMoneys(var2) + T.E;
      }

      return var4;
   }

   public static String getPriceMoney(int var0, int var1, boolean var2) {
      String var3 = "";
      if (var0 > 0) {
         var3 = var3 + getMoneys(var0) + (var2 ? T.C : T.T);
      }

      if (var1 > 0) {
         if (var0 > 0) {
            var3 = var3 + " - ";
         }

         var3 = var3 + getMoneys(var1) + T.D;
      }

      return var3;
   }

   public static String getMoneys(int var0) {
      String var1 = "";
      int var2 = var0 / 1000 + 1;

      for(int var3 = 0; var3 < var2; ++var3) {
         if (var0 < 1000) {
            var1 = var0 + var1;
            break;
         }

         int var4;
         if ((var4 = var0 % 1000) == 0) {
            var1 = ".000" + var1;
         } else if (var4 < 10) {
            var1 = ".00" + var4 + var1;
         } else if (var4 < 100) {
            var1 = ".0" + var4 + var1;
         } else {
            var1 = "." + var4 + var1;
         }

         var0 /= 1000;
      }

      return var1;
   }

   public final void commandAction(javax.microedition.lcdui.Command var1, Displayable var2) {
      if (var1 != null && var1 != List.SELECT_COMMAND) {
         if (var1 == null) {
            if (currentMyScreen == class_jv.a) {
               OnScreen.e().switchToMe();
            } else {
               MapScr.gI().switchToMe();
            }

            Display.getDisplay(GameMidlet.h).setCurrent(this);
            this.setFullScreenMode(true);
            OnSplashScr.isOpen = false;
         }
      } else {
         List list = (List) var2;
         if (list != null && list.getSelectedIndex() != 0) {
            OnScreen.isOngame = true;
            OnScreen.e().switchToMe();
         }

         OnSplashScr.isOpen = false;
         Display.getDisplay(GameMidlet.h).setCurrent(this);
         this.setFullScreenMode(true);
      }

      if (var1 == al) {
         keyPressed[12] = true;
      } else {
         if (var1 == am) {
            keyPressed[13] = true;
         }

      }
   }

   public static boolean isPointer(int var0, int var1, int var2, int var3) {
      return !isPointerDown && !isPointerRelease ? false : b(var0, var1, var2, var3);
   }

   public static boolean b(int var0, int var1, int var2, int var3) {
      return px >= var0 && px <= var0 + var2 && py >= var1 && py <= var1 + var3;
   }

   public static void getTypeMoney(int var0, int var1, IAction var2, IAction var3, IAction var4) {
      String var5 = "";
      Vector var6 = new Vector();
      if (var0 > 0) {
         var6.addElement(new Command(var1 <= 0 ? T.o : T.C, var2));
         var5 = " " + var0 + T.C;
      }

      if (var1 > 0) {
         var6.addElement(new Command(var0 <= 0 ? T.o : T.D, var3));
         var5 = " " + var1 + T.D;
      }

      if (var6.size() == 1) {
         var5 = T.cR + var5 + " " + T.p + " ?";
      } else {
         var5 = T.aG + " \n" + var0 + T.C + " - " + var1 + " " + T.D;
      }

      if (var4 == null) {
         var6.addElement(ad);
      } else {
         var6.addElement(new Command(T.p, var4));
      }

      a(var5, var6);
   }

   public static int getSecond() {
      return (int)(System.currentTimeMillis() / 1000L);
   }

   public static int dx() {
      return pxLast - px;
   }

   public static int dy() {
      return pyLast - py;
   }

   public static boolean isPaintIconVir() {
      return currentDialog == null && menuMain == null && currentMyScreen != MessageScr.me && currentMyScreen != PopupShop.gI() && currentMyScreen != ListScr.instance && currentMyScreen != RoomListOnScr.me && currentMyScreen != BoardListOnScr.me && currentMyScreen != MenuCenter.me && currentMyScreen != OnScreen.a && currentMyScreen != MiniMap.me && currentMyScreen != MoneyScr.a && !HouseScr.isChange && !HouseScr.isSelectObj && currentMyScreen != ParkListSrc.instance && (currentMyScreen != DiamondScr.me_ || !BoardScr.isStartGame);
   }
}

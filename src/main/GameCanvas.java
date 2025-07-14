package main;

import java.util.Vector;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

import avt.*;

public final class GameCanvas extends Canvas implements Runnable, CommandListener {
   public static GameCanvas a;
   private static boolean ag;
   public static boolean[] b = new boolean[14];
   public static boolean[] c = new boolean[14];
   public static boolean[] d = new boolean[14];
   public static boolean e;
   public static boolean f;
   public static boolean g;
   public static int h;
   public static int i;
   public static int j;
   public static int k;
   public static int l;
   public static int m = 0;
   public static int n;
   public static int o;
   public static int p;
   public static int q;
   private static boolean ah;
   public static MyScreen r;
   public static MsgDlg s;
   public static MenuMain t;
   public static class_hb u;
   public static Dialog v;
   private static int ai;
   public static AvatarData w;
   public static LoadMap x;
   public static CameraList y;
   public static GamePad z;
   public static Face A;
   public static Vector B = new Vector();
   private static long[] aj;
   public static Vector C = new Vector();
   public static Welcome D;
   public static boolean E;
   private static boolean ak;
   public static boolean F;
   public static boolean G;
   public static boolean H = false;
   public static boolean I = false;
   public static int J = -1;
   private static javax.microedition.lcdui.Command al;
   private static javax.microedition.lcdui.Command am;
   private static Object an = new Object();
   public static FontX K;
   public static FontX L;
   public static FontX M;
   public static FontX N;
   public static FontX O;
   public static FontX P;
   public static FontX Q;
   public static FontX R;
   public static IPaint S;
   public static int T = 0;
   public static int U = 0;
   private static int ao;
   public static int V;
   public static int W;
   public static T1 X;
   public static Image Y;
   public static int Z = 1;
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

   public GameCanvas() {
      this.setFullScreenMode(true);
      m = this.getWidth();
      q = n = this.getHeight();
      X = new T1();
      AvMain.Y = 1;
      if (CRes.b(GameMidlet.m) == null) {
         FarmData.c();
      }

      Z = 0;
      K = new mFont(0);
      L = new mFont(1);
      M = new mFont(2);
      N = new mFont(3);
      O = new mFont(4);
      P = new mFont(5);
      Q = new mFont(6);
      R = new mFont(7);
      S = new MediumPaint();
      MyScreen.al = K.a() + 6;
      AvMain.af = (byte)N.a();
      AvMain.ag = (byte)L.a();
      AvMain.ah = (byte)K.a();
      AvMain.ai = (byte)P.a();
      this.b();
      o = m / 2;
      p = n / 2;
      a = this;
      System.gc();
      TField.a(0);
      if (ah = this.getKeyCode(8) == -20) {
         TField.a(1);
      }

      String var1;
      E = (var1 = System.getProperty("microedition.platform")).indexOf("RIM") == 0 || var1.indexOf("BlackBerry") == 0;
      ak = var1.indexOf("NX") == 0;
      F = var1.indexOf("NokiaN7") == 0;
      H = this.hasPointerEvents();
      if (E) {
         ai = 5;
         if (var1.indexOf("BlackBerry") == 0) {
            ai = 1;
         }

         TField.a(3);
         this.setCommandListener(this);
         am = new javax.microedition.lcdui.Command(T1.d, 2, 1);
         al = new javax.microedition.lcdui.Command(T1.c, 1, 1);
         this.addCommand(al);
         this.addCommand(am);
      }

      if (ak) {
         ai = 2;
      }

      if (E || ak) {
         aj = new long[4];
      }

      TField.b(a.getGameAction(48) == 0 && a.getGameAction(49) == 0 && a.getGameAction(50) == 0 && a.getGameAction(51) == 0 && a.getGameAction(52) == 0 && a.getGameAction(53) == 0 && a.getGameAction(54) == 0 && a.getGameAction(55) == 0 && a.getGameAction(56) == 0 && a.getGameAction(57) == 0);
      CRes.a();
      t = new MenuSub();
      s = new MsgDlg();
      w = new AvatarData();
      u = new class_hb();
      x = new LoadMap();
      y = new CameraList();
      OptionScr.b().e();
      S.c();
      if (this.hasPointerEvents()) {
         au = new Vector();
      }

      a();
      if ((V = (ao = (int)(Runtime.getRuntime().totalMemory() / 1024L)) / 17) < 60) {
         V = 60;
      }

   }

   public static void a() {
      ad = new Command(T1.p, -1);
      MenuSub.a().c();
      if (r != null) {
         r.c();
      }

   }

   public final void sizeChanged(int var1, int var2) {
      this.setFullScreenMode(true);
      this.b();
   }

   public final void b() {
      m = this.getWidth();
      n = this.getHeight();
      AvMain.aa = 20;
      if (m < 176) {
         AvMain.aa = 4;
      }

      if (OptionScr.d && H) {
         z = new GamePad();
      } else {
         G = false;
         z = null;
      }

      q = n;
      o = m / 2;
      S.c();
      p = n / 2;
      S.a();
      if (t != null) {
         t = null;
      }

      if (LoginScr.a != null) {
         LoginScr.b().f();
      }

      AvCamera.a().b(LoadMap.a);
      if (PopupShop.a != null) {
         PopupShop.e();
      }

      if (PaintPopup.c != null) {
         PaintPopup.a().b();
      }

      if (s != null) {
         s.a();
         s.a(s.a);
      }

      if (r != null) {
         if (r == RaceScr.a) {
            RaceScr.b();
         }

         if (BoardScr.i == r) {
            BoardScr.i.e();
         }

         if (MessageScr.d != null) {
            MessageScr.d.e();
         }

         if (MiniMap.a != null) {
            MiniMap.gI().e();
         }

         if (RoomListOnScr.a == r) {
            RoomListOnScr.a.e();
         }

         if (BoardListOnScr.a == r) {
            BoardListOnScr.a.g();
         }
      }

      if (u != null) {
         u.b();
      }

      if (class_im.a != null) {
         class_im.d().b();
      }

      if (CustomTab.a != null) {
         CustomTab.b().d();
      }

      if (H && MyScreen.ap == null) {
         FilePack.b(T1.aw);
         MyScreen.ap = FilePack.a("bpa");
         MyScreen.aq = FilePack.a("icon_chat");
         FilePack.a();
      }

      if (r != null) {
         if (r == class_ez.a) {
            class_ez.b().e();
         }

         if (r == OptionScr.a) {
            OptionScr.b().e();
         }

         if (r == ListScr.b()) {
            ListScr.b().f();
         }

         if (r == MoneyScr.b()) {
            MoneyScr.b().e();
         }

         if (A != null) {
            A = null;
         }
      }

   }

   public static void a(String var0) {
      if (!OnScreen.b && !var0.equals("")) {
         StringObj var1;
         (var1 = new StringObj(var0, -K.a(var0))).aw = m + 10;
         C.addElement(var1);
         if (ab == 0) {
            ab = 1;
         }

         U = 0;
      }
   }

   public static void c() {
      if (!Session_ME.a().b()) {
         int var0;
         if ((var0 = class_ez.b().ar - 1) < 0) {
            var0 = 0;
         }

         String var1 = "socket://" + GameMidlet.b[OptionScr.b().b[4]][class_ez.b().b][var0] + ":" + GameMidlet.c[OptionScr.b().b[4]][class_ez.b().b][var0];
         if (E) {
            if (OptionScr.e) {
               var1 = var1 + ";interface=wifi";
            } else {
               var1 = var1 + ";deviceside=true";
            }
         }

         Session_ME.a().a(var1);
         GlobalService.gI().b();
      }

   }

   public final void d() {
      if (!aq) {
         (new Thread(this)).start();
      }

      aq = true;
      Session_ME.a().c();
   }

   public final void run() {
      ag = true;

      while(ag) {
         try {
            if (this.ap > 0) {
               --this.ap;
               if (this.ap == 0) {
                  Display.getDisplay(GameMidlet.h).vibrate(0);
               }
            }

            long var1 = System.currentTimeMillis();
            if (++l > 10000) {
               if (System.currentTimeMillis() - this.ar > 20000L && r == LoginScr.a) {
                  GameMidlet.h.notifyDestroyed();
               }

               l = 0;
            }

            if (J != -1) {
               if (J == 1) {
                  this.as += 15;
               } else {
                  ++this.at;
                  if (this.at >= 8) {
                     this.at = 0;
                  }
               }

               if (this.as >= p) {
                  this.as = 0;
                  J = -1;
               }
            }

            if (J != 0) {
               if (z != null) {
                  z.a();
               }

               if (D != null && v == null) {
                  D.l();
               }

               int var3;
               if (B.size() > 0) {
                  for(var3 = 0; var3 < B.size(); ++var3) {
                     ((Effect)B.elementAt(var3)).b();
                  }
               }

               if (r != null) {
                  if (class_im.c) {
                     class_im.d().l();
                  }

                  if (C.size() <= 0) {
                     if (ab > 0) {
                        --ab;
                     }
                  } else {
                     if (ab < AvMain.ag) {
                        ++ab;
                     }

                     StringObj var9;
                     StringObj var10000 = var9 = (StringObj)C.elementAt(0);
                     var10000.aw -= 2;
                     if (var9.aw < var9.c) {
                        C.removeElementAt(0);
                     }
                  }

                  r.k();
                  if (y.m) {
                     CameraList var10 = y;
                     if (t == null && v == null) {
                        if (var10.n == 0) {
                           if (CameraList.i < 0) {
                              CameraList.j = 0;
                           } else if (CameraList.i > var10.c) {
                              CameraList.j = var10.c;
                           }
                        } else {
                           if (CameraList.i < 0 || CameraList.i > var10.c) {
                              if (var10.n > 500) {
                                 var10.n = 500;
                              } else if (var10.n < -500) {
                                 var10.n = -500;
                              }

                              var10.n -= var10.n / 5;
                              if (CRes.f(var10.n / 10) <= 10) {
                                 var10.n = 0;
                              }
                           }

                           CameraList.j = CameraList.i += var10.n / 15;
                           var10.n -= var10.n / 20;
                        }

                        if (var10.o == 0) {
                           if (CameraList.k < 0) {
                              CameraList.l = 0;
                           } else if (CameraList.k > var10.h) {
                              CameraList.l = var10.h;
                           }
                        } else {
                           if (CameraList.k < 0 || CameraList.k > var10.h) {
                              if (var10.o > 500) {
                                 var10.o = 500;
                              } else if (var10.o < -500) {
                                 var10.o = -500;
                              }

                              var10.o -= var10.o / 5;
                              if (CRes.f(var10.o / 10) <= 10) {
                                 var10.o = 0;
                              }
                           }

                           CameraList.l = CameraList.k += var10.o / 15;
                           var10.o -= var10.o / 20;
                        }

                        if (CameraList.i != CameraList.j) {
                           var10.b = CameraList.j - CameraList.i << 2;
                           var10.a += var10.b;
                           CameraList.i += var10.a >> 4;
                           var10.a &= 15;
                        }

                        if (CameraList.k != CameraList.l) {
                           var10.g = CameraList.l - CameraList.k << 2;
                           var10.f += var10.g;
                           CameraList.k += var10.f >> 4;
                           var10.f &= 15;
                        }
                     }
                  }

                  if (v != null) {
                     v.l();
                  } else if (A != null) {
                     if (D == null) {
                        A.l();
                     }
                  } else if (t != null) {
                     t.l();
                     if (t != null) {
                        t.k();
                     }
                  } else {
                     if (A == null && !class_im.c) {
                        r.l();
                     }

                     if (y.m && A == null) {
                        y.a();
                     }
                  }

                  if (l % 20 == 10) {
                     AvatarData.g();
                     FarmData.d();
                     if ((byte)((int)(Runtime.getRuntime().freeMemory() / 1024L)) < 100) {
                        System.gc();
                     }
                  }
               }

               if (D != null) {
                  D.k();
               }

               g = false;
               f = false;

               for(var3 = 0; var3 < ac.size(); ++var3) {
                  ((class_cp)ac.elementAt(var3)).a();
               }

               if (E || ak) {
                  for(var3 = 0; var3 < 4; ++var3) {
                     if (d[(var3 << 1) + 2] && System.currentTimeMillis() / 100L - aj[var3] > (long)ai) {
                        d[(var3 << 1) + 2] = false;
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
      if (J == -1) {
         this.ar = System.currentTimeMillis();
         if (ah) {
            switch (this.getGameAction(var1)) {
               case 1:
                  d[2] = true;
                  b[2] = true;
                  return;
               case 2:
                  d[4] = true;
                  b[4] = true;
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
                  d[6] = true;
                  b[6] = true;
                  return;
               case 6:
                  d[8] = true;
                  b[8] = true;
                  return;
               case 8:
                  d[5] = true;
                  b[5] = true;
                  return;
            }
         } else if (E) {
            long var2 = System.currentTimeMillis() / 100L;
            switch (var1) {
               case -8:
                  d[5] = true;
                  b[5] = true;
                  return;
               case 1:
                  aj[0] = var2;
                  d[2] = true;
                  b[2] = true;
                  return;
               case 2:
                  aj[1] = var2;
                  d[4] = true;
                  b[4] = true;
                  return;
               case 5:
                  aj[2] = var2;
                  d[6] = true;
                  b[6] = true;
                  return;
               case 6:
                  aj[3] = var2;
                  d[8] = true;
                  b[8] = true;
                  return;
            }
         }

         if (v != null) {
            v.d(var1);
         } else if (A != null) {
            A.d(var1);
         } else if (t == null) {
            if (class_im.c) {
               class_im.d().b(var1);
            } else {
               r.d(var1);
            }
         }

         if (ak) {
            long var5 = System.currentTimeMillis() / 100L;
            switch (var1) {
               case -39:
               case -2:
                  aj[3] = var5;
                  break;
               case -38:
               case -1:
                  aj[0] = var5;
                  break;
               case -4:
                  aj[2] = var5;
                  break;
               case -3:
                  aj[1] = var5;
            }
         }

         switch (var1) {
            case -39:
            case -2:
               d[8] = true;
               b[8] = true;
               return;
            case -38:
            case -1:
               d[2] = true;
               b[2] = true;
               return;
            case -22:
            case -7:
               d[13] = true;
               b[13] = true;
               return;
            case -21:
            case -6:
               d[12] = true;
               b[12] = true;
               return;
            case -5:
            case 10:
               d[5] = true;
               b[5] = true;
               return;
            case -4:
               d[6] = true;
               b[6] = true;
            default:
               return;
            case -3:
               d[4] = true;
               b[4] = true;
               return;
            case 35:
               d[11] = true;
               b[11] = true;
               return;
            case 42:
               d[10] = true;
               b[10] = true;
         }
      }
   }

   public static boolean a(int var0) {
      if (b[var0]) {
         b[var0] = false;
         return true;
      } else {
         return false;
      }
   }

   public final void keyReleased(int var1) {
      if (ah) {
         switch (this.getGameAction(var1)) {
            case 1:
               d[2] = false;
               return;
            case 2:
               d[4] = false;
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
               d[6] = false;
               return;
            case 6:
               d[8] = false;
               return;
            case 8:
               d[5] = false;
               return;
         }
      } else if (E && var1 == 27) {
         var1 = -7;
      }

      switch (var1) {
         case -39:
         case -2:
            if (!ak && !E) {
               d[8] = false;
            }

            c[8] = true;
            return;
         case -38:
         case -1:
            if (!ak && !E) {
               d[2] = false;
            }

            c[2] = true;
            return;
         case -22:
         case -7:
            d[13] = false;
            c[13] = true;
            return;
         case -21:
         case -6:
            d[12] = false;
            c[12] = true;
            return;
         case -5:
         case 10:
            d[5] = false;
            c[5] = true;
            return;
         case -4:
            if (!ak && !E) {
               d[6] = false;
            }

            c[6] = true;
         default:
            return;
         case -3:
            if (!ak && !E) {
               d[4] = false;
            }

            c[4] = true;
            return;
         case 35:
            d[11] = false;
            c[11] = true;
            return;
         case 42:
            d[10] = false;
            c[10] = true;
      }
   }

   protected final void pointerDragged(int var1, int var2) {
      au.addElement(new AvPosition(var1, var2));
      h = var1;
      i = var2;
   }

   protected final void pointerPressed(int var1, int var2) {
      g = true;
      e = true;
      j = var1;
      k = var2;
      h = var1;
      i = var2;
   }

   protected final void pointerReleased(int var1, int var2) {
      e = false;
      f = true;
      h = var1;
      i = var2;
   }

   public static void e() {
      f = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         b[var0] = false;
      }

   }

   public static void f() {
      f = false;
      e = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         d[var0] = false;
      }

   }

   public static void g() {
      e = false;

      for(int var0 = 0; var0 < 14; ++var0) {
         c[var0] = false;
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

   public static void a(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      ac.addElement(new class_cp(var1, var2, var0, -1, (Image)null, 0, var5, -1));
   }

   public static void a(int var0, int var1, int var2, int var3, Image var4, int var5) {
      ac.addElement(new class_cp(var1, var2, var0, -1, var4, var5, -1, -1));
   }

   public static void a(String var0, int var1, int var2, int var3, int var4, int var5) {
      ac.addElement(new class_cp(var1, var2, var0, -1, var4, var5));
   }

   public static void a(Graphics var0) {
      var0.drawImage(Y, 0, 1, 0);
   }

   public static void b(Graphics var0) {
      var0.drawImage(Y, 0, 1, 0);
   }

   protected final void paint(Graphics var1) {
      var1.translate(0, 0);
      if (J != 0) {
         if (r != null) {
            r.a(var1);
         }

         if (B.size() > 0 && r != RoomListOnScr.a && r != BoardListOnScr.a) {
            for(int var2 = 0; var2 < B.size(); ++var2) {
               ((Effect)B.elementAt(var2)).a(var1);
            }
         }

         if (class_im.c) {
            class_im.d().a(var1);
         }

         if (A != null) {
            A.a(var1);
         }

         if (v != null) {
            v.a(var1);
         } else if (t != null) {
            t.a(var1);
         }

         if (D != null) {
            D.a(var1);
         }

         Graphics var6 = var1;
         c(var1);
         var1.translate(-AvCamera.a().a, -AvCamera.a().b);

         int var3;
         for(var3 = 0; var3 < ac.size(); ++var3) {
            ((class_cp)ac.elementAt(var3)).a(var6);
         }

         if (ab > 0) {
            var6 = var1;
            var1.translate(-var1.getTranslateX(), -var1.getTranslateY());
            var1.setClip(0, 0, m, n);
            var1.setColor(0);

            for(var3 = 0; var3 < m / 30 + 1; ++var3) {
               var6.drawImage(aa, var3 * 30, ab - 30, 0);
            }

            var6.fillRect(0, ab, m, 1);
            if (C.size() > 0) {
               c(var6);
               var3 = ab / 2 - AvMain.ag / 2;
               var6.setClip(0, var3, m, AvMain.ag + 2);
               StringObj var4 = (StringObj)C.elementAt(0);
               L.a(var6, var4.a, var4.aw, var3, 0);
               c(var6);
            }
         }
      }

      if (J != -1) {
         c(var1);
         var1.setColor(1);
         var1.fillRect(0, 0, m, p - this.as);
         var1.fillRect(0, p + this.as, m, p - this.as + 2 + T);
         if (J != 1) {
            MsgDlg.b.a(this.at, o, p, 0, 3, var1);
         }
      }

      if (z != null) {
         z.a(var1);
      }

      c(var1);
      if (E) {
         synchronized(an) {
            an.notify();
         }
      }
   }

   public static void c(Graphics var0) {
      var0.translate(-var0.getTranslateX(), -var0.getTranslateY());
      var0.translate(0, 0);
      var0.setClip(0, 0, m, q);
   }

   public static void h() {
      s.a(false);
      v = null;
   }

   public static void b(String var0) {
      s.a(var0, new Command(T1.z, -1), (Vector)null);
   }

   public static void a(String var0, Vector var1) {
      if (OnScreen.b) {
         s.a(var0, (Command)null, var1);
      } else {
         s.a(var0, new Command("", -1), var1);
      }
   }

   public static void a(String var0, IAction var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T1.o, var1));
      var2.addElement(ad);
      a(var0, var2);
   }

   public static void a(String var0, int var1, AvMain var2) {
      Vector var3;
      (var3 = new Vector()).addElement(new Command(T1.o, var1, var2));
      var3.addElement(ad);
      a(var0, var3);
   }

   public static void b(String var0, IAction var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T1.z, var1));
      a(var0, var2);
   }

   public static void b(String var0, int var1) {
      Vector var2;
      (var2 = new Vector()).addElement(new Command(T1.o, var1));
      var2.addElement(ad);
      a(var0, var2);
   }

   public static void b(String var0, int var1, AvMain var2) {
      Vector var3;
      (var3 = new Vector()).addElement(new Command(T1.z, var1, var2));
      a(var0, var3);
   }

   public static void c(String var0) {
      s.a(var0, (Command)null, (Vector)null);
      s.a(true);
   }

   public static void d(String var0) {
      s.a(var0, new Command(T1.cm, -1), (Vector)null);
   }

   public static void i() {
      c(T1.b);
   }

   public static String a(int var0, int var1, int var2, boolean var3) {
      String var4 = "";
      if (var0 > 0) {
         var4 = var4 + b(var0) + T1.C;
      }

      if (var1 > 0) {
         if (var0 > 0) {
            var4 = var4 + " - ";
         }

         var4 = var4 + b(var1) + T1.D;
      }

      if (var2 >= 0) {
         if (!var4.equals("")) {
            var4 = var4 + " - ";
         }

         var4 = var4 + b(var2) + T1.E;
      }

      return var4;
   }

   public static String a(int var0, int var1, boolean var2) {
      String var3 = "";
      if (var0 > 0) {
         var3 = var3 + b(var0) + (var2 ? T1.C : T1.T);
      }

      if (var1 > 0) {
         if (var0 > 0) {
            var3 = var3 + " - ";
         }

         var3 = var3 + b(var1) + T1.D;
      }

      return var3;
   }

   public static String b(int var0) {
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
            if (r == class_jv.a) {
               OnScreen.e().a();
            } else {
               MapScr.b().a();
            }

            Display.getDisplay(GameMidlet.h).setCurrent(this);
            this.setFullScreenMode(true);
            OnSplashScr.d = false;
         }
      } else {
         List list = (List) var2;
         if (list != null && list.getSelectedIndex() != 0) {
            OnScreen.b = true;
            OnScreen.e().a();
         }

         OnSplashScr.d = false;
         Display.getDisplay(GameMidlet.h).setCurrent(this);
         this.setFullScreenMode(true);
      }

      if (var1 == al) {
         b[12] = true;
      } else {
         if (var1 == am) {
            b[13] = true;
         }

      }
   }

   public static boolean a(int var0, int var1, int var2, int var3) {
      return !e && !f ? false : b(var0, var1, var2, var3);
   }

   public static boolean b(int var0, int var1, int var2, int var3) {
      return h >= var0 && h <= var0 + var2 && i >= var1 && i <= var1 + var3;
   }

   public static void a(int var0, int var1, IAction var2, IAction var3, IAction var4) {
      String var5 = "";
      Vector var6 = new Vector();
      if (var0 > 0) {
         var6.addElement(new Command(var1 <= 0 ? T1.o : T1.C, var2));
         var5 = " " + var0 + T1.C;
      }

      if (var1 > 0) {
         var6.addElement(new Command(var0 <= 0 ? T1.o : T1.D, var3));
         var5 = " " + var1 + T1.D;
      }

      if (var6.size() == 1) {
         var5 = T1.cR + var5 + " " + T1.p + " ?";
      } else {
         var5 = T1.aG + " \n" + var0 + T1.C + " - " + var1 + " " + T1.D;
      }

      if (var4 == null) {
         var6.addElement(ad);
      } else {
         var6.addElement(new Command(T1.p, var4));
      }

      a(var5, var6);
   }

   public static int j() {
      return (int)(System.currentTimeMillis() / 1000L);
   }

   public static int k() {
      return j - h;
   }

   public static int l() {
      return k - i;
   }

   public static boolean m() {
      return v == null && t == null && r != MessageScr.d && r != PopupShop.b() && r != ListScr.a && r != RoomListOnScr.a && r != BoardListOnScr.a && r != MenuCenter.a && r != OnScreen.a && r != MiniMap.a && r != MoneyScr.a && !HouseScr.e && !HouseScr.b && r != class_hk.a && (r != DiamondScr.a || !BoardScr.j);
   }
}

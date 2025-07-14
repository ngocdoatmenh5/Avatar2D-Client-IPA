package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class TField {
   public int a;
   public int b;
   public int c;
   public int d;
   private boolean v;
   private boolean w = false;
   public boolean e = true;
   private static int x = 1;
   private static int[] y = new int[]{18, 14, 11, 9, 6, 4, 2};
   public static int f = 0;
   private static String[] z = new String[]{" 0", ".,@?!_1\"/$-():*+<=>;%&~#%^&*{}[];'/1", "abc2âă", "def3đê", "ghi4", "jkl5", "mno6ôơ", "pqrs7", "tuv8ư", "wxyz9", "*", "#"};
   private static String[] A = new String[]{"0", "1", "abc2", "def3", "ghi4", "jkl5", "mno6", "pqrs7", "tuv8", "wxyz9", "0", "0"};
   private static String[] B = new String[]{" 0", "er1", "ty2", "ui3", "df4", "gh5", "jk6", "cv7", "bn8", "m9", "0", "0", "qw!", "as?", "zx", "op.", "l,"};
   private String C = "";
   private String D = "";
   public String g = "";
   public int h = 0;
   public int i = 0;
   private int E = 500;
   public int j = 0;
   private static int F = -1984;
   public int k = 0;
   private int G = 0;
   public int l = 10;
   private int H = 0;
   public static boolean m;
   public static int n = 0;
   public static int o;
   public static final String[] p = new String[]{"abc", "Abc", "ABC", "123"};
   private static int I = 11;
   private static int J;
   private Command K;
   public String q = "";
   public static FrameImage r;
   private static javax.microedition.lcdui.Canvas L;
   public static int s;
   public static IAction t;
   public static boolean u = false;
   private int M = -1;
   private int N = 0;
   private int O = 0;
   private long P = 0L;
   private static String Q = "aáàảãạâấầẩẫậăắằẳẵặeéèẻẽẹêếềểễệiíìỉĩịoóòỏõọôốồổỗộơớờởỡợuúùủũụưứừửữựyýỳỷỹỵ";
   private boolean R = false;
   private static int[][] S = new int[][]{{32, 48}, {49, 69}, {50, 84}, {51, 85}, {52, 68}, {53, 71}, {54, 74}, {55, 67}, {56, 66}, {57, 77}, {42, 128}, {35, 137}, {33, 113}, {63, 97}, {64, 121, 122}, {46, 111}, {44, 108}};

   public static void a(int var0) {
      if (var0 == 1) {
         z[0] = "0";
         z[10] = " *";
         z[11] = "#";
         I = 35;
         J = 42;
      } else if (var0 == 0) {
         z[0] = " 0";
         z[10] = "*";
         z[11] = "#";
         I = 35;
         J = 42;
      } else {
         if (var0 == 2) {
            z[0] = "0";
            z[10] = "*";
            z[11] = " #";
            I = 42;
            J = 35;
         }

      }
   }

   public final void a(boolean var1) {
      if (this.v != var1) {
         n = 0;
      }

      F = -1984;
      o = Canvas.getSecond();
      this.v = var1;
   }

   public final Command a() {
      t = this.K.action;
      return Canvas.stypeInt == 0 ? this.K : null;
   }

   public static void b(boolean var0) {
      m = var0;
      Canvas.M.getWidth("ABC");
   }

   public TField() {
      this.C = "";
      f = AvMain.af + 1;
      this.K = new Command(T.bb, new class_jw(this));
      if (L == null) {
         L = Canvas.instance;
      }

      this.a(false);
      this.d = r.frameHeight;
   }

   public final void b() {
      if (this.h > 0 && this.C.length() > 0) {
         this.C = this.C.substring(0, this.h - 1) + this.C.substring(this.h, this.C.length());
         --this.h;
         this.e(0);
         this.h();
      }

   }

   private void e(int var1) {
      if (this.H == 2) {
         this.g = this.D;
      } else {
         this.g = this.C;
      }

      int var2 = Canvas.M.getWidth(this.g.substring(0, this.h));
      if (var1 == -1) {
         if (var2 + this.j < 15 && this.h > 0 && this.h < this.g.length()) {
            this.j += Canvas.M.getWidth(this.g.substring(this.h, this.h + 1));
         }
      } else if (var1 == 1) {
         if (var2 + this.j > this.c - 25 && this.h < this.g.length() && this.h > 0) {
            this.j -= Canvas.M.getWidth(this.g.substring(this.h - 1, this.h));
         }
      } else {
         this.j = -(var2 - (this.c - 12));
      }

      if (this.j > 0) {
         this.j = 0;
      } else {
         if (this.j < 0) {
            var1 = Canvas.M.getWidth(this.g) - (this.c - 12);
            if (this.j < -var1) {
               this.j = -var1;
            }
         }

      }
   }

   private void f(int var1) {
      if (this.H != 2 && this.H != 3 || var1 >= 48 && var1 <= 57 || var1 >= 65 && var1 <= 90 || var1 >= 97 && var1 <= 122) {
         if (this.C.length() < this.E) {
            String var2 = this.C.substring(0, this.h) + (char)var1;
            if (this.h < this.C.length()) {
               var2 = var2 + this.C.substring(this.h, this.C.length());
            }

            this.C = var2;
            ++this.h;
            this.h();
            this.e(0);
         }

      }
   }

   public static void c() {
      if (++n > 3) {
         n = 0;
      }

      F = I;
      o = Canvas.getSecond();
   }

   private void g(int var1) {
      if (this.H != 0 && this.H != 2 && this.H != 3) {
         if (this.H == 1) {
            this.f(var1);
            this.k = 1;
         }

      } else {
         int var2 = var1;
         String[] var3;
         if (Canvas.E) {
            var3 = B;
         } else if (this.H != 2 && this.H != 3) {
            var3 = z;
         } else {
            var3 = A;
         }

         if (Canvas.E) {
            var2 = var1;
            int var4 = 0;

            int var10000;
            label90:
            while(true) {
               if (var4 >= S.length) {
                  var10000 = -1;
                  break;
               }

               for(int var5 = 0; var5 < S[var4].length; ++var5) {
                  if (S[var4][var5] == var2) {
                     var10000 = var4 + 48;
                     break label90;
                  }
               }

               ++var4;
            }

            var2 = var10000;
            if (var10000 == -1) {
               return;
            }
         }

         String var6;
         char var7;
         if (var2 == F) {
            this.G = (this.G + 1) % var3[var2 - 48].length();
            var7 = var3[var2 - 48].charAt(this.G);
            if (n == 0) {
               var7 = Character.toLowerCase(var7);
            } else if (n == 1) {
               var7 = Character.toUpperCase(var7);
            } else if (n == 2) {
               var7 = Character.toUpperCase(var7);
            } else {
               var7 = var3[var2 - 48].charAt(var3[var2 - 48].length() - 1);
            }

            var6 = this.C.substring(0, this.h - 1) + var7;
            if (this.h < this.C.length()) {
               var6 = var6 + this.C.substring(this.h, this.C.length());
            }

            this.C = var6;
            this.k = y[x];
            this.h();
         } else if (this.C.length() < this.E) {
            if (n == 1 && F != -1984) {
               n = 0;
            }

            this.G = 0;
            var7 = var3[var2 - 48].charAt(this.G);
            if (n == 0) {
               var7 = Character.toLowerCase(var7);
            } else if (n == 1) {
               var7 = Character.toUpperCase(var7);
            } else if (n == 2) {
               var7 = Character.toUpperCase(var7);
            } else {
               var7 = var3[var2 - 48].charAt(var3[var2 - 48].length() - 1);
            }

            var6 = this.C.substring(0, this.h) + var7;
            if (this.h < this.C.length()) {
               var6 = var6 + this.C.substring(this.h, this.C.length());
            }

            this.C = var6;
            this.k = y[x];
            ++this.h;
            this.h();
            this.e(0);
         }

         F = var2;
      }
   }

   public final boolean b(int var1) {
      if (Canvas.E) {
         if (var1 == 8 || var1 == 127) {
            this.b();
         }
      } else if (var1 == 8 || var1 == -8 || var1 == 204) {
         this.b();
         return true;
      }

      if (!Canvas.E && var1 >= 65 && var1 <= 122) {
         m = true;
      }

      if (m && !Canvas.E) {
         if (var1 == 45) {
            if (var1 == F && this.k < y[x]) {
               this.C = this.C.substring(0, this.h - 1) + '_';
               this.g = this.C;
               this.h();
               this.e(0);
               F = -1984;
               return false;
            }

            F = 45;
         }

         if (var1 >= 32) {
            this.f(var1);
            return false;
         }
      }

      if (!m && var1 == I) {
         c();
         this.k = 1;
         F = var1;
         return false;
      } else if (var1 == J && this.H == 0) {
         this.g();
         return false;
      } else {
         if (var1 == 42) {
            var1 = 58;
         }

         if (var1 == 35) {
            var1 = 59;
         }

         if (Canvas.E && var1 >= 48) {
            if (m) {
               this.f(var1);
               this.k = 1;
            } else {
               this.g(var1);
            }
         } else if (var1 >= 48 && var1 <= 59) {
            this.g(var1);
         } else {
            this.G = 0;
            F = -1984;
            if (var1 == 14) {
               if (this.h > 0) {
                  --this.h;
                  this.e(0);
                  this.l = 10;
                  return false;
               }
            } else if (var1 == 15) {
               if (this.h < this.C.length()) {
                  ++this.h;
                  this.e(0);
                  this.l = 10;
                  return false;
               }
            } else {
               if (var1 == 19) {
                  this.b();
                  return false;
               }

               F = var1;
            }
         }

         return true;
      }
   }

   private void g() {
      this.P = System.currentTimeMillis() / 100L;
      if (this.M != -1) {
         ++this.O;
         if (this.O >= 6) {
            this.O = 0;
         }

         String var5 = this.C.substring(0, this.M);
         String var6 = this.C.substring(this.M + 1);
         String var7 = Q.substring(this.N + this.O, this.N + this.O + 1);
         this.C = var5 + var7 + var6;
      } else {
         for(int var1 = this.h; var1 > 0; --var1) {
            char var2 = this.C.charAt(var1 - 1);

            for(int var3 = 0; var3 < Q.length(); ++var3) {
               char var4 = Q.charAt(var3);
               if (var2 == var4) {
                  this.N = var3;
                  this.O = 0;
                  this.M = var1 - 1;
                  return;
               }
            }
         }

         this.M = -1;
      }
   }

   public final void paint(Graphics var1) {
      boolean var2 = this.v;
      if (this.H == 2) {
         this.g = this.D;
      } else {
         this.g = this.C;
      }

      var1.setClip(0, 0, Canvas.w + 20, Canvas.h);
      var1.setColor(7829367);
      Canvas.paint.a(var1, this.a, this.b, this.c, this.d, this, var2);
   }

   public final boolean d() {
      return this.v;
   }

   private void h() {
      if (this.H == 2) {
         this.D = "";

         for(int var1 = 0; var1 < this.C.length(); ++var1) {
            this.D = this.D + "*";
         }

         if (this.k > 0 && this.h > 0) {
            this.D = this.D.substring(0, this.h - 1) + this.C.charAt(this.h - 1) + this.D.substring(this.h, this.D.length());
         }
      }

   }

   public final void e() {
      ++this.i;
      if (this.k > 0) {
         --this.k;
         if (this.k == 0 || n > 2) {
            this.G = 0;
            if (this.v && n == 1 && F != I) {
               n = 0;
            }

            F = -1984;
            this.h();
         }
      }

      if (this.l > 0) {
         --this.l;
      }

      if (Canvas.isPointerClick && Canvas.menuMain == null && Canvas.isPointerClick && Canvas.isPointer(0, 0, Canvas.w, Canvas.h - Canvas.hTab / 2)) {
         if (Canvas.isPointer(this.a, this.b - 6, this.c, this.d + 12)) {
            if (!this.v) {
               this.v = true;
            } else {
               if (!OptionScr.d) {
                  this.R = true;
                  OptionScr.d = true;
                  Canvas.instance.b();
               }

               Canvas.z.a = true;
            }
         } else {
            if (this.R) {
               OptionScr.d = false;
               Canvas.instance.b();
               this.R = false;
            }

            if (this.e) {
               this.v = false;
            }
         }
      }

      if (this.M != -1 && System.currentTimeMillis() / 100L - this.P > 5L) {
         this.M = -1;
      }

      if (this.v && Canvas.currentDialog == null) {
         if (Canvas.keyPressed[4]) {
            if (this.H != 2) {
               --this.h;
               if (this.h < 0) {
                  this.h = 0;
               }

               this.e(-1);
            }

            Canvas.keyPressed[4] = false;
            return;
         }

         if (Canvas.keyPressed[6]) {
            if (this.H != 2) {
               ++this.h;
               if (this.h > this.C.length()) {
                  this.h = this.C.length();
               }

               this.e(1);
            }

            Canvas.keyPressed[6] = false;
         }
      }

   }

   public final String f() {
      return this.C;
   }

   public final void a(String var1) {
      if (var1 != null) {
         F = -1984;
         this.k = 0;
         this.G = 0;
         this.C = var1;
         this.g = var1;
         this.h();
         this.h = var1.length();
         this.e(0);
      }
   }

   public final void c(int var1) {
      this.E = 40;
   }

   public final void d(int var1) {
      this.H = var1;
   }

   static boolean a(TField var0) {
      return var0.v;
   }
}

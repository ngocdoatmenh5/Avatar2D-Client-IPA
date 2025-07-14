package avt;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import main.GameCanvas;
import main.GameMidlet;

public final class GlobalMessageHandler extends IService implements IMessageHandler {
   private GlobalLogicHandler c = new GlobalLogicHandler();
   private static GlobalMessageHandler d;
   public IMiniGameMsgHandler a;

   public static GlobalMessageHandler a() {
      if (d == null) {
         d = new GlobalMessageHandler();
      }

      return d;
   }

   public final void b() {
      System.out.println("onConnectionFail");
      GameCanvas.b(T1.Y);
   }

   public final void c() {
      System.out.println("onDisconnected");
      GameCanvas.h();
      GameMidlet.e = 8;
      if (GameCanvas.r != LoginScr.a) {
         GameCanvas.b(T1.aO, new class_du());
      } else {
         GameCanvas.b(T1.aO);
      }

      GameCanvas.t = null;
      HouseScr.a = null;
      MessageScr.d = null;
      SoundManager.a.a();
      if (class_im.d().ac.b != null) {
         class_im.d().ac.b.perform();
      }

      FarmData.a();
   }

   public final void onMessage(Message var1) {
      int var2;
      int var3;
      int var4;
      String var202;
      byte var206;
      SeriPart var207;
      try {
         int var5;
         Vector var6;
         int var7;
         int var8;
         int var64;
         int var72;
         int var82;
         short var84;
         int var94;
         int var107;
         short var109;
         int var110;
         int var114;
         String var188;
         String var190;
         boolean var191;
         String var194;
         short var199;
         short var200;
         short var201;
         String var204;
         int var209;
         byte var234;
         byte var262;
         label823:
         switch (var1.a) {
            case -107:
               byte var265 = var1.b().readByte();
               String var266 = null;
               String[] var267 = null;
               String[] var174 = null;
               String[] var268 = null;
               short[] var176 = null;
               short[] var177 = null;
               short[] var178 = null;
               int[] var179 = null;
               int var181;
               short var269;
               if (var265 == 0) {
                  var266 = var1.b().readUTF();
                  var267 = new String[var269 = var1.b().readShort()];
                  var176 = new short[var269];
                  var174 = new String[var269];
                  var268 = new String[var269];
                  var177 = new short[var269];
                  var178 = new short[var269];

                  for(var181 = 0; var181 < var269; ++var181) {
                     var177[var181] = var1.b().readShort();
                     var176[var181] = var1.b().readShort();
                     var178[var181] = var1.b().readShort();
                     var267[var181] = var1.b().readUTF();
                     var174[var181] = var1.b().readUTF();
                     var268[var181] = var1.b().readUTF();
                  }
               } else if (var265 == 1) {
                  var266 = var1.b().readUTF();
                  var177 = new short[var269 = var1.b().readShort()];
                  var267 = new String[var269];
                  var176 = new short[var269];
                  var179 = new int[var269];
                  var268 = new String[var269];
                  var178 = new short[var269];
                  var174 = new String[var269];

                  for(var181 = 0; var181 < var269; ++var181) {
                     var177[var181] = var1.b().readShort();
                     var267[var181] = var1.b().readUTF();
                     var174[var181] = var1.b().readUTF();
                     var176[var181] = var1.b().readShort();
                     var178[var181] = var1.b().readShort();
                     var179[var181] = var1.b().readInt();
                     var268[var181] = var1.b().readUTF();
                  }
               }

               HouseScr.b().a(var265, var266, var267, var176, var177, var174, var268, var179, var178);
               return;
            case -105:
               byte var169 = var1.b().readByte();
               Vector var170 = new Vector();

               for(int var171 = 0; var171 < var169; ++var171) {
                  short var172 = var1.b().readShort();
                  String var173 = var1.b().readUTF();
                  CommandFlower var175 = new CommandFlower(this, var173, new class_br(this, var171), var172);
                  var170.addElement(var175);
               }

               GameCanvas.h();
               FarmScr.b();
               FarmScr.a(var170);
               break;
            case -103:
               Avatar var164 = LoadMap.g(var1.b().readInt());
               if (var1.b().readByte() == 0) {
                  var164.X = var1.b().readShort();
               } else {
                  var164.aa = var1.b().readShort();
               }
               break;
            case -102:
               int var166 = var1.b().readInt();
               int var167 = var1.b().readInt();
               Avatar var168;
               if (OnScreen.b) {
                  var168 = BoardScr.h(var166);
               } else {
                  var168 = LoadMap.g(var166);
               }

               if (var168 != null) {
                  var168.a[3] = var167;
               }

               return;
            case -101:
               var262 = var1.b().readByte();
               short var263 = var1.b().readShort();
               if (var262 == 1) {
                  StringObj var163;
                  (var163 = new StringObj()).e = var263;
                  var163.a = var1.b().readUTF();
                  var163.d = var1.b().readShort();
                  var163.f = var1.b().readByte();
                  MapScr.o.addElement(var163);
                  if (GameCanvas.r == PopupShop.b()) {
                     PopupShop.b().d();
                  }

                  if (LoadMap.p != null) {
                     MenuCenter.b().e();
                  } else {
                     MenuCenter.b().f();
                  }
                  break;
               } else {
                  int var264 = 0;

                  while(true) {
                     if (var264 >= MapScr.o.size()) {
                        break label823;
                     }

                     if (((StringObj)MapScr.o.elementAt(var264)).e == var263) {
                        MapScr.o.removeElementAt(var264);
                        break label823;
                     }

                     ++var264;
                  }
               }
            case -99:
               byte var155 = var1.b().readByte();
               byte var156 = var1.b().readByte();
               Vector var157 = new Vector();

               for(int var158 = 0; var158 < var156; ++var158) {
                  Avatar var159;
                  (var159 = new Avatar()).w = var1.b().readInt();
                  var159.a(var1.b().readUTF());
                  byte var160 = var1.b().readByte();

                  for(int var161 = 0; var161 < var160; ++var161) {
                     var159.a(new SeriPart(var1.b().readShort()));
                  }

                  var159.aw = var1.b().readShort();
                  var159.ax = var1.b().readShort();
                  var159.ac = var1.b().readByte();
                  var159.W = (byte)(100 - var1.b().readByte());
                  var159.X = var1.b().readShort();
                  var262 = var1.b().readByte();
                  var159.ar = new String[var262];

                  for(int var162 = 0; var162 < var262; ++var162) {
                     var159.ar[var162] = var1.b().readUTF();
                  }

                  var157.addElement(var159);
               }

               short var259 = var1.b().readShort();
               Vector var260 = null;
               Vector var261 = null;
               if (var259 > 0) {
                  var260 = f(var1);
                  var261 = e(var1);
               }

               MapScr.b().a(var155, var157, var260, var261);
               break;
            case -98:
               short var257 = var1.b().readShort();
               byte[] var258 = new byte[var1.b().readShort()];
               var1.b().read(var258);
               AvatarData.i.put("" + var257, new ImageIcon(CRes.a(var258)));
               return;
            case -97:
               byte[] var144 = new byte[var1.b().available()];
               var1.b().read(var144);
               Part var146 = (Part)AvatarData.a(var144, true).elementAt(0);
               AvatarData.j.put("" + var146.g, var146);

               for(int var147 = 0; var147 < LoadMap.m.size(); ++var147) {
                  MyObject var148;
                  if ((var148 = (MyObject)LoadMap.m.elementAt(var147)).az == 0) {
                     Avatar var149;
                     (var149 = (Avatar)var148).h();
                  }
               }

               return;
            case -96:
               GameCanvas.h();
               MapScr.b().n();
               OnSplashScr.b().a();
               OnSplashScr.b().b = 0;
               return;
            case -94:
               byte var142 = var1.b().readByte();
               byte[] var143 = new byte[var1.b().available()];
               var1.b().read(var143);
               GameCanvas.x.a(var142, var143);
               return;
            case -93:
               byte var253 = var1.b().readByte();
               byte var254 = var1.b().readByte();
               var1.b().readShort();
               byte var132 = var1.b().readByte();
               byte[] var134 = new byte[var1.b().readShort()];
               var1.b().read(var134);
               short[] var135 = null;
               byte var136;
               if ((var136 = var1.b().readByte()) > 0) {
                  var135 = new short[var136];

                  for(int var137 = 0; var137 < var136; ++var137) {
                     var135[var137] = var1.b().readShort();
                  }
               }

               short var255 = var1.b().readShort();
               Image var138 = null;
               if (var255 > 0) {
                  byte[] var139 = new byte[var255];
                  var1.b().read(var139);
                  var138 = CRes.a(var139);
               }

               short var256 = var1.b().readShort();
               Vector var140 = null;
               Vector var141 = null;
               if (var256 > 0) {
                  var140 = f(var1);
                  var141 = e(var1);
               }

               MapScr.b();
               MapScr.a(var134, var253, var254, var132, var138, var135, var140, var141);
               return;
            case -92:
               var1.b().readByte();
               byte[] var125 = new byte[var1.b().readInt()];
               var1.b().read(var125);
               int var126 = var1.b().readInt();
               var1.b().readByte();
               byte[] var127 = new byte[var126];

               for(int var128 = 0; var128 < var126; ++var128) {
                  var127[var128] = var1.b().readByte();
               }

               byte var252 = var1.b().readByte();
               Vector var129 = new Vector();

               for(int var130 = 0; var130 < var252; ++var130) {
                  class_kb var131 = new class_kb();
                  var1.b().readByte();
                  var131.d = var1.b().readShort();
                  var131.c = var1.b().readUTF();
                  var131.a = var1.b().readByte();
                  var131.b = var1.b().readByte();
                  var129.addElement(var131);
               }

               MiniMap.j = false;
               MiniMap.gI().a();
               LoadMap.a = -1;
               LoadMap.D = -108;
               LoadMap.E = -1;
               return;
            case -90:
            case -53:
               var206 = var1.b().readByte();
               var190 = var1.b().readUTF();
               this.c.a((byte)(var1.a == -53 ? 0 : 1), var206, var190);
               return;
            case -89:
               HouseScr.b().a(var1.b().readBoolean(), var1.b().readUTF());
               return;
            case -88:
               HouseScr.b();
               HouseScr.g();
               return;
            case -87:
               short var117 = var1.b().readShort();
               Vector var118 = new Vector();

               int var119;
               for(var119 = 0; var119 < var117; ++var119) {
                  SeriPart var120;
                  (var120 = new SeriPart()).a = var1.b().readShort();
                  var120.b = var1.b().readByte();
                  var120.c = var1.b().readUTF();
                  var118.addElement(var120);
               }

               var119 = var1.b().readInt();
               byte var251 = var1.b().readByte();
               short var121 = var1.b().readShort();
               Vector var122 = new Vector();

               for(int var123 = 0; var123 < var121; ++var123) {
                  SeriPart var124;
                  (var124 = new SeriPart()).a = var1.b().readShort();
                  var124.b = var1.b().readByte();
                  var124.c = var1.b().readUTF();
                  var122.addElement(var124);
               }

               HouseScr.b().a(var118, var122, var119, var251);
               return;
            case -85:
               var107 = var1.b().readInt();
               byte var241 = var1.b().readByte();
               Vector var244 = new Vector();

               for(var110 = 0; var110 < var241; ++var110) {
                  Emotion var249 = new Emotion(this);
                  var1.b().readByte();
                  var249.a = var1.b().readShort();
                  var249.b = var1.b().readShort();
                  var244.addElement(var249);
               }

               MapScr.b();
               MapScr.a(var107, var244);
               return;
            case -84:
               var234 = var1.b().readByte();
               byte var238;
               if ((var238 = var1.b().readByte()) != 5 && var238 != 2) {
                  int var111;
                  byte var245;
                  if (var234 == 0) {
                     if (AvatarData.d((short)var238) == null) {
                        AvatarService.a().c((short)var238);
                     }

                     EffectManager var240;
                     (var240 = new EffectManager()).a = var238;
                     var240.k = var1.b().readByte();
                     var240.c = var240.g = var1.b().readByte();
                     if (var240.k != 4) {
                        var240.b = var1.b().readShort();
                        var240.l = var1.b().readByte();
                        if (var240.l == 1) {
                           var240.d = var1.b().readShort();
                        } else if (var240.l == 2) {
                           byte var243 = var1.b().readByte();
                           var240.m = new short[var243];
                           var240.n = new short[var243];

                           for(var110 = 0; var110 < var243; ++var110) {
                              var240.m[var110] = var1.b().readShort();
                              var240.n[var110] = var1.b().readShort();
                           }
                        }

                        if (var240.k == 0) {
                           var240.j = var1.b().readInt();
                        } else {
                           var240.e = var1.b().readShort();
                           var240.f = var1.b().readShort();
                        }

                        MapScr.b();
                        MapScr.a(var240);
                        return;
                     }

                     var109 = var1.b().readShort();
                     var245 = var1.b().readByte();
                     if (GameCanvas.B.size() > 0) {
                        for(var111 = 0; var111 < GameCanvas.B.size(); ++var111) {
                           if (((Effect)GameCanvas.B.elementAt(var111)).c == var238) {
                              return;
                           }
                        }
                     }

                     AnimateEffect var247;
                     (var247 = new AnimateEffect(2, var109)).a = var245;
                     var247.c = var238;
                     var247.c();
                     return;
                  }

                  EffectData var239;
                  (var239 = new EffectData()).e = var238;
                  byte[] var242 = new byte[var1.b().readShort()];
                  var1.b().read(var242);
                  var239.c = CRes.a(var242);
                  var245 = var1.b().readByte();
                  var239.b = new ImageInfo[var245];

                  for(var111 = 0; var111 < var245; ++var111) {
                     var239.b[var111] = new ImageInfo();
                     var239.b[var111].a = var1.b().readByte();
                     var239.b[var111].c = var1.b().readByte();
                     var239.b[var111].d = var1.b().readByte();
                     var239.b[var111].e = var1.b().readByte();
                     var239.b[var111].f = var1.b().readByte();
                  }

                  byte var246 = var1.b().readByte();
                  var239.d = new Frame[var246];

                  int var250;
                  for(int var112 = 0; var112 < var246; ++var112) {
                     var239.d[var112] = new Frame(this);
                     var250 = var1.b().readByte();
                     var239.d[var112].b = new short[var250];
                     var239.d[var112].c = new short[var250];
                     var239.d[var112].a = new byte[var250];

                     for(var114 = 0; var114 < var250; ++var114) {
                        var239.d[var112].b[var114] = var1.b().readByte();
                        var239.d[var112].c[var114] = var1.b().readByte();
                        var239.d[var112].a[var114] = var1.b().readByte();
                     }
                  }

                  byte var248 = var1.b().readByte();
                  var239.a = new byte[var248];

                  for(var250 = 0; var250 < var248; ++var250) {
                     var239.a[var250] = var1.b().readByte();
                  }

                  AvatarData.k.addElement(var239);
                  return;
               }

               return;
            case -83:
               byte var92 = var1.b().readByte();
               Vector var93 = new Vector();

               for(var94 = 0; var94 < var92; ++var94) {
                  StringObj var231;
                  (var231 = new StringObj()).e = var1.b().readShort();
                  var231.a = var1.b().readUTF();
                  var231.d = var1.b().readShort();
                  var93.addElement(var231);
               }

               MapScr.b().b(var93);
               return;
            case -82:
               int var90 = var1.b().readInt();
               short var91 = var1.b().readShort();
               MapScr.b();
               MapScr.b(var90, var91);
               return;
            case -81:
               String var87 = var1.b().readUTF();
               int var88 = 0;

               for(int var89 = 0; var89 < var87.length(); ++var89) {
                  if (var87.charAt(var89) == '-') {
                     ++var88;
                  }
               }

               byte[] var230 = new byte[var1.b().available()];
               var1.b().read(var230);
               if (var88 != 2 && !var87.equals(ListScr.h)) {
                  ListScr.b().a(var230, var87);
                  GameCanvas.h();
                  return;
               }

               ListScr.i.put(var87, var230);
               ListScr.b().a(var87);
               return;
            case -80:
               var84 = var1.b().readShort();
               byte[] var86 = new byte[var1.b().readShort()];
               var1.b().read(var86);
               AvatarData.h.put("" + var84, new ImageIcon(CRes.a(var86)));
               return;
            case -78:
               byte var232 = var1.b().readByte();
               int var100 = var1.b().readInt();
               byte var101 = var1.b().readByte();
               String var102 = var1.b().readUTF();
               short var103;
               if ((var103 = var1.b().readShort()) > 0) {
                  short[] var233 = new short[var103];
                  String[] var235 = new String[var103];
                  String[] var237 = null;
                  if (var232 == 1) {
                     var237 = new String[var103];
                  }

                  for(var107 = 0; var107 < var103; ++var107) {
                     var233[var107] = var1.b().readShort();
                     var235[var107] = var1.b().readUTF();
                     if (var232 == 1) {
                        var237[var107] = var1.b().readUTF();
                     }
                  }

                  MapScr.b().a(var232, var101, var102, var233, var100, var235);
               }

               return;
            case -77:
               var94 = var1.b().readInt();
               byte var95 = var1.b().readByte();
               String var96 = var1.b().readUTF();
               byte var97;
               String[] var98 = new String[var97 = var1.b().readByte()];

               for(int var99 = 0; var99 < var97; ++var99) {
                  var98[var99] = var1.b().readUTF();
               }

               if (PopupShop.a != GameCanvas.r) {
                  MapScr.b().a(var94, var95, var96, var98);
               }

               return;
            case -74:
               MapItem var180;
               (var180 = new MapItem()).b = var1.b().readShort();
               var180.aw = 24 * var1.b().readByte();
               var180.ax = 24 * var1.b().readByte();
               HouseScr.b().a(var180);
               return;
            case -70:
               var82 = var1.b().readInt();
               byte var229 = (byte)(100 - var1.b().readByte());
               MapScr.b();
               MapScr.b(var82, var229);
               return;
            case -64:
               int var78 = var1.b().readInt();
               short var79 = var1.b().readShort();
               byte var80 = var1.b().readByte();
               Vector var81 = new Vector();

               for(var82 = 0; var82 < var80; ++var82) {
                  Gift var83;
                  (var83 = new Gift()).b = var1.b().readByte();
                  switch (var83.b) {
                     case 1:
                        var83.a = var1.b().readShort();
                        if ((var84 = var1.b().readByte()) == -1) {
                           var83.h = "(" + T1.cQ + ")";
                        } else {
                           var83.h = "(" + var84 + " " + T1.cM + ")";
                        }
                        break;
                     case 2:
                        var83.c = var1.b().readInt();
                        break;
                     case 3:
                        var83.f = var1.b().readInt();
                        break;
                     case 4:
                        var83.g = var1.b().readInt();
                  }

                  var81.addElement(var83);
               }

               DialLuckyScr.b().a(var78, var79, var81);
               return;
            case -63:
               LoadMap.a(var1.b().readByte());
               return;
            case -62:
               System.out.println("CHANGE_PASS");
               LoginScr.b().c.a(var1.b().readUTF());
               LoginScr.b().g();
               break;
            case -60:
               var72 = var1.b().readInt();
               byte var73 = var1.b().readByte();
               String var74 = var1.b().readUTF();
               byte var75 = var1.b().readByte();
               byte[] var76 = null;
               if (var1.b().available() > 0) {
                  var76 = new byte[var1.b().readShort()];
                  var1.b().read(var76);
               }

               GameCanvas.u.a(var74, new class_bo(this, var72, var73), var75);
               if (var76 != null) {
                  GameCanvas.u.a(Image.createImage(var76, 0, var76.length));
               }

               return;
            case -59:
               if (GameCanvas.v == GameCanvas.s) {
                  GameCanvas.v = null;
               }

               if (GameCanvas.v != null) {
                  return;
               }

               var64 = var1.b().readInt();
               byte var225 = var1.b().readByte();
               byte var226;
               String[] var227 = new String[var226 = var1.b().readByte()];
               short[] var68 = new short[var226];

               int var69;
               for(var69 = 0; var69 < var226; ++var69) {
                  var227[var69] = var1.b().readUTF();
               }

               if (var1.b().available() > 0) {
                  for(var69 = 0; var69 < var226; ++var69) {
                     var68[var69] = var1.b().readShort();
                  }
               }

               String var228 = null;
               String var70 = null;
               boolean[] var71 = null;
               if (var1.b().available() > 0) {
                  var228 = var1.b().readUTF();
                  var70 = var1.b().readUTF();
                  var71 = new boolean[var226];

                  for(var72 = 0; var72 < var226; ++var72) {
                     var71[var72] = var1.b().readBoolean();
                  }
               }

               this.c.a(var64, var225, var227, var228, var70, var71);
               return;
            case -58:
               var206 = var1.b().readByte();
               Hashtable var219 = new Hashtable();

               for(var4 = 0; var4 < var206; ++var4) {
                  var200 = var1.b().readShort();
                  byte[] var223 = new byte[var1.b().readShort()];
                  var1.b().read(var223);
                  Image var224 = CRes.a(var223);
                  var219.put("" + var200, var224);
               }

               var194 = var1.b().readUTF();
               var202 = var1.b().readUTF();
               System.err.println("CUSTOM_TAB: " + var194);
               System.err.println("CUSTOM_TAB111: " + var202);
               byte var217 = -1;
               if (var1.b().available() > 0) {
                  var217 = var1.b().readByte();
               }

               CustomTab.a = null;
               CustomTab.b().a(var219, var194, var202, var217);
               CustomTab.b().a();
               return;
            case -54:
               var188 = var1.b().readUTF();
               var190 = var1.b().readUTF();
               var194 = var1.b().readUTF();
               GameCanvas.h();
               GameCanvas.a(var188, (IAction)(new class_bm(this, var190, var194)));
               break;
            case -52:
               var188 = var1.b().readUTF();
               var1.b().readInt();
               LoginScr.b().a(var188);
               return;
            case -51:
               var206 = var1.b().readByte();
               byte[] var218 = new byte[var1.b().available()];
               var1.b().read(var218);
               SoundManager.a.a(var218, var206);
               return;
            case -50:
               var204 = var1.b().readUTF();
               var206 = var1.b().readByte();
               SoundManager.a.a(var204, var206);
               return;
            case -49:
               var206 = var1.b().readByte();
               System.out.println("OPEN_SHOP: " + var206);
               var190 = var1.b().readUTF();
               short[] var210 = null;
               if ((var200 = var1.b().readShort()) > 0) {
                  var210 = new short[var200];

                  for(var209 = 0; var209 < var200; ++var209) {
                     var210[var209] = var1.b().readShort();
                  }
               }

               MapScr.b().a((byte)0, var206, var190, var210, -1, (String[])null);
               return;
            case -48:
               var3 = var1.b().readInt();
               var199 = var1.b().readShort();
               MapScr.b();
               MapScr.a(var3, var199);
               return;
            case -47:
               Vector var215 = new Vector();
               var201 = var1.b().readShort();

               for(var3 = 0; var3 < var201; ++var3) {
                  (var207 = new SeriPart()).a = var1.b().readShort();
                  var207.b = var1.b().readByte();
                  var207.c = var1.b().readUTF();
                  var215.addElement(var207);
               }

               MapScr.b().a(var215);
               return;
            case -42:
               var6 = new Vector();
               var201 = var1.b().readByte();

               for(var3 = 0; var3 < var201; ++var3) {
                  ObjAd var205 = new ObjAd(this);
                  var1.b().readShort();
                  var205.b = var1.b().readUTF();
                  var205.c = var1.b().readUTF();
                  var205.d = var1.b().readUTF();
                  var205.e = var1.b().readUTF();
                  var205.f = var1.b().readUTF();
                  var205.g = new Vector();
                  var200 = var1.b().readByte();

                  for(var7 = 0; var7 < var200; ++var7) {
                     AvPosition var213;
                     (var213 = new AvPosition()).c = var1.b().readByte();
                     var213.a = var1.b().readByte();
                     var213.b = var1.b().readByte();
                     var205.g.addElement(var213);
                  }

                  var6.addElement(var205);
               }

               for(var3 = 0; var3 < var201; ++var3) {
                  ((ObjAd)var6.elementAt(var3)).a = var1.b().readByte();
               }

               AvatarData.a(var6);
               return;
            case -38:
               short var150 = var1.b().readShort();
               int var151 = 0;
               if (var150 != -1) {
                  var151 = var1.b().readInt();
               }

               int var152 = var1.b().readInt();
               int var153 = var1.b().readInt();
               int var154 = var1.b().readInt();
               GameMidlet.i.a(var152, var153, var154);
               MapScr.b();
               MapScr.a(var150, var151);
               return;
            case -36:
               var2 = var1.b().readInt();
               short var208 = var1.b().readShort();
               MapScr.b();
               MapScr.b(var2, (int)var208);
               return;
            case -35:
               var191 = var1.b().readBoolean();
               RegisterScr.b();
               RegisterScr.b(var191);
               return;
            case -33:
               var3 = var1.b().readInt();
               var199 = var1.b().readByte();
               if (var3 != 0 && var199 != 1 && var199 == 2 && var199 == 5) {
                  GameMidlet.i.b(GameMidlet.i.a[3] + var3);
                  GameCanvas.a(var3 + "xeng", GameMidlet.i.aw, GameMidlet.i.ax, -1, 0, -1);
               }

               var5 = var1.b().readInt();
               var7 = var1.b().readInt();
               var8 = var1.b().readInt();
               GameMidlet.i.a(var5, var7, var8);
               return;
            case -25:
               var199 = var1.b().readByte();
               var188 = null;
               var190 = null;
               var202 = null;
               if (var199 == 2) {
                  var190 = var1.b().readUTF();
                  var202 = var1.b().readUTF();
               } else {
                  var188 = var1.b().readUTF();
               }

               MiniMap.gI().a((byte)var199, var188, var190, var202);
               break;
            case -24:
               if ((var110 = var1.b().readShort()) != -1) {
                  var1.b().readInt();
                  var1.b().readByte();
               }

               String var113 = var1.b().readUTF();
               var114 = var1.b().readInt();
               int var115 = var1.b().readInt();
               int var116 = var1.b().readInt();
               MapScr.b();
               MapScr.a((short)var110, var113, var114, var115, var116);
               return;
            case -23:
               Vector var193 = new Vector();

               while(var1.b().available() > 0) {
                  MoneyInfo var198;
                  (var198 = new MoneyInfo()).a = var1.b().readUTF();
                  var198.c = var1.b().readUTF();
                  var1.b().readUTF();
                  var198.b = var1.b().readUTF();
                  var193.addElement(var198);
               }

               MoneyScr.b().a(var193);
               MoneyScr.b().a(GameCanvas.r);
               GameCanvas.h();
               return;
            case -22:
               var2 = var1.b().readInt();
               class_kp var197;
               (var197 = new class_kp()).g = var1.b().readByte();
               var197.f = var1.b().readByte();
               var197.a = var1.b().readByte();
               var197.b = var1.b().readByte();
               var197.e = var1.b().readByte();
               var197.c = var1.b().readByte();
               var197.d = var1.b().readByte();
               Avatar var195 = null;
               var5 = var1.b().readInt();
               var204 = "";
               String var203 = "";
               short var211 = 0;
               byte var212 = 0;
               byte var10 = 0;
               short var11 = -1;
               String var12 = "";
               if (var5 != -1) {
                  (var195 = new Avatar()).w = var5;
                  var195.a(var1.b().readUTF());
                  var200 = var1.b().readByte();

                  for(var209 = 0; var209 < var200; ++var209) {
                     var195.a(new SeriPart(var1.b().readShort()));
                  }

                  var204 = var1.b().readUTF();
                  var211 = var1.b().readShort();
                  var212 = var1.b().readByte();
                  var10 = var1.b().readByte();
                  var203 = var1.b().readUTF();
                  if ((var11 = var1.b().readShort()) != -1) {
                     var12 = var1.b().readUTF();
                  }
               }

               if (var1.b().available() > 0) {
                  GameMidlet.i.v = GameMidlet.j.g = var197.g = var1.b().readShort();
               }

               MapScr.b().a(var2, var197, var195, var204, var211, var212, var10, var203, var11, var12);
               return;
            case -21:
               Avatar var196;
               (var196 = new Avatar()).w = var1.b().readInt();
               var196.x = var1.b().readUTF();
               var188 = var1.b().readUTF();
               MapScr.b().a(var196, var188);
               return;
            case -19:
               Avatar var189;
               (var189 = new Avatar()).w = var1.b().readInt();
               var189.x = var1.b().readUTF();
               var191 = var1.b().readBoolean();
               var190 = var1.b().readUTF();
               MapScr.b();
               MapScr.a(var191, var190);
               return;
            case -17:
               GameMidlet.f = var1.b().readByte();
               GameMidlet.g = var1.b().readUTF();
               AvatarData.c();
               break;
            case -12:
               var188 = var1.b().readUTF();
               var190 = var1.b().readUTF();
               LoginScr.b().a(var188, var190);
               break;
            case -10:
               var188 = var1.b().readUTF();
               boolean var192 = false;
               if (var1.b().available() > 0) {
                  var192 = var1.b().readBoolean();
               }

               this.c.a(var188, var192);
               return;
            case -9:
               GameCanvas.b(var1.b().readUTF());
               return;
            case -8:
               GameCanvas.a(var1.b().readUTF());
               return;
            case -7:
               this.c.a(var1.b().readUTF(), var1.b().readUTF());
               return;
            case -6:
               var2 = var1.b().readInt();
               var190 = var1.b().readUTF();
               var194 = var1.b().readUTF();
               if (GameCanvas.r != MessageScr.b()) {
                  ++MyScreen.as;
               }

               MessageScr.b().a(var2, var190, var194);
               return;
            case -1:
               GlobalLogicHandler.a(var1.b().readByte());
               return;
            case 34:
               if (var1.b().readInt() != -1) {
                  var204 = var1.b().readUTF();
                  var2 = var1.b().readInt();
                  var1.b().readShort();
                  var3 = var1.b().readInt();
                  var4 = var1.b().readInt();
                  var5 = var1.b().readInt();
                  var7 = var1.b().readInt();
                  var8 = var1.b().readInt();
                  Avatar var9;
                  (var9 = new Avatar()).d(var3);
                  GameCanvas.b(T1.aA + var204 + ". " + T1.ao + var2 + "$. Level: " + var9.v + "+" + var9.r + "%. " + T1.aP + ": " + var4 + ". " + T1.aQ + ": " + var5 + ". " + T1.aR + ": " + var7 + ". " + T1.aS + ": " + var8);
               }

               return;
            case 50:
               if (this.a == FarmMsgHandler.a || this.a == ParkMsgHandler.a || this.a == HomeMsgHandler.a) {
                  var2 = var1.b().readByte();
                  var3 = var1.b().readByte();
                  var4 = 0;
                  var5 = 0;
                  var6 = new Vector();
                  if (var3 != -1 && var3 != -2) {
                     var4 = var1.b().readShort();
                     var5 = var1.b().readShort();
                     var6 = b(var1);
                  }

                  var64 = var1.b().readShort();
                  Vector var65 = null;
                  Vector var66 = null;
                  if (var64 > 0) {
                     var65 = f(var1);
                     var66 = e(var1);
                  }

                  if (GameMidlet.e == 9) {
                     for(int var67 = 0; var67 < var6.size(); ++var67) {
                        ((Avatar)var6.elementAt(var67)).aa = var1.b().readShort();
                     }
                  }

                  MapScr.b().a((byte)var2, (byte)var3, (short)var4, (short)var5, var6, var65, var66);
                  if (LoadMap.a == 21) {
                     GameCanvas.J = 0;
                     HomeMsgHandler.a();
                     AvatarService.a().c((int)0);
                     GameCanvas.i();
                  }
               }
               break;
            case 89:
               byte var104 = var1.b().readByte();
               System.out.println("DROP_PART: " + var104 + "    " + var1.b().available());
               if (var104 == 0) {
                  var234 = var1.b().readByte();
                  short var236 = var1.b().readShort();
                  var107 = var1.b().readInt();
                  int var108 = var1.b().readInt();
                  System.out.println("aaaaaa: " + var234 + "   " + var236 + "   " + var107 + "   " + var108);
                  var109 = var1.b().readShort();
                  var110 = var1.b().readShort();
                  MapScr.b();
                  MapScr.a(var234, var108, var236, var107, var109, (short)var110);
                  return;
               }

               int var105 = var1.b().readInt();
               int var106 = var1.b().readInt();
               MapScr.b();
               MapScr.c(var105, var106);
               return;
            case 122:
               var1.b().readByte();
               byte var182 = var1.b().readByte();
               byte var183 = var1.b().readByte();
               short var184 = var1.b().readShort();
               short var185 = var1.b().readShort();
               LoadMap.a(var182, var183, var184, var185);
               return;
         }
      } catch (Exception var187) {
         var187.printStackTrace();
      }

      if (this.a != null) {
         this.a.onMessage(var1);
      } else {
         try {
            System.out.println("cmd: " + var1.a);
            switch (var1.a) {
               case -5:
                  GlobalLogicHandler.a(var1.b().readUTF());
                  return;
               case -4:
                  LoginScr.b().g();
                  (GameMidlet.i = new Avatar()).w = var1.b().readInt();
                  var206 = var1.b().readByte();
                  GameMidlet.i.e = new Vector();

                  for(var3 = 0; var3 < var206; ++var3) {
                     (var207 = new SeriPart()).a = var1.b().readShort();
                     GameMidlet.i.a(var207);
                  }

                  GameMidlet.i.d = var1.b().readByte();
                  GameMidlet.j.g = var1.b().readByte();
                  GameMidlet.j.f = var1.b().readByte();
                  GameMidlet.i.a(var1.b().readInt());
                  GameMidlet.j.a = var1.b().readByte();
                  GameMidlet.j.b = var1.b().readByte();
                  GameMidlet.j.e = var1.b().readByte();
                  GameMidlet.j.c = var1.b().readByte();
                  GameMidlet.j.d = var1.b().readByte();
                  GameMidlet.i.a[2] = var1.b().readInt();
                  GameMidlet.i.ac = var1.b().readByte();

                  for(var3 = 0; var3 < GameMidlet.i.e.size(); ++var3) {
                     (var207 = (SeriPart)GameMidlet.i.e.elementAt(var3)).b = var1.b().readByte();
                     var207.c = var1.b().readUTF();
                  }

                  GameMidlet.i.X = var1.b().readShort();
                  MapScr.n = new Vector();
                  byte var221 = var1.b().readByte();

                  for(var4 = 0; var4 < var221; ++var4) {
                     StringObj var216;
                     (var216 = new StringObj()).a = var1.b().readUTF();
                     var216.d = var1.b().readShort();
                     MapScr.n.addElement(var216);
                  }

                  MapScr.o = new Vector();
                  byte var220 = var1.b().readByte();

                  for(var2 = 0; var2 < var220; ++var2) {
                     StringObj var222;
                     (var222 = new StringObj()).e = var1.b().readShort();
                     var222.a = var1.b().readUTF();
                     var222.d = var1.b().readShort();
                     MapScr.o.addElement(var222);
                  }

                  MapScr.b().y = var1.b().readBoolean();
                  if (var1.b().available() > 0) {
                     for(var2 = 0; var2 < var220; ++var2) {
                        ((StringObj)MapScr.o.elementAt(var2)).f = var1.b().readByte();
                     }
                  }

                  if (var1.b().available() > 0) {
                     GameCanvas.W = var1.b().readByte();
                  }

                  GameMidlet.i.v = GameMidlet.j.g = var1.b().readShort();
                  if (GameCanvas.W == 1 || GameCanvas.W == 2) {
                     T1.ek = T1.el;
                  }

                  GameMidlet.i.aa = var1.b().readShort();
                  if (var1.b().available() > 0) {
                     MapScr.u = var1.b().readBoolean();
                  }

                  if (MapScr.u) {
                     GameMidlet.i.a[3] = var1.b().readInt();
                  }

                  MapScr.q = new Vector();
                  var206 = var1.b().readByte();

                  for(var3 = 0; var3 < var206; ++var3) {
                     class_km var214;
                     (var214 = new class_km()).a = var1.b().readShort();
                     var214.c = var1.b().readUTF();
                     var214.b = var1.b().readShort();
                     var214.d = var1.b().readInt();
                     var214.e = var1.b().readByte();
                     MapScr.q.addElement(var214);
                  }

                  GameMidlet.i.c(var1.b().readInt());
                  GameMidlet.i.b = var1.b().readInt();
                  var1.b().readByte();
                  var202 = var1.b().readUTF();
                  GameMidlet.i.a(var202);
                  System.out.println("money: " + GameMidlet.i.a[2] + "    " + var202);
                  GlobalLogicHandler.a();
                  System.out.println("2222222222222222222");
               default:
            }
         } catch (Exception var186) {
            var186.printStackTrace();
         }
      }
   }

   public static Vector b(Message var0) {
      Vector var1 = new Vector();

      try {
         byte var2 = var0.b().readByte();

         int var3;
         int var5;
         for(var3 = 0; var3 < var2; ++var3) {
            Avatar var4;
            (var4 = new Avatar()).w = var0.b().readInt();
            var4.a(var0.b().readUTF());
            var5 = var0.b().readByte();

            for(int var6 = 0; var6 < var5; ++var6) {
               short var7 = var0.b().readShort();
               var4.a(new SeriPart(var7));
            }

            var4.aw = var0.b().readShort();
            var4.ax = var0.b().readShort();
            var4.ac = var0.b().readByte();
            var1.addElement(var4);
         }

         for(var3 = 0; var3 < var2; ++var3) {
            ((Avatar)var1.elementAt(var3)).K = var0.b().readByte();
         }

         for(var3 = 0; var3 < var2; ++var3) {
            ((Avatar)var1.elementAt(var3)).W = (byte)(100 - var0.b().readByte());
         }

         for(var3 = 0; var3 < var2; ++var3) {
            ((Avatar)var1.elementAt(var3)).X = var0.b().readShort();
         }

         byte var12 = var0.b().readByte();

         for(int var9 = 0; var9 < var12; ++var9) {
            Drop_Part var11;
            (var11 = new Drop_Part()).e = var0.b().readByte();
            var11.a = var0.b().readShort();
            var11.d = var0.b().readInt();
            var11.aw = var0.b().readShort();
            var11.ax = var0.b().readShort();
            var1.addElement(var11);
         }

         LoadMap.o = null;
         byte var10 = 0;
         if (var0.b().available() > 0) {
            var10 = var0.b().readByte();
         }

         if (var10 > 0) {
            LoadMap.o = new Vector();

            for(var5 = 0; var5 < var10; ++var5) {
               AvPosition var13;
               (var13 = new AvPosition()).c = var0.b().readShort();
               var13.a = var0.b().readShort();
               var13.b = var0.b().readShort();
               var13.d = var0.b().readByte();
               LoadMap.o.addElement(var13);
            }
         }
      } catch (IOException var8) {
         var8.printStackTrace();
      }

      return var1;
   }

   private static Vector e(Message var0) {
      try {
         byte var1 = var0.b().readByte();
         System.out.println("readMapItemaaaa: " + var1);
         Vector var2 = new Vector();

         for(int var3 = 0; var3 < var1; ++var3) {
            MapItem var4;
            (var4 = new MapItem()).f = var0.b().readByte();
            var4.b = var0.b().readByte();
            var4.aw = var0.b().readByte();
            var4.ax = var0.b().readByte();
            var4.d = true;
            var2.addElement(var4);
         }

         return var2;
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   private static Vector f(Message var0) {
      try {
         byte var1 = var0.b().readByte();
         Vector var2 = new Vector();
         System.out.println("size item: " + var1);

         for(int var3 = 0; var3 < var1; ++var3) {
            MapItemType var4;
            (var4 = new MapItemType()).a = var0.b().readByte();
            var4.b = var0.b().readShort();
            var4.c = var0.b().readByte();
            var4.e = var0.b().readShort();
            var4.f = var0.b().readShort();
            byte var5 = var0.b().readByte();
            var4.j = new Vector();

            for(int var6 = 0; var6 < var5; ++var6) {
               AvPosition var7;
               (var7 = new AvPosition()).a = var0.b().readByte();
               var7.b = var0.b().readByte();
               var4.j.addElement(var7);
            }

            var2.addElement(var4);
         }

         return var2;
      } catch (IOException var8) {
         var8.printStackTrace();
         return null;
      }
   }

   public static void c(Message var0) throws IOException {
      int var1 = var0.b().readInt();
      short var2 = var0.b().readShort();
      short var3 = var0.b().readShort();
      byte var4 = var0.b().readByte();
      short var5 = 0;
      if (var0.b().available() > 0) {
         var5 = var0.b().readShort();
      }

      MapScr.b();
      MapScr.a(var1, var2, var3, var4, (short)var5);
   }

   public static void d(Message var0) throws IOException {
      int var1 = var0.b().readInt();
      String var2 = var0.b().readUTF();
      MapScr.b();
      MapScr.a(var1, var2);
   }
}

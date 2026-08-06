package avt;

import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class ServerListScr extends MyScreen {
   public static ServerListScr me;
   public int indexSV;
   private Image img;
   private boolean isSelected = false;
   private static int cmtoY;
   private static int cmy;
   private static int cmdy;
   private static int cmvy;
   private static int cmyLim;
   private static int hDis;
   private static int x;
   private static int y;
   private int indexUSer = 0;
   private long timeDelay;
   private int vY;
   private boolean transY;
   private int pa;
   private long count;
   private long timePoint;
   private int t;

   public static ServerListScr gI() {
      return me == null ? (me = new ServerListScr()) : me;
   }

   public final void switchToMe() {
      super.switchToMe();
      if (super.center == null) {
         this.initCmd();
      }

      this.refreshServerListFromHttp(false);
      this.indexUSer = 0;
      int ch = OptionScr.gI().mapFocus[4];
      if (GameMidlet.nameSV[ch].length == 0) {
         String[] lh = GameMidlet.linkGetHost[ch];
         if (lh == null || lh.length == 0) {
            Canvas.startOKDlg("Chua cau hinh .");
         } else {
            Canvas.startOKDlg(T.canNotConnect);
         }
      }

      this.e();
      this.chans();
   }

   public ServerListScr() {
      FilePack.b(T.av);
      this.img = FilePack.getImage("tp");
      FilePack.reset();
      this.initCmd();
      CRes.b();
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            if (GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length == 0) {
               Canvas.startOKDlg(T.canNotConnect);
               return;
            }

            if (this.indexSV >= GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length) {
               this.indexSV = 0;
            }

            if (GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length < 2) {
               Canvas.startOKDlg(T.canNotConnect);
               return;
            }

            if (this.isSelected && super.selected_ > 0) {
               Canvas.startWaitCancelDlg(T.logging);
               LoginScr.gI().timeOut = System.currentTimeMillis();
               LoginScr.gI().login();
               return;
            } else {
               if (!this.isSelected) {
                  this.isSelected = true;
                  this.e();
                  super.selected_ = 1 + CRes.rnd(GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length - 1);
                  this.chans();
                  return;
               }

               this.isSelected = false;
               return;
            }
         case 1:
            this.refreshServerListFromHttp(true);
            this.e();
            this.chans();
            return;
         case 2:
            this.isSelected = false;
            this.indexSV = 0;
            super.selected_ = 0;
            LoginScr.gI().switchToMe();
         default:
      }
   }

   public final void initCmd() {
      if (T.selectt != null) {
         if (Canvas.stypeInt == 0) {
            super.center = new Command(T.selectt, 0);
         }

         if (GameMidlet.PROVIDER == 0) {
            super.left = new Command(T.updateList, 1);
         }

         super.right = new Command(T.back, 2);
      }

   }

   private static String normalizeSrvTxtLine(String var0) {
      if (var0 == null) {
         return "";
      }

      while (true) {
         int ln = var0.length();
         if (ln <= 0) {
            break;
         }

         char c = var0.charAt(ln - 1);
         if (c != '\r' && c != '\n') {
            break;
         }

         var0 = var0.substring(0, ln - 1);
      }

      var0 = var0.trim();
      return var0;
   }

   private static String inferGroupTitleFromBareTxt(String txt) {
      if (txt == null || normalizeSrvTxtLine(txt).length() == 0) {
         return null;
      }

      String[] ln = Canvas.normalFont.split(txt, "\n");

      for (int ix = 0; ix < ln.length; ++ix) {
         String row = normalizeSrvTxtLine(ln[ix]);
         if (row.length() == 0) {
            continue;
         }

         String[] pts = Canvas.normalFont.split(row, ":");
         if (pts.length != 3 || pts[2].length() < 2) {
            continue;
         }

         String lbl = normalizeSrvTxtLine(pts[0]);
         if (lbl.length() == 0) {
            continue;
         }

         int hy = lbl.indexOf(45);
         if (hy >= 0) {
            return lbl.substring(0, hy).trim();
         }

         return lbl;
      }

      return null;
   }

   private static String shortSrvRowLabel(String lbl) {
      lbl = normalizeSrvTxtLine(lbl);
      if (lbl.length() == 0) {
         return lbl;
      }

      int hy = lbl.indexOf(45);
      if (hy < 0) {
         return lbl;
      }

      String pre = lbl.substring(0, hy).trim();
      return pre.length() > 0 ? pre : lbl;
   }

   private void applyServerListPayload(String var1) {
      if (var1 == null || var1.trim().length() == 0) {
         throw new RuntimeException();
      }

      String varTrim = var1.trim();
      if (varTrim.indexOf(42) < 0) {
         String varLead = GameMidlet.srvListFallbackLeadingSeg;
         if (varLead == null) {
            varLead = "";
         }

         String varGrp = inferGroupTitleFromBareTxt(varTrim);
         if (varGrp == null || varGrp.length() == 0) {
            varGrp = GameMidlet.srvListFallbackGroupTitle;
            if (varGrp == null) {
               varGrp = "";
            }
         }

         var1 = varLead + "*" + varGrp + "\n" + varTrim + "\n_\n";
      } else {
         var1 = varTrim;
      }

      String[] var6 = Canvas.normalFont.split(var1, "*");
      int chan = OptionScr.gI().mapFocus[4];
      GameMidlet.PORT[chan] = new int[var6.length - 1][];
      GameMidlet.ipSV[chan] = new String[var6.length - 1][];
      GameMidlet.nameSV[chan] = new String[var6.length - 1][];

      for (int var2 = 1; var2 < var6.length; ++var2) {
         String[] var3 = Canvas.normalFont.split(var6[var2], "\n");
         Vector disps = new Vector();
         Vector ips = new Vector();
         Vector ints = new Vector();
         String groupTitle = var3.length <= 0 ? "" : normalizeSrvTxtLine(var3[0]);

         for (int var4 = 1; var4 < var3.length - 1; ++var4) {
            String varLn = normalizeSrvTxtLine(var3[var4]);
            if (varLn.length() == 0) {
               continue;
            }

            String[] var5 = Canvas.normalFont.split(varLn, ":");
            if (var5.length != 3) {
               continue;
            }

            if (var5[2].length() < 2) {
               continue;
            }

            int varPu;
            try {
               String varPt = var5[2].substring(0, var5[2].length() - 1);
               varPu = Integer.parseInt(varPt);
            } catch (Throwable t) {
               continue;
            }

            disps.addElement(shortSrvRowLabel(var5[0]));
            ips.addElement(var5[1]);
            ints.addElement(new Integer(varPu));
         }

         if (ints.size() == 0) {
            throw new RuntimeException();
         }

         int varN = ints.size();
         GameMidlet.nameSV[chan][var2 - 1] = new String[varN + 1];
         GameMidlet.ipSV[chan][var2 - 1] = new String[varN];
         GameMidlet.PORT[chan][var2 - 1] = new int[varN];
         GameMidlet.nameSV[chan][var2 - 1][0] = groupTitle;

         for (int vx = 0; vx < varN; ++vx) {
            GameMidlet.nameSV[chan][var2 - 1][vx + 1] = (String)disps.elementAt(vx);
            GameMidlet.ipSV[chan][var2 - 1][vx] = (String)ips.elementAt(vx);
            GameMidlet.PORT[chan][var2 - 1][vx] = ((Integer)ints.elementAt(vx)).intValue();
         }
      }
   }

   private void refreshServerListFromHttp(boolean showFailureDialog) {
      String[] var0 = GameMidlet.linkGetHost[OptionScr.gI().mapFocus[4]];
      if (var0 == null || var0.length == 0) {
         return;
      }

      Canvas.startWaitCancelDlg(T.pleaseWait);
      this.indexUSer = 0;

      while (this.indexUSer < var0.length) {
         String var1 = GameMidlet.createhttpconnect(var0[this.indexUSer]);
         if (var1 != null) {
            try {
               this.applyServerListPayload(var1);
               AvatarData.e();
               Canvas.endDlg();
               this.indexUSer = 0;
               return;
            } catch (Throwable t) {
               t.printStackTrace();
            }
         }

         ++this.indexUSer;
      }

      Canvas.endDlg();
      this.indexUSer = 0;
      if (showFailureDialog) {
         Canvas.startOKDlg(T.canNotConnect);
      }
   }

   public final void e() {
      if (Canvas.stypeInt > 0) {
         super.isHide_ = true;
      }

      int var1 = 176;
      if (176 > Canvas.w) {
         var1 = Canvas.w;
      }

      PaintPopup.gI().a(T.cloth, var1 * AvMain.hd, MyScreen.hText * 6, 1);
      x = PaintPopup.gI().x + 4;
      y = PaintPopup.gI().y + PaintPopup.hTab + AvMain.hDuBox;
      hDis = PaintPopup.gI().h - (PaintPopup.hTab + (AvMain.hDuBox << 1));
      int ch = OptionScr.gI().mapFocus[4];
      int nCl = GameMidlet.nameSV[ch].length;
      int selRows = 0;
      if (this.isSelected && nCl > 0 && this.indexSV >= 0 && this.indexSV < nCl) {
         selRows = GameMidlet.nameSV[ch][this.indexSV].length * MyScreen.hText;
      }

      cmyLim = nCl * MyScreen.hText + selRows - hDis;
      cmtoY = 0;
      cmy = 0;
      if (cmyLim < 0) {
         cmyLim = 0;
      }

   }

   public final void update() {
      if (this.vY != 0) {
         if (cmy < 0 || cmy > cmyLim) {
            this.vY -= this.vY / 4;
            cmy += this.vY / 20;
            if (this.vY / 10 <= 1) {
               this.vY = 0;
            }
         }

         if (cmy < 0) {
            if (cmy < -hDis / 2) {
               cmy = -hDis / 2;
               cmtoY = 0;
               this.vY = 0;
            }
         } else if (cmy > cmyLim) {
            if (cmy < cmyLim + hDis / 2) {
               cmy = cmyLim + hDis / 2;
               cmtoY = cmyLim;
               this.vY = 0;
            }
         } else {
            cmy += this.vY / 10;
         }

         cmtoY = cmy;
         this.vY -= this.vY / 10;
         if (this.vY / 10 == 0) {
            this.vY = 0;
         }
      } else if (cmy < 0) {
         cmtoY = 0;
      } else if (cmy > cmyLim) {
         cmtoY = cmyLim;
      }

      if (cmy != cmtoY) {
         cmvy = cmtoY - cmy << 2;
         cmdy += cmvy;
         cmy += cmdy >> 4;
         cmdy &= 15;
      }

      Canvas.loadMap.update();
   }

   private void setIndex(int var1) {
      int n = GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length;
      if (n <= 0) {
         this.indexSV = 0;
         return;
      }

      this.indexSV = var1;
      if (this.indexSV >= n) {
         this.indexSV = 0;
      }

      if (this.indexSV < 0) {
         this.indexSV = n - 1;
      }

   }

   public final void setSelected(int var1, boolean var2) {
      int ch = OptionScr.gI().mapFocus[4];
      if (GameMidlet.nameSV[ch].length == 0) {
         super.selected_ = 0;
         return;
      }

      if (this.indexSV < 0 || this.indexSV >= GameMidlet.nameSV[ch].length) {
         this.indexSV = 0;
      }

      super.selected_ = var1;
      if (super.selected_ >= GameMidlet.nameSV[ch][this.indexSV].length || super.selected_ <= 0) {
         super.selected_ = 0;
         if (var2) {
            this.isSelected = false;
            this.e();
         }
      }

   }

   public final void updateKey() {
      if (GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length == 0) {
         super.updateKey();
      } else {
         this.doUpdateKey();
      }
   }

   private void doUpdateKey() {
      ++this.count;
      boolean var1 = false;
      if (Canvas.a(8)) {
         var1 = true;
         if (!this.isSelected) {
            this.setIndex(this.indexSV + 1);
         } else {
            this.setSelected(super.selected_ + 1, true);
         }
      } else if (Canvas.a(2)) {
         var1 = true;
         if (!this.isSelected) {
            this.setIndex(this.indexSV - 1);
         } else {
            this.setSelected(super.selected_ - 1, true);
         }
      }

      if (Canvas.isPointerClick && Canvas.b(x, y, PaintPopup.gI().w, hDis)) {
         Canvas.isPointerClick = false;
         this.pa = cmy;
         this.transY = true;
         this.timeDelay = System.currentTimeMillis() / 10L;
      }

      if (this.transY) {
         long var2 = System.currentTimeMillis() / 10L - this.timeDelay;
         int var4 = Canvas.dy();
         int var5;
         if (Canvas.isPointerDown) {
            if (Canvas.gameTick % 3 == 0) {
               this.t = Canvas.py;
               this.timePoint = this.count;
            }

            this.vY = 0;
            var5 = (cmtoY + Canvas.py - y) / MyScreen.hText;
            if (this.isSelected) {
               super.selected_ = var5 - this.indexSV;
            } else if (var5 >= 0 && var5 < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length) {
               this.indexSV = var5;
            }

            if (CRes.abs(var4) >= 20 * AvMain.hd) {
               super.isHide_ = true;
            } else if (var2 > 10L && var2 < 20L) {
               super.isHide_ = false;
            }

            if ((cmtoY = this.pa + var4) < 0 || cmtoY > cmyLim) {
               cmtoY = this.pa + var4 / 2;
            }

            cmy = cmtoY;
         }

         if (Canvas.isPointerRelease && Canvas.b(x, y, PaintPopup.gI().w, hDis)) {
            var5 = (int)(this.count - this.timePoint);
            int var6;
            if (CRes.abs(var6 = this.t - Canvas.py) > 40 && var5 < 10 && cmtoY > 0 && cmtoY < cmyLim) {
               this.vY = var6 / var5 * 10;
            }

            this.timePoint = -1L;
            if (Math.abs(var4) < 20 * AvMain.hd) {
               if (var2 <= 10L) {
                  super.isHide_ = false;
               }

               if (!super.isHide_) {
                  int var7 = (cmtoY + Canvas.py - y) / MyScreen.hText;
                  if (this.isSelected) {
                     if (var7 - this.indexSV > 0 && var7 - this.indexSV < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length) {
                        super.selected_ = var7 - this.indexSV;
                        this.commandTab(0, -1);
                     } else {
                        if (var7 - this.indexSV <= 0) {
                           this.isSelected = false;
                           super.selected_ = 0;
                           this.indexSV = var7;
                           var1 = true;
                        }

                        if (var7 >= GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length - this.indexSV && var7 < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length - 1 + GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length) {
                           this.isSelected = false;
                           super.selected_ = 0;
                           this.indexSV = var7 - GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][this.indexSV].length + 1;
                           var1 = true;
                        }
                     }
                  } else if (var7 >= 0 && var7 < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length) {
                     this.indexSV = var7;
                     this.commandTab(0, -1);
                  }
               }
            }
         }
      }

      if (Canvas.isPointerRelease) {
         this.transY = false;
      }

      if (var1) {
         this.chans();
      }

      super.updateKey();
   }

   private void chans() {
      if ((cmtoY = (this.indexSV + (this.isSelected ? super.selected_ : 0)) * MyScreen.hText - hDis / 2 + MyScreen.hText / 2) < 0) {
         cmtoY = 0;
      }

      if (cmtoY > cmyLim) {
         cmtoY = cmyLim;
      }

   }

   private static int paintSrvListMetaIcon(Graphics g, short id, int leftX, int cyCenter) {
      if (id < 0) {
         return 0;
      }

      ImageIcon ii = AvatarData.getImgIcon(id);
      if (ii == null || ii.count == -1 || ii.img == null) {
         return 0;
      }

      int varIw = ii.w;
      AvatarData.paintImg(g, id, 3, leftX + (varIw >> 1), cyCenter);
      return varIw;
   }

   public final void paint(Graphics var1) {
      Canvas.loadMap.paint(var1);
      Canvas.loadMap.paintBackGround(var1);
      Canvas.resetTrans(var1);
      PaintPopup.gI().paint(var1);
      if (GameMidlet.avatar != null && !GameMidlet.avatar.name.equals("")) {
         Canvas.borderFont.drawString(var1, T.StoreEmtpy + ", " + GameMidlet.avatar.name, PaintPopup.gI().x + PaintPopup.gI().w / 2, PaintPopup.gI().y - AvMain.hBorder, 2);
      }

      var1.translate(x, y);
      var1.setClip(0, 0, PaintPopup.gI().w - 9, PaintPopup.gI().h - (PaintPopup.hTab + (AvMain.hDuBox << 1)));
      var1.translate(0, -cmy);
      int chP = OptionScr.gI().mapFocus[4];
      if (!super.isHide_ && GameMidlet.nameSV[chP].length > 0) {
         Canvas.paint.drawSelectedArea(var1, 2 * AvMain.hd, this.indexSV * MyScreen.hText + (this.isSelected ? super.selected_ * MyScreen.hText : 0), PaintPopup.gI().w - 8 - 4 * AvMain.hd, MyScreen.hText);
      }

      int var2 = (MyScreen.hText - AvMain.hNormal) / 2;

      for(int var3 = 0; var3 < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]].length; ++var3) {
         int rowMidY = var2 + AvMain.hNormal / 2;
         int arrowXp = 14 * AvMain.hd;
         int varIw = paintSrvListMetaIcon(var1, GameMidlet.srvListImgIconCluster, 4 * AvMain.hd, rowMidY);
         if (varIw > 0) {
            arrowXp = 4 * AvMain.hd + varIw + 2 * AvMain.hd;
         }

         PaintPopup.imgArrowUp.drawFrame(0, arrowXp, rowMidY, 5, 3, var1);
         Canvas.normalFont.drawString(var1, GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][var3][0], arrowXp + 10 * AvMain.hd, var2, 0);
         var2 += MyScreen.hText;
         if (this.isSelected && this.indexSV == var3) {
            for(int var4 = 1; var4 < GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][var3].length; ++var4) {
               int cityMidY = var2 + AvMain.hNormal / 2;
               int iconBase = 12 * AvMain.hd;
               int varIwc = paintSrvListMetaIcon(var1, GameMidlet.srvListImgIconCity, iconBase, cityMidY);
               if (varIwc > 0) {
                  Canvas.normalFont.drawString(var1, GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][var3][var4], iconBase + varIwc + 3 * AvMain.hd, var2, 0);
               } else {
                  var1.drawImage(this.img, 24 * AvMain.hd, cityMidY, 3);
                  Canvas.normalFont.drawString(var1, GameMidlet.nameSV[OptionScr.gI().mapFocus[4]][var3][var4], 36 * AvMain.hd, var2, 0);
               }

               var2 += MyScreen.hText;
            }
         }
      }

      if (GameMidlet.nameSV[chP].length == 0) {
         Canvas.normalFont.drawString(var1, "Chua co may chu. Kiem tra mang / cap nhat.", 8 * AvMain.hd, var2, 0);
      }

      super.paint(var1);
      Canvas.paintPlus(var1);
   }
}

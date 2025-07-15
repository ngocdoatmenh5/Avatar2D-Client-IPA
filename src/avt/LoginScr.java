package avt;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Canvas;
import main.GameMidlet;

public final class LoginScr extends MyScreen {
   public static LoginScr me;
   public TField tfUser = new TField();
   public TField tfPass = new TField();
   public TField tfReg = new TField();
   public TField tfEmail = new TField();
   private int focus;
   private int yL;
   private int defYL;
   private Command cmdRemem;
   Command cmdLogin;
   private Command D;
   Command g;
   private boolean isCheckBox = true;
   Command cmdMenu;
   public boolean isReg = false;
   private String numSupport = "19006610";
   public int xLogin;
   public int yLogin;
   public int wLogin;
   public int hLogin;
   public int xCheck;
   public int yCheck;
   public int wC;
   public int xC;
   public long timeOut = 0L;
   public static int s = 0;
   public static String t;
   public static boolean isSelectedLanguage = false;
   public static boolean isNewGame;
   public static boolean isAccVir;
   private String[] listStrNew = new String[]{"Chơi mới", "Chơi tiếp", "Đổi tài khoản"};
   public int hCellNew;
   public int yNew;
   private byte indexNewGame;
   private String nameVir = "";
   private String passVir = "";
   private boolean K;

   public static LoginScr gI() {
      if (me == null) {
         me = new LoginScr();
      }

      return me;
   }

   public final void close() {
      Canvas.startOKDlg(T.P, 54);
   }

   public final void switchToMe() {
      this.doLeftMenu();
      super.switchToMe();
      Canvas.endDlg();
      if (Canvas.isKeyBoard) {
         this.indexNewGame = -1;
      }

      isNewGame = true;
      super.center = this.g;
      if (this.nameVir.equals("") && this.tfUser.getText().equals("")) {
         this.listStrNew = new String[]{"Chơi mới", "Đổi tài khoản"};
      } else {
         this.listStrNew = new String[]{"Chơi tiếp" + (!this.tfUser.getText().equals("") ? ", " + this.tfUser.getText() : ""), "Chơi mới", "Đổi tài khoản"};
      }
   }

   public final void e() {
      this.timeOut = System.currentTimeMillis();
      FilePack.b(T.aw);

      try {
         if (GameMidlet.f == 6) {
            MyScreen.am = Image.createImage("/lgyeah.png");
         } else {
            MyScreen.am = Image.createImage(T.a() + "/l.png");
         }
      } catch (IOException var2) {
         var2.printStackTrace();
      }

      FilePack.reset();
      this.yL = -50;
      Canvas.loadMap.load(26);
      GameMidlet.avatar.x = GameMidlet.avatar.xCur = LoadMap.wMap * 24 / 2 + 30;
      AvCamera.gI().xCam = AvCamera.gI().xTo = 200;
      this.tfUser.setFocus(true);
      this.tfPass.setFocus(false);
      this.focus = 0;
      this.tfUser.setFocus(true);
   }

   public final void doLeftMenu() {
      this.cmdMenu = new Command(T.c, 0);
      this.D = new Command(T.dt, 3);
      this.cmdLogin = new Command(T.O, 1);
      this.cmdRemem = new Command(T.bA, 2);
      this.g = new Command(T.O, 104);
      super.left = this.cmdMenu;
   }

   public LoginScr() {
      this.init();
      this.tfUser.setFocus(true);
      this.tfUser.setIputType(0);
      this.tfPass.setIputType(2);
      this.tfReg.setIputType(2);
      this.tfEmail.setIputType(0);
      this.tfEmail.q = "Tùy chọn";
      this.focus = 0;
      if (CRes.b(CRes.b) == null) {
         AvatarData.b();
      }

   }

   public final void init() {
      if (Canvas.h > 200) {
         this.defYL = Canvas.hh - 80;
      } else {
         this.defYL = Canvas.hh - 65;
      }

      this.yL = -50;
      this.wC = Canvas.w - 30;
      if (this.wC < 70) {
         this.wC = 70;
      }

      if (this.wC > 99) {
         this.wC = 99;
      }

      this.xC = (Canvas.w - this.wC >> 1) + 29;
      if (Canvas.w <= 128) {
         this.wC = 80;
         this.xC = (Canvas.w - this.wC >> 1) + 20;
      }

      this.xC -= (AvMain.hd - 1) * 40;
      Canvas.paint.initPosLogin(this);
      this.defYL = this.yLogin / 2;
      this.yL = this.defYL;
      AvCamera.gI().followPlayer = GameMidlet.avatar;
      AvCamera.gI().update();
   }

   public final void commandActionPointer(int var1, int var2) {
      switch (var1) {
         case 0:
            this.isReg = true;
            Canvas.paint.initPosLogin(this);
            return;
         case 1:
            this.isReg = false;
            Canvas.paint.initPosLogin(this);
            return;
         case 2:
            Canvas.startOKDlg(T.P, 54);
            return;
         case 3:
            Canvas.startOK(T.du, 55, (AvMain)null);
            return;
         case 4:
            Canvas.inputDlg.setInfoIkb(T.bC, 100, 3);
            return;
         case 5:
            OptionScr.gI().switchToMe();
            return;
         case 6:
            GameMidlet.flatForm("http://wap.teamobi.com/faqs.php?provider=" + GameMidlet.f);
            return;
         case 7:
            GameMidlet.flatForm("http://wap.teamobi.com?info=checkupdate&game=8&version=2.5.8&provider=" + GameMidlet.f + "&agent=" + GameMidlet.g);
            return;
         case 8:
            if (!this.numSupport.equals("")) {
               GameMidlet.flatForm("tel:" + this.numSupport);
               return;
            }

            if (!Session_ME.gI().connected) {
               Canvas.startWaitDlg(T.M);
               Canvas.connect();
            } else {
               Canvas.startWaitDlg();
            }

            GlobalService.gI().requestService((byte)5, (String)null);
            return;
         case 9:
            Canvas.startOKDlg(T.bH + T.bG);
            AvatarData.delRMS();
         case 50:
         default:
      }
   }

   private void doRememberPass() {
      if (!this.isCheckBox) {
         this.isCheckBox = true;
         this.cmdRemem.caption = T.bJ;
      } else {
         this.isCheckBox = false;
         this.cmdRemem.caption = T.bA;
      }
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            Vector var5 = new Vector();
            Command var4 = new Command(T.x, 2);
            var5.addElement(new Command(T.bB, 4));
            var5.addElement(new Command(T.ab, 5));
            if (OptionScr.gI().b[4] == 0) {
               var5.addElement(new Command(T.bD, 6));
            }

            var5.addElement(new Command(T.bE, 7));
            if (OptionScr.gI().b[4] == 0) {
               var5.addElement(new Command(T.bF, 8));
            }

            var5.addElement(new Command(T.bG, 9));
            var5.addElement(var4);
            MenuSub.gI().startAt(var5, 0);
            return;
         case 1:
            isNewGame = true;
            super.left = this.cmdMenu;
            super.center = this.g;
            this.indexNewGame = 0;
            this.listStrNew = new String[]{"Chơi tiếp" + (!this.tfUser.getText().equals("") ? ", " + this.tfUser.getText() : ""), "Chơi mới", "Đổi tài khoản"};
            return;
         case 2:
            this.doRememberPass();
            return;
         case 3:
            if (this.tfUser.getText().equals("")) {
               Canvas.startOKDlg(T.eo[0]);
            } else if (this.tfPass.getText().equals("")) {
               Canvas.startOKDlg(T.eo[1]);
            } else if (this.tfReg.getText().equals("")) {
               Canvas.startOKDlg(T.eo[2]);
            } else if (!this.tfPass.getText().equals(this.tfReg.getText())) {
               Canvas.startOKDlg(T.eo[3]);
            } else {
               Canvas.endDlg();
               this.timeOut = System.currentTimeMillis();
               if (this.tfEmail.getText().equals("")) {
                  n();
                  return;
               }

               Canvas.startOKDlg("Bạn nên điền chính xác số di động hoặc email. Khi quên mật khẩu, bạn sẽ dùng nó để lấy lại. Bạn có chắc chắn đã điền số di động / email đúng chưa?", 102);
            }
            break;
         case 50:
            Canvas.startOKDlg(T.bI);
            return;
         case 51:
            this.regRequest();
            return;
         case 52:
            return;
         case 53:
            GameMidlet.flatForm("http://teamobi.com/dieukhoan.htm");
            return;
         case 54:
            GameMidlet.a();
            return;
         case 55:
            isSelectedLanguage = false;
            this.saveLogin();
            AvatarData.delErrorRms("avatarSV");
            GameMidlet.a();
            return;
         case 100:
            String var3;
            if ((var3 = Canvas.inputDlg.getText()).equals("")) {
               return;
            }

            (new class_n(this, var3)).perform();
            return;
         case 101:
            this.regRequest();
            return;
         case 102:
            n();
            return;
         case 103:
            return;
         case 104:
            this.clickNewGame();
      }

   }

   private void regRequest() {
      Canvas.startWaitDlg();
      Canvas.connect();
      GlobalService.gI().doRegisterByEmail(this.tfUser.getText().toLowerCase(), this.tfPass.getText().toLowerCase(), this.tfEmail.getText());
      this.isReg = false;
      super.center = this.cmdLogin;
      Canvas.paint.initPosLogin(this);
   }

   private static void n() {
      Vector var0;
      (var0 = new Vector()).addElement(new Command(T.e, 51));
      var0.addElement(new Command(T.bK, 52));
      var0.addElement(new Command(T.bL, 53));
      Canvas.a(T.bM, var0);
   }

   public final void update() {
      if ((System.currentTimeMillis() - this.timeOut) / 1000L > 300L) {
         GameMidlet.h.notifyDestroyed();
      }

      if (!isNewGame && this == Canvas.currentMyScreen && Canvas.menuMain == null && !isNewGame) {
         this.tfUser.update();
         this.tfPass.update();
         if (this.isReg) {
            this.tfReg.update();
            this.tfEmail.update();
         }

         if (this.tfUser.isFocused()) {
            super.right = this.tfUser.a();
         } else if (this.tfPass.isFocused()) {
            super.right = this.tfPass.a();
         } else if (this.tfReg.isFocused()) {
            super.right = this.tfReg.a();
         }
      } else {
         super.right = null;
      }

      if (this.defYL != this.yL) {
         this.yL += this.defYL - this.yL >> 1;
      }

      if (this.isReg) {
         super.center = this.D;
      } else if (this.focus == 2) {
         super.right = this.cmdRemem;
      }

      Canvas.loadMap.update();
   }

   public final void keyPress(int var1) {
      if (this.tfUser.isFocused()) {
         this.tfUser.keyPressed(var1);
      } else if (this.tfPass.isFocused()) {
         this.tfPass.keyPressed(var1);
      } else if (this.tfReg.isFocused()) {
         this.tfReg.keyPressed(var1);
      } else if (this.tfEmail.isFocused()) {
         this.tfEmail.keyPressed(var1);
      }

      super.keyPress(var1);
   }

   public final void paint(Graphics var1) {
      this.paintMain(var1);
      super.paint(var1);
      Canvas.paintPlus(var1);
   }

   public final void paintMain(Graphics var1) {
      Canvas.loadMap.paint(var1);
      Canvas.loadMap.paintBackGround(var1);
      Canvas.resetTrans(var1);
      int var4;
      if (isNewGame) {
         Graphics var3 = var1;
         LoginScr var2 = this;
         Canvas.paint.paintPopupBack(var1, this.xLogin, this.yLogin, this.wLogin, this.hLogin, 0);
         var1.translate(this.xLogin, this.yLogin + this.yNew);
         if (this.indexNewGame != -1) {
            Canvas.paint.c(var1, 5 * AvMain.hd, this.indexNewGame * this.hCellNew, this.wLogin - 10 * AvMain.hd, this.hCellNew);
         }

         for(var4 = 0; var4 < var2.listStrNew.length; ++var4) {
            Canvas.normalFont.drawString(var3, var2.listStrNew[var4], var2.wLogin / 2, var4 * var2.hCellNew + var2.hCellNew / 2 - Canvas.normalFont.getHeight() / 2, 2);
         }
      } else if (Canvas.currentDialog == null && this == Canvas.currentMyScreen) {
         Canvas.paint.paintPopupBack(var1, this.xLogin, this.yLogin, this.wLogin, this.hLogin, 0);
         var1.setClip(this.xLogin + 4, this.yLogin + 4, this.wLogin - 8, this.hLogin - 8);
         if (!this.numSupport.equals("") && OptionScr.gI().b[4] == 0) {
            Canvas.paint.drawString(var1, "Hotline: " + this.numSupport, this.xLogin + this.wLogin - 8, this.yLogin + this.hLogin - AvMain.ah - 4, 1);
         }

         this.tfUser.paint(var1);
         var1.setClip(this.xLogin + 4, this.yLogin + 4, this.wLogin - 8, this.hLogin - 8);
         if ((var4 = Canvas.normalFont.getWidth(T.bN + ":")) < this.tfUser.x - this.xLogin) {
            var4 = (this.tfUser.x - this.xLogin - var4) / 2 + AvMain.hDuBox;
         } else {
            var4 = this.tfUser.x - var4 - 5;
         }

         Canvas.paint.drawString(var1, T.bN, this.xLogin + var4, this.tfUser.y + this.tfUser.height / 2 - AvMain.ah / 2, 0);
         Canvas.paint.drawString(var1, T.bO + ":", this.xLogin + var4, this.tfPass.y + this.tfUser.height / 2 - AvMain.ah / 2, 0);
         if (!this.isReg) {
            Canvas.paint.paintCheckBox(var1, this.xCheck, this.yCheck, this.focus, this.isCheckBox);
         } else {
            Canvas.paint.drawString(var1, T.cE, this.xLogin + var4, this.tfReg.y + this.tfUser.height / 2 - AvMain.ah, 0);
            Canvas.paint.drawString(var1, T.bO + ":", this.xLogin + var4, this.tfReg.y + this.tfUser.height / 2, 0);
            Canvas.paint.drawString(var1, "Số di động", this.xLogin + var4, this.tfEmail.y + this.tfUser.height / 2 - AvMain.ah, 0);
            Canvas.paint.drawString(var1, "hoặc email:", this.xLogin + var4, this.tfEmail.y + this.tfUser.height / 2, 0);
            this.tfReg.paint(var1);
            this.tfEmail.paint(var1);
         }

         this.tfPass.paint(var1);
      }

      Canvas.resetTrans(var1);
      var1.drawImage(MyScreen.am, Canvas.hw, this.yL, 3);
   }

   public final void updateKey() {
      if (isNewGame) {
         LoginScr loginScr = this;
         if (Canvas.a(2)) {
            loginScr.indexNewGame = (byte)(loginScr.indexNewGame - 1);
            if (loginScr.indexNewGame < 0) {
               loginScr.indexNewGame = (byte)(loginScr.listStrNew.length - 1);
            }
         } else if (Canvas.a(8)) {
            loginScr.indexNewGame = (byte)(loginScr.indexNewGame + 1);
            if (loginScr.indexNewGame >= loginScr.listStrNew.length) {
               loginScr.indexNewGame = 0;
            }
         }
         if (Canvas.isPointerClick) {
            int n = 0;
            while (n < loginScr.listStrNew.length) {
               if (Canvas.b(loginScr.xLogin, loginScr.yLogin + loginScr.yNew + n * loginScr.hCellNew, loginScr.wLogin, loginScr.hCellNew)) {
                  loginScr.indexNewGame = (byte)n;
                  Canvas.isPointerClick = false;
                  loginScr.K = true;
                  break;
               }
               ++n;
            }
         }
         if (loginScr.K) {
            if (Canvas.isPointerDown && !Canvas.b(loginScr.xLogin, loginScr.yLogin + loginScr.yNew + loginScr.indexNewGame * loginScr.hCellNew, loginScr.wLogin, loginScr.hCellNew)) {
               loginScr.indexNewGame = (byte)-1;
            }
            if (Canvas.isPointerRelease) {
               Canvas.isPointerRelease = false;
               loginScr.K = false;
               if (loginScr.indexNewGame != -1) {
                  loginScr.clickNewGame();
               }
            }
         }
         super.updateKey();
         return;
      }
      if (Canvas.isPointerRelease && Canvas.isPointer(0, 0, Canvas.w, Canvas.h) && Canvas.isPointer(this.xCheck - 10, this.yCheck, 70, MyScreen.al * AvMain.hd + 10)) {
         this.doRememberPass();
      }
      if (Canvas.keyPressed[2]) {
         this.focus = this.focus > 0 ? --this.focus : (this.isReg ? 3 : 2);
      }
      if (Canvas.keyPressed[8]) {
         this.focus = this.focus < (this.isReg ? 3 : 2) ? ++this.focus : 0;
      }
      if (Canvas.keyPressed[2] || Canvas.keyPressed[8]) {
         Canvas.clearKeyPressed();
         if (this.focus == 0) {
            this.tfUser.setFocus(true);
            this.tfPass.setFocus(false);
            this.tfReg.setFocus(false);
            this.tfEmail.setFocus(false);
         } else if (this.focus == 1) {
            this.tfUser.setFocus(false);
            this.tfPass.setFocus(true);
            this.tfReg.setFocus(false);
            this.tfEmail.setFocus(false);
         } else if (this.focus == 2) {
            this.tfUser.setFocus(false);
            this.tfPass.setFocus(false);
            this.right = null;
            if (this.isReg) {
               this.tfReg.setFocus(true);
               this.tfEmail.setFocus(false);
            }
         } else {
            this.tfUser.setFocus(false);
            this.tfPass.setFocus(false);
            this.tfReg.setFocus(false);
            this.tfEmail.setFocus(true);
         }
      }
      super.updateKey();
   }

   private void clickNewGame() {
      System.out.println("clickNewGame: " + isAccVir + "    " + this.indexNewGame);
      switch (this.indexNewGame) {
         case 0:
            if (this.listStrNew.length == 2) {
               (new IAcionNewGameOk(this)).perform();
               return;
            }

            if (isAccVir) {
               ServerListScr.gI().switchToMe();
               return;
            }

            String var2 = this.tfUser.getText().toLowerCase().trim();
            String var3 = this.tfPass.getText();
            if (!var2.equals("")) {
               if (var3.equals("")) {
                  this.focus = 1;
                  this.tfUser.setFocus(false);
                  this.tfPass.setFocus(true);
                  break;
               }

               ServerListScr.gI().switchToMe();
            }

            return;
         case 1:
            if (this.listStrNew.length != 2) {
               IAcionNewGameOk var1 = new IAcionNewGameOk(this);
               if (!this.nameVir.equals("") && this.tfUser.getText().equals("")) {
                  Canvas.startOKDlg("Tài khoản của bạn chưa được đăng kí liên kết với một tài khoản Team. Bạn sẽ mất tài khoản đang chơi nếu tiếp tục. Bạn có muốn tiếp tục ?", (IAction)var1);
                  return;
               }

               var1.perform();
               return;
            }
         case 2:
            this.changeAcc();
      }

   }

   private void changeAcc() {
      IActionChangeAcc var1 = new IActionChangeAcc(this);
      if (!this.nameVir.equals("") && this.tfUser.getText().equals("")) {
         Canvas.startOKDlg("Tài khoản của bạn chưa được đăng kí liên kết với một tài khoản Team. Bạn sẽ mất tài khoản đang chơi nếu tiếp tục. Bạn có muốn tiếp tục ?", (IAction)var1);
      } else {
         var1.perform();
      }
   }

   public final void saveLogin() {
      System.out.println("saveLogin");
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      DataOutputStream var2 = new DataOutputStream(var1);

      try {
         var2.writeUTF("2.5.8");
         var2.writeByte(super.selected_);
         var2.writeUTF(this.numSupport);
         var2.writeUTF(this.nameVir);
         var2.writeUTF(this.passVir);
         if (this.isCheckBox) {
            var2.writeUTF(gI().tfUser.getText());
            var2.writeUTF(gI().tfPass.getText());
         }

         var2.writeInt(s);
         var2.writeBoolean(isSelectedLanguage);
         var2.writeBoolean(isAccVir);
         CRes.saveRMS("avlogin", var1.toByteArray());
         var2.close();
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public final void loadLogin() {
      DataInputStream var1;
      if ((var1 = AvatarData.loadRMS("avlogin")) != null) {
         String var2 = "";

         try {
            var2 = var1.readUTF();
            super.selected_ = var1.readByte();
            this.numSupport = var1.readUTF();
            this.nameVir = var1.readUTF();
            this.passVir = var1.readUTF();
            if (this.isCheckBox) {
               this.tfUser.setText(var1.readUTF());
               this.tfPass.setText(var1.readUTF());
            }

            s = var1.readInt();
            isSelectedLanguage = var1.readBoolean();
            isAccVir = var1.readBoolean();
            var1.close();
         } catch (Exception var3) {
            AvatarData.delErrorRms("avlogin");
         }

         if (!isSelectedLanguage) {
            AvatarData.delErrorRms("avatarSV");
         }

         if (!"2.5.8".equals(var2)) {
            AvatarData.delRMS();
         }

      }
   }

   public final void onNumSupport(String var1) {
      this.numSupport = var1;
   }

   public final void login() {
      Canvas.connect();
      GlobalService.gI().doRequestNumSupport(gI().numSupport.hashCode());
      System.out.println("login: " + isNewGame + "    " + this.indexNewGame);
      if (!isNewGame || (this.indexNewGame != 0 || this.listStrNew.length != 2) && (this.indexNewGame != 1 || this.listStrNew.length != 3)) {
         if (this.tfUser.getText().equals("")) {
            GlobalService.gI().login(this.nameVir, this.passVir, "2.5.8");
            isAccVir = true;
         } else {
            isAccVir = false;
            this.nameVir = "";
            this.passVir = "";
            GlobalService.gI().login(this.tfUser.getText().toLowerCase(), this.tfPass.getText(), "2.5.8");
         }
      } else {
         GlobalService var1 = GlobalService.gI();
         System.out.println("doLoginNewGame");
         var1.createMessage((byte)-12);
         var1.sendMessage();
      }
   }

   public final void onLoginNewGame(String var1, String var2) {
      System.out.println("onLoginNewGame: " + var1 + "   " + var2);
      this.nameVir = var1;
      this.passVir = var2;
      this.tfUser.setText("");
      this.tfPass.setText("");
      isAccVir = true;
      isNewGame = false;
      this.login();
   }
}

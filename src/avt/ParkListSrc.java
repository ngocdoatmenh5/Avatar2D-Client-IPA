package avt;

import javax.microedition.lcdui.Graphics;
import main.Canvas;

public final class ParkListSrc extends MyScreen {
   public static ParkListSrc instance;
   private int[] listBoard;
   private MyScreen lastScr;
   private int d = 5;
   private int e;
   private int f = 7;

   public static ParkListSrc gI() {
      if (instance == null) {
         instance = new ParkListSrc();
      }

      return instance;
   }

   public final void switchToMe(MyScreen var1) {
      super.switchToMe();
      this.lastScr = var1;
      super.selected_ = 0;
   }

   public final void commandTab(int var1, int var2) {
      switch (var1) {
         case 0:
            Canvas.cameraList.isShow = false;
            this.lastScr.switchToMe();
            return;
         case 1:
            Canvas.cameraList.isShow = false;
            this.lastScr.switchToMe();
            ParkService.gI().doJoinPark(MapScr.roomID, super.selected_);
         default:
      }
   }

   public ParkListSrc() {
      super.right = new Command(T.d, 0);
      super.center = new Command(T.O, 1);
      this.e = 20;
      if (Canvas.stypeInt > 0) {
         this.e = Canvas.stypeInt * 30;
      }

      if (Canvas.w < 176) {
         this.e = 15;
      }

      if (this.f * this.e > Canvas.h - Canvas.hTab) {
         this.f = (Canvas.h - Canvas.hTab) / this.e;
      }

   }

   public final void setSelected(int var1, boolean var2) {
      if (var2 && super.selected_ == var1 && super.center != null) {
         super.center.perform();
      }

      super.setSelected(var1, var2);
   }

   public final void setList(int[] var1) {
      this.listBoard = var1;
      Canvas.cameraList.a(Canvas.hw - (this.e * this.d + 10) / 2 + 4, Canvas.hh - this.e * this.f / 2, this.e, this.e, this.d * this.e, this.listBoard.length / this.d * this.e, this.e * this.d, this.e * this.f - (Canvas.stypeInt == 0 ? 30 : 0), var1.length);
   }

   public final void updateKey() {
      super.updateKey();
   }

   public final void update() {
      this.lastScr.update();
   }

   public final void paint(Graphics var1) {
      var1.translate(0, 0);
      var1.setClip(0, 0, Canvas.w, Canvas.h);
      this.lastScr.paintMain(var1);
      Canvas.paint.a(var1, Canvas.hw - (this.e * this.d + 10) / 2, Canvas.hh - this.e * this.f / 2, this.e * this.d + 10, this.e * this.f);
      Canvas.paint.a(var1, this.e, this.d, this.f, super.aj, super.selected_, this.listBoard);
      super.paint(var1);
   }
}

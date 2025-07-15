package avt;

final class class_ka implements IAction {
   class_ka(ParkMsgHandler var1) {
   }

   public final void perform() {
      ParkService.gI().doJoinPark(21, 0);
   }
}

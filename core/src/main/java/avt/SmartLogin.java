package avt;

import main.Canvas;

public final class SmartLogin implements Runnable {
   private static final long LOGIN_RETRY_INTERVAL_MS = 5000L;
   private static final long POLL_MS = 500L;
   private static final long IDLE_SLEEP_MS = 1000L;

   public final void run() {
      while (ClientUtilities.fishingAutoLogin) {
         try {
            if (Canvas.currentMyScreen == LoginScr.gI() && ClientUtilities.isFishingReloginWaiting()) {
               long now = System.currentTimeMillis();
               if (now >= ClientUtilities.getFishingReloginNextAtMs()) {
                  ClientUtilities.scheduleFishingReloginNextLoginAttempt(LOGIN_RETRY_INTERVAL_MS);
                  try {
                     LoginScr.gI().login();
                  } catch (Throwable t) {
                  }
               }
               Thread.sleep(POLL_MS);
            } else {
               Thread.sleep(IDLE_SLEEP_MS);
            }
         } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            break;
         } catch (Throwable t) {
            try {
               Thread.sleep(POLL_MS);
            } catch (InterruptedException ie) {
               Thread.currentThread().interrupt();
               break;
            }
         }
      }
   }
}

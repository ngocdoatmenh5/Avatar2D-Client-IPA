package avt;

import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import main.Canvas;
import main.GameMidlet;

public final class FireworkSettingsScr {
   public static FireworkSettingsScr instance = new FireworkSettingsScr();

   private static final String RMS_KEY = "firework_settings";

   public boolean autoFirework25k = false;
   public boolean autoFirework5Luong = false;
   public boolean autoFirework5k = false;
   public boolean autoFirework50Luong = false;
   public int shootInterval = 30;
   public int shootQuantity = 1;

   private static boolean isAutoRunning = false;
   private static int lastShootTick = 0;

   public static FireworkSettingsScr gI() {
      if (instance == null) {
         instance = new FireworkSettingsScr();
      }
      return instance;
   }

   public static void stopAutoFirework() {
      isAutoRunning = false;
   }

   public static boolean isAutoRunning() {
      return isAutoRunning;
   }

   public static void updateAutoFirework() {
      if (!isAutoRunning) return;

      FireworkSettingsScr settings = gI();
      if (settings.shootInterval <= 0) return;

      int intervalTicks = settings.shootInterval / 100;
      if (Canvas.gameTick - lastShootTick >= intervalTicks || lastShootTick > Canvas.gameTick) {
         int actionId = -1;

         if (settings.autoFirework25k) actionId = 1002;
         else if (settings.autoFirework5Luong) actionId = 1003;
         else if (settings.autoFirework5k) actionId = 1004;
         else if (settings.autoFirework50Luong) actionId = 1005;

         if (actionId >= 0) {
            for (int i = 0; i < settings.shootQuantity; i++) {
               GlobalService.gI().doRequestCmdRotate(actionId, -1);
            }
         }
         lastShootTick = Canvas.gameTick;
      }
   }

   public static void startAutoFirework() {
      if (isAutoRunning) return;
      isAutoRunning = true;
      lastShootTick = Canvas.gameTick;
   }

   public void show(MyScreen lastScr) {
      final MyScreen last = lastScr;
      final Form form = new Form("Cài đặt Đốt pháo");

      final ChoiceGroup cgFirework = new ChoiceGroup("Loại pháo", ChoiceGroup.MULTIPLE);
      cgFirework.append("Đốt pháo 25000 xu (1002)", null);
      cgFirework.append("Đốt pháo 5 Lượng (1003)", null);
      cgFirework.append("Bắn pháo hoa 5000 xu (1004)", null);
      cgFirework.append("Bắn pháo hoa 50 lượng (1005)", null);

      cgFirework.setSelectedIndex(0, this.autoFirework25k);
      cgFirework.setSelectedIndex(1, this.autoFirework5Luong);
      cgFirework.setSelectedIndex(2, this.autoFirework5k);
      cgFirework.setSelectedIndex(3, this.autoFirework50Luong);

      final TextField tfInterval = new TextField("Khoảng cách bắn (ms)", String.valueOf(this.shootInterval), 10, TextField.NUMERIC);
      final TextField tfQuantity = new TextField("Số lượng bắn", String.valueOf(this.shootQuantity), 5, TextField.NUMERIC);

      form.append(cgFirework);
      form.append(tfInterval);
      form.append(tfQuantity);

      final Command cmdSave = new Command("Lưu", Command.OK, 1);
      final Command cmdCancel = new Command(T.cancel, Command.BACK, 1);
      form.addCommand(cmdSave);
      form.addCommand(cmdCancel);
      form.setCommandListener(new CommandListener() {
         public void commandAction(Command c, Displayable d) {
            if (c == cmdSave) {
               FireworkSettingsScr g = FireworkSettingsScr.gI();

               g.autoFirework25k = cgFirework.isSelected(0);
               g.autoFirework5Luong = cgFirework.isSelected(1);
               g.autoFirework5k = cgFirework.isSelected(2);
               g.autoFirework50Luong = cgFirework.isSelected(3);

               try {
                  g.shootInterval = Integer.parseInt(tfInterval.getString().trim());
                  if (g.shootInterval < 100) g.shootInterval = 100;
                  if (g.shootInterval > 600000) g.shootInterval = 600000;
               } catch (Exception e) {
                  g.shootInterval = 30000;
               }

               try {
                  g.shootQuantity = Integer.parseInt(tfQuantity.getString().trim());
                  if (g.shootQuantity < 1) g.shootQuantity = 1;
                  if (g.shootQuantity > 100) g.shootQuantity = 100;
               } catch (Exception e) {
                  g.shootQuantity = 1;
               }

               g.save();

               Canvas.startOKDlg("Đã lưu cài đặt!");
            }

            Canvas.instance.setFullScreenMode(true);
            Display.getDisplay(GameMidlet.instance).setCurrent(Canvas.instance);
            if (last != null) {
               last.switchToMe();
            }
         }
      });

      Display.getDisplay(GameMidlet.instance).setCurrent(form);
   }

   private void save() {
      try {
         String data = (autoFirework25k ? "1" : "0") + ";"
                     + (autoFirework5Luong ? "1" : "0") + ";"
                     + (autoFirework5k ? "1" : "0") + ";"
                     + (autoFirework50Luong ? "1" : "0") + ";"
                     + shootInterval + ";"
                     + shootQuantity;
         CRes.a(RMS_KEY, data);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void load() {
      try {
         String data = CRes.b(RMS_KEY);
         if (data != null && data.length() > 0) {
            String[] parts = CRes.split(data, ";");
            if (parts.length >= 6) {
               this.autoFirework25k = parts[0].equals("1");
               this.autoFirework5Luong = parts[1].equals("1");
               this.autoFirework5k = parts[2].equals("1");
               this.autoFirework50Luong = parts[3].equals("1");
               try { this.shootInterval = Integer.parseInt(parts[4]); } catch (Exception e) {}
               try { this.shootQuantity = Integer.parseInt(parts[5]); } catch (Exception e) {}
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}

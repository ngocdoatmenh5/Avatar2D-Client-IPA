package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;
import java.util.HashMap;
import java.util.Map;

public class Display {
    public static final int LIST_ELEMENT = 1;
    public static final int CHOICE_GROUP_ELEMENT = 2;
    public static final int ALERT = 3;
    public static final int COLOR_BACKGROUND = 0;
    public static final int COLOR_FOREGROUND = 1;

    private static final Map<MIDlet, Display> displays = new HashMap<MIDlet, Display>();
    private Displayable current;

    private Display() {
    }

    public static Display getDisplay(MIDlet m) {
        synchronized (displays) {
            Display d = displays.get(m);
            if (d == null) {
                d = new Display();
                displays.put(m, d);
            }
            return d;
        }
    }

    public Displayable getCurrent() {
        return current;
    }

    public void setCurrent(Displayable nextDisplayable) {
        this.current = nextDisplayable;
    }

    public void setCurrent(Alert alert, Displayable nextDisplayable) {
        this.current = nextDisplayable;
    }

    public void callSerially(Runnable r) {
        if (r != null) {
            new Thread(r).start();
        }
    }

    public boolean flashBacklight(int duration) {
        return false;
    }

    public boolean vibrate(int duration) {
        return false;
    }

    public int getColor(int colorSpecifier) {
        return 0;
    }
}

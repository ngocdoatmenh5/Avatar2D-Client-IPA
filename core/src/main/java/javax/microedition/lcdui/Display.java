package javax.microedition.lcdui;

import com.badlogic.gdx.Gdx;
import main.Canvas;
import main.screen.lcdui.LcduiScreenOverlay;

public final class Display {
    private static final Display instance = new Display();
    private Displayable current;

    public static Display getDisplay(javax.microedition.midlet.MIDlet m) {
        return instance;
    }

    public void setCurrent(Displayable d) {
        this.current = d;
        if (Gdx.app == null) {
            applyCurrent(d);
            return;
        }
        Gdx.app.postRunnable(() -> applyCurrent(d));
    }

    public void setCurrent(Alert a, Displayable next) {
        setCurrent(next);
    }

    private void applyCurrent(Displayable d) {
        if (d == null || d instanceof Canvas) {
            LcduiScreenOverlay.dismissOverlay();
            return;
        }
        if (d instanceof Form || d instanceof List) {
            LcduiScreenOverlay.showOverlay(d);
            return;
        }
        LcduiScreenOverlay.dismissOverlay();
    }

    public Displayable getCurrent() {
        return this.current;
    }

    public void vibrate(int duration) {
    }
}

package javax.microedition.midlet;

import javax.microedition.lcdui.Displayable;
import java.io.InputStream;

public abstract class MIDlet {
    private static MIDlet instance;

    protected MIDlet() {
        instance = this;
    }

    public static MIDlet getInstance() {
        return instance;
    }

    protected abstract void startApp();
    protected abstract void pauseApp();
    protected abstract void destroyApp(boolean unconditional);

    public void notifyDestroyed() {
    }

    public void notifyPaused() {
    }

    public String getAppProperty(String key) {
        return null;
    }

    public final InputStream getClassResourceAsStream(String name) {
        return getClass().getResourceAsStream(name);
    }

    public boolean platformRequest(String URL) throws javax.microedition.io.ConnectionNotFoundException {
        return false;
    }
}


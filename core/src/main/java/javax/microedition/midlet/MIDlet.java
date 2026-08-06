package javax.microedition.midlet;

import com.badlogic.gdx.Gdx;
import javax.microedition.io.ConnectionNotFoundException;

public abstract class MIDlet {
    public void notifyDestroyed() {
        Gdx.app.exit();
    }

    public boolean platformRequest(String url) throws ConnectionNotFoundException {
        Gdx.net.openURI(url);
        return true;
    }
}

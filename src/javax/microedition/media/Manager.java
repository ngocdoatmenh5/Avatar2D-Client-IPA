package javax.microedition.media;

import java.io.InputStream;
import java.io.IOException;

public class Manager {
    public static final String TONE_DEVICE_LOCATOR = "device://tone";

    public static Player createPlayer(InputStream stream, String type) throws IOException, MediaException {
        return new DummyPlayer();
    }

    public static Player createPlayer(String locator) throws IOException, MediaException {
        return new DummyPlayer();
    }

    public static void playTone(int note, int duration, int volume) throws MediaException {
    }

    private static class DummyPlayer implements Player {
        public void realize() {}
        public void prefetch() {}
        public void start() {}
        public void stop() {}
        public void deallocate() {}
        public void close() {}
        public int getState() { return UNREALIZED; }
        public void setLoopCount(int count) {}
        public Control getControl(String controlType) { return null; }
        public Control[] getControls() { return new Control[0]; }
        public void addPlayerListener(PlayerListener listener) {}
        public void removePlayerListener(PlayerListener listener) {}
    }
}

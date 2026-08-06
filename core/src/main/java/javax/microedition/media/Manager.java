package javax.microedition.media;

import java.io.InputStream;
import javax.microedition.media.control.VolumeControl;

public final class Manager {
    private Manager() {
    }

    public static Player createPlayer(InputStream stream, String type) throws MediaException {
        return new NoopPlayer();
    }

    private static final class NoopPlayer implements Player {
        private int state = REALIZED;

        @Override
        public int getState() {
            return this.state;
        }

        @Override
        public void start() {
            if (this.state != CLOSED) {
                this.state = STARTED;
            }
        }

        @Override
        public void stop() {
            if (this.state == STARTED) {
                this.state = PREFETCHED;
            }
        }

        @Override
        public void close() {
            this.state = CLOSED;
        }

        @Override
        public void setLoopCount(int count) {
        }

        @Override
        public Object getControl(String controlType) {
            if ("VolumeControl".equals(controlType)) {
                return (VolumeControl) level -> level;
            }
            return null;
        }
    }
}

package javax.microedition.media;

public interface Player {
    int UNREALIZED = 100;
    int REALIZED = 200;
    int PREFETCHED = 300;
    int STARTED = 400;
    int CLOSED = 0;

    int getState();

    void start() throws MediaException;

    void stop() throws MediaException;

    void close();

    void setLoopCount(int count);

    Object getControl(String controlType);
}

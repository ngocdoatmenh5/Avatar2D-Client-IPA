package javax.microedition.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public interface SocketConnection {
    DataOutputStream openDataOutputStream() throws IOException;

    DataInputStream openDataInputStream() throws IOException;

    void close() throws IOException;
}

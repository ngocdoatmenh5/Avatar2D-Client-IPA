package javax.microedition.io;

import java.io.IOException;
import java.io.InputStream;

public interface HttpConnection extends Connection {
    void setRequestMethod(String method);

    void setRequestProperty(String key, String value);

    int getResponseCode() throws IOException;

    InputStream openInputStream() throws IOException;

    long getLength();
}

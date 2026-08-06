package javax.microedition.io;

import java.io.IOException;

public interface HttpConnection extends ContentConnection {
    String GET = "GET";
    String POST = "POST";
    String HEAD = "HEAD";

    int HTTP_OK = 200;
    int HTTP_CREATED = 201;
    int HTTP_ACCEPTED = 202;
    int HTTP_NO_CONTENT = 204;
    int HTTP_MOVED_PERM = 301;
    int HTTP_FOUND = 302;
    int HTTP_BAD_REQUEST = 400;
    int HTTP_UNAUTHORIZED = 401;
    int HTTP_FORBIDDEN = 403;
    int HTTP_NOT_FOUND = 404;
    int HTTP_INTERNAL_ERROR = 500;
    int HTTP_NOT_IMPLEMENTED = 501;

    String getRequestMethod();
    void setRequestMethod(String method) throws IOException;
    String getRequestProperty(String key);
    void setRequestProperty(String key, String value) throws IOException;
    int getResponseCode() throws IOException;
    String getResponseMessage() throws IOException;
    String getHeaderField(String name) throws IOException;
    String getHeaderField(int n) throws IOException;
}

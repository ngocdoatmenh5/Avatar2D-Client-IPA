package javax.microedition.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.net.Socket;

public class Connector {
    public static final int READ = 1;
    public static final int WRITE = 2;
    public static final int READ_WRITE = 3;

    public static Connection open(String name) throws IOException {
        return open(name, READ_WRITE, false);
    }

    public static Connection open(String name, int mode) throws IOException {
        return open(name, mode, false);
    }

    public static Connection open(String name, int mode, boolean timeouts) throws IOException {
        if (name == null) throw new IllegalArgumentException("URL is null");

        if (name.startsWith("socket://")) {
            String target = name.substring(9);
            int idx = target.indexOf(':');
            if (idx != -1) {
                String host = target.substring(0, idx);
                int port = Integer.parseInt(target.substring(idx + 1));
                final Socket socket = new Socket(host, port);
                return new SocketConnection() {
                    public String getAddress() { return socket.getInetAddress().getHostAddress(); }
                    public int getPort() { return socket.getPort(); }
                    public int getLocalPort() { return socket.getLocalPort(); }
                    public String getLocalAddress() { return socket.getLocalAddress().getHostAddress(); }
                    public void setSocketOption(byte option, int value) {}
                    public int getSocketOption(byte option) { return 0; }
                    public InputStream openInputStream() throws IOException { return socket.getInputStream(); }
                    public DataInputStream openDataInputStream() throws IOException { return new DataInputStream(socket.getInputStream()); }
                    public OutputStream openOutputStream() throws IOException { return socket.getOutputStream(); }
                    public DataOutputStream openDataOutputStream() throws IOException { return new DataOutputStream(socket.getOutputStream()); }
                    public void close() throws IOException { socket.close(); }
                };
            }
        } else if (name.startsWith("http://") || name.startsWith("https://")) {
            URL url = new URL(name);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            return new HttpConnection() {
                public String getRequestMethod() { return conn.getRequestMethod(); }
                public void setRequestMethod(String method) throws IOException { conn.setRequestMethod(method); }
                public String getRequestProperty(String key) { return conn.getRequestProperty(key); }
                public void setRequestProperty(String key, String value) throws IOException { conn.setRequestProperty(key, value); }
                public int getResponseCode() throws IOException { return conn.getResponseCode(); }
                public String getResponseMessage() throws IOException { return conn.getResponseMessage(); }
                public String getHeaderField(String name) { return conn.getHeaderField(name); }
                public String getHeaderField(int n) { return conn.getHeaderField(n); }
                public String getType() { return conn.getContentType(); }
                public String getEncoding() { return conn.getContentEncoding(); }
                public long getLength() { return conn.getContentLengthLong(); }
                public InputStream openInputStream() throws IOException { return conn.getInputStream(); }
                public DataInputStream openDataInputStream() throws IOException { return new DataInputStream(conn.getInputStream()); }
                public OutputStream openOutputStream() throws IOException { return conn.getOutputStream(); }
                public DataOutputStream openDataOutputStream() throws IOException { return new DataOutputStream(conn.getOutputStream()); }
                public void close() { conn.disconnect(); }
            };
        }
        throw new ConnectionNotFoundException("Unsupported protocol: " + name);
    }

    public static DataInputStream openDataInputStream(String name) throws IOException {
        Connection c = open(name, READ);
        if (c instanceof InputConnection) {
            return ((InputConnection) c).openDataInputStream();
        }
        throw new IOException("Connection is not an InputConnection");
    }

    public static DataOutputStream openDataOutputStream(String name) throws IOException {
        Connection c = open(name, WRITE);
        if (c instanceof OutputConnection) {
            return ((OutputConnection) c).openDataOutputStream();
        }
        throw new IOException("Connection is not an OutputConnection");
    }

    public static InputStream openInputStream(String name) throws IOException {
        Connection c = open(name, READ);
        if (c instanceof InputConnection) {
            return ((InputConnection) c).openInputStream();
        }
        throw new IOException("Connection is not an InputConnection");
    }

    public static OutputStream openOutputStream(String name) throws IOException {
        Connection c = open(name, WRITE);
        if (c instanceof OutputConnection) {
            return ((OutputConnection) c).openOutputStream();
        }
        throw new IOException("Connection is not an OutputConnection");
    }
}

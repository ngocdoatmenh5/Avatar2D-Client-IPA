package main.lib;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * LibGDX replacement for javax.microedition.io.SocketConnection.
 */
public final class MeSocket {
    private final Socket socket;

    public MeSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public static MeSocket open(String url) throws IOException {
        String s = url;
        int semi = s.indexOf(';');
        if (semi >= 0) {
            s = s.substring(0, semi);
        }
        if (s.startsWith("socket://")) {
            s = s.substring("socket://".length());
        }
        int colon = s.lastIndexOf(':');
        if (colon < 0) {
            throw new IOException("Invalid socket url: " + url);
        }
        String host = s.substring(0, colon);
        int port = Integer.parseInt(s.substring(colon + 1));
        return new MeSocket(host, port);
    }

    public DataOutputStream openDataOutputStream() throws IOException {
        return new DataOutputStream(socket.getOutputStream());
    }

    public DataInputStream openDataInputStream() throws IOException {
        return new DataInputStream(socket.getInputStream());
    }

    public void close() throws IOException {
        socket.close();
    }
}

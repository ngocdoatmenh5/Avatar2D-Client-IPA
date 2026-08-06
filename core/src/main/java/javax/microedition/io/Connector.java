package javax.microedition.io;

import java.io.IOException;
import main.lib.MeSocket;
import main.lib.NativeHttpClient;

public final class Connector {
    public static final int READ = 1;
    public static final int WRITE = 2;

    private Connector() {
    }

    public static javax.microedition.io.Connection open(String name) throws IOException {
        if (name.startsWith("socket://")) {
            return new SocketConnectionAdapter(MeSocket.open(name));
        }
        if (name.startsWith("http://") || name.startsWith("https://")) {
            return new HttpConnectionAdapter(name);
        }
        if (name.startsWith("sms://")) {
            return new SmsConnectionAdapter();
        }
        throw new IOException("Unsupported connection: " + name);
    }

    private static final class SocketConnectionAdapter implements SocketConnection, Connection {
        private final MeSocket socket;

        SocketConnectionAdapter(MeSocket socket) {
            this.socket = socket;
        }

        @Override
        public java.io.DataOutputStream openDataOutputStream() throws IOException {
            return socket.openDataOutputStream();
        }

        @Override
        public java.io.DataInputStream openDataInputStream() throws IOException {
            return socket.openDataInputStream();
        }

        @Override
        public void close() throws IOException {
            socket.close();
        }
    }

    private static final class HttpConnectionAdapter implements HttpConnection, Connection {
        private final String url;
        private String body;

        HttpConnectionAdapter(String url) {
            this.url = url;
        }

        @Override
        public void setRequestMethod(String method) {
        }

        @Override
        public void setRequestProperty(String key, String value) {
        }

        @Override
        public int getResponseCode() throws IOException {
            body = NativeHttpClient.getResponseSync(url);
            return body != null ? 200 : 500;
        }

        @Override
        public java.io.InputStream openInputStream() {
            return new java.io.ByteArrayInputStream(body != null ? body.getBytes() : new byte[0]);
        }

        @Override
        public long getLength() {
            return body != null ? body.length() : -1;
        }

        @Override
        public void close() {
        }
    }

    private static final class SmsConnectionAdapter implements javax.wireless.messaging.MessageConnection, Connection {
        @Override
        public javax.wireless.messaging.Message newMessage(String type) {
            return new javax.wireless.messaging.TextMessage() {
                private String address;
                private String text;

                @Override
                public void setAddress(String address) {
                    this.address = address;
                }

                @Override
                public void setPayloadText(String text) {
                    this.text = text;
                }
            };
        }

        @Override
        public void send(javax.wireless.messaging.Message message) {
        }

        @Override
        public void close() {
        }
    }
}

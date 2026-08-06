package javax.wireless.messaging;

public interface MessageConnection {
    Message newMessage(String type);

    void send(Message message);

    void close();
}

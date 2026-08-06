package javax.microedition.lcdui;

public class Alert extends Screen {
    public Alert(String title) {
        setTitle(title);
    }
    public Alert(String title, String alertText, Image alertImage, AlertType alertType) {
        setTitle(title);
    }
}

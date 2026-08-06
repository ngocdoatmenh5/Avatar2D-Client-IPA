package javax.microedition.lcdui;

public class StringItem extends Item {
    private String text;

    public StringItem(String label, String text) {
        setLabel(label);
        this.text = text;
    }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}

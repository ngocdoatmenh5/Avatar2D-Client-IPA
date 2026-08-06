package javax.microedition.lcdui;

public class Item {
    private String label;

    public Item() {
    }

    public Item(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

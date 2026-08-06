package javax.microedition.lcdui;

public abstract class Item {
    private String label;

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
    public void addCommand(Command cmd) {}
    public void removeCommand(Command cmd) {}
    public void setItemCommandListener(ItemCommandListener l) {}
    public int getPreferredWidth() { return 0; }
    public int getPreferredHeight() { return 0; }
    public void setDefaultCommand(Command cmd) {}
}

package javax.microedition.lcdui;

public class TextBox extends Screen {
    private String text = "";
    private int maxSize = 500;
    private int constraints = 0;

    public TextBox(String title, String text, int maxSize, int constraints) {
        setTitle(title);
        this.text = text != null ? text : "";
        this.maxSize = maxSize;
        this.constraints = constraints;
    }

    public String getString() { return text; }
    public void setString(String text) { this.text = text != null ? text : ""; }
    public int getMaxSize() { return maxSize; }
    public int setMaxSize(int maxSize) { this.maxSize = maxSize; return maxSize; }
    public int getConstraints() { return constraints; }
    public void setConstraints(int constraints) { this.constraints = constraints; }
}

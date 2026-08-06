package javax.microedition.lcdui;

public class Form extends Screen {
    public Form(String title) {
        setTitle(title);
    }
    public Form(String title, Item[] items) {
        setTitle(title);
    }
    public int append(Item item) { return 0; }
    public int append(String str) { return 0; }
    public int append(Image img) { return 0; }
    public void delete(int itemNum) {}
    public void deleteAll() {}
    public Item get(int itemNum) { return null; }
    public void set(int itemNum, Item item) {}
    public int size() { return 0; }
}

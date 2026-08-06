package javax.microedition.lcdui;

import java.util.Vector;

public class Form extends Displayable {
    private final Vector items = new Vector();

    public Form(String title) {
        setTitle(title);
    }

    public int size() {
        return this.items.size();
    }

    public Object get(int index) {
        return this.items.elementAt(index);
    }

    public void append(String item) {
        this.items.addElement(item);
    }

    public void append(Item item) {
        this.items.addElement(item);
    }

    public void append(ChoiceGroup group) {
        this.items.addElement(group);
    }
}

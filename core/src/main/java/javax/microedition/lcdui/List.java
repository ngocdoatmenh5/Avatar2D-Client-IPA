package javax.microedition.lcdui;

import java.util.Vector;
import main.lib.Image;

public class List extends Displayable {
    public static final int IMPLICIT = 0;
    public static final Command SELECT_COMMAND = new Command("", 4, 0);

    private final int listType;
    private final Vector choices = new Vector();
    private Command selectCommand;
    private int selectedIndex;

    public List(String title, int listType) {
        setTitle(title);
        this.listType = listType;
        this.selectedIndex = -1;
    }

    public int getListType() {
        return this.listType;
    }

    public void setSelectCommand(Command cmd) {
        this.selectCommand = cmd;
    }

    public Command getSelectCommand() {
        return this.selectCommand;
    }

    public int size() {
        return this.choices.size();
    }

    public String getChoice(int index) {
        return (String) this.choices.elementAt(index);
    }

    public void append(String elementPart, Image imagePart) {
        this.choices.addElement(elementPart == null ? "" : elementPart);
        if (this.selectedIndex < 0 && this.choices.size() == 1) {
            this.selectedIndex = 0;
        }
    }

    public void setSelectedIndex(int elementNum, boolean selected) {
        if (selected && elementNum >= 0 && elementNum < this.choices.size()) {
            this.selectedIndex = elementNum;
        }
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }
}

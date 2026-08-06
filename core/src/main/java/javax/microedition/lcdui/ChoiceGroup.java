package javax.microedition.lcdui;

import java.util.Vector;
import main.lib.Image;

public class ChoiceGroup extends Item {
    public static final int EXCLUSIVE = 1;
    public static final int MULTIPLE = 2;
    public static final int POPUP = 4;

    private final int choiceType;
    private final Vector choices = new Vector();
    private int selectedIndex;
    private boolean[] selected;

    public ChoiceGroup(String label, int choiceType) {
        super(label);
        this.choiceType = choiceType;
        this.selectedIndex = -1;
    }

    public int getChoiceType() {
        return this.choiceType;
    }

    public int size() {
        return this.choices.size();
    }

    public String getChoice(int index) {
        return (String) this.choices.elementAt(index);
    }

    public void append(String elementPart, Image imagePart) {
        this.choices.addElement(elementPart == null ? "" : elementPart);
        if (this.choiceType == MULTIPLE) {
            boolean[] next = new boolean[this.choices.size()];
            if (this.selected != null) {
                System.arraycopy(this.selected, 0, next, 0, this.selected.length);
            }
            this.selected = next;
        } else if (this.selectedIndex < 0 && this.choices.size() == 1) {
            this.selectedIndex = 0;
        }
    }

    public boolean isSelected(int elementNum) {
        if (elementNum < 0 || elementNum >= this.choices.size()) {
            return false;
        }
        if (this.choiceType == MULTIPLE) {
            return this.selected != null && this.selected[elementNum];
        }
        return elementNum == this.selectedIndex;
    }

    public void setSelectedIndex(int elementNum, boolean selected) {
        if (elementNum < 0 || elementNum >= this.choices.size()) {
            return;
        }
        if (this.choiceType == MULTIPLE) {
            if (this.selected == null) {
                this.selected = new boolean[this.choices.size()];
            }
            this.selected[elementNum] = selected;
            return;
        }
        if (selected) {
            this.selectedIndex = elementNum;
        } else if (this.selectedIndex == elementNum) {
            this.selectedIndex = -1;
        }
    }

    public int getSelectedIndex() {
        if (this.choiceType == MULTIPLE) {
            if (this.selected == null) {
                return -1;
            }
            for (int i = 0; i < this.selected.length; ++i) {
                if (this.selected[i]) {
                    return i;
                }
            }
            return -1;
        }
        return this.selectedIndex;
    }
}

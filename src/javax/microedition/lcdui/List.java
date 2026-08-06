package javax.microedition.lcdui;

public class List extends Screen implements Choice {
    public static final Command SELECT_COMMAND = new Command("Select", Command.ITEM, 1);

    public List(String title, int listType) {
        setTitle(title);
    }

    public List(String title, int listType, String[] stringElements, Image[] imageElements) {
        setTitle(title);
    }

    public int append(String stringElement, Image imageElement) { return 0; }
    public void delete(int elementNum) {}
    public void deleteAll() {}
    public String getString(int elementNum) { return ""; }
    public Image getImage(int elementNum) { return null; }
    public int getSelectedIndex() { return 0; }
    public void setSelectedIndex(int elementNum, boolean selected) {}
    public boolean isSelected(int elementNum) { return false; }
    public void setSelectCommand(Command command) {}
    public int size() { return 0; }
}



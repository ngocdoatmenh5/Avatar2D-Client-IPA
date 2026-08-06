package javax.microedition.lcdui;

public class ChoiceGroup extends Item implements Choice {
    public ChoiceGroup(String label, int choiceType) {
        setLabel(label);
    }
    public ChoiceGroup(String label, int choiceType, String[] stringElements, Image[] imageElements) {
        setLabel(label);
    }
    public int append(String stringElement, Image imageElement) { return 0; }
    public void delete(int elementNum) {}
    public void deleteAll() {}
    public String getString(int elementNum) { return ""; }
    public Image getImage(int elementNum) { return null; }
    public int getSelectedIndex() { return 0; }
    public void setSelectedIndex(int elementNum, boolean selected) {}
    public boolean isSelected(int elementNum) { return false; }
    public int size() { return 0; }
}


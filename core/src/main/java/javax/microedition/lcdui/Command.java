package javax.microedition.lcdui;

public class Command {
    public static final int OK = 1;
    public static final int BACK = 2;
    public static final int SCREEN = 1;
    public static final int ITEM = 2;

    public final String label;
    public final int commandType;
    public final int priority;

    public Command(String label, int commandType, int priority) {
        this.label = label;
        this.commandType = commandType;
        this.priority = priority;
    }
}

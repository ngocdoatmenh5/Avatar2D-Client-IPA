package javax.microedition.lcdui;

import java.util.Vector;

public abstract class Displayable {
    private final Vector commands = new Vector();
    private CommandListener listener;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addCommand(Command cmd) {
        if (cmd != null) {
            this.commands.addElement(cmd);
        }
    }

    public void setCommandListener(CommandListener listener) {
        this.listener = listener;
    }

    public CommandListener getCommandListener() {
        return this.listener;
    }

    public int getCommandCount() {
        return this.commands.size();
    }

    public Command getCommand(int index) {
        return (Command) this.commands.elementAt(index);
    }
}

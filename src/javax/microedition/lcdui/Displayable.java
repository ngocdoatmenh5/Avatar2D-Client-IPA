package javax.microedition.lcdui;

public abstract class Displayable {
    private String title;
    private CommandListener commandListener;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addCommand(Command cmd) {
    }

    public void removeCommand(Command cmd) {
    }

    public void setCommandListener(CommandListener l) {
        this.commandListener = l;
    }

    public CommandListener getCommandListener() {
        return commandListener;
    }

    public boolean isShown() {
        return true;
    }

    public int getWidth() {
        return 320;
    }

    public int getHeight() {
        return 240;
    }

    protected void sizeChanged(int w, int h) {
    }
}

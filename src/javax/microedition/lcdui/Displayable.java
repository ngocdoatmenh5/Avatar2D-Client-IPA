package javax.microedition.lcdui;

public abstract class Displayable {
    private String title;
    private CommandListener commandListener;
    private static int screenWidth = 320;
    private static int screenHeight = 480;

    public static void setScreenSize(int w, int h) {
        screenWidth = w;
        screenHeight = h;
    }

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
        return screenWidth;
    }

    public int getHeight() {
        return screenHeight;
    }

    protected void sizeChanged(int w, int h) {
    }
}

package main;

import javax.microedition.lcdui.Displayable;
import main.lib.Graphics;
import main.screen.Main;

/**
 * LibGDX replacement for javax.microedition.lcdui.Canvas.
 */
public abstract class AvCanvasBase extends Displayable {
    public int getWidth() {
        return Main.getWidth();
    }

    public int getHeight() {
        return Main.getHeight();
    }

    public final void paint(Graphics g) {
        paintGame(g);
    }

    public abstract void paintGame(Graphics g);

    public void pointerPressed(int x, int y) {
    }

    public void pointerReleased(int x, int y) {
    }

    public void pointerDragged(int x, int y) {
    }

    public void keyPressed(int keyCode) {
    }

    public void keyReleased(int keyCode) {
    }

    public void setFullScreenMode(boolean mode) {
    }

    /** J2ME {@code GAME_UP} */
    public static final int GAME_UP = 1;
    /** J2ME {@code GAME_DOWN} */
    public static final int GAME_DOWN = 6;
    /** J2ME {@code GAME_LEFT} */
    public static final int GAME_LEFT = 2;
    /** J2ME {@code GAME_RIGHT} */
    public static final int GAME_RIGHT = 5;
    /** J2ME {@code GAME_FIRE} */
    public static final int GAME_FIRE = 8;

    public boolean hasPointerEvents() {
        return true;
    }

    public int getGameAction(int keyCode) {
        switch (keyCode) {
            case -1:
                return GAME_UP;
            case -2:
                return GAME_DOWN;
            case -3:
                return GAME_LEFT;
            case -4:
                return GAME_RIGHT;
            case -5:
                return GAME_FIRE;
            default:
                return 0;
        }
    }

    public int getKeyCode(int gameAction) {
        switch (gameAction) {
            case GAME_UP:
                return -1;
            case GAME_DOWN:
                return -2;
            case GAME_LEFT:
                return -3;
            case GAME_RIGHT:
                return -4;
            case GAME_FIRE:
                return -5;
            default:
                return gameAction;
        }
    }

    public void repaint() {
    }

    public void serviceRepaints() {
    }
}

package main.screen;

import avt.Avatar;
import avt.ChatTextField;
import avt.Face;
import avt.MenuMain;
import avt.MyScreen;
import main.Canvas;
import main.GameMidlet;
import main.lib.Graphics;
import avt.Dialog;

/**
 * Per-tab snapshot of shared static game state (Canvas / GameMidlet).
 */
public final class TabSnapshot {
    public MyScreen currentMyScreen;
    public Dialog currentDialog;
    public MenuMain menuMain;
    public Face currentFace;
    public int gameTick;
    public int load;
    public boolean chatShow;
    public Avatar avatar;

    public static TabSnapshot capture() {
        TabSnapshot s = new TabSnapshot();
        s.currentMyScreen = Canvas.currentMyScreen;
        s.currentDialog = Canvas.currentDialog;
        s.menuMain = Canvas.menuMain;
        s.currentFace = Canvas.currentFace;
        s.gameTick = Canvas.gameTick;
        s.load = Canvas.load;
        s.chatShow = ChatTextField.isShow;
        s.avatar = GameMidlet.avatar;
        return s;
    }

    public void apply() {
        Canvas.currentMyScreen = currentMyScreen;
        Canvas.currentDialog = currentDialog;
        Canvas.menuMain = menuMain;
        Canvas.currentFace = currentFace;
        Canvas.gameTick = gameTick;
        Canvas.load = load;
        ChatTextField.isShow = chatShow;
        if (avatar != null && avatar.IDDB != 0) {
            GameMidlet.avatar = avatar;
        } else if (GameMidlet.avatar != null && GameMidlet.avatar.IDDB != 0) {
            avatar = GameMidlet.avatar;
        }
        GameMidlet.canvas = Canvas.instance;
    }
}

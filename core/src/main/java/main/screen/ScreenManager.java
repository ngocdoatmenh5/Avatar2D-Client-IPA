package main.screen;

import main.screen.tab258.MainTab258;

/**
 * LibGDX {@link com.badlogic.gdx.Game} host; đổi tab ủy quyền cho {@link TabMidletManager} (kiểu ios_new).
 */
public final class ScreenManager {
    public static ScreenManager instance = new ScreenManager();

    public Main gameScreen = new Main();

    public void switchToTab(int tab) {
        TabMidletManager.instance.switchMidlet(tab);
    }

    void showTab(MainTab258 tab) {
        gameScreen.screen = tab;
        gameScreen.setScreen(tab);
        if (Main.instance != null) {
            Main.instance.screen = tab;
            Main.instance.initaliseInputProcessors();
        }
    }

    public int getCurrentTab() {
        return TabMidletManager.instance.getCurrentTab();
    }

    public MainTab258 getActiveTab() {
        return TabMidletManager.instance.getActiveTab();
    }

    public MainTab258 getTab(int index) {
        return TabMidletManager.instance.getTab(index);
    }
}

package main.screen;

import com.badlogic.gdx.Gdx;
import main.screen.tab258.MainTab258;

/**
 * Giống {@code MidletManager} bên ios_new: giữ nhiều tab, đổi tab chỉ đổi instance hiển thị.
 */
public final class TabMidletManager {
    public static final TabMidletManager instance = new TabMidletManager();

    private final MainTab258[] tabs = new MainTab258[TabContext.TAB_COUNT];
    private int currentTab;

    private TabMidletManager() {
    }

    public void switchMidlet(int tab) {
        if (tab < 0 || tab >= TabContext.TAB_COUNT) {
            return;
        }
        if (Thread.currentThread().getName().equals("Main")) {
            applySwitch(tab);
        } else {
            Gdx.app.postRunnable(() -> applySwitch(tab));
        }
    }

    private void applySwitch(int tab) {
        MainTab258 next = tabAt(tab);
        if (tab == currentTab && next.isCreated
                && ScreenManager.instance.gameScreen.getScreen() == next) {
            return;
        }
        MainTab258 previous = tabAt(currentTab);
        if (previous.isCreated && previous != next) {
            previous.captureGlobals();
        }
        if (!next.isCreated) {
            main.GameMidlet.initGlobal();
            next.ensureStarted();
        }
        currentTab = tab;
        TabContext.setActiveTab(tab);
        next.bindGlobals();
        ScreenManager.instance.showTab(next);
    }

    private MainTab258 tabAt(int index) {
        if (tabs[index] == null) {
            tabs[index] = new MainTab258(index);
        }
        return tabs[index];
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public MainTab258 getActiveTab() {
        return tabAt(currentTab);
    }

    public MainTab258 getTab(int index) {
        if (index < 0 || index >= TabContext.TAB_COUNT) {
            return null;
        }
        return tabs[index];
    }
}

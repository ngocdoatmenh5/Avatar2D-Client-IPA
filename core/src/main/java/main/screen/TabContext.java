package main.screen;

import avt.GlobalMessageHandler;
import avt.Session_ME;
import main.Canvas;
import main.GameMidlet;

/**
 * Tab đang active: canvas, RMS prefix, socket, message handler.
 */
public final class TabContext {
    public static final int TAB_COUNT = 6;

    private static int activeTab;
    private static Session_ME activeSession;
    private static GlobalMessageHandler activeMessageHandler;

    private TabContext() {
    }

    public static int getActiveTab() {
        return activeTab;
    }

    public static void setActiveTab(int tab) {
        if (tab < 0) {
            tab = 0;
        }
        if (tab >= TAB_COUNT) {
            tab = TAB_COUNT - 1;
        }
        activeTab = tab;
    }

    public static String rmsKey(String baseName) {
        return GameMidlet.APP_VERSION + "t" + activeTab + baseName;
    }

    public static void bindCanvas(Canvas canvas) {
        Canvas.instance = canvas;
        GameMidlet.canvas = canvas;
    }

    public static void bindNetwork(Session_ME session, GlobalMessageHandler handler) {
        activeSession = session;
        activeMessageHandler = handler;
    }

    public static Session_ME getActiveSession() {
        return activeSession;
    }

    public static GlobalMessageHandler getActiveMessageHandler() {
        return activeMessageHandler;
    }
}

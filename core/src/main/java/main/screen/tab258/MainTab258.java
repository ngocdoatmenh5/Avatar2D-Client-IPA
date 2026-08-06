package main.screen.tab258;

import avt.Avatar;
import avt.CRes;
import avt.GlobalMessageHandler;
import avt.IndexPlayer;
import avt.Session_ME;
import avt.SplashScr;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import main.Canvas;
import main.GameMidlet;
import main.lib.Graphics;
import main.lib.NativeHttpClient;
import main.screen.IMainTab;
import main.screen.Main;
import main.screen.ScreenChild;
import main.screen.ScreenManager;
import main.screen.TabContext;
import main.screen.TabSnapshot;

/**
 * Một slot tab (0..5), kiểu ios_new: canvas + avatar riêng, thread game riêng, đổi tab chỉ bind globals.
 */
public final class MainTab258 implements Screen, IMainTab {
    private static boolean serverListLoaderStarted;

    public static MainTab258 instance;

    public final int tabIndex;
    public final Session_ME session = new Session_ME();
    public final GlobalMessageHandler messageHandler;
    public Canvas gameCanvas;
    public Avatar avatar;
    public IndexPlayer myIndexP;
    public ScreenChild screenChild;
    private Graphics graphics;
    public boolean isCreated;
    private TabSnapshot savedState;

    public MainTab258(int tabIndex) {
        this.tabIndex = tabIndex;
        this.messageHandler = new GlobalMessageHandler(this);
    }

   
    public void ensureStarted() {
        if (isCreated) {
            return;
        }
        GameMidlet.initGlobal();
        TabContext.setActiveTab(tabIndex);
        gameCanvas = new Canvas();
        graphics = new Graphics(new SpriteBatch());
        GameMidlet.bootstrapTab(gameCanvas, this);
        gameCanvas.sizeChanged(0, 0);
        gameCanvas.setSize();
        session.setHandler(messageHandler);
        if (tabIndex == 0) {
            String ver = CRes.b("avatar");
            if (ver == null || !ver.equals(GameMidlet.APP_VERSION)) {
                CRes.a("avatar", GameMidlet.APP_VERSION);
            }
            startServerListLoaderOnce();
        }
        gameCanvas.d();
        isCreated = true;
    }

    /** Đồng bộ avatar/index từ globals sau đăng nhập (cmd -4). */
    public void syncFromGame() {
        if (GameMidlet.avatar != null) {
            avatar = GameMidlet.avatar;
        }
        if (GameMidlet.myIndexP != null) {
            myIndexP = GameMidlet.myIndexP;
        }
    }

    public void captureGlobals() {
        if (isCreated) {
            syncFromGame();
            savedState = TabSnapshot.capture();
        }
    }

    public void bindGlobals() {
        TabContext.setActiveTab(tabIndex);
        TabContext.bindCanvas(gameCanvas);
        TabContext.bindNetwork(session, messageHandler);
        applyTabAvatarToGame();
        if (savedState != null) {
            savedState.apply();
            applyTabAvatarToGame();
        }
        instance = this;
        if (Main.instance != null) {
            Main.instance.screen = this;
        }
    }

    private void applyTabAvatarToGame() {
        if (avatar != null && avatar.IDDB != 0) {
            GameMidlet.avatar = avatar;
            if (myIndexP != null) {
                GameMidlet.myIndexP = myIndexP;
            }
        } else if (GameMidlet.avatar != null && GameMidlet.avatar.IDDB != 0) {
            avatar = GameMidlet.avatar;
            if (GameMidlet.myIndexP != null) {
                myIndexP = GameMidlet.myIndexP;
            }
        } else if (avatar != null) {
            GameMidlet.avatar = avatar;
            if (myIndexP != null) {
                GameMidlet.myIndexP = myIndexP;
            }
        }
    }

    private static void startServerListLoaderOnce() {
        if (serverListLoaderStarted) {
            return;
        }
        serverListLoaderStarted = true;
        new Thread(() -> {
            try {
                String serverData = NativeHttpClient.getResponseSync(GameMidlet.linkGetHost[0][0]);
                if (serverData != null) {
                    GameMidlet.parseServerList(serverData);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ServerListLoader").start();
    }

    @Override
    public void show() {
        bindGlobals();
    }

    @Override
    public void render(float delta) {
        if (ScreenManager.instance.getCurrentTab() != tabIndex) {
            return;
        }
        if (screenChild != null && screenChild.isVisible()) {
            screenChild.render();
            return;
        }
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(16384);
        Main.instance.camera.position.set(Main.getWidth() / 2f, Main.getHeight() / 2f, 0);
        Main.instance.camera.update();
        if (graphics == null || gameCanvas == null) {
            return;
        }
        graphics.graphics.setProjectionMatrix(Main.instance.camera.combined);
        graphics.begin();
        gameCanvas.paint(graphics);
        graphics.end();
    }

    @Override
    public void resize(int width, int height) {
        if (ScreenManager.instance.getCurrentTab() != tabIndex) {
            return;
        }
        Main.instance.viewport.update(width, height);
        if (screenChild != null && screenChild.isVisible()) {
            screenChild.resize(width, height);
        }
        if (gameCanvas != null) {
            gameCanvas.sizeChanged(width, height);
        }
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        if (graphics != null && graphics.graphics != null) {
            graphics.graphics.dispose();
        }
    }

    @Override
    public void keyPressed(int k) {
        if (gameCanvas != null) {
            gameCanvas.keyPressed(k);
        }
    }

    @Override
    public void keyReleased(int k) {
        if (gameCanvas != null) {
            gameCanvas.keyReleased(k);
        }
    }

    @Override
    public void pointerPressed(int x, int y) {
        if (gameCanvas != null) {
            gameCanvas.pointerPressed(x, y);
        }
    }

    @Override
    public void pointerDragged(int x, int y) {
        if (gameCanvas != null) {
            gameCanvas.pointerDragged(x, y);
        }
    }

    @Override
    public void pointerReleased(int x, int y) {
        if (gameCanvas != null) {
            gameCanvas.pointerReleased(x, y);
        }
    }

    @Override
    public int getWidth() {
        return Main.getWidth();
    }

    @Override
    public int getHeight() {
        return Main.getHeight();
    }
}

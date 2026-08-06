package main.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import main.lib.LibGDXFloatingButton;
import main.lib.MapKey;
import main.lib.NetRequest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends Game {
    public static Main instance;
    public InputMultiplexer inputMultiplexer;
    private MyInputProcessor inputProcessor;
    private MyGestureHandler gestureHandler;
    private static int WIDTH;
    private static int HEIGHT;
    public static NetRequest netRequest;
    public IMainTab screen;

    public OrthographicCamera camera;
    public Viewport viewport;
    public LibGDXFloatingButton floatingButton;

    @Override
    public void create() {
        if (!Objects.equals(Thread.currentThread().getName(), "Main")) {
            Thread.currentThread().setName("Main");
        }
        instance = this;
        netRequest = new NetRequest();
        if (System.getProperty("microedition.platform") == null) {
            System.setProperty("microedition.platform", "LibGDX/Desktop");
        }
        WIDTH = (int) (Gdx.graphics.getWidth() * 0.8);
        HEIGHT = (int) (Gdx.graphics.getHeight() * 0.8);
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true);
        this.viewport = new ExtendViewport(Main.getWidth(), Main.getHeight(), camera);
        this.viewport.apply();
        camera.update();
        this.inputProcessor = new MyInputProcessor();
        MapKey.load();
        if (Gdx.files.internal("menu.png").exists() || Gdx.files.internal("controlTab.png").exists()) {
            floatingButton = new LibGDXFloatingButton();
        }
        inputMultiplexer = new InputMultiplexer();
        if (floatingButton != null) {
            inputMultiplexer.addProcessor(new TabButtonInputProcessor(floatingButton));
        }
        inputMultiplexer.addProcessor(this.inputProcessor);
        Gdx.input.setInputProcessor(inputMultiplexer);

        ScreenManager.instance.switchToTab(0);
    }

    public InputStream getResourceAsStream(String path) {
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        try {
            // Đọc toàn bộ bytes rồi wrap trong ByteArrayInputStream
            // để available() trả đúng kích thước và read() đọc hết dữ liệu.
            // Khi chạy từ JAR, InputStream gốc (ZipInputStream) có available() không chính xác.
            byte[] data = Gdx.files.internal(path).readBytes();
            return new java.io.ByteArrayInputStream(data);
        } catch (Exception ignored) {
        }
        return null;
    }

    public String readResource(String resourcePath) {
        try (InputStream isLoad = Gdx.files.internal(resourcePath).read()) {
            if (isLoad != null) {
                return readStream(isLoad);
            } else {
                return "";
            }
        } catch (IOException e) {
            return "";
        }
    }

    public static String readStream(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            sb.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
        }

        return sb.toString();
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    @Override
    public void render() {
        main.lib.TextureService.instance.processPendingGl();
        getScreen().render(0);
        if (floatingButton != null) {
            floatingButton.render();
        }
    }

    public void initaliseInputProcessors() {
        this.inputMultiplexer = new InputMultiplexer();
        if (floatingButton != null) {
            this.inputMultiplexer.addProcessor(new TabButtonInputProcessor(floatingButton));
        }
        if (this.inputProcessor == null) {
            this.inputProcessor = new MyInputProcessor();
        }
        if (this.gestureHandler == null) {
            this.gestureHandler = new MyGestureHandler();
        }
        this.inputMultiplexer.addProcessor(new GestureDetector(this.gestureHandler));
        this.inputMultiplexer.addProcessor(this.inputProcessor);
        Gdx.input.setInputProcessor(this.inputMultiplexer);
    }

    @Override
    public void dispose() {

        getScreen().dispose();
    }

    @Override
    public void resize(int width, int height) {
        getScreen().resize(width, height);
        if (floatingButton != null) {
            floatingButton.resize(width, height);
        }
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    public class MyInputProcessor implements InputProcessor {
        MyInputProcessor() {
        }

        @Override
        public boolean keyDown(int keycode) {
            int k = MapKey.map(keycode);
            if ((Gdx.input.isKeyPressed(59) || Gdx.input.isKeyPressed(60)) && keycode == 9) {
                k = 64;
            }
            screen.keyPressed(k);
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            int k = MapKey.map(keycode);
            screen.keyReleased(k);
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            int rotation = Gdx.input.getRotation();
            if (rotation == 90) {
                screenX = screenY;
                screenY = screen.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = screen.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2) {
                screen.pointerPressed(screenX + delX, screenY + delY);
            }
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            int rotation = Gdx.input.getRotation();
            if (rotation == 90) {
                screenX = screenY;
                screenY = screen.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = screen.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2) {
                screen.pointerReleased(screenX + delX, screenY + delY);
            }
            return false;
        }

        @Override
        public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            int rotation = Gdx.input.getRotation();
            if (rotation == 90) {
                screenX = screenY;
                screenY = screen.getHeight() - screenX;
            } else if (rotation == 270) {
                screenY = screenX;
                screenX = screen.getWidth() - screenY;
            }
            Vector3 touch = new Vector3(screenX, screenY, 0.0f);
            camera.unproject(touch);
            int delX = ((int) touch.x) - screenX;
            int delY = ((int) touch.y) - screenY;
            if (pointer < 2) {
                screen.pointerDragged(screenX + delX, screenY + delY);
            }
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
            return false;
        }

        @Override
        public boolean scrolled(float amountX, float amountY) {
            return false;
        }
    }

    public static class MyGestureHandler implements GestureDetector.GestureListener {
        public float initialScale = 1.0f;

        MyGestureHandler() {
        }

        @Override
        public boolean touchDown(float x, float y, int pointer, int button) {
            return false;
        }

        @Override
        public boolean zoom(float initialDistance, float distance) {
            float f = initialDistance / distance;
            return true;
        }

        @Override
        public void pinchStop() {
        }

        @Override
        public boolean tap(float x, float y, int count, int button) {
            return false;
        }

        @Override
        public boolean longPress(float x, float y) {
            return false;
        }

        @Override
        public boolean fling(float velocityX, float velocityY, int button) {
            return false;
        }

        @Override
        public boolean pan(float x, float y, float deltaX, float deltaY) {
            return false;
        }

        @Override
        public boolean panStop(float x, float y, int pointer, int button) {
            return false;
        }

        @Override
        public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
            return false;
        }
    }
}

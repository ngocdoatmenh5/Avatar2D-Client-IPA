package main.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;


public class LibGDXFloatingButton {
    private static final int NUM_TABS = 6;
    private static final float MAIN_W = 50f;
    private static final float MAIN_H = 50f;
    private static final float SUB_SIZE = MAIN_W - 10f;

    private float mainX;
    private float mainY;
    private boolean menuOpen;
    private boolean draggingMain;
    private boolean armedTap;

    private final Array<Rectangle> subBounds = new Array<>();
    private Texture menuButton;
    private final Texture[] tabIcons = new Texture[NUM_TABS];

    private final SpriteBatch batch;
    private final OrthographicCamera screenCamera;

    public LibGDXFloatingButton() {
        batch = new SpriteBatch();
        screenCamera = new OrthographicCamera();
        screenCamera.setToOrtho(false);
        reposition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        loadResources();
    }

    private void loadResources() {
        menuButton = loadTextureFirst("menu.png", "controlTab.png");
        for (int i = 0; i < NUM_TABS; i++) {
            tabIcons[i] = loadTexture("pb" + (i + 1) + ".png");
            if (tabIcons[i] == null) {
                tabIcons[i] = loadTexture("res/pb" + (i + 1) + ".png");
            }
        }
    }

    private static Texture loadTexture(String path) {
        FileHandle file = Gdx.files.internal(path);
        if (!file.exists()) {
            return null;
        }
        return new Texture(file);
    }

    private static Texture loadTextureFirst(String... paths) {
        for (String path : paths) {
            Texture tex = loadTexture(path);
            if (tex != null) {
                return tex;
            }
        }
        return null;
    }

    private void layoutSubButtons(int screenWidth, int screenHeight) {
        subBounds.clear();
        float totalW = SUB_SIZE * NUM_TABS;
        float startX = (screenWidth - totalW) / 2f;
        float subY = mainY - SUB_SIZE;
        for (int i = 0; i < NUM_TABS; i++) {
            float itemX = SUB_SIZE * i + startX;
            subBounds.add(new Rectangle(itemX, subY, SUB_SIZE, SUB_SIZE));
        }
    }

    private void reposition(int width, int height) {
        mainX = width - MAIN_W;
        mainY = height - MAIN_H;
        layoutSubButtons(width, height);
    }

    public void render() {
        
    }

    public boolean isTouched(float x, float y) {
       
        return false;
    }

    public void startDrag() {
        draggingMain = true;
    }

    public void stopDrag() {
        draggingMain = false;
    }

    public boolean isDragging() {
        return draggingMain;
    }

    public void drag(float x, float y) {
        if (!menuOpen && draggingMain) {
            mainX = x - MAIN_W / 2f;
            mainY = y - MAIN_H / 2f;
            clampMainPosition();
            layoutSubButtons(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
    }

    public boolean touchDown(float x, float y) {
        // 隐藏后禁用交互：不让它进入拖拽/菜单开启逻辑。
        armedTap = false;
        draggingMain = false;
        return false;
    }

  /** ios_new ButtonGroup.touchUp — dùng tọa độ thả tay; nếu lệch nhẹ vẫn nhận nhờ {@code armedTap}. */
    public void touchUp(float x, float y) {
        if (!armedTap) {
            return;
        }
        armedTap = false;
        draggingMain = false;

        // 隐藏后不再执行任何菜单逻辑。
    }

    private boolean hitMain(float x, float y) {
        return x >= mainX && x <= mainX + MAIN_W && y >= mainY && y <= mainY + MAIN_H;
    }

    private void clampMainPosition() {
        float maxX = Gdx.graphics.getWidth() - MAIN_W;
        float maxY = Gdx.graphics.getHeight() - MAIN_H;
        if (mainX < 0f) {
            mainX = 0f;
        }
        if (mainY < 0f) {
            mainY = 0f;
        }
        if (mainX > maxX) {
            mainX = maxX;
        }
        if (mainY > maxY) {
            mainY = maxY;
        }
    }

    public void resize(int width, int height) {
        screenCamera.setToOrtho(false, width, height);
        screenCamera.update();
        reposition(width, height);
    }

    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }
        if (menuButton != null) {
            menuButton.dispose();
        }
        for (int i = 0; i < NUM_TABS; i++) {
            if (tabIcons[i] != null) {
                tabIcons[i].dispose();
            }
        }
    }
}

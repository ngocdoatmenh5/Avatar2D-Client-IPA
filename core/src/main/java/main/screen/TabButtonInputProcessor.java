package main.screen;

import com.badlogic.gdx.InputProcessor;
import main.lib.LibGDXFloatingButton;

/**
 * Touch nút tab trước game (ios_new MainApp). Dùng {@code screenX/screenY} LibGDX (gốc dưới-trái).
 */
public final class TabButtonInputProcessor implements InputProcessor {
    private final LibGDXFloatingButton tabButton;

    public TabButtonInputProcessor(LibGDXFloatingButton tabButton) {
        this.tabButton = tabButton;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return tabButton.touchDown(screenX, screenY);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        tabButton.stopDrag();
        tabButton.touchUp(screenX, screenY);
        return tabButton.isTouched(screenX, screenY) || tabButton.isDragging();
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int btn) {
        tabButton.stopDrag();
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!tabButton.isDragging()) {
            return false;
        }
        tabButton.drag(screenX, screenY);
        return true;
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

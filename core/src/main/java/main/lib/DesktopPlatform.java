package main.lib;

import com.badlogic.gdx.Gdx;

/** True when running under LibGDX (desktop/Android), not original J2ME device. */
public final class DesktopPlatform {
    private DesktopPlatform() {
    }

    public static boolean isLibGdx() {
        return Gdx.app != null;
    }
}

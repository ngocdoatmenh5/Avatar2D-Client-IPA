package main.screen.lwjgl3;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import main.screen.ScreenManager;

public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        createApplication();
    }

    private static void createApplication() {
        new Lwjgl3Application(ScreenManager.instance.gameScreen, getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("AvatarNVB");
        configuration.setForegroundFPS(45);


        configuration.setWindowedMode(360, 580);
        configuration.setWindowIcon(Files.FileType.Internal,
                "app_icon16.png",
                "app_icon32.png",
                "app_icon64.png",
                "app_icon128.png");
        return configuration;
    }
}

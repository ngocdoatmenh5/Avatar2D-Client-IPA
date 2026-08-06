package ios;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import main.GameMidlet;

public class IOSLauncher extends UIApplicationDelegateAdapter {
    private UIWindow window;

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();

        // Boot MIDlet in Java ME compatibility runtime on iOS
        try {
            GameMidlet midlet = new GameMidlet();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}

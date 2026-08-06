package ios;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.rt.annotation.Callback;

import main.GameMidlet;
import java.util.Timer;
import java.util.TimerTask;

public class IOSLauncher extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private IOSViewController viewController;

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        viewController = new IOSViewController();
        
        // CRITICAL FIX FOR IOS / LIVECONTAINER CRASH: Set non-null rootViewController
        window.setRootViewController(viewController);
        window.makeKeyAndVisible();

        // Boot MIDlet in Java ME compatibility runtime on iOS
        try {
            GameMidlet midlet = new GameMidlet();
        } catch (Throwable t) {
            t.printStackTrace();
        }

        // Start 30 FPS display refresh timer for smooth rendering
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                IOSCanvasView.requestRepaint();
            }
        }, 0, 33);

        return true;
    }

    // LiveContainer / LC_LOAD_DYLIB EntryPoint export
    @Callback
    public static int LCEntryPoint(int argc, char** argv) {
        main(new String[0]);
        return 0;
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}

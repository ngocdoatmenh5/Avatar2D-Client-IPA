package ios;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIWindow;
import org.robovm.apple.coregraphics.CGRect;

import javax.microedition.lcdui.Displayable;
import main.GameMidlet;
import java.util.Timer;
import java.util.TimerTask;

public class IOSLauncher extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private IOSViewController viewController;

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        CGRect bounds = UIScreen.getMainScreen().getBounds();
        int screenW = (int) bounds.getWidth();
        int screenH = (int) bounds.getHeight();

        // Set screen dimensions BEFORE creating Canvas
        Displayable.setScreenSize(screenW, screenH);

        // Set J2ME system properties to prevent NullPointerException
        System.setProperty("microedition.platform", "iOS");
        System.setProperty("microedition.encoding", "UTF-8");
        System.setProperty("microedition.locale", "en-US");

        window = new UIWindow(bounds);
        viewController = new IOSViewController();
        window.setRootViewController(viewController);
        window.makeKeyAndVisible();

        // Set repaint callback so game loop's repaint() triggers iOS rendering
        javax.microedition.lcdui.Canvas.setRepaintCallback(new Runnable() {
            @Override
            public void run() {
                IOSCanvasView.requestRepaint();
            }
        });

        // Boot MIDlet on background thread to avoid blocking UI
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    GameMidlet midlet = new GameMidlet();
                    // Mark game as ready for rendering and touch input
                    IOSCanvasView view = IOSCanvasView.getInstance();
                    if (view != null) {
                        view.setGameReady(true);
                    }
                    // Trigger first repaint
                    IOSCanvasView.requestRepaint();
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        }).start();

        // Start 30 FPS display refresh timer (backup for game loop)
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                IOSCanvasView.requestRepaint();
            }
        }, 500, 33);

        return true;
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}

package ios;

import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIInterfaceOrientationMask;

public class IOSViewController extends UIViewController {
    private IOSCanvasView canvasView;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        canvasView = new IOSCanvasView(UIScreen.getMainScreen().getBounds());
        setView(canvasView);
    }

    @Override
    public boolean prefersStatusBarHidden() {
        return true;
    }

    @Override
    public boolean shouldAutorotate() {
        return true;
    }

    @Override
    public UIInterfaceOrientationMask getSupportedInterfaceOrientations() {
        return UIInterfaceOrientationMask.All;
    }

    public IOSCanvasView getCanvasView() {
        return canvasView;
    }
}

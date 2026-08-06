package ios;

import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UITouch;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.foundation.NSSet;

import javax.microedition.lcdui.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class IOSCanvasView extends UIView {
    private static IOSCanvasView instance;
    private BufferedImage buffer;
    private Graphics graphics;

    public IOSCanvasView(CGRect frame) {
        super(frame);
        instance = this;
        setMultipleTouchEnabled(false);
        setUserInteractionEnabled(true);
    }

    public static IOSCanvasView getInstance() {
        return instance;
    }

    public static void requestRepaint() {
        if (instance != null) {
            instance.setNeedsDisplay();
        }
    }

    @Override
    public void draw(CGRect rect) {
        CGContext context = UIGraphics.getCurrentContext();
        if (context == null) return;

        int width = (int) rect.getWidth();
        int height = (int) rect.getHeight();
        if (width <= 0 || height <= 0) return;

        if (buffer == null || buffer.getWidth() != width || buffer.getHeight() != height) {
            buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            graphics = new Graphics(buffer.createGraphics());
        }

        main.Canvas canvas = main.Canvas.instance;
        if (canvas != null) {
            try {
                canvas.paintGame(graphics);
            } catch (Throwable t) {
                // Ignore transient paint errors during initialization
            }
        }

        // Draw buffer to iOS view
        context.saveGState();
        context.setBlendMode(org.robovm.apple.coregraphics.CGBlendMode.Copy);
        context.restoreGState();
    }

    @Override
    public void touchesBegan(NSSet<UITouch> touches, UIEvent event) {
        UITouch touch = touches.any();
        if (touch != null) {
            org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
            int x = (int) pt.getX();
            int y = (int) pt.getY();
            main.Canvas canvas = main.Canvas.instance;
            if (canvas != null) {
                canvas.doPointerPressed(x, y);
            }
        }
    }

    @Override
    public void touchesMoved(NSSet<UITouch> touches, UIEvent event) {
        UITouch touch = touches.any();
        if (touch != null) {
            org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
            int x = (int) pt.getX();
            int y = (int) pt.getY();
            main.Canvas canvas = main.Canvas.instance;
            if (canvas != null) {
                canvas.doPointerDragged(x, y);
            }
        }
    }

    @Override
    public void touchesEnded(NSSet<UITouch> touches, UIEvent event) {
        UITouch touch = touches.any();
        if (touch != null) {
            org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
            int x = (int) pt.getX();
            int y = (int) pt.getY();
            main.Canvas canvas = main.Canvas.instance;
            if (canvas != null) {
                canvas.doPointerReleased(x, y);
            }
        }
    }



    @Override
    public void touchesCancelled(NSSet<UITouch> touches, UIEvent event) {
        touchesEnded(touches, event);
    }
}

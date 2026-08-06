package ios;

import org.robovm.apple.coregraphics.CGBitmapInfo;
import org.robovm.apple.coregraphics.CGColorRenderingIntent;
import org.robovm.apple.coregraphics.CGColorSpace;
import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGDataProvider;
import org.robovm.apple.coregraphics.CGImage;
import org.robovm.apple.coregraphics.CGImageAlphaInfo;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIImage;
import org.robovm.apple.uikit.UITouch;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.foundation.NSSet;

import javax.microedition.lcdui.Graphics;

public class IOSCanvasView extends UIView {
    private static IOSCanvasView instance;
    private int viewWidth;
    private int viewHeight;
    private volatile boolean gameReady = false;

    // Shared pixel buffer and graphics
    private int[] pixelBuffer;
    private Graphics graphics;

    public IOSCanvasView(CGRect frame) {
        super(frame);
        instance = this;
        setMultipleTouchEnabled(false);
        setUserInteractionEnabled(true);
        setOpaque(true);

        viewWidth = (int) frame.getWidth();
        viewHeight = (int) frame.getHeight();
        if (viewWidth <= 0) viewWidth = 320;
        if (viewHeight <= 0) viewHeight = 480;

        // Set screen dimensions for J2ME shim layer
        javax.microedition.lcdui.Displayable.setScreenSize(viewWidth, viewHeight);

        // Create shared pixel buffer
        pixelBuffer = new int[viewWidth * viewHeight];
        graphics = new Graphics(pixelBuffer, viewWidth, viewHeight);
    }

    public static IOSCanvasView getInstance() {
        return instance;
    }

    public void setGameReady(boolean ready) {
        this.gameReady = ready;
    }

    public static void requestRepaint() {
        final IOSCanvasView view = instance;
        if (view != null) {
            try {
                view.performSelectorOnMainThread(
                    org.robovm.objc.Selector.register("setNeedsDisplay"),
                    null, false);
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    @Override
    public void draw(CGRect rect) {
        CGContext context = UIGraphics.getCurrentContext();
        if (context == null) return;

        int w = viewWidth;
        int h = viewHeight;

        // Paint game content into pixel buffer
        main.Canvas canvas = main.Canvas.instance;
        if (canvas != null && gameReady) {
            try {
                // Reset graphics translate for each frame
                int tx = graphics.getTranslateX();
                int ty = graphics.getTranslateY();
                if (tx != 0 || ty != 0) {
                    graphics.translate(-tx, -ty);
                }
                graphics.setClip(0, 0, w, h);
                canvas.paintGame(graphics);
            } catch (Throwable t) {
                // Silently ignore paint errors
            }
        }

        // Convert ARGB int[] → RGBA byte[] for CoreGraphics
        byte[] rgba = new byte[w * h * 4];
        for (int i = 0; i < pixelBuffer.length; i++) {
            int argb = pixelBuffer[i];
            int idx = i << 2;
            rgba[idx]     = (byte) ((argb >> 16) & 0xFF); // R
            rgba[idx + 1] = (byte) ((argb >> 8) & 0xFF);  // G
            rgba[idx + 2] = (byte) (argb & 0xFF);          // B
            rgba[idx + 3] = (byte) ((argb >>> 24) & 0xFF); // A
        }

        // Render via UIImage (most reliable path in RoboVM)
        try {
            NSData nsData = new NSData(rgba);
            CGColorSpace colorSpace = CGColorSpace.createDeviceRGB();
            CGDataProvider provider = CGDataProvider.create(nsData);

            CGImage cgImage = CGImage.create(
                w, h, 8, 32, w * 4, colorSpace,
                new CGBitmapInfo(CGImageAlphaInfo.Last.value()),
                provider, null, false,
                CGColorRenderingIntent.Default);

            if (cgImage != null) {
                // Flip Y axis (CG origin is bottom-left)
                context.saveGState();
                context.translateCTM(0, h);
                context.scaleCTM(1, -1);
                context.drawImage(new CGRect(0, 0, w, h), cgImage);
                context.restoreGState();
                cgImage.dispose();
            }

            provider.dispose();
            colorSpace.dispose();
        } catch (Throwable t) {
            // Fallback: fill screen with dark blue to show draw() is called
            context.setRGBFillColor(0.05, 0.05, 0.2, 1);
            context.fillRect(new CGRect(0, 0, w, h));
        }
    }

    @Override
    public void touchesBegan(NSSet<UITouch> touches, UIEvent event) {
        if (!gameReady) return;
        try {
            UITouch touch = touches.any();
            if (touch != null) {
                org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
                main.Canvas canvas = main.Canvas.instance;
                if (canvas != null) {
                    canvas.doPointerPressed((int) pt.getX(), (int) pt.getY());
                }
            }
        } catch (Throwable t) { }
    }

    @Override
    public void touchesMoved(NSSet<UITouch> touches, UIEvent event) {
        if (!gameReady) return;
        try {
            UITouch touch = touches.any();
            if (touch != null) {
                org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
                main.Canvas canvas = main.Canvas.instance;
                if (canvas != null) {
                    canvas.doPointerDragged((int) pt.getX(), (int) pt.getY());
                }
            }
        } catch (Throwable t) { }
    }

    @Override
    public void touchesEnded(NSSet<UITouch> touches, UIEvent event) {
        if (!gameReady) return;
        try {
            UITouch touch = touches.any();
            if (touch != null) {
                org.robovm.apple.coregraphics.CGPoint pt = touch.getLocationInView(this);
                main.Canvas canvas = main.Canvas.instance;
                if (canvas != null) {
                    canvas.doPointerReleased((int) pt.getX(), (int) pt.getY());
                }
            }
        } catch (Throwable t) { }
    }

    @Override
    public void touchesCancelled(NSSet<UITouch> touches, UIEvent event) {
        touchesEnded(touches, event);
    }
}

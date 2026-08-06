package ios;

import org.robovm.apple.coregraphics.CGBitmapContext;
import org.robovm.apple.coregraphics.CGBitmapInfo;
import org.robovm.apple.coregraphics.CGColorSpace;
import org.robovm.apple.coregraphics.CGContext;
import org.robovm.apple.coregraphics.CGImage;
import org.robovm.apple.coregraphics.CGImageAlphaInfo;
import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UITouch;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIGraphics;
import org.robovm.apple.foundation.NSSet;
import org.robovm.rt.bro.ptr.IntPtr;

import javax.microedition.lcdui.Graphics;

public class IOSCanvasView extends UIView {
    private static IOSCanvasView instance;
    private Graphics graphics;
    private int viewWidth;
    private int viewHeight;

    public IOSCanvasView(CGRect frame) {
        super(frame);
        instance = this;
        setMultipleTouchEnabled(false);
        setUserInteractionEnabled(true);
        setOpaque(true);

        viewWidth = (int) frame.getWidth();
        viewHeight = (int) frame.getHeight();

        // Set screen dimensions for J2ME shim layer
        javax.microedition.lcdui.Displayable.setScreenSize(viewWidth, viewHeight);

        // Create the shared graphics buffer
        int[] pixels = new int[viewWidth * viewHeight];
        graphics = new Graphics(pixels, viewWidth, viewHeight);
    }

    public static IOSCanvasView getInstance() {
        return instance;
    }

    public static void requestRepaint() {
        if (instance != null) {
            instance.performSelectorOnMainThread(
                org.robovm.objc.Selector.register("setNeedsDisplay"),
                null, false);
        }
    }

    @Override
    public void draw(CGRect rect) {
        CGContext context = UIGraphics.getCurrentContext();
        if (context == null || graphics == null) return;

        int w = viewWidth;
        int h = viewHeight;
        if (w <= 0 || h <= 0) return;

        int[] pixels = graphics.getPixels();
        if (pixels == null) return;

        // Call the J2ME Canvas paint method
        main.Canvas canvas = main.Canvas.instance;
        if (canvas != null) {
            try {
                // Reset graphics state for each frame
                graphics.translate(-graphics.getTranslateX(), -graphics.getTranslateY());
                graphics.setClip(0, 0, w, h);
                canvas.paintGame(graphics);
            } catch (Throwable t) {
                // Ignore transient paint errors during initialization
            }
        }

        // Convert ARGB int[] to a CGImage and draw it to screen
        try {
            // Allocate native memory for pixel data (BGRA format for CoreGraphics)
            byte[] bgraData = new byte[w * h * 4];
            for (int i = 0; i < pixels.length; i++) {
                int argb = pixels[i];
                int idx = i * 4;
                bgraData[idx]     = (byte) ((argb >> 16) & 0xFF); // R
                bgraData[idx + 1] = (byte) ((argb >> 8) & 0xFF);  // G
                bgraData[idx + 2] = (byte) (argb & 0xFF);         // B
                bgraData[idx + 3] = (byte) ((argb >> 24) & 0xFF); // A
            }

            CGColorSpace colorSpace = CGColorSpace.createDeviceRGB();
            CGBitmapContext bitmapCtx = CGBitmapContext.create(
                bgraData, w, h, 8, w * 4, colorSpace,
                new CGBitmapInfo(CGImageAlphaInfo.PremultipliedLast.value()));

            if (bitmapCtx != null) {
                CGImage cgImage = bitmapCtx.toImage();
                if (cgImage != null) {
                    // CoreGraphics has flipped Y axis, so flip it
                    context.saveGState();
                    context.translateCTM(0, h);
                    context.scaleCTM(1, -1);
                    context.drawImage(new CGRect(0, 0, w, h), cgImage);
                    context.restoreGState();
                    cgImage.dispose();
                }
                bitmapCtx.dispose();
            }
            colorSpace.dispose();
        } catch (Throwable t) {
            // Fallback: just fill black
            context.setRGBFillColor(0, 0, 0, 1);
            context.fillRect(new CGRect(0, 0, w, h));
        }
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

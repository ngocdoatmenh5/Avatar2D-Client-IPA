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

import javax.microedition.lcdui.Graphics;

public class IOSCanvasView extends UIView {
    private static IOSCanvasView instance;
    private int viewWidth;
    private int viewHeight;
    private volatile boolean gameReady = false;

    // Shared pixel buffer and graphics
    private int[] pixelBuffer;
    private Graphics graphics;
    // Reusable byte buffer for CG rendering
    private byte[] rgbaBuffer;

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

        // Create shared pixel buffer & reusable RGBA byte buffer
        pixelBuffer = new int[viewWidth * viewHeight];
        graphics = new Graphics(pixelBuffer, viewWidth, viewHeight);
        rgbaBuffer = new byte[viewWidth * viewHeight * 4];
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

        // Convert ARGB int[] to RGBA byte[] for CoreGraphics
        int len = pixelBuffer.length;
        for (int i = 0; i < len; i++) {
            int argb = pixelBuffer[i];
            int idx = i << 2; // i * 4
            rgbaBuffer[idx]     = (byte) ((argb >> 16) & 0xFF); // R
            rgbaBuffer[idx + 1] = (byte) ((argb >> 8) & 0xFF);  // G
            rgbaBuffer[idx + 2] = (byte) (argb & 0xFF);          // B
            rgbaBuffer[idx + 3] = (byte) ((argb >>> 24) & 0xFF); // A
        }

        // Create CGImage from RGBA data and draw to screen
        CGColorSpace colorSpace = null;
        CGBitmapContext bitmapCtx = null;
        CGImage cgImage = null;
        try {
            colorSpace = CGColorSpace.createDeviceRGB();
            bitmapCtx = CGBitmapContext.create(
                rgbaBuffer, w, h, 8, w * 4, colorSpace,
                new CGBitmapInfo(CGImageAlphaInfo.PremultipliedLast.value()));

            if (bitmapCtx != null) {
                cgImage = bitmapCtx.toImage();
                if (cgImage != null) {
                    // CoreGraphics origin is bottom-left, UIKit is top-left - flip Y
                    context.saveGState();
                    context.translateCTM(0, h);
                    context.scaleCTM(1, -1);
                    context.drawImage(new CGRect(0, 0, w, h), cgImage);
                    context.restoreGState();
                }
            }
        } catch (Throwable t) {
            // Fallback: fill black
            context.setRGBFillColor(0, 0, 0, 1);
            context.fillRect(new CGRect(0, 0, w, h));
        } finally {
            if (cgImage != null) try { cgImage.dispose(); } catch (Throwable e) {}
            if (bitmapCtx != null) try { bitmapCtx.dispose(); } catch (Throwable e) {}
            if (colorSpace != null) try { colorSpace.dispose(); } catch (Throwable e) {}
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
        } catch (Throwable t) {
            t.printStackTrace();
        }
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
        } catch (Throwable t) {
            t.printStackTrace();
        }
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
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Override
    public void touchesCancelled(NSSet<UITouch> touches, UIEvent event) {
        touchesEnded(touches, event);
    }
}

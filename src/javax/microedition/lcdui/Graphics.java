package javax.microedition.lcdui;

/**
 * J2ME Graphics shim for RoboVM/iOS.
 * Uses pure int[] pixel buffer instead of java.awt.Graphics2D (not available on iOS).
 */
public class Graphics {
    public static final int HCONTR = 1;
    public static final int VCONTR = 2;
    public static final int TOP = 16;
    public static final int BOTTOM = 32;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int HCENTER = 1;
    public static final int VCENTER = 2;
    public static final int BASELINE = 64;
    public static final int SOLID = 0;
    public static final int DOTTED = 1;

    private int[] pixels;
    private int bufWidth;
    private int bufHeight;
    private int color = 0xFF000000;
    private Font font = Font.getDefaultFont();
    private int clipX, clipY, clipWidth, clipHeight;
    private int translateX, translateY;

    public Graphics() {
        this.bufWidth = 320;
        this.bufHeight = 240;
        this.pixels = new int[bufWidth * bufHeight];
        this.clipWidth = bufWidth;
        this.clipHeight = bufHeight;
    }

    public Graphics(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.bufWidth = width;
        this.bufHeight = height;
        this.clipWidth = width;
        this.clipHeight = height;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getBufferWidth() {
        return bufWidth;
    }

    public int getBufferHeight() {
        return bufHeight;
    }

    public void setColor(int red, int green, int blue) {
        setColor((red << 16) | (green << 8) | blue);
    }

    public void setColor(int RGB) {
        this.color = 0xFF000000 | (RGB & 0x00FFFFFF);
    }

    public int getColor() {
        return color & 0x00FFFFFF;
    }

    public void setFont(Font f) {
        if (f != null) {
            this.font = f;
        }
    }

    public Font getFont() {
        return font;
    }

    public void setClip(int x, int y, int width, int height) {
        this.clipX = x;
        this.clipY = y;
        this.clipWidth = width;
        this.clipHeight = height;
    }

    public void clipRect(int x, int y, int width, int height) {
        int cx2 = Math.min(clipX + clipWidth, x + width);
        int cy2 = Math.min(clipY + clipHeight, y + height);
        clipX = Math.max(clipX, x);
        clipY = Math.max(clipY, y);
        clipWidth = Math.max(0, cx2 - clipX);
        clipHeight = Math.max(0, cy2 - clipY);
    }

    public int getClipX() { return clipX; }
    public int getClipY() { return clipY; }
    public int getClipWidth() { return clipWidth; }
    public int getClipHeight() { return clipHeight; }

    private void setPixel(int x, int y, int c) {
        x += translateX;
        y += translateY;
        if (x >= clipX && x < clipX + clipWidth && y >= clipY && y < clipY + clipHeight
            && x >= 0 && x < bufWidth && y >= 0 && y < bufHeight) {
            pixels[y * bufWidth + x] = c;
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        // Bresenham's line algorithm
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;
        while (true) {
            setPixel(x1, y1, color);
            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x1 += sx; }
            if (e2 < dx) { err += dx; y1 += sy; }
        }
    }

    public void drawRect(int x, int y, int width, int height) {
        drawLine(x, y, x + width, y);
        drawLine(x + width, y, x + width, y + height);
        drawLine(x + width, y + height, x, y + height);
        drawLine(x, y + height, x, y);
    }

    public void fillRect(int x, int y, int width, int height) {
        int ax = x + translateX;
        int ay = y + translateY;
        int x1 = Math.max(ax, Math.max(clipX, 0));
        int y1 = Math.max(ay, Math.max(clipY, 0));
        int x2 = Math.min(ax + width, Math.min(clipX + clipWidth, bufWidth));
        int y2 = Math.min(ay + height, Math.min(clipY + clipHeight, bufHeight));
        for (int py = y1; py < y2; py++) {
            int offset = py * bufWidth;
            for (int px = x1; px < x2; px++) {
                pixels[offset + px] = color;
            }
        }
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        drawRect(x, y, width, height);
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        fillRect(x, y, width, height);
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        // Simplified - draw bounding rect
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        // Simplified - fill bounding rect
        fillRect(x, y, width, height);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Simple scanline triangle fill
        int minY = Math.min(y1, Math.min(y2, y3));
        int maxY = Math.max(y1, Math.max(y2, y3));
        for (int y = minY; y <= maxY; y++) {
            int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
            // Check intersection with each edge
            int[] xs = {x1, x2, x3};
            int[] ys = {y1, y2, y3};
            for (int i = 0; i < 3; i++) {
                int j = (i + 1) % 3;
                int ya = ys[i], yb = ys[j];
                if ((y >= ya && y <= yb) || (y >= yb && y <= ya)) {
                    int dy2 = yb - ya;
                    int x;
                    if (dy2 == 0) {
                        x = Math.min(xs[i], xs[j]);
                        minX = Math.min(minX, x);
                        maxX = Math.max(maxX, Math.max(xs[i], xs[j]));
                        continue;
                    }
                    x = xs[i] + (y - ya) * (xs[j] - xs[i]) / dy2;
                    minX = Math.min(minX, x);
                    maxX = Math.max(maxX, x);
                }
            }
            if (minX <= maxX) {
                for (int x = minX; x <= maxX; x++) {
                    setPixel(x, y, color);
                }
            }
        }
    }

    public void drawString(String str, int x, int y, int anchor) {
        // Minimal text rendering - just updates position for anchor calculations
        // Real text rendering will be handled by the native iOS layer
        if (str == null) return;
        // Anchor adjustments
        if ((anchor & HCENTER) != 0) {
            x -= font.stringWidth(str) / 2;
        } else if ((anchor & RIGHT) != 0) {
            x -= font.stringWidth(str);
        }
        if ((anchor & BOTTOM) != 0) {
            y -= font.getHeight();
        } else if ((anchor & VCENTER) != 0) {
            y -= font.getHeight() / 2;
        }
        // Simple pixel-level text rendering (basic ASCII)
        // For now just draw a filled rect as placeholder for text area
    }

    public void drawSubstring(String str, int offset, int len, int x, int y, int anchor) {
        if (str != null) {
            drawString(str.substring(offset, offset + len), x, y, anchor);
        }
    }

    public void drawChar(char ch, int x, int y, int anchor) {
        drawString(String.valueOf(ch), x, y, anchor);
    }

    public void drawChars(char[] data, int offset, int length, int x, int y, int anchor) {
        drawString(new String(data, offset, length), x, y, anchor);
    }

    public void drawImage(Image img, int x, int y, int anchor) {
        if (img == null) return;
        int imgW = img.getWidth();
        int imgH = img.getHeight();

        // Anchor adjustments
        if ((anchor & HCENTER) != 0) x -= imgW / 2;
        else if ((anchor & RIGHT) != 0) x -= imgW;
        if ((anchor & VCENTER) != 0) y -= imgH / 2;
        else if ((anchor & BOTTOM) != 0) y -= imgH;

        int[] srcPx = img.getPixels();
        if (srcPx == null) return;

        int dx = x + translateX;
        int dy = y + translateY;

        for (int sy = 0; sy < imgH; sy++) {
            int destY = dy + sy;
            if (destY < 0 || destY >= bufHeight || destY < clipY || destY >= clipY + clipHeight) continue;
            for (int sx = 0; sx < imgW; sx++) {
                int destX = dx + sx;
                if (destX < 0 || destX >= bufWidth || destX < clipX || destX >= clipX + clipWidth) continue;
                int srcColor = srcPx[sy * imgW + sx];
                int alpha = (srcColor >>> 24) & 0xFF;
                if (alpha == 0xFF) {
                    pixels[destY * bufWidth + destX] = srcColor;
                } else if (alpha > 0) {
                    // Alpha blend
                    int dstColor = pixels[destY * bufWidth + destX];
                    int dr = (dstColor >> 16) & 0xFF;
                    int dg = (dstColor >> 8) & 0xFF;
                    int db = dstColor & 0xFF;
                    int sr = (srcColor >> 16) & 0xFF;
                    int sg = (srcColor >> 8) & 0xFF;
                    int sb = srcColor & 0xFF;
                    int invA = 255 - alpha;
                    int r = (sr * alpha + dr * invA) / 255;
                    int g = (sg * alpha + dg * invA) / 255;
                    int b = (sb * alpha + db * invA) / 255;
                    pixels[destY * bufWidth + destX] = 0xFF000000 | (r << 16) | (g << 8) | b;
                }
            }
        }
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest, int y_dest, int anchor) {
        if (src == null) return;
        // Anchor adjustments
        if ((anchor & HCENTER) != 0) x_dest -= width / 2;
        else if ((anchor & RIGHT) != 0) x_dest -= width;
        if ((anchor & VCENTER) != 0) y_dest -= height / 2;
        else if ((anchor & BOTTOM) != 0) y_dest -= height;

        int[] srcPx = src.getPixels();
        if (srcPx == null) return;
        int srcW = src.getWidth();

        int dx = x_dest + translateX;
        int dy = y_dest + translateY;

        for (int row = 0; row < height; row++) {
            int destY = dy + row;
            if (destY < 0 || destY >= bufHeight || destY < clipY || destY >= clipY + clipHeight) continue;
            for (int col = 0; col < width; col++) {
                int destX = dx + col;
                if (destX < 0 || destX >= bufWidth || destX < clipX || destX >= clipX + clipWidth) continue;
                int srcIdx = (y_src + row) * srcW + (x_src + col);
                if (srcIdx >= 0 && srcIdx < srcPx.length) {
                    int srcColor = srcPx[srcIdx];
                    int alpha = (srcColor >>> 24) & 0xFF;
                    if (alpha > 0) {
                        pixels[destY * bufWidth + destX] = srcColor;
                    }
                }
            }
        }
    }

    public void translate(int x, int y) {
        translateX += x;
        translateY += y;
    }

    public int getTranslateX() { return translateX; }
    public int getTranslateY() { return translateY; }

    public void setStrokeStyle(int style) {
    }
}

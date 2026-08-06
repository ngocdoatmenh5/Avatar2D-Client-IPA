package javax.microedition.lcdui;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;

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

    private Graphics2D g2d;
    private int color = 0;
    private Font font = Font.getDefaultFont();
    private int clipX, clipY, clipWidth = 320, clipHeight = 240;

    public Graphics() {
    }

    public Graphics(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void setGraphics2D(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public Graphics2D getGraphics2D() {
        return g2d;
    }

    public void setColor(int red, int green, int blue) {
        setColor((red << 16) | (green << 8) | blue);
    }

    public void setColor(int RGB) {
        this.color = RGB;
        if (g2d != null) {
            g2d.setColor(new Color(RGB));
        }
    }

    public int getColor() {
        return color;
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
        if (g2d != null) {
            g2d.setClip(x, y, width, height);
        }
    }

    public void clipRect(int x, int y, int width, int height) {
        if (g2d != null) {
            g2d.clipRect(x, y, width, height);
        }
    }

    public int getClipX() { return clipX; }
    public int getClipY() { return clipY; }
    public int getClipWidth() { return clipWidth; }
    public int getClipHeight() { return clipHeight; }

    public void drawLine(int x1, int y1, int x2, int y2) {
        if (g2d != null) g2d.drawLine(x1, y1, x2, y2);
    }

    public void drawRect(int x, int y, int width, int height) {
        if (g2d != null) g2d.drawRect(x, y, width, height);
    }

    public void fillRect(int x, int y, int width, int height) {
        if (g2d != null) g2d.fillRect(x, y, width, height);
    }

    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        if (g2d != null) g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        if (g2d != null) g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        if (g2d != null) g2d.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
        if (g2d != null) g2d.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (g2d != null) g2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }


    public void drawString(String str, int x, int y, int anchor) {
        if (g2d != null && str != null) {
            g2d.drawString(str, x, y);
        }
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
        if (g2d != null && img != null && img.getBufferedImage() != null) {
            g2d.drawImage(img.getBufferedImage(), x, y, null);
        }
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest, int y_dest, int anchor) {
        if (g2d != null && src != null && src.getBufferedImage() != null) {
            g2d.drawImage(src.getBufferedImage(), x_dest, y_dest, x_dest + width, y_dest + height, x_src, y_src, x_src + width, y_src + height, null);
        }
    }

    public void translate(int x, int y) {
        if (g2d != null) g2d.translate(x, y);
    }

    public int getTranslateX() { return 0; }
    public int getTranslateY() { return 0; }

    public void setStrokeStyle(int style) {
    }
}

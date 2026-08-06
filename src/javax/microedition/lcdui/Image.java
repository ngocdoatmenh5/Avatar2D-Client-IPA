package javax.microedition.lcdui;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.InputStream;
import java.io.IOException;

public class Image {
    private BufferedImage bufferedImage;
    private Graphics graphics;

    private Image(BufferedImage img) {
        this.bufferedImage = img;
    }

    public static Image createImage(int width, int height) {
        BufferedImage img = new BufferedImage(Math.max(1, width), Math.max(1, height), BufferedImage.TYPE_INT_ARGB);
        return new Image(img);
    }

    public static Image createImage(String name) throws IOException {
        InputStream is = Image.class.getResourceAsStream(name);
        if (is == null) {
            throw new IOException("Resource not found: " + name);
        }
        try {
            BufferedImage img = ImageIO.read(is);
            return new Image(img);
        } finally {
            is.close();
        }
    }

    public static Image createImage(InputStream stream) throws IOException {
        BufferedImage img = ImageIO.read(stream);
        return new Image(img);
    }

    public static Image createImage(byte[] imageData, int imageOffset, int imageLength) {
        try {
            java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(imageData, imageOffset, imageLength);
            BufferedImage img = ImageIO.read(bais);
            return new Image(img);
        } catch (Exception e) {
            return createImage(1, 1);
        }
    }

    public static Image createImage(Image source) {
        if (source == null) return null;
        BufferedImage srcImg = source.getBufferedImage();
        BufferedImage copy = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), srcImg.getType());
        java.awt.Graphics g = copy.getGraphics();
        g.drawImage(srcImg, 0, 0, null);
        g.dispose();
        return new Image(copy);
    }

    public static Image createImage(Image image, int x, int y, int width, int height, int transform) {
        if (image == null) return null;
        BufferedImage sub = image.getBufferedImage().getSubimage(x, y, width, height);
        return new Image(sub);
    }

    public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
        BufferedImage img = new BufferedImage(Math.max(1, width), Math.max(1, height), processAlpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);
        img.setRGB(0, 0, width, height, rgb, 0, width);
        return new Image(img);
    }


    public Graphics getGraphics() {
        if (graphics == null && bufferedImage != null) {
            graphics = new Graphics(bufferedImage.createGraphics());
        }
        return graphics;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public int getWidth() {
        return bufferedImage != null ? bufferedImage.getWidth() : 0;
    }

    public int getHeight() {
        return bufferedImage != null ? bufferedImage.getHeight() : 0;
    }

    public boolean isMutable() {
        return true;
    }

    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        if (bufferedImage != null) {
            bufferedImage.getRGB(x, y, width, height, rgbData, offset, scanlength);
        }
    }
}

package main.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.io.IOException;

public class Image {
    public Texture texture;
    public int width;
    public int height;
    private Pixmap cachedPixmap;

    public Image() {
    }

    public Image(Texture texture) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        // không có pixmap source → getRGB sẽ không hoạt động
    }

    public Image(TextureRegion region) {
        this.texture = TextureService.instance.TextureRegionToTextureSafely(region);
        this.width = region.getRegionWidth();
        this.height = region.getRegionHeight();
        // TextureRegionToTexture dùng FrameBuffer, không có pixmap gốc
        // → cacheFromTexture() nếu cần getRGB
    }

    private Image(Texture texture, Pixmap pixmap) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        // copy pixmap để giữ độc lập, không bị dispose từ bên ngoài
        this.cachedPixmap = new Pixmap(pixmap.getWidth(), pixmap.getHeight(), pixmap.getFormat());
        this.cachedPixmap.drawPixmap(pixmap, 0, 0);
    }

    public static Image createImage(final String url) throws IOException {
        String path = url.startsWith("/") ? url.substring(1) : url;
        try {
            Pixmap pixmap = new Pixmap(Gdx.files.internal(path));
            Texture texture = TextureService.instance.createTextureSafely(pixmap);
            if (texture == null) {
                pixmap.dispose();
                return null;
            }
            Image img = new Image(texture, pixmap);
            pixmap.dispose();
            return img;
        } catch (Exception e) {
            throw new IOException("Image not found: " + path, e);
        }
    }

    public static Image createImage(final Pixmap pixmap) throws IOException {
        Texture texture = TextureService.instance.createTextureSafely(pixmap);
        if (texture == null) return null;
        // pixmap vẫn còn sống ở đây vì TextureService không dispose pixmap do bên ngoài truyền vào
        return new Image(texture, pixmap);
    }

    public static Image createImage(byte[] encodedData, int offset, int len) throws IOException {
        Pixmap pixmap = new Pixmap(encodedData, offset, len);
        Texture texture = TextureService.instance.createTextureSafely(pixmap);
        if (texture == null) {
            pixmap.dispose();
            return null;
        }
        Image img = new Image(texture, pixmap);
        pixmap.dispose();
        return img;
    }

    public static Image createImage(final int[] rgbData, final int w, final int h) throws IOException {
        // build pixmap từ int[] ARGB (giống createRGBTexture nhưng giữ pixmap lại)
        Pixmap pixmap = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int argb = rgbData[y * w + x];
                if (argb != 0xFFFFFF && argb != -0xFFFFFF) {
                    int A = (argb >> 24) & 0xFF;
                    int R = (argb >> 16) & 0xFF;
                    int G = (argb >> 8) & 0xFF;
                    int B = (argb) & 0xFF;
                    // LibGDX drawPixel nhận RGBA8888
                    pixmap.drawPixel(x, y, (R << 24) | (G << 16) | (B << 8) | A);
                }
                // else transparent → mặc định 0x00000000
            }
        }
        Texture texture = TextureService.instance.createTextureSafely(pixmap);
        if (texture == null) {
            pixmap.dispose();
            return null;
        }
        Image img = new Image(texture, pixmap);
        pixmap.dispose();
        return img;
    }

    public static Image createImage(Image source, int x, int y, int width, int height, int transform) throws IOException {
        TextureRegion region = new TextureRegion(source.texture, x, y, width, height);
        boolean flipX = false, flipY = false, swapDimensions = false;
        switch (transform) {
            case 5:
                flipX = true;
                flipY = true;
                swapDimensions = true;
                break;
            case 3:
                flipX = true;
                flipY = true;
                break;
            case 6:
                swapDimensions = true;
                break;
            case 2:
                flipX = true;
                break;
            case 7:
                flipX = true;
                swapDimensions = true;
                break;
            case 1:
                flipY = true;
                break;
            case 4:
                flipY = true;
                swapDimensions = true;
                break;
        }
        if (flipX) region.flip(true, false);
        if (flipY) region.flip(false, true);
        if (swapDimensions) {
            float u = region.getU(), v = region.getV();
            float u2 = region.getU2(), v2 = region.getV2();
            region.setRegion(u, v2, u2, v);
        }

        if (source.cachedPixmap != null && !source.cachedPixmap.isDisposed()) {
            // crop trực tiếp từ cached pixmap của source → không cần GPU round-trip
            int finalW = swapDimensions ? height : width;
            int finalH = swapDimensions ? width : height;
            Pixmap cropped = new Pixmap(finalW, finalH, source.cachedPixmap.getFormat());
            cropped.drawPixmap(source.cachedPixmap, 0, 0, x, y, width, height);
            Texture texture = TextureService.instance.createTextureSafely(cropped);
            if (texture == null) {
                cropped.dispose();
                return new Image(region);
            }
            Image img = new Image(texture, cropped);
            cropped.dispose();
            return img;
        }

        return new Image(region);
    }

    public static Image createImage(final int w, final int h) throws IOException {
        Pixmap pixmap = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        Texture texture = TextureService.instance.createTextureSafely(pixmap);
        if (texture == null) {
            pixmap.dispose();
            return null;
        }
        return new Image(texture, pixmap);
    }

    public Graphics getGraphics() {
        if (cachedPixmap == null) {
            throw new IllegalStateException("Image has no mutable pixmap");
        }
        return new PixmapGraphics(this);
    }

    void flushPixmapToTexture() {
        if (cachedPixmap != null && texture != null) {
            TextureService.instance.flushPixmapToTextureSafely(texture, cachedPixmap);
        }
    }

    private static Pixmap borrowPixmap(Image image) {
        if (image == null) {
            return null;
        }
        if (image.cachedPixmap != null && !image.cachedPixmap.isDisposed()) {
            return image.cachedPixmap;
        }
        if (image.texture == null) {
            return null;
        }
        TextureData data = image.texture.getTextureData();
        if (!data.isPrepared()) {
            data.prepare();
        }
        return data.consumePixmap();
    }

    private static void releasePixmap(Image image, Pixmap borrowed) {
        if (borrowed == null || borrowed == image.cachedPixmap) {
            return;
        }
        TextureData data = image.texture.getTextureData();
        if (data != null && data.disposePixmap()) {
            borrowed.dispose();
        }
    }

    private static void drawRegionPixmap(Pixmap dest, Pixmap src, int x0, int y0, int w0, int h0, int transform, int x, int y) {
        if (dest == null || src == null || w0 <= 0 || h0 <= 0) {
            return;
        }
        Pixmap region = new Pixmap(w0, h0, Pixmap.Format.RGBA8888);
        region.drawPixmap(src, 0, 0, x0, y0, w0, h0);
        Pixmap transformed = applyTransform(region, transform);
        dest.drawPixmap(transformed, x, y);
        if (transformed != region) {
            transformed.dispose();
        }
        region.dispose();
    }

    private static Pixmap applyTransform(Pixmap src, int transform) {
        int w = src.getWidth();
        int h = src.getHeight();
        if (transform == 0) {
            return src;
        }
        Pixmap out = new Pixmap(w, h, Pixmap.Format.RGBA8888);
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                int pixel = src.getPixel(col, row);
                int dx = col;
                int dy = row;
                switch (transform) {
                    case 1: // TRANS_MIRROR_ROT180
                        dy = h - 1 - row;
                        break;
                    case 2: // TRANS_MIRROR
                        dx = w - 1 - col;
                        break;
                    case 3: // TRANS_ROT180
                        dx = w - 1 - col;
                        dy = h - 1 - row;
                        break;
                    default:
                        dx = col;
                        dy = row;
                        break;
                }
                out.drawPixel(dx, dy, pixel);
            }
        }
        return out;
    }

    private static final class PixmapGraphics extends Graphics {
        private final Image target;
        private int color = 0xFF000000;

        PixmapGraphics(Image target) {
            super(null);
            this.target = target;
        }

        @Override
        public void setColor(int rgb) {
            color = 0xFF000000 | (rgb & 0xFFFFFF);
        }

        @Override
        public void fillRect(int x, int y, int w, int h) {
            if (target.cachedPixmap == null || w <= 0 || h <= 0) return;
            target.cachedPixmap.setColor(toGdxColor(color));
            target.cachedPixmap.fillRectangle(x, y, w, h);
        }

        @Override
        public void drawImage(Image image, int x, int y, int anchor) {
            if (target.cachedPixmap == null) return;
            Pixmap src = borrowPixmap(image);
            if (src == null) return;
            target.cachedPixmap.drawPixmap(src, x, y);
            releasePixmap(image, src);
            target.flushPixmapToTexture();
        }

        @Override
        public void drawRegion(Image image, int x0, int y0, int w0, int h0, int transform, int x, int y, int anchor) {
            if (target.cachedPixmap == null) return;
            Pixmap src = borrowPixmap(image);
            if (src == null) return;
            drawRegionPixmap(target.cachedPixmap, src, x0, y0, w0, h0, transform, x, y);
            releasePixmap(image, src);
            target.flushPixmapToTexture();
        }

        private static com.badlogic.gdx.graphics.Color toGdxColor(int rgb) {
            int r = (rgb >> 16) & 0xFF;
            int g = (rgb >> 8) & 0xFF;
            int b = rgb & 0xFF;
            return new com.badlogic.gdx.graphics.Color(r / 255f, g / 255f, b / 255f, 1f);
        }
    }

    public static Image createRGBImage(int[] rgb, int w, int h, boolean bl) throws IOException {
        return createImage(rgb, w, h);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public static int argb(int alpha, int red, int green, int blue) {
        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }

    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        if (rgbData == null) throw new NullPointerException("rgbData is null");
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("width or height <= 0");
        if (x < 0 || y < 0 || x + width > getWidth() || y + height > getHeight())
            throw new ArrayIndexOutOfBoundsException("Exceeds image bounds");
        if (scanlength < width) throw new IllegalArgumentException("scanlength < width");
        if (offset < 0 || offset + (height - 1) * scanlength + width > rgbData.length)
            throw new ArrayIndexOutOfBoundsException("rgbData too small");
        if (cachedPixmap == null || cachedPixmap.isDisposed())
            throw new IllegalStateException("No cachedPixmap — image này được tạo từ constructor không có pixmap source");

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int rgba = cachedPixmap.getPixel(x + col, y + row); // RGBA8888
                int R = (rgba >> 24) & 0xFF;
                int G = (rgba >> 16) & 0xFF;
                int B = (rgba >> 8) & 0xFF;
                int A = (rgba) & 0xFF;
                rgbData[offset + row * scanlength + col] = (A << 24) | (R << 16) | (G << 8) | B;
            }
        }
    }

    public void dispose() {
        if (texture != null) texture.dispose();
        if (cachedPixmap != null && !cachedPixmap.isDisposed()) cachedPixmap.dispose();
    }
}

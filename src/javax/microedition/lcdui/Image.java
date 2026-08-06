package javax.microedition.lcdui;

/**
 * J2ME Image shim for RoboVM/iOS.
 * Uses pure int[] pixel buffer instead of java.awt.BufferedImage (not available on iOS).
 */
import java.io.InputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Image {
    private int[] pixels;
    private int width;
    private int height;
    private Graphics graphics;

    private Image(int[] pixels, int width, int height) {
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public static Image createImage(int width, int height) {
        width = Math.max(1, width);
        height = Math.max(1, height);
        int[] px = new int[width * height];
        return new Image(px, width, height);
    }

    public static Image createImage(String name) throws IOException {
        InputStream is = Image.class.getResourceAsStream(name);
        if (is == null) {
            throw new IOException("Resource not found: " + name);
        }
        try {
            return decodePNG(is);
        } finally {
            is.close();
        }
    }

    public static Image createImage(InputStream stream) throws IOException {
        return decodePNG(stream);
    }

    public static Image createImage(byte[] imageData, int imageOffset, int imageLength) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(imageData, imageOffset, imageLength);
            return decodePNG(bais);
        } catch (Exception e) {
            return createImage(1, 1);
        }
    }

    public static Image createImage(Image source) {
        if (source == null) return null;
        int[] copy = new int[source.pixels.length];
        System.arraycopy(source.pixels, 0, copy, 0, source.pixels.length);
        return new Image(copy, source.width, source.height);
    }

    public static Image createImage(Image image, int x, int y, int width, int height, int transform) {
        if (image == null) return null;
        int[] sub = new int[width * height];
        for (int row = 0; row < height; row++) {
            System.arraycopy(image.pixels, (y + row) * image.width + x, sub, row * width, width);
        }
        return new Image(sub, width, height);
    }

    public static Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha) {
        width = Math.max(1, width);
        height = Math.max(1, height);
        int[] px = new int[width * height];
        System.arraycopy(rgb, 0, px, 0, Math.min(rgb.length, px.length));
        if (!processAlpha) {
            for (int i = 0; i < px.length; i++) {
                px[i] = px[i] | 0xFF000000;
            }
        }
        return new Image(px, width, height);
    }

    public Graphics getGraphics() {
        if (graphics == null) {
            graphics = new Graphics(pixels, width, height);
        }
        return graphics;
    }

    public int[] getPixels() {
        return pixels;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isMutable() {
        return true;
    }

    public void getRGB(int[] rgbData, int offset, int scanlength, int x, int y, int width, int height) {
        for (int row = 0; row < height; row++) {
            System.arraycopy(pixels, (y + row) * this.width + x, rgbData, offset + row * scanlength, width);
        }
    }

    /**
     * Minimal PNG decoder - handles basic PNG files without external dependencies.
     * For images that can't be decoded, creates a 1x1 fallback.
     */
    private static Image decodePNG(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[4096];
        int n;
        while ((n = is.read(buf)) != -1) {
            baos.write(buf, 0, n);
        }
        byte[] data = baos.toByteArray();

        // Try to parse PNG header
        if (data.length < 8) {
            return createImage(1, 1);
        }

        // Check PNG signature: 137 80 78 71 13 10 26 10
        if ((data[0] & 0xFF) == 137 && data[1] == 80 && data[2] == 78 && data[3] == 71) {
            return parsePNG(data);
        }

        // Not a recognized format, return 1x1 placeholder
        return createImage(1, 1);
    }

    private static Image parsePNG(byte[] data) throws IOException {
        int pos = 8; // skip signature
        int width = 0, height = 0;
        int bitDepth = 0, colorType = 0;
        ByteArrayOutputStream idatStream = new ByteArrayOutputStream();
        byte[] palette = null;
        byte[] trns = null;

        while (pos + 8 <= data.length) {
            int chunkLen = readInt(data, pos);
            String chunkType = new String(data, pos + 4, 4, "ASCII");
            pos += 8;

            if (chunkLen < 0 || pos + chunkLen > data.length) break;

            if (chunkType.equals("IHDR")) {
                width = readInt(data, pos);
                height = readInt(data, pos + 4);
                bitDepth = data[pos + 8] & 0xFF;
                colorType = data[pos + 9] & 0xFF;
            } else if (chunkType.equals("PLTE")) {
                palette = new byte[chunkLen];
                System.arraycopy(data, pos, palette, 0, chunkLen);
            } else if (chunkType.equals("tRNS")) {
                trns = new byte[chunkLen];
                System.arraycopy(data, pos, trns, 0, chunkLen);
            } else if (chunkType.equals("IDAT")) {
                idatStream.write(data, pos, chunkLen);
            } else if (chunkType.equals("IEND")) {
                break;
            }

            pos += chunkLen + 4; // skip CRC
        }

        if (width <= 0 || height <= 0) {
            return createImage(1, 1);
        }

        // Decompress IDAT
        byte[] compressed = idatStream.toByteArray();
        byte[] decompressed;
        try {
            java.util.zip.Inflater inflater = new java.util.zip.Inflater();
            inflater.setInput(compressed);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] tmpBuf = new byte[4096];
            while (!inflater.finished()) {
                int count = inflater.inflate(tmpBuf);
                if (count == 0 && inflater.needsInput()) break;
                out.write(tmpBuf, 0, count);
            }
            inflater.end();
            decompressed = out.toByteArray();
        } catch (Exception e) {
            return createImage(width, height);
        }

        int[] pixels = new int[width * height];

        try {
            int bpp; // bytes per pixel in raw scanline
            switch (colorType) {
                case 0: bpp = (bitDepth + 7) / 8; break;       // Grayscale
                case 2: bpp = 3 * ((bitDepth + 7) / 8); break; // RGB
                case 3: bpp = 1; break;                         // Indexed
                case 4: bpp = 2 * ((bitDepth + 7) / 8); break; // Grayscale+Alpha
                case 6: bpp = 4 * ((bitDepth + 7) / 8); break; // RGBA
                default: return createImage(width, height);
            }

            int scanlineLen = width * bpp;
            byte[] prevRow = new byte[scanlineLen];
            byte[] curRow = new byte[scanlineLen];
            int srcPos = 0;

            for (int y = 0; y < height; y++) {
                if (srcPos >= decompressed.length) break;
                int filterType = decompressed[srcPos++] & 0xFF;

                int toRead = Math.min(scanlineLen, decompressed.length - srcPos);
                System.arraycopy(decompressed, srcPos, curRow, 0, toRead);
                srcPos += scanlineLen;

                // Apply PNG filter
                unfilter(filterType, curRow, prevRow, bpp);

                // Decode pixels for this row
                for (int x = 0; x < width; x++) {
                    int pixel;
                    switch (colorType) {
                        case 0: { // Grayscale
                            int g = curRow[x] & 0xFF;
                            pixel = 0xFF000000 | (g << 16) | (g << 8) | g;
                            break;
                        }
                        case 2: { // RGB
                            int r = curRow[x * 3] & 0xFF;
                            int g = curRow[x * 3 + 1] & 0xFF;
                            int b = curRow[x * 3 + 2] & 0xFF;
                            pixel = 0xFF000000 | (r << 16) | (g << 8) | b;
                            break;
                        }
                        case 3: { // Indexed
                            int idx = curRow[x] & 0xFF;
                            if (palette != null && idx * 3 + 2 < palette.length) {
                                int r = palette[idx * 3] & 0xFF;
                                int g = palette[idx * 3 + 1] & 0xFF;
                                int b = palette[idx * 3 + 2] & 0xFF;
                                int a = (trns != null && idx < trns.length) ? (trns[idx] & 0xFF) : 0xFF;
                                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                            } else {
                                pixel = 0xFF000000;
                            }
                            break;
                        }
                        case 4: { // Grayscale+Alpha
                            int g = curRow[x * 2] & 0xFF;
                            int a = curRow[x * 2 + 1] & 0xFF;
                            pixel = (a << 24) | (g << 16) | (g << 8) | g;
                            break;
                        }
                        case 6: { // RGBA
                            int r = curRow[x * 4] & 0xFF;
                            int g = curRow[x * 4 + 1] & 0xFF;
                            int b = curRow[x * 4 + 2] & 0xFF;
                            int a = curRow[x * 4 + 3] & 0xFF;
                            pixel = (a << 24) | (r << 16) | (g << 8) | b;
                            break;
                        }
                        default:
                            pixel = 0xFF000000;
                    }
                    pixels[y * width + x] = pixel;
                }

                // Swap rows
                byte[] tmp = prevRow;
                prevRow = curRow;
                curRow = tmp;
            }
        } catch (Exception e) {
            // Partial decode is better than nothing
        }

        return new Image(pixels, width, height);
    }

    private static void unfilter(int filterType, byte[] curRow, byte[] prevRow, int bpp) {
        switch (filterType) {
            case 0: // None
                break;
            case 1: // Sub
                for (int i = bpp; i < curRow.length; i++) {
                    curRow[i] = (byte) ((curRow[i] & 0xFF) + (curRow[i - bpp] & 0xFF));
                }
                break;
            case 2: // Up
                for (int i = 0; i < curRow.length; i++) {
                    curRow[i] = (byte) ((curRow[i] & 0xFF) + (prevRow[i] & 0xFF));
                }
                break;
            case 3: // Average
                for (int i = 0; i < curRow.length; i++) {
                    int a = (i >= bpp) ? (curRow[i - bpp] & 0xFF) : 0;
                    int b = prevRow[i] & 0xFF;
                    curRow[i] = (byte) ((curRow[i] & 0xFF) + (a + b) / 2);
                }
                break;
            case 4: // Paeth
                for (int i = 0; i < curRow.length; i++) {
                    int a = (i >= bpp) ? (curRow[i - bpp] & 0xFF) : 0;
                    int b = prevRow[i] & 0xFF;
                    int c = (i >= bpp) ? (prevRow[i - bpp] & 0xFF) : 0;
                    curRow[i] = (byte) ((curRow[i] & 0xFF) + paeth(a, b, c));
                }
                break;
        }
    }

    private static int paeth(int a, int b, int c) {
        int p = a + b - c;
        int pa = Math.abs(p - a);
        int pb = Math.abs(p - b);
        int pc = Math.abs(p - c);
        if (pa <= pb && pa <= pc) return a;
        if (pb <= pc) return b;
        return c;
    }

    private static int readInt(byte[] data, int pos) {
        return ((data[pos] & 0xFF) << 24) | ((data[pos + 1] & 0xFF) << 16)
             | ((data[pos + 2] & 0xFF) << 8) | (data[pos + 3] & 0xFF);
    }
}

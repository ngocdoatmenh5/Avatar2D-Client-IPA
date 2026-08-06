package javax.microedition.lcdui;

public class Font {
    public static final int STYLE_PLAIN = 0;
    public static final int STYLE_BOLD = 1;
    public static final int STYLE_ITALIC = 2;
    public static final int STYLE_UNDERLINED = 4;

    public static final int SIZE_SMALL = 8;
    public static final int SIZE_MEDIUM = 0;
    public static final int SIZE_LARGE = 16;

    public static final int FACE_SYSTEM = 0;
    public static final int FACE_MONOSPACE = 32;
    public static final int FACE_PROPORTIONAL = 64;

    public static final int FONT_STATIC_TEXT = 0;
    public static final int FONT_INPUT_TEXT = 1;

    private int face;
    private int style;
    private int size;

    private static final Font defaultFont = new Font(FACE_SYSTEM, STYLE_PLAIN, SIZE_MEDIUM);

    private Font(int face, int style, int size) {
        this.face = face;
        this.style = style;
        this.size = size;
    }

    public static Font getDefaultFont() {
        return defaultFont;
    }

    public static Font getFont(int face, int style, int size) {
        return new Font(face, style, size);
    }

    public int getStyle() { return style; }
    public int getSize() { return size; }
    public int getFace() { return face; }

    public int getHeight() {
        return 14;
    }

    public int getBaselinePosition() {
        return 10;
    }

    public int stringWidth(String str) {
        if (str == null) return 0;
        return str.length() * 7;
    }

    public int substringWidth(String str, int offset, int len) {
        if (str == null) return 0;
        return len * 7;
    }

    public int charWidth(char ch) {
        return 7;
    }

    public int charsWidth(char[] ch, int offset, int length) {
        return length * 7;
    }
}

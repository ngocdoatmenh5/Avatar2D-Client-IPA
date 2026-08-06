package javax.microedition.lcdui;

public class ImageItem extends Item {
    public static final int LAYOUT_DEFAULT = 0;
    public static final int LAYOUT_LEFT = 1;
    public static final int LAYOUT_RIGHT = 2;
    public static final int LAYOUT_CENTER = 3;

    private Image image;

    public ImageItem(String label, Image img, int layout, String altText) {
        setLabel(label);
        this.image = img;
    }

    public Image getImage() { return image; }
    public void setImage(Image img) { this.image = img; }
}

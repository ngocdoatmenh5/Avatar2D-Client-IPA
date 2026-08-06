package javax.microedition.lcdui;

public class TextField extends Item {
    public static final int ANY = 0;
    public static final int PASSWORD = 65536;
    public static final int NUMERIC = 2;

    private String value;
    private final int maxSize;
    private final int constraints;

    public TextField(String label, String initialValue, int maxSize, int constraints) {
        super(label);
        this.value = initialValue == null ? "" : initialValue;
        this.maxSize = maxSize;
        this.constraints = constraints;
    }

    public String getString() {
        return this.value;
    }

    public void setString(String value) {
        this.value = value == null ? "" : value;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getConstraints() {
        return this.constraints;
    }

    public boolean isNumeric() {
        return (this.constraints & NUMERIC) != 0;
    }
}

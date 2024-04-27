import java.io.Serializable;

public abstract class AbstractShape implements Serializable {
    private static final long serialVersionUID = 1L;

    // Static fields are not serialized; assuming 'color' should be the same for all instances
    public static String color = "Yellow";

    public abstract double calculateArea();
    public abstract double calculatePerimeter();

    public String getColor() {
        return color;
    }

    public static void setColor(String newColor) {
        color = newColor;
    }
}

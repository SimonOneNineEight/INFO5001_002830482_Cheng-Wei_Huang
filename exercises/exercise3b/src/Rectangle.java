import java.io.Serializable;

public class Rectangle extends AbstractShape implements Serializable {
    private static final long serialVersionUID = 1L;
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * (double) height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

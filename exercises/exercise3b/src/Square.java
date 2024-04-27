import java.io.Serializable;

public class Square extends AbstractShape implements Serializable {
    private static final long serialVersionUID = 1L;
    private int width;

    public Square(int width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return width * (double) width;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * width;
    }
}

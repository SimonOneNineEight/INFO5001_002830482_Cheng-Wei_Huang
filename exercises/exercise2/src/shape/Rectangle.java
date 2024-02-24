package shape;

public class Rectangle extends AbstractShape{
  private int width;
  private int height;

  public Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return (double) width * height;
  }

  @Override
  public double calculatePerimeter() {
    return (double) 2 * (width + height);
  }
}

package shape;

public class Square extends AbstractShape{
  private int width;
  public Square(int width) {
    this.width = width;
  }

  @Override
  public double calculateArea() {
    return (double) width * width;
  }

  @Override
  public double calculatePerimeter() {
    return (double) 4 * width;
  }
}

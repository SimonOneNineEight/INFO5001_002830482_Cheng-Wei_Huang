package shape;

public abstract class AbstractShape {
  public static String color = "Yellow";

  public abstract double calculateArea();
  public abstract double calculatePerimeter();

  public String getColor() {
    return color;
  }
}

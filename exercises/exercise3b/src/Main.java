import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Create shape instances
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(10, 5);
        Triangle triangle = new Triangle(3, 4, 5);
        Square square = new Square(4);

        // Serialize shapes
        try {
            SerializationUtil.writeObject(circle, "circle.ser");
            SerializationUtil.writeObject(rectangle, "rectangle.ser");
            SerializationUtil.writeObject(triangle, "triangle.ser");
            SerializationUtil.writeObject(square, "square.ser");
            System.out.println("Shapes have been serialized successfully.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize shapes and print their properties
        try {
            Circle deserializedCircle = (Circle) SerializationUtil.readObject("circle.ser");
            Rectangle deserializedRectangle = (Rectangle) SerializationUtil.readObject("rectangle.ser");
            Triangle deserializedTriangle = (Triangle) SerializationUtil.readObject("triangle.ser");
            Square deserializedSquare = (Square) SerializationUtil.readObject("square.ser");

            System.out.println("Deserialized Circle Area: " + deserializedCircle.calculateArea());
            System.out.println("Deserialized Circle Perimeter: " + deserializedCircle.calculatePerimeter());

            System.out.println("Deserialized Rectangle Area: " + deserializedRectangle.calculateArea());
            System.out.println("Deserialized Rectangle Perimeter: " + deserializedRectangle.calculatePerimeter());

            System.out.println("Deserialized Triangle Area: " + deserializedTriangle.calculateArea());
            System.out.println("Deserialized Triangle Perimeter: " + deserializedTriangle.calculatePerimeter());

            System.out.println("Deserialized Square Area: " + deserializedSquare.calculateArea());
            System.out.println("Deserialized Square Perimeter: " + deserializedSquare.calculatePerimeter());

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}

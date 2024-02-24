public class Pen {
  private String brand;
  private String color;
  private String type; // e.g., ballpoint, fountain, gel
  private double tipSize; // in millimeters
  private boolean isRefillable;
  private String inkColor;
  private int inkLevel; // Represented as a percentage from 0 to 100
  private boolean isCapped;

  public Pen(String brand, String color, String type, double tipSize, boolean isRefillable, String inkColor, int inkLevel, boolean isCapped) {
    this.brand = brand;
    this.color = color;
    this.type = type;
    this.tipSize = tipSize;
    this.isRefillable = isRefillable;
    this.inkColor = inkColor;
    this.inkLevel = inkLevel;
    this.isCapped = isCapped;
  }

  // Method to write with the pen, which decreases the ink level
  public void write(String text) {
    if (!isCapped && inkLevel > 0) {
      System.out.println("Writing: " + text);
      inkLevel -= 5; // Decrease ink level by 5% for this example
      if (inkLevel < 0) {
        inkLevel = 0; // Ensure ink level does not go below 0
      }
    } else if (isCapped) {
      System.out.println("Cannot write. The pen is capped.");
    } else {
      System.out.println("Cannot write. The pen is out of ink.");
    }
  }

  // Method to refill the pen, if it is refillable
  public void refill(int inkAmount) {
    if (isRefillable) {
      inkLevel += inkAmount;
      if (inkLevel > 100) {
        inkLevel = 100; // Ensure ink level does not exceed 100%
      }
      System.out.println("Pen refilled. Current ink level: " + inkLevel + "%");
    } else {
      System.out.println("This pen cannot be refilled.");
    }
  }

  // Method to display the pen's details
  public void displayDetails() {
    System.out.println("Pen Details:");
    System.out.println("Brand: " + brand);
    System.out.println("Color: " + color);
    System.out.println("Type: " + type);
    System.out.println("Tip Size: " + tipSize + "mm");
    System.out.println("Refillable: " + (isRefillable ? "Yes" : "No"));
    System.out.println("Ink Color: " + inkColor);
    System.out.println("Ink Level: " + inkLevel + "%");
    System.out.println("Is Capped: " + (isCapped ? "Yes" : "No"));
  }
}

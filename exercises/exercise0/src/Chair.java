public class Chair {
  private String material;
  private String color;
  private int height;
  private int width;
  private int depth;
  private boolean hasArmrests;
  private boolean hasWheels;
  private int comfortLevel; // 1 to 10 scale

  public Chair(String material, String color, int height, int width, int depth, boolean hasArmrests, boolean hasWheels, int comfortLevel) {
    this.material = material;
    this.color = color;
    this.height = height;
    this.width = width;
    this.depth = depth;
    this.hasArmrests = hasArmrests;
    this.hasWheels = hasWheels;
    this.comfortLevel = comfortLevel;
  }

  // Getters
  public String getMaterial() { return material; }
  public String getColor() { return color; }
  public int getHeight() { return height; }
  public int getWidth() { return width; }
  public int getDepth() { return depth; }
  public boolean hasArmrests() { return hasArmrests; }
  public boolean hasWheels() { return hasWheels; }
  public int getComfortLevel() { return comfortLevel; }

  // Setters
  public void setMaterial(String material) { this.material = material; }
  public void setColor(String color) { this.color = color; }
  public void setHeight(int height) { this.height = height; }
  public void setWidth(int width) { this.width = width; }
  public void setDepth(int depth) { this.depth = depth; }
  public void setHasArmrests(boolean hasArmrests) { this.hasArmrests = hasArmrests; }
  public void setHasWheels(boolean hasWheels) { this.hasWheels = hasWheels; }
  public void setComfortLevel(int comfortLevel) { this.comfortLevel = comfortLevel; }

  // Methods
  public void adjustChair(int newHeight, int newWidth, int newDepth) {
    this.height = newHeight;
    this.width = newWidth;
    this.depth = newDepth;
    System.out.println("Chair adjusted to new dimensions.");
  }

  public boolean isComfortable() {
    return this.comfortLevel >= 7;
  }

  public void displayDetails() {
    System.out.println("Chair Details: ");
    System.out.println("Material: " + material);
    System.out.println("Color: " + color);
    System.out.println("Height: " + height + " cm");
    System.out.println("Width: " + width + " cm");
    System.out.println("Depth: " + depth + " cm");
    System.out.println("Has Armrests: " + hasArmrests);
    System.out.println("Has Wheels: " + hasWheels);
    System.out.println("Comfort Level: " + comfortLevel + "/10");
  }
}

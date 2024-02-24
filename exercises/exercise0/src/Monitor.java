public class Monitor {
  private String brand;
  private String model;
  private double screenSize; // in inches
  private String resolution; // e.g., "1920x1080"
  private int refreshRate; // in Hz
  private String panelType; // e.g., IPS, TN, VA
  private boolean isCurved;
  private int brightness; // in cd/m² (candelas per square meter)

  public Monitor(String brand, String model, double screenSize, String resolution, int refreshRate, String panelType, boolean isCurved, int brightness) {
    this.brand = brand;
    this.model = model;
    this.screenSize = screenSize;
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.panelType = panelType;
    this.isCurved = isCurved;
    this.brightness = brightness;
  }

  // Method to turn on the monitor
  public void turnOn() {
    System.out.println("The monitor is now on.");
  }

  // Method to adjust the brightness
  public void adjustBrightness(int newBrightness) {
    brightness = newBrightness;
    System.out.println("Brightness adjusted to " + brightness + " cd/m².");
  }

  // Method to display the monitor's details
  public void displayDetails() {
    System.out.println("Monitor Details:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Screen Size: " + screenSize + " inches");
    System.out.println("Resolution: " + resolution);
    System.out.println("Refresh Rate: " + refreshRate + " Hz");
    System.out.println("Panel Type: " + panelType);
    System.out.println("Is Curved: " + (isCurved ? "Yes" : "No"));
    System.out.println("Brightness: " + brightness + " cd/m²");
  }
}

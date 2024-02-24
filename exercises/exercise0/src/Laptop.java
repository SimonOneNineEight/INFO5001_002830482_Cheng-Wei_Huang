public class Laptop {
  private String brand;
  private String model;
  private double screenSize; // in inches
  private int batteryLife; // in hours
  private int ram; // in GB
  private int storage; // in GB, considering SSD or HDD
  private boolean isTouchscreen;
  private String operatingSystem;

  public Laptop(String brand, String model, double screenSize, int batteryLife, int ram, int storage, boolean isTouchscreen, String operatingSystem) {
    this.brand = brand;
    this.model = model;
    this.screenSize = screenSize;
    this.batteryLife = batteryLife;
    this.ram = ram;
    this.storage = storage;
    this.isTouchscreen = isTouchscreen;
    this.operatingSystem = operatingSystem;
  }

  public void powerOn() {
    System.out.println("Powering on " + brand + " " + model + "...");
  }

  public void installSoftware(String softwareName) {
    System.out.println(softwareName + " installation started...");
  }

  public void displaySpecs() {
    System.out.println("Laptop Specifications:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Screen Size: " + screenSize + "\"");
    System.out.println("Battery Life: " + batteryLife + " hours");
    System.out.println("RAM: " + ram + " GB");
    System.out.println("Storage: " + storage + " GB");
    System.out.println("Touchscreen: " + (isTouchscreen ? "Yes" : "No"));
    System.out.println("Operating System: " + operatingSystem);
  }
}

public class SmartPhone {
  private String brand;
  private String model;
  private String color;
  private double screenSize;
  private int batteryCapacity;
  private int ram;
  private int storage;
  private String operatingSystem;

  public SmartPhone(String brand, String model, String color, double screenSize, int batteryCapacity, int ram, int storage, String operatingSystem) {
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.screenSize = screenSize;
    this.batteryCapacity = batteryCapacity;
    this.ram = ram;
    this.storage = storage;
    this.operatingSystem = operatingSystem;
  }

  // Getters
  public String getBrand() { return brand; }
  public String getModel() { return model; }
  public String getColor() { return color; }
  public double getScreenSize() { return screenSize; }
  public int getBatteryCapacity() { return batteryCapacity; }
  public int getRam() { return ram; }
  public int getStorage() { return storage; }
  public String getOperatingSystem() { return operatingSystem; }

  // Setters
  public void setBrand(String brand) { this.brand = brand; }
  public void setModel(String model) { this.model = model; }
  public void setColor(String color) { this.color = color; }
  public void setScreenSize(double screenSize) { this.screenSize = screenSize; }
  public void setBatteryCapacity(int batteryCapacity) { this.batteryCapacity = batteryCapacity; }
  public void setRam(int ram) { this.ram = ram; }
  public void setStorage(int storage) { this.storage = storage; }
  public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

  // Methods
  public void unlockPhone() {
    System.out.println("Phone unlocked successfully.");
  }

  public String checkBatteryStatus() {
    if(batteryCapacity > 3000) {
      return "High battery capacity. Good for long usage.";
    } else {
      return "Average battery capacity. Consider carrying a charger.";
    }
  }

  public void displaySpecifications() {
    System.out.println("SmartPhone Specifications:");
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Color: " + color);
    System.out.println("Screen Size: " + screenSize + " inches");
    System.out.println("Battery Capacity: " + batteryCapacity + " mAh");
    System.out.println("RAM: " + ram + " GB");
    System.out.println("Storage: " + storage + " GB");
    System.out.println("Operating System: " + operatingSystem);
  }
}

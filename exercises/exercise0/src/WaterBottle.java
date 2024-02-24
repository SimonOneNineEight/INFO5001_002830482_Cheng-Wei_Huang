public class WaterBottle {
  private String material;
  private String color;
  private double capacity; // in liters
  private double currentVolume; // in liters
  private boolean insulated;
  private String brand;
  private double weight; // in grams
  private boolean hasStraw;

  public WaterBottle(String material, String color, double capacity, boolean insulated, String brand, double weight, boolean hasStraw) {
    this.material = material;
    this.color = color;
    this.capacity = capacity;
    this.insulated = insulated;
    this.brand = brand;
    this.weight = weight;
    this.hasStraw = hasStraw;
    this.currentVolume = 0; // Assuming the bottle is empty when created
  }

  // Getters
  public String getMaterial() { return material; }
  public String getColor() { return color; }
  public double getCapacity() { return capacity; }
  public double getCurrentVolume() { return currentVolume; }
  public boolean isInsulated() { return insulated; }
  public String getBrand() { return brand; }
  public double getWeight() { return weight; }
  public boolean hasStraw() { return hasStraw; }

  // Methods
  public void fill(double volume) {
    if (volume <= capacity - currentVolume) {
      currentVolume += volume;
      System.out.println("Water bottle filled. Current volume: " + currentVolume + " liters.");
    } else {
      System.out.println("Cannot fill beyond capacity. Maximum fillable volume: " + (capacity - currentVolume) + " liters.");
    }
  }

  public void drink(double volume) {
    if (volume <= currentVolume) {
      currentVolume -= volume;
      System.out.println("You drank " + volume + " liters. Remaining volume: " + currentVolume + " liters.");
    } else {
      System.out.println("Not enough water. Current volume: " + currentVolume + " liters.");
    }
  }

  public void displayDetails() {
    System.out.println("Water Bottle Details:");
    System.out.println("Material: " + material);
    System.out.println("Color: " + color);
    System.out.println("Capacity: " + capacity + " liters");
    System.out.println("Current Volume: " + currentVolume + " liters");
    System.out.println("Insulated: " + insulated);
    System.out.println("Brand: " + brand);
    System.out.println("Weight: " + weight + " grams");
    System.out.println("Has Straw: " + hasStraw);
  }
}

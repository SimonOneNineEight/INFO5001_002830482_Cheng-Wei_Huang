public class Coffee {
  private String type;
  private double volume;
  private boolean isHot;
  private int caffeineContent;
  private String origin;
  private double price;
  private boolean hasMilk;
  private String flavor;

  public Coffee(String type, double volume, boolean isHot, int caffeineContent, String origin, double price, boolean hasMilk, String flavor) {
    this.type = type;
    this.volume = volume;
    this.isHot = isHot;
    this.caffeineContent = caffeineContent;
    this.origin = origin;
    this.price = price;
    this.hasMilk = hasMilk;
    this.flavor = flavor;
  }

  // Getters
  public String getType() { return type; }
  public double getVolume() { return volume; }
  public boolean isHot() { return isHot; }
  public int getCaffeineContent() { return caffeineContent; }
  public String getOrigin() { return origin; }
  public double getPrice() { return price; }
  public boolean hasMilk() { return hasMilk; }
  public String getFlavor() { return flavor; }

  // Methods
  public void drink(double amount) {
    if (amount <= volume) {
      volume -= amount;
      System.out.println("You drank " + amount + "ml of coffee. Remaining volume: " + volume + "ml.");
    } else {
      System.out.println("Not enough coffee left to drink " + amount + "ml. Remaining volume: " + volume + "ml.");
    }
  }

  public void reheat() {
    if (!isHot) {
      isHot = true;
      System.out.println("Your coffee has been reheated and is now hot.");
    } else {
      System.out.println("Your coffee is already hot.");
    }
  }

  public void displayDetails() {
    System.out.println("Coffee Details:");
    System.out.println("Type: " + type);
    System.out.println("Volume: " + volume + "ml");
    System.out.println("Is Hot: " + isHot);
    System.out.println("Caffeine Content: " + caffeineContent + "mg");
    System.out.println("Origin: " + origin);
    System.out.println("Price: $" + price);
    System.out.println("Has Milk: " + hasMilk);
    System.out.println("Flavor: " + flavor);
  }
}

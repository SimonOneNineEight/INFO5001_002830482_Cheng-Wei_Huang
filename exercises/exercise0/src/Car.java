public class Car {
  private String make;
  private String model;
  private int year;
  private double mileage; // in miles
  private String color;
  private int seatingCapacity;
  private double fuelCapacity; // in liters
  private boolean isElectric;

  public Car(String make, String model, int year, double mileage, String color, int seatingCapacity, double fuelCapacity, boolean isElectric) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.mileage = mileage;
    this.color = color;
    this.seatingCapacity = seatingCapacity;
    this.fuelCapacity = fuelCapacity;
    this.isElectric = isElectric;
  }

  public void startEngine() {
    System.out.println("The engine of the " + make + " " + model + " has been started.");
  }

  public void drive(double distance) {
    mileage += distance;
    System.out.println("Driving " + distance + " miles. Total mileage is now " + mileage + " miles.");
  }

  public void displaySpecifications() {
    System.out.println("Car Specifications:");
    System.out.println("Make: " + make);
    System.out.println("Model: " + model);
    System.out.println("Year: " + year);
    System.out.println("Mileage: " + mileage + " miles");
    System.out.println("Color: " + color);
    System.out.println("Seating Capacity: " + seatingCapacity);
    System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    System.out.println("Electric: " + (isElectric ? "Yes" : "No"));
  }
}

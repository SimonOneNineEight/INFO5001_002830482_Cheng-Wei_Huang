public class Person {
  private String firstName;
  private String lastName;
  private int age;
  private String nationality;
  private String occupation;
  private double height; // in centimeters
  private double weight; // in kilograms
  private String emailAddress;

  public Person(String firstName, String lastName, int age, String nationality, String occupation, double height, double weight, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.nationality = nationality;
    this.occupation = occupation;
    this.height = height;
    this.weight = weight;
    this.emailAddress = emailAddress;
  }

  // Method to celebrate a birthday and increase age
  public void celebrateBirthday() {
    this.age++;
    System.out.println("Happy Birthday " + firstName + "! You are now " + age + " years old.");
  }

  // Method to update the person's email address
  public void updateEmail(String newEmail) {
    this.emailAddress = newEmail;
    System.out.println("Email updated to: " + newEmail);
  }

  // Method to display the person's details
  public void displayDetails() {
    System.out.println("Person Details:");
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Age: " + age);
    System.out.println("Nationality: " + nationality);
    System.out.println("Occupation: " + occupation);
    System.out.println("Height: " + height + " cm");
    System.out.println("Weight: " + weight + " kg");
    System.out.println("Email Address: " + emailAddress);
  }
}

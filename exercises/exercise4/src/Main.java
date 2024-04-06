//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {

  public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.

    // Pattern 1: Date in format yyyy-mm-dd
    String datePattern = "^\\d{4}-\\d{2}-\\d{2}$";
    testPattern(datePattern, "2020-01-01", true);         // Positive case
    testPattern(datePattern, "2020/01/01", false);

//    Pattern 2: IP address
    String ipPattern = "^\\d{1,3}(\\.\\d{1,3}){3}$";
    testPattern(ipPattern, "192.168.1.1", true);          // Positive case
    testPattern(ipPattern, "256.1.1.1", false);           // Negative case

    // Pattern 3: HTML tag
    String htmlTagPattern = "^<\\s*\\w+\\s*/?>$";
    testPattern(htmlTagPattern, "<div>", true);           // Positive case
    testPattern(htmlTagPattern, "< div>", false);         // Negative case

    /*
      1. At least 8 characters long
      2. Contains at least one uppercase letter
      3. Contains at least one lowercase letter
      4. Contains at least one digit
      5. Contains at least one special character (e.g., @, #, $, etc.)
     */
    String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!^&*()])[A-Za-z\\d@#$%!^&*()]{8,}$";
    testPattern(passwordPattern, "Password123!", true); // Positive case: valid password
    testPattern(passwordPattern, "pass", false);        // Negative case: too short
    testPattern(passwordPattern, "password123", false); // Negative case: no uppercase or special character
    testPattern(passwordPattern, "PASSWORD123", false); // Negative case: no lowercase or special character
    testPattern(passwordPattern, "Pass1234", false);    // Negative case: no special character
    testPattern(passwordPattern, "Password@", false);   // Negative case: no digit
    testPattern(passwordPattern, "Passw0rd!", true);    // Positive case: meets all criteria

    // Pattern 4. URL pattern
    String urlPattern = "^(https?://)?(www\\.)?([\\w-]+\\.)+[\\w-]{2,6}(/\\S*)?$";
    testPattern(urlPattern, "http://www.example.com", true);       // Positive case: valid URL
    testPattern(urlPattern, "https://example.com/test?query=true", true); // Positive case: valid URL with path and query
    testPattern(urlPattern, "www.example.com", true);              // Positive case: valid URL without protocol
    testPattern(urlPattern, "example.com", true);                  // Positive case: valid URL short form
    testPattern(urlPattern, "http://example", false);              // Negative case: invalid domain

    // Pattern 5. Credit Card Number pattern
    String creditCardPattern = "^(\\d{4}-){3}\\d{4}$";
    testPattern(creditCardPattern, "1234-5678-9012-3456", true);    // Positive case: valid credit card number
    testPattern(creditCardPattern, "1234-5678-9012-34567", false);  // Negative case: too many digits
    testPattern(creditCardPattern, "1234 5678 9012 3456", false);   // Negative case: spaces instead of dashes
    testPattern(creditCardPattern, "1234-5678-9012", false);
  }

  private static void testPattern(String pattern, String input, boolean expected) {
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(input);
    boolean result = m.matches();
    System.out.println("Testing pattern: " + pattern);
    System.out.println("With input: " + input);
    System.out.println("Expected: " + expected + " | Actual: " + result);
    System.out.println("Result: " + (result == expected ? "PASS" : "FAIL"));
    System.out.println("---------------------------------");
  }
}
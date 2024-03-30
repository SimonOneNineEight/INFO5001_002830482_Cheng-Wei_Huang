package Library;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

  public static void main(String[] args) {
    Library library = new Library();

    // Add books to the library
    library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "1234567890"));
    library.addBook(new Book("1984", "George Orwell", "Dystopian", "0987654//321"));

    System.out.println("Available books:");
    library.getAvailableBooks();
    // Search and display books by title
    System.out.println("Books with title '1984': " + library.searchByTitle("1984"));

    // Checkout a book
    library.checkoutABook("1234567890");

//    Display all available books after checked out one book
    System.out.println("Available books:");
    library.getAvailableBooks();
    // Return a book
    library.returnABook("1234567890");

    // Display all available books
    System.out.println("Available books:");
    library.getAvailableBooks();
  }
}

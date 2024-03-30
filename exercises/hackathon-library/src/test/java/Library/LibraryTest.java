package Library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
  private Library library;

  @Before
  public void setUp() {
    library = new Library();
    library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "1234567890"));
    library.addBook(new Book("1984", "George Orwell", "Dystopian", "0987654321"));
  }

  @Test
  public void testAddAndSearchBook() {
    String title = "The Lord of the Rings";
    library.addBook(new Book(title, "J.R.R. Tolkien", "Fantasy", "1122334455"));
    Assert.assertFalse(library.searchByTitle(title).isEmpty());
  }

  @Test
  public void testRemoveBook() {
    Book book = new Book("Mock Book", "Author", "Genre", "000111222");
    library.addBook(book);
    library.removeBook(book);
    Assert.assertTrue(library.searchByTitle("Mock Book").isEmpty());
  }

  @Test
  public void testCheckoutAndReturnBook() {
    String isbn = "1234567890";
    library.checkoutABook(isbn);
    Assert.assertFalse(library.searchByTitle("The Hobbit").get(0).isAvailable());

    library.returnABook(isbn);
    Assert.assertTrue(library.searchByTitle("The Hobbit").get(0).isAvailable());
  }
}


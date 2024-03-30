package Library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

  private Book book;

  @BeforeEach
  void setUp() {
    book = new Book("Effective Java", "Joshua Bloch", "Programming", "0321356683");
  }

  @Test
  void testBookConstructorAndGetters() {
    assertAll("Constructor and Getters",
        () -> assertEquals("Effective Java", book.getTitle()),
        () -> assertEquals("Joshua Bloch", book.getAuthor()),
        () -> assertEquals("Programming", book.getGenre()),
        () -> assertEquals("0321356683", book.getISBN())
    );
  }

  @Test
  void testBookAvailability() {
    assertTrue(book.isAvailable(), "New book should be available");
    book.setAvailable(false);
    assertFalse(book.isAvailable(), "Book should be marked as unavailable after checkout");
  }

  @Test
  void testToString() {
    String expected = "Book { " +
        "Title='Effective Java'" +
        ", Author='Joshua Bloch'" +
        ", Genre='Programming'" +
        ", ISBN='0321356683'" +
        ", Availability=Available" +
        ", Borrowed= 0 times"+
        " }";
    assertEquals(expected, book.toString());
  }
}

package Library;

import java.util.ArrayList;

public class Library {
  private ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
  }

  public void addBook(Book book) {
    this.books.add(book);
    System.out.println(book.getTitle() + " is added to the library.");
  }

  public void removeBook(Book book) {
    boolean isRemoved = this.books.remove(book);
    if (isRemoved) {
      System.out.println(book.getTitle()+ " removed.");
    } else {
      System.out.println(book.getTitle() + " is not in the library.");
    }
  }
  public ArrayList<Book> searchByTitle(String title) {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book: books) {
      if (book.getTitle().equals(title)) {
        result.add(book);
      }
    }
    return result;
  }
  public ArrayList<Book> searchByAuthor(String author) {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book: books) {
      if (book.getAuthor().equals(author)) {
        result.add(book);
      }
    }
    return result;
  }
  public ArrayList<Book> searchByGenre(String genre) {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book: books) {
      if (book.getGenre().equals(genre)) {
        result.add(book);
      }
    }
    return result;
  }

  public ArrayList<Book> getAvailableBooks() {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book: books) {
      if (book.isAvailable()) {
        result.add(book);
      }
    }
    for (Book book: result) {
      System.out.println(book);
    }
    return result;
  }
  public boolean checkoutABook(String isbn) {
    if (this.books.stream().noneMatch(book -> book.getISBN().equals(isbn))) {
      System.out.println("Book ISBN: " + isbn + " is not in this library.");
      return false;
    }
    for (Book book : this.books) {
      if (book.getISBN().equals(isbn)) {
        if (!book.isAvailable()) {
          System.out.println("Book ISBN: " + isbn + " is not available now.");
          return false;
        }
        book.setAvailable(false);
        System.out.println("Book ISBN: " + isbn + " checked-out.");
        return true;
      }
    }
    return false;
  }
  public boolean returnABook(String isbn) {
    if (this.books.stream().noneMatch(book -> book.getISBN().equals(isbn))) {
      System.out.println("Book ISBN: " + isbn + " is not in this library.");
      return false;
    }
    for (Book book : this.books) {
      if (book.getISBN().equals(isbn)) {
        if (book.isAvailable()) {
          System.out.println("Book ISBN: " + isbn + " is not borrowed now.");
          return false;
        }
        book.setAvailable(true);
        System.out.println("Book ISBN: " + isbn + " returned.");
        return true;
      }
    }
    return false;
  }
}
package Library;

public class Book {
  private String title;
  private String author;
  private String genre;
  private String isbn;
  private boolean isAvailable;

  private int borrowCount;

  public Book(String title, String author, String genre, String isbn) {
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.isbn = isbn;
    this.isAvailable = true; // New books are available by default
    this.borrowCount = 0;
  }

  // Getters and setters
  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public String getGenre() {
    return this.genre;
  }

  public String getISBN() {
    return this.isbn;
  }

  public int getBorrowCount() {
    return this.borrowCount;
  }
  public boolean isAvailable() {
    return this.isAvailable;
  }

  public void setAvailable(boolean available) {
    if (!available) this.borrowCount ++;
    this.isAvailable = available;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null || this.getClass() != object.getClass()) return false;
    if (this == object) return true;
    Book book = (Book) object;
    return this.isbn.equals(book.getISBN());
  }

  @Override
  public String toString() {
    return "Book { " +
        "Title='" + this.title + '\'' +
        ", Author='" + this.author + '\'' +
        ", Genre='" + this.genre + '\'' +
        ", ISBN='" + this.isbn + '\'' +
        ", Availability=" + (this.isAvailable ? "Available" : "Not Available") +
        ", Borrowed= " + this.borrowCount + " times" +
        " }";
  }
}


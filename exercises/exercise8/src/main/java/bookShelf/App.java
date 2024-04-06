package bookShelf;

import java.awt.print.Book;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {
    String xmlData = """
        <BookShelf>
            <Book>
                <title>The Great Gatsby</title>
                <publishedYear>1925</publishedYear>
                <numberOfPages>218</numberOfPages>
                <authors>
                    <author>F. Scott Fitzgerald</author>
                </authors>
            </Book>
            <Book>
                <title>1984</title>
                <publishedYear>1949</publishedYear>
                <numberOfPages>328</numberOfPages>
                <authors>
                    <author>George Orwell</author>
                </authors>
            </Book>
            <Book>
                <title>The Hobbit</title>
                <publishedYear>1937</publishedYear>
                <numberOfPages>310</numberOfPages>
                <authors>
                    <author>J.R.R. Tolkien</author>
                </authors>
            </Book>
        </BookShelf>
        """;

    String jsonData = """
        {
            "BookShelf": [
                {
                    "title": "The Great Gatsby",
                    "publishedYear": 1925,
                    "numberOfPages": 218,
                    "authors": ["F. Scott Fitzgerald"]
                },
                {
                    "title": "1984",
                    "publishedYear": 1949,
                    "numberOfPages": 328,
                    "authors": ["George Orwell"]
                },
                {
                    "title": "The Hobbit",
                    "publishedYear": 1937,
                    "numberOfPages": 310,
                    "authors": ["J.R.R. Tolkien"]
                }
            ]
        }
        """;

    try {
      BookParser.parseAndPrintXML(xmlData);
      BookParser.parseAndPrintJSON(jsonData);

      System.out.println("Adding a new book entry programmatically...");

      // Adding new book programmatically and re-parsing
      xmlData = BookParser.addBookToXML(xmlData, "The Catcher in the Rye", "1951", "234", "J.D. Salinger");
      jsonData = BookParser.addBookToJSON(jsonData, "The Catcher in the Rye", 1951, 234,
          new String[]{"J.D. Salinger"});

      BookParser.parseAndPrintXML(xmlData);
      BookParser.parseAndPrintJSON(jsonData);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

package bookShelf;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class BookParser {

  public static void parseAndPrintXML(String xmlData) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new InputSource(new StringReader(xmlData)));

    NodeList nodeList = doc.getElementsByTagName("Book");
    System.out.println("XML Data:");
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        String title = element.getElementsByTagName("title").item(0).getTextContent();
        String year = element.getElementsByTagName("publishedYear").item(0).getTextContent();
        String pages = element.getElementsByTagName("numberOfPages").item(0).getTextContent();
        NodeList authorsList = element.getElementsByTagName("author");
        List<String> authors = new ArrayList<>();
        for (int j = 0; j < authorsList.getLength(); j++) {
          authors.add(authorsList.item(j).getTextContent());
        }
        System.out.printf("Book: %s, Year: %s, Pages: %s, Authors: %s%n", title, year, pages,
            authors);
      }
    }
  }

  public static String addBookToXML(String xmlData, String title, String year, String pages, String author) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new InputSource(new StringReader(xmlData)));

    Node bookShelf = doc.getElementsByTagName("BookShelf").item(0);

    Element book = doc.createElement("Book");
    Element titleElement = doc.createElement("title");
    titleElement.appendChild(doc.createTextNode(title));
    Element yearElement = doc.createElement("publishedYear");
    yearElement.appendChild(doc.createTextNode(year));
    Element pagesElement = doc.createElement("numberOfPages");
    pagesElement.appendChild(doc.createTextNode(pages));
    Element authors = doc.createElement("authors");
    Element authorElement = doc.createElement("author");
    authorElement.appendChild(doc.createTextNode(author));

    authors.appendChild(authorElement);
    book.appendChild(titleElement);
    book.appendChild(yearElement);
    book.appendChild(pagesElement);
    book.appendChild(authors);
    bookShelf.appendChild(book);

    return toString(doc);
  }

  public static String addBookToJSON(String jsonData, String title, int year, int pages, String[] authors) {
    JSONObject jsonObject = new JSONObject(jsonData);
    JSONArray bookShelf = jsonObject.getJSONArray("BookShelf");

    JSONObject newBook = new JSONObject();
    newBook.put("title", title);
    newBook.put("publishedYear", year);
    newBook.put("numberOfPages", pages);
    newBook.put("authors", new JSONArray(authors));

    bookShelf.put(newBook);
    jsonObject.put("BookShelf", bookShelf);

    return jsonObject.toString();
  }

  public static void parseAndPrintJSON(String jsonData) {
    JSONObject jsonObject = new JSONObject(jsonData);
    JSONArray bookShelf = jsonObject.getJSONArray("BookShelf");
    System.out.println("JSON Data:");
    for (int i = 0; i < bookShelf.length(); i++) {
      JSONObject book = bookShelf.getJSONObject(i);
      String title = book.getString("title");
      int year = book.getInt("publishedYear");
      int pages = book.getInt("numberOfPages");
      JSONArray authors = book.getJSONArray("authors");
      System.out.printf("Book: %s, Year: %d, Pages: %d, Authors: %s%n", title, year, pages,
          authors.toList());
    }
  }

  public static String toString(Document doc) throws Exception {
    javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
    javax.xml.transform.Transformer transformer = tf.newTransformer();
    javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
    java.io.StringWriter writer = new java.io.StringWriter();
    javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(writer);
    transformer.transform(source, result);
    return writer.toString();
  }
}

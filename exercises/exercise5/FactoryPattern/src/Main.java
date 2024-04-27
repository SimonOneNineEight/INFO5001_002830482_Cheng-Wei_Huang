public class Main {
    public static void main(String[] args) {
        AbstractDocument document = DocumentFactory.createDocument("text");
        document.open();
        document.save();
        document.close();
    }
}
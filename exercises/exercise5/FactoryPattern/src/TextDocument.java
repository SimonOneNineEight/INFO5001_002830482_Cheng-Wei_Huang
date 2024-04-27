class TextDocument extends AbstractDocument {
    public void open() {
        System.out.println("TextDocument: Open");
    }
    public void save() {
        System.out.println("TextDocument: Save");
    }
    public void close() {
        System.out.println("TextDocument: Close");
    }
}
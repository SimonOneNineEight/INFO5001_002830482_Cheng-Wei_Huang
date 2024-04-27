class SpreadsheetDocument extends AbstractDocument {
    public void open() {
        System.out.println("SpreadsheetDocument: Open");
    }
    public void save() {
        System.out.println("SpreadsheetDocument: Save");
    }
    public void close() {
        System.out.println("SpreadsheetDocument: Close");
    }
}

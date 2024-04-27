class DocumentFactory {
    public static AbstractDocument createDocument(String type) {
        if ("text".equals(type)) {
            return new TextDocument();
        } else if ("spreadsheet".equals(type)) {
            return new SpreadsheetDocument();
        }
        throw new IllegalArgumentException("Unknown document type");
    }
}
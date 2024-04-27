public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager("save");
        eventManager.subscribe("save", (eventType, data) -> System.out.println(eventType + " event received with data: " + data));

        // Simulating event
        eventManager.notify("save", "Document saved successfully");
    }
}
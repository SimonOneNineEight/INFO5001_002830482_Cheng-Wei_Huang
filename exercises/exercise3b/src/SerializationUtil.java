import java.io.*;

public class SerializationUtil {

    // Method to serialize an object to a file
    public static void writeObject(Serializable obj, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        }
    }

    // Method to deserialize an object from a file
    public static Object readObject(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        }
    }
}

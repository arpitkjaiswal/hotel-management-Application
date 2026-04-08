import java.io.*;

class FileHandler {

    public static void saveRooms(java.util.ArrayList<Room> rooms) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rooms.dat"))) {
            oos.writeObject(rooms);
        } catch (Exception e) {
            System.out.println("Error saving rooms");
        }
    }

    public static java.util.ArrayList<Room> loadRooms() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rooms.dat"))) {
            return (java.util.ArrayList<Room>) ois.readObject();
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}

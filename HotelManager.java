import java.util.*;
import javafx.collections.*;

public class HotelManager {

    private ObservableList<Room> rooms = FXCollections.observableArrayList();
    private HashMap<Integer, Customer> customers = new HashMap<>();

    public ObservableList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(int n, String t, double p) {
        rooms.add(new Room(n, t, p));
    }

    public String bookRoom(int num, String name, String phone) {
        for (Room r : rooms) {
            if (r.getNumber() == num) {
                if (!r.isBooked()) {
                    r.setBooked(true);
                    customers.put(num, new Customer(name, phone, num));
                    return "Booking Successful!";
                }
                return "Room already booked!";
            }
        }
        return "Room not found!";
    }

    public String checkout(int num) {
        for (Room r : rooms) {
            if (r.getNumber() == num && r.isBooked()) {
                r.setBooked(false);
                customers.remove(num);
                return "Checkout Successful!";
            }
        }
        return "Invalid room!";
    }
}

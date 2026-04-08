import javafx.beans.property.*;

public class Room {

    private IntegerProperty number;
    private StringProperty type;
    private DoubleProperty price;
    private BooleanProperty booked;

    public Room(int number, String type, double price) {
        this.number = new SimpleIntegerProperty(number);
        this.type = new SimpleStringProperty(type);
        this.price = new SimpleDoubleProperty(price);
        this.booked = new SimpleBooleanProperty(false);
    }

    public int getNumber() { return number.get(); }
    public String getType() { return type.get(); }
    public double getPrice() { return price.get(); }
    public boolean isBooked() { return booked.get(); }

    public void setBooked(boolean value) { booked.set(value); }

    public IntegerProperty numberProperty() { return number; }
    public StringProperty typeProperty() { return type; }
    public DoubleProperty priceProperty() { return price; }
    public BooleanProperty bookedProperty() { return booked; }
}

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    HotelManager hm = new HotelManager();

    @Override
    public void start(Stage stage) {

        TextField roomNo = new TextField();
        roomNo.setPromptText("Room Number");

        TextField price = new TextField();
        price.setPromptText("Price");

        ComboBox<String> type = new ComboBox<>();
        type.getItems().addAll("Single", "Double", "Deluxe");

        TextField name = new TextField();
        name.setPromptText("Customer Name");

        TextField phone = new TextField();
        phone.setPromptText("Phone");

        Label status = new Label();

        TableView<Room> table = new TableView<>();

        TableColumn<Room, Number> c1 = new TableColumn<>("Room");
        c1.setCellValueFactory(d -> d.getValue().numberProperty());

        TableColumn<Room, String> c2 = new TableColumn<>("Type");
        c2.setCellValueFactory(d -> d.getValue().typeProperty());

        TableColumn<Room, Number> c3 = new TableColumn<>("Price");
        c3.setCellValueFactory(d -> d.getValue().priceProperty());

        TableColumn<Room, Boolean> c4 = new TableColumn<>("Booked");
        c4.setCellValueFactory(d -> d.getValue().bookedProperty());

        table.getColumns().addAll(c1, c2, c3, c4);
        table.setItems(hm.getRooms());

        Button add = new Button("Add Room");
        Button book = new Button("Book Room");
        Button checkout = new Button("Checkout");

        add.setOnAction(e -> {
            hm.addRoom(
                Integer.parseInt(roomNo.getText()),
                type.getValue(),
                Double.parseDouble(price.getText())
            );
            status.setText("Room Added");
        });

        book.setOnAction(e -> {
            status.setText(hm.bookRoom(
                Integer.parseInt(roomNo.getText()),
                name.getText(),
                phone.getText()
            ));
        });

        checkout.setOnAction(e -> {
            status.setText(hm.checkout(Integer.parseInt(roomNo.getText())));
        });

        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(10);

        form.add(new Label("Room No:"), 0, 0);
        form.add(roomNo, 1, 0);
        form.add(new Label("Type:"), 0, 1);
        form.add(type, 1, 1);
        form.add(new Label("Price:"), 0, 2);
        form.add(price, 1, 2);
        form.add(new Label("Name:"), 0, 3);
        form.add(name, 1, 3);
        form.add(new Label("Phone:"), 0, 4);
        form.add(phone, 1, 4);

        HBox buttons = new HBox(10, add, book, checkout);

        VBox root = new VBox(15, form, buttons, table, status);
        root.setStyle("-fx-padding:20;");

        Scene scene = new Scene(root, 650, 500);

        stage.setTitle("Hotel Management Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

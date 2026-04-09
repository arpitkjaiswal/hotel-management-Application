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
        status.setStyle("-fx-font-weight: bold;");

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

        // Table click → auto fill room number
        table.setOnMouseClicked(e -> {
            Room selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                roomNo.setText(String.valueOf(selected.getNumber()));
            }
        });

        Button add = new Button("Add Room");
        Button book = new Button("Book Room");
        Button checkout = new Button("Checkout");
        Button available = new Button("Show Available");
        Button showAll = new Button("Show All");

        add.setOnAction(e -> {
            if (roomNo.getText().isEmpty() || price.getText().isEmpty() || type.getValue() == null) {
                status.setText("Fill all room details!");
                return;
            }

            hm.addRoom(
                Integer.parseInt(roomNo.getText()),
                type.getValue(),
                Double.parseDouble(price.getText())
            );

            table.setItems(hm.getRooms());
            status.setText("Room Added Successfully!");

            roomNo.clear();
            price.clear();
            type.setValue(null);
        });

        book.setOnAction(e -> {

            if (roomNo.getText().isEmpty()) {
                status.setText("Select a room from table!");
                return;
            }

            if (name.getText().isEmpty() || phone.getText().isEmpty()) {
                status.setText("Enter customer details!");
                return;
            }

            String result = hm.bookRoom(
                Integer.parseInt(roomNo.getText()),
                name.getText(),
                phone.getText()
            );

            status.setText(result);
            table.refresh();

            name.clear();
            phone.clear();
        });

        checkout.setOnAction(e -> {

            if (roomNo.getText().isEmpty()) {
                status.setText("Select a room first!");
                return;
            }

            String result = hm.checkout(Integer.parseInt(roomNo.getText()));

            status.setText(result);
            table.refresh();
        });

        available.setOnAction(e -> {
            table.setItems(hm.getRooms().filtered(r -> !r.isBooked()));
            status.setText("Showing available rooms");
        });

        showAll.setOnAction(e -> {
            table.setItems(hm.getRooms());
            status.setText("Showing all rooms");
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

        HBox buttons = new HBox(10, add, book, checkout, available, showAll);

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

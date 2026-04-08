# 🏨 Hotel Management Application

A **Java-based Hotel Management System** with a graphical user interface built using **JavaFX**.
This application allows users to manage hotel rooms, handle bookings, and perform checkout operations efficiently.

---

## 🚀 Features

* ➕ Add new rooms with details (Room No, Type, Price)
* 📋 View all rooms in a dynamic table
* 🛏️ Book rooms for customers
* 🔓 Checkout and free rooms
* 👤 Manage customer booking data
* 📊 Real-time updates using JavaFX TableView
* 🖥️ Interactive GUI (JavaFX)

---

## 🛠️ Technologies Used

* **Java**
* **JavaFX**
* **Collections Framework**

  * `ArrayList` / `ObservableList`
  * `HashMap`
* **OOP Concepts**

  * Encapsulation
  * Modular Design

---

## 📂 Project Structure

```
HotelManagementApp/
│
├── Room.java
├── Customer.java
├── HotelManager.java
├── Main.java
│
├── README.md
├── .gitignore
```

---

## ⚙️ Setup Instructions

### 1. Download JavaFX SDK

Download from: https://openjfx.io/

---

### 2. Compile the Project

```bash
javac --module-path /Users/arpitkumarjaiswal/Downloads/javafx-sdk-26/lib \
--add-modules javafx.controls,javafx.fxml *.java
```

---

### 3. Run the Application

```bash
java --module-path /Users/arpitkumarjaiswal/Downloads/javafx-sdk-26/lib \
--add-modules javafx.controls,javafx.fxml Main
```

---

## 🧪 Usage

1. Enter room details and click **Add Room**
2. Select room and enter customer details
3. Click **Book Room**
4. Use **Checkout** to free a room
5. View updates in the table

---

## 🧠 Concepts Demonstrated

* JavaFX GUI Development
* Event Handling
* Data Binding using `ObservableList`
* Object-Oriented Programming
* Real-time UI updates

---

## ⚠️ Notes

* Requires Java 11 or higher
* JavaFX must be properly configured using `--module-path`
* Warning related to native access may appear (safe to ignore)

---

## 👨‍💻 Author

* Arpit Kumar Jaiswal

---

## ⭐ Acknowledgement

Developed as part of a **Hotel Management System Lab Project** to demonstrate integration of backend logic with GUI using JavaFX.

---

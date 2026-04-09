# 🏨 Hotel Management Application

A **JavaFX-based Hotel Management System** designed to automate and simplify basic hotel operations.
This application provides an interactive and user-friendly interface for managing rooms, customers, bookings, and checkouts.

---

## 🚀 Features

### 🛏️ Room Management

* Add new rooms with:

  * Room Number
  * Room Type (Single, Double, Deluxe)
  * Price per Day
* View all rooms in a dynamic table
* Filter and display only available rooms

---

### 👤 Customer Management

* Enter customer details:

  * Name
  * Contact Number
  * Room Number (auto-filled via table selection)
* Seamless booking experience using GUI

---

### 🔄 Booking & Checkout

* Book rooms with a single click
* Prevent double booking of occupied rooms
* Checkout rooms and update availability instantly

---

### 🖥️ GUI Features

* Built using **JavaFX**
* Uses components:

  * Label, TextField, Button, ComboBox, TableView
* Layouts:

  * GridPane (forms)
  * VBox / HBox (structure)
* Real-time updates using `ObservableList`
* Table row selection for better user experience

---

## 🧠 Concepts Used

* Object-Oriented Programming (OOP)
* Java Collections (`ObservableList`, `HashMap`)
* Event Handling
* Data Binding (JavaFX Properties)
* Modular Code Design

---

## 📂 Project Structure

```text
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

1. Add room details and click **Add Room**
2. Select a room from the table (auto-fills room number)
3. Enter customer details and click **Book Room**
4. Use **Checkout** to release a room
5. Use **Show Available** to filter available rooms
6. Use **Show All** to reset the view

---

## ⚠️ Notes

* Requires Java 11 or higher
* JavaFX must be configured using `--module-path`
* Some runtime warnings related to native access may appear (safe to ignore)

---

## 👨‍💻 Author

**Arpit Kumar Jaiswal**

---

## ⭐ Acknowledgement

Developed as part of a **Hotel Management System Lab Project**, demonstrating integration of backend logic with a JavaFX-based graphical interface.

---

---

🏨 **LuxeStay Hotel Reservation System**

LuxeStay is a Java-based Hotel Reservation System developed using "Java Swing" and "Apache NetBeans". The system provides a user-friendly graphical interface for managing hotel rooms, customers, bookings, reservations, cancellations, and hotel information.

 ✨ **Features**
 
- 🏠 Modern and attractive hotel management GUI
- 🛏️ View available hotel rooms
- 🔎 Search rooms by category
- 👤 Manage customer information
- 📅 Make hotel reservations
- 💳 Select payment method
- 📋 View reservation details
- ❌ Cancel reservations
- 📊 Admin dashboard
- 📈 Display hotel statistics
- 💾 File-based data storage
- 🎨 Custom hotel graphics using Java2D
- 🖥️ Desktop application built with Java Swing

🏗️ **Room Categories**

The system supports different types of rooms:
- Standard Room
- Deluxe Room
- Suite

Each room contains information such as:
- Room number
- Room category
- Room price
- Availability status

🖥️ **Graphical User Interface**

The application uses a modern luxury-hotel inspired interface with:
- Forest green theme
- Cream and beige backgrounds
- Gold accents
- Rounded cards and buttons
- Hotel-style dashboard
- Custom Java2D graphics
- Room and hotel visual elements
- 
The GUI graphics are created directly using Java code, so external images are not required for the main interface.

 📋 **Main Modules**

Main.java:
Starts the application and initializes the hotel system and graphical user interface.

HotelGUI.java:
Contains the complete graphical user interface of the Hotel Reservation System, including the home page, rooms, booking, reservations, and admin dashboard.

Hotel.java:
Manages hotel operations such as rooms, bookings, reservations, cancellations, and hotel statistics.

Room.java:
Represents individual hotel rooms and manages their room number, category, price, and availability.

Customer.java:
Stores customer information such as name, phone number, and email.

Reservation.java:
Stores reservation information and handles reservation details, number of nights, payment method, and total amount.

FileManager.java:
Handles local file operations and stores hotel data in text files.

💾 **Data Storage**

The application uses local text files for storing data.

```text
data/
├── rooms.txt
└── reservations.txt

The room information is loaded from the room data file, while reservation information is stored separately.

🛠️**Technologies Used**

Programming Language: Java
GUI Framework: Java Swing
Graphics: Java2D / Graphics2D
IDE: Apache NetBeans
Data Storage: Text Files
Version Control: Git & GitHub

▶️How to Run

Requirements:
-Java JDK
-Apache NetBeans IDE

Steps:
Clone this repository.
Open the project in Apache NetBeans.
Make sure all Java files are inside the correct package.
Build the project.
Run Main.java.
The LuxeStay Hotel Reservation System GUI will open.

📁 Project Structure

Hotel-Reservation-System/
│
├── src/
│   └── hotelreservation/
│       ├── Main.java
│       ├── HotelGUI.java
│       ├── Hotel.java
│       ├── Room.java
│       ├── Customer.java
│       ├── Reservation.java
│       └── FileManager.java
│
├── data/
│   ├── rooms.txt
│   └── reservations.txt
│
└── README.md

🎯 Project Objective

The main objective of this project is to develop a simple and efficient hotel reservation system using Java and Object-Oriented Programming concepts.

The project demonstrates:
-Object-Oriented Programming
-Classes and Objects
-Encapsulation
-ArrayLists and Collections
-File Handling
-GUI Development
-Event Handling
-Room Management
-Customer Management
-Reservation Management

🚀 Future Enhancements

The system can be further improved by adding:
-MySQL database integration
-User login and authentication
-Online payment system
-Check-in and check-out management
-Date-based room availability
-PDF reservation receipts
-Advanced reporting
-Email confirmation
-Multi-user support

👩‍💻 Project Type

Internship Project

⭐ LuxeStay

Experience Comfort, Luxury & Unforgettable Moments.

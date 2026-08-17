package hotelreservation;

public class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    public Room(int roomNumber, String category, double price, boolean available) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getStatus() {
        return available ? "Available" : "Booked";
    }

    @Override
    public String toString() {
        return "Room " + roomNumber +
                " | " + category +
                " | Rs. " + String.format("%.0f", price) +
                " | " + getStatus();
    }
}
package hotelreservation;

import java.time.LocalDate;

public class Reservation {

    private String reservationId;
    private Customer customer;
    private Room room;
    private int nights;
    private double totalAmount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate bookingDate;

    public Reservation(String reservationId,
                       Customer customer,
                       Room room,
                       int nights,
                       String paymentMethod) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.nights = nights;
        this.totalAmount = room.getPrice() * nights;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Paid";
        this.bookingDate = LocalDate.now();
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getDetails() {

        return "RESERVATION DETAILS\n"
                + "---------------------------------\n"
                + "Reservation ID : " + reservationId + "\n"
                + "Booking Date   : " + bookingDate + "\n"
                + "Guest Name     : " + customer.getName() + "\n"
                + "Phone          : " + customer.getPhone() + "\n"
                + "Email          : " + customer.getEmail() + "\n"
                + "Room Number    : " + room.getRoomNumber() + "\n"
                + "Room Category  : " + room.getCategory() + "\n"
                + "Price/Night    : Rs. " + String.format("%.0f", room.getPrice()) + "\n"
                + "Nights         : " + nights + "\n"
                + "Total Amount   : Rs. " + String.format("%.0f", totalAmount) + "\n"
                + "Payment Method : " + paymentMethod + "\n"
                + "Payment Status : " + paymentStatus + "\n"
                + "---------------------------------";
    }

    public String toFileString() {

        return reservationId + "|"
                + customer.getName() + "|"
                + customer.getPhone() + "|"
                + customer.getEmail() + "|"
                + room.getRoomNumber() + "|"
                + room.getCategory() + "|"
                + room.getPrice() + "|"
                + nights + "|"
                + totalAmount + "|"
                + paymentMethod + "|"
                + paymentStatus + "|"
                + bookingDate;
    }
}
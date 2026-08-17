package hotelreservation;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {

        FileManager.initializeFiles();

        rooms = new ArrayList<>(
                FileManager.loadRooms()
        );

        reservations = new ArrayList<>();
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Room> searchRooms(String category) {

        List<Room> result = new ArrayList<>();

        for (Room room : rooms) {

            if (category.equalsIgnoreCase("All")
                    || room.getCategory().equalsIgnoreCase(category)) {

                result.add(room);
            }
        }

        return result;
    }

    public List<Room> getAvailableRooms(String category) {

        List<Room> result = new ArrayList<>();

        for (Room room : rooms) {

            boolean categoryMatches =
                    category.equalsIgnoreCase("All")
                    || room.getCategory().equalsIgnoreCase(category);

            if (categoryMatches && room.isAvailable()) {
                result.add(room);
            }
        }

        return result;
    }

    public Reservation bookRoom(
            Room room,
            String name,
            String phone,
            String email,
            int nights,
            String paymentMethod) {

        if (!room.isAvailable()) {
            return null;
        }

        Customer customer =
                new Customer(name, phone, email);

        String reservationId =
                generateReservationId();

        Reservation reservation =
                new Reservation(
                        reservationId,
                        customer,
                        room,
                        nights,
                        paymentMethod
                );

        room.setAvailable(false);

        reservations.add(reservation);

        FileManager.saveRooms(rooms);
        FileManager.saveReservation(reservation);

        return reservation;
    }

    public boolean cancelReservation(String reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId()
                    .equalsIgnoreCase(reservationId)) {

                reservation.getRoom().setAvailable(true);

                FileManager.saveRooms(rooms);

                reservations.remove(reservation);

                return true;
            }
        }

        return false;
    }

    public Reservation findReservation(String reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId()
                    .equalsIgnoreCase(reservationId)) {

                return reservation;
            }
        }

        return null;
    }

    private String generateReservationId() {

        return "RES-" +
                String.format(
                        "%04d",
                        reservations.size() + 1
                );
    }

    public int getTotalRooms() {
        return rooms.size();
    }

    public int getAvailableRoomsCount() {

        int count = 0;

        for (Room room : rooms) {

            if (room.isAvailable()) {
                count++;
            }
        }

        return count;
    }

    public int getBookedRoomsCount() {

        return getTotalRooms()
                - getAvailableRoomsCount();
    }
}
package hotelreservation;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Hotel hotel = new Hotel();
            new HotelGUI(hotel).setVisible(true);
        });
    }
}
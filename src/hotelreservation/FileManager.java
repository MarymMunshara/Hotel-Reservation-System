package hotelreservation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String DATA_FOLDER = "data";
    private static final String ROOMS_FILE = DATA_FOLDER + File.separator + "rooms.txt";
    private static final String RESERVATIONS_FILE =
            DATA_FOLDER + File.separator + "reservations.txt";

    public static void initializeFiles() {

        File folder = new File(DATA_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File roomsFile = new File(ROOMS_FILE);

        if (!roomsFile.exists()) {

            try (PrintWriter writer = new PrintWriter(
                    new FileWriter(ROOMS_FILE))) {

                writer.println("101|Standard|5000|true");
                writer.println("102|Standard|5000|true");
                writer.println("103|Standard|5000|true");

                writer.println("201|Deluxe|8000|true");
                writer.println("202|Deluxe|8000|true");
                writer.println("203|Deluxe|8000|true");

                writer.println("301|Suite|12000|true");
                writer.println("302|Suite|12000|true");

            } catch (IOException e) {
                System.out.println("Error creating rooms file: " + e.getMessage());
            }
        }

        File reservationsFile = new File(RESERVATIONS_FILE);

        if (!reservationsFile.exists()) {

            try {
                reservationsFile.createNewFile();
            } catch (IOException e) {
                System.out.println(
                        "Error creating reservations file: "
                        + e.getMessage());
            }
        }
    }

    public static List<Room> loadRooms() {

        List<Room> rooms = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(ROOMS_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\|");

                if (parts.length >= 4) {

                    int number = Integer.parseInt(parts[0]);
                    String category = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    boolean available = Boolean.parseBoolean(parts[3]);

                    rooms.add(
                            new Room(
                                    number,
                                    category,
                                    price,
                                    available
                            )
                    );
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading rooms: " + e.getMessage());
        }

        return rooms;
    }

    public static void saveRooms(List<Room> rooms) {

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(ROOMS_FILE))) {

            for (Room room : rooms) {

                writer.println(
                        room.getRoomNumber()
                        + "|" + room.getCategory()
                        + "|" + room.getPrice()
                        + "|" + room.isAvailable()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving rooms: " + e.getMessage());
        }
    }

    public static void saveReservation(Reservation reservation) {

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(
                                     RESERVATIONS_FILE,
                                     true))) {

            writer.println(reservation.toFileString());

        } catch (IOException e) {

            System.out.println(
                    "Error saving reservation: "
                    + e.getMessage());
        }
    }

    public static List<String> loadReservationLines() {

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(RESERVATIONS_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading reservations: "
                    + e.getMessage());
        }

        return lines;
    }
}
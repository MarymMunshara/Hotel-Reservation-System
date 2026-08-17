package hotelreservation;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class HotelGUI extends JFrame {

    private final Hotel hotel;
    private JPanel contentPanel;

    // ===================== PREMIUM PALETTE =====================
    private final Color BG       = new Color(246, 241, 232);
    private final Color CARD     = new Color(255, 253, 248);
    private final Color PAPER    = new Color(251, 247, 239);
    private final Color GREEN    = new Color(43, 65, 56);
    private final Color DARK     = new Color(27, 45, 39);
    private final Color SAGE     = new Color(151, 170, 153);
    private final Color ROSE     = new Color(198, 157, 151);
    private final Color GOLD     = new Color(194, 160, 103);
    private final Color TEXT     = new Color(62, 54, 47);
    private final Color MUTED    = new Color(135, 122, 109);
    private final Color BORDER   = new Color(224, 214, 201);
    private final Color GREEN_BG = new Color(226, 235, 226);
    private final Color ROSE_BG  = new Color(241, 224, 220);

    public HotelGUI(Hotel hotel) {
        this.hotel = hotel;

        setTitle("Aurelia House | Hotel Reservation System");
        setSize(1240, 760);
        setMinimumSize(new Dimension(1050, 650));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createInterface();
        showHome();
    }

    private void createInterface() {
        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG);

        root.add(createTopBar(), BorderLayout.NORTH);
        root.add(createSideBar(), BorderLayout.WEST);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BG);
        contentPanel.setBorder(new EmptyBorder(26, 30, 26, 30));

        root.add(contentPanel, BorderLayout.CENTER);
        setContentPane(root);
    }

    // ===================== TOP BAR =====================

    private JPanel createTopBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(CARD);
        bar.setPreferredSize(new Dimension(0, 84));
        bar.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, BORDER),
                new EmptyBorder(12, 28, 12, 28)
        ));

        JPanel brand = new JPanel();
        brand.setOpaque(false);
        brand.setLayout(new BoxLayout(brand, BoxLayout.Y_AXIS));

        JLabel logo = label("AURELIA HOUSE", DARK, 25, Font.BOLD, "Serif");
        JLabel sub = label("BOUTIQUE HOTEL  •  EST. 2026", GOLD, 8, Font.BOLD, "SansSerif");

        brand.add(logo);
        brand.add(Box.createVerticalStrut(2));
        brand.add(sub);

        bar.add(brand, BorderLayout.WEST);

        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 10));
        right.setOpaque(false);

        JLabel phrase = label("A slower stay. A softer life.", MUTED, 13, Font.ITALIC, "Serif");
        JLabel star = label("✦", GOLD, 19, Font.BOLD, "Serif");

        right.add(phrase);
        right.add(star);
        bar.add(right, BorderLayout.EAST);

        return bar;
    }

    // ===================== SIDEBAR =====================

    private JPanel createSideBar() {
        JPanel side = new JPanel();
        side.setBackground(DARK);
        side.setPreferredSize(new Dimension(220, 0));
        side.setBorder(new EmptyBorder(28, 15, 22, 15));
        side.setLayout(new BoxLayout(side, BoxLayout.Y_AXIS));

        JLabel menu = label("EXPLORE", new Color(226, 207, 168), 9, Font.BOLD, "SansSerif");
        menu.setBorder(new EmptyBorder(0, 13, 12, 0));
        side.add(menu);

        JButton home = sideButton("⌂", "Home");
        JButton rooms = sideButton("◇", "Our Rooms");
        JButton reserve = sideButton("✦", "Make Reservation");
        JButton bookings = sideButton("▤", "My Reservations");
        JButton cancel = sideButton("×", "Cancel Booking");

        home.addActionListener(e -> showHome());
        rooms.addActionListener(e -> showRooms());
        reserve.addActionListener(e -> showBookingForm());
        bookings.addActionListener(e -> showReservations());
        cancel.addActionListener(e -> showCancel());

        addNav(side, home);
        addNav(side, rooms);
        addNav(side, reserve);
        addNav(side, bookings);
        addNav(side, cancel);

        side.add(Box.createVerticalGlue());

        JLabel line = label("────────────────", new Color(91, 114, 102), 10, Font.PLAIN, "Serif");
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        side.add(line);
        side.add(Box.createVerticalStrut(12));

        JLabel q1 = label("STAY SLOW.", new Color(226, 207, 168), 13, Font.BOLD, "Serif");
        JLabel q2 = label("STAY BEAUTIFUL.", new Color(200, 214, 204), 12, Font.PLAIN, "Serif");
        q1.setAlignmentX(Component.CENTER_ALIGNMENT);
        q2.setAlignmentX(Component.CENTER_ALIGNMENT);
        side.add(q1);
        side.add(Box.createVerticalStrut(3));
        side.add(q2);

        side.add(Box.createVerticalStrut(22));

        JButton exit = sideButton("⇥", "Exit");
        exit.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to leave Aurelia House?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (answer == JOptionPane.YES_OPTION) System.exit(0);
        });
        side.add(exit);

        return side;
    }

    private void addNav(JPanel side, JButton button) {
        side.add(button);
        side.add(Box.createVerticalStrut(5));
    }

    private JButton sideButton(String icon, String text) {
        JButton button = new JButton();
        button.setLayout(new BorderLayout());
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 48));
        button.setPreferredSize(new Dimension(190, 48));
        button.setBackground(DARK);
        button.setBorder(new EmptyBorder(5, 10, 5, 10));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel i = label(icon, new Color(226, 207, 168), 19, Font.PLAIN, "Serif");
        JLabel t = label(text, new Color(225, 232, 226), 11, Font.PLAIN, "SansSerif");

        JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        left.setOpaque(false);
        left.add(i);
        left.add(t);
        button.add(left, BorderLayout.WEST);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(GREEN);
                t.setForeground(new Color(235, 216, 173));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(DARK);
                t.setForeground(new Color(225, 232, 226));
            }
        });

        return button;
    }

    // ===================== HOME =====================

    private void showHome() {
        contentPanel.removeAll();

        JPanel page = new JPanel();
        page.setBackground(BG);
        page.setLayout(new BoxLayout(page, BoxLayout.Y_AXIS));

        JPanel hero = new JPanel(new BorderLayout(20, 0));
        hero.setBackground(new Color(233, 225, 214));
        hero.setBorder(new EmptyBorder(36, 40, 36, 30));
        hero.setPreferredSize(new Dimension(0, 215));

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel eyebrow = label("WELCOME TO AURELIA", GOLD, 9, Font.BOLD, "SansSerif");
        JLabel heading = label("<html>Your little escape<br><i>from the ordinary.</i></html>",
                TEXT, 37, Font.BOLD, "Serif");
        JLabel desc = label("<html>Thoughtfully designed rooms, warm hospitality,<br>" +
                "and quiet moments waiting just for you.</html>",
                new Color(103, 90, 79), 11, Font.PLAIN, "SansSerif");

        JButton explore = primaryButton("EXPLORE ROOMS   →");
        explore.addActionListener(e -> showRooms());

        left.add(eyebrow);
        left.add(Box.createVerticalStrut(9));
        left.add(heading);
        left.add(Box.createVerticalStrut(10));
        left.add(desc);
        left.add(Box.createVerticalStrut(20));
        left.add(explore);

        hero.add(left, BorderLayout.CENTER);
        hero.add(createHeroArt(), BorderLayout.EAST);

        page.add(hero);
        page.add(Box.createVerticalStrut(18));

        JPanel stats = new JPanel(new GridLayout(1, 3, 14, 0));
        stats.setOpaque(false);
        stats.add(statCard("TOTAL ROOMS", String.valueOf(hotel.getTotalRooms()),
                "Beautiful spaces", GOLD));
        stats.add(statCard("AVAILABLE", String.valueOf(hotel.getAvailableRoomsCount()),
                "Ready for your stay", SAGE));
        stats.add(statCard("RESERVED", String.valueOf(hotel.getBookedRoomsCount()),
                "Currently occupied", ROSE));

        page.add(stats);
        page.add(Box.createVerticalStrut(22));

        JPanel titleRow = new JPanel(new BorderLayout());
        titleRow.setOpaque(false);
        titleRow.add(label("Rooms with a little more soul.", TEXT, 24, Font.BOLD, "Serif"),
                BorderLayout.WEST);
        titleRow.add(label("CHOOSE YOUR SPACE", MUTED, 8, Font.BOLD, "SansSerif"),
                BorderLayout.EAST);

        page.add(titleRow);
        page.add(Box.createVerticalStrut(12));

        JPanel categories = new JPanel(new GridLayout(1, 3, 14, 0));
        categories.setOpaque(false);
        categories.add(categoryCard("01", "STANDARD", "Calm & comfortable", "Rs. 2,500", SAGE));
        categories.add(categoryCard("02", "DELUXE", "Soft & sophisticated", "Rs. 4,000", ROSE));
        categories.add(categoryCard("03", "SUITE", "Spacious & serene", "Rs. 6,000", GREEN));
        page.add(categories);

        JScrollPane scroll = new JScrollPane(page);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(15);

        contentPanel.add(scroll, BorderLayout.CENTER);
        refresh();
    }

    private JPanel createHeroArt() {
        JPanel art = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(198, 157, 151, 100));
                g2.fillOval(72, 5, 145, 145);

                g2.setColor(new Color(151, 170, 153, 130));
                g2.fillOval(15, 95, 82, 82);

                g2.setColor(GOLD);
                g2.setStroke(new BasicStroke(1.4f));
                g2.drawOval(42, 25, 165, 165);

                g2.setColor(new Color(255, 253, 248, 180));
                g2.fillOval(99, 78, 50, 50);

                g2.setColor(GOLD);
                g2.setFont(new Font("Serif", Font.PLAIN, 40));
                g2.drawString("✦", 116, 115);
            }
        };
        art.setOpaque(false);
        art.setPreferredSize(new Dimension(245, 190));
        return art;
    }

    private JPanel statCard(String title, String number, String description, Color accent) {
        JPanel card = new JPanel(new BorderLayout(12, 0));
        card.setBackground(CARD);
        card.setBorder(new CompoundBorder(new LineBorder(BORDER),
                new EmptyBorder(15, 17, 15, 17)));

        JPanel mark = new JPanel();
        mark.setBackground(accent);
        mark.setPreferredSize(new Dimension(4, 48));

        JPanel text = new JPanel();
        text.setOpaque(false);
        text.setLayout(new BoxLayout(text, BoxLayout.Y_AXIS));

        text.add(label(title, MUTED, 8, Font.BOLD, "SansSerif"));
        text.add(Box.createVerticalStrut(4));
        text.add(label(description, MUTED, 9, Font.PLAIN, "SansSerif"));

        JLabel n = label(number, accent, 27, Font.BOLD, "Serif");

        card.add(mark, BorderLayout.WEST);
        card.add(text, BorderLayout.CENTER);
        card.add(n, BorderLayout.EAST);
        return card;
    }

    private JPanel categoryCard(String number, String title, String subtitle,
                                String price, Color accent) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(CARD);
        card.setBorder(new LineBorder(BORDER));

        JPanel visual = new JPanel(new BorderLayout());
        visual.setBackground(accent);
        visual.setPreferredSize(new Dimension(0, 105));

        JLabel num = label(number, new Color(255, 255, 255, 100), 43, Font.BOLD, "Serif");
        num.setBorder(new EmptyBorder(10, 17, 0, 0));

        JLabel star = label("✦", new Color(255, 255, 255, 200), 25, Font.PLAIN, "Serif");
        star.setBorder(new EmptyBorder(0, 0, 0, 17));

        visual.add(num, BorderLayout.WEST);
        visual.add(star, BorderLayout.EAST);

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setBorder(new EmptyBorder(14, 17, 14, 17));
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        info.add(label(title, DARK, 19, Font.BOLD, "Serif"));
        info.add(Box.createVerticalStrut(3));
        info.add(label(subtitle, MUTED, 9, Font.PLAIN, "SansSerif"));
        info.add(Box.createVerticalStrut(8));
        info.add(label(price + " / night", GOLD, 13, Font.BOLD, "Serif"));

        JButton view = textButton("VIEW ROOMS   →");
        view.addActionListener(e -> showRooms());
        info.add(view);

        card.add(visual, BorderLayout.NORTH);
        card.add(info, BorderLayout.CENTER);
        return card;
    }

    // ===================== ROOMS =====================

    private void showRooms() {
        contentPanel.removeAll();

        JPanel page = new JPanel(new BorderLayout(0, 18));
        page.setBackground(BG);

        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        JPanel heading = new JPanel();
        heading.setOpaque(false);
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.add(label("THE AURELIA COLLECTION", GOLD, 8, Font.BOLD, "SansSerif"));
        heading.add(Box.createVerticalStrut(4));
        heading.add(label("Find your room.", TEXT, 31, Font.BOLD, "Serif"));

        JComboBox<String> filter = new JComboBox<>(new String[]{
                "All Rooms", "Standard", "Deluxe", "Suite"
        });
        styleCombo(filter);
        filter.setPreferredSize(new Dimension(160, 38));

        header.add(heading, BorderLayout.WEST);
        header.add(filter, BorderLayout.EAST);
        page.add(header, BorderLayout.NORTH);

        JPanel grid = new JPanel(new GridLayout(0, 3, 14, 14));
        grid.setBackground(BG);

        JScrollPane scroll = new JScrollPane(grid);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(15);
        page.add(scroll, BorderLayout.CENTER);

        Runnable load = () -> {
            grid.removeAll();
            String selected = (String) filter.getSelectedItem();
            String category = "All".equals(selected) || "All Rooms".equals(selected)
                    ? "All" : selected;

            List<Room> rooms = hotel.searchRooms(category);
            for (Room room : rooms) grid.add(roomCard(room));

            grid.revalidate();
            grid.repaint();
        };

        filter.addActionListener(e -> load.run());
        load.run();

        contentPanel.add(page, BorderLayout.CENTER);
        refresh();
    }

    private JPanel roomCard(Room room) {
        Color accent = room.getCategory().equalsIgnoreCase("Deluxe") ? ROSE
                : room.getCategory().equalsIgnoreCase("Suite") ? GREEN : SAGE;

        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(CARD);
        card.setBorder(new CompoundBorder(new LineBorder(BORDER),
                new EmptyBorder(0, 0, 10, 0)));

        JPanel top = new JPanel(new BorderLayout());
        top.setBackground(accent);
        top.setPreferredSize(new Dimension(0, 125));

        JLabel category = label(room.getCategory().toUpperCase(), Color.WHITE, 20, Font.BOLD, "Serif");
        category.setBorder(new EmptyBorder(18, 19, 0, 0));

        JLabel number = label(String.valueOf(room.getRoomNumber()),
                new Color(255, 255, 255, 100), 43, Font.BOLD, "Serif");
        number.setBorder(new EmptyBorder(0, 0, 0, 18));

        top.add(category, BorderLayout.WEST);
        top.add(number, BorderLayout.EAST);

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setBorder(new EmptyBorder(14, 17, 10, 17));
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        info.add(label("ROOM " + room.getRoomNumber(), MUTED, 8, Font.BOLD, "SansSerif"));
        info.add(Box.createVerticalStrut(5));
        info.add(label(roomDescription(room.getCategory()), TEXT, 9, Font.PLAIN, "SansSerif"));
        info.add(Box.createVerticalStrut(10));
        info.add(label("Rs. " + String.format("%.0f", room.getPrice()) + " / night",
                GOLD, 18, Font.BOLD, "Serif"));
        info.add(Box.createVerticalStrut(7));

        JLabel status = label(room.isAvailable() ? "  AVAILABLE  " : "  BOOKED  ",
                room.isAvailable() ? GREEN : new Color(145, 80, 76),
                8, Font.BOLD, "SansSerif");
        status.setOpaque(true);
        status.setBackground(room.isAvailable() ? GREEN_BG : ROSE_BG);
        status.setBorder(new EmptyBorder(5, 7, 5, 7));
        status.setAlignmentX(Component.LEFT_ALIGNMENT);
        info.add(status);
        info.add(Box.createVerticalStrut(10));

        if (room.isAvailable()) {
            JButton reserve = primaryButton("RESERVE THIS ROOM");
            reserve.addActionListener(e -> showBookingForm(room));
            info.add(reserve);
        } else {
            info.add(label("This room is currently reserved.", MUTED, 9, Font.ITALIC, "SansSerif"));
        }

        card.add(top, BorderLayout.NORTH);
        card.add(info, BorderLayout.CENTER);
        return card;
    }

    private String roomDescription(String category) {
        if (category.equalsIgnoreCase("Standard"))
            return "Simple, calm and comfortable.";
        if (category.equalsIgnoreCase("Deluxe"))
            return "More space, softer details.";
        return "A spacious stay with refined comfort.";
    }

    // ===================== BOOKING =====================

    private void showBookingForm() {
        List<Room> available = hotel.getAvailableRooms("All");

        if (available.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "There are no rooms available right now.",
                    "No Availability", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // FIX: Let the guest choose a room instead of silently selecting room #1.
        showBookingForm(null);
    }

    private void showBookingForm(Room selectedRoom) {
        List<Room> available = hotel.getAvailableRooms("All");

        if (available.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "There are no rooms available right now.",
                    "No Availability", JOptionPane.WARNING_MESSAGE);
            return;
        }

        contentPanel.removeAll();

        JPanel page = new JPanel(new BorderLayout(18, 0));
        page.setBackground(BG);

        JPanel formCard = new JPanel(new GridBagLayout());
        formCard.setBackground(CARD);
        formCard.setBorder(new CompoundBorder(new LineBorder(BORDER),
                new EmptyBorder(25, 28, 25, 28)));

        GridBagConstraints g = new GridBagConstraints();
        g.gridx = 0;
        g.weightx = 1;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(3, 0, 3, 0);

        JLabel eyebrow = label("A BEAUTIFUL STAY STARTS HERE", GOLD, 8, Font.BOLD, "SansSerif");
        JLabel title = label("Make a reservation.", TEXT, 28, Font.BOLD, "Serif");

        g.gridy = 0;
        formCard.add(eyebrow, g);
        g.gridy = 1;
        formCard.add(title, g);

        JTextField name = inputField("Your full name");
        JTextField phone = inputField("Phone number");
        JTextField email = inputField("Email address");

        JComboBox<Room> roomBox = new JComboBox<>();
        for (Room room : available) roomBox.addItem(room);
        if (selectedRoom != null && available.contains(selectedRoom))
            roomBox.setSelectedItem(selectedRoom);
        styleCombo(roomBox);

        JSpinner nights = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        nights.setPreferredSize(new Dimension(0, 38));
        nights.setFont(new Font("SansSerif", Font.PLAIN, 11));

        JComboBox<String> payment = new JComboBox<>(new String[]{
                "Cash", "Credit / Debit Card", "Online Payment"
        });
        styleCombo(payment);

        addField(formCard, g, 2, "FULL NAME", name);
        addField(formCard, g, 3, "PHONE", phone);
        addField(formCard, g, 4, "EMAIL", email);
        addField(formCard, g, 5, "ROOM", roomBox);
        addField(formCard, g, 6, "NUMBER OF NIGHTS", nights);
        addField(formCard, g, 7, "PAYMENT METHOD", payment);

        JButton confirm = primaryButton("CONTINUE TO PAYMENT   →");
        g.gridy = 16;
        g.insets = new Insets(13, 0, 0, 0);
        formCard.add(confirm, g);

        JPanel summary = new JPanel(new BorderLayout());
        summary.setBackground(DARK);
        summary.setBorder(new EmptyBorder(30, 30, 30, 30));

        JPanel summaryText = new JPanel();
        summaryText.setOpaque(false);
        summaryText.setLayout(new BoxLayout(summaryText, BoxLayout.Y_AXIS));

        JLabel small = label("YOUR PRIVATE RETREAT", new Color(226, 207, 168), 8, Font.BOLD, "SansSerif");
        JLabel roomTitle = label("", Color.WHITE, 34, Font.BOLD, "Serif");
        JLabel roomNumber = label("", new Color(205, 216, 208), 9, Font.PLAIN, "SansSerif");
        JLabel line = label("────────────────", GOLD, 12, Font.PLAIN, "Serif");
        JLabel totalLabel = label("ESTIMATED TOTAL", new Color(226, 207, 168), 8, Font.BOLD, "SansSerif");
        JLabel total = label("", Color.WHITE, 31, Font.BOLD, "Serif");

        summaryText.add(small);
        summaryText.add(Box.createVerticalStrut(15));
        summaryText.add(roomTitle);
        summaryText.add(roomNumber);
        summaryText.add(Box.createVerticalStrut(18));
        summaryText.add(line);
        summaryText.add(Box.createVerticalStrut(20));
        summaryText.add(totalLabel);
        summaryText.add(Box.createVerticalStrut(5));
        summaryText.add(total);
        summaryText.add(Box.createVerticalStrut(25));

        JLabel features = label("<html>✓  Comfortable accommodation<br><br>" +
                "✓  Secure reservation<br><br>" +
                "✓  Payment simulation<br><br>" +
                "✓  Instant confirmation</html>",
                new Color(217, 226, 219), 10, Font.PLAIN, "SansSerif");
        summaryText.add(features);

        summary.add(summaryText, BorderLayout.CENTER);

        Runnable updateTotal = () -> {
            Room room = (Room) roomBox.getSelectedItem();
            if (room == null) return;

            int n = (Integer) nights.getValue();
            total.setText("Rs. " + String.format("%.0f", room.getPrice() * n));
            roomTitle.setText(room.getCategory());
            roomNumber.setText("ROOM " + room.getRoomNumber());
        };

        roomBox.addActionListener(e -> updateTotal.run());
        nights.addChangeListener(e -> updateTotal.run());
        updateTotal.run();

        confirm.addActionListener(e -> {
            if (name.getText().trim().isEmpty()
                    || phone.getText().trim().isEmpty()
                    || email.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please complete all guest details.",
                        "Incomplete Details", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Room room = (Room) roomBox.getSelectedItem();
            int n = (Integer) nights.getValue();
            String method = (String) payment.getSelectedItem();

            if (room == null || !room.isAvailable()) {
                JOptionPane.showMessageDialog(this,
                        "Please select an available room.",
                        "Room Unavailable", JOptionPane.WARNING_MESSAGE);
                showBookingForm();
                return;
            }

            processPayment(room, name.getText().trim(), phone.getText().trim(),
                    email.getText().trim(), n, method);
        });

        page.add(formCard, BorderLayout.CENTER);
        page.add(summary, BorderLayout.EAST);

        // Keep a sensible width for the summary panel.
        summary.setPreferredSize(new Dimension(310, 0));

        contentPanel.add(page, BorderLayout.CENTER);
        refresh();
    }

    // ===================== PAYMENT =====================

    private void processPayment(Room room, String name, String phone,
                                String email, int nights, String method) {
        double total = room.getPrice() * nights;

        JPanel summary = new JPanel();
        summary.setBackground(PAPER);
        summary.setBorder(new EmptyBorder(20, 25, 20, 25));
        summary.setLayout(new BoxLayout(summary, BoxLayout.Y_AXIS));

        summary.add(label("✦  RESERVATION SUMMARY", GOLD, 19, Font.BOLD, "Serif"));
        summary.add(Box.createVerticalStrut(15));
        summary.add(detailLabel("Guest", name));
        summary.add(detailLabel("Room", room.getRoomNumber() + " • " + room.getCategory()));
        summary.add(detailLabel("Nights", String.valueOf(nights)));
        summary.add(detailLabel("Payment", method));
        summary.add(Box.createVerticalStrut(10));
        summary.add(label("Rs. " + String.format("%.0f", total), DARK, 27, Font.BOLD, "Serif"));

        int answer = JOptionPane.showConfirmDialog(
                this, summary, "Confirm Your Payment",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE
        );

        if (answer == JOptionPane.YES_OPTION) {
            Reservation reservation = hotel.bookRoom(
                    room, name, phone, email, nights, method
            );

            if (reservation != null) {
                showConfirmation(reservation);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Sorry, this room is no longer available.",
                        "Booking Failed", JOptionPane.ERROR_MESSAGE);
                showRooms();
            }
        }
    }

    private JLabel detailLabel(String label, String value) {
        JLabel l = new JLabel(label + "     " + value);
        l.setForeground(TEXT);
        l.setFont(new Font("SansSerif", Font.PLAIN, 11));
        l.setBorder(new EmptyBorder(3, 0, 3, 0));
        return l;
    }

    // ===================== CONFIRMATION =====================

    private void showConfirmation(Reservation reservation) {
        contentPanel.removeAll();

        JPanel background = new JPanel(new GridBagLayout());
        background.setBackground(BG);

        JPanel ticket = new JPanel();
        ticket.setBackground(CARD);
        ticket.setBorder(new CompoundBorder(
                new LineBorder(GOLD, 1),
                new EmptyBorder(30, 45, 30, 45)
        ));
        ticket.setLayout(new BoxLayout(ticket, BoxLayout.Y_AXIS));

        JLabel symbol = label("✦", GOLD, 40, Font.PLAIN, "Serif");
        JLabel title = label("Your stay is confirmed.", DARK, 28, Font.BOLD, "Serif");
        JLabel id = label(reservation.getReservationId(), GOLD, 9, Font.BOLD, "SansSerif");

        symbol.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        id.setAlignmentX(Component.CENTER_ALIGNMENT);

        ticket.add(symbol);
        ticket.add(Box.createVerticalStrut(4));
        ticket.add(title);
        ticket.add(Box.createVerticalStrut(5));
        ticket.add(id);
        ticket.add(Box.createVerticalStrut(20));

        addConfirmationLine(ticket, "GUEST", reservation.getCustomer().getName());
        addConfirmationLine(ticket, "ROOM",
                reservation.getRoom().getCategory() + " • " + reservation.getRoom().getRoomNumber());
        addConfirmationLine(ticket, "NIGHTS", String.valueOf(reservation.getNights()));
        addConfirmationLine(ticket, "PAYMENT", reservation.getPaymentMethod());
        addConfirmationLine(ticket, "TOTAL",
                "Rs. " + String.format("%.0f", reservation.getTotalAmount()));

        ticket.add(Box.createVerticalStrut(18));

        JButton view = primaryButton("VIEW MY RESERVATIONS");
        view.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.addActionListener(e -> showReservations());
        ticket.add(view);

        background.add(ticket);
        contentPanel.add(background, BorderLayout.CENTER);
        refresh();
    }

    private void addConfirmationLine(JPanel panel, String label, String value) {
        JLabel line = new JLabel(label + "     " + value);
        line.setForeground(TEXT);
        line.setFont(new Font("SansSerif", Font.PLAIN, 10));
        line.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(line);
        panel.add(Box.createVerticalStrut(5));
    }

    // ===================== RESERVATIONS =====================

    private void showReservations() {
        contentPanel.removeAll();

        JPanel page = new JPanel(new BorderLayout(0, 18));
        page.setBackground(BG);

        JPanel heading = new JPanel();
        heading.setOpaque(false);
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.add(label("YOUR AURELIA JOURNEY", GOLD, 8, Font.BOLD, "SansSerif"));
        heading.add(Box.createVerticalStrut(4));
        heading.add(label("My reservations.", TEXT, 31, Font.BOLD, "Serif"));
        page.add(heading, BorderLayout.NORTH);

        JPanel listPanel = new JPanel();
        listPanel.setBackground(BG);
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        List<Reservation> reservations = hotel.getReservations();

        if (reservations.isEmpty()) {
            JLabel empty = label("<html><center>No reservations yet.<br>" +
                    "<i>Your next beautiful stay is waiting.</i></center></html>",
                    MUTED, 17, Font.PLAIN, "Serif");
            empty.setAlignmentX(Component.CENTER_ALIGNMENT);
            listPanel.add(Box.createVerticalStrut(50));
            listPanel.add(empty);
        } else {
            for (Reservation r : reservations) {
                listPanel.add(reservationCard(r));
                listPanel.add(Box.createVerticalStrut(10));
            }
        }

        JScrollPane scroll = new JScrollPane(listPanel);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(15);

        page.add(scroll, BorderLayout.CENTER);
        contentPanel.add(page, BorderLayout.CENTER);
        refresh();
    }

    private JPanel reservationCard(Reservation r) {
        JPanel card = new JPanel(new BorderLayout(20, 0));
        card.setBackground(CARD);
        card.setBorder(new CompoundBorder(new LineBorder(BORDER),
                new EmptyBorder(18, 20, 18, 20)));

        JPanel info = new JPanel();
        info.setOpaque(false);
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));

        info.add(label(r.getReservationId(), GOLD, 8, Font.BOLD, "SansSerif"));
        info.add(Box.createVerticalStrut(4));
        info.add(label(r.getCustomer().getName(), DARK, 21, Font.BOLD, "Serif"));
        info.add(label("Room " + r.getRoom().getRoomNumber() + "  •  " +
                r.getRoom().getCategory(), MUTED, 9, Font.PLAIN, "SansSerif"));
        info.add(Box.createVerticalStrut(3));
        info.add(label("Booked " + r.getBookingDate(), new Color(160, 149, 137),
                8, Font.PLAIN, "SansSerif"));

        JPanel right = new JPanel();
        right.setOpaque(false);
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));

        right.add(label("Rs. " + String.format("%.0f", r.getTotalAmount()),
                GOLD, 21, Font.BOLD, "Serif"));

        JLabel paid = label("● " + r.getPaymentStatus().toUpperCase(),
                GREEN, 8, Font.BOLD, "SansSerif");
        right.add(paid);
        right.add(Box.createVerticalStrut(8));

        JButton details = secondaryButton("VIEW DETAILS");
        details.addActionListener(e -> showReservationDetails(r));
        right.add(details);

        card.add(info, BorderLayout.CENTER);
        card.add(right, BorderLayout.EAST);
        return card;
    }

    private void showReservationDetails(Reservation r) {
        JTextArea area = new JTextArea(r.getDetails());
        area.setEditable(false);
        area.setBackground(PAPER);
        area.setForeground(TEXT);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12));
        area.setBorder(new EmptyBorder(18, 20, 18, 20));

        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(540, 390));

        JOptionPane.showMessageDialog(this, scroll,
                "Reservation Details", JOptionPane.PLAIN_MESSAGE);
    }

    // ===================== CANCEL =====================

    private void showCancel() {
        contentPanel.removeAll();

        JPanel page = new JPanel(new GridBagLayout());
        page.setBackground(BG);

        JPanel card = new JPanel();
        card.setBackground(CARD);
        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(224, 198, 190)),
                new EmptyBorder(35, 45, 35, 45)
        ));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel symbol = label("×", ROSE, 42, Font.BOLD, "Serif");
        JLabel title = label("Cancel a reservation.", TEXT, 28, Font.BOLD, "Serif");
        JLabel subtitle = label("Enter the reservation ID from your confirmation.",
                MUTED, 10, Font.PLAIN, "SansSerif");

        symbol.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField id = inputField("e.g. RES-0001");
        id.setMaximumSize(new Dimension(380, 38));

        JButton cancel = dangerButton("CANCEL RESERVATION");
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(symbol);
        card.add(Box.createVerticalStrut(5));
        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(20));
        card.add(id);
        card.add(Box.createVerticalStrut(13));
        card.add(cancel);

        cancel.addActionListener(e -> {
            String reservationId = id.getText().trim();

            if (reservationId.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a reservation ID.",
                        "Missing ID", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Reservation r = hotel.findReservation(reservationId);

            if (r == null) {
                JOptionPane.showMessageDialog(this,
                        "No reservation was found with that ID.",
                        "Reservation Not Found", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int answer = JOptionPane.showConfirmDialog(this,
                    "Cancel this reservation?\n\nGuest: " +
                            r.getCustomer().getName() +
                            "\nRoom: " + r.getRoom().getRoomNumber(),
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION &&
                    hotel.cancelReservation(reservationId)) {

                JOptionPane.showMessageDialog(this,
                        "Your reservation has been cancelled.",
                        "Cancellation Complete",
                        JOptionPane.INFORMATION_MESSAGE);
                showHome();
            }
        });

        page.add(card);
        contentPanel.add(page, BorderLayout.CENTER);
        refresh();
    }

    // ===================== COMPONENT STYLING =====================

    private JLabel label(String text, Color color, int size,
                         int style, String fontName) {
        JLabel l = new JLabel(text);
        l.setForeground(color);
        l.setFont(new Font(fontName, style, size));
        return l;
    }

    private JTextField inputField(String placeholder) {
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(0, 38));
        field.setBackground(PAPER);
        field.setForeground(TEXT);
        field.setFont(new Font("SansSerif", Font.PLAIN, 11));
        field.setBorder(new CompoundBorder(
                new LineBorder(BORDER),
                new EmptyBorder(5, 11, 5, 11)
        ));
        field.setToolTipText(placeholder);

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                field.setBorder(new CompoundBorder(
                        new LineBorder(GOLD, 1),
                        new EmptyBorder(5, 11, 5, 11)
                ));
            }
            @Override
            public void focusLost(FocusEvent e) {
                field.setBorder(new CompoundBorder(
                        new LineBorder(BORDER),
                        new EmptyBorder(5, 11, 5, 11)
                ));
            }
        });

        return field;
    }

    private void styleCombo(JComboBox<?> combo) {
        combo.setBackground(PAPER);
        combo.setForeground(TEXT);
        combo.setFont(new Font("SansSerif", Font.PLAIN, 10));
        combo.setPreferredSize(new Dimension(0, 38));
        combo.setBorder(new LineBorder(BORDER));
    }

    private void addField(JPanel panel, GridBagConstraints g, int row,
                          String labelText, JComponent component) {
        JLabel l = label(labelText, MUTED, 8, Font.BOLD, "SansSerif");

        g.gridy = row * 2;
        panel.add(l, g);

        g.gridy = row * 2 + 1;
        panel.add(component, g);
    }

    private JButton primaryButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(GREEN);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 8));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(new EmptyBorder(11, 17, 11, 17));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(DARK);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(GREEN);
            }
        });

        return button;
    }

    private JButton secondaryButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(GREEN_BG);
        button.setForeground(GREEN);
        button.setFont(new Font("SansSerif", Font.BOLD, 8));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(new EmptyBorder(9, 13, 9, 13));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(207, 222, 210));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(GREEN_BG);
            }
        });

        return button;
    }

    private JButton dangerButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(ROSE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 8));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBorder(new EmptyBorder(11, 17, 11, 17));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(178, 132, 127));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(ROSE);
            }
        });

        return button;
    }

    private JButton textButton(String text) {
        JButton button = new JButton(text);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(GREEN);
        button.setFont(new Font("SansSerif", Font.BOLD, 8));
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void refresh() {
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}

import java.sql.*;

public class BookingInsertion {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database"; // Change this
        String dbUser = "your_username"; // Change this
        String dbPassword = "your_password"; // Change this

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
                String sql = "INSERT INTO bookings (id, type, customerName, details, status) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql)) {

                    stmt.setInt(1, 1);
                    stmt.setString(2, "Flight");
                    stmt.setString(3, "Alice");
                    stmt.setString(4, "Flight No: AI101");
                    stmt.setString(5, "Confirmed");
                    stmt.executeUpdate();

                    stmt.setInt(1, 2);
                    stmt.setString(2, "Hotel");
                    stmt.setString(3, "Bob");
                    stmt.setString(4, "Hotel: Taj Palace");
                    stmt.setString(5, "Pending");
                    stmt.executeUpdate();

                    stmt.setInt(1, 3);
                    stmt.setString(2, "Cab");
                    stmt.setString(3, "Charlie");
                    stmt.setString(4, "Cab No: KA01AB1234");
                    stmt.setString(5, "Confirmed");
                    stmt.executeUpdate();

                    System.out.println("3 bookings inserted successfully.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "system";
        String password = "oracle123";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Bağlantı başarılı!");

            String sql = "INSERT INTO BOOK (ID, NAME, ISBN) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            for (int i = 1; i <= 100; i++) {
                String name = "Book_" + UUID.randomUUID().toString().substring(0, 8);
                String isbn = "ISBN-" + new Random().nextInt(999999);

                stmt.setInt(1, i);
                stmt.setString(2, name);
                stmt.setString(3, isbn);
                stmt.addBatch(); // toplu çalıştırma için
            }

            stmt.executeBatch();

            System.out.println("100 kayıt başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.*;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class DemoClass {

    // Load environment variables from .env file
    private static final Dotenv dotenv = Dotenv.load();

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/anime_db";
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public static void main(String[] args) {
        DemoClass demo = new DemoClass();
        Scanner scanner = new Scanner(System.in);

        try {
            // Test database connection
            if (demo.testConnection()) {
                System.out.println("✅ Successfully connected to anime_db database!");

                // Display menu
                while (true) {
                    System.out.println("\n=== Anime Database Management ===");
                    System.out.println("1. View all anime");
                    System.out.println("2. Add new anime");
                    System.out.println("3. Update anime");
                    System.out.println("4. Delete anime");
                    System.out.println("5. Search anime");
                    System.out.println("6. Exit");
                    System.out.print("Choose an option (1-6): ");

                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1 -> demo.viewAllAnime();
                        case 2 -> demo.addAnime(scanner);
                        case 3 -> demo.updateAnime(scanner);
                        case 4 -> demo.deleteAnime(scanner);
                        case 5 -> demo.searchAnime(scanner);
                        case 6 -> {
                            System.out.println("Goodbye!");
                            return;
                        }
                        default -> System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("❌ Failed to connect to database!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    /**
     * Test database connection
     */
    public boolean testConnection() {
        System.out.println("🔍 Diagnosing connection issues...");
        System.out.println("URL: " + DB_URL);
        System.out.println("User: " + DB_USER);
        System.out.println("Password: " + (DB_PASSWORD == null || DB_PASSWORD.isEmpty() ? "[EMPTY]" : "[SET]"));

        try {
            // Check MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL driver found");

            // Attempt connection
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("✅ Connection successful!");
            System.out.println("Database: " + conn.getCatalog());
            conn.close();
            return true;

        } catch (ClassNotFoundException e) {
            System.err.println("❌ MySQL driver not found!");
            return false;
        } catch (SQLException e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
            return false;
        }
    }

    /** View all anime */
    public void viewAllAnime() {
        String sql = "SELECT * FROM anime";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("\n=== All Anime Records ===");
            System.out.printf("%-5s %-30s %-20s %-10s %-15s%n", "ID", "Title", "Genre", "Episodes", "Status");
            System.out.println("-".repeat(80));

            while (rs.next()) {
                System.out.printf("%-5d %-30s %-20s %-10d %-15s%n",
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("episodes"),
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Error viewing anime: " + e.getMessage());
        }
    }

    /** Add new anime */
    public void addAnime(Scanner scanner) {
        System.out.print("Enter anime title: ");
        String title = scanner.nextLine();

        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter number of episodes: ");
        int episodes = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter status (Ongoing/Completed/Dropped): ");
        String status = scanner.nextLine();

        String sql = "INSERT INTO anime (title, genre, episodes, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, genre);
            stmt.setInt(3, episodes);
            stmt.setString(4, status);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Anime added successfully!" : "❌ Failed to add anime.");

        } catch (SQLException e) {
            System.err.println("Error adding anime: " + e.getMessage());
        }
    }

    /** Update anime */
    public void updateAnime(Scanner scanner) {
        System.out.print("Enter anime ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();

        System.out.print("Enter new genre: ");
        String genre = scanner.nextLine();

        System.out.print("Enter new number of episodes: ");
        int episodes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new status: ");
        String status = scanner.nextLine();

        String sql = "UPDATE anime SET title = ?, genre = ?, episodes = ?, status = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);
            stmt.setString(2, genre);
            stmt.setInt(3, episodes);
            stmt.setString(4, status);
            stmt.setInt(5, id);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Anime updated successfully!" : "❌ No anime found with ID: " + id);

        } catch (SQLException e) {
            System.err.println("Error updating anime: " + e.getMessage());
        }
    }

    /** Delete anime */
    public void deleteAnime(Scanner scanner) {
        System.out.print("Enter anime ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM anime WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "✅ Anime deleted successfully!" : "❌ No anime found with ID: " + id);

        } catch (SQLException e) {
            System.err.println("Error deleting anime: " + e.getMessage());
        }
    }

    /** Search anime */
    public void searchAnime(Scanner scanner) {
        System.out.print("Enter search term (title or genre): ");
        String searchTerm = scanner.nextLine();

        String sql = "SELECT * FROM anime WHERE title LIKE ? OR genre LIKE ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String searchPattern = "%" + searchTerm + "%";
            stmt.setString(1, searchPattern);
            stmt.setString(2, searchPattern);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n=== Search Results ===");
                System.out.printf("%-5s %-30s %-20s %-10s %-15s%n", "ID", "Title", "Genre", "Episodes", "Status");
                System.out.println("-".repeat(80));

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    System.out.printf("%-5d %-30s %-20s %-10d %-15s%n",
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("genre"),
                            rs.getInt("episodes"),
                            rs.getString("status"));
                }

                if (!found) System.out.println("No anime found matching: " + searchTerm);
            }

        } catch (SQLException e) {
            System.err.println("Error searching anime: " + e.getMessage());
        }
    }
}

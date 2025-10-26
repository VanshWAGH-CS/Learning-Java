import java.sql.*;

public class JDBCSetup {
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root"; // your MySQL username
    static final String PASSWORD = "Your_password"; // replace with your MySQL password
    static final String DB_NAME = "sampledb";

    public static void main(String[] args) {
        try {
            // 1️⃣ Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL JDBC Driver loaded.");

            // 2️⃣ Connect to MySQL (no DB selected yet)
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            System.out.println("✅ Connected to MySQL.");

            // 3️⃣ Create database if not exists
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println("✅ Database created or already exists: " + DB_NAME);
            stmt.close();
            conn.close();

            // 4️⃣ Connect to the new database
            conn = DriverManager.getConnection(JDBC_URL + DB_NAME, USER, PASSWORD);
            stmt = conn.createStatement();

            // 5️⃣ Create table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS students (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(50),
                    age INT
                )
            """);
            System.out.println("✅ Table 'students' created.");

            // 6️⃣ Insert data
            stmt.executeUpdate("""
                INSERT INTO students (name, age)
                VALUES ('Vansh', 21), ('Aditi', 20), ('Rohan', 22)
            """);
            System.out.println("✅ Sample data inserted.");

            // 7️⃣ Retrieve and print data
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("\n🎓 Student Records:");
            System.out.println("---------------------");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Age: " + rs.getInt("age"));
            }

            // 8️⃣ Close connections
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n✅ Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

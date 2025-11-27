package murach.sql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DB_URL =
            "jdbc:postgresql://dpg-d4jtr1chg0os73abi7r0-a.oregon-postgres.render.com:5432/ch_12";
    private static final String DB_USER = "ch_12_user";
    private static final String DB_PASSWORD = "wPNeFDYqvB3eRK6Y6xXYoVT7hmFZtT1K";

    static {
        try {
            // Load PostgreSQL driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Hoặc log ra file log
        }
    }

    // Lấy connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    
    // Hàm đóng Statement
    public static void closeStatement(Statement s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Hàm đóng PreparedStatement
    public static void closePreparedStatement(Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    // Hàm đóng ResultSet
    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}

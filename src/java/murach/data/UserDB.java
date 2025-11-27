package murach.data;

import java.sql.*;
import murach.business.User;
import murach.sql.DBUtil;

public class UserDB {

    // --- 1. INSERT ---
    public static int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        // KIỂM TRA KẾT NỐI
        if (connection == null) {
            System.out.println("LỖI INSERT: Không có kết nối Database (connection is null).");
            return 0; 
        }

        // Sửa tên bảng thành "Users"
        String query = "INSERT INTO users (Email, FirstName, LastName) VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    // --- 2. UPDATE ---
    public static int update(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        // KIỂM TRA KẾT NỐI (Thêm mới)
        if (connection == null) {
            System.out.println("LỖI UPDATE: Không có kết nối Database.");
            return 0;
        }

        // Sửa tên bảng thành "Users"
        String query = "UPDATE \"users\" SET "
                     + "FirstName = ?, "
                     + "LastName = ? "
                     + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    // --- 3. DELETE ---
    public static int delete(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        // KIỂM TRA KẾT NỐI (Thêm mới)
        if (connection == null) {
            System.out.println("LỖI DELETE: Không có kết nối Database.");
            return 0;
        }

        // Sửa tên bảng thành "Users"
        String query = "DELETE FROM \"users\" "
                     + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    // --- 4. CHECK EMAIL ---
    public static boolean emailExists(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        // KIỂM TRA KẾT NỐI (Thêm mới)
        if (connection == null) {
            System.out.println("LỖI CHECK EMAIL: Không có kết nối Database.");
            return false;
        }

        // Sửa tên bảng thành "Users"
        String query = "SELECT Email FROM users WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    // --- 5. SELECT USER ---
    public static User selectUser(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        // KIỂM TRA KẾT NỐI (Thêm mới)
        if (connection == null) {
            System.out.println("LỖI SELECT: Không có kết nối Database.");
            return null;
        }

        // Sửa tên bảng thành "Users"
        String query = "SELECT * FROM \"users\" "
                     + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
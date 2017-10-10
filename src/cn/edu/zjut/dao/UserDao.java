package cn.edu.zjut.dao;

import cn.edu.zjut.model.UserBean;

import java.sql.*;

/**
 * Created by a on 2017/10/10.
 */
public class UserDao {
    private static final String GET_ONE_SQL
            = "SELECT * FROM usertable WHERE username=? AND password=?";

    public UserDao() {
    }

    public Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/yztdb";
        String username = "root";
        String password = "youshang1021";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean searchUser(UserBean user) {
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(GET_ONE_SQL)){
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

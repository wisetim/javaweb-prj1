package cn.edu.zjut.dao;

import cn.edu.zjut.model.UserBean;

import java.sql.*;

/**
 * Created by a on 2017/10/10.
 */
public class UserDao {
    //一系列字符串常量，保存SQL语句
    private static final String GET_ONE_SQL
            = "SELECT * FROM usertable WHERE username=? AND password=? AND type=?";
    private static final String SELECT_USER_BY_NAME
            = "SELECT * FROM usertable WHERE username=?";
    private static final String INSERT_USER
            = "INSERT INTO usertable VALUE(?,?,?)";

    public UserDao() {
    }

    //一般的JDBC连接
    private Connection getConnection() {
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String dburl = "jdbc:mysql://localhost:3306/mydb";
        String username = "wisetim";
        String password = "wisetim1021";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(dburl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean searchUser(UserBean user) {
        int type = user.getType().equals("admin") ? 1 : 2;
        //采用try-with-resource语法，自动释放对象
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(GET_ONE_SQL)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, type);
            ResultSet rs = pstmt.executeQuery();
            //若user的信息与数据库中的数据匹配则返回true
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean exist(UserBean user) {
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(SELECT_USER_BY_NAME)) {
            pstmt.setString(1, user.getUsername());
            ResultSet rs = pstmt.executeQuery();
            //判断账号是否已经存在，若存在则返回true
            if (rs.next()) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insert(UserBean user) {
        int type = user.getType().equals("admin") ? 1 : 2;
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(INSERT_USER)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, type);
            //向数据库中插入一条User数据
            //若executeUpdate()的结果不为0，说明插入成功
            if (pstmt.executeUpdate() != 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД


    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1234";
        String connectionURL = "jdbc:mysql://localhost:3306/lessons";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(connectionURL, userName, password);

    }


}

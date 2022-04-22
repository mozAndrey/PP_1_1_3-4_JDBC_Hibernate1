package jm.task.core.jdbc.util;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private String userName = "root";
    private String password = "1234";
    private String connectionURL = "jdbc:mysql://localhost:3306/lessons";

    public Statement getStatement () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionURL, userName, password);
        Statement statement = connection.createStatement();
        return statement;

    }
}

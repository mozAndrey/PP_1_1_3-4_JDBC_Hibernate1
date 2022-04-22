package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("John","Sina", (byte) 26);
        userDaoJDBC.saveUser("Jackie","Chan", (byte) 27);
        userDaoJDBC.saveUser("Andrey","Mozal", (byte) 36);
        userDaoJDBC.saveUser("Jack","Salt", (byte) 45);
        List<User> list = userDaoJDBC.getAllUsers();
        list.forEach(System.out::println);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}

